package com.shopee.app.ui.product.add;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ab;
import com.shopee.app.d.c.ak;
import com.shopee.app.d.c.az;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.cg;
import com.shopee.app.d.c.ct;
import com.shopee.app.d.c.cy;
import com.shopee.app.d.c.da;
import com.shopee.app.d.c.dv;
import com.shopee.app.d.c.el;
import com.shopee.app.d.c.x;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.data.viewmodel.EditCategoryData;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.h.r;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.ar;
import com.shopee.app.network.d.ax;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.product.add.j;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.ui.product.b.a.f;
import com.shopee.app.ui.product.b.c;
import com.shopee.app.ui.product.b.d;
import com.shopee.app.upload.VideoState;
import com.shopee.app.util.af;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.util.q.e;
import com.shopee.app.util.s;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.shopee.protocol.shop.ItemCondition;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;

public class e extends q<k> {
    private static CharSequence[] T = new CharSequence[2];
    private static ItemCondition[] U = new ItemCondition[2];
    private boolean A = false;
    private String B = "";
    private s C;
    /* access modifiers changed from: private */
    public final d D;
    private com.garena.android.appkit.b.e E = new g() {
        public void onEvent(a aVar) {
            ((k) e.this.f19220b).F();
            ((k) e.this.f19220b).o();
        }
    };
    private com.garena.android.appkit.b.e F = new g() {
        public void onEvent(a aVar) {
            ((k) e.this.f19220b).M();
        }
    };
    private com.garena.android.appkit.b.e G = new g() {
        public void onEvent(a aVar) {
            ShopDetail unused = e.this.t = (ShopDetail) aVar.data;
        }
    };
    private com.garena.android.appkit.b.e H = new g() {
        public void onEvent(a aVar) {
            ShopDetail unused = e.this.t = (ShopDetail) aVar.data;
            ((k) e.this.f19220b).a(e.this.t);
            ((k) e.this.f19220b).g(e.this.t.getMaxImageCount());
        }
    };
    private com.garena.android.appkit.b.e I = new g() {
        public void onEvent(a aVar) {
            ((k) e.this.f19220b).G();
        }
    };
    private com.garena.android.appkit.b.e J = new g() {
        public void onEvent(a aVar) {
        }
    };
    private com.garena.android.appkit.b.e K = new g() {
        public void onEvent(a aVar) {
            ct ctVar = (ct) aVar;
            ((k) e.this.f19220b).a(ctVar.f16725a, ctVar.f16726b);
        }
    };
    private com.garena.android.appkit.b.e L = new g() {
        public void onEvent(a aVar) {
            r.a().b((int) R.string.sp_unable_to_load_image);
        }
    };
    private com.garena.android.appkit.b.e M = new g() {
        public void onEvent(a aVar) {
            ((k) e.this.f19220b).a((ag) aVar.data);
        }
    };
    /* access modifiers changed from: private */
    public com.garena.android.appkit.b.e N = new g() {
        public void onEvent(a aVar) {
            boolean z;
            long j;
            int i;
            if (!((k) e.this.f19220b).N()) {
                k.f24080a = true;
                AddProductInfo submitState = ((k) e.this.f19220b).getSubmitState();
                Long originalPrice = ((k) e.this.f19220b).getOriginalPrice();
                List<MediaData> images = ((k) e.this.f19220b).getImages();
                List<WholesaleTierModel> wholesaleTiers = ((k) e.this.f19220b).getWholesaleTiers();
                ((k) e.this.f19220b).Q();
                List<ModelDetail> modelDetails = ((k) e.this.f19220b).getModelDetails();
                c.a a2 = e.this.D.b().a(submitState, images.size());
                boolean z2 = false;
                if (!a2.a()) {
                    ((k) e.this.f19220b).a(a2);
                    z = false;
                } else {
                    z = true;
                }
                int i2 = -1;
                long j2 = -1;
                try {
                    com.shopee.app.ui.product.b.a.g gVar = (com.shopee.app.ui.product.b.a.g) e.this.D.b().a(e.C0408e.STOCK);
                    i = gVar.a();
                    try {
                        i2 = gVar.b();
                        f fVar = (f) e.this.D.b().a(e.C0408e.PRICE);
                        j = fVar.a();
                        try {
                            j2 = fVar.b();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        j = -1;
                    }
                } catch (Exception unused3) {
                    j = -1;
                    i = -1;
                }
                boolean z3 = z;
                j.a a3 = e.this.f24016d.a(submitState, wholesaleTiers, originalPrice, e.this.s != 0, modelDetails, ((k) e.this.f19220b).aw, ((k) e.this.f19220b).n.c(), j, j2, i, i2);
                if (!a3.k()) {
                    ((k) e.this.f19220b).a(a3, z3);
                } else if (a3.p() != null) {
                    ((k) e.this.f19220b).a(a3.p(), (a.C0318a) new a.C0318a() {
                        public void onNegative() {
                        }

                        public void onPositive() {
                            e.this.N.onEvent(new com.garena.android.appkit.b.a());
                        }
                    });
                } else {
                    z2 = z3;
                }
                if (z2) {
                    e.this.f24018f.a(e.this.s, submitState, wholesaleTiers, images, ((k) e.this.f19220b).getInstagramId(), modelDetails, ((k) e.this.f19220b).P(), ((k) e.this.f19220b).getTierVariations());
                    ((k) e.this.f19220b).X();
                }
            }
        }
    };
    private com.garena.android.appkit.b.e O = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            AddProductInfo submitState = ((k) e.this.f19220b).getSubmitState();
            List<WholesaleTierModel> wholesaleTiers = ((k) e.this.f19220b).getWholesaleTiers();
            List<ModelDetail> modelDetails = ((k) e.this.f19220b).getModelDetails();
            ((k) e.this.f19220b).E();
            e.this.n.a(e.this.s, submitState, wholesaleTiers, ((k) e.this.f19220b).getImages(), ((k) e.this.f19220b).getInstagramId(), modelDetails, false, ((k) e.this.f19220b).y.isChecked(), ((k) e.this.f19220b).P(), ((k) e.this.f19220b).getTierVariations());
        }
    };
    private com.garena.android.appkit.b.e P = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
        }
    };
    private com.garena.android.appkit.b.e Q = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((k) e.this.f19220b).F();
            int intValue = ((Integer) aVar.data).intValue();
            if (intValue == -100) {
                ((k) e.this.f19220b).a(b.e(R.string.sp_network_error));
            } else if (intValue == 1) {
                ((k) e.this.f19220b).a(b.e(R.string.sp_server_parameter_error));
            } else if (intValue != 2) {
                ((k) e.this.f19220b).a(b.e(R.string.sp_server_error));
            } else {
                ((k) e.this.f19220b).a(b.e(R.string.sp_server_permission_error));
            }
        }
    };
    private com.garena.android.appkit.b.e R = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            e.this.a((AddProductInfo) aVar.data);
        }
    };
    private com.garena.android.appkit.b.e S = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ItemDetail itemDetail = (ItemDetail) aVar.data;
            ((k) e.this.f19220b).setItemDetail(itemDetail);
            List<ModelDetail> modelDetails = itemDetail.getModelDetails();
            if (modelDetails != null && !modelDetails.isEmpty()) {
                ((k) e.this.f19220b).a(modelDetails);
            }
            e.this.b(true);
            e.this.b(modelDetails, itemDetail.getWholesaleTiers());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final bi f24014a;

    /* renamed from: c  reason: collision with root package name */
    private final n f24015c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final j f24016d;

    /* renamed from: e  reason: collision with root package name */
    private final ab f24017e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final el f24018f;

    /* renamed from: g  reason: collision with root package name */
    private final UserInfo f24019g;
    private final ak h;
    private final cy i;
    private final x j;
    private final cg k;
    private final az l;
    private final da m;
    /* access modifiers changed from: private */
    public final dv n;
    private final bt o;
    private final aj p;
    private final SettingConfigStore q;
    private final OkHttpClient r;
    /* access modifiers changed from: private */
    public long s;
    /* access modifiers changed from: private */
    public ShopDetail t;
    private final i u;
    private int v = 0;
    private VideoState w;
    private ar x = null;
    private al y;
    private com.shopee.app.network.http.a.a z;

    public e(n nVar, bi biVar, j jVar, cy cyVar, da daVar, ab abVar, x xVar, az azVar, cg cgVar, dv dvVar, el elVar, UserInfo userInfo, SettingConfigStore settingConfigStore, aj ajVar, ak akVar, bt btVar, OkHttpClient okHttpClient, com.shopee.app.network.http.a.a aVar, al alVar, s sVar, d dVar) {
        this.f24015c = nVar;
        this.f24014a = biVar;
        this.f24016d = jVar;
        this.f24017e = abVar;
        this.j = xVar;
        this.l = azVar;
        this.k = cgVar;
        this.n = dvVar;
        this.f24018f = elVar;
        this.f24019g = userInfo;
        this.q = settingConfigStore;
        this.h = akVar;
        this.i = cyVar;
        this.m = daVar;
        this.o = btVar;
        this.p = ajVar;
        this.r = okHttpClient;
        this.z = aVar;
        this.y = alVar;
        this.C = sVar;
        this.u = com.garena.a.a.a.b.a(this);
        this.D = dVar;
    }

    public void e() {
        this.x = new ar();
        this.x.a(0, 5, true);
    }

    public void a(int i2, int i3) {
        this.o.a(i3, i2, new com.shopee.app.network.g());
        new ao().a(i2);
    }

    public void a(long j2) {
        this.s = j2;
        if (this.s != 0) {
            b(false);
            new ax(this.f24019g.getShopId(), j2).g();
            ((k) this.f19220b).B();
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (!this.A && z2) {
            this.A = true;
        }
        this.h.a(this.s);
        ((k) this.f19220b).a(this.s);
    }

    public void b(long j2) {
        this.s = j2;
    }

    public void f() {
        ((k) this.f19220b).a(T);
    }

    public void a(List<Integer> list, List<String> list2) {
        this.i.a(list, list2, true);
    }

    public void a(String str, String str2) {
        this.m.a(this.s, str, str2);
    }

    public void a() {
        this.u.a();
        this.f24015c.a("ITEM_SAVED_LOCALLY", this.I);
        this.f24015c.a("ITEM_CATEGORY_LIST_LOCAL_LOAD", this.J);
        this.f24015c.a("ON_IMAGE_SELECTED", this.K);
        this.f24015c.a("ON_IMAGE_SELECTED_FAIL", this.L);
        this.f24015c.a("ITEM_LOADED", this.R);
        this.f24015c.a("EDIT_ITEM_SUCCESS", this.P);
        this.f24015c.a("EDIT_ITEM_ERROR", this.Q);
        this.f24015c.a("ITEM_DELETE", this.E);
        this.f24015c.a("ITEM_DETAIL_LOAD", this.S);
        this.f24015c.a("SHOP_INFO_FETCHED", this.H);
        this.f24015c.a("SHOP_INFO_LOCAL_LOAD", this.G);
        this.f24015c.a("ON_IMAGE_SELECTED_DONE", this.F);
        this.f24015c.a("ADD_ITEM_RESULT_VALIDATE", this.O);
        if (!l()) {
            ((k) this.f19220b).T();
        }
        ((k) this.f19220b).a(T[0].toString(), 0);
        this.D.c();
    }

    public void a(List<EditCategoryData.EditCategory> list) {
        if (!af.a(list)) {
            int i2 = list.get(list.size() - 1).catId;
            this.f24017e.a(i2);
            b(i2, 0);
            ((k) this.f19220b).W();
        }
    }

    public void a(int i2, List<Integer> list) {
        if (this.x != null) {
            this.f24017e.a(i2);
            this.x = null;
            a(list, this.v);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        a(((k) this.f19220b).av.getCategoryId(), ((k) this.f19220b).av.getCategoryIdPath());
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        ((k) this.f19220b).D();
        if (i2 == -100) {
            ((k) this.f19220b).a(b.e(R.string.sp_network_error));
            ((k) this.f19220b).e(0);
        } else if (i2 == 4) {
            ((k) this.f19220b).f(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        ((k) this.f19220b).h.setText(str);
        ((k) this.f19220b).av.setCategory(str);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((k) this.f19220b).F();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = b.e(R.string.sp_network_error);
            } else if (i2 == 1) {
                str = b.e(R.string.sp_server_parameter_error);
            } else if (i2 != 2) {
                str = b.e(R.string.sp_server_error);
            } else {
                str = b.e(R.string.sp_server_permission_error);
            }
        }
        ((k) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        ((k) this.f19220b).D();
        if (i2 > 0) {
            this.v = i2;
            this.l.a(this.v, ((k) this.f19220b).av.getAttributeValues());
            this.k.a(i2, ((k) this.f19220b).av.getAttributeValues());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(af afVar) {
        if (afVar.f23988a > 0) {
            if (afVar.f23988a != this.v) {
                ((k) this.f19220b).f(afVar.f23988a);
            }
            this.v = afVar.f23988a;
            this.l.a(this.v, afVar.f23989b);
        }
    }

    public void c() {
        ((k) this.f19220b).O();
        this.f24014a.a("PRODUCT_SUBMIT_PRODUCT", this.N);
        this.f24014a.a("DELETE_MODEL", this.M);
    }

    public void d() {
        this.f24014a.b("PRODUCT_SUBMIT_PRODUCT", this.N);
        this.f24014a.b("DELETE_MODEL", this.M);
    }

    public void b() {
        this.u.b();
        this.f24015c.b("ITEM_SAVED_LOCALLY", this.I);
        this.f24015c.b("ITEM_CATEGORY_LIST_LOCAL_LOAD", this.J);
        this.f24015c.b("ON_IMAGE_SELECTED", this.K);
        this.f24015c.b("ON_IMAGE_SELECTED_FAIL", this.L);
        this.f24015c.b("ITEM_LOADED", this.R);
        this.f24015c.b("EDIT_ITEM_SUCCESS", this.P);
        this.f24015c.b("EDIT_ITEM_ERROR", this.Q);
        this.f24015c.b("ITEM_DELETE", this.E);
        this.f24015c.b("ITEM_DETAIL_LOAD", this.S);
        this.f24015c.b("SHOP_INFO_FETCHED", this.H);
        this.f24015c.b("SHOP_INFO_LOCAL_LOAD", this.G);
        this.f24015c.b("ON_IMAGE_SELECTED_DONE", this.F);
        this.f24015c.b("ADD_ITEM_RESULT_VALIDATE", this.O);
    }

    /* access modifiers changed from: package-private */
    public void a(da.a aVar) {
        ((k) this.f19220b).a(aVar.f16774a, aVar.f16775b, aVar.f16777d, aVar.f16776c, 0, true);
        ((k) this.f19220b).M();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        r.a().b((int) R.string.sp_unable_to_load_image);
    }

    /* access modifiers changed from: package-private */
    public void a(VideoState videoState) {
        if (videoState.video.getItemId() == this.s) {
            this.w = videoState;
            ((k) this.f19220b).a(videoState.progress);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(VideoState videoState) {
        if (videoState.video.getItemId() == this.s) {
            this.w = videoState;
            ((k) this.f19220b).a(videoState.video.getThumb(), videoState.video.getOutPath(), 0, videoState.video.getDuration(), videoState.video.getStatus(), false);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(VideoState videoState) {
        if (videoState.video.getItemId() == this.s) {
            this.w = videoState;
            ((k) this.f19220b).a(videoState.video.getThumb(), videoState.video.getOutPath(), 0, videoState.video.getDuration(), videoState.video.getStatus(), false);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((k) this.f19220b).F();
        if (!c(aVar)) {
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                int i2 = aVar.f17892a;
                if (i2 == -100) {
                    str = b.e(R.string.sp_network_error);
                } else if (i2 == 17) {
                    str = b.e(R.string.sp_server_price_limit_error);
                } else if (i2 == 1) {
                    str = b.e(R.string.sp_server_parameter_error);
                } else if (i2 == 2) {
                    str = b.e(R.string.sp_server_permission_error);
                } else if (i2 != 3) {
                    switch (i2) {
                        case 30:
                        case 31:
                        case 32:
                            str = b.e(R.string.sp_add_product_category_error);
                            break;
                        default:
                            str = b.e(R.string.sp_server_error);
                            break;
                    }
                } else {
                    str = b.e(R.string.sp_max_product_limit_reached);
                }
            }
            ((k) this.f19220b).a(str);
        }
    }

    private boolean c(com.shopee.app.network.c.d.a aVar) {
        if (this.C.a("delist_product") && aVar.f17892a == 3 && aVar.f17894c.item_limit != null) {
            ((k) this.f19220b).a(j.b.a(b.a(R.string.listing_limit_reached_content, Integer.valueOf(com.shopee.app.d.b.b.a(aVar.f17894c.item_limit, 100)))), (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    ((k) e.this.f19220b).W.setChecked(false);
                    e.this.N.onEvent(new com.garena.android.appkit.b.a());
                }
            });
            return true;
        } else if (aVar.f17892a != 67) {
            return false;
        } else {
            ((k) this.f19220b).a(b.e(R.string.sp_invalid_category_error_msg));
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void a(AddProductInfo addProductInfo) {
        k.f24080a = true;
        ((k) this.f19220b).setProduct(addProductInfo);
        ((k) this.f19220b).F();
        a(addProductInfo.getCategoryIdPath(), addProductInfo.getModelId());
        b(addProductInfo);
        if (this.A) {
            b(addProductInfo.getName());
        }
    }

    private void b(AddProductInfo addProductInfo) {
        int status = addProductInfo.getStatus();
        if (status == 2) {
            ((k) this.f19220b).B.setVisibility(0);
            ((k) this.f19220b).B.setBackgroundColor(b.a(R.color.primary12));
            ((k) this.f19220b).D.setText(b.e(R.string.sp_product_under_review_label));
            ((k) this.f19220b).C.setVisibility(8);
            ((k) this.f19220b).E.setVisibility(8);
            k.f24081b = false;
        } else if (status == 3 || status == 4 || status == 5) {
            ((k) this.f19220b).B.setVisibility(0);
            String bannedReason = addProductInfo.getBannedReason();
            if (TextUtils.isEmpty(bannedReason)) {
                ((k) this.f19220b).C.setText(b.e(R.string.sp_banned_product_notice));
            } else {
                String a2 = b.a(R.string.sp_banned_product_notice_details, bannedReason);
                SpannableString valueOf = SpannableString.valueOf(b.a(R.string.sp_banned_product_notice_details, bannedReason));
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(b.a(R.color.black87));
                int indexOf = a2.indexOf(bannedReason);
                valueOf.setSpan(foregroundColorSpan, indexOf, bannedReason.length() + indexOf, 33);
                ((k) this.f19220b).C.setText(valueOf);
            }
            k.f24081b = false;
        } else {
            k.f24081b = true;
            ((k) this.f19220b).B.setVisibility(8);
            if (addProductInfo.isInvalidCategory()) {
                String e2 = b.e(R.string.add_product_invalid_category_reminder_highlight);
                String e3 = b.e(R.string.add_product_invalid_category_reminder);
                int indexOf2 = e3.indexOf("%1$s");
                if (indexOf2 != -1 && e2.length() + indexOf2 < e3.length()) {
                    SpannableString spannableString = new SpannableString(e3.replace("%1$s", e2));
                    spannableString.setSpan(new ForegroundColorSpan(b.a(R.color.primary)), indexOf2, e2.length() + indexOf2, 33);
                    ((k) this.f19220b).a((Spannable) spannableString);
                    ((k) this.f19220b).V();
                }
            } else if (addProductInfo.getAttributeStatus() == 0) {
                ((k) this.f19220b).a((Spannable) new SpannableString(b.e(R.string.add_product_attribute_reminder)));
            }
        }
    }

    public void b(List<ModelDetail> list, List<WholesaleTierModel> list2) {
        if (b(list) || !af.a(list2)) {
            ((k) this.f19220b).S();
        } else {
            ((k) this.f19220b).R();
        }
    }

    private boolean l() {
        return this.q.wholesaleEnabled() || this.f24019g.isWholesaleEnabled();
    }

    public boolean b(List<ModelDetail> list) {
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
        Long a2 = com.shopee.app.g.e.a(modelDetail.getDisplayPrice(), "IDR");
        return a2 != null ? a2.longValue() : modelDetail.getPrice();
    }

    public int c(int i2) {
        if (i2 < 0) {
            return ItemCondition.NOT_SET.getValue();
        }
        return U[i2].getValue();
    }

    public void i() {
        if (this.s <= 0) {
            ((k) this.f19220b).z();
        } else {
            ((k) this.f19220b).A();
        }
    }

    static {
        T[0] = b.e(R.string.sp_label_new_tag);
        T[1] = b.e(R.string.sp_label_used_new);
        U[0] = ItemCondition.NEW_WITH_TAGS;
        U[1] = ItemCondition.USED_LIKE_NEW;
    }

    public void c(long j2) {
        ((k) this.f19220b).B();
        new com.shopee.app.network.d.n(j2).g();
    }

    public ShareMessage a(long j2, AddProductInfo addProductInfo, String str) {
        String str2 = com.shopee.app.util.i.f7041d + this.t.getUserName() + Constants.URL_PATH_DELIMITER + j2;
        ShareMessage shareMessage = new ShareMessage();
        shareMessage.setShopID(this.t.getShopId());
        shareMessage.setShopName(this.t.getShopName());
        shareMessage.setShopDesc(this.t.getDescription());
        shareMessage.setShopImage(this.t.getCover());
        shareMessage.setItemID(j2);
        shareMessage.setItemCurrency("IDR");
        shareMessage.setItemDesc(addProductInfo.getDescription());
        shareMessage.setItemName(addProductInfo.getName());
        shareMessage.setUsername(this.t.getUserName());
        shareMessage.setItemPrice(addProductInfo.getPrice());
        shareMessage.setWatermarkProductDesc("<style color='#F5FFFFFF'>" + str2.replace("http://", "") + "</style>");
        shareMessage.setItemImage(str);
        shareMessage.setAvatar((String) com.shopee.app.data.store.ak.a().f().b(null));
        shareMessage.setUrl(str2);
        return shareMessage;
    }

    public int a(boolean z2) {
        ShopDetail shopDetail = this.t;
        boolean z3 = shopDetail != null && shopDetail.getBankStatus() == 0;
        return !TextUtils.isEmpty(this.f24019g.getPhone()) ? (!z3 || !z2) ? 0 : 1 : (!z3 || !z2) ? 2 : 3;
    }

    public void j() {
        VideoState videoState = this.w;
        if (videoState != null) {
            videoState.runnable.discard();
        }
    }

    public void b(int i2, int i3) {
        if (i3 > 0) {
            this.v = i3;
            this.l.a(this.v, ((k) this.f19220b).av.getAttributeValues());
        }
        ((k) this.f19220b).e(i3);
        ((k) this.f19220b).C();
        this.j.a(i2);
    }

    public void a(List<Integer> list, int i2) {
        if (i2 > 0) {
            this.v = i2;
            this.l.a(this.v, ((k) this.f19220b).av.getAttributeValues());
        }
        ((k) this.f19220b).e(i2);
        if (!af.a(list)) {
            ((k) this.f19220b).C();
            this.j.a(list);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(List<VMItemAttribute> list) {
        if (!af.a(list)) {
            ((k) this.f19220b).a(this.v, list);
            ((k) this.f19220b).L();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(u uVar) {
        ((k) this.f19220b).b(this.v, uVar);
    }

    /* access modifiers changed from: package-private */
    public void b(u uVar) {
        ((k) this.f19220b).a(this.v, uVar);
    }

    /* access modifiers changed from: package-private */
    public void c(u uVar) {
        ((k) this.f19220b).a(this.v, uVar);
        d(((k) this.f19220b).getViewState().getAttributeValues());
    }

    /* access modifiers changed from: package-private */
    public void k() {
        ((k) this.f19220b).k();
    }

    /* access modifiers changed from: package-private */
    public void d(List<u> list) {
        this.k.a(this.v, list);
    }

    /* access modifiers changed from: package-private */
    public void e(List<WholesaleTierModel> list) {
        if (!af.a(list)) {
            ((k) this.f19220b).d(list);
            ((k) this.f19220b).c(f(list));
            return;
        }
        ((k) this.f19220b).d(list);
        ((k) this.f19220b).c(((k) this.f19220b).getContext().getString(R.string.wholesale_description));
    }

    private String f(List<WholesaleTierModel> list) {
        WholesaleTierModel wholesaleTierModel = list.get(0);
        if (list.size() == 1) {
            return ">= " + wholesaleTierModel.f24170a + ", " + wholesaleTierModel.f24172c;
        }
        return wholesaleTierModel.f24170a + "-" + wholesaleTierModel.f24171b + ", " + wholesaleTierModel.f24172c;
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        final AddProductInfo addProductInfo = ((k) this.f19220b).av;
        if (addProductInfo == null || !addProductInfo.isInvalidCategory()) {
            ShopDetail shopDetail = this.t;
            if (!this.q.isCategoryRecommendationActive(shopDetail != null && shopDetail.isShopeeVerified())) {
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.B;
            if (str2 == null || !str2.trim().equals(str.trim())) {
                this.B = str;
                String str3 = this.y.c() ? "3" : "1";
                if (this.y.f()) {
                    str3 = "2";
                }
                this.z.a(str3, str, "ID".toLowerCase()).b(io.b.h.a.b()).a(new io.b.d.f<List<Integer>>() {
                    /* renamed from: a */
                    public void accept(List<Integer> list) throws Exception {
                        if (list != null) {
                            AddProductInfo addProductInfo = addProductInfo;
                            if (addProductInfo != null) {
                                addProductInfo.setCatRecommendationIds(new ArrayList(list));
                            }
                        }
                    }
                }, (io.b.d.f<? super Throwable>) new io.b.d.f<Throwable>() {
                    /* renamed from: a */
                    public void accept(Throwable th) throws Exception {
                        com.garena.android.appkit.d.a.a(th);
                        AddProductInfo addProductInfo = addProductInfo;
                        if (addProductInfo != null) {
                            addProductInfo.setCatRecommendationIds(new ArrayList());
                        }
                    }
                });
            }
        }
    }
}
