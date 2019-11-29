package com.salesforce.android.service.common.ui.internal.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public class TypefaceFactory {
    public static Typeface createFromAsset(AssetManager assetManager, String str) {
        return Typeface.createFromAsset(assetManager, str);
    }
}
