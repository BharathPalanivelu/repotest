package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import com.path.android.jobqueue.JobManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private b f1548a;

    public f() {
        this(1);
    }

    public f(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1548a = new a(i);
        } else {
            this.f1548a = new b();
        }
    }

    public void a(Activity activity) {
        this.f1548a.a(activity);
    }

    public SparseIntArray[] b(Activity activity) {
        return this.f1548a.b(activity);
    }

    private static class b {
        public void a(Activity activity) {
        }

        public SparseIntArray[] b(Activity activity) {
            return null;
        }

        b() {
        }
    }

    private static class a extends b {

        /* renamed from: e  reason: collision with root package name */
        private static HandlerThread f1549e;

        /* renamed from: f  reason: collision with root package name */
        private static Handler f1550f;

        /* renamed from: a  reason: collision with root package name */
        int f1551a;

        /* renamed from: b  reason: collision with root package name */
        SparseIntArray[] f1552b = new SparseIntArray[9];

        /* renamed from: c  reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f1553c = new Window.OnFrameMetricsAvailableListener() {
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                if ((a.this.f1551a & 1) != 0) {
                    a aVar = a.this;
                    aVar.a(aVar.f1552b[0], frameMetrics.getMetric(8));
                }
                if ((a.this.f1551a & 2) != 0) {
                    a aVar2 = a.this;
                    aVar2.a(aVar2.f1552b[1], frameMetrics.getMetric(1));
                }
                if ((a.this.f1551a & 4) != 0) {
                    a aVar3 = a.this;
                    aVar3.a(aVar3.f1552b[2], frameMetrics.getMetric(3));
                }
                if ((a.this.f1551a & 8) != 0) {
                    a aVar4 = a.this;
                    aVar4.a(aVar4.f1552b[3], frameMetrics.getMetric(4));
                }
                if ((a.this.f1551a & 16) != 0) {
                    a aVar5 = a.this;
                    aVar5.a(aVar5.f1552b[4], frameMetrics.getMetric(5));
                }
                if ((a.this.f1551a & 64) != 0) {
                    a aVar6 = a.this;
                    aVar6.a(aVar6.f1552b[6], frameMetrics.getMetric(7));
                }
                if ((a.this.f1551a & 32) != 0) {
                    a aVar7 = a.this;
                    aVar7.a(aVar7.f1552b[5], frameMetrics.getMetric(6));
                }
                if ((a.this.f1551a & 128) != 0) {
                    a aVar8 = a.this;
                    aVar8.a(aVar8.f1552b[7], frameMetrics.getMetric(0));
                }
                if ((a.this.f1551a & 256) != 0) {
                    a aVar9 = a.this;
                    aVar9.a(aVar9.f1552b[8], frameMetrics.getMetric(2));
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<WeakReference<Activity>> f1554d = new ArrayList<>();

        a(int i) {
            this.f1551a = i;
        }

        /* access modifiers changed from: package-private */
        public void a(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / JobManager.NS_PER_MS);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }

        public void a(Activity activity) {
            if (f1549e == null) {
                f1549e = new HandlerThread("FrameMetricsAggregator");
                f1549e.start();
                f1550f = new Handler(f1549e.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                SparseIntArray[] sparseIntArrayArr = this.f1552b;
                if (sparseIntArrayArr[i] == null && (this.f1551a & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f1553c, f1550f);
            this.f1554d.add(new WeakReference(activity));
        }

        public SparseIntArray[] b(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f1554d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference next = it.next();
                if (next.get() == activity) {
                    this.f1554d.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f1553c);
            return this.f1552b;
        }
    }
}
