package com.tencent.qcloud.core.http;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import java.util.HashMap;
import java.util.Map;

public final class MimeType {
    private static final Map<String, String> mimeTypes = new HashMap();

    static {
        mimeTypes.put("bin", COSRequestHeaderKey.APPLICATION_OCTET_STREAM);
        mimeTypes.put("bmp", "image/bmp");
        mimeTypes.put("cgm", "image/cgm");
        mimeTypes.put("djv", "image/vnd.djvu");
        mimeTypes.put("djvu", "image/vnd.djvu");
        mimeTypes.put("gif", "image/gif");
        mimeTypes.put("ico", "image/x-icon");
        mimeTypes.put("ief", "image/ief");
        mimeTypes.put("jp2", "image/jp2");
        mimeTypes.put("jpe", "image/jpeg");
        mimeTypes.put("jpeg", "image/jpeg");
        mimeTypes.put("jpg", "image/jpeg");
        mimeTypes.put("mac", "image/x-macpaint");
        mimeTypes.put("pbm", "image/x-portable-bitmap");
        mimeTypes.put("pct", "image/pict");
        mimeTypes.put("pgm", "image/x-portable-graymap");
        mimeTypes.put("pic", "image/pict");
        mimeTypes.put("pict", "image/pict");
        mimeTypes.put("png", "image/png");
        mimeTypes.put("pnm", "image/x-portable-anymap");
        mimeTypes.put("pnt", "image/x-macpaint");
        mimeTypes.put("pntg", "image/x-macpaint");
        mimeTypes.put("ppm", "image/x-portable-pixmap");
        mimeTypes.put("qti", "image/x-quicktime");
        mimeTypes.put("qtif", "image/x-quicktime");
        mimeTypes.put("ras", "image/x-cmu-raster");
        mimeTypes.put("rgb", "image/x-rgb");
        mimeTypes.put("svg", "image/svg+xml");
        mimeTypes.put("tif", "image/tiff");
        mimeTypes.put("tiff", "image/tiff");
        mimeTypes.put("wbmp", "image/vnd.wap.wbmp");
        mimeTypes.put("xbm", "image/x-xbitmap");
        mimeTypes.put("xpm", "image/x-xpixmap");
        mimeTypes.put("xwd", "image/x-xwindowdump");
    }

    public static String getTypeByFileName(String str) {
        if (str == null) {
            return null;
        }
        String str2 = mimeTypes.get((str.lastIndexOf(".") != -1 ? str.substring(str.lastIndexOf(".") + 1, str.length()) : "").toLowerCase());
        return str2 == null ? mimeTypes.get("bin") : str2;
    }
}
