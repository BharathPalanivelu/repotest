package com.salesforce.android.chat.ui.model;

import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;

public final class PreChatTextInputField extends PreChatInputField {
    private final transient int mInputType;
    private final transient boolean mIsCounterEnabled;
    private final transient int mMaxValueLength;
    private final transient Validator mValidator;

    public interface Validator {
        boolean isValid(CharSequence charSequence);
    }

    PreChatTextInputField(Builder builder) {
        super(builder.mDisplayLabel, builder.mAgentLabel, builder.mInitialValue, builder.mIsReadOnly, builder.mIsRequired, builder.mIsDisplayedToAgent, builder.mTranscriptFieldNames);
        this.mIsCounterEnabled = builder.mIsCounterEnabled;
        this.mMaxValueLength = builder.mMaxValueLength;
        this.mInputType = builder.mInputType;
        this.mValidator = builder.mValidator;
    }

    public void setValue(Object obj) {
        if (obj instanceof CharSequence) {
            setValue((CharSequence) obj);
        } else if (obj == null) {
            setValue((CharSequence) null);
        }
    }

    public void setValue(CharSequence charSequence) {
        super.setValue(charSequence);
    }

    public boolean isSatisfied() {
        Object value = getValue();
        if (!super.isSatisfied()) {
            return false;
        }
        if (value != null && CharSequence.class.isAssignableFrom(value.getClass()) && ((CharSequence) value).length() == 0 && isRequired()) {
            return false;
        }
        if (value != null && CharSequence.class.isAssignableFrom(value.getClass())) {
            int length = ((CharSequence) value).length();
            int i = this.mMaxValueLength;
            if (length > i && i > 0) {
                return false;
            }
        }
        if (value == null || !CharSequence.class.isAssignableFrom(value.getClass())) {
            return true;
        }
        Validator validator = this.mValidator;
        if (validator != null) {
            return validator.isValid((CharSequence) value);
        }
        return true;
    }

    public int getInputType() {
        return this.mInputType;
    }

    public boolean isCounterEnabled() {
        return this.mIsCounterEnabled;
    }

    public int getMaxValueLength() {
        return this.mMaxValueLength;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String mAgentLabel;
        /* access modifiers changed from: private */
        public String mDisplayLabel;
        /* access modifiers changed from: private */
        public CharSequence mInitialValue;
        /* access modifiers changed from: private */
        public int mInputType = 1;
        /* access modifiers changed from: private */
        public boolean mIsCounterEnabled = true;
        /* access modifiers changed from: private */
        public boolean mIsDisplayedToAgent = true;
        /* access modifiers changed from: private */
        public boolean mIsReadOnly;
        /* access modifiers changed from: private */
        public boolean mIsRequired;
        /* access modifiers changed from: private */
        public int mMaxValueLength;
        /* access modifiers changed from: private */
        public List<String> mTranscriptFieldNames = new ArrayList();
        /* access modifiers changed from: private */
        public Validator mValidator;

        public Builder inputType(int i) {
            this.mInputType = i;
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

        public Builder maxValueLength(int i) {
            this.mMaxValueLength = Math.max(i, 0);
            return this;
        }

        public Builder counterEnabled(boolean z) {
            this.mIsCounterEnabled = z;
            return this;
        }

        public Builder displayedToAgent(boolean z) {
            this.mIsDisplayedToAgent = z;
            return this;
        }

        public Builder initialValue(CharSequence charSequence) {
            this.mInitialValue = charSequence;
            return this;
        }

        public Builder validator(Validator validator) {
            this.mValidator = validator;
            return this;
        }

        public Builder mapToChatTranscriptFieldName(String str) {
            this.mTranscriptFieldNames.add(str);
            return this;
        }

        public PreChatTextInputField build(String str, String str2) {
            Arguments.checkNotNull(str, "A display label must be declared");
            Arguments.checkNotNull(str2, "An agent label must be declared");
            this.mDisplayLabel = str;
            this.mAgentLabel = str2;
            return new PreChatTextInputField(this);
        }
    }
}
