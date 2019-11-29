package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.emoji.widget.g;
import com.devspark.robototextview.b;

public class RobotoSupportEmojiTextView extends g {
    public RobotoSupportEmojiTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RobotoSupportEmojiTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }

    public RobotoSupportEmojiTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            b.a(this, context, attributeSet);
        }
    }
}
