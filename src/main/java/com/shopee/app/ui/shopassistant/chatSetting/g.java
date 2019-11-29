package com.shopee.app.ui.shopassistant.chatSetting;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean j = false;
    private final c k = new c();

    public g(Context context) {
        super(context);
        g();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.chat_settings_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.k);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25422f = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.auto_reply);
        this.f25423g = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.accept_chat);
        this.h = (TextView) aVar.internalFindViewById(R.id.auto_reply_msg);
        this.i = aVar.internalFindViewById(R.id.divider);
        View internalFindViewById = aVar.internalFindViewById(R.id.message_shortcut_option);
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.d();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.f();
                }
            });
        }
        c();
    }
}
