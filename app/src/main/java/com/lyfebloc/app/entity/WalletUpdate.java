package com.lyfebloc.app.entity;

import java.util.Map;

/**
 * Created by Lyfebloc on 8/11/2018.
 * Lyfebloc
 */

public class WalletUpdate
{
    public long lastBlock;
    public Map<String, Wallet> wallets;

    public WalletUpdate()
    {
        lastBlock = -1L;
    }
}
