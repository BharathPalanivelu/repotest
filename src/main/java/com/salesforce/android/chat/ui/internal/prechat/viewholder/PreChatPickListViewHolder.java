package com.salesforce.android.chat.ui.internal.prechat.viewholder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PickListOptionAdapter;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatViewHolder;
import com.salesforce.android.chat.ui.model.PreChatPickListField;
import com.salesforce.android.service.common.ui.views.SalesforcePickListView;
import java.util.ArrayList;
import java.util.List;

public class PreChatPickListViewHolder extends RecyclerView.w implements PreChatViewHolder {
    private PreChatViewHolder.OnUpdateListener mOnUpdateListener;
    private PreChatPickListField mPickListField;
    private final SalesforcePickListView mSalesforcePickListView;

    public PreChatPickListViewHolder(SalesforcePickListView salesforcePickListView) {
        super(salesforcePickListView);
        this.mSalesforcePickListView = salesforcePickListView;
        this.mSalesforcePickListView.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PreChatPickListViewHolder.this.processUpdate(adapterView, i);
            }
        });
    }

    public void setData(ChatUserData chatUserData) {
        if (chatUserData instanceof PreChatPickListField) {
            this.mPickListField = (PreChatPickListField) chatUserData;
            String displayLabel = this.mPickListField.getDisplayLabel();
            if (this.mPickListField.isRequired()) {
                displayLabel = displayLabel + "*";
            }
            this.mSalesforcePickListView.getLabelView().setText(displayLabel);
            PickListOptionAdapter pickListOptionAdapter = new PickListOptionAdapter(this.itemView.getContext(), R.string.pre_chat_picklist_select_hint, toOptionHolders(this.mPickListField.getOptions()));
            Spinner spinner = this.mSalesforcePickListView.getSpinner();
            spinner.setAdapter(pickListOptionAdapter);
            if (this.mPickListField.isOptionSelected()) {
                spinner.setSelection(this.mPickListField.getSelectedOptionIndex() + 1);
            }
            if (this.mPickListField.isReadOnly()) {
                this.mSalesforcePickListView.setEnabled(false);
            }
        }
    }

    public void setOnUpdateListener(PreChatViewHolder.OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    /* access modifiers changed from: private */
    public void processUpdate(AdapterView<?> adapterView, int i) {
        PreChatPickListField preChatPickListField = this.mPickListField;
        if (preChatPickListField != null) {
            boolean z = true;
            if (i == preChatPickListField.getSelectedOptionIndex() + 1) {
                z = false;
            }
            if (z) {
                this.mPickListField.setValue(((PickListOptionAdapter.OptionHolder) adapterView.getSelectedItem()).getValue());
                PreChatViewHolder.OnUpdateListener onUpdateListener = this.mOnUpdateListener;
                if (onUpdateListener != null) {
                    onUpdateListener.onPreChatFieldUpdate(this.mPickListField);
                }
            }
        }
    }

    private List<PickListOptionAdapter.OptionHolder> toOptionHolders(List<PreChatPickListField.Option> list) {
        ArrayList arrayList = new ArrayList();
        for (PreChatPickListField.Option next : list) {
            arrayList.add(new PickListOptionAdapter.OptionHolder(next.getDisplayLabel(), next));
        }
        return arrayList;
    }
}
