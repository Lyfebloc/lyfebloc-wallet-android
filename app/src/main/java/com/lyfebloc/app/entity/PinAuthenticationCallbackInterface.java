package com.lyfebloc.app.entity;

/**
 * Created by Lyfebloc on 19/07/2019.
 * Lyfebloc
 */
public interface PinAuthenticationCallbackInterface
{
    void completeAuthentication(Operation taskCode);
    void failedAuthentication(Operation taskCode);
}
