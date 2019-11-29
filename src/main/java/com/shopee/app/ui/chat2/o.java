package com.shopee.app.ui.chat2;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.ui.chat2.send.ChatShortcutView;
import com.shopee.app.ui.chat2.send.e;
import com.shopee.app.ui.common.t;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class o extends n implements a, b {
    private boolean u = false;
    private final c v = new c();

    public o(Context context, int i, ChatIntention chatIntention) {
        super(context, i, chatIntention);
        x();
    }

    public static n a(Context context, int i, ChatIntention chatIntention) {
        o oVar = new o(context, i, chatIntention);
        oVar.onFinishInflate();
        return oVar;
    }

    public void onFinishInflate() {
        if (!this.u) {
            this.u = true;
            inflate(getContext(), R.layout.user_chat_view_layout, this);
            this.v.a((a) this);
        }
        super.onFinishInflate();
    }

    private void x() {
        c a2 = c.a(this.v);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20534a = (RecyclerView) aVar.internalFindViewById(R.id.chat_list);
        this.f20535b = (e) aVar.internalFindViewById(R.id.send_text_view);
        this.f20536c = (TextView) aVar.internalFindViewById(R.id.chat_block_overlay);
        this.f20537d = (r) aVar.internalFindViewById(R.id.keyboardPanel);
        this.f20538e = (TextView) aVar.internalFindViewById(R.id.hintText);
        this.f20539f = (ChatShortcutView) aVar.internalFindViewById(R.id.shortcut_view);
        this.f20540g = (t) aVar.internalFindViewById(R.id.notice_view_vacation);
        this.h = (t) aVar.internalFindViewById(R.id.notice_view_translation);
        if (this.f20538e != null) {
            this.f20538e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    o.this.e();
                }
            });
        }
        a();
    }
}
