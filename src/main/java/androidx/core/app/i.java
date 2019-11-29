package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.a;
import cn.tongdun.android.shell.settings.Constants;
import java.util.ArrayList;
import java.util.Iterator;

public class i {

    public interface e {
        d a(d dVar);
    }

    public static class d {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        Notification N;
        @Deprecated
        public ArrayList<String> O;

        /* renamed from: a  reason: collision with root package name */
        public Context f1567a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f1568b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<a> f1569c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f1570d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f1571e;

        /* renamed from: f  reason: collision with root package name */
        PendingIntent f1572f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f1573g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean m;
        boolean n;
        g o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        public d(Context context, String str) {
            this.f1568b = new ArrayList<>();
            this.f1569c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.N = new Notification();
            this.f1567a = context;
            this.I = str;
            this.N.when = System.currentTimeMillis();
            this.N.audioStreamType = -1;
            this.l = 0;
            this.O = new ArrayList<>();
        }

        @Deprecated
        public d(Context context) {
            this(context, (String) null);
        }

        public d a(long j2) {
            this.N.when = j2;
            return this;
        }

        public d a(boolean z2) {
            this.m = z2;
            return this;
        }

        public d b(boolean z2) {
            this.n = z2;
            return this;
        }

        public d a(int i2) {
            this.N.icon = i2;
            return this;
        }

        public d a(int i2, int i3) {
            Notification notification = this.N;
            notification.icon = i2;
            notification.iconLevel = i3;
            return this;
        }

        public d a(CharSequence charSequence) {
            this.f1570d = f(charSequence);
            return this;
        }

        public d b(CharSequence charSequence) {
            this.f1571e = f(charSequence);
            return this;
        }

        public d c(CharSequence charSequence) {
            this.p = f(charSequence);
            return this;
        }

        public d a(CharSequence[] charSequenceArr) {
            this.q = charSequenceArr;
            return this;
        }

        public d b(int i2) {
            this.k = i2;
            return this;
        }

        public d d(CharSequence charSequence) {
            this.j = f(charSequence);
            return this;
        }

        public d a(int i2, int i3, boolean z2) {
            this.r = i2;
            this.s = i3;
            this.t = z2;
            return this;
        }

        public d a(RemoteViews remoteViews) {
            this.N.contentView = remoteViews;
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.f1572f = pendingIntent;
            return this;
        }

        public d b(PendingIntent pendingIntent) {
            this.N.deleteIntent = pendingIntent;
            return this;
        }

        public d a(PendingIntent pendingIntent, boolean z2) {
            this.f1573g = pendingIntent;
            a(128, z2);
            return this;
        }

        public d e(CharSequence charSequence) {
            this.N.tickerText = f(charSequence);
            return this;
        }

        public d a(CharSequence charSequence, RemoteViews remoteViews) {
            this.N.tickerText = f(charSequence);
            this.h = remoteViews;
            return this;
        }

        public d a(Bitmap bitmap) {
            this.i = b(bitmap);
            return this;
        }

