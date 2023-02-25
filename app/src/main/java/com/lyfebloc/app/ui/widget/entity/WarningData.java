package com.lyfebloc.app.ui.widget.entity;

import com.lyfebloc.app.entity.BackupTokenCallback;
import com.lyfebloc.app.entity.Wallet;

/**
 * Created by Lyfebloc on 18/07/2019.
 * Lyfebloc
 */
public class WarningData
{
    public String title;
    public String detail;
    public String buttonText;
    public Wallet wallet;
    public int colour;
    public int buttonColour;
    public final BackupTokenCallback callback;

    public WarningData(BackupTokenCallback tCallback)
    {
        callback = tCallback;
    }
}
