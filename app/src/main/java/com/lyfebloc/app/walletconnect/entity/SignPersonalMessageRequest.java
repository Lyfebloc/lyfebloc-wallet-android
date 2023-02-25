package com.lyfebloc.app.walletconnect.entity;

import com.lyfebloc.token.entity.EthereumMessage;
import com.lyfebloc.token.entity.SignMessageType;
import com.lyfebloc.token.entity.Signable;

public class SignPersonalMessageRequest extends BaseRequest
{
    public SignPersonalMessageRequest(String params)
    {
        super(params, WCEthereumSignMessage.WCSignType.PERSONAL_MESSAGE);
    }

    @Override
    public Signable getSignable()
    {
        return new EthereumMessage(getMessage(), "", 0, SignMessageType.SIGN_PERSONAL_MESSAGE);
    }

    @Override
    public Signable getSignable(long callbackId, String origin)
    {
        return new EthereumMessage(getMessage(), origin, callbackId, SignMessageType.SIGN_PERSONAL_MESSAGE);
    }

    @Override
    public String getWalletAddress()
    {
        return params.get(1);
    }
}
