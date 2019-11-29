package org.b.a;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.b.a.c;
import org.b.a.d;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f33865a;

    /* renamed from: b  reason: collision with root package name */
    private File f33866b;

    /* renamed from: c  reason: collision with root package name */
    private String f33867c = "sh cat";

    /* renamed from: d  reason: collision with root package name */
    private Process f33868d;

    public b(Context context, File file) throws FileNotFoundException, IOException {
        this.f33866b = file;
        a(context, false);
    }

    public void a(Context context, boolean z) {
        this.f33865a = a(context, c.a.ffmpeg, "ffmpeg", z);
    }

    public String a() {
        return this.f33865a;
    }

    public Process b() {
        return this.f33868d;
    }

    private static String a(Context context, int i, String str, boolean z) {
        try {
            File file = new File(context.getDir("bin", 0), str);
            if (file.exists()) {
                file.delete();
            }
            a(context, i, file, "0755");
            return file.getCanonicalPath();
        } catch (Exception e2) {
            Log.e("FFMPEG", "installBinary failed: " + e2.getLocalizedMessage());
            return null;
        }
    }

    private static void a(Context context, int i, File file, String str) throws IOException, InterruptedException {
        String absolutePath = file.getAbsolutePath();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputStream openRawResource = context.getResources().openRawResource(i);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = openRawResource.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                openRawResource.close();
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod " + str + SQLBuilder.BLANK + absolutePath).waitFor();
                return;
            }
        }
    }

    private void a(List<String> list, d.a aVar, File file) throws IOException, InterruptedException {
        c();
        b(list, aVar, file);
    }

    private void c() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("chmod 700 " + this.f33865a);
    }

    public void a(List<String> list, d.a aVar) throws IOException, InterruptedException {
        a(list, aVar, new File(this.f33865a).getParentFile());
    }

    private int b(List<String> list, d.a aVar, File file) throws IOException, InterruptedException {
        for (String str : list) {
            String.format(Locale.US, "%s", new Object[]{str});
        }
        ProcessBuilder processBuilder = new ProcessBuilder(list);
        processBuilder.directory(file);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : list) {
            stringBuffer.append(append);
            stringBuffer.append(' ');
        }
        Log.d("FFMPEG", stringBuffer.toString());
        aVar.shellOut(stringBuffer.toString());
        Process start = processBuilder.start();
        this.f33868d = start;
        a aVar2 = new a(start.getErrorStream(), "ERROR", aVar);
        a aVar3 = new a(start.getInputStream(), "OUTPUT", aVar);
        aVar2.start();
        aVar3.start();
        int waitFor = start.waitFor();
        aVar.processComplete(waitFor);
        this.f33868d = null;
        return waitFor;
    }

    public a a(a aVar, boolean z, String str, d.a aVar2) throws Exception {
        new ArrayList();
        a aVar3 = new a();
        String str2 = aVar.f33860g;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f33865a);
        arrayList.add("-y");
        arrayList.add("-noautorotate");
        if (aVar.h != null) {
            arrayList.add("-ss");
            arrayList.add(aVar.h);
        }
        arrayList.add("-i");
        arrayList.add(str2);
        if (aVar.i != -1.0d) {
            arrayList.add("-t");
            arrayList.add(String.format(Locale.US, "%f", new Object[]{Double.valueOf(aVar.i)}));
        }
        if (!z) {
            arrayList.add("-an");
        }
        arrayList.add("-async");
        arrayList.add("1");
        arrayList.add("-vf");
        arrayList.add("scale=" + aVar.f33854a + ":" + aVar.f33855b);
        arrayList.add("-sws_flags");
        arrayList.add("fast_bilinear");
        arrayList.add("-acodec");
        arrayList.add("copy");
        arrayList.add("-vcodec");
        arrayList.add("libx264");
        arrayList.add("-crf");
        arrayList.add(String.valueOf(aVar.l));
        arrayList.add("-r");
        arrayList.add(String.valueOf(aVar.m));
        arrayList.add("-threads");
        arrayList.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        arrayList.add("-preset");
        arrayList.add(aVar.n);
        arrayList.add("-strict");
        arrayList.add("-2");
        aVar3.f33860g = str;
        arrayList.add(aVar3.f33860g);
        a((List<String>) arrayList, aVar2);
        return aVar3;
    }

    private static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f33869a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33870b;

        /* renamed from: c  reason: collision with root package name */
        private final d.a f33871c;

        a(InputStream inputStream, String str, d.a aVar) {
            this.f33869a = inputStream;
            this.f33870b = str;
            this.f33871c = aVar;
        }

        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f33869a));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return;
                    }
                    if (this.f33871c != null) {
                        this.f33871c.shellOut(readLine);
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
