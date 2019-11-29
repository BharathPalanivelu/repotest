package com.salesforce.android.service.common.http;

import java.nio.charset.Charset;
import okhttp3.MediaType;

public interface HttpMediaType {
    Charset charset();

    Charset charset(Charset charset);

    String subtype();

    MediaType toOkHttpMediaType();

    String type();
}
