package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.s;
import com.squareup.a.e;
import com.squareup.a.w;

public class SelectStickerRecyclerAdapter extends a<a> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f27517e;

    public interface b {
        void a(int i, Object obj, int i2, int i3);
    }

    public class Holder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private Holder f27526b;

        public Holder_ViewBinding(Holder holder, View view) {
            this.f27526b = holder;
            holder.imageView = (ImageView) butterknife.a.b.a(view, c.e.iv_image, "field 'imageView'", ImageView.class);
        }
    }

    public void a(b bVar) {
        this.f27517e = bVar;
    }

    public SelectStickerRecyclerAdapter(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new Holder(this.f27559c.inflate(c.f.feeds_layout_photo_editor_sticker_choose_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        final Holder holder = (Holder) wVar;
        final a aVar = (a) this.f27558b.get(i);
        if (aVar != null) {
            AnonymousClass1 r1 = new e() {
                public void d() {
                }

                public void c() {
                    Drawable drawable = holder.imageView.getDrawable();
                    if (drawable != null) {
                        holder.a(s.a(SelectStickerRecyclerAdapter.this.f27557a, ((float) drawable.getIntrinsicWidth()) / 3.0f));
                        holder.b(s.a(SelectStickerRecyclerAdapter.this.f27557a, ((float) drawable.getIntrinsicHeight()) / 3.0f));
                    }
                }
            };
            if (!TextUtils.isEmpty(aVar.f27530d)) {
                w.a(this.f27557a).a(com.shopee.feeds.feedlibrary.data.c.b.b(aVar.f27530d)).a(c.d.feeds_ic_placeholder).b(c.d.feeds_ic_placeholder).a(holder.imageView, (e) r1);
            } else if (aVar.f27529c != 0) {
                w.a(this.f27557a).a(aVar.f27529c).a(c.d.feeds_ic_placeholder).b(c.d.feeds_ic_placeholder).a(holder.imageView, (e) r1);
            }
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (SelectStickerRecyclerAdapter.this.f27517e != null) {
                        if (holder.b() == 0 || holder.a() == 0) {
                            Drawable drawable = holder.imageView.getDrawable();
                            if (drawable != null) {
                                holder.a(s.a(SelectStickerRecyclerAdapter.this.f27557a, ((float) drawable.getIntrinsicWidth()) / 3.0f));
                                holder.b(s.a(SelectStickerRecyclerAdapter.this.f27557a, ((float) drawable.getIntrinsicHeight()) / 3.0f));
                            }
                        }
                        SelectStickerRecyclerAdapter.this.f27517e.a(i, aVar, holder.a(), holder.b());
                    }
                }
            });
            a(holder.imageView);
        }
    }

    private void a(ImageView imageView) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = (int) ((float) ((this.f27557a.getResources().getDisplayMetrics().widthPixels / 3) - com.shopee.feeds.feedlibrary.util.w.a(this.f27557a, 20)));
        imageView.setLayoutParams(layoutParams);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f27527a;

        /* renamed from: b  reason: collision with root package name */
        private int f27528b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f27529c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f27530d;

        public a(int i, String str) {
            this.f27528b = i;
            this.f27530d = str;
        }

        public int a() {
            return this.f27528b;
        }

        public String b() {
            return this.f27530d;
        }

        public String c() {
            String str = this.f27527a;
            return str == null ? "" : str;
        }

        public void a(String str) {
            this.f27527a = str;
        }
    }

    public static class Holder extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        int f27524a;

        /* renamed from: b  reason: collision with root package name */
        int f27525b;
        @BindView
        ImageView imageView;

        public Holder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }

        public int a() {
            return this.f27524a;
        }

        public void a(int i) {
            this.f27524a = i;
        }

        public int b() {
            return this.f27525b;
        }

        public void b(int i) {
            this.f27525b = i;
        }
    }
}
