package com.shopee.live.livestreaming.ui.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.android.appkit.tools.b;
import com.google.a.o;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.a.d;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.GetSessionProductTask;
import com.shopee.live.livestreaming.ui.view.LoadMoreRecycyleView;
import com.shopee.live.livestreaming.ui.view.a.a;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.ad;
import com.shopee.live.livestreaming.util.q;
import com.shopee.live.livestreaming.util.w;
import com.shopee.live.livestreaming.util.z;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;
import com.shopee.shopeetracker.EventSender;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import java.util.ArrayList;

public class d extends DialogFragment implements View.OnClickListener {
    private static int q;

    /* renamed from: a  reason: collision with root package name */
    Context f29295a;

    /* renamed from: b  reason: collision with root package name */
    TextView f29296b;

    /* renamed from: c  reason: collision with root package name */
    MyButton f29297c;

    /* renamed from: d  reason: collision with root package name */
    LoadMoreRecycyleView f29298d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayout f29299e;

    /* renamed from: f  reason: collision with root package name */
    LinearLayout f29300f;

    /* renamed from: g  reason: collision with root package name */
    TextView f29301g;
    ArrayList<SessionProductEntity.ProductItem> h = new ArrayList<>();
    ArrayList<SessionProductEntity.ProductItem> i = new ArrayList<>();
    a j;
    private GetSessionProductTask k;
    private int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public boolean o;
    private int p;
    /* access modifiers changed from: private */
    public com.shopee.live.livestreaming.ui.view.a.a r;
    /* access modifiers changed from: private */
    public int s;
    private String t = "";
    private int u;
    private String v = "";
    private boolean w = false;
    private boolean x = false;
    private ad y;

    public interface a {
        void a();

        void a(int i);

        void a(SessionProductEntity.ProductItem productItem, String str);

        void a(ArrayList<SessionProductEntity.ProductItem> arrayList, int i, int i2);

        void b(SessionProductEntity.ProductItem productItem, String str);
    }

