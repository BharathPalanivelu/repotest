package com.shopee.app.util;

import android.app.Activity;
import com.shopee.id.R;
import d.d.b.j;

public final class aj {
    public static final void a(Activity activity, int i) {
        j.b(activity, "activity");
        if (i == 0) {
            return;
        }
        if (i == 1) {
            activity.overridePendingTransition(R.anim.slide_in_from_bottom_fast, R.anim.not_move_ani);
        } else if (i == 3) {
            activity.overridePendingTransition(0, 0);
        } else if (i != 4) {
            activity.overridePendingTransition(0, 0);
        } else {
            activity.overridePendingTransition(R.anim.slide_in_from_right_fast, R.anim.not_move_ani);
        }
    }

    public static final void b(Activity activity, int i) {
        j.b(activity, "activity");
        if (i == 0) {
            return;
        }
        if (i == 1) {
            activity.overridePendingTransition(R.anim.not_move_ani, R.anim.slide_out_from_bottom_fast);
        } else if (i == 3) {
            activity.overridePendingTransition(0, 0);
        } else if (i != 4) {
            activity.overridePendingTransition(0, 0);
        } else {
            activity.overridePendingTransition(R.anim.not_move_ani, R.anim.slide_out_from_right_fast);
        }
    }
}
