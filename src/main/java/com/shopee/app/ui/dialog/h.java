package com.shopee.app.ui.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.ui.product.add.ae;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.Calendar;

public class h extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f21572a;

    /* renamed from: b  reason: collision with root package name */
    ae f21573b;

    /* renamed from: c  reason: collision with root package name */
    bc f21574c;

    /* renamed from: d  reason: collision with root package name */
    bi f21575d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView.i f21576e;

    public interface a {
        void a(h hVar);
    }

    public h(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21574c.a(this.f21573b);
        int a2 = ((com.garena.android.appkit.tools.a.a.a() - 1420070400) / 604800) + 1;
        Calendar instance = Calendar.getInstance();
        instance.set(7, 2);
        instance.setFirstDayOfWeek(2);
        int timeInMillis = (int) (instance.getTimeInMillis() / 1000);
        instance.add(5, 6);
        int timeInMillis2 = (int) (instance.getTimeInMillis() / 1000);
        com.shopee.app.ui.income.h[] hVarArr = new com.shopee.app.ui.income.h[(a2 + 1)];
        hVarArr[0] = new com.shopee.app.ui.income.h(-1, -1);
        for (int i = 0; i < a2; i++) {
            if (i == 0) {
                hVarArr[i + 1] = new com.shopee.app.ui.income.h(timeInMillis, com.garena.android.appkit.tools.a.a.a());
            } else {
                hVarArr[i + 1] = new com.shopee.app.ui.income.h(timeInMillis, timeInMillis2);
            }
            timeInMillis -= 604800;
            timeInMillis2 -= 604800;
        }
        this.f21576e = new LinearLayoutManager(getContext());
        this.f21572a.setLayoutManager(this.f21576e);
        b bVar = new b(hVarArr);
        bVar.a(this.f21575d);
        this.f21572a.setAdapter(bVar);
        bVar.notifyDataSetChanged();
    }

    public static class b extends RecyclerView.a<a> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public com.shopee.app.ui.income.h[] f21577a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public bi f21578b;

        public static class a extends RecyclerView.w {

            /* renamed from: a  reason: collision with root package name */
            public TextView f21581a;

            public a(TextView textView) {
                super(textView);
                this.f21581a = textView;
            }
        }

        public b(com.shopee.app.ui.income.h[] hVarArr) {
            this.f21577a = hVarArr;
        }

        public void a(bi biVar) {
            this.f21578b = biVar;
        }

        /* renamed from: a */
        public a onCreateViewHolder(ViewGroup viewGroup, int i) {
            TextView textView = new TextView(viewGroup.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, b.a.m * 2));
            textView.setTextSize(14.0f);
            textView.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
            return new a(textView);
        }

        /* renamed from: a */
        public void onBindViewHolder(a aVar, final int i) {
            com.shopee.app.ui.income.h hVar = this.f21577a[i];
            if (hVar.f23182a == -1) {
                aVar.f21581a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_all));
            } else {
                String c2 = com.garena.android.appkit.tools.a.a.c(hVar.f23182a, "ID");
                String c3 = com.garena.android.appkit.tools.a.a.c(hVar.f23183b, "ID");
                aVar.f21581a.setText(c2 + " - " + c3);
            }
            aVar.f21581a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.f21578b.a().ao.a(b.this.f21577a[i]).a();
                }
            });
        }

        public int getItemCount() {
            return this.f21577a.length;
        }
    }
}
