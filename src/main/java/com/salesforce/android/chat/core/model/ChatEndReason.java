package com.salesforce.android.chat.core.model;

public enum ChatEndReason {
    EndedByAgent,
    EndedByClient,
    NoAgentsAvailable,
    LiveAgentTimeout,
    NetworkError,
    VerificationError,
    Unknown
}
