package com.salesforce.android.chat.ui.internal.prechat.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import java.util.List;

class PickListOptionAdapter extends ArrayAdapter<OptionHolder> {
    private final OptionHolder mUnselectedOption;

    static class OptionHolder {
        private final String mLabel;
        private final Object mValue;

        OptionHolder(String str, Object obj) {
            this.mLabel = str;
            this.mValue = obj;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public Object getValue() {
            return this.mValue;
        }
    }

    PickListOptionAdapter(Context context, int i, List<OptionHolder> list) {
        super(context, 0, list);
        this.mUnselectedOption = new OptionHolder(context.getString(i), (Object) null);
    }

    public int getCount() {
        return super.getCount() + 1;
    }

    public OptionHolder getItem(int i) {
        if (i == 0) {
            return this.mUnselectedOption;
        }
        return (OptionHolder) super.getItem(i - 1);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup, R.layout.pre_chat_field_picklist_option);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup, R.layout.pre_chat_field_picklist_selection);
    }

    private View getView(int i, View view, ViewGroup viewGroup, int i2) {
        SalesforceTextView salesforceTextView;
        if (view == null || !(view instanceof SalesforceTextView)) {
            salesforceTextView = (SalesforceTextView) LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        } else {
            salesforceTextView = (SalesforceTextView) view;
        }
        OptionHolder item = getItem(i);
        if (item != null) {
            salesforceTextView.setText(item.getLabel());
        }
        return salesforceTextView;
    }
}
