package com.shopee.app.ui.gallery;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.garena.videolib.c.a;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.image.j;
import com.shopee.id.R;
import com.squareup.a.aa;
import com.squareup.a.w;
import java.io.File;

public class o extends FrameLayout implements n<GalleryData> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f21983a = ((int) ((((float) b.b()) / 3.0f) * 0.5f));

    /* renamed from: b  reason: collision with root package name */
    ImageView f21984b;

    /* renamed from: c  reason: collision with root package name */
    CheckBox f21985c;

    /* renamed from: d  reason: collision with root package name */
    ViewGroup f21986d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21987e;

    /* renamed from: f  reason: collision with root package name */
    View f21988f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21989g;
    private CompoundButton.OnCheckedChangeListener h;
    private Drawable i = new ColorDrawable(b.a(R.color.secondary));

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public o(Context context, boolean z) {
        super(context);
        this.f21989g = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i2);
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.h = onCheckedChangeListener;
        this.f21985c.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void a(GalleryData galleryData) {
        File file = new File(galleryData.f21838b);
        int i2 = 0;
        if (galleryData.f21839c) {
            w a2 = j.a(getContext());
            aa a3 = a2.a("video://" + galleryData.f21838b).a(this.i);
            int i3 = f21983a;
            a3.b(i3, i3).d().a(this.f21984b);
            this.f21986d.setVisibility(0);
            this.f21987e.setText(a.a(galleryData.f21840d));
        } else if (file.exists()) {
            aa a4 = w.a(getContext()).a(Uri.fromFile(file)).a(this.i);
            int i4 = f21983a;
            a4.b(i4, i4).d().a(this.f21984b);
        } else {
            aa a5 = w.a(getContext()).a(galleryData.f21838b).a(this.i);
            int i5 = f21983a;
            a5.b(i5, i5).d().a(this.f21984b);
        }
        this.f21985c.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f21985c.setChecked(galleryData.f21837a);
        this.f21985c.setOnCheckedChangeListener(this.h);
        this.f21988f.setVisibility(galleryData.a() ? 0 : 8);
        CheckBox checkBox = this.f21985c;
        if (this.f21989g || galleryData.a()) {
            i2 = 8;
        }
        checkBox.setVisibility(i2);
    }
}
