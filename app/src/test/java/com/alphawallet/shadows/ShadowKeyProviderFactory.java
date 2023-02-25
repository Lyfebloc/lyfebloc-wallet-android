package com.lyfebloc.shadows;

import com.lyfebloc.app.di.mock.KeyProviderMockImpl;
import com.lyfebloc.app.repository.KeyProvider;
import com.lyfebloc.app.repository.KeyProviderFactory;
import com.lyfebloc.app.repository.KeyProviderJNIImpl;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

@Implements(KeyProviderFactory.class)
public class ShadowKeyProviderFactory
{
    @Implementation
    public static KeyProvider get() {
        return new KeyProviderMockImpl();
    }
}
