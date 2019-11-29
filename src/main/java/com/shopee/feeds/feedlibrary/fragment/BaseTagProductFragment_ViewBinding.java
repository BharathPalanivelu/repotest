package com.shopee.feeds.feedlibrary.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.LoadMoreRecycyleView;

public class BaseTagProductFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private BaseTagProductFragment f28107b;

    /* renamed from: c  reason: collision with root package name */
    private View f28108c;

    public BaseTagProductFragment_ViewBinding(final BaseTagProductFragment baseTagProductFragment, View view) {
        this.f28107b = baseTagProductFragment;
        baseTagProductFragment.recyclerView = (LoadMoreRecycyleView) b.a(view, c.e.recycler_view, "field 'recyclerView'", LoadMoreRecycyleView.class);
        baseTagProductFragment.tvNoData = (TextView) b.a(view, c.e.tv_no_data, "field 'tvNoData'", TextView.class);
        baseTagProductFragment.tvWrongNetData = (RobotoTextView) b.a(view, c.e.tv_wrong_net_data, "field 'tvWrongNetData'", RobotoTextView.class);
        View a2 = b.a(view, c.e.tv_retry, "field 'tvRetry' and method 'retryLoad'");
        baseTagProductFragment.tvRetry = (RobotoTextView) b.b(a2, c.e.tv_retry, "field 'tvRetry'", RobotoTextView.class);
        this.f28108c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                baseTagProductFragment.retryLoad();
            }
        });
        baseTagProductFragment.llWrongNet = (LinearLayout) b.a(view, c.e.ll_wrong_net, "field 'llWrongNet'", LinearLayout.class);
    }
}
