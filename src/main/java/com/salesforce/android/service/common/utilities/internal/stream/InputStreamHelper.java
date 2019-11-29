package com.salesforce.android.service.common.utilities.internal.stream;

import android.content.ContentResolver;
import android.net.Uri;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamHelper {
    public Async<InputStream> openContentUri(ContentResolver contentResolver, Uri uri) {
        BasicAsync create = BasicAsync.create();
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream != null) {
                create.setResult(new BufferedInputStream(openInputStream));
                return create;
            }
            throw new FileNotFoundException();
        } catch (FileNotFoundException e2) {
            create.setError((Throwable) e2);
        }
    }

    public int availableBytes(InputStream inputStream) {
        try {
            return inputStream.available();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void close(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void reset(InputStream inputStream) {
        try {
            inputStream.reset();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public byte[] convertToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
