package com.shopee.app.ui.setting.notification2;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.setting.cell.SettingWithSelectionItemView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private final c A = new c();
    private boolean z = false;

    public e(Context context) {
        super(context);
        m();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.z) {
            this.z = true;
            inflate(getContext(), R.layout.notification_setting_layout2, this);
            this.A.a((a) this);
        }
        super.onFinishInflate();
    }

    private void m() {
        c a2 = c.a(this.A);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25279a = aVar.internalFindViewById(R.id.container);
        this.f25280b = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.allow_setting);
        this.f25281c = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.sound_setting);
        this.f25282d = (SettingWithSelectionItemView) aVar.internalFindViewById(R.id.sound_type);
        this.f25283e = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.grouped_notification_setting);
        this.f25284f = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.order_update_notification);
        this.f25285g = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.list_update_notification);
        this.h = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.chat_notification);
        this.i = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.activity_notification);
        this.j = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.shopee_promotion_notification);
        this.k = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.personalised_content);
        this.l = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.rating);
        this.m = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.wallet);
        this.n = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.feed_comment);
        this.o = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.feed_like);
        this.p = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.feed_mention);
        if (this.f25281c != null) {
            this.f25281c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.a(view);
                }
            });
        }
        if (this.f25282d != null) {
            this.f25282d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.b(view);
                }
            });
        }
        if (this.f25280b != null) {
            this.f25280b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.c(view);
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.d(view);
                }
            });
        }
        if (this.f25284f != null) {
            this.f25284f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.e(view);
                }
            });
        }
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.f(view);
                }
            });
        }
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.g(view);
                }
            });
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.h(view);
                }
            });
        }
        if (this.k != null) {
            this.k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.i(view);
                }
            });
        }
        if (this.f25285g != null) {
            this.f25285g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.j(view);
                }
            });
        }
        if (this.f25283e != null) {
            this.f25283e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.k(view);
                }
            });
        }
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.l(view);
                }
            });
        }
        if (this.n != null) {
            this.n.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.j();
                }
            });
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.k();
                }
            });
        }
        if (this.p != null) {
            this.p.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.l();
                }
            });
        }
        a();
    }
}
