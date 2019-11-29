package tencent.tls.request;

import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t2;
import tencent.tls.tlvs.tlv_t8;

public class req_imgcode_verify extends oicq_request {
    public req_imgcode_verify(req_global req_global) {
        this._cmd = 2103;
        this._sub_cmd = 2;
        this._service_cmd = "wtlogin64.login";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public byte[] get_request_body(final byte[] bArr) {
        final async_context async_context = req_global.get_async_data(this._g._seq);
        AnonymousClass1 r1 = new TLVPacker(new int[]{260, 8, 2}) {
            /* access modifiers changed from: protected */
            public byte[] loop(int i) {
                byte[] bArr = new byte[0];
                if (i == 2) {
                    return new tlv_t2().get_tlv_2(bArr, async_context._t105.get_sign());
                }
                if (i == 8) {
                    return new tlv_t8().get_tlv_8(0, req_global._local_id, 0);
                }
                if (i != 260) {
                    return bArr;
                }
                return async_context._t104.get_buf();
            }
        };
        return encrypt_body(r1.doit(), this._sub_cmd, r1.getTlvCnt());
    }

    public int make_request(String str) {
        int snd_rcv_req;
        if (str == null) {
            str = "";
        }
        int i = req_global._app_client_version;
        int i2 = 0;
        while (true) {
            int i3 = i;
            get_request(this._default_client_version, this._cmd, this._default_client_seq, this._g._uin, this._default_ext_retry, this._default_ext_type, i3, this._default_ext_instance, get_request_body(str.getBytes()));
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            QLog.i("retry num:" + i2 + " ret:" + snd_rcv_req, this._g._uin);
            if (snd_rcv_req != 180) {
                break;
            }
            int i4 = i2 + 1;
            if (i2 >= 1) {
                break;
            }
            i2 = i4;
        }
        return snd_rcv_req;
    }
}
