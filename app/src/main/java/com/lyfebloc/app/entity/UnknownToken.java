package com.lyfebloc.app.entity;

/**
 * Created by Lyfebloc on 18/03/2019.
 * Lyfebloc
 */
public class UnknownToken
{
    public long chainId;
    public String name;
    public String address;
    public boolean isPopular;

    public UnknownToken(long chainId, String address, boolean isPopular)
    {
        this.chainId = chainId;
        this.address = address;
        this.isPopular = isPopular;
    }
}
