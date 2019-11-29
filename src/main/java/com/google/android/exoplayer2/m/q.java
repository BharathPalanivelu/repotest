package com.google.android.exoplayer2.m;

import android.text.TextUtils;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.n.m;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface q extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final m<String> f10813a = new m<String>() {
        public boolean a(String str) {
            String d2 = t.d(str);
            return !TextUtils.isEmpty(d2) && (!d2.contains("text") || d2.contains("text/vtt")) && !d2.contains("html") && !d2.contains("xml");
        }
    };

    public interface b extends f.a {
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f10815a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f10816b;

        public synchronized Map<String, String> a() {
            if (this.f10816b == null) {
                this.f10816b = Collections.unmodifiableMap(new HashMap(this.f10815a));
            }
            return this.f10816b;
        }
    }

    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final f f10814a = new f();

        /* access modifiers changed from: protected */
        public abstract q b(f fVar);

        /* renamed from: b */
        public final q a() {
            return b(this.f10814a);
        }
    }

    public static class c extends IOException {
        public final i dataSpec;
        public final int type;

        public c(String str, i iVar, int i) {
            super(str);
            this.dataSpec = iVar;
            this.type = i;
        }

        public c(IOException iOException, i iVar, int i) {
            super(iOException);
            this.dataSpec = iVar;
            this.type = i;
        }

        public c(String str, IOException iOException, i iVar, int i) {
            super(str, iOException);
            this.dataSpec = iVar;
            this.type = i;
        }
    }

    public static final class d extends c {
        public final String contentType;

        public d(String str, i iVar) {
            super("Invalid content type: " + str, iVar, 1);
            this.contentType = str;
        }
    }

    public static final class e extends c {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        public e(int i, Map<String, List<String>> map, i iVar) {
            super("Response code: " + i, iVar, 1);
            this.responseCode = i;
            this.headerFields = map;
        }
    }
}
