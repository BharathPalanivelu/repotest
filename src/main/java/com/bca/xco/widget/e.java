package com.bca.xco.widget;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bca.xco.widget.comp.XEditText;
import com.bca.xco.widget.e.b;
import com.bca.xco.widget.h;
import com.litesuits.orm.db.assit.SQLBuilder;

public class e extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextView f5260a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f5261b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public XEditText f5262c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f5263d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f5264e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f5265f;

    /* renamed from: g  reason: collision with root package name */
    private String f5266g;

    public void a(d dVar) {
        this.f5263d = dVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getWindow().setSoftInputMode(48);
        View inflate = layoutInflater.inflate(h.e.xco_fragment_screen_edit, viewGroup, false);
        this.f5265f = inflate.getContext();
        this.f5264e = new b();
        this.f5260a = (TextView) inflate.findViewById(h.d.xco_textview_cardnumber);
        this.f5262c = (XEditText) inflate.findViewById(h.d.xco_input_daily_limit);
        XEditText xEditText = this.f5262c;
        xEditText.addTextChangedListener(new com.bca.xco.widget.b.b(xEditText));
        Resources resources = this.f5265f.getResources();
        b bVar = this.f5264e;
        Context context = this.f5265f;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bVar.a(context, (float) context.getResources().getDimensionPixelSize(h.b.xco_text_size_input), false));
        this.f5265f.getResources().getDrawable(h.c.xco_ic_cancel);
        this.f5262c.setCompoundDrawablesWithIntrinsicBounds(bitmapDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
        int compoundPaddingRight = this.f5262c.getCompoundPaddingRight();
        ImageView imageView = (ImageView) inflate.findViewById(h.d.xco_info_limit);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f5263d.h();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int i = compoundPaddingRight + 2;
        layoutParams.setMargins(0, 0, i, 0);
        imageView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f5260a.getLayoutParams();
        layoutParams2.setMargins(0, 0, i, 0);
        this.f5260a.setLayoutParams(layoutParams2);
        this.f5261b = (TextView) inflate.findViewById(h.d.text_bantuan);
        Spanned fromHtml = Html.fromHtml(inflate.getContext().getString(h.f.xco_help));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan a2 : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            a(spannableStringBuilder, a2);
        }
        this.f5261b.setText(spannableStringBuilder);
        this.f5261b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5261b.setLinkTextColor(this.f5265f.getResources().getColor(h.a.xco_normal));
        this.f5264e.a(this.f5261b);
        this.f5264e.a(this.f5260a);
        this.f5264e.b((EditText) this.f5262c);
        this.f5264e.c((EditText) this.f5262c);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                e.this.f5264e.a(e.this.f5265f);
                e.this.f5263d.a(e.this.f5260a.getText().toString(), e.this.f5262c.getText().toString(), 2);
                e.this.f5263d.b(5);
                e.this.f5263d.i();
            }
        }, spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    public void a() {
        try {
            if (b()) {
                String charSequence = this.f5260a.getText().toString();
                String obj = this.f5262c.getText().toString();
                this.f5263d.c(charSequence.replace(SQLBuilder.BLANK, ""), obj.replace(".", ""));
                this.f5264e.a(this.f5265f);
                this.f5263d.f();
            }
        } catch (NumberFormatException unused) {
            this.f5263d.c(this.f5265f.getString(h.f.xco_error_must_number));
        } catch (Exception unused2) {
            this.f5263d.a(this.f5265f.getString(h.f.xco_error_unknown));
        }
    }

    public boolean b() {
        String replace = this.f5262c.getText().toString().replace(".", "");
        if (this.f5264e.a((EditText) this.f5262c)) {
            this.f5263d.c(this.f5265f.getString(h.f.xco_err_limit_01));
            return false;
        } else if (this.f5264e.b(replace)) {
            this.f5263d.c(this.f5265f.getString(h.f.xco_err_parse_int));
            return false;
        } else if (Double.parseDouble(replace) <= 0.0d) {
            this.f5263d.c(this.f5265f.getString(h.f.xco_err_limit_02));
            return false;
        } else if (Double.parseDouble(replace) != Double.parseDouble(this.f5266g)) {
            return true;
        } else {
            this.f5263d.c(this.f5265f.getString(h.f.xco_err_limit_03));
            return false;
        }
    }

    public void a(String str, String str2) {
        this.f5260a.setText(str);
        this.f5262c.setText(str2);
        this.f5266g = str2;
    }

    public void a(String str) {
        this.f5260a.setText(str);
    }
}
