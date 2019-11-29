package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;

public class WebPageScrollView extends ScrollView {
    public WebPageScrollView(Context context) {
        super(context, (AttributeSet) null);
    }

    public WebPageScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public WebPageScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void requestChildFocus(View view, View view2) {
        if (!(view2 instanceof WebView)) {
            super.requestChildFocus(view, view2);
        }
    }
}
