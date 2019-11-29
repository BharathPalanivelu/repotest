package com.shopee.app.ui.maps;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.facebook.places.model.PlaceFields;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.c;
import com.garena.c.a.d;
import com.garena.c.a.h;
import com.garena.c.a.i;
import com.garena.c.a.j;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.application.ar;
import com.shopee.app.h.r;
import com.shopee.app.web.RenderProcessGoneHandlerClient;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class b extends a {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.garena.c.a.a f23190f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ListView f23191g;
    /* access modifiers changed from: private */
    public WebView h;
    /* access modifiers changed from: private */
    public a i;
    /* access modifiers changed from: private */
    public List<String> j = new ArrayList();
    /* access modifiers changed from: private */
    public ProgressBar k;
    private ImageButton l;
    private j m = new j() {
        public void a(Location location) {
            if (!b.this.f23189e) {
                b.this.b((float) location.getLongitude(), (float) location.getLatitude());
            }
        }

        public void a(int i) {
            com.garena.android.appkit.d.a.a("error code %d", Integer.valueOf(i));
            if (i != 4102) {
                switch (i) {
                }
            }
            r.a().b((int) R.string.sp_location_internal_error);
            b.this.k.setVisibility(8);
        }
    };

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.location_selection_compat_view;
    }

    public void b() {
    }

    public void c() {
    }

    public b(Context context) {
        super(context);
        f();
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        super.a(f2, f3);
        b(f3, f2);
    }

    private void f() {
        this.k = (ProgressBar) findViewById(R.id.progress);
        findViewById(R.id.location_close_window).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.e();
            }
        });
        findViewById(R.id.send_location).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.i();
            }
        });
        this.f23191g = (ListView) findViewById(R.id.list_address_result);
        this.l = (ImageButton) findViewById(R.id.locate_btn);
        this.l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b bVar = b.this;
                bVar.f23189e = false;
                bVar.h();
            }
        });
        this.h = new WebView(ar.a().getApplicationContext());
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, c.a().a(300)));
        this.h.getSettings().setJavaScriptEnabled(true);
        ((FrameLayout) this.l.getParent()).addView(this.h, 0);
        this.k.setVisibility(0);
        h();
        this.f23191g.setChoiceMode(1);
        this.i = new a();
        this.f23191g.setAdapter(this.i);
        this.f23191g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((CheckedTextView) view).setChecked(true);
                if (b.this.f23190f != null) {
                    b.this.f23190f.f7802d = (String) b.this.j.get(i);
                }
            }
        });
    }

    private void g() {
        this.h.setWebViewClient(new RenderProcessGoneHandlerClient() {
            public void onPageFinished(WebView webView, String str) {
                if (b.this.h != null) {
                    WebView e2 = b.this.h;
                    e2.loadUrl("javascript:centerAt(" + b.this.f23190f.f7799a + "," + b.this.f23190f.f7800b + SQLBuilder.PARENTHESES_RIGHT);
                }
            }
        });
        this.h.loadUrl("file:///android_asset/location.html");
    }

    public void d() {
        super.d();
        this.f23190f = null;
        WebView webView = this.h;
        if (webView != null) {
            webView.removeAllViews();
            this.h.destroy();
        }
        this.h = null;
        i.a().b(this.m);
    }

    /* access modifiers changed from: private */
    public void h() {
        i.a().a(false);
        i.a().b(false);
        i.a().a(this.m);
    }

    /* access modifiers changed from: private */
    public void b(float f2, float f3) {
        this.f23190f = new com.garena.c.a.a();
        com.garena.c.a.a aVar = this.f23190f;
        aVar.f7800b = f2;
        aVar.f7799a = f3;
        g();
        this.k.setVisibility(0);
        com.garena.android.appkit.d.a.e("location %f %f", Float.valueOf(this.f23190f.f7799a), Float.valueOf(this.f23190f.f7800b));
        com.garena.android.appkit.f.b.a().a(new C0361b(this.f23190f));
    }

    /* renamed from: com.shopee.app.ui.maps.b$b  reason: collision with other inner class name */
    private class C0361b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private com.garena.c.a.a f23200b;

        C0361b(com.garena.c.a.a aVar) {
            this.f23200b = aVar;
        }

        public void run() {
            final List<d.a> a2 = h.a(this.f23200b);
            if (b.this.j != null) {
                f.a().a(new Runnable() {
                    public void run() {
                        if (a2 != null && b.this.f23191g != null) {
                            b.this.k.setVisibility(8);
                            if (b.this.f23190f != null) {
                                b.this.f23190f.f7802d = ((d.a) a2.get(0)).f7813a;
                                b.this.j.clear();
                                for (d.a aVar : a2) {
                                    b.this.j.add(aVar.f7813a);
                                }
                                b.this.i.notifyDataSetChanged();
                                b.this.f23191g.setSelection(0);
                            }
                        }
                    }
                });
            }
        }
    }

    private class a extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        private a() {
        }

        public int getCount() {
            if (b.this.j == null) {
                return 0;
            }
            return b.this.j.size();
        }

        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView;
            if (view == null) {
                checkedTextView = new CheckedTextView(b.this.getContext());
                checkedTextView.setMinHeight(c.a().a(50));
                checkedTextView.setGravity(16);
                checkedTextView.setCheckMarkDrawable((Drawable) null);
                checkedTextView.setTextAppearance(b.this.getContext(), R.style.whisper_text_light);
                checkedTextView.setBackgroundResource(R.drawable.address_item_bg_style);
                checkedTextView.setPadding(10, 0, 10, 0);
            } else {
                checkedTextView = (CheckedTextView) view;
            }
            checkedTextView.setText((CharSequence) b.this.j.get(i));
            return checkedTextView;
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        com.garena.c.a.a aVar = this.f23190f;
        if (aVar == null) {
            r.a().a((int) R.string.sp_label_locate_position);
        } else if (!TextUtils.isEmpty(aVar.f7802d)) {
            Intent intent = new Intent();
            intent.putExtra(PlaceFields.LOCATION, this.f23190f.b());
            getActivity().setResult(-1, intent);
            e();
        }
    }
}
