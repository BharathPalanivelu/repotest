package com.shopee.app.ui.chat;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import org.a.a.a.d;
import org.a.a.b.c;

public final class ChatActivity_ extends a implements org.a.a.b.a {

    /* renamed from: f  reason: collision with root package name */
    private final c f19998f = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.f19998f);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        l();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f19998f.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.f19998f.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.f19998f.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("toUserId")) {
                this.f20004d = extras.getInt("toUserId");
            }
            if (extras.containsKey("intention")) {
                this.f20005e = (ChatIntention) extras.getParcelable("intention");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4) {
            a(i2, intent);
        } else if (i == 406) {
            b(i2, intent);
        } else if (i == 408) {
            c(i2, intent);
        } else if (i == 816) {
            d(i2, intent);
        } else if (i == 6271) {
            e(i2, intent);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f19999d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f20000e;

        public a(Context context) {
            super(context, ChatActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f20000e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f19999d;
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
            return (a) super.a("toUserId", i);
        }

        public a a(ChatIntention chatIntention) {
            return (a) super.a("intention", (Parcelable) chatIntention);
        }
    }
}
