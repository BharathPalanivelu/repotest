package com.garena.android.gpns.notification;

import com.garena.android.gpns.notification.event.NotifyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NotificationBus {
    private HashMap<String, ArrayList<NotifyItem>> mMap = new HashMap<>();

    public void register(String str, NotifyItem notifyItem) {
        if (str == null) {
            return;
        }
        if (this.mMap.containsKey(str)) {
            this.mMap.get(str).add(notifyItem);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(notifyItem);
        this.mMap.put(str, arrayList);
    }

    public void unregister(String str, NotifyItem notifyItem) {
        if (str != null && this.mMap.containsKey(str)) {
            this.mMap.get(str).remove(notifyItem);
        }
    }

    public void fire(String str, NotifyEvent notifyEvent) {
        if (str != null && this.mMap.containsKey(str)) {
            Iterator it = this.mMap.get(str).iterator();
            while (it.hasNext()) {
                NotifyItem notifyItem = (NotifyItem) it.next();
                if (notifyItem != null) {
                    notifyItem.onNotify(notifyEvent);
                }
            }
        }
    }

    public void clearAll() {
        this.mMap.clear();
    }
}
