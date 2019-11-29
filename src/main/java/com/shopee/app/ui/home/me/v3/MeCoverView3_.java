package com.shopee.app.ui.home.me.v3;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.home.me.MeCoverImageView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class MeCoverView3_ extends a implements a, b {
    private boolean E = false;
    private final c F = new c();

    public MeCoverView3_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        i();
    }

    public MeCoverView3_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    public MeCoverView3_(Context context) {
        super(context);
        i();
    }

    public void onFinishInflate() {
        if (!this.E) {
            this.E = true;
            inflate(getContext(), R.layout.me_cover_layout3, this);
            this.F.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.F);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.s = resources.getString(R.string.sp_s_followers3);
        this.t = resources.getString(R.string.sp_1_follower3);
        this.u = resources.getString(R.string.sp_s_following3);
        this.v = resources.getString(R.string.sp_1_following3);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22479g = (MeCoverImageView) aVar.internalFindViewById(R.id.cover_view);
        this.h = aVar.internalFindViewById(R.id.overlay);
        this.i = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.j = (ImageView) aVar.internalFindViewById(R.id.shopee_type);
        this.k = (TextView) aVar.internalFindViewById(R.id.shop_name);
        this.l = (Button) aVar.internalFindViewById(R.id.btnLogin);
        this.m = (Button) aVar.internalFindViewById(R.id.btnSignup);
        this.n = (TextView) aVar.internalFindViewById(R.id.followers);
        this.o = (TextView) aVar.internalFindViewById(R.id.following);
        this.p = aVar.internalFindViewById(R.id.separator);
        this.q = aVar.internalFindViewById(R.id.sell_entry);
        this.r = (TextView) aVar.internalFindViewById(R.id.sell_entry_text);
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MeCoverView3_.this.b(view);
                }
            });
            this.l.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    MeCoverView3_.this.c();
                    return true;
                }
            });
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MeCoverView3_.this.c(view);
                }
            });
        }
        if (this.n != null) {
            this.n.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MeCoverView3_.this.d(view);
                }
            });
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MeCoverView3_.this.e(view);
                }
            });
        }
        if (this.q != null) {
            this.q.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MeCoverView3_.this.f(view);
                }
            });
        }
        b();
    }
}
