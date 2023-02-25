package com.lyfebloc.shadows;

import com.lyfebloc.app.App;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowApplication;

@Implements(App.class)
public class ShadowApp extends ShadowApplication
{
    @Implementation
    public void onCreate()
    {
    }
}
