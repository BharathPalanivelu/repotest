package androidx.core.g.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

public final class c {

    public interface a {
        void a(boolean z);
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }

    private static class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final a f1738a;

        b(a aVar) {
            this.f1738a = aVar;
        }

        public int hashCode() {
            return this.f1738a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f1738a.equals(((b) obj).f1738a);
        }

        public void onTouchExplorationStateChanged(boolean z) {
            this.f1738a.a(z);
        }
    }
}
