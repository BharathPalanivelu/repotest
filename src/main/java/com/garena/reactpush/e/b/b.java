package com.garena.reactpush.e.b;

import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.data.ReactBundle;
import java.io.File;
import okhttp3.Call;

public interface b {
    void a(ReactBundle reactBundle, ReactBundle reactBundle2, File file);

    void a(ReactBundle reactBundle, File file);

    void a(ReactBundle reactBundle, String str, ReactAsset reactAsset, ReactAsset reactAsset2, File file);

    void a(ReactBundle reactBundle, String str, ReactAsset reactAsset, File file);

    void a(Call call, Exception exc);

    void a(boolean z);
}
