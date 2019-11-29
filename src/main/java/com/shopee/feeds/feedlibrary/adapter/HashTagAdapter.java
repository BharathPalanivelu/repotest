package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.CaptionTagEntity;
import com.shopee.feeds.feedlibrary.util.v;
import com.shopee.feeds.feedlibrary.view.HashTagPortraitView;

public class HashTagAdapter extends a<CaptionTagEntity> {

    /* renamed from: e  reason: collision with root package name */
    private int f27484e;

    public class HashTagViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private HashTagViewHolder f27489b;

        public HashTagViewHolder_ViewBinding(HashTagViewHolder hashTagViewHolder, View view) {
            this.f27489b = hashTagViewHolder;
            hashTagViewHolder.hashTagPortraitView = (HashTagPortraitView) b.a(view, c.e.portrait_view, "field 'hashTagPortraitView'", HashTagPortraitView.class);
            hashTagViewHolder.name = (RobotoTextView) b.a(view, c.e.name, "field 'name'", RobotoTextView.class);
            hashTagViewHolder.mLlTagItem = (LinearLayout) b.a(view, c.e.ll_tag_item, "field 'mLlTagItem'", LinearLayout.class);
            hashTagViewHolder.tvHashTagNum = (RobotoTextView) b.a(view, c.e.tv_hashtag_num, "field 'tvHashTagNum'", RobotoTextView.class);
        }
    }

    public void a(int i) {
        this.f27484e = i;
    }

    public HashTagAdapter(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HashTagViewHolder(this.f27559c.inflate(c.f.feeds_layout_hashtag, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        final CaptionTagEntity captionTagEntity = (CaptionTagEntity) this.f27558b.get(i);
        final HashTagViewHolder hashTagViewHolder = (HashTagViewHolder) wVar;
        hashTagViewHolder.hashTagPortraitView.setImage(captionTagEntity.getUrl());
        int i2 = this.f27484e;
        if (i2 == 1) {
            hashTagViewHolder.hashTagPortraitView.b();
            RobotoTextView robotoTextView = hashTagViewHolder.name;
            robotoTextView.setText("#" + captionTagEntity.getName().toLowerCase());
            if (captionTagEntity.getNum() > 1) {
                hashTagViewHolder.tvHashTagNum.setText(String.format(com.garena.android.appkit.tools.b.e(c.g.feeds_txt_posts), new Object[]{v.a(String.valueOf(captionTagEntity.getNum()), 1)}));
                hashTagViewHolder.tvHashTagNum.setVisibility(0);
            } else if (captionTagEntity.getNum() >= 0) {
                hashTagViewHolder.tvHashTagNum.setText(String.format(com.garena.android.appkit.tools.b.e(c.g.feeds_txt_post), new Object[]{String.valueOf(captionTagEntity.getNum())}));
                hashTagViewHolder.tvHashTagNum.setVisibility(0);
            } else {
                hashTagViewHolder.tvHashTagNum.setVisibility(8);
            }
        } else if (i2 == 2) {
            hashTagViewHolder.hashTagPortraitView.a();
            hashTagViewHolder.name.setText(captionTagEntity.getName());
            hashTagViewHolder.tvHashTagNum.setVisibility(8);
        }
        hashTagViewHolder.mLlTagItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HashTagAdapter.this.f27560d != null) {
                    HashTagAdapter.this.f27560d.a(i, captionTagEntity, hashTagViewHolder.mLlTagItem);
                }
            }
        });
    }

    static class HashTagViewHolder extends RecyclerView.w {
        @BindView
        HashTagPortraitView hashTagPortraitView;
        @BindView
        LinearLayout mLlTagItem;
        @BindView
        RobotoTextView name;
        @BindView
        RobotoTextView tvHashTagNum;

        public HashTagViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }
}
