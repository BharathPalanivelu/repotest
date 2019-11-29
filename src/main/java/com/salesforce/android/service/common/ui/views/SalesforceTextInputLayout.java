package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.salesforce.android.service.common.ui.R;

public class SalesforceTextInputLayout extends TextInputLayout {
    private EditText editText;

    public SalesforceTextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SalesforceTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.salesforceTextInputLayoutStyle);
    }

    public SalesforceTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EditText getEditText() {
        return this.editText;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.salesforce_text_input_layout_edit_text, this, true);
        this.editText = (EditText) findViewById(R.id.text_input_layout_edit_text);
    }

    public void setHint(CharSequence charSequence) {
        super.setHint(charSequence);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            editText2.setHint(charSequence);
            setImportantForAccessibility(2);
            return;
        }
        setImportantForAccessibility(0);
    }
}