        private Bitmap b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f1567a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(a.b.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(a.b.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = (double) dimensionPixelSize;
            double max = (double) Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(max);
            double d3 = d2 / max;
            double d4 = (double) dimensionPixelSize2;
            double max2 = (double) Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(max2);
            double min = Math.min(d3, d4 / max2);
            double width = (double) bitmap.getWidth();
            Double.isNaN(width);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
        }

        public d a(Uri uri) {
            Notification notification = this.N;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.N.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public d a(Uri uri, int i2) {
            Notification notification = this.N;
            notification.sound = uri;
            notification.audioStreamType = i2;
            if (Build.VERSION.SDK_INT >= 21) {
                this.N.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i2).build();
            }
            return this;
        }

        public d a(long[] jArr) {
            this.N.vibrate = jArr;
            return this;
        }

        public d a(int i2, int i3, int i4) {
            Notification notification = this.N;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            int i5 = (notification.ledOnMS == 0 || this.N.ledOffMS == 0) ? 0 : 1;
            Notification notification2 = this.N;
            notification2.flags = i5 | (notification2.flags & -2);
            return this;
        }

        public d c(boolean z2) {
            a(2, z2);
            return this;
        }

        public d d(boolean z2) {
            a(8, z2);
            return this;
        }

        public d e(boolean z2) {
            a(16, z2);
            return this;
        }

        public d f(boolean z2) {
            this.x = z2;
            return this;
        }

        public d a(String str) {
            this.A = str;
            return this;
        }

        public d c(int i2) {
            Notification notification = this.N;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        private void a(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.N;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.N;
            notification2.flags = (i2 ^ -1) & notification2.flags;
        }

        public d d(int i2) {
            this.l = i2;
            return this;
        }

        public d b(String str) {
            this.O.add(str);
            return this;
        }

        public d c(String str) {
            this.u = str;
            return this;
        }

        public d g(boolean z2) {
            this.v = z2;
            return this;
        }

        public d d(String str) {
            this.w = str;
            return this;
        }

        public d a(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.B;
                if (bundle2 == null) {
                    this.B = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        public d b(Bundle bundle) {
            this.B = bundle;
            return this;
        }

        public Bundle a() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public d a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1568b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public d a(a aVar) {
            this.f1568b.add(aVar);
            return this;
        }

        public d a(g gVar) {
            if (this.o != gVar) {
                this.o = gVar;
                g gVar2 = this.o;
                if (gVar2 != null) {
                    gVar2.a(this);
                }
            }
            return this;
        }

        public d e(int i2) {
            this.C = i2;
            return this;
        }

        public d f(int i2) {
            this.D = i2;
            return this;
        }

        public d a(Notification notification) {
            this.E = notification;
            return this;
        }

        public d b(RemoteViews remoteViews) {
            this.F = remoteViews;
            return this;
        }

        public d c(RemoteViews remoteViews) {
            this.G = remoteViews;
            return this;
        }

        public d d(RemoteViews remoteViews) {
            this.H = remoteViews;
            return this;
        }

        public d e(String str) {
            this.I = str;
            return this;
        }

        public d g(int i2) {
            this.M = i2;
            return this;
        }

        public d a(e eVar) {
            eVar.a(this);
            return this;
        }

        public Notification b() {
            return new j(this).b();
        }

        protected static CharSequence f(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, Constants.DEFAULT_BLACKBOX_MINSIZE) : charSequence;
        }
    }

    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        protected d f1575a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f1576b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f1577c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1578d = false;

        public void a(Bundle bundle) {
        }

        public void a(h hVar) {
        }

        public RemoteViews b(h hVar) {
            return null;
        }

        public RemoteViews c(h hVar) {
            return null;
        }

        public RemoteViews d(h hVar) {
            return null;
        }

        public void a(d dVar) {
            if (this.f1575a != dVar) {
                this.f1575a = dVar;
                d dVar2 = this.f1575a;
                if (dVar2 != null) {
                    dVar2.a(this);
                }
            }
        }
    }

    public static class b extends g {

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f1563e;

        /* renamed from: f  reason: collision with root package name */
        private Bitmap f1564f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1565g;

        public b a(CharSequence charSequence) {
            this.f1577c = d.f(charSequence);
            this.f1578d = true;
            return this;
        }

        public b a(Bitmap bitmap) {
            this.f1563e = bitmap;
            return this;
        }

        public b b(Bitmap bitmap) {
            this.f1564f = bitmap;
            this.f1565g = true;
            return this;
        }

        public void a(h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(hVar.a()).setBigContentTitle(this.f1576b).bigPicture(this.f1563e);
                if (this.f1565g) {
                    bigPicture.bigLargeIcon(this.f1564f);
                }
                if (this.f1578d) {
                    bigPicture.setSummaryText(this.f1577c);
                }
            }
        }
    }

    public static class c extends g {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f1566e;

        public c a(CharSequence charSequence) {
            this.f1577c = d.f(charSequence);
            this.f1578d = true;
            return this;
        }

        public c b(CharSequence charSequence) {
            this.f1566e = d.f(charSequence);
            return this;
        }

        public void a(h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(hVar.a()).setBigContentTitle(this.f1576b).bigText(this.f1566e);
                if (this.f1578d) {
                    bigText.setSummaryText(this.f1577c);
                }
            }
        }
    }

    public static class f extends g {

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<CharSequence> f1574e = new ArrayList<>();

        public f a(CharSequence charSequence) {
            this.f1576b = d.f(charSequence);
            return this;
        }

        public f b(CharSequence charSequence) {
            this.f1577c = d.f(charSequence);
            this.f1578d = true;
            return this;
        }

        public f c(CharSequence charSequence) {
            this.f1574e.add(d.f(charSequence));
            return this;
        }

        public void a(h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(hVar.a()).setBigContentTitle(this.f1576b);
                if (this.f1578d) {
                    bigContentTitle.setSummaryText(this.f1577c);
                }
                Iterator<CharSequence> it = this.f1574e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f1556a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1557b;

        /* renamed from: c  reason: collision with root package name */
        public int f1558c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f1559d;

        /* renamed from: e  reason: collision with root package name */
        public PendingIntent f1560e;

        /* renamed from: f  reason: collision with root package name */
        private final m[] f1561f;

        /* renamed from: g  reason: collision with root package name */
        private final m[] f1562g;
        private boolean h;
        private final int i;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2, charSequence, pendingIntent, new Bundle(), (m[]) null, (m[]) null, true, 0, true);
        }

        a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, m[] mVarArr, m[] mVarArr2, boolean z, int i3, boolean z2) {
            this.f1557b = true;
            this.f1558c = i2;
            this.f1559d = d.f(charSequence);
            this.f1560e = pendingIntent;
            this.f1556a = bundle == null ? new Bundle() : bundle;
            this.f1561f = mVarArr;
            this.f1562g = mVarArr2;
            this.h = z;
            this.i = i3;
            this.f1557b = z2;
        }

        public int a() {
            return this.f1558c;
        }

        public CharSequence b() {
            return this.f1559d;
        }

        public PendingIntent c() {
            return this.f1560e;
        }

        public Bundle d() {
            return this.f1556a;
        }

        public boolean e() {
            return this.h;
        }

        public m[] f() {
            return this.f1561f;
        }

        public int g() {
            return this.i;
        }

        public m[] h() {
            return this.f1562g;
        }

        public boolean i() {
            return this.f1557b;
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return k.a(notification);
        }
        return null;
    }
}
