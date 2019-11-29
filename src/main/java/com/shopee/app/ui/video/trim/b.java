package com.shopee.app.ui.video.trim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.garena.android.gpns.utility.CONSTANT;
import com.garena.videolib.c.a;
import com.shopee.app.h.f;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.image.j;
import com.shopee.app.ui.video.e;
import com.shopee.app.upload.data.UploadVideo;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import com.squareup.a.w;
import java.io.File;
import life.knowledge4.videotrimmer.K4LVideoTrimmer;
import life.knowledge4.videotrimmer.a.c;
import life.knowledge4.videotrimmer.a.d;

public class b extends FrameLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    K4LVideoTrimmer f25792a;

    /* renamed from: b  reason: collision with root package name */
    Activity f25793b;

    /* renamed from: c  reason: collision with root package name */
    r f25794c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f25795d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public UploadVideo f25796e;

    public b(Context context, String str) {
        super(context);
        this.f25795d = str;
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25794c.a(true);
        String d2 = f.a().d();
        this.f25792a.setTrimmer(new life.knowledge4.videotrimmer.a.e() {
            public void a(File file, String str, long j, long j2, c cVar) {
                UploadVideo unused = b.this.f25796e = new UploadVideo.Builder().startTime((long) ((int) (((float) j) / 1000.0f))).duration((int) (((float) j2) / 1000.0f)).path(file.getPath()).build();
                cVar.a(Uri.fromFile(file));
            }
        });
        K4LVideoTrimmer k4LVideoTrimmer = this.f25792a;
        k4LVideoTrimmer.setHint("↓ " + com.garena.android.appkit.tools.b.e(R.string.sp_label_drag_video));
        this.f25792a.setHintColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f25792a.setPlayProgressColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f25792a.setMaxDuration(1000);
        this.f25792a.setOnTrimVideoListener(this);
        this.f25792a.setDestinationPath(d2);
        this.f25792a.setThumbLoader(new d() {
            public void a(ImageView imageView, K4LVideoTrimmer.b bVar) {
                w a2 = j.a(b.this.getContext());
                a2.a("videothumb://" + b.this.f25795d + "?time=" + bVar.f33742a).b(bVar.f33743b, bVar.f33744c).d().a(imageView);
            }
        });
        this.f25792a.setVideoURI(Uri.parse(this.f25795d));
        long a2 = a.a(getContext(), this.f25795d);
        this.f25792a.setVisibleDurationAndGenerateBitmaps(a2 < 60000 ? (int) a2 : CONSTANT.TIME.MIN_1);
    }

    public void a(final Uri uri) {
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                b.this.f25794c.b();
                Intent intent = new Intent();
                intent.putExtra("trimVideoPath", uri.getPath());
                intent.putExtra("trimVideoData", WebRegister.GSON.b((Object) b.this.f25796e));
                b.this.f25793b.setResult(-1, intent);
                b.this.f25793b.finish();
            }
        });
    }

    public void b() {
        this.f25792a.c();
        this.f25793b.finish();
    }

    public void c() {
        this.f25794c.a();
        this.f25792a.a();
    }
}
