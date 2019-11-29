package tencent.tls.request;

import tencent.tls.platform.TLSUserInfo;
import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t;
import tencent.tls.tlvs.tlv_t100;
import tencent.tls.tlvs.tlv_t107;
import tencent.tls.tlvs.tlv_t112;
import tencent.tls.tlvs.tlv_t154;
import tencent.tls.tlvs.tlv_t502;
import tencent.tls.tlvs.tlv_t509;
import tencent.tls.tlvs.tlv_t8;

public class req_getsalt extends oicq_request {
    public req_getsalt(req_global req_global) {
        this._cmd = 2103;
        this._sub_cmd = 25;
        this._service_cmd = "wtlogin64.login";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public byte[] get_request_body(long j, long j2, int i, int i2, String str, int i3, int i4, int i5, int i6) {
        final String str2 = str;
        final long j3 = j;
        final long j4 = j2;
        final int i7 = i;
        final int i8 = i2;
        final int i9 = i3;
        final int i10 = i4;
        final int i11 = i5;
        final int i12 = i6;
        AnonymousClass1 r0 = new TLVPacker(new int[]{256, TiffUtil.TIFF_TAG_ORIENTATION, 263, 265, 340, 8, 1282, 1289}) {
            /* access modifiers changed from: protected */
            public byte[] loop(int i) {
                byte[] bArr = new byte[0];
                String str = str2;
                if (str != null) {
                    bArr = str.getBytes();
                }
                byte[] bArr2 = new byte[0];
                if (i == 8) {
                    return new tlv_t8().get_tlv_8(0, req_global._local_id, 0);
                }
                if (i == 256) {
                    return new tlv_t100().get_tlv_100(j3, j4, i7, i8);
                }
                if (i == 263) {
                    return new tlv_t107().get_tlv_107(i9, i10, i11, i12);
                }
                if (i == 265) {
                    tlv_t tlv_t = new tlv_t(265);
                    tlv_t.set_data(req_global._IMEI, req_global._IMEI.length);
                    return tlv_t.get_buf();
                } else if (i == 274) {
                    return new tlv_t112().get_tlv_112(bArr);
                } else {
                    if (i == 340) {
                        return new tlv_t154().get_tlv_154(req_getsalt.this._g._sso_seq);
                    }
                    if (i == 1282) {
                        return new tlv_t502().get_tlv_502(req_global._acc_type);
                    }
                    if (i != 1289) {
                        return bArr2;
                    }
                    return new tlv_t509().get_tlv_509(req_global._apk_sig, req_global._apk_id);
                }
            }
        };
        return encrypt_body(r0.doit(), this._sub_cmd, r0.getTlvCnt());
    }

    public int make_request(long j, long j2, int i, String str, int i2, int i3, int i4, int i5, TLSUserInfo tLSUserInfo) {
        int snd_rcv_req;
        int i6 = req_global._app_client_version;
        this._g._userid = str;
        int i7 = 0;
        while (true) {
            int i8 = i6;
            get_request(this._default_client_version, this._cmd, this._default_client_seq, 0, this._default_ext_retry, this._default_ext_type, i8, this._default_ext_instance, get_request_body(j, j2, i6, i, str, i2, i3, i4, i5));
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            QLog.i("retry num:" + i7 + " ret:" + snd_rcv_req + " uin: " + this._g._uin);
            if (snd_rcv_req != 180) {
                break;
            }
            int i9 = i7 + 1;
            if (i7 >= 1) {
                break;
            }
            i7 = i9;
        }
        return snd_rcv_req;
    }
}
