package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.g.a.d;

public class q extends androidx.core.g.a {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f2968a;

    /* renamed from: b  reason: collision with root package name */
    final androidx.core.g.a f2969b = new a(this);

    public q(RecyclerView recyclerView) {
        this.f2968a = recyclerView;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f2968a.v();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (a() || this.f2968a.getLayoutManager() == null) {
            return false;
        }
        return this.f2968a.getLayoutManager().a(i, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        dVar.b((CharSequence) RecyclerView.class.getName());
        if (!a() && this.f2968a.getLayoutManager() != null) {
            this.f2968a.getLayoutManager().a(dVar);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    public androidx.core.g.a b() {
        return this.f2969b;
    }

    public static class a extends androidx.core.g.a {

        /* renamed from: a  reason: collision with root package name */
        final q f2970a;

        public a(q qVar) {
            this.f2970a = qVar;
        }

        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            if (!this.f2970a.a() && this.f2970a.f2968a.getLayoutManager() != null) {
                this.f2970a.f2968a.getLayoutManager().a(view, dVar);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.f2970a.a() || this.f2970a.f2968a.getLayoutManager() == null) {
                return false;
            }
            return this.f2970a.f2968a.getLayoutManager().a(view, i, bundle);
        }
    }
}
