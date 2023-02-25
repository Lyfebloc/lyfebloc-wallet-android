package com.lyfebloc.app.web3;

import com.lyfebloc.token.entity.EthereumMessage;

public interface OnSignMessageListener {
    void onSignMessage(EthereumMessage message);
}
