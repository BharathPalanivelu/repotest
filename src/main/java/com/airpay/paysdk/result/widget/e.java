package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.view.View;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.BPTransactionMoreDetailsActivity;
import com.airpay.paysdk.result.bean.a;
import com.airpay.paysdk.result.widget.m;

public class e extends m {

    /* renamed from: a  reason: collision with root package name */
    private a f4501a;

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f4502b = new View.OnClickListener() {
        public final void onClick(View view) {
            e.this.a(view);
        }
    };

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    private e(Context context, a aVar) {
        super(context);
        this.f4501a = aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        BPTransactionMoreDetailsActivity.a(getContext(), this.f4501a.q());
    }

    public static e a(Context context, a aVar) {
        if (aVar.t() == 1 && aVar.p() != null && aVar.p().b() == 101) {
            return null;
        }
        return new e(context, aVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        m.c cVar = new m.c(getContext(), (CharSequence) getResources().getString(c.i.com_garena_beepay_label_more_detail), (CharSequence) "", true);
        setOnClickListener(this.f4502b);
        addView(cVar);
    }
}
