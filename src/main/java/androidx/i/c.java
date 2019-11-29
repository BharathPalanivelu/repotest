package androidx.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;
import com.tencent.imsdk.TIMGroupManager;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class c implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final File f2355a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2356b;

    /* renamed from: c  reason: collision with root package name */
    private final File f2357c;

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f2358d;

    /* renamed from: e  reason: collision with root package name */
    private final FileChannel f2359e;

    /* renamed from: f  reason: collision with root package name */
    private final FileLock f2360f;

    private static class a extends File {
        public long crc = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    c(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + SQLBuilder.PARENTHESES_RIGHT);
        this.f2355a = file;
        this.f2357c = file2;
        this.f2356b = b(file);
        File file3 = new File(file2, "MultiDex.lock");
        this.f2358d = new RandomAccessFile(file3, "rw");
        try {
            this.f2359e = this.f2358d.getChannel();
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f2360f = this.f2359e.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                a((Closeable) this.f2359e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                a((Closeable) this.f2359e);
                throw e;
            } catch (Error e4) {
                e = e4;
                a((Closeable) this.f2359e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            a((Closeable) this.f2358d);
            throw e5;
        }
    }

    /* access modifiers changed from: package-private */
    public List<? extends File> a(Context context, String str, boolean z) throws IOException {
        List<a> list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f2355a.getPath() + ", " + z + ", " + str + SQLBuilder.PARENTHESES_RIGHT);
        if (this.f2360f.isValid()) {
            if (z || a(context, this.f2355a, this.f2356b, str)) {
                if (z) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                list = a();
                a(context, str, a(this.f2355a), this.f2356b, list);
            } else {
                try {
                    list = a(context, str);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                    list = a();
                    a(context, str, a(this.f2355a), this.f2356b, list);
                }
            }
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() throws IOException {
        this.f2360f.release();
        this.f2359e.close();
        this.f2358d.close();
    }

    private List<a> a(Context context, String str) throws IOException {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        String str3 = this.f2355a.getName() + ".classes";
        SharedPreferences a2 = a(context);
        int i = a2.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            a aVar = new a(this.f2357c, str3 + i2 + ".zip");
            if (aVar.isFile()) {
                aVar.crc = b(aVar);
                long j = a2.getLong(str2 + "dex.crc." + i2, -1);
                long j2 = a2.getLong(str2 + "dex.time." + i2, -1);
                long lastModified = aVar.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = a2;
                    if (j == aVar.crc) {
                        arrayList.add(aVar);
                        i2++;
                        a2 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + aVar.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + aVar.getPath() + "'");
        }
        return arrayList;
    }

    private static boolean a(Context context, File file, long j, String str) {
        SharedPreferences a2 = a(context);
        if (a2.getLong(str + "timestamp", -1) == a(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("crc");
            return a2.getLong(sb.toString(), -1) != j;
        }
    }

    private static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long b(File file) throws IOException {
        long a2 = d.a(file);
        return a2 == -1 ? a2 - 1 : a2;
    }

    private List<a> a() throws IOException {
        a aVar;
        boolean z;
        String str = this.f2355a.getName() + ".classes";
        b();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f2355a);
        try {
            ZipEntry entry = zipFile.getEntry("classes" + 2 + ".dex");
            int i = 2;
            while (entry != null) {
                aVar = new a(this.f2357c, str + i + ".zip");
                arrayList.add(aVar);
                Log.i("MultiDex", "Extraction is needed for file " + aVar);
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    a(zipFile, entry, (File) aVar, str);
                    aVar.crc = b(aVar);
                    z = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : ChatFileTransferEvent.FAILED);
                    sb.append(" '");
                    sb.append(aVar.getAbsolutePath());
                    sb.append("': length ");
                    int i4 = i3;
                    sb.append(aVar.length());
                    sb.append(" - crc: ");
                    sb.append(aVar.crc);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        aVar.delete();
                        if (aVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + aVar.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i2 = i4;
                }
                if (z2) {
                    i++;
                    entry = zipFile.getEntry("classes" + i + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i + SQLBuilder.PARENTHESES_RIGHT);
                }
            }
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
            return arrayList;
        } catch (IOException e3) {
            Log.w("MultiDex", "Failed to read crc from " + aVar.getAbsolutePath(), e3);
            z = false;
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                zipFile.close();
            } catch (IOException e4) {
                Log.w("MultiDex", "Failed to close resource", e4);
            }
            throw th2;
        }
    }

    private static void a(Context context, String str, long j, long j2, List<a> list) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (a next : list) {
            edit.putLong(str + "dex.crc." + i, next.crc);
            edit.putLong(str + "dex.time." + i, next.lastModified());
            i++;
        }
        edit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private void b() {
        File[] listFiles = this.f2357c.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f2357c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            } else {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    a((Closeable) inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            a((Closeable) inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }
}
