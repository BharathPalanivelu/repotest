package com.shopee.feeds.feedlibrary.editor.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.OnClick;
import com.garena.android.appkit.f.f;
import com.shopee.feeds.feedlibrary.adapter.EditPageProductAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.SaveProductEntity;
import com.shopee.feeds.feedlibrary.editor.VideoEditLayer;
import com.shopee.feeds.feedlibrary.editor.a.b;
import com.shopee.feeds.feedlibrary.editor.tag.a;
import com.shopee.feeds.feedlibrary.util.b.d;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.k;
import com.shopee.feeds.feedlibrary.view.CommonCheckButton;
import com.shopee.feeds.feedlibrary.view.preview.TextureVideoView;
import java.io.File;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class VideoEditActivity extends AbstractEditActivity {
    d i;
    /* access modifiers changed from: private */
    public CommonCheckButton j;
    private b k;
    private boolean l = false;

    public boolean e() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (j.a().t() == null) {
            com.shopee.feeds.feedlibrary.util.d.a((Object) "222222");
        }
        v();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.k.a().j();
        u().a(this.j.a());
        ArrayList a2 = i().getTagEditor().a();
        if (this.i != null && a2 != null && a2.size() > 0) {
            this.i.b();
            this.i.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.k.a().i();
    }

    private void v() {
        w();
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("source_path");
        int intExtra = getIntent().getIntExtra("vidoe_duration", 3);
        x();
        this.k = new b(this, this.tvRight);
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            this.k.a(intExtra);
            this.k.a((VideoEditLayer) i(), stringArrayListExtra.get(0), this.j);
            this.f7092e.e();
            new File(stringArrayListExtra.get(0));
            j.a().j().setVideo_original_file_size(k.f(stringArrayListExtra.get(0)));
            j.a().j().setVideo_duration(j.a().t().getDuration());
        }
        this.k.a((b.a) new b.a() {
            public void a() {
                VideoEditActivity.this.r();
            }
        });
        this.k.a().setIfTagCanDelete(false);
        f.a().a(new Runnable() {
            public void run() {
                VideoEditActivity.this.j.setChecked(true);
            }
        }, 500);
        u().setAvalibaleCallback(new TextureVideoView.a() {
            public void a() {
                f.a().a(new Runnable() {
                    public void run() {
                        VideoEditActivity.this.u().a(VideoEditActivity.this.j.a());
                    }
                });
            }
        });
    }

    private void w() {
        this.btnTopBack.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_nav_bar_title_edit_video));
        this.ivLeft.setImageResource(c.d.feeds_ic_left_arrow);
        this.tvRight.setVisibility(0);
        this.tvRight.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_button_next));
        this.tvTap.setVisibility(8);
        this.tvRemove.setVisibility(8);
        this.mTvMove.setVisibility(8);
        this.tagViewpager.setVisibility(8);
        this.rlVideoContainer.setVisibility(0);
        this.j = (CommonCheckButton) findViewById(c.e.checkbox_mute);
        this.j.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.j.setTranslationZ(4.0f);
        }
        this.mRvProduct.setLayoutManager(new LinearLayoutManager(this.f7086a));
        this.f7090c = new EditPageProductAdapter(this.f7086a);
        this.f7090c.a(new EditPageProductAdapter.a() {
            public void a(int i, com.shopee.feeds.feedlibrary.editor.tag.b bVar) {
                VideoEditActivity.this.i().getTagEditor().c((a) bVar);
                VideoEditActivity.this.n();
            }
        });
        this.mRvProduct.setAdapter(this.f7090c);
        this.i = new d(this.f7086a, this.mRvProduct, 2, true);
        this.i.a((d.a) new d.a() {
            public void a(int i) {
                VideoEditActivity.this.b(i);
            }
        });
    }

    @OnClick
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == c.e.tv_right) {
            this.k.c();
            e.x();
        } else if (id == c.e.rl_add_tag) {
            e.u();
        } else if (id == c.e.iv_add_text) {
            e.v();
        } else if (id == c.e.iv_add_sticker) {
            e.w();
        }
    }

    /* access modifiers changed from: protected */
    public com.shopee.feeds.feedlibrary.editor.b.d i() {
        return (com.shopee.feeds.feedlibrary.editor.b.d) findViewById(c.e.edit_layer);
    }

    /* access modifiers changed from: protected */
    public com.shopee.feeds.feedlibrary.editor.b.d j() {
        return (com.shopee.feeds.feedlibrary.editor.b.d) findViewById(c.e.edit_layer);
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return i().k();
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return i().getTextEditor().a().size() < 8;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        com.shopee.feeds.feedlibrary.editor.sticker.d stickerEditor = i().getStickerEditor();
        if (i2 == 1) {
            return stickerEditor.l();
        }
        if (i2 == 2) {
            return stickerEditor.m();
        }
        if (i2 == 3) {
            return stickerEditor.i();
        }
        if (i2 != 4) {
            return false;
        }
        return stickerEditor.k();
    }

    /* access modifiers changed from: protected */
    public int m() {
        return i().getTagEditor().a().size();
    }

    /* access modifiers changed from: protected */
    public void n() {
        ArrayList a2 = i().getTagEditor().a();
        if (a2.size() > 0) {
            this.mRvProduct.setVisibility(0);
            this.f7090c.a(a2);
            y();
            return;
        }
        this.mRvProduct.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void r() {
        Drawable drawable;
        ImageView imageView = this.ivAddTag;
        if (k()) {
            drawable = com.garena.android.appkit.tools.b.f(c.d.feeds_ic_tag);
        } else {
            drawable = com.garena.android.appkit.tools.b.f(c.d.feeds_ic_tag_unavailable);
        }
        imageView.setImageDrawable(drawable);
        int m = m();
        if (m > 0) {
            this.tvTagsNum.setVisibility(0);
            this.tvTagsNum.setText(String.valueOf(m));
            return;
        }
        this.tvTagsNum.setVisibility(8);
    }

    @m(a = ThreadMode.MAIN)
    public void onReceiveProducts(SaveProductEntity saveProductEntity) {
        if (saveProductEntity != null) {
            if (this.f7093f == null) {
                this.f7093f = new SaveProductEntity();
            }
            this.f7093f.setmPageType(saveProductEntity.getmPageType());
            this.f7093f.setProductItems(saveProductEntity.getProductItems());
            a(this.f7093f);
        }
    }

    private void a(SaveProductEntity saveProductEntity) {
        if (saveProductEntity != null) {
            ArrayList<ProductEntity.ProductItem> productItems = saveProductEntity.getProductItems();
            if (productItems != null && productItems.size() > 0) {
                com.shopee.feeds.feedlibrary.editor.b.d i2 = i();
                i2.getTagEditor().c();
                for (ProductEntity.ProductItem next : productItems) {
                    com.shopee.feeds.feedlibrary.editor.tag.b bVar = new com.shopee.feeds.feedlibrary.editor.tag.b();
                    bVar.b(1);
                    bVar.c(next.getName());
                    bVar.d(next.getPrice());
                    bVar.b(next.getItem_id());
                    bVar.c(next.getShop_id());
                    bVar.a(i2.getTapX());
                    bVar.b(i2.getTapY());
                    bVar.e((float) i2.getMeasuredWidth());
                    bVar.f((float) i2.getMeasuredHeight());
                    bVar.a(String.valueOf(System.currentTimeMillis()));
                    i2.getTagEditor().b((a) bVar);
                }
            } else if (productItems != null) {
                i().getTagEditor().c();
            }
        }
    }

    private void x() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rlVideoContainer.getLayoutParams();
        WindowManager windowManager = (WindowManager) getSystemService("window");
        if (windowManager != null && j.a().t() != null) {
            int videoWidth = j.a().t().getVideoWidth();
            int videoHeight = j.a().t().getVideoHeight();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.height = (int) ((float) ((displayMetrics.widthPixels * videoHeight) / videoWidth));
            this.rlVideoContainer.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public boolean t() {
        return this.k.d();
    }

    public void f() {
        e.k(this.f7087b);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        d dVar = this.i;
        if (dVar != null) {
            dVar.c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.i.c();
    }

    public TextureVideoView u() {
        return this.k.a().getVideoView();
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        ArrayList a2 = i().getTagEditor().a();
        if (a2 != null && a2.size() > 0) {
            com.shopee.feeds.feedlibrary.editor.tag.b bVar = (com.shopee.feeds.feedlibrary.editor.tag.b) a2.get(i2);
            if (bVar != null) {
                ProductEntity.ProductItem n = bVar.n();
                if (n != null) {
                    e.a(n.getItem_id(), n.getShop_id(), i2);
                }
            }
        }
    }

    private void y() {
        if (!this.l) {
            this.l = true;
            this.i.a();
        }
    }
}
