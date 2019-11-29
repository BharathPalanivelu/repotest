package com.shopee.app.ui.gallery;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.data.viewmodel.GalleryItemInfo;
import com.shopee.app.util.w;
import java.util.ArrayList;
import java.util.List;

public class f extends RecyclerView.a<c> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f21888a;

    /* renamed from: b  reason: collision with root package name */
    private List<GalleryItemInfo> f21889b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f21890c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f21891d;

    /* renamed from: e  reason: collision with root package name */
    private String f21892e;

    public interface a {
        boolean a(GalleryItemInfo galleryItemInfo, boolean z);

        boolean a(String str);
    }

    public interface b {
        void a(List<GalleryData> list, int i, GalleryData galleryData);
    }

    public f(boolean z, String str) {
        this.f21888a = z;
        this.f21892e = str;
    }

    public void a(List<GalleryItemInfo> list) {
        this.f21889b = list;
    }

    public long getItemId(int i) {
        return (long) this.f21889b.get(i).hashCode();
    }

    /* renamed from: a */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(p.a(viewGroup.getContext(), this.f21888a));
    }

    public void a(b bVar) {
        this.f21890c = bVar;
    }

    public void a(a aVar) {
        this.f21891d = aVar;
    }

    /* access modifiers changed from: private */
    public List<GalleryData> a() {
        ArrayList arrayList = new ArrayList();
        for (GalleryItemInfo next : this.f21889b) {
            boolean a2 = w.a(next, this.f21892e);
            if (a(next.getPath()) && a2) {
                arrayList.add(GalleryData.a(next, a(next.getPath()), false));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void onBindViewHolder(final c cVar, int i) {
        final GalleryItemInfo galleryItemInfo = this.f21889b.get(i);
        final GalleryData a2 = GalleryData.a(galleryItemInfo, a(galleryItemInfo.getPath()), !w.a(galleryItemInfo, this.f21892e));
        cVar.f21900a.a(a2);
        cVar.f21900a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (f.this.f21890c != null && cVar.getAdapterPosition() != -1) {
                    f.this.f21890c.a(f.this.a(), cVar.getAdapterPosition(), a2);
                }
            }
        });
        cVar.f21900a.setCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (f.this.f21891d != null) {
                    a2.f21837a = z;
                    if (!f.this.f21891d.a(galleryItemInfo, z)) {
                        a2.f21837a = false;
                        cVar.f21900a.setCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                        cVar.f21900a.f21985c.setChecked(false);
                        cVar.f21900a.setCheckedChangeListener(this);
                    }
                }
            }
        });
    }

    private boolean a(String str) {
        a aVar = this.f21891d;
        if (aVar != null) {
            return aVar.a(str);
        }
        return false;
    }

    public int getItemCount() {
        return this.f21889b.size();
    }

    public GalleryItemInfo a(int i) {
        return this.f21889b.get(i);
    }

    public static class c extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        public o f21900a;

        public c(o oVar) {
            super(oVar);
            this.f21900a = oVar;
        }
    }
}
