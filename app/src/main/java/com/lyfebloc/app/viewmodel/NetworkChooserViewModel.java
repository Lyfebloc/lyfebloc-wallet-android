package com.lyfebloc.app.viewmodel;

import android.app.Activity;
import android.content.Intent;

import com.lyfebloc.app.entity.NetworkInfo;
import com.lyfebloc.app.repository.EthereumNetworkBase;
import com.lyfebloc.app.repository.EthereumNetworkRepositoryType;
import com.lyfebloc.app.repository.PreferenceRepositoryType;
import com.lyfebloc.app.service.TokensService;
import com.lyfebloc.app.ui.NetworkToggleActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NetworkChooserViewModel extends BaseViewModel
{
    private final EthereumNetworkRepositoryType networkRepository;
    private final TokensService tokensService;
    private final PreferenceRepositoryType preferenceRepository;

    @Inject
    public NetworkChooserViewModel(EthereumNetworkRepositoryType ethereumNetworkRepositoryType,
                                   TokensService tokensService,
                                   PreferenceRepositoryType preferenceRepository)
    {
        this.networkRepository = ethereumNetworkRepositoryType;
        this.tokensService = tokensService;
        this.preferenceRepository = preferenceRepository;
    }

    public NetworkInfo[] getNetworkList()
    {
        return networkRepository.getAvailableNetworkList();
    }

    public List<Long> getFilterNetworkList()
    {
        return networkRepository.getFilterNetworkList();
    }

    public void openSelectNetworkFilters(Activity ctx, int requestCode)
    {
        Intent intent = new Intent(ctx, NetworkToggleActivity.class);
        ctx.startActivityForResult(intent, requestCode);
    }

    public NetworkInfo getNetworkByChain(long chainId)
    {
        return networkRepository.getNetworkByChain(chainId);
    }

    public boolean isMainNet(long networkId)
    {
        return EthereumNetworkBase.hasRealValue(networkId);
    }

    public long getSelectedNetwork()
    {
        NetworkInfo browserNetwork = networkRepository.getActiveBrowserNetwork();
        if (browserNetwork != null)
        {
            return browserNetwork.chainId;
        }
        else return -1;
    }

    public TokensService getTokensService()
    {
        return tokensService;
    }
}
