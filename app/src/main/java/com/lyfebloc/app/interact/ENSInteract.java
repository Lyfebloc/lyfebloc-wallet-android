package com.lyfebloc.app.interact;

import com.lyfebloc.app.repository.TokenRepositoryType;
import com.lyfebloc.app.ui.widget.entity.ENSHandler;
import com.lyfebloc.token.tools.Numeric;

import java.math.BigInteger;

import io.reactivex.Single;

/**
 * Created by Lyfebloc on 4/12/2018.
 * Lyfebloc
 */
public class ENSInteract
{
    private final TokenRepositoryType tokenRepository;

    public ENSInteract(TokenRepositoryType tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Single<String> checkENSAddress(long chainId, String name)
    {
        if (!ENSHandler.canBeENSName(name)) return Single.fromCallable(() -> "0");
        return tokenRepository.resolveENS(chainId, name)
                .map(this::checkAddress);
    }

    private String checkAddress(String returnedAddress)
    {
        BigInteger test = Numeric.toBigInt(returnedAddress);
        if (!test.equals(BigInteger.ZERO))
        {
            return returnedAddress;
        }
        else
        {
            return "0";
        }
    }
}
