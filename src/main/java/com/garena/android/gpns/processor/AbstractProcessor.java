package com.garena.android.gpns.processor;

import com.squareup.wire.Wire;

public abstract class AbstractProcessor {
    protected static Wire mWire = new Wire((Class<?>[]) new Class[0]);

    public abstract int getCommand();

    public abstract void process(byte[] bArr, int i, int i2) throws Exception;
}
