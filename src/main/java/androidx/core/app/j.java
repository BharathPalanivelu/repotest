package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f1579a;

    /* renamed from: b  reason: collision with root package name */
    private final i.d f1580b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f1581c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f1582d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Bundle> f1583e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f1584f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    private int f1585g;
    private RemoteViews h;

    j(i.d dVar) {
        this.f1580b = dVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1579a = new Notification.Builder(dVar.f1567a, dVar.I);
        } else {
            this.f1579a = new Notification.Builder(dVar.f1567a);
        }
        Notification notification = dVar.N;
        this.f1579a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f1570d).setContentText(dVar.f1571e).setContentInfo(dVar.j).setContentIntent(dVar.f1572f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f1573g, (notification.flags & 128) != 0).setLargeIcon(dVar.i).setNumber(dVar.k).setProgress(dVar.r, dVar.s, dVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1579a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1579a.setSubText(dVar.p).setUsesChronometer(dVar.n).setPriority(dVar.l);
            Iterator<i.a> it = dVar.f1568b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (dVar.B != null) {
                this.f1584f.putAll(dVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.x) {
                    this.f1584f.putBoolean("android.support.localOnly", true);
                }
                if (dVar.u != null) {
                    this.f1584f.putString("android.support.groupKey", dVar.u);
                    if (dVar.v) {
                        this.f1584f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1584f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (dVar.w != null) {
                    this.f1584f.putString("android.support.sortKey", dVar.w);
                }
            }
            this.f1581c = dVar.F;
            this.f1582d = dVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1579a.setShowWhen(dVar.m);
            if (Build.VERSION.SDK_INT < 21 && dVar.O != null && !dVar.O.isEmpty()) {
                this.f1584f.putStringArray("android.people", (String[]) dVar.O.toArray(new String[dVar.O.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1579a.setLocalOnly(dVar.x).setGroup(dVar.u).setGroupSummary(dVar.v).setSortKey(dVar.w);
            this.f1585g = dVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1579a.setCategory(dVar.A).setColor(dVar.C).setVisibility(dVar.D).setPublicVersion(dVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = dVar.O.iterator();
            while (it2.hasNext()) {
                this.f1579a.addPerson(it2.next());
            }
            this.h = dVar.H;
            if (dVar.f1569c.size() > 0) {
                Bundle bundle = dVar.a().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < dVar.f1569c.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), k.a(dVar.f1569c.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                dVar.a().putBundle("android.car.EXTENSIONS", bundle);
                this.f1584f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1579a.setExtras(dVar.B).setRemoteInputHistory(dVar.q);
            if (dVar.F != null) {
                this.f1579a.setCustomContentView(dVar.F);
            }
            if (dVar.G != null) {
                this.f1579a.setCustomBigContentView(dVar.G);
            }
            if (dVar.H != null) {
                this.f1579a.setCustomHeadsUpContentView(dVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1579a.setBadgeIconType(dVar.J).setShortcutId(dVar.K).setTimeoutAfter(dVar.L).setGroupAlertBehavior(dVar.M);
            if (dVar.z) {
                this.f1579a.setColorized(dVar.y);
            }
            if (!TextUtils.isEmpty(dVar.I)) {
                this.f1579a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
    }

    public Notification.Builder a() {
        return this.f1579a;
    }

    public Notification b() {
        i.g gVar = this.f1580b.o;
        if (gVar != null) {
            gVar.a((h) this);
        }
        RemoteViews b2 = gVar != null ? gVar.b(this) : null;
        Notification c2 = c();
        if (b2 != null) {
            c2.contentView = b2;
        } else if (this.f1580b.F != null) {
            c2.contentView = this.f1580b.F;
        }
        if (Build.VERSION.SDK_INT >= 16 && gVar != null) {
            RemoteViews c3 = gVar.c(this);
            if (c3 != null) {
                c2.bigContentView = c3;
            }
        }
        if (Build.VERSION.SDK_INT >= 21 && gVar != null) {
            RemoteViews d2 = this.f1580b.o.d(this);
            if (d2 != null) {
                c2.headsUpContentView = d2;
            }
        }
        if (Build.VERSION.SDK_INT >= 16 && gVar != null) {
            Bundle a2 = i.a(c2);
            if (a2 != null) {
                gVar.a(a2);
            }
        }
        return c2;
    }

    private void a(i.a aVar) {
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.a(), aVar.b(), aVar.c());
            if (aVar.f() != null) {
                for (RemoteInput addRemoteInput : m.a(aVar.f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.i());
            builder.addExtras(bundle);
            this.f1579a.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f1583e.add(k.a(this.f1579a, aVar));
        }
    }

    /* access modifiers changed from: protected */
    public Notification c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f1579a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.f1579a.build();
            if (this.f1585g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f1585g != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f1585g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f1579a.setExtras(this.f1584f);
            Notification build2 = this.f1579a.build();
            RemoteViews remoteViews = this.f1581c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1582d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f1585g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f1585g != 2)) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f1585g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f1579a.setExtras(this.f1584f);
            Notification build3 = this.f1579a.build();
            RemoteViews remoteViews4 = this.f1581c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1582d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f1585g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f1585g != 2)) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f1585g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a2 = k.a(this.f1583e);
            if (a2 != null) {
                this.f1584f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f1579a.setExtras(this.f1584f);
            Notification build4 = this.f1579a.build();
            RemoteViews remoteViews6 = this.f1581c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1582d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT < 16) {
            return this.f1579a.getNotification();
        } else {
            Notification build5 = this.f1579a.build();
            Bundle a3 = i.a(build5);
            Bundle bundle = new Bundle(this.f1584f);
            for (String str : this.f1584f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = k.a(this.f1583e);
            if (a4 != null) {
                i.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f1581c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f1582d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
