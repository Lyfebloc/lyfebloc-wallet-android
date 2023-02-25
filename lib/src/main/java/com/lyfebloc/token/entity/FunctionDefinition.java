package com.lyfebloc.token.entity;

import com.lyfebloc.token.tools.TokenDefinition;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lyfebloc on 10/11/2018.
 * Lyfebloc
 */

public class FunctionDefinition
{
    public ContractInfo contract;
    public String method;
    public TokenDefinition.Syntax syntax;
    public As as;
    public List<MethodArg> parameters = new ArrayList<>();

    public String result;
    public long resultTime = 0;
    public BigInteger tokenId;
    public EthereumTransaction tx;

    public int getTokenRequirement()
    {
        int count = 0;
        for (MethodArg arg : parameters)
        {
            if (arg.isTokenId()) count++;
        }

        if (count == 0) count = 1;

        return count;
    }
}
