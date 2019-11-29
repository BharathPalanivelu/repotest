package com.shopee.feeds.feedlibrary.bg.a;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.data.c.a;
import com.shopee.feeds.feedlibrary.data.c.f;
import com.shopee.feeds.feedlibrary.data.entity.BaseEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.ImageEntity;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.PostStatusEntity;
import com.shopee.feeds.feedlibrary.data.entity.PostStatusLoadingEntity;
import com.shopee.feeds.feedlibrary.data.entity.UpLoadImageEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.k;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.util.r;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.x;
import com.shopee.feeds.feedlibrary.view.preview.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.b.a.d;
import org.greenrobot.eventbus.c;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f27611a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PhotoEditEntity f27612b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public VideoEditEntity f27613c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.shopee.feeds.feedlibrary.data.c.a f27614d = new com.shopee.feeds.feedlibrary.data.c.a(b.b().c());
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public f f27615e = new f();

    /* renamed from: f  reason: collision with root package name */
    private x f27616f = new x(b.b().c(), (com.shopee.feeds.feedlibrary.view.widget.a) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f27617g = true;

    /* renamed from: com.shopee.feeds.feedlibrary.bg.a.a$a  reason: collision with other inner class name */
    private interface C0423a {
        void a();
    }

    /* access modifiers changed from: private */
    public void d() {
        c.a().c(new PostStatusLoadingEntity());
    }

    public void a(String str) {
        this.f27612b = null;
        this.f27613c = null;
        String d2 = this.f27615e.d(str);
        String str2 = f27611a;
        h.b(str2, "retryStart " + str + "," + d2);
        com.google.a.f a2 = com.shopee.feeds.feedlibrary.bg.b.a.a();
        if (this.f27615e.f(d2)) {
            this.f27612b = (PhotoEditEntity) a2.a(d2, PhotoEditEntity.class);
            this.f27617g = true;
        } else {
            this.f27613c = (VideoEditEntity) a2.a(d2, VideoEditEntity.class);
            this.f27617g = false;
        }
        if (this.f27612b == null && this.f27613c == null) {
            h.b(f27611a, "empty entity");
            d();
            return;
        }
        boolean c2 = f.c(e().getPostId());
        String str3 = f27611a;
        h.b(str3, "is inPosting " + c2);
        if (!c2) {
            f.a(e().getPostId());
            if (e().getPostState() == 1) {
                String str4 = f27611a;
                h.b(str4, "retryStart has posted " + str);
                d();
                return;
            }
            a();
        }
    }

    /* access modifiers changed from: private */
    public BaseEditEntity e() {
        if (this.f27617g) {
            return this.f27612b;
        }
        return this.f27613c;
    }

    public void a() {
        h.b("PostStatusTask", "PostStatusTask executeStart");
        final String feedId = e().getFeedId();
        if (!TextUtils.isEmpty(feedId)) {
            c(feedId);
        } else {
            this.f27614d.a(3, false, (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    String str2 = (String) obj;
                    if (!TextUtils.isEmpty(str2)) {
                        String c2 = a.f27611a;
                        h.b(c2, "get feed success " + feedId);
                        a.this.e().setFeedId(str2);
                        if (!a.this.f27617g) {
                            a.this.f27613c.getUploadEntity().setFeed_id(feedId);
                        }
                        a.this.f27615e.a(a.this.e().getPostId(), a.this.e());
                        a.this.c(str2);
                        return;
                    }
                    f.b(a.this.e().getPostId());
                    a.this.d();
                }

                public void a(String str) {
                    a.this.d();
                    a.this.f(str);
                    f.b(a.this.e().getPostId());
                    h.b(a.f27611a, "getFeedId fail onError");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c(final String str) {
        String str2 = f27611a;
        h.b(str2, "uploadResource enter " + e().getPostType());
        if (e().getPostType() == 1) {
            if (this.f27612b.isHasParamCheck()) {
                d(str);
                return;
            }
            HashMap hashMap = new HashMap();
            com.shopee.feeds.feedlibrary.data.c.a aVar = this.f27614d;
            String caution = this.f27612b.getCaution();
            ArrayList<String> hashTags = this.f27612b.getHashTags();
            ArrayList<Integer> mentions = this.f27612b.getMentions();
            PhotoEditEntity photoEditEntity = this.f27612b;
            this.f27614d.a(aVar.a(caution, hashTags, mentions, str, hashMap, photoEditEntity, photoEditEntity.getPostCurrentPathList(), (ArrayList<String>) null), 3, (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    a.this.f27612b.setHasParamCheck(true);
                    a.this.f27615e.a(a.this.f27612b.getPostId(), (BaseEditEntity) a.this.f27612b);
                    a.this.d(str);
                }

                public void a(String str) {
                    a.this.d();
                    a.this.f(str);
                    f.b(a.this.e().getPostId());
                    h.b(a.f27611a, "hint");
                }
            });
        } else if (this.f27613c.isHasParamCheck()) {
            e(str);
        } else {
            com.shopee.feeds.feedlibrary.data.c.a aVar2 = this.f27614d;
            String videoUploadMd5 = this.f27613c.getVideoUploadMd5();
            String caution2 = this.f27613c.getCaution();
            ArrayList<String> hashTags2 = this.f27613c.getHashTags();
            ArrayList<Integer> mentions2 = this.f27613c.getMentions();
            String feedId = this.f27613c.getFeedId();
            VideoEditEntity videoEditEntity = this.f27613c;
            this.f27614d.a(aVar2.a(videoUploadMd5, caution2, hashTags2, mentions2, feedId, videoEditEntity, videoEditEntity.getPostCurrentPathList()), 3, (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    a.this.f27613c.setHasParamCheck(true);
                    a.this.f27615e.a(a.this.f27613c.getPostId(), (BaseEditEntity) a.this.f27613c);
                    a.this.e(str);
                }

                public void a(String str) {
                    a.this.d();
                    a.this.f(str);
                    f.b(a.this.e().getPostId());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void d(final String str) {
        h.b(f27611a, "doImgUploadResouce start ");
        c.a().c(new PostStatusEntity());
        if (e().getPostStartTime() == 0) {
            e().setPostStartTime(System.currentTimeMillis());
        }
        this.f27615e.a(e().getPostId(), e());
        com.shopee.feeds.feedlibrary.bg.a.a().a(e().getPostId(), e());
        ArrayList<ImageEntity> imageList = this.f27612b.getImageList();
        if (imageList == null || imageList.size() <= 0) {
            ArrayList<String> a2 = com.shopee.feeds.feedlibrary.bg.b.a.a(this.f27612b.getPostCurrentPathList(), this.f27612b.getCleanEditImagePathMap());
            h.b(f27611a, "uploadImage start ");
            String a3 = com.shopee.feeds.feedlibrary.bg.b.a.a(this.f27612b.getFirstSaveImg(), this.f27612b);
            this.f27612b.setShareInsImg(a3);
            this.f27615e.a(this.f27612b.getPostId(), (BaseEditEntity) this.f27612b);
            if (!TextUtils.isEmpty(a3)) {
                String str2 = f27611a;
                h.b(str2, "get share img " + a3);
                a2.add(a3);
            }
            this.f27614d.a(a2, 3, false, (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList == null || arrayList.size() <= 0) {
                        a.this.b("upLoadImage empty");
                        return;
                    }
                    h.b(a.f27611a, "uploadImage successs ");
                    a.this.f27612b.setImageList(arrayList);
                    a.this.f27615e.a(a.this.f27612b.getPostId(), (BaseEditEntity) a.this.f27612b);
                    HashMap hashMap = new HashMap();
                    com.shopee.feeds.feedlibrary.bg.b.a.a((ArrayList<ImageEntity>) arrayList, (HashMap<String, String>) hashMap, a.this.f27612b);
                    a aVar = a.this;
                    aVar.a(str, (HashMap<String, String>) hashMap, aVar.f27612b);
                    a.this.a(a.this.f27614d.a(a.this.f27612b.getCaution(), a.this.f27612b.getHashTags(), a.this.f27612b.getMentions(), str, hashMap, a.this.f27612b, a.this.f27612b.getPostCurrentPathList(), com.shopee.feeds.feedlibrary.bg.b.a.a((ArrayList<ImageEntity>) arrayList, a.this.f27612b)));
                }

                public void a(String str) {
                    a.this.f(str);
                    a aVar = a.this;
                    aVar.b("upLoadImage " + str);
                }
            });
            return;
        }
        HashMap hashMap = new HashMap();
        com.shopee.feeds.feedlibrary.bg.b.a.a(imageList, (HashMap<String, String>) hashMap, this.f27612b);
        a(str, (HashMap<String, String>) hashMap, this.f27612b);
        com.shopee.feeds.feedlibrary.data.c.a aVar = this.f27614d;
        String caution = this.f27612b.getCaution();
        ArrayList<String> hashTags = this.f27612b.getHashTags();
        ArrayList<Integer> mentions = this.f27612b.getMentions();
        PhotoEditEntity photoEditEntity = this.f27612b;
        a(aVar.a(caution, hashTags, mentions, str, hashMap, photoEditEntity, photoEditEntity.getPostCurrentPathList(), com.shopee.feeds.feedlibrary.bg.b.a.a(imageList, this.f27612b)));
    }

    /* access modifiers changed from: private */
    public void a(String str, HashMap<String, String> hashMap, PhotoEditEntity photoEditEntity) {
        com.shopee.feeds.feedlibrary.bg.b.a.a(str, hashMap, photoEditEntity);
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        c.a().c(new PostStatusEntity());
        if (e().getPostStartTime() == 0) {
            e().setPostStartTime(System.currentTimeMillis());
        }
        this.f27615e.a(e().getPostId(), e());
        com.shopee.feeds.feedlibrary.bg.a.a().a(e().getPostId(), e());
        final ArrayList<String> a2 = com.shopee.feeds.feedlibrary.bg.b.a.a(this.f27613c.getPostCurrentPathList(), this.f27613c.getCleanEditImagePathMap());
        if (!this.f27613c.isHasVideoClipAndWater() || !this.f27613c.isHasWaterVideoClip()) {
            if (!this.f27613c.isHasVideoClipAndWater()) {
                a(this.f27613c.getVideoStorePath(), a2.get(0), this.f27613c.getVideoWaterImgPath(), (C0423a) new C0423a() {
                    public void a() {
                        a.this.a(false, (ArrayList<String>) a2);
                    }
                });
            }
            if (!this.f27613c.isHasWaterVideoClip()) {
                String a3 = com.shopee.feeds.feedlibrary.bg.b.a.a(b.b().c(), this.f27613c.getPostId());
                this.f27613c.setVideoWaterMarkStorePath(a3);
                this.f27615e.a(this.f27613c.getPostId(), (BaseEditEntity) this.f27613c);
                b(this.f27613c.getVideoStorePath(), a3, this.f27613c.getVideoWaterImgPath(), new C0423a() {
                    public void a() {
                        a.this.a(true, (ArrayList<String>) null);
                    }
                });
                return;
            }
            return;
        }
        f();
    }

    /* access modifiers changed from: private */
    public synchronized void a(boolean z, ArrayList<String> arrayList) {
        if (!z) {
            h.b(f27611a, "onClipFinish finish ");
            this.f27613c.getUploadEntity().setVideo_output_file_size(k.f(arrayList.get(0)));
            this.f27613c.setHasVideoClipAndWater(true);
            this.f27615e.a(e().getPostId(), (BaseEditEntity) this.f27613c);
            if (this.f27613c.isHasWaterVideoClip()) {
                f();
            }
        } else {
            h.b(f27611a, "onClipFinish water finish ");
            this.f27613c.setHasWaterVideoClip(true);
            this.f27615e.a(e().getPostId(), (BaseEditEntity) this.f27613c);
            if (this.f27613c.isHasVideoClipAndWater()) {
                f();
            }
        }
    }

    private void f() {
        String str = f27611a;
        h.b(str, "uploadVideoResouce enter " + e().getPostId());
        r rVar = new r(b.b().c());
        final ArrayList<String> a2 = com.shopee.feeds.feedlibrary.bg.b.a.a(this.f27613c.getCurrentPathList(), this.f27613c.getCleanEditImagePathMap());
        rVar.a(b.b().c(), a2.get(0), new r.a() {
            public void a(String str) {
                String c2 = a.f27611a;
                h.b(c2, "onCoverGet " + str);
                if (!TextUtils.isEmpty(a.this.f27613c.getImageWaterMarkStorePath())) {
                    a.this.a((ArrayList<String>) a2);
                    return;
                }
                String a2 = com.shopee.feeds.feedlibrary.bg.b.a.a(a.this.f27613c.getCoverPath(), a.this.f27613c);
                if (TextUtils.isEmpty(a2)) {
                    a.this.b("water mark empty path");
                    return;
                }
                a.this.f27613c.setImageWaterMarkStorePath(a2);
                a.this.f27615e.a(a.this.f27613c.getPostId(), (BaseEditEntity) a.this.f27613c);
                a.this.a((ArrayList<String>) a2);
            }
        }, this.f27613c);
    }

    /* access modifiers changed from: private */
    public void a(final ArrayList<String> arrayList) {
        h.b(f27611a, "start get signiature ");
        this.f27614d.a(this.f27613c, (a.C0425a) new a.C0425a() {
            public void a(int i) {
                String c2 = a.f27611a;
                h.b(c2, "onSiginatureCall back " + i);
                if (i == 0) {
                    a.this.f27615e.a(a.this.f27613c.getPostId(), (BaseEditEntity) a.this.f27613c);
                    a.this.b((ArrayList<String>) arrayList);
                    return;
                }
                a.this.b("fail get onSiginatureCall");
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(ArrayList<String> arrayList) {
        h.b(f27611a, "reallyStartUploadVideo enter");
        if (!TextUtils.isEmpty(this.f27613c.getVideoUploadMd5())) {
            g();
            return;
        }
        h.b(f27611a, "upload video start ");
        this.f27616f.a(arrayList.get(0), new com.shopee.feeds.feedlibrary.a.a() {
            public void a(Object obj, String str) {
                h.b(a.f27611a, "upload video finish ");
                a.this.f27613c.setCoverUploadUrl(str);
                String str2 = (String) obj;
                a.this.f27613c.setVideoUploadMd5(str2);
                a.this.f27615e.a(a.this.f27613c.getPostId(), (BaseEditEntity) a.this.f27613c);
                a.this.f27613c.getUploadEntity().setVideo_url(str2);
                a.this.f27613c.getUploadEntity().setFeed_id(a.this.f27613c.getFeedId());
                e.a(a.this.f27613c.getUploadEntity());
                a.this.g();
            }

            public void a(String str) {
                a aVar = a.this;
                aVar.b("uploadVideoWithTXLib " + str);
            }
        }, this.f27613c);
    }

    /* access modifiers changed from: private */
    public void g() {
        if (!TextUtils.isEmpty(this.f27613c.getVideoWaterMarkUploadUrl())) {
            h();
        } else {
            this.f27616f.b(this.f27613c.getVideoWaterMarkStorePath(), new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    h.b(a.f27611a, "water mark success");
                    a.this.f27613c.setVideoWaterMarkUploadUrl((String) obj);
                    a.this.f27613c.setImageWaterMarkUploadUrl(str);
                    a.this.f27615e.a(a.this.f27613c.getPostId(), (BaseEditEntity) a.this.f27613c);
                    a.this.h();
                }

                public void a(String str) {
                    a.this.b(str);
                }
            }, this.f27613c);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        h.b(f27611a, "uploadVideoPost start ");
        com.shopee.feeds.feedlibrary.data.c.a aVar = this.f27614d;
        String videoUploadMd5 = this.f27613c.getVideoUploadMd5();
        String caution = this.f27613c.getCaution();
        ArrayList<String> hashTags = this.f27613c.getHashTags();
        ArrayList<Integer> mentions = this.f27613c.getMentions();
        String feedId = this.f27613c.getFeedId();
        VideoEditEntity videoEditEntity = this.f27613c;
        this.f27614d.a(aVar.a(videoUploadMd5, caution, hashTags, mentions, feedId, videoEditEntity, videoEditEntity.getPostCurrentPathList()), 3, false, (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
            public void a(Object obj, String str) {
                h.b(a.f27611a, "uploadVideoPost finish ");
                a.this.i();
                a.this.j();
            }

            public void a(String str) {
                a.this.f(str);
                a aVar = a.this;
                aVar.b("upVideoPostReq " + str);
            }
        });
    }

    private void a(String str, String str2, String str3, C0423a aVar) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final C0423a aVar2 = aVar;
        a.k.a(new Callable<String>() {
            /* renamed from: a */
            public String call() throws Exception {
                int i;
                try {
                    k.a a2 = com.shopee.feeds.feedlibrary.view.preview.k.a();
                    a2.a(a.this.f27613c.getVideoCacheRect());
                    a2.a(a.this.f27613c.getVideoScaleWidth(), a.this.f27613c.getVideoScaleHeight());
                    k.a a3 = com.shopee.feeds.feedlibrary.view.preview.k.a();
                    int duration = a.this.f27613c.getDuration();
                    if (a.this.f27613c.isVideoNeedWater()) {
                        int i2 = 0;
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(str4);
                            if (Build.VERSION.SDK_INT >= 17) {
                                i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                            }
                            i = i2;
                        } catch (Exception unused) {
                            i = 0;
                        }
                        File file = new File(str5);
                        if (file.exists()) {
                            h.b(a.f27611a, "file exits before and need delete");
                            file.delete();
                        }
                        String c2 = a.f27611a;
                        h.b(c2, "clic parma " + str4 + "," + str6 + "," + str5);
                        a3.a(str4, str6, com.shopee.feeds.feedlibrary.bg.b.a.a(duration, a.this.f27613c), i, str5, (d.a) new d.a() {
                            public void shellOut(String str) {
                            }

                            public void processComplete(int i) {
                                aVar2.a();
                            }
                        });
                        return null;
                    }
                    a3.a(true, com.shopee.feeds.feedlibrary.bg.b.a.a(duration, a.this.f27613c), str4, str5, (d.a) new d.a() {
                        public void shellOut(String str) {
                        }

                        public void processComplete(int i) {
                            aVar2.a();
                        }
                    }, a.this.f27613c);
                    return null;
                } catch (Throwable th) {
                    String c3 = a.f27611a;
                    h.b(c3, "doWaterAndCripWork exception happens " + th.getMessage());
                    th.printStackTrace();
                    return null;
                }
            }
        });
    }

    private void b(String str, String str2, String str3, C0423a aVar) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final C0423a aVar2 = aVar;
        a.k.a(new Callable<String>() {
            /* renamed from: a */
            public String call() throws Exception {
                int i;
                try {
                    k.a a2 = com.shopee.feeds.feedlibrary.view.preview.k.a();
                    a2.a(a.this.f27613c.getVideoCacheRect());
                    a2.a(a.this.f27613c.getVideoScaleWidth(), a.this.f27613c.getVideoScaleHeight());
                    k.a a3 = com.shopee.feeds.feedlibrary.view.preview.k.a();
                    int duration = a.this.f27613c.getDuration();
                    int i2 = 0;
                    try {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(str4);
                        if (Build.VERSION.SDK_INT >= 17) {
                            i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                        }
                        i = i2;
                    } catch (Exception unused) {
                        i = 0;
                    }
                    File file = new File(str5);
                    if (file.exists()) {
                        h.b(a.f27611a, "file exits before and need delete");
                        file.delete();
                    }
                    String a4 = com.shopee.feeds.feedlibrary.bg.b.a.a(str6, a.this.f27613c.isVideoNeedWater(), a.this.f27613c, i);
                    a.this.f27613c.setImageFeedWaterCachePath(a4);
                    a.this.f27615e.a(a.this.f27613c.getPostId(), (BaseEditEntity) a.this.f27613c);
                    String c2 = a.f27611a;
                    h.b(c2, "clic parma " + str4 + "," + a4 + "," + str5);
                    a3.a(str4, a4, com.shopee.feeds.feedlibrary.bg.b.a.a(duration, a.this.f27613c), i, str5, (d.a) new d.a() {
                        public void shellOut(String str) {
                        }

                        public void processComplete(int i) {
                            aVar2.a();
                        }
                    });
                    return null;
                } catch (Throwable th) {
                    String c3 = a.f27611a;
                    h.b(c3, "doWaterAndCripWork exception happens " + th.getMessage());
                    th.printStackTrace();
                    return null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(UpLoadImageEntity upLoadImageEntity) {
        h.b(f27611a, "uploadPost enter");
        this.f27614d.a(upLoadImageEntity, 3, false, (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
            public void a(Object obj, String str) {
                a.this.i();
                a.this.j();
            }

            public void a(String str) {
                a.this.f(str);
                a aVar = a.this;
                aVar.b("upLoadImgPostReq " + str);
            }
        }, this.f27612b);
    }

    /* access modifiers changed from: private */
    public void i() {
        h.b(f27611a, "saveToAlbum start");
        ArrayList<String> saveList = e().getSaveList();
        for (int i = 0; i < saveList.size(); i++) {
            File file = new File(saveList.get(i));
            Context c2 = b.b().c();
            if (!e().isHasAlbum()) {
                com.shopee.feeds.feedlibrary.util.k.a(c2, file);
            } else if (e().getPostType() == 1) {
                File a2 = q.a(file, ".jpg");
                if (a2 != null) {
                    c2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(a2)));
                }
            } else if (e().getPostType() == 2) {
                com.shopee.feeds.feedlibrary.util.b.a(c2, this.f27613c.getVideoWaterMarkStorePath(), System.currentTimeMillis(), 0);
            }
        }
        h.b(f27611a, "saveToAlbum end");
    }

    /* access modifiers changed from: private */
    public void j() {
        b();
    }

    public void b(String str) {
        String str2 = f27611a;
        h.b(str2, "uploadFail " + e().getPostId() + "," + str);
        f.b(e().getPostId());
        e().setPostState(2);
        this.f27615e.a(e().getPostId(), e());
        com.shopee.feeds.feedlibrary.bg.a.a().c(e().getPostId(), e());
    }

    public void b() {
        String str = f27611a;
        h.b(str, "uploadFinish " + e().getPostId());
        e().setPostState(1);
        e().setPostEndTime(System.currentTimeMillis());
        this.f27615e.a(e().getPostId(), e());
        com.shopee.feeds.feedlibrary.bg.a.a().b(e().getPostId(), e());
    }

    /* access modifiers changed from: private */
    public void f(final String str) {
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                if (!com.shopee.feeds.feedlibrary.util.d.a(str)) {
                    u.a(b.b().c(), str);
                }
            }
        });
    }
}
