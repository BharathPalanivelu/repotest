package com.shopee.feeds.feedlibrary.util.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.picture.LocalMedia;
import com.shopee.feeds.feedlibrary.picture.LocalMediaFolder;
import com.shopee.feeds.feedlibrary.picture.PictureSelectionConfig;
import com.shopee.feeds.feedlibrary.picture.a;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.d.c;
import com.shopee.feeds.feedlibrary.util.u;
import io.b.b.b;
import io.b.o;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    c f28276a;

    /* renamed from: b  reason: collision with root package name */
    PictureSelectionConfig f28277b;

    /* renamed from: c  reason: collision with root package name */
    TextView f28278c;

    /* renamed from: d  reason: collision with root package name */
    Fragment f28279d;

    /* renamed from: e  reason: collision with root package name */
    C0436a f28280e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f28281f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f28282g;
    private com.shopee.feeds.feedlibrary.picture.a h;
    /* access modifiers changed from: private */
    public ArrayList<LocalMediaFolder> i = new ArrayList<>();
    /* access modifiers changed from: private */
    public List<LocalMedia> j = new ArrayList();

    /* renamed from: com.shopee.feeds.feedlibrary.util.c.a$a  reason: collision with other inner class name */
    public interface C0436a {
        void a();

        void a(String str, List<LocalMedia> list);

        void a(List<LocalMediaFolder> list);

        void b();
    }

    public a(Context context, Fragment fragment, TextView textView) {
        this.f28281f = context;
        this.f28277b = PictureSelectionConfig.a();
        this.f28276a = new c((Activity) context);
        this.f28278c = textView;
        this.f28279d = fragment;
        this.h = new com.shopee.feeds.feedlibrary.picture.a((androidx.fragment.app.c) context, 0, false, (long) this.f28277b.l, 0);
        TextView textView2 = this.f28278c;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.a();
                }
            });
        }
    }

    public void a() {
        this.f28276a.b("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").a(new o<Boolean>() {
            public void a() {
            }

            public void a(b bVar) {
            }

            public void a(Throwable th) {
            }

            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    a.this.b();
                    return;
                }
                a.this.f28280e.b();
                u.a(a.this.f28281f, "Permission Denied!");
            }
        });
    }

    public void b() {
        this.h.a((a.b) new a.b() {
            public void a(List<LocalMediaFolder> list) {
                if (!a.this.f28282g) {
                    a.this.d();
                    if (list.size() > 0) {
                        ArrayList unused = a.this.i = (ArrayList) list;
                        if (a.this.f28280e != null) {
                            a.this.f28280e.a(a.this.i);
                        }
                        LocalMediaFolder localMediaFolder = list.get(0);
                        localMediaFolder.a(true);
                        String a2 = localMediaFolder.a();
                        List<LocalMedia> c2 = localMediaFolder.c();
                        if (c2.size() <= 0) {
                            a.this.e();
                        } else if (c2.size() > a.this.j.size()) {
                            List unused2 = a.this.j = c2;
                            if (a.this.f28280e != null) {
                                boolean unused3 = a.this.f28282g = true;
                                a.this.f28280e.a(a2, a.this.j);
                            }
                        }
                    } else {
                        a.this.e();
                    }
                }
            }
        });
    }

    public void a(String str) {
        if (!d.a(str)) {
            this.j.add(0, new LocalMedia(str, 0, 0, "image/jpeg"));
            C0436a aVar = this.f28280e;
            if (aVar != null) {
                aVar.a(com.garena.android.appkit.tools.b.e(c.g.feeds_picture_gallery), this.j);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        ArrayList<LocalMediaFolder> arrayList = this.i;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public boolean c() {
        ArrayList<LocalMediaFolder> arrayList = this.i;
        return arrayList != null && arrayList.size() > 0;
    }

    /* access modifiers changed from: private */
    public void e() {
        C0436a aVar = this.f28280e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(C0436a aVar) {
        this.f28280e = aVar;
    }
}
