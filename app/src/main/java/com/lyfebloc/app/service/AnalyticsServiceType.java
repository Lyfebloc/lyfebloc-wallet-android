package com.lyfebloc.app.service;

import com.lyfebloc.app.entity.ServiceErrorException;

public interface AnalyticsServiceType<T> {

    void track(String eventName);

    void track(String eventName, T event);

    void flush();

    void identify(String uuid);

    void recordException(ServiceErrorException e);
}

