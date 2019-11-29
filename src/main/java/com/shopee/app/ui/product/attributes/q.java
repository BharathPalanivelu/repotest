package com.shopee.app.ui.product.attributes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.garena.android.appkit.f.f;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.a.r;
import com.shopee.app.util.af;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class q extends LinearLayout implements r {

    /* renamed from: a  reason: collision with root package name */
    ListView f24332a;

    /* renamed from: b  reason: collision with root package name */
    View f24333b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.ui.common.r f24334c;

    /* renamed from: d  reason: collision with root package name */
    bc f24335d;

    /* renamed from: e  reason: collision with root package name */
    k f24336e;

    /* renamed from: f  reason: collision with root package name */
    f f24337f;

    /* renamed from: g  reason: collision with root package name */
    Activity f24338g;
    com.shopee.app.ui.actionbar.a h;
    private final int i;
    private final String j;
    private final int k;
    private final byte[] l;
    private final int m;
    private final boolean n;

    public interface a {
        void a(q qVar);
    }

    public void b() {
    }

    public void d() {
    }

    public q(Context context, int i2, String str, int i3, byte[] bArr, int i4, boolean z) {
        super(context);
        this.i = i2;
        this.j = str;
        this.k = i3;
        this.l = bArr;
        this.m = i4;
        this.n = z;
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24335d.a(this.f24336e);
        this.f24336e.a(this);
        this.f24332a.setAdapter(this.f24337f);
        this.f24332a.setEmptyView(findViewById(R.id.empty_vew));
        this.f24336e.a(this.i, this.m, this.j, this.l);
        this.f24332a.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    com.shopee.app.c.a.a(q.this.getContext());
                }
            }
        });
        this.f24332a.setRecyclerListener(new AbsListView.RecyclerListener() {
            public void onMovedToScrapHeap(View view) {
                if (view.hasFocus()) {
                    view.clearFocus();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(v vVar) {
        if (vVar.f24353g) {
            this.f24338g.finish();
        } else {
            this.f24336e.c(vVar.f24352f);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<v> list) {
        v vVar;
        Iterator<v> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                vVar = null;
                break;
            }
            vVar = it.next();
            if (vVar.f24353g) {
                break;
            }
        }
        if (vVar != null) {
            list.remove(vVar);
            list.add(0, vVar);
        }
    }

    public void b(List<v> list) {
        this.f24333b.setVisibility(8);
        boolean z = false;
        this.f24332a.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        if (!af.a(list)) {
            if (this.n || list.size() == 1) {
                v vVar = list.get(list.size() - 1);
                vVar.a(true);
                arrayList.add(vVar);
                z = true;
            } else {
                arrayList.addAll(list);
            }
        }
        a((List<v>) arrayList);
        this.f24337f.a(arrayList);
        this.f24337f.notifyDataSetChanged();
        if (!z && this.k > 20) {
            f.a().a(new Runnable() {
                public void run() {
                    View findViewById = q.this.h.findViewById(R.id.search_edit);
                    if (findViewById != null) {
                        com.shopee.app.c.a.b(findViewById);
                    }
                }
            }, IjkMediaCodecInfo.RANK_LAST_CHANCE);
        }
    }

    public void a(u uVar, int i2) {
        Intent intent = new Intent();
        intent.putExtra(AbTestingModule.KEY_RESULT, uVar);
        intent.putExtra("return_type", i2);
        this.f24338g.setResult(-1, intent);
        this.f24338g.finish();
    }

    public void c() {
        com.shopee.app.c.a.a(getContext());
    }

    public void e() {
        this.f24333b.setVisibility(0);
        this.f24332a.setVisibility(8);
    }
}
