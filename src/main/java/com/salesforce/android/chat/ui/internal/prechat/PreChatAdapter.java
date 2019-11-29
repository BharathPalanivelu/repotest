package com.salesforce.android.chat.ui.internal.prechat;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.core.model.PreChatField;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PickListViewHolder;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatHeaderViewHolder;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatPickListViewHolder;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatTextInputViewHolder;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatViewHolder;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.StringEditViewHolder;
import com.salesforce.android.chat.ui.model.PreChatPickListField;
import com.salesforce.android.chat.ui.model.PreChatTextInputField;
import com.salesforce.android.service.common.ui.views.SalesforcePickListView;
import com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout;
import java.util.List;

public class PreChatAdapter extends RecyclerView.a<RecyclerView.w> {
    protected static final int TYPE_EMAIL = 2;
    protected static final int TYPE_HEADER = 5;
    protected static final int TYPE_PHONE = 4;
    protected static final int TYPE_PICKLIST = 3;
    protected static final int TYPE_PICKLIST_INPUT = 7;
    protected static final int TYPE_STRING = 1;
    protected static final int TYPE_TEXT_INPUT = 6;
    private final PreChatViewHolder.OnUpdateListener mOnUpdateListener;
    private final List<? extends ChatUserData> mPreChatFields;

    private int toPrechatListIndex(int i) {
        return i - 1;
    }

    PreChatAdapter(List<? extends ChatUserData> list, PreChatViewHolder.OnUpdateListener onUpdateListener) {
        this.mPreChatFields = list;
        this.mOnUpdateListener = onUpdateListener;
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 1:
                return new StringEditViewHolder((SalesforceTextInputLayout) from.inflate(R.layout.pre_chat_field_text, viewGroup, false));
            case 2:
                return new StringEditViewHolder((SalesforceTextInputLayout) from.inflate(R.layout.pre_chat_field_email, viewGroup, false));
            case 3:
                return new PickListViewHolder((SalesforcePickListView) from.inflate(R.layout.pre_chat_field_picklist, viewGroup, false));
            case 4:
                return new StringEditViewHolder((SalesforceTextInputLayout) from.inflate(R.layout.pre_chat_field_phone, viewGroup, false));
            case 5:
                return new PreChatHeaderViewHolder(from.inflate(R.layout.pre_chat_field_header, viewGroup, false));
            case 6:
                return new PreChatTextInputViewHolder((SalesforceTextInputLayout) from.inflate(R.layout.pre_chat_field_text, viewGroup, false));
            case 7:
                return new PreChatPickListViewHolder((SalesforcePickListView) from.inflate(R.layout.pre_chat_field_picklist, viewGroup, false));
            default:
                throw new IllegalArgumentException("Unknown viewType");
        }
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        if (wVar instanceof PreChatViewHolder) {
            int prechatListIndex = toPrechatListIndex(i);
            PreChatViewHolder preChatViewHolder = (PreChatViewHolder) wVar;
            preChatViewHolder.setOnUpdateListener(this.mOnUpdateListener);
            preChatViewHolder.setData((ChatUserData) this.mPreChatFields.get(prechatListIndex));
        }
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 5;
        }
        int prechatListIndex = toPrechatListIndex(i);
        if (prechatListIndex >= this.mPreChatFields.size() || prechatListIndex < 0) {
            throw new IllegalStateException("MenuItem does not exist at position " + i);
        }
        ChatUserData chatUserData = (ChatUserData) this.mPreChatFields.get(prechatListIndex);
        if (chatUserData instanceof PreChatTextInputField) {
            return 6;
        }
        if (chatUserData instanceof PreChatPickListField) {
            return 7;
        }
        if (chatUserData instanceof PreChatField) {
            PreChatField preChatField = (PreChatField) chatUserData;
            String type = preChatField.getType();
            char c2 = 65535;
            switch (type.hashCode()) {
                case -891985903:
                    if (type.equals(PreChatField.STRING)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -738707393:
                    if (type.equals(PreChatField.PICKLIST)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 96619420:
                    if (type.equals("email")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 106642798:
                    if (type.equals("phone")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                return 3;
            }
            if (c2 == 1) {
                return 2;
            }
            if (c2 == 2) {
                return 4;
            }
            if (c2 == 3) {
                return 1;
            }
            throw new IllegalStateException("MenuItem at " + prechatListIndex + " is not a valid prechat field. Type=" + preChatField.getType());
        }
        throw new IllegalStateException("MenuItem at " + prechatListIndex + " is not a valid prechat field. Type=" + chatUserData.getClass().getCanonicalName());
    }

    public int getItemCount() {
        return this.mPreChatFields.size() + 1;
    }
}
