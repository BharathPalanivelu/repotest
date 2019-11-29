package com.shopee.shopeetracker.utils;

import com.shopee.shopeetracker.model.UserAction;
import java.util.List;

public interface TrackLogger {
    void onErrorSendEvents(String str, Exception exc, List<UserAction> list);

    void onStartSendEvents(String str, List<UserAction> list);

    void onSuccessSendEvents(String str, List<UserAction> list);
}
