package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.devspark.robototextview.widget.RobotoTextView;
import com.google.a.o;
import com.shopee.feeds.feedlibrary.adapter.CreatePostPictureAdapter;
import com.shopee.feeds.feedlibrary.adapter.HashTagAdapter;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.b.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.BaseEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.CaptionTagEntity;
import com.shopee.feeds.feedlibrary.data.entity.HashTagEntity;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.PostStatusEntity;
import com.shopee.feeds.feedlibrary.data.entity.PostStatusLoadingEntity;
import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.p;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.ToogleButton;
import com.shopee.feeds.feedlibrary.view.a.a;
import com.shopee.feeds.feedlibrary.view.edittext.LimitEditText;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;
import com.shopee.sdk.modules.ui.navigator.options.JumpOption;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class CreatePostActivity extends a implements a.C0119a {
    @BindView
    ToogleButton albumToogle;
    @BindView
    RobotoTextView btnTopBack;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f7067c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f7068d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f7069e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f7070f = new ArrayList<>();
    @BindView
    FrameLayout flBottomFrame;

    /* renamed from: g  reason: collision with root package name */
    private int f7071g = -1;
    private String h = "";
    private CreatePostPictureAdapter i;
    @BindView
    ToogleButton insToogle;
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    private HashTagAdapter j;
    /* access modifiers changed from: private */
    public b k;
    private String l = "";
    @BindView
    LimitEditText limitEditText;
    @BindView
    RelativeLayout llTitleLayout;
    private PhotoEditEntity m;
    @BindView
    LinearLayout mLlToogle;
    @BindView
    TextView mTvSaveAlbumTitle;
    @BindView
    TextView mTvShareInsTitle;
    private VideoEditEntity n;
    /* access modifiers changed from: private */
    public boolean o = false;
    private HashMap<String, String> p = new HashMap<>();
    private String q = null;
    private com.shopee.feeds.feedlibrary.bg.a r;
    @BindView
    RelativeLayout rlSaveAlbum;
    @BindView
    RelativeLayout rlShareIns;
    @BindView
    RecyclerView rvPictures;
    @BindView
    RecyclerView rvTags;
    private com.shopee.sdk.ui.a s;
    private boolean t = false;
    @BindView
    RobotoTextView tvRight;
    private String u;

    public boolean e() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.shopee.feeds.feedlibrary.view.b bVar = new com.shopee.feeds.feedlibrary.view.b(this);
        bVar.addView(getLayoutInflater().inflate(c.f.feeds_activity_create_post, (ViewGroup) null));
        setContentView(bVar);
        ButterKnife.a((Activity) this);
        org.greenrobot.eventbus.c.a().a((Object) this);
        i();
    }

    private void i() {
        this.r = com.shopee.feeds.feedlibrary.bg.a.a();
        this.k = new b(this, this, this.tvRight);
        j();
        m();
        k();
        l();
        this.rvPictures.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.i = new CreatePostPictureAdapter(this.f7086a, this.f7071g);
        this.rvPictures.setAdapter(this.i);
        VideoEditEntity videoEditEntity = this.n;
        if (videoEditEntity != null) {
            this.i.a(videoEditEntity);
        }
        this.rvTags.setLayoutManager(new LinearLayoutManager(this.f7086a));
        this.j = new HashTagAdapter(this.f7086a);
        this.j.a((a.C0422a) new a.C0422a() {
            public void a(int i, Object obj, View view) {
                CaptionTagEntity captionTagEntity = (CaptionTagEntity) obj;
                if (!d.a(captionTagEntity.getName())) {
                    CreatePostActivity.this.limitEditText.a(captionTagEntity);
                }
            }
        });
        this.rvTags.setAdapter(this.j);
        ArrayList<String> arrayList = this.f7068d;
        if (arrayList != null && arrayList.size() > 0) {
            this.i.a(this.f7068d);
        }
        String e2 = j.a().e();
        if (!TextUtils.isEmpty(e2)) {
            CaptionTagEntity captionTagEntity = new CaptionTagEntity();
            captionTagEntity.setType(1);
            captionTagEntity.setName(e2);
            this.limitEditText.a(captionTagEntity);
        }
    }

    private void j() {
        this.btnTopBack.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_nav_bar_title_new_post));
        this.ivLeft.setImageResource(c.d.feeds_ic_left_arrow);
        this.tvRight.setVisibility(0);
        this.tvRight.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_button_post));
    }

    private void k() {
        if (!p.a(this.f7086a, "com.instagram.android")) {
            this.rlShareIns.setVisibility(8);
        } else {
            this.rlShareIns.setVisibility(0);
        }
        if (this.k.b()) {
            this.albumToogle.a();
        }
        if (this.k.c()) {
            this.insToogle.a();
        }
        this.insToogle.setOnCheckListener(new ToogleButton.a() {
            public void a(boolean z) {
                e.h(z);
                BaseEditEntity a2 = CreatePostActivity.this.n();
                if (a2 != null) {
                    a2.setHasIns(z);
                    CreatePostActivity.this.a(a2);
                }
            }

            public void a() {
                boolean unused = CreatePostActivity.this.o = true;
            }
        });
        this.albumToogle.setOnCheckListener(new ToogleButton.a() {
            public void a(boolean z) {
                e.i(z);
                BaseEditEntity a2 = CreatePostActivity.this.n();
                if (a2 != null) {
                    a2.setHasAlbum(z);
                    CreatePostActivity.this.a(a2);
                }
            }

            public void a() {
                boolean unused = CreatePostActivity.this.o = true;
            }
        });
    }

    private void l() {
        if (getIntent() != null) {
            this.f7071g = d.b((Activity) this, "source_mode");
            this.f7067c = getIntent().getStringArrayListExtra("source_path");
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                return;
            }
            if (extras.get(PhotoEditEntity.PHOTO_INFO) != null) {
                this.m = (PhotoEditEntity) extras.get(PhotoEditEntity.PHOTO_INFO);
                this.f7068d = this.k.a(this.f7067c, this.m.getEditImagePathMap());
                this.f7069e = this.k.a(this.f7067c, this.m.getCleanEditImagePathMap());
                this.f7070f = this.k.a(this.f7067c, this.m.getSaveAlbumPathMap());
                if (j.a().w()) {
                    this.f7069e.add(this.f7070f.get(0));
                    h.b("", "PostStatusTask " + this.f7070f.get(0));
                }
                h.b("PostStatusTask", " upload " + this.f7069e.toString());
                h.b("PostStatusTask", " current " + this.f7067c.toString());
            } else if (extras.get(VideoEditEntity.VIDEO_INFO) != null) {
                this.n = (VideoEditEntity) extras.get(VideoEditEntity.VIDEO_INFO);
                this.f7068d = this.k.a(this.f7067c, this.n);
                this.f7069e = this.k.a(this.f7067c, this.n.getCleanEditImagePathMap());
                this.f7070f.addAll(this.f7069e);
            }
        }
    }

    private void m() {
        this.mTvShareInsTitle.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_new_post_share_to_instagram));
        this.mTvSaveAlbumTitle.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_new_post_save_to_album));
        this.limitEditText.setSearchType(34);
        this.limitEditText.d(500).c(getResources().getColor(c.b.grey_1000)).b(getResources().getColor(c.b.grey_500)).a(String.format(com.garena.android.appkit.tools.b.e(c.g.feeds_new_post_page_edit_placehoder), new Object[]{3})).a(new LimitEditText.b(0, 500, "", 1)).a((LimitEditText.a) new LimitEditText.a() {
            public void a(CharSequence charSequence) {
                if (!d.a(charSequence.toString())) {
                    boolean unused = CreatePostActivity.this.o = true;
                }
                BaseEditEntity a2 = CreatePostActivity.this.n();
                if (a2 != null) {
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = "";
                    }
                    a2.setCaution(charSequence.toString());
                    CreatePostActivity.this.a(a2);
                }
            }

            public void a(String str, int i) {
                CreatePostActivity.this.k.a(str, 5, i);
            }

            public void a() {
                CreatePostActivity.this.r();
            }
        }).a(0);
    }

    @OnClick
    public void onClick(View view) {
        if (this.o) {
            a(com.garena.android.appkit.tools.b.e(c.g.feeds_new_post_page_goback_alert_tips));
            return;
        }
        o();
        finish();
    }

    /* access modifiers changed from: private */
    public BaseEditEntity n() {
        if (!TextUtils.isEmpty(this.u)) {
            return com.shopee.feeds.feedlibrary.bg.a.a().a(this.u);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(BaseEditEntity baseEditEntity) {
        com.shopee.feeds.feedlibrary.bg.a.a().a(baseEditEntity);
    }

    /* access modifiers changed from: protected */
    public com.shopee.sdk.ui.a h() {
        if (this.s == null) {
            this.s = new com.shopee.sdk.ui.a(this);
            this.s.a(false);
        }
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        if (z) {
            this.t = true;
            h().a();
            j.a().g(true);
            this.tvRight.setTextColor(this.f7086a.getResources().getColor(c.b.grey_400));
            this.tvRight.setEnabled(false);
            return;
        }
        this.t = false;
        h().b();
        j.a().g(false);
        this.tvRight.setTextColor(this.f7086a.getResources().getColor(c.b.main_color));
        this.tvRight.setEnabled(true);
    }

    @OnClick
    public void onCreatePost() {
        this.k.a(this.insToogle, this.albumToogle);
        if (this.limitEditText.getHashTagList().size() > 3) {
            u.a(this.f7086a, com.garena.android.appkit.tools.b.a(c.g.feeds_hashtags_max_tips, 3));
            return;
        }
        if (this.f7071g == 2) {
            ArrayList<String> arrayList = this.f7068d;
            if (arrayList != null && arrayList.size() > 0) {
                this.q = this.f7068d.get(0);
                this.n.setTimelineShowVideo(this.q);
            }
        }
        if (TextUtils.isEmpty(this.u)) {
            this.u = UUID.randomUUID().toString();
            b(this.u);
        }
        c(this.u);
        e.t();
    }

    private void b(String str) {
        this.r.b();
        if (this.f7071g == 2) {
            this.n.setHasIns(this.insToogle.c());
            this.n.setHasAlbum(this.albumToogle.c());
            this.n.setPostType(this.f7071g);
            this.n.setCaution(this.limitEditText.getTextString());
            this.n.setMentions(this.limitEditText.getUserIdList());
            this.n.setHashTags(this.limitEditText.getHashTagList());
            this.n.setPostId(str);
            this.n.setSaveList(this.f7070f);
            this.n.setPostCurrentPathList(this.f7067c);
            this.n.setVideoNeedWater(j.a().v());
            this.n.setOriginalVideo(j.a().i());
            this.n.setVideoStorePath(this.q);
            this.n.setVideoWaterImgPath(j.a().o());
            this.n.setVideoPreviewPath(j.a().r());
            this.n.setVideoWaterPath(j.a().o());
            this.n.setUploadEntity(j.a().j());
            this.n.setMediaCompressParam(j.a().s());
            this.n.setCoverPath(j.a().z());
            this.n.setSignature(j.a().y());
            this.n.setVideoPostParams(j.a().t());
            this.n.setVideoCacheRect(j.a().n());
            this.n.setVideoScaleHeight(j.a().m());
            this.n.setVideoScaleWidth(j.a().l());
            this.n.setFeedWaterMarkIconPath(j.a().c());
            this.r.a((BaseEditEntity) this.n, true);
            return;
        }
        this.m.setHasIns(this.insToogle.c());
        this.m.setHasAlbum(this.albumToogle.c());
        this.m.setPostType(this.f7071g);
        this.m.setCaution(this.limitEditText.getTextString());
        this.m.setMentions(this.limitEditText.getUserIdList());
        this.m.setHashTags(this.limitEditText.getHashTagList());
        this.m.setPostId(str);
        this.m.setSaveList(this.f7070f);
        this.m.setFromBuyerReview(j.a().w());
        this.m.setPostCurrentPathList(this.f7067c);
        this.m.setTimelineImgList(this.f7068d);
        this.m.setFirstSaveImg(this.f7070f.get(0));
        this.m.setMediaCompressParam(j.a().s());
        this.m.setmUploadImageCompressParams(j.a().x());
        this.m.setFeedWaterMarkIconPath(j.a().c());
        this.r.a((BaseEditEntity) this.m, false);
    }

    private void c(String str) {
        a(true);
        this.r.d(str);
    }

    public void d() {
        o();
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(PostStatusEntity postStatusEntity) {
        if (postStatusEntity instanceof PostStatusEntity) {
            h.b("", "PostStatusEntity jump to rn timeline page");
            a(false);
            com.shopee.sdk.b.a().e().a((Activity) this, NavigationPath.c("follow?refresh=1"), (o) null, JumpOption.a(false));
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(PostStatusLoadingEntity postStatusLoadingEntity) {
        if (postStatusLoadingEntity instanceof PostStatusLoadingEntity) {
            a(false);
        }
    }

    public void f() {
        e.g(this.f7087b);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.k.a();
        this.insToogle.setOnCheckListener((ToogleButton.a) null);
        this.albumToogle.setOnCheckListener((ToogleButton.a) null);
        this.j.a((a.C0422a) null);
        this.limitEditText.a((LimitEditText.a) null);
        org.greenrobot.eventbus.c.a().b(this);
    }

    public void a(SearchUserEntity searchUserEntity) {
        ArrayList<CaptionTagEntity> a2 = this.k.a(searchUserEntity);
        this.j.a(2);
        a(a2);
    }

    public void a(HashTagEntity hashTagEntity) {
        ArrayList<CaptionTagEntity> a2 = this.k.a(hashTagEntity);
        this.j.a(1);
        a(a2);
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        if (!this.o) {
            o();
            return false;
        } else if (this.t) {
            return true;
        } else {
            a(com.garena.android.appkit.tools.b.e(c.g.feeds_new_post_page_goback_alert_tips));
            return true;
        }
    }

    private void o() {
        p();
        if (!TextUtils.isEmpty(this.u)) {
            com.shopee.feeds.feedlibrary.bg.a.a().a(this.u, true);
        }
    }

    private void p() {
        if (this.f7071g == 2) {
            try {
                String r2 = j.a().r();
                String o2 = j.a().o();
                if (!TextUtils.isEmpty(r2) && !j.a().i()) {
                    new File(r2).delete();
                }
                if (!TextUtils.isEmpty(o2)) {
                    new File(o2).delete();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (this.f7069e != null && this.f7069e.size() == 1) {
                    new File(this.f7069e.get(0)).delete();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(ArrayList<CaptionTagEntity> arrayList) {
        if (this.limitEditText.getMode() == 0) {
            return;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            r();
            return;
        }
        this.j.a(arrayList);
        q();
    }

    private void q() {
        this.mLlToogle.setVisibility(8);
        this.rvTags.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void r() {
        this.mLlToogle.setVisibility(0);
        this.rvTags.setVisibility(8);
    }
}
