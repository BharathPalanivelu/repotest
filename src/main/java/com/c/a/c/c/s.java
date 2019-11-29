package com.c.a.c.c;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.InputStream;

public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f5973a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f5974b;

    public boolean a(Integer num) {
        return true;
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f5974b = resources;
        this.f5973a = nVar;
    }

    public n.a<Data> a(Integer num, int i, int i2, j jVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f5973a.a(b2, i, i2, jVar);
    }

    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f5974b.getResourcePackageName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.f5974b.getResourceTypeName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.f5974b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    public static class b implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f5976a;

        public b(Resources resources) {
            this.f5976a = resources;
        }

        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f5976a, rVar.a(Uri.class, InputStream.class));
        }
    }

    public static class a implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f5975a;

        public a(Resources resources) {
            this.f5975a = resources;
        }

        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f5975a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f5977a;

        public c(Resources resources) {
            this.f5977a = resources;
        }

        public n<Integer, Uri> a(r rVar) {
            return new s(this.f5977a, v.a());
        }
    }
}
