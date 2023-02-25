package com.lyfebloc.shadows;

import com.lyfebloc.app.repository.EthereumNetworkBase;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(EthereumNetworkBase.class)
public class ShadowEthereumNetworkBase
{
    @Implementation
    public static String getKlaytnKey()
    {
        return "klaytn-key";
    }

    @Implementation
    public static String getInfuraKey()
    {
        return "infura-key";
    }
}
