package com.salesforce.android.chat.ui.model;

import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.ui.internal.model.PreChatInput;
import java.util.List;

abstract class PreChatInputField extends ChatUserData implements PreChatInput {
    private final String mDisplayLabel;
    private final boolean mIsReadOnly;
    private final boolean mIsRequired;

    PreChatInputField(String str, String str2, Object obj, boolean z, boolean z2, boolean z3, List<String> list) {
        super(str2, obj, z3, (String[]) list.toArray(new String[0]));
        this.mDisplayLabel = str;
        this.mIsReadOnly = z;
        this.mIsRequired = z2;
    }

    public final String getDisplayLabel() {
        return this.mDisplayLabel;
    }

    public boolean isSatisfied() {
        return getValue() != null || !isRequired();
    }

    public final boolean hasValue() {
        return getValue() != null;
    }

    public final boolean isReadOnly() {
        return this.mIsReadOnly;
    }

    public final boolean isRequired() {
        return this.mIsRequired;
    }

    public void setValue(Object obj) {
        if (!this.mIsReadOnly) {
            super.setValue(obj);
        }
    }
}
