package com.tencent.imsdk;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.imcore.EnvRequestClosure;
import com.tencent.imcore.HttpMethod;
import com.tencent.imcore.IEnv;
import com.tencent.imcore.RunClosure;
import com.tencent.imcore.ThreadEntry;
import com.tencent.imcore.UploadLogFileOpt;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class IMCoreAndroidEnv extends IEnv {
    static IMCoreAndroidEnv inst = new IMCoreAndroidEnv();
    /* access modifiers changed from: private */
    public static String logTag = "IMCoreAndroidEnv";
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    private IMCoreAndroidEnv() {
    }

    public static IMCoreAndroidEnv get() {
        return inst;
    }

    public boolean createThread(ThreadEntry threadEntry) {
        new Thread(new ad(this, threadEntry)).start();
        return true;
    }

    public boolean httpRequest(String str, HttpMethod httpMethod, String str2, byte[] bArr, EnvRequestClosure envRequestClosure) {
        try {
            new Thread(new ab(this, httpMethod, (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str2).openConnection())), bArr, envRequestClosure)).start();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean runOnMainThread(RunClosure runClosure) {
        return this.mainHandler.post(new ae(this, runClosure));
    }

    public boolean runOnMainThread(Runnable runnable) {
        return this.mainHandler.post(runnable);
    }

    public boolean sSORequest(String str, String str2, byte[] bArr, EnvRequestClosure envRequestClosure) {
        return sSORequest(str, str2, bArr, envRequestClosure, IMMsfCoreProxy.get().getReqTimeout());
    }

    public boolean sSORequest(String str, String str2, byte[] bArr, EnvRequestClosure envRequestClosure, long j) {
        IMMsfCoreProxy.get().request(str, str2, bArr, envRequestClosure != null ? new ac(this, envRequestClosure, str) : null, j);
        return envRequestClosure != null;
    }

    public boolean uploadLogFile(String str, UploadLogFileOpt uploadLogFileOpt) {
        return IMMsfCoreProxy.get().uploadLogFile(str, IMCoreUploadLogFileOpt.convertFrom(uploadLogFileOpt));
    }
}
