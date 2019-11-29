package androidx.core.g.a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityRecord f1754a;

    @Deprecated
    public f(Object obj) {
        this.f1754a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static f a() {
        return new f(AccessibilityRecord.obtain());
    }

    @Deprecated
    public void a(boolean z) {
        this.f1754a.setScrollable(z);
    }

    @Deprecated
    public void a(int i) {
        this.f1754a.setItemCount(i);
    }

    @Deprecated
    public void b(int i) {
        this.f1754a.setFromIndex(i);
    }

    @Deprecated
    public void c(int i) {
        this.f1754a.setToIndex(i);
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f1754a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        AccessibilityRecord accessibilityRecord = this.f1754a;
        if (accessibilityRecord == null) {
            if (fVar.f1754a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(fVar.f1754a)) {
            return false;
        }
        return true;
    }
}
