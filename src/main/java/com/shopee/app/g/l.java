package com.shopee.app.g;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.garena.android.appkit.btmsheet.a;
import com.garena.android.appkit.d.a;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.ui.common.a.d;
import com.shopee.app.ui.common.b.c;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.id.R;

public class l {
    public static Dialog a(Context context, AddCartMessage addCartMessage, int i) {
        final c a2 = d.a(context, i);
        addCartMessage.test();
        a2.setData(addCartMessage);
        a2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.b("", new Object[0]);
            }
        });
        com.garena.android.appkit.btmsheet.a a3 = new a.C0124a(context, R.style.StyleDialog).a((View) a2).b(a2.getScrollingView()).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                a2.e();
            }
        }).a();
        a2.setDialog(a3);
        return a3;
    }

    public static Dialog a(Context context, int i, long j, int i2, int i3) {
        final c a2 = d.a(context, i);
        com.garena.android.appkit.btmsheet.a c2 = new a.C0124a(context, R.style.StyleDialog).a((View) a2).b(a2.getScrollingView()).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                a2.e();
            }
        }).c();
        a2.a(j, i3, i2);
        a2.setDialog(c2);
        return c2;
    }

    public static Dialog a(Context context, AddCartMessage addCartMessage, VMOffer vMOffer, final c.b bVar) {
        com.shopee.app.ui.common.b.c a2 = com.shopee.app.ui.common.b.d.a(context);
        a2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        final com.garena.android.appkit.btmsheet.a c2 = new a.C0124a(context, R.style.StyleDialog).a((View) a2).b(a2.getScrollingView()).c();
        a2.a(addCartMessage, (c.b) new c.b() {
            public void a(int i, long j, long j2) {
                c2.dismiss();
                bVar.a(i, j, j2);
            }
        });
        if (vMOffer != null) {
            a2.setLastOffer(vMOffer);
        }
        a2.setDialog(c2);
        c2.show();
        return c2;
    }

    public static Dialog a(Context context, long j, int i, int i2, final c.b bVar) {
        com.shopee.app.ui.common.b.c a2 = com.shopee.app.ui.common.b.d.a(context);
        a2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        final com.garena.android.appkit.btmsheet.a c2 = new a.C0124a(context, R.style.StyleDialog).a((View) a2).b(a2.getScrollingView()).c();
        a2.a(j, i2, i, new c.b() {
            public void a(int i, long j, long j2) {
                c2.dismiss();
                bVar.a(i, j, j2);
            }
        });
        a2.setDialog(c2);
        return c2;
    }

    public static Dialog b(Context context, AddCartMessage addCartMessage, VMOffer vMOffer, final c.b bVar) {
        com.shopee.app.ui.common.b.c a2 = com.shopee.app.ui.common.b.d.a(context);
        a2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        final com.garena.android.appkit.btmsheet.a c2 = new a.C0124a(context, R.style.StyleDialog).a((View) a2).b(a2.getScrollingView()).c();
        a2.a(addCartMessage, (c.b) new c.b() {
            public void a(int i, long j, long j2) {
                c2.dismiss();
                bVar.a(i, j, j2);
            }
        });
        a2.setLastOffer(vMOffer);
        c2.show();
        a2.setDialog(c2);
        return c2;
    }
}
