package com.bca.xco.widget;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bca.xco.widget.a.c;
import com.bca.xco.widget.comp.XSpinner;
import com.bca.xco.widget.e.b;
import com.bca.xco.widget.h;
import java.util.List;

public class g extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public EditText f5288a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CheckBox f5289b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f5290c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5291d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f5292e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f5293f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public XSpinner f5294g;
    private Button h;
    /* access modifiers changed from: private */
    public c i;
    /* access modifiers changed from: private */
    public List<c> j;
    /* access modifiers changed from: private */
    public int k = 0;
    /* access modifiers changed from: private */
    public d l;
    /* access modifiers changed from: private */
    public ArrayAdapter<String> m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public b o;
    /* access modifiers changed from: private */
    public Context p;

    public void a(d dVar) {
        this.l = dVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(48);
        View inflate = layoutInflater.inflate(h.e.xco_fragment_screen_phone, viewGroup, false);
        this.p = inflate.getContext();
        this.i = new c();
        this.o = new b();
        this.f5294g = (XSpinner) inflate.findViewById(h.d.xco_list_phone);
        this.m = new ArrayAdapter<String>(this.p, 17367049) {
            public View getDropDownView(int i, View view, ViewGroup viewGroup) {
                View dropDownView = super.getDropDownView(i, view, viewGroup);
                TextView textView = (TextView) dropDownView.findViewById(16908308);
                if (i == getCount()) {
                    textView.setText("");
                    textView.setHint((CharSequence) getItem(getCount()));
                }
                g.this.o.a(textView);
                g.this.o.a(textView, (float) g.this.p.getResources().getDimensionPixelSize(h.b.xco_text_size_input));
                return dropDownView;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                TextView textView = (TextView) view2.findViewById(16908308);
                if (i == getCount()) {
                    textView.setText("");
                    textView.setHint((CharSequence) getItem(getCount()));
                }
                g.this.o.a(textView);
                g.this.o.a(textView, (float) g.this.p.getResources().getDimensionPixelSize(h.b.xco_text_size_input));
                return view2;
            }

            public int getCount() {
                return super.getCount() - 1;
            }
        };
        this.m.setDropDownViewResource(17367049);
        this.m.add(inflate.getContext().getString(h.f.xco_listphone_prompt));
        this.m.add(inflate.getContext().getString(h.f.xco_listphone_prompt));
        this.f5294g.setAdapter(this.m);
        this.f5294g.setSelection(this.m.getCount());
        this.f5294g.setOnItemSelectedEvenIfUnchangedListener(new AdapterView.OnItemSelectedListener() {
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public boolean f5297b = true;

            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (!(g.this.f5294g.getSelectedItem() + "").equals(g.this.p.getString(h.f.xco_listphone_prompt))) {
                    final com.bca.xco.widget.comp.b bVar = new com.bca.xco.widget.comp.b(g.this.p);
                    final c cVar = (c) g.this.j.get(i);
                    bVar.a(cVar);
                    bVar.show();
                    ((Button) bVar.findViewById(h.d.xco_button_ok)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            boolean unused = AnonymousClass2.this.f5297b = false;
                            c unused2 = g.this.i = cVar;
                            g.this.l.b(g.this.i.a(), g.this.i.b());
                            g.this.l.e();
                            bVar.dismiss();
                        }
                    });
                    ((Button) bVar.findViewById(h.d.xco_button_cancel)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (AnonymousClass2.this.f5297b) {
                                g.this.f5294g.setSelection(g.this.m.getCount(), true);
                            } else {
                                g.this.f5294g.setSelection(g.this.m.getPosition(g.this.i.b()), true);
                            }
                            bVar.dismiss();
                        }
                    });
                }
            }
        });
        this.f5292e = (TextView) inflate.findViewById(h.d.xco_label_otp);
        this.f5293f = (ImageView) inflate.findViewById(h.d.xco_img_otp);
        this.f5289b = (CheckBox) inflate.findViewById(h.d.xco_checkbox_agreement);
        this.f5290c = (TextView) inflate.findViewById(h.d.xco_text_agreement);
        Spanned fromHtml = Html.fromHtml(inflate.getContext().getString(h.f.xco_agreement));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan a2 : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            a(spannableStringBuilder, a2);
        }
        this.f5290c.setText(spannableStringBuilder);
        this.f5290c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5290c.setLinkTextColor(this.p.getResources().getColor(h.a.xco_link_html));
        this.f5290c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (g.this.f5289b.isEnabled()) {
                    g.this.f5289b.setChecked(!g.this.f5289b.isChecked());
                }
            }
        });
        this.f5288a = (EditText) inflate.findViewById(h.d.xco_input_otp);
        this.f5291d = (TextView) inflate.findViewById(h.d.xco_textview_otp);
        this.f5291d.setVisibility(4);
        this.h = (Button) inflate.findViewById(h.d.xco_button_send_otp);
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                g.this.o.a(g.this.p);
                g.this.l.b(g.this.i.a(), g.this.i.b());
                g.this.l.e();
            }
        });
        a(false);
        this.o.a(this.f5292e);
        this.o.a(this.f5290c);
        this.o.b(this.f5288a);
        this.o.a(this.f5291d);
        this.o.a(this.h);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                g.this.o.a(g.this.p);
                g.this.l.i();
                g.this.l.b(4);
                d f2 = g.this.l;
                List d2 = g.this.j;
                c e2 = g.this.i;
                int i = g.this.k;
                f2.a((List<c>) d2, e2, i, g.this.f5288a.getText() + "", g.this.f5289b.isChecked(), g.this.n);
            }
        }, spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    public void a(boolean z) {
        this.n = z;
        this.f5288a.setEnabled(z);
        this.h.setEnabled(z);
        this.f5289b.setEnabled(z);
        this.f5292e.setEnabled(z);
        this.f5293f.setEnabled(z);
        this.l.j();
        if (!z) {
            this.f5290c.setTextColor(this.p.getResources().getColor(h.a.xco_text_inactive));
            this.f5288a.setTextColor(this.p.getResources().getColor(h.a.xco_text_inactive));
            this.f5292e.setTextColor(this.p.getResources().getColor(h.a.xco_text_inactive));
            this.f5293f.setImageDrawable(this.p.getResources().getDrawable(h.c.xco_ic_otp_na));
            this.h.setBackgroundResource(h.c.xco_button_rounded_disable);
            return;
        }
        this.f5290c.setTextColor(this.p.getResources().getColor(h.a.xco_text_active));
        this.f5288a.setTextColor(this.p.getResources().getColor(h.a.xco_text_active));
        this.f5292e.setTextColor(this.p.getResources().getColor(h.a.xco_text_active));
        this.f5293f.setImageDrawable(this.p.getResources().getDrawable(h.c.xco_ic_otp));
        this.h.setBackgroundResource(h.c.xco_button_rounded_positive);
    }

    public void a() {
        this.k++;
        this.f5291d.setText(this.p.getString(h.f.xco_permintaan_otp) + this.k);
        this.f5291d.setVisibility(0);
    }

    public boolean b() {
        if ((this.f5294g.getSelectedItem() + "").equals(this.p.getString(h.f.xco_listphone_prompt))) {
            this.l.c(this.p.getString(h.f.xco_err_ponsel_01));
            return false;
        } else if (this.o.a(this.f5288a)) {
            this.l.c(this.p.getString(h.f.xco_err_otp_01));
            return false;
        } else if (this.f5288a.getText().length() < 6) {
            this.l.c(this.p.getString(h.f.xco_err_otp_03));
            return false;
        } else if (!this.f5289b.isChecked()) {
            this.l.c(this.p.getString(h.f.xco_err_syarat_01));
            return false;
        } else {
            this.l.setDataOTP(this.f5288a.getText().toString());
            this.o.a(this.p);
            return true;
        }
    }

    public void a(List<c> list) {
        this.j = list;
        this.m.clear();
        for (c b2 : this.j) {
            this.m.add(b2.b());
        }
        this.m.add(this.p.getString(h.f.xco_listphone_prompt));
        this.f5294g.setAdapter(this.m);
        this.f5294g.setSelection(this.m.getCount(), true);
    }

    public void a(List<c> list, c cVar, int i2, String str, boolean z, boolean z2) {
        this.i = cVar;
        this.j = list;
        this.m.clear();
        int i3 = -1;
        for (int i4 = 0; i4 < this.j.size(); i4++) {
            c cVar2 = this.j.get(i4);
            this.m.add(cVar2.b());
            if (cVar.a().equals(cVar2.a())) {
                i3 = i4;
            }
        }
        this.m.add(this.p.getString(h.f.xco_listphone_prompt));
        this.f5294g.setAdapter(this.m);
        if (i3 == -1) {
            i3 = this.m.getCount();
        }
        this.f5294g.setSelection(i3, true);
        this.k = i2;
        if (i2 == 0) {
            this.f5291d.setVisibility(4);
        } else {
            TextView textView = this.f5291d;
            textView.setText(this.p.getString(h.f.xco_permintaan_otp) + this.k);
            this.f5291d.setVisibility(0);
        }
        a(z2);
        this.f5288a.setText(str);
        this.f5289b.setChecked(z);
    }
}
