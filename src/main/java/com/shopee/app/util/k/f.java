package com.shopee.app.util.k;

import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.be;
import com.shopee.app.g.d;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.video.c;
import com.shopee.app.upload.UploadRunnable;
import com.shopee.app.util.f.a;
import com.shopee.app.util.i;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemExtInfo;
import com.shopee.protocol.shop.VideoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final n f26399a;

    /* renamed from: b  reason: collision with root package name */
    private final g f26400b;

    /* renamed from: c  reason: collision with root package name */
    private final com.shopee.app.util.f.a f26401c;

    /* renamed from: d  reason: collision with root package name */
    private final a f26402d;

    /* renamed from: e  reason: collision with root package name */
    private final be f26403e;

    /* renamed from: f  reason: collision with root package name */
    private final ba f26404f;

    /* renamed from: g  reason: collision with root package name */
    private final SettingConfigStore f26405g;
    private final h h;
    /* access modifiers changed from: private */
    public long i = 0;
    private int j = 0;
    private ResponseCommon k;

    public f(n nVar, com.shopee.app.util.f.a aVar, h hVar, be beVar, ba baVar, SettingConfigStore settingConfigStore, g gVar) {
        this.f26399a = nVar;
        this.f26401c = aVar;
        this.f26400b = gVar;
        this.h = hVar;
        this.f26405g = settingConfigStore;
        this.f26403e = beVar;
        this.f26404f = baVar;
        this.f26402d = new a(Thread.currentThread());
    }

    public void run() {
        g a2 = this.h.a();
        if (a2 == null || !a2.requestId.equals(this.f26400b.requestId)) {
            b();
            return;
        }
        com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " RETRY: " + this.j, new Object[0]);
        this.f26402d.a(0);
        Item item = this.f26400b.item;
        String[] split = item.images.split(",");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        final long j2 = 0;
        for (String str : split) {
            long a3 = a(str + "_tn");
            long a4 = a(str);
            if (!(a3 == -1 || a4 == -1)) {
                j2 = j2 + a3 + a4;
                arrayList.add(str + "_tn");
                arrayList.add(str);
                arrayList2.add(str);
            }
        }
        if (j2 == 0) {
            a((int) UploadRunnable.NO_IMAGES);
            return;
        }
        f();
        this.i = 0;
        boolean z = false;
        int i2 = 0;
        for (String str2 : arrayList) {
            int a5 = this.f26401c.a(str2, (a.C0402a) new a.C0402a() {
                public void onProgress(int i, int i2) {
                    f fVar = f.this;
                    fVar.a(j2, fVar.i + ((long) i2));
                }
            });
            if (a5 != 1) {
                com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " - " + str2 + " FAILED: ", new Object[0]);
                z = true;
            } else {
                com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " - " + str2 + " PASSED: ", new Object[0]);
                this.i = this.i + a(str2);
                a(j2, this.i);
            }
            if (a5 == 2) {
                com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " DISCARDED: ", new Object[0]);
                return;
            } else if (this.f26402d.a() == -99) {
                com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " DISCARDED: ", new Object[0]);
                return;
            } else {
                i2 = a5;
            }
        }
        if (z) {
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " FAILED: image", new Object[0]);
            a(i2);
            return;
        }
        com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " PASSED: image", new Object[0]);
        g();
        if (this.f26400b.video != null && !TextUtils.isEmpty(this.f26400b.video.path)) {
            c a6 = c.a(MediaData.newVideoData(this.f26400b.video.thumb, this.f26400b.video.path, this.f26400b.video.duration));
            if (a6 != null && a6.a()) {
                String a7 = a6.a((c.a) new c.a() {
                    public void a(int i) {
                    }
                });
                this.f26400b.video.videoId = a7;
                this.f26404f.a(this.f26400b);
                if (!TextUtils.isEmpty(a7)) {
                    try {
                        Item.Builder builder = new Item.Builder(item);
                        ItemExtInfo.Builder builder2 = new ItemExtInfo.Builder((ItemExtInfo) com.shopee.app.network.f.f18486a.parseFrom(item.extinfo.i(), ItemExtInfo.class));
                        builder2.video_info_list(Collections.singletonList(new VideoInfo.Builder().video_id(this.f26400b.video.videoId).duration(Integer.valueOf(this.f26400b.video.duration)).thumb_url(this.f26400b.video.thumb).build()));
                        builder.extinfo(e.f.a(builder2.build().toByteArray()));
                        item = builder.build();
                    } catch (Exception unused) {
                    }
                }
            }
        }
        g();
        if (this.f26402d.a() == -99) {
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " DISCARDED: ", new Object[0]);
            return;
        }
        Item.Builder builder3 = new Item.Builder(item);
        builder3.images(d.a((List<String>) arrayList2));
        this.f26400b.item = builder3.build();
        com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " SERVER: request", new Object[0]);
        e eVar = new e(this.f26400b, this.f26405g.showProductWeight());
        this.k = eVar.a();
        if (this.k.errcode.intValue() == 0) {
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " SUCCESS: ", new Object[0]);
            a(eVar.b());
        } else if (this.k.errcode.intValue() == -100) {
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " FAILED: ErrorCode " + this.k.errcode, new Object[0]);
            a(this.k.errcode.intValue());
        } else if (this.k.errcode.intValue() == 11) {
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " FAILED: duplicate", new Object[0]);
            b();
        } else {
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " FAILED: server rejected us", new Object[0]);
            b(this.k.errcode.intValue());
        }
    }

    public ResponseCommon a() {
        return this.k;
    }

    private void f() {
        h();
    }

    private void g() {
        h().f26385b = 1.2d;
    }

    /* access modifiers changed from: private */
    public void a(long j2, long j3) {
        if (!this.f26402d.d()) {
            h().f26385b = (double) (((float) j3) / (((float) j2) * 1.0f));
        }
    }

    private void a(com.shopee.app.ui.product.add.a aVar) {
        b h2 = h();
        h2.f26388e = aVar;
        ShareMessage o = this.f26403e.o();
        String str = i.f7041d + o.getUsername() + Constants.URL_PATH_DELIMITER + h2.f26388e.f23949b;
        o.setItemID(h2.f26388e.f23949b);
        o.setUrl(i.f7041d + o.getUsername() + Constants.URL_PATH_DELIMITER + o.getItemID());
        StringBuilder sb = new StringBuilder();
        sb.append("<style color='#F5FFFFFF'>");
        sb.append(str.replace("http://", ""));
        sb.append("</style>");
        o.setWatermarkProductDesc(sb.toString());
        this.f26403e.a(o);
    }

    private void a(int i2) {
        int i3 = this.j;
        if (i3 < 5) {
            this.j = i3 + 1;
            g();
            com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.f26400b.item.name + " SLEEP: 8 sec", new Object[0]);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            run();
            return;
        }
        b(-100);
    }

    private void b(int i2) {
        h().f26387d = i2;
        g gVar = this.f26400b;
        gVar.status = 2;
        gVar.errorMessage = c(i2);
        this.f26404f.a(this.f26400b);
        throw new RuntimeException(String.valueOf(i2));
    }

    public void b() {
        h();
    }

    private b h() {
        b bVar = new b();
        bVar.f26384a = this.f26400b;
        bVar.f26386c = this;
        return bVar;
    }

    private long a(String str) {
        File file = new File(com.shopee.app.h.f.a().b(str));
        if (file.exists()) {
            return file.length();
        }
        return -1;
    }

    public void c() {
        this.f26402d.b();
    }

    public void d() {
        this.f26402d.c();
    }

    public void e() {
        this.f26402d.e();
    }

    private String c(int i2) {
        String str = b.e(R.string.sp_product_failed_noti_message_general) + "\t";
        if (i2 == -100) {
            return str + b.e(R.string.sp_network_error);
        }
        ResponseCommon responseCommon = this.k;
        if (responseCommon == null) {
            return str + b.e(R.string.sp_unknown_error);
        } else if (TextUtils.isEmpty(responseCommon.err_message)) {
            int intValue = this.k.errcode.intValue();
            if (intValue == -100) {
                return str + b.e(R.string.sp_network_error);
            } else if (intValue == 17) {
                return str + b.e(R.string.sp_server_price_limit_error);
            } else if (intValue == 1) {
                return str + b.e(R.string.sp_server_parameter_error);
            } else if (intValue == 2) {
                return str + b.e(R.string.sp_server_permission_error);
            } else if (intValue != 3) {
                return str + b.e(R.string.sp_unknown_error);
            } else {
                return str + b.e(R.string.sp_max_product_limit_reached);
            }
        } else {
            return str + this.k.err_message;
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Thread f26409a;

        /* renamed from: b  reason: collision with root package name */
        private BlockingQueue<Integer> f26410b = new ArrayBlockingQueue(40);

        /* renamed from: c  reason: collision with root package name */
        private boolean f26411c = false;

        public a(Thread thread) {
            this.f26409a = thread;
            a(0);
        }

        public int a() {
            try {
                return this.f26410b.take().intValue();
            } catch (InterruptedException unused) {
                return -99;
            }
        }

        public void b() {
            this.f26410b.clear();
        }

        public void c() {
            a(0);
        }

        public boolean d() {
            return this.f26411c;
        }

        public void a(int i) {
            this.f26410b.clear();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 40; i2++) {
                arrayList.add(Integer.valueOf(i));
            }
            this.f26410b.addAll(arrayList);
        }

        public void e() {
            this.f26411c = true;
            this.f26409a.interrupt();
        }
    }
}
