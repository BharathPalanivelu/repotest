package com.shopee.app.ui.product.add;

import android.text.TextUtils;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.g.e;
import com.shopee.app.g.f;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.util.af;
import com.shopee.app.util.k.i;
import com.shopee.id.R;
import com.tencent.imsdk.TIMGroupManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class j {

    /* renamed from: a  reason: collision with root package name */
    private SettingConfigStore f24073a;

    public j(SettingConfigStore settingConfigStore) {
        this.f24073a = settingConfigStore;
    }

    public a a(AddProductInfo addProductInfo, List<WholesaleTierModel> list, Long l, boolean z, List<ModelDetail> list2, List<VMItemAttribute> list3, boolean z2, long j, long j2, int i, int i2) {
        Iterator<ModelDetail> it;
        int i3;
        long j3 = j;
        long j4 = j2;
        int i4 = i;
        int i5 = i2;
        a aVar = new a();
        int i6 = 1;
        String a2 = e.a(j4, "IDR", true, false);
        String a3 = e.a(j3, "IDR", true, false);
        if (TextUtils.isEmpty(addProductInfo.getCategory())) {
            aVar.a(com.garena.android.appkit.tools.b.e(R.string.sp_error_no_category));
            aVar.f24075b |= TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE;
        }
        if (!af.a(list3)) {
            HashMap hashMap = new HashMap();
            if (!af.a(addProductInfo.getAttributeValues())) {
                for (u next : addProductInfo.getAttributeValues()) {
                    hashMap.put(Integer.valueOf(next.a()), next);
                }
            }
            Iterator<VMItemAttribute> it2 = list3.iterator();
            while (it2.hasNext()) {
                VMItemAttribute next2 = it2.next();
                if (next2.isMandatory() && next2.isKnowType()) {
                    Iterator<VMItemAttribute> it3 = it2;
                    if (!hashMap.containsKey(Integer.valueOf(next2.getAttrId()))) {
                        aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_x_no_empty, next2.getDisplayName()));
                        aVar.f24075b |= 8;
                    } else if (TextUtils.isEmpty(((u) hashMap.get(Integer.valueOf(next2.getAttrId()))).b())) {
                        aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_x_no_empty, next2.getDisplayName()));
                        aVar.f24075b |= 8;
                    }
                    it2 = it3;
                }
            }
        }
        if (list2.isEmpty()) {
            String price = addProductInfo.getPrice();
            if (f.b(price) == f.f17505a) {
                aVar.a(a((int) R.string.sp_error_invalid_price));
                aVar.f24075b |= 16;
            }
            Long a4 = e.a(price, "IDR");
            if (!(j3 == -1 || a4 == null || a4.longValue() >= j3)) {
                aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_price_range_min, a3));
                aVar.f24075b |= 16;
            }
            if (!(j4 == -1 || a4 == null || a4.longValue() <= j4)) {
                aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_price_range_max, a2));
                aVar.f24075b |= 16;
            }
            if (!(i4 == -1 || i5 == -1)) {
                try {
                    int parseInt = Integer.parseInt(addProductInfo.getStock());
                    if (parseInt < i4) {
                        aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_stock_range, Integer.valueOf(i), Integer.valueOf(i2)));
                        aVar.f24075b |= 32;
                    }
                    if (parseInt > i5) {
                        aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_stock_range, Integer.valueOf(i), Integer.valueOf(i2)));
                        aVar.f24075b |= 32;
                    }
                } catch (Exception unused) {
                    aVar.a(a((int) R.string.sp_error_invalid_stock_invalid));
                    aVar.f24075b |= 32;
                }
            }
        } else {
            HashMap hashMap2 = new HashMap();
            Iterator<ModelDetail> it4 = list2.iterator();
            int i7 = 1;
            int i8 = 0;
            while (it4.hasNext()) {
                ModelDetail next3 = it4.next();
                if (!af.a(addProductInfo.getTierVariations()) || (!TextUtils.isEmpty(next3.getName().trim()) && next3.getName().trim().length() <= 20)) {
                    i3 = i7;
                    String lowerCase = next3.getName().trim().toLowerCase();
                    if (hashMap2.containsKey(lowerCase)) {
                        it = it4;
                        aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_name_model_duplicate_name, hashMap2.get(lowerCase), Integer.valueOf(i3)));
                        aVar.f24074a = i3;
                        aVar.f24075b |= 64;
                    } else {
                        it = it4;
                        hashMap2.put(lowerCase, Integer.valueOf(i3));
                    }
                } else {
                    Object[] objArr = new Object[i6];
                    objArr[0] = Integer.valueOf(i7);
                    aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_name_model, objArr));
                    i3 = i7;
                    aVar.f24074a = i3;
                    aVar.f24075b |= 64;
                    it = it4;
                }
                if (f.b(next3.getDisplayPrice()) == f.f17505a) {
                    aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_price_model, Integer.valueOf(i3)));
                    aVar.f24074a = i3;
                    aVar.f24075b |= 128;
                }
                Long a5 = e.a(next3.getDisplayPrice(), "IDR");
                if (j3 != -1 && a5 != null && a5.longValue() < j3) {
                    aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_price_range_min, a3));
                    aVar.f24074a = i3;
                    aVar.f24075b |= 128;
                }
                if (j4 != -1 && a5 != null && a5.longValue() > j4) {
                    aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_price_range_max, a2));
                    aVar.f24074a = i3;
                    aVar.f24075b |= 128;
                }
                int c2 = f.c(next3.getDisplayStock());
                if (c2 == 1) {
                    aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_stock_invalid_model, Integer.valueOf(i3)));
                    aVar.f24074a = i3;
                    aVar.f24075b |= 256;
                }
                if (c2 == 2) {
                    aVar.a(com.garena.android.appkit.tools.b.a(R.string.sp_error_invalid_stock_too_much_model, Integer.valueOf(i3)));
                    aVar.f24074a = i3;
                    aVar.f24075b |= 256;
                }
                try {
                    i8 += Integer.parseInt(next3.getDisplayStock());
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
                it4 = it;
                i7 = i3 + 1;
                i6 = 1;
            }
            int i9 = i7;
            if (i8 == 0 && !z) {
                aVar.a(com.garena.android.appkit.tools.b.e(R.string.sp_error_invalid_stock));
                aVar.f24074a = i9 - 1;
                aVar.f24075b |= 256;
            }
        }
        if (!f.a(addProductInfo.getBrand())) {
            aVar.a(a((int) R.string.sp_error_brand_too_long));
            aVar.f24075b |= 512;
        }
        if (addProductInfo.getShippingDays() < 1) {
            aVar.a(com.garena.android.appkit.tools.b.e(R.string.sp_shipping_day_error2));
            aVar.f24075b |= 1024;
        }
        if (TextUtils.isEmpty(addProductInfo.getDisplayWeight()) && this.f24073a.showProductWeight() && !this.f24073a.isProductWeightOptional()) {
            aVar.a(com.garena.android.appkit.tools.b.e(R.string.sp_no_product_weight_err));
            aVar.f24075b |= 8192;
        }
        if (!f.d(addProductInfo.getDisplayLogisticInfo())) {
            aVar.a(com.garena.android.appkit.tools.b.e(R.string.sp_shipping_logistic_err));
            aVar.f24075b |= 2048;
        }
        if (!af.a(list) && !a(list2)) {
            aVar.a(com.garena.android.appkit.tools.b.e(R.string.wholesale_variations_not_same_price));
            aVar.f24075b |= 4096;
        }
        if (a(l, list)) {
            aVar.a(com.garena.android.appkit.tools.b.e(R.string.wholesale_original_price_lower_wholesale_price));
            aVar.f24075b |= 16;
            aVar.f24075b |= 4096;
        }
        if (z2) {
            aVar.a(com.garena.android.appkit.tools.b.e(R.string.add_product_invalid_attribute_error));
            aVar.f24075b |= 8;
        }
        return aVar;
    }

    private boolean a(Long l, List<WholesaleTierModel> list) {
        if (l == null) {
            return false;
        }
        String a2 = e.a(l.longValue(), "IDR", true);
        if (!af.a(list)) {
            String str = list.get(0).f24172c;
            if (i.a(a2, str) || i.b(a2, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(List<ModelDetail> list) {
        if (af.a(list)) {
            return true;
        }
        long a2 = a(list.get(0));
        for (ModelDetail a3 : list) {
            if (a2 != a(a3)) {
                return false;
            }
        }
        return true;
    }

    private long a(ModelDetail modelDetail) {
        long priceBeforeDiscount = modelDetail.getPriceBeforeDiscount();
        if (priceBeforeDiscount > 0) {
            return priceBeforeDiscount;
        }
        Long a2 = e.a(modelDetail.getDisplayPrice(), "IDR");
        if (a2 != null) {
            return a2.longValue();
        }
        return 0;
    }

    private String a(int i) {
        return com.garena.android.appkit.tools.b.e(i);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f24074a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f24075b = 0;

        /* renamed from: c  reason: collision with root package name */
        private String f24076c = "";

        /* renamed from: d  reason: collision with root package name */
        private b f24077d;

        public boolean a() {
            return (this.f24075b & TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE) != 0;
        }

        public boolean b() {
            return (this.f24075b & 16) != 0;
        }

        public boolean c() {
            return (this.f24075b & 32) != 0;
        }

        public boolean d() {
            return (this.f24075b & 64) != 0;
        }

        public boolean e() {
            return (this.f24075b & 128) != 0;
        }

        public boolean f() {
            return (this.f24075b & 256) != 0;
        }

        public boolean g() {
            return (this.f24075b & 512) != 0;
        }

        public boolean h() {
            return (this.f24075b & 1024) != 0;
        }

        public boolean i() {
            return (this.f24075b & 2048) != 0;
        }

        public boolean j() {
            return (this.f24075b & 8192) != 0;
        }

        public boolean k() {
            return this.f24075b == 0;
        }

        public boolean l() {
            return this.f24074a != -1;
        }

        public boolean m() {
            return (this.f24075b & 4096) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return (this.f24075b & TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG) != 0;
        }

        public void a(String str) {
            if (TextUtils.isEmpty(this.f24076c)) {
                this.f24076c = str;
            }
        }

        public String o() {
            return this.f24076c;
        }

        /* access modifiers changed from: package-private */
        public b p() {
            return this.f24077d;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f24078a;

        /* renamed from: b  reason: collision with root package name */
        private String f24079b;

        private b(int i, String str) {
            this.f24078a = i;
            this.f24079b = str;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f24078a == 0;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f24079b;
        }

        static b a(String str) {
            return new b(0, str);
        }
    }
}
