package com.garena.android.gpns.processor;

import com.garena.android.gpnprotocol.gpush.GetGPidResponse;
import com.garena.android.gpns.GNotificationService;
import com.garena.android.gpns.notification.event.NotifyEvent;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.utility.AppLogger;
import com.garena.android.gpns.utility.CONSTANT;

public class PushIdResponseProcessor extends AbstractProcessor {
    public int getCommand() {
        return 17;
    }

    public void process(byte[] bArr, int i, int i2) throws Exception {
        GetGPidResponse getGPidResponse = (GetGPidResponse) mWire.parseFrom(bArr, i, i2, GetGPidResponse.class);
        long longValue = getGPidResponse.GPid.longValue();
        AppLogger.d("GPID : " + longValue);
        if (longValue != 0) {
            LocalStorage.saveConnectionId(longValue);
            LocalStorage.saveConnectionAddress(getGPidResponse.ConnServerAddr);
        }
        GNotificationService.getBus().fire(CONSTANT.BUS.CONNECT_NOTIFICATION_SERVER, (NotifyEvent) null);
    }
}
