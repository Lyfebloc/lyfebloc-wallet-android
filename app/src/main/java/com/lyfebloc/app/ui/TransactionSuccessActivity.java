package com.lyfebloc.app.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.lyfebloc.app.C;
import com.lyfebloc.app.R;
import com.lyfebloc.app.entity.StandardFunctionInterface;
import com.lyfebloc.app.viewmodel.TransactionSuccessViewModel;
import com.lyfebloc.app.widget.CopyTextView;
import com.lyfebloc.app.widget.FunctionButtonBar;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


/**
 * Created by Lyfebloc on 4/12/2020.
 */
@AndroidEntryPoint
public class TransactionSuccessActivity extends BaseActivity implements StandardFunctionInterface
{
    private String transactionHash;

    TransactionSuccessViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_success);

        transactionHash = getIntent().getStringExtra(C.EXTRA_TXHASH);
        CopyTextView hashText = findViewById(R.id.tx_hash);
        hashText.setText(transactionHash);

        viewModel = new ViewModelProvider(this)
                .get(TransactionSuccessViewModel.class);

        toolbar();

        setTitle(getString(R.string.empty));

        FunctionButtonBar functionBar = findViewById(R.id.layoutButtons);
        functionBar.setupFunctions(this, new ArrayList<>(Collections.singletonList(R.string.action_show_tx_details)));
        functionBar.revealButtons();

        viewModel.tryToShowRateAppDialog(this);
    }

    @Override
    public void handleClick(String action, int actionId)
    {
        Intent intent = new Intent();
        intent.putExtra(C.EXTRA_TXHASH, transactionHash);
        setResult(RESULT_OK, intent);
        finish();
    }
}
