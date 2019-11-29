package com.shopee.app.ui.home.me.editprofile;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {
    private boolean v = false;
    private final c w = new c();

    public i(Context context) {
        super(context);
        s();
    }

    public static h a(Context context) {
        i iVar = new i(context);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.v) {
            this.v = true;
            inflate(getContext(), R.layout.edit_profile_layout, this);
            this.w.a((a) this);
        }
        super.onFinishInflate();
    }

    private void s() {
        c a2 = c.a(this.w);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22381a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f22382b = (ImageView) aVar.internalFindViewById(R.id.cover_view);
        this.f22383c = (MaterialEditText) aVar.internalFindViewById(R.id.user_name);
        this.j = aVar.internalFindViewById(R.id.dummy);
        this.k = (EditProfileItemView) aVar.internalFindViewById(R.id.name_item);
        this.l = (EditProfileItemView) aVar.internalFindViewById(R.id.bio_item);
        this.m = (EditProfileItemView) aVar.internalFindViewById(R.id.change_password);
        this.n = (EditText) aVar.internalFindViewById(R.id.gender);
        this.o = (EditText) aVar.internalFindViewById(R.id.birthday);
        this.p = (EditProfileItemView) aVar.internalFindViewById(R.id.gender_item);
        this.q = (EditProfileItemView) aVar.internalFindViewById(R.id.birthday_item);
        this.r = (EditProfileItemView) aVar.internalFindViewById(R.id.phone_item);
        this.s = (EditProfileItemView) aVar.internalFindViewById(R.id.email_item);
        View internalFindViewById = aVar.internalFindViewById(R.id.social_item);
        if (this.f22382b != null) {
            this.f22382b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.c();
                }
            });
        }
        if (this.f22381a != null) {
            this.f22381a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.d();
                }
            });
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.e();
                }
            });
            this.o.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    i.this.a(z);
                }
            });
        }
        if (this.q != null) {
            this.q.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.e();
                }
            });
        }
        if (this.n != null) {
            this.n.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.f();
                }
            });
            this.n.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    i.this.b(z);
                }
            });
        }
        if (this.p != null) {
            this.p.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.f();
                }
            });
        }
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.g();
                }
            });
        }
        if (this.k != null) {
            this.k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.h();
                }
            });
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.i();
                }
            });
        }
        if (this.s != null) {
            this.s.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.j();
                }
            });
        }
        if (this.r != null) {
            this.r.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.k();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.l();
                }
            });
        }
        a();
    }
}
