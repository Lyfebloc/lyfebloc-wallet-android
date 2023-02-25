package com.lyfebloc.app.entity;

/**
 * Created by Lyfebloc on 9/06/2019.
 * Lyfebloc
 */

public interface AuthenticationCallback
{
    void authenticatePass(Operation callbackId);
    void authenticateFail(String fail, AuthenticationFailType failType, Operation callbackId);
    void legacyAuthRequired(Operation callbackId, String dialogTitle, String desc);
}

