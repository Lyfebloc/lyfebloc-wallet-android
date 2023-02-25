package com.lyfebloc.app.service;

import com.lyfebloc.app.entity.QueryResponse;

import java.io.IOException;

/**
 * Created by Lyfebloc on 4/11/2022.
 */
public interface IPFSServiceType
{
    String getContent(String url);
    QueryResponse performIO(String url, String[] headers) throws IOException;
}
