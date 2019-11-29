package tencent.tls.request;

import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t;
import tencent.tls.tlvs.tlv_t100;
import tencent.tls.tlvs.tlv_t112;
import tencent.tls.tlvs.tlv_t502;
import tencent.tls.tlvs.tlv_t8;

public class req_exchange extends oicq_request {
    public req_exchange(req_global req_global) {
        this._cmd = 2103;
        this._sub_cmd = 26;
        this._service_cmd = "wtlogin64.login";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public byte[] get_request_body(long j, int i, String str, String str2, String str3) {
        final long j2 = j;
        final String str4 = str;
        final int i2 = i;
        final String str5 = str2;
        final String str6 = str3;
        AnonymousClass1 r0 = new TLVPacker(new int[]{256, TiffUtil.TIFF_TAG_ORIENTATION, 1282, 1283, 1287, 8}) {
            /* access modifiers changed from: protected */
            public byte[] loop(int i) {
                byte[] bArr = new byte[0];
                if (i == 8) {
                    return new tlv_t8().get_tlv_8(0, req_global._local_id, 0);
                }
                if (i == 256) {
                    return new tlv_t100().get_tlv_100(j2, 0, 0, 0);
                }
                if (i != 274) {
                    byte[] bArr2 = null;
                    if (i == 1287) {
                        tlv_t tlv_t = new tlv_t(1287);
                        String str = str6;
                        if (str != null) {
                            bArr2 = str.getBytes();
                        }
                        return tlv_t.build_tlv(bArr2);
                    } else if (i == 1282) {
                        return new tlv_t502().get_tlv_502(i2);
                    } else {
                        if (i != 1283) {
                            return bArr;
                        }
                        tlv_t tlv_t2 = new tlv_t(1283);
                        String str2 = str5;
                        if (str2 != null) {
                            bArr2 = str2.getBytes();
                        }
                        return tlv_t2.build_tlv(bArr2);
                    }
                } else {
                    tlv_t112 tlv_t112 = new tlv_t112();
                    String str3 = str4;
                    return tlv_t112.get_tlv_112(str3 == null ? new byte[0] : str3.getBytes());
                }
            }
        };
        return encrypt_body(r0.doit(), this._sub_cmd, r0.getTlvCnt());
    }

    public int make_request(long j, int i, String str, String str2, String str3) {
        int snd_rcv_req;
        int i2 = req_global._app_client_version;
        this._g._userid = str;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            get_request(this._default_client_version, this._cmd, this._default_client_seq, 0, this._default_ext_retry, this._default_ext_type, i4, this._default_ext_instance, get_request_body(j, i, str, str2, str3));
            snd_rcv_req = snd_rcv_req();
            if (snd_rcv_req != 0) {
                break;
            }
            snd_rcv_req = get_response();
            QLog.i("retry num:" + i3 + " ret:" + snd_rcv_req + " uin: " + this._g._uin);
            if (snd_rcv_req != 180) {
                break;
            }
            int i5 = i3 + 1;
            if (i3 >= 1) {
                break;
            }
            i3 = i5;
        }
        return snd_rcv_req;
    }
}
