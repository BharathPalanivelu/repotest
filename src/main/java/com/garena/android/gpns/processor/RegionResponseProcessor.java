package com.garena.android.gpns.processor;

import android.text.TextUtils;
import com.garena.android.gpnprotocol.gpush.GetRegionResponse;
import com.garena.android.gpns.GNotificationService;
import com.garena.android.gpns.notification.event.NotifyEvent;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.utility.CONSTANT;

public class RegionResponseProcessor extends AbstractProcessor {
    public int getCommand() {
        return 20;
    }

    public void process(byte[] bArr, int i, int i2) throws Exception {
        String str = ((GetRegionResponse) mWire.parseFrom(bArr, i, i2, GetRegionResponse.class)).Region;
        if (!TextUtils.isEmpty(str)) {
            LocalStorage.updateRegionRequestTime(System.currentTimeMillis());
            LocalStorage.setAuthServerAddress(str);
        }
        GNotificationService.getBus().fire(CONSTANT.BUS.CONNECT_AUTHENTICATION_SERVER, (NotifyEvent) null);
    }
}
