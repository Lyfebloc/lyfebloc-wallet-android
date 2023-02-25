package com.lyfebloc.app.ui.widget.entity;

import com.lyfebloc.app.ui.widget.holder.TokenLabelViewHolder;
import com.lyfebloc.app.util.LocaleUtils;

import java.util.Date;

/**
 * Created by Lyfebloc on 10/08/2020.
 */
public class LabelSortedItem extends TimestampSortedItem<Date>
{
    public static final int VIEW_TYPE = 1016;

    public LabelSortedItem(Date value) {
        super(VIEW_TYPE, value, 0, DESC);
    }

    @Override
    public Date getTimestamp() {
        return value;
    }

    @Override
    public boolean areContentsTheSame(SortedItem newItem) {
        return viewType == newItem.viewType && value.equals(((TimestampSortedItem) newItem).value);
    }

    @Override
    public boolean areItemsTheSame(SortedItem other) {
        return viewType == other.viewType;
    }

    public long getUID()
    {
        return ((Date)value).getTime();
    }
}
