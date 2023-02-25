package com.lyfebloc.app.entity;

/**
 * Created by Lyfebloc on 22/07/2019.
 * Lyfebloc
 */
public enum WalletType
{
    NOT_DEFINED,
    KEYSTORE,
    HDKEY,
    WATCH,
    TEXT_MARKER, // used as a separator in wallet view
    KEYSTORE_LEGACY,  // to support keys created from old wallets
    LARGE_TITLE,
    HARDWARE,
}
