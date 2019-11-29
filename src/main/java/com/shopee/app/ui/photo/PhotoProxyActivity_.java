package com.shopee.app.ui.photo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import org.a.a.a.d;
import org.a.a.b.c;

public final class PhotoProxyActivity_ extends PhotoProxyActivity implements org.a.a.b.a {
    private final c S = new c();

    public void onCreate(Bundle bundle) {
        c a2 = c.a(this.S);
        c(bundle);
        super.onCreate(bundle);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    private void c(Bundle bundle) {
        l();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.S.a((org.a.a.b.a) this);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        this.S.a((org.a.a.b.a) this);
    }

    public void setContentView(View view) {
        super.setContentView(view);
        this.S.a((org.a.a.b.a) this);
    }

    public static a a(Context context) {
        return new a(context);
    }

    private void l() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("useCamera")) {
                this.f23920a = extras.getBoolean("useCamera");
            }
            if (extras.containsKey("showPreview")) {
                this.f23921b = extras.getBoolean("showPreview");
            }
            if (extras.containsKey("cameraMode")) {
                this.f23922c = extras.getInt("cameraMode");
            }
            if (extras.containsKey("applyCrop")) {
                this.f23923d = extras.getBoolean("applyCrop");
            }
            if (extras.containsKey("fromAlbum")) {
                this.f23924e = extras.getBoolean("fromAlbum");
            }
            if (extras.containsKey("galleryMode")) {
                this.f23925f = extras.getInt("galleryMode");
            }
            if (extras.containsKey("fromInstagram")) {
                this.f23926g = extras.getBoolean("fromInstagram");
            }
            if (extras.containsKey("cropCamera")) {
                this.h = extras.getBoolean("cropCamera");
            }
            if (extras.containsKey("ratioWidth")) {
                this.i = extras.getInt("ratioWidth");
            }
            if (extras.containsKey("ratioHeight")) {
                this.j = extras.getInt("ratioHeight");
            }
            if (extras.containsKey("maxImageCount")) {
                this.k = extras.getInt("maxImageCount");
            }
            if (extras.containsKey("maxVideoCount")) {
                this.l = extras.getInt("maxVideoCount");
            }
            if (extras.containsKey(ShareConstants.MEDIA_URI)) {
                this.m = extras.getString(ShareConstants.MEDIA_URI);
            }
            if (extras.containsKey("allowSpacing")) {
                this.n = extras.getBoolean("allowSpacing");
            }
            if (extras.containsKey("allowEdit")) {
                this.H = extras.getBoolean("allowEdit");
            }
            if (extras.containsKey("harbor_activity")) {
                this.I = extras.getInt("harbor_activity");
            }
            if (extras.containsKey("resource_id")) {
                this.J = extras.getInt("resource_id");
            }
            if (extras.containsKey("fullscreen")) {
                this.K = extras.getBoolean("fullscreen");
            }
            if (extras.containsKey("filterCode")) {
                this.L = extras.getString("filterCode");
            }
            if (extras.containsKey("photoFrameInfo")) {
                this.M = (PhotoFrameInfo) extras.getParcelable("photoFrameInfo");
            }
            if (extras.containsKey("preferMinImageSize")) {
                this.N = extras.getInt("preferMinImageSize");
            }
            if (extras.containsKey("disableGallerySelection")) {
                this.O = extras.getBoolean("disableGallerySelection");
            }
            if (extras.containsKey("icCamera3Info")) {
                this.P = (IcCamera3Info) extras.getParcelable("icCamera3Info");
            }
        }
    }

    public void setIntent(Intent intent) {
        super.setIntent(intent);
        l();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1223) {
            a(i2, intent);
        } else if (i == 1782) {
            Bundle bundle = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle.getStringArrayList("add_product_image_uri_list"), bundle.getStringArrayList("add_product_video_uri_list"), bundle.getString("INSTAGRAM_INFO"), bundle.getBoolean("add_product_image_source"), bundle.getBoolean("GO_TO_ALBUM"), (PhotoFrameInfo) bundle.getParcelable("PHOTO_FRAME_INFO"), bundle.getInt("PHOTO_ORIENTATION"));
        } else if (i == 1827) {
            Bundle bundle2 = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle2.getStringArrayList("imageList"), bundle2.getStringArrayList("videoList"), bundle2.getString("instagramPackets"), bundle2.getString("trimVideoData"), bundle2.getBoolean("trimDone"));
        } else if (i == 1837) {
            Bundle bundle3 = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle3.getStringArrayList("imageList"), bundle3.getString("instagramPackets"));
        } else if (i == 7283) {
            Bundle bundle4 = (intent == null || intent.getExtras() == null) ? new Bundle() : intent.getExtras();
            a(i2, bundle4.getString("trimVideoPath"), bundle4.getString("trimVideoData"));
        } else if (i == 9006) {
            b(i2, intent);
        }
    }

    public static class a extends org.a.a.a.a<a> {

        /* renamed from: d  reason: collision with root package name */
        private Fragment f23933d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.fragment.app.Fragment f23934e;

        public a(Context context) {
            super(context, PhotoProxyActivity_.class);
        }

        public d a(int i) {
            androidx.fragment.app.Fragment fragment = this.f23934e;
            if (fragment != null) {
                fragment.startActivityForResult(this.f7170c, i);
            } else {
                Fragment fragment2 = this.f23933d;
                if (fragment2 != null) {
                    fragment2.startActivityForResult(this.f7170c, i, this.f7168a);
                } else if (this.f7169b instanceof Activity) {
                    androidx.core.app.a.a((Activity) this.f7169b, this.f7170c, i, this.f7168a);
                } else {
                    this.f7169b.startActivity(this.f7170c, this.f7168a);
                }
            }
            return new d(this.f7169b);
        }

        public a a(boolean z) {
            return (a) super.a("useCamera", z);
        }

        public a b(boolean z) {
            return (a) super.a("showPreview", z);
        }

        public a b(int i) {
            return (a) super.a("cameraMode", i);
        }

        public a c(boolean z) {
            return (a) super.a("applyCrop", z);
        }

        public a d(boolean z) {
            return (a) super.a("fromAlbum", z);
        }

        public a c(int i) {
            return (a) super.a("galleryMode", i);
        }

        public a e(boolean z) {
            return (a) super.a("fromInstagram", z);
        }

        public a f(boolean z) {
            return (a) super.a("cropCamera", z);
        }

        public a d(int i) {
            return (a) super.a("ratioWidth", i);
        }

        public a e(int i) {
            return (a) super.a("ratioHeight", i);
        }

        public a f(int i) {
            return (a) super.a("maxImageCount", i);
        }

        public a g(int i) {
            return (a) super.a("maxVideoCount", i);
        }

        public a a(String str) {
            return (a) super.a(ShareConstants.MEDIA_URI, str);
        }

        public a g(boolean z) {
            return (a) super.a("allowSpacing", z);
        }

        public a h(boolean z) {
            return (a) super.a("allowEdit", z);
        }

        public a h(int i) {
            return (a) super.a("harbor_activity", i);
        }

        public a i(int i) {
            return (a) super.a("resource_id", i);
        }

        public a i(boolean z) {
            return (a) super.a("fullscreen", z);
        }

        public a b(String str) {
            return (a) super.a("filterCode", str);
        }

        public a a(PhotoFrameInfo photoFrameInfo) {
            return (a) super.a("photoFrameInfo", (Parcelable) photoFrameInfo);
        }

        public a j(int i) {
            return (a) super.a("preferMinImageSize", i);
        }

        public a j(boolean z) {
            return (a) super.a("disableGallerySelection", z);
        }

        public a a(IcCamera3Info icCamera3Info) {
            return (a) super.a("icCamera3Info", (Parcelable) icCamera3Info);
        }
    }
}
