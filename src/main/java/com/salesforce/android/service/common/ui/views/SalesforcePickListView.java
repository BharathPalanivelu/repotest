package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.utils.ViewGroupHelper;

public class SalesforcePickListView extends LinearLayout {
    private TextView labelView;
    Spinner spinner;

    public SalesforcePickListView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SalesforcePickListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SalesforcePickListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    public Spinner getSpinner() {
        return this.spinner;
    }

    public TextView getLabelView() {
        return this.labelView;
    }

    public void setId(int i) {
        this.spinner.setId(i);
    }

    public void setLabel(CharSequence charSequence) {
        this.labelView.setText(charSequence);
    }

    public void setLabel(int i) {
        this.labelView.setText(i);
    }

    public void setEnabled(boolean z) {
        ViewGroupHelper.recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        this.spinner.setAdapter(spinnerAdapter);
    }

    public void setSelection(int i) {
        this.spinner.setSelection(i);
    }

    public int getSelectedItemPosition() {
        return this.spinner.getSelectedItemPosition();
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.spinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        setOrientation(1);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.salesforce_input_minimum_height));
        setAddStatesFromChildren(true);
        LayoutInflater.from(context).inflate(R.layout.salesforce_pick_list_view, this, true);
        this.labelView = (TextView) findViewById(R.id.pick_list_label);
        setupSpinner();
        ((ViewGroup) findViewById(R.id.pick_list_spinner_frame)).setAddStatesFromChildren(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforcePickListView, i, 0);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.SalesforcePickListView_salesforce_label);
        if (!TextUtils.isEmpty(text)) {
            setLabel(text);
        }
        obtainStyledAttributes.recycle();
    }

    private void setupSpinner() {
        this.spinner = (Spinner) findViewById(R.id.pick_list_spinner);
        this.spinner.setFocusableInTouchMode(true);
        this.spinner.setFocusable(true);
        this.spinner.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                SalesforcePickListView.this.spinner.performClick();
                return true;
            }
        });
    }
}
