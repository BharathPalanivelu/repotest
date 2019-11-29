package twitter4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import twitter4j.conf.Configuration;

final class DispatcherImpl implements Dispatcher {
    private static final long SHUTDOWN_TIME = 5000;
    private static final Logger logger = Logger.getLogger(DispatcherImpl.class);
    /* access modifiers changed from: private */
    public final ExecutorService executorService;

    public DispatcherImpl(final Configuration configuration) {
        this.executorService = Executors.newFixedThreadPool(configuration.getAsyncNumThreads(), new ThreadFactory() {
            int count = 0;

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                int i = this.count;
                this.count = i + 1;
                thread.setName(String.format("Twitter4J Async Dispatcher[%d]", new Object[]{Integer.valueOf(i)}));
                thread.setDaemon(configuration.isDaemonEnabled());
                return thread;
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                DispatcherImpl.this.executorService.shutdown();
            }
        });
    }

    public synchronized void invokeLater(Runnable runnable) {
        this.executorService.execute(runnable);
    }

    public synchronized void shutdown() {
        this.executorService.shutdown();
        try {
            if (!this.executorService.awaitTermination(SHUTDOWN_TIME, TimeUnit.MILLISECONDS)) {
                this.executorService.shutdownNow();
            }
        } catch (InterruptedException e2) {
            logger.warn(e2.getMessage());
        }
        return;
    }
}
