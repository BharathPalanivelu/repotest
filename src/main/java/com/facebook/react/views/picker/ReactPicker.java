package com.facebook.react.views.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import com.facebook.react.common.annotations.VisibleForTesting;

public class ReactPicker extends AppCompatSpinner {
    private final AdapterView.OnItemSelectedListener mItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (ReactPicker.this.mOnSelectListener != null) {
                ReactPicker.this.mOnSelectListener.onItemSelected(i);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
            if (ReactPicker.this.mOnSelectListener != null) {
                ReactPicker.this.mOnSelectListener.onItemSelected(-1);
            }
        }
    };
    private int mMode = 0;
    /* access modifiers changed from: private */
    public OnSelectListener mOnSelectListener;
    private Integer mPrimaryColor;
    private SpinnerAdapter mStagedAdapter;
    private Integer mStagedSelection;
    private final Runnable measureAndLayout = new Runnable() {
        public void run() {
            ReactPicker reactPicker = ReactPicker.this;
            reactPicker.measure(View.MeasureSpec.makeMeasureSpec(reactPicker.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ReactPicker.this.getHeight(), 1073741824));
            ReactPicker reactPicker2 = ReactPicker.this;
            reactPicker2.layout(reactPicker2.getLeft(), ReactPicker.this.getTop(), ReactPicker.this.getRight(), ReactPicker.this.getBottom());
        }
    };

    public interface OnSelectListener {
        void onItemSelected(int i);
    }

    public ReactPicker(Context context) {
        super(context);
    }

    public ReactPicker(Context context, int i) {
        super(context, i);
        this.mMode = i;
    }

    public ReactPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReactPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ReactPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMode = i2;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getOnItemSelectedListener() == null) {
            setOnItemSelectedListener(this.mItemSelectedListener);
        }
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.mOnSelectListener = onSelectListener;
    }

    public OnSelectListener getOnSelectListener() {
        return this.mOnSelectListener;
    }

    /* access modifiers changed from: package-private */
    public void setStagedAdapter(SpinnerAdapter spinnerAdapter) {
        this.mStagedAdapter = spinnerAdapter;
    }

    /* access modifiers changed from: package-private */
    public void setStagedSelection(int i) {
        this.mStagedSelection = Integer.valueOf(i);
    }

    /* access modifiers changed from: package-private */
    public void commitStagedData() {
        setOnItemSelectedListener((AdapterView.OnItemSelectedListener) null);
        int selectedItemPosition = getSelectedItemPosition();
        SpinnerAdapter spinnerAdapter = this.mStagedAdapter;
        if (!(spinnerAdapter == null || spinnerAdapter == getAdapter())) {
            setAdapter(this.mStagedAdapter);
            setSelection(selectedItemPosition, false);
            this.mStagedAdapter = null;
        }
        Integer num = this.mStagedSelection;
        if (!(num == null || num.intValue() == selectedItemPosition)) {
            setSelection(this.mStagedSelection.intValue(), false);
            this.mStagedSelection = null;
        }
        setOnItemSelectedListener(this.mItemSelectedListener);
    }

    public Integer getPrimaryColor() {
        return this.mPrimaryColor;
    }

    public void setPrimaryColor(Integer num) {
        this.mPrimaryColor = num;
    }

    @VisibleForTesting
    public int getMode() {
        return this.mMode;
    }
}
