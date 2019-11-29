package com.shopee.feeds.feedlibrary.fragment;

import a.k;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.garena.android.appkit.tools.b;
import com.google.a.f;
import com.google.a.g;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.DownloadImgEvent;
import com.shopee.feeds.feedlibrary.data.entity.ModeChangeEntity;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.data.entity.ReLoadEntity;
import com.shopee.feeds.feedlibrary.picture.LocalMedia;
import com.shopee.feeds.feedlibrary.picture.LocalMediaFolder;
import com.shopee.feeds.feedlibrary.util.c.a;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.v;
import com.shopee.feeds.feedlibrary.util.w;
import com.shopee.feeds.feedlibrary.view.GalleryView;
import com.shopee.feeds.feedlibrary.view.folderwindow.a;
import com.shopee.feeds.feedlibrary.view.preview.ContainerLayout;
import com.shopee.feeds.feedlibrary.view.preview.e;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class PickPhotoFragment extends a {

    /* renamed from: d  reason: collision with root package name */
    private a f7124d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7125e = true;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f7126f = true;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public e f7127g;
    /* access modifiers changed from: private */
    public com.shopee.feeds.feedlibrary.view.preview.a h;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, String> i;
    private com.shopee.sdk.ui.a j;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> k = new LinkedHashMap<>();
    /* access modifiers changed from: private */
    public com.shopee.feeds.feedlibrary.view.folderwindow.a l;
    @BindView
    ContainerLayout mContainer;
    @BindView
    GalleryView mGalleryView;
    @BindView
    ImageView mIvVideoStop;
    @BindView
    LinearLayout mLlLibrary;
    @BindView
    LinearLayout mLlNoAccess;
    @BindView
    LinearLayout mLlNoContent;
    @BindView
    ImageView mMultiBtn;
    @BindView
    TextView mNextBtn;
    @BindView
    ImageView mScaleBtn;
    @BindView
    TextView mTitle;
    @BindView
    TextView mTvNoContent;
    @BindView
    TextView mTvPermissiTwo;
    @BindView
    TextView mTvPermissioOne;
    @BindView
    TextView mTvPermission;
    @BindView
    View mViewBlank;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.f.feeds_fragment_new_library, viewGroup, false);
        ButterKnife.a(this, inflate);
        org.greenrobot.eventbus.c.a().a((Object) this);
        b();
        c();
        return inflate;
    }

    private void b() {
        this.mTitle.setText(b.e(c.g.feeds_album_title_gallery));
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(c.d.feeds_ic_arrow_down), (Drawable) null);
        this.mTitle.setCompoundDrawablePadding(8);
        this.mNextBtn.setVisibility(0);
        this.mNextBtn.setText(b.e(c.g.feeds_button_next));
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_left) {
            com.shopee.feeds.feedlibrary.util.b.e.h();
            getActivity().finish();
        } else if (id == c.e.tv_right) {
            List<com.shopee.feeds.feedlibrary.view.preview.a> a2 = this.f7127g.a();
            if (!a(a2)) {
                g gVar = new g();
                gVar.c();
                f d2 = gVar.d();
                StringBuilder sb = new StringBuilder();
                sb.append("list--" + d2.b((Object) a2).toString());
                sb.append("\n");
                sb.append("singleMode--" + this.f7126f);
                sb.append("\n");
                sb.append("current---" + d2.b((Object) this.h).toString());
                sb.append("\n");
                h.a("crash_test", sb.toString());
                u.a(com.shopee.feeds.feedlibrary.b.b().f27287b, b.e(c.g.feeds_operation_failed));
                return;
            }
            LinkedHashMap<String, String> linkedHashMap = this.i;
            if (linkedHashMap == null) {
                this.i = new LinkedHashMap<>();
            } else {
                linkedHashMap.clear();
            }
            for (com.shopee.feeds.feedlibrary.view.preview.a h2 : a2) {
                this.i.put(h2.h(), "");
            }
            if (a2.size() != 1 || !a2.get(0).i().contains("video")) {
                this.j.a(false);
                a(true);
            } else if (!a(a2.get(0))) {
                return;
            }
            this.f7127g.a(18);
            com.shopee.feeds.feedlibrary.util.b.e.g();
        } else if (id == c.e.btn_top_back && this.f7124d.c()) {
            if (this.l.isShowing()) {
                this.l.dismiss();
            } else {
                e();
            }
        }
    }

    @OnClick
    public void onChangeScale() {
        if (!this.f7127g.c()) {
            this.f7125e = !this.f7125e;
            this.f7127g.a(this.f7125e ? e.a.CENTER_CROP : e.a.CENTER_INSIDE);
            com.shopee.feeds.feedlibrary.util.b.e.d();
        }
    }

    @OnClick
    public void onChangeMode() {
        int i2 = 1;
        this.f7126f = !this.f7126f;
        GalleryView galleryView = this.mGalleryView;
        if (!this.f7126f) {
            i2 = 2;
        }
        galleryView.setMode(i2);
        this.f7127g.a(this.f7126f ? e.b.SINGLE : e.b.MULTIPLE);
        if (!this.f7126f) {
            this.f7127g.b(this.h);
            this.mScaleBtn.setVisibility(8);
            this.mViewBlank.setVisibility(8);
            this.mMultiBtn.setBackgroundResource(c.d.feeds_bg_multi_press);
        } else {
            this.mScaleBtn.setVisibility(0);
            this.mViewBlank.setVisibility(0);
            this.mMultiBtn.setBackgroundResource(c.d.feeds_bg_multi_normal);
        }
        ModeChangeEntity modeChangeEntity = new ModeChangeEntity();
        modeChangeEntity.setmSingleMode(this.f7126f);
        org.greenrobot.eventbus.c.a().c(modeChangeEntity);
        this.f7127g.a(this.h);
        com.shopee.feeds.feedlibrary.util.b.e.e();
    }

    private void c() {
        this.f7127g = new e(getContext(), this.mContainer, this.mMultiBtn, this.mScaleBtn, this.mIvVideoStop);
        this.j = new com.shopee.sdk.ui.a(getActivity());
        this.f7124d = new a(getActivity(), this, this.mTvPermission);
        this.mGalleryView.setGalleryImageSelectedListener(new GalleryView.a() {
            public void a(int i, LocalMedia localMedia) {
                if (localMedia != null) {
                    PickPhotoFragment.this.mGalleryView.a(i);
                    PickPhotoFragment pickPhotoFragment = PickPhotoFragment.this;
                    com.shopee.feeds.feedlibrary.view.preview.a unused = pickPhotoFragment.h = pickPhotoFragment.a(localMedia);
                    if (PickPhotoFragment.this.f7126f) {
                        PickPhotoFragment.this.f7127g.a(PickPhotoFragment.this.h);
                        return;
                    }
                    PickPhotoFragment.this.f7127g.b(PickPhotoFragment.this.h);
                    PickPhotoFragment.this.f7127g.a(PickPhotoFragment.this.h);
                }
            }

            public void b(int i, LocalMedia localMedia) {
                if (localMedia != null) {
                    PickPhotoFragment.this.f7127g.c(PickPhotoFragment.this.a(localMedia));
                }
            }
        });
        this.f7124d.a((a.C0436a) new a.C0436a() {
            public void a() {
                PickPhotoFragment.this.g();
            }

            public void a(String str, List<LocalMedia> list) {
                PickPhotoFragment.this.f();
                PickPhotoFragment.this.mTitle.setText(str);
                PickPhotoFragment.this.mGalleryView.a(list.get(0));
                PickPhotoFragment.this.mGalleryView.setLocalMediaList((ArrayList) list);
                PickPhotoFragment pickPhotoFragment = PickPhotoFragment.this;
                com.shopee.feeds.feedlibrary.view.preview.a unused = pickPhotoFragment.h = pickPhotoFragment.a(list.get(0));
                PickPhotoFragment.this.f7127g.a(PickPhotoFragment.this.h);
            }

            public void b() {
                PickPhotoFragment.this.h();
            }

            public void a(List<LocalMediaFolder> list) {
                PickPhotoFragment.this.l.a((ArrayList<LocalMediaFolder>) (ArrayList) list);
            }
        });
        d();
        this.f7124d.a();
    }

    public void onPause() {
        super.onPause();
        this.f7127g.b();
    }

    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
    }

    public void onResume() {
        super.onResume();
        this.f7127g.a(this.f7129b);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        e eVar = this.f7127g;
        if (eVar == null) {
            return;
        }
        if (z) {
            eVar.a(z);
        } else {
            eVar.b();
        }
    }

    public void a() {
        com.shopee.feeds.feedlibrary.util.b.e.b(this.f7128a);
    }

    @m(a = ThreadMode.MAIN)
    public void onMediaSaved(com.shopee.feeds.feedlibrary.view.preview.a aVar) {
        if (this.i != null && aVar != null && aVar.k()) {
            if (this.i.containsKey(aVar.h())) {
                this.i.put(aVar.h(), aVar.j());
            }
            ArrayList arrayList = new ArrayList();
            for (String next : this.i.values()) {
                if (!TextUtils.isEmpty(next)) {
                    arrayList.add(next);
                } else {
                    return;
                }
            }
            if (this.i.size() > 1) {
                a((ArrayList<String>) arrayList);
            } else if (this.i.size() != 1) {
            } else {
                if (aVar.i().contains("video")) {
                    a(false);
                    com.shopee.feeds.feedlibrary.util.a.a(getContext(), arrayList, 2, (int) v.a(aVar.g()), aVar.e(), aVar.f(), aVar.b(), aVar.c(), aVar.a());
                    return;
                }
                a((ArrayList<String>) arrayList);
            }
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onVideoProgress(DownloadImgEvent downloadImgEvent) {
        if (!downloadImgEvent.isSuccess() && downloadImgEvent.isLocal()) {
            a(false);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(ReLoadEntity reLoadEntity) {
        if (reLoadEntity instanceof ReLoadEntity) {
            this.f7124d.a(reLoadEntity.getFilePath());
        }
    }

    private void d() {
        this.l = new com.shopee.feeds.feedlibrary.view.folderwindow.a(getContext());
        this.l.a((a.C0437a) new a.C0437a() {
            public void a(int i, LocalMediaFolder localMediaFolder) {
                if (!d.a(localMediaFolder.a())) {
                    PickPhotoFragment.this.mTitle.setText(localMediaFolder.a());
                }
                ArrayList arrayList = (ArrayList) localMediaFolder.c();
                if (arrayList.size() > 0) {
                    PickPhotoFragment.this.f();
                    PickPhotoFragment.this.mGalleryView.setLocalMediaList(arrayList);
                    if (PickPhotoFragment.this.f7126f) {
                        PickPhotoFragment.this.mGalleryView.a((LocalMedia) arrayList.get(0));
                        PickPhotoFragment pickPhotoFragment = PickPhotoFragment.this;
                        com.shopee.feeds.feedlibrary.view.preview.a unused = pickPhotoFragment.h = pickPhotoFragment.a((LocalMedia) arrayList.get(0));
                        PickPhotoFragment.this.f7127g.a(PickPhotoFragment.this.h);
                        return;
                    }
                    return;
                }
                PickPhotoFragment.this.g();
            }
        });
    }

    private void e() {
        this.l.getContentView().measure(w.c(this.l.getWidth()), w.c(this.l.getHeight()));
        this.l.a();
        androidx.core.widget.h.a(this.l, this.mTitle, -b.d(c.C0424c.dp24), -b.d(c.C0424c.dp5), 8388611);
    }

    /* access modifiers changed from: private */
    public com.shopee.feeds.feedlibrary.view.preview.a a(LocalMedia localMedia) {
        com.shopee.feeds.feedlibrary.view.preview.a aVar = new com.shopee.feeds.feedlibrary.view.preview.a(localMedia.b(), com.shopee.feeds.feedlibrary.picture.c.a(localMedia.a()) == 1 ? "image/jpg" : "video/mp4", localMedia.b());
        aVar.e(18);
        aVar.a(localMedia.c());
        return aVar;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.j.a();
            this.mNextBtn.setTextColor(getContext().getResources().getColor(c.b.grey_400));
            this.mNextBtn.setEnabled(false);
            return;
        }
        this.j.b();
        this.mNextBtn.setTextColor(getContext().getResources().getColor(c.b.main_color));
        this.mNextBtn.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.mNextBtn.setTextColor(getContext().getResources().getColor(c.b.main_color));
        this.mNextBtn.setEnabled(true);
        this.mLlNoContent.setVisibility(8);
        this.mLlLibrary.setVisibility(0);
        this.mLlNoAccess.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void g() {
        this.mNextBtn.setTextColor(getContext().getResources().getColor(c.b.grey_400));
        this.mNextBtn.setEnabled(false);
        this.mLlNoContent.setVisibility(0);
        this.mLlNoAccess.setVisibility(8);
        this.mLlLibrary.setVisibility(8);
        this.mTvNoContent.setText(b.e(c.g.feeds_album_empty_tips));
    }

    /* access modifiers changed from: private */
    public void h() {
        this.mNextBtn.setTextColor(getContext().getResources().getColor(c.b.grey_400));
        this.mNextBtn.setEnabled(false);
        this.mLlNoContent.setVisibility(8);
        this.mLlNoAccess.setVisibility(0);
        this.mLlLibrary.setVisibility(8);
        this.mTvPermissioOne.setText(b.e(c.g.feeds_album_no_permission_tips_one));
        this.mTvPermissiTwo.setText(b.e(c.g.feeds_album_no_permission_tips_two));
        this.mTvPermission.setText(b.e(c.g.feeds_album_no_permission_tips_three));
    }

    private boolean a(com.shopee.feeds.feedlibrary.view.preview.a aVar) {
        if (aVar.g() >= 3000 && aVar.g() <= BaseConstants.DEFAULT_MSG_TIMEOUT) {
            return true;
        }
        u.a(getContext(), b.a(c.g.feeds_video_duration_limit_tips, 3, 30));
        return false;
    }

    private boolean a(List<com.shopee.feeds.feedlibrary.view.preview.a> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) == null) {
                return false;
            }
        }
        return true;
    }

    private void a(final ArrayList<String> arrayList) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : PickPhotoFragment.this.i.entrySet()) {
                    try {
                        Bitmap h = com.squareup.a.w.a(PickPhotoFragment.this.getContext()).a(q.a((String) entry.getKey())).h();
                        if (h != null) {
                            OriginImageInfo originImageInfo = new OriginImageInfo();
                            originImageInfo.setOriginal_resolution(h.getWidth() + " * " + h.getHeight());
                            originImageInfo.setOriginal_file_size(q.a(h));
                            hashMap.put(entry.getValue(), originImageInfo);
                            h.recycle();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                j.a().a((HashMap<String, OriginImageInfo>) hashMap);
                return null;
            }
        }).a(new a.h<Object, Object>() {
            public Object then(k<Object> kVar) throws Exception {
                PickPhotoFragment.this.a(false);
                j.a().d(1);
                com.shopee.feeds.feedlibrary.util.a.a(PickPhotoFragment.this.getContext(), 0, arrayList, PickPhotoFragment.this.k);
                return null;
            }
        }, k.f377b);
    }
}
