package tencent.tls.request;

import cn.tongdun.android.BuildConfig;
import java.util.List;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSUserInfo;
import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t1;
import tencent.tls.tlvs.tlv_t100;
import tencent.tls.tlvs.tlv_t104;
import tencent.tls.tlvs.tlv_t106;
import tencent.tls.tlvs.tlv_t107;
import tencent.tls.tlvs.tlv_t109;
import tencent.tls.tlvs.tlv_t112;
import tencent.tls.tlvs.tlv_t116;
import tencent.tls.tlvs.tlv_t124;
import tencent.tls.tlvs.tlv_t128;
import tencent.tls.tlvs.tlv_t141;
import tencent.tls.tlvs.tlv_t142;
import tencent.tls.tlvs.tlv_t144;
import tencent.tls.tlvs.tlv_t145;
import tencent.tls.tlvs.tlv_t147;
import tencent.tls.tlvs.tlv_t154;
import tencent.tls.tlvs.tlv_t166;
import tencent.tls.tlvs.tlv_t16a;
import tencent.tls.tlvs.tlv_t16b;
import tencent.tls.tlvs.tlv_t16e;
import tencent.tls.tlvs.tlv_t172;
import tencent.tls.tlvs.tlv_t177;
import tencent.tls.tlvs.tlv_t18;
import tencent.tls.tlvs.tlv_t185;
import tencent.tls.tlvs.tlv_t502;
import tencent.tls.tlvs.tlv_t509;
import tencent.tls.tlvs.tlv_t8;
import tencent.tls.tools.util;

public class req_TGTGT extends oicq_request {
    public static final int SIGSRC_NORMAL = 3;

