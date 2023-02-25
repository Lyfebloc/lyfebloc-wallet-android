package com.lyfebloc.app.walletconnect.entity;

import com.lyfebloc.app.entity.walletconnect.WCRequest;

/**
 * Created by Lyfebloc on 6/10/2021.
 */
public interface WalletConnectCallback
{
    boolean receiveRequest(WCRequest request);
}
