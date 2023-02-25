package com.lyfebloc.app.entity;

import com.lyfebloc.app.web3.entity.Web3Transaction;

/**
 * Created by Lyfebloc on 26/01/2019.
 * Lyfebloc
 */
public class TransactionReturn
{
    public final String hash;
    public final Web3Transaction tx;
    public final Throwable throwable;

    public TransactionReturn(String hash, Web3Transaction tx)
    {
        this.hash = hash;
        this.tx = tx;
        this.throwable = null;
    }

    public TransactionReturn(Throwable throwable, Web3Transaction tx)
    {
        this.hash = null;
        this.tx = tx;
        this.throwable = throwable;
    }

    public String getDisplayData()
    {
        return hash != null ? hash.substring(0, 66) : "";
    }
}
