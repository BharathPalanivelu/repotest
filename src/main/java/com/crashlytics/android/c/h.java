package com.crashlytics.android.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import io.a.a.a.a.g.o;
import java.util.concurrent.CountDownLatch;

class h {

    /* renamed from: a  reason: collision with root package name */
    private final b f6474a;

    /* renamed from: b  reason: collision with root package name */
    private final AlertDialog.Builder f6475b;

    interface a {
        void a(boolean z);
    }

    private static int a(float f2, int i) {
        return (int) (f2 * ((float) i));
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6480a;

        /* renamed from: b  reason: collision with root package name */
        private final CountDownLatch f6481b;

        private b() {
            this.f6480a = false;
            this.f6481b = new CountDownLatch(1);
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.f6480a = z;
            this.f6481b.countDown();
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f6480a;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            try {
                this.f6481b.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public static h a(Activity activity, o oVar, final a aVar) {
        final b bVar = new b();
        v vVar = new v(activity, oVar);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView a2 = a(activity, vVar.b());
        builder.setView(a2).setTitle(vVar.a()).setCancelable(false).setNeutralButton(vVar.c(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                bVar.a(true);
                dialogInterface.dismiss();
            }
        });
        if (oVar.f33246d) {
            builder.setNegativeButton(vVar.e(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    bVar.a(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (oVar.f33248f) {
            builder.setPositiveButton(vVar.d(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    aVar.a(true);
                    bVar.a(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new h(builder, bVar);
    }

    private static ScrollView a(Activity activity, String str) {
        float f2 = activity.getResources().getDisplayMetrics().density;
        int a2 = a(f2, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(a2, a2, a2, a2);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(a(f2, 14), a(f2, 2), a(f2, 10), a(f2, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private h(AlertDialog.Builder builder, b bVar) {
        this.f6474a = bVar;
        this.f6475b = builder;
    }

    public void a() {
        this.f6475b.show();
    }

    public void b() {
        this.f6474a.b();
    }

    public boolean c() {
        return this.f6474a.a();
    }
}
