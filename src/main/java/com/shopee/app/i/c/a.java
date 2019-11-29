package com.shopee.app.i.c;

import android.app.Activity;
import android.content.Context;
import com.google.a.o;
import com.shopee.id.R;
import com.shopee.sdk.d.b;
import com.shopee.sdk.d.c;

public class a {
    public static c a() {
        c cVar = new c("LiveQuizRouter");
        cVar.a(new C0263a());
        return cVar;
    }

    /* renamed from: com.shopee.app.i.c.a$a  reason: collision with other inner class name */
    public static class C0263a extends b {
        public com.shopee.sdk.d.a a() {
            return com.shopee.sdk.d.a.a("ShopeeLiveQuiz");
        }

        public boolean a(Activity activity, o oVar) {
            com.shopee.app.ui.dialog.a.a((Context) activity, 0, (int) R.string.sp_function_not_available, 0, (int) R.string.sp_label_ok);
            return true;
        }
    }
}
