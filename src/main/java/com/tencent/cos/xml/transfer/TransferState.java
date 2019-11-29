package com.tencent.cos.xml.transfer;

import java.util.HashMap;
import java.util.Map;

public enum TransferState {
    WAITING,
    IN_PROGRESS,
    PAUSED,
    RESUMED_WAITING,
    COMPLETED,
    CANCELED,
    FAILED,
    WAITING_FOR_NETWORK,
    PART_COMPLETED,
    PENDING_CANCEL,
    PENDING_PAUSE,
    PENDING_NETWORK_DISCONNECT,
    UNKNOWN;
    
    private static final Map<String, TransferState> MAP = null;

    static {
        int i;
        MAP = new HashMap();
        for (TransferState transferState : values()) {
            MAP.put(transferState.toString(), transferState);
        }
    }

    public static TransferState getState(String str) {
        if (MAP.containsKey(str)) {
            return MAP.get(str);
        }
        return UNKNOWN;
    }
}
