package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class s extends RecyclerView.f {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations = true;

    public abstract boolean animateAdd(RecyclerView.w wVar);

    public abstract boolean animateChange(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4);

    public abstract boolean animateMove(RecyclerView.w wVar, int i, int i2, int i3, int i4);

    public abstract boolean animateRemove(RecyclerView.w wVar);

    public void onAddFinished(RecyclerView.w wVar) {
    }

    public void onAddStarting(RecyclerView.w wVar) {
    }

    public void onChangeFinished(RecyclerView.w wVar, boolean z) {
    }

    public void onChangeStarting(RecyclerView.w wVar, boolean z) {
    }

    public void onMoveFinished(RecyclerView.w wVar) {
    }

    public void onMoveStarting(RecyclerView.w wVar) {
    }

    public void onRemoveFinished(RecyclerView.w wVar) {
    }

    public void onRemoveStarting(RecyclerView.w wVar) {
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void setSupportsChangeAnimations(boolean z) {
        this.mSupportsChangeAnimations = z;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.w wVar) {
        return !this.mSupportsChangeAnimations || wVar.isInvalid();
    }

    public boolean animateDisappearance(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i = cVar.f2714a;
        int i2 = cVar.f2715b;
        View view = wVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f2714a;
        int top = cVar2 == null ? view.getTop() : cVar2.f2715b;
        if (wVar.isRemoved() || (i == left && i2 == top)) {
            return animateRemove(wVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return animateMove(wVar, i, i2, left, top);
    }

    public boolean animateAppearance(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar == null || (cVar.f2714a == cVar2.f2714a && cVar.f2715b == cVar2.f2715b)) {
            return animateAdd(wVar);
        }
        return animateMove(wVar, cVar.f2714a, cVar.f2715b, cVar2.f2714a, cVar2.f2715b);
    }

    public boolean animatePersistence(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.f2714a == cVar2.f2714a && cVar.f2715b == cVar2.f2715b) {
            dispatchMoveFinished(wVar);
            return false;
        }
        return animateMove(wVar, cVar.f2714a, cVar.f2715b, cVar2.f2714a, cVar2.f2715b);
    }

    public boolean animateChange(RecyclerView.w wVar, RecyclerView.w wVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f2714a;
        int i4 = cVar.f2715b;
        if (wVar2.shouldIgnore()) {
            int i5 = cVar.f2714a;
            i = cVar.f2715b;
            i2 = i5;
        } else {
            i2 = cVar2.f2714a;
            i = cVar2.f2715b;
        }
        return animateChange(wVar, wVar2, i3, i4, i2, i);
    }

    public final void dispatchRemoveFinished(RecyclerView.w wVar) {
        onRemoveFinished(wVar);
        dispatchAnimationFinished(wVar);
    }

    public final void dispatchMoveFinished(RecyclerView.w wVar) {
        onMoveFinished(wVar);
        dispatchAnimationFinished(wVar);
    }

    public final void dispatchAddFinished(RecyclerView.w wVar) {
        onAddFinished(wVar);
        dispatchAnimationFinished(wVar);
    }

    public final void dispatchChangeFinished(RecyclerView.w wVar, boolean z) {
        onChangeFinished(wVar, z);
        dispatchAnimationFinished(wVar);
    }

    public final void dispatchRemoveStarting(RecyclerView.w wVar) {
        onRemoveStarting(wVar);
    }

    public final void dispatchMoveStarting(RecyclerView.w wVar) {
        onMoveStarting(wVar);
    }

    public final void dispatchAddStarting(RecyclerView.w wVar) {
        onAddStarting(wVar);
    }

    public final void dispatchChangeStarting(RecyclerView.w wVar, boolean z) {
        onChangeStarting(wVar, z);
    }
}
