package com.shopee.app.react.protocol;

import android.text.TextUtils;
import com.shopee.app.util.af;
import java.util.List;

public class Manifest {
    private List<ReactBundle> bundles;
    private String updated_at;

    public List<ReactBundle> getBundles() {
        return this.bundles;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.updated_at) && af.a(this.bundles);
    }
}
