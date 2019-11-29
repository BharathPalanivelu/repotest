package com.airbnb.android.react.maps;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.common.time.Clock;
import com.facebook.react.common.ReactConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class k extends AsyncTask<String, Void, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final String f3338a = "FileUtil";

    /* renamed from: b  reason: collision with root package name */
    private final String f3339b = "temp";

    /* renamed from: c  reason: collision with root package name */
    private Exception f3340c;

    /* renamed from: d  reason: collision with root package name */
    private Context f3341d;

    public k(Context context) {
        this.f3341d = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InputStream doInBackground(String... strArr) {
        try {
            Uri parse = Uri.parse(strArr[0]);
            if (parse.getScheme().startsWith("http")) {
                return a(this.f3341d, parse);
            }
            return this.f3341d.getContentResolver().openInputStream(parse);
        } catch (Exception e2) {
            this.f3340c = e2;
            FLog.e(ReactConstants.TAG, "Could not retrieve file for contentUri " + strArr[0], (Throwable) e2);
            return null;
        }
    }

    private InputStream a(Context context, Uri uri) throws IOException {
        FileOutputStream fileOutputStream;
        File createTempFile = File.createTempFile("FileUtil", "temp", context.getApplicationContext().getCacheDir());
        createTempFile.deleteOnExit();
        InputStream openStream = FirebasePerfUrlConnection.openStream(new URL(uri.toString()));
        try {
            ReadableByteChannel newChannel = Channels.newChannel(openStream);
            try {
                fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.getChannel().transferFrom(newChannel, 0, Clock.MAX_TIME);
                FileInputStream fileInputStream = new FileInputStream(createTempFile);
                fileOutputStream.close();
                newChannel.close();
                return fileInputStream;
            } catch (Throwable th) {
                newChannel.close();
                throw th;
            }
        } finally {
            openStream.close();
        }
    }
}
