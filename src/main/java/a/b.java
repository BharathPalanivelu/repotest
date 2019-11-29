package a;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Uri f350a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f351b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f352c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f353a;

        /* renamed from: b  reason: collision with root package name */
        private final String f354b;

        /* renamed from: c  reason: collision with root package name */
        private final String f355c;

        /* renamed from: d  reason: collision with root package name */
        private final String f356d;

        public a(String str, String str2, Uri uri, String str3) {
            this.f354b = str;
            this.f355c = str2;
            this.f353a = uri;
            this.f356d = str3;
        }
    }

    public b(Uri uri, List<a> list, Uri uri2) {
        this.f350a = uri;
        this.f351b = list == null ? Collections.emptyList() : list;
        this.f352c = uri2;
    }
}
