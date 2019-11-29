package com.shopee.feeds.feedlibrary.bg.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.google.a.f;
import com.google.a.g;
import com.google.a.x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.data.c.b;
import com.shopee.feeds.feedlibrary.data.entity.BaseEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.ImageCompressUploadParams;
import com.shopee.feeds.feedlibrary.data.entity.ImageEntity;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.editor.sticker.a.c;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.react.sdk.bridge.protocol.feed.FeedsPostData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class a {
    public static ArrayList<String> a(ArrayList<String> arrayList, HashMap<String, String> hashMap) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList.size() > 0 && hashMap.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(hashMap.get(arrayList.get(i)));
            }
        }
        return arrayList2;
    }

    public static void a(ArrayList<ImageEntity> arrayList, HashMap<String, String> hashMap, PhotoEditEntity photoEditEntity) {
        HashMap<String, String> cleanEditImagePathMap = photoEditEntity.getCleanEditImagePathMap();
        if (cleanEditImagePathMap != null && cleanEditImagePathMap.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                ImageEntity imageEntity = arrayList.get(i);
                for (Map.Entry next : cleanEditImagePathMap.entrySet()) {
                    File file = new File((String) next.getKey());
                    if (new File((String) next.getValue()).getName().equals(imageEntity.getFile_name())) {
                        hashMap.put(file.getName(), imageEntity.getFile_id());
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ImageEntity imageEntity2 = arrayList.get(i2);
                h.b("", "Create post : id = " + imageEntity2.getFile_id() + "  name = " + imageEntity2.getFile_name());
            }
        }
    }

    public static void a(String str, HashMap<String, String> hashMap, PhotoEditEntity photoEditEntity) {
        ArrayList<ImageCompressUploadParams> arrayList = photoEditEntity.getmUploadImageCompressParams();
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                ImageCompressUploadParams imageCompressUploadParams = arrayList.get(i);
                if (imageCompressUploadParams != null) {
                    String str2 = hashMap.get(new File(imageCompressUploadParams.getPath()).getName());
                    if (!d.a(str2)) {
                        imageCompressUploadParams.setFeed_id(str);
                        imageCompressUploadParams.setImage_url(b.b(str2));
                        e.a(imageCompressUploadParams);
                    }
                } else {
                    d.a((Object) arrayList);
                }
            }
        }
    }

    public static String a(String str, boolean z, VideoEditEntity videoEditEntity, int i) {
        float videoWidth = ((float) videoEditEntity.getVideoPostParams().getVideoWidth()) / 1080.0f;
        if (z) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileInputStream fileInputStream2 = new FileInputStream(videoEditEntity.getFeedWaterMarkIconPath());
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                Bitmap decodeStream2 = BitmapFactory.decodeStream(fileInputStream2);
                Matrix matrix = new Matrix();
                matrix.postRotate((float) (-i));
                matrix.postScale(videoWidth, videoWidth);
                Bitmap createBitmap = Bitmap.createBitmap(decodeStream2, 0, 0, decodeStream2.getWidth(), decodeStream2.getHeight(), matrix, true);
                if (!(createBitmap == decodeStream2 || decodeStream2 == null || decodeStream2.isRecycled())) {
                    decodeStream2.recycle();
                }
                Bitmap copy = decodeStream.copy(Bitmap.Config.ARGB_8888, true);
                Canvas canvas = new Canvas(copy);
                if (i == 0) {
                    canvas.drawBitmap(createBitmap, (float) (decodeStream.getWidth() - createBitmap.getWidth()), (float) (decodeStream.getHeight() - createBitmap.getHeight()), (Paint) null);
                } else {
                    canvas.drawBitmap(createBitmap, (float) (decodeStream.getWidth() - createBitmap.getWidth()), BitmapDescriptorFactory.HUE_RED, (Paint) null);
                }
                String c2 = c(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getPostId());
                FileOutputStream fileOutputStream = new FileOutputStream(c2);
                copy.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                h.b("", "getFeedVideoWaterMarkPath 1  " + c2);
                return c2;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(videoEditEntity.getFeedWaterMarkIconPath());
                Bitmap createBitmap2 = Bitmap.createBitmap(videoEditEntity.getVideoPostParams().getVideoWidth(), videoEditEntity.getVideoPostParams().getVideoHeight(), Bitmap.Config.ARGB_4444);
                Bitmap decodeStream3 = BitmapFactory.decodeStream(fileInputStream3);
                Matrix matrix2 = new Matrix();
                matrix2.postScale(videoWidth, videoWidth);
                Bitmap createBitmap3 = Bitmap.createBitmap(decodeStream3, 0, 0, decodeStream3.getWidth(), decodeStream3.getHeight(), matrix2, true);
                if (!(decodeStream3 == createBitmap3 || decodeStream3 == null || decodeStream3.isRecycled())) {
                    decodeStream3.recycle();
                }
                Bitmap copy2 = createBitmap2.copy(Bitmap.Config.ARGB_8888, true);
                new Canvas(copy2).drawBitmap(createBitmap3, (float) (createBitmap2.getWidth() - createBitmap3.getWidth()), (float) (createBitmap2.getHeight() - createBitmap3.getHeight()), (Paint) null);
                String c3 = c(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getPostId());
                FileOutputStream fileOutputStream2 = new FileOutputStream(c3);
                Matrix matrix3 = new Matrix();
                matrix3.postRotate((float) (-i));
                Bitmap createBitmap4 = Bitmap.createBitmap(copy2, 0, 0, copy2.getWidth(), copy2.getHeight(), matrix3, true);
                if (!(createBitmap4 == copy2 || copy2 == null || copy2.isRecycled())) {
                    copy2.recycle();
                }
                createBitmap4.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream2);
                fileOutputStream2.flush();
                fileOutputStream2.getFD().sync();
                fileOutputStream2.close();
                h.b("", "getFeedVideoWaterMarkPath 2 " + c3);
                return c3;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
    }

    public static String a(Context context, String str) {
        return q.c(context, "water_video_" + str.replace("-", "") + ".mp4");
    }

    public static String b(Context context, String str) {
        return q.b(context, "water_img_" + str.replace("-", "") + ".jpg");
    }

    public static String c(Context context, String str) {
        return q.b(context, "water_video_img_" + str.replace("-", "") + ".png");
    }

    public static String a(String str, VideoEditEntity videoEditEntity) {
        try {
            float videoWidth = ((float) videoEditEntity.getVideoPostParams().getVideoWidth()) / 1080.0f;
            FileInputStream fileInputStream = new FileInputStream(str);
            FileInputStream fileInputStream2 = new FileInputStream(videoEditEntity.getFeedWaterMarkIconPath());
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            Bitmap decodeStream2 = BitmapFactory.decodeStream(fileInputStream2);
            Matrix matrix = new Matrix();
            matrix.postScale(videoWidth, videoWidth);
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream2, 0, 0, decodeStream2.getWidth(), decodeStream2.getHeight(), matrix, true);
            if (!(decodeStream2 == createBitmap || decodeStream2 == null || decodeStream2.isRecycled())) {
                decodeStream2.recycle();
            }
            Bitmap copy = decodeStream.copy(Bitmap.Config.ARGB_8888, true);
            new Canvas(copy).drawBitmap(createBitmap, (float) (decodeStream.getWidth() - createBitmap.getWidth()), (float) (decodeStream.getHeight() - createBitmap.getHeight()), (Paint) null);
            String b2 = b(com.shopee.feeds.feedlibrary.b.b().c(), videoEditEntity.getPostId());
            FileOutputStream fileOutputStream = new FileOutputStream(b2);
            copy.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            return b2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> a(ArrayList<ImageEntity> arrayList, PhotoEditEntity photoEditEntity) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        HashMap<String, String> saveAlbumPathMap = photoEditEntity.getSaveAlbumPathMap();
        if (saveAlbumPathMap != null && saveAlbumPathMap.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                ImageEntity imageEntity = arrayList.get(i);
                if (imageEntity.getFile_name().startsWith("water_pre")) {
                    arrayList2.add(imageEntity.getFile_id());
                    break;
                }
                for (Map.Entry<String, String> value : saveAlbumPathMap.entrySet()) {
                    if (new File((String) value.getValue()).getName().equals(imageEntity.getFile_name())) {
                        arrayList2.add(imageEntity.getFile_id());
                    }
                }
                i++;
            }
        }
        return arrayList2;
    }

    public static String a(String str, PhotoEditEntity photoEditEntity) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileInputStream fileInputStream2 = new FileInputStream(photoEditEntity.getFeedWaterMarkIconPath());
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            Bitmap decodeStream2 = BitmapFactory.decodeStream(fileInputStream2);
            Bitmap copy = decodeStream.copy(Bitmap.Config.ARGB_8888, true);
            new Canvas(copy).drawBitmap(decodeStream2, (float) (decodeStream.getWidth() - decodeStream2.getWidth()), (float) (decodeStream.getHeight() - decodeStream2.getHeight()), (Paint) null);
            Context c2 = com.shopee.feeds.feedlibrary.b.b().c();
            String a2 = q.a(c2, "water_pre" + UUID.randomUUID().toString() + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(a2);
            copy.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            return a2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static FeedsPostData a(BaseEditEntity baseEditEntity) {
        FeedsPostData feedsPostData = new FeedsPostData();
        feedsPostData.setFeedId(baseEditEntity.getFeedId());
        feedsPostData.setPostStartTime(baseEditEntity.getPostStartTime());
        feedsPostData.setPostEndTime(baseEditEntity.getPostEndTime());
        feedsPostData.setSharing(baseEditEntity.isHasIns());
        feedsPostData.setStatus(baseEditEntity.getPostState());
        feedsPostData.setPostId(baseEditEntity.getPostId());
        if (baseEditEntity.getPostType() == 2) {
            feedsPostData.setType(1);
        } else {
            feedsPostData.setType(0);
        }
        if (baseEditEntity instanceof PhotoEditEntity) {
            ArrayList<String> timelineImgList = ((PhotoEditEntity) baseEditEntity).getTimelineImgList();
            if (timelineImgList != null && timelineImgList.size() > 0) {
                feedsPostData.setImageDir(timelineImgList);
            }
        } else if (baseEditEntity instanceof VideoEditEntity) {
            VideoEditEntity videoEditEntity = (VideoEditEntity) baseEditEntity;
            FeedsPostData.VideoData videoData = new FeedsPostData.VideoData();
            videoData.setCover(videoEditEntity.getTimelineShowCover());
            videoData.setSource(videoEditEntity.getTimelineShowVideo());
            feedsPostData.setVideoDir(videoData);
        }
        return feedsPostData;
    }

    public static f a() {
        com.shopee.feeds.feedlibrary.data.a<com.shopee.feeds.feedlibrary.editor.sticker.a.d> b2 = com.shopee.feeds.feedlibrary.data.a.a(com.shopee.feeds.feedlibrary.editor.sticker.a.d.class, "kind").b(c.class, c.class.getName()).b(com.shopee.feeds.feedlibrary.editor.sticker.a.a.class, com.shopee.feeds.feedlibrary.editor.sticker.a.a.class.getName()).b(com.shopee.feeds.feedlibrary.editor.sticker.a.b.class, com.shopee.feeds.feedlibrary.editor.sticker.a.b.class.getName()).b(com.shopee.feeds.feedlibrary.editor.sticker.a.e.class, com.shopee.feeds.feedlibrary.editor.sticker.a.e.class.getName()).b(com.shopee.feeds.feedlibrary.editor.sticker.a.f.class, com.shopee.feeds.feedlibrary.editor.sticker.a.f.class.getName());
        com.shopee.feeds.feedlibrary.data.a<com.shopee.feeds.feedlibrary.editor.tag.a> b3 = com.shopee.feeds.feedlibrary.data.a.a(com.shopee.feeds.feedlibrary.editor.tag.a.class, "kind").b(com.shopee.feeds.feedlibrary.editor.tag.b.class, com.shopee.feeds.feedlibrary.editor.tag.b.class.getName());
        g gVar = new g();
        gVar.a((x) b2);
        gVar.a((x) b3);
        return gVar.d();
    }

    public static String a(int i, VideoEditEntity videoEditEntity) {
        String str;
        MediaCompressParam mediaCompressParam = videoEditEntity.getMediaCompressParam();
        if (mediaCompressParam == null) {
            mediaCompressParam = com.shopee.feeds.feedlibrary.util.e.a();
        }
        ArrayList<MediaCompressParam.VideoCompressItem> videoList = mediaCompressParam.getAndroid().getVideoList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= videoList.size()) {
                str = "";
                break;
            }
            MediaCompressParam.VideoCompressItem videoCompressItem = videoList.get(i3);
            if (i > videoCompressItem.getDuration()) {
                str = videoCompressItem.getBitrate() + "k";
                i2 = videoCompressItem.getBitrate();
                break;
            }
            i3++;
        }
        videoEditEntity.getUploadEntity().setHit_bitrate(i2);
        videoEditEntity.getUploadEntity().setHit_duration(i);
        return str;
    }
}
