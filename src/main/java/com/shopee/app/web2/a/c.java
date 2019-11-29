package com.shopee.app.web2.a;

import android.content.DialogInterface;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.afollestad.materialdialogs.f;
import com.shopee.app.web2.d;

public class c extends h {
    public a a() {
        return new a();
    }

    class a {
        a() {
        }

        @JavascriptInterface
        public void select(String str, String str2, String str3, String str4) {
            final int i;
            d c2 = c.this.c();
            if (c2 != null && c2.f26666c == null) {
                final String[] split = str2.split("\\|");
                final String[] split2 = str3.split("\\|");
                if (split.length == split2.length && split.length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= split.length) {
                            i = -1;
                            break;
                        } else if (split[i2].equals(str4)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    final d dVar = c2;
                    final String str5 = str;
                    c2.a((Runnable) new Runnable() {
                        public void run() {
                            if (!dVar.a()) {
                                f c2 = new f.a(dVar.getActivity()).a((CharSequence[]) split2).a(i, (f.C0065f) new f.C0065f() {
                                    public boolean a(f fVar, View view, int i, CharSequence charSequence) {
                                        dVar.f26666c = null;
                                        dVar.a(str5, split[i]);
                                        return true;
                                    }
                                }).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        dVar.f26666c = null;
                                    }
                                }).c();
                                dVar.f26665b.add(c2);
                                dVar.f26666c = c2;
                            }
                        }
                    });
                }
            }
        }
    }
}
