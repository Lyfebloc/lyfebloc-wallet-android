package com.lyfebloc.shadows;


import com.lyfebloc.app.di.mock.KeyProviderMockNonProductionImpl;
import com.lyfebloc.app.repository.KeyProvider;
import com.lyfebloc.app.repository.KeyProviderFactory;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(KeyProviderFactory.class)
public class ShadowKeyProviderFactoryNonProduction
{
    @Implementation
    public static KeyProvider get() {
        return new KeyProviderMockNonProductionImpl();
    }
}
