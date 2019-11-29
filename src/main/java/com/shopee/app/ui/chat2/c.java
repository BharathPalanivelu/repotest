package com.shopee.app.ui.chat2;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.f;
import com.shopee.app.util.ai;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class c extends RelativeLayout implements n<ChatItem2> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f20398a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f20399b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20400c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20401d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20402e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f20403f;

    /* renamed from: g  reason: collision with root package name */
    f f20404g;
    int h;
    int i;
    int j;
    private boolean k = false;

    public c(Context context, boolean z) {
        super(context);
        this.k = z;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setBackgroundResource(R.drawable.white_background_hightlight);
        this.f20404g.c();
    }

    public void a(ChatItem2 chatItem2) {
        String str;
        z.a(getContext()).a(chatItem2.getAvatar()).a(this.f20398a);
        int offerCount = chatItem2.getOfferCount();
        if (chatItem2.isUserBanned()) {
            this.f20401d.setTextColor(b.a(R.color.primary));
            this.f20401d.setText(b.e(R.string.sp_label_banned));
            this.f20399b.setVisibility(0);
        } else if (chatItem2.isUserDeleted()) {
            this.f20401d.setTextColor(b.a(R.color.primary));
            this.f20401d.setText(b.e(R.string.sp_label_deleted));
            this.f20399b.setVisibility(0);
        } else if (chatItem2.getPreviewStatus() == 2 || chatItem2.getPreviewStatus() == 4) {
            this.f20401d.setTextColor(b.a(R.color.black54));
            this.f20399b.setVisibility(8);
            com.a.a.f b2 = com.a.a.f.a(getContext()).b((int) R.drawable.q_ic_issue).c(this.f20401d.getLineHeight()).a().b();
            b2.a(SQLBuilder.BLANK + chatItem2.getPreviewText()).b().b().a(this.f20401d);
        } else if (offerCount <= 0) {
            this.f20399b.setVisibility(8);
            this.f20401d.setTextColor(b.a(R.color.black54));
            this.f20401d.setText(chatItem2.getPreviewText());
        } else {
            this.f20399b.setVisibility(8);
            this.f20401d.setTextColor(b.a(R.color.primary));
            if (offerCount != 1) {
                str = b.a(R.string.sp_you_have_x_pending_offers, String.valueOf(offerCount));
            } else {
                str = b.e(R.string.sp_you_have_1_pending_offer);
            }
            this.f20401d.setText(str);
        }
        if (chatItem2.isUserBanned()) {
            this.f20400c.setText(b.e(R.string.sp_banned_user));
            this.f20400c.setTextColor(b.a(R.color.black54));
        } else if (chatItem2.isUserDeleted()) {
            this.f20400c.setText(chatItem2.getUsername());
            this.f20400c.setTextColor(b.a(R.color.black54));
        } else {
            this.f20400c.setTextColor(b.a(R.color.black87));
            this.f20400c.setText(chatItem2.getUsername());
        }
        this.f20402e.setText(chatItem2.getTimestamp());
        this.f20404g.setVisibility(chatItem2.getUnreadCount() == 0 ? 4 : 0);
        this.f20404g.setNumber(Integer.valueOf(chatItem2.getUnreadCount()));
        if (TextUtils.isEmpty(chatItem2.getPreviewImage())) {
            this.f20403f.setVisibility(4);
        } else {
            this.f20403f.setVisibility(0);
            if (!chatItem2.getImages().isEmpty()) {
                ai.a(getContext()).a(chatItem2.getImages(), this.f20403f);
            } else if (!chatItem2.getPreviewImage().equals(ChatItem2.BANNED_IMAGE)) {
                z.b(getContext()).a(chatItem2.getPreviewImage()).a(this.f20403f);
            } else {
                this.f20403f.setImageResource(R.drawable.com_garena_shopee_ic_product_default);
            }
        }
        if (!TextUtils.isEmpty(chatItem2.getSearchKeyword()) && this.k) {
            String username = chatItem2.getUsername();
            String searchKeyword = chatItem2.getSearchKeyword();
            this.f20400c.setText(Html.fromHtml(username.replace(searchKeyword, "<font color=#00BFA5>" + chatItem2.getSearchKeyword() + "</font>")));
        }
    }
}
