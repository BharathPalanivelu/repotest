package com.google.android.libraries.places.widget;

import android.os.Bundle;
import androidx.appcompat.app.d;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.internal.dx;
import com.google.android.libraries.places.internal.fs;
import com.google.android.libraries.places.internal.fz;
import com.google.android.libraries.places.internal.gb;
import com.google.android.libraries.places.internal.go;

public class AutocompleteActivity extends d {
    public static final int RESULT_ERROR = 2;

    /* renamed from: a  reason: collision with root package name */
    private fs f13082a;

    public void onCreate(Bundle bundle) {
        try {
            go.b(Places.isInitialized(), (Object) "Places must be initialized.");
            fz a2 = gb.a(this, bundle);
            if (this.f13082a == null) {
                this.f13082a = a2.a();
            }
            super.onCreate(bundle);
            this.f13082a.a();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            this.f13082a.c();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            this.f13082a.d();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public void onBackPressed() {
        try {
            this.f13082a.e();
            super.onBackPressed();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            this.f13082a.f();
            super.onPause();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
            this.f13082a.a(bundle);
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            this.f13082a.g();
            super.onStop();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            this.f13082a.h();
            super.onDestroy();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }
}
