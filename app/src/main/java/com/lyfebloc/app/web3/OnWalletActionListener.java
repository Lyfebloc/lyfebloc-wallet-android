package com.lyfebloc.app.web3;

import com.lyfebloc.app.web3.entity.WalletAddEthereumChainObject;

/**
 * Created by Lyfebloc on 15/01/2022.
 */
public interface OnWalletActionListener
{
    void onRequestAccounts(long callbackId);
    void onWalletSwitchEthereumChain(long callbackId, WalletAddEthereumChainObject chainObj);
}
