package com.shopee.app.ui.product.add;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.shopee.app.ui.common.TagEditText2;
import com.shopee.app.ui.common.m;
import com.shopee.app.ui.product.attributes.t;
import com.shopee.app.ui.product.common.ProductImageControl;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class l extends k implements a, b {
    private boolean aD = false;
    private final c aE = new c();

    public l(Context context, long j) {
        super(context, j);
        aa();
    }

    public static k a(Context context, long j) {
        l lVar = new l(context, j);
        lVar.onFinishInflate();
        return lVar;
    }

    public void onFinishInflate() {
        if (!this.aD) {
            this.aD = true;
            inflate(getContext(), R.layout.add_product_layout, this);
            this.aE.a((a) this);
        }
        super.onFinishInflate();
    }

    private void aa() {
        c a2 = c.a(this.aE);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.au = resources.getDimensionPixelSize(R.dimen.dp10);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24082c = (LinearLayout) aVar.internalFindViewById(R.id.add_product_layout);
        this.f24083d = (TagEditText2) aVar.internalFindViewById(R.id.hash_tag_view);
        this.f24084e = aVar.internalFindViewById(R.id.hashtag_panel);
        this.f24085f = (m) aVar.internalFindViewById(R.id.modelIcon);
        this.f24086g = aVar.internalFindViewById(R.id.divider);
        this.h = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.product_category);
        this.i = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.product_condition);
        this.j = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.product_brand);
        this.k = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.product_weight);
        this.l = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.packaging_size);
        this.m = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.product_shipping_fee);
        this.n = (t) aVar.internalFindViewById(R.id.attribute_section);
        this.o = (com.shopee.app.ui.product.common.b) aVar.internalFindViewById(R.id.product_price);
        this.p = (TextView) aVar.internalFindViewById(R.id.hash_tag_warning);
        this.q = (TextView) aVar.internalFindViewById(R.id.product_desc_len_warning);
        this.r = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.product_shipping_days);
        this.s = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.product_stock);
        this.t = (com.shopee.app.ui.product.common.a) aVar.internalFindViewById(R.id.share_fb_page);
        this.u = (LinearLayout) aVar.internalFindViewById(R.id.title_section);
        this.v = (EditText) aVar.internalFindViewById(R.id.add_product_name);
        this.w = (TextView) aVar.internalFindViewById(R.id.add_product_name_len);
        this.x = (RelativeLayout) aVar.internalFindViewById(R.id.twitter_sharing_panel);
        this.y = (CompoundButton) aVar.internalFindViewById(R.id.twitter_sharing_checkbox);
        this.z = (ProductImageControl) aVar.internalFindViewById(R.id.product_image_control);
        this.A = (RelativeLayout) aVar.internalFindViewById(R.id.item_delete_layout);
        this.B = aVar.internalFindViewById(R.id.notice);
        this.C = (TextView) aVar.internalFindViewById(R.id.notice_detail);
        this.D = (TextView) aVar.internalFindViewById(R.id.notice_title);
        this.E = aVar.internalFindViewById(R.id.icArrowRight);
        this.F = (ScrollView) aVar.internalFindViewById(R.id.scroll_view);
        this.G = (LinearLayout) aVar.internalFindViewById(R.id.model_details);
        this.H = aVar.internalFindViewById(R.id.add_model_panel);
        this.I = aVar.internalFindViewById(R.id.variation_divider);
        this.J = (TextView) aVar.internalFindViewById(R.id.variation_help_center);
        this.K = (TextView) aVar.internalFindViewById(R.id.wholesaleInfoView);
        this.L = aVar.internalFindViewById(R.id.wholesaleLayout);
        this.M = (TextView) aVar.internalFindViewById(R.id.wholesaleView);
        this.N = aVar.internalFindViewById(R.id.wholesaleDivTopView);
        this.O = aVar.internalFindViewById(R.id.wholesaleDivBottomView);
        this.P = aVar.internalFindViewById(R.id.wholesaleDesView);
        this.Q = (LinearLayout) aVar.internalFindViewById(R.id.dts_section);
        this.R = (CompoundButton) aVar.internalFindViewById(R.id.pre_order);
        this.S = (TextView) aVar.internalFindViewById(R.id.shipping_description);
        this.T = (TextView) aVar.internalFindViewById(R.id.reminderTextView);
        this.U = aVar.internalFindViewById(R.id.reminderLayout);
        this.V = (TextView) aVar.internalFindViewById(R.id.model_hint);
        this.W = (SwitchCompat) aVar.internalFindViewById(R.id.switchView);
        this.aa = aVar.internalFindViewById(R.id.publishLayout);
        View internalFindViewById = aVar.internalFindViewById(R.id.closeReminder);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.item_delete_btn);
        if (this.y != null) {
            this.y.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.a();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.e();
                }
            });
        }
        if (this.B != null) {
            this.B.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.f();
                }
            });
        }
        if (this.H != null) {
            this.H.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.g();
                }
            });
        }
        if (this.L != null) {
            this.L.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.h();
                }
            });
        }
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.i();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.l();
                }
            });
        }
        if (this.k != null) {
            this.k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.m();
                }
            });
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.n();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.s();
                }
            });
        }
        if (this.t != null) {
            this.t.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.t();
                }
            });
        }
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.u();
                }
            });
        }
        if (this.r != null) {
            this.r.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.v();
                }
            });
        }
        if (this.x != null) {
            this.x.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.w();
                }
            });
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.Y();
                }
            });
        }
        if (this.s != null) {
            this.s.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.Z();
                }
            });
        }
        if (this.v != null) {
            this.v.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return l.this.r();
                }
            });
        }
        if (this.R != null) {
            this.R.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    l.this.a(compoundButton, z);
                }
            });
        }
        j();
    }
}
