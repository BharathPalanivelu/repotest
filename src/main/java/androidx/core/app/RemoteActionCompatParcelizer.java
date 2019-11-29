package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1513a = (IconCompat) aVar.b(remoteActionCompat.f1513a, 1);
        remoteActionCompat.f1514b = aVar.b(remoteActionCompat.f1514b, 2);
        remoteActionCompat.f1515c = aVar.b(remoteActionCompat.f1515c, 3);
        remoteActionCompat.f1516d = (PendingIntent) aVar.b(remoteActionCompat.f1516d, 4);
        remoteActionCompat.f1517e = aVar.b(remoteActionCompat.f1517e, 5);
        remoteActionCompat.f1518f = aVar.b(remoteActionCompat.f1518f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.a(false, false);
        aVar.a((c) remoteActionCompat.f1513a, 1);
        aVar.a(remoteActionCompat.f1514b, 2);
        aVar.a(remoteActionCompat.f1515c, 3);
        aVar.a((Parcelable) remoteActionCompat.f1516d, 4);
        aVar.a(remoteActionCompat.f1517e, 5);
        aVar.a(remoteActionCompat.f1518f, 6);
    }
}
