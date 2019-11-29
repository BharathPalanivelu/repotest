package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@VisibleForTesting
final class zzey implements zzem {
    /* access modifiers changed from: private */
    public static final String zzaog = String.format("CREATE TABLE IF NOT EXISTS %s ('%s' TEXT UNIQUE);", new Object[]{"gtm_hit_unique_ids", "hit_unique_id"});
    /* access modifiers changed from: private */
    public static final String zzaoh = String.format("CREATE TRIGGER IF NOT EXISTS %s DELETE ON %s FOR EACH ROW WHEN OLD.%s NOTNULL BEGIN     INSERT OR IGNORE INTO %s (%s) VALUES (OLD.%s); END;", new Object[]{"save_unique_on_delete", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id"});
    /* access modifiers changed from: private */
    public static final String zzaoi = String.format("CREATE TRIGGER IF NOT EXISTS %s BEFORE INSERT ON %s FOR EACH ROW WHEN NEW.%s NOT NULL BEGIN     SELECT RAISE(ABORT, 'Duplicate unique ID.')     WHERE EXISTS (SELECT 1 FROM %s WHERE %s = NEW.%s); END;", new Object[]{"check_unique_on_insert", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id"});
    /* access modifiers changed from: private */
    public static final String zzxj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT UNIQUE, '%s' TEXT, '%s' TEXT);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time", "hit_method", "hit_unique_id", "hit_headers", "hit_body"});
    /* access modifiers changed from: private */
    public final String zzaih;
    private long zzaii;
    private final int zzaij;
    private final zzfa zzaoj;
    private volatile zzed zzaok;
    private final zzen zzaol;
    /* access modifiers changed from: private */
    public final Context zzrm;
    /* access modifiers changed from: private */
    public Clock zzsd;

    zzey(zzen zzen, Context context) {
        this(zzen, context, "gtm_urls.db", 2000);
    }

    @VisibleForTesting
    private zzey(zzen zzen, Context context, String str, int i) {
        this.zzrm = context.getApplicationContext();
        this.zzaih = str;
        this.zzaol = zzen;
        this.zzsd = DefaultClock.getInstance();
        this.zzaoj = new zzfa(this, this.zzrm, this.zzaih);
        this.zzaok = new zzfu(this.zzrm, new zzez(this));
        this.zzaii = 0;
        this.zzaij = 2000;
    }

    public final void zza(long j, String str, String str2, String str3, Map<String, String> map, String str4) {
        String str5;
        String str6 = str;
        Map<String, String> map2 = map;
        long currentTimeMillis = this.zzsd.currentTimeMillis();
        if (currentTimeMillis > this.zzaii + 86400000) {
            this.zzaii = currentTimeMillis;
            SQLiteDatabase zzau = zzau("Error opening database for deleteStaleHits.");
            if (zzau != null) {
                int delete = zzau.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzsd.currentTimeMillis() - 2592000000L)});
                StringBuilder sb = new StringBuilder(31);
                sb.append("Removed ");
                sb.append(delete);
                sb.append(" stale hits.");
                zzev.zzab(sb.toString());
                this.zzaol.zze(zzbv("gtm_hits") == 0);
            }
        }
        int zzbv = (zzbv("gtm_hits") - this.zzaij) + 1;
        if (zzbv > 0) {
            List<String> zzz = zzz(zzbv);
            int size = zzz.size();
            StringBuilder sb2 = new StringBuilder(51);
            sb2.append("Store full, deleting ");
            sb2.append(size);
            sb2.append(" hits to make room.");
            zzev.zzab(sb2.toString());
            zza((String[]) zzz.toArray(new String[0]));
        }
        SQLiteDatabase zzau2 = zzau("Error opening database for putHit");
        if (zzau2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", 0);
            contentValues.put("hit_method", str2 == null ? "GET" : str2);
            contentValues.put("hit_unique_id", str3);
            if (map2 == null) {
                str5 = null;
            } else {
                str5 = new JSONObject(map2).toString();
            }
            contentValues.put("hit_headers", str5);
            contentValues.put("hit_body", str4);
            try {
                zzau2.insertOrThrow("gtm_hits", (String) null, contentValues);
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 19);
                sb3.append("Hit stored (url = ");
                sb3.append(str);
                sb3.append(SQLBuilder.PARENTHESES_RIGHT);
                zzev.zzab(sb3.toString());
                this.zzaol.zze(false);
            } catch (SQLiteConstraintException unused) {
                String valueOf = String.valueOf(str);
                zzev.zzab(valueOf.length() != 0 ? "Hit has already been sent: ".concat(valueOf) : new String("Hit has already been sent: "));
            } catch (SQLiteException e2) {
                String valueOf2 = String.valueOf(e2.getMessage());
                zzev.zzac(valueOf2.length() != 0 ? "Error storing hit: ".concat(valueOf2) : new String("Error storing hit: "));
            }
        }
        if (zzfd.zzkr().isPreview()) {
            zzev.zzab("Sending hits immediately under preview.");
            dispatch();
        }
    }

    private final List<String> zzz(int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzev.zzac("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase zzau = zzau("Error opening database for peekHitIds.");
        if (zzau == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            Cursor query = zzau.query("gtm_hits", new String[]{"hit_id"}, (String) null, (String[]) null, (String) null, (String) null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            if (query.moveToFirst()) {
                do {
                    arrayList.add(String.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzev.zzac(valueOf.length() != 0 ? "Error in peekHits fetching hitIds: ".concat(valueOf) : new String("Error in peekHits fetching hitIds: "));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x020d, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01dd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01de, code lost:
        r14 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01e3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01fe, code lost:
        r0 = "Error in peekHits fetching hitIds: ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0203, code lost:
        r0 = new java.lang.String("Error in peekHits fetching hitIds: ");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0198 A[Catch:{ all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x019d A[Catch:{ all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b4 A[Catch:{ all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01dd A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01fe A[Catch:{ all -> 0x0211 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0203 A[Catch:{ all -> 0x0211 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.google.android.gms.internal.gtm.zzeh> zzaa(int r21) {
        /*
            r20 = this;
            java.lang.String r0 = "%s ASC"
            java.lang.String r1 = "hit_id"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "Error opening database for peekHits"
            r4 = r20
            android.database.sqlite.SQLiteDatabase r3 = r4.zzau(r3)
            if (r3 != 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r6 = "gtm_hits"
            r15 = 3
            java.lang.String[] r7 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            r13 = 0
            r7[r13] = r1     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            java.lang.String r5 = "hit_time"
            r12 = 1
            r7[r12] = r5     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            java.lang.String r5 = "hit_first_send_time"
            r11 = 2
            r7[r11] = r5     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            r8 = 0
            r9 = 0
            r10 = 0
            r16 = 0
            java.lang.Object[] r5 = new java.lang.Object[r12]     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            r5[r13] = r1     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            java.lang.String r17 = java.lang.String.format(r0, r5)     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            r18 = 40
            java.lang.String r19 = java.lang.Integer.toString(r18)     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            r5 = r3
            r14 = 2
            r11 = r16
            r15 = 1
            r12 = r17
            r14 = 0
            r13 = r19
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x01ec, all -> 0x01e9 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x01e3, all -> 0x01dd }
            r12.<init>()     // Catch:{ SQLiteException -> 0x01e3, all -> 0x01dd }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x01da, all -> 0x01dd }
            if (r2 == 0) goto L_0x0078
        L_0x0052:
            com.google.android.gms.internal.gtm.zzeh r2 = new com.google.android.gms.internal.gtm.zzeh     // Catch:{ SQLiteException -> 0x0073, all -> 0x006f }
            long r6 = r13.getLong(r14)     // Catch:{ SQLiteException -> 0x0073, all -> 0x006f }
            long r8 = r13.getLong(r15)     // Catch:{ SQLiteException -> 0x0073, all -> 0x006f }
            r5 = 2
            long r10 = r13.getLong(r5)     // Catch:{ SQLiteException -> 0x0073, all -> 0x006f }
            r5 = r2
            r5.<init>(r6, r8, r10)     // Catch:{ SQLiteException -> 0x0073, all -> 0x006f }
            r12.add(r2)     // Catch:{ SQLiteException -> 0x0073, all -> 0x006f }
            boolean r2 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0073, all -> 0x006f }
            if (r2 != 0) goto L_0x0052
            goto L_0x0078
        L_0x006f:
            r0 = move-exception
            r14 = r13
            goto L_0x0212
        L_0x0073:
            r0 = move-exception
            r2 = r12
            r14 = r13
            goto L_0x01ee
        L_0x0078:
            if (r13 == 0) goto L_0x007d
            r13.close()
        L_0x007d:
            java.lang.String r6 = "gtm_hits"
            r2 = 5
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            r7[r14] = r1     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            java.lang.String r2 = "hit_url"
            r7[r15] = r2     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            java.lang.String r2 = "hit_method"
            r5 = 2
            r7[r5] = r2     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            java.lang.String r2 = "hit_headers"
            r5 = 3
            r7[r5] = r2     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            java.lang.String r2 = "hit_body"
            r11 = 4
            r7[r11] = r2     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            r8 = 0
            r9 = 0
            r10 = 0
            r2 = 0
            java.lang.Object[] r5 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            r5[r14] = r1     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            java.lang.String r0 = java.lang.String.format(r0, r5)     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            java.lang.String r1 = java.lang.Integer.toString(r18)     // Catch:{ SQLiteException -> 0x0184, all -> 0x0180 }
            r5 = r3
            r3 = 4
            r11 = r2
            r2 = r12
            r12 = r0
            r18 = r13
            r13 = r1
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x017c, all -> 0x0178 }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x0176 }
            if (r0 == 0) goto L_0x0170
            r1 = 0
        L_0x00ba:
            r0 = r13
            android.database.sqlite.SQLiteCursor r0 = (android.database.sqlite.SQLiteCursor) r0     // Catch:{ SQLiteException -> 0x0176 }
            android.database.CursorWindow r0 = r0.getWindow()     // Catch:{ SQLiteException -> 0x0176 }
            int r0 = r0.getNumRows()     // Catch:{ SQLiteException -> 0x0176 }
            if (r0 <= 0) goto L_0x014b
            java.lang.Object r0 = r2.get(r1)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzeh r0 = (com.google.android.gms.internal.gtm.zzeh) r0     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.String r5 = r13.getString(r15)     // Catch:{ SQLiteException -> 0x0176 }
            r0.zzbc(r5)     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.Object r0 = r2.get(r1)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzeh r0 = (com.google.android.gms.internal.gtm.zzeh) r0     // Catch:{ SQLiteException -> 0x0176 }
            r5 = 2
            java.lang.String r6 = r13.getString(r5)     // Catch:{ SQLiteException -> 0x0176 }
            r0.zzbt(r6)     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.Object r0 = r2.get(r1)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzeh r0 = (com.google.android.gms.internal.gtm.zzeh) r0     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.String r5 = r13.getString(r3)     // Catch:{ SQLiteException -> 0x0176 }
            r0.zzbu(r5)     // Catch:{ SQLiteException -> 0x0176 }
            r5 = 3
            java.lang.String r0 = r13.getString(r5)     // Catch:{ JSONException -> 0x0127 }
            if (r0 == 0) goto L_0x011b
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0127 }
            r6.<init>(r0)     // Catch:{ JSONException -> 0x0127 }
            org.json.JSONArray r0 = r6.names()     // Catch:{ JSONException -> 0x0127 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ JSONException -> 0x0127 }
            r7.<init>()     // Catch:{ JSONException -> 0x0127 }
            r8 = 0
        L_0x0105:
            int r9 = r0.length()     // Catch:{ JSONException -> 0x0127 }
            if (r8 >= r9) goto L_0x011c
            java.lang.String r9 = r0.getString(r8)     // Catch:{ JSONException -> 0x0127 }
            java.lang.Object r10 = r6.opt(r9)     // Catch:{ JSONException -> 0x0127 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ JSONException -> 0x0127 }
            r7.put(r9, r10)     // Catch:{ JSONException -> 0x0127 }
            int r8 = r8 + 1
            goto L_0x0105
        L_0x011b:
            r7 = 0
        L_0x011c:
            java.lang.Object r0 = r2.get(r1)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzeh r0 = (com.google.android.gms.internal.gtm.zzeh) r0     // Catch:{ SQLiteException -> 0x0176 }
            r0.zzg(r7)     // Catch:{ SQLiteException -> 0x0176 }
            r7 = 2
            goto L_0x0168
        L_0x0127:
            r0 = move-exception
            java.lang.String r6 = "Failed to read headers for hitId %d: %s"
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.Object r9 = r2.get(r1)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzeh r9 = (com.google.android.gms.internal.gtm.zzeh) r9     // Catch:{ SQLiteException -> 0x0176 }
            long r9 = r9.zzih()     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ SQLiteException -> 0x0176 }
            r8[r14] = r9     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ SQLiteException -> 0x0176 }
            r8[r15] = r0     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.String r0 = java.lang.String.format(r6, r8)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ SQLiteException -> 0x0176 }
            goto L_0x016a
        L_0x014b:
            r5 = 3
            r7 = 2
            java.lang.String r0 = "HitString for hitId %d too large. Hit will be deleted."
            java.lang.Object[] r6 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.Object r8 = r2.get(r1)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzeh r8 = (com.google.android.gms.internal.gtm.zzeh) r8     // Catch:{ SQLiteException -> 0x0176 }
            long r8 = r8.zzih()     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x0176 }
            r6[r14] = r8     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.String r0 = java.lang.String.format(r0, r6)     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ SQLiteException -> 0x0176 }
        L_0x0168:
            int r1 = r1 + 1
        L_0x016a:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0176 }
            if (r0 != 0) goto L_0x00ba
        L_0x0170:
            if (r13 == 0) goto L_0x0175
            r13.close()
        L_0x0175:
            return r2
        L_0x0176:
            r0 = move-exception
            goto L_0x0188
        L_0x0178:
            r0 = move-exception
            r13 = r18
            goto L_0x01d4
        L_0x017c:
            r0 = move-exception
            r13 = r18
            goto L_0x0188
        L_0x0180:
            r0 = move-exception
            r18 = r13
            goto L_0x01d4
        L_0x0184:
            r0 = move-exception
            r2 = r12
            r18 = r13
        L_0x0188:
            java.lang.String r1 = "Error in peekHits fetching hit url: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01d3 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01d3 }
            int r3 = r0.length()     // Catch:{ all -> 0x01d3 }
            if (r3 == 0) goto L_0x019d
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x01d3 }
            goto L_0x01a2
        L_0x019d:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x01d3 }
            r0.<init>(r1)     // Catch:{ all -> 0x01d3 }
        L_0x01a2:
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ all -> 0x01d3 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x01d3 }
            r0.<init>()     // Catch:{ all -> 0x01d3 }
            r12 = r2
            java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x01d3 }
            int r1 = r12.size()     // Catch:{ all -> 0x01d3 }
            r2 = 0
        L_0x01b2:
            if (r14 >= r1) goto L_0x01cd
            java.lang.Object r3 = r12.get(r14)     // Catch:{ all -> 0x01d3 }
            int r14 = r14 + 1
            com.google.android.gms.internal.gtm.zzeh r3 = (com.google.android.gms.internal.gtm.zzeh) r3     // Catch:{ all -> 0x01d3 }
            java.lang.String r5 = r3.zzij()     // Catch:{ all -> 0x01d3 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01d3 }
            if (r5 == 0) goto L_0x01c9
            if (r2 != 0) goto L_0x01cd
            r2 = 1
        L_0x01c9:
            r0.add(r3)     // Catch:{ all -> 0x01d3 }
            goto L_0x01b2
        L_0x01cd:
            if (r13 == 0) goto L_0x01d2
            r13.close()
        L_0x01d2:
            return r0
        L_0x01d3:
            r0 = move-exception
        L_0x01d4:
            if (r13 == 0) goto L_0x01d9
            r13.close()
        L_0x01d9:
            throw r0
        L_0x01da:
            r0 = move-exception
            r2 = r12
            goto L_0x01e4
        L_0x01dd:
            r0 = move-exception
            r18 = r13
            r14 = r18
            goto L_0x0212
        L_0x01e3:
            r0 = move-exception
        L_0x01e4:
            r18 = r13
            r14 = r18
            goto L_0x01ee
        L_0x01e9:
            r0 = move-exception
            r14 = 0
            goto L_0x0212
        L_0x01ec:
            r0 = move-exception
            r14 = 0
        L_0x01ee:
            java.lang.String r1 = "Error in peekHits fetching hitIds: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0211 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0211 }
            int r3 = r0.length()     // Catch:{ all -> 0x0211 }
            if (r3 == 0) goto L_0x0203
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0211 }
            goto L_0x0208
        L_0x0203:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0211 }
            r0.<init>(r1)     // Catch:{ all -> 0x0211 }
        L_0x0208:
            com.google.android.gms.internal.gtm.zzev.zzac(r0)     // Catch:{ all -> 0x0211 }
            if (r14 == 0) goto L_0x0210
            r14.close()
        L_0x0210:
            return r2
        L_0x0211:
            r0 = move-exception
        L_0x0212:
            if (r14 == 0) goto L_0x0217
            r14.close()
        L_0x0217:
            goto L_0x0219
        L_0x0218:
            throw r0
        L_0x0219:
            goto L_0x0218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzey.zzaa(int):java.util.List");
    }

    private final void zza(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzau = zzau("Error opening database for deleteHits.");
            if (zzau != null) {
                boolean z = true;
                try {
                    zzau.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    zzen zzen = this.zzaol;
                    if (zzbv("gtm_hits") != 0) {
                        z = false;
                    }
                    zzen.zze(z);
                } catch (SQLiteException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    zzev.zzac(valueOf.length() != 0 ? "Error deleting hits: ".concat(valueOf) : new String("Error deleting hits: "));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zze(long j) {
        zza(new String[]{String.valueOf(j)});
    }

    /* access modifiers changed from: private */
    public final void zzb(long j, long j2) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        if (zzau != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzau.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e2) {
                String message = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 70);
                sb.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId ");
                sb.append(j);
                sb.append(": ");
                sb.append(message);
                zzev.zzac(sb.toString());
                zze(j);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    private final int zzbv(String str) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumRecords.");
        int i = 0;
        if (zzau == null) {
            return 0;
        }
        ? r2 = 0;
        try {
            String valueOf = String.valueOf(str);
            Cursor rawQuery = zzau.rawQuery(valueOf.length() != 0 ? "SELECT COUNT(*) from ".concat(valueOf) : new String("SELECT COUNT(*) from "), r2);
            if (rawQuery.moveToFirst()) {
                i = (int) rawQuery.getLong(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (SQLiteException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            zzev.zzac(valueOf2.length() != 0 ? "Error getting numStoredRecords: ".concat(valueOf2) : new String("Error getting numStoredRecords: "));
            if (r2 != 0) {
                r2.close();
            }
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
        return i;
    }

    private final int zziw() {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        int i = 0;
        if (zzau == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            Cursor query = zzau.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", (String[]) null, (String) null, (String) null, (String) null);
            i = query.getCount();
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzev.zzac(valueOf.length() != 0 ? "Error getting num untried hits: ".concat(valueOf) : new String("Error getting num untried hits: "));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return i;
    }

    public final void dispatch() {
        zzev.zzab("GTM Dispatch running...");
        if (this.zzaok.zzhy()) {
            List<zzeh> zzaa = zzaa(40);
            if (zzaa.isEmpty()) {
                zzev.zzab("...nothing to dispatch");
                this.zzaol.zze(true);
                return;
            }
            this.zzaok.zzd(zzaa);
            if (zziw() > 0) {
                zzfo.zzkv().dispatch();
            }
        }
    }

    private final SQLiteDatabase zzau(String str) {
        try {
            return this.zzaoj.getWritableDatabase();
        } catch (SQLiteException e2) {
            Context context = this.zzrm;
            zzev.zzb(str, e2);
            if (CrashUtils.addDynamiteErrorToDropBox(context, e2)) {
                zzev.zzab("Crash reported successfully.");
                return null;
            }
            zzev.zzab("Failed to report crash");
            return null;
        }
    }
}
