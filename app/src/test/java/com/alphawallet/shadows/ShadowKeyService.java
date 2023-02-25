package com.lyfebloc.shadows;

import android.content.Context;

import com.lyfebloc.app.entity.AnalyticsProperties;
import com.lyfebloc.app.service.AnalyticsServiceType;
import com.lyfebloc.app.service.KeyService;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(KeyService.class)
public class ShadowKeyService
{
    @Implementation
    public void __constructor__(Context ctx, AnalyticsServiceType<AnalyticsProperties> analyticsService) {

    }
}
