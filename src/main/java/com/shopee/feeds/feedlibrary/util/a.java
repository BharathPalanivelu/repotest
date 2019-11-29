package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.shopee.feeds.feedlibrary.activity.MyFollowingActivity;
import com.shopee.feeds.feedlibrary.activity.SelectVoucherActivity;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoPostParams;
import com.shopee.feeds.feedlibrary.editor.activity.PhotoEditActivity;
import com.shopee.feeds.feedlibrary.editor.activity.VideoEditActivity;
import com.shopee.feeds.feedlibrary.editor.sticker.a.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class a {
    public static void a(Context context, ArrayList<String> arrayList, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        VideoPostParams videoPostParams = new VideoPostParams();
        videoPostParams.setDuration(i2);
        videoPostParams.setOffsetX(i5);
        videoPostParams.setOffsetY(i6);
        videoPostParams.setVideoWidth(i3);
        videoPostParams.setVideoHeight(i4);
        videoPostParams.setVideoSquare(z);
        j.a().a(videoPostParams);
        h.b("PostStatusTask", "orignnal video size " + i3 + "," + i4);
        if (j.a().t() == null) {
            d.a((Object) "111111");
        }
        Intent intent = new Intent(context, VideoEditActivity.class);
        intent.putExtra("source_mode", i);
        intent.putStringArrayListExtra("source_path", arrayList);
        intent.putExtra("vidoe_duration", i2);
        context.startActivity(intent);
    }

    public static void a(Context context, int i, ArrayList<String> arrayList, LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> linkedHashMap) {
        Intent intent = new Intent(context, PhotoEditActivity.class);
        intent.putExtra("source_mode", 1);
        Bundle bundle = new Bundle();
        PhotoEditEntity photoEditEntity = new PhotoEditEntity();
        photoEditEntity.setCurrentPathList(arrayList);
        photoEditEntity.setSource(i);
        photoEditEntity.setTagInfoMap(linkedHashMap);
        bundle.putSerializable("tagPic", photoEditEntity);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, MyFollowingActivity.class));
    }

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, SelectVoucherActivity.class);
        intent.putExtra("type", i);
        context.startActivity(intent);
    }

    public static void a(Context context, int i, f fVar) {
        if (fVar == null) {
            a(context, i);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_info", fVar);
        Intent intent = new Intent(context, SelectVoucherActivity.class);
        intent.putExtra("type", i);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
