package com.garena.android.uikit.image.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.garena.android.uikit.image.b.b;
import com.garena.android.uikit.image.b.c;
import com.garena.android.uikit.image.b.d;

public class a extends FrameLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f7773a;

    /* renamed from: b  reason: collision with root package name */
    private b f7774b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7775c;

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f7774b = new b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f7774b, layoutParams);
    }

    private void b(Context context) {
        this.f7773a = new ProgressBar(context);
        this.f7773a.setMax(100);
        this.f7773a.setIndeterminate(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.f7773a, layoutParams);
    }

    public ImageView getActualImageView() {
        return this.f7774b;
    }

    public void a() {
        if (this.f7773a == null) {
            b(getContext());
        }
        this.f7773a.setVisibility(0);
        this.f7775c = true;
    }

    public void b() {
        ProgressBar progressBar = this.f7773a;
        if (progressBar != null) {
            progressBar.setVisibility(4);
            this.f7775c = false;
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f7774b.setImageBitmap(bitmap);
        b();
    }

    public void setImageDrawable(Drawable drawable) {
        this.f7774b.setImageDrawable(drawable);
        b();
    }

    public void setImageAsync(c cVar) {
        com.garena.android.uikit.image.b.a aVar = new com.garena.android.uikit.image.b.a(this, cVar);
        this.f7774b.setTag(aVar);
        aVar.a();
    }

    public void setImageAsync(d dVar) {
        this.f7774b.setTag(dVar);
        dVar.a();
    }

    public void setImageOnTapListener(View.OnClickListener onClickListener) {
        this.f7774b.setOnClickListener(onClickListener);
    }

    public void setImageOnLongTapListener(View.OnLongClickListener onLongClickListener) {
        this.f7774b.setOnLongClickListener(onLongClickListener);
    }

    public void c() {
        this.f7774b.setTag((Object) null);
    }

    public void a(Bitmap bitmap) {
        this.f7774b.setTag((Object) null);
        if (bitmap == null || !b.a(bitmap.getWidth(), bitmap.getHeight())) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), new BitmapDrawable(getResources(), bitmap)});
            transitionDrawable.startTransition(400);
            setImageDrawable(transitionDrawable);
            return;
        }
        setImageBitmap(bitmap);
    }

    public void d() {
        d dVar = (d) this.f7774b.getTag();
        if (dVar != null) {
            dVar.b();
        }
    }

    public void e() {
        this.f7774b.a();
    }

    public boolean a(int i) {
        return this.f7774b.canScrollHorizontally(i);
    }
}
