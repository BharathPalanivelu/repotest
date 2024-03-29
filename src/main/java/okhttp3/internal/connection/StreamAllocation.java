package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    public StreamAllocation(ConnectionPool connectionPool2, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, routeDatabase(), call2, eventListener2);
        this.callStackTrace = obj;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec newCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = newCodec;
            }
            return newCodec;
        } catch (IOException e2) {
            throw new RouteException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.findConnection(r4, r5, r6, r7, r8)
            okhttp3.ConnectionPool r1 = r3.connectionPool
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x0018
            r3.noNewStreams()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x001c:
            throw r4
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        	at java.util.ArrayList.get(ArrayList.java:433)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private okhttp3.internal.connection.RealConnection findConnection(int r19, int r20, int r21, int r22, boolean r23) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            okhttp3.ConnectionPool r2 = r1.connectionPool
            monitor-enter(r2)
            boolean r0 = r1.released     // Catch:{ all -> 0x0144 }
            if (r0 != 0) goto L_0x013c
            okhttp3.internal.http.HttpCodec r0 = r1.codec     // Catch:{ all -> 0x0144 }
            if (r0 != 0) goto L_0x0134
            boolean r0 = r1.canceled     // Catch:{ all -> 0x0144 }
            if (r0 != 0) goto L_0x012c
            okhttp3.internal.connection.RealConnection r0 = r1.connection     // Catch:{ all -> 0x0144 }
            java.net.Socket r3 = r18.releaseIfNoNewStreams()     // Catch:{ all -> 0x0144 }
            okhttp3.internal.connection.RealConnection r4 = r1.connection     // Catch:{ all -> 0x0144 }
            r5 = 0
            if (r4 == 0) goto L_0x0020
            okhttp3.internal.connection.RealConnection r0 = r1.connection     // Catch:{ all -> 0x0144 }
            r4 = r5
            goto L_0x0022
        L_0x0020:
            r4 = r0
            r0 = r5
        L_0x0022:
            boolean r6 = r1.reportedAcquired     // Catch:{ all -> 0x0144 }
            if (r6 != 0) goto L_0x0027
            r4 = r5
        L_0x0027:
            r6 = 1
            r7 = 0
            if (r0 != 0) goto L_0x0043
            okhttp3.internal.Internal r8 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x0144 }
            okhttp3.ConnectionPool r9 = r1.connectionPool     // Catch:{ all -> 0x0144 }
            okhttp3.Address r10 = r1.address     // Catch:{ all -> 0x0144 }
            r8.get(r9, r10, r1, r5)     // Catch:{ all -> 0x0144 }
            okhttp3.internal.connection.RealConnection r8 = r1.connection     // Catch:{ all -> 0x0144 }
            if (r8 == 0) goto L_0x003e
            okhttp3.internal.connection.RealConnection r0 = r1.connection     // Catch:{ all -> 0x0144 }
            r8 = r0
            r9 = r5
            r0 = 1
            goto L_0x0046
        L_0x003e:
            okhttp3.Route r8 = r1.route     // Catch:{ all -> 0x0144 }
            r9 = r8
            r8 = r0
            goto L_0x0045
        L_0x0043:
            r8 = r0
            r9 = r5
        L_0x0045:
            r0 = 0
        L_0x0046:
            monitor-exit(r2)     // Catch:{ all -> 0x0144 }
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r3)
            if (r4 == 0) goto L_0x0053
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.Call r3 = r1.call
            r2.connectionReleased(r3, r4)
        L_0x0053:
            if (r0 == 0) goto L_0x005c
            okhttp3.EventListener r2 = r1.eventListener
            okhttp3.Call r3 = r1.call
            r2.connectionAcquired(r3, r8)
        L_0x005c:
            if (r8 == 0) goto L_0x0067
            okhttp3.internal.connection.RealConnection r0 = r1.connection
            okhttp3.Route r0 = r0.route()
            r1.route = r0
            return r8
        L_0x0067:
            if (r9 != 0) goto L_0x007d
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection
            if (r2 == 0) goto L_0x0073
            boolean r2 = r2.hasNext()
            if (r2 != 0) goto L_0x007d
        L_0x0073:
            okhttp3.internal.connection.RouteSelector r2 = r1.routeSelector
            okhttp3.internal.connection.RouteSelector$Selection r2 = r2.next()
            r1.routeSelection = r2
            r2 = 1
            goto L_0x007e
        L_0x007d:
            r2 = 0
        L_0x007e:
            okhttp3.ConnectionPool r3 = r1.connectionPool
            monitor-enter(r3)
            boolean r4 = r1.canceled     // Catch:{ all -> 0x0129 }
            if (r4 != 0) goto L_0x0121
            if (r2 == 0) goto L_0x00b0
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection     // Catch:{ all -> 0x0129 }
            java.util.List r2 = r2.getAll()     // Catch:{ all -> 0x0129 }
            int r4 = r2.size()     // Catch:{ all -> 0x0129 }
            r10 = 0
        L_0x0092:
            if (r10 >= r4) goto L_0x00b0
            java.lang.Object r11 = r2.get(r10)     // Catch:{ all -> 0x0129 }
            okhttp3.Route r11 = (okhttp3.Route) r11     // Catch:{ all -> 0x0129 }
            okhttp3.internal.Internal r12 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x0129 }
            okhttp3.ConnectionPool r13 = r1.connectionPool     // Catch:{ all -> 0x0129 }
            okhttp3.Address r14 = r1.address     // Catch:{ all -> 0x0129 }
            r12.get(r13, r14, r1, r11)     // Catch:{ all -> 0x0129 }
            okhttp3.internal.connection.RealConnection r12 = r1.connection     // Catch:{ all -> 0x0129 }
            if (r12 == 0) goto L_0x00ad
            okhttp3.internal.connection.RealConnection r8 = r1.connection     // Catch:{ all -> 0x0129 }
            r1.route = r11     // Catch:{ all -> 0x0129 }
            r0 = 1
            goto L_0x00b0
        L_0x00ad:
            int r10 = r10 + 1
            goto L_0x0092
        L_0x00b0:
            if (r0 != 0) goto L_0x00c8
            if (r9 != 0) goto L_0x00ba
            okhttp3.internal.connection.RouteSelector$Selection r2 = r1.routeSelection     // Catch:{ all -> 0x0129 }
            okhttp3.Route r9 = r2.next()     // Catch:{ all -> 0x0129 }
        L_0x00ba:
            r1.route = r9     // Catch:{ all -> 0x0129 }
            r1.refusedStreamCount = r7     // Catch:{ all -> 0x0129 }
            okhttp3.internal.connection.RealConnection r8 = new okhttp3.internal.connection.RealConnection     // Catch:{ all -> 0x0129 }
            okhttp3.ConnectionPool r2 = r1.connectionPool     // Catch:{ all -> 0x0129 }
            r8.<init>(r2, r9)     // Catch:{ all -> 0x0129 }
            r1.acquire(r8, r7)     // Catch:{ all -> 0x0129 }
        L_0x00c8:
            monitor-exit(r3)     // Catch:{ all -> 0x0129 }
            if (r0 == 0) goto L_0x00d3
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.Call r2 = r1.call
            r0.connectionAcquired(r2, r8)
            return r8
        L_0x00d3:
            okhttp3.Call r0 = r1.call
            okhttp3.EventListener r2 = r1.eventListener
            r10 = r8
            r11 = r19
            r12 = r20
            r13 = r21
            r14 = r22
            r15 = r23
            r16 = r0
            r17 = r2
            r10.connect(r11, r12, r13, r14, r15, r16, r17)
            okhttp3.internal.connection.RouteDatabase r0 = r18.routeDatabase()
            okhttp3.Route r2 = r8.route()
            r0.connected(r2)
            okhttp3.ConnectionPool r2 = r1.connectionPool
            monitor-enter(r2)
            r1.reportedAcquired = r6     // Catch:{ all -> 0x011e }
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x011e }
            okhttp3.ConnectionPool r3 = r1.connectionPool     // Catch:{ all -> 0x011e }
            r0.put(r3, r8)     // Catch:{ all -> 0x011e }
            boolean r0 = r8.isMultiplexed()     // Catch:{ all -> 0x011e }
            if (r0 == 0) goto L_0x0112
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.instance     // Catch:{ all -> 0x011e }
            okhttp3.ConnectionPool r3 = r1.connectionPool     // Catch:{ all -> 0x011e }
            okhttp3.Address r4 = r1.address     // Catch:{ all -> 0x011e }
            java.net.Socket r5 = r0.deduplicate(r3, r4, r1)     // Catch:{ all -> 0x011e }
            okhttp3.internal.connection.RealConnection r8 = r1.connection     // Catch:{ all -> 0x011e }
        L_0x0112:
            monitor-exit(r2)     // Catch:{ all -> 0x011e }
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r5)
            okhttp3.EventListener r0 = r1.eventListener
            okhttp3.Call r2 = r1.call
            r0.connectionAcquired(r2, r8)
            return r8
        L_0x011e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011e }
            throw r0
        L_0x0121:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)     // Catch:{ all -> 0x0129 }
            throw r0     // Catch:{ all -> 0x0129 }
        L_0x0129:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0129 }
            throw r0
        L_0x012c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0144 }
            java.lang.String r3 = "Canceled"
            r0.<init>(r3)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x0134:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0144 }
            java.lang.String r3 = "codec != null"
            r0.<init>(r3)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x013c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0144 }
            java.lang.String r3 = "released"
            r0.<init>(r3)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x0144:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0144 }
            goto L_0x0148
        L_0x0147:
            throw r0
        L_0x0148:
            goto L_0x0147
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.StreamAllocation.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                if (httpCodec == this.codec) {
                    if (!z) {
                        this.connection.successCount++;
                    }
                    realConnection = this.connection;
                    deallocate = deallocate(z, false, true);
                    if (this.connection != null) {
                        realConnection = null;
                    }
                    z2 = this.released;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.callEnd(this.call);
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public Route route() {
        return this.route;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, (IOException) null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    private Socket deallocate(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.codec = null;
        }
        if (z2) {
            this.released = true;
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z) {
                realConnection.noNewStreams = true;
            }
            if (this.codec == null && (this.released || this.connection.noNewStreams)) {
                release(this.connection);
                if (this.connection.allocations.isEmpty()) {
                    this.connection.idleAtNanos = System.nanoTime();
                    if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                        socket = this.connection.socket();
                        this.connection = null;
                        return socket;
                    }
                }
                socket = null;
                this.connection = null;
                return socket;
            }
        }
        return null;
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void streamFailed(IOException iOException) {
        boolean z;
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                    if (this.refusedStreamCount > 1) {
                        this.route = null;
                    }
                    z = false;
                    realConnection = this.connection;
                    deallocate = deallocate(z, false, true);
                    if (this.connection != null || !this.reportedAcquired) {
                        realConnection = null;
                    }
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.route = null;
                    }
                    z = false;
                    realConnection = this.connection;
                    deallocate = deallocate(z, false, true);
                    realConnection = null;
                }
            } else {
                if (this.connection != null && (!this.connection.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.connection.successCount == 0) {
                        if (!(this.route == null || iOException == null)) {
                            this.routeSelector.connectFailed(this.route, iOException);
                        }
                        this.route = null;
                    }
                }
                z = false;
                realConnection = this.connection;
                deallocate = deallocate(z, false, true);
                realConnection = null;
            }
            z = true;
            realConnection = this.connection;
            deallocate = deallocate(z, false, true);
            realConnection = null;
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Socket deallocate = deallocate(true, false, false);
            this.connection = realConnection;
            realConnection.allocations.add(this.connection.allocations.get(0));
            return deallocate;
        }
        throw new IllegalStateException();
    }

    public boolean hasMoreRoutes() {
        if (this.route == null) {
            RouteSelector.Selection selection = this.routeSelection;
            if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        RealConnection connection2 = connection();
        return connection2 != null ? connection2.toString() : this.address.toString();
    }

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }
}
