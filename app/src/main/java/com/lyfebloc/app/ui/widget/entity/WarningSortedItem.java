package com.lyfebloc.app.ui.widget.entity;

import com.lyfebloc.app.ui.widget.holder.WarningHolder;

/**
 * Created by Lyfebloc on 18/07/2019.
 * Lyfebloc
 */
public class WarningSortedItem extends SortedItem<WarningData> {

    public WarningSortedItem(WarningData value, int weight) {
        super(WarningHolder.VIEW_TYPE, value, new TokenPosition(weight));
    }

    @Override
    public boolean areContentsTheSame(SortedItem newItem)
    {
        return false;
    }

    @Override
    public boolean areItemsTheSame(SortedItem other)
    {
        return other.viewType == viewType;
    }
}
