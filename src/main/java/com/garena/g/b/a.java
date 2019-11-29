package com.garena.g.b;

import android.content.Intent;
import android.net.Uri;

public class a {
    public static Intent a(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/*");
        intent.putExtra("android.intent.extra.TEXT", str);
        return intent;
    }

    public static Intent a(Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.STREAM", uri);
        return intent;
    }
}
