package com.bca.xco.widget.e;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f5269a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f5270b;

    public a(Context context) {
        this.f5269a = context;
    }

    public void a(String str) {
        this.f5270b = new AlertDialog.Builder(this.f5269a).setMessage(str).setPositiveButton(17039379, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.f5270b.show();
            }
        }).create();
        this.f5270b.show();
    }
}
