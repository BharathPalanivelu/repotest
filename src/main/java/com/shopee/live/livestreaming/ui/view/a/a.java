package com.shopee.live.livestreaming.ui.view.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.live.livestreaming.a.d;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.UpLoadShowProductTask;
import com.shopee.live.livestreaming.ui.view.e.b;
import com.shopee.live.livestreaming.ui.view.e.c;
import com.shopee.live.livestreaming.util.z;

public class a extends d<SessionProductEntity.ProductItem> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f29184e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f29185f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f29186g = "";
    /* access modifiers changed from: private */
    public int h = 19;
    private int i;
    private UpLoadShowProductTask j = InjectorUtils.provideUpLoadShowProductTask();
    /* access modifiers changed from: private */
    public C0442a k;

    /* renamed from: com.shopee.live.livestreaming.ui.view.a.a$a  reason: collision with other inner class name */
    public interface C0442a {
        void a(SessionProductEntity.ProductItem productItem);
    }

    public a(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        int i3 = this.h;
        if (i3 == 18 || i3 == 17 || i3 == 19) {
            return com.shopee.live.livestreaming.ui.view.e.a.a(this.f28753c, viewGroup);
        }
        return b.a(this.f28753c, viewGroup);
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i2) {
        SessionProductEntity.ProductItem productItem = (SessionProductEntity.ProductItem) this.f28752b.get(i2);
        c cVar = (c) wVar;
        cVar.a(i2, productItem);
        int i3 = this.h;
        if (i3 == 18 || i3 == 17) {
            a((com.shopee.live.livestreaming.ui.view.e.a) cVar, i2, productItem);
        } else if (i3 == 20 || i3 == 21) {
            a((b) cVar, i2, productItem);
        }
    }

    private void a(final com.shopee.live.livestreaming.ui.view.e.a aVar, int i2, final SessionProductEntity.ProductItem productItem) {
        if (this.f29186g.equals(a(productItem))) {
            this.f29184e = aVar.getAdapterPosition();
            aVar.c();
            return;
        }
        aVar.a();
        aVar.a(new View.OnClickListener() {
            public void onClick(View view) {
                if (aVar.getAdapterPosition() != a.this.f29184e) {
                    aVar.b();
                    a.this.a(productItem, (UpLoadShowProductTask.Callback) new UpLoadShowProductTask.Callback() {
                        public void upLoadSuccess() {
                            int adapterPosition = aVar.getAdapterPosition();
                            int unused = a.this.f29185f = a.this.f29184e;
                            int unused2 = a.this.f29184e = adapterPosition;
                            String unused3 = a.this.f29186g = a.this.a(productItem);
                            a.this.notifyItemChanged(a.this.f29185f);
                            a.this.notifyItemChanged(a.this.f29184e);
                            if (a.this.f28754d != null) {
                                a.this.f28754d.a(adapterPosition, productItem, aVar.d());
                            }
                        }

                        public void onError(int i, String str) {
                            aVar.a();
                        }
                    });
                }
            }
        });
    }

    private void a(final b bVar, int i2, final SessionProductEntity.ProductItem productItem) {
        AnonymousClass2 r3 = new View.OnClickListener() {
            public void onClick(View view) {
                int adapterPosition = bVar.getAdapterPosition();
                if (a.this.f28754d != null) {
                    if (a.this.h == 20) {
                        com.shopee.live.livestreaming.ui.audience.c.e(productItem.getItem_id(), productItem.getShop_id(), adapterPosition);
                    } else {
                        com.shopee.live.livestreaming.ui.audience.c.f(productItem.getItem_id(), productItem.getShop_id(), adapterPosition);
                    }
                    a.this.f28754d.a(adapterPosition, productItem, bVar.a());
                }
                if (a.this.h == 20) {
                    com.shopee.live.livestreaming.ui.audience.c.b(productItem.getItem_id(), productItem.getShop_id(), adapterPosition);
                } else {
                    com.shopee.live.livestreaming.ui.audience.c.d(productItem.getItem_id(), productItem.getShop_id(), adapterPosition);
                }
            }
        };
        bVar.b().setOnClickListener(r3);
        bVar.a().setOnClickListener(r3);
        bVar.c().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.k != null) {
                    a.this.k.a(productItem);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(SessionProductEntity.ProductItem productItem, final UpLoadShowProductTask.Callback callback) {
        this.j.execute(new UpLoadShowProductTask.Data(b(), productItem), new UpLoadShowProductTask.Callback() {
            public void upLoadSuccess() {
                callback.upLoadSuccess();
            }

            public void onError(int i, String str) {
                if (!com.shopee.live.livestreaming.util.d.a(str)) {
                    z.a(a.this.f28751a, str);
                }
                callback.onError(i, str);
            }
        });
    }

    public void b(int i2) {
        this.h = i2;
    }

    public void a(String str) {
        this.f29186g = str;
    }

    public String a() {
        String str = this.f29186g;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: private */
    public String a(SessionProductEntity.ProductItem productItem) {
        return "" + productItem.getShop_id() + productItem.getItem_id();
    }

    public void c(int i2) {
        this.i = i2;
    }

    public int b() {
        return this.i;
    }

    public void a(C0442a aVar) {
        this.k = aVar;
    }
}
