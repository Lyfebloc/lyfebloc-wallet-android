package com.lyfebloc.app.entity;

import java.math.BigDecimal;

/**
 * Created by Lyfebloc on 23/02/2019.
 * Lyfebloc
 */
public class EthTypeParam
{
    public String type;
    public String value;

    public EthTypeParam(String t, String v)
    {
        type = t;
        value = v;

        if (t.contains("uint"))
        {
            //v is in exp form
            try
            {
                String convStr = String.valueOf(Double.parseDouble(v));
                BigDecimal bi = new BigDecimal(convStr);
                value = bi.toPlainString();
            }
            catch (NumberFormatException e)
            {
                //do nothing
            }
        }
    }
}
