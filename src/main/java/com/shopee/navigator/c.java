package com.shopee.navigator;

import android.content.Context;
import android.content.Intent;
import com.google.a.o;
import com.shopee.navigator.options.JumpOption;
import com.shopee.navigator.options.PopOption;
import com.shopee.navigator.options.PushOption;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Intent f30118a;

    public PushOption a() {
        return (PushOption) this.f30118a.getParcelableExtra("PUSH_OPTION_INTENT_KEY");
    }

    public PopOption b() {
        return (PopOption) this.f30118a.getParcelableExtra("POP_OPTION_INTENT_KEY");
    }

    public o c() {
        return a.f30103b.a(d()).m();
    }

    public String d() {
        return this.f30118a.hasExtra("PUSH_DATA_KEY") ? this.f30118a.getStringExtra("PUSH_DATA_KEY") : a.f30104c;
    }

    public NavigationPath e() {
        return (NavigationPath) this.f30118a.getParcelableExtra("NAVIGATION_PATH_INTENT_KEY");
    }

    public String f() {
        return this.f30118a.hasExtra("FROM_NAME_INTENT_KEY") ? this.f30118a.getStringExtra("FROM_NAME_INTENT_KEY") : "";
    }

    public boolean g() {
        return this.f30118a.getBooleanExtra("JUMP_FLAG_INTENT_KEY", false);
    }

    public JumpOption h() {
        return (JumpOption) this.f30118a.getParcelableExtra("JUMP_OPTION_INTENT_KEY");
    }

    public Intent i() {
        return this.f30118a;
    }

    private c(a aVar) {
        this.f30118a = aVar.f30119a;
    }

    public c(Intent intent) {
        this.f30118a = intent;
    }

    public void j() {
        this.f30118a.putExtra("JUMP_FLAG_INTENT_KEY", false);
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Intent f30119a;

        public a(Context context, Class cls) {
            this.f30119a = new Intent(context, cls);
        }

        public a() {
            this.f30119a = new Intent();
        }

        public a a(PushOption pushOption) {
            this.f30119a.putExtra("PUSH_OPTION_INTENT_KEY", pushOption);
            return this;
        }

        public a a(PopOption popOption) {
            this.f30119a.putExtra("POP_OPTION_INTENT_KEY", popOption);
            return this;
        }

        public a a(String str) {
            this.f30119a.putExtra("FROM_NAME_INTENT_KEY", str);
            return this;
        }

        public a a(o oVar) {
            this.f30119a.putExtra("PUSH_DATA_KEY", oVar.toString());
            return this;
        }

        public a a(NavigationPath navigationPath) {
            this.f30119a.putExtra("NAVIGATION_PATH_INTENT_KEY", navigationPath);
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
