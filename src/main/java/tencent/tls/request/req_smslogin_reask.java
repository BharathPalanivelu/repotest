package tencent.tls.request;

import tencent.tls.platform.TLSUserInfo;
import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t116;
import tencent.tls.tlvs.tlv_t8;

public class req_smslogin_reask extends oicq_request {
    public req_smslogin_reask(req_global req_global) {
        this._cmd = 2103;
        this._sub_cmd = 19;
        this._service_cmd = "wtlogin64.login";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public byte[] get_request_body(int i, int i2, long[] jArr) {
        final int i3 = i;
        final int i4 = i2;
        final long[] jArr2 = jArr;
        AnonymousClass1 r1 = new TLVPacker(new int[]{260, 8, 278}) {
            /* access modifiers changed from: protected */
            public byte[] loop(int i) {
                byte[] bArr = new byte[0];
                if (i == 8) {
                    return new tlv_t8().get_tlv_8(0, req_global._local_id, 0);
                }
                if (i == 260) {
                    return req_global.get_async_data(req_smslogin_reask.this._g._seq)._t104.get_buf();
                }
                if (i != 278) {
                    return bArr;
                }
                return new tlv_t116().get_tlv_116(i3, i4, jArr2);
            }
        };
        return encrypt_body(r1.doit(), this._sub_cmd, r1.getTlvCnt());
    }

    public int make_request(int i, int i2, long[] jArr, TLSUserInfo tLSUserInfo) {
        int snd_rcv_req;
        int i3 = req_global._app_client_version;
        int i4 = 0;
        while (true) {
            int i5 = i3;
            get_request(this._default_client_version, this._cmd, this._default_client_seq, this._g._uin, this._default_ext_retry, this._default_ext_type, i5, this._default_ext_instance, get_request_body(i, i2, jArr));
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            QLog.i("retry num:" + i4 + " ret:" + snd_rcv_req, this._g._uin);
            if (snd_rcv_req != 180) {
                break;
            }
            int i6 = i4 + 1;
            if (i4 >= 1) {
                break;
            }
            i4 = i6;
        }
        return snd_rcv_req;
    }
}
