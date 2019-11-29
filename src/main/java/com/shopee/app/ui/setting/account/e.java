package com.shopee.app.ui.setting.account;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean k = false;
    private final c l = new c();

    public e(Context context) {
        super(context);
        h();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.mail_setting_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.l);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f25169a = resources.getString(R.string.sp_label_done);
        this.f25170b = resources.getString(R.string.sp_label_email_address);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25171c = (MaterialEditText) aVar.internalFindViewById(R.id.new_setting_value);
        this.f25172d = (Button) aVar.internalFindViewById(R.id.action_btn);
        if (this.f25172d != null) {
            this.f25172d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.c();
                }
            });
        }
        a();
    }
}
