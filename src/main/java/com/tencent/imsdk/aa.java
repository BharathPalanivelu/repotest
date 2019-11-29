package com.tencent.imsdk;

import android.util.SparseArray;
import com.google.android.gms.location.places.Place;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import tencent.tls.platform.TLSErrInfo;

final class aa extends SparseArray<IMErrInfo> {
    aa() {
        put(1001, new IMErrInfo(BaseConstants.ERR_REQUEST_FAILED, ""));
        put(1002, new IMErrInfo(BaseConstants.ERR_REQUEST_TIMEOUT, ""));
        put(1007, new IMErrInfo(BaseConstants.ERR_REQUEST_INVALID_REQ, ""));
        put(1008, new IMErrInfo(BaseConstants.ERR_REQUEST_OVERLOADED, ""));
        put(Place.TYPE_POINT_OF_INTEREST, new IMErrInfo(BaseConstants.ERR_SERIVCE_NOT_READY, "QALSERVICE not ready"));
        put(Place.TYPE_POST_BOX, new IMErrInfo(BaseConstants.ERR_REQUEST_NO_NET_ONREQ, "Network is not avaliable"));
        put(Place.TYPE_POSTAL_CODE, new IMErrInfo(BaseConstants.ERR_NEVER_CONNECT_AFTER_LAUNCH, ""));
        put(Place.TYPE_POSTAL_CODE_PREFIX, new IMErrInfo(BaseConstants.ERR_TLSSDK_NOT_INITIALIZED, ""));
        put(Place.TYPE_POSTAL_TOWN, new IMErrInfo(BaseConstants.ERR_TLSSDK_FIND_NO_USER, ""));
        put(1018, new IMErrInfo(BaseConstants.ERR_WIFI_NEED_AUTH, "wifi does not have internet connection"));
        put(1019, new IMErrInfo(BaseConstants.ERR_WIFI_NEED_AUTH, "no short connection available"));
        put(2001, new IMErrInfo(BaseConstants.ERR_SDK_NOT_LOGGED_IN, ""));
        put(2009, new IMErrInfo(BaseConstants.ERR_REQUEST_SERVICE_SUSPEND, ""));
        put(2012, new IMErrInfo(BaseConstants.ERR_REQUEST_KICK_OFF, ""));
        put(2013, new IMErrInfo(BaseConstants.ERR_REQUEST_KICK_OFF, ""));
        put(2014, new IMErrInfo(BaseConstants.ERR_REQUEST_INVALID_SIGN, ""));
        put(2015, new IMErrInfo(BaseConstants.ERR_REQUEST_INVALID_COOKIE, ""));
        put(2101, new IMErrInfo(BaseConstants.ERR_LOGIN_OPENMSG_TIMEOUT, ""));
        put(2102, new IMErrInfo(BaseConstants.ERR_LOGIN_OPENMSG_RSP_PARSE_FAILED, ""));
        put(2103, new IMErrInfo(BaseConstants.ERR_LOGIN_KICKED_OFF_BY_OTHER, "Kicked off by other device"));
        put(-1, new IMErrInfo(BaseConstants.ERR_TLSSDK_NOT_INITIALIZED, ""));
        put(TLSErrInfo.TIMEOUT, new IMErrInfo(BaseConstants.ERR_REQUEST_TIMEOUT, ""));
        put(TLSErrInfo.DECRYPT_FAILED, new IMErrInfo(BaseConstants.ERR_LOGIN_TLS_DECRYPT_FAILED, ""));
        put(TLSErrInfo.PK_LEN, new IMErrInfo(BaseConstants.ERR_LOGIN_TLS_RSP_PARSE_FAILED, ""));
        put(TLSErrInfo.NO_NETWORK_ERROR, new IMErrInfo(BaseConstants.ERR_REQUEST_NO_NET_ONREQ, "Network is not avaliable"));
        put(TLSErrInfo.NO_QAL_SERVICE, new IMErrInfo(BaseConstants.ERR_SERIVCE_NOT_READY, "QALSERVICE not ready"));
        put(-10001, new IMErrInfo(BaseConstants.ERR_USER_SIG_EXPIRED, ""));
        put(-10003, new IMErrInfo(BaseConstants.ERR_USER_SIG_EXPIRED, ""));
        put(-10004, new IMErrInfo(BaseConstants.ERR_USER_SIG_EXPIRED, ""));
        put(IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM, new IMErrInfo(BaseConstants.ERR_USER_SIG_EXPIRED, ""));
    }
}
