package com.shopee.sdk.modules.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import com.afollestad.materialdialogs.f;
import com.shopee.sdk.f.b;

public class c implements b {
    public void a(Activity activity, a aVar, b<Integer> bVar) {
        f.a a2 = new f.a(activity).a((CharSequence) aVar.a()).e((CharSequence) aVar.d()).c((CharSequence) aVar.c()).a(aVar.e());
        a(a2, bVar);
        a2.b((CharSequence) aVar.b());
        a2.c();
    }

    private void a(f.a aVar, final b<Integer> bVar) {
        aVar.a((f.b) new f.b() {
            public void onPositive(f fVar) {
                super.onPositive(fVar);
                fVar.dismiss();
                bVar.b(1);
            }

            public void onNegative(f fVar) {
                super.onNegative(fVar);
                fVar.dismiss();
                bVar.b(0);
            }
        });
        aVar.a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                bVar.b(2);
            }
        });
    }
}
