package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.picture.LocalMedia;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.c.b;
import com.shopee.feeds.feedlibrary.util.f;
import com.shopee.feeds.feedlibrary.util.u;
import com.squareup.a.ab;
import com.squareup.a.w;
import com.tencent.imsdk.BaseConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SelectorPictureAdapter extends a<LocalMedia> {

    /* renamed from: e  reason: collision with root package name */
    b f27537e;

    /* renamed from: f  reason: collision with root package name */
    w f27538f;

    /* renamed from: g  reason: collision with root package name */
    private int f27539g = 1;
    /* access modifiers changed from: private */
    public List<LocalMedia> h = new ArrayList();
    private Animation i;
    private LocalMedia j;
    private LocalMedia k;
    /* access modifiers changed from: private */
    public a l;

    public interface a {
        void a(LocalMedia localMedia, int i);

        void a(List<LocalMedia> list);

        void b(LocalMedia localMedia, int i);
    }

    public class SelectorPictureViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private SelectorPictureViewHolder f27547b;

        public SelectorPictureViewHolder_ViewBinding(SelectorPictureViewHolder selectorPictureViewHolder, View view) {
            this.f27547b = selectorPictureViewHolder;
            selectorPictureViewHolder.ivPicture = (ImageView) butterknife.a.b.a(view, c.e.iv_picture, "field 'ivPicture'", ImageView.class);
            selectorPictureViewHolder.check = (TextView) butterknife.a.b.a(view, c.e.check, "field 'check'", TextView.class);
            selectorPictureViewHolder.llCheck = (LinearLayout) butterknife.a.b.a(view, c.e.ll_check, "field 'llCheck'", LinearLayout.class);
            selectorPictureViewHolder.tvIsGif = (TextView) butterknife.a.b.a(view, c.e.tv_isGif, "field 'tvIsGif'", TextView.class);
            selectorPictureViewHolder.tvLongChart = (TextView) butterknife.a.b.a(view, c.e.tv_long_chart, "field 'tvLongChart'", TextView.class);
            selectorPictureViewHolder.tvDuration = (TextView) butterknife.a.b.a(view, c.e.tv_duration, "field 'tvDuration'", TextView.class);
        }
    }

    public SelectorPictureAdapter(Context context) {
        super(context);
        this.i = com.shopee.feeds.feedlibrary.picture.b.a(context, c.a.modal_in);
        this.f27537e = new b();
        this.f27538f = new w.a(context).a((ab) this.f27537e).a();
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new SelectorPictureViewHolder(this.f27559c.inflate(c.f.feeds_picture_image_grid_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i2) {
        final SelectorPictureViewHolder selectorPictureViewHolder = (SelectorPictureViewHolder) wVar;
        final LocalMedia localMedia = (LocalMedia) this.f27558b.get(i2);
        final String b2 = localMedia.b();
        String a2 = localMedia.a();
        final int a3 = com.shopee.feeds.feedlibrary.picture.c.a(a2);
        selectorPictureViewHolder.tvIsGif.setVisibility(com.shopee.feeds.feedlibrary.picture.c.b(a2) ? 0 : 8);
        selectorPictureViewHolder.tvDuration.setVisibility(a3 == 2 ? 0 : 8);
        selectorPictureViewHolder.tvLongChart.setVisibility(com.shopee.feeds.feedlibrary.picture.c.a(localMedia) ? 0 : 8);
        selectorPictureViewHolder.tvDuration.setText(f.a(localMedia.c()));
        if (localMedia.a().startsWith("image")) {
            w.a(this.f27557a).a(a(b2)).b(320, 320).d().a(c.d.feeds_image_placeholder).a(Bitmap.Config.RGB_565).a((Object) "PhotoTag").a(w.e.HIGH).b(c.d.feeds_image_placeholder).f().a(selectorPictureViewHolder.ivPicture);
        } else {
            w wVar2 = this.f27538f;
            wVar2.a("video:" + b2).a(selectorPictureViewHolder.ivPicture);
        }
        int i3 = this.f27539g;
        if (i3 == 1) {
            selectorPictureViewHolder.llCheck.setVisibility(8);
        } else if (i3 == 2) {
            selectorPictureViewHolder.llCheck.setVisibility(0);
        }
        LocalMedia localMedia2 = this.j;
        if (localMedia2 == null || !localMedia.a(localMedia2)) {
            selectorPictureViewHolder.ivPicture.clearColorFilter();
        } else {
            selectorPictureViewHolder.ivPicture.setColorFilter(androidx.core.content.b.c(this.f27557a, c.b.filter_color_fa), PorterDuff.Mode.SRC_ATOP);
        }
        if (this.f27539g != 2 || !e(localMedia)) {
            selectorPictureViewHolder.check.setSelected(false);
            selectorPictureViewHolder.check.setText("");
        } else {
            selectorPictureViewHolder.check.setSelected(true);
            if (f(localMedia) != -1) {
                selectorPictureViewHolder.check.setText(String.valueOf(f(localMedia)));
            }
        }
        final int i4 = i2;
        selectorPictureViewHolder.f27546a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!new File(b2).exists()) {
                    u.a(view.getContext(), com.shopee.feeds.feedlibrary.picture.c.a(view.getContext(), a3));
                    return;
                }
                e.f();
                if (SelectorPictureAdapter.this.d(localMedia)) {
                    SelectorPictureAdapter.this.a(selectorPictureViewHolder, localMedia, i4);
                    SelectorPictureAdapter.this.l.a(SelectorPictureAdapter.this.h);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(SelectorPictureViewHolder selectorPictureViewHolder, LocalMedia localMedia, int i2) {
        int i3 = this.f27539g;
        if (i3 == 1) {
            b(selectorPictureViewHolder, localMedia, i2);
        } else if (i3 == 2) {
            c(selectorPictureViewHolder, localMedia, i2);
        }
    }

    private void b(SelectorPictureViewHolder selectorPictureViewHolder, LocalMedia localMedia, int i2) {
        if (!localMedia.a(this.j)) {
            this.k = this.j;
            this.j = localMedia;
            e();
            this.h.clear();
            this.h.add(localMedia);
            this.l.a(localMedia, i2);
        }
    }

    private void c(SelectorPictureViewHolder selectorPictureViewHolder, LocalMedia localMedia, int i2) {
        if (!localMedia.a(this.j)) {
            d(selectorPictureViewHolder, localMedia, i2);
        } else if (this.h.size() > 0) {
            selectorPictureViewHolder.check.setSelected(false);
            selectorPictureViewHolder.check.setText("");
            c(localMedia);
            if (this.h.size() > 0) {
                selectorPictureViewHolder.ivPicture.clearColorFilter();
                d();
            }
            f();
            this.l.b(localMedia, i2);
        } else {
            d(selectorPictureViewHolder, localMedia, i2);
        }
    }

    private void d(SelectorPictureViewHolder selectorPictureViewHolder, LocalMedia localMedia, int i2) {
        selectorPictureViewHolder.check.setSelected(true);
        selectorPictureViewHolder.check.startAnimation(this.i);
        this.k = this.j;
        this.j = localMedia;
        this.l.a(localMedia, i2);
        if (!e(localMedia)) {
            this.h.add(localMedia);
        }
        f();
    }

    private void d() {
        if (this.h.size() >= 1) {
            for (int i2 = 0; i2 < this.f27558b.size(); i2++) {
                String b2 = ((LocalMedia) this.f27558b.get(i2)).b();
                List<LocalMedia> list = this.h;
                if (b2.equals(list.get(list.size() - 1).b())) {
                    this.k = this.j;
                    this.j = (LocalMedia) this.f27558b.get(i2);
                    this.l.a((LocalMedia) this.f27558b.get(i2), i2);
                    return;
                }
            }
        }
    }

    private void e() {
        if (this.f27558b.size() > 0) {
            LocalMedia localMedia = this.k;
            if (localMedia != null) {
                int b2 = b(localMedia);
                if (b2 != -1) {
                    notifyItemChanged(b2);
                }
            }
            LocalMedia localMedia2 = this.j;
            if (localMedia2 != null) {
                int b3 = b(localMedia2);
                if (b3 != -1) {
                    notifyItemChanged(b3);
                }
            }
        }
    }

    private void f() {
        if (this.h.size() > 0) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                int b2 = b(this.h.get(i2));
                if (-1 != b2) {
                    notifyItemChanged(b2);
                }
            }
        }
    }

    private int b(LocalMedia localMedia) {
        if (this.f27558b.size() <= 0) {
            return -1;
        }
        for (int i2 = 0; i2 < this.f27558b.size(); i2++) {
            if (localMedia.b().equals(((LocalMedia) this.f27558b.get(i2)).b())) {
                return i2;
            }
        }
        return -1;
    }

    private void c(LocalMedia localMedia) {
        if (this.h.size() > 0) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                LocalMedia localMedia2 = this.h.get(i2);
                if (localMedia2.b().equals(localMedia.b())) {
                    this.h.remove(localMedia2);
                }
            }
        }
    }

    public void a(LocalMedia localMedia) {
        this.j = localMedia;
        if (!e(localMedia)) {
            this.h.add(localMedia);
        }
    }

    /* access modifiers changed from: private */
    public boolean d(LocalMedia localMedia) {
        boolean startsWith = localMedia.a().startsWith("video");
        if (this.f27539g == 2) {
            if (startsWith) {
                u.a(this.f27557a, com.garena.android.appkit.tools.b.e(c.g.feeds_select_video_not_allow_in_multi_mode_tips));
                return false;
            } else if (!e(localMedia) && this.h.size() >= 5) {
                u.a(this.f27557a, com.garena.android.appkit.tools.b.a(c.g.feeds_picture_limit_tips, 5));
                return false;
            }
        } else if (startsWith && (localMedia.c() < 3000 || localMedia.c() > BaseConstants.DEFAULT_MSG_TIMEOUT)) {
            u.a(this.f27557a, com.garena.android.appkit.tools.b.a(c.g.feeds_video_duration_limit_tips, 3, 30));
            return false;
        }
        return true;
    }

    static class SelectorPictureViewHolder extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        View f27546a;
        @BindView
        TextView check;
        @BindView
        ImageView ivPicture;
        @BindView
        LinearLayout llCheck;
        @BindView
        TextView tvDuration;
        @BindView
        TextView tvIsGif;
        @BindView
        TextView tvLongChart;

        public SelectorPictureViewHolder(View view) {
            super(view);
            this.f27546a = view;
            ButterKnife.a(this, view);
        }
    }

    public void a(int i2) {
        this.f27539g = i2;
        c();
        this.h.add(this.j);
        notifyDataSetChanged();
    }

    public void c() {
        List<LocalMedia> list = this.h;
        if (list != null) {
            list.clear();
        }
    }

    public void a(a aVar) {
        this.l = aVar;
    }

    private boolean e(LocalMedia localMedia) {
        if (this.h.size() > 0) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (this.h.get(i2).b().equals(localMedia.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    private int f(LocalMedia localMedia) {
        if (localMedia == null || this.h.size() <= 0) {
            return -1;
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            if (localMedia.b().equals(this.h.get(i2).b())) {
                return i2 + 1;
            }
        }
        return -1;
    }

    private String a(String str) {
        if (str.startsWith("file://")) {
            return str;
        }
        return "file://" + str;
    }
}
