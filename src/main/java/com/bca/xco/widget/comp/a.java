package com.bca.xco.widget.comp;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bca.xco.widget.e.b;
import com.bca.xco.widget.h;

public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f4712a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4713b;

    /* renamed from: c  reason: collision with root package name */
    private b f4714c;

    public a(Context context) {
        super(context);
        this.f4712a = LayoutInflater.from(context);
        a(context, true);
    }

    public void a(String str) {
        ((TextView) findViewById(h.d.xco_message)).setText(str);
    }

    public void b(String str) {
        ((TextView) findViewById(h.d.xco_message)).setText(Html.fromHtml("<html>" + str + "</html>"));
    }

    public void a(int i) {
        TextView textView = (TextView) findViewById(h.d.xco_message);
        if (i == 1) {
            textView.setPadding(0, 100, 0, 100);
        } else {
            textView.setPadding(0, 50, 0, 50);
        }
    }

    private void a(Context context, boolean z) {
        this.f4714c = new b();
        this.f4713b = context;
        requestWindowFeature(1);
        setContentView(h.e.xco_dialog_info);
        setCanceledOnTouchOutside(false);
        Button button = (Button) findViewById(h.d.xco_button_ok);
        TextView textView = (TextView) findViewById(h.d.xco_message);
        if (z) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        }
        this.f4714c.a(textView);
        this.f4714c.a(button);
    }
}
