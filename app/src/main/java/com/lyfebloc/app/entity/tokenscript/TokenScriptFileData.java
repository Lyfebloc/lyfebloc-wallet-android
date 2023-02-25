package com.lyfebloc.app.entity.tokenscript;

import com.lyfebloc.token.entity.XMLDsigDescriptor;

public class TokenScriptFileData
{
    public String hash;
    public XMLDsigDescriptor sigDescriptor;

    public TokenScriptFileData()
    {
        hash = null;
        sigDescriptor = null;
    }
}
