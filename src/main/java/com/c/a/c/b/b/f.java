package com.c.a.c.b.b;

import android.content.Context;
import com.c.a.c.b.b.d;
import java.io.File;

public final class f extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(final Context context, final String str, int i) {
        super(new d.a() {
            public File a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                String str = str;
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, i);
    }
}
