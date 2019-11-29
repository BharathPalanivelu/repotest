package com.tencent.imsdk;

import com.tencent.imcore.IApplyDownloadFileCallback;
import com.tencent.imcore.StrVec;
import java.util.ArrayList;
import java.util.List;

abstract class af<T> extends IApplyDownloadFileCallback {

    /* renamed from: a  reason: collision with root package name */
    public T f30689a;

    public af(T t) {
        swigReleaseOwnership();
        this.f30689a = t;
    }

    public abstract void a(int i, String str);

    public abstract void a(List<String> list);

    public void done(StrVec strVec) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; ((long) i) < strVec.size(); i++) {
            arrayList.add(strVec.get(i));
        }
        IMMsfCoreProxy.mainHandler.post(new ag(this, arrayList));
        swigTakeOwnership();
    }

    public void fail(int i, String str) {
        IMMsfCoreProxy.mainHandler.post(new ah(this, i, str));
        swigTakeOwnership();
    }
}
