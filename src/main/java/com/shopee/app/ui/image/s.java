package com.shopee.app.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.garena.android.uikit.image.c.a;
import com.shopee.app.ui.video.VideoViewerView;
import com.shopee.app.ui.video.VideoViewerView_;
import java.util.List;

public abstract class s implements GImageBrowserView.a {

    /* renamed from: a  reason: collision with root package name */
    private List<MediaData> f23078a;

    public View a(Context context, MediaData mediaData, int i) {
        return null;
    }

    public abstract List<MediaData> a();

    public abstract void a(a aVar, String str, int i);

    public abstract void a(VideoViewerView videoViewerView, MediaData mediaData, int i);

    public int b() {
        List<MediaData> list = this.f23078a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public View b(Context context, int i) {
        MediaData mediaData = this.f23078a.get(i);
        if (mediaData.isVideo()) {
            VideoViewerView a2 = VideoViewerView_.a(context);
            a(a2, mediaData, i);
            return a2;
        }
        a aVar = new a(context);
        a(aVar, mediaData.getPath(), i);
        return aVar;
    }

    public View a(Context context, int i) {
        if (i < 0 || i >= this.f23078a.size()) {
            return null;
        }
        return a(context, this.f23078a.get(i), i);
    }

    public void a(View view, View view2, int i) {
        if (this.f23078a.get(i).isVideo()) {
            ((VideoViewerView) view).d();
            return;
        }
        a aVar = (a) view;
        aVar.d();
        aVar.setImageBitmap((Bitmap) null);
    }

    public void b(View view, View view2, int i) {
        if (this.f23078a.get(i).isVideo()) {
            VideoViewerView videoViewerView = (VideoViewerView) view;
            if (videoViewerView.getCurrentPosition() < videoViewerView.getDuration()) {
                videoViewerView.c();
                return;
            }
            return;
        }
        ((a) view).e();
    }

    public void c(View view, View view2, int i) {
        if (this.f23078a.get(i).isVideo()) {
            ((VideoViewerView) view).a(10);
        }
    }

    public void c() {
        this.f23078a = a();
    }
}
