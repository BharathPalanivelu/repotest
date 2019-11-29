package com.bca.xco.widget;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bca.xco.widget.comp.XTextView;
import com.bca.xco.widget.h;

public class f extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public d f5277a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f5278b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f5279c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ProgressDialog f5280d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f5281e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f5282f;

    /* renamed from: g  reason: collision with root package name */
    private String f5283g;

    public void a(d dVar) {
        this.f5277a = dVar;
    }

    public void a(String str, String str2, int i) {
        this.f5282f = str;
        this.f5283g = str2;
        this.f5281e = i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getWindow().setSoftInputMode(48);
        View inflate = layoutInflater.inflate(h.e.xco_fragment_screen_help, viewGroup, false);
        this.f5278b = inflate.getContext();
        ((XTextView) inflate.findViewById(h.d.xco_title)).a(this.f5278b, 1);
        ((ImageView) inflate.findViewById(h.d.xco_ic_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    f.this.getFragmentManager().popBackStack();
                    f.this.f5277a.j();
                    f.this.f5277a.a(true);
                    new a().execute(new Void[0]);
                } catch (Exception unused) {
                    f.this.f5277a.a(f.this.f5278b.getString(h.f.xco_error_unknown));
                }
            }
        });
        this.f5279c = (WebView) inflate.findViewById(h.d.xco_webview);
        this.f5279c.getSettings().setJavaScriptEnabled(true);
        this.f5279c.setScrollBarStyle(33554432);
        this.f5280d = ProgressDialog.show(this.f5278b, "BCA", "Loading...");
        this.f5279c.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Log.i("TAG", "Processing webview url click...");
                webView.loadUrl(str);
                return true;
            }

            public void onPageFinished(WebView webView, String str) {
                Log.i("TAG", "Finished loading URL: " + str);
                if (f.this.f5280d.isShowing()) {
                    f.this.f5280d.dismiss();
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Log.e("TAG", "Error: " + str);
                f.this.f5277a.c("Error loading page");
            }
        });
        this.f5279c.loadUrl("https://www.bca.co.id/oneklik/tc?type=mobile_apps");
        return inflate;
    }

    private class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private ProgressDialog f5287b;

        private a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f5287b = new ProgressDialog(f.this.f5278b);
            this.f5287b.setMessage(f.this.f5278b.getString(h.f.xco_please_wait));
            this.f5287b.setCancelable(false);
            this.f5287b.show();
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
            if (f.this.f5281e == 2) {
                f.this.f5277a.setToScreenFragmentTextCredentialNumber(f.this.f5282f);
            }
            if (this.f5287b.isShowing()) {
                this.f5287b.dismiss();
            }
        }
    }
}
