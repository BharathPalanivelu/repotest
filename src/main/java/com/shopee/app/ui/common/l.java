package com.shopee.app.ui.common;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.id.R;
import java.util.List;

public class l implements PopupWindow.OnDismissListener {

    /* renamed from: c  reason: collision with root package name */
    private static final int f21284c = b.a.t;

    /* renamed from: a  reason: collision with root package name */
    private final Context f21285a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f21286b;

    /* renamed from: d  reason: collision with root package name */
    private View f21287d;

    /* renamed from: e  reason: collision with root package name */
    private View f21288e;

    /* renamed from: f  reason: collision with root package name */
    private List<a> f21289f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f21290g;
    private PopupWindow.OnDismissListener h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f21293a;

        /* renamed from: b  reason: collision with root package name */
        public String f21294b;

        /* renamed from: c  reason: collision with root package name */
        public String f21295c;

        /* renamed from: d  reason: collision with root package name */
        public String f21296d;

        /* renamed from: e  reason: collision with root package name */
        public int f21297e;

        /* renamed from: f  reason: collision with root package name */
        public int f21298f;
    }

    public interface b {
        void a(a aVar);
    }

    public l(Context context) {
        this.f21285a = context;
        this.f21286b = new PopupWindow(context);
        this.f21286b.setBackgroundDrawable(new ColorDrawable(com.garena.android.appkit.tools.b.a(R.color.black12)));
        this.f21286b.setOutsideTouchable(false);
        this.f21286b.setTouchable(true);
        this.f21286b.setFocusable(true);
        this.f21286b.setOnDismissListener(this);
        this.f21288e = new View(context);
        this.f21288e.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.black54));
    }

    public void a(List<a> list) {
        this.f21289f = list;
    }

    public void a(b bVar) {
        this.f21290g = bVar;
    }

    public void a(View view) {
        this.f21287d = View.inflate(this.f21285a, R.layout.fancy_popup_layout, (ViewGroup) null);
        this.f21286b.setHeight(-2);
        this.f21286b.setWidth(-2);
        this.f21286b.setOutsideTouchable(true);
        this.f21286b.setTouchable(true);
        this.f21286b.setFocusable(true);
        this.f21286b.setBackgroundDrawable(new BitmapDrawable());
        this.f21286b.setContentView(this.f21287d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        LinearLayout linearLayout = (LinearLayout) this.f21287d.findViewById(R.id.popup_container);
        List<a> list = this.f21289f;
        if (list != null) {
            for (a a2 : list) {
                linearLayout.addView(a(a2));
            }
        }
        this.f21287d.measure(-2, -2);
        int measuredHeight = this.f21287d.getMeasuredHeight();
        int measuredWidth = this.f21287d.getMeasuredWidth();
        int size = this.f21289f.size() - 1;
        for (int i = 0; i < size; i++) {
            View view2 = new View(this.f21285a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(measuredWidth - (b.a.k * 2), 1);
            layoutParams.leftMargin = b.a.k;
            layoutParams.rightMargin = b.a.k;
            view2.setLayoutParams(layoutParams);
            view2.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white54));
            linearLayout.addView(view2, (i * 2) + 1);
        }
        int centerX = rect.centerX() - (measuredWidth / 2);
        int height = rect.bottom - (rect.height() / 2);
        double d2 = (double) measuredHeight;
        Double.isNaN(d2);
        if (((double) (com.garena.android.appkit.tools.b.d() - height)) < d2 * 1.5d) {
            height = (rect.top - measuredHeight) - (rect.height() / 2);
            ((ImageView) this.f21287d.findViewById(R.id.tooltip_nav_up)).setVisibility(8);
        } else {
            ((ImageView) this.f21287d.findViewById(R.id.tooltip_nav_down)).setVisibility(8);
        }
        this.f21286b.showAtLocation(view, 0, centerX, height);
    }

    public void a(View view, float f2, float f3) {
        this.f21287d = View.inflate(this.f21285a, R.layout.fancy_popup_layout, (ViewGroup) null);
        this.f21286b.setHeight(-2);
        this.f21286b.setWidth(-1);
        this.f21286b.setOutsideTouchable(true);
        this.f21286b.setTouchable(true);
        this.f21286b.setFocusable(true);
        this.f21286b.setBackgroundDrawable(new BitmapDrawable());
        this.f21286b.setContentView(this.f21287d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        LinearLayout linearLayout = (LinearLayout) this.f21287d.findViewById(R.id.popup_container);
        List<a> list = this.f21289f;
        if (list != null) {
            for (a a2 : list) {
                linearLayout.addView(a(a2));
            }
        }
        this.f21287d.measure(-2, -2);
        int measuredHeight = this.f21287d.getMeasuredHeight();
        int centerX = rect.centerX() - (this.f21287d.getMeasuredWidth() / 2);
        int d2 = ((int) (((float) ((com.garena.android.appkit.tools.b.d() - com.garena.android.appkit.tools.b.d(R.dimen.action_bar_height)) - b.a.m)) * f3)) + com.garena.android.appkit.tools.b.d(R.dimen.action_bar_height) + b.a.m;
        double d3 = (double) measuredHeight;
        Double.isNaN(d3);
        if (((double) (com.garena.android.appkit.tools.b.d() - d2)) < d3 * 1.5d) {
            d2 = (d2 - measuredHeight) - b.a.m;
            ((ImageView) this.f21287d.findViewById(R.id.tooltip_nav_up)).setVisibility(8);
        } else {
            ((ImageView) this.f21287d.findViewById(R.id.tooltip_nav_down)).setVisibility(8);
        }
        this.f21286b.showAtLocation(view, 0, centerX, d2);
    }

    private View a(final a aVar) {
        View inflate = View.inflate(this.f21285a, R.layout.fancy_popup_item_layout2, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.title)).setText(aVar.f21294b);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (l.this.f21290g != null) {
                    l.this.f21290g.a(aVar);
                }
                l.this.f21286b.dismiss();
            }
        });
        return inflate;
    }

    public void onDismiss() {
        PopupWindow.OnDismissListener onDismissListener = this.h;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.h = onDismissListener;
    }
}
