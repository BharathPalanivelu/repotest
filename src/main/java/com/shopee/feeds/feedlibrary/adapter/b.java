package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.view.b.e;
import com.shopee.feeds.feedlibrary.view.b.k;
import com.squareup.a.r;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class b extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    Context f27561a;

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<k> f27562b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f27563c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private e f27564d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f27565e;

    public interface a {
        void a(int i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public b(Context context) {
        this.f27561a = context;
    }

    public void a(a aVar) {
        this.f27565e = aVar;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f27562b.get(i) == null) {
            a(i);
        }
        final k kVar = this.f27562b.get(i);
        w.a(this.f27561a).a(q.a(this.f27563c.get(i))).b(this.f27561a.getResources().getDisplayMetrics().widthPixels, this.f27561a.getResources().getDisplayMetrics().heightPixels).e().a(r.NO_CACHE, r.NO_STORE).a(c.d.feeds_image_placeholder).f().a((ImageView) kVar, (com.squareup.a.e) new com.squareup.a.e() {
            public void d() {
            }

            public void c() {
                float intrinsicHeight = (float) kVar.getDrawable().getIntrinsicHeight();
                float f2 = (float) b.this.f27561a.getResources().getDisplayMetrics().widthPixels;
                float intrinsicWidth = (intrinsicHeight / ((float) kVar.getDrawable().getIntrinsicWidth())) * f2;
                ViewGroup.LayoutParams layoutParams = kVar.getLayoutParams();
                layoutParams.width = (int) f2;
                layoutParams.height = (int) intrinsicWidth;
                kVar.setLayoutParams(layoutParams);
                if (b.this.f27565e != null) {
                    b.this.f27565e.a(layoutParams.height);
                }
            }
        });
        viewGroup.removeView(kVar);
        viewGroup.addView(kVar);
        kVar.setOnOutsidePhotoTapListener(this.f27564d);
        return kVar;
    }

    public void a(List<String> list) {
        if (list != null) {
            ArrayList<String> arrayList = this.f27563c;
            if (arrayList == null) {
                this.f27563c = new ArrayList<>(list.size());
                this.f27563c.addAll(list);
            } else {
                arrayList.clear();
                this.f27563c.addAll(list);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f27563c.size();
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f27562b.get(i) != null) {
            viewGroup.removeView(this.f27562b.get(i));
            this.f27562b.remove(i);
        }
    }

    private void a(int i) {
        this.f27562b.put(i, new k(this.f27561a));
    }

    public void a(e eVar) {
        this.f27564d = eVar;
    }
}
