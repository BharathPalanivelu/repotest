package com.shopee.app.ui.actionbox2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.actionbox2.item.d;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean B = false;
    private final c C = new c();

    public b(Context context) {
        super(context);
        s();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.B) {
            this.B = true;
            inflate(getContext(), R.layout.action_box_header, this);
            this.C.a((a) this);
        }
        super.onFinishInflate();
    }

    private void s() {
        c a2 = c.a(this.C);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19358a = (TextView) aVar.internalFindViewById(R.id.read_all);
        this.f19359b = aVar.internalFindViewById(R.id.divider);
        this.f19360c = aVar.internalFindViewById(R.id.emptyView);
        this.f19361d = aVar.internalFindViewById(R.id.read_all_layout);
        this.f19362e = (d) aVar.internalFindViewById(R.id.activity);
        this.f19363f = (d) aVar.internalFindViewById(R.id.social);
        this.f19364g = (d) aVar.internalFindViewById(R.id.shopUpdates);
        this.h = (d) aVar.internalFindViewById(R.id.paid_ads);
        this.i = (d) aVar.internalFindViewById(R.id.wallet);
        this.j = (d) aVar.internalFindViewById(R.id.updates);
        this.k = (d) aVar.internalFindViewById(R.id.promotion);
        this.l = (d) aVar.internalFindViewById(R.id.ratings);
        this.m = (d) aVar.internalFindViewById(R.id.foody);
        this.n = (d) aVar.internalFindViewById(R.id.discussMsg);
        this.o = aVar.internalFindViewById(R.id.xiaomi_section);
        this.p = (ImageView) aVar.internalFindViewById(R.id.xiaomi_cross);
        this.q = (TextView) aVar.internalFindViewById(R.id.xiaomi_notification_info);
        this.r = (d) aVar.internalFindViewById(R.id.payLater);
        View internalFindViewById = aVar.internalFindViewById(R.id.shopping_cart_btn);
        if (this.f19362e != null) {
            this.f19362e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.b();
                }
            });
        }
        if (this.f19364g != null) {
            this.f19364g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.c();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.d();
                }
            });
        }
        if (this.f19363f != null) {
            this.f19363f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.e();
                }
            });
        }
        if (this.k != null) {
            this.k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.f();
                }
            });
        }
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.g();
                }
            });
        }
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.h();
                }
            });
        }
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.i();
                }
            });
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.j();
                }
            });
        }
        if (this.n != null) {
            this.n.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.k();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.l();
                }
            });
        }
        if (this.f19358a != null) {
            this.f19358a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.m();
                }
            });
        }
        if (this.q != null) {
            this.q.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.o();
                }
            });
        }
        if (this.p != null) {
            this.p.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.p();
                }
            });
        }
        if (this.r != null) {
            this.r.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.q();
                }
            });
        }
        a();
    }
}
