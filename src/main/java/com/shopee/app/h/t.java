package com.shopee.app.h;

import com.shopee.app.data.viewmodel.UserBriefInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t {

    /* renamed from: d  reason: collision with root package name */
    private static t f17703d;

    /* renamed from: a  reason: collision with root package name */
    List<UserBriefInfo> f17704a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    Map<Integer, UserBriefInfo> f17705b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    Map<Integer, UserBriefInfo> f17706c = new HashMap();

    public static t a() {
        if (f17703d == null) {
            f17703d = new t();
        }
        return f17703d;
    }

    private t() {
    }

    public void a(UserBriefInfo userBriefInfo) {
        this.f17704a.add(userBriefInfo);
        this.f17705b.put(Integer.valueOf(userBriefInfo.getUserId()), userBriefInfo);
        this.f17706c.put(Integer.valueOf(userBriefInfo.getShopId()), userBriefInfo);
    }

    public void a(List<UserBriefInfo> list) {
        for (UserBriefInfo a2 : list) {
            a(a2);
        }
    }

    public UserBriefInfo a(int i) {
        return this.f17705b.get(Integer.valueOf(i));
    }

    public UserBriefInfo b(int i) {
        return this.f17706c.get(Integer.valueOf(i));
    }
}
