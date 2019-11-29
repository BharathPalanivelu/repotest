package com.google.android.libraries.places.internal;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.g.w;
import androidx.f.a.a.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.libraries.places.R;
import java.util.ArrayList;

@TargetApi(14)
public final class fn extends e {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<RecyclerView.w> f12562a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<RecyclerView.w> f12563b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<RecyclerView.w> f12564c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final int f12565d;

    public fn(Resources resources) {
        this.f12565d = resources.getDimensionPixelSize(R.dimen.places_autocomplete_vertical_dropdown);
    }

    public final boolean animateAdd(RecyclerView.w wVar) {
        try {
            endAnimation(wVar);
            w.a(wVar.itemView, (float) BitmapDescriptorFactory.HUE_RED);
            if (!(wVar instanceof fq) || !((fq) wVar).f12571b) {
                this.f12564c.add(wVar);
                return true;
            }
            this.f12563b.add(wVar);
            return true;
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void endAnimation(RecyclerView.w wVar) {
        try {
            super.endAnimation(wVar);
            View view = wVar.itemView;
            if (this.f12563b.remove(wVar)) {
                a(view);
                dispatchAddFinished(wVar);
            }
            a();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final boolean isRunning() {
        try {
            return super.isRunning() || !this.f12563b.isEmpty() || !this.f12562a.isEmpty();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void endAnimations() {
        try {
            for (int size = this.f12563b.size() - 1; size >= 0; size--) {
                RecyclerView.w wVar = this.f12563b.get(size);
                a(wVar.itemView);
                dispatchAddFinished(wVar);
                this.f12563b.remove(size);
            }
            ArrayList<RecyclerView.w> arrayList = this.f12562a;
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                arrayList.get(size2).itemView.animate().cancel();
            }
            super.endAnimations();
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    public final void runPendingAnimations() {
        try {
            ArrayList arrayList = this.f12564c;
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                super.animateAdd((RecyclerView.w) obj);
            }
            this.f12564c.clear();
            super.runPendingAnimations();
            if (!this.f12563b.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(this.f12563b);
                this.f12563b.clear();
                ArrayList arrayList3 = arrayList2;
                int size2 = arrayList3.size();
                while (i < size2) {
                    Object obj2 = arrayList3.get(i);
                    i++;
                    RecyclerView.w wVar = (RecyclerView.w) obj2;
                    View view = wVar.itemView;
                    this.f12562a.add(wVar);
                    long moveDuration = getMoveDuration();
                    if (wVar instanceof fq) {
                        moveDuration += (long) (((fq) wVar).f12570a * 67);
                    }
                    view.setTranslationY((float) (-this.f12565d));
                    view.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    ViewPropertyAnimator animate = view.animate();
                    animate.cancel();
                    animate.translationY(BitmapDescriptorFactory.HUE_RED).alpha(1.0f).setDuration(133).setInterpolator(new b()).setStartDelay(moveDuration);
                    animate.setListener(new fo(this, view, wVar, animate)).start();
                }
            }
        } catch (Error | RuntimeException e2) {
            dx.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    static void a(View view) {
        view.setAlpha(1.0f);
        view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
    }
}
