package com.airpay.paysdk.qrcode.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.airpay.paysdk.base.b.c;
import com.airpay.paysdk.base.bean.TicketPin;
import com.airpay.paysdk.base.d.d;
import com.airpay.paysdk.base.d.e;
import com.airpay.paysdk.base.d.j;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.base.ui.weidget.BPLoadingLayout;
import com.airpay.paysdk.base.ui.weidget.PaymentOptionView;
import com.airpay.paysdk.base.ui.weidget.a;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.net.a.a.b;
import com.airpay.paysdk.core.bean.Param;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.qrcode.model.BPSimpleTopUpFullInfo;
import com.airpay.paysdk.qrcode.model.BankAccountFullInfo;
import com.airpay.paysdk.qrcode.model.QRCodeGetInfo;
import com.airpay.paysdk.qrcode.model.QRCodeTopupInfo;
import com.airpay.paysdk.qrcode.model.QRTopupInfo;
import com.airpay.paysdk.qrcode.ui.PaymentCodeActivity;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.imsdk.BaseConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentCodeActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f4389b = {4, 8, 12};
    private b A;
    /* access modifiers changed from: private */
    public b B;
    private long C = 0;
    private long D = 0;
    private Param E;
    private com.airpay.paysdk.b F;
    private com.airpay.paysdk.qrcode.b G;
    private Runnable H = new Runnable() {
        public void run() {
            if (PaymentCodeActivity.this.q) {
                PaymentCodeActivity.this.s();
                b unused = PaymentCodeActivity.this.B = c.a().b(com.airpay.paysdk.base.different.a.a().f());
                b unused2 = PaymentCodeActivity.this.y = com.airpay.paysdk.core.a.a().a(PaymentCodeActivity.this.s, PaymentCodeActivity.this.r, PaymentCodeActivity.this.t, (com.airpay.paysdk.common.net.a.a.a<QRCodeGetInfo>) PaymentCodeActivity.this.J);
            }
        }
    };
    private j.b I = new j.b() {
        public void a(String str, String str2, Bitmap bitmap, boolean z) {
            if (str.equals(PaymentCodeActivity.this.o)) {
                if (!z) {
                    PaymentCodeActivity paymentCodeActivity = PaymentCodeActivity.this;
                    int unused = paymentCodeActivity.n = paymentCodeActivity.n & -3;
                    PaymentCodeActivity.this.f4391d.setImageBitmap(bitmap);
                } else {
                    PaymentCodeActivity paymentCodeActivity2 = PaymentCodeActivity.this;
                    int unused2 = paymentCodeActivity2.n = paymentCodeActivity2.n & -2;
                    PaymentCodeActivity.this.f4392e.setImageBitmap(bitmap);
                }
                if (PaymentCodeActivity.this.n == 0) {
                    PaymentCodeActivity.this.k.setLoadingOn(false);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public com.airpay.paysdk.common.net.a.a.a<QRCodeGetInfo> J = new com.airpay.paysdk.common.net.a.a.a<QRCodeGetInfo>() {
        public void a(QRCodeGetInfo qRCodeGetInfo) {
            com.airpay.paysdk.common.c.a.a().a(new Runnable(qRCodeGetInfo) {
                private final /* synthetic */ QRCodeGetInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PaymentCodeActivity.AnonymousClass3.this.b(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(QRCodeGetInfo qRCodeGetInfo) {
            com.airpay.paysdk.common.b.a.a("get qr code ---------success!" + qRCodeGetInfo.toString(), new Object[0]);
            com.airpay.paysdk.common.b.a.a(qRCodeGetInfo.toString(), new Object[0]);
            PaymentCodeActivity.this.v();
            PaymentCodeActivity.this.a(qRCodeGetInfo.f4363a, qRCodeGetInfo.f4364b);
            boolean unused = PaymentCodeActivity.this.s = qRCodeGetInfo.f4365c;
            String unused2 = PaymentCodeActivity.this.t = qRCodeGetInfo.f4367e == null ? "" : qRCodeGetInfo.f4367e;
            int unused3 = PaymentCodeActivity.this.r = qRCodeGetInfo.f4366d;
            if (PaymentCodeActivity.this.v != null) {
                PaymentCodeActivity.this.v.a(PaymentCodeActivity.this.s, PaymentCodeActivity.this.r, PaymentCodeActivity.this.t);
            }
        }

        public void a(int i, String str) {
            com.airpay.paysdk.common.c.a.a().a(new Runnable(i, str) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    PaymentCodeActivity.AnonymousClass3.this.b(this.f$1, this.f$2);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i, String str) {
            com.airpay.paysdk.common.b.a.a("get qr code  ---------error code ==" + i + "---- error message == " + str, new Object[0]);
            PaymentCodeActivity.this.w();
            com.airpay.paysdk.base.b.a.a().b((Context) PaymentCodeActivity.this, str);
        }
    };
    private com.airpay.paysdk.common.net.a.a.a<QRCodeTopupInfo> K = new com.airpay.paysdk.common.net.a.a.a<QRCodeTopupInfo>() {
        public void a(QRCodeTopupInfo qRCodeTopupInfo) {
            com.airpay.paysdk.common.c.a.a().a(new Runnable(qRCodeTopupInfo) {
                private final /* synthetic */ QRCodeTopupInfo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PaymentCodeActivity.AnonymousClass4.this.b(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(QRCodeTopupInfo qRCodeTopupInfo) {
            int unused = PaymentCodeActivity.this.u = qRCodeTopupInfo.f4368a;
            List unused2 = PaymentCodeActivity.this.w = qRCodeTopupInfo.f4369b;
            if (PaymentCodeActivity.this.v != null) {
                PaymentCodeActivity.this.v.a(qRCodeTopupInfo.f4368a, qRCodeTopupInfo.f4369b);
            }
        }

        public void a(int i, String str) {
            com.airpay.paysdk.common.c.a.a().a(new Runnable(i, str) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    PaymentCodeActivity.AnonymousClass4.this.b(this.f$1, this.f$2);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i, String str) {
            com.airpay.paysdk.common.b.a.a("get qr code topup  ---------error code ==" + i + "---- error message == " + str, new Object[0]);
            com.airpay.paysdk.base.b.a.a().b((Context) PaymentCodeActivity.this, str);
        }
    };
    private boolean L = true;
    private com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>> M = new com.airpay.paysdk.common.net.a.a.a<List<BankAccountFullInfo>>() {
        public void a(List<BankAccountFullInfo> list) {
            com.airpay.paysdk.common.c.a.a().a(new Runnable(list) {
                private final /* synthetic */ List f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PaymentCodeActivity.AnonymousClass5.this.b(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(List list) {
            PaymentCodeActivity.this.c();
            if (PaymentCodeActivity.this.v != null) {
                PaymentCodeActivity.this.v.a((List<BankAccountFullInfo>) list);
            }
        }

        public void a(int i, String str) {
            com.airpay.paysdk.common.c.a.a().a(new Runnable(str) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PaymentCodeActivity.AnonymousClass5.this.a(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            PaymentCodeActivity.this.c();
            com.airpay.paysdk.base.b.a.a().b((Context) PaymentCodeActivity.this, str);
        }
    };
    private long N = 0;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f4390c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f4391d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f4392e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f4393f;

    /* renamed from: g  reason: collision with root package name */
    private View f4394g;
    private TextView h;
    private ImageView i;
    private Animation j;
    /* access modifiers changed from: private */
    public BPLoadingLayout k;
    private View l;
    private View m;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public String o;
    private boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public String t;
    /* access modifiers changed from: private */
    public int u = -1;
    /* access modifiers changed from: private */
    public PaymentOptionView v;
    /* access modifiers changed from: private */
    public List<QRTopupInfo> w;
    private Runnable x = new Runnable() {
        public final void run() {
            PaymentCodeActivity.this.t();
        }
    };
    /* access modifiers changed from: private */
    public b y;
    private b z;

    private void o() {
    }

    private void p() {
    }

    private void h() {
        this.A = com.airpay.paysdk.qrcode.a.a().a(this.M);
        this.L = false;
    }

    private void i() {
        this.z = com.airpay.paysdk.core.a.a().a(this.K);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_airpay_payment_qr_code_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        l();
        m();
        n();
        u();
        i();
        o();
        this.G = com.airpay.paysdk.qrcode.b.a().a(this, this.F);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.q = true;
        if (this.L) {
            h();
        }
        long j2 = 0;
        if (this.D > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.D;
            long j3 = this.C;
            if (j3 > currentTimeMillis) {
                j2 = j3 - currentTimeMillis;
            }
            com.airpay.paysdk.common.c.a.a().a(this.H, j2);
            this.D = System.currentTimeMillis();
            this.C = j2;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.q = false;
        com.airpay.paysdk.common.c.a.a().b(this.H);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        j();
        p();
        com.airpay.paysdk.common.c.a.a().b(this.H);
        com.airpay.paysdk.common.c.a.a().b(this.x);
    }

    public void onBackPressed() {
        k();
        super.onBackPressed();
    }

    private void j() {
        b bVar = this.y;
        if (bVar != null) {
            bVar.a();
        }
        b bVar2 = this.z;
        if (bVar2 != null) {
            bVar2.a();
        }
        if (this.M != null) {
            this.A.a();
        }
        com.airpay.paysdk.qrcode.b bVar3 = this.G;
        if (bVar3 != null) {
            bVar3.b();
        }
        b bVar4 = this.B;
        if (bVar4 != null) {
            bVar4.a();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        com.airpay.paysdk.b bVar = this.F;
        if (bVar != null) {
            bVar.onResponse(PayResult.f4114b);
        }
        finish();
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        this.E = (Param) extras.getParcelable("param");
        this.F = o.a(extras);
    }

    private void m() {
        getWindow().addFlags(8192);
        e.a(this);
        g();
        setTitle(c.i.com_garena_beepay_label_pay_to_merchant);
        this.f3840a.setHomeAction(new View.OnClickListener() {
            public void onClick(View view) {
                PaymentCodeActivity.this.k();
            }
        });
    }

    private void n() {
        this.f4390c = BitmapFactory.decodeResource(getResources(), c.d.com_garena_beepay_ic_launcher);
        q();
        r();
        this.f4391d = (ImageView) findViewById(c.f.com_garena_beepay_img_barcode);
        this.f4391d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentCodeActivity.this.d(view);
            }
        });
        this.f4392e = (ImageView) findViewById(c.f.com_garena_beepay_img_qrcode);
        this.f4392e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentCodeActivity.this.c(view);
            }
        });
        this.f4393f = (TextView) findViewById(c.f.com_garena_beepay_tv_code_number);
        this.f4393f.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/gotham_book.otf"));
        this.k = (BPLoadingLayout) findViewById(c.f.com_garena_beepay_section_payment_codes);
        this.m = findViewById(c.f.com_garena_beepay_section_codes);
        this.l = findViewById(c.f.com_garena_beepay_empty_view);
        this.i = (ImageView) findViewById(c.f.com_garena_beepay_img_status);
        this.h = (TextView) findViewById(c.f.com_garena_beepay_tv_status);
        this.f4394g = findViewById(c.f.com_garena_beepay_section_status);
        this.f4394g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentCodeActivity.this.b(view);
            }
        });
        d.a(d(), c.f.com_garena_beepay_btn_refresh_code, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentCodeActivity.this.a(view);
            }
        });
        this.j = AnimationUtils.loadAnimation(this, c.a.com_garena_beepay_progress_anim);
        this.j.setDuration(1000);
        this.j.setInterpolator(new LinearInterpolator());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (!TextUtils.isEmpty(this.o)) {
            String str = this.o;
            TicketCodeViewActivity.a(this, Collections.singletonList(new TicketPin(str, str)), 0, false, view, false, true, this.F);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (!TextUtils.isEmpty(this.o)) {
            TicketCodeViewActivity.a(this, Collections.singletonList(new TicketPin((String) null, this.o)), 0, true, view, true, true, this.F);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        s();
        this.B = com.airpay.paysdk.base.b.c.a().b(com.airpay.paysdk.base.different.a.a().f());
        this.y = com.airpay.paysdk.core.a.a().a(this.s, this.r, this.t, this.J);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        u();
    }

    private void q() {
        this.f3840a.a((a.C0073a) new a.b() {
            public int b() {
                return 6;
            }

            public int a() {
                return c.d.com_garena_beepay_titlebar_icon_help_page;
            }

            public void a(View view) {
                PaymentCodeHelpActivity.a(PaymentCodeActivity.this);
            }
        });
    }

    private void r() {
        this.v = (PaymentOptionView) findViewById(c.f.qr_payment_option_layout);
        this.v.setOptionUpdateListener(new PaymentOptionView.a() {
            public void a(ArrayList<BPSimpleTopUpFullInfo> arrayList) {
            }

            public void a() {
                PaymentCodeActivity paymentCodeActivity = PaymentCodeActivity.this;
                boolean unused = paymentCodeActivity.s = !paymentCodeActivity.s;
                b unused2 = PaymentCodeActivity.this.B = com.airpay.paysdk.base.b.c.a().b(com.airpay.paysdk.base.different.a.a().f());
                b unused3 = PaymentCodeActivity.this.y = com.airpay.paysdk.core.a.a().a(PaymentCodeActivity.this.s, PaymentCodeActivity.this.r, PaymentCodeActivity.this.t, (com.airpay.paysdk.common.net.a.a.a<QRCodeGetInfo>) PaymentCodeActivity.this.J);
            }

            public void a(int i, String str) {
                int unused = PaymentCodeActivity.this.r = i;
                String unused2 = PaymentCodeActivity.this.t = str;
            }
        });
        this.v.a(this.s, this.r, this.t);
        this.v.a((List<BankAccountFullInfo>) null);
        this.v.a(this.u, this.w);
    }

    /* access modifiers changed from: private */
    public void s() {
        this.f4394g.setEnabled(false);
        this.h.setText(c.i.com_garena_beepay_label_updating);
        this.i.setImageResource(c.d.userpaymentqr_icon_refresh);
        this.i.setAnimation(this.j);
        com.airpay.paysdk.common.c.a.a().b(this.x);
    }

    /* access modifiers changed from: private */
    public void t() {
        this.f4394g.setEnabled(true);
        this.h.setText(c.i.com_garena_beepay_label_refresh);
        this.i.setImageResource(c.d.userpaymentqr_icon_refresh);
        this.i.clearAnimation();
        com.airpay.paysdk.common.c.a.a().b(this.x);
    }

    private void u() {
        this.p = false;
        this.k.setLoadingOn(true);
        this.B = com.airpay.paysdk.base.b.c.a().b(com.airpay.paysdk.base.different.a.a().f());
        this.y = com.airpay.paysdk.core.a.a().a(this.s, this.r, this.t, this.J);
    }

    /* access modifiers changed from: private */
    public void v() {
        if (this.p) {
            x();
            return;
        }
        this.p = true;
        this.l.setVisibility(8);
        this.v.setVisibility(0);
        this.m.setVisibility(0);
        t();
    }

    /* access modifiers changed from: private */
    public void w() {
        this.k.setLoadingOn(false);
        if (this.p) {
            t();
            return;
        }
        this.l.setVisibility(0);
        this.v.setVisibility(8);
        this.m.setVisibility(8);
    }

    private void x() {
        this.f4394g.setEnabled(false);
        this.h.setText(c.i.com_garena_beepay_label_updated);
        this.i.setImageResource(c.d.com_garena_beepay_payment_qr_code_loaded);
        this.i.clearAnimation();
        com.airpay.paysdk.common.c.a.a().b(this.x);
        com.airpay.paysdk.common.c.a.a().a(this.x, 2000);
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2) {
        this.C = System.currentTimeMillis() / 1000;
        this.o = str;
        long j2 = (((long) i2) - this.C) * 1000;
        if (j2 <= 0) {
            j2 = BaseConstants.DEFAULT_MSG_TIMEOUT;
        }
        com.airpay.paysdk.common.c.a a2 = com.airpay.paysdk.common.c.a.a();
        a2.b(this.H);
        a2.a(this.H, j2);
        this.C = j2;
        this.D = System.currentTimeMillis();
        this.f4393f.setText(b(this.o));
        this.n |= 2;
        j.a((Activity) this, this.o, false, this.I);
        this.n |= 1;
        j.a((Activity) this, this.o, this.f4390c, false, this.I);
    }

    private String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            int[] iArr = f4389b;
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (iArr[i3] == i2) {
                    sb.append(SQLBuilder.BLANK);
                    break;
                } else {
                    i3++;
                }
            }
            sb.append(str.charAt(i2));
        }
        return sb.toString();
    }
}
