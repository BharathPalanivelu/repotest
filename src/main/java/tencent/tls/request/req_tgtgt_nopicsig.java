package tencent.tls.request;

import cn.tongdun.android.BuildConfig;
import java.util.List;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSUserInfo;
import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t1;
import tencent.tls.tlvs.tlv_t100;
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
import tencent.tls.tlvs.tlv_t502;
import tencent.tls.tlvs.tlv_t509;
import tencent.tls.tlvs.tlv_t8;
import tencent.tls.tools.util;

public class req_tgtgt_nopicsig extends oicq_request {
    public req_tgtgt_nopicsig(req_global req_global) {
        this._cmd = 2103;
        this._sub_cmd = 15;
        this._service_cmd = "wtlogin64.login";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public byte[] get_request_body(long j, int i, long j2, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i4, long[] jArr, int i5, long j3, int i6, int i7, int i8, int i9, int i10, long j4, byte[] bArr4, byte[] bArr5, List<String> list) {
        long j5 = j3;
        int[] iArr = new int[21];
        // fill-array-data instruction
        iArr[0] = 24;
        iArr[1] = 1;
        iArr[2] = 262;
        iArr[3] = 278;
        iArr[4] = 256;
        iArr[5] = 263;
        iArr[6] = 324;
        iArr[7] = 322;
        iArr[8] = 274;
        iArr[9] = 1282;
        iArr[10] = 325;
        iArr[11] = 358;
        iArr[12] = 362;
        iArr[13] = 363;
        iArr[14] = 340;
        iArr[15] = 321;
        iArr[16] = 8;
        iArr[17] = 327;
        iArr[18] = 370;
        iArr[19] = 375;
        iArr[20] = 1289;
        async_context async_context = req_global.get_async_data(this._g._seq);
        AnonymousClass1 r0 = new TLVPacker(this, iArr, j, i, j2, i2, bArr, bArr2, i3, i4, jArr, j5, i5, i7, i8, i9, i10, bArr4, async_context, bArr5, bArr3, list, j4) {
            final /* synthetic */ req_tgtgt_nopicsig this$0;
            final /* synthetic */ byte[] val$A1;
            final /* synthetic */ byte[] val$IMEI;
            final /* synthetic */ byte[] val$apk_id;
            final /* synthetic */ long val$appid;
            final /* synthetic */ long[] val$appid_array;
            final /* synthetic */ int val$bitmap;
            final /* synthetic */ int val$cap_type;
            final /* synthetic */ byte[] val$client_ip;
            final /* synthetic */ int val$client_version;
            final /* synthetic */ List val$domains;
            final /* synthetic */ int val$getsig;
            final /* synthetic */ int val$getsig1;
            final /* synthetic */ byte[] val$no_pic_sig;
            final /* synthetic */ int val$pic_size;
            final /* synthetic */ int val$pic_type;
            final /* synthetic */ int val$rc;
            final /* synthetic */ int val$ret_type;
            final /* synthetic */ long val$sappid;
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
                this.val$bitmap = r14;
                this.val$getsig = r15;
                this.val$appid_array = r16;
                this.val$wxappid = r17;
                this.val$getsig1 = r19;
                this.val$pic_type = r20;
                this.val$cap_type = r21;
                this.val$pic_size = r22;
                this.val$ret_type = r23;
                this.val$IMEI = r24;
                this.val$thisContext = r25;
                this.val$apk_id = r26;
                this.val$no_pic_sig = r27;
                this.val$domains = r28;
                this.val$sappid = r29;
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
                    case 262:
                        tlv_t106 tlv_t106 = new tlv_t106();
                        byte[] bArr2 = this.val$A1;
                        tlv_t106.set_data(bArr2, bArr2.length);
                        return tlv_t106.get_buf();
                    case 263:
                        return new tlv_t107().get_tlv_107(this.val$pic_type, this.val$cap_type, this.val$pic_size, this.val$ret_type);
                    case TiffUtil.TIFF_TAG_ORIENTATION:
                        return new tlv_t112().get_tlv_112(this.this$0._g._userid.getBytes());
                    case 278:
                        return new tlv_t116().get_tlv_116(this.val$bitmap, this.val$getsig, this.val$appid_array);
                    case 321:
                        return new tlv_t141().get_tlv_141(req_global._sim_operator_name, req_global._network_type, req_global._apn);
                    case BuildConfig.VERSION_CODE:
                        return new tlv_t142().get_tlv_142(this.val$apk_id);
                    case 324:
                        byte[] bArr3 = new byte[0];
                        byte[] bArr4 = this.val$IMEI;
                        if (bArr4 != null && bArr4.length > 0) {
                            bArr3 = new tlv_t109().get_tlv_109(this.val$IMEI);
                        }
                        return new tlv_t144().get_tlv_144(bArr3, new tlv_t124().get_tlv_124(util.get_os_type(), util.get_os_version(), req_global._network_type, req_global._sim_operator_name, new byte[0], req_global._apn), new tlv_t128().get_tlv_128(req_global._new_install, req_global._read_guid, req_global._guid_chg, req_global._dev_report, req_global._device, req_global._IMEI, (byte[]) null), new tlv_t16e().get_tlv_16e(req_global._device), this.val$thisContext._tgtgt_key);
                    case 325:
                        return new tlv_t145().get_tlv_145(req_global._IMEI);
                    case 327:
                        return new tlv_t147().get_tlv_147(this.val$sappid, req_global._apk_v, req_global._apk_sig);
                    case 340:
                        return new tlv_t154().get_tlv_154(this.this$0._g._sso_seq);
                    case 358:
                        if ((this.val$bitmap & 128) == 0) {
                            return bArr;
                        }
                        return new tlv_t166().get_tlv_166(req_global._img_type);
                    case 362:
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

    public int make_request(long j, int i, long j2, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i4, long[] jArr, int i5, long j3, int i6, int i7, int i8, int i9, int i10, long j4, TLSUserInfo tLSUserInfo) {
        int snd_rcv_req;
        req_tgtgt_nopicsig req_tgtgt_nopicsig = this;
        int i11 = req_global._app_client_version;
        byte[] decrypt_a1 = req_tgtgt_nopicsig.decrypt_a1(bArr2);
        if (decrypt_a1 == null) {
            return TLSErrInfo.LOGIN_KEY_INVALID;
        }
        int i12 = 0;
        while (true) {
            int i13 = req_tgtgt_nopicsig._default_client_version;
            int i14 = req_tgtgt_nopicsig._cmd;
            int i15 = req_tgtgt_nopicsig._default_client_seq;
            int i16 = req_tgtgt_nopicsig._default_ext_retry;
            int i17 = req_tgtgt_nopicsig._default_ext_type;
            long j5 = j2;
            int i18 = i17;
            int i19 = i16;
            int i20 = i15;
            int i21 = i14;
            int i22 = i13;
            int i23 = i12;
            get_request(i22, i21, i20, j5, i19, i18, i11, req_tgtgt_nopicsig._default_ext_instance, get_request_body(j, i11, j5, i2, bArr, decrypt_a1, bArr3, i3, i4, jArr, i5, j3, i11, i7, i8, i9, i10, j4, req_global._IMEI, req_global._apk_id, (List<String>) null));
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            StringBuilder sb = new StringBuilder();
            sb.append("retry num:");
            int i24 = i23;
            sb.append(i24);
            sb.append(" ret:");
            sb.append(snd_rcv_req);
            QLog.i(sb.toString(), j2);
            if (snd_rcv_req != 180) {
                break;
            }
            i12 = i24 + 1;
            if (i24 >= 1) {
                break;
            }
            req_tgtgt_nopicsig = this;
        }
        return snd_rcv_req;
    }
}
