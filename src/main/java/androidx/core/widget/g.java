package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class g {
    public static void a(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }

    public static boolean b(ListView listView, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            return listView.canScrollList(i);
        }
        int childCount = listView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (i > 0) {
            int bottom = listView.getChildAt(childCount - 1).getBottom();
            if (firstVisiblePosition + childCount < listView.getCount() || bottom > listView.getHeight() - listView.getListPaddingBottom()) {
                return true;
            }
            return false;
        }
        int top = listView.getChildAt(0).getTop();
        if (firstVisiblePosition > 0 || top < listView.getListPaddingTop()) {
            return true;
        }
        return false;
    }
}
