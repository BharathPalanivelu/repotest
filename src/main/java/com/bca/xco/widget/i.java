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
import com.bca.xco.widget.b.a;
import com.bca.xco.widget.comp.XEditText;
import com.bca.xco.widget.e.b;
import com.bca.xco.widget.h;
import com.litesuits.orm.db.assit.SQLBuilder;

public class i extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private TextView f5306a;

    /* renamed from: b  reason: collision with root package name */
    private XEditText f5307b;

    /* renamed from: c  reason: collision with root package name */
    private XEditText f5308c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f5309d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f5310e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f5311f;

    public void a(d dVar) {
        this.f5309d = dVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getWindow().setSoftInputMode(48);
        getActivity().getWindow().setSoftInputMode(48);
        View inflate = layoutInflater.inflate(h.e.xco_fragment_screen_registrasi, viewGroup, false);
        this.f5311f = inflate.getContext();
        this.f5310e = new b();
        this.f5307b = (XEditText) inflate.findViewById(h.d.xco_input_card_number);
        XEditText xEditText = this.f5307b;
        xEditText.addTextChangedListener(new a(xEditText));
        this.f5308c = (XEditText) inflate.findViewById(h.d.xco_input_daily_limit);
        XEditText xEditText2 = this.f5308c;
        xEditText2.addTextChangedListener(new com.bca.xco.widget.b.b(xEditText2));
        Resources resources = getResources();
        b bVar = this.f5310e;
        Context context = this.f5311f;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bVar.a(context, (float) context.getResources().getDimensionPixelSize(h.b.xco_text_size_input), false));
        this.f5311f.getResources().getDrawable(h.c.xco_ic_cancel);
        this.f5308c.setCompoundDrawablesWithIntrinsicBounds(bitmapDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
        int compoundPaddingRight = this.f5308c.getCompoundPaddingRight();
        ImageView imageView = (ImageView) inflate.findViewById(h.d.xco_info_limit);
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                i.this.f5309d.h();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, 0, compoundPaddingRight + 2, 0);
        imageView.setLayoutParams(layoutParams);
        this.f5306a = (TextView) inflate.findViewById(h.d.xco_text_help);
        Spanned fromHtml = Html.fromHtml(inflate.getContext().getString(h.f.xco_help));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
        for (URLSpan a2 : (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class)) {
            a(spannableStringBuilder, a2);
        }
        this.f5306a.setText(spannableStringBuilder);
        this.f5306a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5306a.setLinkTextColor(this.f5311f.getResources().getColor(h.a.xco_normal));
        this.f5310e.b((EditText) this.f5307b);
        this.f5310e.b((EditText) this.f5308c);
        this.f5310e.a(this.f5306a);
        this.f5310e.c((EditText) this.f5307b);
        this.f5310e.c((EditText) this.f5308c);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                i.this.f5310e.a(i.this.f5311f);
                i.this.f5309d.b(5);
                i.this.f5309d.i();
            }
        }, spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    public void a() {
        try {
            if (b()) {
                String obj = this.f5307b.getText().toString();
                String obj2 = this.f5308c.getText().toString();
                this.f5309d.c(obj.replace(SQLBuilder.BLANK, ""), obj2.replace(".", ""));
                this.f5310e.a(this.f5311f);
                this.f5309d.g();
            }
        } catch (NumberFormatException unused) {
            this.f5309d.c(this.f5311f.getString(h.f.xco_error_must_number));
        } catch (Exception unused2) {
            this.f5309d.a(this.f5311f.getString(h.f.xco_error_unknown));
        }
    }

    public boolean b() {
        this.f5307b.getText().toString();
        String replace = this.f5308c.getText().toString().replace(".", "");
        if (this.f5310e.a((EditText) this.f5307b)) {
            this.f5309d.c(this.f5311f.getString(h.f.xco_err_card_01));
            return false;
        } else if (this.f5307b.getText().length() < 19) {
            this.f5309d.c(this.f5311f.getString(h.f.xco_err_card_01));
            return false;
        } else if (this.f5310e.a((EditText) this.f5308c)) {
            this.f5309d.c(this.f5311f.getString(h.f.xco_err_limit_01));
            return false;
        } else if (this.f5310e.b(replace)) {
            this.f5309d.c(this.f5311f.getString(h.f.xco_error_must_number));
            return false;
        } else if (Double.parseDouble(replace) > 0.0d) {
            return true;
        } else {
            this.f5309d.c(this.f5311f.getString(h.f.xco_err_limit_02));
            return false;
        }
    }
}
