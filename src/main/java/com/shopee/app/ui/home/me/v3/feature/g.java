package com.shopee.app.ui.home.me.v3.feature;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import d.d.b.j;

public final class g extends o<MeFeature> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22620a = new a((g) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* renamed from: a */
    public String b(MeFeature meFeature, int i) {
        j.b(meFeature, "data");
        if (n.f22642a.a(meFeature.getName()) != null) {
            return meFeature.getName();
        }
        return meFeature.getSubFeatures() != null ? "CUSTOM_FEATURE_WITH_SUB" : "CUSTOM_FEATURE";
    }

    public View a(Context context, String str) {
        j.b(context, "context");
        j.b(str, "itemViewType");
        n a2 = n.f22642a.a(str);
        if (a2 != null) {
            return a2.a(context);
        }
        if (j.a((Object) str, (Object) "CUSTOM_FEATURE_WITH_SUB")) {
            return new a(context);
        }
        return new CustomMeFeatureView(context, (AttributeSet) null, 0, 6, (g) null);
    }
}
