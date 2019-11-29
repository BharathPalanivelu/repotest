package com.tencent.cos.xml.utils;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
    public static void closeQuietly(Closeable closeable) throws CosXmlClientException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                throw new CosXmlClientException((Throwable) e2);
            }
        }
    }
}
