package androidx.core.g;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.a;
import androidx.core.g.a.d;
import androidx.core.g.a.e;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class a {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* renamed from: androidx.core.g.a$a  reason: collision with other inner class name */
    static final class C0034a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f1734a;

        C0034a(a aVar) {
            this.f1734a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1734a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1734a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            d a2 = d.a(accessibilityNodeInfo);
            a2.o(w.G(view));
            a2.q(w.I(view));
            a2.h(w.H(view));
            this.f1734a.onInitializeAccessibilityNodeInfo(view, a2);
            a2.a(accessibilityNodeInfo.getText(), view);
            List<d.a> actionList = a.getActionList(view);
            for (int i = 0; i < actionList.size(); i++) {
                a2.a(actionList.get(i));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1734a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1734a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f1734a.sendAccessibilityEvent(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1734a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            e accessibilityNodeProvider = this.f1734a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.a();
            }
            return null;
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f1734a.performAccessibilityAction(view, i, bundle);
        }
    }

    public a() {
        this(DEFAULT_DELEGATE);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new C0034a(this);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, dVar.a());
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public e getAccessibilityNodeProvider(View view) {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        AccessibilityNodeProvider accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new e(accessibilityNodeProvider);
        }
        return null;
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        List<d.a> actionList = getActionList(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= actionList.size()) {
                break;
            }
            d.a aVar = actionList.get(i2);
            if (aVar.a() == i) {
                z = aVar.a(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.mOriginalDelegate.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != a.c.accessibility_action_clickable_span) ? z : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean performClickableSpanAction(int i, View view) {
        SparseArray sparseArray = (SparseArray) view.getTag(a.c.tag_accessibility_clickable_spans);
        if (sparseArray == null) {
            return false;
        }
        WeakReference weakReference = (WeakReference) sparseArray.get(i);
        if (weakReference == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] d2 = d.d(view.createAccessibilityNodeInfo().getText());
            int i = 0;
            while (d2 != null && i < d2.length) {
                if (clickableSpan.equals(d2[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    static List<d.a> getActionList(View view) {
        List<d.a> list = (List) view.getTag(a.c.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
