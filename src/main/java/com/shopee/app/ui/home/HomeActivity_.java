package com.shopee.app.ui.home;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import org.a.a.a.d;
import org.a.a.b.c;

public final class HomeActivity_ extends c implements org.a.a.b.a {
    private final c H = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.H);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        I();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.H.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.H.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.H.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void I() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("tabPosition")) {
                this.f7012a = extras.getInt("tabPosition");
            }
            if (extras.containsKey("redirect")) {
                this.f7013b = extras.getString("redirect");
            }
            if (extras.containsKey("httpURL")) {
                this.f7014c = extras.getString("httpURL");
            }
            if (extras.containsKey("notiTaskId")) {
                this.f7015d = extras.getInt("notiTaskId");
            }
            if (extras.containsKey("resetLocale")) {
                this.f7016e = extras.getBoolean("resetLocale");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        I();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        super.onActivityResult(i, i2, intent);
        if (i3 == 3) {
            a(i4, intent2);
        } else if (i3 == 20123) {
            c(i4);
        } else if (i3 == 10029) {
            Bundle bundle = (intent2 == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle.getString("keyword"), bundle.getInt("type"), bundle.getInt("cateId"), bundle.getString("cateName"), bundle.getInt("defaultSuggestionsIndex"), bundle.getInt("scopeListIndex"), bundle.getString(ShareConstants.FEED_SOURCE_PARAM), bundle.getString("tracking"));
        } else if (i3 == 10030) {
            Bundle bundle2 = (intent2 == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            b(i2, bundle2.getString("keyword"), bundle2.getInt("type"), bundle2.getInt("cateId"), bundle2.getString("cateName"), bundle2.getInt("defaultSuggestionsIndex"), bundle2.getInt("scopeListIndex"), bundle2.getString(ShareConstants.FEED_SOURCE_PARAM), bundle2.getString("tracking"));
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f7009d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f7010e;

        public a(Context context) {
            super(context, HomeActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f7010e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f7009d;
                if (fragment2 != null) {
                    fragment2.startActivityForResult(this.f7170c, i, this.f7168a);
                } else if (this.f7169b instanceof Activity) {
                    androidx.core.app.a.a((Activity) this.f7169b, this.f7170c, i, this.f7168a);
                } else {
                    this.f7169b.startActivity(this.f7170c, this.f7168a);
                }
            }
            return new d(this.f7169b);
        }

        public a b(int i) {
            return (a) super.a("tabPosition", i);
        }

        public a a(String str) {
            return (a) super.a("redirect", str);
        }

        public a b(String str) {
            return (a) super.a("httpURL", str);
        }

        public a c(int i) {
            return (a) super.a("notiTaskId", i);
        }

        public a a(boolean z) {
            return (a) super.a("resetLocale", z);
        }
    }
}
