package com.c.a.c.b;

import com.c.a.c.a;
import com.c.a.c.c;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f5807a = new h() {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final h f5808b = new h() {
        public boolean a() {
            return false;
        }

        public boolean a(a aVar) {
            return false;
        }

        public boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public boolean b() {
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final h f5809c = new h() {
        public boolean a() {
            return false;
        }

        public boolean a(boolean z, a aVar, c cVar) {
            return false;
        }

        public boolean b() {
            return true;
        }

        public boolean a(a aVar) {
            return (aVar == a.DATA_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final h f5810d = new h() {
        public boolean a() {
            return true;
        }

        public boolean a(a aVar) {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean a(boolean z, a aVar, c cVar) {
            return (aVar == a.RESOURCE_DISK_CACHE || aVar == a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final h f5811e = new h() {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean a(a aVar) {
            return aVar == a.REMOTE;
        }

        public boolean a(boolean z, a aVar, c cVar) {
            return ((z && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && cVar == c.TRANSFORMED;
        }
    };

    public abstract boolean a();

    public abstract boolean a(a aVar);

    public abstract boolean a(boolean z, a aVar, c cVar);

    public abstract boolean b();
}
