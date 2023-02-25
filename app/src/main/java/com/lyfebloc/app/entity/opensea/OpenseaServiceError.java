package com.lyfebloc.app.entity.opensea;

import com.lyfebloc.app.entity.ErrorEnvelope;

/**
 * Created by Lyfebloc on 20/12/2018.
 * Lyfebloc
 */

public class OpenseaServiceError extends Exception {
    public final ErrorEnvelope error;

    public OpenseaServiceError(String message) {
        super(message);

        error = new ErrorEnvelope(message);
    }
}
