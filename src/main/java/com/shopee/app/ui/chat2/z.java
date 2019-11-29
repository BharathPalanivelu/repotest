package com.shopee.app.ui.chat2;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class z extends y implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f20970g = false;
    private final c h = new c();

    public z(Context context, int i, String str) {
        super(context, i, str);
        j();
    }

    public static y a(Context context, int i, String str) {
        z zVar = new z(context, i, str);
        zVar.onFinishInflate();
        return zVar;
    }

    public void onFinishInflate() {
        if (!this.f20970g) {
            this.f20970g = true;
            inflate(getContext(), R.layout.message_shortcut_edit_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void j() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20958a = (EditText) aVar.internalFindViewById(R.id.text);
        View internalFindViewById = aVar.internalFindViewById(R.id.submit);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    z.this.e();
                }
            });
        }
        a();
    }
}
