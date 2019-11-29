package com.shopee.sdk.modules.ui.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.google.a.o;
import com.google.a.q;
import com.shopee.sdk.modules.ui.navigator.a.a;
import com.shopee.sdk.modules.ui.navigator.a.b;
import com.shopee.sdk.modules.ui.navigator.options.JumpOption;
import com.shopee.sdk.modules.ui.navigator.options.PopOption;
import com.shopee.sdk.modules.ui.navigator.options.PushOption;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private b f30445a;

    public void a(Activity activity, NavigationPath navigationPath) {
        b(activity, navigationPath, new o(), PushOption.a());
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar) {
        if (oVar == null) {
            oVar = new o();
        }
        b(activity, navigationPath, oVar, PushOption.a());
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        if (oVar == null) {
            oVar = new o();
        }
        b(activity, navigationPath, oVar, pushOption);
    }

    public void a(Activity activity) {
        b(activity, new o(), PopOption.b(), b(activity));
    }

    public void a(Activity activity, o oVar, PopOption popOption) {
        if (oVar == null) {
            oVar = new o();
        }
        b(activity, oVar, popOption, b(activity));
    }

    public void a(Activity activity, NavigationPath navigationPath, o oVar, JumpOption jumpOption) {
        b bVar = this.f30445a;
        if (bVar != null) {
            bVar.a(activity, navigationPath, oVar, jumpOption);
        } else {
            a((Context) activity);
        }
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -98) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("PUSH_DATA_KEY");
                String stringExtra2 = intent.getStringExtra("FROM_INTENT_KEY");
                b(activity, new q().a(stringExtra).m(), (PopOption) intent.getParcelableExtra("ANIMATION_INTENT_KEY"), stringExtra2);
            }
        } else if (i2 == -99) {
            if (intent != null) {
                b(activity, (NavigationPath) intent.getParcelableExtra("NAVIGATION_PATH_INTENT_KEY"), new q().a(intent.getStringExtra("PUSH_DATA_KEY")).m(), (PushOption) intent.getParcelableExtra("ANIMATION_INTENT_KEY"));
            }
        } else if (!(activity instanceof b)) {
        } else {
            if (intent == null || !intent.hasExtra("PUSH_DATA_KEY") || !intent.hasExtra("FROM_INTENT_KEY")) {
                ((b) activity).a(i2, "", new o());
                return;
            }
            b bVar = (b) activity;
            bVar.a(i2, intent.getStringExtra("FROM_INTENT_KEY"), new q().a(intent.getStringExtra("PUSH_DATA_KEY")).m());
        }
    }

    private void b(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        if (pushOption.b() <= 0) {
            b(activity, navigationPath, oVar);
        } else if (pushOption.b() == 1) {
            b(activity, navigationPath, oVar);
            activity.overridePendingTransition(0, 0);
            activity.finish();
        } else if (pushOption.b() > 1) {
            pushOption.b(pushOption.b() - 1);
            c(activity, navigationPath, oVar, pushOption);
        }
    }

    private void b(Activity activity, NavigationPath navigationPath, o oVar) {
        if (navigationPath.f()) {
            activity.startActivityForResult(a.a((Context) activity, navigationPath.b(), oVar), 1021);
            return;
        }
        b bVar = this.f30445a;
        if (bVar != null) {
            bVar.a(activity, navigationPath, oVar);
        } else {
            a((Context) activity);
        }
    }

    private void c(Activity activity, NavigationPath navigationPath, o oVar, PushOption pushOption) {
        Intent intent = new Intent();
        intent.putExtra("ANIMATION_INTENT_KEY", pushOption);
        intent.putExtra("PUSH_DATA_KEY", oVar.toString());
        intent.putExtra("NAVIGATION_PATH_INTENT_KEY", navigationPath);
        activity.setResult(-99, intent);
        activity.finish();
    }

    private void a(Activity activity, o oVar, PopOption popOption, String str) {
        Intent intent = new Intent();
        intent.putExtra("PUSH_DATA_KEY", oVar.toString());
        intent.putExtra("ANIMATION_INTENT_KEY", popOption);
        intent.putExtra("FROM_INTENT_KEY", str);
        activity.setResult(-98, intent);
        activity.finish();
    }

    private void b(Activity activity, o oVar, PopOption popOption, String str) {
        if (popOption.a() > 1) {
            popOption.a(popOption.a() - 1);
            a(activity, oVar, popOption, str);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PUSH_DATA_KEY", oVar.toString());
        intent.putExtra("FROM_INTENT_KEY", str);
        activity.setResult(-1, intent);
        activity.finish();
    }

    private String b(Activity activity) {
        if (activity instanceof a) {
            return ((a) activity).a();
        }
        return activity.getClass().getSimpleName();
    }

    public void a(b bVar) {
        this.f30445a = bVar;
    }

    private void a(Context context) {
        Toast.makeText(context, "Feature not available", 0).show();
    }
}
