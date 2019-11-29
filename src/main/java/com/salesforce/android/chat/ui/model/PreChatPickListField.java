package com.salesforce.android.chat.ui.model;

import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;

public final class PreChatPickListField extends PreChatInputField {
    private final transient List<Option> mOptions;
    private transient Option mSelectedOption;

    public /* bridge */ /* synthetic */ boolean isSatisfied() {
        return super.isSatisfied();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreChatPickListField(Builder builder) {
        super(builder.mDisplayLabel, builder.mAgentLabel, builder.mInitialValue == null ? null : builder.mInitialValue.getValue(), builder.mIsReadOnly, builder.mIsRequired, builder.mIsDisplayedToAgent, builder.mTranscriptFieldNames);
        this.mOptions = builder.mOptions;
        this.mSelectedOption = builder.mInitialValue;
    }

    public void setValue(Object obj) {
        if (obj instanceof Option) {
            setValue((Option) obj);
        } else {
            deselect();
        }
    }

    public void setValue(Option option) {
        if (option == null || option.getValue() == null) {
            deselect();
        } else if (this.mOptions.contains(option)) {
            this.mSelectedOption = option;
            super.setValue(option.getValue());
        }
    }

    public void deselect() {
        this.mSelectedOption = null;
        super.setValue((Object) null);
    }

    public boolean isOptionSelected() {
        return this.mSelectedOption != null;
    }

    public Option getSelectedOption() {
        return this.mSelectedOption;
    }

    public int getSelectedOptionIndex() {
        if (!isOptionSelected()) {
            return -1;
        }
        return this.mOptions.indexOf(this.mSelectedOption);
    }

    public List<Option> getOptions() {
        return this.mOptions;
    }

    public static final class Option {
        private String mLabel;
        private Object mValue;

        public Option(String str, Object obj) {
            this.mLabel = str;
            this.mValue = obj;
        }

        public String getDisplayLabel() {
            return this.mLabel;
        }

        public Object getValue() {
            return this.mValue;
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String mAgentLabel;
        /* access modifiers changed from: private */
        public String mDisplayLabel;
        /* access modifiers changed from: private */
        public Option mInitialValue;
        /* access modifiers changed from: private */
        public boolean mIsDisplayedToAgent = true;
        /* access modifiers changed from: private */
        public boolean mIsReadOnly;
        /* access modifiers changed from: private */
        public boolean mIsRequired;
        /* access modifiers changed from: private */
        public List<Option> mOptions = new ArrayList();
        /* access modifiers changed from: private */
        public List<String> mTranscriptFieldNames = new ArrayList();

        public Builder addOption(Option option) {
            this.mOptions.add(option);
            return this;
        }

        public Builder readOnly(boolean z) {
            this.mIsReadOnly = z;
            return this;
        }

        public Builder required(boolean z) {
            this.mIsRequired = z;
            return this;
        }

        public Builder displayedToAgent(boolean z) {
            this.mIsDisplayedToAgent = z;
            return this;
        }

        public Builder initialValue(Option option) {
            this.mInitialValue = option;
            return this;
        }

        public Builder mapToChatTranscriptFieldName(String str) {
            this.mTranscriptFieldNames.add(str);
            return this;
        }

        public PreChatPickListField build(String str, String str2) {
            Arguments.checkNotNull(str, "A display label must be declared");
            Arguments.checkNotNull(str2, "An agent label must be declared");
            Arguments.check(!this.mOptions.isEmpty(), "PreChatPickListField cannot have an empty set of options");
            this.mDisplayLabel = str;
            this.mAgentLabel = str2;
            return new PreChatPickListField(this);
        }
    }
}
