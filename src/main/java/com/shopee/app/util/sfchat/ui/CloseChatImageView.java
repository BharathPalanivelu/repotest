package com.shopee.app.util.sfchat.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.shopee.app.util.sfchat.b;
import d.d.b.j;

public final class CloseChatImageView extends ImageView implements View.OnClickListener {
    public CloseChatImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public CloseChatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CloseChatImageView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloseChatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        super.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view != null) {
            b bVar = b.f26507a;
            Context context = view.getContext();
            j.a((Object) context, "it.context");
            bVar.a(context);
        }
    }
}
