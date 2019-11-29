package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class r {
    static int a(RecyclerView.t tVar, p pVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        int i;
        if (iVar.y() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar.d(view), iVar.d(view2));
        int max = Math.max(iVar.d(view), iVar.d(view2));
        if (z2) {
            i = Math.max(0, (tVar.e() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(pVar.b(view2) - pVar.a(view))) / ((float) (Math.abs(iVar.d(view) - iVar.d(view2)) + 1)))) + ((float) (pVar.c() - pVar.a(view))));
    }

    static int a(RecyclerView.t tVar, p pVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.y() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.d(view) - iVar.d(view2)) + 1;
        }
        return Math.min(pVar.f(), pVar.b(view2) - pVar.a(view));
    }

    static int b(RecyclerView.t tVar, p pVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.y() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tVar.e();
        }
        return (int) ((((float) (pVar.b(view2) - pVar.a(view))) / ((float) (Math.abs(iVar.d(view) - iVar.d(view2)) + 1))) * ((float) tVar.e()));
    }
}
