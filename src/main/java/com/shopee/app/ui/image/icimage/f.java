package com.shopee.app.ui.image.icimage;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.ui.image.bound.j;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f23015g = false;
    private final c h = new c();

    public f(Context context, String str, PhotoFrameInfo photoFrameInfo, IcCamera3Info icCamera3Info, int i) {
        super(context, str, photoFrameInfo, icCamera3Info, i);
        d();
    }

    public static e a(Context context, String str, PhotoFrameInfo photoFrameInfo, IcCamera3Info icCamera3Info, int i) {
        f fVar = new f(context, str, photoFrameInfo, icCamera3Info, i);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.f23015g) {
            this.f23015g = true;
            inflate(getContext(), R.layout.ic_image_preview_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23000a = (ImageView) aVar.internalFindViewById(R.id.image);
        this.f23001b = (j) aVar.internalFindViewById(R.id.photo_frame_layout);
        this.f23002c = aVar.internalFindViewById(R.id.button_done);
        this.f23003d = (ImageButton) aVar.internalFindViewById(R.id.button_back);
        if (this.f23002c != null) {
            this.f23002c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.b();
                }
            });
        }
        if (this.f23003d != null) {
            this.f23003d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.c();
                }
            });
        }
        a();
    }
}
