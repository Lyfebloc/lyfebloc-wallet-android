package com.lyfebloc.app.entity;

import com.lyfebloc.app.web3.entity.Web3Transaction;

/**
 * Created by Lyfebloc on 26/01/2019.
 * Lyfebloc
 */
public interface SendTransactionInterface
{
    void transactionSuccess(Web3Transaction web3Tx, String hashData);
    void transactionError(long callbackId, Throwable error);
}
