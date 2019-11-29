package com.shopee.app.ui.image;

import android.widget.ImageView;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.dj;
import com.shopee.app.g.d;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class i extends q<j> {

    /* renamed from: a  reason: collision with root package name */
    private final n f22967a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final dj f22968c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f22969d;

    /* renamed from: e  reason: collision with root package name */
    private e f22970e = new g() {
        public void onEvent(a aVar) {
            r.a().b((int) R.string.sp_image_save_fail);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f22971f = new g() {
        public void onEvent(a aVar) {
            ImageView unused = i.this.f22969d = (ImageView) aVar.data;
            d.a(((j) i.this.f19220b).getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 64, 0, R.string.msg_permission_gallery, R.string.sp_no_storage_access, R.string.sp_to_allow_gallery_hint, new d.a() {
                public void b() {
                }

                public void c() {
                }

                public void a() {
                    i.this.f22968c.a(i.this.f22969d);
                }
            });
        }
    };

    public i(n nVar, dj djVar) {
        this.f22967a = nVar;
        this.f22968c = djVar;
    }

    public void a() {
        this.f22967a.a("ON_IMAGE_SAVED_ALBUM_FAIL", this.f22970e);
        this.f22967a.a("ON_IMAGE_ACTION_ONE", this.f22971f);
    }

    public void b() {
        this.f22967a.b("ON_IMAGE_SAVED_ALBUM_FAIL", this.f22970e);
        this.f22967a.b("ON_IMAGE_ACTION_ONE", this.f22971f);
    }

    public void e() {
        this.f22968c.a(this.f22969d);
    }
}
