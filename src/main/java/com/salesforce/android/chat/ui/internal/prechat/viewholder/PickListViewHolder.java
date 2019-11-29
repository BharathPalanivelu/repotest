package com.salesforce.android.chat.ui.internal.prechat.viewholder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.core.model.PreChatField;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PickListOptionAdapter;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatViewHolder;
import com.salesforce.android.service.common.ui.views.SalesforcePickListView;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class PickListViewHolder extends RecyclerView.w implements PreChatViewHolder {
    private PreChatViewHolder.OnUpdateListener mOnUpdateListener;
    private PreChatField mPreChatField;
    private final SalesforcePickListView mSalesforcePickListView;

    public PickListViewHolder(SalesforcePickListView salesforcePickListView) {
        super(salesforcePickListView);
        this.mSalesforcePickListView = salesforcePickListView;
        this.mSalesforcePickListView.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PickListViewHolder.this.processUpdate(adapterView, i - 1);
            }
        });
    }

    public void setData(ChatUserData chatUserData) {
        if (chatUserData instanceof PreChatField) {
            this.mPreChatField = (PreChatField) chatUserData;
            String displayName = this.mPreChatField.getDisplayName();
            if (this.mPreChatField.isRequired().booleanValue()) {
                displayName = displayName + "*";
            }
            this.mSalesforcePickListView.getLabelView().setText(displayName);
            PickListOptionAdapter pickListOptionAdapter = new PickListOptionAdapter(this.itemView.getContext(), R.string.pre_chat_picklist_select_hint, toOptionHolders(this.mPreChatField.getPickListOptions()));
            Spinner spinner = this.mSalesforcePickListView.getSpinner();
            spinner.setAdapter(pickListOptionAdapter);
            if (this.mPreChatField.isPickListItemSelected()) {
                spinner.setSelection(this.mPreChatField.getSelectedPickListIndex());
            } else {
                spinner.setSelection(0);
            }
            if (this.mPreChatField.isReadOnly().booleanValue()) {
                this.mSalesforcePickListView.setEnabled(false);
            }
        }
    }

    public void setOnUpdateListener(PreChatViewHolder.OnUpdateListener onUpdateListener) {
        this.mOnUpdateListener = onUpdateListener;
    }

    /* access modifiers changed from: private */
    public void processUpdate(AdapterView<?> adapterView, int i) {
        PreChatField preChatField = this.mPreChatField;
        if (preChatField != null) {
            if (i != preChatField.getSelectedPickListIndex()) {
                if (i >= 0) {
                    this.mPreChatField.setSelectedPickListIndex(i);
                    this.mPreChatField.setValue(((PickListOptionAdapter.OptionHolder) adapterView.getSelectedItem()).getValue());
                } else {
                    this.mPreChatField.unsetSelectedPickListIndex();
                }
                PreChatViewHolder.OnUpdateListener onUpdateListener = this.mOnUpdateListener;
                if (onUpdateListener != null) {
                    onUpdateListener.onPreChatFieldUpdate(this.mPreChatField);
                }
            }
        }
    }

    private List<PickListOptionAdapter.OptionHolder> toOptionHolders(List<PreChatField.PickListOption> list) {
        ArrayList arrayList = new ArrayList();
        for (PreChatField.PickListOption next : list) {
            arrayList.add(new PickListOptionAdapter.OptionHolder(next.getId(), next.getLabel()));
        }
        return arrayList;
    }
}
