package com.shopee.arcatch.c.e;

import android.annotation.TargetApi;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.text.TextUtils;
import com.shopee.arcatch.c.e.a.a;
import com.shopee.arcatch.c.e.a.c;
import com.shopee.arcatch.c.e.a.d;
import java.io.File;

@TargetApi(21)
public class b {

    /* renamed from: a  reason: collision with root package name */
    private MediaProjection f26815a;

    /* renamed from: b  reason: collision with root package name */
    private a f26816b;

    /* renamed from: c  reason: collision with root package name */
    private c f26817c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26818d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26819e;

    public String a() {
        a aVar = this.f26816b;
        return aVar == null ? "" : aVar.b();
    }

    public void a(MediaProjection mediaProjection, a aVar) {
        if (mediaProjection == null || !a(aVar)) {
            throw new IllegalArgumentException("init param illegal");
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f26815a = mediaProjection;
            this.f26816b = aVar;
            this.f26818d = true;
        } else {
            throw new RuntimeException("sdk version must > LOLLIPOP(21)");
        }
    }

    private boolean a(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.b()) && aVar.c() > 0 && aVar.d() > 0 && aVar.f() > 0) {
            return true;
        }
        return false;
    }

    private void f() {
        a aVar = this.f26816b;
        if (aVar != null) {
            String b2 = aVar.b();
            if (!TextUtils.isEmpty(b2)) {
                File file = new File(b2);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public boolean b() {
        if (!this.f26818d) {
            throw new RuntimeException("please init first");
        } else if (this.f26819e) {
            return false;
        } else {
            try {
                this.f26817c = new c(a());
                new d.a().a(this.f26815a).a(this.f26817c).a(this.f26816b.c()).b(this.f26816b.d()).a(this.f26816b.e()).c(640).d(640).e(this.f26816b.f()).f(1572864).g(this.f26816b.g()).a();
                new a(this.f26817c);
                this.f26817c.a();
                this.f26819e = true;
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                com.shopee.e.a.a.a(e2, "RecordScreenManager-start failed", new Object[0]);
                return false;
            }
        }
    }

    public boolean c() {
        if (this.f26819e && this.f26818d) {
            try {
                if (this.f26817c == null) {
                    return true;
                }
                this.f26817c.c();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                com.shopee.e.a.a.a(e2, "RecordScreenManager-pause failed", new Object[0]);
            }
        }
        return false;
    }

    public boolean d() {
        if (this.f26819e && this.f26818d) {
            try {
                if (this.f26817c == null) {
                    return true;
                }
                this.f26817c.d();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                com.shopee.e.a.a.a(e2, "RecordScreenManager-resume failed", new Object[0]);
            }
        }
        return false;
    }

    public boolean a(boolean z) {
        if (!this.f26819e) {
            return false;
        }
        this.f26819e = false;
        try {
            if (this.f26817c == null) {
                return true;
            }
            this.f26817c.b();
            if (!z) {
                return true;
            }
            f();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            com.shopee.e.a.a.a(e2, "RecordScreenManager-stop failed", new Object[0]);
            return false;
        }
    }

    public boolean e() {
        return this.f26818d;
    }
}
