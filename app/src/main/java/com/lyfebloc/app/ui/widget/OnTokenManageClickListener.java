package com.lyfebloc.app.ui.widget;

import com.lyfebloc.app.entity.tokens.Token;

public interface OnTokenManageClickListener
{
    void onTokenClick(Token token, int position, boolean isChecked);
}
