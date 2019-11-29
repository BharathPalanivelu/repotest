package tencent.tls.request;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.math.BigInteger;
import java.net.Socket;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import tencent.tls.account.acc_status;
import tencent.tls.platform.TLSUserInfo;
import tencent.tls.report.QLog;
import tencent.tls.request.TinyInfo;
import tencent.tls.tlvs.tlv_t150;
import tencent.tls.tools.I18nMsg;
import tencent.tls.tools.MD5;
import tencent.tls.tools.util;

public class req_global {
    public static byte[] _IMEI = new byte[0];
    static byte[] _IMEI_KEY = new byte[0];
    public static SecureRandom _SR = new SecureRandom();
    public static int _acc_type = 0;
    public static account_sig_info_map _account_sig_info_map = null;
    public static int _android_sdk;
    public static byte[] _apk_id = new byte[0];
    static byte[] _apk_sig = new byte[0];
    static byte[] _apk_v = new byte[0];
    public static byte[] _apn = new byte[0];
    static int _app_client_version = 0;
    public static TreeMap<Long, async_context> _async_data = new TreeMap<>();
    static byte[] _brand = new byte[0];
    public static Context _context = null;
    public static long _cur_sequence = 0;
    static int _dev_chg = 0;
    static int _dev_report = 0;
    static byte[] _device = new byte[0];
    static int _guid_chg = 0;
    static int _guid_src = 0;
    static int _img_type = 1;
    public static byte[] _ip_addr = new byte[4];
    static int _isroot = 0;
    public static long _l_init_time = 0;
    public static String _last_date = "";
    public static int _local_id = I18nMsg.ZH_CN;
    static byte[] _mac = new byte[0];
    public static int _network_type = 0;
    static int _new_install = 0;
    public static int _pic_type = 0;
    static int _read_guid = 0;
    static byte[] _sim_operator_name = new byte[0];
    static long _time_difference = 0;
    private static final Object data_lock = new Object();
    public static long sdkappid;
    public int _admin = 0;
    public int _cancel = 0;
    public int _encrypt_type = 0;
    public byte[] _pub_key = new byte[16];
    public byte[] _rand_key = new byte[16];
    public long _seq = 0;
    public byte[] _share_key = new byte[16];
    Socket _sk = null;
    public int _sso_seq = 0;
    public tlv_t150 _t150 = null;
    public byte[] _t172_data = new byte[0];
    public byte[] _tgt_key = null;
    public int _time_out = 10000;
    Socket _transport_sk = null;
    public long _uin = 0;
    public boolean _use_sso_channel = true;
    public String _userid = "";

    public req_global(Context context) {
    }

    public req_global getClone(long j) {
        req_global req_global = new req_global((Context) null);
        req_global._use_sso_channel = this._use_sso_channel;
        req_global._time_out = this._time_out;
        byte[] bArr = this._rand_key;
        if (bArr != null) {
            req_global._rand_key = (byte[]) bArr.clone();
        }
        byte[] bArr2 = this._pub_key;
        if (!(bArr2 == null || this._share_key == null)) {
            req_global._pub_key = (byte[]) bArr2.clone();
            req_global._share_key = (byte[]) this._share_key.clone();
        }
        if (j <= 0) {
            req_global._seq = allocSequence();
        } else {
            req_global._seq = j;
        }
        return req_global;
    }

    public static synchronized long allocSequence() {
        long j;
        synchronized (req_global.class) {
            if (_cur_sequence > 200) {
                _cur_sequence = 0;
            }
            j = _cur_sequence + 1;
            _cur_sequence = j;
        }
        return j;
    }

    public static async_context get_async_data(long j) {
        async_context async_context;
        synchronized (data_lock) {
            async_context = _async_data.get(Long.valueOf(j));
            if (async_context == null) {
                async_context = new async_context();
                _async_data.put(Long.valueOf(j), async_context);
            }
        }
        return async_context;
    }

    public static void remove_async_data(long j) {
        synchronized (data_lock) {
            _async_data.remove(Long.valueOf(j));
        }
    }

