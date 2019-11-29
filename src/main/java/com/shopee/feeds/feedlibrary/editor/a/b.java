package com.shopee.feeds.feedlibrary.editor.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.shopee.feeds.feedlibrary.activity.CreatePostActivity;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.editor.VideoEditLayer;
import com.shopee.feeds.feedlibrary.editor.b.a;
import com.shopee.feeds.feedlibrary.editor.sticker.a.d;
import com.shopee.feeds.feedlibrary.editor.tag.c;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.k;
import com.shopee.feeds.feedlibrary.util.r;
import com.shopee.feeds.feedlibrary.view.CommonCheckButton;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    Context f27816a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public VideoEditLayer f27817b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f27818c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f27819d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f27820e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Integer[]> f27821f;

    /* renamed from: g  reason: collision with root package name */
    private a f27822g;
    private LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> h = new LinkedHashMap<>();
    private LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.text.b>> i = new LinkedHashMap<>();
    private LinkedHashMap<String, ArrayList<d>> j = new LinkedHashMap<>();
    private com.shopee.sdk.ui.a k;
    private boolean l = false;
    private TextView m;
    /* access modifiers changed from: private */
    public r n;
    private int o;

    public interface a {
        void a();
    }

    /* renamed from: com.shopee.feeds.feedlibrary.editor.a.b$b  reason: collision with other inner class name */
    public interface C0428b {
        void a(String str);
    }

    public void a(int i2) {
        this.o = i2;
    }

    public b(Activity activity, TextView textView) {
        this.f27816a = activity;
        this.m = textView;
        this.f27818c = new ArrayList<>();
        this.f27819d = new HashMap<>();
        this.f27820e = new HashMap<>();
        this.f27821f = new HashMap<>();
        this.k = new com.shopee.sdk.ui.a(activity);
        this.k.a(true);
        this.n = new r(this.f27816a);
    }

    public void a(final VideoEditLayer videoEditLayer, String str, CommonCheckButton commonCheckButton) {
        this.f27817b = videoEditLayer;
        this.f27818c.clear();
        this.f27818c.add(str);
        this.h.put(str, new ArrayList());
        this.i.put(str, new ArrayList());
        this.j.put(str, new ArrayList());
        if (j.a().t() == null) {
            com.shopee.feeds.feedlibrary.util.d.a((Object) "333333");
        }
        videoEditLayer.getTagEditor().a((c.b) new c.b<com.shopee.feeds.feedlibrary.editor.tag.a>() {
            public void a() {
                b.this.a(videoEditLayer.getPath(), videoEditLayer.getTagEditor());
            }

            /* renamed from: a */
            public void b(com.shopee.feeds.feedlibrary.editor.tag.a aVar) {
                b.this.a(videoEditLayer.getPath(), videoEditLayer.getTagEditor());
            }

            /* renamed from: b */
            public void a(com.shopee.feeds.feedlibrary.editor.tag.a aVar) {
                b.this.a(videoEditLayer.getPath(), videoEditLayer.getTagEditor());
            }
        });
        videoEditLayer.getTextEditor().a(new a.C0429a<com.shopee.feeds.feedlibrary.editor.text.b>() {
            /* renamed from: a */
            public void b(com.shopee.feeds.feedlibrary.editor.text.b bVar) {
                b.this.a(videoEditLayer.getPath(), videoEditLayer.getTextEditor());
            }

            /* renamed from: b */
            public void a(com.shopee.feeds.feedlibrary.editor.text.b bVar) {
                b.this.a(videoEditLayer.getPath(), videoEditLayer.getTextEditor());
            }
        });
        videoEditLayer.getStickerEditor().a(new a.C0429a<d>() {
            /* renamed from: a */
            public void b(d dVar) {
                b.this.a(videoEditLayer.getPath(), videoEditLayer.getStickerEditor());
            }

            /* renamed from: b */
            public void a(d dVar) {
                b.this.a(videoEditLayer.getPath(), videoEditLayer.getStickerEditor());
            }
        });
        videoEditLayer.a(str, this.o);
        commonCheckButton.setCheckListener(new CommonCheckButton.a() {
            public void a(boolean z) {
                videoEditLayer.getVideoView().a(z);
                e.m(!z);
            }
        });
        b();
        this.f27817b.e();
    }

    public VideoEditLayer a() {
        return this.f27817b;
    }

    public void b() {
        this.f27817b.f();
        this.f27821f.put(this.f27818c.get(0), new Integer[]{Integer.valueOf(j.a().t().getVideoWidth()), Integer.valueOf(j.a().t().getVideoHeight())});
    }

    public void a(String str) {
        VideoEditEntity videoEditEntity = new VideoEditEntity();
        videoEditEntity.setCurrentPathList(this.f27818c);
        videoEditEntity.setDuration(j.a().t().getDuration());
        videoEditEntity.setEditImagePathMap(this.f27819d);
        videoEditEntity.setCleanEditImagePathMap(this.f27820e);
        videoEditEntity.setCleanEditImageSizeMap(this.f27821f);
        videoEditEntity.setTimelineShowCover(str);
        videoEditEntity.setTextInfoMap(this.i);
        videoEditEntity.setTagInfoMap(this.h);
        videoEditEntity.setStickerInfoMap(this.j);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoEditEntity.VIDEO_INFO, videoEditEntity);
        Intent intent = new Intent(this.f27816a, CreatePostActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("source_mode", 2);
        intent.putStringArrayListExtra("source_path", this.f27818c);
        this.f27816a.startActivity(intent);
    }

    public void c() {
        a(true);
        final long currentTimeMillis = System.currentTimeMillis();
        j.a().d("");
        this.f27817b.a(true, (C0428b) new C0428b() {
            public void a(String str) {
                j.a().j().setCompression_cost_time(((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f);
                File file = new File(str);
                if (file.exists()) {
                    j.a().j().setVideo_output_file_size(k.a(file));
                }
                b.this.f27820e.put(b.this.f27818c.get(0), str);
                b.this.f27817b.a(false, (C0428b) new C0428b() {
                    public void a(String str) {
                        b.this.a(false);
                        b.this.f27819d.put(b.this.f27818c.get(0), str);
                        b.this.f27817b.d();
                        b.this.n.a((r.b) new r.b() {
                            public void a() {
                                b.this.n.a(b.this.f27816a, (String) b.this.f27818c.get(0), (r.a) new r.a() {
                                    public void a(String str) {
                                        b.this.a(str);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        this.f27822g = aVar;
    }

    /* access modifiers changed from: private */
    public void a(String str, c cVar) {
        a aVar = this.f27822g;
        if (aVar != null) {
            aVar.a();
        }
        this.h.put(str, cVar.a());
        this.l = true;
    }

    /* access modifiers changed from: private */
    public void a(String str, com.shopee.feeds.feedlibrary.editor.text.c cVar) {
        this.i.put(str, cVar.a());
        this.l = true;
    }

    /* access modifiers changed from: private */
    public void a(String str, com.shopee.feeds.feedlibrary.editor.sticker.d dVar) {
        this.j.put(str, dVar.a());
        this.l = true;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (this.k == null) {
            return;
        }
        if (z) {
            if (this.m != null) {
                j.a().g(true);
                this.m.setTextColor(this.f27816a.getResources().getColor(c.b.grey_400));
                this.m.setEnabled(false);
            }
            this.k.a();
            return;
        }
        if (this.m != null) {
            j.a().g(false);
            this.m.setTextColor(this.f27816a.getResources().getColor(c.b.main_color));
            this.m.setEnabled(true);
        }
        this.k.b();
    }

    public boolean d() {
        return this.l;
    }
}
