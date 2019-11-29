package com.shopee.app.ui.product.rating;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;

public class j extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24772a = true;

    /* renamed from: b  reason: collision with root package name */
    m f24773b;

    /* renamed from: c  reason: collision with root package name */
    View f24774c;

    /* renamed from: d  reason: collision with root package name */
    View f24775d;

    /* renamed from: e  reason: collision with root package name */
    RobotoTextView f24776e;

    /* renamed from: f  reason: collision with root package name */
    AvatarView f24777f;

    /* renamed from: g  reason: collision with root package name */
    RobotoTextView f24778g;
    LinearLayout h;
    RobotoTextView i;
    private boolean j;
    private a k;

    public interface a {
        void e();
    }

    public j(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24776e.setMovementMethod(new ScrollingMovementMethod());
        this.f24776e.setMaxHeight(b.d() / 4);
        this.f24773b.setOnClickListener(this);
        this.f24774c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        if (f24772a) {
            b();
        } else {
            c();
        }
    }

    public void setData(ItemCommentInfo itemCommentInfo) {
        a(this.f24777f, itemCommentInfo);
        this.f24778g.setText(itemCommentInfo.getUserName());
        a(this.h, itemCommentInfo.getRatingStar());
        a(itemCommentInfo);
        b(itemCommentInfo);
    }

    private void a(ItemCommentInfo itemCommentInfo) {
        CharSequence charSequence;
        if (!itemCommentInfo.isHidden()) {
            charSequence = itemCommentInfo.getDisplayString();
        } else if (itemCommentInfo.isOwnerComment()) {
            charSequence = getResources().getString(R.string.sp_comment_seller_hidden);
        } else {
            charSequence = getResources().getString(R.string.sp_comment_buyer_hidden);
        }
        this.f24776e.setText(charSequence);
        this.f24776e.setVisibility(TextUtils.isEmpty(itemCommentInfo.getDisplayString()) ? 8 : 0);
    }

    private void b(ItemCommentInfo itemCommentInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.garena.android.appkit.tools.a.a.a(itemCommentInfo.getCTime(), "ID"));
        if (itemCommentInfo.getVariationName() != null) {
            sb.append("   |   Variation: ");
            sb.append(itemCommentInfo.getVariationName());
        }
        this.i.setText(sb.toString());
    }

    public void setToggleListener(a aVar) {
        this.k = aVar;
    }

    public void b() {
        this.j = true;
        f24772a = true;
        this.f24773b.setImageResource(R.drawable.com_garena_shopee_ic_arrow_down);
        this.f24773b.setColor(-1);
    }

    public void c() {
        this.j = false;
        f24772a = false;
        this.f24773b.setImageResource(R.drawable.com_garena_shopee_ic_arrow_up);
        this.f24773b.setColor(-1);
    }

    public void d() {
        if (this.j) {
            c();
            this.f24774c.animate().translationYBy((float) this.f24775d.getHeight()).start();
            return;
        }
        b();
        this.f24774c.animate().translationYBy((float) (-this.f24775d.getHeight())).start();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f24775d.getMeasuredHeight() != 0 && !f24772a) {
            this.f24774c.setTranslationY((float) this.f24775d.getMeasuredHeight());
        }
    }

    public void onClick(View view) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.e();
        }
    }

    public static void a(AvatarView avatarView, ItemCommentInfo itemCommentInfo) {
        avatarView.a(itemCommentInfo.getUserId(), itemCommentInfo.getUserPortrait());
        avatarView.setAnonymous(itemCommentInfo.isAnonymous());
    }

    public static void a(LinearLayout linearLayout, int i2) {
        linearLayout.removeAllViews();
        int i3 = b.a.f7695f;
        int i4 = b.a.f7690a;
        int i5 = 1;
        while (i5 <= 5) {
            ImageView imageView = new ImageView(linearLayout.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            if (i5 == 1) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(i4 * 2, 0, 0, 0);
            }
            imageView.setImageResource(i5 > i2 ? R.drawable.ic_rating_score_hollow : R.drawable.ic_rating_score_solid);
            linearLayout.addView(imageView, layoutParams);
            i5++;
        }
    }
}
