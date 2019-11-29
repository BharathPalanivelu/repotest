package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e extends s {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<RecyclerView.w> mAddAnimations = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.w>> mAdditionsList = new ArrayList<>();
    ArrayList<RecyclerView.w> mChangeAnimations = new ArrayList<>();
    ArrayList<ArrayList<a>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.w> mMoveAnimations = new ArrayList<>();
    ArrayList<ArrayList<b>> mMovesList = new ArrayList<>();
    private ArrayList<RecyclerView.w> mPendingAdditions = new ArrayList<>();
    private ArrayList<a> mPendingChanges = new ArrayList<>();
    private ArrayList<b> mPendingMoves = new ArrayList<>();
    private ArrayList<RecyclerView.w> mPendingRemovals = new ArrayList<>();
    ArrayList<RecyclerView.w> mRemoveAnimations = new ArrayList<>();

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.w f2870a;

        /* renamed from: b  reason: collision with root package name */
        public int f2871b;

        /* renamed from: c  reason: collision with root package name */
        public int f2872c;

        /* renamed from: d  reason: collision with root package name */
        public int f2873d;

        /* renamed from: e  reason: collision with root package name */
        public int f2874e;

        b(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
            this.f2870a = wVar;
            this.f2871b = i;
            this.f2872c = i2;
            this.f2873d = i3;
            this.f2874e = i4;
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.w f2864a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.w f2865b;

        /* renamed from: c  reason: collision with root package name */
        public int f2866c;

        /* renamed from: d  reason: collision with root package name */
        public int f2867d;

        /* renamed from: e  reason: collision with root package name */
        public int f2868e;

        /* renamed from: f  reason: collision with root package name */
        public int f2869f;

        private a(RecyclerView.w wVar, RecyclerView.w wVar2) {
            this.f2864a = wVar;
            this.f2865b = wVar2;
        }

        a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4) {
            this(wVar, wVar2);
            this.f2866c = i;
            this.f2867d = i2;
            this.f2868e = i3;
            this.f2869f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2864a + ", newHolder=" + this.f2865b + ", fromX=" + this.f2866c + ", fromY=" + this.f2867d + ", toX=" + this.f2868e + ", toY=" + this.f2869f + '}';
        }
    }

    public void runPendingAnimations() {
        boolean z = !this.mPendingRemovals.isEmpty();
        boolean z2 = !this.mPendingMoves.isEmpty();
        boolean z3 = !this.mPendingChanges.isEmpty();
        boolean z4 = !this.mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.w> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            e.this.animateMoveImpl(bVar.f2870a, bVar.f2871b, bVar.f2872c, bVar.f2873d, bVar.f2874e);
                        }
                        arrayList.clear();
                        e.this.mMovesList.remove(arrayList);
                    }
                };
                if (z) {
                    w.a(((b) arrayList.get(0)).f2870a.itemView, (Runnable) r6, getRemoveDuration());
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            e.this.animateChangeImpl((a) it.next());
                        }
                        arrayList2.clear();
                        e.this.mChangesList.remove(arrayList2);
                    }
                };
                if (z) {
                    w.a(((a) arrayList2.get(0)).f2864a.itemView, (Runnable) r62, getRemoveDuration());
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            e.this.animateAddImpl((RecyclerView.w) it.next());
                        }
                        arrayList3.clear();
                        e.this.mAdditionsList.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j = 0;
                    long removeDuration = z ? getRemoveDuration() : 0;
                    long moveDuration = z2 ? getMoveDuration() : 0;
                    if (z3) {
                        j = getChangeDuration();
                    }
                    w.a(((RecyclerView.w) arrayList3.get(0)).itemView, (Runnable) r5, removeDuration + Math.max(moveDuration, j));
                    return;
                }
                r5.run();
            }
        }
    }

    public boolean animateRemove(RecyclerView.w wVar) {
        resetAnimation(wVar);
        this.mPendingRemovals.add(wVar);
        return true;
    }

    private void animateRemoveImpl(final RecyclerView.w wVar) {
        final View view = wVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(wVar);
        animate.setDuration(getRemoveDuration()).alpha(BitmapDescriptorFactory.HUE_RED).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                e.this.dispatchRemoveStarting(wVar);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                e.this.dispatchRemoveFinished(wVar);
                e.this.mRemoveAnimations.remove(wVar);
                e.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateAdd(RecyclerView.w wVar) {
        resetAnimation(wVar);
        wVar.itemView.setAlpha(BitmapDescriptorFactory.HUE_RED);
        this.mPendingAdditions.add(wVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateAddImpl(final RecyclerView.w wVar) {
        final View view = wVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(wVar);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                e.this.dispatchAddStarting(wVar);
            }

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                e.this.dispatchAddFinished(wVar);
                e.this.mAddAnimations.remove(wVar);
                e.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateMove(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
        View view = wVar.itemView;
        int translationX = i + ((int) wVar.itemView.getTranslationX());
        int translationY = i2 + ((int) wVar.itemView.getTranslationY());
        resetAnimation(wVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(wVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.mPendingMoves.add(new b(wVar, translationX, translationY, i3, i4));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateMoveImpl(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
        final View view = wVar.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(BitmapDescriptorFactory.HUE_RED);
        }
        if (i6 != 0) {
            view.animate().translationY(BitmapDescriptorFactory.HUE_RED);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(wVar);
        final RecyclerView.w wVar2 = wVar;
        animate.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                e.this.dispatchMoveStarting(wVar2);
            }

            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                }
                if (i6 != 0) {
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                e.this.dispatchMoveFinished(wVar2);
                e.this.mMoveAnimations.remove(wVar2);
                e.this.dispatchFinishedWhenDone();
            }
        }).start();
    }

    public boolean animateChange(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4) {
        if (wVar == wVar2) {
            return animateMove(wVar, i, i2, i3, i4);
        }
        float translationX = wVar.itemView.getTranslationX();
        float translationY = wVar.itemView.getTranslationY();
        float alpha = wVar.itemView.getAlpha();
        resetAnimation(wVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        wVar.itemView.setTranslationX(translationX);
        wVar.itemView.setTranslationY(translationY);
        wVar.itemView.setAlpha(alpha);
        if (wVar2 != null) {
            resetAnimation(wVar2);
            wVar2.itemView.setTranslationX((float) (-i5));
            wVar2.itemView.setTranslationY((float) (-i6));
            wVar2.itemView.setAlpha(BitmapDescriptorFactory.HUE_RED);
        }
        this.mPendingChanges.add(new a(wVar, wVar2, i, i2, i3, i4));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateChangeImpl(final a aVar) {
        final View view;
        RecyclerView.w wVar = aVar.f2864a;
        final View view2 = null;
        if (wVar == null) {
            view = null;
        } else {
            view = wVar.itemView;
        }
        RecyclerView.w wVar2 = aVar.f2865b;
        if (wVar2 != null) {
            view2 = wVar2.itemView;
        }
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(aVar.f2864a);
            duration.translationX((float) (aVar.f2868e - aVar.f2866c));
            duration.translationY((float) (aVar.f2869f - aVar.f2867d));
            duration.alpha(BitmapDescriptorFactory.HUE_RED).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    e.this.dispatchChangeStarting(aVar.f2864a, true);
                }

                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    e.this.dispatchChangeFinished(aVar.f2864a, true);
                    e.this.mChangeAnimations.remove(aVar.f2864a);
                    e.this.dispatchFinishedWhenDone();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(aVar.f2865b);
            animate.translationX(BitmapDescriptorFactory.HUE_RED).translationY(BitmapDescriptorFactory.HUE_RED).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    e.this.dispatchChangeStarting(aVar.f2865b, false);
                }

                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    view2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    e.this.dispatchChangeFinished(aVar.f2865b, false);
                    e.this.mChangeAnimations.remove(aVar.f2865b);
                    e.this.dispatchFinishedWhenDone();
                }
            }).start();
        }
    }

    private void endChangeAnimation(List<a> list, RecyclerView.w wVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (endChangeAnimationIfNecessary(aVar, wVar) && aVar.f2864a == null && aVar.f2865b == null) {
                list.remove(aVar);
            }
        }
    }

    private void endChangeAnimationIfNecessary(a aVar) {
        if (aVar.f2864a != null) {
            endChangeAnimationIfNecessary(aVar, aVar.f2864a);
        }
        if (aVar.f2865b != null) {
            endChangeAnimationIfNecessary(aVar, aVar.f2865b);
        }
    }

    private boolean endChangeAnimationIfNecessary(a aVar, RecyclerView.w wVar) {
        boolean z = false;
        if (aVar.f2865b == wVar) {
            aVar.f2865b = null;
        } else if (aVar.f2864a != wVar) {
            return false;
        } else {
            aVar.f2864a = null;
            z = true;
        }
        wVar.itemView.setAlpha(1.0f);
        wVar.itemView.setTranslationX(BitmapDescriptorFactory.HUE_RED);
        wVar.itemView.setTranslationY(BitmapDescriptorFactory.HUE_RED);
        dispatchChangeFinished(wVar, z);
        return true;
    }

    public void endAnimation(RecyclerView.w wVar) {
        View view = wVar.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.mPendingMoves.get(size).f2870a == wVar) {
                view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                dispatchMoveFinished(wVar);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, wVar);
        if (this.mPendingRemovals.remove(wVar)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(wVar);
        }
        if (this.mPendingAdditions.remove(wVar)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(wVar);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, wVar);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f2870a == wVar) {
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    dispatchMoveFinished(wVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(wVar)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(wVar);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(wVar);
        this.mAddAnimations.remove(wVar);
        this.mChangeAnimations.remove(wVar);
        this.mMoveAnimations.remove(wVar);
        dispatchFinishedWhenDone();
    }

    private void resetAnimation(RecyclerView.w wVar) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        wVar.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(wVar);
    }

    public boolean isRunning() {
        return !this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.mPendingMoves.get(size);
            View view = bVar.f2870a.itemView;
            view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
            dispatchMoveFinished(bVar.f2870a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.w wVar = this.mPendingAdditions.get(size3);
            wVar.itemView.setAlpha(1.0f);
            dispatchAddFinished(wVar);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f2870a.itemView;
                    view2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    view2.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    dispatchMoveFinished(bVar2.f2870a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.w wVar2 = (RecyclerView.w) arrayList2.get(size8);
                    wVar2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(wVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelAll(List<RecyclerView.w> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.w wVar, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(wVar, list);
    }
}
