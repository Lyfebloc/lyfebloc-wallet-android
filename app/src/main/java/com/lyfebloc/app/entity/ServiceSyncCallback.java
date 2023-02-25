package com.lyfebloc.app.entity;

import com.lyfebloc.app.service.TokensService;

/**
 * Created by Lyfebloc on 2/12/2021.
 */
public interface ServiceSyncCallback
{
    void syncComplete(TokensService svs, int syncCount);
}
