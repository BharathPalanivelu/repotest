package com.shopee.feeds.feedlibrary.editor.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.feeds.feedlibrary.activity.CreatePostActivity;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.PhotoFileInfoEntity;
import com.shopee.feeds.feedlibrary.editor.PhotoEditLayer;
import com.shopee.feeds.feedlibrary.editor.b.a;
import com.shopee.feeds.feedlibrary.editor.b.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.k;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.w;
import io.b.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class a extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    Context f27786a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f27787b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<View> f27788c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f27789d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f27790e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f27791f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f27792g;
    /* access modifiers changed from: private */
    public HashMap<String, Integer[]> h;
    private HashMap<String, String> i;
    private int j;
    /* access modifiers changed from: private */
    public C0427a k;
    private LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> l = new LinkedHashMap<>();
    private LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.text.b>> m = new LinkedHashMap<>();
    private LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>> n = new LinkedHashMap<>();
    private int o;
    private int p = 0;
    /* access modifiers changed from: private */
    public int q;
    private boolean r = false;
    /* access modifiers changed from: private */
    public b s;
    /* access modifiers changed from: private */
    public boolean t = false;
    private com.shopee.feeds.feedlibrary.util.d.c u;
    private d v;

    /* renamed from: com.shopee.feeds.feedlibrary.editor.a.a$a  reason: collision with other inner class name */
    public interface C0427a {
        void a();

        void b();
    }

    public interface b {
        void a(long j);
    }

    public interface c {
        void a(int i);
    }

    public interface d {
        void a();
    }

    public interface e {
        void a(int i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    static /* synthetic */ int a(a aVar) {
        int i2 = aVar.p;
        aVar.p = i2 + 1;
        return i2;
    }

    static /* synthetic */ int b(a aVar) {
        int i2 = aVar.p;
        aVar.p = i2 - 1;
        return i2;
    }

    static /* synthetic */ int c(a aVar) {
        int i2 = aVar.q;
        aVar.q = i2 + 1;
        return i2;
    }

    public a(Context context, int i2) {
        this.f27786a = context;
        this.f27788c = new SparseArray<>();
        this.f27789d = new ArrayList<>();
        this.f27790e = new HashMap<>();
        this.f27791f = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        this.f27792g = new HashMap<>();
        this.j = i2;
        this.u = new com.shopee.feeds.feedlibrary.util.d.c((Activity) context);
    }

    public void a(b bVar) {
        this.s = bVar;
    }

    public void a(d dVar) {
        this.v = dVar;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (this.f27788c.get(i2) == null) {
            c(i2);
            d dVar = this.v;
            if (dVar != null) {
                dVar.a();
            }
        }
        View view = this.f27788c.get(i2);
        String str = this.f27789d.get(i2);
        final PhotoEditLayer photoEditLayer = (PhotoEditLayer) view.findViewById(c.e.edit_layer);
        photoEditLayer.setNetImageMap(this.f27787b);
        photoEditLayer.getTagEditor().a(new a.C0429a<com.shopee.feeds.feedlibrary.editor.tag.a>() {
            /* renamed from: a */
            public void b(com.shopee.feeds.feedlibrary.editor.tag.a aVar) {
                a.a(a.this);
                a.this.a(photoEditLayer.getPath(), photoEditLayer.getTagEditor());
            }

            /* renamed from: b */
            public void a(com.shopee.feeds.feedlibrary.editor.tag.a aVar) {
                a.b(a.this);
                a.this.a(photoEditLayer.getPath(), photoEditLayer.getTagEditor());
            }
        });
        photoEditLayer.getTextEditor().a(new a.C0429a<com.shopee.feeds.feedlibrary.editor.text.b>() {
            /* renamed from: a */
            public void b(com.shopee.feeds.feedlibrary.editor.text.b bVar) {
                a.this.a(photoEditLayer.getPath(), photoEditLayer.getTextEditor());
            }

            /* renamed from: b */
            public void a(com.shopee.feeds.feedlibrary.editor.text.b bVar) {
                a.this.a(photoEditLayer.getPath(), photoEditLayer.getTextEditor());
            }
        });
        photoEditLayer.getStickerEditor().a(new a.C0429a<com.shopee.feeds.feedlibrary.editor.sticker.a.d>() {
            /* renamed from: a */
            public void b(com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar) {
                a.this.a(photoEditLayer.getPath(), photoEditLayer.getStickerEditor());
            }

            /* renamed from: b */
            public void a(com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar) {
                a.this.a(photoEditLayer.getPath(), photoEditLayer.getStickerEditor());
            }
        });
        photoEditLayer.a(this.j, str, this.l.get(str), new PhotoEditLayer.a() {
            public void a(String str, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a> arrayList) {
                a.this.a(str, photoEditLayer.getTagEditor());
            }

            public void a(long j) {
                a.c(a.this);
                if (a.this.q >= a.this.f27789d.size() && a.this.k != null) {
                    a.this.k.b();
                }
                if (a.this.s != null) {
                    a.this.s.a(j);
                }
            }

            public void a() {
                if (j.a().w() && !a.this.t) {
                    u.b(a.this.f27786a, com.garena.android.appkit.tools.b.e(c.g.feeds_network_error_toast));
                    boolean unused = a.this.t = true;
                }
            }
        });
        viewGroup.removeView(view);
        viewGroup.addView(view);
        return view;
    }

    public void a(List<String> list) {
        String str;
        if (list != null) {
            ArrayList arrayList = null;
            if (j.a().w()) {
                arrayList = new ArrayList(list.size());
                for (String next : list) {
                    if (k.c(next)) {
                        str = com.shopee.feeds.feedlibrary.a.b.c.a().getDir("images", 0).getPath() + File.separator + k.a(next) + k.b(next);
                    } else {
                        str = next;
                    }
                    this.f27787b.put(str, next);
                    arrayList.add(str);
                }
            }
            if (arrayList != null) {
                list = arrayList;
            }
            ArrayList<String> arrayList2 = this.f27789d;
            if (arrayList2 == null) {
                this.f27789d = new ArrayList<>(list.size());
                this.f27789d.addAll(list);
            } else {
                arrayList2.clear();
                this.f27789d.addAll(list);
            }
            Iterator<String> it = this.f27789d.iterator();
            while (it.hasNext()) {
                String next2 = it.next();
                this.l.put(next2, new ArrayList());
                this.m.put(next2, new ArrayList());
                this.n.put(next2, new ArrayList());
            }
        }
        notifyDataSetChanged();
    }

    public void a(LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> linkedHashMap) {
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            this.l.clear();
            this.l.putAll(linkedHashMap);
        }
    }

    public void a(int i2) {
        this.o = i2;
    }

    public int a() {
        return this.o;
    }

    public int getCount() {
        return this.f27789d.size();
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (this.f27788c.get(i2) != null) {
            viewGroup.removeView(this.f27788c.get(i2));
            this.f27788c.remove(i2);
        }
    }

    private void c(int i2) {
        this.f27788c.put(i2, LayoutInflater.from(this.f27786a).inflate(c.f.feeds_layout_editor_picture, (ViewGroup) null, false));
    }

    public void b() {
        PhotoEditEntity photoEditEntity = new PhotoEditEntity();
        photoEditEntity.setCurrentPathList(this.f27789d);
        photoEditEntity.setEditImagePathMap(this.f27790e);
        photoEditEntity.setCleanEditImagePathMap(this.f27791f);
        photoEditEntity.setCleanEditImageSizeMap(this.h);
        photoEditEntity.setMainColorMap(this.i);
        photoEditEntity.setSaveAlbumPathMap(this.f27792g);
        photoEditEntity.setTextInfoMap(this.m);
        photoEditEntity.setTagInfoMap(this.l);
        try {
            j();
        } catch (Throwable unused) {
        }
        b(this.n);
        photoEditEntity.setStickerInfoMap(this.n);
        photoEditEntity.setSource(this.j);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PhotoEditEntity.PHOTO_INFO, photoEditEntity);
        Intent intent = new Intent(this.f27786a, CreatePostActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("source_mode", 1);
        intent.putStringArrayListExtra("source_path", this.f27789d);
        this.f27786a.startActivity(intent);
    }

    private void b(LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.sticker.a.d>> linkedHashMap) {
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str : linkedHashMap.keySet()) {
                ArrayList arrayList = linkedHashMap.get(str);
                if (arrayList != null && arrayList.size() > 0) {
                    int i2 = -1;
                    int i3 = -1;
                    float f2 = -1.0f;
                    float f3 = -1.0f;
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) arrayList.get(i4);
                        if (dVar.q() == 3) {
                            f2 = dVar.r();
                            i2 = i4;
                        } else if (dVar.q() == 4) {
                            f3 = dVar.r();
                            i3 = i4;
                        }
                    }
                    if (i2 > -1 && i3 > -1) {
                        if (i2 < i3) {
                            if (f2 > f3) {
                                Collections.swap(arrayList, i2, i3);
                            }
                        } else if (f2 < f3) {
                            Collections.swap(arrayList, i2, i3);
                        }
                    }
                }
            }
        }
    }

    private void j() {
        Map<String, PhotoEditLayer> e2 = e();
        if (e2 != null && e2.size() > 0) {
            for (String next : e2.keySet()) {
                PhotoEditLayer photoEditLayer = e2.get(next);
                if (photoEditLayer != null) {
                    com.shopee.feeds.feedlibrary.editor.sticker.d stickerEditor = photoEditLayer.getStickerEditor();
                    if (stickerEditor == null) {
                        continue;
                    } else {
                        com.shopee.feeds.feedlibrary.editor.b.c h2 = stickerEditor.h();
                        if (h2 != null) {
                            ArrayList arrayList = this.n.get(next);
                            if (arrayList != null && arrayList.size() > 0) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) it.next();
                                    if (dVar != null && (dVar instanceof com.shopee.feeds.feedlibrary.editor.sticker.a.b)) {
                                        dVar.i(h2.getScaleX());
                                        dVar.j(w.a(h2.getScaleX()));
                                        h.b("", "updateStickerMap " + dVar.toString());
                                        dVar.g(Math.abs(dVar.h()));
                                        dVar.h(Math.abs(dVar.i()));
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public PhotoEditLayer c() {
        return b(a());
    }

    public PhotoEditLayer d() {
        return b(0);
    }

    public PhotoEditLayer b(int i2) {
        if (i2 < 0 || i2 >= this.f27788c.size()) {
            return new PhotoEditLayer(this.f27786a);
        }
        return (PhotoEditLayer) this.f27788c.get(i2).findViewById(c.e.edit_layer);
    }

    public Map<String, PhotoEditLayer> e() {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < this.f27788c.size(); i2++) {
            hashMap.put(this.f27789d.get(i2), b(i2));
        }
        return hashMap;
    }

    public void a(final e eVar) {
        a.k.a(new Callable<Object>() {
            public Object call() throws Exception {
                ArrayList<String> a2 = com.shopee.feeds.feedlibrary.bg.b.a.a((ArrayList<String>) a.this.f27789d, (HashMap<String, String>) a.this.f27792g);
                if (a2 == null || a2.size() <= 0) {
                    eVar.a(-1);
                }
                Iterator<String> it = a2.iterator();
                while (it.hasNext()) {
                    com.shopee.feeds.feedlibrary.view.preview.j.a(it.next());
                }
                eVar.a(0);
                return null;
            }
        });
    }

    public boolean f() {
        return this.u.a("android.permission.READ_EXTERNAL_STORAGE") && this.u.a("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public void a(final MediaCompressParam mediaCompressParam, final d.a aVar, final c cVar) {
        this.u.b("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").a(new o<Boolean>() {
            public void a() {
            }

            public void a(io.b.b.b bVar) {
            }

            public void a(Throwable th) {
            }

            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    Map<String, PhotoEditLayer> e2 = a.this.e();
                    a.this.f27790e.clear();
                    a.this.f27791f.clear();
                    final boolean i = com.shopee.feeds.feedlibrary.data.c.b.i();
                    Iterator it = a.this.f27789d.iterator();
                    while (it.hasNext()) {
                        final String str = (String) it.next();
                        final PhotoEditLayer photoEditLayer = e2.get(str);
                        if (photoEditLayer != null) {
                            photoEditLayer.a(false, false, mediaCompressParam, new PhotoEditLayer.b() {
                                public void a(String str, PhotoFileInfoEntity photoFileInfoEntity) {
                                    a.this.f27790e.put(str, photoFileInfoEntity.getFilePath());
                                    h.b("%s", "dbload " + str + ", " + photoFileInfoEntity.getFilePath());
                                    photoEditLayer.a(false, true, mediaCompressParam, new PhotoEditLayer.b() {
                                        public void a(String str, PhotoFileInfoEntity photoFileInfoEntity) {
                                            a.this.f27792g.put(str, photoFileInfoEntity.getFilePath());
                                            photoEditLayer.a(true, false, mediaCompressParam, new PhotoEditLayer.b() {
                                                public void a(String str, PhotoFileInfoEntity photoFileInfoEntity) {
                                                    a.this.f27791f.put(str, photoFileInfoEntity.getFilePath());
                                                    if (photoFileInfoEntity.getWidthPixels() > 0) {
                                                        j.a().a((float) photoFileInfoEntity.getWidthPixels());
                                                        j.a().b((float) photoFileInfoEntity.getHeightPixels());
                                                    }
                                                    a.this.h.put(str, new Integer[]{Integer.valueOf(photoFileInfoEntity.getWidthPixels()), Integer.valueOf(photoFileInfoEntity.getHeightPixels())});
                                                    if (a.this.f27791f.size() == a.this.f27789d.size()) {
                                                        a.this.k();
                                                        aVar.a();
                                                    }
                                                }
                                            }, i);
                                        }
                                    }, i);
                                }
                            }, i);
                        } else {
                            a.k.a(new Callable<PhotoFileInfoEntity>() {
                                /* renamed from: a */
                                public PhotoFileInfoEntity call() throws Exception {
                                    com.shopee.feeds.feedlibrary.view.preview.j.a(false);
                                    return PhotoEditLayer.a(str);
                                }
                            }).a(new a.h<PhotoFileInfoEntity, Void>() {
                                /* renamed from: a */
                                public Void then(a.k<PhotoFileInfoEntity> kVar) throws Exception {
                                    PhotoFileInfoEntity f2 = kVar.f();
                                    if (f2 == null) {
                                        return null;
                                    }
                                    a.this.f27790e.put(str, f2.getFilePath());
                                    a.this.f27791f.put(str, f2.getFilePath());
                                    if (f2.getWidthPixels() > 0) {
                                        j.a().a((float) f2.getWidthPixels());
                                        j.a().b((float) f2.getHeightPixels());
                                    }
                                    a.this.h.put(str, new Integer[]{Integer.valueOf(f2.getWidthPixels()), Integer.valueOf(f2.getHeightPixels())});
                                    if (a.this.f27790e.size() != a.this.f27789d.size()) {
                                        return null;
                                    }
                                    a.this.k();
                                    aVar.a();
                                    return null;
                                }
                            }, a.k.f377b);
                        }
                    }
                    return;
                }
                c cVar = cVar;
                if (cVar != null) {
                    cVar.a(-1);
                }
            }
        });
    }

    public void a(C0427a aVar) {
        this.k = aVar;
    }

    public boolean g() {
        Map<String, PhotoEditLayer> e2 = e();
        int i2 = 0;
        for (String str : e2.keySet()) {
            com.shopee.feeds.feedlibrary.editor.b.d dVar = e2.get(str);
            if (dVar != null) {
                i2 += dVar.getTextEditor().a().size();
            }
        }
        if (i2 < 8) {
            return true;
        }
        return false;
    }

    public int h() {
        Map<String, PhotoEditLayer> e2 = e();
        int i2 = 0;
        for (String str : e2.keySet()) {
            com.shopee.feeds.feedlibrary.editor.b.d dVar = e2.get(str);
            if (dVar != null) {
                i2 += dVar.getTagEditor().a().size();
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public void a(String str, com.shopee.feeds.feedlibrary.editor.tag.c cVar) {
        C0427a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
        this.l.put(str, cVar.a());
        if (this.j == 0) {
            this.r = true;
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        HashMap<String, String> hashMap = this.f27791f;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry next : this.f27791f.entrySet()) {
                try {
                    String str = (String) next.getKey();
                    if (!com.shopee.feeds.feedlibrary.util.d.a((String) next.getValue())) {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        if (decodeFile != null) {
                            this.i.put(str, w.a(androidx.j.a.b.a(decodeFile).a().a(-7829368)));
                            decodeFile.recycle();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, com.shopee.feeds.feedlibrary.editor.text.c cVar) {
        this.m.put(str, cVar.a());
        this.r = true;
    }

    /* access modifiers changed from: private */
    public void a(String str, com.shopee.feeds.feedlibrary.editor.sticker.d dVar) {
        this.n.put(str, dVar.a());
        this.r = true;
    }

    public boolean i() {
        return this.r;
    }
}
