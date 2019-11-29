package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

final class av implements Continuation<Bundle, String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ au f14142a;

    av(au auVar) {
        this.f14142a = auVar;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        return au.a((Bundle) task.getResult(IOException.class));
    }
}
