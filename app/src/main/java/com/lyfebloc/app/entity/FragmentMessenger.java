package com.lyfebloc.app.entity;

/**
 * Created by Lyfebloc on 1/02/2019.
 * Lyfebloc
 */
public interface FragmentMessenger
{
    void tokenScriptError(String message);

    void playStoreUpdateReady(int versionUpdate);

    void externalUpdateReady(String version);
}
