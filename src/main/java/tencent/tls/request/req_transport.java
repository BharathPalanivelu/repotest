package tencent.tls.request;

import com.tencent.rtmp.TXLiveConstants;
import java.net.Socket;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.platform.TLSUserInfo;
import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t172;
import tencent.tls.tools.cryptor;
import tencent.tls.tools.util;

public class req_transport extends oicq_request {
    public int _req_transport_eext_head_len = 0;
    public int _rsp_transport_eext_head_len = 5;

    public int get_port(boolean z) {
        if (z) {
        }
        return 8080;
    }

    public req_transport(req_global req_global) {
        this._cmd = TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG;
        this._sub_cmd = 1;
        this._service_cmd = "wtlogin64.trans_emp";
        this._g = req_global;
        this._g._encrypt_type = 0;
    }

    public Socket get_sk() {
        if (this._g._transport_sk != null) {
            QLog.d("_transport_sk" + this._g._transport_sk.toString());
        } else {
            QLog.d("_transport_sk null");
        }
        return this._g._transport_sk;
    }

    public void set_sk(Socket socket) {
        this._g._transport_sk = socket;
    }

    public byte[] get_request_body(byte[] bArr, byte[] bArr2, long j, long j2, int i) {
        int i2;
        if (bArr2 == null) {
            bArr2 = new byte[0];
            i2 = i == 0 ? 0 : 3;
        } else {
            i2 = i == 0 ? 1 : 2;
        }
        byte[] bArr3 = new byte[0];
        if (this._g._t172_data != null && this._g._t172_data.length > 0) {
            byte[] bArr4 = new tlv_t172().get_tlv_172(this._g._t172_data);
            byte[] bArr5 = new byte[(bArr4.length + 2)];
            util.int16_to_buf(bArr5, 0, 1);
            System.arraycopy(bArr4, 0, bArr5, 2, bArr4.length);
            bArr3 = bArr5;
        }
        this._req_transport_eext_head_len = bArr2.length + 13 + 1 + bArr3.length;
        byte[] bArr6 = new byte[(bArr.length + this._req_transport_eext_head_len)];
        util.int8_to_buf(bArr6, 0, i2);
        util.int16_to_buf(bArr6, 1, bArr.length);
        util.int32_to_buf(bArr6, 3, 0);
        util.int64_to_buf32(bArr6, 7, j2);
        util.int16_to_buf(bArr6, 11, bArr2.length);
        System.arraycopy(bArr2, 0, bArr6, 13, bArr2.length);
        int length = 13 + bArr2.length;
        util.int8_to_buf(bArr6, length, bArr3.length);
        int i3 = length + 1;
        System.arraycopy(bArr3, 0, bArr6, i3, bArr3.length);
        System.arraycopy(bArr, 0, bArr6, i3 + bArr3.length, bArr.length);
        int length2 = bArr.length;
        return encrypt_body(bArr6);
    }

    /* access modifiers changed from: protected */
    public byte[] encrypt_body(byte[] bArr) {
        if (this._g._encrypt_type == 0) {
            return ecdh_encrypt_body(bArr, this._g._rand_key, this._g._pub_key, this._g._share_key);
        }
        return kc_encrypt_body(bArr, this._g._rand_key, 3);
    }

    public int get_response_body(byte[] bArr, int i, int i2) {
        if (i2 < this._rsp_transport_eext_head_len) {
            return TLSErrInfo.PK_LEN;
        }
        int i3 = get_response_ret_code(bArr, i);
        set_err_msg((TLSErrInfo) null);
        QLog.d("type=" + i3);
        return i3;
    }

