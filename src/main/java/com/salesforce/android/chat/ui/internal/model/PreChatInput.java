package com.salesforce.android.chat.ui.internal.model;

public interface PreChatInput {
    String getDisplayLabel();

    boolean hasValue();

    boolean isReadOnly();

    boolean isRequired();

    boolean isSatisfied();
}
