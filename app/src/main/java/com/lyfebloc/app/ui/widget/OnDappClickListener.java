package com.lyfebloc.app.ui.widget;

import java.io.Serializable;

import com.lyfebloc.app.entity.DApp;

public interface OnDappClickListener extends Serializable {
    void onDappClick(DApp dapp);
}
