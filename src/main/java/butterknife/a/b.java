package butterknife.a;

import android.util.TypedValue;
import android.view.View;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final TypedValue f3076a = new TypedValue();

    public static View a(View view, int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String a2 = a(view, i);
        throw new IllegalStateException("Required view '" + a2 + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T a(View view, int i, String str, Class<T> cls) {
        return b(a(view, i, str), i, str, cls);
    }

    public static <T> T b(View view, int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e2) {
            String a2 = a(view, i);
            throw new IllegalStateException("View '" + a2 + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e2);
        }
    }

    private static String a(View view, int i) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i);
    }
}
