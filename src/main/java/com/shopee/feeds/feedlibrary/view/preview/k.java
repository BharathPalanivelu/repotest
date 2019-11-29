package com.shopee.feeds.feedlibrary.view.preview;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.appevents.AppEventsConstants;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoPostParams;
import com.shopee.feeds.feedlibrary.util.h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.b.a.d;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static a f28696a;

    public static synchronized a a() throws IOException {
        a aVar;
        synchronized (k.class) {
            if (f28696a == null) {
                Context c2 = b.b().c();
                f28696a = new a(c2, j.c(c2));
            }
            aVar = f28696a;
        }
        return aVar;
    }

    public static class a extends org.b.a.b {

        /* renamed from: a  reason: collision with root package name */
        private Rect f28697a;

        /* renamed from: b  reason: collision with root package name */
        private int f28698b;

        /* renamed from: c  reason: collision with root package name */
        private int f28699c;

        public a(Context context, File file) throws IOException {
            super(context, file);
        }

        public void a(Rect rect) {
            this.f28697a = rect;
        }

        public void a(int i, int i2) {
            this.f28698b = i;
            this.f28699c = i2;
        }

        public void a(List<String> list, d.a aVar) throws IOException, InterruptedException {
            int indexOf = list.indexOf("-vf");
            list.remove(indexOf);
            list.remove(indexOf);
            list.add(list.size() - 1, "-vf");
            list.add(list.size() - 1, new org.b.a.a.a(String.valueOf(this.f28697a.width()), String.valueOf(this.f28697a.height()), String.valueOf(this.f28697a.left), String.valueOf(this.f28697a.top)).a() + ",scale=" + this.f28698b + ":" + this.f28699c);
            super.a(list, aVar);
        }

        public void a(boolean z, String str, String str2, String str3, d.a aVar, VideoEditEntity videoEditEntity) throws Exception {
            VideoPostParams videoPostParams = videoEditEntity.getVideoPostParams();
            ArrayList arrayList = new ArrayList();
            arrayList.add(a());
            arrayList.add("-y");
            arrayList.add("-noautorotate");
            arrayList.add("-ss");
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            arrayList.add("-i");
            arrayList.add(str2);
            arrayList.add("-t");
            arrayList.add(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(videoPostParams.getDuration())}));
            if (!z) {
                arrayList.add("-an");
            }
            arrayList.add("-async");
            arrayList.add("1");
            arrayList.add("-vf");
            arrayList.add("scale=" + videoPostParams.getVideoWidth() + ":" + videoPostParams.getVideoHeight());
            h.b("PostStatusTask", "add clip video size " + videoPostParams.getVideoWidth() + "," + videoPostParams.getVideoHeight());
            arrayList.add("-sws_flags");
            arrayList.add("fast_bilinear");
            arrayList.add("-acodec");
            arrayList.add("copy");
            arrayList.add("-vcodec");
            arrayList.add("libx264");
            arrayList.add("-r");
            arrayList.add(String.valueOf(30));
            if (!com.shopee.feeds.feedlibrary.util.d.a(str)) {
                arrayList.add("-b:v");
                arrayList.add(str);
            }
            arrayList.add("-threads");
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            arrayList.add("-preset");
            arrayList.add("superfast");
            arrayList.add("-strict");
            arrayList.add("-2");
            arrayList.add("-movflags");
            arrayList.add("faststart");
            arrayList.add(str3);
            try {
                a((List<String>) arrayList, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void a(String str, String str2, String str3, int i, String str4, d.a aVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a());
            arrayList.add("-y");
            arrayList.add("-noautorotate");
            arrayList.add("-i");
            arrayList.add(str);
            arrayList.add("-i");
            arrayList.add(str2);
            arrayList.add("-async");
            arrayList.add("1");
            arrayList.add("-filter_complex");
            arrayList.add("[0:0]" + new org.b.a.a.a(String.valueOf(this.f28697a.width()), String.valueOf(this.f28697a.height()), String.valueOf(this.f28697a.left), String.valueOf(this.f28697a.top)).a() + ",scale=" + this.f28698b + ":" + this.f28699c + "[tmp],[tmp][1:0]overlay=format=rgb");
            arrayList.add("-pix_fmt");
            arrayList.add("yuv420p");
            arrayList.add("-sws_flags");
            arrayList.add("fast_bilinear");
            arrayList.add("-acodec");
            arrayList.add("copy");
            arrayList.add("-vcodec");
            arrayList.add("libx264");
            arrayList.add("-r");
            arrayList.add(String.valueOf(30));
            if (!com.shopee.feeds.feedlibrary.util.d.a(str3)) {
                arrayList.add("-b:v");
                arrayList.add(str3);
            }
            arrayList.add("-threads");
            arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            arrayList.add("-preset");
            arrayList.add("superfast");
            arrayList.add("-strict");
            arrayList.add("-2");
            arrayList.add("-movflags");
            arrayList.add("faststart");
            arrayList.add("-pix_fmt");
            arrayList.add("yuv420p");
            if (i != 0) {
                arrayList.add("-metadata:s:v:0");
                arrayList.add("rotate=" + i);
            }
            arrayList.add(str4);
            try {
                super.a((List<String>) arrayList, aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
