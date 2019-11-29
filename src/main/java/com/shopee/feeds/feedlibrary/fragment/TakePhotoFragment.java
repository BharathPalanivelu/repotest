package com.shopee.feeds.feedlibrary.fragment;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.a;
import com.otaliastudios.cameraview.ag;
import com.otaliastudios.cameraview.ah;
import com.otaliastudios.cameraview.f;
import com.otaliastudios.cameraview.j;
import com.otaliastudios.cameraview.n;
import com.otaliastudios.cameraview.o;
import com.otaliastudios.cameraview.s;
import com.otaliastudios.cameraview.t;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.data.entity.ReLoadEntity;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.d.c;
import com.shopee.feeds.feedlibrary.util.k;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TakePhotoFragment extends a {
    @BindView
    TextView btnTopBack;
    @BindView
    CameraView cameraView;

    /* renamed from: d  reason: collision with root package name */
    c f28177d;

    /* renamed from: e  reason: collision with root package name */
    private View f28178e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f28179f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28180g = false;
    @BindView
    ImageView ivFront;
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    @BindView
    ImageView ivTakePhoto;
    @BindView
    RelativeLayout llTitleLayout;
    @BindView
    ImageView mIvFlash;
    @BindView
    RelativeLayout rl_frame;
    @BindView
    TextView tvRight;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f28178e = layoutInflater.inflate(c.f.feeds_fragment_videopost, viewGroup, false);
        ButterKnife.a(this, this.f28178e);
        f();
        return this.f28178e;
    }

    /* access modifiers changed from: private */
    public void c() {
        b();
        this.cameraView.a(s.PINCH, t.ZOOM);
        this.cameraView.a(s.TAP, t.FOCUS_WITH_MARKER);
        ag a2 = ah.a(com.shopee.feeds.feedlibrary.util.s.a(getContext()));
        ag c2 = ah.c(com.shopee.feeds.feedlibrary.util.s.a(getContext()));
        ag b2 = ah.b(com.shopee.feeds.feedlibrary.util.s.a(getContext()));
        ag a3 = ah.a(c2, a2, ah.d(com.shopee.feeds.feedlibrary.util.s.a(getContext())), b2);
        ag a4 = ah.a(a.a(1, 1), BitmapDescriptorFactory.HUE_RED);
        this.cameraView.setPictureSize(ah.b(ah.a(a4, a3), a4, ah.a()));
        this.cameraView.a((f) new f() {
            public void a(byte[] bArr) {
                j.a(bArr, com.shopee.feeds.feedlibrary.util.s.a(TakePhotoFragment.this.getContext()), com.shopee.feeds.feedlibrary.util.s.a(TakePhotoFragment.this.getContext()), (j.a) new j.a() {
                    public void a(Bitmap bitmap) {
                        if (bitmap.getWidth() != bitmap.getHeight()) {
                            bitmap = TakePhotoFragment.this.a(bitmap);
                        }
                        if (bitmap != null) {
                            final HashMap hashMap = new HashMap();
                            final OriginImageInfo originImageInfo = new OriginImageInfo();
                            originImageInfo.setOriginal_resolution(bitmap.getWidth() + " * " + bitmap.getHeight());
                            l.a(TakePhotoFragment.this.getContext(), bitmap, new l.a() {
                                public void a(String str) {
                                    originImageInfo.setOriginal_file_size(k.f(str));
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(str);
                                    new LinkedHashMap().put(str, str);
                                    hashMap.put(str, originImageInfo);
                                    com.shopee.feeds.feedlibrary.util.j.a().a((HashMap<String, OriginImageInfo>) hashMap);
                                    com.shopee.feeds.feedlibrary.util.j.a().d(2);
                                    com.shopee.feeds.feedlibrary.util.a.a(TakePhotoFragment.this.getContext(), 0, arrayList, new LinkedHashMap());
                                    if (!d.a(str)) {
                                        ReLoadEntity reLoadEntity = new ReLoadEntity();
                                        reLoadEntity.setFilePath(str);
                                        org.greenrobot.eventbus.c.a().c(reLoadEntity);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
        this.cameraView.start();
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_left) {
            if (getActivity() != null) {
                getActivity().finish();
                e.i();
            }
        } else if (id == c.e.iv_take_photo) {
            this.cameraView.e();
        } else if (id == c.e.iv_front) {
            e();
        } else if (id == c.e.iv_flash) {
            d();
        }
    }

    private void d() {
        if (this.cameraView.getFlash() == o.TORCH) {
            this.cameraView.setFlash(o.OFF);
            this.mIvFlash.setImageResource(c.d.feeds_ic_camera_flash_off);
        } else if (this.cameraView.getFlash() == o.OFF) {
            this.cameraView.setFlash(o.TORCH);
            this.mIvFlash.setImageResource(c.d.feeds_ic_camera_flash_on);
        }
    }

    private void e() {
        if (this.cameraView.getFacing() == n.BACK) {
            this.cameraView.setFacing(n.FRONT);
        } else if (this.cameraView.getFacing() == n.FRONT) {
            this.cameraView.setFacing(n.BACK);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f28179f) {
            this.cameraView.stop();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f28179f) {
            this.cameraView.start();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && !this.f28180g && this.f28178e != null) {
            this.f28177d = new com.shopee.feeds.feedlibrary.util.d.c(getActivity());
            g();
            this.f28180g = true;
        }
    }

    public void a() {
        e.c(this.f7128a);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
        this.cameraView.destroy();
        org.greenrobot.eventbus.c.a().b(this);
    }

    private void f() {
        this.btnTopBack.setText(b.e(c.g.feeds_tab_bar_photo));
    }

    private void g() {
        this.f28177d.b("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").a(new io.b.o<Boolean>() {
            public void a() {
            }

            public void a(io.b.b.b bVar) {
            }

            public void a(Throwable th) {
            }

            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    boolean unused = TakePhotoFragment.this.f28179f = true;
                    TakePhotoFragment.this.c();
                    return;
                }
                u.a(TakePhotoFragment.this.getContext(), "Permission Denied!");
            }
        });
    }

    public void b() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rl_frame.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.height = displayMetrics.widthPixels;
        this.rl_frame.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public Bitmap a(Bitmap bitmap) {
        int i;
        if (bitmap.getHeight() > bitmap.getWidth()) {
            i = bitmap.getWidth();
        } else {
            i = bitmap.getHeight();
        }
        return ThumbnailUtils.extractThumbnail(bitmap, i, i, 2);
    }
}
