package com.shopee.feeds.feedlibrary.editor.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.activity.a;
import com.shopee.feeds.feedlibrary.adapter.EditPageProductAdapter;
import com.shopee.feeds.feedlibrary.adapter.SelectStickerRecyclerAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FollowingPosEntity;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.PosVoucherEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductPosEntity;
import com.shopee.feeds.feedlibrary.data.entity.SaveProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.VoucherEntity;
import com.shopee.feeds.feedlibrary.editor.b.d;
import com.shopee.feeds.feedlibrary.editor.sticker.CommentStickerEditorPanel;
import com.shopee.feeds.feedlibrary.editor.sticker.CommentStickerItemView;
import com.shopee.feeds.feedlibrary.editor.sticker.StickerEditorDialogFragment;
import com.shopee.feeds.feedlibrary.editor.sticker.a.f;
import com.shopee.feeds.feedlibrary.editor.sticker.d;
import com.shopee.feeds.feedlibrary.editor.sticker.e;
import com.shopee.feeds.feedlibrary.editor.text.TextEditorDialogFragment;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.r;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.w;
import com.shopee.feeds.feedlibrary.view.PageIndicator;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public abstract class AbstractEditActivity extends a {
    @BindView
    TextView btnTopBack;

    /* renamed from: c  reason: collision with root package name */
    protected EditPageProductAdapter f7090c;
    @BindView
    CommentStickerEditorPanel commentStickerEditorPanel;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.sdk.ui.a f7091d;

    /* renamed from: e  reason: collision with root package name */
    r f7092e;

    /* renamed from: f  reason: collision with root package name */
    SaveProductEntity f7093f;

    /* renamed from: g  reason: collision with root package name */
    List<SelectStickerRecyclerAdapter.a> f7094g = new ArrayList();
    protected boolean h = false;
    private int i;
    @BindView
    PageIndicator indicator;
    @BindView
    ImageView ivAddSticker;
    @BindView
    ImageView ivAddTag;
    @BindView
    ImageView ivAddText;
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    private boolean j = false;
    @BindView
    RelativeLayout llTitleLayout;
    @BindView
    RelativeLayout mAddTagLayout;
    @BindView
    RecyclerView mRvProduct;
    @BindView
    TextView mTvMove;
    @BindView
    RelativeLayout rlTopTitle;
    @BindView
    RelativeLayout rlVideoContainer;
    @BindView
    ViewPager tagViewpager;
    @BindView
    TextView tvRemove;
    @BindView
    TextView tvRight;
    @BindView
    TextView tvTagsNum;
    @BindView
    TextView tvTap;

    /* access modifiers changed from: protected */
    public abstract boolean a(int i2);

    /* access modifiers changed from: protected */
    public abstract d i();

    /* access modifiers changed from: protected */
    public abstract d j();

    /* access modifiers changed from: protected */
    public abstract boolean k();

    /* access modifiers changed from: protected */
    public abstract boolean l();

    /* access modifiers changed from: protected */
    public abstract int m();

    /* access modifiers changed from: protected */
    public abstract void n();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        c();
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_editor);
        ButterKnife.a((Activity) this);
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.f7092e = new r(this);
        this.f7092e.a();
        this.f7092e.a((com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
            public void a(String str) {
            }

            public void a(Object obj, String str) {
                j.a().a((MediaCompressParam) obj);
            }
        });
        j.a().B();
        u();
    }

    private void u() {
        this.i = com.shopee.feeds.feedlibrary.util.d.b((Activity) this, "source_mode");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
        j.a().B();
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_left) {
            if (!j.a().A()) {
                if (t()) {
                    a(b.e(c.g.feeds_edit_photo_page_goback_alert_tips));
                } else {
                    finish();
                }
            }
        } else if (id != c.e.tv_right) {
            if (id == c.e.rl_add_tag) {
                d i2 = i();
                i2.a(((float) i2.getMeasuredWidth()) / 2.0f, ((float) i2.getMeasuredHeight()) / 2.0f);
                i2.a(this.f7093f);
            } else if (id == c.e.iv_add_text) {
                o();
            } else if (id == c.e.iv_add_sticker) {
                p();
            }
        }
    }

    public void a(boolean z) {
        this.rlTopTitle.setVisibility(z ? 0 : 4);
    }

    /* access modifiers changed from: protected */
    public void b(boolean z) {
        if (z) {
            h().a();
            j.a().g(true);
            this.tvRight.setTextColor(this.f7086a.getResources().getColor(c.b.grey_400));
            this.tvRight.setEnabled(false);
            return;
        }
        h().b();
        j.a().g(false);
        this.tvRight.setTextColor(this.f7086a.getResources().getColor(c.b.main_color));
        this.tvRight.setEnabled(true);
    }

    /* access modifiers changed from: protected */
    public com.shopee.sdk.ui.a h() {
        if (this.f7091d == null) {
            this.f7091d = new com.shopee.sdk.ui.a(this);
            this.f7091d.a(false);
        }
        return this.f7091d;
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(ProductPosEntity productPosEntity) {
        if (productPosEntity != null) {
            d i2 = i();
            com.shopee.feeds.feedlibrary.editor.tag.b bVar = new com.shopee.feeds.feedlibrary.editor.tag.b();
            bVar.b(1);
            bVar.c(productPosEntity.getProductName());
            bVar.d(productPosEntity.getPrice());
            bVar.b(productPosEntity.getItem_id());
            bVar.c(productPosEntity.getShop_id());
            bVar.a(productPosEntity.getProductPosItem());
            bVar.a(i2.getTapX());
            bVar.b(i2.getTapY());
            bVar.e((float) i2.getMeasuredWidth());
            bVar.f((float) i2.getMeasuredHeight());
            bVar.a(String.valueOf(System.currentTimeMillis()));
            int i3 = this.i;
            if (i3 == 1) {
                i2.getTagEditor().a((com.shopee.feeds.feedlibrary.editor.tag.a) bVar);
            } else if (i3 == 2 && !b(bVar.n())) {
                i2.getTagEditor().b((com.shopee.feeds.feedlibrary.editor.tag.a) bVar);
                n();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ProductEntity.ProductItem productItem) {
        d j2 = j();
        h.b("%s", "addBuyerProductTag " + j2.toString());
        com.shopee.feeds.feedlibrary.editor.tag.b bVar = new com.shopee.feeds.feedlibrary.editor.tag.b();
        bVar.b(1);
        bVar.c(productItem.getName());
        bVar.d(productItem.getPrice());
        bVar.b(productItem.getItem_id());
        bVar.c(productItem.getShop_id());
        bVar.a(productItem);
        bVar.a(j2.getTapX());
        bVar.b(j2.getTapY());
        bVar.e((float) j2.getMeasuredWidth());
        bVar.f((float) j2.getMeasuredHeight());
        bVar.a(String.valueOf(System.currentTimeMillis()));
        j2.getTagEditor().a((com.shopee.feeds.feedlibrary.editor.tag.a) bVar);
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(FollowingPosEntity followingPosEntity) {
        if (followingPosEntity != null) {
            a(followingPosEntity);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(PosVoucherEntity posVoucherEntity) {
        if (posVoucherEntity != null) {
            if (posVoucherEntity.getType() == 1) {
                if (posVoucherEntity.getOldInfo() != null) {
                    i().getStickerEditor().b((com.shopee.feeds.feedlibrary.editor.sticker.a.d) posVoucherEntity.getOldInfo());
                    a(posVoucherEntity.getVoucherEntity(), posVoucherEntity.getOldInfo());
                    return;
                }
                a(posVoucherEntity.getVoucherEntity(), (f) null);
            } else if (posVoucherEntity.getType() == 2 && this.commentStickerEditorPanel.d()) {
                this.commentStickerEditorPanel.a(posVoucherEntity);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        if (j.a().A()) {
            return true;
        }
        if (this.commentStickerEditorPanel.d()) {
            this.commentStickerEditorPanel.b();
            return true;
        } else if (!t()) {
            return false;
        } else {
            a(b.e(c.g.feeds_edit_photo_page_goback_alert_tips));
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        if (l()) {
            TextEditorDialogFragment.a((Activity) this, (TextEditorDialogFragment.a) new TextEditorDialogFragment.a() {
                public void a(com.shopee.feeds.feedlibrary.editor.text.b bVar) {
                    bVar.g(BitmapDescriptorFactory.HUE_RED);
                    bVar.h(0.5f);
                    bVar.a(0);
                    bVar.i(1.0f);
                    bVar.j(w.a(1.0f));
                    AbstractEditActivity.this.i().getTextEditor().a(bVar);
                }

                public void a() {
                    AbstractEditActivity.this.a(false);
                }

                public void b() {
                    AbstractEditActivity.this.a(true);
                }
            });
        } else {
            u.a(this, b.e(c.g.feeds_sticker_limit_tips));
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        StickerEditorDialogFragment.a(this, new StickerEditorDialogFragment.a() {
            public void a(List<SelectStickerRecyclerAdapter.a> list) {
                if (list != null && list.size() > 0) {
                    AbstractEditActivity.this.f7094g.clear();
                    AbstractEditActivity.this.f7094g.addAll(list);
                }
            }

            public void a(int i, String str, String str2, int i2, int i3) {
                com.shopee.feeds.feedlibrary.editor.sticker.d stickerEditor = AbstractEditActivity.this.i().getStickerEditor();
                if (stickerEditor != null) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                                        public void run() {
                                            AbstractEditActivity.this.q();
                                        }
                                    });
                                }
                            } else if (AbstractEditActivity.this.a(i)) {
                                com.shopee.feeds.feedlibrary.util.a.a(AbstractEditActivity.this.f7086a, 1);
                            } else {
                                com.shopee.feeds.feedlibrary.util.a.a(AbstractEditActivity.this.f7086a, 1, stickerEditor.p());
                            }
                        } else if (AbstractEditActivity.this.a(i)) {
                            com.shopee.feeds.feedlibrary.util.a.a(AbstractEditActivity.this.f7086a);
                        } else {
                            u.a(AbstractEditActivity.this.f7086a, b.e(c.g.feeds_sticker_limit_tips));
                        }
                    } else if (AbstractEditActivity.this.a(i)) {
                        com.shopee.feeds.feedlibrary.editor.sticker.a.c cVar = new com.shopee.feeds.feedlibrary.editor.sticker.a.c(str);
                        cVar.e(str2);
                        cVar.b(i2);
                        cVar.c(i3);
                        AbstractEditActivity.this.a((com.shopee.feeds.feedlibrary.editor.sticker.a.d) cVar);
                    } else {
                        u.a(AbstractEditActivity.this.f7086a, b.e(c.g.feeds_sticker_limit_tips));
                    }
                }
            }
        }, this.f7094g);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (j.a().w()) {
            com.shopee.feeds.feedlibrary.editor.sticker.d stickerEditor = j().getStickerEditor();
            if (stickerEditor != null) {
                stickerEditor.g();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.feeds.feedlibrary.editor.sticker.a.a aVar) {
        if (j().getStickerEditor() != null) {
            if (a(5)) {
                b((com.shopee.feeds.feedlibrary.editor.sticker.a.d) aVar);
            } else {
                h.b("%s", "showBuyerCommentView too more");
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        RelativeLayout f2 = i().getStickerEditor().f();
        if (f2 != null) {
            for (int i2 = 0; i2 < f2.getChildCount(); i2++) {
                View childAt = f2.getChildAt(i2);
                if ((childAt instanceof e) && childAt.getVisibility() == 0) {
                    com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) ((e) childAt).getmInfo();
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (z) {
                            childAt.setTranslationZ(2.01f);
                            dVar.k(2.01f);
                        } else {
                            childAt.setTranslationZ(2.0f);
                            dVar.k(2.0f);
                        }
                    }
                } else if ((childAt instanceof CommentStickerItemView) && childAt.getVisibility() == 0) {
                    com.shopee.feeds.feedlibrary.editor.sticker.a.b info = ((CommentStickerItemView) childAt).getInfo();
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (z) {
                            childAt.setTranslationZ(2.0f);
                            info.k(2.0f);
                        } else {
                            childAt.setTranslationZ(2.01f);
                            info.k(2.01f);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        final com.shopee.feeds.feedlibrary.editor.sticker.d stickerEditor = i().getStickerEditor();
        final com.shopee.feeds.feedlibrary.editor.sticker.a.b o = !a(4) ? stickerEditor.o() : null;
        if (o != null) {
            stickerEditor.c(o);
        }
        this.commentStickerEditorPanel.a((CommentStickerEditorPanel.a) new CommentStickerEditorPanel.a() {
            public void a(com.shopee.feeds.feedlibrary.editor.sticker.a.b bVar) {
                if (o == null) {
                    AbstractEditActivity.this.i().getStickerEditor().a((d.a) new d.a() {
                        public void a(int i) {
                            if (i == 4) {
                                AbstractEditActivity.this.commentStickerEditorPanel.setVisibility(8);
                                AbstractEditActivity.this.i().getStickerEditor().a((d.a) null);
                            }
                        }
                    });
                    AbstractEditActivity.this.a((com.shopee.feeds.feedlibrary.editor.sticker.a.d) bVar);
                } else {
                    stickerEditor.d(bVar);
                }
                AbstractEditActivity.this.c(false);
            }

            public void a() {
                AbstractEditActivity.this.a(false);
                if (o != null) {
                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                        public void run() {
                            stickerEditor.c(o);
                        }
                    }, 100);
                }
            }

            public void b() {
                AbstractEditActivity.this.a(true);
                if (o != null) {
                    stickerEditor.b();
                }
            }
        }).b(o);
    }

    /* access modifiers changed from: protected */
    public void a(VoucherEntity voucherEntity, f fVar) {
        f fVar2 = new f();
        int reward_type = voucherEntity.getReward_type();
        fVar2.f(voucherEntity.getPromotion_id());
        fVar2.g(voucherEntity.getSignature());
        fVar2.h(voucherEntity.getVoucher_code());
        fVar2.d(voucherEntity.getMin_spend());
        fVar2.c(reward_type);
        if (reward_type == 0) {
            if (!com.shopee.feeds.feedlibrary.util.d.a(voucherEntity.getDiscount_value())) {
                fVar2.b(voucherEntity.getDiscount_value());
            } else {
                fVar2.b(voucherEntity.getDiscount_percent());
            }
            fVar2.c(voucherEntity.getDiscount_cap());
        } else if (reward_type == 1) {
            fVar2.e(voucherEntity.getCoin_percentage_real());
            fVar2.c(voucherEntity.getCoin_cap());
        }
        if (fVar != null) {
            fVar2.g(fVar.h());
            fVar2.h(fVar.i());
            fVar2.a(fVar.l());
            fVar2.i(fVar.j());
            fVar2.j(w.a(fVar.j()));
            i().getStickerEditor().a((com.shopee.feeds.feedlibrary.editor.sticker.a.d) fVar2);
            return;
        }
        a((com.shopee.feeds.feedlibrary.editor.sticker.a.d) fVar2);
    }

    /* access modifiers changed from: protected */
    public void a(FollowingPosEntity followingPosEntity) {
        com.shopee.feeds.feedlibrary.editor.sticker.a.e eVar = new com.shopee.feeds.feedlibrary.editor.sticker.a.e();
        eVar.b("@" + followingPosEntity.getName());
        eVar.d(followingPosEntity.getUser_id());
        a((com.shopee.feeds.feedlibrary.editor.sticker.a.d) eVar);
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar) {
        dVar.g(0.5f);
        dVar.h(0.5f);
        dVar.a(0);
        dVar.i(1.0f);
        dVar.j(w.a(1.0f));
        i().getStickerEditor().a(dVar);
    }

    /* access modifiers changed from: protected */
    public void b(com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar) {
        dVar.g(0.5f);
        dVar.h(0.5f);
        dVar.a(dVar.l());
        dVar.i(1.0f);
        dVar.j(w.a(1.0f));
        j().getStickerEditor().a(dVar);
    }

    /* access modifiers changed from: protected */
    public void r() {
        Drawable drawable;
        ImageView imageView = this.ivAddTag;
        if (k()) {
            drawable = b.f(c.d.feeds_ic_tag);
        } else {
            drawable = b.f(c.d.feeds_ic_tag_unavailable);
        }
        imageView.setImageDrawable(drawable);
        com.shopee.feeds.feedlibrary.editor.tag.c tagEditor = i().getTagEditor();
        if (tagEditor.a().size() <= 0) {
            this.tvTap.setVisibility(0);
            this.tvRemove.setVisibility(8);
            this.mTvMove.setVisibility(8);
        } else if (tagEditor.d() == 1) {
            this.tvTap.setVisibility(8);
            this.tvRemove.setVisibility(8);
            this.mTvMove.setVisibility(0);
        } else {
            this.tvTap.setVisibility(8);
            this.tvRemove.setVisibility(0);
            this.mTvMove.setVisibility(0);
        }
        if (j.a().w()) {
            this.tvRemove.setVisibility(8);
        }
    }

    public CommentStickerEditorPanel s() {
        return this.commentStickerEditorPanel;
    }

    /* access modifiers changed from: protected */
    public boolean t() {
        return this.j;
    }

    public boolean b(ProductEntity.ProductItem productItem) {
        ArrayList a2 = i().getTagEditor().a();
        if (a2 != null && a2.size() > 0) {
            for (int i2 = 0; i2 < a2.size(); i2++) {
                if (com.shopee.feeds.feedlibrary.util.d.a(productItem, ((com.shopee.feeds.feedlibrary.editor.tag.b) a2.get(i2)).n())) {
                    return true;
                }
            }
        }
        return false;
    }
}
