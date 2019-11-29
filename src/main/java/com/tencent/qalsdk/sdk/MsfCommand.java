package com.tencent.qalsdk.sdk;

public enum MsfCommand {
    unknown,
    registerMsfService,
    unRegisterMsfService,
    loginAuth,
    changeUinLogin,
    delLoginedAccount,
    submitVerifyCode,
    refreVerifyCode,
    refreshTickets,
    getServerTime,
    registerPush,
    unRegisterPush,
    registerCmdCallback,
    resetCmdCallback,
    reportMsg,
    getServerConfig,
    onConnOpened,
    onReceFirstResp,
    onOepnConnAllFailed,
    onConnClosed,
    onConnWeakNet,
    onNetNeedSignon,
    onInvalidSign,
    onTokenExpired,
    onTicketChanged,
    onRecvConfigPush,
    onRecvVerifyCode,
    onRecvPushMsg,
    onRecvNotifyMsg,
    onOnlineStatusChanged,
    _msf_RegPush,
    _msf_UnRegPush,
    _msf_queryPush,
    _msf_refreToken,
    _msf_kickedAndCleanTokenResp,
    _msf_kickedResp,
    _msf_getConfig,
    _msf_HeartbeatAlive,
    _msf_NetException,
    SEND_WIRELESS_PSWREQ,
    SEND_WIRELESS_MEIBAOREQ,
    _setMsfSuspend,
    _setMsfResunmed,
    getPluginConfig,
    regUin_queryMobile,
    regUin_commitMobile,
    regUin_querySmsStat,
    regUin_reSendSms,
    regUin_commitSmsCode,
    regUin_commitPass,
    checkRole,
    changeToken,
    proxyRegisterPush,
    proxyUnRegisterPush,
    appDataIncerment,
    getAppDataCount,
    accountTokenSyncCheckSign,
    appReportLog,
    getMsfDebugInfo,
    reportRdm,
    reportSocket,
    pushSetConfig,
    getKey,
    getAlterTickets,
    openConn,
    getGatewayIp,
    setMsfConnStatus,
    sendVideoAck,
    processGuardModeChange,
    qqwifi_notifyAvail,
    imsdk_init,
    imsdk_testmsg,
    httpreq_remove,
    gm_GuardEvent,
    onConnInfo,
    qal_Hello,
    qal_setAppEnv,
    qal_setLogLevel,
    qal_setAppStatus,
    qal_reportEvent,
    qal_setServerEnv,
    qal_setProxyList,
    qal_cancelProxyList,
    qal_setDefineVersion
}
