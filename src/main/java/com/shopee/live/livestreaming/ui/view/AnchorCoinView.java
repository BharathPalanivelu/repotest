package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.AnchorCoinEntity;
import com.shopee.live.livestreaming.util.w;

public class AnchorCoinView extends RobotoTextView {

    /* renamed from: a  reason: collision with root package name */
    private a f29098a;

    public interface a {
        void h();

        void i();
    }

    public AnchorCoinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnchorCoinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnchorCoinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setCompoundDrawablePadding((int) w.a(context, 4.0f));
    }

    public void setViewVisibilityCallback(a aVar) {
        this.f29098a = aVar;
    }

    public void a(AnchorCoinEntity anchorCoinEntity) {
        Drawable drawable;
        if (anchorCoinEntity == null) {
            setVisibility(8);
            this.f29098a.i();
        } else if (anchorCoinEntity.getShown_coins() == 0 || anchorCoinEntity.getCoin_status() == 1) {
            setVisibility(8);
            this.f29098a.i();
        } else {
            setVisibility(0);
            int claims_left = anchorCoinEntity.getClaims_left();
            if (claims_left < 0) {
                claims_left = 0;
            }
            if (claims_left == 0) {
                drawable = getContext().getResources().getDrawable(c.d.live_streaming_coin_status);
            } else {
                drawable = getContext().getResources().getDrawable(c.d.live_streaming_anchor_coin);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            setText(String.format(b.e(c.g.live_streaming_host_cic_total_coins_claimed), new Object[]{String.valueOf(anchorCoinEntity.getGiveout())}) + "\n" + String.format(b.e(c.g.live_streaming_host_cic_times_left), new Object[]{String.valueOf(claims_left)}));
            this.f29098a.h();
        }
    }
}
