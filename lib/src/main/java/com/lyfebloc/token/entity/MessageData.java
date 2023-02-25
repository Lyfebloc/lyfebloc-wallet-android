package com.lyfebloc.token.entity;

import java.math.BigInteger;

/**
 * Created by Lyfebloc on 21/03/2018.
 */

public class MessageData
{
    public BigInteger priceWei;
    public int[] tickets;
    public byte[] signature = new byte[65];
}
