package com.shopee.live.livestreaming.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.shopee.live.livestreaming.ui.forbidden.LiveStreamingForbiddenZoneActivity;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;
import com.shopee.sdk.modules.ui.navigator.options.PopOption;
import com.shopee.sdk.modules.ui.navigator.options.PushOption;

public class o {
    public static void a(Activity activity, String str, int i, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("?type=" + str2 + "&");
        sb.append("bgurl=" + str3 + "&");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("session=");
        sb2.append(i);
        sb.append(sb2.toString());
        b.a().e().a(activity, NavigationPath.a(sb.toString()), (com.google.a.o) null, PushOption.a(2));
    }

    public static void a(Activity activity) {
        if (activity != null) {
            b.a().e().a(activity, (com.google.a.o) null, PopOption.b(2));
        }
    }

    public static void a(Activity activity, String str, a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("?type=" + aVar.f29469a + "&");
        sb.append("bgurl=" + aVar.f29470b + "&");
        sb.append("session=" + aVar.f29471c + "&");
        sb.append("shop_id=" + aVar.f29472d + "&");
        sb.append("host_avatar=" + aVar.f29473e + "&");
        sb.append("host_name=" + Uri.encode(aVar.f29474f) + "&");
        sb.append("product_total_count=" + aVar.f29475g + "&");
        sb.append("session_title=" + Uri.encode(aVar.h) + "&");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("host_user_id=");
        sb2.append(aVar.i);
        sb.append(sb2.toString());
        if (aVar.j) {
            sb.append("&can_show_items");
        }
        if (aVar.k != null) {
            sb.append("#from_source=" + aVar.k);
        }
        b.a().e().a(activity, NavigationPath.a(sb.toString()), (com.google.a.o) null, PushOption.a(1));
    }

    public static void b(Activity activity) {
        activity.startActivity(new Intent(activity, LiveStreamingForbiddenZoneActivity.class));
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29469a;

        /* renamed from: b  reason: collision with root package name */
        public String f29470b;

        /* renamed from: c  reason: collision with root package name */
        public int f29471c;

        /* renamed from: d  reason: collision with root package name */
        public int f29472d;

        /* renamed from: e  reason: collision with root package name */
        public String f29473e;

        /* renamed from: f  reason: collision with root package name */
        public String f29474f;

        /* renamed from: g  reason: collision with root package name */
        public int f29475g;
        public String h;
        public int i;
        public boolean j;
        public String k;

        /* renamed from: com.shopee.live.livestreaming.util.o$a$a  reason: collision with other inner class name */
        public static class C0448a {

            /* renamed from: a  reason: collision with root package name */
            private String f29476a;

            /* renamed from: b  reason: collision with root package name */
            private String f29477b;

            /* renamed from: c  reason: collision with root package name */
            private int f29478c;

            /* renamed from: d  reason: collision with root package name */
            private int f29479d;

            /* renamed from: e  reason: collision with root package name */
            private String f29480e;

            /* renamed from: f  reason: collision with root package name */
            private String f29481f;

            /* renamed from: g  reason: collision with root package name */
            private int f29482g;
            private String h;
            private int i;
            private boolean j;
            private String k;

            public C0448a a(String str) {
                this.f29476a = str;
                return this;
            }

            public C0448a b(String str) {
                this.f29477b = str;
                return this;
            }

            public C0448a a(int i2) {
                this.f29478c = i2;
                return this;
            }

            public C0448a b(int i2) {
                this.f29479d = i2;
                return this;
            }

            public C0448a c(String str) {
                this.f29480e = str;
                return this;
            }

            public C0448a d(String str) {
                this.f29481f = str;
                return this;
            }

            public C0448a c(int i2) {
                this.f29482g = i2;
                return this;
            }

            public C0448a e(String str) {
                this.h = str;
                return this;
            }

            public C0448a d(int i2) {
                this.i = i2;
                return this;
            }

            public C0448a a(boolean z) {
                this.j = z;
                return this;
            }

            public C0448a f(String str) {
                this.k = str;
                return this;
            }

            public a a() {
                a aVar = new a();
                aVar.f29469a = this.f29476a;
                aVar.f29470b = this.f29477b;
                aVar.f29471c = this.f29478c;
                aVar.f29472d = this.f29479d;
                aVar.f29473e = this.f29480e;
                aVar.f29474f = this.f29481f;
                aVar.f29475g = this.f29482g;
                aVar.h = this.h;
                aVar.i = this.i;
                aVar.j = this.j;
                aVar.k = this.k;
                return aVar;
            }
        }
    }
}
