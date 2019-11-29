package tencent.tls.request;

import cn.tongdun.android.BuildConfig;
import tencent.tls.platform.TLSUserInfo;
import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t100;
import tencent.tls.tlvs.tlv_t109;
import tencent.tls.tlvs.tlv_t112;
import tencent.tls.tlvs.tlv_t116;
import tencent.tls.tlvs.tlv_t142;
import tencent.tls.tlvs.tlv_t145;
import tencent.tls.tlvs.tlv_t154;
import tencent.tls.tlvs.tlv_t502;
import tencent.tls.tlvs.tlv_t509;
import tencent.tls.tlvs.tlv_t8;

public class req_smslogin_ask extends oicq_request {
    public req_smslogin_ask(req_global req_global) {
        this._cmd = 2103;
        this._sub_cmd = 17;
        this._service_cmd = "wtlogin64.login";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public byte[] get_request_body(long j, long j2, int i, int i2, byte[] bArr, int i3, int i4, long[] jArr) {
        final long j3 = j;
        final long j4 = j2;
        final int i5 = i2;
        final int i6 = i;
        final byte[] bArr2 = bArr;
        final int i7 = i3;
        final int i8 = i4;
        final long[] jArr2 = jArr;
        AnonymousClass1 r0 = new TLVPacker(new int[]{256, 265, 8, BuildConfig.VERSION_CODE, 325, 340, TiffUtil.TIFF_TAG_ORIENTATION, 1282, 278, 1289}) {
            /* access modifiers changed from: protected */
            public byte[] loop(int i) {
                byte[] bArr = new byte[0];
                if (i == 8) {
                    return new tlv_t8().get_tlv_8(0, req_global._local_id, 0);
                }
                if (i == 256) {
                    return new tlv_t100().get_tlv_100(j3, j4, i5, i6);
                }
                if (i != 265) {
                    if (i == 274) {
                        return new tlv_t112().get_tlv_112(bArr2);
                    }
                    if (i == 278) {
                        return new tlv_t116().get_tlv_116(i7, i8, jArr2);
                    }
                    if (i == 322) {
                        return new tlv_t142().get_tlv_142(req_global._apk_id);
                    }
                    if (i == 325) {
                        return new tlv_t145().get_tlv_145(req_global._IMEI);
                    }
                    if (i == 340) {
                        return new tlv_t154().get_tlv_154(req_smslogin_ask.this._g._sso_seq);
                    }
                    if (i == 1282) {
                        return new tlv_t502().get_tlv_502(req_global._acc_type);
                    }
                    if (i != 1289) {
                        return bArr;
                    }
                    return new tlv_t509().get_tlv_509(req_global._apk_sig, req_global._apk_id);
                } else if (req_global._IMEI == null || req_global._IMEI.length <= 0) {
                    return bArr;
                } else {
                    return new tlv_t109().get_tlv_109(req_global._IMEI);
                }
            }
        };
        return encrypt_body(r0.doit(), this._sub_cmd, r0.getTlvCnt());
    }

    public int make_request(long j, long j2, int i, String str, int i2, int i3, TLSUserInfo tLSUserInfo) {
        int snd_rcv_req;
        int i4 = req_global._app_client_version;
        int i5 = 0;
        while (true) {
            byte[] bArr = get_request_body(j, j2, i, i4, str.getBytes(), i2, i3, (long[]) null);
            get_request(this._default_client_version, this._cmd, this._default_client_seq, this._g._uin, this._default_ext_retry, this._default_ext_type, i4, this._default_ext_instance, bArr);
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            QLog.i("retry num:" + i5 + " ret:" + snd_rcv_req, this._g._uin);
            if (snd_rcv_req != 180) {
                break;
            }
            int i6 = i5 + 1;
            if (i5 >= 1) {
                break;
            }
            i5 = i6;
        }
        return snd_rcv_req;
    }
}
