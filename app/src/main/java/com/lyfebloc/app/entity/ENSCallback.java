package com.lyfebloc.app.entity;

/**
 * Created by Lyfebloc on 4/12/2018.
 * Lyfebloc
 */

public interface ENSCallback
{
    void ENSComplete();
    void displayCheckingDialog(boolean shouldShow);
    void ENSResolved(String address, String ens);
    void ENSName(String name);
}
