package com.shopee.app.ui.actionbox2;

import android.view.View;
import android.view.ViewGroup;
import com.b.a.a.a;
import com.b.a.c;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.ui.a.x;
import com.shopee.app.ui.actionbox.actionrequired.b;

public class i extends x<ActionContentInfo, ActionContentInfo> {
    /* access modifiers changed from: protected */
    public c a(ViewGroup viewGroup, x.a<ActionContentInfo> aVar) {
        return new com.shopee.app.ui.actionbox2.item.c(b.a(viewGroup.getContext()), aVar);
    }

    /* access modifiers changed from: protected */
    public View a(ViewGroup viewGroup) {
        return com.shopee.app.ui.actionbox2.item.b.a(viewGroup.getContext());
    }

    /* access modifiers changed from: protected */
    public void a(c cVar, ActionContentInfo actionContentInfo) {
        ((com.shopee.app.ui.actionbox2.item.c) cVar).a(actionContentInfo.isInitiallyExpanded());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ActionContentInfo b(long j) {
        ActionContentInfo actionContentInfo = new ActionContentInfo();
        actionContentInfo.setId(j);
        return actionContentInfo;
    }

    public long getItemId(int i) {
        a aVar = (a) this.f4656a.get(i);
        if (aVar.d()) {
            return ((ActionContentInfo) aVar.a()).getId();
        }
        return ((ActionContentInfo) aVar.b()).getId() * -1;
    }
}