    public static d a(int i2, String str, String str2, ArrayList<SessionProductEntity.ProductItem> arrayList, int i3, int i4, int i5) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putInt(EventSender.TRACKING_DATA_SESSION_ID, i2);
        bundle.putString("select_url", str);
        bundle.putString("pos", str2);
        bundle.putSerializable("list", arrayList);
        bundle.putInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, i4);
        bundle.putInt("index", i3);
        bundle.putInt("total", i5);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.l = arguments.getInt(EventSender.TRACKING_DATA_SESSION_ID);
        this.t = arguments.getString("pos");
        this.v = arguments.getString("select_url");
        this.i = (ArrayList) arguments.getSerializable("list");
        this.u = arguments.getInt("index");
        this.n = arguments.getInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET);
        this.p = arguments.getInt("total");
        setStyle(c.h.bottom_sheet_dialog, 0);
        this.k = InjectorUtils.provideGetSessionProductTask();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.b.transparent)));
            window.requestFeature(1);
        }
        View inflate = layoutInflater.inflate(c.f.live_streaming_fragment_bottom_product, viewGroup, false);
        a(inflate);
        return inflate;
    }

    private void a(View view) {
        this.f29296b = (TextView) view.findViewById(c.e.tv_bottom_product_title);
        this.f29297c = (MyButton) view.findViewById(c.e.btn_bottom_product_add);
        this.f29297c.setOnClickListener(this);
        this.f29298d = (LoadMoreRecycyleView) view.findViewById(c.e.rv_bottom_product);
        this.f29299e = (LinearLayout) view.findViewById(c.e.ll_bottom_product);
        this.f29300f = (LinearLayout) view.findViewById(c.e.ll_no_product);
        this.f29301g = (TextView) view.findViewById(c.e.tv_no_product);
        this.f29301g.setText(b.e(c.g.live_streaming_host_related_products_no_products_tip));
        this.f29297c.a(b.e(c.g.live_streaming_host_related_product_btn_add), -1, 0);
        this.r = new com.shopee.live.livestreaming.ui.view.a.a(this.f29295a);
        this.r.b(this.s);
        this.r.a(this.t);
        this.r.c(this.l);
        this.r.a((d.a) new d.a() {
            public void a(int i, Object obj, View view) {
                if (d.this.s == 17 || d.this.s == 18) {
                    if (d.this.j != null) {
                        d.this.j.a((SessionProductEntity.ProductItem) obj, d.this.r.a());
                    }
                } else if ((d.this.s == 20 || d.this.s == 21) && d.this.j != null) {
                    d.this.j.a((SessionProductEntity.ProductItem) obj, d.this.r.a());
                }
            }
        });
        this.r.a((a.C0442a) new a.C0442a() {
            public void a(SessionProductEntity.ProductItem productItem) {
                if (d.this.j != null) {
                    d.this.j.b(productItem, d.this.r.a());
                }
            }
        });
        this.f29298d.setLayoutManager(new LinearLayoutManager(this.f29295a));
        this.f29298d.setOnLoadListener(new LoadMoreRecycyleView.a() {
            public void a() {
                int unused = d.this.n = 10;
                d.this.a();
                d.this.c();
            }
        });
        this.f29298d.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && d.this.j != null) {
                    d.this.j.a(d.this.h, d.this.f29298d.g(d.this.f29298d.getChildAt(0)), d.this.m);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        this.f29298d.setAdapter(this.r);
        int i2 = this.s;
        if (i2 == 20 || i2 == 21 || i2 == 17) {
            this.f29297c.setVisibility(8);
        }
        this.y = new ad(getActivity(), this.f29298d);
        this.y.a((ad.a) new ad.a() {
            public void a(int i) {
                SessionProductEntity.ProductItem productItem = (SessionProductEntity.ProductItem) d.this.r.a(i);
                if (productItem == null) {
                    return;
                }
                if (d.this.s == 20) {
                    com.shopee.live.livestreaming.ui.audience.c.a(productItem.getItem_id(), productItem.getShop_id(), i);
                } else if (d.this.s == 21) {
                    com.shopee.live.livestreaming.ui.audience.c.c(productItem.getItem_id(), productItem.getShop_id(), i);
                }
            }
        });
        b();
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.dimAmount = BitmapDescriptorFactory.HUE_RED;
            attributes.width = (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.95f);
            attributes.height = (getResources().getDisplayMetrics().heightPixels * 3) / 5;
            attributes.windowAnimations = c.h.bottom_sheet_dialog_animation;
            window.setAttributes(attributes);
        }
    }

    public void onResume() {
        super.onResume();
        f();
        if (this.w) {
            a();
            c();
            this.w = false;
        }
        if (com.shopee.live.livestreaming.util.d.a(this.f29295a.getApplicationContext()) == 1) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 83;
            attributes.width = (int) ab.a(370.0f);
            attributes.height = (int) ((((float) (w.b(this.f29295a) - q)) - ab.a(12.0f)) - ((float) w.c(this.f29295a)));
            attributes.horizontalMargin = ab.a(15.0f) / ((float) w.a(this.f29295a));
            window.setAttributes(attributes);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.n < 10) {
            this.n = 10;
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException e2) {
            com.shopee.e.a.a.a(e2, "productDialogFragment show error", new Object[0]);
        }
    }

    private void b() {
        ArrayList<SessionProductEntity.ProductItem> arrayList = this.i;
        if (arrayList != null && arrayList.size() > 0) {
            this.h.addAll(this.i);
            this.r.a(this.i);
            int i2 = this.u;
            if (i2 > 0) {
                this.f29298d.b(i2);
            }
        }
        this.f29296b.setText(String.format(b.e(c.g.live_streaming_host_related_products_tittle), new Object[]{Integer.valueOf(this.p)}));
        a();
        this.m = 0;
        c();
        d();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.k.execute(new GetSessionProductTask.Data(this.l, this.m, this.n), new GetSessionProductTask.Callback() {
            public void returnProduct(int i, SessionProductEntity sessionProductEntity) {
                if (d.this.f29298d != null) {
                    d.this.f29298d.setLoading(false);
                    if (sessionProductEntity != null && sessionProductEntity.getItems().size() > 0) {
                        d.this.g();
                        if (i == 0) {
                            d.this.h.clear();
                        }
                        d.this.h.addAll(sessionProductEntity.getItems());
                        boolean unused = d.this.o = sessionProductEntity.isHasMore();
                        int unused2 = d.this.m = sessionProductEntity.getNext_offset();
                        d.this.r.a(d.this.h);
                        if (d.this.j != null) {
                            d.this.j.a(sessionProductEntity.getTotal_count());
                        }
                        if (sessionProductEntity.getTotal_count() > 0) {
                            d.this.f29296b.setText(String.format(b.e(c.g.live_streaming_host_related_products_tittle), new Object[]{Integer.valueOf(sessionProductEntity.getTotal_count())}));
                        }
                    } else if (i == 0) {
                        d.this.f29300f.setVisibility(0);
                        d.this.f29298d.setVisibility(8);
                    }
                }
            }

            public void onError(int i, String str) {
                if (!com.shopee.live.livestreaming.util.d.a(str)) {
                    z.a(d.this.f29295a, str);
                }
            }
        });
    }

    private void d() {
        if (q.c(this.s) || q.d(this.s)) {
            this.y.a();
        }
    }

    private void e() {
        if (q.c(this.s) || q.d(this.s)) {
            this.y.c();
        }
    }

    private void f() {
        if (q.c(this.s) || q.d(this.s)) {
            this.y.b();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        LoadMoreRecycyleView loadMoreRecycyleView = this.f29298d;
        if (loadMoreRecycyleView != null && loadMoreRecycyleView.getVisibility() == 8) {
            this.f29298d.setVisibility(0);
            this.f29300f.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (!com.shopee.live.livestreaming.util.d.a(this.v)) {
            com.shopee.sdk.b.a().e().a(getActivity(), NavigationPath.a(this.v), (o) null);
            this.w = true;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f29295a = activity;
    }

    public void onDestroy() {
        super.onDestroy();
        e();
        this.k.shutTask();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
    }

    public d a(int i2) {
        this.s = i2;
        com.shopee.live.livestreaming.ui.view.a.a aVar = this.r;
        if (aVar != null) {
            aVar.b(i2);
        }
        return this;
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public static void b(int i2) {
        q = i2;
    }
}
