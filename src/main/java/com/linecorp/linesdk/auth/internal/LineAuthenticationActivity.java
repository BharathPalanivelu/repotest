package com.linecorp.linesdk.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.auth.LineAuthenticationConfig;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.linecorp.linesdk.auth.internal.a;
import com.linecorp.linesdk.auth.internal.c;
import com.linecorp.linesdk.auth.internal.d;
import com.linecorp.linesdk.b;
import com.linecorp.linesdk.c;
import java.util.List;

public class LineAuthenticationActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15057a = false;

    /* renamed from: b  reason: collision with root package name */
    private d f15058b;

    /* renamed from: c  reason: collision with root package name */
    private c f15059c;

    public static Intent a(Context context, LineAuthenticationConfig lineAuthenticationConfig, List<String> list) {
        Intent intent = new Intent(context, LineAuthenticationActivity.class);
        intent.putExtra("authentication_config", lineAuthenticationConfig);
        intent.putExtra(NativeProtocol.RESULT_ARGS_PERMISSIONS, (String[]) list.toArray(new String[list.size()]));
        return intent;
    }

    public static LineLoginResult a(Intent intent) {
        LineLoginResult lineLoginResult = (LineLoginResult) intent.getParcelableExtra("authentication_result");
        return lineLoginResult == null ? new LineLoginResult(b.INTERNAL_ERROR, new LineApiError("Authentication result is not found.")) : lineLoginResult;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        d dVar;
        super.onCreate(bundle);
        setContentView(c.a.linesdk_activity_lineauthentication);
        Intent intent = getIntent();
        LineAuthenticationConfig lineAuthenticationConfig = (LineAuthenticationConfig) intent.getParcelableExtra("authentication_config");
        if (lineAuthenticationConfig == null) {
            a(new LineLoginResult(b.INTERNAL_ERROR, new LineApiError("The requested parameter is illegal.")));
            return;
        }
        if (bundle == null) {
            dVar = new d();
        } else {
            dVar = (d) bundle.getParcelable("authenticationStatus");
            if (dVar == null) {
                dVar = new d();
            }
        }
        this.f15058b = dVar;
        this.f15059c = new c(this, lineAuthenticationConfig, this.f15058b, intent.getStringArrayExtra(NativeProtocol.RESULT_ARGS_PERMISSIONS));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f15058b.f15089d == d.a.f15090a) {
            c cVar = this.f15059c;
            cVar.h.f15089d = d.a.f15091b;
            new c.C0247c(cVar, (byte) 0).execute(new Void[0]);
        } else if (this.f15058b.f15089d != d.a.f15092c) {
            new Handler(Looper.getMainLooper()).postDelayed(new c.b(this.f15059c, (byte) 0), 1000);
        }
        this.f15057a = false;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f15057a = true;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        a.c cVar;
        super.onNewIntent(intent);
        if (this.f15058b.f15089d == d.a.f15091b) {
            c cVar2 = this.f15059c;
            cVar2.h.f15089d = d.a.f15092c;
            a aVar = cVar2.f15080e;
            Uri data = intent.getData();
            if (data == null) {
                cVar = a.c.a("Illegal redirection from external application.");
            } else {
                String str = aVar.f15061b.f15088c;
                String queryParameter = data.getQueryParameter(ServerProtocol.DIALOG_PARAM_STATE);
                if (str == null || !str.equals(queryParameter)) {
                    cVar = a.c.a("Illegal parameter value of 'state'.");
                } else {
                    String queryParameter2 = data.getQueryParameter("code");
                    cVar = !TextUtils.isEmpty(queryParameter2) ? new a.c(queryParameter2, (String) null, (String) null, (String) null) : new a.c((String) null, data.getQueryParameter("error"), data.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION), (String) null);
                }
            }
            if (!cVar.a()) {
                cVar2.h.f15089d = d.a.f15093d;
                cVar2.f15076a.a(new LineLoginResult(cVar.b() ? b.AUTHENTICATION_AGENT_ERROR : b.INTERNAL_ERROR, cVar.c()));
                return;
            }
            c.a aVar2 = new c.a(cVar2, (byte) 0);
            String[] strArr = new String[1];
            if (!TextUtils.isEmpty(cVar.f15069a)) {
                strArr[0] = cVar.f15069a;
                aVar2.execute(strArr);
                return;
            }
            throw new UnsupportedOperationException("requestToken is null. Please check result by isSuccess before.");
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f15058b.f15089d == d.a.f15091b) {
            c cVar = this.f15059c;
            if (i == 3 && cVar.h.f15089d != d.a.f15092c) {
                new Handler(Looper.getMainLooper()).postDelayed(new c.b(cVar, (byte) 0), 1000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("authenticationStatus", this.f15058b);
    }

    /* access modifiers changed from: package-private */
    public final void a(LineLoginResult lineLoginResult) {
        d dVar = this.f15058b;
        if (dVar == null) {
            finish();
        } else if ((dVar.f15089d == d.a.f15091b && !this.f15057a) || this.f15058b.f15089d == d.a.f15093d) {
            Intent intent = new Intent();
            intent.putExtra("authentication_result", lineLoginResult);
            setResult(-1, intent);
            finish();
        }
    }
}
