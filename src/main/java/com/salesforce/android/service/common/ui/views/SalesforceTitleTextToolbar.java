package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.Toolbar;
import com.salesforce.android.service.common.ui.R;

public class SalesforceTitleTextToolbar extends Toolbar {
    private SalesforceTextView titleText;

    public SalesforceTitleTextToolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SalesforceTitleTextToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public SalesforceTitleTextToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    public void setTitleText(CharSequence charSequence) {
        this.titleText.setText(charSequence);
    }

    public void setTitleText(int i) {
        this.titleText.setText(i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.salesforce_toolbar_title_text_view, this, true);
        this.titleText = (SalesforceTextView) findViewById(R.id.salesforce_toolbar_title);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceTitleTextToolbar, i, 0);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.SalesforceTitleTextToolbar_salesforce_title_text);
        if (!TextUtils.isEmpty(text)) {
            setTitleText(text);
        }
        obtainStyledAttributes.recycle();
    }
}
