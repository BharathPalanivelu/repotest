package com.bca.xco.widget;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bca.xco.widget.a.a;
import com.bca.xco.widget.a.b;
import com.bca.xco.widget.e.c;
import com.bca.xco.widget.e.f;
import com.bca.xco.widget.h;
import com.bca.xco.widget.j;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.security.ProviderInstaller;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.List;

class d extends LinearLayout implements ProviderInstaller.ProviderInstallListener {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f4719a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f4720b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4721c;

    /* renamed from: d  reason: collision with root package name */
    private j f4722d;

    /* renamed from: e  reason: collision with root package name */
    private View f4723e;

    /* renamed from: f  reason: collision with root package name */
    private String f4724f = "DEV";

    /* renamed from: g  reason: collision with root package name */
    private a f4725g;
    private b h;
    private com.bca.xco.widget.e.b i;
    /* access modifiers changed from: private */
    public i j;
    /* access modifiers changed from: private */
    public e k;
    private g l;
    private k m;
    private f n;
    private int o = 0;

    /* access modifiers changed from: private */
    public void o() {
    }

    public d(Context context, String str) {
        super(context);
        this.f4719a = LayoutInflater.from(context);
        this.f4721c = context;
        this.f4724f = str;
        m();
    }

    private void m() {
        ProviderInstaller.installIfNeededAsync(this.f4721c, this);
        this.i = new com.bca.xco.widget.e.b();
        this.i.a(this.f4721c, "in");
        this.f4725g = new a();
        this.h = new b();
        c.a("Current Env", this.f4724f + "");
        this.f4722d = new j(this.f4721c, this, this.f4724f);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f4723e = this.f4719a.inflate(h.e.xco_main_layout, this, true);
        this.f4725g.d(new f().a(this.f4721c, "||", 1, 1, true));
        c.a("Finger Print", this.f4725g.e());
        this.m = new k();
        this.n = new f();
        j();
    }

    public void setListener(c cVar) {
        this.f4720b = cVar;
        this.f4722d.a(cVar);
    }

    public void b(int i2) {
        this.o = i2;
        FragmentTransaction beginTransaction = ((Activity) this.f4721c).getFragmentManager().beginTransaction();
        if (i2 == 1) {
            this.j = new i();
            this.j.a(this);
            beginTransaction.replace(h.d.frame_layout, this.j);
            beginTransaction.commit();
            a(true);
        } else if (i2 == 2) {
            this.k = new e();
            this.k.a(this);
            beginTransaction.replace(h.d.frame_layout, this.k);
            beginTransaction.commit();
            a(true);
        } else if (i2 == 3) {
            this.l = new g();
            this.l.a(this);
            beginTransaction.replace(h.d.frame_layout, this.l);
            beginTransaction.commit();
            a(true);
        } else if (i2 == 4) {
            this.m.a(this);
            beginTransaction.replace(h.d.frame_layout, this.m);
            beginTransaction.addToBackStack((String) null);
            beginTransaction.commit();
            a(false);
        } else if (i2 == 5) {
            this.n.a(this);
            beginTransaction.replace(h.d.frame_layout, this.n);
            beginTransaction.addToBackStack((String) null);
            beginTransaction.commit();
            a(false);
        }
    }

