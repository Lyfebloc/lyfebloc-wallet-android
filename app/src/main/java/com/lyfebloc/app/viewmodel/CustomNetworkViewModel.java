package com.lyfebloc.app.viewmodel;

import com.lyfebloc.app.analytics.Analytics;
import com.lyfebloc.app.entity.AnalyticsProperties;
import com.lyfebloc.app.entity.NetworkInfo;
import com.lyfebloc.app.repository.EthereumNetworkRepository;
import com.lyfebloc.app.repository.EthereumNetworkRepositoryType;
import com.lyfebloc.app.service.AnalyticsServiceType;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CustomNetworkViewModel extends BaseViewModel
{
    private final EthereumNetworkRepositoryType ethereumNetworkRepository;

    @Inject
    CustomNetworkViewModel(
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            AnalyticsServiceType analyticsService)
    {
        this.ethereumNetworkRepository = ethereumNetworkRepository;
        setAnalyticsService(analyticsService);
    }

    public void saveNetwork(boolean isEditMode, String name, String rpcUrl, long chainId, String symbol, String blockExplorerUrl, String explorerApiUrl, boolean isTestnet, Long oldChainId)
    {
        this.ethereumNetworkRepository.saveCustomRPCNetwork(name, rpcUrl, chainId, symbol, blockExplorerUrl, explorerApiUrl, isTestnet, oldChainId);
        AnalyticsProperties props = new AnalyticsProperties();
        props.put(Analytics.PROPS_CUSTOM_NETWORK_NAME, name);
        props.put(Analytics.PROPS_CUSTOM_NETWORK_RPC_URL, rpcUrl);
        props.put(Analytics.PROPS_CUSTOM_NETWORK_CHAIN_ID, chainId);
        props.put(Analytics.PROPS_CUSTOM_NETWORK_SYMBOL, symbol);
        props.put(Analytics.PROPS_CUSTOM_NETWORK_IS_TESTNET, isTestnet);
        track(isEditMode? Analytics.Action.EDIT_CUSTOM_CHAIN : Analytics.Action.ADD_CUSTOM_CHAIN, props);
    }

    public NetworkInfo getNetworkInfo(long chainId)
    {
        return this.ethereumNetworkRepository.getNetworkByChain(chainId);
    }

    public boolean isTestNetwork(NetworkInfo network)
    {
        return !EthereumNetworkRepository.hasRealValue(network.chainId);
    }

    public NetworkInfo getBuiltInNetwork(long chainId)
    {
        return this.ethereumNetworkRepository.getBuiltInNetwork(chainId);
    }
}
