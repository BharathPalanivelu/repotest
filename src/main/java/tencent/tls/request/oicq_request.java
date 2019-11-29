package tencent.tls.request;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.TXLiteAVCode;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.report.QLog;
import tencent.tls.tlvs.tlv_t;
import tencent.tls.tlvs.tlv_t146;
import tencent.tls.tlvs.tlv_t149;
import tencent.tls.tlvs.tlv_t172;
import tencent.tls.tools.I18nMsg;
import tencent.tls.tools.cryptor;
import tencent.tls.tools.util;

public class oicq_request {
    static final int ECDH_KEY = 0;
    static final int KC_KEY = 1;
    static String _save_host = "";
    static String[] _static_web_wlogin_ip = {"183.62.104.188"};
    static String[] _static_wlogin_ip = {"183.62.104.188"};
    static int _test = 0;
    static String _test_host = "";
    protected byte[] _buf = new byte[this._max];
    protected int _cmd = 0;
    protected int _default_client_seq = 0;
    protected int _default_client_version = TXLiteAVCode.EVT_ROOM_CONNECT_SUCC;
    protected int _default_ext_instance = 0;
    protected int _default_ext_no = 0;
    protected int _default_ext_retry = 0;
    protected int _default_ext_type = 2;
    protected int _default_ext_version = 3;
    protected int _default_ext_version1 = 0;
    public req_global _g;
    int _max = 4096;
    int _pos = 0;
    byte[] _recv_ret_buf = new byte[10240];
    int _rep_body_len = 0;
    int _req_head_len = 31;
    byte _ret;
    protected int _rsp_body_len = 0;
    public int _rsp_head_len = 19;
    InetSocketAddress _server_ip = null;
    int _server_port = 0;
    protected String _service_cmd = "";
    protected int _sub_cmd = 0;

    public int get_port(boolean z) {
        if (z) {
        }
        return 443;
    }

    public String get_static_ip(boolean z) {
        if (z) {
            return _static_web_wlogin_ip[((int) (Math.random() * 2.147483647E9d)) % _static_web_wlogin_ip.length];
        }
        return _static_wlogin_ip[((int) (Math.random() * 2.147483647E9d)) % _static_wlogin_ip.length];
    }

    public static void set_test(int i, String str) {
        _test = i;
        _test_host = str;
    }

    public void fill_head(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, int i8) {
        int i9 = this._default_client_seq + 1;
        this._default_client_seq = i9;
        this._pos = 0;
        util.int8_to_buf(this._buf, this._pos, 2);
        this._pos++;
        util.int16_to_buf(this._buf, this._pos, this._req_head_len + 2 + i8);
        this._pos += 2;
        util.int16_to_buf(this._buf, this._pos, i);
        this._pos += 2;
        util.int16_to_buf(this._buf, this._pos, i2);
        this._pos += 2;
        util.int16_to_buf(this._buf, this._pos, i9);
        this._pos += 2;
        util.int64_to_buf(this._buf, this._pos, j);
        this._pos += 8;
        util.int8_to_buf(this._buf, this._pos, 3);
        this._pos++;
        util.int8_to_buf(this._buf, this._pos, 7);
        this._pos++;
        util.int8_to_buf(this._buf, this._pos, i4);
        this._pos++;
        util.int32_to_buf(this._buf, this._pos, i5);
        this._pos += 4;
        util.int32_to_buf(this._buf, this._pos, i6);
        this._pos += 4;
        util.int32_to_buf(this._buf, this._pos, i7);
        this._pos += 4;
    }

    public void fill_end() {
        util.int8_to_buf(this._buf, this._pos, 3);
        this._pos++;
    }

    public void fill_body(byte[] bArr, int i) {
        int i2 = this._pos;
        if (i + i2 + 1 > this._max) {
            this._max = i + i2 + 1 + 128;
            byte[] bArr2 = new byte[this._max];
            System.arraycopy(this._buf, 0, bArr2, 0, i2);
            this._buf = bArr2;
        }
        System.arraycopy(bArr, 0, this._buf, this._pos, i);
        this._pos += i;
    }

    public void fill(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr, int i8) {
        fill_head(i, i2, i3, j, i4, i5, i6, i7, i8);
        fill_body(bArr, i8);
        fill_end();
    }

    public void get_request(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr) {
        byte[] bArr2 = bArr;
        fill(i, i2, i3, j, i4, i5, i6, i7, bArr2, bArr2.length);
    }

    public int get_response() {
        int i;
        int i2 = this._pos;
        int i3 = this._rsp_head_len;
        if (i2 <= i3 + 2) {
            return TLSErrInfo.PK_LEN;
        }
        this._rsp_body_len = (i2 - i3) - 2;
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
        return get_response_body(this._buf, this._rsp_head_len + 1, this._rsp_body_len);
    }

    public void set_buf(byte[] bArr, int i) {
        if (i > this._max) {
            this._max = i + 128;
            this._buf = new byte[this._max];
        }
        this._pos = i;
        System.arraycopy(bArr, 0, this._buf, 0, i);
    }

    public byte[] get_buf() {
        int i = this._pos;
        byte[] bArr = new byte[i];
        System.arraycopy(this._buf, 0, bArr, 0, i);
        return bArr;
    }

