package com.sunmi.peripheral.printer;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface h extends IInterface {
    void a() throws RemoteException;

    void a(float f2, a aVar) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, a aVar) throws RemoteException;

    void a(Bitmap bitmap, int i, a aVar) throws RemoteException;

    void a(Bitmap bitmap, a aVar) throws RemoteException;

    void a(Bitmap bitmap, b bVar) throws RemoteException;

    void a(a aVar) throws RemoteException;

    void a(String str, int i, int i2, int i3, int i4, a aVar) throws RemoteException;

    void a(String str, int i, int i2, a aVar) throws RemoteException;

    void a(String str, int i, boolean z, b bVar) throws RemoteException;

    void a(String str, a aVar) throws RemoteException;

    void a(String str, b bVar) throws RemoteException;

    void a(String str, String str2, float f2, a aVar) throws RemoteException;

    void a(String str, String str2, b bVar) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(boolean z, a aVar) throws RemoteException;

    void a(byte[] bArr, a aVar) throws RemoteException;

    void a(byte[] bArr, c cVar) throws RemoteException;

    void a(TransBean[] transBeanArr, a aVar) throws RemoteException;

    void a(String[] strArr, int[] iArr, b bVar) throws RemoteException;

    void a(String[] strArr, int[] iArr, int[] iArr2, a aVar) throws RemoteException;

    int b() throws RemoteException;

    void b(int i, a aVar) throws RemoteException;

    void b(a aVar) throws RemoteException;

    void b(String str, a aVar) throws RemoteException;

    void b(boolean z) throws RemoteException;

    void b(String[] strArr, int[] iArr, int[] iArr2, a aVar) throws RemoteException;

    int c(a aVar) throws RemoteException;

    String c() throws RemoteException;

    void c(String str, a aVar) throws RemoteException;

    String d() throws RemoteException;

    void d(a aVar) throws RemoteException;

    String e() throws RemoteException;

    void e(a aVar) throws RemoteException;

    String f() throws RemoteException;

    void f(a aVar) throws RemoteException;

    void g() throws RemoteException;

    void g(a aVar) throws RemoteException;

    int h() throws RemoteException;

    int i() throws RemoteException;

    void j() throws RemoteException;

    int k() throws RemoteException;

    int l() throws RemoteException;

    int m() throws RemoteException;

    int n() throws RemoteException;

    boolean o() throws RemoteException;

    boolean p() throws RemoteException;

    boolean q() throws RemoteException;

    int r() throws RemoteException;

    int s() throws RemoteException;

    int t() throws RemoteException;

    boolean u() throws RemoteException;

    public static abstract class a extends Binder implements h {

        /* renamed from: a  reason: collision with root package name */
        static final int[][] f30635a = {new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9527, 9527, 9527, 9527, 9527, 9527, 9527, 9527, 9527, 0, -9, -9, -9, -9, -9, -9, -9, 9527, 9527, 9527, 9527, 9527}, new int[]{-1, 3, 3, 3, 9527, 9527, 8, 8, 1, 1, -10, -10, -10, -10, -3, -3, -3, -10, -10, 9527, -2, 9527, 9527, 9527, 9527, 9527, 9527, -10, 9527, -10, -10, -10}, new int[]{0, 0, 0, 9527, 9527, 9527, 0, 0, -5, 9527, 9527, 9527, 9527, 9527, 9527, 9527, 9527, 9527, 9527, 0, -15, -15, -15, -15, -15, -15, -15, 9527, 9527, 9527, 9527, 9527}, new int[]{-1, 3, 3, 3, 9527, 9527, 5, 5, 1, 1, -10, -10, -10, -10, 9527, 9527, 9527, -10, -10, 9527, -6, 9527, 9527, 9527, 9527, 9527, 9527, 9527, -13, -13, 9527, 9527}};

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("woyou.aidlservice.jiuiv5.IWoyouService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new C0483a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.graphics.Bitmap} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v56, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.graphics.Bitmap} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v62, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: android.graphics.Bitmap} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
            /*
                r10 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                java.lang.String r1 = "woyou.aidlservice.jiuiv5.IWoyouService"
                r2 = 1
                if (r11 == r0) goto L_0x0432
                r0 = 0
                r3 = 0
                switch(r11) {
                    case 1: goto L_0x0428;
                    case 2: goto L_0x041a;
                    case 3: goto L_0x040c;
                    case 4: goto L_0x03fa;
                    case 5: goto L_0x03e8;
                    case 6: goto L_0x03da;
                    case 7: goto L_0x03cc;
                    case 8: goto L_0x03be;
                    case 9: goto L_0x03a8;
                    case 10: goto L_0x0392;
                    case 11: goto L_0x037c;
                    case 12: goto L_0x0366;
                    case 13: goto L_0x0350;
                    case 14: goto L_0x033a;
                    case 15: goto L_0x0324;
                    case 16: goto L_0x0306;
                    case 17: goto L_0x02e8;
                    case 18: goto L_0x02c7;
                    case 19: goto L_0x02a0;
                    case 20: goto L_0x0282;
                    case 21: goto L_0x026c;
                    case 22: goto L_0x0252;
                    case 23: goto L_0x0248;
                    case 24: goto L_0x0237;
                    case 25: goto L_0x0226;
                    case 26: goto L_0x0210;
                    case 27: goto L_0x01fe;
                    case 28: goto L_0x01f4;
                    case 29: goto L_0x01e2;
                    case 30: goto L_0x01c9;
                    case 31: goto L_0x01ab;
                    case 32: goto L_0x019d;
                    case 33: goto L_0x018b;
                    case 34: goto L_0x017d;
                    case 35: goto L_0x016b;
                    case 36: goto L_0x015d;
                    case 37: goto L_0x014f;
                    case 38: goto L_0x0139;
                    case 39: goto L_0x0118;
                    case 40: goto L_0x010a;
                    case 41: goto L_0x00fc;
                    case 42: goto L_0x00d7;
                    case 43: goto L_0x00c9;
                    case 44: goto L_0x00bb;
                    case 45: goto L_0x00ad;
                    case 46: goto L_0x009f;
                    case 47: goto L_0x0091;
                    case 48: goto L_0x0083;
                    case 49: goto L_0x0069;
                    case 50: goto L_0x005b;
                    case 51: goto L_0x004d;
                    case 52: goto L_0x002c;
                    case 53: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r11 = super.onTransact(r11, r12, r13, r14)
                return r11
            L_0x0012:
                r12.enforceInterface(r1)
                java.lang.String[] r11 = r12.createStringArray()
                int[] r14 = r12.createIntArray()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.b r12 = com.sunmi.peripheral.printer.b.a.a(r12)
                r10.a((java.lang.String[]) r11, (int[]) r14, (com.sunmi.peripheral.printer.b) r12)
                r13.writeNoException()
                return r2
            L_0x002c:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                int r14 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x003e
                r3 = 1
            L_0x003e:
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.b r12 = com.sunmi.peripheral.printer.b.a.a(r12)
                r10.a((java.lang.String) r11, (int) r14, (boolean) r3, (com.sunmi.peripheral.printer.b) r12)
                r13.writeNoException()
                return r2
            L_0x004d:
                r12.enforceInterface(r1)
                boolean r11 = r10.u()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x005b:
                r12.enforceInterface(r1)
                int r11 = r10.t()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x0069:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                java.lang.String r14 = r12.readString()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.b r12 = com.sunmi.peripheral.printer.b.a.a(r12)
                r10.a((java.lang.String) r11, (java.lang.String) r14, (com.sunmi.peripheral.printer.b) r12)
                r13.writeNoException()
                return r2
            L_0x0083:
                r12.enforceInterface(r1)
                int r11 = r10.s()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x0091:
                r12.enforceInterface(r1)
                int r11 = r10.r()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x009f:
                r12.enforceInterface(r1)
                boolean r11 = r10.q()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x00ad:
                r12.enforceInterface(r1)
                boolean r11 = r10.p()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x00bb:
                r12.enforceInterface(r1)
                boolean r11 = r10.o()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x00c9:
                r12.enforceInterface(r1)
                int r11 = r10.n()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x00d7:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x00e9
                android.os.Parcelable$Creator r11 = android.graphics.Bitmap.CREATOR
                java.lang.Object r11 = r11.createFromParcel(r12)
                r0 = r11
                android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            L_0x00e9:
                int r11 = r12.readInt()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((android.graphics.Bitmap) r0, (int) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x00fc:
                r12.enforceInterface(r1)
                int r11 = r10.m()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x010a:
                r12.enforceInterface(r1)
                int r11 = r10.l()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x0118:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x012a
                android.os.Parcelable$Creator r11 = android.graphics.Bitmap.CREATOR
                java.lang.Object r11 = r11.createFromParcel(r12)
                r0 = r11
                android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            L_0x012a:
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.b r11 = com.sunmi.peripheral.printer.b.a.a(r11)
                r10.a((android.graphics.Bitmap) r0, (com.sunmi.peripheral.printer.b) r11)
                r13.writeNoException()
                return r2
            L_0x0139:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.b r12 = com.sunmi.peripheral.printer.b.a.a(r12)
                r10.a((java.lang.String) r11, (com.sunmi.peripheral.printer.b) r12)
                r13.writeNoException()
                return r2
            L_0x014f:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                r10.a((int) r11)
                r13.writeNoException()
                return r2
            L_0x015d:
                r12.enforceInterface(r1)
                int r11 = r10.i()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x016b:
                r12.enforceInterface(r1)
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.e(r11)
                r13.writeNoException()
                return r2
            L_0x017d:
                r12.enforceInterface(r1)
                int r11 = r10.h()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x018b:
                r12.enforceInterface(r1)
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.d(r11)
                r13.writeNoException()
                return r2
            L_0x019d:
                r12.enforceInterface(r1)
                int r11 = r10.k()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x01ab:
                r12.enforceInterface(r1)
                java.lang.String[] r11 = r12.createStringArray()
                int[] r14 = r12.createIntArray()
                int[] r0 = r12.createIntArray()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.b(r11, r14, r0, r12)
                r13.writeNoException()
                return r2
            L_0x01c9:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x01d3
                r3 = 1
            L_0x01d3:
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.a((boolean) r3, (com.sunmi.peripheral.printer.a) r11)
                r13.writeNoException()
                return r2
            L_0x01e2:
                r12.enforceInterface(r1)
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.g(r11)
                r13.writeNoException()
                return r2
            L_0x01f4:
                r12.enforceInterface(r1)
                r10.j()
                r13.writeNoException()
                return r2
            L_0x01fe:
                r12.enforceInterface(r1)
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.f(r11)
                r13.writeNoException()
                return r2
            L_0x0210:
                r12.enforceInterface(r1)
                byte[] r11 = r12.createByteArray()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.c r12 = com.sunmi.peripheral.printer.c.a.a(r12)
                r10.a((byte[]) r11, (com.sunmi.peripheral.printer.c) r12)
                r13.writeNoException()
                return r2
            L_0x0226:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0230
                r3 = 1
            L_0x0230:
                r10.b((boolean) r3)
                r13.writeNoException()
                return r2
            L_0x0237:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x0241
                r3 = 1
            L_0x0241:
                r10.a((boolean) r3)
                r13.writeNoException()
                return r2
            L_0x0248:
                r12.enforceInterface(r1)
                r10.g()
                r13.writeNoException()
                return r2
            L_0x0252:
                r12.enforceInterface(r1)
                android.os.Parcelable$Creator<com.sunmi.peripheral.printer.TransBean> r11 = com.sunmi.peripheral.printer.TransBean.f30626a
                java.lang.Object[] r11 = r12.createTypedArray(r11)
                com.sunmi.peripheral.printer.TransBean[] r11 = (com.sunmi.peripheral.printer.TransBean[]) r11
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((com.sunmi.peripheral.printer.TransBean[]) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x026c:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.c(r11, r12)
                r13.writeNoException()
                return r2
            L_0x0282:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                int r14 = r12.readInt()
                int r0 = r12.readInt()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((java.lang.String) r11, (int) r14, (int) r0, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x02a0:
                r12.enforceInterface(r1)
                java.lang.String r4 = r12.readString()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                int r7 = r12.readInt()
                int r8 = r12.readInt()
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r9 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r3 = r10
                r3.a(r4, r5, r6, r7, r8, r9)
                r13.writeNoException()
                return r2
            L_0x02c7:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                if (r11 == 0) goto L_0x02d9
                android.os.Parcelable$Creator r11 = android.graphics.Bitmap.CREATOR
                java.lang.Object r11 = r11.createFromParcel(r12)
                r0 = r11
                android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            L_0x02d9:
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.a((android.graphics.Bitmap) r0, (com.sunmi.peripheral.printer.a) r11)
                r13.writeNoException()
                return r2
            L_0x02e8:
                r12.enforceInterface(r1)
                java.lang.String[] r11 = r12.createStringArray()
                int[] r14 = r12.createIntArray()
                int[] r0 = r12.createIntArray()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((java.lang.String[]) r11, (int[]) r14, (int[]) r0, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x0306:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                java.lang.String r14 = r12.readString()
                float r0 = r12.readFloat()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((java.lang.String) r11, (java.lang.String) r14, (float) r0, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x0324:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.b((java.lang.String) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x033a:
                r12.enforceInterface(r1)
                float r11 = r12.readFloat()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((float) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x0350:
                r12.enforceInterface(r1)
                java.lang.String r11 = r12.readString()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((java.lang.String) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x0366:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.b((int) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x037c:
                r12.enforceInterface(r1)
                byte[] r11 = r12.createByteArray()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((byte[]) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x0392:
                r12.enforceInterface(r1)
                int r11 = r12.readInt()
                android.os.IBinder r12 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r12 = com.sunmi.peripheral.printer.a.C0479a.a(r12)
                r10.a((int) r11, (com.sunmi.peripheral.printer.a) r12)
                r13.writeNoException()
                return r2
            L_0x03a8:
                r12.enforceInterface(r1)
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                int r11 = r10.c(r11)
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x03be:
                r12.enforceInterface(r1)
                java.lang.String r11 = r10.f()
                r13.writeNoException()
                r13.writeString(r11)
                return r2
            L_0x03cc:
                r12.enforceInterface(r1)
                java.lang.String r11 = r10.e()
                r13.writeNoException()
                r13.writeString(r11)
                return r2
            L_0x03da:
                r12.enforceInterface(r1)
                java.lang.String r11 = r10.d()
                r13.writeNoException()
                r13.writeString(r11)
                return r2
            L_0x03e8:
                r12.enforceInterface(r1)
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.b((com.sunmi.peripheral.printer.a) r11)
                r13.writeNoException()
                return r2
            L_0x03fa:
                r12.enforceInterface(r1)
                android.os.IBinder r11 = r12.readStrongBinder()
                com.sunmi.peripheral.printer.a r11 = com.sunmi.peripheral.printer.a.C0479a.a(r11)
                r10.a((com.sunmi.peripheral.printer.a) r11)
                r13.writeNoException()
                return r2
            L_0x040c:
                r12.enforceInterface(r1)
                java.lang.String r11 = r10.c()
                r13.writeNoException()
                r13.writeString(r11)
                return r2
            L_0x041a:
                r12.enforceInterface(r1)
                int r11 = r10.b()
                r13.writeNoException()
                r13.writeInt(r11)
                return r2
            L_0x0428:
                r12.enforceInterface(r1)
                r10.a()
                r13.writeNoException()
                return r2
            L_0x0432:
                r13.writeString(r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sunmi.peripheral.printer.h.a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.sunmi.peripheral.printer.h$a$a  reason: collision with other inner class name */
        public static class C0483a implements h {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f30636a;

            /* renamed from: b  reason: collision with root package name */
            private int[] f30637b;

            C0483a(IBinder iBinder) {
                this.f30636a = iBinder;
                v();
            }

            private void v() {
                if (Build.MODEL.contains("V2") || Build.MODEL.contains("v2") || Build.MODEL.contains("P2") || Build.MODEL.contains("p2") || Build.MODEL.contains("P1") || Build.MODEL.contains("p1") || Build.MODEL.contains("V1s") || Build.MODEL.contains("v1s")) {
                    this.f30637b = a.f30635a[0];
                } else if (Build.MODEL.contains("mini")) {
                    this.f30637b = a.f30635a[1];
                } else if (Build.MODEL.contains("V1") || Build.MODEL.contains("v1")) {
                    this.f30637b = a.f30635a[2];
                } else if (Build.MODEL.contains("T1") || Build.MODEL.contains("t1") || Build.MODEL.contains("T2") || Build.MODEL.contains("t2") || Build.MODEL.contains("S2") || Build.MODEL.contains("s2")) {
                    this.f30637b = a.f30635a[3];
                } else {
                    this.f30637b = a.f30635a[3];
                }
            }

            public IBinder asBinder() {
                return this.f30636a;
            }

            public void a() throws RemoteException {
                throw new e("only system calls are supported");
            }

            public int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    this.f30636a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    this.f30636a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain2.readException();
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(5, obtain, obtain2, 0);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    this.f30636a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    this.f30636a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    this.f30636a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int c(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                if (Build.MODEL.contains("T1") || Build.MODEL.contains("t1")) {
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        this.f30636a.transact(9, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        this.f30636a.transact(9, obtain, obtain2, 0);
                        obtain2.readException();
                        return 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            public void a(int i, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(byte[] bArr, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(int i, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, a aVar) throws RemoteException {
                throw new e("invalid interface call temporarily");
            }

            public void a(float f2, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeFloat(f2);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(String str, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, String str2, float f2, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeFloat(f2);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String[] strArr, int[] iArr, int[] iArr2, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeStringArray(strArr);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(Bitmap bitmap, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, int i, int i2, int i3, int i4, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(String str, int i, int i2, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c(String str, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30636a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(TransBean[] transBeanArr, a aVar) throws RemoteException {
                if (this.f30637b[19] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeTypedArray(transBeanArr, 0);
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.f30636a.transact(22, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    if (this.f30636a.transact(this.f30637b[0] + 23, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return;
                    }
                    throw new e("this version does not support this method!");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void d(a aVar) throws RemoteException {
                if (this.f30637b[10] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[10] + 33, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int h() throws RemoteException {
                if (this.f30637b[11] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[11] + 34, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void e(a aVar) throws RemoteException {
                if (this.f30637b[12] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[12] + 35, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int i() throws RemoteException {
                if (this.f30637b[13] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[13] + 36, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeInt(z ? 1 : 0);
                    if (this.f30636a.transact(this.f30637b[1] + 24, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return;
                    }
                    throw new e("this version does not support this method!");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeInt(z ? 1 : 0);
                    if (this.f30636a.transact(this.f30637b[2] + 25, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return;
                    }
                    throw new e("this version does not support this method!");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(byte[] bArr, c cVar) throws RemoteException {
                if (this.f30637b[3] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeByteArray(bArr);
                        obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[3] + 26, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void f(a aVar) throws RemoteException {
                if (this.f30637b[4] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[4] + 27, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void j() throws RemoteException {
                if (this.f30637b[5] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[5] + 28, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void g(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f30636a.transact(this.f30637b[6] + 29, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return;
                    }
                    throw new e("this version does not support this method!");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(boolean z, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f30636a.transact(this.f30637b[7] + 30, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return;
                    }
                    throw new e("this version does not support this method!");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void b(String[] strArr, int[] iArr, int[] iArr2, a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                    obtain.writeStringArray(strArr);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f30636a.transact(this.f30637b[8] + 31, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return;
                    }
                    throw new e("this version does not support this method!");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int k() throws RemoteException {
                if (this.f30637b[9] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[9] + 32, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(int i) throws RemoteException {
                if (this.f30637b[14] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeInt(i);
                        if (this.f30636a.transact(this.f30637b[14] + 37, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(String str, b bVar) throws RemoteException {
                if (this.f30637b[15] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeString(str);
                        obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[15] + 38, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(Bitmap bitmap, b bVar) throws RemoteException {
                if (this.f30637b[16] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (bitmap != null) {
                            obtain.writeInt(1);
                            bitmap.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[16] + 39, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int l() throws RemoteException {
                if (this.f30637b[17] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[17] + 40, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int m() throws RemoteException {
                if (this.f30637b[18] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[18] + 41, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(Bitmap bitmap, int i, a aVar) throws RemoteException {
                if (this.f30637b[20] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (bitmap != null) {
                            obtain.writeInt(1);
                            bitmap.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeInt(i);
                        obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[20] + 42, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int n() throws RemoteException {
                if (this.f30637b[21] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[21] + 43, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public boolean o() throws RemoteException {
                if (this.f30637b[22] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        boolean z = false;
                        if (this.f30636a.transact(this.f30637b[22] + 44, obtain, obtain2, 0)) {
                            obtain2.readException();
                            if (obtain2.readInt() != 0) {
                                z = true;
                            }
                            return z;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public boolean p() throws RemoteException {
                if (this.f30637b[23] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        boolean z = false;
                        if (this.f30636a.transact(this.f30637b[23] + 45, obtain, obtain2, 0)) {
                            obtain2.readException();
                            if (obtain2.readInt() != 0) {
                                z = true;
                            }
                            return z;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public boolean q() throws RemoteException {
                if (this.f30637b[24] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        boolean z = false;
                        if (this.f30636a.transact(this.f30637b[24] + 46, obtain, obtain2, 0)) {
                            obtain2.readException();
                            if (obtain2.readInt() != 0) {
                                z = true;
                            }
                            return z;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int r() throws RemoteException {
                if (this.f30637b[25] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[25] + 47, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int s() throws RemoteException {
                if (this.f30637b[26] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[26] + 48, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(String str, String str2, b bVar) throws RemoteException {
                if (this.f30637b[27] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[27] + 49, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public int t() throws RemoteException {
                if (this.f30637b[28] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        if (this.f30636a.transact(this.f30637b[28] + 50, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return obtain2.readInt();
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public boolean u() throws RemoteException {
                if (this.f30637b[29] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        boolean z = false;
                        if (this.f30636a.transact(this.f30637b[29] + 51, obtain, obtain2, 0)) {
                            obtain2.readException();
                            if (obtain2.readInt() != 0) {
                                z = true;
                            }
                            return z;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(String str, int i, boolean z, b bVar) throws RemoteException {
                if (this.f30637b[30] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeString(str);
                        obtain.writeInt(i);
                        obtain.writeInt(z ? 1 : 0);
                        obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[30] + 52, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }

            public void a(String[] strArr, int[] iArr, b bVar) throws RemoteException {
                if (this.f30637b[31] != 9527) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("woyou.aidlservice.jiuiv5.IWoyouService");
                        obtain.writeStringArray(strArr);
                        obtain.writeIntArray(iArr);
                        obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                        if (this.f30636a.transact(this.f30637b[31] + 53, obtain, obtain2, 0)) {
                            obtain2.readException();
                            return;
                        }
                        throw new e("this version does not support this method!");
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } else {
                    throw new e("this model does not support this method!");
                }
            }
        }
    }
}
