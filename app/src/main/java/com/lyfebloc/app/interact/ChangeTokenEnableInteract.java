package com.lyfebloc.app.interact;

import com.lyfebloc.app.entity.Wallet;
import com.lyfebloc.app.repository.TokenRepositoryType;
import com.lyfebloc.token.entity.ContractAddress;

import io.reactivex.Completable;

public class ChangeTokenEnableInteract
{
    private final TokenRepositoryType tokenRepository;

    public ChangeTokenEnableInteract(TokenRepositoryType tokenRepository)
    {
        this.tokenRepository = tokenRepository;
    }

    public Completable setEnable(Wallet wallet, ContractAddress cAddr, boolean enabled)
    {
        tokenRepository.setEnable(wallet, cAddr, enabled);
        tokenRepository.setVisibilityChanged(wallet, cAddr);
        return Completable.fromAction(() -> {});
    }
}
