package tencent.tls.platform;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.KeyAgreement;
import tencent.tls.account.TLSOpenAccountInfo;
import tencent.tls.account.acc_ask_code;
import tencent.tls.account.acc_commit;
import tencent.tls.account.acc_guest;
import tencent.tls.account.acc_reask_code;
import tencent.tls.account.acc_request;
import tencent.tls.account.acc_status;
import tencent.tls.account.acc_verify_code;
import tencent.tls.oidb.Oidb0x483_request;
import tencent.tls.oidb.Oidb0x483_response;
import tencent.tls.oidb.Oidb0x601_request;
import tencent.tls.oidb.Oidb0x601_response;
import tencent.tls.oidb.Oidb0x602_request;
import tencent.tls.oidb.Oidb0x602_response;
import tencent.tls.oidb.Oidb0xa0b_request;
import tencent.tls.oidb.Oidb0xa0b_response;
import tencent.tls.report.QLog;
import tencent.tls.request.SigInfo;
import tencent.tls.request.Ticket;
import tencent.tls.request.TinyInfo;
import tencent.tls.request.TransReqContext;
import tencent.tls.request.WorkThread;
import tencent.tls.request.async_context;
import tencent.tls.request.oicq_request;
import tencent.tls.request.req_global;
import tencent.tls.request.req_imgcode_reask;
import tencent.tls.request.req_imgcode_verify;
import tencent.tls.request.req_smslogin_ask;
import tencent.tls.request.req_smslogin_reask;
import tencent.tls.request.req_smslogin_verify;
import tencent.tls.request.req_tgtgt_nopicsig;
import tencent.tls.request.req_transport;
import tencent.tls.tlvs.tlv_t;
import tencent.tls.tools.EcdhCrypt;
import tencent.tls.tools.I18nMsg;
import tencent.tls.tools.MD5;
import tencent.tls.tools.util;

public class TLSHelper {
    private static TLSHelper __helper;
    /* access modifiers changed from: private */
    public static String guest;
    /* access modifiers changed from: private */
    public static String ssoGuest;
    /* access modifiers changed from: private */
    public int DummyGetSig = -1;
    /* access modifiers changed from: private */
    public int mAccType = 0;
    private String mAppVer = "";
    /* access modifiers changed from: private */
    public long mAsyncSeq = 0;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mCountry = 86;
    private req_global mG = new req_global((Context) null);
    /* access modifiers changed from: private */
    public int mMainSigMap = 262208;
    /* access modifiers changed from: private */
    public int mMiscBitmap = 16252;
    private acc_status mRegStatus = new acc_status();
    /* access modifiers changed from: private */
    public long mSdkAppid;
    /* access modifiers changed from: private */
    public long mSubAppid = 1;
    /* access modifiers changed from: private */
    public int mSubSigMap = 66560;
    /* access modifiers changed from: private */
    public TLSOpenAccountInfo openAccountInfo;

    public String getSDKVersion() {
        return util.SDK_VERSION;
    }

    private TLSHelper() {
    }

    public static TLSHelper getInstance() {
        TLSHelper tLSHelper;
        synchronized (TLSHelper.class) {
            if (__helper == null) {
                __helper = new TLSHelper();
            }
            tLSHelper = __helper;
        }
        return tLSHelper;
    }

    public TLSHelper init(Context context, long j) {
        QLog.initQAL();
        this.mContext = context;
        this.mSdkAppid = j;
        this.mAccType = 0;
        this.mAppVer = "";
        req_global._acc_type = 0;
        req_global.sdkappid = j;
        acc_status.apk_id = util.get_apk_id(this.mContext);
        Context context2 = this.mContext;
        acc_status.apk_sig = util.getPkgSigFromApkName(context2, context2.getPackageName());
        this.mG.set_context(this.mContext);
        shareKeyInit();
        requestInit();
        return this;
    }

    private int ShareKeyInitDefault() {
        this.mG._pub_key = util.string_to_buf(EcdhCrypt.DEFAULT_PUB_KEY);
        this.mG._share_key = util.string_to_buf(EcdhCrypt.DEFAULT_SHARE_KEY);
        StringBuilder sb = new StringBuilder();
        sb.append("android sdk ");
        req_global req_global = this.mG;
        sb.append(req_global._android_sdk);
        sb.append(" using DEFAULT key");
        QLog.w(sb.toString());
        return 0;
    }

    private int ShareKeyInitOpenSSL() {
        if (Build.VERSION.SDK_INT >= 23) {
            return -1;
        }
        EcdhCrypt ecdhCrypt = new EcdhCrypt(this.mContext);
        if (ecdhCrypt.GenereateKey() != 0) {
            return -1;
        }
        byte[] bArr = ecdhCrypt.get_c_pub_key();
        byte[] bArr2 = ecdhCrypt.get_g_share_key();
        if (bArr == null || bArr.length <= 0 || bArr2 == null || bArr2.length <= 0) {
            QLog.w("get client public key or shared key FAILED");
            return -2;
        }
        this.mG._pub_key = (byte[]) bArr.clone();
        this.mG._share_key = (byte[]) bArr2.clone();
        QLog.i("create key pair and shared key with OpenSSL OK");
        return 0;
    }