    public void a(boolean z) {
        ImageView imageView = (ImageView) findViewById(h.d.xco_imagelogo);
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    private void f(String str) {
        Button button = (Button) findViewById(h.d.xco_submit);
        new com.bca.xco.widget.e.b().b(button);
        button.setText(h.f.xco_button_next);
        if (str.equals("REGISTRATION")) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (d.this.n()) {
                        d.this.j.a();
                    } else {
                        d.this.c();
                    }
                }
            });
        } else if (str.equals("UPDATE")) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (d.this.n()) {
                        d.this.k.a();
                    } else {
                        d.this.b();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean n() {
        return this.o != 3;
    }

    public void a(int i2) {
        Button button = (Button) findViewById(h.d.xco_submit);
        if (i2 == 1) {
            button.setText(h.f.xco_button_submit_registration);
        } else if (i2 == 2) {
            button.setText(h.f.xco_button_submit_edit);
        }
    }

    private void a(Boolean bool) {
        Button button = (Button) findViewById(h.d.xco_submit);
        if (bool.booleanValue()) {
            button.setBackgroundResource(h.c.xco_button_disable);
            button.setEnabled(false);
            return;
        }
        button.setBackgroundResource(h.c.xco_button_submit);
        button.setEnabled(true);
    }

    public void l() {
        a((Boolean) false);
    }

    public void k() {
        a((Boolean) true);
    }

    private void c(int i2) {
        ((Button) findViewById(h.d.xco_submit)).setVisibility(i2);
    }

    public void j() {
        c(0);
    }

    public void i() {
        c(8);
    }

    public void h() {
        j jVar = this.f4722d;
        jVar.getClass();
        j.b bVar = new j.b(this.f4725g, this.h);
        bVar.execute(new Void[0]);
        a((AsyncTask) bVar);
    }

    public void g() {
        j jVar = this.f4722d;
        jVar.getClass();
        j.d dVar = new j.d(this.f4725g, this.h);
        dVar.execute(new Void[0]);
        a((AsyncTask) dVar);
    }

    public void f() {
        j jVar = this.f4722d;
        jVar.getClass();
        j.h hVar = new j.h(this.f4725g, this.h);
        hVar.execute(new Void[0]);
        a((AsyncTask) hVar);
    }

    public void e() {
        j jVar = this.f4722d;
        jVar.getClass();
        j.c cVar = new j.c(this.f4725g, this.h);
        cVar.execute(new Void[0]);
        a((AsyncTask) cVar);
    }

    public void d() {
        j jVar = this.f4722d;
        jVar.getClass();
        j.a aVar = new j.a(this.f4725g, this.h);
        aVar.execute(new Void[0]);
        a((AsyncTask) aVar);
    }

    public void c() {
        if (this.l.b()) {
            j jVar = this.f4722d;
            jVar.getClass();
            j.f fVar = new j.f(this.f4725g, this.h);
            fVar.execute(new Void[0]);
            a((AsyncTask) fVar);
        }
    }

    public void b() {
        if (this.l.b()) {
            j jVar = this.f4722d;
            jVar.getClass();
            j.g gVar = new j.g(this.f4725g, this.h);
            gVar.execute(new Void[0]);
            a((AsyncTask) gVar);
        }
    }

    private void a(final AsyncTask asyncTask) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (asyncTask.getStatus() == AsyncTask.Status.RUNNING) {
                    asyncTask.cancel(true);
                }
            }
        }, (long) Integer.valueOf(this.f4721c.getString(h.f.xco_timeout_maxprogress)).intValue());
    }

    public void c(String str, String str2) {
        this.h.b("DC");
        this.h.c(str);
        this.h.d(str2);
    }

    public void b(String str, String str2) {
        this.h.j(str);
        this.h.k(str2);
    }

    public void setDataOTP(String str) {
        this.h.g(str);
    }

    public void setOTPFieldEnabled(boolean z) {
        this.l.a(z);
    }

    public void a() {
        this.l.a();
    }

    public void setListPhone(List<com.bca.xco.widget.a.c> list) {
        this.l.a(list);
    }

    public void b(List<com.bca.xco.widget.a.c> list, com.bca.xco.widget.a.c cVar, int i2, String str, boolean z, boolean z2) {
        this.l.a(list, cVar, i2, str, z, z2);
    }

    public void a(List<com.bca.xco.widget.a.c> list, com.bca.xco.widget.a.c cVar, int i2, String str, boolean z, boolean z2) {
        this.m.a(list, cVar, i2, str, z, z2);
    }

    public void a(String str, String str2, int i2) {
        this.n.a(str, str2, i2);
    }

    public void setToScreenFragmentTextCredentialNumber(String str) {
        this.k.a(str);
    }

    public void a(String str, String str2) {
        this.k.a(str, str2);
    }

    /* access modifiers changed from: protected */
    public void setTransactionType(String str) {
        this.h.i(str);
    }

    /* access modifiers changed from: protected */
    public void setType(String str) {
        this.h.a(str);
        if (str.equals("REGISTRATION")) {
            b(1);
        } else if (str.equals("UPDATE")) {
            b(2);
        } else {
            b(1);
        }
        f(str);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        this.f4722d.a(this.f4720b);
        this.f4725g.a(str);
        this.f4725g.b(HttpConstants.ContentType.JSON);
        this.f4725g.c(str2);
        this.f4725g.e(str3);
        this.h.e(str4);
        this.h.f(str5);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f4722d.a(this.f4720b);
        this.f4725g.a(str);
        this.f4725g.b(HttpConstants.ContentType.JSON);
        this.f4725g.c(str2);
        this.f4725g.e(str3);
        this.h.e(str4);
        this.h.f(str5);
        this.h.h(str6);
        d();
    }

    public void e(String str) {
        final com.bca.xco.widget.comp.a aVar = new com.bca.xco.widget.comp.a(this.f4721c);
        aVar.a(str);
        aVar.show();
        ((Button) aVar.findViewById(h.d.xco_button_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                aVar.dismiss();
                d.this.f4720b.a("Token Expired");
            }
        });
    }

    public void a(String str, String str2, String str3, final String str4) {
        final com.bca.xco.widget.comp.a aVar = new com.bca.xco.widget.comp.a(this.f4721c);
        aVar.a(this.i.a(this.f4721c, str2, str3));
        aVar.show();
        ((Button) aVar.findViewById(h.d.xco_button_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                aVar.dismiss();
                d.this.f4720b.b(str4);
            }
        });
    }

    public void b(String str, String str2, String str3) {
        final com.bca.xco.widget.comp.a aVar = new com.bca.xco.widget.comp.a(this.f4721c);
        aVar.a(this.i.a(this.f4721c, str2, str3));
        aVar.show();
        ((Button) aVar.findViewById(h.d.xco_button_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                aVar.dismiss();
                d.this.f4720b.a();
            }
        });
    }

    public void d(String str) {
        final com.bca.xco.widget.comp.a aVar = new com.bca.xco.widget.comp.a(this.f4721c);
        aVar.a(str);
        aVar.show();
        ((Button) aVar.findViewById(h.d.xco_button_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                aVar.dismiss();
                d.this.f4720b.a();
            }
        });
    }

    public void a(String str, String str2, String str3) {
        com.bca.xco.widget.comp.a aVar = new com.bca.xco.widget.comp.a(this.f4721c);
        aVar.a(this.i.a(this.f4721c, str2, str3));
        aVar.show();
    }

    public void c(String str) {
        com.bca.xco.widget.comp.a aVar = new com.bca.xco.widget.comp.a(this.f4721c);
        aVar.a(str);
        aVar.show();
    }

    public void b(String str) {
        com.bca.xco.widget.comp.a aVar = new com.bca.xco.widget.comp.a(this.f4721c);
        aVar.b(str);
        aVar.a(0);
        aVar.show();
    }

    public void a(String str) {
        new com.bca.xco.widget.e.a(this.f4721c).a(str);
    }

    public void setResponseCredentialDetails(b bVar) {
        this.h.h(bVar.g());
        this.h.d(bVar.c());
        this.h.b(bVar.a());
        this.h.c(bVar.b());
    }

    public void setResponseCredentialRequestRegistration(b bVar) {
        this.h.h(bVar.g());
        this.h.d(bVar.c());
        this.h.b(bVar.a());
        this.h.c(bVar.b());
        this.h.f(bVar.e());
        this.h.e(bVar.d());
        this.h.a(bVar.h());
    }

    public void setResponseCredentialOTPRegistration(b bVar) {
        this.h.i(bVar.i());
        this.h.h(bVar.g());
        this.h.f(bVar.e());
        this.h.j(bVar.j());
    }

    public void onProviderInstalled() {
        this.f4722d = new j(this.f4721c, this, this.f4724f);
        this.f4722d.a(this.f4720b);
    }

    public void onProviderInstallFailed(int i2, Intent intent) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (instance.isUserResolvableError(i2)) {
            Context context = this.f4721c;
            if (context instanceof Activity) {
                instance.showErrorDialogFragment((Activity) context, i2, 1, new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        d.this.o();
                    }
                });
                return;
            }
            return;
        }
        o();
    }
}
