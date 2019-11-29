package com.google.android.exoplayer2.e.g;

import android.util.SparseArray;
import com.appsflyer.share.Constants;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.Collections;
import java.util.List;

public interface v {

    public interface c {
        SparseArray<v> a();

        v a(int i, b bVar);
    }

    void a();

    void a(k kVar, boolean z);

    void a(q qVar, h hVar, d dVar);

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f9744a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9745b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f9746c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f9747d;

        public b(int i, String str, List<a> list, byte[] bArr) {
            List<a> list2;
            this.f9744a = i;
            this.f9745b = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.f9746c = list2;
            this.f9747d = bArr;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f9741a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9742b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f9743c;

        public a(String str, int i, byte[] bArr) {
            this.f9741a = str;
            this.f9742b = i;
            this.f9743c = bArr;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f9748a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9749b;

        /* renamed from: c  reason: collision with root package name */
        private final int f9750c;

        /* renamed from: d  reason: collision with root package name */
        private int f9751d;

        /* renamed from: e  reason: collision with root package name */
        private String f9752e;

        public d(int i, int i2) {
            this(RNCartPanelDataEntity.NULL_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + Constants.URL_PATH_DELIMITER;
            } else {
                str = "";
            }
            this.f9748a = str;
            this.f9749b = i2;
            this.f9750c = i3;
            this.f9751d = RNCartPanelDataEntity.NULL_VALUE;
        }

        public void a() {
            int i = this.f9751d;
            this.f9751d = i == Integer.MIN_VALUE ? this.f9749b : i + this.f9750c;
            this.f9752e = this.f9748a + this.f9751d;
        }

        public int b() {
            d();
            return this.f9751d;
        }

        public String c() {
            d();
            return this.f9752e;
        }

        private void d() {
            if (this.f9751d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
