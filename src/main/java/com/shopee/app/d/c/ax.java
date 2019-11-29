package com.shopee.app.d.c;

import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.g;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.database.orm.bean.DBItemAttribute;
import com.shopee.app.network.f;
import com.shopee.app.ui.product.attributes.v;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseMatchAttribute;
import com.shopee.protocol.shop.AttributeInstance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ax extends a {

    /* renamed from: c  reason: collision with root package name */
    private final g f16527c;

    /* renamed from: d  reason: collision with root package name */
    private final af f16528d;

    /* renamed from: e  reason: collision with root package name */
    private int f16529e;

    /* renamed from: f  reason: collision with root package name */
    private int f16530f;

    /* renamed from: g  reason: collision with root package name */
    private String f16531g;
    private byte[] h;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetLocalAttributeListInteractor";
    }

    protected ax(n nVar, g gVar, af afVar) {
        super(nVar);
        this.f16527c = gVar;
        this.f16528d = afVar;
    }

    public void a(int i, int i2, String str, byte[] bArr) {
        this.f16529e = i;
        this.f16530f = i2;
        this.f16531g = str;
        this.h = bArr;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        AttributeInstance attributeInstance;
        AttributeInstance attributeInstance2;
        ResponseMatchAttribute responseMatchAttribute;
        DBItemAttribute a2 = this.f16528d.a(this.f16529e);
        VMItemAttribute vMItemAttribute = new VMItemAttribute();
        b.a(a2, this.f16530f, this.h, vMItemAttribute);
        try {
            ResponseMatchAttribute responseMatchAttribute2 = (ResponseMatchAttribute) f.f18486a.parseFrom(this.f16527c.a(this.h).b(), ResponseMatchAttribute.class);
            ArrayList arrayList = new ArrayList();
            DBAttributeCache a3 = this.f16527c.a(this.f16530f, new ArrayList());
            if (a3 != null && a3.b() != null) {
                try {
                    responseMatchAttribute = (ResponseMatchAttribute) f.f18486a.parseFrom(a3.b(), ResponseMatchAttribute.class);
                } catch (IOException e2) {
                    a.a(e2);
                    responseMatchAttribute = null;
                }
                if (responseMatchAttribute != null) {
                    Iterator<AttributeInstance> it = responseMatchAttribute.narrow_down.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        attributeInstance = it.next();
                        if (attributeInstance.attr_id.intValue() == this.f16529e) {
                            break;
                        }
                    }
                }
            }
            attributeInstance = null;
            if (vMItemAttribute.hasSelfDefine() && !TextUtils.isEmpty(this.f16531g) && attributeInstance != null && !attributeInstance.values.contains(this.f16531g)) {
                arrayList.add(new v(vMItemAttribute.getAttrId(), vMItemAttribute.getInputType(), vMItemAttribute.getAttrType(), vMItemAttribute.getValidateType(), 2, this.f16531g, true));
            }
            if (!com.shopee.app.util.af.a(responseMatchAttribute2.suggest) || !com.shopee.app.util.af.a(responseMatchAttribute2.narrow_down)) {
                if (!com.shopee.app.util.af.a(responseMatchAttribute2.suggest)) {
                    for (String next : a(attributeInstance, responseMatchAttribute2.suggest)) {
                        arrayList.add(new v(vMItemAttribute.getAttrId(), vMItemAttribute.getInputType(), vMItemAttribute.getAttrType(), vMItemAttribute.getValidateType(), 0, next, next.equals(this.f16531g)));
                    }
                }
                if (!com.shopee.app.util.af.a(responseMatchAttribute2.narrow_down)) {
                    Iterator<AttributeInstance> it2 = responseMatchAttribute2.narrow_down.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            attributeInstance2 = null;
                            break;
                        }
                        attributeInstance2 = it2.next();
                        if (attributeInstance2.attr_id.intValue() == this.f16529e) {
                            break;
                        }
                    }
                    if (attributeInstance2 != null) {
                        for (String next2 : attributeInstance2.values) {
                            arrayList.add(new v(vMItemAttribute.getAttrId(), vMItemAttribute.getInputType(), vMItemAttribute.getAttrType(), vMItemAttribute.getValidateType(), 0, next2, next2.equals(this.f16531g)));
                        }
                    }
                }
            }
            if (vMItemAttribute.hasSelfDefine()) {
                arrayList.add(new v(vMItemAttribute.getAttrId(), vMItemAttribute.getInputType(), vMItemAttribute.getAttrType(), vMItemAttribute.getValidateType(), 1, (attributeInstance == null || !attributeInstance.values.contains(this.f16531g)) ? this.f16531g : "", false));
            }
            this.f16402a.a("LOCAL_ATTRIBUTE_SUCCESS", new com.garena.android.appkit.b.a(arrayList));
        } catch (IOException e3) {
            a.a(e3);
        }
    }

    private List<String> a(AttributeInstance attributeInstance, List<AttributeInstance> list) {
        AttributeInstance attributeInstance2;
        ArrayList arrayList = new ArrayList();
        Iterator<AttributeInstance> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                attributeInstance2 = null;
                break;
            }
            attributeInstance2 = it.next();
            if (attributeInstance2.attr_id.intValue() == this.f16529e) {
                break;
            }
        }
        if (attributeInstance2 != null) {
            arrayList.addAll(attributeInstance2.values);
        }
        if (attributeInstance != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(attributeInstance.values);
            arrayList2.removeAll(arrayList);
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }
}
