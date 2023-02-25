package com.lyfebloc.hardware;

/**
 * Created by Lyfebloc on 1/02/2023.
 */
public interface HardwareCallback
{
    void hardwareCardError(String errorMessage);

    void signedMessageFromHardware(SignatureFromKey returnSig);

    void onCardReadStart();
}
