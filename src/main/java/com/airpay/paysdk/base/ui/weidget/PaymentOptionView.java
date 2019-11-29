package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.b;
import com.airpay.paysdk.qrcode.model.BPSimpleTopUpFullInfo;
import com.airpay.paysdk.qrcode.model.BankAccountFullInfo;
import com.airpay.paysdk.qrcode.model.QRTopupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaymentOptionView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f3896a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f3897b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f3898c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f3899d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f3900e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f3901f;

    /* renamed from: g  reason: collision with root package name */
    private View f3902g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private int l = 147;
    private a m;
    private int n;
    private long o;
    private boolean p;
    private int q;
    private List<QRTopupInfo> r = new ArrayList();
    private List<BankAccountFullInfo> s = new ArrayList();
    private int t = 0;
    private List<com.airpay.paysdk.qrcode.model.a> u = new ArrayList();
    private ArrayList<BPSimpleTopUpFullInfo> v = new ArrayList<>();

    public interface a {
        void a();

        void a(int i, String str);

        void a(ArrayList<BPSimpleTopUpFullInfo> arrayList);
    }

    public PaymentOptionView(Context context) {
        super(context);
        a();
    }

    public PaymentOptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PaymentOptionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public void setOptionUpdateListener(a aVar) {
        this.m = aVar;
    }

    private void a() {
        inflate(getContext(), c.h.view_qr_payment_option, this);
        this.f3896a = findViewById(c.f.qr_payment_additional_option);
        this.f3897b = (ImageView) findViewById(c.f.qr_payment_additional_option_icon);
        this.f3898c = (ImageView) findViewById(c.f.qr_payment_additional_option_selection);
        this.f3899d = (TextView) findViewById(c.f.qr_payment_additional_option_title);
        this.f3900e = (TextView) findViewById(c.f.qr_payment_additional_option_description);
        this.f3901f = (TextView) findViewById(c.f.qr_payment_additional_option_extra_description);
        this.f3902g = findViewById(c.f.my_additional_option_divider);
        View findViewById = findViewById(c.f.qr_payment_option);
        this.h = (ImageView) findViewById(c.f.qr_payment_option_icon);
        this.i = (TextView) findViewById(c.f.qr_payment_option_title);
        this.j = (TextView) findViewById(c.f.qr_payment_option_description);
        this.k = (TextView) findViewById(c.f.qr_payment_option_extra_description);
        a(false);
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentOptionView.this.b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        int i2 = this.l;
        if (i2 != 147 && i2 != 146) {
            a aVar = this.m;
            if (aVar != null) {
                aVar.a(this.v);
            }
        }
    }

    private void a(boolean z) {
        int i2 = 0;
        this.f3896a.setVisibility(z ? 0 : 8);
        View view = this.f3902g;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
        if (z) {
            this.f3896a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PaymentOptionView.this.a(view);
                }
            });
        } else {
            this.f3896a.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.p = !this.p;
        this.f3898c.setSelected(this.p);
        a aVar = this.m;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(boolean z, int i2, String str) {
        this.p = z;
        this.f3898c.setSelected(this.p);
        this.n = i2;
        if (!TextUtils.isEmpty(str)) {
            this.o = Long.valueOf(str).longValue();
        }
        a(1);
    }

    public void a(int i2, List<QRTopupInfo> list) {
        if (i2 > -1 && list != null) {
            this.q = i2;
            this.r.clear();
            a((this.q & 256) == 256);
            this.r = list;
            a(4);
        }
    }

    public void a(List<BankAccountFullInfo> list) {
        if (list != null) {
            this.s.clear();
            this.s.addAll(list);
            a(2);
        }
    }

    private void a(int i2) {
        this.t = i2 | this.t;
        if (this.t == 7) {
            b();
            requestLayout();
        }
    }

    private void b() {
        if (this.n > 0 && !this.r.isEmpty()) {
            if ((this.q & 256) == 256) {
                e();
            }
            if (this.q == 1) {
                this.l = 146;
                d();
            } else {
                f();
            }
        }
        g();
    }

    private boolean c() {
        int i2 = this.q;
        return ((i2 & 256) == 256 || (i2 & 1) != 1 || i2 == 1) ? false : true;
    }

    private void d() {
        Resources resources = com.airpay.paysdk.a.a().b().getResources();
        int k2 = com.airpay.paysdk.base.different.a.a().k();
        String string = resources.getString(c.i.com_garena_beepay_label_cash);
        String string2 = resources.getString(c.i.label_available_cash_balance, new Object[]{b.b((double) com.airpay.paysdk.base.b.c.a().b())});
        String str = null;
        for (QRTopupInfo next : this.r) {
            if (next.f4371b == 11000) {
                str = next.f4372c;
            }
        }
        a(string, string2, str, k2);
    }

    private void e() {
        Resources resources = com.airpay.paysdk.a.a().b().getResources();
        int k2 = com.airpay.paysdk.base.different.a.a().k();
        String string = resources.getString(c.i.com_garena_beepay_label_cash);
        String string2 = resources.getString(c.i.label_available_cash_balance, new Object[]{b.b((double) com.airpay.paysdk.base.b.c.a().b())});
        String str = null;
        for (QRTopupInfo next : this.r) {
            if (next.f4371b == 11000) {
                str = next.f4372c;
            }
        }
        b(string, string2, str, k2);
    }

    private void f() {
        QRTopupInfo qRTopupInfo;
        this.l = 148;
        if (!c() || this.n != 11000) {
            Iterator<QRTopupInfo> it = this.r.iterator();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    qRTopupInfo = null;
                    break;
                }
                qRTopupInfo = it.next();
                if (qRTopupInfo.f4371b != 11000) {
                    i2++;
                }
                if (qRTopupInfo.f4371b == this.o) {
                    z = true;
                    break;
                }
            }
            if (!z && i2 > 0) {
                Iterator<QRTopupInfo> it2 = this.r.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    QRTopupInfo next = it2.next();
                    if (next.f4371b != 11000) {
                        this.o = next.f4371b;
                        Iterator<BankAccountFullInfo> it3 = this.s.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            BankAccountFullInfo next2 = it3.next();
                            if (next2.c() == this.o) {
                                this.n = next2.a();
                                break;
                            }
                        }
                        a aVar = this.m;
                        if (aVar != null) {
                            aVar.a(this.n, String.valueOf(this.o));
                        }
                        qRTopupInfo = next;
                        z = true;
                    }
                }
            }
            if (z) {
                this.l = 149;
                for (BankAccountFullInfo next3 : this.s) {
                    if (next3.c() == this.o) {
                        a(qRTopupInfo, next3);
                        return;
                    }
                }
            } else if (i2 == 0) {
                this.l = 147;
            } else {
                a(com.airpay.paysdk.a.a().b().getResources().getString(c.i.com_garena_beepay_label_select_card), "", "", c.d.userpaymentqr_icon_addcard);
            }
        } else {
            d();
        }
    }

    private void g() {
        if (!this.r.isEmpty()) {
            this.u.clear();
            this.v.clear();
            for (QRTopupInfo next : this.r) {
                if (next.f4371b == 11000) {
                    com.airpay.paysdk.qrcode.model.a aVar = new com.airpay.paysdk.qrcode.model.a(next, (BankAccountFullInfo) null);
                    this.u.add(new com.airpay.paysdk.qrcode.model.a(next, (BankAccountFullInfo) null));
                    if (c()) {
                        this.v.add(new BPSimpleTopUpFullInfo(aVar));
                    }
                } else {
                    for (BankAccountFullInfo next2 : this.s) {
                        if (next2.c() == next.f4371b) {
                            com.airpay.paysdk.qrcode.model.a aVar2 = new com.airpay.paysdk.qrcode.model.a(next, next2);
                            this.u.add(aVar2);
                            this.v.add(new BPSimpleTopUpFullInfo(aVar2));
                        }
                    }
                }
            }
        }
    }

    private void a(QRTopupInfo qRTopupInfo, BankAccountFullInfo bankAccountFullInfo) {
        int i2;
        String str;
        String str2 = f.a(bankAccountFullInfo.d().f4355a, bankAccountFullInfo.a(), false, true) + " **" + f.b(bankAccountFullInfo.b());
        if (bankAccountFullInfo.g()) {
            String g2 = com.airpay.paysdk.pay.b.a.g(bankAccountFullInfo.d().l);
            char c2 = 65535;
            switch (g2.hashCode()) {
                case 47665:
                    if (g2.equals("001")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 47666:
                    if (g2.equals("002")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 47671:
                    if (g2.equals("007")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                i2 = c.d.com_garena_beepay_logo_payment_visa;
            } else if (c2 == 1) {
                i2 = c.d.com_garena_beepay_logo_payment_master;
            } else if (c2 != 2) {
                i2 = c.d.com_garena_beepay_logo_payment_unknown;
            } else {
                i2 = c.d.com_garena_beepay_logo_payment_jcb;
            }
        } else {
            i2 = f.a(bankAccountFullInfo.a());
        }
        if (qRTopupInfo != null) {
            str = qRTopupInfo.f4372c;
        } else {
            str = "";
        }
        a(str2, str, "", i2);
    }

    private void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2) {
        this.h.setImageResource(i2);
        this.i.setText(charSequence);
        if (!TextUtils.isEmpty(charSequence2)) {
            this.j.setText(charSequence2);
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
            this.j.setText("");
        }
        if (!TextUtils.isEmpty(charSequence3)) {
            this.k.setVisibility(0);
            this.k.setText(charSequence3);
            return;
        }
        this.k.setVisibility(8);
        this.k.setText("");
    }

    private void b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2) {
        this.f3897b.setImageResource(i2);
        this.f3899d.setText(charSequence);
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f3900e.setText(charSequence2);
            this.f3900e.setVisibility(0);
        } else {
            this.f3900e.setVisibility(8);
        }
        if (!TextUtils.isEmpty(charSequence3)) {
            this.f3901f.setText(charSequence3);
            this.f3901f.setVisibility(0);
        } else {
            this.f3901f.setVisibility(8);
        }
        if (this.s.isEmpty()) {
            this.f3896a.setEnabled(false);
            this.f3898c.setImageResource(c.d.img_selection_box_selected_disabled);
            return;
        }
        this.f3896a.setEnabled(true);
        this.f3898c.setImageResource(c.d.com_garena_beepay_circular_checkbox_selector);
    }
}
