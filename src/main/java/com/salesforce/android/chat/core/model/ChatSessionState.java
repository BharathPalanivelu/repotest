package com.salesforce.android.chat.core.model;

public enum ChatSessionState {
    Ready,
    Verification,
    Initializing,
    Connecting,
    InQueue,
    Connected,
    Ending,
    Disconnected;

    public boolean isPostSession() {
        return ordinal() > Connected.ordinal();
    }
}
