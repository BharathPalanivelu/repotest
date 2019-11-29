package com.shopee.app.d.c;

import android.net.Uri;
import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.network.g;
import com.shopee.app.ui.auth.signup.c;
import com.shopee.app.util.n;
import java.util.HashSet;
import java.util.Set;

public class dc extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f16783c;

    /* renamed from: d  reason: collision with root package name */
    private String f16784d;

    /* renamed from: e  reason: collision with root package name */
    private SettingConfigStore f16785e;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetFbProfilePhotoInteractor";
    }

    public dc(n nVar, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f16783c = nVar;
        this.f16785e = settingConfigStore;
    }

    public void a(String str) {
        this.f16784d = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (!TextUtils.isEmpty(this.f16784d)) {
            String a2 = c.a(Uri.parse(this.f16784d), this.f16785e.getAvatarImageConfig());
            if (a2 != null) {
                HashSet hashSet = new HashSet();
                hashSet.add(a2);
                hashSet.add(a2 + "_tn");
                this.f16783c.a("IMAGE_PROCESSED", new a(a2));
                com.shopee.app.h.b.a.a().a((Set<String>) hashSet, new g());
            }
        }
    }
}
