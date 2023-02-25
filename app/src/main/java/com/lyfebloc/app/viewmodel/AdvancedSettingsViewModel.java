package com.lyfebloc.app.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;

import com.lyfebloc.app.entity.CurrencyItem;
import com.lyfebloc.app.entity.LocaleItem;
import com.lyfebloc.app.repository.CurrencyRepositoryType;
import com.lyfebloc.app.repository.LocaleRepositoryType;
import com.lyfebloc.app.repository.PreferenceRepositoryType;
import com.lyfebloc.app.service.AssetDefinitionService;
import com.lyfebloc.app.service.TokensService;
import com.lyfebloc.app.service.TransactionsService;
import com.lyfebloc.app.ui.HomeActivity;
import com.lyfebloc.app.util.LocaleUtils;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Single;
import io.realm.Realm;

@HiltViewModel
public class AdvancedSettingsViewModel extends BaseViewModel {
    private final AssetDefinitionService assetDefinitionService;
    private final PreferenceRepositoryType preferenceRepository;
    private final TransactionsService transactionsService;

    @Inject
    AdvancedSettingsViewModel(
            AssetDefinitionService assetDefinitionService,
            PreferenceRepositoryType preferenceRepository,
            TransactionsService transactionsService) {
        this.assetDefinitionService = assetDefinitionService;
        this.preferenceRepository = preferenceRepository;
        this.transactionsService = transactionsService;
    }

    public boolean createDirectory() {
        //create XML repository directory
        File directory = new File(
                Environment.getExternalStorageDirectory()
                        + File.separator + HomeViewModel.ALPHAWALLET_DIR);

        if (!directory.exists()) {
            return directory.mkdir();
        }
        else
        {
            return directory.exists();
        }
    }

    public void startFileListeners()
    {
        assetDefinitionService.startLyfeblocListener();
    }

    public void setFullScreenState(boolean state)
    {
        preferenceRepository.setFullScreenState(state);
    }

    public void toggle1559Transactions(boolean toggleState)
    {
        preferenceRepository.setUse1559Transactions(toggleState);
    }

    public boolean get1559TransactionsState()
    {
        return preferenceRepository.getUse1559Transactions();
    }

    public boolean getFullScreenState()
    {
        return preferenceRepository.getFullScreenState();
    }

    public void blankFilterSettings()
    {
        preferenceRepository.blankHasSetNetworkFilters();
    }

    public Single<Boolean> resetTokenData()
    {
        return transactionsService.wipeDataForWallet();
    }

    public void stopChainActivity()
    {
        transactionsService.stopActivity();
    }
}
