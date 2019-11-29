package com.shopee.app.ui.home.bottom;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.common.f;
import com.shopee.id.R;

public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f22126a;

    /* renamed from: b  reason: collision with root package name */
    TextView f22127b;

    /* renamed from: c  reason: collision with root package name */
    f f22128c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleDraweeView f22129d;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.app.ui.home.a f22130e;

    public a(Context context) {
        super(context);
        setClipChildren(false);
    }

    public void setData(com.shopee.app.ui.home.a aVar) {
        this.f22130e = aVar;
        this.f22126a.setImageResource(aVar.getIconResId());
        this.f22127b.setText(aVar.getTitleResId());
        f fVar = this.f22128c;
        fVar.setTag("TAB:" + aVar.getPos());
        this.f22128c.c();
        setTag(aVar);
    }

    public com.shopee.app.ui.home.a getData() {
        return this.f22130e;
    }

    public f getBadgeView() {
        return this.f22128c;
    }

    public void setActive(boolean z) {
        this.f22126a.setImageResource(z ? this.f22130e.getIconActiveResId() : this.f22130e.getIconResId());
        int i = z ? R.color.primary : R.color.black65;
        if ((this.f22130e.getId().equals(com.shopee.app.ui.home.a.TAB_MALL_RN.getId()) || this.f22130e.getId().equals(com.shopee.app.ui.home.a.TAB_MALL_WEB.getId())) && z) {
            i = R.color.red_official_shop;
        }
        this.f22127b.setTextColor(b.a(i));
    }
}
