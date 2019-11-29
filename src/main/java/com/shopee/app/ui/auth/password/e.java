package com.shopee.app.ui.auth.password;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.devspark.robototextview.widget.RobotoTextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean l = false;
    private final c m = new c();

    public e(Context context) {
        super(context);
        f();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.check_password_layout, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.m);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f19603d = resources.getString(R.string.sp_label_continue);
        this.f19604e = resources.getString(R.string.sp_current_passsword);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19600a = (MaterialEditText) aVar.internalFindViewById(R.id.new_setting_value);
        this.f19601b = (Button) aVar.internalFindViewById(R.id.action_btn);
        this.f19602c = (RobotoTextView) aVar.internalFindViewById(R.id.verify_phone_tip);
        if (this.f19601b != null) {
            this.f19601b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.b();
                }
            });
        }
        a();
    }
}
