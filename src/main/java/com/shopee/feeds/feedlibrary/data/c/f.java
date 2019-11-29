package com.shopee.feeds.feedlibrary.data.c;

import a.k;
import android.text.TextUtils;
import com.shopee.feeds.feedlibrary.bg.b.a;
import com.shopee.feeds.feedlibrary.data.entity.BaseEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.react.sdk.bridge.protocol.feed.FeedPostStatusQueryData;
import com.shopee.react.sdk.bridge.protocol.feed.FeedsPostData;
import com.shopee.sdk.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, String> f27707b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private String f27708a;

    public f() {
        d();
    }

    private void d() {
        int a2 = b.a().d().a().a();
        File dir = com.shopee.feeds.feedlibrary.b.b().c().getDir("postDir", 0);
        File file = new File(dir + File.separator + a2);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f27708a = file.toString();
        h.b("PostStatusTask", "fixParentPath " + this.f27708a);
    }

    public void a() {
        d();
    }

    private String g(String str) {
        String str2 = this.f27708a;
        return new File(str2, str + ".txt").toString();
    }

    public static synchronized void a(String str) {
        synchronized (f.class) {
            h.b("PostStatusTask", "addPosting cache " + str);
            f27707b.put(str, "");
        }
    }

    public static synchronized void b(String str) {
        synchronized (f.class) {
            h.b("PostStatusTask", "deletePosting cache " + str);
            f27707b.remove(str);
        }
    }

    public static synchronized boolean c(String str) {
        boolean containsKey;
        synchronized (f.class) {
            containsKey = f27707b.containsKey(str);
        }
        return containsKey;
    }

    public void a(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(new File(g(str)), false);
            fileWriter.write(str2);
            fileWriter.flush();
            fileWriter.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String d(String str) {
        String str2 = this.f27708a;
        File file = new File(str2, str + ".txt");
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return new String(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public BaseEditEntity e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f(str)) {
            return (PhotoEditEntity) a.a().a(str, PhotoEditEntity.class);
        }
        return (VideoEditEntity) a.a().a(str, VideoEditEntity.class);
    }

    public void a(String str, BaseEditEntity baseEditEntity) {
        String str2;
        if (baseEditEntity.getPostType() == 1) {
            str2 = new com.google.a.f().b((Object) (PhotoEditEntity) baseEditEntity);
        } else {
            str2 = new com.google.a.f().b((Object) (VideoEditEntity) baseEditEntity);
        }
        a(str, str2);
    }

    public FeedPostStatusQueryData b() {
        a();
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(this.f27708a).listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        for (File name : listFiles) {
            String d2 = d(name.getName().replace(".txt", ""));
            new FeedsPostData();
            if (f(d2)) {
                PhotoEditEntity photoEditEntity = (PhotoEditEntity) new com.google.a.f().a(d2, PhotoEditEntity.class);
                if (photoEditEntity != null) {
                    if (!photoEditEntity.isHasParamCheck()) {
                        a(photoEditEntity.getPostId(), false);
                    } else {
                        arrayList.add(a.a(photoEditEntity));
                    }
                }
            } else {
                VideoEditEntity videoEditEntity = (VideoEditEntity) new com.google.a.f().a(d2, VideoEditEntity.class);
                if (videoEditEntity != null) {
                    if (!videoEditEntity.isHasParamCheck()) {
                        a(videoEditEntity.getPostId(), false);
                    } else {
                        arrayList.add(a.a(videoEditEntity));
                    }
                }
            }
        }
        FeedPostStatusQueryData feedPostStatusQueryData = new FeedPostStatusQueryData();
        feedPostStatusQueryData.setPost_list(arrayList);
        return feedPostStatusQueryData;
    }

    public ArrayList<BaseEditEntity> c() {
        File[] listFiles = new File(this.f27708a).listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        ArrayList<BaseEditEntity> arrayList = new ArrayList<>();
        for (File name : listFiles) {
            final BaseEditEntity baseEditEntity = (BaseEditEntity) new com.google.a.f().a(d(name.getName().replace(".txt", "")), BaseEditEntity.class);
            if (!baseEditEntity.isHasParamCheck()) {
                k.a(new Callable<Object>() {
                    public Object call() throws Exception {
                        f.this.a(baseEditEntity.getPostId(), false);
                        return null;
                    }
                });
            } else {
                arrayList.add(baseEditEntity);
            }
        }
        return arrayList;
    }

    public boolean a(String str, boolean z) {
        h.b("PostStatusTask", "deletePostStatus enter " + str);
        try {
            b(str, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        File file = new File(g(str));
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    private void b(String str, boolean z) {
        VideoEditEntity videoEditEntity;
        h.b("PostStatusTask", "deleteRelatedResouce start " + str);
        String d2 = d(str);
        if (!TextUtils.isEmpty(d2)) {
            BaseEditEntity baseEditEntity = (BaseEditEntity) new com.google.a.f().a(d2, BaseEditEntity.class);
            if (baseEditEntity != null) {
                PhotoEditEntity photoEditEntity = null;
                if (baseEditEntity.getPostType() == 1) {
                    photoEditEntity = (PhotoEditEntity) new com.google.a.f().a(d2, PhotoEditEntity.class);
                    videoEditEntity = null;
                } else {
                    videoEditEntity = (VideoEditEntity) new com.google.a.f().a(d2, VideoEditEntity.class);
                }
                ArrayList<String> a2 = a.a(baseEditEntity.getPostCurrentPathList(), baseEditEntity.getCleanEditImagePathMap());
                if (baseEditEntity.getPostType() == 1) {
                    if (!z) {
                        com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), photoEditEntity.getPostCurrentPathList());
                    }
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), a.a(photoEditEntity.getPostCurrentPathList(), photoEditEntity.getEditImagePathMap()));
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), a.a(photoEditEntity.getPostCurrentPathList(), photoEditEntity.getSaveAlbumPathMap()));
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), a2);
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), photoEditEntity.getShareInsImg());
                    if (!z) {
                        com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), photoEditEntity.getFeedWaterMarkIconPath());
                    }
                } else if (baseEditEntity.getPostType() == 2) {
                    if (!videoEditEntity.isOriginalVideo()) {
                        com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getVideoPreviewPath());
                    }
                    if (!z) {
                        com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getFeedWaterMarkIconPath());
                    }
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getSaveList());
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getVideoWaterPath());
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getCoverPath());
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getImageWaterMarkStorePath());
                    if (!videoEditEntity.isHasAlbum()) {
                        com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getVideoWaterMarkStorePath());
                    }
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getImageFeedWaterCachePath());
                    com.shopee.feeds.feedlibrary.util.k.a(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getOldCoverPath());
                    h.b("PostStatusTask", "deleteRelatedResouce res1 " + videoEditEntity.getVideoPreviewPath());
                    h.b("PostStatusTask", "deleteRelatedResouce res2 " + videoEditEntity.getVideoWaterPath());
                    h.b("PostStatusTask", "deleteRelatedResouce res3 " + videoEditEntity.getCoverPath());
                    h.b("PostStatusTask", "deleteRelatedResouce res4 " + videoEditEntity.getVideoWaterImgPath());
                    h.b("PostStatusTask", "deleteRelatedResouce res5 " + videoEditEntity.getImageFeedWaterCachePath());
                    h.b("PostStatusTask", "deleteRelatedResouce res6 " + videoEditEntity.getOldCoverPath());
                }
                h.b("PostStatusTask", "deleteRelatedResouce end " + str);
            }
        }
    }

    public boolean f(String str) {
        if (TextUtils.isEmpty(str) || ((BaseEditEntity) new com.google.a.f().a(str, BaseEditEntity.class)).getPostType() == 1) {
            return true;
        }
        return false;
    }
}
