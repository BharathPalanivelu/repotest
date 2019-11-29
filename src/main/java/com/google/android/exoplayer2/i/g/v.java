package com.google.android.exoplayer2.i.g;

import android.util.SparseArray;
import com.appsflyer.share.Constants;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.Collections;
import java.util.List;

public interface v {

    public interface c {
        SparseArray<v> a();

        v a(int i, b bVar);
    }

    void a();

    void a(l lVar, boolean z);

    void a(s sVar, g gVar, d dVar);

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f10381a;

        /* renamed from: b  reason: collision with root package name */
        public final String f10382b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f10383c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f10384d;

        public b(int i, String str, List<a> list, byte[] bArr) {
            List<a> list2;
            this.f10381a = i;
            this.f10382b = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.f10383c = list2;
            this.f10384d = bArr;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f10378a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10379b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f10380c;

        public a(String str, int i, byte[] bArr) {
            this.f10378a = str;
            this.f10379b = i;
            this.f10380c = bArr;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f10385a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10386b;

        /* renamed from: c  reason: collision with root package name */
        private final int f10387c;

        /* renamed from: d  reason: collision with root package name */
        private int f10388d;

        /* renamed from: e  reason: collision with root package name */
        private String f10389e;

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
            this.f10385a = str;
            this.f10386b = i2;
            this.f10387c = i3;
            this.f10388d = RNCartPanelDataEntity.NULL_VALUE;
        }

        public void a() {
            int i = this.f10388d;
            this.f10388d = i == Integer.MIN_VALUE ? this.f10386b : i + this.f10387c;
            this.f10389e = this.f10385a + this.f10388d;
        }

        public int b() {
            d();
            return this.f10388d;
        }

        public String c() {
            d();
            return this.f10389e;
        }

        private void d() {
            if (this.f10388d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
