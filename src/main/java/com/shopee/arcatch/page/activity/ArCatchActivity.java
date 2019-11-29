package com.shopee.arcatch.page.activity;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.shopee.arcatch.a;
import com.shopee.arcatch.b.c.g;
import com.shopee.arcatch.c.b.f;
import com.shopee.arcatch.c.g.i;
import com.shopee.arcatch.c.g.j;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.data.data_tracking.TrackingProp;
import com.shopee.arcatch.data.network_bean.CommonBean;
import com.shopee.arcatch.data.network_bean.CommonCallback;
import com.shopee.arcatch.data.network_bean.game.EndGameData;
import com.shopee.arcatch.data.network_bean.game.PropsBean;
import com.shopee.arcatch.page.cameraview.common.CameraSourcePreview;
import com.shopee.arcatch.page.cameraview.common.GraphicOverlay;
import com.shopee.arcatch.page.view.ArCatchCountdownView;
import com.shopee.arcatch.page.view.ArCatchGameInfoView;
import com.shopee.arcatch.page.view.ArCatchTitleBar;
import com.shopee.arcatch.page.view.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ArCatchActivity extends com.shopee.arcatch.b.a.a implements ArCatchCountdownView.a, ArCatchGameInfoView.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.shopee.arcatch.page.cameraview.common.a f26926a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CameraSourcePreview f26927b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public GraphicOverlay f26928c;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintLayout f26929d;

    /* renamed from: e  reason: collision with root package name */
    private ArCatchTitleBar f26930e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f26931f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f26932g;
    private com.shopee.arcatch.page.view.b h;
    private com.shopee.arcatch.page.view.a i;
    private com.shopee.arcatch.c.h.a j;
    private ArCatchCountdownView k;
    private ArCatchGameInfoView l;
    private TextView m;
    private ImageView n;
    /* access modifiers changed from: private */
    public com.shopee.arcatch.page.view.c o;
    private boolean p = false;
    private MediaProjectionManager q;
    private j r;
    private com.shopee.arcatch.c.e.b s = new com.shopee.arcatch.c.e.b();
    /* access modifiers changed from: private */
    public i t;
    /* access modifiers changed from: private */
    public i u;
    /* access modifiers changed from: private */
    public Handler v = new Handler();
    private Runnable w = new a(this);
    private Runnable x = new Runnable() {
        public void run() {
            com.shopee.arcatch.c.d.b.a().h();
        }
    };
    private Timer y;
    private TimerTask z = new TimerTask() {
        public void run() {
            float b2 = com.shopee.arcatch.b.c.e.b((Context) ArCatchActivity.this);
            float d2 = com.shopee.arcatch.b.c.e.d();
            if (ArCatchActivity.this.t != null && ArCatchActivity.this.u != null) {
                ArCatchActivity.this.t.a(d2);
                ArCatchActivity.this.u.a(b2);
            }
        }
    };

    public String a() {
        return "ArCatchActivity";
    }

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ArCatchActivity> f26937a;

        protected a(ArCatchActivity arCatchActivity) {
            this.f26937a = new WeakReference<>(arCatchActivity);
        }

        public void run() {
            ArCatchActivity arCatchActivity = (ArCatchActivity) this.f26937a.get();
            if (arCatchActivity != null && !arCatchActivity.isFinishing()) {
                arCatchActivity.b();
            }
        }
    }

    private static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ArCatchActivity> f26940a;

        protected d(ArCatchActivity arCatchActivity) {
            this.f26940a = new WeakReference<>(arCatchActivity);
        }

        public void run() {
            ArCatchActivity arCatchActivity = (ArCatchActivity) this.f26940a.get();
            if (arCatchActivity != null && !arCatchActivity.isFinishing()) {
                arCatchActivity.n();
                arCatchActivity.g();
                arCatchActivity.p();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.d.activity_arcatch);
        m();
        l();
        k();
        i();
        e();
        com.shopee.sdk.b.c().a("NotificationShopeeLiveHideMiniWindow", (com.shopee.sdk.c.a) null);
    }

    public void b() {
        this.h.b();
        this.v.postDelayed(this.w, this.r.b());
    }

    private void e() {
        if (!com.shopee.arcatch.c.d.a.a().h) {
            f();
        } else if (Build.VERSION.SDK_INT < 21) {
            f();
        } else if (com.shopee.arcatch.b.b.a.a(this, "android.permission.RECORD_AUDIO")) {
            t();
        } else {
            f();
        }
    }

    private void f() {
        this.v.post(new d(this));
    }

    /* access modifiers changed from: private */
    public void g() {
        this.k.a();
    }

    private void h() {
        ArCatchCountdownView arCatchCountdownView = this.k;
        if (arCatchCountdownView != null) {
            arCatchCountdownView.b();
        }
        com.shopee.arcatch.page.view.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
        TextView textView = this.m;
        if (textView != null && textView.getAnimation() != null) {
            this.m.clearAnimation();
        }
    }

    private void i() {
        com.shopee.arcatch.c.d.b.a().b(!com.shopee.arcatch.c.d.a.a().f26762g);
    }

    private void j() {
        this.v.postDelayed(this.x, 50);
    }

    private void k() {
        this.r = new j(com.shopee.arcatch.c.d.a.a().c(), com.shopee.arcatch.c.d.a.a().i);
    }

    private void l() {
        this.y = new Timer();
        this.y.schedule(this.z, 500, 1000);
        this.t = new i("cpu");
        this.u = new i("ram");
        com.shopee.arcatch.b.c.e.c();
    }

    private void m() {
        this.f26929d = (ConstraintLayout) findViewById(a.c.arcatch_game_content);
        this.k = (ArCatchCountdownView) findViewById(a.c.arcatch_tv_countdown);
        this.f26931f = (LinearLayout) findViewById(a.c.arcatch_goldfall_container);
        this.f26932g = (FrameLayout) findViewById(a.c.arcatch_anivoice_container);
        this.l = (ArCatchGameInfoView) findViewById(a.c.arcatch_timercoins);
        this.f26927b = (CameraSourcePreview) findViewById(a.c.arcatch_camera_preview);
        this.f26928c = (GraphicOverlay) findViewById(a.c.arcatch_graphic_overlay);
        this.m = (TextView) findViewById(a.c.arcatch_timesup);
        this.n = (ImageView) findViewById(a.c.arcatch_forbg);
        this.k.setCountDownListener(this);
        this.f26930e = (ArCatchTitleBar) findViewById(a.c.arcatch_game_titlebar);
        this.f26930e.setBackOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ArCatchActivity.this.finish();
            }
        });
        this.f26930e.a(com.shopee.arcatch.c.d.a.a().n());
        g.a((View) this.f26930e);
        g.a(getWindow());
        this.n.setImageBitmap(com.shopee.arcatch.c.d.a.a().f());
        this.l.setListener(this);
    }

    /* access modifiers changed from: private */
    public void n() {
        this.h = new com.shopee.arcatch.page.view.b(this);
        this.f26931f.addView(this.h);
        this.h.setLayerType(0, (Paint) null);
        this.i = new com.shopee.arcatch.page.view.a(this);
        this.f26932g.addView(this.i);
        this.h.setCatchItemVoiceAnimaView(this.i);
        this.h.setArCatchTimerCoinsView(this.l);
        o();
    }

    private void o() {
        if (this.f26926a == null) {
            this.f26926a = new com.shopee.arcatch.page.cameraview.common.a(this, this.f26928c);
        }
        this.j = new com.shopee.arcatch.c.h.a(this.h, this.f26928c);
        this.f26926a.a((com.shopee.arcatch.page.cameraview.common.b) this.j);
        if (com.shopee.arcatch.c.d.a.a().i()) {
            this.f26926a.a(640, 480);
        }
        this.i.setProcess(this.j);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        CameraSourcePreview cameraSourcePreview = this.f26927b;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.a();
        }
        this.v.removeCallbacks(this.w);
        com.shopee.arcatch.c.d.b.a().c();
        this.s.c();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f26927b != null) {
            p();
        }
        if (this.p) {
            this.v.postDelayed(this.w, this.r.b());
        }
        com.shopee.arcatch.c.d.b.a().b();
        this.s.d();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        com.shopee.arcatch.c.b.a.c();
        if (!isFinishing()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        com.shopee.arcatch.page.cameraview.common.a aVar = this.f26926a;
        if (aVar != null) {
            aVar.b();
        }
        this.l.a();
        this.s.a(true);
        com.shopee.arcatch.c.d.b.a().d();
        this.v.removeCallbacks(this.w);
        this.y.cancel();
        h();
        com.shopee.arcatch.b.c.a.b();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void p() {
        if (this.f26926a == null) {
            return;
        }
        if (this.f26927b == null) {
            com.garena.android.appkit.d.a.b("resume : Preview is null", new Object[0]);
        } else if (this.f26928c == null) {
            com.garena.android.appkit.d.a.b("resume : GraphicOverlay is null", new Object[0]);
        } else {
            com.shopee.arcatch.b.c.a.a().post(new Runnable() {
                public void run() {
                    try {
                        ArCatchActivity.this.f26927b.a(ArCatchActivity.this.f26926a, ArCatchActivity.this.f26928c);
                        ArCatchActivity.this.v.post(new e(ArCatchActivity.this, (Exception) null));
                    } catch (Exception e2) {
                        ArCatchActivity.this.v.post(new e(ArCatchActivity.this, e2));
                    }
                }
            });
        }
    }

    private static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ArCatchActivity> f26941a;

        /* renamed from: b  reason: collision with root package name */
        private final Exception f26942b;

        protected e(ArCatchActivity arCatchActivity, Exception exc) {
            this.f26941a = new WeakReference<>(arCatchActivity);
            this.f26942b = exc;
        }

        public void run() {
            ArCatchActivity arCatchActivity = (ArCatchActivity) this.f26941a.get();
            if (arCatchActivity != null && !arCatchActivity.isFinishing()) {
                Exception exc = this.f26942b;
                if (exc != null) {
                    arCatchActivity.a(exc);
                } else {
                    arCatchActivity.q();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Exception exc) {
        com.garena.android.appkit.d.a.a(exc);
        com.shopee.arcatch.page.cameraview.common.a aVar = this.f26926a;
        if (aVar != null) {
            aVar.b();
            this.f26926a = null;
        }
        com.shopee.arcatch.c.f.d.c(this);
        finish();
    }

    /* access modifiers changed from: private */
    public void q() {
        CameraSourcePreview cameraSourcePreview = this.f26927b;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 101) {
            return;
        }
        if (i3 == -1) {
            com.shopee.arcatch.c.b.a.a(true);
            com.shopee.arcatch.c.a.b.a().c(true);
            a(i3, intent);
            f();
            return;
        }
        com.shopee.arcatch.c.b.a.a(false);
        com.shopee.arcatch.c.a.b.a().c(false);
        f();
    }

    public void c() {
        this.p = true;
        this.r.a();
        j();
        this.v.postDelayed(this.w, this.r.b());
        this.l.a(com.shopee.arcatch.c.d.a.a().i);
    }

    private void r() {
        com.shopee.arcatch.c.b.e eVar = new com.shopee.arcatch.c.b.e();
        eVar.a(this.h.getBox2dStatistics());
        eVar.a(this.h.getFpsStatus());
        eVar.a(this.j.c());
        eVar.a(this.t);
        eVar.a(this.u);
        eVar.f26748g = Build.MODEL;
        eVar.h = Build.VERSION.SDK_INT;
        com.shopee.arcatch.page.cameraview.common.a aVar = this.f26926a;
        if (aVar != null) {
            eVar.u = aVar.a();
            eVar.v = this.f26926a.e();
            eVar.w = this.f26926a.e();
            eVar.x = this.f26926a.e();
            eVar.y = this.f26926a.e();
        }
        f.a(eVar);
    }

    public void d() {
        com.shopee.arcatch.c.d.b.a().f();
        this.p = false;
        this.v.removeCallbacks(this.w);
        this.y.cancel();
        r();
        this.h.c();
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        if (createFromAsset != null) {
            this.m.setTypeface(createFromAsset);
        }
        this.m.setText(com.shopee.arcatch.c.d.a.a().f26756a);
        this.m.setTextColor(com.shopee.arcatch.c.d.a.a().f26757b);
        this.m.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, a.C0236a.anim_arcatch_coutdown_scale);
        loadAnimation.setRepeatCount(0);
        this.m.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new c(this));
    }

    private static class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ArCatchActivity> f26939a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        protected c(ArCatchActivity arCatchActivity) {
            this.f26939a = new WeakReference<>(arCatchActivity);
        }

        public void onAnimationEnd(Animation animation) {
            ArCatchActivity arCatchActivity = (ArCatchActivity) this.f26939a.get();
            if (arCatchActivity != null && !arCatchActivity.isFinishing()) {
                arCatchActivity.s();
            }
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        boolean z2 = false;
        this.o = new c.a(this).a(false).a();
        this.o.show();
        this.s.a(false);
        if (a((Context) this, this.s.a()) != null) {
            z2 = true;
        }
        b(z2);
    }

    public void a(boolean z2) {
        com.shopee.arcatch.c.b.a.b();
        com.shopee.arcatch.c.a.b.a().b(!z2);
        com.shopee.arcatch.c.d.b.a().a(z2);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @TargetApi(21)
    private void t() {
        com.shopee.arcatch.c.b.a.d();
        this.q = (MediaProjectionManager) getSystemService("media_projection");
        MediaProjectionManager mediaProjectionManager = this.q;
        if (mediaProjectionManager != null) {
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 101);
        }
    }

    @TargetApi(21)
    private void a(int i2, Intent intent) {
        String a2 = com.shopee.arcatch.b.c.f.a();
        File file = new File(a2);
        if ((file.exists() || file.mkdir()) && this.q != null) {
            String str = a2 + File.separator + com.shopee.arcatch.c.d.a.a().j() + "-" + System.currentTimeMillis() + ".mp4";
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            int height = this.f26930e.getHeight();
            Rect rect = new Rect();
            rect.top = height;
            rect.left = 0;
            rect.right = displayMetrics.widthPixels;
            rect.bottom = height + this.f26929d.getHeight();
            com.shopee.arcatch.c.e.a a3 = com.shopee.arcatch.c.e.a.a().a(displayMetrics.widthPixels).b(displayMetrics.heightPixels).a(rect).c(displayMetrics.densityDpi).a(str);
            MediaProjection mediaProjection = this.q.getMediaProjection(i2, intent);
            if (mediaProjection != null) {
                this.s.a(mediaProjection, a3);
                if (this.s.e()) {
                    this.s.b();
                }
            }
        }
    }

    public static Uri a(Context context, String str) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            com.shopee.e.a.a.a((Object) "video path is empty");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.shopee.e.a.a.a((Object) "video file not exist");
            return null;
        }
        long length = file.length();
        if (length < 512000) {
            com.shopee.e.a.a.a((Object) "video file length too small " + length + " deleteSuccess " + file.delete());
            return null;
        }
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("title", file.getName());
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("_data", file.getAbsolutePath());
        try {
            uri = context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.garena.android.appkit.d.a.a(e2);
            uri = null;
        }
        if (uri == null) {
            com.shopee.e.a.a.a((Object) "video insert fail uri is null");
            return null;
        }
        a(context, Uri.fromFile(file));
        return uri;
    }

    private static void a(Context context, Uri uri) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
    }

    private void b(boolean z2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        float score = this.h.getScore();
        String a2 = com.shopee.arcatch.b.c.c.a(score + "|" + currentTimeMillis);
        ConfigBean b2 = com.shopee.arcatch.c.a.b.a().b();
        if (b2 == null || b2.paramsConfigBean == null) {
            com.shopee.e.a.a.b("finish game fail configBean || paramsConfigBean is null", new Object[0]);
            finish();
            return;
        }
        List<PropsBean> list = b2.paramsConfigBean.props;
        HashMap hashMap = new HashMap();
        for (PropsBean next : list) {
            hashMap.put(next.getId(), Float.valueOf(next.getPropValue()));
        }
        ArrayList arrayList = new ArrayList();
        Map<String, Integer> catchedCountMap = this.h.getCatchedCountMap();
        Map<String, Integer> fallingCount = this.h.getFallingCount();
        float score2 = this.h.getScore();
        for (String next2 : catchedCountMap.keySet()) {
            TrackingProp trackingProp = new TrackingProp();
            trackingProp.propId = next2;
            trackingProp.fallingCount = fallingCount.containsKey(next2) ? fallingCount.get(next2).intValue() : 0;
            trackingProp.propValue = ((Float) hashMap.get(next2)).floatValue();
            trackingProp.quantity = (float) catchedCountMap.get(next2).intValue();
            arrayList.add(trackingProp);
        }
        com.shopee.arcatch.c.a.b.a().a(this, z2 ? this.s.a() : null, a2, currentTimeMillis, arrayList, score2, new b(this));
    }

    private static class b extends CommonCallback<EndGameData> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ArCatchActivity> f26938a;

        protected b(ArCatchActivity arCatchActivity) {
            this.f26938a = new WeakReference<>(arCatchActivity);
        }

        public void onSuccess(CommonBean<EndGameData> commonBean) {
            ArCatchActivity arCatchActivity = (ArCatchActivity) this.f26938a.get();
            if (arCatchActivity != null && !arCatchActivity.isFinishing()) {
                if (arCatchActivity.o != null && arCatchActivity.o.isShowing()) {
                    arCatchActivity.o.dismiss();
                }
                arCatchActivity.finish();
            }
        }

        public void onFail(int i, String str) {
            ArCatchActivity arCatchActivity = (ArCatchActivity) this.f26938a.get();
            if (arCatchActivity != null && !arCatchActivity.isFinishing()) {
                if (arCatchActivity.o != null && arCatchActivity.o.isShowing()) {
                    arCatchActivity.o.dismiss();
                }
                arCatchActivity.finish();
            }
        }
    }
}
