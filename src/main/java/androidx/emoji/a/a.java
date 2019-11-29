package androidx.emoji.a;

import android.content.Context;
import androidx.core.util.e;
import androidx.emoji.b.a;
import androidx.emoji.b.f;

public class a extends a.c {
    public a(Context context) {
        super(new C0045a(context));
    }

    /* renamed from: androidx.emoji.a.a$a  reason: collision with other inner class name */
    private static class C0045a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2023a;

        C0045a(Context context) {
            this.f2023a = context.getApplicationContext();
        }

        public void a(a.g gVar) {
            e.a(gVar, (Object) "loaderCallback cannot be null");
            Thread thread = new Thread(new b(this.f2023a, gVar));
            thread.setDaemon(false);
            thread.start();
        }
    }

    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final a.g f2024a;

        /* renamed from: b  reason: collision with root package name */
        private final Context f2025b;

        b(Context context, a.g gVar) {
            this.f2025b = context;
            this.f2024a = gVar;
        }

        public void run() {
            try {
                this.f2024a.a(f.a(this.f2025b.getAssets(), "NotoColorEmojiCompat.ttf"));
            } catch (Throwable th) {
                this.f2024a.a(th);
            }
        }
    }
}
