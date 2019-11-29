package com.c.a.c.c;

import android.util.Log;
import com.c.a.c.d;
import com.c.a.c.j;
import com.c.a.i.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c implements d<ByteBuffer> {
    public boolean a(ByteBuffer byteBuffer, File file, j jVar) {
        try {
            a.a(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}
