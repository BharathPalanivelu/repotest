package com.shopee.app.ui.actionbox.actionrequired;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.af;
import com.shopee.app.util.ai;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class a extends LinearLayout implements n<ActionContentInfo> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f19340a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f19341b;

    /* renamed from: c  reason: collision with root package name */
    TextView f19342c;

    /* renamed from: d  reason: collision with root package name */
    TextView f19343d;

    /* renamed from: e  reason: collision with root package name */
    TextView f19344e;

    /* renamed from: f  reason: collision with root package name */
    c f19345f;

    /* renamed from: g  reason: collision with root package name */
    View f19346g;
    ImageView h;
    ProgressWheel i;
    View j;

    public a(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.i.setLinearProgress(true);
    }

    public void a(ActionContentInfo actionContentInfo) {
        if (actionContentInfo.isUnread()) {
            setBackgroundResource(R.drawable.activity_item_unread_background);
        } else {
            setBackgroundResource(R.drawable.activity_item_background);
        }
        if (!TextUtils.isEmpty(actionContentInfo.getContent())) {
            this.f19344e.setText(actionContentInfo.getContent());
        }
        this.f19343d.setText(com.garena.android.appkit.tools.a.a.a(actionContentInfo.getCreateTime(), "ID"));
        if (!TextUtils.isEmpty(actionContentInfo.getTitle())) {
            this.f19342c.setText(actionContentInfo.getTitle());
            this.f19342c.setVisibility(0);
        } else {
            this.f19342c.setVisibility(8);
        }
        if (actionContentInfo.ratingIsNotDefaultOrShown()) {
            this.f19345f.a(actionContentInfo.getShowRatingStatus(), true);
            setVisibilityToRatingPanel(0);
        } else {
            setVisibilityToRatingPanel(8);
        }
        if (actionContentInfo.getGroupedCount() <= 1) {
            this.h.setVisibility(4);
        } else {
            this.h.setVisibility(0);
        }
        if (actionContentInfo.getActionCategory() == 10) {
            b(actionContentInfo);
        } else if (!af.a(actionContentInfo.getImages())) {
            ai.a(getContext()).a(actionContentInfo.getImages(), this.f19340a);
        }
    }

    private void setVisibilityToRatingPanel(int i2) {
        this.f19345f.setVisibility(i2);
    }

    private void b(ActionContentInfo actionContentInfo) {
        this.f19340a.setBackground(b.f(R.drawable.default_avatar));
        this.f19340a.setImageDrawable((Drawable) null);
        this.j.setVisibility(8);
        if (!TextUtils.isEmpty(actionContentInfo.getAvatarImage())) {
            z.a(getContext()).a(actionContentInfo.getAvatarImage()).a(this.f19340a);
        }
        if (!af.a(actionContentInfo.getImages())) {
            ai.a(getContext()).a(actionContentInfo.getImages(), this.f19341b);
            this.f19341b.setVisibility(0);
            this.f19344e.setPadding(0, 0, 0, b.a.f7693d);
            return;
        }
        this.f19341b.setVisibility(8);
        this.f19344e.setPadding(0, 0, b.a.k, b.a.f7693d);
    }
}
