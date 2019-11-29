package com.garena.android.gpns.utility;

public class CONSTANT {
    public static final long DEFAULT_GPID = -1;

    public static class CONFIG {
        public static String PUSH_ID = "";
        public static String PUSH_PACKAGE = "";
    }

    public interface ALARM {
        public static final String DATA_BUNDLE = "DATA_BUNDLE";
        public static final String KEY_ALARM_TYPE = "KEY_ALARM_TYPE";
        public static final int TYPE_LONG_PING = 1;
        public static final int TYPE_SHORT_PING = 0;
        public static final int TYPE_WAKE_CONNECT = 2;
    }

    public interface BUS {
        public static final String ACK_PUSH_MSG = "ACK_PUSH_MSG";
        public static final String CONNECT_AUTHENTICATION_SERVER = "CONNECT_AUTHENTICATION_SERVER";
        public static final String CONNECT_NOTIFICATION_SERVER = "CONNECT_NOTIFICATION_SERVER";
        public static final String LONG_PING = "LONG_PING";
        public static final String PERFORM_PING = "PERFORM_PING";
        public static final String SHORT_PING = "SHORT_PING";
        public static final String WAKE_CONNECT = "WAKE_CONNECT";
    }

    public interface COMMAND {
        public static final int CONNECT = 2;
        public static final int GET_GPID = 1;
        public static final int MSG_ACK = 3;
        public static final int PING = 4;
        public static final int PING_ACK = 19;
        public static final int PUSH_MSG = 18;
        public static final int REGION = 5;
        public static final int RETURN_GPID = 17;
        public static final int RETURN_REGION = 20;
    }

    public interface INTENT {
        public static final String INTENT_REQUEST = "INTENT_REQUEST";
        public static final int REQUEST_NONE = 0;
        public static final int REQUEST_TOKEN = 1;
    }

    public interface NETWORK {
        public static final int ID_AUTH_SERVER_CONNECTION = 0;
        public static final int ID_NOTIFICATION_SERVER_CONNECTION = 1;
        public static final int ID_REGION_SERVER_CONNECTION = 2;
        public static final int MAX_CONNECTION_TIMEOUT = 600000;
        public static final String SERVER_IP = "203.116.50.191";
        public static final int SERVER_PORT = 10086;
    }

    public interface TIME {
        public static final int HR_24 = 86400000;
        public static final int MIN_1 = 60000;
        public static final int MIN_5 = 300000;
        public static final int SEC_30 = 30000;
    }

    public interface VERSION {
        public static final int SERVICE_VERSION = 1;
    }

    public static class ACTION {
        public static String ACTION_ALARM() {
            return "com.garena.android.gpns.ALARM_ACTION." + CONFIG.PUSH_PACKAGE + "." + CONFIG.PUSH_ID;
        }

        public static String ACTION_NOTIFICATION() {
            return "com.garena.android.gpns.NOTIFICATION_RECEIVE." + CONFIG.PUSH_PACKAGE + "." + CONFIG.PUSH_ID;
        }

        public static String ACTION_TOKEN() {
            return "com.garena.android.gpns.TOKEN_RECEIVE." + CONFIG.PUSH_PACKAGE + "." + CONFIG.PUSH_ID;
        }
    }
}
