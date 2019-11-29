package com.shopee.app.ui.actionbox2.item;

import android.view.View;
import android.widget.ImageView;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.ui.a.x;
import com.shopee.app.util.af;
import com.shopee.id.R;

public class c extends com.b.a.c<ActionContentInfo, ActionContentInfo> {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final x.a<ActionContentInfo> f19437c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19438d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f19439e;

    public boolean d() {
        return false;
    }

    public c(View view, x.a<ActionContentInfo> aVar) {
        super(view);
        this.f19437c = aVar;
        this.f19438d = (ImageView) view.findViewById(R.id.image_arrow);
        this.f19439e = view.findViewById(R.id.action_loading_progress);
        this.f19438d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f19438d.setTag(Long.valueOf(((ActionContentInfo) c.this.a()).getGroupId()));
                c.this.f19438d.setVisibility(8);
                c.this.f19439e.setVisibility(0);
                if (c.this.f19437c != null) {
                    c.this.f19437c.a(c.this.a(), !c.this.c(), c.this.getAdapterPosition());
                }
                if (c.this.getAdapterPosition() == -1) {
                    return;
                }
                if (c.this.c()) {
                    c.this.f();
                } else {
                    c.this.e();
                }
            }
        });
    }

    public void b(boolean z) {
        super.b(z);
        c(!z);
    }

    public void a(boolean z) {
        super.a(z);
        c(z);
    }

    private void c(boolean z) {
        if (a() != null) {
            ActionContentInfo actionContentInfo = (ActionContentInfo) a();
            if (this.f19438d.getTag() == null || actionContentInfo.getGroupId() != ((Long) this.f19438d.getTag()).longValue()) {
                this.f19439e.setVisibility(8);
                this.f19438d.setVisibility(0);
            } else if (!af.a(((ActionContentInfo) a()).getChildList())) {
                this.f19439e.setVisibility(8);
                this.f19438d.setVisibility(0);
            }
        }
        if (z) {
            this.f19438d.setImageResource(R.drawable.com_garena_shopee_ic_arrow_up);
        } else {
            this.f19438d.setImageResource(R.drawable.com_garena_shopee_ic_arrow_down);
        }
    }
}
