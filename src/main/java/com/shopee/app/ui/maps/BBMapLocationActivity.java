package com.shopee.app.ui.maps;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class BBMapLocationActivity extends c {

    /* renamed from: a  reason: collision with root package name */
    a f23184a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f23184a = d.a(this, intent.getIntExtra("geocode", 0));
        if (intent.hasExtra("BUNDLE_LATITUDE_KEY")) {
            float floatExtra = intent.getFloatExtra("BUNDLE_LATITUDE_KEY", BitmapDescriptorFactory.HUE_RED);
            float floatExtra2 = intent.getFloatExtra("BUNDLE_LONGITUDE_KEY", BitmapDescriptorFactory.HUE_RED);
            this.f23184a.a(floatExtra, floatExtra2);
            if (intent.hasExtra("BUNDLE_SET_MARKER_ID")) {
                this.f23184a.a(floatExtra, floatExtra2, intent.getStringExtra("BUNDLE_SET_MARKER_ID"), intent.getStringExtra("BUNDLE_SHOP_NAME_ID"));
            }
        }
        if (intent.hasExtra("BUNDLE_TITLE_KEY")) {
            this.f23184a.setTitle(intent.getStringExtra("BUNDLE_TITLE_KEY"));
        }
        if (intent.hasExtra("BUNDLE_SEND_ACTION_KEY")) {
            this.f23184a.setSendAction(intent.getBooleanExtra("BUNDLE_SEND_ACTION_KEY", false));
        }
        if (intent.hasExtra("BUNDLE_HOME_ACTION_ID")) {
            this.f23184a.setHomeAction(intent.getIntExtra("BUNDLE_HOME_ACTION_ID", -1));
        }
        setContentView(this.f23184a);
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        a aVar = this.f23184a;
        if (aVar != null) {
            aVar.d();
        }
        super.onDestroy();
    }
}
