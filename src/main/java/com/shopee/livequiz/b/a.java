package com.shopee.livequiz.b;

import android.util.SparseArray;
import com.shopee.livequiz.data.bean.GameData;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<C0453a> f29676a = new SparseArray<>();

    public void a(GameData gameData) {
        int c2 = c(gameData);
        if (c2 > 0) {
            C0453a aVar = this.f29676a.get(c2);
            boolean z = true;
            if (aVar == null) {
                aVar = new C0453a();
            } else if (aVar.a() != null) {
                z = false;
            }
            if (z) {
                aVar.a(gameData);
                long currentTimeMillis = System.currentTimeMillis();
                aVar.a(currentTimeMillis);
                e.a(gameData, currentTimeMillis);
                this.f29676a.put(c2, aVar);
            }
            a(GameData.TYPE_END_LIVE.equals(gameData.msg_type));
        }
    }

    public void b(GameData gameData) {
        int c2 = c(gameData);
        if (c2 > 0) {
            C0453a aVar = this.f29676a.get(c2);
            boolean z = true;
            if (aVar == null) {
                aVar = new C0453a();
            } else if (aVar.b() != null) {
                z = false;
            }
            if (z) {
                aVar.b(gameData);
                long currentTimeMillis = System.currentTimeMillis();
                aVar.b(currentTimeMillis);
                e.b(gameData, currentTimeMillis);
                this.f29676a.put(c2, aVar);
            }
            a(GameData.TYPE_END_LIVE.equals(gameData.msg_type));
        }
    }

    private void a(boolean z) {
        for (int i = 0; i < this.f29676a.size(); i++) {
            C0453a valueAt = this.f29676a.valueAt(i);
            if (!valueAt.f29681e && (z || !(valueAt.a() == null || valueAt.b() == null))) {
                e.a(valueAt.a(), valueAt.d(), valueAt.c());
                valueAt.a(true);
            }
        }
    }

    private int c(GameData gameData) {
        if (gameData == null) {
            return -1;
        }
        if (GameData.TYPE_QUEATION.equals(gameData.msg_type)) {
            if (gameData.msg_body == null || gameData.msg_body.sn <= 0) {
                return -1;
            }
            return gameData.msg_body.sn * 10;
        } else if (GameData.TYPE_ANSWER.equals(gameData.msg_type)) {
            if (gameData.msg_body == null || gameData.msg_body.sn <= 0) {
                return -1;
            }
            return (gameData.msg_body.sn * 10) + 5;
        } else if (GameData.TYPE_SESSION_RESULT.equals(gameData.msg_type)) {
            return 9999997;
        } else {
            if (GameData.TYPE_HIDE_RESULT.equals(gameData.msg_type)) {
                return 9999998;
            }
            return GameData.TYPE_END_LIVE.equals(gameData.msg_type) ? 9999999 : 0;
        }
    }

    /* renamed from: com.shopee.livequiz.b.a$a  reason: collision with other inner class name */
    private static class C0453a {

        /* renamed from: a  reason: collision with root package name */
        private GameData f29677a;

        /* renamed from: b  reason: collision with root package name */
        private GameData f29678b;

        /* renamed from: c  reason: collision with root package name */
        private long f29679c;

        /* renamed from: d  reason: collision with root package name */
        private long f29680d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f29681e;

        private C0453a() {
        }

        public GameData a() {
            return this.f29677a;
        }

        public void a(GameData gameData) {
            this.f29677a = gameData;
        }

        public GameData b() {
            return this.f29678b;
        }

        public void b(GameData gameData) {
            this.f29678b = gameData;
        }

        public long c() {
            return this.f29679c;
        }

        public void a(long j) {
            this.f29679c = j;
        }

        public long d() {
            return this.f29680d;
        }

        public void b(long j) {
            this.f29680d = j;
        }

        public void a(boolean z) {
            this.f29681e = z;
        }
    }
}
