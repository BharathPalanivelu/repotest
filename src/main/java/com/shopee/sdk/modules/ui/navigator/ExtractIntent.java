package com.shopee.sdk.modules.ui.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.a.f;
import com.google.a.o;
import com.google.a.q;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExtractIntent {
    public static Intent a(Context context, Class<? extends Activity> cls, o oVar) {
        if (oVar == null) {
            oVar = new o();
        }
        Intent intent = new Intent(context, cls);
        intent.putExtra("PUSH_DATA_KEY", oVar.toString());
        return intent;
    }

    public static <T> Intent a(Context context, Class<? extends Activity> cls, T t) {
        if (t == null) {
            return a(context, cls, new o());
        }
        Intent intent = new Intent(context, cls);
        intent.putExtra("PUSH_DATA_KEY", new f().b((Object) t));
        return intent;
    }

    public static JsonObject a(Intent intent) {
        if (intent == null) {
            return new JsonObject();
        }
        if (!intent.hasExtra("PUSH_DATA_KEY")) {
            return new JsonObject();
        }
        try {
//            return new q().a(intent.getStringExtra("PUSH_DATA_KEY")).m();
            return new JsonParser().parse(intent.getStringExtra("PUSH_DATA_KEY")).getAsJsonObject();
        } catch (Exception unused) {
            return new JsonObject();
        }
    }
}
