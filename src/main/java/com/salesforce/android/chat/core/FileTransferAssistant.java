package com.salesforce.android.chat.core;

import com.salesforce.android.service.common.utilities.control.Async;

public interface FileTransferAssistant {
    Async<Float> uploadFile(byte[] bArr, String str);
}
