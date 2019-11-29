package com.bca.xco.widget;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bca.xco.widget.a.c;
import com.bca.xco.widget.comp.XTextView;
import com.bca.xco.widget.h;
import java.util.List;

public class k extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public d f5353a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f5354b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<c> f5355c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f5356d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f5357e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f5358f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f5359g;
    /* access modifiers changed from: private */
    public boolean h;
    private WebView i;
    /* access modifiers changed from: private */
    public ProgressDialog j;

    public void a(List<c> list, c cVar, int i2, String str, boolean z, boolean z2) {
        this.f5355c = list;
        this.f5356d = cVar;
        this.f5357e = i2;
        this.f5358f = str;
        this.f5359g = z;
        this.h = z2;
    }

    public void a(d dVar) {
        this.f5353a = dVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getWindow().setSoftInputMode(48);
        View inflate = layoutInflater.inflate(h.e.xco_fragment_screen_term_condition, viewGroup, false);
        this.f5354b = inflate.getContext();
        ((XTextView) inflate.findViewById(h.d.xco_title)).a(this.f5354b, 1);
        ((ImageView) inflate.findViewById(h.d.xco_ic_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    k.this.f5353a.b(3);
                    new a().execute(new Void[0]);
                } catch (Exception unused) {
                    k.this.f5353a.a(k.this.f5354b.getString(h.f.xco_error_unknown));
                }
            }
        });
        inflate.setFocusableInTouchMode(true);
        inflate.requestFocus();
        inflate.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && i == 4) {
                    try {
                        k.this.f5353a.b(3);
                        new a().execute(new Void[0]);
                    } catch (Exception unused) {
                        k.this.f5353a.a(k.this.f5354b.getString(h.f.xco_error_unknown));
                    }
                }
                return false;
            }
        });
        this.i = (WebView) inflate.findViewById(h.d.xco_webview);
        this.i.getSettings().setJavaScriptEnabled(true);
        this.i.setScrollBarStyle(33554432);
        this.j = ProgressDialog.show(this.f5354b, "BCA", "Loading...");
        this.i.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }

            public void onPageFinished(WebView webView, String str) {
                if (k.this.j.isShowing()) {
                    k.this.j.dismiss();
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                k.this.f5353a.c("Error loading page");
            }
        });
        this.i.loadUrl("https://www.bca.co.id/oneklik/tc?type=mobile_apps");
        return inflate;
    }

    private class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private ProgressDialog f5364b;

        private a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5364b = new ProgressDialog(k.this.f5354b);
            this.f5364b.setMessage(k.this.f5354b.getString(h.f.xco_please_wait));
            this.f5364b.setCancelable(false);
            this.f5364b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
            }
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            k.this.f5353a.b(k.this.f5355c, k.this.f5356d, k.this.f5357e, k.this.f5358f, k.this.f5359g, k.this.h);
            if (this.f5364b.isShowing()) {
                this.f5364b.dismiss();
            }
        }
    }
}
