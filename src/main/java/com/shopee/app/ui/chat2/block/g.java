package com.shopee.app.ui.chat2.block;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean i = false;
    private final c j = new c();

    public g(Context context) {
        super(context);
        b();
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.blocked_user_item, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onViewChanged(a aVar) {
        this.f20314a = (TextView) aVar.internalFindViewById(R.id.username);
        this.f20315b = (TextView) aVar.internalFindViewById(R.id.nickname);
        this.f20316c = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f20317d = (RobotoButton) aVar.internalFindViewById(R.id.block_button);
        this.f20318e = aVar.internalFindViewById(R.id.banned_icon);
        if (this.f20317d != null) {
            this.f20317d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.a();
                }
            });
        }
    }
}
