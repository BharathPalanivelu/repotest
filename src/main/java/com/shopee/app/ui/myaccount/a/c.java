package com.shopee.app.ui.myaccount.a;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {
    private boolean j = false;
    private final org.a.a.b.c k = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        r();
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void r() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.k);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onViewChanged(a aVar) {
        a aVar2 = aVar;
        View internalFindViewById = aVar2.internalFindViewById(R.id.btnProfile);
        View internalFindViewById2 = aVar2.internalFindViewById(R.id.btnEditAddress);
        View internalFindViewById3 = aVar2.internalFindViewById(R.id.btnBankAndCard);
        View internalFindViewById4 = aVar2.internalFindViewById(R.id.myEReceipt);
        View internalFindViewById5 = aVar2.internalFindViewById(R.id.btnChatSetting);
        View internalFindViewById6 = aVar2.internalFindViewById(R.id.btnNotificationBatchSettings);
        View internalFindViewById7 = aVar2.internalFindViewById(R.id.btnPrivacySettings);
        View internalFindViewById8 = aVar2.internalFindViewById(R.id.btnBlockedUser);
        View internalFindViewById9 = aVar2.internalFindViewById(R.id.btnLanguageSettings);
        View internalFindViewById10 = aVar2.internalFindViewById(R.id.btnHelperCenter);
        View internalFindViewById11 = aVar2.internalFindViewById(R.id.btnTipsAndTricks);
        View internalFindViewById12 = aVar2.internalFindViewById(R.id.btnCommunityRules);
        View internalFindViewById13 = aVar2.internalFindViewById(R.id.btnShopeePolicies);
        View internalFindViewById14 = aVar2.internalFindViewById(R.id.btnGooglePlay);
        View internalFindViewById15 = aVar2.internalFindViewById(R.id.btnLogout);
        View internalFindViewById16 = aVar2.internalFindViewById(R.id.btnClearCache);
        View internalFindViewById17 = aVar2.internalFindViewById(R.id.btnRequestAccountDeletion);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.b();
                }
            });
        }
        if (internalFindViewById3 != null) {
            internalFindViewById3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.c();
                }
            });
        }
        if (internalFindViewById4 != null) {
            internalFindViewById4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.d();
                }
            });
        }
        if (internalFindViewById5 != null) {
            internalFindViewById5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.e();
                }
            });
        }
        if (internalFindViewById6 != null) {
            internalFindViewById6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.f();
                }
            });
        }
        if (internalFindViewById7 != null) {
            internalFindViewById7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.g();
                }
            });
        }
        if (internalFindViewById8 != null) {
            internalFindViewById8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.h();
                }
            });
        }
        if (internalFindViewById9 != null) {
            internalFindViewById9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.i();
                }
            });
        }
        if (internalFindViewById10 != null) {
            internalFindViewById10.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.j();
                }
            });
        }
        if (internalFindViewById11 != null) {
            internalFindViewById11.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.k();
                }
            });
        }
        if (internalFindViewById12 != null) {
            internalFindViewById12.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.l();
                }
            });
        }
        if (internalFindViewById13 != null) {
            internalFindViewById13.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.m();
                }
            });
        }
        if (internalFindViewById14 != null) {
            internalFindViewById14.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.n();
                }
            });
        }
        if (internalFindViewById15 != null) {
            internalFindViewById15.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.o();
                }
            });
        }
        if (internalFindViewById16 != null) {
            internalFindViewById16.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.p();
                }
            });
        }
        if (internalFindViewById17 != null) {
            internalFindViewById17.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.q();
                }
            });
        }
    }
}
