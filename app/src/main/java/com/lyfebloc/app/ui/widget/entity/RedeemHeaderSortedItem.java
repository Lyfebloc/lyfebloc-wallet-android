package com.lyfebloc.app.ui.widget.entity;

import com.lyfebloc.app.ui.widget.holder.RedeemTicketHolder;
import com.lyfebloc.app.entity.tokens.Token;

/**
 * Created by Lyfebloc on 13/02/2018.
 */

public class RedeemHeaderSortedItem extends SortedItem<Token>
{
    public RedeemHeaderSortedItem(Token value)
    {
        super(RedeemTicketHolder.VIEW_TYPE, value, new TokenPosition(0));
    }

    @Override
    public boolean areContentsTheSame(SortedItem newItem)
    {
        return newItem.viewType == viewType
                || (((TokenBalanceSortedItem) newItem).value.getTokenCount() == value.getTokenCount())
                && ((TokenBalanceSortedItem) newItem).value.getFullName().equals(value.getFullName());
    }

    @Override
    public boolean areItemsTheSame(SortedItem other)
    {
        return other.viewType == viewType;
    }
}

