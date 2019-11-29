package com.shopee.app.ui.product.attributes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f24343a;

    /* renamed from: b  reason: collision with root package name */
    View f24344b;

    /* renamed from: c  reason: collision with root package name */
    List<c> f24345c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f24346d = 0;

    public t(Context context) {
        super(context);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i) {
        int i2 = 0;
        while (i2 < i) {
            if (this.f24345c.size() <= i2) {
                c a2 = d.a(getContext());
                this.f24345c.add(a2);
                this.f24343a.addView(a2, new LinearLayout.LayoutParams(-1, -2));
            } else {
                this.f24345c.get(i2).setVisibility(0);
            }
            i2++;
        }
        while (i2 < this.f24345c.size()) {
            this.f24345c.get(i2).setVisibility(8);
            i2++;
        }
    }

    public void a(int i, List<VMItemAttribute> list) {
        for (int b2 = b(i, list); b2 < this.f24345c.size(); b2++) {
            this.f24345c.get(b2).setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(int i, List<VMItemAttribute> list) {
        c cVar;
        this.f24346d = i;
        a(list.size());
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i3 < list.size()) {
            VMItemAttribute vMItemAttribute = list.get(i3);
            if (this.f24345c.size() <= i3) {
                cVar = d.a(getContext());
                this.f24345c.add(cVar);
                this.f24343a.addView(cVar, new LinearLayout.LayoutParams(-1, -2));
            } else {
                cVar = this.f24345c.get(i3);
                cVar.setVisibility(0);
            }
            cVar.a(vMItemAttribute);
            if (vMItemAttribute.isKnowType()) {
                cVar.setVisibility(0);
                z = true;
            } else {
                cVar.setVisibility(8);
            }
            i3++;
        }
        View view = this.f24344b;
        if (!z) {
            i2 = 8;
        }
        view.setVisibility(i2);
        return i3;
    }

    public void c(int i, List<VMItemAttribute> list) {
        for (int b2 = b(i, list); b2 < this.f24345c.size(); b2++) {
            c cVar = this.f24345c.get(b2);
            cVar.setVisibility(8);
            cVar.e();
        }
    }

    public void a() {
        for (c next : this.f24345c) {
            if (next.getVisibility() == 0) {
                next.b();
            }
        }
    }

    public List<u> getSubmitAttributeValueList() {
        ArrayList arrayList = new ArrayList();
        for (c next : this.f24345c) {
            if (next.getVisibility() != 8) {
                u submitAttributeData = next.getSubmitAttributeData();
                if (submitAttributeData != null) {
                    arrayList.add(submitAttributeData);
                }
            }
        }
        return arrayList;
    }

    public List<u> getAttributeValueList() {
        ArrayList arrayList = new ArrayList();
        for (c next : this.f24345c) {
            if (!(next.getVisibility() == 8 || next.getAttributeValue() == null)) {
                arrayList.add(next.getAttributeValue());
            }
        }
        return arrayList;
    }

    public void b() {
        for (c next : this.f24345c) {
            if (next.getVisibility() != 8) {
                next.setSelectAttributeData((u) null);
            }
        }
    }

    public void setSelectAttributeData(List<u> list) {
        HashMap hashMap = new HashMap();
        for (u next : list) {
            hashMap.put(Integer.valueOf(next.a()), next);
        }
        for (int i = 0; i < this.f24345c.size(); i++) {
            c cVar = this.f24345c.get(i);
            u uVar = (u) hashMap.get(Integer.valueOf(cVar.getAttributeId()));
            if (cVar.getVisibility() == 0) {
                cVar.setSelectAttributeData(uVar);
            }
        }
    }

    public int getModelId() {
        return this.f24346d;
    }

    public void a(u uVar) {
        b.a("ON_ATTRIBUTE_SELECTED", new a(uVar), b.a.UI_BUS);
    }

    public boolean c() {
        for (c next : this.f24345c) {
            if (next.getVisibility() != 8 && next.c()) {
                return true;
            }
        }
        return false;
    }
}
