package com.shopee.shopeetracker.utils;

import android.os.AsyncTask;
import com.shopee.shopeetracker.EventSender;
import com.shopee.shopeetracker.Injection;

@Deprecated
public class SendEventTask extends AsyncTask<Boolean, Void, Void> {
    /* access modifiers changed from: protected */
    public Void doInBackground(Boolean... boolArr) {
        try {
            EventSender provideEventSender = Injection.provideEventSender();
            if (boolArr != null && boolArr.length > 0) {
                provideEventSender.setWifi(boolArr[0].booleanValue());
            }
            provideEventSender.sendEvents();
            return null;
        } catch (Exception e2) {
            Logger.debug((Throwable) e2);
            return null;
        }
    }
}
