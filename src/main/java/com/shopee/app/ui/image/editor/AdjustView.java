package com.shopee.app.ui.image.editor;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.shopee.app.ui.image.editor.d.d;
import com.shopee.app.util.l;
import com.shopee.id.R;

public class AdjustView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22837a = Color.parseColor(l.w);

    /* renamed from: b  reason: collision with root package name */
    private ImageButton f22838b;

    /* renamed from: c  reason: collision with root package name */
    private ImageButton f22839c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f22840d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public SeekBar f22841e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22842f;

    /* renamed from: g  reason: collision with root package name */
    private i f22843g;
    /* access modifiers changed from: private */
    public View.OnClickListener h;
    /* access modifiers changed from: private */
    public View.OnClickListener i;
    /* access modifiers changed from: private */
    public a j;
    private Context k;
    private SeekBar.OnSeekBarChangeListener l = new SeekBar.OnSeekBarChangeListener() {
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            AdjustView.this.a(i);
            if (AdjustView.this.j != null) {
                AdjustView.this.j.a(seekBar, i, z);
            }
        }
    };

    public interface a {
        void a(SeekBar seekBar, int i, boolean z);
    }

    public AdjustView(Context context) {
        super(context);
        a(context);
    }

    public AdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AdjustView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        inflate(context, R.layout.adjust_view_layout, this);
        this.k = getContext();
        this.f22840d = (FrameLayout) findViewById(R.id.seekbarContainer);
        this.f22841e = (SeekBar) findViewById(R.id.seekbar);
        this.f22841e.setOnSeekBarChangeListener(this.l);
        this.f22842f = (TextView) findViewById(R.id.textSeekbarValue);
        this.f22842f.setVisibility(4);
        this.f22843g = (i) findViewById(R.id.subMenu);
        this.f22838b = (ImageButton) findViewById(R.id.ok);
        this.f22838b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (AdjustView.this.h != null) {
                    AdjustView.this.h.onClick(view);
                }
                AdjustView.this.setVisibility(8);
            }
        });
        ImageButton imageButton = this.f22838b;
        imageButton.setOnTouchListener(new com.shopee.app.ui.image.editor.d.a(imageButton, f22837a));
        this.f22839c = (ImageButton) findViewById(R.id.cancel);
        this.f22839c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (AdjustView.this.i != null) {
                    AdjustView.this.i.onClick(view);
                }
                AdjustView.this.setVisibility(8);
            }
        });
        ImageButton imageButton2 = this.f22839c;
        imageButton2.setOnTouchListener(new com.shopee.app.ui.image.editor.d.a(imageButton2, f22837a));
        this.j = null;
    }

    public void a() {
        this.f22840d.setVisibility(0);
        this.f22843g.setVisibility(8);
    }

    public void b() {
        this.f22840d.setVisibility(4);
    }

    public void c() {
        this.f22840d.setVisibility(4);
        this.f22843g.setVisibility(0);
    }

    public i getSubMenu() {
        return this.f22843g;
    }

    public void d() {
        this.f22843g.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        this.f22842f.setVisibility(0);
        this.f22842f.setText(String.valueOf(i2));
        int a2 = d.a(30, this.k);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, -2);
        layoutParams.setMargins((((i2 * ((this.f22841e.getWidth() - this.f22841e.getPaddingLeft()) - this.f22841e.getPaddingRight())) / this.f22841e.getMax()) + this.f22841e.getPaddingLeft()) - (a2 / 2), d.a(5, this.k), 0, 0);
        this.f22842f.setLayoutParams(layoutParams);
        this.f22842f.requestLayout();
    }

    public void setProgressChangeListener(a aVar) {
        this.j = aVar;
    }

    public void setOnOkClickListener(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void setSeekPosition(final int i2) {
        if (this.f22841e.getWidth() == 0) {
            post(new Runnable() {
                public void run() {
                    AdjustView.this.f22841e.setProgress(i2);
                }
            });
        } else {
            this.f22841e.setProgress(i2);
        }
    }
}
