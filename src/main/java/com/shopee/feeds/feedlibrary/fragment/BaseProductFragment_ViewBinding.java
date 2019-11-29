package com.shopee.feeds.feedlibrary.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.LoadMoreRecycyleView;

public class BaseProductFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private BaseProductFragment f28102b;

    public BaseProductFragment_ViewBinding(BaseProductFragment baseProductFragment, View view) {
        this.f28102b = baseProductFragment;
        baseProductFragment.recyclerView = (LoadMoreRecycyleView) b.a(view, c.e.recycler_view, "field 'recyclerView'", LoadMoreRecycyleView.class);
        baseProductFragment.mTvNoData = (TextView) b.a(view, c.e.tv_no_data, "field 'mTvNoData'", TextView.class);
    }
}
