package com.shopee.app.react.modules.ui.mediabrowser;

import android.app.Activity;
import android.content.Intent;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.j;
import com.shopee.app.util.af;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.MediaBrowserData;
import com.shopee.react.sdk.bridge.protocol.MediaBrowserResult;
import com.shopee.react.sdk.bridge.protocol.MediaData;
import java.util.ArrayList;

public class a extends com.shopee.react.sdk.bridge.modules.ui.mediabrowser.a {

    /* renamed from: a  reason: collision with root package name */
    private c<MediaBrowserResult> f18895a;

    private void a(int i, boolean z, int i2, boolean z2) {
        c<MediaBrowserResult> cVar = this.f18895a;
        if (cVar != null) {
            cVar.a(MediaBrowserResult.newResult(i, z, i2, z2));
        }
    }

    private void a() {
        c<MediaBrowserResult> cVar = this.f18895a;
        if (cVar != null) {
            cVar.a(MediaBrowserResult.newError());
        }
    }

    public void a(Activity activity, MediaBrowserData mediaBrowserData, c<MediaBrowserResult> cVar) {
        this.f18895a = cVar;
        if (af.a(mediaBrowserData.getMediaList())) {
            a();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaBrowserData.Media next : mediaBrowserData.getMediaList()) {
            if (next.isVideo()) {
                arrayList.add(MediaData.newVideoData(next.getImageUrl(), next.getMediaUrl(), 0, next.getCurrentTime(), next.getTrackingData() != null ? next.getTrackingData().toString() : ""));
            } else {
                arrayList.add(MediaData.newImageData(next.getImageUrl()));
            }
        }
        j.f23021a = com.shopee.app.ui.image.MediaData.newListFromSdkMediaDataList(arrayList);
        ImageBrowserActivity_.a(activity).b(mediaBrowserData.getCurrentIndex()).b(mediaBrowserData.isMuted()).a(81);
    }

    public void a(int i, int i2, Intent intent) {
        if (i != 81) {
            return;
        }
        if (i2 == -1) {
            a(intent.getIntExtra("index", 0), intent.getBooleanExtra("isPlaying", false), intent.getIntExtra("curTime", 0), intent.getBooleanExtra("isMuted", true));
        } else {
            a();
        }
    }
}
