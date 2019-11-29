package com.airpay.paysdk.qrcode.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.bean.TicketPin;
import com.airpay.paysdk.base.d.e;
import com.airpay.paysdk.base.d.h;
import com.airpay.paysdk.base.d.j;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.facebook.react.uimanager.ViewProps;
import com.google.a.u;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class TicketCodeViewActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    private int f4404b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f4405c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f4406d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f4407e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<TicketPin> f4408f = null;

    /* renamed from: g  reason: collision with root package name */
    private Rect f4409g;
    /* access modifiers changed from: private */
    public ViewPager h;
    private com.airpay.paysdk.base.ui.b.a<TicketPin, b> i;
    /* access modifiers changed from: private */
    public boolean j = false;
    private TicketCodeView k;
    private b l;
    /* access modifiers changed from: private */
    public j.b m = new j.b() {
        public void a(String str, String str2, Bitmap bitmap, boolean z) {
            Iterator it = TicketCodeViewActivity.this.f4408f.iterator();
            int i = 0;
            while (it.hasNext() && !((TicketPin) it.next()).pinCode.equals(str)) {
                i++;
            }
            View findViewWithTag = TicketCodeViewActivity.this.h.findViewWithTag(TicketCodeViewActivity.this.c(i));
            if (findViewWithTag instanceof b) {
                b bVar = (b) findViewWithTag;
                bVar.a(false);
                bVar.setBitmap(bitmap);
            }
        }
    };

    public static void a(Context context, List<TicketPin> list, int i2, boolean z, View view, boolean z2, boolean z3, b bVar) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Intent intent = new Intent(context, TicketCodeViewActivity.class);
        String b2 = h.a().b().b((Object) list);
        intent.putExtra(ViewProps.POSITION, i2);
        intent.putExtra("is_qr_code", z);
        intent.putExtra("ticket_pins", b2);
        intent.putExtra("source_view", rect);
        intent.putExtra("show_logo", z2);
        intent.putExtra("show_msg", z3);
        Bundle bundle = new Bundle();
        o.a(bundle, bVar);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_airpay_activity_ticket_code_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.l = o.a(getIntent().getExtras());
        this.f4404b = getIntent().getIntExtra(ViewProps.POSITION, 0);
        this.f4405c = getIntent().getBooleanExtra("is_qr_code", false);
        this.f4409g = (Rect) getIntent().getParcelableExtra("source_view");
        this.f4406d = getIntent().getBooleanExtra("show_logo", false);
        this.f4407e = getIntent().getBooleanExtra("show_msg", false);
        String stringExtra = getIntent().getStringExtra("ticket_pins");
        try {
            this.f4408f = (List) h.a().b().a(stringExtra, new com.google.a.c.a<List<TicketPin>>() {
            }.getType());
        } catch (u e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
        }
        List<TicketPin> list = this.f4408f;
        if (list == null || list.isEmpty()) {
            com.airpay.paysdk.base.b.a.a().a((Context) this, c.i.com_garena_beepay_error_unknown);
            finish();
            return;
        }
        if (this.f4405c) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        this.i = new com.airpay.paysdk.base.ui.b.a<TicketPin, b>(this, this.f4408f) {

            /* renamed from: a  reason: collision with root package name */
            Bitmap f4412a = null;

            /* renamed from: b */
            public b a(Context context) {
                b bVar = new b(context);
                bVar.b(TicketCodeViewActivity.this.f4407e);
                bVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return bVar;
            }

            public void a(Context context, b bVar, TicketPin ticketPin, int i) {
                bVar.setTag(TicketCodeViewActivity.this.c(i));
                bVar.a(ticketPin.label, !TicketCodeViewActivity.this.f4405c);
                bVar.a(true);
                if (TicketCodeViewActivity.this.f4405c) {
                    if (TicketCodeViewActivity.this.f4406d && this.f4412a == null) {
                        this.f4412a = BitmapFactory.decodeResource(TicketCodeViewActivity.this.getResources(), c.d.com_garena_beepay_ic_launcher);
                    }
                    j.a((Activity) TicketCodeViewActivity.this, ticketPin.pinCode, this.f4412a, true, TicketCodeViewActivity.this.m);
                    return;
                }
                j.a((Activity) TicketCodeViewActivity.this, ticketPin.pinCode, true, TicketCodeViewActivity.this.m);
            }

            public void finishUpdate(ViewGroup viewGroup) {
                super.finishUpdate(viewGroup);
                if (!TicketCodeViewActivity.this.j) {
                    boolean unused = TicketCodeViewActivity.this.j = true;
                    TicketCodeViewActivity ticketCodeViewActivity = TicketCodeViewActivity.this;
                    ticketCodeViewActivity.d(ticketCodeViewActivity.h.getCurrentItem());
                }
            }
        };
        b(false);
        e.a(this);
        this.k = (TicketCodeView) findViewById(c.f.com_garena_beepay_ticket_code_view);
        this.k.a(this, this.f4409g);
        this.h = (ViewPager) findViewById(c.f.com_garena_beepay_pager);
        this.h.setAdapter(this.i);
        this.h.setCurrentItem(this.f4404b);
        this.h.addOnPageChangeListener(new ViewPager.f() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f2, int i2) {
            }

            public void onPageSelected(int i) {
                TicketCodeViewActivity.this.d(i);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public String c(int i2) {
        return String.format(Locale.US, "item_view_%1$d", new Object[]{Integer.valueOf(i2)});
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        b bVar = (b) e().findViewWithTag(c(i2));
        if (bVar != null) {
            this.k.setMovableView(bVar.getmSectionContent());
            this.k.a();
            if (i2 == this.f4404b) {
                this.k.setTargetView(bVar.getmImgCode());
                this.k.a((View) bVar.getmTxtCode());
                this.k.a(bVar.getmBackgroundView());
                return;
            }
            this.k.setTargetView((View) null);
        }
    }
}
