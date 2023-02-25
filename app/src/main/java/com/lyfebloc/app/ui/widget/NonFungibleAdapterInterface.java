package com.lyfebloc.app.ui.widget;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Lyfebloc on 17/08/2021.
 */
public interface NonFungibleAdapterInterface
{
    List<BigInteger> getSelectedTokenIds(List<BigInteger> selection);
    int getSelectedGroups();
    void setRadioButtons(boolean selected);
}
