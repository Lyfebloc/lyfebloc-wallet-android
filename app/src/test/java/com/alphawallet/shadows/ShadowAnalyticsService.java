package com.lyfebloc.shadows;

import android.content.Context;

import com.lyfebloc.app.service.AnalyticsService;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(AnalyticsService.class)
public class ShadowAnalyticsService
{
    @Implementation
    public void __constructor__(Context context) {
    }

    @Implementation
    public void identify(String uuid) {
    }
}
