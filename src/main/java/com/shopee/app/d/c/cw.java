package com.shopee.app.d.c;

import android.text.TextUtils;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;

public class cw extends a {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f16743c = false;

    /* renamed from: d  reason: collision with root package name */
    private final be f16744d;

    /* renamed from: e  reason: collision with root package name */
    private ShopDetail f16745e;

    /* renamed from: f  reason: collision with root package name */
    private UserInfo f16746f;

    /* access modifiers changed from: protected */
    public String d() {
        return "PrepareMeTabNotificationItem";
    }

    protected cw(n nVar, be beVar, UserInfo userInfo) {
        super(nVar);
        this.f16744d = beVar;
        this.f16746f = userInfo;
    }

    public void a(ShopDetail shopDetail) {
        this.f16745e = shopDetail;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        ShopDetail shopDetail = this.f16745e;
        int d2 = d(shopDetail);
        if (d2 == 99) {
            d2 = e(shopDetail);
        }
        MeTabNoticeItem.Builder shop = new MeTabNoticeItem.Builder().actionId(d2).shop(shopDetail);
        if (d2 == 0) {
            shop.text((int) R.string.sp_verify_phone).buttonText(R.string.sp_set_now).iconRes(R.drawable.ic_me_prompt_phone);
        } else if (d2 == 1) {
            shop.text((int) R.string.sp_verify_email).buttonText(R.string.sp_set_now).iconRes(R.drawable.ic_me_prompt_email);
        } else if (d2 == 2) {
            shop.text((int) R.string.sp_make_phone_public).buttonText(R.string.sp_set_now).iconRes(R.drawable.ic_me_prompt_phone);
        } else if (d2 == 3) {
            shop.text(b(shopDetail)).buttonText(R.string.sp_set_now).iconRes(R.drawable.ic_me_edit_icon);
        }
        this.f16402a.a().F.a(shop.build()).a();
    }

    private String b(ShopDetail shopDetail) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f16746f.getNickname())) {
            arrayList.add(b.e(R.string.sp_label_name));
        }
        if (c(shopDetail)) {
            arrayList.add(b.e(R.string.sp_gender));
        }
        if (shopDetail.getBirthdayTimeStamp() == null) {
            arrayList.add(b.e(R.string.sp_birthday));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (sb.length() == 0) {
                sb.append(str);
            } else {
                sb.append(", ");
                sb.append(str);
            }
        }
        return b.a(R.string.sp_me_tab_complete_info, sb);
    }

    private boolean c(ShopDetail shopDetail) {
        int gender = shopDetail.getGender();
        return (gender == 1 || gender == 2 || gender == 10) ? false : true;
    }

    private int d(ShopDetail shopDetail) {
        if (this.f16744d.M()) {
            return 99;
        }
        if (TextUtils.isEmpty(this.f16746f.getNickname()) || shopDetail.getGender() == 0 || shopDetail.getBirthdayTimeStamp() == null) {
            return 3;
        }
        return 99;
    }

    private int e(ShopDetail shopDetail) {
        if (!shopDetail.isPhoneVerified() && shopDetail.isSeller() && !f16743c) {
            return 0;
        }
        if (shopDetail.isEmailVerified() || this.f16744d.y()) {
            return (!shopDetail.isPhoneVerified() || shopDetail.isPhonePublic() || !shopDetail.isSeller() || this.f16744d.z()) ? 99 : 2;
        }
        return 1;
    }
}
