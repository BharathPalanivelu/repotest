package com.tencent.cos.xml.utils;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public static String tempCache(InputStream inputStream) throws CosXmlClientException {
        FileOutputStream fileOutputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            String str = CosXmlSimpleService.appCachePath + File.separator + "temp.tmp";
            Log.d("UnitTest", str);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
                while (true) {
                    int read = inputStream.read(bArr, 0, bArr.length);
                    if (read > 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        fileOutputStream2.flush();
                        CloseUtil.closeQuietly(fileOutputStream2);
                        CloseUtil.closeQuietly(inputStream);
                        return str;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    throw new CosXmlClientException((Throwable) e);
                } catch (Throwable th) {
                    th = th;
                    CloseUtil.closeQuietly(fileOutputStream);
                    CloseUtil.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                CloseUtil.closeQuietly(fileOutputStream);
                CloseUtil.closeQuietly(inputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw new CosXmlClientException((Throwable) e);
        }
    }
}
