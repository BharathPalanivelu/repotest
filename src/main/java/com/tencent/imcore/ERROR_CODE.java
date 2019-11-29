package com.tencent.imcore;

import com.tencent.imsdk.BaseConstants;

public enum ERROR_CODE {
    ERR_SUCC((String) 0),
    ERR_PARSE_RESPONSE_FAILED((String) BaseConstants.ERR_PARSE_RESPONSE_FAILED),
    ERR_SERIALIZE_REQ_FAILED((String) BaseConstants.ERR_SERIALIZE_REQ_FAILED),
    ERR_NO_SUCC_RESULT((String) BaseConstants.ERR_NO_SUCC_RESULT),
    ERR_INVALID_CONVERSATION((String) BaseConstants.ERR_INVALID_CONVERSATION),
    ERR_LOADMSG_FAILED((String) BaseConstants.ERR_LOADMSG_FAILED),
    ERR_FILE_TRANS_AUTH_FAILED((String) BaseConstants.ERR_FILE_TRANS_AUTH_FAILED),
    ERR_FILE_TRANS_NO_SERVER((String) BaseConstants.ERR_FILE_TRANS_NO_SERVER),
    ERR_FILE_TRANS_UPLOAD_FAILED((String) BaseConstants.ERR_FILE_TRANS_UPLOAD_FAILED),
    ERR_FILE_TRANS_DOWNLOAD_FAILED((String) BaseConstants.ERR_FILE_TRANS_DOWNLOAD_FAILED),
    ERR_HTTP_REQ_FAILED((String) BaseConstants.ERR_HTTP_REQ_FAILED),
    ERR_TO_USER_INVALID((String) BaseConstants.ERR_TO_USER_INVALID),
    ERR_REQUEST_TIMEOUT((String) BaseConstants.ERR_REQUEST_TIMEOUT),
    ERR_SDK_NOT_INITIALIZED((String) BaseConstants.ERR_SDK_NOT_INITIALIZED),
    ERR_SDK_NOT_LOGGED_IN((String) BaseConstants.ERR_SDK_NOT_LOGGED_IN),
    ERR_IN_PROGESS((String) BaseConstants.ERR_IN_PROGESS),
    ERR_INVALID_MSG_ELEM((String) BaseConstants.ERR_INVALID_MSG_ELEM),
    ERR_INVALID_PARAMETERS((String) BaseConstants.ERR_INVALID_PARAMETERS),
    ERR_INIT_CORE_FAIL((String) BaseConstants.ERR_INIT_CORE_FAIL),
    ERR_DATABASE_OPERATE_FAILED((String) BaseConstants.ERR_DATABASE_OPERATE_FAILED),
    ERR_EXPIRED_SESSION_NODE((String) 6020),
    ERR_INVALID_SDK_OBJECT((String) BaseConstants.ERR_INVALID_SDK_OBJECT),
    ERR_IO_OPERATION_FAILED((String) BaseConstants.ERR_IO_OPERATION_FAILED),
    ERR_LOGGED_OUT_BEFORE_LOGIN_FINISHED((String) BaseConstants.ERR_LOGGED_OUT_BEFORE_LOGIN_FINISHED),
    ERR_TLSSDK_NOT_INITIALIZED((String) BaseConstants.ERR_TLSSDK_NOT_INITIALIZED),
    ERR_TLSSDK_USER_NOT_FOUND((String) BaseConstants.ERR_TLSSDK_FIND_NO_USER),
    ERR_BIND_FAIL_UNKNOWN((String) 6100),
    ERR_BIND_FAIL_NO_SSOTICKET((String) 6101),
    ERR_BIND_FAIL_REPEATD_BIND((String) 6102),
    ERR_BIND_FAIL_TINYID_NULL((String) 6103),
    ERR_BIND_FAIL_GUID_NULL((String) 6104),
    ERR_BIND_FAIL_UNPACK_REGPACK_FAILED((String) 6105),
    ERR_BIND_FAIL_REG_TIMEOUT((String) 6106),
    ERR_BIND_FAIL_ISBINDING((String) 6107),
    ERR_PACKET_FAIL_UNKNOWN((String) 6120),
    ERR_PACKET_FAIL_REQ_NO_NET((String) 6121),
    ERR_PACKET_FAIL_RESP_NO_NET((String) 6122),
    ERR_PACKET_FAIL_REQ_NO_AUTH((String) 6123),
    ERR_PACKET_FAIL_SSO_ERR((String) 6124),
    ERR_PACKET_FAIL_REQ_TIMEOUT((String) 6125),
    ERR_PACKET_FAIL_RESP_TIMEOUT((String) 6126),
    ERR_PACKET_FAIL_REQ_ON_RESEND((String) 6127),
    ERR_PACKET_FAIL_RESP_NO_RESEND((String) 6128),
    ERR_PACKET_FAIL_FLOW_SAVE_FILTERED((String) 6129),
    ERR_PACKET_FAIL_REQ_OVER_LOAD((String) 6130),
    ERR_PACKET_FAIL_LOGIC_ERR((String) 6131),
    ERR_FRIENDSHIP_PROXY_NOT_SYNCED((String) 6150),
    ERR_FRIENDSHIP_PROXY_SYNCING((String) 6151),
    ERR_FRIENDSHIP_PROXY_SYNCED_FAIL((String) 6152),
    ERR_FRIENDSHIP_PROXY_LOCAL_CHECK_ERR((String) 6153),
    ERR_GROUP_INVALID_FIELD((String) 6160),
    ERR_GROUP_STORAGE_DISABLED((String) 6161),
    ERR_LOADGRPINFO_FAILED((String) 6162),
    ERR_REQ_NO_NET_ON_REQ((String) BaseConstants.ERR_REQUEST_NO_NET_ONREQ),
    ERR_REQ_NO_NET_ON_RSP((String) BaseConstants.ERR_REQUEST_NO_NET_ONRSP),
    ERR_SERIVCE_NOT_READY((String) BaseConstants.ERR_SERIVCE_NOT_READY),
    ERR_USER_SIG_EXPIRED((String) BaseConstants.ERR_USER_SIG_EXPIRED),
    ERR_LOGIN_AUTH_FAILED((String) 6207),
    ERR_LOGIN_KICKED_OFF_BY_OTHER((String) BaseConstants.ERR_LOGIN_KICKED_OFF_BY_OTHER),
    ERR_NEVER_CONNECT_AFTER_LAUNCH((String) BaseConstants.ERR_NEVER_CONNECT_AFTER_LAUNCH),
    ERR_REQ_FAILED((String) BaseConstants.ERR_REQUEST_FAILED),
    ERR_REQ_INVALID_REQ((String) BaseConstants.ERR_REQUEST_INVALID_REQ),
    ERR_REQ_OVERLOADED((String) BaseConstants.ERR_REQUEST_OVERLOADED),
    ERR_REQ_KICK_OFF((String) BaseConstants.ERR_REQUEST_KICK_OFF),
    ERR_REQ_SERVICE_SUSPEND((String) BaseConstants.ERR_REQUEST_SERVICE_SUSPEND),
    ERR_REQ_INVALID_SIGN((String) BaseConstants.ERR_REQUEST_INVALID_SIGN),
    ERR_REQ_INVALID_COOKIE((String) BaseConstants.ERR_REQUEST_INVALID_COOKIE),
    ERR_LOGIN_TLS_RSP_PARSE_FAILED((String) BaseConstants.ERR_LOGIN_TLS_RSP_PARSE_FAILED),
    ERR_LOGIN_OPENMSG_TIMEOUT((String) BaseConstants.ERR_LOGIN_OPENMSG_TIMEOUT),
    ERR_LOGIN_OPENMSG_RSP_PARSE_FAILED((String) BaseConstants.ERR_LOGIN_OPENMSG_RSP_PARSE_FAILED),
    ERR_LOGIN_TLS_DECRYPT_FAILED((String) BaseConstants.ERR_LOGIN_TLS_DECRYPT_FAILED),
    ERR_WIFI_NEED_AUTH((String) BaseConstants.ERR_WIFI_NEED_AUTH),
    ERR_USER_CANCELED((String) BaseConstants.ERR_USER_CANCELED),
    ERR_REVOKE_TIME_LIMIT_EXCEED((String) BaseConstants.ERR_REVOKE_TIME_LIMIT_EXCEED),
    ERR_LACK_UGC_EXT((String) 6224),
    ERR_REQ_CONTENT_ATTACK((String) 80001),
    ERR_LOGIN_SIG_EXPIRE((String) 70001),
    ERR_OPENBDH_BASE((String) 115000);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30639a;

        static /* synthetic */ int a() {
            int i = f30639a;
            f30639a = i + 1;
            return i;
        }
    }

    private ERROR_CODE(int i) {
        this.swigValue = i;
        int unused = aa.f30639a = i + 1;
    }

    private ERROR_CODE(ERROR_CODE error_code) {
        this.swigValue = error_code.swigValue;
        int unused = aa.f30639a = this.swigValue + 1;
    }

    public static ERROR_CODE swigToEnum(int i) {
        ERROR_CODE[] error_codeArr = (ERROR_CODE[]) ERROR_CODE.class.getEnumConstants();
        if (i < error_codeArr.length && i >= 0 && error_codeArr[i].swigValue == i) {
            return error_codeArr[i];
        }
        for (ERROR_CODE error_code : error_codeArr) {
            if (error_code.swigValue == i) {
                return error_code;
            }
        }
        throw new IllegalArgumentException("No enum " + ERROR_CODE.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
