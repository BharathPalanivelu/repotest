package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.a.a;
import com.appsflyer.share.Constants;
import com.facebook.FacebookSdk;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        bundle = bundle == null ? new Bundle() : bundle;
        String dialogAuthority = ServerProtocol.getDialogAuthority();
        this.uri = Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + Constants.URL_PATH_DELIMITER + ServerProtocol.DIALOG_PATH + str, bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        a a2 = new a.C0023a().a();
        a2.f1316a.setPackage(str);
        a2.f1316a.addFlags(1073741824);
        a2.a(activity, this.uri);
    }
}
