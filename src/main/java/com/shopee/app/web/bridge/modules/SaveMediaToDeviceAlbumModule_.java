package com.shopee.app.web.bridge.modules;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import org.a.a.a;
import org.a.a.b;

public final class SaveMediaToDeviceAlbumModule_ extends SaveMediaToDeviceAlbumModule {
    private Context context_;

    private void init_() {
    }

    private SaveMediaToDeviceAlbumModule_(Context context) {
        super(context);
        this.context_ = context;
        init_();
    }

    public static SaveMediaToDeviceAlbumModule_ getInstance_(Context context) {
        return new SaveMediaToDeviceAlbumModule_(context);
    }

    public void rebind(Context context) {
        this.context_ = context;
        init_();
    }

    public void onSuccess(final Uri uri) {
        b.a("", new Runnable() {
            public void run() {
                SaveMediaToDeviceAlbumModule_.super.onSuccess(uri);
            }
        }, 0);
    }

    public void onError(final String str) {
        b.a("", new Runnable() {
            public void run() {
                SaveMediaToDeviceAlbumModule_.super.onError(str);
            }
        }, 0);
    }

    public void saveMedia(File file) {
        final File file2 = file;
        a.a((a.C0532a) new a.C0532a("", 0, "") {
            public void execute() {
                try {
                    SaveMediaToDeviceAlbumModule_.super.saveMedia(file2);
                } catch (Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                }
            }
        });
    }
}
