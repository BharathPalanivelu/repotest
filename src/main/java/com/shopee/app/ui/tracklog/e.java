package com.shopee.app.ui.tracklog;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public class e extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private g f25651a;

    public e(Context context, String str) {
        super(context);
        this.f25651a = (g) WebRegister.GSON.a(str, g.class);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        TextView textView = (TextView) findViewById(R.id.tag);
        if (this.f25651a.j != null) {
            textView.setText(this.f25651a.j);
        }
        ((TextView) findViewById(R.id.time)).setText(new SimpleDateFormat("MMM dd,yyyy HH:mm:ss").format(new Date(this.f25651a.f25658e)));
        TextView textView2 = (TextView) findViewById(R.id.exception);
        if (this.f25651a.i != null) {
            textView2.setVisibility(0);
            textView2.setText(this.f25651a.i.toString());
        }
        TextView textView3 = (TextView) findViewById(R.id.text);
        if (this.f25651a.f25659f != null) {
            textView3.setText(a(WebRegister.GSON.b((Object) this.f25651a.f25659f)));
        }
    }

    public static String a(String str) {
        String replaceAll = str.replaceAll("\\\\", "");
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        for (int i = 0; i < replaceAll.length(); i++) {
            char charAt = replaceAll.charAt(i);
            if (charAt != ',') {
                if (charAt != '[') {
                    if (charAt != ']') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                sb.append(charAt);
                            }
                        }
                    }
                    str2 = str2.replaceFirst("\t", "");
                    sb.append("\n" + str2 + charAt);
                }
                sb.append("\n" + str2 + charAt + "\n");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("\t");
                str2 = sb2.toString();
                sb.append(str2);
            } else {
                sb.append(charAt + "\n" + str2);
            }
        }
        return sb.toString();
    }
}
