package com.lyfebloc.app.interact;

import com.lyfebloc.app.repository.TokenRepositoryType;

import io.reactivex.Observable;

import com.lyfebloc.app.entity.TransferFromEventResponse;

/**
 * Created by Lyfebloc on 1/02/2018.
 */

public class MemPoolInteract
{
    private final TokenRepositoryType tokenRepository;

    public MemPoolInteract(TokenRepositoryType tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    //create an observable
    public Observable<TransferFromEventResponse> burnListener(String contractAddress) {
        return tokenRepository.burnListenerObservable(contractAddress);
    }
}
