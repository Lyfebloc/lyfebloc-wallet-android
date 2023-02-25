package com.lyfebloc.app.service;

import com.lyfebloc.app.entity.TransactionReturn;
import com.lyfebloc.app.web3.entity.Web3Transaction;
import com.lyfebloc.hardware.SignatureFromKey;

/**
 * Created by Lyfebloc on 2/02/2023.
 */
public interface TransactionSendHandlerInterface
{
    void transactionFinalised(TransactionReturn txData);

    void transactionError(TransactionReturn txError);

    default void transactionSigned(SignatureFromKey sigData, Web3Transaction w3Tx)
    {
    } //Not always required, only WalletConnect
}
