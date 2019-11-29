package com.shopee.react.sdk.bridge.protocol;

public class StartShakeDetectionMessage {
    private final int sensitivity;

    public StartShakeDetectionMessage(int i) {
        this.sensitivity = i;
    }

    public int getSensitivity() {
        return this.sensitivity;
    }
}
