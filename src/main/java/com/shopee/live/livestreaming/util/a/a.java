package com.shopee.live.livestreaming.util.a;

import android.content.Context;
import java.io.File;

public class a {

    /* renamed from: a  reason: collision with root package name */
    d f29368a;

    /* renamed from: b  reason: collision with root package name */
    d f29369b;

    /* renamed from: c  reason: collision with root package name */
    private Context f29370c;

    public a(Context context) {
        this.f29370c = context;
        this.f29368a = new d(context, "anchor_bitrate");
        this.f29369b = new d(context, "anchor_txlog");
    }

    public void a(int i) {
        this.f29368a.a(i);
        this.f29369b.a(i);
    }

    public void a(File file) {
        try {
            this.f29368a.a(file);
            this.f29369b.a(file);
        } catch (Exception unused) {
        }
    }

    public void a(String str) {
        try {
            if (this.f29368a != null) {
                this.f29368a.a(str);
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        try {
            if (this.f29369b != null) {
                this.f29369b.a(str);
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        this.f29368a.a();
        this.f29369b.a();
    }
}