    private int ShareKeyInitBC() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC", "BC");
            instance.initialize(new ECGenParameterSpec("secp192k1"));
            KeyPair genKeyPair = instance.genKeyPair();
            PrivateKey privateKey = genKeyPair.getPrivate();
            byte[] encoded = genKeyPair.getPublic().getEncoded();
            PublicKey generatePublic = KeyFactory.getInstance("EC", "BC").generatePublic(new X509EncodedKeySpec(util.string_to_buf(EcdhCrypt.X509_S_PUB_KEY)));
            KeyAgreement instance2 = KeyAgreement.getInstance("ECDH", "BC");
            instance2.init(privateKey);
            instance2.doPhase(generatePublic, true);
            byte[] generateSecret = instance2.generateSecret();
            byte[] bArr = new byte[49];
            System.arraycopy(encoded, 23, bArr, 0, 49);
            byte[] mD5Byte = MD5.toMD5Byte(generateSecret);
            this.mG._pub_key = bArr;
            this.mG._share_key = mD5Byte;
            QLog.i("create key pair and shared key with bouncycastle OK");
            return 0;
        } catch (InvalidAlgorithmParameterException e2) {
            QLog.w("create key pair and shared key failed, " + e2.getMessage());
            return -1;
        } catch (NoSuchAlgorithmException e3) {
            QLog.w("create key pair and shared key failed, " + e3.getMessage());
            return -2;
        } catch (NoSuchProviderException e4) {
            QLog.w("create key pair and shared key failed, " + e4.getMessage());
            return -3;
        } catch (InvalidKeySpecException e5) {
            QLog.w("create key pair and shared key failed, " + e5.getMessage());
            return -4;
        } catch (InvalidKeyException e6) {
            QLog.w("create key pair and shared key failed, " + e6.getMessage());
            return -5;
        }
    }

    private int shareKeyInit() {
        QLog.i("Generate Shared Key Begin ...");
        if (ShareKeyInitOpenSSL() == 0 || ShareKeyInitBC() == 0) {
            return 0;
        }
        return ShareKeyInitDefault();
    }

    private int requestInit() {
        synchronized (this) {
            int i = util.get_saved_network_type(this.mContext);
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                str = "";
            }
            req_global.init();
            QLog.i("android version:" + str + " saved_network_type:" + i + " network_type:" + req_global._network_type + " release time:" + util.get_release_time() + " svn ver:" + util.SVN_VER);
        }
        return 0;
    }

    public void setTestHost(String str, boolean z) {
        oicq_request.set_test(1, str);
        this.mG._use_sso_channel = z;
    }

    public void setLocalId(int i) {
        acc_status.lang = i;
        req_global._local_id = i;
    }

    public void setTimeOut(int i) {
        this.mG._time_out = i;
    }

    public static void setLogcat(boolean z) {
        util.LOGCAT_OUT = z;
    }

    public void setCountry(int i) {
        this.mCountry = i;
    }

    public List<TLSUserInfo> getAllUserInfo() {
        return this.mG.get_all_logined_account();
    }

    public TLSUserInfo getLastUserInfo() {
        List<TLSUserInfo> list = this.mG.get_all_logined_account();
        TLSUserInfo tLSUserInfo = null;
        if (list == null) {
            return null;
        }
        for (TLSUserInfo next : list) {
            if (tLSUserInfo == null || next.createTime > tLSUserInfo.createTime) {
                tLSUserInfo = next;
            }
        }
        return tLSUserInfo;
    }

    public boolean needSmsVerify(String str) {
        return acc_status.mpasswd.length() == 0;
    }

    public boolean needLogin(String str) {
        SigInfo sigInfo;
        if (str == null) {
            return true;
        }
        long tinyId = this.mG.getTinyId(str);
        if (tinyId == 0) {
            sigInfo = null;
        } else {
            sigInfo = this.mG.get_siginfo(tinyId, this.mSdkAppid);
        }
        if (sigInfo == null || sigInfo._en_A1 == null || sigInfo._en_A1.length <= 0) {
            QLog.i("userAccount:" + str + " dwAppid:" + this.mSdkAppid + " IsUserHaveA1 false");
            return true;
        }
        QLog.i("userAccount:" + str + " dwAppid:" + this.mSdkAppid + " IsUserHaveA1 true");
        return false;
    }

    public Map<String, Object> getSSOTicket(String str) {
        HashMap hashMap = new HashMap();
        TLSUserInfo GetLocalSig = GetLocalSig(str, this.mSdkAppid);
        Ticket userTicket = getUserTicket(GetLocalSig, 64);
        if (userTicket == null) {
            hashMap.put("A2", new byte[0]);
            hashMap.put("A2Key", new byte[0]);
        } else {
            hashMap.put("A2", userTicket.Sig);
            hashMap.put("A2Key", userTicket.SigKey);
        }
        Ticket userTicket2 = getUserTicket(GetLocalSig, SigType.D2);
        if (userTicket2 == null) {
            hashMap.put("D2", new byte[0]);
            hashMap.put("D2Key", new byte[0]);
        } else {
            hashMap.put("D2", userTicket2.Sig);
            hashMap.put("D2Key", userTicket2.SigKey);
        }
        long j = 0;
        if (GetLocalSig != null) {
            j = GetLocalSig.tinyid;
            str = GetLocalSig.identifier;
        }
        hashMap.put("tinyID", Long.valueOf(j));
        hashMap.put("identifier", str);
        return hashMap;
    }

    public String getUserSig(String str) {
        Ticket localTicket = getLocalTicket(str, SigType.TLS);
        if (localTicket == null || localTicket.Sig == null || localTicket.Sig.length <= 0) {
            return "";
        }
        String str2 = new String(localTicket.Sig);
        QLog.i("ticket not null " + str2.length());
        return str2;
    }

    public String getGuestIdentifier() {
        String str = guest;
        if (str != null) {
            return str;
        }
        List<TLSUserInfo> list = this.mG.get_all_logined_account();
        if (list == null) {
            return null;
        }
        for (TLSUserInfo next : list) {
            if (next.userType == TinyInfo.UserType.USER_TYPE_GUEST) {
                String str2 = next.identifier;
                guest = str2;
                return str2;
            }
        }
        return null;
    }

    public String getSSOGuestIdentifier() {
        String str = ssoGuest;
        if (str != null) {
            return str;
        }
        List<TLSUserInfo> list = this.mG.get_all_logined_account();
        if (list == null) {
            return null;
        }
        for (TLSUserInfo next : list) {
            if (next.userType == TinyInfo.UserType.USER_TYPE_SSO_GUEST) {
                String str2 = next.identifier;
                ssoGuest = str2;
                return str2;
            }
        }
        return null;
    }

    public int TLSPwdResetAskCode(String str, TLSPwdResetListener tLSPwdResetListener) {
        QLog.i("TLSPwdResetAskCode ..." + str);
        return askCode(str, 64, false, tLSPwdResetListener);
    }

    public int TLSPwdRegAskCode(String str, TLSPwdRegListener tLSPwdRegListener) {
        QLog.i("TLSPwdRegAskCode ..." + str);
        return askCode(str, 49, false, tLSPwdRegListener);
    }

    public int TLSSmsRegAskCode(String str, TLSSmsRegListener tLSSmsRegListener) {
        QLog.i("TLSSmsRegAskCode ..." + str);
        return askCode(str, 33, false, tLSSmsRegListener);
    }

    private int askCode(String str, int i, boolean z, Object obj) {
        if (str == null || str.length() == 0) {
            return TLSErrInfo.INPUT_INVALID;
        }
        if (!z || !(this.openAccountInfo.checkInvalid() || this.openAccountInfo.status == TLSOpenAccountInfo.OpenAccountStatus.UNKNOWN || this.openAccountInfo.status == TLSOpenAccountInfo.OpenAccountStatus.USED_BINDED)) {
            this.mRegStatus.userID = str;
            acc_ask_code acc_ask_code = new acc_ask_code(i);
            TransReqContext transReqContext = new TransReqContext(obj);
            this.mRegStatus.sdkAppid = this.mSdkAppid;
            transReqContext.set_register_req();
            transReqContext.set_subcmd(acc_ask_code.get_cmd());
            if (z) {
                transReqContext._body = acc_ask_code.get_request(this.mAccType, str, req_global._apk_id, this.mAppVer, this.mCountry, this.mSdkAppid, req_global._IMEI, this.openAccountInfo);
            } else {
                transReqContext._body = acc_ask_code.get_request(this.mAccType, str, req_global._apk_id, this.mAppVer, this.mCountry, this.mSdkAppid, req_global._IMEI);
            }
            return RequestTransport((String) null, 0, str, (String) null, (long) this.mRegStatus.role, transReqContext);
        }
        QLog.i("openAccountInfo invalid or status == UNKNOW or status == LOGINED_BINDED");
        return TLSErrInfo.INPUT_INVALID;
    }

    public int TLSPwdResetReaskCode(TLSPwdResetListener tLSPwdResetListener) {
        QLog.i("TLSPwdResetReaskCode ...");
        return reaskCode(65, tLSPwdResetListener);
    }

    public int TLSPwdRegReaskCode(TLSPwdRegListener tLSPwdRegListener) {
        QLog.i("TLSPwdRegReaskCode ...");
        return reaskCode(52, tLSPwdRegListener);
    }

    public int TLSSmsRegReaskCode(TLSSmsRegListener tLSSmsRegListener) {
        QLog.i("TLSSmsRegReaskCode ...");
        return reaskCode(36, tLSSmsRegListener);
    }

    private int reaskCode(int i, Object obj) {
        acc_reask_code acc_reask_code = new acc_reask_code(i);
        TransReqContext transReqContext = new TransReqContext(obj);
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_reask_code.get_cmd());
        transReqContext._body = acc_reask_code.get_request(this.mRegStatus.token);
        return RequestTransport((String) null, 0, this.mRegStatus.userID, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    public int TLSPwdResetVerifyCode(String str, TLSPwdResetListener tLSPwdResetListener) {
        QLog.i("TLSPwdResetVerifyCode ...");
        return verifyCode(str, 66, tLSPwdResetListener);
    }

    public int TLSPwdRegVerifyCode(String str, TLSPwdRegListener tLSPwdRegListener) {
        QLog.i("TLSPwdRegVerifyCode ...");
        return verifyCode(str, 53, tLSPwdRegListener);
    }

    public int TLSSmsRegVerifyCode(String str, TLSSmsRegListener tLSSmsRegListener) {
        QLog.i("TLSSmsRegVerifyCode ...");
        return verifyCode(str, 37, tLSSmsRegListener);
    }

    private int verifyCode(String str, int i, Object obj) {
        if (str == null || str.length() == 0) {
            return TLSErrInfo.INPUT_INVALID;
        }
        acc_verify_code acc_verify_code = new acc_verify_code(i);
        TransReqContext transReqContext = new TransReqContext(obj);
        this.mRegStatus.msgcode = str.getBytes();
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_verify_code.get_cmd());
        transReqContext._body = acc_verify_code.get_request(this.mRegStatus.token, str.getBytes());
        return RequestTransport((String) null, 0, this.mRegStatus.userID, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    public int TLSPwdResetCommit(String str, TLSPwdResetListener tLSPwdResetListener) {
        QLog.i("TLSPwdResetCommit ...");
        return commit(str, 67, tLSPwdResetListener);
    }

    public int TLSPwdRegCommit(String str, TLSPwdRegListener tLSPwdRegListener) {
        QLog.i("TLSPwdRegCommit ...");
        return commit(str, 54, tLSPwdRegListener);
    }

    public int TLSSmsRegCommit(TLSSmsRegListener tLSSmsRegListener) {
        QLog.i("TLSSmsRegCommit No Password...");
        acc_status.mpasswd = util.get_mpasswd();
        return commit(acc_status.mpasswd, 38, tLSSmsRegListener);
    }

    private int commit(String str, int i, Object obj) {
        acc_commit acc_commit = new acc_commit(i);
        TransReqContext transReqContext = new TransReqContext(obj);
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_commit.get_cmd());
        transReqContext._body = acc_commit.get_request(this.mRegStatus.token, str, this.mRegStatus.msgcode);
        return RequestTransport((String) null, 0, this.mRegStatus.userID, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    public int TLSStrAccReg(String str, String str2, TLSStrAccRegListener tLSStrAccRegListener) {
        String str3 = str;
        if (str.length() == 0 || str.getBytes().length > 24 || str2.length() == 0 || str2.getBytes().length > 16 || str2.getBytes().length < 8) {
            return TLSErrInfo.INPUT_INVALID;
        }
        boolean z = true;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str3.charAt(i);
            if (charAt != '.' && charAt != '_' && !Character.isLetterOrDigit(charAt)) {
                return TLSErrInfo.INPUT_INVALID;
            }
            if (!Character.isDigit(charAt)) {
                z = false;
            }
        }
        if (z) {
            return TLSErrInfo.INPUT_INVALID;
        }
        acc_ask_code acc_ask_code = new acc_ask_code(97);
        TransReqContext transReqContext = new TransReqContext(tLSStrAccRegListener);
        acc_status acc_status = this.mRegStatus;
        acc_status.userID = str3;
        acc_status.password = str2;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_ask_code.get_cmd());
        String str4 = str;
        transReqContext._body = acc_ask_code.get_request(this.mAccType, str4, req_global._apk_id, this.mAppVer, this.mCountry, this.mSdkAppid, req_global._IMEI);
        return RequestTransport((String) null, 0, str, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    private int TLSStrAccRegCommit(TLSStrAccRegListener tLSStrAccRegListener) {
        acc_commit acc_commit = new acc_commit(102);
        TransReqContext transReqContext = new TransReqContext(tLSStrAccRegListener);
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_commit.get_cmd());
        transReqContext._body = acc_commit.get_request(this.mRegStatus.token, this.mRegStatus.password, (byte[]) null);
        return RequestTransport((String) null, 0, this.mRegStatus.userID, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    private int TLSGuestReg(TLSGuestRegListener tLSGuestRegListener) {
        acc_guest acc_guest = new acc_guest();
        TransReqContext transReqContext = new TransReqContext(tLSGuestRegListener);
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_guest.get_cmd());
        transReqContext._body = acc_guest.get_request(this.mAccType, req_global._apk_id, this.mAppVer, this.mCountry, this.mSdkAppid, req_global._IMEI);
        return RequestTransport((String) null, 0, (String) null, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    private int TLSSSOGuestReg(TLSSSORegListener tLSSSORegListener) {
        acc_guest acc_guest = new acc_guest();
        TransReqContext transReqContext = new TransReqContext(tLSSSORegListener);
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_guest.get_cmd());
        transReqContext._body = acc_guest.get_request(this.mAccType, req_global._apk_id, this.mAppVer, this.mCountry, this.mSdkAppid, req_global._IMEI);
        return RequestTransport((String) null, 0, (String) null, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    public int TLSRefreshUserSig(String str, final TLSRefreshUserSigListener tLSRefreshUserSigListener) {
        TLSOpenAccountInfo GetLocalOpenAccountInfo = GetLocalOpenAccountInfo(str, this.mSdkAppid);
        if (GetLocalOpenAccountInfo == null || !GetLocalOpenAccountInfo.openid.equals(str)) {
            QLog.i("Account RefreshUserSig");
            return GetStWithoutPasswd(str, this.mSdkAppid, tLSRefreshUserSigListener);
        }
        QLog.i("OpenAccount RefreshUserSig");
        final TLSOpenAccountInfo tLSOpenAccountInfo = this.openAccountInfo;
        this.openAccountInfo = GetLocalOpenAccountInfo;
        TLSOpenAccountLogin(new TLSExchangeTicketListener() {
            public void OnExchangeTicketSuccess(TLSUserInfo tLSUserInfo) {
                tLSRefreshUserSigListener.OnRefreshUserSigSuccess(tLSUserInfo);
                TLSOpenAccountInfo unused = TLSHelper.this.openAccountInfo = tLSOpenAccountInfo;
            }

            public void OnExchangeTicketFail(TLSErrInfo tLSErrInfo) {
                tLSRefreshUserSigListener.OnRefreshUserSigFail(tLSErrInfo);
                TLSOpenAccountInfo unused = TLSHelper.this.openAccountInfo = tLSOpenAccountInfo;
            }

            public void OnExchangeTicketTimeout(TLSErrInfo tLSErrInfo) {
                tLSRefreshUserSigListener.OnRefreshUserSigTimeout(tLSErrInfo);
                TLSOpenAccountInfo unused = TLSHelper.this.openAccountInfo = tLSOpenAccountInfo;
            }
        });
        return TLSErrInfo.PENDING;
    }

    private int GetStWithoutPasswd(String str, long j, Object obj) {
        if (str == null) {
            return TLSErrInfo.INPUT_INVALID;
        }
        final TLSUserInfo tLSUserInfo = new TLSUserInfo();
        final req_global clone = this.mG.getClone(0);
        final req_global req_global = clone;
        final String str2 = str;
        final long j2 = j;
        final TLSUserInfo tLSUserInfo2 = tLSUserInfo;
        final Object obj2 = obj;
        new WorkThread(Looper.myLooper(), new WorkThread.Worker() {
            public int work() {
                int i;
                async_context async_context = req_global.get_async_data(req_global._seq);
                QLog.i("wtlogin login with GetStWithoutPasswd:user:" + str2 + " dwSrcAppid:" + TLSHelper.this.mSdkAppid + " dwDstAppid:" + j2 + " dwMainSigMap:" + TLSHelper.this.mMainSigMap + " dwSubDstAppid:" + TLSHelper.this.mSubAppid + " Seq:" + req_global._seq + " ...");
                int i2 = util.get_saved_network_type(TLSHelper.this.mContext);
                req_global._network_type = util.get_network_type(TLSHelper.this.mContext);
                if (i2 != req_global._network_type) {
                    util.set_net_retry_type(TLSHelper.this.mContext, 0);
                    util.save_network_type(TLSHelper.this.mContext, req_global._network_type);
                }
                req_global._apn = util.get_apn_string(TLSHelper.this.mContext).getBytes();
                TLSUserInfo tLSUserInfo = tLSUserInfo2;
                String str = str2;
                tLSUserInfo.identifier = str;
                req_global req_global = req_global;
                req_global._userid = str;
                async_context._userid = str;
                req_global._uin = 0;
                async_context._tinyid = 0;
                async_context._src_appid = TLSHelper.this.mSdkAppid;
                async_context._appid = j2;
                async_context._sub_appid = TLSHelper.this.mSubAppid;
                async_context._main_sigmap = TLSHelper.this.mMainSigMap;
                async_context._last_err_msg = new TLSErrInfo();
                long tinyId = req_global.getTinyId(str2);
                int i3 = -1004;
                if (tinyId == 0) {
                    QLog.i("user:" + str2 + " have not found uin record.");
                    i3 = TLSErrInfo.LOGIN_NO_ID;
                } else {
                    req_global._uin = tinyId;
                    TLSHelper tLSHelper = TLSHelper.this;
                    byte[] access$500 = tLSHelper.GetA1ByAccount(str2, tLSHelper.mSdkAppid);
                    TLSHelper tLSHelper2 = TLSHelper.this;
                    byte[] access$600 = tLSHelper2.GetNoPicSigByAccount(str2, tLSHelper2.mSdkAppid);
                    if (access$500 == null || access$500.length <= 0 || access$600 == null || access$600.length <= 0) {
                        i = -1004;
                    } else {
                        QLog.i("user:" + str2 + " exchange A2 from A1.", req_global._uin);
                        async_context._tmp_pwd = access$500;
                        async_context._tmp_no_pic_sig = access$600;
                        req_tgtgt_nopicsig req_tgtgt_nopicsig = r1;
                        req_tgtgt_nopicsig req_tgtgt_nopicsig2 = new req_tgtgt_nopicsig(req_global);
                        i = req_tgtgt_nopicsig.make_request(j2, 1, req_global._uin, 0, req_global._ip_addr, access$500, access$600, TLSHelper.this.mMiscBitmap, TLSHelper.this.mSubSigMap, (long[]) null, TLSHelper.this.mMainSigMap, TLSHelper.this.mSubAppid, 1, req_global._pic_type, 0, 0, 1, TLSHelper.this.mSdkAppid, tLSUserInfo2);
                    }
                    if (i == 0) {
                        SigInfo sigInfo = req_global.get_siginfo(tinyId, j2);
                        if (sigInfo != null) {
                            tLSUserInfo2.get_clone(sigInfo);
                        }
                    }
                    i3 = i;
                }
                req_global.close_connect();
                QLog.i("wtlogin login with GetStWithoutPasswd:user:" + str2 + " dwSrcAppid:" + TLSHelper.this.mSdkAppid + " dwDstAppid:" + j2 + " dwMainSigMap:0x" + Integer.toHexString(TLSHelper.this.mMainSigMap) + " dwSubDstAppid:" + TLSHelper.this.mSubAppid + " Seq:" + req_global._seq + " ret=" + i3, req_global._uin);
                return i3;
            }
        }, new WorkThread.When() {
            public void done(int i) {
                TLSErrInfo tLSErrInfo = req_global.get_async_data(clone._seq)._last_err_msg;
                req_global.remove_async_data(clone._seq);
                TLSRefreshUserSigListener tLSRefreshUserSigListener = (TLSRefreshUserSigListener) obj2;
                if (i == 0) {
                    tLSRefreshUserSigListener.OnRefreshUserSigSuccess(tLSUserInfo);
                } else if (i == -1000) {
                    tLSRefreshUserSigListener.OnRefreshUserSigTimeout(tLSErrInfo);
                } else {
                    tLSErrInfo.ErrCode = i;
                    tLSRefreshUserSigListener.OnRefreshUserSigFail(tLSErrInfo);
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    /* access modifiers changed from: private */
    public int GetStWithPasswd(String str, byte[] bArr, boolean z, Object obj) {
        if (str == null) {
            return TLSErrInfo.INPUT_INVALID;
        }
        final req_global clone = this.mG.getClone(this.mAsyncSeq);
        final TLSUserInfo tLSUserInfo = new TLSUserInfo();
        final byte[] bArr2 = bArr;
        final req_global req_global = clone;
        final String str2 = str;
        final TLSUserInfo tLSUserInfo2 = tLSUserInfo;
        final boolean z2 = z;
        final Object obj2 = obj;
        new WorkThread(Looper.myLooper(), new WorkThread.Worker() {
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0156, code lost:
                if (r1 != 0) goto L_0x029a;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int work() {
                /*
                    r38 = this;
                    r0 = r38
                    byte[] r1 = r2
                    tencent.tls.request.req_global r2 = r3
                    long r2 = r2._seq
                    tencent.tls.request.async_context r2 = tencent.tls.request.req_global.get_async_data(r2)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "wtlogin login with GetStWithPasswd:user:"
                    r3.append(r4)
                    java.lang.String r5 = r4
                    r3.append(r5)
                    java.lang.String r5 = " accType: "
                    r3.append(r5)
                    tencent.tls.platform.TLSHelper r5 = tencent.tls.platform.TLSHelper.this
                    int r5 = r5.mAccType
                    r3.append(r5)
                    java.lang.String r5 = " dwAppid:"
                    r3.append(r5)
                    tencent.tls.platform.TLSHelper r6 = tencent.tls.platform.TLSHelper.this
                    long r6 = r6.mSdkAppid
                    r3.append(r6)
                    java.lang.String r6 = " dwMainSigMap:0x"
                    r3.append(r6)
                    tencent.tls.platform.TLSHelper r6 = tencent.tls.platform.TLSHelper.this
                    int r6 = r6.mMainSigMap
                    java.lang.String r6 = java.lang.Integer.toHexString(r6)
                    r3.append(r6)
                    java.lang.String r6 = " dwSubAppid:"
                    r3.append(r6)
                    tencent.tls.platform.TLSHelper r7 = tencent.tls.platform.TLSHelper.this
                    long r7 = r7.mSubAppid
                    r3.append(r7)
                    java.lang.String r7 = " Seq:"
                    r3.append(r7)
                    tencent.tls.request.req_global r8 = r3
                    long r8 = r8._seq
                    r3.append(r8)
                    java.lang.String r8 = " ..."
                    r3.append(r8)
                    java.lang.String r3 = r3.toString()
                    tencent.tls.report.QLog.i(r3)
                    if (r1 == 0) goto L_0x0074
                    int r3 = r1.length
                    if (r3 != 0) goto L_0x007a
                L_0x0074:
                    java.lang.String r1 = r2._mpasswd
                    byte[] r1 = r1.getBytes()
                L_0x007a:
                    java.lang.String r3 = ""
                    tencent.tls.account.acc_status.mpasswd = r3
                    long r8 = tencent.tls.account.acc_status.msalt
                    r10 = 0
                    int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                    if (r3 == 0) goto L_0x008c
                    long r8 = tencent.tls.account.acc_status.msalt
                    r2._msalt = r8
                    tencent.tls.account.acc_status.msalt = r10
                L_0x008c:
                    int r3 = r1.length
                    r8 = 16
                    r9 = 0
                    if (r3 <= r8) goto L_0x0095
                    java.lang.System.arraycopy(r1, r9, r1, r9, r8)
                L_0x0095:
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    android.content.Context r3 = r3.mContext
                    int r3 = tencent.tls.tools.util.get_saved_network_type(r3)
                    tencent.tls.platform.TLSHelper r8 = tencent.tls.platform.TLSHelper.this
                    android.content.Context r8 = r8.mContext
                    int r8 = tencent.tls.tools.util.get_network_type(r8)
                    tencent.tls.request.req_global._network_type = r8
                    int r8 = tencent.tls.request.req_global._network_type
                    if (r3 == r8) goto L_0x00c3
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    android.content.Context r3 = r3.mContext
                    tencent.tls.tools.util.set_net_retry_type(r3, r9)
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    android.content.Context r3 = r3.mContext
                    int r8 = tencent.tls.request.req_global._network_type
                    tencent.tls.tools.util.save_network_type(r3, r8)
                L_0x00c3:
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    android.content.Context r3 = r3.mContext
                    java.lang.String r3 = tencent.tls.tools.util.get_apn_string(r3)
                    byte[] r3 = r3.getBytes()
                    tencent.tls.request.req_global._apn = r3
                    tencent.tls.platform.TLSUserInfo r3 = r5
                    java.lang.String r8 = r4
                    r3.identifier = r8
                    tencent.tls.request.req_global r3 = r3
                    r3._userid = r8
                    r2._userid = r8
                    r3._uin = r10
                    r2._tinyid = r10
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r12 = r3.mSdkAppid
                    r2._src_appid = r12
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r12 = r3.mSdkAppid
                    r2._appid = r12
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r12 = r3.mSubAppid
                    r2._sub_appid = r12
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    int r3 = r3.mMainSigMap
                    r2._main_sigmap = r3
                    tencent.tls.platform.TLSErrInfo r3 = new tencent.tls.platform.TLSErrInfo
                    r3.<init>()
                    r2._last_err_msg = r3
                    int r3 = r1.length
                    if (r3 <= 0) goto L_0x0115
                    byte[] r1 = tencent.tls.tools.MD5.toMD5Byte((byte[]) r1)
                    r2._tmp_pwd = r1
                    r2._tmp_pwd_type = r9
                L_0x0115:
                    java.lang.String r1 = r4
                    int r1 = r1.length()
                    int r3 = tencent.tls.tools.util.MAX_NAME_LEN
                    if (r1 <= r3) goto L_0x0123
                    r1 = -1008(0xfffffffffffffc10, float:NaN)
                    goto L_0x029a
                L_0x0123:
                    long r12 = r2._msalt
                    int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                    if (r1 != 0) goto L_0x015a
                    tencent.tls.request.req_getsalt r12 = new tencent.tls.request.req_getsalt
                    tencent.tls.request.req_global r1 = r3
                    r12.<init>(r1)
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    long r13 = r1.mSdkAppid
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    long r15 = r1.mSubAppid
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    int r17 = r1.mMainSigMap
                    java.lang.String r1 = r4
                    int r19 = tencent.tls.request.req_global._pic_type
                    r20 = 0
                    r21 = 0
                    r22 = 1
                    tencent.tls.platform.TLSUserInfo r3 = r5
                    r18 = r1
                    r23 = r3
                    int r1 = r12.make_request(r13, r15, r17, r18, r19, r20, r21, r22, r23)
                    if (r1 == 0) goto L_0x015a
                    goto L_0x029a
                L_0x015a:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r3 = "get salt: "
                    r1.append(r3)
                    long r12 = r2._msalt
                    int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                    if (r3 == 0) goto L_0x016c
                    r3 = 1
                    goto L_0x016d
                L_0x016c:
                    r3 = 0
                L_0x016d:
                    r1.append(r3)
                    java.lang.String r1 = r1.toString()
                    tencent.tls.report.QLog.i(r1)
                    int r1 = r2._tmp_pwd_type
                    java.lang.String r3 = "user:"
                    if (r1 == 0) goto L_0x01ef
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r3)
                    java.lang.String r3 = r4
                    r1.append(r3)
                    java.lang.String r3 = " login with saved A1."
                    r1.append(r3)
                    java.lang.String r1 = r1.toString()
                    tencent.tls.request.req_global r3 = r3
                    long r8 = r3._uin
                    tencent.tls.report.QLog.i(r1, r8)
                    tencent.tls.request.req_TGTGT r1 = new tencent.tls.request.req_TGTGT
                    r10 = r1
                    tencent.tls.request.req_global r3 = r3
                    r1.<init>(r3)
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    long r11 = r1.mSdkAppid
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    long r13 = r1.mSubAppid
                    r15 = 1
                    tencent.tls.request.req_global r1 = r3
                    long r8 = r1._uin
                    r16 = r8
                    r18 = 0
                    byte[] r19 = tencent.tls.request.req_global._ip_addr
                    byte[] r1 = r2._tmp_pwd
                    r20 = r1
                    byte[] r1 = r2._tmp_no_pic_sig
                    r21 = r1
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    int r22 = r1.mMiscBitmap
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    int r23 = r1.mSubSigMap
                    r24 = 0
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    int r25 = r1.mMainSigMap
                    tencent.tls.platform.TLSHelper r1 = tencent.tls.platform.TLSHelper.this
                    long r26 = r1.mSubAppid
                    r28 = 1
                    int r29 = tencent.tls.request.req_global._pic_type
                    r30 = 0
                    r31 = 0
                    r32 = 1
                    tencent.tls.platform.TLSUserInfo r1 = r5
                    r33 = r1
                    int r1 = r10.make_request(r11, r13, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r32, r33)
                    goto L_0x027f
                L_0x01ef:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r3)
                    java.lang.String r3 = r4
                    r1.append(r3)
                    java.lang.String r3 = " login with input password."
                    r1.append(r3)
                    java.lang.String r1 = r1.toString()
                    tencent.tls.request.req_global r3 = r3
                    long r12 = r3._uin
                    tencent.tls.report.QLog.i(r1, r12)
                    r1 = 4
                    byte[] r1 = new byte[r1]
                    long r12 = java.lang.System.currentTimeMillis()
                    r14 = 1000(0x3e8, double:4.94E-321)
                    long r12 = r12 / r14
                    long r14 = tencent.tls.request.req_global._l_init_time
                    long r12 = r12 + r14
                    long r14 = tencent.tls.account.acc_status.regtime
                    int r3 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
                    if (r3 != 0) goto L_0x0220
                    goto L_0x0222
                L_0x0220:
                    long r12 = tencent.tls.account.acc_status.regtime
                L_0x0222:
                    tencent.tls.tools.util.int64_to_buf32(r1, r9, r12)
                    tencent.tls.account.acc_status.regtime = r10
                    tencent.tls.request.req_TGTGT r3 = new tencent.tls.request.req_TGTGT
                    r12 = r3
                    tencent.tls.request.req_global r8 = r3
                    r3.<init>(r8)
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r13 = r3.mSdkAppid
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r15 = r3.mSubAppid
                    r17 = 1
                    tencent.tls.request.req_global r3 = r3
                    long r8 = r3._uin
                    r18 = r8
                    r20 = 0
                    byte[] r21 = tencent.tls.request.req_global._ip_addr
                    r23 = 0
                    byte[] r2 = r2._tmp_pwd
                    r24 = r2
                    boolean r2 = r6
                    r25 = r2
                    tencent.tls.platform.TLSHelper r2 = tencent.tls.platform.TLSHelper.this
                    int r26 = r2.mMiscBitmap
                    tencent.tls.platform.TLSHelper r2 = tencent.tls.platform.TLSHelper.this
                    int r27 = r2.mSubSigMap
                    r28 = 0
                    tencent.tls.platform.TLSHelper r2 = tencent.tls.platform.TLSHelper.this
                    int r29 = r2.mMainSigMap
                    tencent.tls.platform.TLSHelper r2 = tencent.tls.platform.TLSHelper.this
                    long r30 = r2.mSubAppid
                    r32 = 1
                    int r33 = tencent.tls.request.req_global._pic_type
                    r34 = 0
                    r35 = 0
                    r36 = 1
                    tencent.tls.platform.TLSUserInfo r2 = r5
                    r37 = r2
                    r22 = r1
                    int r1 = r12.make_request(r13, r15, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r36, r37)
                L_0x027f:
                    if (r1 == 0) goto L_0x0282
                    goto L_0x029a
                L_0x0282:
                    tencent.tls.request.req_global r2 = r3
                    long r8 = r2._uin
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r10 = r3.mSdkAppid
                    tencent.tls.request.SigInfo r2 = r2.get_siginfo(r8, r10)
                    if (r2 != 0) goto L_0x0295
                    r1 = -1004(0xfffffffffffffc14, float:NaN)
                    goto L_0x029a
                L_0x0295:
                    tencent.tls.platform.TLSUserInfo r3 = r5
                    r3.get_clone(r2)
                L_0x029a:
                    tencent.tls.request.req_global r2 = r3
                    r2.close_connect()
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    r2.append(r4)
                    java.lang.String r3 = r4
                    r2.append(r3)
                    r2.append(r5)
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r3 = r3.mSdkAppid
                    r2.append(r3)
                    java.lang.String r3 = " dwMainSigMap:"
                    r2.append(r3)
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    int r3 = r3.mMainSigMap
                    r2.append(r3)
                    r2.append(r6)
                    tencent.tls.platform.TLSHelper r3 = tencent.tls.platform.TLSHelper.this
                    long r3 = r3.mSubAppid
                    r2.append(r3)
                    r2.append(r7)
                    tencent.tls.request.req_global r3 = r3
                    long r3 = r3._seq
                    r2.append(r3)
                    java.lang.String r3 = " ret="
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r2 = r2.toString()
                    tencent.tls.request.req_global r3 = r3
                    long r3 = r3._uin
                    tencent.tls.report.QLog.i(r2, r3)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: tencent.tls.platform.TLSHelper.AnonymousClass4.work():int");
            }
        }, new WorkThread.When() {
            public void done(int i) {
                async_context async_context = req_global.get_async_data(clone._seq);
                TLSErrInfo tLSErrInfo = async_context._last_err_msg;
                Object obj = obj2;
                if (obj instanceof TLSSmsLoginListener) {
                    TLSSmsLoginListener tLSSmsLoginListener = (TLSSmsLoginListener) obj;
                    if (i == 0) {
                        tLSSmsLoginListener.OnSmsLoginSuccess(tLSUserInfo);
                    } else if (i == -1000) {
                        tLSSmsLoginListener.OnSmsLoginTimeout(tLSErrInfo);
                    } else {
                        tLSErrInfo.ErrCode = i;
                        tLSSmsLoginListener.OnSmsLoginFail(tLSErrInfo);
                    }
                } else if (obj instanceof TLSPwdLoginListener) {
                    TLSPwdLoginListener tLSPwdLoginListener = (TLSPwdLoginListener) obj;
                    if (i == 0) {
                        tLSPwdLoginListener.OnPwdLoginSuccess(tLSUserInfo);
                    } else if (i == 2) {
                        long unused = TLSHelper.this.mAsyncSeq = clone._seq;
                        tLSPwdLoginListener.OnPwdLoginNeedImgcode(async_context._t105.get_pic(), tLSErrInfo);
                    } else if (i == -1000) {
                        tLSPwdLoginListener.OnPwdLoginTimeout(tLSErrInfo);
                    } else {
                        tLSErrInfo.ErrCode = i;
                        tLSPwdLoginListener.OnPwdLoginFail(tLSErrInfo);
                    }
                } else if (obj instanceof TLSGuestLoginListener) {
                    TLSGuestLoginListener tLSGuestLoginListener = (TLSGuestLoginListener) obj;
                    if (i == 0) {
                        req_global req_global = clone;
                        req_global.put_guest(req_global._userid, clone._uin);
                        String unused2 = TLSHelper.guest = clone._userid;
                        tLSGuestLoginListener.OnGuestLoginSuccess(tLSUserInfo);
                    } else if (i == -1000) {
                        tLSGuestLoginListener.OnGuestLoginTimeout(tLSErrInfo);
                    } else {
                        tLSGuestLoginListener.OnGuestLoginFail(tLSErrInfo);
                    }
                } else if (obj instanceof TLSSSOGuestLoginListener) {
                    TLSSSOGuestLoginListener tLSSSOGuestLoginListener = (TLSSSOGuestLoginListener) obj;
                    if (i == 0) {
                        req_global req_global2 = clone;
                        req_global2.put_sso_guest(req_global2._userid, clone._uin);
                        String unused3 = TLSHelper.ssoGuest = clone._userid;
                        tLSSSOGuestLoginListener.OnGuestLoginSuccess(tLSUserInfo);
                    } else if (i == -1000) {
                        tLSSSOGuestLoginListener.OnGuestLoginTimeout(tLSErrInfo);
                    } else {
                        tLSSSOGuestLoginListener.OnGuestLoginFail(tLSErrInfo);
                    }
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    public int TLSSmsLogin(String str, TLSSmsLoginListener tLSSmsLoginListener) {
        QLog.i("user:" + str + " TLSSmsLogin ..." + this.mSubAppid);
        String str2 = acc_status.mpasswd;
        if (str2.length() > 0) {
            this.mAsyncSeq = 0;
        }
        QLog.i("has mpasswd? " + str2.length());
        return GetStWithPasswd(str, str2.getBytes(), true, tLSSmsLoginListener);
    }

    public int TLSPwdLogin(String str, byte[] bArr, TLSPwdLoginListener tLSPwdLoginListener) {
        QLog.i("user:" + str + " TLSPwdLogin ..." + this.mSdkAppid);
        this.mAsyncSeq = 0;
        return GetStWithPasswd(str, bArr, false, tLSPwdLoginListener);
    }

    public int TLSGuestLogin(final TLSGuestLoginListener tLSGuestLoginListener) {
        TLSGuestReg(new TLSGuestRegListener() {
            public void OnGuestRegSuccess(TLSUserInfo tLSUserInfo) {
                TLSHelper tLSHelper = TLSHelper.this;
                tLSHelper.clearUserInfo(tLSHelper.getGuestIdentifier());
                QLog.i("user:" + tLSUserInfo.identifier + " TLSGuestLogin ..." + TLSHelper.this.mSdkAppid);
                long unused = TLSHelper.this.mAsyncSeq = 0;
                int unused2 = TLSHelper.this.GetStWithPasswd(tLSUserInfo.identifier, acc_status.mpasswd.getBytes(), false, tLSGuestLoginListener);
            }

            public void OnGuestRegFail(TLSErrInfo tLSErrInfo) {
                tLSGuestLoginListener.OnGuestLoginFail(tLSErrInfo);
            }

            public void OnGuestRegTimeout(TLSErrInfo tLSErrInfo) {
                tLSGuestLoginListener.OnGuestLoginTimeout(tLSErrInfo);
            }
        });
        return TLSErrInfo.PENDING;
    }

    public int TLSSSOGuestLogin(final TLSSSOGuestLoginListener tLSSSOGuestLoginListener) {
        TLSSSOGuestReg(new TLSSSORegListener() {
            public void OnGuestRegSuccess(TLSUserInfo tLSUserInfo) {
                TLSHelper tLSHelper = TLSHelper.this;
                tLSHelper.clearUserInfo(tLSHelper.getSSOGuestIdentifier());
                QLog.i("user:" + tLSUserInfo.identifier + " TLSGuestLogin ..." + TLSHelper.this.mSdkAppid);
                long unused = TLSHelper.this.mAsyncSeq = 0;
                int unused2 = TLSHelper.this.GetStWithPasswd(tLSUserInfo.identifier, acc_status.mpasswd.getBytes(), false, tLSSSOGuestLoginListener);
            }

            public void OnGuestRegFail(TLSErrInfo tLSErrInfo) {
                tLSSSOGuestLoginListener.OnGuestLoginFail(tLSErrInfo);
            }

            public void OnGuestRegTimeout(TLSErrInfo tLSErrInfo) {
                tLSSSOGuestLoginListener.OnGuestLoginTimeout(tLSErrInfo);
            }
        });
        return TLSErrInfo.PENDING;
    }

    public int TLSSmsLoginAskCode(final String str, final TLSSmsLoginListener tLSSmsLoginListener) {
        acc_status.msalt = 0;
        acc_status.mpasswd = "";
        if (str == null) {
            return TLSErrInfo.INPUT_INVALID;
        }
        final TLSUserInfo tLSUserInfo = new TLSUserInfo();
        final req_global clone = this.mG.getClone(0);
        this.mAsyncSeq = clone._seq;
        new WorkThread(Looper.myLooper(), new WorkThread.Worker() {
            public int work() {
                async_context async_context = req_global.get_async_data(clone._seq);
                clone._userid = str;
                QLog.i("user:" + str + " Seq:" + clone._seq + " TLSSmsLoginAskCode ...");
                async_context._last_err_msg = new TLSErrInfo();
                int make_request = new req_smslogin_ask(clone).make_request(TLSHelper.this.mSdkAppid, TLSHelper.this.mSubAppid, TLSHelper.this.DummyGetSig, str, TLSHelper.this.mMiscBitmap, TLSHelper.this.mSubSigMap, tLSUserInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("user:");
                sb.append(clone._userid);
                sb.append(" Seq:");
                sb.append(clone._seq);
                sb.append(" TLSSmsLoginAskCode ret=");
                sb.append(make_request > 0 ? Integer.toHexString(make_request) : Integer.valueOf(make_request));
                QLog.i(sb.toString(), clone._uin);
                return make_request;
            }
        }, new WorkThread.When() {
            public void done(int i) {
                async_context async_context = req_global.get_async_data(clone._seq);
                TLSErrInfo tLSErrInfo = async_context._last_err_msg;
                if (i == 0) {
                    tLSSmsLoginListener.OnSmsLoginAskCodeSuccess(async_context._smslogin_reask, async_context._smslogin_expire);
                } else if (i == -1000) {
                    tLSSmsLoginListener.OnSmsLoginTimeout(tLSErrInfo);
                } else {
                    tLSSmsLoginListener.OnSmsLoginFail(tLSErrInfo);
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    public int TLSSmsLoginReaskCode(final String str, final TLSSmsLoginListener tLSSmsLoginListener) {
        if (str == null || str.length() == 0) {
            return TLSErrInfo.INPUT_INVALID;
        }
        final TLSUserInfo tLSUserInfo = new TLSUserInfo();
        final req_global clone = this.mG.getClone(this.mAsyncSeq);
        new WorkThread(Looper.myLooper(), new WorkThread.Worker() {
            public int work() {
                async_context async_context = req_global.get_async_data(clone._seq);
                QLog.i("user:" + str + " Seq:" + clone._seq + " TLSSmsLoginReaskCode ...");
                clone._userid = str;
                async_context._last_err_msg = new TLSErrInfo();
                int make_request = new req_smslogin_reask(clone).make_request(TLSHelper.this.mMiscBitmap, TLSHelper.this.mSubSigMap, (long[]) null, tLSUserInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("user:");
                sb.append(clone._userid);
                sb.append(" Seq:");
                sb.append(clone._seq);
                sb.append(" TLSSmsLoginReaskCode ret=");
                sb.append(make_request > 0 ? Integer.toHexString(make_request) : Integer.valueOf(make_request));
                QLog.i(sb.toString());
                return make_request;
            }
        }, new WorkThread.When() {
            public void done(int i) {
                async_context async_context = req_global.get_async_data(clone._seq);
                TLSErrInfo tLSErrInfo = async_context._last_err_msg;
                if (i == 0) {
                    tLSSmsLoginListener.OnSmsLoginReaskCodeSuccess(async_context._smslogin_reask, async_context._smslogin_expire);
                } else if (i == -1000) {
                    tLSSmsLoginListener.OnSmsLoginTimeout(tLSErrInfo);
                } else {
                    tLSSmsLoginListener.OnSmsLoginFail(tLSErrInfo);
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    public int TLSPwdLoginReaskImgcode(final TLSPwdLoginListener tLSPwdLoginListener) {
        new TLSUserInfo();
        final req_global clone = this.mG.getClone(this.mAsyncSeq);
        new WorkThread(Looper.myLooper(), new WorkThread.Worker() {
            public int work() {
                async_context async_context = req_global.get_async_data(clone._seq);
                QLog.i("user:" + clone._userid + " Seq:" + clone._seq + " TLSPwdLoginReaskImgcode ...");
                clone._userid = async_context._userid;
                clone._uin = async_context._tinyid;
                async_context._last_err_msg = new TLSErrInfo();
                int make_request = new req_imgcode_reask(clone).make_request();
                StringBuilder sb = new StringBuilder();
                sb.append("user:");
                sb.append(clone._userid);
                sb.append(" Seq:");
                sb.append(clone._seq);
                sb.append(" TLSPwdLoginReaskImgcode ret=");
                sb.append(make_request > 0 ? Integer.toHexString(make_request) : Integer.valueOf(make_request));
                QLog.i(sb.toString());
                return make_request;
            }
        }, new WorkThread.When() {
            public void done(int i) {
                async_context async_context = req_global.get_async_data(clone._seq);
                TLSErrInfo tLSErrInfo = async_context._last_err_msg;
                if (i == 2) {
                    long unused = TLSHelper.this.mAsyncSeq = clone._seq;
                    tLSPwdLoginListener.OnPwdLoginReaskImgcodeSuccess(async_context._t105.get_pic());
                } else if (i == -1000) {
                    tLSPwdLoginListener.OnPwdLoginTimeout(tLSErrInfo);
                } else {
                    tLSPwdLoginListener.OnPwdLoginFail(tLSErrInfo);
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    public int TLSSmsLoginVerifyCode(final String str, final TLSSmsLoginListener tLSSmsLoginListener) {
        if (str == null || str.length() == 0) {
            return TLSErrInfo.INPUT_INVALID;
        }
        final TLSUserInfo tLSUserInfo = new TLSUserInfo();
        final req_global clone = this.mG.getClone(this.mAsyncSeq);
        new WorkThread(Looper.myLooper(), new WorkThread.Worker() {
            public int work() {
                async_context async_context = req_global.get_async_data(clone._seq);
                QLog.i("user:" + clone._userid + " code:" + str + " Seq:" + clone._seq + " TLSSmsLoginVerifyCode ...");
                async_context._last_err_msg = new TLSErrInfo();
                async_context._mpasswd = util.get_mpasswd();
                int make_request = new req_smslogin_verify(clone).make_request(str, TLSHelper.this.mMiscBitmap, TLSHelper.this.mSubSigMap, (long[]) null, tLSUserInfo);
                QLog.i("user:" + clone._userid + " code:" + str + " Seq:" + clone._seq + " TLSSmsLoginVerifyCode ret=" + Integer.toHexString(make_request));
                return make_request;
            }
        }, new WorkThread.When() {
            public void done(int i) {
                TLSErrInfo tLSErrInfo = req_global.get_async_data(clone._seq)._last_err_msg;
                if (i == 0) {
                    tLSSmsLoginListener.OnSmsLoginVerifyCodeSuccess();
                } else if (i == -1000) {
                    tLSSmsLoginListener.OnSmsLoginTimeout(tLSErrInfo);
                } else {
                    tLSSmsLoginListener.OnSmsLoginFail(tLSErrInfo);
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    public int TLSPwdLoginVerifyImgcode(final String str, final TLSPwdLoginListener tLSPwdLoginListener) {
        final TLSUserInfo tLSUserInfo = new TLSUserInfo();
        final req_global clone = this.mG.getClone(this.mAsyncSeq);
        new WorkThread(Looper.myLooper(), new WorkThread.Worker() {
            public int work() {
                async_context async_context = req_global.get_async_data(clone._seq);
                QLog.i("user:" + clone._userid + " Seq:" + clone._seq + " TLSPwdLoginVerifyImgcode ...");
                TLSUserInfo tLSUserInfo = tLSUserInfo;
                req_global req_global = clone;
                String str = async_context._userid;
                req_global._userid = str;
                tLSUserInfo.identifier = str;
                clone._uin = async_context._tinyid;
                async_context._last_err_msg = new TLSErrInfo();
                int make_request = new req_imgcode_verify(clone).make_request(str);
                StringBuilder sb = new StringBuilder();
                sb.append("user:");
                sb.append(clone._userid);
                sb.append(" Seq:");
                sb.append(clone._seq);
                sb.append(" TLSPwdLoginVerifyImgcode ret=");
                sb.append(make_request > 0 ? Integer.toHexString(make_request) : Integer.valueOf(make_request));
                QLog.i(sb.toString());
                return make_request;
            }
        }, new WorkThread.When() {
            public void done(int i) {
                async_context async_context = req_global.get_async_data(clone._seq);
                TLSErrInfo tLSErrInfo = async_context._last_err_msg;
                if (i == 0) {
                    tLSPwdLoginListener.OnPwdLoginSuccess(tLSUserInfo);
                } else if (i == 2) {
                    long unused = TLSHelper.this.mAsyncSeq = clone._seq;
                    tLSPwdLoginListener.OnPwdLoginNeedImgcode(async_context._t105.get_pic(), tLSErrInfo);
                } else if (i == -1000) {
                    tLSPwdLoginListener.OnPwdLoginTimeout(tLSErrInfo);
                } else {
                    tLSPwdLoginListener.OnPwdLoginFail(tLSErrInfo);
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    public void clearUserInfo(String str) {
        QLog.i("user:" + str + " sdkAppid:" + this.mSdkAppid + " clearUserInfo");
        if (str != null && str.length() > 0) {
            if (str.equals(guest)) {
                guest = null;
            }
            long tinyId = this.mG.getTinyId(str);
            if (tinyId != 0) {
                this.mG.clear_sig(tinyId, this.mSdkAppid);
            }
            this.mG.remove_account(str);
        }
    }

    public byte[] getGUID() {
        if (req_global._IMEI == null || req_global._IMEI.length <= 0) {
            return null;
        }
        byte[] bArr = new byte[req_global._IMEI.length];
        System.arraycopy(req_global._IMEI, 0, bArr, 0, req_global._IMEI.length);
        return bArr;
    }

    public int TLSExchangeTicket(String str, String str2, TLSExchangeTicketListener tLSExchangeTicketListener) {
        return TLSExchangeTicket(this.mSdkAppid, str, str2, tLSExchangeTicketListener);
    }

    public int TLSExchangeTicket(long j, String str, String str2, TLSExchangeTicketListener tLSExchangeTicketListener) {
        if (util.checkInvalid(str) || util.checkInvalid(str2)) {
            return TLSErrInfo.INPUT_INVALID;
        }
        this.mSdkAppid = j;
        Oidb0xa0b_request oidb0xa0b_request = new Oidb0xa0b_request(2);
        TransReqContext transReqContext = new TransReqContext(tLSExchangeTicketListener);
        transReqContext.set_subcmd(oidb0xa0b_request.getCmd());
        String str3 = str;
        transReqContext._body = oidb0xa0b_request.get_request(this.mSdkAppid, 0, str3, (String) null, str2);
        return RequestTransport((String) null, 0, str3, str2, 6269, transReqContext);
    }

    public void setOpenAccountInfo(int i, String str, String str2, String str3) {
        this.openAccountInfo = new TLSOpenAccountInfo(i, str, str2, str3);
        TLSOpenAccountInfo tLSOpenAccountInfo = this.openAccountInfo;
        tLSOpenAccountInfo.sdkAppid = this.mSdkAppid;
        tLSOpenAccountInfo.userAccountType = this.mAccType;
    }

    public void setOpenAccountInfo(TLSOpenAccountInfo tLSOpenAccountInfo) {
        this.openAccountInfo = tLSOpenAccountInfo;
        TLSOpenAccountInfo tLSOpenAccountInfo2 = this.openAccountInfo;
        tLSOpenAccountInfo2.sdkAppid = this.mSdkAppid;
        tLSOpenAccountInfo2.userAccountType = this.mAccType;
    }

    public TLSOpenAccountInfo getOpenAccountInfo() {
        return this.openAccountInfo;
    }

    public int TLSOpenAccountQuery(TLSOpenAccountQueryListener tLSOpenAccountQueryListener) {
        int i = this.openAccountInfo.openAccountType;
        String str = this.openAccountInfo.openid;
        String str2 = this.openAccountInfo.access_token;
        String str3 = this.openAccountInfo.openappid;
        if (i <= 0 || util.checkInvalid(str) || util.checkInvalid(str2)) {
            return TLSErrInfo.INPUT_INVALID;
        }
        Oidb0x602_request oidb0x602_request = new Oidb0x602_request();
        TransReqContext transReqContext = new TransReqContext(tLSOpenAccountQueryListener);
        transReqContext.set_subcmd(oidb0x602_request.getCmd());
        int i2 = i;
        transReqContext._body = oidb0x602_request.get_request((int) this.mSdkAppid, i2, str3, str, str2);
        return RequestTransport(str3, i2, str, str2, 6161, transReqContext);
    }

    public int TLSOpenAccountBind(String str, String str2, TLSOpenAccountBindListener tLSOpenAccountBindListener) {
        int i = this.openAccountInfo.openAccountType;
        String str3 = this.openAccountInfo.openid;
        String str4 = this.openAccountInfo.access_token;
        String str5 = this.openAccountInfo.openappid;
        TLSOpenAccountInfo tLSOpenAccountInfo = this.openAccountInfo;
        tLSOpenAccountInfo.identifer = str;
        tLSOpenAccountInfo.usersig = str2;
        if (i <= 0 || util.checkInvalid(str) || util.checkInvalid(str2) || util.checkInvalid(str3) || util.checkInvalid(str4)) {
            return TLSErrInfo.INPUT_INVALID;
        }
        Oidb0x601_request oidb0x601_request = new Oidb0x601_request();
        TransReqContext transReqContext = new TransReqContext(tLSOpenAccountBindListener);
        transReqContext.set_subcmd(oidb0x601_request.getCmd());
        transReqContext._body = oidb0x601_request.get_request((int) this.openAccountInfo.sdkAppid, this.openAccountInfo.userAccountType, str, str2, i, this.openAccountInfo.openappid, str3, str4);
        return RequestTransport(str5, i, str3, str4, 6161, transReqContext);
    }

    public int TLSOpenAccessToken(int i, String str, TLSOpenAccessTokenListener tLSOpenAccessTokenListener) {
        if (i <= 0 || util.checkInvalid(str)) {
            return TLSErrInfo.INPUT_INVALID;
        }
        Oidb0x483_request oidb0x483_request = new Oidb0x483_request();
        TransReqContext transReqContext = new TransReqContext(tLSOpenAccessTokenListener);
        transReqContext.set_subcmd(oidb0x483_request.getCmd());
        transReqContext._body = oidb0x483_request.get_request(this.mSdkAppid, i, str);
        return RequestTransport((String) null, i, (String) null, (String) null, 5970, transReqContext);
    }

    public int TLSSmsRegAskCodeWithOA(String str, TLSSmsRegListener tLSSmsRegListener) {
        QLog.i("TLSSmsRegAskCodeWithOA ..." + str);
        return askCode(str, 33, true, tLSSmsRegListener);
    }

    public int TLSPwdRegAskCodeWithOA(String str, TLSPwdRegListener tLSPwdRegListener) {
        QLog.i("TLSPwdRegAskCodeWithOA ..." + str);
        return askCode(str, 49, true, tLSPwdRegListener);
    }

    public int TLSStrAccRegWithOA(String str, String str2, TLSStrAccRegListener tLSStrAccRegListener) {
        String str3 = str;
        if (str.length() == 0 || str.getBytes().length > 24 || str2.length() == 0 || str2.getBytes().length > 16 || str2.getBytes().length < 8 || this.openAccountInfo.checkInvalid()) {
            return TLSErrInfo.INPUT_INVALID;
        }
        boolean z = true;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str3.charAt(i);
            if (charAt != '.' && charAt != '_' && !Character.isLetterOrDigit(charAt)) {
                return TLSErrInfo.INPUT_INVALID;
            }
            if (!Character.isDigit(charAt)) {
                z = false;
            }
        }
        if (z) {
            return TLSErrInfo.INPUT_INVALID;
        }
        acc_ask_code acc_ask_code = new acc_ask_code(97);
        TransReqContext transReqContext = new TransReqContext(tLSStrAccRegListener);
        acc_status acc_status = this.mRegStatus;
        acc_status.userID = str3;
        acc_status.password = str2;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(acc_ask_code.get_cmd());
        String str4 = str;
        transReqContext._body = acc_ask_code.get_request(this.mAccType, str4, req_global._apk_id, this.mAppVer, this.mCountry, this.mSdkAppid, req_global._IMEI, this.openAccountInfo);
        return RequestTransport((String) null, 0, str, (String) null, (long) this.mRegStatus.role, transReqContext);
    }

    public int TLSOpenAccountLogin(TLSExchangeTicketListener tLSExchangeTicketListener) {
        if (this.openAccountInfo.checkInvalid()) {
            return TLSErrInfo.INPUT_INVALID;
        }
        int i = this.openAccountInfo.openAccountType;
        String str = this.openAccountInfo.openid;
        String str2 = this.openAccountInfo.openappid;
        String str3 = this.openAccountInfo.access_token;
        Oidb0xa0b_request oidb0xa0b_request = new Oidb0xa0b_request(1);
        TransReqContext transReqContext = new TransReqContext(tLSExchangeTicketListener);
        transReqContext.set_subcmd(oidb0xa0b_request.getCmd());
        transReqContext._body = oidb0xa0b_request.get_request(this.mSdkAppid, i, str, str2, str3);
        return RequestTransport(str2, i, str, str3, 6269, transReqContext);
    }

    private int RequestTransport(String str, int i, String str2, String str3, long j, TransReqContext transReqContext) {
        TLSUserInfo tLSUserInfo = new TLSUserInfo();
        final String str4 = str2;
        tLSUserInfo.identifier = str4;
        req_global clone = this.mG.getClone(0);
        Looper myLooper = Looper.myLooper();
        final long j2 = j;
        final req_global req_global = clone;
        final TransReqContext transReqContext2 = transReqContext;
        final TLSUserInfo tLSUserInfo2 = tLSUserInfo;
        AnonymousClass18 r0 = new WorkThread.Worker() {
            public int work() {
                QLog.i("user:" + str4 + " sdkAppid:" + TLSHelper.this.mSdkAppid + " role:" + j2 + " Seq:" + req_global._seq + " RequestTransport...");
                req_global req_global = req_global;
                req_global._userid = str4;
                int make_request = new req_transport(req_global).make_request(0, transReqContext2, (byte[]) null, (byte[]) null, TLSHelper.this.mSdkAppid, j2, tLSUserInfo2);
                req_global.close_transport_connect();
                QLog.i("user:" + str4 + " sdkAppid:" + TLSHelper.this.mSdkAppid + " role:" + j2 + " Seq:" + req_global._seq + " RequestTransport ret=" + make_request);
                return make_request;
            }
        };
        final TransReqContext transReqContext3 = transReqContext;
        final TLSUserInfo tLSUserInfo3 = tLSUserInfo;
        final req_global req_global2 = clone;
        final String str5 = str;
        final int i2 = i;
        final String str6 = str3;
        new WorkThread(myLooper, r0, new WorkThread.When() {
            public void done(int i) {
                int i2 = transReqContext3.get_subcmd();
                if (transReqContext3.is_register_req()) {
                    TLSHelper.this.OnTLSRequestRegister(transReqContext3, tLSUserInfo3, i);
                } else if (i2 == 1538) {
                    TLSHelper.this.OnTLSOpenAccountQuery(transReqContext3, i);
                } else if (i2 == 1537) {
                    TLSHelper.this.OnTLSOpenAccountBind(transReqContext3, i);
                } else if (i2 == 2571) {
                    TLSHelper.this.OnTLSExchangeTicket(transReqContext3, req_global2, str5, i2, str6, i);
                } else if (i2 == 1155) {
                    TLSHelper.this.OnTLSOpenAccessToken(transReqContext3, i);
                } else {
                    QLog.i("命令字不一致!");
                }
            }
        }).start();
        return TLSErrInfo.PENDING;
    }

    /* access modifiers changed from: private */
    public void OnTLSOpenAccessToken(TransReqContext transReqContext, int i) {
        TLSOpenAccessTokenListener tLSOpenAccessTokenListener = (TLSOpenAccessTokenListener) transReqContext.listener;
        TLSErrInfo tLSErrInfo = new TLSErrInfo(i, "", I18nMsg.getMsg(I18nMsg.MSG_TYPE.MSG_3));
        if (i != 0) {
            whenError(tLSErrInfo, tLSOpenAccessTokenListener);
            return;
        }
        Oidb0x483_response oidb0x483_response = new Oidb0x483_response(transReqContext.get_body());
        if (oidb0x483_response.getResult() != 0) {
            tLSErrInfo.ErrCode = oidb0x483_response.getResult();
            tLSErrInfo.Msg = "解析包出错";
            whenError(tLSErrInfo, tLSOpenAccessTokenListener);
        } else if (oidb0x483_response.getHeadResult() == 0) {
            TLSAccessTokenInfo tLSAccessTokenInfo = new TLSAccessTokenInfo();
            tLSAccessTokenInfo.access_token = oidb0x483_response.getAccessToken();
            tLSAccessTokenInfo.expireTime = oidb0x483_response.getExpireTime();
            tLSAccessTokenInfo.refresh_token = oidb0x483_response.getRefreshToken();
            tLSAccessTokenInfo.openid = oidb0x483_response.getOpenid();
            tLSAccessTokenInfo.scope = oidb0x483_response.getScope();
            tLSAccessTokenInfo.unionid = oidb0x483_response.getUnionid();
            tLSOpenAccessTokenListener.OnOpenAccessTokenSuccess(tLSAccessTokenInfo);
        } else {
            QLog.i("rsp.getHeadResult() = " + oidb0x483_response.getHeadResult());
            tLSErrInfo.ErrCode = oidb0x483_response.getHeadResult();
            tLSErrInfo.Msg = oidb0x483_response.getErrHint();
            tLSOpenAccessTokenListener.OnOpenAccessTokenFail(tLSErrInfo);
        }
    }

    /* access modifiers changed from: private */
    public void OnTLSRequestRegister(TransReqContext transReqContext, TLSUserInfo tLSUserInfo, int i) {
        int i2 = transReqContext.get_subcmd();
        Object obj = transReqContext.listener;
        TLSErrInfo tLSErrInfo = new TLSErrInfo(i, "", I18nMsg.getMsg(I18nMsg.MSG_TYPE.MSG_3));
        if (i != 0) {
            whenError(tLSErrInfo, obj);
            return;
        }
        int parse_checkvalid_rsp = acc_request.parse_checkvalid_rsp(i2, transReqContext.get_body(), this.mRegStatus);
        if (parse_checkvalid_rsp != 0) {
            tLSErrInfo.ErrCode = parse_checkvalid_rsp;
            whenError(tLSErrInfo, obj);
            return;
        }
        QLog.i("reg cmd:" + i2 + " ret:" + this.mRegStatus.sec_ctrl_code);
        tLSErrInfo.ErrCode = this.mRegStatus.sec_ctrl_code;
        tLSErrInfo.Msg = new String(this.mRegStatus.promptinfo);
        if (tLSErrInfo.ErrCode != 0) {
            whenError(tLSErrInfo, obj);
            return;
        }
        QLog.i("Reg Success " + tLSErrInfo.ErrCode + ", msg: " + tLSErrInfo.Msg);
        if (i2 == 33) {
            QLog.i("OnSmsRegAskCodeSuccess ");
            ((TLSSmsRegListener) obj).OnSmsRegAskCodeSuccess(this.mRegStatus.next_resend_time, this.mRegStatus.total_time_over);
        } else if (i2 == 49) {
            QLog.i("OnPwdRegAskCodeSuccess ");
            ((TLSPwdRegListener) obj).OnPwdRegAskCodeSuccess(this.mRegStatus.next_resend_time, this.mRegStatus.total_time_over);
        } else if (i2 == 97) {
            QLog.i("OnStrAccRegQuerySuccess ");
            TLSStrAccRegCommit((TLSStrAccRegListener) obj);
        } else if (i2 == 102) {
            QLog.i("OnStrAccRegCommitSuccess ");
            ((TLSStrAccRegListener) obj).OnStrAccRegSuccess(tLSUserInfo);
        } else if (i2 != 118) {
            switch (i2) {
                case 36:
                    QLog.i("OnSmsRegReaskCodeSuccess ");
                    ((TLSSmsRegListener) obj).OnSmsRegReaskCodeSuccess(this.mRegStatus.next_resend_time, this.mRegStatus.total_time_over);
                    return;
                case 37:
                    QLog.i("OnSmsRegVerifyCodeSuccess ");
                    ((TLSSmsRegListener) obj).OnSmsRegVerifyCodeSuccess();
                    return;
                case 38:
                    QLog.i("OnSmsRegCommitSuccess ");
                    ((TLSSmsRegListener) obj).OnSmsRegCommitSuccess(tLSUserInfo);
                    return;
                default:
                    switch (i2) {
                        case 52:
                            QLog.i("OnPwdRegReaskCodeSuccess ");
                            ((TLSPwdRegListener) obj).OnPwdRegReaskCodeSuccess(this.mRegStatus.next_resend_time, this.mRegStatus.total_time_over);
                            return;
                        case 53:
                            QLog.i("OnPwdRegVerifyCodeSuccess ");
                            ((TLSPwdRegListener) obj).OnPwdRegVerifyCodeSuccess();
                            return;
                        case 54:
                            QLog.i("OnPwdRegCommitSuccess ");
                            ((TLSPwdRegListener) obj).OnPwdRegCommitSuccess(tLSUserInfo);
                            return;
                        default:
                            switch (i2) {
                                case 64:
                                    QLog.i("OnPwdResetAskCodeSuccess ");
                                    ((TLSPwdResetListener) obj).OnPwdResetAskCodeSuccess(this.mRegStatus.next_resend_time, this.mRegStatus.total_time_over);
                                    return;
                                case 65:
                                    QLog.i("OnPwdResetReaskCodeSuccess ");
                                    ((TLSPwdResetListener) obj).OnPwdResetReaskCodeSuccess(this.mRegStatus.next_resend_time, this.mRegStatus.total_time_over);
                                    return;
                                case 66:
                                    QLog.i("OnPwdResetVerifyCodeSuccess ");
                                    ((TLSPwdResetListener) obj).OnPwdResetVerifyCodeSuccess();
                                    return;
                                case 67:
                                    QLog.i("OnPwdResetCommitSuccess ");
                                    ((TLSPwdResetListener) obj).OnPwdResetCommitSuccess(tLSUserInfo);
                                    return;
                                default:
                                    QLog.w("OnTLSRequestRegister unhandle cmd:" + i2);
                                    return;
                            }
                    }
            }
        } else {
            QLog.i("OnGuestRegSuccess ");
            tLSUserInfo.identifier = this.mRegStatus.userID;
            if (obj instanceof TLSGuestRegListener) {
                ((TLSGuestRegListener) obj).OnGuestRegSuccess(tLSUserInfo);
            } else if (obj instanceof TLSSSORegListener) {
                ((TLSSSORegListener) obj).OnGuestRegSuccess(tLSUserInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    public void OnTLSExchangeTicket(TransReqContext transReqContext, req_global req_global, String str, int i, String str2, int i2) {
        req_global req_global2 = req_global;
        int i3 = i2;
        TLSExchangeTicketListener tLSExchangeTicketListener = (TLSExchangeTicketListener) transReqContext.listener;
        TLSErrInfo tLSErrInfo = new TLSErrInfo(i3, "", I18nMsg.getMsg(I18nMsg.MSG_TYPE.MSG_3));
        if (i3 != 0) {
            whenError(tLSErrInfo, tLSExchangeTicketListener);
            return;
        }
        Oidb0xa0b_response oidb0xa0b_response = new Oidb0xa0b_response(transReqContext.get_body());
        if (oidb0xa0b_response.getResult() != 0) {
            tLSErrInfo.ErrCode = oidb0xa0b_response.getResult();
            tLSErrInfo.Msg = "解析包出错";
            whenError(tLSErrInfo, tLSExchangeTicketListener);
        } else if (oidb0xa0b_response.getHeadResult() == 0) {
            long tinyID = oidb0xa0b_response.getTinyID();
            byte[] a2 = oidb0xa0b_response.getA2();
            byte[] d2 = oidb0xa0b_response.getD2();
            byte[] d2Key = oidb0xa0b_response.getD2Key();
            int adminFlag = oidb0xa0b_response.getAdminFlag();
            String identifier = oidb0xa0b_response.getIdentifier();
            if (i <= 0) {
                identifier = req_global2._userid;
            }
            String userSig = oidb0xa0b_response.getUserSig();
            String str3 = req_global2._userid;
            if (util.checkInvalid(identifier)) {
                identifier = req_global2._userid;
            }
            req_global2._uin = tinyID;
            req_global2._admin = adminFlag;
            req_global2.put_open_account(req_global2._userid, identifier, req_global2._uin);
            req_global2._userid = identifier;
            long j = req_global.get_cur_time();
            ArrayList arrayList = new ArrayList();
            long j2 = j + 2160000;
            arrayList.add(new Ticket(64, a2, new tlv_t(269).get_data(), j, j2));
            arrayList.add(new Ticket(SigType.D2, d2, d2Key, j, j + 1728000));
            arrayList.add(new Ticket(SigType.TLS, userSig.getBytes(), (byte[]) null, j, j2));
            if (i > 0) {
                arrayList.add(new Ticket(SigType.ACCESS_TOKEN, i, str, str2.getBytes(), str3.getBytes(), j, 0));
            }
            long j3 = req_global2._uin;
            long j4 = this.mSdkAppid;
            req_global req_global3 = req_global2;
            req_global.put_siginfo(j3, j4, new byte[0], new byte[0], j4, 4294967295L, j, arrayList, 0);
            TLSExchangeTicketListener tLSExchangeTicketListener2 = tLSExchangeTicketListener;
            tLSExchangeTicketListener2.OnExchangeTicketSuccess(new TLSUserInfo(i, req_global3._userid, req_global3._uin, j, TinyInfo.UserType.USER_TYPE_NORMAL));
        } else {
            TLSExchangeTicketListener tLSExchangeTicketListener3 = tLSExchangeTicketListener;
            QLog.i("rsp.getHeadResult() = " + oidb0xa0b_response.getHeadResult());
            tLSErrInfo.ErrCode = oidb0xa0b_response.getHeadResult();
            tLSErrInfo.Msg = oidb0xa0b_response.getErrMsg();
            if (tLSErrInfo.Msg.length() == 0) {
                tLSErrInfo.Msg = "内部错误，请访问 http://bbs.qcloud.com/thread-8309-1-1.html 或者联系 QQ 3268519604";
            }
            whenError(tLSErrInfo, tLSExchangeTicketListener3);
        }
    }

    /* access modifiers changed from: private */
    public void OnTLSOpenAccountQuery(TransReqContext transReqContext, int i) {
        TLSOpenAccountQueryListener tLSOpenAccountQueryListener = (TLSOpenAccountQueryListener) transReqContext.listener;
        TLSErrInfo tLSErrInfo = new TLSErrInfo(i, "", I18nMsg.getMsg(I18nMsg.MSG_TYPE.MSG_3));
        if (i != 0) {
            whenError(tLSErrInfo, tLSOpenAccountQueryListener);
            return;
        }
        Oidb0x602_response oidb0x602_response = new Oidb0x602_response(transReqContext.get_body());
        if (oidb0x602_response.getResult() != 0) {
            tLSErrInfo.ErrCode = oidb0x602_response.getResult();
            tLSErrInfo.Msg = "解析包出错";
            whenError(tLSErrInfo, tLSOpenAccountQueryListener);
        } else if (oidb0x602_response.getHeadResult() == 0) {
            int i2 = AnonymousClass20.$SwitchMap$tencent$tls$account$TLSOpenAccountInfo$OpenAccountStatus[oidb0x602_response.getOpenAccountStatus().ordinal()];
            if (i2 == 1) {
                this.openAccountInfo.status = TLSOpenAccountInfo.OpenAccountStatus.UNUSED;
                tLSOpenAccountQueryListener.onUnlogined(this.openAccountInfo);
            } else if (i2 == 2) {
                this.openAccountInfo.status = TLSOpenAccountInfo.OpenAccountStatus.USED_UNBINDED;
                tLSOpenAccountQueryListener.onLoginedButUnbinded(this.openAccountInfo);
            } else if (i2 != 3) {
                QLog.i("后台返回异常");
            } else {
                this.openAccountInfo.status = TLSOpenAccountInfo.OpenAccountStatus.USED_BINDED;
                tLSOpenAccountQueryListener.onLoginedAndBinded(this.openAccountInfo);
            }
        } else {
            QLog.i("rsp.getHeadResult() = " + oidb0x602_response.getHeadResult());
            tLSErrInfo.ErrCode = oidb0x602_response.getHeadResult();
            tLSErrInfo.Msg = "出错啦";
            whenError(tLSErrInfo, tLSOpenAccountQueryListener);
        }
    }

    /* renamed from: tencent.tls.platform.TLSHelper$20  reason: invalid class name */
    static /* synthetic */ class AnonymousClass20 {
        static final /* synthetic */ int[] $SwitchMap$tencent$tls$account$TLSOpenAccountInfo$OpenAccountStatus = new int[TLSOpenAccountInfo.OpenAccountStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                tencent.tls.account.TLSOpenAccountInfo$OpenAccountStatus[] r0 = tencent.tls.account.TLSOpenAccountInfo.OpenAccountStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$tencent$tls$account$TLSOpenAccountInfo$OpenAccountStatus = r0
                int[] r0 = $SwitchMap$tencent$tls$account$TLSOpenAccountInfo$OpenAccountStatus     // Catch:{ NoSuchFieldError -> 0x0014 }
                tencent.tls.account.TLSOpenAccountInfo$OpenAccountStatus r1 = tencent.tls.account.TLSOpenAccountInfo.OpenAccountStatus.UNUSED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$tencent$tls$account$TLSOpenAccountInfo$OpenAccountStatus     // Catch:{ NoSuchFieldError -> 0x001f }
                tencent.tls.account.TLSOpenAccountInfo$OpenAccountStatus r1 = tencent.tls.account.TLSOpenAccountInfo.OpenAccountStatus.USED_UNBINDED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$tencent$tls$account$TLSOpenAccountInfo$OpenAccountStatus     // Catch:{ NoSuchFieldError -> 0x002a }
                tencent.tls.account.TLSOpenAccountInfo$OpenAccountStatus r1 = tencent.tls.account.TLSOpenAccountInfo.OpenAccountStatus.USED_BINDED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tencent.tls.platform.TLSHelper.AnonymousClass20.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void OnTLSOpenAccountBind(TransReqContext transReqContext, int i) {
        TLSOpenAccountBindListener tLSOpenAccountBindListener = (TLSOpenAccountBindListener) transReqContext.listener;
        TLSErrInfo tLSErrInfo = new TLSErrInfo(i, "", I18nMsg.getMsg(I18nMsg.MSG_TYPE.MSG_3));
        if (i != 0) {
            whenError(tLSErrInfo, tLSOpenAccountBindListener);
            return;
        }
        Oidb0x601_response oidb0x601_response = new Oidb0x601_response(transReqContext.get_body());
        if (oidb0x601_response.getResult() != 0) {
            tLSErrInfo.ErrCode = oidb0x601_response.getResult();
            tLSErrInfo.Msg = "解析包出错";
            whenError(tLSErrInfo, tLSOpenAccountBindListener);
        } else if (oidb0x601_response.getHeadResult() == 0) {
            tLSOpenAccountBindListener.onBindSuccess(this.openAccountInfo);
        } else {
            QLog.i("rsp.getHeadResult() = " + oidb0x601_response.getHeadResult());
            tLSOpenAccountBindListener.onBindFailure(this.openAccountInfo);
        }
    }

    private void whenError(TLSErrInfo tLSErrInfo, Object obj) {
        if (tLSErrInfo.ErrCode == -1000) {
            if (obj instanceof TLSPwdRegListener) {
                ((TLSPwdRegListener) obj).OnPwdRegTimeout(tLSErrInfo);
            } else if (obj instanceof TLSPwdResetListener) {
                ((TLSPwdResetListener) obj).OnPwdResetTimeout(tLSErrInfo);
            } else if (obj instanceof TLSSmsRegListener) {
                ((TLSSmsRegListener) obj).OnSmsRegTimeout(tLSErrInfo);
            } else if (obj instanceof TLSStrAccRegListener) {
                ((TLSStrAccRegListener) obj).OnStrAccRegTimeout(tLSErrInfo);
            } else if (obj instanceof TLSGuestRegListener) {
                ((TLSGuestRegListener) obj).OnGuestRegTimeout(tLSErrInfo);
            } else if (obj instanceof TLSOpenAccountQueryListener) {
                ((TLSOpenAccountQueryListener) obj).onTimeOut(tLSErrInfo);
            } else if (obj instanceof TLSOpenAccountBindListener) {
                ((TLSOpenAccountBindListener) obj).onTimeOut(tLSErrInfo);
            } else if (obj instanceof TLSExchangeTicketListener) {
                ((TLSExchangeTicketListener) obj).OnExchangeTicketTimeout(tLSErrInfo);
            } else if (obj instanceof TLSOpenAccessTokenListener) {
                ((TLSOpenAccessTokenListener) obj).OnOpenAccessTokenTimeout(tLSErrInfo);
            }
        } else if (obj instanceof TLSPwdRegListener) {
            ((TLSPwdRegListener) obj).OnPwdRegFail(tLSErrInfo);
        } else if (obj instanceof TLSPwdResetListener) {
            ((TLSPwdResetListener) obj).OnPwdResetFail(tLSErrInfo);
        } else if (obj instanceof TLSSmsRegListener) {
            ((TLSSmsRegListener) obj).OnSmsRegFail(tLSErrInfo);
        } else if (obj instanceof TLSStrAccRegListener) {
            ((TLSStrAccRegListener) obj).OnStrAccRegFail(tLSErrInfo);
        } else if (obj instanceof TLSGuestRegListener) {
            ((TLSGuestRegListener) obj).OnGuestRegFail(tLSErrInfo);
        } else if (obj instanceof TLSOpenAccountQueryListener) {
            ((TLSOpenAccountQueryListener) obj).onFailure(tLSErrInfo);
        } else if (obj instanceof TLSOpenAccountBindListener) {
            ((TLSOpenAccountBindListener) obj).onFailure(tLSErrInfo);
        } else if (obj instanceof TLSExchangeTicketListener) {
            ((TLSExchangeTicketListener) obj).OnExchangeTicketFail(tLSErrInfo);
        } else if (obj instanceof TLSOpenAccessTokenListener) {
            ((TLSOpenAccessTokenListener) obj).OnOpenAccessTokenFail(tLSErrInfo);
        }
        QLog.i("whenError " + tLSErrInfo.ErrCode + ", msg: " + tLSErrInfo.Msg);
    }

    private TLSOpenAccountInfo GetLocalOpenAccountInfo(String str, long j) {
        SigInfo sigInfo;
        long tinyId = this.mG.getTinyId(str);
        if (tinyId == 0) {
            sigInfo = null;
        } else {
            sigInfo = this.mG.get_siginfo(tinyId, j);
        }
        if (sigInfo == null || sigInfo._access_token == null || sigInfo._access_token.length <= 0) {
            QLog.i("userAccount:" + str + " dwAppid:" + j + " GetLocalOpenAccountInfo return: null");
            return null;
        }
        QLog.i("userAccount:" + str + " dwAppid:" + j + " GetLocalOpenAccountInfo return: not null");
        return new TLSOpenAccountInfo(sigInfo.accountType, new String(sigInfo.appidAt3rd), new String((byte[]) sigInfo.openid.clone()), new String((byte[]) sigInfo._access_token.clone()));
    }

    /* access modifiers changed from: private */
    public byte[] GetA1ByAccount(String str, long j) {
        SigInfo sigInfo;
        long tinyId = this.mG.getTinyId(str);
        if (tinyId == 0) {
            sigInfo = null;
        } else {
            sigInfo = this.mG.get_siginfo(tinyId, j);
        }
        if (sigInfo == null || sigInfo._en_A1 == null || sigInfo._en_A1.length <= 0) {
            QLog.i("userAccount:" + str + " dwAppid:" + j + " GetA1ByAccount return: null");
            return null;
        }
        QLog.i("userAccount:" + str + " dwAppid:" + j + " GetA1ByAccount return: not null");
        return (byte[]) sigInfo._en_A1.clone();
    }

    /* access modifiers changed from: private */
    public byte[] GetNoPicSigByAccount(String str, long j) {
        SigInfo sigInfo;
        long tinyId = this.mG.getTinyId(str);
        if (tinyId == 0) {
            sigInfo = null;
        } else {
            sigInfo = this.mG.get_siginfo(tinyId, j);
        }
        if (sigInfo == null || sigInfo._noPicSig == null || sigInfo._noPicSig.length <= 0) {
            QLog.i("userAccount:" + str + " dwAppid:" + j + " GetNoPicSigByAccount return: null");
            return null;
        }
        QLog.i("userAccount:" + str + " dwAppid:" + j + " GetNoPicSigByAccount return: not null");
        return (byte[]) sigInfo._noPicSig.clone();
    }

    private TLSUserInfo GetLocalSig(String str, long j) {
        QLog.i("GetLocalSig name:" + str);
        TinyInfo tinyInfo = this.mG.getTinyInfo(str);
        if (tinyInfo != null) {
            this.mG._uin = tinyInfo._tinyid;
            SigInfo sigInfo = this.mG.get_siginfo(tinyInfo._tinyid, j);
            if (sigInfo != null) {
                long j2 = sigInfo._A1_create_time;
                if (j2 <= 0) {
                    j2 = sigInfo._TLS_create_time;
                }
                TLSUserInfo tLSUserInfo = new TLSUserInfo(tinyInfo._acc_type, tinyInfo._userid, tinyInfo._tinyid, j2, tinyInfo.userType);
                tLSUserInfo.get_clone(sigInfo);
                return tLSUserInfo;
            }
        }
        return null;
    }

    private Ticket getLocalTicket(String str, int i) {
        return getUserTicket(GetLocalSig(str, this.mSdkAppid), i);
    }

    private static Ticket getUserTicket(TLSUserInfo tLSUserInfo, int i) {
        if (tLSUserInfo == null || tLSUserInfo._tickets == null) {
            return null;
        }
        for (int i2 = 0; i2 < tLSUserInfo._tickets.size(); i2++) {
            Ticket ticket = tLSUserInfo._tickets.get(i2);
            if (ticket.Type == i) {
                QLog.i(" type:" + Integer.toHexString(i) + " sig:" + util.buf_len(ticket.Sig) + " key:" + util.buf_len(ticket.SigKey) + " create time:" + ticket.CreateTime + " expire time:" + ticket.ExpireTime);
                return ticket;
            }
        }
        return null;
    }

    public long TLSGetLastRefreshTime(String str) {
        if (util.checkInvalid(str)) {
            return 0;
        }
        QLog.i("TLSGetLastRefreshTime identifier:" + str);
        TinyInfo tinyInfo = this.mG.getTinyInfo(str);
        if (tinyInfo != null) {
            SigInfo sigInfo = this.mG.get_siginfo(tinyInfo._tinyid, this.mSdkAppid);
            if (sigInfo != null) {
                return sigInfo._A2_create_time;
            }
        }
        return 0;
    }

    public static void setSoLoadPath(String str) {
        util.soLoadPath = str;
    }
}
