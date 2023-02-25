package com.lyfebloc.token.entity;

import com.lyfebloc.token.tools.TokenDefinition;

import java.math.BigInteger;

/**
 * Created by Lyfebloc on 22/05/2019.
 * Lyfebloc
 */
public interface AttributeInterface
{
    TransactionResult getFunctionResult(ContractAddress contract, Attribute attr, BigInteger tokenId);
    TransactionResult storeAuxData(String walletAddress, TransactionResult tResult);
    boolean resolveOptimisedAttr(ContractAddress contract, Attribute attr, TransactionResult transactionResult);

    String getWalletAddr();

    default long getLastTokenUpdate(long chainId, String address) { return 0; };
    default Attribute fetchAttribute(ContractInfo origin, String attributeName) { return null; };
    default TokenScriptResult.Attribute fetchAttrResult(ContractAddress origin, Attribute attr, BigInteger tokenId) { return null; };
}
