package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.okhttp.ProgressObservingSink;
import e.d;
import e.n;
import e.u;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

abstract class ObservableRequestBody extends RequestBody {
    private ProgressObservingSink.Listener mListener;

    public abstract void writeToSink(d dVar) throws IOException;

    ObservableRequestBody() {
    }

    public void setListener(ProgressObservingSink.Listener listener) {
        this.mListener = listener;
    }

    public void writeTo(d dVar) throws IOException {
        ProgressObservingSink.Listener listener = this.mListener;
        if (listener == null) {
            writeToSink(dVar);
            return;
        }
        d a2 = n.a((u) new ProgressObservingSink(dVar, listener));
        writeToSink(a2);
        a2.flush();
    }

    public static ObservableRequestBody wrap(final RequestBody requestBody) {
        return new ObservableRequestBody() {
            public MediaType contentType() {
                return requestBody.contentType();
            }

            public long contentLength() throws IOException {
                return requestBody.contentLength();
            }

            public void writeToSink(d dVar) throws IOException {
                requestBody.writeTo(dVar);
            }
        };
    }
}
