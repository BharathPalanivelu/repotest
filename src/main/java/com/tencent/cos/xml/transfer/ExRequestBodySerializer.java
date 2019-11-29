package com.tencent.cos.xml.transfer;

import com.facebook.common.util.UriUtil;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.RequestBody;

public class ExRequestBodySerializer extends RequestBodySerializer {
    RequestBody body;

    public ExRequestBodySerializer(RequestBody requestBody) {
        this.body = requestBody;
    }

    public RequestBody body() {
        return this.body;
    }

    public static ExRequestBodySerializer multipart(Map<String, String> map, File file, long j, long j2) {
        MultipartRequestBody multipartRequestBody = new MultipartRequestBody();
        multipartRequestBody.setParameters(map);
        multipartRequestBody.setContent((String) null, UriUtil.LOCAL_FILE_SCHEME, file.getName(), file, j, j2);
        multipartRequestBody.build();
        return new ExRequestBodySerializer(multipartRequestBody);
    }

    public static ExRequestBodySerializer multipart(Map<String, String> map, String str, byte[] bArr, long j, long j2) {
        MultipartRequestBody multipartRequestBody = new MultipartRequestBody();
        Map<String, String> map2 = map;
        multipartRequestBody.setParameters(map);
        multipartRequestBody.setContent((String) null, UriUtil.LOCAL_FILE_SCHEME, str, bArr, j, j2);
        multipartRequestBody.build();
        return new ExRequestBodySerializer(multipartRequestBody);
    }

    public static ExRequestBodySerializer multipart(Map<String, String> map, File file, InputStream inputStream, long j, long j2) throws IOException {
        MultipartRequestBody multipartRequestBody = new MultipartRequestBody();
        Map<String, String> map2 = map;
        multipartRequestBody.setParameters(map);
        multipartRequestBody.setContent((String) null, UriUtil.LOCAL_FILE_SCHEME, file.getName(), file, inputStream, j, j2);
        multipartRequestBody.build();
        return new ExRequestBodySerializer(multipartRequestBody);
    }
}
