package cn.tongdun.android.core.x0ox00x0oooo0xxx;

import android.text.TextUtils;
import cn.tongdun.android.core.oo0ooo0o00o0xo.oxxx0x0ooooxxooooo000;
import cn.tongdun.android.shell.utils.BoxUtil;
import cn.tongdun.android.shell.utils.LogUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class o00xxox0x0xoox {
    static final HostnameVerifier o00xxox0x0xoox = new oo0ooo0o00o0xo();

    private static void o00xxox0x0xoox(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(o00xxox0x0xoox("5165427f5374492d30003915", 97), str);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoOutput(true);
    }

    private static String o00xxox0x0xoox(URL url, byte[] bArr, String str, int i) throws Exception {
        HttpsURLConnection httpsURLConnection;
        if (url.getProtocol().toLowerCase().equals(o00xxox0x0xoox("7a1368176b", 39))) {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection(Proxy.NO_PROXY)));
            if (i == 1) {
                o00xxox0x0xoox(httpsURLConnection2);
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = httpsURLConnection2;
                if (i == 2) {
                    httpsURLConnection2.setHostnameVerifier(o00xxox0x0xoox);
                    httpsURLConnection = httpsURLConnection2;
                }
            }
        } else {
            httpsURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection(Proxy.NO_PROXY)));
        }
        o00xxox0x0xoox(httpsURLConnection, str);
        BoxUtil.getdata(httpsURLConnection, bArr);
        httpsURLConnection.setRequestMethod(o00xxox0x0xoox("421e4c19", 41));
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode != 200) {
            String str2 = o00xxox0x0xoox("5157425749515e05180210071906510a031d151e0a1f1709524a5e415f04", 83) + responseCode;
            LogUtil.err(str2);
            return str2;
        }
        try {
            Map headerFields = httpsURLConnection.getHeaderFields();
            if (headerFields != null) {
                List list = (List) headerFields.get(o00xxox0x0xoox("416a42332c1f2c1b2e17", 116));
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str3 = (String) list.get(i2);
                        if (str3.contains(o00xxox0x0xoox("4a0b490630", 35))) {
                            String[] split = str3.split(o00xxox0x0xoox("29", 102));
                            int length = split.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                String str4 = split[i3];
                                if (str4.startsWith(o00xxox0x0xoox("4a484945", 96))) {
                                    String substring = str4.substring(5, str4.length());
                                    if (!TextUtils.isEmpty(substring)) {
                                        oxxx0x0ooooxxooooo000.o00xxox0x0xoox().o00xxox0x0xoox(substring);
                                        break;
                                    }
                                }
                                i3++;
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        InputStream inputStream = httpsURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, o00xxox0x0xoox("6720676b72", 9)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                inputStream.close();
                outputStream.close();
                return sb.toString();
            }
        }
    }

    public static String o00xxox0x0xoox(String str, Map map, byte[] bArr, int i) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null) {
                sb.append((String) entry.getKey());
                sb.append(o00xxox0x0xoox("2f", 8));
                sb.append(URLEncoder.encode((String) entry.getValue(), o00xxox0x0xoox("670e674572", 39)));
                sb.append(o00xxox0x0xoox("34", 101));
            }
        }
        if (!map.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return o00xxox0x0xoox(new URL(str + o00xxox0x0xoox("2d", 16) + sb.toString()), bArr, o00xxox0x0xoox("7336612a642066357b337a723a7e2d6f3c3662316426602a", 15), i);
    }

    public static String o00xxox0x0xoox(String str, Map map) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null) {
                sb.append((String) entry.getKey());
                sb.append(o00xxox0x0xoox("2f", 98));
                sb.append(URLEncoder.encode((String) entry.getValue(), o00xxox0x0xoox("6709674272", 32)));
                sb.append(o00xxox0x0xoox("34", 17));
            }
        }
        if (!map.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return str + o00xxox0x0xoox("2d", 34) + sb.toString();
    }

    public static void o00xxox0x0xoox(HttpsURLConnection httpsURLConnection) {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            o00xx0xx0ooooo0xx00 o00xx0xx0ooooo0xx00 = new o00xx0xx0ooooo0xx00();
            SSLContext instance = SSLContext.getInstance(o00xxox0x0xoox("46474b", 119));
            instance.init((KeyManager[]) null, new TrustManager[]{o00xx0xx0ooooo0xx00}, (SecureRandom) null);
            sSLSocketFactory = instance.getSocketFactory();
        } catch (Exception unused) {
        }
        if (sSLSocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(new x0000xo0x0oooooo0());
            return;
        }
        throw new IllegalArgumentException(o00xxox0x0xoox("f713f66da86c616c7e53425f4a515b637c616b7a7671ea30ff69a378e92bd94f9e57cf12ec74954e", 86));
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 40);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 18);
            byte b3 = bArr[0];
            int i4 = 1;
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
