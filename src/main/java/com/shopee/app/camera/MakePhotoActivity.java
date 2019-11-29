package com.shopee.app.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.afollestad.materialdialogs.f;
import com.facebook.react.uimanager.ViewProps;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.g.d;
import com.shopee.app.h.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.image.bound.j;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.id.R;
import com.squareup.a.aa;
import com.squareup.a.w;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MakePhotoActivity extends Activity implements SensorEventListener, MediaRecorder.OnInfoListener {
    private static final String[] ab = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
    /* access modifiers changed from: private */
    public RelativeLayout A;
    private boolean B = false;
    /* access modifiers changed from: private */
    public int C;
    /* access modifiers changed from: private */
    public boolean D = false;
    private ImageView E;
    private boolean F = false;
    private int G = 1;
    /* access modifiers changed from: private */
    public int H = 1;
    /* access modifiers changed from: private */
    public PhotoFrameInfo I;
    private int J;
    private boolean K = false;
    private IcCamera3Info L;
    /* access modifiers changed from: private */
    public int M;
    /* access modifiers changed from: private */
    public TextView N;
    private ImageView O;
    /* access modifiers changed from: private */
    public ImageView P;
    /* access modifiers changed from: private */
    public boolean Q = false;
    private String R;
    /* access modifiers changed from: private */
    public long S;
    private Sensor T;
    private Sensor U;
    private float[] V = new float[3];
    private float[] W = new float[3];
    private boolean X = false;
    private boolean Y = false;
    private float[] Z = new float[9];

    /* renamed from: a  reason: collision with root package name */
    j f15932a;
    private float[] aa = new float[3];
    private OrientationEventListener ac;
    /* access modifiers changed from: private */
    public int ad;
    private boolean ae = false;
    /* access modifiers changed from: private */
    public String af = "";
    private e ag = new g() {
        public void onEvent(a aVar) {
            MakePhotoActivity.this.finish();
            Toast.makeText(MakePhotoActivity.this, b.e(R.string.sp_unable_to_connect_camera), 1).show();
        }
    };
    private e ah = new g() {
        public void onEvent(a aVar) {
            ViewGroup.LayoutParams layoutParams;
            if (aVar != null && aVar.data != null) {
                Pair pair = (Pair) aVar.data;
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                if (MakePhotoActivity.this.a(intValue2)) {
                    final b bVar = new b(MakePhotoActivity.this);
                    if (MakePhotoActivity.this.b()) {
                        layoutParams = new FrameLayout.LayoutParams(b.a.u, b.a.u);
                        if (MakePhotoActivity.this.getResources().getBoolean(R.bool.isRightToLeft)) {
                            if (intValue > b.a.p) {
                                ((FrameLayout.LayoutParams) layoutParams).setMargins(0, intValue2 - b.a.p, MakePhotoActivity.this.l.getWidth() - (intValue + b.a.p), 0);
                            } else {
                                ((FrameLayout.LayoutParams) layoutParams).setMargins(0, intValue2 - b.a.p, MakePhotoActivity.this.l.getWidth() - b.a.u, 0);
                            }
                        } else if (b.a.p + intValue < MakePhotoActivity.this.l.getWidth()) {
                            ((FrameLayout.LayoutParams) layoutParams).setMargins(intValue - b.a.p, intValue2 - b.a.p, 0, 0);
                        } else {
                            ((FrameLayout.LayoutParams) layoutParams).setMargins(intValue - b.a.p, intValue2 - b.a.p, MakePhotoActivity.this.l.getWidth() - ((intValue - b.a.p) + b.a.u), 0);
                        }
                    } else {
                        layoutParams = new RelativeLayout.LayoutParams(b.a.u, b.a.u);
                        if (MakePhotoActivity.this.getResources().getBoolean(R.bool.isRightToLeft)) {
                            if (intValue > b.a.p) {
                                ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, intValue2 - b.a.p, MakePhotoActivity.this.l.getWidth() - (intValue + b.a.p), 0);
                            } else {
                                ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, intValue2 - b.a.p, MakePhotoActivity.this.l.getWidth() - b.a.u, 0);
                            }
                        } else if (b.a.p + intValue < MakePhotoActivity.this.l.getWidth()) {
                            ((RelativeLayout.LayoutParams) layoutParams).setMargins(intValue - b.a.p, intValue2 - b.a.p, 0, 0);
                        } else {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.addRule(11);
                            layoutParams2.setMargins(0, intValue2 - b.a.p, MakePhotoActivity.this.l.getWidth() - ((intValue - b.a.p) + b.a.u), 0);
                        }
                    }
                    if (MakePhotoActivity.this.z != null) {
                        MakePhotoActivity.this.l.removeView(MakePhotoActivity.this.z);
                    }
                    MakePhotoActivity.this.l.addView(bVar, layoutParams);
                    MakePhotoActivity.this.A.bringToFront();
                    b unused = MakePhotoActivity.this.z = bVar;
                    bVar.a(MakePhotoActivity.this);
                    f.a().a(new Runnable() {
                        public void run() {
                            if (MakePhotoActivity.this.z != null) {
                                MakePhotoActivity.this.l.removeView(bVar);
                            }
                        }
                    }, 800);
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    SettingConfigStore f15933b;

    /* renamed from: c  reason: collision with root package name */
    final int f15934c = b.a.r;

    /* renamed from: d  reason: collision with root package name */
    final Handler f15935d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    Runnable f15936e = new Runnable() {
        public void run() {
            if (MakePhotoActivity.this.Q) {
                long b2 = com.garena.android.appkit.tools.a.a.b() - MakePhotoActivity.this.S;
                if (b2 < 3500) {
                    MakePhotoActivity.this.P.setEnabled(false);
                } else {
                    w.a((Context) MakePhotoActivity.this).a((int) R.drawable.ic_video_button_suspended).b(MakePhotoActivity.this.f15934c, MakePhotoActivity.this.f15934c).d().a(MakePhotoActivity.this.P);
                    MakePhotoActivity.this.P.setEnabled(true);
                }
                MakePhotoActivity.this.N.setText(org.apache.commons.c.a.a.a(b2, "HH:mm:ss"));
                MakePhotoActivity.this.f15935d.postDelayed(MakePhotoActivity.this.f15936e, 500);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Camera f15937f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f15938g = 0;
    private c h;
    private ImageView i;
    private MediaRecorder j;
    private e k;
    /* access modifiers changed from: private */
    public ViewGroup l;
    private int m;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public ImageView p;
    private ImageView q;
    /* access modifiers changed from: private */
    public ImageButton r;
    /* access modifiers changed from: private */
    public ImageView s;
    /* access modifiers changed from: private */
    public RelativeLayout t;
    /* access modifiers changed from: private */
    public RelativeLayout u;
    private TextView v;
    private TextView w;
    /* access modifiers changed from: private */
    public TextView x;
    private FrameLayout y;
    /* access modifiers changed from: private */
    public b z;

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    /* access modifiers changed from: private */
    public boolean a(int i2) {
        if (!b()) {
            int i3 = this.m;
            if (i2 < i3 || i2 > this.n + i3) {
                return false;
            }
        }
        return true;
    }

    public boolean a() {
        return this.f15938g == 0;
    }

    public boolean b() {
        return this.ae;
    }

    public int c() {
        return this.n;
    }

    public int d() {
        return this.o;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(4);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.n = point.x;
        this.o = point.y;
        this.C = getIntent().getIntExtra("camera_resource_id", -1);
        this.F = getIntent().getBooleanExtra("SHOW_PREVIEW", false);
        this.M = getIntent().getIntExtra("CAMERA_MODE", 2);
        this.G = getIntent().getIntExtra("maxImageCount", 1);
        this.H = getIntent().getIntExtra("maxVideoCount", 1);
        this.ae = getIntent().getBooleanExtra("FULLSCREEN", false);
        this.af = getIntent().getStringExtra("FILTER_CODE");
        this.I = (PhotoFrameInfo) getIntent().getParcelableExtra("PHOTO_FRAME_INFO");
        this.J = getIntent().getIntExtra("PREFER_MIN_IMAGE_SIZE", -1);
        this.K = getIntent().getBooleanExtra("DISABLE_GALLERY_SELECTION", false);
        this.L = (IcCamera3Info) getIntent().getParcelableExtra("IC_CAMERA_3_INFO");
        this.l = (ViewGroup) ((LayoutInflater) getApplicationContext().getSystemService("layout_inflater")).inflate(this.ae ? R.layout.camera_full_screen_layout : R.layout.camera_layout, (ViewGroup) null);
        setContentView(this.l);
        this.f15938g = r();
        com.garena.android.appkit.b.b.a("CAMERA_FOCUS", this.ah, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CAMERA_STATUS_WRONG", this.ag, b.a.UI_BUS);
        i();
        h();
        this.f15933b = ar.f().e().settingConfigStore();
        this.ac = new OrientationEventListener(this, 3) {
            public void onOrientationChanged(int i) {
                if (i != MakePhotoActivity.this.ad && i != -1) {
                    if (i <= 45 || i > 315) {
                        int unused = MakePhotoActivity.this.ad = 0;
                    } else if (i > 45 && i <= 135) {
                        int unused2 = MakePhotoActivity.this.ad = 90;
                    } else if (i > 135 && i <= 225) {
                        int unused3 = MakePhotoActivity.this.ad = 180;
                    } else if (i > 225 && i <= 315) {
                        int unused4 = MakePhotoActivity.this.ad = 270;
                    }
                }
            }
        };
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        int i2 = this.M;
        if (i2 == 2 || i2 == 0) {
            this.N.setVisibility(8);
            TextView textView = this.x;
            if (textView != null) {
                textView.setVisibility(0);
            }
            this.O.setImageDrawable(com.garena.android.appkit.tools.b.f(R.drawable.ic_camera_video));
            if (!this.ae) {
                this.P.setBackgroundResource(R.drawable.camera_btn);
            }
            aa a2 = w.a((Context) this).a((int) R.drawable.ic_camera_button);
            int i3 = this.f15934c;
            a2.b(i3, i3).d().a(this.P);
        } else if (i2 == 3 || i2 == 1) {
            TextView textView2 = this.x;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.N.setVisibility(0);
            this.O.setImageDrawable(com.garena.android.appkit.tools.b.f(R.drawable.ic_video_camera));
            if (!this.ae) {
                this.P.setBackgroundResource(R.drawable.camera_btn);
            }
            aa a3 = w.a((Context) this).a((int) R.drawable.ic_video_button);
            int i4 = this.f15934c;
            a3.b(i4, i4).d().a(this.P);
            d.a(this, ab, 1, 0, R.string.msg_permission_video, R.string.sp_no_camera_access, R.string.sp_to_allow_camera_hint, new d.a() {
                public void a() {
                }

                public void b() {
                    MakePhotoActivity.this.finish();
                }

                public void c() {
                    MakePhotoActivity.this.finish();
                }
            });
        }
    }

    private void i() {
        this.N = (TextView) findViewById(R.id.current_video_length);
        this.O = (ImageView) findViewById(R.id.switch_video_mode);
        this.p = (ImageView) findViewById(R.id.flip_camera);
        this.r = (ImageButton) findViewById(R.id.flash_option);
        this.q = (ImageView) findViewById(R.id.close_window);
        this.A = (RelativeLayout) findViewById(R.id.camera_action_bar);
        this.s = (ImageView) findViewById(R.id.image_preview);
        this.t = (RelativeLayout) findViewById(R.id.btn_panel);
        this.u = (RelativeLayout) findViewById(R.id.text_panel);
        this.v = (TextView) findViewById(R.id.retake);
        this.w = (TextView) findViewById(R.id.use_photo);
        this.P = (ImageView) findViewById(R.id.capture_camera);
        this.i = (ImageView) findViewById(R.id.gallery_preview);
        this.f15932a = (j) this.l.findViewById(R.id.photo_frame_layout);
        if (this.K) {
            this.i.setVisibility(8);
        }
        k();
        j();
        this.E = (ImageView) findViewById(R.id.camera_preview_empty);
        if (s() < 0) {
            this.p.setVisibility(4);
        }
        this.P.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MakePhotoActivity.this.q();
            }
        });
        if (this.ae) {
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PhotoProxyActivity_.a(MakePhotoActivity.this).c(3).d(true).b(MakePhotoActivity.this.af).a(4);
                }
            });
        }
        int i2 = this.M;
        if (i2 == 0 || i2 == 1) {
            this.O.setVisibility(8);
        } else if (i2 == 2 || i2 == 3) {
            this.O.setVisibility(0);
            this.O.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (MakePhotoActivity.this.H == 0) {
                        com.shopee.app.ui.dialog.a.a((Context) MakePhotoActivity.this, 0, (int) R.string.sp_video_gallery_replace_text, (int) R.string.sp_label_cancel, (int) R.string.sp_label_replace, (f.b) new f.b() {
                            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                                fVar.dismiss();
                                MakePhotoActivity makePhotoActivity = MakePhotoActivity.this;
                                int i = 2;
                                if (MakePhotoActivity.this.M == 2) {
                                    i = 3;
                                }
                                int unused = makePhotoActivity.M = i;
                                MakePhotoActivity.this.h();
                                int unused2 = MakePhotoActivity.this.H = 1;
                            }
                        }, false);
                        return;
                    }
                    MakePhotoActivity makePhotoActivity = MakePhotoActivity.this;
                    int i = 2;
                    if (makePhotoActivity.M == 2) {
                        i = 3;
                    }
                    int unused = makePhotoActivity.M = i;
                    MakePhotoActivity.this.h();
                }
            });
        }
        n();
        l();
    }

    private void j() {
        IcCamera3Info icCamera3Info = this.L;
        if (icCamera3Info != null) {
            int type = icCamera3Info.getType();
            if (type == 1) {
                ((ViewStub) findViewById(R.id.camera_selfie_overlay_stub)).inflate();
            } else if (type == 2) {
                ((ViewStub) findViewById(R.id.camera_ic_overlay_stub)).inflate();
                this.t.setBackgroundColor(androidx.core.content.b.c(this, R.color.transparent));
                this.A.setVisibility(8);
                this.q = (ImageView) findViewById(R.id.close_window_ic);
                this.r = (ImageButton) findViewById(R.id.flash_option_ic);
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                this.i.setVisibility(8);
            }
        }
    }

    private void k() {
        PhotoFrameInfo photoFrameInfo = this.I;
        if (photoFrameInfo != null && photoFrameInfo.getFrameRatio() > BitmapDescriptorFactory.HUE_RED) {
            j jVar = this.f15932a;
            if (jVar != null) {
                jVar.setVisibility(0);
                this.f15932a.a(this.I.getFrameRatio(), this.I.getHorizontalMargin());
            }
        }
    }

    private void l() {
        this.q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MakePhotoActivity.this.finish();
            }
        });
    }

    private void m() throws Exception {
        if (!this.B) {
            boolean z2 = true;
            if (getPackageManager().hasSystemFeature("android.hardware.camera")) {
                int i2 = this.f15938g;
                if (i2 >= 0) {
                    this.f15937f = Camera.open(i2);
                    if (this.f15937f != null) {
                        this.B = true;
                        IcCamera3Info icCamera3Info = this.L;
                        this.k = new e(this, this.J > 0, icCamera3Info != null && icCamera3Info.getType() == 2);
                        Camera.Parameters parameters = this.f15937f.getParameters();
                        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
                        Camera.Size size = null;
                        int i3 = this.J;
                        if (i3 > 0) {
                            int i4 = this.o;
                            if (i4 > 0) {
                                size = d.a(supportedPictureSizes, (double) (((float) this.n) / ((float) i4)), i3);
                            }
                        }
                        if (size == null) {
                            size = a(supportedPictureSizes);
                        }
                        Camera.Size size2 = size;
                        parameters.setPictureSize(size2.width, size2.height);
                        Camera camera = this.f15937f;
                        int i5 = this.f15938g;
                        int i6 = this.o;
                        int i7 = this.n;
                        double d2 = (double) size2.width;
                        double d3 = (double) size2.height;
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        this.h = new c(this, camera, i5, i6, i7, d2 / d3, b());
                        this.x = new TextView(this);
                        this.x.setGravity(1);
                        this.x.setPadding(0, b.a.k, 0, 0);
                        this.x.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
                        this.x.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.full_opacity));
                        d.a((Activity) this, this.f15938g, this.f15937f);
                        this.y = (FrameLayout) findViewById(R.id.camera_preview);
                        this.y.requestLayout();
                        if (this.n >= this.o) {
                            z2 = false;
                        }
                        if (!this.ae) {
                            int i8 = this.n;
                            int i9 = this.o;
                            if (i8 >= i9) {
                                i8 = i9;
                            }
                            if (z2) {
                                this.y.addView(this.h, i8, (size2.width * i8) / size2.height);
                            } else {
                                new FrameLayout.LayoutParams((size2.height * i8) / size2.width, i8).setMargins(Math.abs((this.o - this.n) / 2), 0, 0, 0);
                                this.y.addView(this.h, (size2.height * i8) / size2.width, i8);
                            }
                            int abs = Math.abs(this.n - this.o);
                            this.m = b.a.k * 3;
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, abs);
                            layoutParams.setMargins(0, i8, 0, 0);
                            this.y.addView(this.x, layoutParams);
                        } else if (this.J > 0) {
                            this.y.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
                        } else {
                            this.y.addView(this.h, this.n, this.o);
                        }
                        int i10 = this.M;
                        if (i10 == 2) {
                            this.x.setVisibility(0);
                        } else if (i10 == 3) {
                            this.x.setVisibility(8);
                        }
                        if (this.f15938g == 0 && parameters.getFlashMode() != null) {
                            if (parameters.getSupportedFocusModes().contains("auto")) {
                                parameters.setFocusMode("auto");
                            }
                            if (parameters.getSupportedFlashModes().contains("off")) {
                                parameters.setFlashMode("off");
                            }
                        }
                        this.f15937f.setParameters(parameters);
                        this.h.a();
                        this.E.setVisibility(8);
                        this.l.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.transparent));
                        return;
                    }
                    throw new f(1);
                }
                throw new f(1);
            }
            Toast.makeText(this, com.garena.android.appkit.tools.b.e(R.string.sp_no_camera_found), 1).show();
            throw new f(0);
        }
    }

    private Camera.Size a(List<Camera.Size> list) {
        double d2;
        int i2;
        double d3;
        List<Camera.Size> list2 = list;
        Camera.Size size = list2.get(0).height > list2.get(list.size() - 1).height ? list2.get(list.size() - 1) : list2.get(0);
        Camera.Size size2 = size;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (Camera.Size next : list) {
            if (next.height > size2.height && (next.height < 1024 || next.width < 1024)) {
                i4 = i3;
                size2 = next;
            }
            if (next.height > next.width) {
                double d4 = (double) next.height;
                double d5 = (double) next.width;
                Double.isNaN(d4);
                Double.isNaN(d5);
                d3 = d4 / d5;
            } else {
                double d6 = (double) next.width;
                double d7 = (double) next.height;
                Double.isNaN(d6);
                Double.isNaN(d7);
                d3 = d6 / d7;
            }
            if (next.height > size.height && Math.abs(d3 - 1.3d) < 0.1d && (next.height < 1024 || next.width < 1024)) {
                i5 = i3;
                size = next;
            }
            i3++;
        }
        if (size.height > size.width) {
            d2 = (double) size.height;
            i2 = size.width;
        } else {
            d2 = (double) size.width;
            i2 = size.height;
        }
        double d8 = (double) i2;
        Double.isNaN(d2);
        Double.isNaN(d8);
        if (Math.abs((d2 / d8) - 1.3d) >= 0.1d || (size.height >= 1024 && size.width >= 1024)) {
            return list2.get(i4);
        }
        return list2.get(i5);
    }

    private void n() {
        this.p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MakePhotoActivity.this.f15938g == 0) {
                    MakePhotoActivity makePhotoActivity = MakePhotoActivity.this;
                    int unused = makePhotoActivity.f15938g = makePhotoActivity.s();
                    if (MakePhotoActivity.this.f15938g < 0) {
                        r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_error_no_front_camera));
                        return;
                    }
                    MakePhotoActivity.this.w();
                    MakePhotoActivity.this.o();
                    return;
                }
                MakePhotoActivity makePhotoActivity2 = MakePhotoActivity.this;
                int unused2 = makePhotoActivity2.f15938g = makePhotoActivity2.r();
                if (MakePhotoActivity.this.f15938g < 0) {
                    r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_error_no_back_camera));
                    return;
                }
                MakePhotoActivity.this.w();
                MakePhotoActivity.this.o();
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MakePhotoActivity.this.f15937f != null) {
                    try {
                        Camera.Parameters parameters = MakePhotoActivity.this.f15937f.getParameters();
                        if (parameters.getFlashMode().equals("auto")) {
                            parameters.setFlashMode(ViewProps.ON);
                            MakePhotoActivity.this.r.setImageDrawable(com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_camera_flash_on));
                        } else if (parameters.getFlashMode().equals(ViewProps.ON)) {
                            parameters.setFlashMode("off");
                            MakePhotoActivity.this.r.setImageDrawable(com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_camera_flash_off));
                        } else {
                            parameters.setFlashMode("auto");
                            MakePhotoActivity.this.r.setImageDrawable(com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_camera_flash_auto));
                        }
                        MakePhotoActivity.this.f15937f.setParameters(parameters);
                        MakePhotoActivity.this.f15937f.startPreview();
                    } catch (Exception e2) {
                        com.garena.android.appkit.d.a.a(e2);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void o() {
        try {
            m();
        } catch (f e2) {
            if (e2.a() == 0) {
                Toast.makeText(this, com.garena.android.appkit.tools.b.e(R.string.sp_no_camera_found), 1).show();
                finish();
            } else if (e2.a() == 1) {
                p();
            }
        } catch (Exception unused) {
            p();
        }
    }

    private void p() {
        com.shopee.app.ui.dialog.a.a((Context) this, (int) R.string.sp_camera_in_use, (int) R.string.sp_label_cancel, (int) R.string.sp_choose_from_album, (a.C0318a) new a.C0318a() {
            public void onPositive() {
                Intent intent = new Intent();
                intent.putExtra("GO_TO_ALBUM", true);
                MakePhotoActivity.this.setResult(1, intent);
                MakePhotoActivity.this.finish();
            }

            public void onNegative() {
                MakePhotoActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    public void q() {
        int i2 = this.M;
        if (i2 == 0 || i2 == 2) {
            try {
                this.k.a(u());
                this.f15937f.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, this.k);
            } catch (RuntimeException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        } else if (i2 != 1 && i2 != 3) {
        } else {
            if (this.Q) {
                f();
                this.Q = false;
                return;
            }
            t();
            e();
            this.Q = true;
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 1) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        } else if (iArr.length == ab.length) {
            for (int i3 : iArr) {
                if (i3 != 0) {
                    finish();
                    return;
                }
            }
        } else {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.j.start();
        this.S = com.garena.android.appkit.tools.a.a.b();
        this.f15935d.postDelayed(this.f15936e, 1000);
        aa a2 = w.a((Context) this).a((int) R.drawable.ic_video_button_suspended_1);
        int i2 = this.f15934c;
        a2.b(i2, i2).d().a(this.P);
        this.P.setEnabled(false);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        aa a2 = w.a((Context) this).a((int) R.drawable.ic_video_button);
        int i2 = this.f15934c;
        a2.b(i2, i2).d().a(this.P);
        this.S = 0;
        this.j.stop();
        v();
        this.f15937f.lock();
        a(Uri.fromFile(new File(com.shopee.app.h.f.a().d() + this.R)), true);
    }

    /* access modifiers changed from: private */
    public int r() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 0) {
                com.garena.android.appkit.d.a.b("MakePhotoActivity", "Camera found");
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int s() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                com.garena.android.appkit.d.a.b("MakePhotoActivity", "Camera found");
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 4 && i3 == -1) {
            a((ArrayList) intent.getStringArrayListExtra("add_product_image_uri_list"), intent.getStringExtra("INSTAGRAM_INFO"), false);
        }
    }

    private void a(ArrayList arrayList, String str, boolean z2) {
        Intent intent = new Intent();
        intent.putExtra("add_product_image_uri_list", arrayList);
        intent.putExtra("INSTAGRAM_INFO", str);
        intent.putExtra("add_product_image_source", z2);
        intent.putExtra("PHOTO_FRAME_INFO", this.I);
        setResult(-1, intent);
        finish();
    }

    public void a(Uri uri, boolean z2) {
        a(uri, z2, 0);
    }

    public void a(final Uri uri, final boolean z2, final int i2) {
        if (this.F) {
            this.p.setVisibility(8);
            this.t.setVisibility(8);
            this.x.setText("");
            this.u.setVisibility(0);
            this.s.setVisibility(0);
            w.a((Context) this).a(uri).b(this.n, this.o).e().a(this.s);
            this.w.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String uri = uri.toString();
                    Intent intent = new Intent();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(uri);
                    intent.putExtra("add_product_image_uri_list", arrayList);
                    intent.putExtra("add_product_image_source", z2);
                    intent.putExtra("PHOTO_ORIENTATION", i2);
                    intent.putExtra("PHOTO_FRAME_INFO", MakePhotoActivity.this.I);
                    MakePhotoActivity.this.setResult(-1, intent);
                    MakePhotoActivity.this.finish();
                }
            });
            this.v.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MakePhotoActivity.this.p.setVisibility(0);
                    if (MakePhotoActivity.this.C != -1) {
                        MakePhotoActivity.this.x.setText(com.garena.android.appkit.tools.b.e(MakePhotoActivity.this.C));
                    } else {
                        MakePhotoActivity.this.x.setText(com.garena.android.appkit.tools.b.e(R.string.sp_photo_default_text));
                    }
                    MakePhotoActivity.this.t.setVisibility(0);
                    MakePhotoActivity.this.u.setVisibility(8);
                    MakePhotoActivity.this.s.setVisibility(8);
                    MakePhotoActivity.this.g();
                }
            });
            return;
        }
        int i3 = this.M;
        if (i3 == 1 || i3 == 3) {
            String uri2 = uri.toString();
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add(uri2);
            intent.putExtra("add_product_video_uri_list", arrayList);
            intent.putExtra("add_product_image_source", z2);
            setResult(-1, intent);
            finish();
        } else if (i3 == 0 || i3 == 2) {
            String uri3 = uri.toString();
            Intent intent2 = new Intent();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(uri3);
            intent2.putExtra("add_product_image_uri_list", arrayList2);
            intent2.putExtra("add_product_image_source", z2);
            intent2.putExtra("PHOTO_ORIENTATION", i2);
            intent2.putExtra("PHOTO_FRAME_INFO", this.I);
            setResult(-1, intent2);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.D = false;
        this.X = false;
        this.Y = false;
        this.ac.enable();
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                if (!MakePhotoActivity.this.D) {
                    MakePhotoActivity.this.o();
                    MakePhotoActivity.this.h();
                }
            }
        }, 500);
    }

    private void t() {
        try {
            List<Camera.Size> supportedVideoSizes = this.f15937f.getParameters().getSupportedVideoSizes();
            if (supportedVideoSizes != null) {
                a(supportedVideoSizes, this.f15933b.getProductImageConfig().fullVideoWidth, this.f15933b.getProductImageConfig().fullVideoHeight);
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        this.f15937f.unlock();
        this.j = new MediaRecorder();
        this.j.setCamera(this.f15937f);
        this.j.setAudioSource(5);
        this.j.setVideoSource(1);
        CamcorderProfile camcorderProfile = null;
        Iterator it = Arrays.asList(new Integer[]{3, 4, 5}).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int intValue = ((Integer) it.next()).intValue();
            if (CamcorderProfile.hasProfile(this.f15938g, intValue)) {
                camcorderProfile = CamcorderProfile.get(this.f15938g, intValue);
                break;
            }
        }
        if (camcorderProfile == null) {
            camcorderProfile = CamcorderProfile.get(this.f15938g, 1);
        }
        com.garena.android.appkit.d.a.b(camcorderProfile.toString(), new Object[0]);
        this.j.setOutputFormat(camcorderProfile.fileFormat);
        this.j.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.j.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.j.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.j.setVideoEncoder(2);
        if (camcorderProfile.quality < 1000 || camcorderProfile.quality > 1007) {
            this.j.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.j.setAudioChannels(camcorderProfile.audioChannels);
            this.j.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.j.setAudioEncoder(3);
        }
        this.j.setOrientationHint(u());
        this.R = String.valueOf(com.garena.android.appkit.tools.a.a.a()) + ".mp4";
        this.j.setOutputFile(com.shopee.app.h.f.a().b(this.R));
        this.j.setPreviewDisplay(this.h.getHolder().getSurface());
        try {
            this.j.prepare();
        } catch (IOException e3) {
            com.garena.android.appkit.d.a.a(e3);
            e3.printStackTrace();
            v();
            w();
            finish();
        }
    }

    private int u() {
        IcCamera3Info icCamera3Info = this.L;
        if (icCamera3Info != null) {
            int type = icCamera3Info.getType();
            if (type == 1) {
                return a() ? 90 : 270;
            }
            if (type == 2) {
                if (a()) {
                    return 0;
                }
                return 180;
            }
        }
        int cameraAngle = this.h.getCameraAngle() + this.ad;
        if (!a()) {
            cameraAngle += 180;
        }
        return cameraAngle % 360;
    }

    private Camera.Size a(List<Camera.Size> list, int i2, int i3) {
        int i4 = i3;
        double d2 = (double) i2;
        double d3 = (double) i4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double d5 = Double.MAX_VALUE;
        double d6 = Double.MAX_VALUE;
        for (Camera.Size next : list) {
            double d7 = (double) next.width;
            double d8 = (double) next.height;
            Double.isNaN(d7);
            Double.isNaN(d8);
            if (Math.abs((d7 / d8) - d4) <= 0.2d && ((double) Math.abs(next.height - i4)) < d6) {
                d6 = (double) Math.abs(next.height - i4);
                size = next;
            }
        }
        if (size == null) {
            for (Camera.Size next2 : list) {
                if (((double) Math.abs(next2.height - i4)) < d5) {
                    size = next2;
                    d5 = (double) Math.abs(next2.height - i4);
                }
            }
        }
        return size;
    }

    private void v() {
        MediaRecorder mediaRecorder = this.j;
        if (mediaRecorder != null) {
            mediaRecorder.reset();
            this.j.release();
            this.j = null;
            this.f15937f.lock();
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        if (this.B) {
            this.B = false;
            Camera camera = this.f15937f;
            if (camera != null) {
                camera.lock();
                this.h.getHolder().removeCallback(this.h);
                this.y.removeView(this.h);
                this.f15937f.release();
                this.f15937f = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        v();
        w();
        this.D = true;
        this.ac.disable();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        com.garena.android.appkit.b.b.b("CAMERA_FOCUS", this.ah, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CAMERA_STATUS_WRONG", this.ag, b.a.UI_BUS);
        super.onDestroy();
    }

    public void g() {
        w();
        o();
    }

    public void onInfo(MediaRecorder mediaRecorder, int i2, int i3) {
        if (i2 == 800 || i2 == 801) {
            q();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == this.T) {
            System.arraycopy(sensorEvent.values, 0, this.V, 0, sensorEvent.values.length);
            this.X = true;
        } else if (sensorEvent.sensor == this.U) {
            System.arraycopy(sensorEvent.values, 0, this.W, 0, sensorEvent.values.length);
            this.Y = true;
        }
        if (this.X && this.Y) {
            SensorManager.getRotationMatrix(this.Z, (float[]) null, this.V, this.W);
            SensorManager.getOrientation(this.Z, this.aa);
            float[] fArr = this.aa;
            float f2 = fArr[1];
            double d2 = (double) (-fArr[1]);
            double d3 = (double) (-fArr[2]);
            double d4 = (double) (-fArr[0]);
            int i2 = -1;
            Double.isNaN(d2);
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d4);
            if (((double) (((float) ((d2 * d2) + (d3 * d3))) * 4.0f)) >= d4 * d4) {
                Double.isNaN(d3);
                i2 = 90 - Math.round(((float) Math.atan2(-d3, d2)) * 57.29578f);
                while (i2 >= 360) {
                    i2 -= 360;
                }
                while (i2 < 0) {
                    i2 += 360;
                }
            }
            Log.d("ORIENTATION", String.valueOf(i2));
        }
    }
}
