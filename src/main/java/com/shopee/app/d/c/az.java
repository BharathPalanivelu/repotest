package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.an;
import com.shopee.app.data.store.g;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.database.orm.bean.DBItemAttribute;
import com.shopee.app.database.orm.bean.DBModelAttrIdMap;
import com.shopee.app.network.f;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.util.af;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseMatchAttribute;
import com.shopee.protocol.shop.AttributeInstance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class az extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f16535c;

    /* renamed from: d  reason: collision with root package name */
    private final bi f16536d;

    /* renamed from: e  reason: collision with root package name */
    private final cg f16537e;

    /* renamed from: f  reason: collision with root package name */
    private final an f16538f;

    /* renamed from: g  reason: collision with root package name */
    private final g f16539g;
    private final af h;
    /* access modifiers changed from: private */
    public int i;
    private List<u> j;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetLocalAttributeModelInteractor";
    }

    protected az(n nVar, bi biVar, cg cgVar, an anVar, g gVar, af afVar) {
        super(nVar);
        this.f16535c = nVar;
        this.f16536d = biVar;
        this.f16537e = cgVar;
        this.f16538f = anVar;
        this.f16539g = gVar;
        this.h = afVar;
    }

    public void a(int i2, List<u> list) {
        this.i = i2;
        this.j = list;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        DBModelAttrIdMap a2 = this.f16538f.a(this.i);
        if (a2 != null) {
            List<Integer> a3 = a2.a();
            ArrayList arrayList = new ArrayList();
            final DBAttributeCache a4 = this.f16539g.a(this.i, this.j);
            arrayList.addAll(com.shopee.app.util.af.a(this.h.a(a3), new af.b<VMItemAttribute, DBItemAttribute>() {
                /* renamed from: a */
                public VMItemAttribute map(DBItemAttribute dBItemAttribute) {
                    if (dBItemAttribute == null) {
                        return null;
                    }
                    VMItemAttribute vMItemAttribute = new VMItemAttribute();
                    b.a(dBItemAttribute, az.this.i, a4.a(), vMItemAttribute);
                    return vMItemAttribute;
                }
            }));
            List<VMItemAttribute> a5 = com.shopee.app.util.af.a(arrayList, new af.a<VMItemAttribute>() {
                /* renamed from: a */
                public boolean shouldInclude(VMItemAttribute vMItemAttribute) {
                    return vMItemAttribute != null;
                }
            });
            byte[] b2 = a4.b();
            if (b2 != null) {
                try {
                    ResponseMatchAttribute responseMatchAttribute = (ResponseMatchAttribute) f.f18486a.parseFrom(b2, ResponseMatchAttribute.class);
                    if (com.shopee.app.util.af.a(responseMatchAttribute.suggest)) {
                        if (com.shopee.app.util.af.a(responseMatchAttribute.narrow_down)) {
                            for (VMItemAttribute vMItemAttribute : a5) {
                                ArrayList arrayList2 = new ArrayList();
                                if (vMItemAttribute.hasSelfDefine()) {
                                    arrayList2.add("");
                                }
                                vMItemAttribute.setSubAttributes(arrayList2);
                            }
                            this.f16535c.a("GET_LOCAL_ATTRIBUTES_SUCCESS", new a(a5));
                        }
                    }
                    DBAttributeCache a6 = this.f16539g.a(this.i, new ArrayList());
                    if (a6 == null || a6.b() == null) {
                        this.f16537e.a(this.i, new ArrayList());
                        return;
                    }
                    ResponseMatchAttribute responseMatchAttribute2 = (ResponseMatchAttribute) f.f18486a.parseFrom(a6.b(), ResponseMatchAttribute.class);
                    HashMap hashMap = new HashMap(responseMatchAttribute2.narrow_down.size());
                    for (AttributeInstance next : responseMatchAttribute2.narrow_down) {
                        hashMap.put(next.attr_id, next);
                    }
                    if (!com.shopee.app.util.af.a(responseMatchAttribute.suggest)) {
                        a(responseMatchAttribute.suggest, hashMap, a5);
                    }
                    if (!com.shopee.app.util.af.a(responseMatchAttribute.narrow_down)) {
                        HashMap hashMap2 = new HashMap(responseMatchAttribute.narrow_down.size());
                        for (AttributeInstance next2 : responseMatchAttribute.narrow_down) {
                            hashMap2.put(next2.attr_id, next2);
                        }
                        b(hashMap2, a5);
                        a(responseMatchAttribute.suggest, hashMap2, hashMap, this.j);
                    }
                    a((Map<Integer, AttributeInstance>) hashMap, this.j);
                    this.f16535c.a("GET_LOCAL_ATTRIBUTES_SUCCESS", new a(a5));
                } catch (IOException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    }

    private void a(Map<Integer, AttributeInstance> map, List<u> list) {
        for (u next : list) {
            if (!map.containsKey(Integer.valueOf(next.a()))) {
                next.a(0);
            }
        }
    }

    private void a(List<AttributeInstance> list, Map<Integer, AttributeInstance> map, Map<Integer, AttributeInstance> map2, List<u> list2) {
        HashMap hashMap = new HashMap(list.size());
        for (AttributeInstance next : list) {
            hashMap.put(next.attr_id, next);
        }
        for (u next2 : list2) {
            int a2 = next2.a();
            if (hashMap.containsKey(Integer.valueOf(a2))) {
                AttributeInstance attributeInstance = map.get(Integer.valueOf(a2));
                if (!map2.containsKey(Integer.valueOf(a2)) || !map2.get(Integer.valueOf(a2)).values.contains(next2.b()) || attributeInstance.values.contains(next2.b())) {
                    com.garena.android.appkit.d.a.b(next2.toString() + " no need to be cleared  by suggest ", new Object[0]);
                } else {
                    com.garena.android.appkit.d.a.b(next2.toString() + " need to be cleared, by suggest", new Object[0]);
                    if (attributeInstance.values.size() == 1) {
                        this.f16536d.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, attributeInstance.values.get(0), 2)));
                        this.f16535c.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, attributeInstance.values.get(0), 2)));
                        com.garena.android.appkit.d.a.b(next2.toString() + " need to be cleared  by suggest, new value " + attributeInstance.values.get(0), new Object[0]);
                    } else {
                        this.f16536d.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, "", 2)));
                        this.f16535c.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, "", 2)));
                        com.garena.android.appkit.d.a.b(next2.toString() + " need to be cleared  by suggest, new value empty ", new Object[0]);
                    }
                }
            }
            if (map.containsKey(Integer.valueOf(a2))) {
                AttributeInstance attributeInstance2 = map.get(Integer.valueOf(a2));
                if (!map2.containsKey(Integer.valueOf(a2)) || !map2.get(Integer.valueOf(a2)).values.contains(next2.b()) || attributeInstance2.values.contains(next2.b())) {
                    com.garena.android.appkit.d.a.b(next2.toString() + " no need to be cleared   by full list", new Object[0]);
                } else {
                    com.garena.android.appkit.d.a.b(next2.toString() + " need to be cleared,  by full list", new Object[0]);
                    if (attributeInstance2.values.size() == 1) {
                        this.f16536d.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, attributeInstance2.values.get(0), 2)));
                        this.f16535c.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, attributeInstance2.values.get(0), 2)));
                        com.garena.android.appkit.d.a.b(next2.toString() + " need to be cleared  by full list, new value " + attributeInstance2.values.get(0), new Object[0]);
                    } else {
                        this.f16536d.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, "", 2)));
                        this.f16535c.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(new u(a2, "", 2)));
                        com.garena.android.appkit.d.a.b(next2.toString() + " need to be cleared  by full list, new value empty ", new Object[0]);
                    }
                }
            }
        }
    }

    private void b(Map<Integer, AttributeInstance> map, List<VMItemAttribute> list) {
        for (VMItemAttribute next : list) {
            ArrayList arrayList = new ArrayList();
            if (map.containsKey(Integer.valueOf(next.getAttrId()))) {
                if (!com.shopee.app.util.af.a(map.get(Integer.valueOf(next.getAttrId())).values)) {
                    arrayList.addAll(map.get(Integer.valueOf(next.getAttrId())).values);
                }
                if (next.hasSelfDefine()) {
                    arrayList.add("");
                }
                next.setSubAttributes(arrayList);
            }
        }
    }

    private void a(List<AttributeInstance> list, Map<Integer, AttributeInstance> map, List<VMItemAttribute> list2) {
        HashMap hashMap = new HashMap(list.size());
        for (AttributeInstance next : list) {
            hashMap.put(next.attr_id, next);
        }
        HashMap hashMap2 = new HashMap(list2.size());
        for (VMItemAttribute next2 : list2) {
            hashMap2.put(Integer.valueOf(next2.getAttrId()), next2);
        }
        b(hashMap, list2);
        for (AttributeInstance next3 : list) {
            if (map.containsKey(next3.attr_id) && hashMap.containsKey(next3.attr_id)) {
                AttributeInstance attributeInstance = map.get(next3.attr_id);
                VMItemAttribute vMItemAttribute = (VMItemAttribute) hashMap2.get(next3.attr_id);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(vMItemAttribute.getSubAttributes());
                arrayList.remove("");
                if (!com.shopee.app.util.af.a(attributeInstance.values)) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(attributeInstance.values);
                    if (!com.shopee.app.util.af.a(vMItemAttribute.getSubAttributes())) {
                        arrayList2.removeAll(vMItemAttribute.getSubAttributes());
                    }
                    arrayList.addAll(arrayList2);
                }
                vMItemAttribute.setSubAttributes(arrayList);
            }
        }
    }
}
