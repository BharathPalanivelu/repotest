package com.shopee.app.ui.chat2.send;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.grid.GGridView;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;

public class a extends FrameLayout implements GGridView.b {

    /* renamed from: a  reason: collision with root package name */
    GGridView f20916a;

    /* renamed from: b  reason: collision with root package name */
    bi f20917b;

    /* renamed from: c  reason: collision with root package name */
    SettingConfigStore f20918c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.app.tracking.trackingv3.b f20919d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<b> f20920e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final ShopDetail f20921f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20922g = false;

    public a(Context context, ShopDetail shopDetail, boolean z) {
        super(context);
        a(context);
        this.f20921f = shopDetail;
        this.f20922g = z;
    }

    private void a(Context context) {
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        b();
        this.f20916a.setColumnCount(4);
        this.f20916a.setItemMargin(b.a.f7695f);
        this.f20916a.setOnItemClickListener(this);
        this.f20916a.setAdapter(new C0310a());
        this.f20916a.a();
    }

    private void b() {
        this.f20920e.add(new b(R.string.sp_label_gallery, R.drawable.ic_photos));
        this.f20920e.add(new b(R.string.sp_bt_camera, R.drawable.ic_camera_chat));
        this.f20920e.add(new b(R.string.sp_label_products, R.drawable.ic_products));
        if (!this.f20922g) {
            this.f20920e.add(new b(R.string.sp_label_order, R.drawable.ic_orders));
        }
        ShopDetail shopDetail = this.f20921f;
        if (shopDetail != null && shopDetail.isPhonePublic() && !this.f20918c.hidePhonePublicOption()) {
            this.f20920e.add(new b(R.string.sp_label_call, R.drawable.ic_call));
        }
        ShopDetail shopDetail2 = this.f20921f;
        if (shopDetail2 != null && !shopDetail2.isOnHoliday()) {
            this.f20920e.add(new b(R.string.sp_label_offers, R.drawable.ic_offer));
            if (this.f20921f.getItemCount() > 0) {
                this.f20920e.add(new b(R.string.sp_label_buy, R.drawable.ic_buy));
            }
        }
        for (int size = this.f20920e.size(); size < 8; size++) {
            this.f20920e.add(new b(0, 0));
        }
    }

    public void a(View view, int i, int i2, int i3) {
        switch (this.f20920e.get(i3).f20924a) {
            case R.drawable.ic_buy:
                this.f20917b.a().at.a();
                this.f20919d.a("buy_now_button", com.shopee.app.tracking.trackingv3.b.f19172a);
                return;
            case R.drawable.ic_call:
                ShopDetail shopDetail = this.f20921f;
                if (shopDetail != null) {
                    String phone = shopDetail.getPhone();
                    if (!phone.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                        phone = Marker.ANY_NON_NULL_MARKER + phone;
                    }
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse("tel:" + phone));
                    getContext().startActivity(intent);
                    return;
                }
                return;
            case R.drawable.ic_camera_chat:
                PhotoProxyActivity_.a(getContext()).a(true).b(true).a(4);
                return;
            case R.drawable.ic_offer:
                this.f20917b.a().R.a();
                return;
            case R.drawable.ic_orders:
                this.f20917b.a().aj.a();
                return;
            case R.drawable.ic_photos:
                PhotoProxyActivity_.a(getContext()).d(true).f(9).a(4);
                return;
            case R.drawable.ic_products:
                this.f20917b.a().V.a();
                return;
            default:
                return;
        }
    }

    /* renamed from: com.shopee.app.ui.chat2.send.a$a  reason: collision with other inner class name */
    private class C0310a implements GGridView.a {
        private C0310a() {
        }

        public int a() {
            return a.this.f20920e.size();
        }

        public View a(Context context, int i, int i2, int i3) {
            View inflate = View.inflate(context, R.layout.chat_option_item, (ViewGroup) null);
            if (((b) a.this.f20920e.get(i3)).f20924a != 0) {
                ((ImageView) inflate.findViewById(R.id.icon)).setImageResource(((b) a.this.f20920e.get(i3)).f20924a);
                ((TextView) inflate.findViewById(R.id.label)).setText(((b) a.this.f20920e.get(i3)).f20925b);
            }
            return inflate;
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f20924a;

        /* renamed from: b  reason: collision with root package name */
        public int f20925b;

        public b(int i, int i2) {
            this.f20925b = i;
            this.f20924a = i2;
        }
    }
}
