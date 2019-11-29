package com.shopee.app.util.datapoint;

import android.os.AsyncTask;
import com.firebase.jobdispatcher.r;
import com.firebase.jobdispatcher.s;
import com.shopee.app.application.ar;
import java.lang.ref.WeakReference;

public class DataPointService extends s {

    /* renamed from: a  reason: collision with root package name */
    private a f26306a;

    public boolean a(r rVar) {
        com.garena.android.appkit.d.a.b("DataPointService Start", new Object[0]);
        this.f26306a = new a(this, rVar);
        this.f26306a.execute(new Void[0]);
        return true;
    }

    public boolean b(r rVar) {
        a aVar = this.f26306a;
        if (aVar != null) {
            aVar.cancel(true);
        }
        return true;
    }

    private static class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<DataPointService> f26307a;

        /* renamed from: b  reason: collision with root package name */
        private final r f26308b;

        a(DataPointService dataPointService, r rVar) {
            this.f26307a = new WeakReference<>(dataPointService);
            this.f26308b = rVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                ar.f().e().locationSyncManager().a(ar.f().getApplicationContext());
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            DataPointService dataPointService = (DataPointService) this.f26307a.get();
            if (dataPointService != null) {
                dataPointService.b(this.f26308b, false);
            }
        }
    }
}
