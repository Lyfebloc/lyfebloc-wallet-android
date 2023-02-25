package com.lyfebloc.app.entity;

/**
 * Created by Lyfebloc on 18/07/2019.
 * Lyfebloc
 */
public interface BackupTokenCallback
{
    default void backUpClick(Wallet wallet) { }
    default void remindMeLater(Wallet wallet) { };
}
