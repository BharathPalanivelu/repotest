package com.d.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class e extends RecyclerView.a<RecyclerView.w> {

    /* renamed from: a  reason: collision with root package name */
    private int f6623a;

    /* renamed from: b  reason: collision with root package name */
    private int f6624b;

    /* renamed from: c  reason: collision with root package name */
    private int f6625c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6626d;

    /* renamed from: e  reason: collision with root package name */
    private int f6627e;

    /* renamed from: f  reason: collision with root package name */
    private int f6628f;

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (this.f6626d) {
            return new c(from, viewGroup, this.f6624b);
        }
        return new RecyclerView.w(from.inflate(this.f6624b, viewGroup, false)) {
        };
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        if (this.f6626d) {
            ShimmerLayout shimmerLayout = (ShimmerLayout) wVar.itemView;
            shimmerLayout.setShimmerAnimationDuration(this.f6627e);
            shimmerLayout.setShimmerAngle(this.f6628f);
            shimmerLayout.setShimmerColor(this.f6625c);
            shimmerLayout.a();
        }
    }

    public int getItemCount() {
        return this.f6623a;
    }

    public void a(int i) {
        this.f6624b = i;
    }

    public void b(int i) {
        this.f6623a = i;
    }

    public void c(int i) {
        this.f6625c = i;
    }

    public void a(boolean z) {
        this.f6626d = z;
    }

    public void d(int i) {
        this.f6627e = i;
    }

    public void e(int i) {
        this.f6628f = i;
    }
}
