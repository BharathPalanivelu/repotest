package com.c.a.c.d.e;

import android.util.Log;
import com.c.a.c.b.s;
import com.c.a.c.c;
import com.c.a.c.j;
import com.c.a.c.l;
import com.c.a.i.a;
import java.io.File;
import java.io.IOException;

public class d implements l<c> {
    public c a(j jVar) {
        return c.SOURCE;
    }

    public boolean a(s<c> sVar, File file, j jVar) {
        try {
            a.a(sVar.c().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
