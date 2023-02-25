package com.lyfebloc.app.ui.widget.entity;

import java.math.BigInteger;

/**
 * Created by Lyfebloc on 26/11/2020.
 */
public interface GasSettingsCallback
{
    void gasSettingsUpdate(BigInteger gasPriceMax, BigInteger priorityFee, BigInteger gasLimit);
}
