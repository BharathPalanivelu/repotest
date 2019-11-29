package com.tencent.timint;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.IMMsfUserInfo;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConnListener;
import com.tencent.imsdk.TIMLogLevel;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMNetworkStatus;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.quality_report;
import com.tencent.imsdk.utils.BuglyUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TIMIntManager {
    static TIMIntManager inst = new TIMIntManager();
    private static final String tag = "MSF.C.TIMIntManager";
    private TIMConnListener connListener = null;
    DBHelper dbhelper = new DBHelper(this.msfCoreProxy.getContext(), "QualityReport.db");
    private IMMsfCoreProxy msfCoreProxy = IMMsfCoreProxy.get();
    private ExecutorService pool = Executors.newFixedThreadPool(1);
    private Random random = new Random();

    private TIMIntManager() {
    }

    public static TIMIntManager getInstance() {
        return inst;
    }

    /* access modifiers changed from: private */
    public void resendLocalQualityReport(String str) {
        QLog.d(tag, 1, "start to resend local quality report");
        this.pool.execute(new ad(this, str));
    }

    /* access modifiers changed from: private */
    public void storeQualityReportToLocal(quality_report.ReqBody reqBody) {
        QLog.d(tag, 1, "store quality report to local");
        this.pool.execute(new ac(this, reqBody));
    }

    public TIMConnListener getConnectionListener() {
        return this.connListener;
    }

    /* access modifiers changed from: package-private */
    public int getDeviceType() {
        Context context = this.msfCoreProxy.getContext();
        if (context == null) {
            return 2;
        }
        return (((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0 || (context.getResources().getConfiguration().screenLayout & 15) >= 3) ? 3 : 2;
    }

    public boolean getIsLogPrintEnabled() {
        return IMMsfCoreProxy.get().getSdkConfig() == null || IMMsfCoreProxy.get().getSdkConfig().isLogPrintEnabled();
    }

    public TIMLogLevel getLogLevel() {
        return IMMsfCoreProxy.get().getSdkConfig() == null ? TIMLogLevel.DEBUG : IMMsfCoreProxy.get().getSdkConfig().getLogLevel();
    }

    public String getLogPath() {
        return IMMsfCoreProxy.get().getSdkConfig() == null ? "" : IMMsfCoreProxy.get().getSdkConfig().getLogPath();
    }

    public TIMNetworkStatus getNetworkStatus() {
        return IMMsfCoreProxy.get().getNetworkStatus();
    }

    /* access modifiers changed from: package-private */
    public int getNetworkType() {
        Context context = this.msfCoreProxy.getContext();
        if (context == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 5;
        }
        if (type == 0) {
            if (!TextUtils.isEmpty(Proxy.getDefaultHost())) {
                return 1;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
            }
        }
        return 6;
    }

    public long getTinyId() {
        String loginUser = TIMManager.getInstance().getLoginUser();
        QLog.i(tag, 1, "getTinyId, identifier: " + loginUser);
        if (TextUtils.isEmpty(loginUser)) {
            return 0;
        }
        IMMsfUserInfo msfUserInfo = IMMsfCoreProxy.get().getMsfUserInfo(loginUser);
        if (msfUserInfo != null && msfUserInfo.isLoggedIn()) {
            return msfUserInfo.getTinyid();
        }
        QLog.e(tag, 1, "getTinyId, user not online");
        return 0;
    }

    public void logBugly(TIMLogLevel tIMLogLevel, String str, String str2) {
        BuglyUtils.getInstance().log(tIMLogLevel, str, str2);
    }

    public void request(String str, byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack) {
        IMMsfUserInfo anyOnLineMsfUserInfo = IMMsfCoreProxy.get().getAnyOnLineMsfUserInfo();
        if (anyOnLineMsfUserInfo == null || !anyOnLineMsfUserInfo.isLoggedIn()) {
            QLog.e(tag, 1, "TIMIntManager|request no user online");
            anyOnLineMsfUserInfo = new IMMsfUserInfo();
        }
        this.msfCoreProxy.request(anyOnLineMsfUserInfo.getIdentifier(), str, bArr, tIMValueCallBack);
    }

    public void request(String str, byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        IMMsfUserInfo anyOnLineMsfUserInfo = IMMsfCoreProxy.get().getAnyOnLineMsfUserInfo();
        if (anyOnLineMsfUserInfo == null || !anyOnLineMsfUserInfo.isLoggedIn()) {
            QLog.e(tag, 1, "TIMIntManager|request no user online");
            anyOnLineMsfUserInfo = new IMMsfUserInfo();
        }
        this.msfCoreProxy.request(anyOnLineMsfUserInfo.getIdentifier(), str, bArr, tIMValueCallBack, j);
    }

    public void requestMultiVideoApp(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack) {
        aa.a().a(bArr, tIMValueCallBack, 0);
    }

    public void requestMultiVideoApp(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        aa.a().a(bArr, tIMValueCallBack, j);
    }

    public void requestMultiVideoInfo(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack) {
        aa.a().b(bArr, tIMValueCallBack, 0);
    }

    public void requestMultiVideoInfo(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        aa.a().b(bArr, tIMValueCallBack, j);
    }

    public void requestQualityReport(int i, byte[] bArr, TIMCallBack tIMCallBack) {
        QLog.d(tag, 1, "quality report, type: " + i);
        if (tIMCallBack != null) {
            if (bArr == null) {
                QLog.e(tag, 1, "invalid param");
                tIMCallBack.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
            } else if (!this.msfCoreProxy.inited) {
                QLog.e(tag, 1, "sdk not initialized");
                tIMCallBack.onError(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not initialized");
            } else {
                quality_report.ReqBody reqBody = new quality_report.ReqBody();
                reqBody.uint32_sdkappid.set(this.msfCoreProxy.getSdkAppId());
                reqBody.uint64_from_uin.set(getTinyId());
                reqBody.uint32_timestamp.set((int) (System.currentTimeMillis() / 1000));
                reqBody.uint32_seq.set(this.random.nextInt());
                reqBody.msg_common_info.setHasFlag(true);
                reqBody.msg_common_info.msg_device_info.setHasFlag(true);
                reqBody.msg_common_info.msg_device_info.enum_device_type.set(getDeviceType());
                reqBody.msg_common_info.msg_device_info.str_device_board.set(Build.BOARD);
                reqBody.msg_common_info.msg_device_info.str_device_brand.set(Build.BRAND);
                reqBody.msg_common_info.msg_device_info.str_device_model.set(Build.MODEL);
                reqBody.msg_common_info.msg_device_info.str_device_cpu_abi.set(Build.CPU_ABI);
                reqBody.msg_common_info.msg_system_info.setHasFlag(true);
                reqBody.msg_common_info.msg_system_info.enum_os_type.set(1);
                reqBody.msg_common_info.msg_system_info.str_os_version.set(Build.VERSION.RELEASE);
                reqBody.msg_common_info.msg_network_info.setHasFlag(true);
                reqBody.msg_common_info.msg_network_info.enum_network_type.set(getNetworkType());
                reqBody.msg_report_content.setHasFlag(true);
                reqBody.msg_report_content.uint32_type.set(i);
                reqBody.msg_report_content.bytes_report_data.set(ByteStringMicro.copyFrom(bArr));
                request("AVQualityReportSvc.C2S", reqBody.toByteArray(), new af(this, tIMCallBack, reqBody));
            }
        }
    }

    public void setAvSDKVersionToBugly(String str, String str2) {
        BuglyUtils.getInstance().setAvSDKVersionToBugly(this.msfCoreProxy.getContext(), str, str2);
    }

    public void setBuglyDebugMode(boolean z) {
        BuglyUtils.getInstance().setDebugModeEnabled(z);
    }

    public void setConnectionListener(TIMConnListener tIMConnListener) {
        this.connListener = tIMConnListener;
    }

    public void setReqTimeout(long j) {
        this.msfCoreProxy.setReqTimeout(j);
    }

    public void tinyIdToUserId(List<Long> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack) {
        tinyIdToUserId(list, tIMValueCallBack, 0);
    }

    public void tinyIdToUserId(List<Long> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack, long j) {
        TIMTinyIdToUserId.get().tinyIdToUserId(list, tIMValueCallBack, j);
    }

    public void userIdToTinyId(List<String> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack) {
        userIdToTinyId(list, tIMValueCallBack, 0);
    }

    public void userIdToTinyId(List<String> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack, long j) {
        ArrayList arrayList = new ArrayList();
        for (String identifier : list) {
            TIMUser tIMUser = new TIMUser();
            tIMUser.setAccountType(IMMsfCoreProxy.get().getAccountType());
            tIMUser.setAppIdAt3rd(String.valueOf(IMMsfCoreProxy.get().getSdkAppId()));
            tIMUser.setIdentifier(identifier);
            arrayList.add(tIMUser);
        }
        TIMUserIdToTinyId.get().userIdToTinyId(arrayList, tIMValueCallBack, j);
    }
}
