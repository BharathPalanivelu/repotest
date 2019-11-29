package com.afollestad.materialdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.internal.MDRootLayout;

class c extends Dialog implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    protected MDRootLayout f3144a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnShowListener f3145b;

    protected c(Context context, int i) {
        super(context, i);
    }

    public View findViewById(int i) {
        return this.f3144a.findViewById(i);
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f3145b = onShowListener;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.setOnShowListener(this);
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        super.setContentView(view);
    }

    public void onShow(DialogInterface dialogInterface) {
        DialogInterface.OnShowListener onShowListener = this.f3145b;
        if (onShowListener != null) {
            onShowListener.onShow(dialogInterface);
        }
    }

    @Deprecated
    public void setContentView(int i) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Deprecated
    public void setContentView(View view) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Deprecated
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }
}
