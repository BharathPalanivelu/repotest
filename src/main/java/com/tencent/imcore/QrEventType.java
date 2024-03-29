package com.tencent.imcore;

public enum QrEventType {
    kEventInit((String) 0),
    kEventLogin((String) 1),
    kEventSendMsg((String) 2),
    kEventUploadPic((String) 3),
    kEventRecvPic((String) 4),
    kEventUploadAudio((String) 5),
    kEventRecvAudio((String) 6),
    kEventUploadVideo((String) 7),
    kEventRecvVideo((String) 8),
    kEventJoinGroup((String) 9),
    kEventCreateGroup((String) 10),
    kEventJoinDiscuss((String) 11),
    kEventCreateDiscuss((String) 12),
    kEventUinToTiny((String) 13),
    kEventTinyToUin((String) 14),
    kEventUploadFile((String) 15),
    kEventRecvFile((String) 16),
    kEventRecvMsg((String) 21),
    kEventSetToken((String) 22),
    kEventDeviceId((String) 23),
    kEventUploadUGC((String) 24),
    kEventRecvUGC((String) 25),
    kEventMax((String) 99);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30656a;

        static /* synthetic */ int a() {
            int i = f30656a;
            f30656a = i + 1;
            return i;
        }
    }

    private QrEventType(int i) {
        this.swigValue = i;
        int unused = aa.f30656a = i + 1;
    }

    private QrEventType(QrEventType qrEventType) {
        this.swigValue = qrEventType.swigValue;
        int unused = aa.f30656a = this.swigValue + 1;
    }

    public static QrEventType swigToEnum(int i) {
        QrEventType[] qrEventTypeArr = (QrEventType[]) QrEventType.class.getEnumConstants();
        if (i < qrEventTypeArr.length && i >= 0 && qrEventTypeArr[i].swigValue == i) {
            return qrEventTypeArr[i];
        }
        for (QrEventType qrEventType : qrEventTypeArr) {
            if (qrEventType.swigValue == i) {
                return qrEventType;
            }
        }
        throw new IllegalArgumentException("No enum " + QrEventType.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