    public req_TGTGT(req_global req_global) {
        this._cmd = 2103;
        this._sub_cmd = 9;
        this._service_cmd = "wtlogin64.login";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public byte[] get_request_body(long j, long j2, int i, long j3, int i2, byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4, boolean z, byte[] bArr5, byte[] bArr6, int i4, int i5, long[] jArr, int i6, long j4, int i7, int i8, int i9, int i10, int i11, byte[] bArr7, byte[] bArr8, byte[] bArr9, List<String> list) {
        int i12 = i6;
        long j5 = j4;
        int i13 = i8;
        int i14 = i9;
        int i15 = i10;
        int i16 = i11;
        byte[] bArr10 = bArr9;
        int[] iArr = new int[23];
        int[] iArr2 = iArr;
        // fill-array-data instruction
        iArr[0] = 24;
        iArr[1] = 1;
        iArr[2] = 262;
        iArr[3] = 278;
        iArr[4] = 256;
        iArr[5] = 263;
        iArr[6] = 260;
        iArr[7] = 322;
        iArr[8] = 274;
        iArr[9] = 1282;
        iArr[10] = 324;
        iArr[11] = 325;
        iArr[12] = 327;
        iArr[13] = 358;
        iArr[14] = 340;
        iArr[15] = 321;
        iArr[16] = 8;
        iArr[17] = 363;
        iArr[18] = 370;
        iArr[19] = 375;
        iArr[20] = 362;
        iArr[21] = 389;
        iArr[22] = 1289;
        async_context async_context = req_global.get_async_data(this._g._seq);
        async_context async_context2 = async_context;
        long j6 = async_context._msalt;
        AnonymousClass1 r0 = new TLVPacker(this, iArr2, j, i, j3, i2, bArr, bArr5, j2, bArr2, bArr3, j6, bArr4, bArr6, j5, i12, i13, i14, i15, i16, i4, i5, jArr, bArr7, async_context2, bArr10, bArr8, list, z) {
            final /* synthetic */ req_TGTGT this$0;
            final /* synthetic */ byte[] val$A1;
            final /* synthetic */ byte[] val$IMEI;
            final /* synthetic */ byte[] val$TGTGT_key;
            final /* synthetic */ byte[] val$apk_id;
            final /* synthetic */ long val$appid;
            final /* synthetic */ int val$bitmap;
            final /* synthetic */ int val$cap_type;
            final /* synthetic */ byte[] val$client_ip;
            final /* synthetic */ int val$client_version;
            final /* synthetic */ List val$domains;
            final /* synthetic */ int val$getsig;
            final /* synthetic */ int val$getsig1;
            final /* synthetic */ byte[] val$init_time;
            final /* synthetic */ long val$msalt;
            final /* synthetic */ byte[] val$no_pic_sig;
            final /* synthetic */ int val$pic_size;
            final /* synthetic */ int val$pic_type;
            final /* synthetic */ byte[] val$pwd_md5;
            final /* synthetic */ int val$rc;
            final /* synthetic */ int val$ret_type;
            final /* synthetic */ byte[] val$sigsession;
            final /* synthetic */ boolean val$smslogin;
            final /* synthetic */ long val$subappid;
            final /* synthetic */ long[] val$subappid_list;
            final /* synthetic */ async_context val$thisContext;
            final /* synthetic */ long val$uin;
            final /* synthetic */ long val$wxappid;

            {
                this.this$0 = r4;
                this.val$appid = r6;
                this.val$client_version = r8;
                this.val$uin = r9;
                this.val$rc = r11;
                this.val$client_ip = r12;
                this.val$A1 = r13;
                this.val$subappid = r14;
                this.val$init_time = r16;
                this.val$pwd_md5 = r17;
                this.val$msalt = r18;
                this.val$TGTGT_key = r20;
                this.val$no_pic_sig = r21;
                this.val$wxappid = r22;
                this.val$getsig1 = r24;
                this.val$pic_type = r25;
                this.val$cap_type = r26;
                this.val$pic_size = r27;
                this.val$ret_type = r28;
                this.val$bitmap = r29;
                this.val$getsig = r30;
                this.val$subappid_list = r31;
                this.val$IMEI = r32;
                this.val$thisContext = r33;
                this.val$apk_id = r34;
                this.val$sigsession = r35;
                this.val$domains = r36;
                this.val$smslogin = r37;
                int[] iArr = r5;
            }

            /* access modifiers changed from: protected */
            public byte[] loop(int i) {
                byte[] bArr = new byte[0];
                switch (i) {
                    case 1:
                        return new tlv_t1().get_tlv_1(this.val$uin, this.val$client_ip);
                    case 8:
                        return new tlv_t8().get_tlv_8(0, req_global._local_id, 0);
                    case 24:
                        return new tlv_t18().get_tlv_18(this.val$appid, this.val$client_version, this.val$uin, this.val$rc);
                    case 256:
                        return new tlv_t100().get_tlv_100(this.val$appid, this.val$wxappid, this.val$client_version, this.val$getsig1);
                    case 260:
                        byte[] bArr2 = this.val$sigsession;
                        if (bArr2 == null || bArr2.length <= 0) {
                            return bArr;
                        }
                        return new tlv_t104().get_tlv_104(this.val$sigsession);
                    case 262:
                        byte[] bArr3 = this.val$A1;
                        if (bArr3 == null || bArr3.length == 0) {
                            tlv_t106 tlv_t106 = r1;
                            tlv_t106 tlv_t1062 = new tlv_t106();
                            return tlv_t106.get_tlv_106(this.val$appid, this.val$subappid, this.val$client_version, this.val$init_time, this.val$client_ip, 1, this.val$pwd_md5, this.val$msalt, this.val$TGTGT_key, req_global._read_guid, req_global._IMEI, 3, this.this$0._g._userid.getBytes(), req_global._acc_type);
                        }
                        tlv_t106 tlv_t1063 = new tlv_t106();
                        byte[] bArr4 = this.val$A1;
                        tlv_t1063.set_data(bArr4, bArr4.length);
                        return tlv_t1063.get_buf();
                    case 263:
                        return new tlv_t107().get_tlv_107(this.val$pic_type, this.val$cap_type, this.val$pic_size, this.val$ret_type);
                    case TiffUtil.TIFF_TAG_ORIENTATION:
                        if (this.this$0._g._userid != null) {
                            return new tlv_t112().get_tlv_112(this.this$0._g._userid.getBytes());
                        }
                        return bArr;
                    case 278:
                        return new tlv_t116().get_tlv_116(this.val$bitmap, this.val$getsig, this.val$subappid_list);
                    case 321:
                        return new tlv_t141().get_tlv_141(req_global._sim_operator_name, req_global._network_type, req_global._apn);
                    case BuildConfig.VERSION_CODE:
                        return new tlv_t142().get_tlv_142(this.val$apk_id);
                    case 324:
                        byte[] bArr5 = new byte[0];
                        byte[] bArr6 = this.val$IMEI;
                        if (bArr6 != null && bArr6.length > 0) {
                            bArr5 = new tlv_t109().get_tlv_109(this.val$IMEI);
                        }
                        return new tlv_t144().get_tlv_144(bArr5, new tlv_t124().get_tlv_124(util.get_os_type(), util.get_os_version(), req_global._network_type, req_global._sim_operator_name, new byte[0], req_global._apn), new tlv_t128().get_tlv_128(req_global._new_install, req_global._read_guid, req_global._guid_chg, req_global._dev_report, req_global._device, req_global._IMEI, (byte[]) null), new tlv_t16e().get_tlv_16e(req_global._device), this.val$thisContext._tgtgt_key);
                    case 325:
                        return new tlv_t145().get_tlv_145(req_global._IMEI);
                    case 327:
                        return new tlv_t147().get_tlv_147(this.val$appid, req_global._apk_v, req_global._apk_sig);
                    case 340:
                        return new tlv_t154().get_tlv_154(this.this$0._g._sso_seq);
                    case 358:
                        if ((this.val$bitmap & 128) == 0) {
                            return bArr;
                        }
                        return new tlv_t166().get_tlv_166(req_global._img_type);
                    case 362:
                        byte[] bArr7 = this.val$no_pic_sig;
                        if (bArr7 == null || bArr7.length <= 0) {
                            return bArr;
                        }
                        return new tlv_t16a().get_tlv_16a(this.val$no_pic_sig);
                    case 363:
                        List list = this.val$domains;
                        if (list == null || list.size() <= 0) {
                            return bArr;
                        }
                        return new tlv_t16b().get_tlv_16b(this.val$domains);
                    case 370:
                        if (this.this$0._g._t172_data == null || this.this$0._g._t172_data.length <= 0) {
                            return bArr;
                        }
                        return new tlv_t172().get_tlv_172(this.this$0._g._t172_data);
                    case 375:
                        return new tlv_t177().get_tlv_177(util.BUILD_TIME, util.SDK_VERSION);
                    case 389:
                        if (!this.val$smslogin) {
                            return bArr;
                        }
                        return new tlv_t185().get_tlv_185(1);
                    case 1282:
                        return new tlv_t502().get_tlv_502(req_global._acc_type);
                    case 1289:
                        return new tlv_t509().get_tlv_509(req_global._apk_sig, req_global._apk_id);
                    default:
                        return bArr;
                }
            }
        };
        return encrypt_body(r0.doit(), this._sub_cmd, r0.getTlvCnt());
    }

    public int make_request(long j, long j2, int i, long j3, int i2, byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, boolean z, int i4, int i5, long[] jArr, int i6, long j4, int i7, int i8, int i9, int i10, int i11, TLSUserInfo tLSUserInfo) {
        int snd_rcv_req;
        int i12 = req_global._app_client_version;
        async_context async_context = req_global.get_async_data(this._g._seq);
        async_context._tgtgt_key = util.get_rand_16byte(req_global._IMEI_KEY);
        byte[] bArr4 = async_context._tgtgt_key;
        tlv_t104 tlv_t104 = async_context._t104;
        if (tlv_t104 == null) {
            tlv_t104 = new tlv_t104();
        }
        tlv_t104 tlv_t1042 = tlv_t104;
        int i13 = 0;
        while (true) {
            int i14 = i13;
            byte[] bArr5 = bArr4;
            byte[] bArr6 = get_request_body(j, j2, i12, j3, i2, bArr, bArr2, i3, bArr3, bArr4, z, (byte[]) null, (byte[]) null, i4, i5, jArr, i6, j4, i12, i8, i9, i10, i11, req_global._IMEI, tlv_t1042.get_data(), req_global._apk_id, (List<String>) null);
            get_request(this._default_client_version, this._cmd, this._default_client_seq, j3, this._default_ext_retry, this._default_ext_type, i12, this._default_ext_instance, bArr6);
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            StringBuilder sb = new StringBuilder();
            sb.append("retry num:");
            int i15 = i14;
            sb.append(i15);
            sb.append(" ret:");
            sb.append(snd_rcv_req);
            QLog.i(sb.toString(), j3);
            if (snd_rcv_req != 180) {
                break;
            }
            i13 = i15 + 1;
            if (i15 >= 1) {
                break;
            }
            bArr4 = bArr5;
        }
        return snd_rcv_req;
    }

    public int make_request(long j, long j2, int i, long j3, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i4, long[] jArr, int i5, long j4, int i6, int i7, int i8, int i9, int i10, TLSUserInfo tLSUserInfo) {
        int snd_rcv_req;
        int i11 = req_global._app_client_version;
        tlv_t104 tlv_t104 = req_global.get_async_data(this._g._seq)._t104;
        if (tlv_t104 == null) {
            tlv_t104 = new tlv_t104();
        }
        tlv_t104 tlv_t1042 = tlv_t104;
        byte[] decrypt_a1 = decrypt_a1(bArr2);
        if (decrypt_a1 == null) {
            return TLSErrInfo.LOGIN_KEY_INVALID;
        }
        int i12 = 0;
        while (true) {
            int i13 = i12;
            byte[] bArr4 = get_request_body(j, j2, i11, j3, i2, bArr, (byte[]) null, 0, (byte[]) null, (byte[]) null, false, decrypt_a1, bArr3, i3, i4, jArr, i5, j4, i11, i7, i8, i9, i10, req_global._IMEI, tlv_t1042.get_data(), req_global._apk_id, (List<String>) null);
            get_request(this._default_client_version, this._cmd, this._default_client_seq, j3, this._default_ext_retry, this._default_ext_type, i11, this._default_ext_instance, bArr4);
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            StringBuilder sb = new StringBuilder();
            sb.append("retry num:");
            int i14 = i13;
            sb.append(i14);
            sb.append(" ret:");
            sb.append(snd_rcv_req);
            QLog.i(sb.toString(), j3);
            if (snd_rcv_req != 180) {
                break;
            }
            i12 = i14 + 1;
            if (i14 >= 1) {
                break;
            }
        }
        return snd_rcv_req;
    }
}
