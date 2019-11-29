package com.garena.rnrecyclerview.library.a;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.views.image.ReactImageView;
import com.facebook.share.internal.ShareConstants;

public class a {
    public static void a(ReactImageView reactImageView, String str) {
        FLog.d(ReactConstants.TAG, "(UIManager.clearImage) tag: UNKN, viewToUpdate: " + reactImageView.getClass().getSimpleName() + ", viewInstance: " + reactImageView.hashCode());
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(ShareConstants.MEDIA_URI, str);
        javaOnlyArray.pushMap(javaOnlyMap);
        reactImageView.setSource(javaOnlyArray);
        reactImageView.maybeUpdateView();
    }
}
