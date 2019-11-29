package com.garena.android.gpns.processor;

import com.garena.android.gpnprotocol.gpush.MsgType;
import com.garena.android.gpnprotocol.gpush.PushMsg;
import com.garena.android.gpns.GNotificationService;
import com.garena.android.gpns.notification.event.NotifyEvent;
import com.garena.android.gpns.storage.LocalStorage;
import com.garena.android.gpns.ui.NotificationBroadcaster;
import com.garena.android.gpns.utility.CONSTANT;
import com.garena.android.gpns.utility.TCPPacketFactory;
import java.util.ArrayList;
import java.util.List;

public class PushMsgArrivedProcessor extends AbstractProcessor {
    public int getCommand() {
        return 18;
    }

    public void process(byte[] bArr, int i, int i2) throws Exception {
        PushMsg pushMsg = (PushMsg) mWire.parseFrom(bArr, i, i2, PushMsg.class);
        for (MsgType next : filterMessagesToShow(pushMsg.Msg)) {
            NotificationBroadcaster.broadcast(GNotificationService.getContext(), next.Appid, next.Data);
        }
        GNotificationService.getBus().fire(CONSTANT.BUS.ACK_PUSH_MSG, new NotifyEvent(TCPPacketFactory.newPushMessageAckPacket(pushMsg.Msg.get(0).Msgid.intValue())));
    }

    private List<MsgType> filterMessagesToShow(List<MsgType> list) {
        List<Integer> acknowledgedMsgList = LocalStorage.getAcknowledgedMsgList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MsgType next : list) {
            if (!acknowledgedMsgList.contains(next.Msgid)) {
                arrayList2.add(next);
            }
            arrayList.add(next.Msgid);
        }
        LocalStorage.putAcknowledgedMsgList(arrayList);
        return arrayList2;
    }
}
