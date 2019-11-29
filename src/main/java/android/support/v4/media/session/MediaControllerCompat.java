package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import androidx.core.app.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        final Object f450a;

        /* renamed from: b  reason: collision with root package name */
        C0004a f451b;

        /* renamed from: c  reason: collision with root package name */
        a f452c;

        public void a() {
        }

        public void a(int i) {
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(b bVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void b(int i) {
        }

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f450a = c.a(new b(this));
                return;
            }
            c cVar = new c(this);
            this.f452c = cVar;
            this.f450a = cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, Object obj, Bundle bundle) {
            C0004a aVar = this.f451b;
            if (aVar != null) {
                Message obtainMessage = aVar.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        private static class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f455a;

            b(a aVar) {
                this.f455a = new WeakReference<>(aVar);
            }

            public void a() {
                a aVar = (a) this.f455a.get();
                if (aVar != null) {
                    aVar.b();
                }
            }

            public void a(String str, Bundle bundle) {
                a aVar = (a) this.f455a.get();
                if (aVar == null) {
                    return;
                }
                if (aVar.f452c == null || Build.VERSION.SDK_INT >= 23) {
                    aVar.a(str, bundle);
                }
            }

            public void a(Object obj) {
                a aVar = (a) this.f455a.get();
                if (aVar != null && aVar.f452c == null) {
                    aVar.a(PlaybackStateCompat.a(obj));
                }
            }

            public void b(Object obj) {
                a aVar = (a) this.f455a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }

            public void a(List<?> list) {
                a aVar = (a) this.f455a.get();
                if (aVar != null) {
                    aVar.a(MediaSessionCompat.QueueItem.a(list));
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = (a) this.f455a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.f455a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            public void a(int i, int i2, int i3, int i4, int i5) {
                a aVar = (a) this.f455a.get();
                if (aVar != null) {
                    aVar.a(new b(i, i2, i3, i4, i5));
                }
            }
        }

        private static class c extends a.C0005a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f456a;

            public void a(boolean z) throws RemoteException {
            }

            c(a aVar) {
                this.f456a = new WeakReference<>(aVar);
            }

            public void a(String str, Bundle bundle) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a() throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(8, (Object) null, (Bundle) null);
                }
            }

            public void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(5, list, (Bundle) null);
                }
            }

            public void a(CharSequence charSequence) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, (Bundle) null);
                }
            }

            public void b(boolean z) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), (Bundle) null);
                }
            }

            public void a(int i) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), (Bundle) null);
                }
            }

            public void b(int i) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), (Bundle) null);
                }
            }

            public void a(Bundle bundle) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, (Bundle) null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new b(parcelableVolumeInfo.f469a, parcelableVolumeInfo.f470b, parcelableVolumeInfo.f471c, parcelableVolumeInfo.f472d, parcelableVolumeInfo.f473e) : null, (Bundle) null);
                }
            }

            public void b() throws RemoteException {
                a aVar = (a) this.f456a.get();
                if (aVar != null) {
                    aVar.a(13, (Object) null, (Bundle) null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        private class C0004a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f453a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f454b;

            public void handleMessage(Message message) {
                if (this.f453a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            this.f454b.a((String) message.obj, data);
                            return;
                        case 2:
                            this.f454b.a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.f454b.a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.f454b.a((b) message.obj);
                            return;
                        case 5:
                            this.f454b.a((List<MediaSessionCompat.QueueItem>) (List) message.obj);
                            return;
                        case 6:
                            this.f454b.a((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            this.f454b.a(bundle);
                            return;
                        case 8:
                            this.f454b.b();
                            return;
                        case 9:
                            this.f454b.a(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            this.f454b.a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.f454b.b(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            this.f454b.a();
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f457a;

        /* renamed from: b  reason: collision with root package name */
        private final int f458b;

        /* renamed from: c  reason: collision with root package name */
        private final int f459c;

        /* renamed from: d  reason: collision with root package name */
        private final int f460d;

        /* renamed from: e  reason: collision with root package name */
        private final int f461e;

        b(int i, int i2, int i3, int i4, int i5) {
            this.f457a = i;
            this.f458b = i2;
            this.f459c = i3;
            this.f460d = i4;
            this.f461e = i5;
        }
    }

    static class MediaControllerImplApi21 {

        /* renamed from: a  reason: collision with root package name */
        final Object f445a;

        /* renamed from: b  reason: collision with root package name */
        final MediaSessionCompat.Token f446b;

        /* renamed from: c  reason: collision with root package name */
        private final List<a> f447c;

        /* renamed from: d  reason: collision with root package name */
        private HashMap<a, a> f448d;

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f446b.a() != null) {
                for (a next : this.f447c) {
                    a aVar = new a(next);
                    this.f448d.put(next, aVar);
                    next.f452c = aVar;
                    try {
                        this.f446b.a().a((a) aVar);
                        next.a(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e2) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                    }
                }
                this.f447c.clear();
            }
        }

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f449a;

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f449a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f445a) {
                        mediaControllerImplApi21.f446b.a(b.a.a(d.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f446b.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.a();
                    }
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            public void a() throws RemoteException {
                throw new AssertionError();
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public void a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }
}
