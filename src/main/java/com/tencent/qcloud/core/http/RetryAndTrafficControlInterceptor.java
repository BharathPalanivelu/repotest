package com.tencent.qcloud.core.http;

import com.tencent.qalsdk.im_open.http;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.RetryStrategy;
import com.tencent.qcloud.core.task.TaskManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

class RetryAndTrafficControlInterceptor implements Interceptor {
    private TrafficStrategy downloadTrafficStrategy = new AggressiveTrafficStrategy("DownloadStrategy-", 3);
    private RetryStrategy retryStrategy;
    private TrafficStrategy uploadTrafficStrategy = new ModerateTrafficStrategy("UploadStrategy-", 2);

    private boolean isRecoverable(int i) {
        return (i == 401 || i == 404) ? false : true;
    }

    private static class ResizableSemaphore extends Semaphore {
        ResizableSemaphore(int i, boolean z) {
            super(i, z);
        }

        /* access modifiers changed from: protected */
        public void reducePermits(int i) {
            super.reducePermits(i);
        }
    }

    private static abstract class TrafficStrategy {
        static final int MIN_FAST_SPEED = 300;
        static final int MIN_TIMEOUT_COUNT = 2;
        private AtomicInteger concurrent;
        private ResizableSemaphore controller;
        private int current = 0;
        private AtomicInteger historyConsecutiveTimeoutError = new AtomicInteger(0);
        private final int[] historySpeed = new int[5];
        private final int maxConcurrent;
        private final String name;

        TrafficStrategy(String str, int i, int i2) {
            this.name = str;
            this.maxConcurrent = i2;
            this.controller = new ResizableSemaphore(i, true);
            this.concurrent = new AtomicInteger(i);
            QCloudLogger.d("QCloudHttp", str + " init concurrent is " + i, new Object[0]);
        }

        /* access modifiers changed from: package-private */
        public void reportException(Request request, IOException iOException) {
            this.controller.release();
        }