    public int decrypt_body(byte[] bArr, int i, int i2, byte[] bArr2) {
        byte[] decrypt = cryptor.decrypt(bArr, i, i2, bArr2);
        if (decrypt == null) {
            return TLSErrInfo.DECRYPT_FAILED;
        }
        this._rsp_body_len = decrypt.length;
        int length = decrypt.length;
        int i3 = this._rsp_head_len;
        if (length + i3 + 2 > this._max) {
            this._max = decrypt.length + i3 + 2;
            byte[] bArr3 = new byte[this._max];
            System.arraycopy(this._buf, 0, bArr3, 0, this._pos);
            this._buf = bArr3;
        }
        this._pos = 0;
        System.arraycopy(decrypt, 0, this._buf, i, decrypt.length);
        this._pos += this._rsp_head_len + 2 + decrypt.length;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public byte[] ecdh_encrypt_body(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr == null || bArr2 == null || bArr3 == null || bArr4 == null) {
            return new byte[0];
        }
        byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, bArr4);
        byte[] bArr5 = new byte[(bArr2.length + 2 + 2 + 2 + bArr3.length + encrypt.length)];
        util.int8_to_buf(bArr5, 0, 1);
        util.int8_to_buf(bArr5, 1, 1);
        System.arraycopy(bArr2, 0, bArr5, 2, bArr2.length);
        int length = bArr2.length + 2;
        util.int16_to_buf(bArr5, length, 258);
        int i = length + 2;
        util.int16_to_buf(bArr5, i, bArr3.length);
        int i2 = i + 2;
        System.arraycopy(bArr3, 0, bArr5, i2, bArr3.length);
        System.arraycopy(encrypt, 0, bArr5, i2 + bArr3.length, encrypt.length);
        int length2 = encrypt.length;
        QLog.d("ecdh req body " + bArr5.length);
        return bArr5;
    }

    /* access modifiers changed from: package-private */
    public byte[] kc_encrypt_body(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, bArr2);
        byte[] bArr3 = new byte[(bArr2.length + 2 + 2 + 2 + encrypt.length)];
        util.int8_to_buf(bArr3, 0, 1);
        util.int8_to_buf(bArr3, 1, i);
        System.arraycopy(bArr2, 0, bArr3, 2, bArr2.length);
        int length = bArr2.length + 2;
        util.int16_to_buf(bArr3, length, 258);
        int i2 = length + 2;
        util.int16_to_buf(bArr3, i2, 0);
        System.arraycopy(encrypt, 0, bArr3, i2 + 2, encrypt.length);
        int length2 = encrypt.length;
        QLog.d("kc req body " + bArr3.length);
        return bArr3;
    }

    /* access modifiers changed from: package-private */
    public byte[] kc_encrypt_body(byte[] bArr, byte[] bArr2) {
        return kc_encrypt_body(bArr, bArr2, 2);
    }

    /* access modifiers changed from: package-private */
    public byte[] encrypt_body(byte[] bArr, int i, int i2) {
        QLog.i("subcmd 0x" + Integer.toHexString(i));
        byte[] bArr2 = new byte[(bArr.length + 4)];
        util.int16_to_buf(bArr2, 0, i);
        util.int16_to_buf(bArr2, 2, i2);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        if (this._g._encrypt_type == 0) {
            return ecdh_encrypt_body(bArr2, this._g._rand_key, this._g._pub_key, this._g._share_key);
        }
        return kc_encrypt_body(bArr2, this._g._rand_key);
    }

    /* access modifiers changed from: protected */
    public byte[] encrypt_body(byte[] bArr) {
        if (this._g._encrypt_type == 0) {
            return ecdh_encrypt_body(bArr, this._g._rand_key, this._g._pub_key, this._g._share_key);
        }
        return kc_encrypt_body(bArr, this._g._rand_key);
    }

    public Socket get_sk() {
        if (this._g._sk != null) {
            QLog.d("_sk" + this._g._sk.toString());
        } else {
            QLog.d("_sknull");
        }
        return this._g._sk;
    }

    public void set_sk(Socket socket) {
        this._g._sk = socket;
    }

    public String get_host(boolean z) {
        String[] strArr = new String[2];
        if (z) {
            strArr[0] = "ida1.qq.com";
            strArr[1] = "ida1.qq.com";
        } else {
            strArr[0] = "ida.qq.com";
            strArr[1] = "ida.qq.com";
        }
        return strArr[Math.abs(new Random().nextInt() % strArr.length)];
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String resolve_server_addr(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 2
            int r4 = r4 / r0
            int r1 = _test
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = _test_host
            if (r1 == 0) goto L_0x0013
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0013
            java.lang.String r5 = _test_host
            goto L_0x0069
        L_0x0013:
            r1 = 1
            if (r4 >= r1) goto L_0x005e
            if (r5 == 0) goto L_0x0032
            int r2 = tencent.tls.request.req_global._network_type
            if (r2 != r1) goto L_0x0025
            android.content.Context r0 = tencent.tls.request.req_global._context
            java.lang.String r1 = "wap-host1"
            java.lang.String r0 = tencent.tls.tools.util.get_server_host(r0, r1)
            goto L_0x004e
        L_0x0025:
            int r1 = tencent.tls.request.req_global._network_type
            if (r1 != r0) goto L_0x004c
            android.content.Context r0 = tencent.tls.request.req_global._context
            java.lang.String r1 = "wap-host2"
            java.lang.String r0 = tencent.tls.tools.util.get_server_host(r0, r1)
            goto L_0x004e
        L_0x0032:
            int r2 = tencent.tls.request.req_global._network_type
            if (r2 != r1) goto L_0x003f
            android.content.Context r0 = tencent.tls.request.req_global._context
            java.lang.String r1 = "host1"
            java.lang.String r0 = tencent.tls.tools.util.get_server_host(r0, r1)
            goto L_0x004e
        L_0x003f:
            int r1 = tencent.tls.request.req_global._network_type
            if (r1 != r0) goto L_0x004c
            android.content.Context r0 = tencent.tls.request.req_global._context
            java.lang.String r1 = "host2"
            java.lang.String r0 = tencent.tls.tools.util.get_server_host(r0, r1)
            goto L_0x004e
        L_0x004c:
            java.lang.String r0 = ""
        L_0x004e:
            if (r0 == 0) goto L_0x0059
            int r1 = r0.length()
            if (r1 > 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r5 = r0
            goto L_0x0069
        L_0x0059:
            java.lang.String r5 = r3.get_host(r5)
            goto L_0x0069
        L_0x005e:
            if (r4 >= r0) goto L_0x0065
            java.lang.String r5 = r3.get_host(r5)
            goto L_0x0069
        L_0x0065:
            java.lang.String r5 = r3.get_static_ip(r5)
        L_0x0069:
            _save_host = r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "resolve_server_addr OK host:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " tryno:"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            tencent.tls.report.QLog.d(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.request.oicq_request.resolve_server_addr(int, boolean):java.lang.String");
    }

    public int snd_rcv_req() {
        int i;
        if (this._g._use_sso_channel) {
            i = snd_rcv_req_sso();
        } else {
            i = snd_rcv_req_tcp();
        }
        if (i == -1000) {
            TLSErrInfo tLSErrInfo = new TLSErrInfo();
            tLSErrInfo.ErrCode = i;
            tLSErrInfo.Msg = I18nMsg.getMsg(I18nMsg.MSG_TYPE.MSG_4);
            set_err_msg(tLSErrInfo);
        }
        return i;
    }

    public int snd_rcv_req_sso() {
        QLog.i(getClass().getName() + ":snd_rcv_req_sso ...", this._g._uin);
        int i = this._g._time_out;
        byte[] bArr = get_buf();
        int i2 = TLSErrInfo.TIMEOUT;
        try {
            QLog.i("SSORunner service_cmd:" + this._service_cmd + " timeout:" + i, this._g._uin);
            SSORunner sSORunner = new SSORunner(this._service_cmd, bArr, i);
            sSORunner.run();
            byte[] resData = sSORunner.getResData();
            if (resData == null) {
                QLog.i("recv data from server failed, ret=" + sSORunner.getRet(), this._g._uin);
                if (1013 == sSORunner.getRet()) {
                    i2 = TLSErrInfo.NO_QAL_SERVICE;
                } else if (1014 == sSORunner.getRet()) {
                    i2 = TLSErrInfo.NO_NETWORK_ERROR;
                } else {
                    int ret = sSORunner.getRet();
                }
            } else {
                set_buf(resData, resData.length);
                i2 = 0;
            }
        } catch (Exception e2) {
            QLog.e(e2);
        }
        QLog.i(getClass().getName() + ":snd_rcv_req_sso ret=" + i2, this._g._uin);
        return i2;
    }

    public int get_rsp_length(byte[] bArr) {
        return util.buf_to_int16(bArr, 1);
    }

    public int snd_rcv_req_tcp() {
        String str;
        QLog.i(getClass().getName() + ":snd_rcv_req_tcp ...", this._g._uin);
        byte[] bArr = get_buf();
        int i = 0;
        Socket socket = get_sk();
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6) {
            if (i2 != 0) {
                util.chg_retry_type(req_global._context);
            }
            util.is_wap_retry(req_global._context);
            this._server_ip = null;
            QLog.i("try bin connect " + i2 + " ...", this._g._uin);
            if (socket == null) {
                if (this._server_ip == null) {
                    str = resolve_server_addr(i2, false);
                    QLog.i("DNS for " + str + " request ...", this._g._uin);
                    try {
                        this._server_port = get_port(false);
                        this._server_ip = DNS_resolver.get_DNS_resolver(str, this._server_port, (long) this._g._time_out);
                    } catch (Exception unused) {
                    }
                } else {
                    str = "";
                }
                if (this._server_ip == null) {
                    QLog.i("DNS for " + str + " request failed", this._g._uin);
                    i2++;
                    this._server_ip = null;
                    set_sk((Socket) null);
                    socket = null;
                } else {
                    QLog.i("DNS for " + str + SQLBuilder.PARENTHESES_LEFT + this._server_ip.toString() + ") request OK", this._g._uin);
                }
            }
            if (socket == null) {
                try {
                    QLog.i("tcp connect to " + this._server_ip + " request ...", this._g._uin);
                    socket = new Socket();
                    set_sk(socket);
                    socket.connect(this._server_ip, this._g._time_out);
                    socket.setSoTimeout(this._g._time_out);
                    socket.setReceiveBufferSize(this._recv_ret_buf.length);
                    QLog.i("tcp connect to " + this._server_ip + " OK", this._g._uin);
                } catch (Exception e2) {
                    QLog.e(e2);
                    i2++;
                    this._server_ip = null;
                    set_sk((Socket) null);
                }
            }
            QLog.i("tcp request write ...", this._g._uin);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bArr, 0, bArr.length);
            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            try {
                QLog.i("recv data from server ...", this._g._uin);
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= this._rsp_head_len + 1) {
                        break;
                    }
                    i5 = inputStream.read(this._recv_ret_buf, i4, (this._rsp_head_len + 1) - i4);
                    if (i5 < 0) {
                        break;
                    }
                    i4 += i5;
                }
                if (i5 >= 0) {
                    i3 = get_rsp_length(this._recv_ret_buf);
                    if (i3 > this._rsp_head_len + 1) {
                        if (i3 < this._recv_ret_buf.length) {
                            int i6 = this._rsp_head_len + 1;
                            int i7 = i3 - i6;
                            while (true) {
                                if (i7 <= 0) {
                                    break;
                                }
                                i5 = inputStream.read(this._recv_ret_buf, i6, i7);
                                if (i5 == -1) {
                                    break;
                                }
                                i6 += i5;
                                i7 -= i5;
                            }
                            if (i5 != -1) {
                                break;
                            }
                            i2++;
                            socket.close();
                            this._server_ip = null;
                            set_sk((Socket) null);
                            socket = null;
                        } else {
                            i2++;
                            socket.close();
                            this._server_ip = null;
                            set_sk((Socket) null);
                            socket = null;
                        }
                    } else {
                        i2++;
                        socket.close();
                        this._server_ip = null;
                        set_sk((Socket) null);
                        socket = null;
                    }
                } else {
                    i2++;
                    socket.close();
                    this._server_ip = null;
                    try {
                        set_sk((Socket) null);
                    } catch (Exception e3) {
                        e = e3;
                        socket = null;
                    }
                    socket = null;
                }
            } catch (Exception e4) {
                e = e4;
                QLog.e(e);
                i2++;
                try {
                    if (socket.isConnected()) {
                        socket.close();
                    }
                } catch (Exception unused2) {
                }
                this._server_ip = null;
                set_sk((Socket) null);
                socket = null;
            }
        }
        if (i2 >= 6) {
            i = TLSErrInfo.TIMEOUT;
        }
        if (i == 0) {
            set_buf(this._recv_ret_buf, i3);
        }
        QLog.i(getClass().getName() + ":snd_rcv_req_tcp ret=" + i, this._g._uin);
        return i;
    }

    public int get_response_ret_code(byte[] bArr, int i) {
        this._ret = bArr[i];
        return bArr[i] & 255;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this._pos; i++) {
            str = (str + Integer.toHexString((this._buf[i] >> 4) & 15)) + Integer.toHexString(this._buf[i] & 15);
        }
        return str;
    }

    public void get_err_msg(byte[] bArr, int i, int i2) {
        tlv_t146 tlv_t146 = new tlv_t146();
        int i3 = tlv_t146.get_tlv(bArr, i, i2);
        async_context async_context = req_global.get_async_data(this._g._seq);
        if (i3 >= 0) {
            async_context._last_err_msg = new TLSErrInfo(tlv_t146.errType, tlv_t146.errTitle, tlv_t146.errMsg, tlv_t146.extraErrMsg);
            QLog.i("t146 errtype: " + tlv_t146.errType);
        }
    }

    public void set_err_msg(TLSErrInfo tLSErrInfo) {
        async_context async_context = req_global.get_async_data(this._g._seq);
        if (tLSErrInfo != null) {
            async_context._last_err_msg = tLSErrInfo;
        } else {
            async_context._last_err_msg = new TLSErrInfo();
        }
    }

    public void show_alert_dialog(tlv_t149 tlv_t149) {
        if (tlv_t149 != null) {
            try {
                new alert_thread(req_global._context, new TLSErrInfo(tlv_t149.get_type(), tlv_t149.get_title(), tlv_t149.get_content(), tlv_t149.get_otherinfo())).start();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] encrypt_a1(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] decrypt_a1(byte[] r8) {
        /*
            r7 = this;
            byte[] r0 = tencent.tls.request.req_global._IMEI_KEY
            r1 = 16
            r2 = 0
            java.lang.String r3 = "%4;7t>;28<fc.5*6"
            if (r0 == 0) goto L_0x0047
            byte[] r0 = tencent.tls.request.req_global._IMEI_KEY
            int r0 = r0.length
            if (r0 > 0) goto L_0x000f
            goto L_0x0047
        L_0x000f:
            byte[] r0 = new byte[r1]
            byte[] r4 = tencent.tls.request.req_global._IMEI_KEY
            int r4 = r4.length
            int r5 = r0.length
            if (r4 <= r5) goto L_0x001e
            byte[] r4 = tencent.tls.request.req_global._IMEI_KEY
            int r5 = r0.length
            java.lang.System.arraycopy(r4, r2, r0, r2, r5)
            goto L_0x0033
        L_0x001e:
            byte[] r4 = tencent.tls.request.req_global._IMEI_KEY
            byte[] r5 = tencent.tls.request.req_global._IMEI_KEY
            int r5 = r5.length
            java.lang.System.arraycopy(r4, r2, r0, r2, r5)
            byte[] r4 = tencent.tls.request.req_global._IMEI_KEY
            int r4 = r4.length
        L_0x0029:
            int r5 = r0.length
            if (r4 >= r5) goto L_0x0033
            int r5 = r4 + 1
            byte r6 = (byte) r5
            r0[r4] = r6
            r4 = r5
            goto L_0x0029
        L_0x0033:
            int r4 = r8.length
            byte[] r0 = tencent.tls.tools.cryptor.decrypt(r8, r2, r4, r0)
            if (r0 == 0) goto L_0x003d
            int r4 = r0.length
            if (r4 > 0) goto L_0x0050
        L_0x003d:
            int r0 = r8.length
            byte[] r3 = r3.getBytes()
            byte[] r0 = tencent.tls.tools.cryptor.decrypt(r8, r2, r0, r3)
            goto L_0x0050
        L_0x0047:
            int r0 = r8.length
            byte[] r3 = r3.getBytes()
            byte[] r0 = tencent.tls.tools.cryptor.decrypt(r8, r2, r0, r3)
        L_0x0050:
            if (r0 != 0) goto L_0x0059
            java.lang.Object r8 = r8.clone()
            r0 = r8
            byte[] r0 = (byte[]) r0
        L_0x0059:
            if (r0 == 0) goto L_0x0076
            int r8 = r0.length
            if (r8 >= r1) goto L_0x005f
            goto L_0x0076
        L_0x005f:
            int r8 = r0.length
            int r8 = r8 - r1
            byte[] r3 = new byte[r8]
            java.lang.System.arraycopy(r0, r2, r3, r2, r8)
            byte[] r4 = new byte[r1]
            java.lang.System.arraycopy(r0, r8, r4, r2, r1)
            tencent.tls.request.req_global r8 = r7._g
            long r0 = r8._seq
            tencent.tls.request.async_context r8 = tencent.tls.request.req_global.get_async_data(r0)
            r8._tgtgt_key = r4
            return r3
        L_0x0076:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.request.oicq_request.decrypt_a1(byte[]):byte[]");
    }

    /* access modifiers changed from: package-private */
    public void set_server_host(int i, byte[] bArr, int i2) {
        if (bArr != null && bArr.length > 0) {
            if (i == 1) {
                if (req_global._network_type == 1) {
                    util.set_server_host(req_global._context, bArr, "host1");
                } else if (req_global._network_type == 2) {
                    util.set_server_host(req_global._context, bArr, "host2");
                }
            } else if (i == 2) {
                if (req_global._network_type == 1) {
                    util.set_server_host(req_global._context, bArr, "wap-host1");
                } else if (req_global._network_type == 2) {
                    util.set_server_host(req_global._context, bArr, "wap-host2");
                }
            }
            QLog.i("net type:" + req_global._network_type + " type:" + i + " host:" + new String(bArr) + " port:" + i2, this._g._uin);
        }
    }

    public int parse_t173(tlv_t tlv_t) {
        byte[] bArr = tlv_t.get_data();
        if (bArr != null && bArr.length > 2) {
            int buf_to_int8 = util.buf_to_int8(bArr, 1);
            int i = 0;
            int i2 = 2;
            while (i < buf_to_int8) {
                int i3 = i2 + 1;
                if (bArr.length < i3) {
                    break;
                }
                int buf_to_int82 = util.buf_to_int8(bArr, i2);
                int i4 = i3 + 2;
                if (bArr.length < i4) {
                    break;
                }
                int buf_to_int16 = util.buf_to_int16(bArr, i3);
                int i5 = i4 + buf_to_int16;
                if (bArr.length < i5) {
                    break;
                }
                byte[] bArr2 = new byte[buf_to_int16];
                System.arraycopy(bArr, i4, bArr2, 0, buf_to_int16);
                int i6 = i5 + 2;
                if (bArr.length < i6) {
                    break;
                }
                set_server_host(buf_to_int82, bArr2, util.buf_to_int16(bArr, i5));
                i++;
                i2 = i6;
            }
        }
        return 0;
    }

    public int parse_t161(tlv_t tlv_t) {
        tlv_t tlv_t2 = new tlv_t(371);
        tlv_t172 tlv_t172 = new tlv_t172();
        byte[] bArr = tlv_t.get_data();
        int length = bArr.length;
        if (tlv_t2.get_tlv(bArr, 2, length) > 0) {
            parse_t173(tlv_t2);
        }
        if (tlv_t172.get_tlv(bArr, 2, length) <= 0) {
            return 0;
        }
        req_global req_global = this._g;
        req_global._encrypt_type = 1;
        req_global._t172_data = tlv_t172.get_data();
        QLog.i("get rollback sig");
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x056f  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int get_response_body(byte[] r40, int r41, int r42) {
        /*
            r39 = this;
            r0 = r39
            r1 = r40
            tencent.tls.tlvs.tlv_t104 r2 = new tencent.tls.tlvs.tlv_t104
            r2.<init>()
            tencent.tls.tlvs.tlv_t105 r3 = new tencent.tls.tlvs.tlv_t105
            r3.<init>()
            tencent.tls.tlvs.tlv_t113 r4 = new tencent.tls.tlvs.tlv_t113
            r4.<init>()
            tencent.tls.tlvs.tlv_t r5 = new tencent.tls.tlvs.tlv_t
            r6 = 281(0x119, float:3.94E-43)
            r5.<init>(r6)
            tencent.tls.tlvs.tlv_t r6 = new tencent.tls.tlvs.tlv_t
            r7 = 269(0x10d, float:3.77E-43)
            r6.<init>(r7)
            tencent.tls.tlvs.tlv_t r7 = new tencent.tls.tlvs.tlv_t
            r8 = 266(0x10a, float:3.73E-43)
            r7.<init>(r8)
            tencent.tls.tlvs.tlv_t130 r8 = new tencent.tls.tlvs.tlv_t130
            r8.<init>()
            tencent.tls.tlvs.tlv_t106 r9 = new tencent.tls.tlvs.tlv_t106
            r9.<init>()
            tencent.tls.tlvs.tlv_t r10 = new tencent.tls.tlvs.tlv_t
            r11 = 268(0x10c, float:3.76E-43)
            r10.<init>(r11)
            tencent.tls.tlvs.tlv_t11f r11 = new tencent.tls.tlvs.tlv_t11f
            r11.<init>()
            tencent.tls.tlvs.tlv_t138 r12 = new tencent.tls.tlvs.tlv_t138
            r12.<init>()
            tencent.tls.tlvs.tlv_t149 r12 = new tencent.tls.tlvs.tlv_t149
            r12.<init>()
            tencent.tls.tlvs.tlv_t150 r13 = new tencent.tls.tlvs.tlv_t150
            r13.<init>()
            tencent.tls.tlvs.tlv_t r14 = new tencent.tls.tlvs.tlv_t
            r15 = 323(0x143, float:4.53E-43)
            r14.<init>(r15)
            tencent.tls.tlvs.tlv_t r15 = new tencent.tls.tlvs.tlv_t
            r16 = r9
            r9 = 773(0x305, float:1.083E-42)
            r15.<init>(r9)
            tencent.tls.tlvs.tlv_t16a r9 = new tencent.tls.tlvs.tlv_t16a
            r9.<init>()
            r17 = r9
            tencent.tls.tlvs.tlv_t r9 = new tencent.tls.tlvs.tlv_t
            r18 = r10
            r10 = 353(0x161, float:4.95E-43)
            r9.<init>(r10)
            tencent.tls.tlvs.tlv_t r10 = new tencent.tls.tlvs.tlv_t
            r19 = r11
            r11 = 372(0x174, float:5.21E-43)
            r10.<init>(r11)
            tencent.tls.tlvs.tlv_t126 r11 = new tencent.tls.tlvs.tlv_t126
            r11.<init>()
            r20 = r12
            tencent.tls.tlvs.tlv_t505 r12 = new tencent.tls.tlvs.tlv_t505
            r12.<init>()
            r21 = r5
            tencent.tls.tlvs.tlv_t183 r5 = new tencent.tls.tlvs.tlv_t183
            r5.<init>()
            r22 = r13
            tencent.tls.request.req_global r13 = r0._g
            r23 = r14
            long r13 = r13._seq
            tencent.tls.request.async_context r13 = tencent.tls.request.req_global.get_async_data(r13)
            r24 = r15
            long r14 = r13._src_appid
            r25 = r6
            r26 = r7
            long r6 = r13._appid
            r31 = r6
            int r6 = r0._sub_cmd
            r7 = 2
            r34 = r4
            if (r6 == r7) goto L_0x00db
            r4 = 3
            if (r6 == r4) goto L_0x00db
            r4 = 7
            if (r6 == r4) goto L_0x00d6
            r4 = 9
            if (r6 == r4) goto L_0x00db
            r4 = 15
            if (r6 == r4) goto L_0x00d2
            r4 = 25
            if (r6 == r4) goto L_0x00cd
            r4 = 26
            if (r6 == r4) goto L_0x00c8
            switch(r6) {
                case 17: goto L_0x00db;
                case 18: goto L_0x00c4;
                case 19: goto L_0x00db;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            r1 = -1012(0xfffffffffffffc0c, float:NaN)
            return r1
        L_0x00c4:
            r4 = r42
            r6 = 7
            goto L_0x00de
        L_0x00c8:
            r4 = r42
            r6 = 9
            goto L_0x00de
        L_0x00cd:
            r4 = r42
            r6 = 8
            goto L_0x00de
        L_0x00d2:
            r4 = r42
            r6 = 5
            goto L_0x00de
        L_0x00d6:
            r4 = 6
            r4 = r42
            r6 = 6
            goto L_0x00de
        L_0x00db:
            r4 = r42
            r6 = 0
        L_0x00de:
            r7 = 5
            if (r4 >= r7) goto L_0x00e4
            r1 = -1009(0xfffffffffffffc0f, float:NaN)
            return r1
        L_0x00e4:
            int r4 = r41 + 2
            int r4 = r0.get_response_ret_code(r1, r4)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r36 = r6
            java.lang.String r6 = "get_response_body type="
            r7.append(r6)
            r7.append(r4)
            java.lang.String r6 = r7.toString()
            tencent.tls.report.QLog.i(r6)
            r6 = 5
            int r6 = r41 + 5
            tencent.tls.request.req_global r7 = r0._g
            r37 = r14
            r14 = 0
            r7._t150 = r14
            r15 = 1
            if (r4 == 0) goto L_0x0280
            if (r4 == r15) goto L_0x026e
            r7 = 2
            if (r4 == r7) goto L_0x0229
            r7 = 15
            if (r4 == r7) goto L_0x026e
            r3 = 16
            if (r4 == r3) goto L_0x0206
            r3 = 160(0xa0, float:2.24E-43)
            if (r4 == r3) goto L_0x01e1
            r3 = 176(0xb0, float:2.47E-43)
            if (r4 == r3) goto L_0x01c8
            r3 = 180(0xb4, float:2.52E-43)
            if (r4 == r3) goto L_0x01ac
            r3 = 208(0xd0, float:2.91E-43)
            if (r4 == r3) goto L_0x0144
            r2 = 255(0xff, float:3.57E-43)
            if (r4 == r2) goto L_0x0137
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r0.get_err_msg(r1, r6, r2)
            goto L_0x0535
        L_0x0137:
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r0.get_err_msg(r1, r6, r2)
            tencent.tls.platform.TLSErrInfo r1 = r13._last_err_msg
            int r4 = r1.ErrCode
            goto L_0x0535
        L_0x0144:
            int r3 = r0._pos
            int r3 = r3 - r6
            int r3 = r3 - r15
            int r4 = r2.get_tlv((byte[]) r1, (int) r6, (int) r3)
            if (r4 >= 0) goto L_0x0150
            goto L_0x0535
        L_0x0150:
            r13._t104 = r2
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r4 = r11.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r4 >= 0) goto L_0x015e
            goto L_0x0535
        L_0x015e:
            r13._t126 = r11
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r4 = r12.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r4 >= 0) goto L_0x016c
            goto L_0x0535
        L_0x016c:
            int r2 = r12.getReask()
            r13._smslogin_reask = r2
            int r2 = r12.getExpire()
            r13._smslogin_expire = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "reask: "
            r2.append(r3)
            int r3 = r13._smslogin_reask
            r2.append(r3)
            java.lang.String r3 = ", expire: "
            r2.append(r3)
            int r3 = r13._smslogin_expire
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            tencent.tls.report.QLog.i(r2)
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r4 = r5.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r4 >= 0) goto L_0x01a4
            goto L_0x0535
        L_0x01a4:
            long r1 = r5.getMsalt()
            r13._msalt = r1
            goto L_0x0534
        L_0x01ac:
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r2 = r9.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r2 >= 0) goto L_0x01b7
            goto L_0x0210
        L_0x01b7:
            r0.parse_t161(r9)
            java.lang.String r2 = "0xb4 parse t161 called"
            tencent.tls.report.QLog.d(r2)
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r0.get_err_msg(r1, r6, r2)
            goto L_0x0535
        L_0x01c8:
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r0.get_err_msg(r1, r6, r2)
            tencent.tls.request.req_global r1 = r0._g
            java.lang.String r2 = r1._userid
            r1.remove_account(r2)
            tencent.tls.request.req_global r1 = r0._g
            long r2 = r1._uin
            r5 = 0
            r1.clear_sig(r2, r5)
            goto L_0x0535
        L_0x01e1:
            int r3 = r0._pos
            int r3 = r3 - r6
            int r3 = r3 - r15
            int r3 = r2.get_tlv((byte[]) r1, (int) r6, (int) r3)
            if (r3 >= 0) goto L_0x01ee
            r4 = r3
            goto L_0x0535
        L_0x01ee:
            r13._t104 = r2
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r2 = r10.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r2 >= 0) goto L_0x01fb
            goto L_0x0210
        L_0x01fb:
            r13._t174 = r10
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r0.get_err_msg(r1, r6, r2)
            goto L_0x0535
        L_0x0206:
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r2 = r8.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r2 >= 0) goto L_0x0213
        L_0x0210:
            r4 = r2
            goto L_0x0535
        L_0x0213:
            tencent.tls.request.req_global r2 = r0._g
            byte[] r3 = r8.get_time()
            byte[] r5 = r8.get_ipaddr()
            r2.set_time_ip(r3, r5)
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r0.get_err_msg(r1, r6, r2)
            goto L_0x0535
        L_0x0229:
            int r5 = r0._pos
            int r5 = r5 - r6
            int r5 = r5 - r15
            int r5 = r2.get_tlv((byte[]) r1, (int) r6, (int) r5)
            if (r5 >= 0) goto L_0x0236
            r4 = r5
            goto L_0x0535
        L_0x0236:
            r13._t104 = r2
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r2 = r3.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r2 >= 0) goto L_0x0243
            goto L_0x0210
        L_0x0243:
            r13._t105 = r3
            tencent.tls.tlvs.tlv_t r2 = new tencent.tls.tlvs.tlv_t
            r3 = 1284(0x504, float:1.799E-42)
            r2.<init>(r3)
            int r3 = r0._pos
            int r3 = r3 - r6
            int r3 = r3 - r15
            int r1 = r2.get_tlv((byte[]) r1, (int) r6, (int) r3)
            if (r1 < 0) goto L_0x025b
            java.lang.String r1 = "got t504"
            tencent.tls.report.QLog.i(r1)
        L_0x025b:
            tencent.tls.platform.TLSErrInfo r1 = new tencent.tls.platform.TLSErrInfo
            java.lang.String r3 = new java.lang.String
            byte[] r2 = r2.get_data()
            r3.<init>(r2)
            r1.<init>(r4, r14, r3)
            r0.set_err_msg(r1)
            goto L_0x0535
        L_0x026e:
            tencent.tls.request.req_global r2 = r0._g
            long r7 = r2._uin
            r10 = r37
            r2.clear_sig(r7, r10)
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r0.get_err_msg(r1, r6, r2)
            goto L_0x0535
        L_0x0280:
            r4 = r36
            r10 = r37
            r3 = 7
            if (r4 == r3) goto L_0x0509
            r3 = 8
            if (r4 != r3) goto L_0x028d
            goto L_0x050b
        L_0x028d:
            r2 = 2160000(0x20f580, double:1.067182E-317)
            r27 = 1728000(0x1a5e00, double:8.537454E-318)
            r36 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r5 = 9
            if (r4 != r5) goto L_0x036b
            int r4 = r0._pos
            int r4 = r4 - r6
            r5 = r34
            int r4 = r5.get_tlv((byte[]) r1, (int) r6, (int) r4)
            if (r4 >= 0) goto L_0x02ab
        L_0x02a7:
            r4 = -1003(0xfffffffffffffc15, float:NaN)
            goto L_0x0535
        L_0x02ab:
            tencent.tls.request.req_global r4 = r0._g
            long r7 = r5.get_uin()
            r4._uin = r7
            tencent.tls.tlvs.tlv_t r4 = new tencent.tls.tlvs.tlv_t
            r5 = 1286(0x506, float:1.802E-42)
            r4.<init>(r5)
            int r5 = r0._pos
            int r5 = r5 - r6
            int r5 = r4.get_tlv((byte[]) r1, (int) r6, (int) r5)
            if (r5 < 0) goto L_0x02d0
            tencent.tls.request.req_global r5 = r0._g
            byte[] r4 = r4.get_data()
            r7 = 0
            int r4 = tencent.tls.tools.util.buf_to_int32(r4, r7)
            r5._admin = r4
        L_0x02d0:
            tencent.tls.tlvs.tlv_t r4 = new tencent.tls.tlvs.tlv_t
            r5 = 274(0x112, float:3.84E-43)
            r4.<init>(r5)
            int r5 = r0._pos
            int r5 = r5 - r6
            int r5 = r4.get_tlv((byte[]) r1, (int) r6, (int) r5)
            tencent.tls.request.req_global r7 = r0._g
            java.lang.String r7 = r7._userid
            if (r5 < 0) goto L_0x02ed
            java.lang.String r7 = new java.lang.String
            byte[] r4 = r4.get_data()
            r7.<init>(r4)
        L_0x02ed:
            tencent.tls.request.req_global r4 = r0._g
            java.lang.String r5 = r4._userid
            tencent.tls.request.req_global r8 = r0._g
            long r8 = r8._uin
            r4.put_open_account(r5, r7, r8)
            tencent.tls.request.req_global r4 = r0._g
            r4._userid = r7
            int r4 = r0._pos
            int r4 = r4 - r6
            r12 = r26
            r12.get_tlv((byte[]) r1, (int) r6, (int) r4)
            int r4 = r0._pos
            int r4 = r4 - r6
            r5 = r23
            r5.get_tlv((byte[]) r1, (int) r6, (int) r4)
            int r4 = r0._pos
            int r4 = r4 - r6
            r7 = r24
            r7.get_tlv((byte[]) r1, (int) r6, (int) r4)
            long r8 = tencent.tls.request.req_global.get_cur_time()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            tencent.tls.request.Ticket r4 = new tencent.tls.request.Ticket
            r16 = 64
            byte[] r17 = r12.get_data()
            byte[] r18 = r25.get_data()
            long r21 = r8 + r2
            r15 = r4
            r19 = r8
            r15.<init>(r16, r17, r18, r19, r21)
            r1.add(r4)
            tencent.tls.request.Ticket r2 = new tencent.tls.request.Ticket
            r16 = 262144(0x40000, float:3.67342E-40)
            byte[] r17 = r5.get_data()
            byte[] r18 = r7.get_data()
            long r21 = r8 + r27
            r15 = r2
            r15.<init>(r16, r17, r18, r19, r21)
            r1.add(r2)
            tencent.tls.request.req_global r2 = r0._g
            long r3 = r2._uin
            r5 = 0
            byte[] r6 = new byte[r5]
            byte[] r7 = new byte[r5]
            int r5 = r13._login_bitmap
            r24 = r2
            r25 = r3
            r27 = r10
            r29 = r6
            r30 = r7
            r33 = r36
            r35 = r8
            r37 = r1
            r38 = r5
            r24.put_siginfo(r25, r27, r29, r30, r31, r33, r35, r37, r38)
            goto L_0x0534
        L_0x036b:
            r7 = r23
            r14 = r24
            r12 = r26
            r5 = r34
            if (r4 != 0) goto L_0x0393
            int r4 = r0._pos
            int r4 = r4 - r6
            int r4 = r5.get_tlv((byte[]) r1, (int) r6, (int) r4)
            if (r4 >= 0) goto L_0x0380
            goto L_0x02a7
        L_0x0380:
            tencent.tls.request.req_global r4 = r0._g
            long r2 = r5.get_uin()
            r4._uin = r2
            tencent.tls.request.req_global r2 = r0._g
            java.lang.String r3 = r2._userid
            tencent.tls.request.req_global r4 = r0._g
            long r4 = r4._uin
            r2.put_account(r3, r4)
        L_0x0393:
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            r3 = r22
            int r2 = r3.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r2 < 0) goto L_0x03a3
            tencent.tls.request.req_global r2 = r0._g
            r2._t150 = r3
        L_0x03a3:
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            int r2 = r9.get_tlv((byte[]) r1, (int) r6, (int) r2)
            if (r2 < 0) goto L_0x03b5
            r0.parse_t161(r9)
            java.lang.String r2 = "parse t161 called"
            tencent.tls.report.QLog.d(r2)
        L_0x03b5:
            int r2 = r0._pos
            int r2 = r2 - r6
            int r2 = r2 - r15
            byte[] r3 = r13._tgtgt_key
            r4 = r21
            int r1 = r4.get_tlv(r1, r6, r2, r3)
            if (r1 >= 0) goto L_0x03cb
            java.lang.String r2 = "119 can not decrypt"
            tencent.tls.report.QLog.d(r2)
            r4 = r1
            goto L_0x0535
        L_0x03cb:
            byte[] r1 = r4.get_data()
            int r2 = r1.length
            r3 = r20
            r4 = 2
            int r5 = r3.get_tlv((byte[]) r1, (int) r4, (int) r2)
            if (r5 <= 0) goto L_0x03dc
            r0.show_alert_dialog(r3)
        L_0x03dc:
            int r3 = r8.get_tlv((byte[]) r1, (int) r4, (int) r2)
            if (r3 <= 0) goto L_0x03ef
            tencent.tls.request.req_global r3 = r0._g
            byte[] r5 = r8.get_time()
            byte[] r6 = r8.get_ipaddr()
            r3.set_time_ip(r5, r6)
        L_0x03ef:
            r12.get_tlv((byte[]) r1, (int) r4, (int) r2)
            r3 = r25
            r3.get_tlv((byte[]) r1, (int) r4, (int) r2)
            r7.get_tlv((byte[]) r1, (int) r4, (int) r2)
            r14.get_tlv((byte[]) r1, (int) r4, (int) r2)
            tencent.tls.tlvs.tlv_t r5 = new tencent.tls.tlvs.tlv_t
            r6 = 1283(0x503, float:1.798E-42)
            r5.<init>(r6)
            r5.get_tlv((byte[]) r1, (int) r4, (int) r2)
            r6 = r19
            int r8 = r6.get_tlv((byte[]) r1, (int) r4, (int) r2)
            if (r8 < 0) goto L_0x041e
            int r4 = r6.get_tk_pri()
            long r8 = (long) r4
            r19 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r8 = r8 & r19
            r33 = r8
            goto L_0x0420
        L_0x041e:
            r33 = r36
        L_0x0420:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "sdkAppid:"
            r4.append(r6)
            long r8 = r13._appid
            r4.append(r8)
            java.lang.String r6 = " tk_valid:"
            r4.append(r6)
            r8 = 2160000(0x20f580, double:1.067182E-317)
            r4.append(r8)
            java.lang.String r6 = " a2_valid:"
            r4.append(r6)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            tencent.tls.request.req_global r6 = r0._g
            long r8 = r6._uin
            tencent.tls.report.QLog.i(r4, r8)
            r4 = 0
            byte[] r6 = new byte[r4]
            byte[] r8 = new byte[r4]
            r4 = r18
            r9 = 2
            int r15 = r4.get_tlv((byte[]) r1, (int) r9, (int) r2)
            r18 = r6
            r6 = r16
            int r16 = r6.get_tlv((byte[]) r1, (int) r9, (int) r2)
            if (r16 < 0) goto L_0x0476
            if (r15 < 0) goto L_0x0476
            byte[] r4 = r4.get_data()
            byte[] r6 = r6.get_data()
            byte[] r4 = encrypt_a1(r6, r4)
            r29 = r4
            r4 = r17
            goto L_0x047a
        L_0x0476:
            r4 = r17
            r29 = r18
        L_0x047a:
            int r1 = r4.get_tlv((byte[]) r1, (int) r9, (int) r2)
            if (r1 < 0) goto L_0x0487
            byte[] r1 = r4.get_data()
            r30 = r1
            goto L_0x0489
        L_0x0487:
            r30 = r8
        L_0x0489:
            long r1 = tencent.tls.request.req_global.get_cur_time()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            tencent.tls.request.Ticket r6 = new tencent.tls.request.Ticket
            r16 = 64
            byte[] r17 = r12.get_data()
            byte[] r18 = r3.get_data()
            r8 = 2160000(0x20f580, double:1.067182E-317)
            long r8 = r8 + r1
            r15 = r6
            r19 = r1
            r21 = r8
            r15.<init>(r16, r17, r18, r19, r21)
            r4.add(r6)
            tencent.tls.request.Ticket r3 = new tencent.tls.request.Ticket
            r16 = 262144(0x40000, float:3.67342E-40)
            byte[] r17 = r7.get_data()
            byte[] r18 = r14.get_data()
            long r21 = r1 + r27
            r15 = r3
            r15.<init>(r16, r17, r18, r19, r21)
            r4.add(r3)
            tencent.tls.request.Ticket r3 = new tencent.tls.request.Ticket
            r16 = 268435456(0x10000000, float:2.5243549E-29)
            byte[] r17 = r5.get_data()
            r18 = 0
            r15 = r3
            r21 = r8
            r15.<init>(r16, r17, r18, r19, r21)
            r4.add(r3)
            tencent.tls.request.req_global r3 = r0._g
            long r5 = r3._uin
            int r7 = r13._login_bitmap
            r24 = r3
            r25 = r5
            r27 = r10
            r35 = r1
            r37 = r4
            r38 = r7
            int r4 = r24.put_siginfo(r25, r27, r29, r30, r31, r33, r35, r37, r38)
            if (r4 == 0) goto L_0x0534
            tencent.tls.platform.TLSErrInfo r1 = new tencent.tls.platform.TLSErrInfo
            r1.<init>()
            r1.ErrCode = r4
            tencent.tls.tools.I18nMsg$MSG_TYPE r2 = tencent.tls.tools.I18nMsg.MSG_TYPE.MSG_2
            java.lang.String r2 = tencent.tls.tools.I18nMsg.getMsg(r2)
            r1.Msg = r2
            r0.set_err_msg(r1)
            tencent.tls.request.req_global r1 = r0._g
            long r1 = r1._uin
            java.lang.String r3 = "put_siginfo fail,ret="
            tencent.tls.report.QLog.i(r3, r1)
            goto L_0x0535
        L_0x0509:
            r3 = 8
        L_0x050b:
            if (r4 != r3) goto L_0x0528
            int r3 = r0._pos
            int r3 = r3 - r6
            int r4 = r5.get_tlv((byte[]) r1, (int) r6, (int) r3)
            if (r4 >= 0) goto L_0x0517
            goto L_0x0535
        L_0x0517:
            long r3 = r5.getMsalt()
            r13._msalt = r3
            tencent.tls.request.req_global r3 = r0._g
            java.lang.String r4 = r3._userid
            tencent.tls.request.req_global r5 = r0._g
            long r7 = r5._uin
            r3.put_account(r4, r7)
        L_0x0528:
            int r3 = r0._pos
            int r3 = r3 - r6
            int r4 = r2.get_tlv((byte[]) r1, (int) r6, (int) r3)
            if (r4 >= 0) goto L_0x0532
            goto L_0x0535
        L_0x0532:
            r13._t104 = r2
        L_0x0534:
            r4 = 0
        L_0x0535:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ret:"
            r1.append(r2)
            if (r4 <= 0) goto L_0x0557
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L_0x055b
        L_0x0557:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
        L_0x055b:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            tencent.tls.request.req_global r2 = r0._g
            long r2 = r2._uin
            tencent.tls.report.QLog.i(r1, r2)
            tencent.tls.platform.TLSErrInfo r1 = r13._last_err_msg
            r1.ErrCode = r4
            if (r4 != 0) goto L_0x0578
            r1 = 0
            r0.set_err_msg(r1)
            tencent.tls.platform.TLSErrInfo r1 = r13._last_err_msg
            r2 = 0
            r1.ErrCode = r2
        L_0x0578:
            r1 = 10
            if (r4 == r1) goto L_0x0598
            r1 = 162(0xa2, float:2.27E-43)
            if (r4 == r1) goto L_0x0598
            r1 = 164(0xa4, float:2.3E-43)
            if (r4 == r1) goto L_0x0598
            r1 = 165(0xa5, float:2.31E-43)
            if (r4 == r1) goto L_0x0598
            r1 = 166(0xa6, float:2.33E-43)
            if (r4 == r1) goto L_0x0598
            r1 = 154(0x9a, float:2.16E-43)
            if (r4 == r1) goto L_0x0598
            r1 = 128(0x80, float:1.794E-43)
            if (r4 < r1) goto L_0x059a
            r1 = 143(0x8f, float:2.0E-43)
            if (r4 > r1) goto L_0x059a
        L_0x0598:
            r4 = -1000(0xfffffffffffffc18, float:NaN)
        L_0x059a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.request.oicq_request.get_response_body(byte[], int, int):int");
    }
}
