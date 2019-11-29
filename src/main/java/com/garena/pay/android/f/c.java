package com.garena.pay.android.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.d.a;
import com.garena.pay.android.c.b;
import com.garena.pay.android.c.f;
import com.garena.pay.android.f.b;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8266a = (!c.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private b f8267b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f8268c;

    /* renamed from: d  reason: collision with root package name */
    private List<e> f8269d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f8270e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f8271f;

    /* renamed from: g  reason: collision with root package name */
    private String f8272g = "";
    private int h = 0;

    public interface a {
        void a();

        void a(Object obj);
    }

    public c(Activity activity) {
        this.f8268c = activity;
    }

    public void a(String str, int i, String str2, Object obj) {
        e eVar = new e();
        eVar.f8277d = i;
        eVar.f8276c = str;
        eVar.f8280g = obj;
        eVar.f8279f = str2;
        this.f8269d.add(eVar);
    }

    public void a(String str, String str2, String str3, Object obj) {
        e eVar = new e();
        eVar.f8278e = str2;
        eVar.f8276c = str;
        eVar.f8280g = obj;
        eVar.f8279f = str3;
        this.f8269d.add(eVar);
    }

    public void a(e eVar) {
        this.f8269d.add(eVar);
    }

    public void a(a aVar) {
        this.f8270e = aVar;
    }

    public void a() {
        b.a((Context) this.f8268c);
        c();
    }

    public void a(int i) {
        this.h = i;
    }

    private void c() {
        g gVar;
        this.f8271f = (ViewGroup) this.f8268c.getLayoutInflater().inflate(a.e.picker_view, new LinearLayout(this.f8268c));
        if (f8266a || this.f8271f != null) {
            LinearLayout linearLayout = (LinearLayout) this.f8271f.findViewById(a.d.picker_item_list);
            TextView textView = (TextView) this.f8271f.findViewById(a.d.picker_header_text);
            textView.setVisibility(f.a(this.f8272g) ? 8 : 0);
            textView.setText(this.f8272g);
            this.f8271f.findViewById(a.d.btn_footer).setVisibility(this.h);
            for (e next : this.f8269d) {
                if (next instanceof d) {
                    gVar = new f(this.f8268c, this);
                } else {
                    gVar = new g(this.f8268c, this);
                }
                gVar.a(next);
                linearLayout.addView(gVar.a());
            }
            return;
        }
        throw new AssertionError();
    }

    public void a(View view) {
        this.f8267b = new b(this.f8271f, false, false);
        this.f8267b.a((b.a) new b.a() {
            public void a() {
                c.this.f8270e.a();
            }
        });
        this.f8267b.a(view);
    }

    public void a(boolean z) {
        b bVar = this.f8267b;
        if (bVar == null || !z) {
            b bVar2 = this.f8267b;
            if (bVar2 != null && !z) {
                bVar2.b();
                return;
            }
            return;
        }
        bVar.a();
    }

    public void a(String str) {
        this.f8272g = str;
    }

    public a b() {
        return this.f8270e;
    }
}
