package com.shopee.app.ui.a;

import androidx.recyclerview.widget.RecyclerView;
import com.shopee.app.tracking.ImpressionObserver;

public class t<T> extends y<T> {

    /* renamed from: c  reason: collision with root package name */
    private ImpressionObserver f19221c;

    public t(s<T> sVar, ImpressionObserver impressionObserver) {
        super(sVar);
        this.f19221c = impressionObserver;
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        a(wVar);
        super.onBindViewHolder(wVar, i);
        a(wVar, i);
    }

    public void onViewRecycled(RecyclerView.w wVar) {
        super.onViewRecycled(wVar);
        a(wVar);
    }

    private void a(RecyclerView.w wVar, int i) {
        if (this.f19221c != null && wVar != null && wVar.itemView != null) {
            this.f19221c.a(wVar.itemView, i);
        }
    }

    private void a(RecyclerView.w wVar) {
        if (this.f19221c != null && wVar != null && wVar.itemView != null) {
            this.f19221c.a(wVar.itemView);
        }
    }
}
