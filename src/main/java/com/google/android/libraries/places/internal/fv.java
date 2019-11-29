package com.google.android.libraries.places.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.Map;

public class fv implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final ft f12587a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<TaskCompletionSource<?>, HandlerThread> f12588b = new HashMap();

    public static int a(int i, int i2, int i3) {
        double a2 = a(i);
        double a3 = a(a(i2), a2);
        return (a3 <= 3.0d && a3 <= a(a(i3), a2)) ? i3 : i2;
    }

    private static double a(double d2, double d3) {
        double round = (double) Math.round(((Math.max(d2, d3) + 0.05d) / (Math.min(d2, d3) + 0.05d)) * 100.0d);
        Double.isNaN(round);
        return round / 100.0d;
    }

    private static double a(int i) {
        double red = (double) Color.red(i);
        Double.isNaN(red);
        double green = (double) Color.green(i);
        Double.isNaN(green);
        double a2 = (a(red / 255.0d) * 0.2126d) + (a(green / 255.0d) * 0.7152d);
        double blue = (double) Color.blue(i);
        Double.isNaN(blue);
        return a2 + (a(blue / 255.0d) * 0.0722d);
    }

    private static double a(double d2) {
        return d2 <= 0.03928d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
    }

    public static FusedLocationProviderClient a(Context context) {
        return (FusedLocationProviderClient) lt.a(fu.a(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public fv(ft ftVar) {
        this.f12587a = ftVar;
    }

    public <T> boolean a(TaskCompletionSource<T> taskCompletionSource, long j, String str) {
        if (this.f12588b.containsKey(taskCompletionSource)) {
            return false;
        }
        HandlerThread b2 = ft.b("timeoutHandlerThread");
        this.f12588b.put(taskCompletionSource, b2);
        return new Handler(b2.getLooper()).postDelayed(new as(taskCompletionSource, str), j);
    }

    public <T> Task<T> a(Task<T> task, CancellationToken cancellationToken, long j, String str) {
        TaskCompletionSource taskCompletionSource;
        if (cancellationToken == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        }
        a(taskCompletionSource, j, str);
        task.continueWithTask(new at(this, taskCompletionSource));
        taskCompletionSource.getTask().addOnCompleteListener(new au(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public static <T> Task<T> a(TaskCompletionSource<T> taskCompletionSource, Task<T> task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
        } else if (!task.isCanceled() && task.getException() != null) {
            taskCompletionSource.setException(task.getException());
        }
        return taskCompletionSource.getTask();
    }

    /* renamed from: a */
    public boolean b(TaskCompletionSource<?> taskCompletionSource) {
        HandlerThread remove = this.f12588b.remove(taskCompletionSource);
        if (remove == null) {
            return false;
        }
        return remove.quit();
    }

    public /* synthetic */ Task b(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        return a(taskCompletionSource, task);
    }
}
