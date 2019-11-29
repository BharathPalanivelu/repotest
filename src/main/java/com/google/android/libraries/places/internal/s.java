package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.places.internal.az;

public abstract class s<TypeT, ResponseT extends az> {
    public abstract ResponseT convert() throws ApiException;
}