        /* access modifiers changed from: package-private */
        public void reportTimeOut(Request request) {
            if (this.historyConsecutiveTimeoutError.get() < 0) {
                this.historyConsecutiveTimeoutError.set(1);
            } else {
                this.historyConsecutiveTimeoutError.incrementAndGet();
            }
            if (this.historyConsecutiveTimeoutError.get() >= 2) {
                adjustConcurrentAndRelease(1);
            } else {
                this.controller.release();
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void reportSpeed(Request request, double d2) {
            this.historyConsecutiveTimeoutError.decrementAndGet();
            if (d2 > 0.0d) {
                QCloudLogger.d("QCloudHttp", this.name + " %s streaming speed is %1.3f KBps", request, Double.valueOf(d2));
                int updateAverageSpeed = updateAverageSpeed(d2);
                int i = this.concurrent.get();
                int i2 = i + 1;
                if (updateAverageSpeed <= i2 * 300 || i >= this.maxConcurrent) {
                    if (updateAverageSpeed > 0) {
                        int i3 = i - 1;
                        if (updateAverageSpeed < i3 * 300 && i > 1) {
                            adjustConcurrentAndRelease(i3);
                        }
                    }
                    this.controller.release();
                } else {
                    adjustConcurrentAndRelease(i2);
                }
            } else {
                this.controller.release();
            }
        }

        /* access modifiers changed from: package-private */
        public void waitForPermit() {
            try {
                this.controller.acquire();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        private int updateAverageSpeed(double d2) {
            int i;
            synchronized (this.historySpeed) {
                this.historySpeed[this.current] = (int) Math.floor(d2);
                boolean z = true;
                this.current = (this.current + 1) % this.historySpeed.length;
                int[] iArr = this.historySpeed;
                int length = iArr.length;
                i = 0;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    int i4 = iArr[i2];
                    if (i4 == 0) {
                        break;
                    }
                    i3 += i4;
                    i2++;
                }
                if (!z) {
                    i = i3 / this.historySpeed.length;
                }
            }
            return i;
        }

        private void clearAverageSpeed() {
            synchronized (this.historySpeed) {
                for (int i = 0; i < this.historySpeed.length; i++) {
                    this.historySpeed[i] = 0;
                }
            }
        }

        private synchronized void adjustConcurrentAndRelease(int i) {
            int i2 = i - this.concurrent.get();
            if (i2 == 0) {
                this.controller.release();
            } else {
                this.concurrent.set(i);
                if (i2 > 0) {
                    this.controller.release(i2 + 1);
                    clearAverageSpeed();
                } else {
                    this.controller.reducePermits(i2 * -1);
                    this.controller.release();
                    clearAverageSpeed();
                }
                QCloudLogger.i("QCloudHttp", this.name + " adjust concurrent to " + i, new Object[0]);
            }
        }
    }

    private static class AggressiveTrafficStrategy extends TrafficStrategy {
        AggressiveTrafficStrategy(String str, int i) {
            super(str, i, i);
        }
    }

    private static class ModerateTrafficStrategy extends TrafficStrategy {
        ModerateTrafficStrategy(String str, int i) {
            super(str, 1, i);
        }
    }

    RetryAndTrafficControlInterceptor(RetryStrategy retryStrategy2) {
        this.retryStrategy = retryStrategy2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        return processRequest(chain, request, (HttpTask) TaskManager.getInstance().get((String) request.tag()));
    }

    /* access modifiers changed from: package-private */
    public Response processRequest(Interceptor.Chain chain, Request request, HttpTask httpTask) throws IOException {
        Request request2 = request;
        HttpTask httpTask2 = httpTask;
        if (httpTask2 == null || httpTask.isCanceled()) {
            throw new IOException("CANCELED");
        }
        long currentTimeMillis = System.currentTimeMillis();
        TrafficStrategy suitableStrategy = getSuitableStrategy(httpTask2);
        int i = 0;
        Response response = null;
        IOException iOException = null;
        while (true) {
            if (i >= 1 && !this.retryStrategy.shouldRetry(i, System.currentTimeMillis() - currentTimeMillis)) {
                break;
            }
            long j = 0;
            if (suitableStrategy != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                suitableStrategy.waitForPermit();
                j = System.currentTimeMillis() - currentTimeMillis2;
            }
            if (i > 0) {
                long nextDelay = (long) this.retryStrategy.getNextDelay(i);
                if (nextDelay > j + 500) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(nextDelay - j);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            QCloudLogger.i("QCloudHttp", "%s start to execute, attempts is %d", request2, Integer.valueOf(i));
            int i2 = i + 1;
            long nanoTime = System.nanoTime();
            int i3 = -1;
            try {
                response = executeTaskOnce(chain, request, httpTask);
                if (httpTask.isDownloadTask()) {
                    httpTask2.convertResponse(response);
                }
                iOException = null;
            } catch (IOException e2) {
                e = e2;
                iOException = e;
            } catch (QCloudClientException e3) {
                e = e3.getCause() instanceof IOException ? (IOException) e3.getCause() : new IOException(e3);
                iOException = e;
            } catch (QCloudServiceException e4) {
                iOException = e4.getCause() instanceof IOException ? (IOException) e4.getCause() : new IOException(e4);
                i3 = e4.getStatusCode();
            }
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            if (iOException == null) {
                if (suitableStrategy != null) {
                    suitableStrategy.reportSpeed(request2, httpTask2.getAverageStreamingSpeed(millis));
                }
            } else if (isUserCancelled(iOException) || !isRecoverable(iOException) || !isRecoverable(i3)) {
                QCloudLogger.i("QCloudHttp", "%s failed for %s, and is not recoverable", request2, iOException);
            } else {
                QCloudLogger.i("QCloudHttp", "%s failed for %s", request2, iOException);
                if (suitableStrategy != null) {
                    if (iOException instanceof SocketTimeoutException) {
                        suitableStrategy.reportTimeOut(request2);
                    } else {
                        suitableStrategy.reportException(request2, iOException);
                    }
                }
                i = i2;
            }
        }
        QCloudLogger.i("QCloudHttp", "%s failed for %s, and is not recoverable", request2, iOException);
        if (suitableStrategy != null) {
            suitableStrategy.reportException(request2, iOException);
        }
        if (iOException == null) {
            return response;
        }
        QCloudLogger.i("QCloudHttp", "%s ends with error, %s", request2, iOException);
        throw iOException;
    }

    private TrafficStrategy getSuitableStrategy(HttpTask httpTask) {
        if (httpTask.isDownloadTask()) {
            return this.downloadTrafficStrategy;
        }
        if (httpTask.isUploadTask()) {
            return this.uploadTrafficStrategy;
        }
        return null;
    }

    private Response executeTaskOnce(Interceptor.Chain chain, Request request, HttpTask httpTask) throws IOException {
        try {
            if (!httpTask.isCanceled()) {
                return processSingleRequest(chain, request);
            }
            throw new IOException("CANCELED");
        } catch (ProtocolException e2) {
            if (e2.getMessage() != null && e2.getMessage().contains("HTTP 204 had non-zero Content-Length: ")) {
                return new Response.Builder().request(request).message(e2.toString()).code(http.No_Content).protocol(Protocol.HTTP_1_1).build();
            }
            e2.printStackTrace();
            throw e2;
        } catch (IOException e3) {
            e3.printStackTrace();
            throw e3;
        }
    }

    private boolean isUserCancelled(IOException iOException) {
        return iOException.getMessage() != null && iOException.getMessage().toLowerCase().equals("canceled");
    }

    /* access modifiers changed from: package-private */
    public Response processSingleRequest(Interceptor.Chain chain, Request request) throws IOException {
        return chain.proceed(request);
    }

    private boolean isRecoverable(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException;
        }
        if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        }
        return false;
    }
}
