package tencent.tls.tools;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class FileTracer implements Handler.Callback {
    private static final int MSG_FLUSH = 1024;
    private static String bufferA = "";
    private static String bufferB = "";
    private static FileTracer instance;
    private Context context;
    private Handler handler;
    private volatile boolean isFlushing = false;
    private HandlerThread thread;

    private FileTracer(Context context2) {
        this.context = context2;
        this.thread = new HandlerThread("FileTracer");
        HandlerThread handlerThread = this.thread;
        if (handlerThread != null) {
            handlerThread.start();
        }
        if (this.thread.isAlive()) {
            this.handler = new Handler(this.thread.getLooper(), this);
        }
        this.handler.sendEmptyMessage(1024);
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1024) {
            return true;
        }
        flushBuffer();
        prepareNextFlush();
        return true;
    }

    private void prepareNextFlush() {
        try {
            this.handler.sendEmptyMessageDelayed(1024, 1000);
        } catch (Throwable unused) {
        }
    }

    public void flush() {
        if (this.handler.hasMessages(1024)) {
            this.handler.removeMessages(1024);
        }
        this.handler.sendEmptyMessage(1024);
    }

    private void flushBuffer() {
        if (Thread.currentThread() == this.thread && !this.isFlushing) {
            this.isFlushing = true;
            writeFile();
            this.isFlushing = false;
        }
    }

    private void writeFile() {
        String str = bufferB;
        if (str != null && str.length() > 0) {
            bufferA = bufferB;
            bufferB = "";
            byte[] compress = util.compress(bufferA.getBytes());
            if (compress != null && compress.length != 0) {
                byte[] bArr = new byte[(compress.length + 4)];
                util.int32_to_buf(bArr, 0, compress.length);
                System.arraycopy(compress, 0, bArr, 4, compress.length);
                util.writeFile(util.getLogFileName(this.context, util.getCurrentDay()), bArr);
            }
        }
    }

    public static void writeLog(Context context2, String str, String str2) {
        if (context2 != null && str2 != null) {
            if (instance == null) {
                instance = new FileTracer(context2);
            }
            synchronized (bufferB) {
                if (bufferB.length() > 4096) {
                    bufferB = "";
                }
                bufferB += util.getDate() + util.getThreadId() + util.getLineInfo(3) + util.getSdkVersion() + util.getUser(str) + str2 + "\n";
            }
        }
    }
}
