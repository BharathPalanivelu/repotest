package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.internal.ih;
import com.google.android.libraries.places.internal.ii;
import com.google.android.libraries.places.internal.ij;
import com.google.android.libraries.places.internal.ik;
import com.google.android.libraries.places.internal.ip;
import com.google.android.libraries.places.internal.is;
import com.google.android.libraries.places.internal.iy;
import com.google.android.libraries.places.internal.jd;
import com.google.android.libraries.places.internal.jf;
import com.google.android.libraries.places.internal.ji;
import com.google.android.libraries.places.internal.jl;
import com.google.android.libraries.places.internal.jm;
import java.util.Locale;

public class ds implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final ClearcutLogger f12472a;

    /* renamed from: b  reason: collision with root package name */
    public final dw f12473b;

    /* renamed from: c  reason: collision with root package name */
    public final dz f12474c;

    public static ClearcutLogger a(Context context) {
        return (ClearcutLogger) lt.a(ClearcutLogger.anonymousLogger(context, "LE"), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public void a(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, Task<FindAutocompletePredictionsResponse> task, long j, long j2) {
        MessageType messagetype;
        MessageType messagetype2;
        MessageType messagetype3;
        MessageType messagetype4;
        MessageType messagetype5;
        MessageType messagetype6;
        ip.a aVar = (ip.a) ip.f12736c.f();
        if (findAutocompletePredictionsRequest.getTypeFilter() != null) {
            String a2 = ar.a(findAutocompletePredictionsRequest.getTypeFilter());
            aVar.b();
            ip ipVar = (ip) aVar.f12904a;
            if (a2 != null) {
                if (!ipVar.f12739b.a()) {
                    ipVar.f12739b = kv.a(ipVar.f12739b);
                }
                ipVar.f12739b.add(a2);
            } else {
                throw new NullPointerException();
            }
        }
        if (aVar.f12905b) {
            messagetype = aVar.f12904a;
        } else {
            aVar.f12904a.e();
            aVar.f12905b = true;
            messagetype = aVar.f12904a;
        }
        kv kvVar = (kv) messagetype;
        if (kvVar.g()) {
            ip ipVar2 = (ip) kvVar;
            is.a aVar2 = (is.a) is.f12750d.f();
            if (ipVar2 != null) {
                aVar2.b();
                is isVar = (is) aVar2.f12904a;
                if (ipVar2 != null) {
                    isVar.f12754c = ipVar2;
                    isVar.f12752a |= 4;
                } else {
                    throw new NullPointerException();
                }
            }
            if (aVar2.f12905b) {
                messagetype2 = aVar2.f12904a;
            } else {
                aVar2.f12904a.e();
                aVar2.f12905b = true;
                messagetype2 = aVar2.f12904a;
            }
            kv kvVar2 = (kv) messagetype2;
            if (kvVar2.g()) {
                is isVar2 = (is) kvVar2;
                jm.a a3 = a().a(jm.b.AUTOCOMPLETE);
                a3.b();
                jm jmVar = (jm) a3.f12904a;
                if (isVar2 != null) {
                    jmVar.i = isVar2;
                    jmVar.f12834a |= 256;
                    if (a3.f12905b) {
                        messagetype3 = a3.f12904a;
                    } else {
                        a3.f12904a.e();
                        a3.f12905b = true;
                        messagetype3 = a3.f12904a;
                    }
                    kv kvVar3 = (kv) messagetype3;
                    if (kvVar3.g()) {
                        iy.a a4 = dv.a(this.f12473b).a(iy.b.PLACES_QUERY).a((jm) kvVar3);
                        if (findAutocompletePredictionsRequest.getSessionToken() != null) {
                            a4.a(findAutocompletePredictionsRequest.getSessionToken().toString());
                        }
                        if (a4.f12905b) {
                            messagetype4 = a4.f12904a;
                        } else {
                            a4.f12904a.e();
                            a4.f12905b = true;
                            messagetype4 = a4.f12904a;
                        }
                        kv kvVar4 = (kv) messagetype4;
                        if (kvVar4.g()) {
                            a((iy) kvVar4);
                            int i = 0;
                            if (task.isSuccessful()) {
                                i = task.getResult().getAutocompletePredictions().size();
                            }
                            ii.a aVar3 = (ii.a) ii.f12705c.f();
                            aVar3.b();
                            ii iiVar = (ii) aVar3.f12904a;
                            iiVar.f12707a |= 1;
                            iiVar.f12708b = i;
                            if (aVar3.f12905b) {
                                messagetype5 = aVar3.f12904a;
                            } else {
                                aVar3.f12904a.e();
                                aVar3.f12905b = true;
                                messagetype5 = aVar3.f12904a;
                            }
                            kv kvVar5 = (kv) messagetype5;
                            if (kvVar5.g()) {
                                ii iiVar2 = (ii) kvVar5;
                                ik.a a5 = ik.a().a(ik.b.GET_AUTOCOMPLETE_PREDICTIONS);
                                a5.b();
                                ik ikVar = (ik) a5.f12904a;
                                if (iiVar2 != null) {
                                    ikVar.f12720g = iiVar2;
                                    ikVar.f12714a |= 512;
                                    ik.a a6 = a5.a(a(task)).a((int) (j2 - j));
                                    if (a6.f12905b) {
                                        messagetype6 = a6.f12904a;
                                    } else {
                                        a6.f12904a.e();
                                        a6.f12905b = true;
                                        messagetype6 = a6.f12904a;
                                    }
                                    kv kvVar6 = (kv) messagetype6;
                                    if (kvVar6.g()) {
                                        a((ik) kvVar6);
                                        return;
                                    }
                                    throw new ne();
                                }
                                throw new NullPointerException();
                            }
                            throw new ne();
                        }
                        throw new ne();
                    }
                    throw new ne();
                }
                throw new NullPointerException();
            }
            throw new ne();
        }
        throw new ne();
    }

    public void a(FetchPlaceRequest fetchPlaceRequest, Task<FetchPlaceResponse> task, long j, long j2) {
        MessageType messagetype;
        MessageType messagetype2;
        MessageType messagetype3;
        MessageType messagetype4;
        MessageType messagetype5;
        MessageType messagetype6;
        jd.a aVar = (jd.a) jd.f12801c.f();
        aVar.b();
        ((jd) aVar.f12904a).f12803a |= 2;
        jl.a a2 = jl.a().a(aq.a(fetchPlaceRequest.getPlaceFields()));
        if (a2.f12905b) {
            messagetype = a2.f12904a;
        } else {
            a2.f12904a.e();
            a2.f12905b = true;
            messagetype = a2.f12904a;
        }
        kv kvVar = (kv) messagetype;
        if (kvVar.g()) {
            jl jlVar = (jl) kvVar;
            aVar.b();
            jd jdVar = (jd) aVar.f12904a;
            if (jlVar != null) {
                jdVar.f12804b = jlVar;
                jdVar.f12803a |= 4;
                if (aVar.f12905b) {
                    messagetype2 = aVar.f12904a;
                } else {
                    aVar.f12904a.e();
                    aVar.f12905b = true;
                    messagetype2 = aVar.f12904a;
                }
                kv kvVar2 = (kv) messagetype2;
                if (kvVar2.g()) {
                    jd jdVar2 = (jd) kvVar2;
                    jm.a a3 = a().a(jm.b.BY_ID);
                    a3.b();
                    jm jmVar = (jm) a3.f12904a;
                    if (jdVar2 != null) {
                        jmVar.h = jdVar2;
                        jmVar.f12834a |= 128;
                        if (a3.f12905b) {
                            messagetype3 = a3.f12904a;
                        } else {
                            a3.f12904a.e();
                            a3.f12905b = true;
                            messagetype3 = a3.f12904a;
                        }
                        kv kvVar3 = (kv) messagetype3;
                        if (kvVar3.g()) {
                            iy.a a4 = dv.a(this.f12473b).a(iy.b.PLACES_QUERY).a((jm) kvVar3);
                            if (fetchPlaceRequest.getSessionToken() != null) {
                                a4.a(fetchPlaceRequest.getSessionToken().toString());
                            }
                            if (a4.f12905b) {
                                messagetype4 = a4.f12904a;
                            } else {
                                a4.f12904a.e();
                                a4.f12905b = true;
                                messagetype4 = a4.f12904a;
                            }
                            kv kvVar4 = (kv) messagetype4;
                            if (kvVar4.g()) {
                                a((iy) kvVar4);
                                boolean isSuccessful = task.isSuccessful();
                                ij.a aVar2 = (ij.a) ij.f12709d.f();
                                aVar2.b();
                                ij ijVar = (ij) aVar2.f12904a;
                                ijVar.f12711a |= 1;
                                ijVar.f12712b = 1;
                                aVar2.b();
                                ij ijVar2 = (ij) aVar2.f12904a;
                                ijVar2.f12711a |= 2;
                                ijVar2.f12713c = isSuccessful ? 1 : 0;
                                if (aVar2.f12905b) {
                                    messagetype5 = aVar2.f12904a;
                                } else {
                                    aVar2.f12904a.e();
                                    aVar2.f12905b = true;
                                    messagetype5 = aVar2.f12904a;
                                }
                                kv kvVar5 = (kv) messagetype5;
                                if (kvVar5.g()) {
                                    ij ijVar3 = (ij) kvVar5;
                                    ik.a a5 = ik.a().a(ik.b.GET_PLACE_BY_ID);
                                    a5.b();
                                    ik ikVar = (ik) a5.f12904a;
                                    if (ijVar3 != null) {
                                        ikVar.f12718e = ijVar3;
                                        ikVar.f12714a |= 32;
                                        ik.a a6 = a5.a(a(task)).a((int) (j2 - j));
                                        if (a6.f12905b) {
                                            messagetype6 = a6.f12904a;
                                        } else {
                                            a6.f12904a.e();
                                            a6.f12905b = true;
                                            messagetype6 = a6.f12904a;
                                        }
                                        kv kvVar6 = (kv) messagetype6;
                                        if (kvVar6.g()) {
                                            a((ik) kvVar6);
                                            return;
                                        }
                                        throw new ne();
                                    }
                                    throw new NullPointerException();
                                }
                                throw new ne();
                            }
                            throw new ne();
                        }
                        throw new ne();
                    }
                    throw new NullPointerException();
                }
                throw new ne();
            }
            throw new NullPointerException();
        }
        throw new ne();
    }

    public void a(FindCurrentPlaceRequest findCurrentPlaceRequest, Task<FindCurrentPlaceResponse> task, long j, long j2, long j3) {
        jf.b bVar;
        MessageType messagetype;
        MessageType messagetype2;
        MessageType messagetype3;
        MessageType messagetype4;
        MessageType messagetype5;
        if (task.isSuccessful()) {
            bVar = jf.b.NEARBY_SEARCH;
        } else {
            bVar = jf.b.NO_RESULT;
        }
        jf.a aVar = (jf.a) jf.f12810e.f();
        jl.a a2 = jl.a().a(aq.a(findCurrentPlaceRequest.getPlaceFields()));
        if (a2.f12905b) {
            messagetype = a2.f12904a;
        } else {
            a2.f12904a.e();
            a2.f12905b = true;
            messagetype = a2.f12904a;
        }
        kv kvVar = (kv) messagetype;
        if (kvVar.g()) {
            jl jlVar = (jl) kvVar;
            aVar.b();
            jf jfVar = (jf) aVar.f12904a;
            if (jlVar != null) {
                jfVar.f12815d = jlVar;
                jfVar.f12812a |= 8;
                int i = (int) (j3 - j);
                aVar.b();
                jf jfVar2 = (jf) aVar.f12904a;
                jfVar2.f12812a |= 4;
                jfVar2.f12814c = i;
                aVar.b();
                jf jfVar3 = (jf) aVar.f12904a;
                if (bVar != null) {
                    jfVar3.f12812a |= 2;
                    jfVar3.f12813b = bVar.f12820c;
                    if (aVar.f12905b) {
                        messagetype2 = aVar.f12904a;
                    } else {
                        aVar.f12904a.e();
                        aVar.f12905b = true;
                        messagetype2 = aVar.f12904a;
                    }
                    kv kvVar2 = (kv) messagetype2;
                    if (kvVar2.g()) {
                        jf jfVar4 = (jf) kvVar2;
                        iy.a a3 = dv.a(this.f12473b).a(iy.b.GET_CURRENT_PLACE);
                        a3.b();
                        iy iyVar = (iy) a3.f12904a;
                        if (jfVar4 != null) {
                            iyVar.h = jfVar4;
                            iyVar.f12776a |= 1024;
                            if (a3.f12905b) {
                                messagetype3 = a3.f12904a;
                            } else {
                                a3.f12904a.e();
                                a3.f12905b = true;
                                messagetype3 = a3.f12904a;
                            }
                            kv kvVar3 = (kv) messagetype3;
                            if (kvVar3.g()) {
                                a((iy) kvVar3);
                                if (j2 != -1) {
                                    int i2 = 0;
                                    if (task.isSuccessful()) {
                                        i2 = task.getResult().getPlaceLikelihoods().size();
                                    }
                                    ih.a aVar2 = (ih.a) ih.f12701c.f();
                                    aVar2.b();
                                    ih ihVar = (ih) aVar2.f12904a;
                                    ihVar.f12703a |= 1;
                                    ihVar.f12704b = i2;
                                    if (aVar2.f12905b) {
                                        messagetype4 = aVar2.f12904a;
                                    } else {
                                        aVar2.f12904a.e();
                                        aVar2.f12905b = true;
                                        messagetype4 = aVar2.f12904a;
                                    }
                                    kv kvVar4 = (kv) messagetype4;
                                    if (kvVar4.g()) {
                                        ih ihVar2 = (ih) kvVar4;
                                        ik.a a4 = ik.a().a(ik.b.ESTIMATE_PLACES_BY_LOCATION);
                                        a4.b();
                                        ik ikVar = (ik) a4.f12904a;
                                        if (ihVar2 != null) {
                                            ikVar.f12719f = ihVar2;
                                            ikVar.f12714a |= 128;
                                            ik.a a5 = a4.a(a(task)).a((int) (j3 - j2));
                                            if (a5.f12905b) {
                                                messagetype5 = a5.f12904a;
                                            } else {
                                                a5.f12904a.e();
                                                a5.f12905b = true;
                                                messagetype5 = a5.f12904a;
                                            }
                                            kv kvVar5 = (kv) messagetype5;
                                            if (kvVar5.g()) {
                                                a((ik) kvVar5);
                                                return;
                                            }
                                            throw new ne();
                                        }
                                        throw new NullPointerException();
                                    }
                                    throw new ne();
                                }
                                return;
                            }
                            throw new ne();
                        }
                        throw new NullPointerException();
                    }
                    throw new ne();
                }
                throw new NullPointerException();
            }
            throw new NullPointerException();
        }
        throw new ne();
    }

    public void a(Task<FetchPhotoResponse> task, long j, long j2) {
        MessageType messagetype;
        MessageType messagetype2;
        MessageType messagetype3;
        ji.a aVar = (ji.a) ji.f12822c.f();
        ji.b bVar = ji.b.PHOTO_IMAGE;
        aVar.b();
        ji jiVar = (ji) aVar.f12904a;
        if (bVar != null) {
            jiVar.f12824a |= 1;
            jiVar.f12825b = bVar.f12829b;
            if (aVar.f12905b) {
                messagetype = aVar.f12904a;
            } else {
                aVar.f12904a.e();
                aVar.f12905b = true;
                messagetype = aVar.f12904a;
            }
            kv kvVar = (kv) messagetype;
            if (kvVar.g()) {
                ji jiVar2 = (ji) kvVar;
                iy.a a2 = dv.a(this.f12473b).a(iy.b.PLACE_PHOTO_QUERY);
                a2.b();
                iy iyVar = (iy) a2.f12904a;
                if (jiVar2 != null) {
                    iyVar.f12782g = jiVar2;
                    iyVar.f12776a |= 512;
                    if (a2.f12905b) {
                        messagetype2 = a2.f12904a;
                    } else {
                        a2.f12904a.e();
                        a2.f12905b = true;
                        messagetype2 = a2.f12904a;
                    }
                    kv kvVar2 = (kv) messagetype2;
                    if (kvVar2.g()) {
                        a((iy) kvVar2);
                        ik.a a3 = ik.a().a(ik.b.GET_PHOTO).a(a(task)).a((int) (j2 - j));
                        if (a3.f12905b) {
                            messagetype3 = a3.f12904a;
                        } else {
                            a3.f12904a.e();
                            a3.f12905b = true;
                            messagetype3 = a3.f12904a;
                        }
                        kv kvVar3 = (kv) messagetype3;
                        if (kvVar3.g()) {
                            a((ik) kvVar3);
                            return;
                        }
                        throw new ne();
                    }
                    throw new ne();
                }
                throw new NullPointerException();
            }
            throw new ne();
        }
        throw new NullPointerException();
    }

    public ds(ClearcutLogger clearcutLogger, dw dwVar, dz dzVar) {
        this.f12472a = clearcutLogger;
        this.f12473b = dwVar;
        this.f12474c = dzVar;
    }

    public jm.a a() {
        Locale c2 = this.f12474c.c();
        Locale locale = Locale.getDefault();
        jm.a aVar = (jm.a) jm.j.f();
        String locale2 = c2.toString();
        aVar.b();
        jm jmVar = (jm) aVar.f12904a;
        if (locale2 != null) {
            jmVar.f12834a |= 2;
            jmVar.f12836c = locale2;
            if (!c2.equals(locale)) {
                String locale3 = locale.toString();
                aVar.b();
                jm jmVar2 = (jm) aVar.f12904a;
                if (locale3 != null) {
                    jmVar2.f12834a |= 4;
                    jmVar2.f12837d = locale3;
                } else {
                    throw new NullPointerException();
                }
            }
            return aVar;
        }
        throw new NullPointerException();
    }

    public void a(ik ikVar) {
        MessageType messagetype;
        iy.a a2 = dv.a(this.f12473b).a(iy.b.NETWORK_REQUEST_EVENT);
        a2.b();
        iy iyVar = (iy) a2.f12904a;
        if (ikVar != null) {
            iyVar.j = ikVar;
            iyVar.f12776a |= 8388608;
            if (a2.f12905b) {
                messagetype = a2.f12904a;
            } else {
                a2.f12904a.e();
                a2.f12905b = true;
                messagetype = a2.f12904a;
            }
            kv kvVar = (kv) messagetype;
            if (kvVar.g()) {
                a((iy) kvVar);
                return;
            }
            throw new ne();
        }
        throw new NullPointerException();
    }

    public void a(iy iyVar) {
        this.f12472a.newEvent(dv.a(iyVar).c()).log();
    }

    public <ResponseT extends az> ik.c a(Task<ResponseT> task) {
        if (task.isSuccessful()) {
            return ik.c.SUCCESS;
        }
        int statusCode = a(task.getException()).getStatusCode();
        if (statusCode == 7) {
            return ik.c.NETWORK_ERROR;
        }
        if (statusCode != 15) {
            return ik.c.INVALID;
        }
        return ik.c.TIMEOUT;
    }

    public static ApiException a(Exception exc) {
        if (exc instanceof ApiException) {
            return (ApiException) exc;
        }
        return new ApiException(new Status(13, exc.getMessage()));
    }
}
