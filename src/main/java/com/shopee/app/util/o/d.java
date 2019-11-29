package com.shopee.app.util.o;

import android.app.Activity;
import android.content.Context;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.home.me.v3.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f26474a;

    /* renamed from: b  reason: collision with root package name */
    private SparseIntArray f26475b = new SparseIntArray(5);

    /* renamed from: c  reason: collision with root package name */
    private int f26476c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26477d = true;

    public boolean b() {
        return true;
    }

    private d() {
    }

    public static d a() {
        if (f26474a == null) {
            f26474a = new d();
        }
        return f26474a;
    }

    public void a(Activity activity) {
        if (b()) {
            this.f26477d = c.a(activity);
            c.b(activity);
        }
    }

    public void b(Activity activity) {
        if (b()) {
            this.f26477d = c.a(activity);
            c.c(activity);
        }
    }

    public void c(Activity activity) {
        if (b()) {
            this.f26477d = c.a(activity);
        }
    }

    public int a(Context context) {
        if (!b() || !this.f26477d) {
            return 0;
        }
        return c.a(context);
    }

    public void a(Activity activity, com.shopee.app.ui.a.d dVar, int i) {
        if (b()) {
            this.f26477d = c.a(activity);
            c(activity, i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dVar.getActionBar().getLayoutParams().width, b.a.r + a((Context) activity));
            layoutParams.gravity = 48;
            dVar.getActionBar().setPadding(dVar.getActionBar().getPaddingLeft(), a((Context) activity), dVar.getActionBar().getPaddingRight(), dVar.getActionBar().getPaddingBottom());
            dVar.getActionBar().setLayoutParams(layoutParams);
        }
    }

    private void c(Activity activity, int i) {
        if (i == 0) {
            c.b(activity);
        } else {
            c.c(activity);
        }
    }

    public void a(Context context, a aVar) {
        if (b()) {
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) aVar.q.getLayoutParams();
            aVar2.topMargin = a(context);
            aVar.q.setLayoutParams(aVar2);
            com.shopee.app.ui.actionbar.a mActionBar = aVar.getMActionBar();
            if (mActionBar != null) {
                ConstraintLayout.a aVar3 = (ConstraintLayout.a) mActionBar.getLayoutParams();
                aVar3.topMargin = a(context);
                mActionBar.setLayoutParams(aVar3);
            }
        }
    }

    public void a(Activity activity, int i) {
        this.f26476c = i;
        c(activity, this.f26475b.get(i));
    }

    public void b(Activity activity, int i) {
        if (activity instanceof c) {
            this.f26475b.put(this.f26476c, i);
        }
    }
}