    public static void clear_sdk_log() {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            if (format.compareTo(_last_date) != 0) {
                _last_date = format;
                new delete_expire_log(_context).start();
            }
        } catch (Exception unused) {
        }
    }

    public static void dev_compare() {
        byte[] bArr = util.get_mac_addr(_context);
        if (bArr != null && bArr.length > 0) {
            bArr = MD5.toMD5Byte(bArr);
        }
        byte[] bArr2 = util.get_imei_id(_context);
        if (bArr2 != null && bArr2.length > 0) {
            bArr2 = MD5.toMD5Byte(bArr2);
        }
        byte[] _imei = util.get_IMEI(_context);
        if (_imei != null && _imei.length > 0) {
            _imei = MD5.toMD5Byte(_imei);
        }
        if (util.get_last_flag(_context) != 0) {
            byte[] bArr3 = util.get_last_mac(_context);
            byte[] bArr4 = util.get_last_imei(_context);
            byte[] bArr5 = util.get_last_guid(_context);
            if (!Arrays.equals(bArr, bArr3)) {
                _dev_chg |= 1;
            }
            if (!Arrays.equals(bArr2, bArr4)) {
                _dev_chg |= 2;
            }
            if (!Arrays.equals(_imei, bArr5)) {
                _dev_chg |= 4;
            }
        }
        util.save_cur_flag(_context, 1);
        util.save_cur_mac(_context, bArr);
        util.save_cur_imei(_context, bArr2);
        util.save_cur_guid(_context, _imei);
    }

    @SuppressLint({"NewApi"})
    private static byte[] get_guid(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : null;
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            String str = "";
            String str2 = Build.MODEL;
            if (deviceId != null) {
                str = str + deviceId;
            }
            if (str2 != null) {
                str = str + str2;
            }
            if (string != null) {
                str = str + string;
            }
            if (str.length() == 0) {
                return new byte[0];
            }
            return MD5.toMD5Byte(str.getBytes());
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[SYNTHETIC, Splitter:B:27:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A[SYNTHETIC, Splitter:B:31:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] get_file_guid(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            byte[] r1 = new byte[r1]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0056 }
            r2.<init>()     // Catch:{ Exception -> 0x0056 }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ Exception -> 0x0056 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x0056 }
            r2.append(r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r5 = "/tls_device.dat"
            r2.append(r5)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0056 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0056 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0056 }
            boolean r5 = r2.exists()     // Catch:{ Exception -> 0x0056 }
            if (r5 == 0) goto L_0x0048
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0056 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0056 }
            int r0 = r5.available()     // Catch:{ Exception -> 0x0043, all -> 0x003e }
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 >= r2) goto L_0x0049
            byte[] r1 = new byte[r0]     // Catch:{ Exception -> 0x0043, all -> 0x003e }
            r5.read(r1)     // Catch:{ Exception -> 0x0043, all -> 0x003e }
            goto L_0x0049
        L_0x003e:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0067
        L_0x0043:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0057
        L_0x0048:
            r5 = r0
        L_0x0049:
            if (r5 == 0) goto L_0x0066
            r5.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0066
        L_0x004f:
            r5 = move-exception
            tencent.tls.report.QLog.e(r5)
            goto L_0x0066
        L_0x0054:
            r5 = move-exception
            goto L_0x0067
        L_0x0056:
            r5 = move-exception
        L_0x0057:
            int r2 = _dev_report     // Catch:{ all -> 0x0054 }
            r3 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 | r3
            _dev_report = r2     // Catch:{ all -> 0x0054 }
            tencent.tls.report.QLog.e(r5)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0066
            r0.close()     // Catch:{ IOException -> 0x004f }
        L_0x0066:
            return r1
        L_0x0067:
            if (r0 == 0) goto L_0x0071
            r0.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            tencent.tls.report.QLog.e(r0)
        L_0x0071:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.request.req_global.get_file_guid(android.content.Context):byte[]");
    }

    public static void init() {
        int i = util.get_saved_network_type(_context);
        int i2 = 0;
        _dev_report = 0;
        byte[] bArr = get_file_guid(_context);
        byte[] bArr2 = get_guid(_context);
        if (bArr == null || bArr.length <= 0) {
            if (bArr2 == null || bArr2.length <= 0) {
                bArr = "%4;7t>;28<fc.5*6".getBytes();
                _read_guid = 0;
                _guid_src = 20;
            } else {
                _read_guid = 1;
                _guid_src = 17;
                bArr = bArr2;
            }
            util.save_file_imei(_context, bArr);
            _guid_chg = 0;
            _new_install = 1;
        } else {
            if (bArr2 == null || bArr2.length <= 0) {
                bArr2 = "%4;7t>;28<fc.5*6".getBytes();
            }
            if (Arrays.equals(bArr2, bArr)) {
                _guid_chg = 0;
            } else {
                _guid_chg = 1;
            }
            _read_guid = 1;
            _new_install = 0;
            _guid_src = 1;
        }
        dev_compare();
        _dev_report |= (_guid_src << 24) & -16777216;
        _dev_report |= (_dev_chg << 8) & 65280;
        _IMEI = (byte[]) bArr.clone();
        _IMEI_KEY = (byte[]) bArr.clone();
        _android_sdk = Build.VERSION.SDK_INT;
        _sim_operator_name = util.get_sim_operator_name(_context);
        _network_type = util.get_network_type(_context);
        if (i != _network_type) {
            util.set_net_retry_type(_context, 0);
            util.save_network_type(_context, _network_type);
        }
        _apn = util.get_apn_string(_context).getBytes();
        byte[] bArr3 = util.get_apk_id(_context);
        _apk_id = bArr3;
        acc_status.apk_id = bArr3;
        _apk_v = util.get_apk_v(_context, new String(_apk_id));
        Context context = _context;
        _apk_sig = util.getPkgSigFromApkName(context, context.getPackageName());
        String str = Build.MODEL;
        if (str == null) {
            _device = new byte[0];
        } else {
            _device = str.getBytes();
        }
        if (util.isFileExist("/system/bin/su") || util.isFileExist("/system/xbin/su") || util.isFileExist("/sbin/su")) {
            i2 = 1;
        }
        _isroot = i2;
    }

    public static long get_cur_time() {
        return System.currentTimeMillis() / 1000;
    }

    public static long get_server_cur_time() {
        return (System.currentTimeMillis() / 1000) + _l_init_time;
    }

    public void set_time_ip(byte[] bArr, byte[] bArr2) {
        _time_difference = (((long) util.buf_to_int32(bArr, 0)) & 4294967295L) - (System.currentTimeMillis() / 1000);
        _l_init_time = _time_difference;
        _ip_addr = bArr2;
    }

    public void clear_time_ip() {
        _ip_addr = null;
        _time_difference = 0;
        _l_init_time = 0;
    }

    public void set_context(Context context) {
        _context = context;
        _account_sig_info_map = new account_sig_info_map(context);
        byte[] bArr = new byte[16];
        _SR.nextBytes(bArr);
        System.arraycopy(bArr, 0, this._rand_key, 0, bArr.length);
    }

    public void close_connect() {
        QLog.d("close_connect");
        if (this._sk != null) {
            try {
                QLog.d("close_connect" + this._sk.toString());
                this._sk.close();
            } catch (Exception e2) {
                QLog.e(e2);
            }
            this._sk = null;
        }
    }

    public void close_transport_connect() {
        QLog.d("close_transport_connect");
        if (this._transport_sk != null) {
            try {
                QLog.d("close_transport_connect" + this._transport_sk.toString());
                this._transport_sk.close();
            } catch (Exception e2) {
                QLog.e(e2);
            }
            this._transport_sk = null;
        }
    }

    public synchronized SigInfo get_siginfo(long j, long j2) {
        QLog.i("get_siginfo", j);
        SigInfo sigInfo = _account_sig_info_map.get_siginfo(j, j2);
        if (sigInfo != null) {
            return sigInfo;
        }
        return sigInfo;
    }

    public synchronized void remove_account(String str) {
        _account_sig_info_map.remove_account(str);
    }

    public synchronized long getTinyId(String str) {
        if (str == null) {
            return 0;
        }
        TinyInfo tinyInfo = _account_sig_info_map.getTinyInfo(str);
        if (tinyInfo == null) {
            return 0;
        }
        return tinyInfo._tinyid;
    }

    public synchronized TinyInfo getTinyInfo(String str) {
        if (str == null) {
            return null;
        }
        return _account_sig_info_map.getTinyInfo(str);
    }

    public synchronized List<TLSUserInfo> get_all_logined_account() {
        try {
        } catch (NullPointerException e2) {
            QLog.w("_account_sig_info_map null " + e2.getMessage());
            return null;
        }
        return _account_sig_info_map.get_all_logined_account();
    }

    public synchronized int put_siginfo(long j, long j2, byte[] bArr, byte[] bArr2, long j3, long j4, long j5, ArrayList<Ticket> arrayList, int i) {
        return _account_sig_info_map.put_siginfo(j, j2, bArr, bArr2, j3, j4, j5, arrayList, i);
    }

    public synchronized void clear_sig(long j, long j2) {
        _account_sig_info_map.clear_sig(j, j2);
    }

    public synchronized void put_account(String str, long j) {
        _account_sig_info_map.putTinyInfo(str, str, j, TinyInfo.UserType.USER_TYPE_NORMAL);
    }

    public synchronized void put_open_account(String str, String str2, long j) {
        _account_sig_info_map.putTinyInfo(str, str2, j, TinyInfo.UserType.USER_TYPE_NORMAL);
    }

    public void put_guest(String str, long j) {
        _account_sig_info_map.putTinyInfo(str, str, j, TinyInfo.UserType.USER_TYPE_GUEST);
    }

    public void put_sso_guest(String str, long j) {
        _account_sig_info_map.putTinyInfo(str, str, j, TinyInfo.UserType.USER_TYPE_SSO_GUEST);
    }

    public static String long2string(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(BigInteger.ONE.shiftLeft(64));
        }
        return valueOf.toString();
    }

    public String uin2string() {
        return long2string(this._uin);
    }
}
