package com.lyfebloc.app.web3;

import com.lyfebloc.app.web3.entity.Web3Call;

/**
 * Created by Lyfebloc on 19/02/2021.
 */
public interface OnEthCallListener
{
    void onEthCall(Web3Call txdata);
}
