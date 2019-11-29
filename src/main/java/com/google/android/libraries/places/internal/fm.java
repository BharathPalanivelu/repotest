package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.TypedValue;
import java.io.Serializable;

public class fm implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f12561a = new Intent();

    public final /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public void a(String str, String str2) {
        if (str2 != null) {
            this.f12561a.putExtra(str, str2);
        } else {
            this.f12561a.removeExtra(str);
        }
    }

    public void a(String str, Parcelable parcelable) {
        if (parcelable != null) {
            this.f12561a.putExtra(str, parcelable);
        } else {
            this.f12561a.removeExtra(str);
        }
    }

    public void a(String str, Serializable serializable) {
        if (serializable != null) {
            this.f12561a.putExtra(str, serializable);
        } else {
            this.f12561a.removeExtra(str);
        }
    }

    public Intent a(Context context, Class<?> cls) {
        this.f12561a.setClass(context, cls);
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        if (theme.resolveAttribute(16843827, typedValue, true) && !this.f12561a.hasExtra("primary_color")) {
            this.f12561a.putExtra("primary_color", typedValue.data);
        }
        if (theme.resolveAttribute(16843828, typedValue2, true) && !this.f12561a.hasExtra("primary_color_dark")) {
            this.f12561a.putExtra("primary_color_dark", typedValue2.data);
        }
        return this.f12561a;
    }
}
