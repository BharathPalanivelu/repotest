package com.shopee.app.ui.gallery;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.image.j;
import com.shopee.app.util.af;
import com.squareup.a.w;
import java.io.File;
import java.util.ArrayList;

public class a extends LinearLayout implements n<GalleryAlbumInfo> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f21844a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21845b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21846c;

    public a(Context context) {
        super(context);
    }

    public void a(GalleryAlbumInfo galleryAlbumInfo) {
        this.f21845b.setText(galleryAlbumInfo.getName());
        ArrayList<GalleryItemInfo> imageList = galleryAlbumInfo.getImageList();
        if (!af.a(imageList)) {
            this.f21846c.setText(String.valueOf(imageList.size()));
            if (imageList.get(0).isVideo()) {
                w a2 = j.a(getContext());
                a2.a("video://" + galleryAlbumInfo.getImagePath()).b(o.f21983a, o.f21983a).d().a(this.f21844a);
                return;
            }
            w.a(getContext()).a(Uri.fromFile(new File(galleryAlbumInfo.getImagePath()))).b(o.f21983a, o.f21983a).d().a(this.f21844a);
        }
    }
}
