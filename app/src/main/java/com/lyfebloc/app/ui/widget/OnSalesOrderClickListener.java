package com.lyfebloc.app.ui.widget;

import android.view.View;

import com.lyfebloc.token.entity.MagicLinkData;

/**
 * Created by Lyfebloc on 21/02/2018.
 */

public interface OnSalesOrderClickListener {
    void onOrderClick (View view, MagicLinkData range);
}
