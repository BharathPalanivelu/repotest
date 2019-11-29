package com.shopee.app.ui.webview;

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

public final class WebPageActivity_ extends c implements org.a.a.b.a {
    private final c n = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.n);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        G();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.n.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.n.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.n.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void G() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("navbar")) {
                this.f7023c = extras.getString("navbar");
            }
            if (extras.containsKey("isPresentModel")) {
                this.f7024d = extras.getBoolean("isPresentModel");
            }
            if (extras.containsKey("url")) {
                this.f7025e = extras.getString("url");
            }
            if (extras.containsKey("popupStr")) {
                this.f7026f = extras.getString("popupStr");
            }
            if (extras.containsKey("tabsStr")) {
                this.f7027g = extras.getString("tabsStr");
            }
            if (extras.containsKey("tabRightButtonStr")) {
                this.h = extras.getString("tabRightButtonStr");
            }
            if (extras.containsKey("config")) {
                this.i = extras.getString("config");
            }
            if (extras.containsKey("lastPageJs")) {
                this.j = extras.getString("lastPageJs");
            }
            if (extras.containsKey("preloadKey")) {
                this.k = extras.getString("preloadKey");
            }
            if (extras.containsKey("pageType")) {
                this.l = extras.getInt("pageType");
            }
            if (extras.containsKey("popUpForBackButton")) {
                this.m = extras.getString("popUpForBackButton");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        G();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3) {
            e(i2, intent);
        } else if (i == 4) {
            c(i2, intent);
        } else if (i == 6) {
            b(i2, ((intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras()).getString("callbackId"));
        } else if (i == 100) {
            Bundle bundle = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(bundle.getString("returnData"), bundle.getInt("returnCountKey"));
        } else if (i == 1002) {
            b(i2, intent);
        } else if (i == 1923) {
            a(i2, intent);
        } else if (i == 7222) {
            a(i2, ((intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras()).getLong("commentId"));
        } else if (i == 7264) {
            Bundle bundle2 = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle2.getInt("index"), bundle2.getBoolean("isPlaying"), bundle2.getInt("curTime"));
        } else if (i == 8772) {
            d(i2, intent);
        } else if (i == 9281) {
            a(i2, ((intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras()).getString("popData"));
        } else if (i == 10029) {
            Bundle bundle3 = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle3.getString("keyword"), bundle3.getInt("type"), bundle3.getInt("cateId"), bundle3.getString("cateName"), bundle3.getInt("defaultSuggestionsIndex"), bundle3.getInt("scopeListIndex"), bundle3.getString(ShareConstants.FEED_SOURCE_PARAM), bundle3.getString("tracking"));
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f25811d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f25812e;

        public a(Context context) {
            super(context, WebPageActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f25812e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f25811d;
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

        public a a(String str) {
            return (a) super.a("navbar", str);
        }

        public a a(boolean z) {
            return (a) super.a("isPresentModel", z);
        }

        public a b(String str) {
            return (a) super.a("url", str);
        }

        public a c(String str) {
            return (a) super.a("popupStr", str);
        }

        public a d(String str) {
            return (a) super.a("tabsStr", str);
        }

        public a e(String str) {
            return (a) super.a("tabRightButtonStr", str);
        }

        public a f(String str) {
            return (a) super.a("config", str);
        }

        public a g(String str) {
            return (a) super.a("lastPageJs", str);
        }

        public a h(String str) {
            return (a) super.a("preloadKey", str);
        }

        public a b(int i) {
            return (a) super.a("pageType", i);
        }

        public a i(String str) {
            return (a) super.a("popUpForBackButton", str);
        }
    }
}
