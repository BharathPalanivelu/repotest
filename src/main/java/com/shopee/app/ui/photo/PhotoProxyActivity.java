package com.shopee.app.ui.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.camera.MakePhotoActivity;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.g.d;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.a.j;
import com.shopee.app.ui.a.k;
import com.shopee.app.ui.gallery.GalleryActivity_;
import com.shopee.app.ui.gallery.instagram.InstagramGalleryActivity_;
import com.shopee.app.ui.image.crop.CropActivity_;
import com.shopee.app.ui.image.editor.ImageEditorActivity_;
import com.shopee.app.ui.video.trim.VideoTrimActivity_;
import com.shopee.app.util.af;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Collections;

public class PhotoProxyActivity extends b implements x<k> {
    boolean H;
    int I = -1;
    int J = -1;
    boolean K = false;
    String L = "";
    PhotoFrameInfo M;
    int N = -1;
    boolean O = false;
    IcCamera3Info P;
    com.shopee.app.application.a.b Q;
    UserInfo R;
    private k S;
    private ProxyData T;

    /* renamed from: a  reason: collision with root package name */
    boolean f23920a;

    /* renamed from: b  reason: collision with root package name */
    boolean f23921b = false;

    /* renamed from: c  reason: collision with root package name */
    int f23922c = 0;

    /* renamed from: d  reason: collision with root package name */
    boolean f23923d;

    /* renamed from: e  reason: collision with root package name */
    boolean f23924e;