    public synchronized int make_request(long j, TransReqContext transReqContext, byte[] bArr, byte[] bArr2, long j2, long j3, TLSUserInfo tLSUserInfo) {
        int i;
        byte[] bArr3;
        int i2;
        TransReqContext transReqContext2 = transReqContext;
        byte[] bArr4 = bArr2;
        synchronized (this) {
            int i3 = req_global._app_client_version;
            i = 0;
            int i4 = 0;
            while (true) {
                byte[] bArr5 = transReqContext2._body;
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + req_global._l_init_time;
                if (bArr5 == null) {
                    bArr3 = new byte[0];
                } else if (bArr == null) {
                    byte[] bArr6 = new byte[(bArr5.length + 4)];
                    util.int64_to_buf32(bArr6, 0, currentTimeMillis);
                    System.arraycopy(bArr5, 0, bArr6, 4, bArr5.length);
                    bArr3 = bArr6;
                } else {
                    byte[] bArr7 = new byte[(bArr5.length + 4)];
                    util.int64_to_buf32(bArr7, 0, currentTimeMillis);
                    System.arraycopy(bArr5, 0, bArr7, 4, bArr5.length);
                    bArr3 = cryptor.encrypt(bArr7, 0, bArr7.length, bArr4);
                }
                if (bArr3 != null && bArr3.length > 0) {
                    long j4 = j;
                    int i5 = i3;
                    i2 = i4;
                    get_request(this._default_client_version, this._cmd, this._default_client_seq, j4, this._default_ext_retry, this._default_ext_type, i5, this._default_ext_instance, get_request_body(bArr3, bArr, j2, j3, 0));
                    i = snd_rcv_req();
                    if (i == 0) {
                        i = get_response(transReqContext2);
                        if (i == 0 && bArr != null) {
                            byte[] bArr8 = transReqContext.get_body();
                            transReqContext2.set_body(cryptor.decrypt(bArr8, 0, bArr8.length, bArr4));
                        }
                        if (i != 180) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    i2 = i4;
                }
                int i6 = i2;
                i4 = i6 + 1;
                if (i6 >= 1) {
                    break;
                }
            }
            QLog.d("req_transport rsp: ret=" + i);
        }
        return i;
    }

    public int get_response(TransReqContext transReqContext) {
        int i;
        int i2 = this._pos;
        if (i2 <= this._rsp_head_len + 2) {
            return TLSErrInfo.PK_LEN;
        }
        this._rsp_body_len = (i2 - this._rsp_head_len) - 2;
        if (this._g._encrypt_type == 0) {
            i = decrypt_body(this._buf, this._rsp_head_len + 1, this._rsp_body_len, this._g._share_key);
            if (i < 0) {
                QLog.i("use ecdh decrypt_body failed");
                i = decrypt_body(this._buf, this._rsp_head_len + 1, this._rsp_body_len, this._g._rand_key);
                if (i < 0) {
                    QLog.i("use kc decrypt_body failed");
                }
            }
        } else {
            i = decrypt_body(this._buf, this._rsp_head_len + 1, this._rsp_body_len, this._g._rand_key);
            if (i < 0) {
                QLog.i("use kc decrypt_body failed");
            }
        }
        if (i < 0) {
            return i;
        }
        return get_response_body(this._buf, this._rsp_head_len + 1, this._rsp_body_len, transReqContext);
    }

    public int get_response_body(byte[] bArr, int i, int i2, TransReqContext transReqContext) {
        if (i2 < this._rsp_transport_eext_head_len) {
            return TLSErrInfo.PK_LEN;
        }
        int i3 = get_response_ret_code(bArr, i);
        set_err_msg((TLSErrInfo) null);
        QLog.d("type=" + i3);
        if (i3 == 0) {
            int i4 = this._rsp_transport_eext_head_len;
            byte[] bArr2 = new byte[(i2 - i4)];
            System.arraycopy(bArr, i + i4, bArr2, 0, bArr2.length);
            transReqContext.set_body(bArr2);
            return i3;
        } else if (i3 != 180) {
            return i3;
        } else {
            int i5 = i + this._rsp_transport_eext_head_len + 2;
            tlv_t172 tlv_t172 = new tlv_t172();
            int i6 = tlv_t172.get_tlv(bArr, i5, (this._pos - i5) - 1);
            if (i6 <= 0) {
                return i6;
            }
            this._g._encrypt_type = 1;
            this._g._t172_data = tlv_t172.get_data();
            QLog.i("get rollback sig");
            return i3;
        }
    }
}
