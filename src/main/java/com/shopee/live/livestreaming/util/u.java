package com.shopee.live.livestreaming.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioRecord;
import android.net.Uri;
import android.os.Build;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.t;
import com.shopee.sdk.modules.ui.a.a;
import com.tencent.ugc.TXRecordCommon;
import tencent.tls.platform.SigType;

public class u {

    /* renamed from: a  reason: collision with root package name */
    a f29490a;

    /* renamed from: b  reason: collision with root package name */
    private Context f29491b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f29492c = false;

    public interface a {
        void a();
    }

    public u(Context context) {
        this.f29491b = context;
    }

    public void a(Activity activity, a aVar) {
        if (!this.f29492c) {
            this.f29490a = aVar;
            if (androidx.core.app.a.b((Context) activity, "android.permission.CAMERA") != 0) {
                f(activity);
            } else {
                b(activity);
            }
        }
    }

    public void a(final Activity activity) {
        this.f29492c = true;
        t.a().b(activity, new t.b() {
            public void a(String str) {
                boolean unused = u.this.f29492c = false;
                u.this.b(activity);
            }

            public void a(String str, boolean z) {
                boolean unused = u.this.f29492c = false;
                u.this.a(activity, b.e(c.g.live_streaming_host_preview_camera_permission_setting_title), b.e(c.g.live_streaming_host_preview_camera_permission_desc));
            }
        });
    }

    public void b(final Activity activity) {
        this.f29492c = true;
        t.a().c(activity, new t.b() {
            public void a(String str) {
                boolean unused = u.this.f29492c = false;
                if (u.this.f29490a != null) {
                    u.this.f29490a.a();
                }
            }

            public void a(String str, boolean z) {
                boolean unused = u.this.f29492c = false;
                u.this.a(activity, b.e(c.g.live_streaming_host_preview_microphone_permission_title), b.e(c.g.live_streaming_host_preview_microphone_permission_desc));
            }
        });
    }

    private void f(final Activity activity) {
        this.f29492c = true;
        com.shopee.sdk.b.a().c().a(activity, new a.C0472a().c(b.e(c.g.live_streaming_host_preview_camera_permission_btn_ok)).b(b.e(c.g.live_streaming_host_preview_camera_permission_title)).a(), new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                boolean unused = u.this.f29492c = false;
                int intValue = num.intValue();
                if (intValue == 0) {
                    return;
                }
                if (intValue == 1) {
                    u.this.a(activity);
                }
            }
        });
    }

    public void a(final Activity activity, String str, String str2) {
        this.f29492c = true;
        com.shopee.sdk.b.a().c().a(activity, new a.C0472a().c(b.e(c.g.live_streaming_host_preview_microphone_permission_btn_settings)).a(str).d(b.e(c.g.live_streaming_host_preview_microphone_permission_btn_cancel)).b(str2).a(), new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                boolean unused = u.this.f29492c = false;
                int intValue = num.intValue();
                if (intValue != 0) {
                    if (intValue == 1) {
                        u.e(activity);
                        return;
                    } else if (intValue != 2) {
                        return;
                    }
                }
                activity.finish();
            }
        });
    }

    public boolean c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23 || b()) {
            return true;
        }
        a(activity, b.e(c.g.live_streaming_host_preview_camera_permission_setting_title), b.e(c.g.live_streaming_host_preview_camera_permission_desc));
        return false;
    }

    public boolean d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23 || a()) {
            return true;
        }
        a(activity, b.e(c.g.live_streaming_host_preview_microphone_permission_title), b.e(c.g.live_streaming_host_preview_microphone_permission_desc));
        return false;
    }

    public static void e(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + activity.getPackageName()));
        intent.addFlags(SigType.TLS);
        activity.startActivity(intent);
    }

    public boolean a() {
        AudioRecord audioRecord = new AudioRecord(1, TXRecordCommon.AUDIO_SAMPLERATE_44100, 12, 2, AudioRecord.getMinBufferSize(TXRecordCommon.AUDIO_SAMPLERATE_44100, 12, 2));
        try {
            audioRecord.startRecording();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
        if (audioRecord.getRecordingState() != 3) {
            return false;
        }
        int read = audioRecord.read(new byte[1024], 0, 1024);
        if (read == -3 || read <= 0) {
            return false;
        }
        if (audioRecord.getRecordingState() == 1) {
            return true;
        }
        audioRecord.stop();
        audioRecord.release();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[SYNTHETIC, Splitter:B:10:0x0011] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r2 = this;
            android.hardware.Camera r0 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x000d }
            android.hardware.Camera$Parameters r1 = r0.getParameters()     // Catch:{ Exception -> 0x000e }
            r0.setParameters(r1)     // Catch:{ Exception -> 0x000e }
            r1 = 1
            goto L_0x000f
        L_0x000d:
            r0 = 0
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0019
            r0.release()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.util.u.b():boolean");
    }
}
