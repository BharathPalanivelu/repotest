package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ae extends ad implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f20045c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f20046d = new c();

    public ae(Context context, an anVar, boolean z) {
        super(context, anVar, z);
        e();
    }

    public static ad a(Context context, an anVar, boolean z) {
        ae aeVar = new ae(context, anVar, z);
        aeVar.onFinishInflate();
        return aeVar;
    }

    public void onFinishInflate() {
        if (!this.f20045c) {
            this.f20045c = true;
            inflate(getContext(), R.layout.chat_sticker_item_layout, this);
            this.f20046d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f20046d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20040a = (ProgressWheel) aVar.internalFindViewById(R.id.progress_wheel);
        this.f20041b = (ImageView) aVar.internalFindViewById(R.id.chat_sticker);
        a();
    }
}
