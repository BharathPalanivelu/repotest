package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.garena.android.appkit.d.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.activity.PicPreviewActivity;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoPostParams;
import com.shopee.feeds.feedlibrary.util.c.b;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.util.q;
import com.squareup.a.ab;
import com.squareup.a.e;
import com.squareup.a.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CreatePostPictureAdapter extends a<String> {

    /* renamed from: e  reason: collision with root package name */
    b f27468e;

    /* renamed from: f  reason: collision with root package name */
    w f27469f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f27470g = -1;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public int i;

    public class PictureViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private PictureViewHolder f27475b;

        public PictureViewHolder_ViewBinding(PictureViewHolder pictureViewHolder, View view) {
            this.f27475b = pictureViewHolder;
            pictureViewHolder.ivPicture = (ImageView) butterknife.a.b.a(view, c.e.iv_picture, "field 'ivPicture'", ImageView.class);
            pictureViewHolder.ivVideo = (ImageView) butterknife.a.b.a(view, c.e.iv_video, "field 'ivVideo'", ImageView.class);
            pictureViewHolder.flPostPic = (FrameLayout) butterknife.a.b.a(view, c.e.fl_post_pic, "field 'flPostPic'", FrameLayout.class);
            pictureViewHolder.ivVideoTag = (ImageView) butterknife.a.b.a(view, c.e.iv_video_tag, "field 'ivVideoTag'", ImageView.class);
        }
    }

    public CreatePostPictureAdapter(Context context, int i2) {
        super(context);
        this.f27470g = i2;
        this.f27468e = new b();
        this.f27469f = new w.a(context).a((ab) this.f27468e).a();
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new PictureViewHolder(this.f27559c.inflate(c.f.feeds_layout_create_post_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i2) {
        String str = (String) this.f27558b.get(i2);
        PictureViewHolder pictureViewHolder = (PictureViewHolder) wVar;
        if (!d.a(str)) {
            int i3 = this.f27470g;
            if (i3 == 1) {
                pictureViewHolder.ivVideoTag.setVisibility(8);
                pictureViewHolder.ivVideo.setVisibility(8);
                pictureViewHolder.ivPicture.setVisibility(0);
                if (j.a().g() > BitmapDescriptorFactory.HUE_RED && j.a().f() > BitmapDescriptorFactory.HUE_RED) {
                    a(j.a().f(), j.a().g(), pictureViewHolder.ivPicture);
                }
                w.a(this.f27557a).a(q.a(str)).a(j.a().p() ? c.d.feeds_shape_post_preview_one : c.d.feeds_shape_post_preview_two).b(j.a().p() ? c.d.feeds_shape_post_preview_one : c.d.feeds_shape_post_preview_two).a(pictureViewHolder.ivPicture, (e) new e() {
                    public void c() {
                    }

                    public void d() {
                        a.b("error!!", new Object[0]);
                    }
                });
            } else if (i3 == 2) {
                pictureViewHolder.ivVideoTag.setVisibility(0);
                pictureViewHolder.ivVideo.setVisibility(0);
                pictureViewHolder.ivPicture.setVisibility(8);
                VideoPostParams t = j.a().t();
                if (t != null && t.getVideoWidth() > 0) {
                    a((float) t.getVideoWidth(), (float) t.getVideoHeight(), pictureViewHolder.ivVideo);
                }
                w wVar2 = this.f27469f;
                wVar2.a("video:" + str).a(pictureViewHolder.ivVideo);
                pictureViewHolder.flPostPic.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                    }
                });
            }
            pictureViewHolder.flPostPic.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PicPreviewActivity.a(CreatePostPictureAdapter.this.f27557a, CreatePostPictureAdapter.this.f27470g, i2, CreatePostPictureAdapter.this.f27558b, CreatePostPictureAdapter.this.h, CreatePostPictureAdapter.this.i);
                }
            });
        }
    }

    static class PictureViewHolder extends RecyclerView.w {
        @BindView
        FrameLayout flPostPic;
        @BindView
        ImageView ivPicture;
        @BindView
        ImageView ivVideo;
        @BindView
        ImageView ivVideoTag;

        public PictureViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public void a(VideoEditEntity videoEditEntity) {
        HashMap<String, Integer[]> cleanEditImageSizeMap = videoEditEntity.getCleanEditImageSizeMap();
        if (cleanEditImageSizeMap != null && cleanEditImageSizeMap.size() > 0) {
            Iterator<Map.Entry<String, Integer[]>> it = cleanEditImageSizeMap.entrySet().iterator();
            if (it.hasNext()) {
                Integer[] numArr = (Integer[]) it.next().getValue();
                this.h = numArr[0].intValue();
                this.i = numArr[1].intValue();
            }
        }
    }

    public void a(float f2, float f3, ImageView imageView) {
        float f4;
        int a2 = l.a(4, this.f27557a);
        float f5 = BitmapDescriptorFactory.HUE_RED;
        if (f2 == f3) {
            f5 = (float) l.a(124, this.f27557a);
            f4 = (float) l.a(124, this.f27557a);
        } else if (f2 > f3) {
            f5 = (float) l.a(124, this.f27557a);
            f4 = (((float) l.a(124, this.f27557a)) * f3) / f2;
        } else if (f3 > f2) {
            float a3 = (float) l.a(124, this.f27557a);
            f5 = (((float) l.a(124, this.f27557a)) * f2) / f3;
            f4 = a3;
        } else {
            f4 = BitmapDescriptorFactory.HUE_RED;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) f5;
        layoutParams.height = (int) f4;
        layoutParams.setMargins(a2, a2, a2, a2);
        imageView.setLayoutParams(layoutParams);
    }
}
