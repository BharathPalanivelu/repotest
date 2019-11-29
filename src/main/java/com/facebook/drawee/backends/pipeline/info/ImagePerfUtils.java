package com.facebook.drawee.backends.pipeline.info;

import com.facebook.GraphResponse;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;

public class ImagePerfUtils {
    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "error" : "canceled" : GraphResponse.SUCCESS_KEY : "intermediate_available" : "origin_available" : ChatFileTransferEvent.REQUESTED;
    }

    private ImagePerfUtils() {
    }
}
