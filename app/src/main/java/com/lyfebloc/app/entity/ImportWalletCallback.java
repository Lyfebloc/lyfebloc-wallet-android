package com.lyfebloc.app.entity;
import com.lyfebloc.app.entity.cryptokeys.KeyEncodingType;
import com.lyfebloc.app.service.KeyService;

public interface ImportWalletCallback
{
    void walletValidated(String address, KeyEncodingType type, KeyService.AuthenticationLevel level);
}
