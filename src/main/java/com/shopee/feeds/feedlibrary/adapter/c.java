package com.shopee.feeds.feedlibrary.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.fragment.app.k;
import java.util.ArrayList;
import java.util.List;

public class c extends k {

    /* renamed from: a  reason: collision with root package name */
    private final List<Fragment> f27568a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f27569b = new ArrayList<>();

    public c(h hVar, ArrayList<String> arrayList) {
        super(hVar);
        this.f27569b = arrayList;
    }

    public Fragment a(int i) {
        return this.f27568a.get(i);
    }

    public CharSequence getPageTitle(int i) {
        return this.f27569b.get(i);
    }

    public int getCount() {
        return this.f27568a.size();
    }

    public void a(Fragment fragment) {
        this.f27568a.add(fragment);
    }
}
