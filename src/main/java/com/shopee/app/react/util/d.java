package com.shopee.app.react.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.ReactRootView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.shopee.id.R;
import java.util.HashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Integer> f19013a = new HashMap<>();

    static {
        f19013a.put("shopee://back", Integer.valueOf(R.drawable.com_garena_shopee_ic_back));
        f19013a.put("shopee://cart", Integer.valueOf(R.drawable.ic_nav_cart_orange));
        f19013a.put("shopee://more", Integer.valueOf(R.drawable.com_garena_shopee_ic_more));
    }

    public static int a(ReactRootView reactRootView) {
        View a2 = a((ViewGroup) reactRootView);
        if (a2 != null) {
            return a2.getMeasuredHeight();
        }
        return 0;
    }

    private static View a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        View view = null;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                if (childAt instanceof ReactScrollView) {
                    view = ((ReactScrollView) childAt).getChildAt(0);
                } else {
                    view = a((ViewGroup) childAt);
                }
                if (view != null) {
                    return view;
                }
            }
        }
        return view;
    }
}
