package fr.greweb.reactnativeviewshot;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.util.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Locale;
import java.util.Stack;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Matrix f33029a = new Matrix();

    public static int a(String str, String str2) {
        int i = 0;
        while (str2.length() > 0) {
            int indexOf = str2.indexOf("\n");
            int min = Math.min(str2.length(), Math.min(indexOf < 0 ? 200 : indexOf + 1, 200));
            Log.d(str, String.format(Locale.US, "%02d: %s", new Object[]{Integer.valueOf(i), str2.substring(0, min)}));
            str2 = str2.substring(min);
            i++;
        }
        return i;
    }

    public static String a(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        if (findViewById != null) {
            return a(findViewById);
        }
        return "Activity [" + activity.getClass().getSimpleName() + "] is not initialized yet. ";
    }

    private static String a(View view) {
        StringBuilder sb = new StringBuilder(8192);
        sb.append("\n");
        Resources resources = view.getResources();
        Stack stack = new Stack();
        stack.push(d.a("", view));
        while (!stack.empty()) {
            d dVar = (d) stack.pop();
            View view2 = (View) dVar.f1883b;
            String str = (String) dVar.f1882a;
            boolean z = stack.empty() || !str.equals(((d) stack.peek()).f1882a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(str);
            sb2.append(z ? "└── " : "├── ");
            sb.append(sb2.toString() + view2.getClass().getSimpleName() + a(resources, view2));
            sb.append("\n");
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(z ? "    " : "│   ");
                    stack.push(d.a(sb3.toString(), viewGroup.getChildAt(childCount)));
                }
            }
        }
        return sb.toString();
    }

    @TargetApi(21)
    private static String a(Resources resources, View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(SQLBuilder.BLANK);
        sb.append("id=");
        sb.append(view.getId());
        sb.append(b(resources, view));
        int visibility = view.getVisibility();
        if (visibility == 0) {
            sb.append(", V--");
        } else if (visibility == 4) {
            sb.append(", -I-");
        } else if (visibility != 8) {
            sb.append(", ---");
        } else {
            sb.append(", --G");
        }
        if (!view.getMatrix().equals(f33029a)) {
            sb.append(", ");
            sb.append("matrix=");
            sb.append(view.getMatrix().toShortString());
            if (!(BitmapDescriptorFactory.HUE_RED == view.getRotation() && BitmapDescriptorFactory.HUE_RED == view.getRotationX() && BitmapDescriptorFactory.HUE_RED == view.getRotationY())) {
                sb.append(", rotate=[");
                sb.append(view.getRotation());
                sb.append(",");
                sb.append(view.getRotationX());
                sb.append(",");
                sb.append(view.getRotationY());
                sb.append("]");
                if (!(((float) (view.getWidth() / 2)) == view.getPivotX() && ((float) (view.getHeight() / 2)) == view.getPivotY())) {
                    sb.append(", pivot=[");
                    sb.append(view.getPivotX());
                    sb.append(",");
                    sb.append(view.getPivotY());
                    sb.append("]");
                }
            }
            if (Build.VERSION.SDK_INT >= 21 && !(BitmapDescriptorFactory.HUE_RED == view.getTranslationX() && BitmapDescriptorFactory.HUE_RED == view.getTranslationY() && BitmapDescriptorFactory.HUE_RED == view.getTranslationZ())) {
                sb.append(", translate=[");
                sb.append(view.getTranslationX());
                sb.append(",");
                sb.append(view.getTranslationY());
                sb.append(",");
                sb.append(view.getTranslationZ());
                sb.append("]");
            }
            if (!(1.0f == view.getScaleX() && 1.0f == view.getScaleY())) {
                sb.append(", scale=[");
                sb.append(view.getScaleX());
                sb.append(",");
                sb.append(view.getScaleY());
                sb.append("]");
            }
        }
        if (!(view.getPaddingStart() == 0 && view.getPaddingTop() == 0 && view.getPaddingEnd() == 0 && view.getPaddingBottom() == 0)) {
            sb.append(", ");
            sb.append("padding=[");
            sb.append(view.getPaddingStart());
            sb.append(",");
            sb.append(view.getPaddingTop());
            sb.append(",");
            sb.append(view.getPaddingEnd());
            sb.append(",");
            sb.append(view.getPaddingBottom());
            sb.append("]");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (!(marginLayoutParams.leftMargin == 0 && marginLayoutParams.topMargin == 0 && marginLayoutParams.rightMargin == 0 && marginLayoutParams.bottomMargin == 0)) {
                sb.append(", ");
                sb.append("margin=[");
                sb.append(marginLayoutParams.leftMargin);
                sb.append(",");
                sb.append(marginLayoutParams.topMargin);
                sb.append(",");
                sb.append(marginLayoutParams.rightMargin);
                sb.append(",");
                sb.append(marginLayoutParams.bottomMargin);
                sb.append("]");
            }
        }
        sb.append(", position=[");
        sb.append(view.getLeft());
        sb.append(",");
        sb.append(view.getTop());
        sb.append("]");
        sb.append(", size=[");
        sb.append(view.getWidth());
        sb.append(",");
        sb.append(view.getHeight());
        sb.append("]");
        if (view instanceof TextView) {
            sb.append(", text=\"");
            sb.append(((TextView) view).getText());
            sb.append("\"");
        }
        return sb.toString();
    }

    private static String b(Resources resources, View view) {
        if (resources == null) {
            return "";
        }
        try {
            return " / " + resources.getResourceEntryName(view.getId());
        } catch (Throwable unused) {
            return "";
        }
    }
}