    /* renamed from: f  reason: collision with root package name */
    int f23925f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f23926g;
    boolean h = false;
    int i = -1;
    int j = -1;
    int k = 1;
    int l = 1;
    String m;
    boolean n;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.T = new ProxyData();
            l();
        }
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new RelativeLayout(this));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.S = j.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.S.a(this);
    }

    /* renamed from: c */
    public k b() {
        return this.S;
    }

    private void l() {
        if (this.f23920a) {
            H();
        } else if (this.f23924e) {
            p();
        } else if (this.f23926g) {
            q();
        } else if (this.f23923d) {
            I();
        } else if (this.H) {
            J();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("data", this.T);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.T = (ProxyData) bundle.getParcelable("data");
    }

    private void p() {
        d.a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 5096, 0, R.string.msg_permission_gallery, R.string.sp_no_storage_access, R.string.sp_to_allow_gallery_hint, new d.a() {
            public void a() {
                PhotoProxyActivity.this.r();
            }

            public void b() {
                PhotoProxyActivity.this.finish();
            }

            public void c() {
                PhotoProxyActivity.this.finish();
            }
        });
    }

    private void q() {
        InstagramGalleryActivity_.a(this).b(this.k).a(F()).a(1837);
    }

    /* access modifiers changed from: private */
    public void r() {
        GalleryActivity_.a(this).c(this.k).d(this.l).b(this.f23925f).a(F()).a(1827);
    }

    private String F() {
        if (!TextUtils.isEmpty(this.L)) {
            return this.L;
        }
        return this.R.isMall() ? "FILTER_MALL" : "";
    }

    /* access modifiers changed from: private */
    public void G() {
        Intent intent = new Intent(this, MakePhotoActivity.class);
        intent.putExtra("camera_root_activity", this.I);
        intent.putExtra("camera_resource_id", this.J);
        intent.putExtra("SHOW_PREVIEW", this.f23921b);
        intent.putExtra("CAMERA_MODE", this.f23922c);
        intent.putExtra("FULLSCREEN", this.K);
        intent.putExtra("FILTER_CODE", this.L);
        intent.putExtra("PHOTO_FRAME_INFO", this.M);
        intent.putExtra("PREFER_MIN_IMAGE_SIZE", this.N);
        intent.putExtra("DISABLE_GALLERY_SELECTION", this.O);
        intent.putExtra("IC_CAMERA_3_INFO", this.P);
        intent.putExtra("maxImageCount", this.k);
        intent.putExtra("maxVideoCount", this.l);
        this.Q.b();
        startActivityForResult(intent, 1782);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 2048) {
            if (i2 == 5096) {
                if (iArr.length <= 0 || iArr[0] != 0) {
                    finish();
                } else {
                    r();
                }
            }
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            finish();
        } else {
            G();
        }
    }

    private void H() {
        d.a(this, new String[]{"android.permission.CAMERA"}, 2048, 0, R.string.msg_permission_camera, R.string.sp_no_camera_access, R.string.sp_to_allow_camera_hint, new d.a() {
            public void a() {
                PhotoProxyActivity.this.G();
            }

            public void b() {
                PhotoProxyActivity.this.finish();
            }

            public void c() {
                PhotoProxyActivity.this.finish();
            }
        });
    }

    private void I() {
        if (this.m == null) {
            return;
        }
        if (this.j == -1 || this.i == -1) {
            CropActivity_.a(this).a(this.m).a(this.n).a(1223);
        } else {
            CropActivity_.a(this).a(this.m).a(this.n).b(this.i).c(this.j).a(1223);
        }
    }

    private void J() {
        if (this.m != null) {
            ImageEditorActivity_.a(this).a(this.m).a((int) PlacesStatusCodes.DEVICE_RATE_LIMIT_EXCEEDED);
        }
    }

    private void a(String str) {
        if (str != null) {
            VideoTrimActivity_.a(this).a(str).a(7283);
        }
    }

    private void a(ArrayList<String> arrayList, boolean z, PhotoFrameInfo photoFrameInfo, int i2) {
        Intent intent = new Intent();
        intent.putExtra("add_product_image_uri_list", arrayList);
        if (!TextUtils.isEmpty(this.T.f23931c)) {
            intent.putExtra("INSTAGRAM_INFO", this.T.f23931c);
        }
        intent.putExtra("add_product_harbour_activity", this.I);
        intent.putExtra("add_product_image_source", z);
        intent.putExtra("PHOTO_FRAME_INFO", photoFrameInfo);
        intent.putExtra("PHOTO_ORIENTATION", i2);
        setResult(-1, intent);
        finish();
    }

    private void a(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("add_product_image_uri_list", arrayList);
        if (!TextUtils.isEmpty(this.T.f23931c)) {
            intent.putExtra("INSTAGRAM_INFO", this.T.f23931c);
        }
        intent.putExtra("add_product_harbour_activity", this.I);
        setResult(-1, intent);
        finish();
    }

    private void a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Intent intent = new Intent();
        intent.putExtra("add_product_image_uri_list", arrayList);
        intent.putExtra("add_product_video_uri_list", arrayList2);
        if (!TextUtils.isEmpty(this.T.f23932d)) {
            intent.putExtra("add_product_trim_video_data", this.T.f23932d);
        }
        if (!TextUtils.isEmpty(this.T.f23931c)) {
            intent.putExtra("INSTAGRAM_INFO", this.T.f23931c);
        }
        intent.putExtra("add_product_harbour_activity", this.I);
        setResult(-1, intent);
        finish();
    }

    private void K() {
        Intent intent = new Intent();
        intent.putExtra("add_product_harbour_activity", this.I);
        setResult(0, intent);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, ArrayList<String> arrayList, String str) {
        if (i2 == -1) {
            ProxyData proxyData = this.T;
            proxyData.f23931c = str;
            proxyData.f23929a = arrayList;
            proxyData.f23930b = null;
            d(false);
            return;
        }
        K();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, String str2, boolean z) {
        if (i2 == -1) {
            ProxyData proxyData = this.T;
            proxyData.f23931c = str;
            proxyData.f23929a = arrayList;
            proxyData.f23930b = arrayList2;
            proxyData.f23932d = str2;
            d(z);
            return;
        }
        K();
    }

    public void d(boolean z) {
        ArrayList<String> arrayList = this.T.f23930b;
        ArrayList<String> arrayList2 = this.T.f23929a;
        if (af.a(arrayList)) {
            if (arrayList2.size() == 1) {
                this.m = arrayList2.get(0);
                if (this.f23923d) {
                    I();
                } else if (this.H) {
                    J();
                } else {
                    a(arrayList2);
                }
            } else {
                a(arrayList2);
            }
        } else if (!z) {
            a(arrayList.get(0));
        } else {
            a(arrayList2, arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, boolean z, boolean z2, PhotoFrameInfo photoFrameInfo, int i3) {
        if (i2 == -1) {
            ProxyData proxyData = this.T;
            proxyData.f23931c = str;
            proxyData.f23929a = arrayList;
            proxyData.f23930b = arrayList2;
            if (af.a(arrayList2)) {
                String str2 = arrayList.get(0);
                if ((!z || this.h) && this.f23923d) {
                    this.m = str2;
                    I();
                } else if (this.H) {
                    this.m = str2;
                    J();
                } else {
                    a(arrayList, z, photoFrameInfo, i3);
                }
            } else {
                a(arrayList2.get(0));
            }
        } else if (i2 != 1) {
            K();
        } else if (z2) {
            p();
        } else {
            K();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("image");
            arrayList.add(stringExtra);
            if (this.H) {
                this.m = stringExtra;
                J();
                return;
            }
            a((ArrayList<String>) arrayList);
        } else if (this.f23920a) {
            H();
        } else {
            K();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(intent.getStringExtra("image"));
            a((ArrayList<String>) arrayList);
        } else if (this.f23920a) {
            H();
        } else {
            K();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, String str2) {
        if (i2 == -1) {
            this.T.f23930b = new ArrayList<>(Collections.singletonList(str));
            ProxyData proxyData = this.T;
            proxyData.f23932d = str2;
            a(proxyData.f23929a, this.T.f23930b);
            return;
        }
        K();
    }

    public static class ProxyData implements Parcelable {
        public static final Parcelable.Creator<ProxyData> CREATOR = new Parcelable.Creator<ProxyData>() {
            /* renamed from: a */
            public ProxyData createFromParcel(Parcel parcel) {
                return new ProxyData(parcel);
            }

            /* renamed from: a */
            public ProxyData[] newArray(int i) {
                return new ProxyData[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f23929a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f23930b;

        /* renamed from: c  reason: collision with root package name */
        public String f23931c;

        /* renamed from: d  reason: collision with root package name */
        public String f23932d;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringList(this.f23929a);
            parcel.writeStringList(this.f23930b);
            parcel.writeString(this.f23931c);
        }

        public ProxyData() {
        }

        protected ProxyData(Parcel parcel) {
            this.f23929a = parcel.createStringArrayList();
            this.f23930b = parcel.createStringArrayList();
            this.f23931c = parcel.readString();
        }
    }
}
