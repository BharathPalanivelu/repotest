package com.shopee.app.ui.tracklog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.app.ui.tracklog.b;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import com.shopee.shopeetracker.utils.SendEventTask;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class j extends FrameLayout implements SwipeRefreshLayout.b {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f25669a;

    /* renamed from: b  reason: collision with root package name */
    SwipeRefreshLayout f25670b;

    /* renamed from: c  reason: collision with root package name */
    SwitchCompat f25671c;

    /* renamed from: d  reason: collision with root package name */
    b f25672d;

    /* renamed from: e  reason: collision with root package name */
    private a f25673e;

    public j(Context context) {
        super(context);
        ((h) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25669a.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f25673e = new a(getContext());
        this.f25669a.setAdapter(this.f25673e);
        this.f25670b.setOnRefreshListener(this);
        b();
        ((ImageButton) findViewById(R.id.fabRemove)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                j.this.f25672d.a();
                j.this.b();
            }
        });
        ((ImageButton) findViewById(R.id.fabUpload)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new SendEventTask().execute(new Boolean[]{true});
            }
        });
        this.f25672d.a((b.C0393b) new b.C0393b() {
            public void a() {
                j.this.postDelayed(new Runnable() {
                    public void run() {
                        j.this.b();
                    }
                }, 100);
            }
        });
        this.f25671c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                j.this.b();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f25672d.a((b.C0393b) null);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f25673e.a(this.f25672d.a(this.f25671c.isChecked()));
        this.f25673e.notifyDataSetChanged();
    }

    public void onRefresh() {
        b();
        this.f25670b.setRefreshing(false);
    }

    private static class a extends RecyclerView.a<b> {

        /* renamed from: a  reason: collision with root package name */
        private Context f25679a;

        /* renamed from: b  reason: collision with root package name */
        private List<g> f25680b = new ArrayList();

        public a(Context context) {
            this.f25679a = context;
        }

        public void a(List<g> list) {
            this.f25680b.clear();
            if (list != null) {
                this.f25680b.addAll(list);
            }
        }

        /* renamed from: a */
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(this.f25679a).inflate(R.layout.item_log_view, viewGroup, false);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TrackBadgeDetailActivity_.a(view.getContext()).a(WebRegister.GSON.b((Object) (g) view.getTag())).a();
                }
            });
            return new b(inflate);
        }

        /* renamed from: a */
        public void onBindViewHolder(b bVar, int i) {
            String str;
            String str2;
            g gVar = this.f25680b.get((getItemCount() - 1) - i);
            int i2 = -16777216;
            if (gVar.f25657d == g.f25655b) {
                str = "send Event Badge Success";
            } else if (gVar.f25657d == g.f25656c) {
                i2 = -65536;
                str = "send Event Badge Failed";
            } else {
                str = "Start Send Event Badge";
            }
            if (gVar.f25660g == -1) {
                str2 = "Android V3";
            } else if (gVar.f25660g == 1) {
                str2 = "RN";
            } else {
                str2 = gVar.f25660g == 2 ? "Android V2" : "Android";
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
            Date date = new Date(gVar.f25658e);
            String str3 = "";
            if (gVar.f25659f != null) {
                if (gVar.f25659f.contains("mweb")) {
                    str3 = str3 + "mweb, ";
                }
                if (gVar.f25659f.contains("android")) {
                    str3 = str3 + "android, ";
                }
                if (gVar.f25659f.contains("rn")) {
                    str3 = str3 + "rn, ";
                }
            }
            bVar.f25682a.setText(str);
            bVar.f25682a.setTextColor(i2);
            bVar.f25683b.setText(simpleDateFormat.format(date));
            bVar.f25684c.setText(str3);
            bVar.f25685d.setText(str2);
            bVar.itemView.setTag(gVar);
        }

        public int getItemCount() {
            return this.f25680b.size();
        }
    }

    private static class b extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        TextView f25682a;

        /* renamed from: b  reason: collision with root package name */
        TextView f25683b;

        /* renamed from: c  reason: collision with root package name */
        TextView f25684c;

        /* renamed from: d  reason: collision with root package name */
        TextView f25685d;

        public b(View view) {
            super(view);
            this.f25682a = (TextView) view.findViewById(R.id.title);
            this.f25683b = (TextView) view.findViewById(R.id.time);
            this.f25685d = (TextView) view.findViewById(R.id.type);
            this.f25684c = (TextView) view.findViewById(R.id.source);
        }
    }
}
