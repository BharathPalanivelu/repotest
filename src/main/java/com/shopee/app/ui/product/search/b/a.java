package com.shopee.app.ui.product.search.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.viewmodel.HotWordData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.product.search.j;
import com.shopee.app.util.z;

public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    View f24800a;

    /* renamed from: b  reason: collision with root package name */
    View f24801b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24802c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f24803d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f24804e;

    /* renamed from: f  reason: collision with root package name */
    TextView f24805f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f24806g;
    ImageView h;
    /* access modifiers changed from: private */
    public j.b i;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public a(Context context) {
        super(context);
    }

    public void a(final int i2, final HotWordData hotWordData, final int i3, final HotWordData hotWordData2) {
        boolean z = true;
        int i4 = 0;
        boolean z2 = hotWordData != null;
        int i5 = 4;
        this.f24800a.setVisibility(z2 ? 0 : 4);
        if (z2) {
            this.f24800a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (a.this.i != null) {
                        a.this.i.a(a.this.f24800a, hotWordData.getText(), i2, (SearchProductItem) null);
                    }
                }
            });
            this.f24802c.setText(hotWordData.getText());
            this.f24804e.setVisibility("hot".equals(hotWordData.getData_type()) ? 0 : 8);
            z.b(getContext()).a(hotWordData.getImage()).a(b.a.r).a(this.f24803d);
        }
        if (hotWordData2 == null) {
            z = false;
        }
        View view = this.f24801b;
        if (z) {
            i5 = 0;
        }
        view.setVisibility(i5);
        if (z) {
            this.f24801b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (a.this.i != null) {
                        a.this.i.a(a.this.f24800a, hotWordData2.getText(), i3, (SearchProductItem) null);
                    }
                }
            });
            this.f24805f.setText(hotWordData2.getText());
            ImageView imageView = this.h;
            if (!"hot".equals(hotWordData2.getData_type())) {
                i4 = 8;
            }
            imageView.setVisibility(i4);
            z.b(getContext()).a(hotWordData2.getImage()).a(b.a.r).a(this.f24806g);
        }
    }

    public void setOnItemClickListener(j.b bVar) {
        this.i = bVar;
    }
}
