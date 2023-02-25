package com.lyfebloc.app.router;

import android.content.Context;
import android.content.Intent;

import com.lyfebloc.app.C;
import com.lyfebloc.app.ui.ImportTokenActivity;

/**
 * Created by Lyfebloc on 9/03/2018.
 */

public class ImportTokenRouter
{
    public void open(Context context, String importTxt) {
        Intent intent = new Intent(context, ImportTokenActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra(C.IMPORT_STRING, importTxt);
        context.startActivity(intent);
    }
}
