package com.google.android.gms.internal.firebase_remote_config;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

public final class zzan extends zzp {
    private Object data;

    public zzan(Object obj) {
        super(zzam.MEDIA_TYPE);
        this.data = zzdt.checkNotNull(obj);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, zzo()));
        boolean z = true;
        for (Map.Entry next : zzbt.zzf(this.data).entrySet()) {
            Object value = next.getValue();
            if (value != null) {
                String zzah = zzcs.zzah((String) next.getKey());
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    for (Object zza : zzco.zzi(value)) {
                        z = zza(z, bufferedWriter, zzah, zza);
                    }
                } else {
                    z = zza(z, bufferedWriter, zzah, value);
                }
            }
        }
        bufferedWriter.flush();
    }

    private static boolean zza(boolean z, Writer writer, String str, Object obj) throws IOException {
        if (obj != null && !zzbt.isNull(obj)) {
            if (z) {
                z = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            String zzah = zzcs.zzah(obj instanceof Enum ? zzbz.zza((Enum<?>) (Enum) obj).getName() : obj.toString());
            if (zzah.length() != 0) {
                writer.write(SimpleComparison.EQUAL_TO_OPERATION);
                writer.write(zzah);
            }
        }
        return z;
    }
}
