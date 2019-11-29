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
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FeedsInstagramData;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.u;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class PickInsPicAdapter extends a<FeedsInstagramData> {

    /* renamed from: e  reason: collision with root package name */
    private int f27490e = 1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<FeedsInstagramData> f27491f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private Animation f27492g;
    private FeedsInstagramData h;
    private FeedsInstagramData i;
    /* access modifiers changed from: private */
    public a j;

    public interface a {
        void a(FeedsInstagramData feedsInstagramData, int i);

        void a(List<FeedsInstagramData> list);

        void b(FeedsInstagramData feedsInstagramData, int i);
    }

    public class SelectorPictureViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private SelectorPictureViewHolder f27498b;

        public SelectorPictureViewHolder_ViewBinding(SelectorPictureViewHolder selectorPictureViewHolder, View view) {
            this.f27498b = selectorPictureViewHolder;
            selectorPictureViewHolder.ivPicture = (ImageView) b.a(view, c.e.iv_picture, "field 'ivPicture'", ImageView.class);
            selectorPictureViewHolder.check = (TextView) b.a(view, c.e.check, "field 'check'", TextView.class);
            selectorPictureViewHolder.llCheck = (LinearLayout) b.a(view, c.e.ll_check, "field 'llCheck'", LinearLayout.class);
            selectorPictureViewHolder.tvIsGif = (TextView) b.a(view, c.e.tv_isGif, "field 'tvIsGif'", TextView.class);
            selectorPictureViewHolder.tvLongChart = (TextView) b.a(view, c.e.tv_long_chart, "field 'tvLongChart'", TextView.class);
            selectorPictureViewHolder.tvDuration = (TextView) b.a(view, c.e.tv_duration, "field 'tvDuration'", TextView.class);
        }
    }

    public PickInsPicAdapter(Context context) {
        super(context);
        this.f27492g = com.shopee.feeds.feedlibrary.picture.b.a(context, c.a.modal_in);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new SelectorPictureViewHolder(this.f27559c.inflate(c.f.feeds_picture_image_grid_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i2) {
        final SelectorPictureViewHolder selectorPictureViewHolder = (SelectorPictureViewHolder) wVar;
        final FeedsInstagramData feedsInstagramData = (FeedsInstagramData) this.f27558b.get(i2);
        w.a(this.f27557a).a(com.shopee.feeds.feedlibrary.data.c.b.b(feedsInstagramData.getThumbnail())).b(320, 320).d().a(c.d.feeds_image_placeholder).a(Bitmap.Config.RGB_565).a((Object) "instagram").b(c.d.feeds_image_placeholder).f().a(selectorPictureViewHolder.ivPicture);
        int i3 = this.f27490e;
        if (i3 == 1) {
            selectorPictureViewHolder.llCheck.setVisibility(8);
        } else if (i3 == 2) {
            selectorPictureViewHolder.llCheck.setVisibility(0);
        }
        FeedsInstagramData feedsInstagramData2 = this.h;
        if (feedsInstagramData2 == null || !feedsInstagramData.isSameImage(feedsInstagramData2)) {
            selectorPictureViewHolder.ivPicture.clearColorFilter();
        } else {
            selectorPictureViewHolder.ivPicture.setColorFilter(androidx.core.content.b.c(this.f27557a, c.b.filter_color_fa), PorterDuff.Mode.SRC_ATOP);
        }
        if (this.f27490e != 2 || !e(feedsInstagramData)) {
            selectorPictureViewHolder.check.setSelected(false);
            selectorPictureViewHolder.check.setText("");
        } else {
            selectorPictureViewHolder.check.setSelected(true);
            if (f(feedsInstagramData) != -1) {
                selectorPictureViewHolder.check.setText(String.valueOf(f(feedsInstagramData)));
            }
        }
        selectorPictureViewHolder.f27497a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.f();
                if (PickInsPicAdapter.this.d(feedsInstagramData)) {
                    PickInsPicAdapter.this.a(selectorPictureViewHolder, feedsInstagramData, i2);
                    PickInsPicAdapter.this.j.a(PickInsPicAdapter.this.f27491f);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(SelectorPictureViewHolder selectorPictureViewHolder, FeedsInstagramData feedsInstagramData, int i2) {
        int i3 = this.f27490e;
        if (i3 == 1) {
            b(selectorPictureViewHolder, feedsInstagramData, i2);
        } else if (i3 == 2) {
            c(selectorPictureViewHolder, feedsInstagramData, i2);
        }
    }

    private void b(SelectorPictureViewHolder selectorPictureViewHolder, FeedsInstagramData feedsInstagramData, int i2) {
        if (!feedsInstagramData.isSameImage(this.h)) {
            this.i = this.h;
            this.h = feedsInstagramData;
            e();
            this.f27491f.clear();
            this.f27491f.add(feedsInstagramData);
            this.j.a(feedsInstagramData, i2);
        }
    }

    private void c(SelectorPictureViewHolder selectorPictureViewHolder, FeedsInstagramData feedsInstagramData, int i2) {
        if (!feedsInstagramData.isSameImage(this.h)) {
            d(selectorPictureViewHolder, feedsInstagramData, i2);
        } else if (this.f27491f.size() > 0) {
            selectorPictureViewHolder.check.setSelected(false);
            selectorPictureViewHolder.check.setText("");
            c(feedsInstagramData);
            if (this.f27491f.size() > 0) {
                selectorPictureViewHolder.ivPicture.clearColorFilter();
                d();
            }
            f();
            this.j.b(feedsInstagramData, i2);
        } else {
            d(selectorPictureViewHolder, feedsInstagramData, i2);
        }
    }

    private void d(SelectorPictureViewHolder selectorPictureViewHolder, FeedsInstagramData feedsInstagramData, int i2) {
        selectorPictureViewHolder.check.setSelected(true);
        selectorPictureViewHolder.check.startAnimation(this.f27492g);
        this.i = this.h;
        this.h = feedsInstagramData;
        this.j.a(feedsInstagramData, i2);
        if (!e(feedsInstagramData)) {
            this.f27491f.add(feedsInstagramData);
        }
        f();
    }

    private void d() {
        if (this.f27491f.size() >= 1) {
            for (int i2 = 0; i2 < this.f27558b.size(); i2++) {
                String image = ((FeedsInstagramData) this.f27558b.get(i2)).getImage();
                List<FeedsInstagramData> list = this.f27491f;
                if (image.equals(list.get(list.size() - 1).getImage())) {
                    this.i = this.h;
                    this.h = (FeedsInstagramData) this.f27558b.get(i2);
                    this.j.a((FeedsInstagramData) this.f27558b.get(i2), i2);
                    return;
                }
            }
        }
    }

    private void e() {
        if (this.f27558b.size() > 0) {
            FeedsInstagramData feedsInstagramData = this.i;
            if (feedsInstagramData != null) {
                int b2 = b(feedsInstagramData);
                if (b2 != -1) {
                    notifyItemChanged(b2);
                }
            }
            FeedsInstagramData feedsInstagramData2 = this.h;
            if (feedsInstagramData2 != null) {
                int b3 = b(feedsInstagramData2);
                if (b3 != -1) {
                    notifyItemChanged(b3);
                }
            }
        }
    }

    private void f() {
        if (this.f27491f.size() > 0) {
            for (int i2 = 0; i2 < this.f27491f.size(); i2++) {
                int b2 = b(this.f27491f.get(i2));
                if (-1 != b2) {
                    notifyItemChanged(b2);
                }
            }
        }
    }

    private int b(FeedsInstagramData feedsInstagramData) {
        if (this.f27558b.size() <= 0) {
            return -1;
        }
        for (int i2 = 0; i2 < this.f27558b.size(); i2++) {
            if (feedsInstagramData.getImage().equals(((FeedsInstagramData) this.f27558b.get(i2)).getImage())) {
                return i2;
            }
        }
        return -1;
    }

    private void c(FeedsInstagramData feedsInstagramData) {
        if (this.f27491f.size() > 0) {
            for (int i2 = 0; i2 < this.f27491f.size(); i2++) {
                FeedsInstagramData feedsInstagramData2 = this.f27491f.get(i2);
                if (feedsInstagramData2.getImage().equals(feedsInstagramData.getImage())) {
                    this.f27491f.remove(feedsInstagramData2);
                }
            }
        }
    }

    public void a(FeedsInstagramData feedsInstagramData) {
        this.h = feedsInstagramData;
        if (!e(feedsInstagramData)) {
            this.f27491f.add(feedsInstagramData);
        }
    }

    /* access modifiers changed from: private */
    public boolean d(FeedsInstagramData feedsInstagramData) {
        if (this.f27490e != 2 || e(feedsInstagramData) || this.f27491f.size() < 5) {
            return true;
        }
        u.a(this.f27557a, com.garena.android.appkit.tools.b.a(c.g.feeds_picture_limit_tips, 5));
        return false;
    }

    static class SelectorPictureViewHolder extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        View f27497a;
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
            this.f27497a = view;
            ButterKnife.a(this, view);
        }
    }

    public void a(int i2) {
        this.f27490e = i2;
        c();
        this.f27491f.add(this.h);
        notifyDataSetChanged();
    }

    public void c() {
        List<FeedsInstagramData> list = this.f27491f;
        if (list != null) {
            list.clear();
        }
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    private boolean e(FeedsInstagramData feedsInstagramData) {
        if (this.f27491f.size() > 0) {
            for (int i2 = 0; i2 < this.f27491f.size(); i2++) {
                if (this.f27491f.get(i2).getImage().equals(feedsInstagramData.getImage())) {
                    return true;
                }
            }
        }
        return false;
    }

    private int f(FeedsInstagramData feedsInstagramData) {
        if (feedsInstagramData == null || this.f27491f.size() <= 0) {
            return -1;
        }
        for (int i2 = 0; i2 < this.f27491f.size(); i2++) {
            if (feedsInstagramData.getImage().equals(this.f27491f.get(i2).getImage())) {
                return i2 + 1;
            }
        }
        return -1;
    }
}
