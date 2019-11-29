package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.airpay.paysdk.base.interfaces.ILoadingView;

public abstract class j extends View implements ILoadingView {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f3951a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f3952b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f3953c;

    /* access modifiers changed from: protected */
    public abstract void a();

    public j(Context context) {
        this(context, (AttributeSet) null);
    }

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3951a = new a();
        this.f3952b = false;
        this.f3953c = false;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.f3953c = true;
            b();
            return;
        }
        this.f3953c = false;
        removeCallbacks(this.f3951a);
    }

    public void changeLoadingState(boolean z) {
        if (z != this.f3952b) {
            if (z) {
                this.f3952b = true;
                b();
                return;
            }
            this.f3952b = false;
            removeCallbacks(this.f3951a);
        }
    }

    private void b() {
        if (this.f3952b && this.f3953c) {
            post(this.f3951a);
        }
    }

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            if (j.this.f3952b && j.this.f3953c) {
                long currentTimeMillis = System.currentTimeMillis();
                j.this.a();
                j.this.invalidate();
                long currentTimeMillis2 = 16 - (System.currentTimeMillis() - currentTimeMillis);
                j jVar = j.this;
                if (currentTimeMillis2 < 0) {
                    currentTimeMillis2 = 0;
                }
                jVar.postDelayed(this, currentTimeMillis2);
            }
        }
    }
}
