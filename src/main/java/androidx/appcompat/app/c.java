package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.a;
import androidx.appcompat.app.AlertController;

public class c extends g implements DialogInterface {

    /* renamed from: a  reason: collision with root package name */
    final AlertController f639a = new AlertController(getContext(), this, getWindow());

    protected c(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0012a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.f639a.b();
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f639a.a(charSequence);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f639a.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f639a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f639a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.a f640a;

        /* renamed from: b  reason: collision with root package name */
        private final int f641b;

        public a(Context context) {
            this(context, c.a(context, 0));
        }

        public a(Context context, int i) {
            this.f640a = new AlertController.a(new ContextThemeWrapper(context, c.a(context, i)));
            this.f641b = i;
        }

        public Context a() {
            return this.f640a.f568a;
        }

        public a a(CharSequence charSequence) {
            this.f640a.f573f = charSequence;
            return this;
        }

        public a a(View view) {
            this.f640a.f574g = view;
            return this;
        }

        public a a(Drawable drawable) {
            this.f640a.f571d = drawable;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f640a.u = onKeyListener;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f640a;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f640a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public a a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f640a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.H = true;
            return this;
        }

        public c b() {
            c cVar = new c(this.f640a.f568a, this.f641b);
            this.f640a.a(cVar.f639a);
            cVar.setCancelable(this.f640a.r);
            if (this.f640a.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f640a.s);
            cVar.setOnDismissListener(this.f640a.t);
            if (this.f640a.u != null) {
                cVar.setOnKeyListener(this.f640a.u);
            }
            return cVar;
        }

        public c c() {
            c b2 = b();
            b2.show();
            return b2;
        }
    }
}
