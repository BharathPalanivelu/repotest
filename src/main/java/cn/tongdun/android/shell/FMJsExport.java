package cn.tongdun.android.shell;

import android.content.Context;
import android.webkit.JavascriptInterface;
import cn.tongdun.android.shell.utils.LogUtil;
import java.util.HashMap;

public class FMJsExport {
    private static final int version = 312;
    Context mContext;

    public FMJsExport(Context context) {
        this.mContext = context;
    }

    @JavascriptInterface
    public void init(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(linkxxxxx("667e65797e7b4c514b4f", 36), str);
        FMAgent.initWithOptions(this.mContext, FMAgent.ENV_PRODUCTION, hashMap);
        LogUtil.info(linkxxxxx("4f075d106f207e3b673f3376346e2d6a232f6a286d3539663f703f762976", 96));
    }

    @JavascriptInterface
    public String onEvent() {
        String onEvent = FMAgent.onEvent(this.mContext);
        LogUtil.info(linkxxxxx("4f225d356f057e1e671a3353344b2d4f230a6c0b473854334e671d610b610d770d", 69));
        return onEvent;
    }

    public static String linkxxxxx(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 76);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 5);
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
