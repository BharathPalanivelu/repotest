package com.shopee.app.util;

import android.view.View;
import com.shopee.app.tracking.g;
import com.shopee.id.R;
import com.shopee.shopeetracker.bimodel.FormRowValidateError;

public class d {
    public static void a(View view, String str, g gVar) {
        FormRowValidateError formRowValidateError = new FormRowValidateError();
        formRowValidateError.field = str;
        if (gVar != null) {
            formRowValidateError.error = String.valueOf(gVar.getValue());
        }
        view.setTag(R.id.tracking_info_tag, formRowValidateError);
    }
}
