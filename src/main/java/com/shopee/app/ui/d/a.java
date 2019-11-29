package com.shopee.app.ui.d;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class a extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    m f21454a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21455b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f21456c;

    /* renamed from: d  reason: collision with root package name */
    HorizontalScrollView f21457d;

    /* renamed from: e  reason: collision with root package name */
    View f21458e;

    /* renamed from: f  reason: collision with root package name */
    final GestureDetector f21459f = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            a.this.performClick();
            return true;
        }
    });

    /* renamed from: g  reason: collision with root package name */
    private List<String> f21460g;
    private int h = 0;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public a(Context context) {
        super(context);
    }

    public void a(int i) {
        if (i != 0) {
            this.f21455b.setTextColor(b.a(R.color.primary));
            int i2 = b.a.k + b.a.f7691b;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.addRule(15);
            layoutParams.leftMargin = b.a.f7693d + b.a.f7691b;
            layoutParams.rightMargin = b.a.f7693d;
            this.f21454a.setLayoutParams(layoutParams);
            this.f21454a.setPadding(0, b.a.f7690a, 0, 0);
            this.f21454a.setColor(com.garena.android.appkit.tools.b.a(R.color.black26));
        }
    }

    public void setTitle(String str) {
        this.f21455b.setVisibility(0);
        this.f21455b.setTextColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f21457d.setVisibility(8);
        this.f21455b.setText(str);
    }

    public void setTitleColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f21455b.setTextColor(Color.parseColor(str));
            } catch (Exception unused) {
            }
        }
    }

    public void setTags(List<String> list) {
        this.f21460g = new ArrayList(list);
        this.f21455b.setVisibility(8);
        this.f21457d.setVisibility(0);
        b();
    }

    public void setSearchText(String str) {
        this.f21455b.setVisibility(0);
        this.f21455b.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f21457d.setVisibility(8);
        this.f21455b.setText(str);
    }

    private void b() {
        this.f21456c.removeAllViews();
        for (String next : this.f21460g) {
            d a2 = e.a(getContext());
            a2.setText(next);
            a2.setTag(next);
            a2.setCrossClickListener(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = b.a.f7693d;
            this.f21456c.addView(a2, layoutParams);
        }
        this.f21456c.addView(new View(getContext()), new LinearLayout.LayoutParams(b.a.t, -1));
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, MotionEvent motionEvent) {
        return this.f21459f.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        this.f21460g.remove((String) view.getTag());
        StringBuilder sb = new StringBuilder();
        for (String next : this.f21460g) {
            if (next.trim().contains(SQLBuilder.BLANK)) {
                sb.append("\"");
                sb.append(next);
                sb.append("\"");
                sb.append(SQLBuilder.BLANK);
            } else {
                sb.append(next);
                sb.append(SQLBuilder.BLANK);
            }
        }
        com.garena.android.appkit.b.b.a("SEARCH_TAG_REMOVED", new com.garena.android.appkit.b.a(sb.toString().trim()), b.a.UI_BUS);
        b();
    }

    public void setStyle(int i) {
        if (this.h != i && i == 1) {
            this.h = i;
            this.f21455b.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
            this.f21458e.setBackgroundResource(R.drawable.search_box_secondary_dark);
            this.f21454a.setColor(com.garena.android.appkit.tools.b.a(R.color.white));
        }
    }
}
