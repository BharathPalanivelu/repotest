package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ai extends ah implements a, b {
    private boolean i = false;
    private final c j = new c();

    public ai(Context context, boolean z) {
        super(context, z);
        g();
    }

    public static ah a(Context context, boolean z) {
        ai aiVar = new ai(context, z);
        aiVar.onFinishInflate();
        return aiVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.chat_text_item_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.j);
        c.a((b) this);
        this.f20056f = androidx.core.content.b.c(getContext(), R.color.white);
        this.f20057g = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f20051a = (TextView) aVar.internalFindViewById(R.id.chat_text);
        this.f20052b = (TextView) aVar.internalFindViewById(R.id.translation_source);
        this.f20053c = aVar.internalFindViewById(R.id.translation_separator);
        this.f20054d = aVar.internalFindViewById(R.id.translation_expand_button);
        this.f20055e = (TextView) aVar.internalFindViewById(R.id.translation_original_text);
        if (this.f20051a != null) {
            this.f20051a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ai.this.c();
                }
            });
            this.f20051a.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    ai.this.e();
                    return true;
                }
            });
        }
        if (this.f20055e != null) {
            this.f20055e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ai.this.d();
                }
            });
        }
        if (this.f20054d != null) {
            this.f20054d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ai.this.f();
                }
            });
        }
        a();
    }
}
