package com.shopee.live.livestreaming.ui.forbidden;

import a.h;
import a.k;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.x;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.app.a.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

public class LiveStreamingForbiddenZoneActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f29087a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f29088b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f29089c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f29090d;

    static /* synthetic */ int a(LiveStreamingForbiddenZoneActivity liveStreamingForbiddenZoneActivity) {
        int i = liveStreamingForbiddenZoneActivity.f29090d;
        liveStreamingForbiddenZoneActivity.f29090d = i + 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.f.live_streaming_activity_forbidden_zone);
        a();
    }

    private void a() {
        this.f29087a = (ImageView) findViewById(c.e.iv_close_btn);
        this.f29087a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LiveStreamingForbiddenZoneActivity.this.finish();
            }
        });
        this.f29089c = (TextView) findViewById(c.e.tv_shopee_info);
        this.f29089c.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n"})
            public void onClick(View view) {
                if (!"live".equals(x.b())) {
                    LiveStreamingForbiddenZoneActivity.a(LiveStreamingForbiddenZoneActivity.this);
                    if (LiveStreamingForbiddenZoneActivity.this.f29090d == 10) {
                        a a2 = b.a().a().a();
                        com.shopee.sdk.modules.app.e.a a3 = b.a().d().a();
                        LiveStreamingForbiddenZoneActivity.this.f29089c.setTextIsSelectable(true);
                        TextView c2 = LiveStreamingForbiddenZoneActivity.this.f29089c;
                        c2.setText("AppDeviceID: " + a2.b() + "\nAppDeviceName: " + a2.g() + "\nUserName: " + a3.c() + "\nUserId: " + a3.a() + "\nAvatar: " + a3.d() + "\nShopeId: " + a3.b());
                    }
                }
            }
        });
        this.f29088b = (TextView) findViewById(c.e.tv_version_info);
        b();
    }

    private void b() {
        k.a(new Callable<String>() {
            /* renamed from: a */
            public String call() throws Exception {
                try {
                    return LiveStreamingForbiddenZoneActivity.this.a(com.shopee.live.livestreaming.b.b().f28742b.getAssets().open("versions_livestreaming.txt"));
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }).a(new h<String, Void>() {
            /* renamed from: a */
            public Void then(k<String> kVar) throws Exception {
                LiveStreamingForbiddenZoneActivity.this.f29088b.setText(kVar.f());
                return null;
            }
        }, k.f377b);
    }

    /* access modifiers changed from: private */
    public String a(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        if (Build.VERSION.SDK_INT >= 19) {
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        } else {
            try {
                inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                inputStreamReader = null;
            }
        }
        if (inputStreamReader == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
                stringBuffer.append("\n");
            } catch (IOException e3) {
                com.shopee.e.a.a.a(e3, "", new Object[0]);
            }
        }
        return stringBuffer.toString();
    }
}
