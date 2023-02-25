package com.lyfebloc.app.repository;

import com.lyfebloc.app.entity.OnRampContract;
import com.lyfebloc.app.entity.tokens.Token;

public interface OnRampRepositoryType {
    String getUri(String address, Token token);

    OnRampContract getContract(Token token);
}
