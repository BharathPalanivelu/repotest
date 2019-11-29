package com.shopee.arcatch.page.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import com.shopee.arcatch.a;
import com.shopee.arcatch.b.a.a;
import com.shopee.arcatch.b.c.g;
import com.shopee.arcatch.c.a.b;
import com.shopee.arcatch.c.d.c;
import com.shopee.arcatch.c.d.d;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.page.view.ArCatchFaceMatchView;
import com.shopee.arcatch.page.view.ArCatchGuideView;
import com.shopee.arcatch.page.view.ArCatchTitleBar;

public class FaceMatchActivity extends a {

    /* renamed from: a  reason: collision with root package name */
    private ArCatchTitleBar f26950a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ViewFlipper f26951b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArCatchGuideView f26952c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArCatchFaceMatchView f26953d;

    public String a() {
        return "FaceMatchActivity";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ConfigBean b2 = b.a().b();
        if (b2 == null || b2.imageConfigBean == null || b2.paramsConfigBean == null) {
            com.shopee.e.a.a.b("FaceMatchActivity ConfigBean invalid", new Object[0]);
            finish();
            return;
        }
        setContentView(a.d.arcatch_activity_facematch);
        d.a().a(b2.paramsConfigBean.eventId);
        this.f26950a = (ArCatchTitleBar) findViewById(a.c.arcatch_newbie_titlebar);
        this.f26950a.setBackOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FaceMatchActivity.this.finish();
            }
        });
        this.f26950a.a(b2.textConfigBean.title);
        g.a((View) this.f26950a);
        g.a(getWindow());
        this.f26951b = (ViewFlipper) findViewById(a.c.arcatch_fm_flipper);
        this.f26952c = (ArCatchGuideView) findViewById(a.c.arcatch_guide_guide);
        this.f26953d = (ArCatchFaceMatchView) findViewById(a.c.arcatch_face_match);
        this.f26951b.setInAnimation(AnimationUtils.loadAnimation(this, a.C0236a.arcatch_fm_fade_in));
        this.f26951b.setOutAnimation(AnimationUtils.loadAnimation(this, a.C0236a.arcatch_fm_fade_out));
        this.f26952c.setOnPageFinishListener(new ArCatchGuideView.a() {
            public void a() {
                FaceMatchActivity.this.f26951b.setDisplayedChild(1);
                FaceMatchActivity.this.f26953d.a();
            }
        });
        this.f26953d.a((Activity) this);
        this.f26952c.post(new Runnable() {
            public void run() {
                c.a().a(FaceMatchActivity.this.getApplicationContext(), FaceMatchActivity.this.f26952c.getWidth(), FaceMatchActivity.this.f26952c.getHeight());
            }
        });
        this.f26953d.setOnFaceMatchFinishListener(new ArCatchFaceMatchView.a() {
            public void a() {
                com.shopee.arcatch.c.f.d.b(FaceMatchActivity.this);
                FaceMatchActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f26951b.getDisplayedChild() == 1) {
            this.f26953d.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.f26951b.getDisplayedChild() == 1) {
            this.f26953d.b();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ArCatchFaceMatchView arCatchFaceMatchView = this.f26953d;
        if (arCatchFaceMatchView != null) {
            arCatchFaceMatchView.c();
        }
        super.onDestroy();
    }
}
