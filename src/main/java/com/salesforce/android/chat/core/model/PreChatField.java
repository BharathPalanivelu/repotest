package com.salesforce.android.chat.core.model;

import com.google.a.a.c;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public class PreChatField extends ChatUserData {
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PICKLIST = "picklist";
    public static final String STRING = "string";
    private final String mDisplayName;
    private final String mExtraTypeInfo;
    private final boolean mIsHidden;
    private final Integer mMaxValueLength;
    private final List<PickListOption> mPickListOptions;
    private final Boolean mReadOnly;
    private final Boolean mRequired;
    private int mSelectedPickListIndex = -1;
    private final String mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    PreChatField(Builder builder) {
        super(builder.mFieldName, builder.mValue, builder.mIsDisplayedToAgent, builder.mTranscriptFields);
        this.mPickListOptions = builder.mPickListOptions;
        this.mReadOnly = Boolean.valueOf(builder.mReadOnly);
        this.mRequired = Boolean.valueOf(builder.mRequired);
        this.mExtraTypeInfo = builder.mExtraTypeInfo;
        this.mMaxValueLength = Integer.valueOf(builder.mMaxValueLength);
        this.mDisplayName = builder.mDisplayName;
        this.mIsHidden = builder.mIsHidden;
        this.mType = builder.mType;
    }

    @Deprecated
    public String getFieldName() {
        return getAgentLabel();
    }

    public void setValue(Serializable serializable) {
        if (!this.mReadOnly.booleanValue()) {
            super.setValue(serializable);
        }
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public String getExtraTypeInfo() {
        return this.mExtraTypeInfo;
    }

    public String getType() {
        return this.mType;
    }

    public Integer getMaxValueLength() {
        return this.mMaxValueLength;
    }

    public Boolean isReadOnly() {
        return this.mReadOnly;
    }

    public Boolean isRequired() {
        return this.mRequired;
    }

    public Boolean isSatisfied() {
        boolean z = true;
        if (this.mReadOnly.booleanValue() || !this.mRequired.booleanValue()) {
            return true;
        }
        if (this.mType.equals(PICKLIST)) {
            int i = this.mSelectedPickListIndex;
            if (i < 0 || i >= this.mPickListOptions.size()) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        int length = getValue() == null ? 0 : getValue().toString().length();
        boolean z2 = this.mMaxValueLength.intValue() <= 0 || (this.mMaxValueLength.intValue() > 0 && length <= this.mMaxValueLength.intValue());
        if (length <= 0 || !z2) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public Boolean isHidden() {
        return Boolean.valueOf(this.mIsHidden);
    }

    public List<PickListOption> getPickListOptions() {
        return this.mPickListOptions;
    }

    public int getSelectedPickListIndex() {
        return this.mSelectedPickListIndex;
    }

    public void setSelectedPickListIndex(int i) {
        if (i >= 0 && i < this.mPickListOptions.size() && this.mType.equals(PICKLIST)) {
            this.mSelectedPickListIndex = i;
        }
    }

    public void unsetSelectedPickListIndex() {
        this.mSelectedPickListIndex = -1;
        setValue((Serializable) null);
    }

    public boolean isPickListItemSelected() {
        return this.mSelectedPickListIndex != -1;
    }

    @Deprecated
    public String[] getTranscriptFields() {
        return getTranscriptFieldNames();
    }

    public static class PickListOption implements Serializable {
        @c(a = "label")
        private String mId;
        @c(a = "value")
        private String mLabel;

        public String getId() {
            return this.mId;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public PickListOption(String str, String str2) {
            this.mId = str;
            this.mLabel = str2;
        }
    }

    @Deprecated
    public static class Builder {
        /* access modifiers changed from: private */
        public String mDisplayName;
        /* access modifiers changed from: private */
        public String mExtraTypeInfo;
        /* access modifiers changed from: private */
        public String mFieldName;
        /* access modifiers changed from: private */
        public boolean mIsDisplayedToAgent = true;
        /* access modifiers changed from: private */
        public boolean mIsHidden;
        /* access modifiers changed from: private */
        public int mMaxValueLength;
        /* access modifiers changed from: private */
        public List<PickListOption> mPickListOptions;
        /* access modifiers changed from: private */
        public boolean mReadOnly;
        /* access modifiers changed from: private */
        public boolean mRequired;
        /* access modifiers changed from: private */
        public String[] mTranscriptFields = new String[0];
        /* access modifiers changed from: private */
        public String mType;
        /* access modifiers changed from: private */
        public Serializable mValue;

        public Builder extraTypeInfo(String str) {
            this.mExtraTypeInfo = str;
            return this;
        }

        public Builder readOnly(Boolean bool) {
            this.mReadOnly = bool.booleanValue();
            return this;
        }

        public Builder required(Boolean bool) {
            this.mRequired = bool.booleanValue();
            return this;
        }

        public Builder maxValueLength(Integer num) {
            this.mMaxValueLength = num.intValue();
            return this;
        }

        public Builder hidden(boolean z) {
            this.mIsHidden = z;
            return this;
        }

        public Builder displayedToAgent(boolean z) {
            this.mIsDisplayedToAgent = z;
            return this;
        }

        public Builder value(Serializable serializable) {
            this.mValue = serializable;
            return this;
        }

        public Builder picklistOptions(List<PickListOption> list) {
            this.mPickListOptions = list;
            return this;
        }

        public Builder picklistOptions(PickListOption... pickListOptionArr) {
            return picklistOptions((List<PickListOption>) Arrays.asList(pickListOptionArr));
        }

        public Builder addPickListOption(PickListOption pickListOption) {
            if (this.mPickListOptions == null) {
                this.mPickListOptions = new LinkedList();
            }
            this.mPickListOptions.add(pickListOption);
            return this;
        }

        public Builder mapToChatTranscriptField(String... strArr) {
            this.mTranscriptFields = strArr;
            return this;
        }

        public PreChatField build(String str, String str2, String str3) {
            Arguments.checkNotNull(str);
            Arguments.checkNotNull(str2);
            Arguments.checkNotNull(str3);
            this.mFieldName = str;
            this.mDisplayName = str2;
            this.mType = str3;
            if (this.mExtraTypeInfo == null) {
                this.mExtraTypeInfo = "";
            }
            if (this.mValue == null) {
                this.mValue = "";
            }
            return new PreChatField(this);
        }
    }
}
