package com.lyfebloc.app.ui.widget.entity;

/**
 * Created by Lyfebloc on 17/11/2018.
 * Lyfebloc
 */
public interface ItemClickListener
{
    void onItemClick(String url);
    default void onItemLongClick(String url) { }  //only override this if extra handling is needed
}
