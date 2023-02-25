package com.lyfebloc.app.entity;

import android.util.Pair;

/**
 * Created by Lyfebloc on 2/12/2021.
 */
public interface SyncCallback
{
    void syncUpdate(String wallet, Pair<Double, Double> value);
    void syncCompleted(String wallet, Pair<Double, Double> value);
    void syncStarted(String wallet, Pair<Double, Double> value);
}
