package com.google.c;

import com.google.c.a;
import com.google.c.s;
import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class r extends a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected static boolean f14002a = false;
    private static final long serialVersionUID = 1;
    protected at unknownFields = at.f();

    protected interface b extends a.b {
    }

    protected r() {
    }

    public static abstract class a<BuilderType extends a<BuilderType>> extends a.C0223a<BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        private b f14003a;

        /* renamed from: b  reason: collision with root package name */
        private at f14004b;

        protected a() {
            this((b) null);
        }

        protected a(b bVar) {
            this.f14004b = at.f();
            this.f14003a = bVar;
        }

        /* renamed from: e */
        public BuilderType clone() {
            BuilderType buildertype = (a) L().H();
            buildertype.c(t());
            return buildertype;
        }
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new s.i(this);
    }
}
