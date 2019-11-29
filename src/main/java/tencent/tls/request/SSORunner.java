package tencent.tls.request;

import com.facebook.appevents.AppEventsConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.report.QLog;
import tencent.tls.tools.util;

public class SSORunner implements Runnable {
    /* access modifiers changed from: private */
    public final Object __sync = new Object();
    /* access modifiers changed from: private */
    public boolean isDataSent = false;
    private byte[] reqData;
    /* access modifiers changed from: private */
    public byte[] resData = null;
    /* access modifiers changed from: private */
    public int ret;
    private String serviceCmd;
    private int timeout;

    public SSORunner(String str, byte[] bArr, int i) {
        this.serviceCmd = str == null ? "" : str;
        this.reqData = bArr == null ? new byte[0] : bArr;
        this.timeout = i <= 0 ? 10000 : i;
    }

    public int getRet() {
        return this.ret;
    }

    public byte[] getResData() {
        return this.resData;
    }

    public void run() {
        this.ret = 0;
        char c2 = 3;
        char c3 = 2;
        try {
            Class<?> cls = Class.forName("com.tencent.qalsdk.QALSDKManager");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            Class<?> cls2 = Class.forName("com.tencent.qalsdk.QALConnListener");
            cls.getMethod("setConnectionListener", new Class[]{cls2}).invoke(invoke, new Object[]{Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new ProxyListener())});
            Class<?> cls3 = Class.forName("com.tencent.qalsdk.QALValueCallBack");
            Object newProxyInstance = Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new ProxyListener());
            Method method = cls.getMethod("sendMsg", new Class[]{String.class, String.class, byte[].class, Long.TYPE, cls3});
            QLog.i("SSORunner serviceCmd=" + this.serviceCmd + " reqData.length=" + this.reqData.length + " timeout=" + this.timeout);
            int i = util.connRetryTimes;
            while (i > 0) {
                Object[] objArr = new Object[5];
                objArr[0] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                objArr[1] = this.serviceCmd;
                objArr[c3] = this.reqData;
                objArr[c2] = Integer.valueOf(this.timeout);
                objArr[4] = newProxyInstance;
                method.invoke(invoke, objArr);
                synchronized (this.__sync) {
                    QLog.i("timeout " + this.timeout + " before wait");
                    this.__sync.wait((long) (this.timeout + 500));
                    QLog.i("timeout " + this.timeout + " or notified");
                }
                if (true != this.isDataSent) {
                    i--;
                    c2 = 3;
                    c3 = 2;
                } else {
                    return;
                }
            }
        } catch (Exception unused) {
            try {
                Class<?> cls4 = Class.forName("com.tencent.timint.TIMIntManager");
                Object invoke2 = cls4.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
                Class<?> cls5 = Class.forName("com.tencent.TIMValueCallBack");
                Object newProxyInstance2 = Proxy.newProxyInstance(cls5.getClassLoader(), new Class[]{cls5}, new ProxyListener());
                Method method2 = cls4.getMethod("request", new Class[]{String.class, byte[].class, cls5, Long.TYPE});
                int i2 = util.connRetryTimes;
                while (i2 > 0) {
                    method2.invoke(invoke2, new Object[]{this.serviceCmd, this.reqData, newProxyInstance2, Integer.valueOf(this.timeout)});
                    synchronized (this.__sync) {
                        this.__sync.wait((long) (this.timeout + 500));
                        if (true != this.isDataSent) {
                            i2--;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                QLog.e(e2);
                this.ret = TLSErrInfo.TIMEOUT;
            }
        }
    }

    class ProxyListener implements InvocationHandler {
        ProxyListener() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            QLog.i("proxy " + name);
            boolean z = false;
            if (name.equals("onSuccess")) {
                onSuccess(objArr[0]);
            } else if (name.equals("onError")) {
                onError(objArr[0].intValue(), objArr[1]);
            } else if ("equals".equals(name)) {
                if (obj == objArr[0]) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if ("hashCode".equals(name)) {
                return Integer.valueOf(System.identityHashCode(obj));
            } else {
                if ("toString".equals(name)) {
                    return obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj)) + ", with InvocationHandler " + this;
                } else if ("onConnected".equals(name)) {
                    onConnected();
                } else if (!"onDisconnected".equals(name)) {
                    "onWifiNeedAuth".equals(name);
                }
            }
            return obj;
        }

        /* access modifiers changed from: package-private */
        public void onSuccess(byte[] bArr) {
            byte[] unused = SSORunner.this.resData = bArr;
            boolean unused2 = SSORunner.this.isDataSent = true;
            synchronized (SSORunner.this.__sync) {
                SSORunner.this.__sync.notify();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(int i, String str) {
            QLog.i("sso err " + i + " errmsg " + str);
            byte[] unused = SSORunner.this.resData = null;
            int unused2 = SSORunner.this.ret = i;
            synchronized (SSORunner.this.__sync) {
                SSORunner.this.__sync.notify();
            }
        }

        /* access modifiers changed from: package-private */
        public void onConnected() {
            QLog.i("qal connected");
            synchronized (SSORunner.this.__sync) {
                SSORunner.this.__sync.notify();
            }
        }
    }
}
