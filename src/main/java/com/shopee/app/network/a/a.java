package com.shopee.app.network.a;

import android.util.Pair;
import com.squareup.wire.Message;
import java.io.IOException;

public interface a<T extends Message> {
    Pair<String, T> a(byte[] bArr) throws IOException;
}
