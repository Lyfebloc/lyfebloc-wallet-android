package com.lyfebloc.app.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lyfebloc.app.R;
import com.lyfebloc.app.entity.BackupOperationType;
import com.lyfebloc.app.entity.BackupState;
import com.lyfebloc.app.entity.CreateWalletCallbackInterface;
import com.lyfebloc.app.entity.Operation;
import com.lyfebloc.app.entity.SignAuthenticationCallback;
import com.lyfebloc.app.entity.StandardFunctionInterface;
import com.lyfebloc.app.entity.Wallet;
import com.lyfebloc.app.entity.WalletType;
import com.lyfebloc.app.service.KeyService;
import com.lyfebloc.app.ui.QRScanning.DisplayUtils;
import com.lyfebloc.app.util.Utils;
import com.lyfebloc.app.viewmodel.BackupKeyViewModel;
import com.lyfebloc.app.widget.AWalletAlertDialog;
import com.lyfebloc.app.widget.FunctionButtonBar;
import com.lyfebloc.app.widget.LayoutCallbackListener;
import com.lyfebloc.app.widget.PasswordInputView;
import com.lyfebloc.app.widget.SignTransactionDialog;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModelProvider;

import static com.lyfebloc.app.C.Key.WALLET;
import static com.lyfebloc.app.entity.BackupState.ENTER_BACKUP_STATE_HD;
import static com.lyfebloc.app.entity.BackupState.ENTER_JSON_BACKUP;
import static com.lyfebloc.app.entity.BackupState.SHOW_SEED_PHRASE_SINGLE;
import static com.lyfebloc.app.entity.BackupState.UPGRADE_KEY_SECURITY;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ScammerWarningActivity extends BaseActivity
{
    private FunctionButtonBar functionButtonBar;
    private Wallet wallet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        lockOrientation();
        toolbar();
        wallet = getIntent().getParcelableExtra(WALLET);
        setShowSeedPhraseSplash();
    }

    @SuppressLint("SourceLockedOrientationActivity")
    private void lockOrientation()
    {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        else
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    private void setShowSeedPhraseSplash()
    {
        setContentView(R.layout.activity_show_seed);
        initViews();
        functionButtonBar.setPrimaryButtonText(R.string.show_seed_phrase);
        functionButtonBar.setPrimaryButtonClickListener(v -> {
            openBackupKeyActivity();
        });
    }

    private void openBackupKeyActivity()
    {
        Intent intent = new Intent(this, BackupKeyActivity.class);
        intent.putExtra(WALLET, wallet);
        intent.putExtra("STATE", SHOW_SEED_PHRASE_SINGLE);
        startActivity(intent);
    }

    private void initViews()
    {
        functionButtonBar = findViewById(R.id.layoutButtons);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        toolbar();
        setTitle(getString(R.string.empty));
    }
}
