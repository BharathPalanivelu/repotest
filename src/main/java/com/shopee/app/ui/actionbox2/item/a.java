package com.shopee.app.ui.actionbox2.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class a extends LinearLayout implements n<ActionContentInfo> {

    /* renamed from: a  reason: collision with root package name */
    RobotoTextView f19431a;

    /* renamed from: b  reason: collision with root package name */
    RobotoTextView f19432b;

    /* renamed from: c  reason: collision with root package name */
    RobotoTextView f19433c;

    /* renamed from: d  reason: collision with root package name */
    View f19434d;

    public a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_child_action, this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.bg_color_background_highlight);
    }

    public void a(ActionContentInfo actionContentInfo) {
        this.f19431a.setText(actionContentInfo.getTitle());
        this.f19432b.setText(actionContentInfo.getContent());
        this.f19433c.setText(com.garena.android.appkit.tools.a.a.a(actionContentInfo.getCreateTime(), "ID"));
    }
}
