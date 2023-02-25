package com.lyfebloc.app.entity;

import com.lyfebloc.hardware.SignatureFromKey;

/**
 * Created by Lyfebloc on 21/07/2019.
 * Lyfebloc
 */
public interface SignAuthenticationCallback
{
    void gotAuthorisation(boolean gotAuth);

    default void createdKey(String keyAddress)
    {
    }

    void cancelAuthentication();

    void gotSignature(SignatureFromKey signature);

    default void signingError(String error)
    {
    } //Handle signing error from hardware card
}
