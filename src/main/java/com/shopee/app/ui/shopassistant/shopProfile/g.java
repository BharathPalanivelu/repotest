package com.shopee.app.ui.shopassistant.shopProfile;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.ui.product.common.ShopCoverControl2;
import com.shopee.app.ui.shopassistant.d;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean s = false;
    private final c t = new c();

    public g(Context context) {
        super(context);
        o();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.s) {
            this.s = true;
            inflate(getContext(), R.layout.shop_profile_layout, this);
            this.t.a((a) this);
        }
        super.onFinishInflate();
    }

    private void o() {
        c a2 = c.a(this.t);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25511a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f25512b = (ImageView) aVar.internalFindViewById(R.id.cover_view);
        this.f25513c = (MaterialEditText) aVar.internalFindViewById(R.id.nickname);
        this.f25514d = (MaterialEditText) aVar.internalFindViewById(R.id.shop_description);
        this.f25515e = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.post_to_feed);
        this.f25516f = (d) aVar.internalFindViewById(R.id.phone_item);
        this.f25517g = (d) aVar.internalFindViewById(R.id.email_item);
        this.m = (ShopCoverControl2) aVar.internalFindViewById(R.id.product_image_control);
        this.o = aVar.internalFindViewById(R.id.dummy);
        View internalFindViewById = aVar.internalFindViewById(R.id.edit_cover);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.banned_btn);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.c();
                }
            });
        }
        if (this.f25511a != null) {
            this.f25511a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.d();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.f();
                }
            });
        }
        if (this.f25517g != null) {
            this.f25517g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.l();
                }
            });
        }
        if (this.f25516f != null) {
            this.f25516f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.m();
                }
            });
        }
        final TextView textView = (TextView) aVar.internalFindViewById(R.id.nickname);
        if (textView != null) {
            textView.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    g.this.a(textView);
                }
            });
        }
        final TextView textView2 = (TextView) aVar.internalFindViewById(R.id.shop_description);
        if (textView2 != null) {
            textView2.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    g.this.b(textView2);
                }
            });
        }
        a();
    }
}
