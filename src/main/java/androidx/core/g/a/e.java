package androidx.core.g.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1752a;

    public d a(int i) {
        return null;
    }

    public List<d> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public d b(int i) {
        return null;
    }

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final e f1753a;

        a(e eVar) {
            this.f1753a = eVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            d a2 = this.f1753a.a(i);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<d> a2 = this.f1753a.a(str, i);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a2.get(i2).a());
            }
            return arrayList;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f1753a.a(i, i2, bundle);
        }
    }

    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            d b2 = this.f1753a.b(i);
            if (b2 == null) {
                return null;
            }
            return b2.a();
        }
    }

    public e() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1752a = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f1752a = new a(this);
        } else {
            this.f1752a = null;
        }
    }

    public e(Object obj) {
        this.f1752a = obj;
    }

    public Object a() {
        return this.f1752a;
    }
}
