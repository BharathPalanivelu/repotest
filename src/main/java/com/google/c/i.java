package com.google.c;

import com.appsflyer.share.Constants;
import com.google.c.at;
import com.google.c.j;
import com.google.c.t;
import com.google.c.u;
import com.litesuits.orm.db.assit.SQLStatement;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.imsdk.TIMGroupManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class i {
    /* access modifiers changed from: private */
    public static final j.a A = a().g().get(11);
    /* access modifiers changed from: private */
    public static final t.f B = new t.f(A, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption"});
    /* access modifiers changed from: private */
    public static final j.a C = a().g().get(12);
    /* access modifiers changed from: private */
    public static final t.f D = new t.f(C, new String[]{"UninterpretedOption"});
    /* access modifiers changed from: private */
    public static final j.a E = a().g().get(13);
    /* access modifiers changed from: private */
    public static final t.f F = new t.f(E, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});
    /* access modifiers changed from: private */
    public static final j.a G = a().g().get(14);
    /* access modifiers changed from: private */
    public static final t.f H = new t.f(G, new String[]{"Deprecated", "UninterpretedOption"});
    /* access modifiers changed from: private */
    public static final j.a I = a().g().get(15);
    /* access modifiers changed from: private */
    public static final t.f J = new t.f(I, new String[]{"Deprecated", "UninterpretedOption"});
    /* access modifiers changed from: private */
    public static final j.a K = a().g().get(16);
    /* access modifiers changed from: private */
    public static final t.f L = new t.f(K, new String[]{"Deprecated", "UninterpretedOption"});
    /* access modifiers changed from: private */
    public static final j.a M = a().g().get(17);
    /* access modifiers changed from: private */
    public static final t.f N = new t.f(M, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
    /* access modifiers changed from: private */
    public static final j.a O = M.h().get(0);
    /* access modifiers changed from: private */
    public static final t.f P = new t.f(O, new String[]{"NamePart", "IsExtension"});
    /* access modifiers changed from: private */
    public static final j.a Q = a().g().get(18);
    /* access modifiers changed from: private */
    public static final t.f R = new t.f(Q, new String[]{Constants.HTTP_REDIRECT_URL_HEADER_FIELD});
    /* access modifiers changed from: private */
    public static final j.a S = Q.h().get(0);
    /* access modifiers changed from: private */
    public static final t.f T = new t.f(S, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
    private static final j.a U = a().g().get(19);
    private static final t.f V = new t.f(U, new String[]{"Annotation"});
    private static final j.a W = U.h().get(0);
    private static final t.f X = new t.f(W, new String[]{"Path", "SourceFile", "Begin", "End"});
    /* access modifiers changed from: private */
    public static j.g Y;

    /* renamed from: a  reason: collision with root package name */
    private static final j.a f13729a = a().g().get(0);

    /* renamed from: b  reason: collision with root package name */
    private static final t.f f13730b = new t.f(f13729a, new String[]{"File"});
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final j.a f13731c = a().g().get(1);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final t.f f13732d = new t.f(f13731c, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final j.a f13733e = a().g().get(2);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final t.f f13734f = new t.f(f13733e, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final j.a f13735g = f13733e.h().get(0);
    /* access modifiers changed from: private */
    public static final t.f h = new t.f(f13735g, new String[]{"Start", "End"});
    /* access modifiers changed from: private */
    public static final j.a i = f13733e.h().get(1);
    /* access modifiers changed from: private */
    public static final t.f j = new t.f(i, new String[]{"Start", "End"});
    /* access modifiers changed from: private */
    public static final j.a k = a().g().get(3);
    /* access modifiers changed from: private */
    public static final t.f l = new t.f(k, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options"});
    /* access modifiers changed from: private */
    public static final j.a m = a().g().get(4);
    /* access modifiers changed from: private */
    public static final t.f n = new t.f(m, new String[]{"Name", "Options"});
    /* access modifiers changed from: private */
    public static final j.a o = a().g().get(5);
    /* access modifiers changed from: private */
    public static final t.f p = new t.f(o, new String[]{"Name", "Value", "Options"});
    /* access modifiers changed from: private */
    public static final j.a q = a().g().get(6);
    /* access modifiers changed from: private */
    public static final t.f r = new t.f(q, new String[]{"Name", "Number", "Options"});
    /* access modifiers changed from: private */
    public static final j.a s = a().g().get(7);
    /* access modifiers changed from: private */
    public static final t.f t = new t.f(s, new String[]{"Name", "Method", "Options"});
    /* access modifiers changed from: private */
    public static final j.a u = a().g().get(8);
    /* access modifiers changed from: private */
    public static final t.f v = new t.f(u, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
    /* access modifiers changed from: private */
    public static final j.a w = a().g().get(9);
    /* access modifiers changed from: private */
    public static final t.f x = new t.f(w, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "UninterpretedOption"});
    /* access modifiers changed from: private */
    public static final j.a y = a().g().get(10);
    /* access modifiers changed from: private */
    public static final t.f z = new t.f(y, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});

    public interface ab extends t.e {
    }

    public interface ad extends ag {
    }

    public interface af extends t.e {
    }

    public interface ah extends ag {
    }

    public interface aj extends ag {
    }

    public interface b extends ag {
    }

    public interface d extends ag {
    }

    public interface f extends t.e {
    }

    public interface h extends ag {
    }

    public interface j extends t.e {
    }

    public interface l extends ag {
    }

    public interface n extends t.e {
    }

    public interface p extends ag {
    }

    public interface r extends t.e {
    }

    public interface t extends t.e {
    }

    public interface v extends ag {
    }

    public interface x extends t.e {
    }

    public interface z extends ag {
    }

    public static final class o extends t implements p {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<o> f13855a = new c<o>() {
            /* renamed from: a */
            public o b(g gVar, p pVar) throws v {
                return new o(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final o f13856c = new o();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public z dependency_;
        /* access modifiers changed from: private */
        public List<c> enumType_;
        /* access modifiers changed from: private */
        public List<k> extension_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<a> messageType_;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public q options_;
        /* access modifiers changed from: private */
        public volatile Object package_;
        /* access modifiers changed from: private */
        public List<Integer> publicDependency_;
        /* access modifiers changed from: private */
        public List<ac> service_;
        /* access modifiers changed from: private */
        public ag sourceCodeInfo_;
        /* access modifiers changed from: private */
        public volatile Object syntax_;
        /* access modifiers changed from: private */
        public List<Integer> weakDependency_;

        private o(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private o() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.package_ = "";
            this.dependency_ = y.f14071a;
            this.publicDependency_ = Collections.emptyList();
            this.weakDependency_ = Collections.emptyList();
            this.messageType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.service_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.syntax_ = "";
        }

        public final at f() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: com.google.c.i$q$a} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: com.google.c.i$ag$a} */
        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r11v36 */
        /* JADX WARNING: type inference failed for: r11v37 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private o(com.google.c.g r14, com.google.c.p r15) throws com.google.c.v {
            /*
                r13 = this;
                r13.<init>()
                com.google.c.at$a r0 = com.google.c.at.c()
                r1 = 0
                r2 = 0
            L_0x0009:
                r3 = 256(0x100, float:3.59E-43)
                r4 = 128(0x80, float:1.794E-43)
                r5 = 64
                r6 = 32
                r7 = 4
                r8 = 16
                r9 = 8
                if (r1 != 0) goto L_0x0235
                int r10 = r14.a()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11 = 0
                r12 = 1
                switch(r10) {
                    case 0: goto L_0x01be;
                    case 10: goto L_0x01b1;
                    case 18: goto L_0x01a3;
                    case 26: goto L_0x018b;
                    case 34: goto L_0x0171;
                    case 42: goto L_0x0157;
                    case 50: goto L_0x013d;
                    case 58: goto L_0x0123;
                    case 66: goto L_0x00fa;
                    case 74: goto L_0x00d1;
                    case 80: goto L_0x00b5;
                    case 82: goto L_0x0081;
                    case 88: goto L_0x0066;
                    case 90: goto L_0x0033;
                    case 98: goto L_0x0027;
                    default: goto L_0x0021;
                }     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
            L_0x0021:
                boolean r3 = r13.a(r14, r0, r15, r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x01c1
            L_0x0027:
                com.google.c.f r10 = r14.m()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r11 = r13.bitField0_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11 = r11 | r8
                r13.bitField0_ = r11     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.syntax_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x0033:
                int r10 = r14.t()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r10 = r14.d(r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11 = r2 & 16
                if (r11 == r8) goto L_0x004e
                int r11 = r14.y()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                if (r11 <= 0) goto L_0x004e
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.weakDependency_ = r11     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 16
            L_0x004e:
                int r11 = r14.y()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                if (r11 <= 0) goto L_0x0062
                java.util.List<java.lang.Integer> r11 = r13.weakDependency_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r12 = r14.g()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.add(r12)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x004e
            L_0x0062:
                r14.e(r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x0066:
                r10 = r2 & 16
                if (r10 == r8) goto L_0x0073
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.weakDependency_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 16
            L_0x0073:
                java.util.List<java.lang.Integer> r10 = r13.weakDependency_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r11 = r14.g()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.add(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x0081:
                int r10 = r14.t()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r10 = r14.d(r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11 = r2 & 8
                if (r11 == r9) goto L_0x009c
                int r11 = r14.y()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                if (r11 <= 0) goto L_0x009c
                java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.publicDependency_ = r11     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 8
            L_0x009c:
                int r11 = r14.y()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                if (r11 <= 0) goto L_0x00b0
                java.util.List<java.lang.Integer> r11 = r13.publicDependency_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r12 = r14.g()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.add(r12)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x009c
            L_0x00b0:
                r14.e(r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x00b5:
                r10 = r2 & 8
                if (r10 == r9) goto L_0x00c2
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.publicDependency_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 8
            L_0x00c2:
                java.util.List<java.lang.Integer> r10 = r13.publicDependency_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r11 = r14.g()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.add(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x00d1:
                int r10 = r13.bitField0_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10 = r10 & r9
                if (r10 != r9) goto L_0x00dc
                com.google.c.i$ag r10 = r13.sourceCodeInfo_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.i$ag$a r11 = r10.I()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
            L_0x00dc:
                com.google.c.aj<com.google.c.i$ag> r10 = com.google.c.i.ag.f13774a     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.ad r10 = r14.a(r10, (com.google.c.p) r15)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.i$ag r10 = (com.google.c.i.ag) r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.sourceCodeInfo_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                if (r11 == 0) goto L_0x00f3
                com.google.c.i$ag r10 = r13.sourceCodeInfo_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.a((com.google.c.i.ag) r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.i$ag r10 = r11.v()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.sourceCodeInfo_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
            L_0x00f3:
                int r10 = r13.bitField0_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10 = r10 | r9
                r13.bitField0_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x00fa:
                int r10 = r13.bitField0_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10 = r10 & r7
                if (r10 != r7) goto L_0x0105
                com.google.c.i$q r10 = r13.options_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.i$q$a r11 = r10.I()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
            L_0x0105:
                com.google.c.aj<com.google.c.i$q> r10 = com.google.c.i.q.f13864a     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.ad r10 = r14.a(r10, (com.google.c.p) r15)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.i$q r10 = (com.google.c.i.q) r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.options_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                if (r11 == 0) goto L_0x011c
                com.google.c.i$q r10 = r13.options_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.a((com.google.c.i.q) r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.i$q r10 = r11.v()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.options_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
            L_0x011c:
                int r10 = r13.bitField0_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10 = r10 | r7
                r13.bitField0_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x0123:
                r10 = r2 & 256(0x100, float:3.59E-43)
                if (r10 == r3) goto L_0x0130
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.extension_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 256(0x100, float:3.59E-43)
            L_0x0130:
                java.util.List<com.google.c.i$k> r10 = r13.extension_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.aj<com.google.c.i$k> r11 = com.google.c.i.k.f13829a     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.ad r11 = r14.a(r11, (com.google.c.p) r15)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.add(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x013d:
                r10 = r2 & 128(0x80, float:1.794E-43)
                if (r10 == r4) goto L_0x014a
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.service_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 128(0x80, float:1.794E-43)
            L_0x014a:
                java.util.List<com.google.c.i$ac> r10 = r13.service_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.aj<com.google.c.i$ac> r11 = com.google.c.i.ac.f13760a     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.ad r11 = r14.a(r11, (com.google.c.p) r15)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.add(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x0157:
                r10 = r2 & 64
                if (r10 == r5) goto L_0x0164
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.enumType_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 64
            L_0x0164:
                java.util.List<com.google.c.i$c> r10 = r13.enumType_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.aj<com.google.c.i$c> r11 = com.google.c.i.c.f13801a     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.ad r11 = r14.a(r11, (com.google.c.p) r15)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.add(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x0171:
                r10 = r2 & 32
                if (r10 == r6) goto L_0x017e
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.messageType_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 32
            L_0x017e:
                java.util.List<com.google.c.i$a> r10 = r13.messageType_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.aj<com.google.c.i$a> r11 = com.google.c.i.a.f13736a     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                com.google.c.ad r11 = r14.a(r11, (com.google.c.p) r15)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r10.add(r11)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x018b:
                com.google.c.f r10 = r14.m()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11 = r2 & 4
                if (r11 == r7) goto L_0x019c
                com.google.c.y r11 = new com.google.c.y     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.<init>()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.dependency_ = r11     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r2 = r2 | 4
            L_0x019c:
                com.google.c.z r11 = r13.dependency_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11.a(r10)     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x01a3:
                com.google.c.f r10 = r14.m()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r11 = r13.bitField0_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11 = r11 | 2
                r13.bitField0_ = r11     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.package_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x01b1:
                com.google.c.f r10 = r14.m()     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                int r11 = r13.bitField0_     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r11 = r11 | r12
                r13.bitField0_ = r11     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                r13.name_ = r10     // Catch:{ v -> 0x01d1, IOException -> 0x01c6 }
                goto L_0x0009
            L_0x01be:
                r1 = 1
                goto L_0x0009
            L_0x01c1:
                if (r3 != 0) goto L_0x0009
                goto L_0x01be
            L_0x01c4:
                r14 = move-exception
                goto L_0x01d7
            L_0x01c6:
                r14 = move-exception
                com.google.c.v r15 = new com.google.c.v     // Catch:{ all -> 0x01c4 }
                r15.<init>((java.io.IOException) r14)     // Catch:{ all -> 0x01c4 }
                com.google.c.v r14 = r15.a(r13)     // Catch:{ all -> 0x01c4 }
                throw r14     // Catch:{ all -> 0x01c4 }
            L_0x01d1:
                r14 = move-exception
                com.google.c.v r14 = r14.a(r13)     // Catch:{ all -> 0x01c4 }
                throw r14     // Catch:{ all -> 0x01c4 }
            L_0x01d7:
                r15 = r2 & 4
                if (r15 != r7) goto L_0x01e3
                com.google.c.z r15 = r13.dependency_
                com.google.c.z r15 = r15.e()
                r13.dependency_ = r15
            L_0x01e3:
                r15 = r2 & 32
                if (r15 != r6) goto L_0x01ef
                java.util.List<com.google.c.i$a> r15 = r13.messageType_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.messageType_ = r15
            L_0x01ef:
                r15 = r2 & 64
                if (r15 != r5) goto L_0x01fb
                java.util.List<com.google.c.i$c> r15 = r13.enumType_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.enumType_ = r15
            L_0x01fb:
                r15 = r2 & 128(0x80, float:1.794E-43)
                if (r15 != r4) goto L_0x0207
                java.util.List<com.google.c.i$ac> r15 = r13.service_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.service_ = r15
            L_0x0207:
                r15 = r2 & 256(0x100, float:3.59E-43)
                if (r15 != r3) goto L_0x0213
                java.util.List<com.google.c.i$k> r15 = r13.extension_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.extension_ = r15
            L_0x0213:
                r15 = r2 & 8
                if (r15 != r9) goto L_0x021f
                java.util.List<java.lang.Integer> r15 = r13.publicDependency_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.publicDependency_ = r15
            L_0x021f:
                r15 = r2 & 16
                if (r15 != r8) goto L_0x022b
                java.util.List<java.lang.Integer> r15 = r13.weakDependency_
                java.util.List r15 = java.util.Collections.unmodifiableList(r15)
                r13.weakDependency_ = r15
            L_0x022b:
                com.google.c.at r15 = r0.w()
                r13.unknownFields = r15
                r13.Y()
                throw r14
            L_0x0235:
                r14 = r2 & 4
                if (r14 != r7) goto L_0x0241
                com.google.c.z r14 = r13.dependency_
                com.google.c.z r14 = r14.e()
                r13.dependency_ = r14
            L_0x0241:
                r14 = r2 & 32
                if (r14 != r6) goto L_0x024d
                java.util.List<com.google.c.i$a> r14 = r13.messageType_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.messageType_ = r14
            L_0x024d:
                r14 = r2 & 64
                if (r14 != r5) goto L_0x0259
                java.util.List<com.google.c.i$c> r14 = r13.enumType_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.enumType_ = r14
            L_0x0259:
                r14 = r2 & 128(0x80, float:1.794E-43)
                if (r14 != r4) goto L_0x0265
                java.util.List<com.google.c.i$ac> r14 = r13.service_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.service_ = r14
            L_0x0265:
                r14 = r2 & 256(0x100, float:3.59E-43)
                if (r14 != r3) goto L_0x0271
                java.util.List<com.google.c.i$k> r14 = r13.extension_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.extension_ = r14
            L_0x0271:
                r14 = r2 & 8
                if (r14 != r9) goto L_0x027d
                java.util.List<java.lang.Integer> r14 = r13.publicDependency_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.publicDependency_ = r14
            L_0x027d:
                r14 = r2 & 16
                if (r14 != r8) goto L_0x0289
                java.util.List<java.lang.Integer> r14 = r13.weakDependency_
                java.util.List r14 = java.util.Collections.unmodifiableList(r14)
                r13.weakDependency_ = r14
            L_0x0289:
                com.google.c.at r14 = r0.w()
                r13.unknownFields = r14
                r13.Y()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.o.<init>(com.google.c.g, com.google.c.p):void");
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.f13732d.a((Class<? extends t>) o.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public String i() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public boolean j() {
            return (this.bitField0_ & 2) == 2;
        }

        public String k() {
            Object obj = this.package_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.package_ = d2;
            }
            return d2;
        }

        public al l() {
            return this.dependency_;
        }

        public int m() {
            return this.dependency_.size();
        }

        public String a(int i) {
            return (String) this.dependency_.get(i);
        }

        public List<Integer> n() {
            return this.publicDependency_;
        }

        public int o() {
            return this.publicDependency_.size();
        }

        public int b(int i) {
            return this.publicDependency_.get(i).intValue();
        }

        public List<Integer> p() {
            return this.weakDependency_;
        }

        public int q() {
            return this.weakDependency_.size();
        }

        public List<a> r() {
            return this.messageType_;
        }

        public int s() {
            return this.messageType_.size();
        }

        public a c(int i) {
            return this.messageType_.get(i);
        }

        public List<c> t() {
            return this.enumType_;
        }

        public int u() {
            return this.enumType_.size();
        }

        public c d(int i) {
            return this.enumType_.get(i);
        }

        public List<ac> v() {
            return this.service_;
        }

        public int w() {
            return this.service_.size();
        }

        public ac e(int i) {
            return this.service_.get(i);
        }

        public List<k> x() {
            return this.extension_;
        }

        public int y() {
            return this.extension_.size();
        }

        public k f(int i) {
            return this.extension_.get(i);
        }

        public boolean z() {
            return (this.bitField0_ & 4) == 4;
        }

        public q A() {
            q qVar = this.options_;
            return qVar == null ? q.V() : qVar;
        }

        public boolean B() {
            return (this.bitField0_ & 8) == 8;
        }

        public ag C() {
            ag agVar = this.sourceCodeInfo_;
            return agVar == null ? ag.m() : agVar;
        }

        public boolean D() {
            return (this.bitField0_ & 16) == 16;
        }

        public String E() {
            Object obj = this.syntax_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.syntax_ = d2;
            }
            return d2;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < s(); i++) {
                if (!c(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < u(); i2++) {
                if (!d(i2).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < w(); i3++) {
                if (!e(i3).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < y(); i4++) {
                if (!f(i4).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!z() || A().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                t.a(hVar, 2, this.package_);
            }
            for (int i = 0; i < this.dependency_.size(); i++) {
                t.a(hVar, 3, this.dependency_.c(i));
            }
            for (int i2 = 0; i2 < this.messageType_.size(); i2++) {
                hVar.a(4, (ad) this.messageType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                hVar.a(5, (ad) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.service_.size(); i4++) {
                hVar.a(6, (ad) this.service_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                hVar.a(7, (ad) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                hVar.a(8, (ad) A());
            }
            if ((this.bitField0_ & 8) == 8) {
                hVar.a(9, (ad) C());
            }
            for (int i6 = 0; i6 < this.publicDependency_.size(); i6++) {
                hVar.b(10, this.publicDependency_.get(i6).intValue());
            }
            for (int i7 = 0; i7 < this.weakDependency_.size(); i7++) {
                hVar.b(11, this.weakDependency_.get(i7).intValue());
            }
            if ((this.bitField0_ & 16) == 16) {
                t.a(hVar, 12, this.syntax_);
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int a2 = (this.bitField0_ & 1) == 1 ? t.a(1, this.name_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                a2 += t.a(2, this.package_);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.dependency_.size(); i3++) {
                i2 += a(this.dependency_.c(i3));
            }
            int size = a2 + i2 + (l().size() * 1);
            for (int i4 = 0; i4 < this.messageType_.size(); i4++) {
                size += h.c(4, (ad) this.messageType_.get(i4));
            }
            for (int i5 = 0; i5 < this.enumType_.size(); i5++) {
                size += h.c(5, (ad) this.enumType_.get(i5));
            }
            for (int i6 = 0; i6 < this.service_.size(); i6++) {
                size += h.c(6, (ad) this.service_.get(i6));
            }
            for (int i7 = 0; i7 < this.extension_.size(); i7++) {
                size += h.c(7, (ad) this.extension_.get(i7));
            }
            if ((this.bitField0_ & 4) == 4) {
                size += h.c(8, (ad) A());
            }
            if ((this.bitField0_ & 8) == 8) {
                size += h.c(9, (ad) C());
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.publicDependency_.size(); i9++) {
                i8 += h.h(this.publicDependency_.get(i9).intValue());
            }
            int size2 = size + i8 + (n().size() * 1);
            int i10 = 0;
            for (int i11 = 0; i11 < this.weakDependency_.size(); i11++) {
                i10 += h.h(this.weakDependency_.get(i11).intValue());
            }
            int size3 = size2 + i10 + (p().size() * 1);
            if ((this.bitField0_ & 16) == 16) {
                size3 += t.a(12, this.syntax_);
            }
            int b2 = size3 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof o)) {
                return super.equals(obj);
            }
            o oVar = (o) obj;
            boolean z = h() == oVar.h();
            if (h()) {
                z = z && i().equals(oVar.i());
            }
            boolean z2 = z && j() == oVar.j();
            if (j()) {
                z2 = z2 && k().equals(oVar.k());
            }
            boolean z3 = (((((((z2 && l().equals(oVar.l())) && n().equals(oVar.n())) && p().equals(oVar.p())) && r().equals(oVar.r())) && t().equals(oVar.t())) && v().equals(oVar.v())) && x().equals(oVar.x())) && z() == oVar.z();
            if (z()) {
                z3 = z3 && A().equals(oVar.A());
            }
            boolean z4 = z3 && B() == oVar.B();
            if (B()) {
                z4 = z4 && C().equals(oVar.C());
            }
            boolean z5 = z4 && D() == oVar.D();
            if (D()) {
                z5 = z5 && E().equals(oVar.E());
            }
            if (!z5 || !this.unknownFields.equals(oVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
            }
            if (j()) {
                hashCode = (((hashCode * 37) + 2) * 53) + k().hashCode();
            }
            if (m() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + l().hashCode();
            }
            if (o() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + n().hashCode();
            }
            if (q() > 0) {
                hashCode = (((hashCode * 37) + 11) * 53) + p().hashCode();
            }
            if (s() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + r().hashCode();
            }
            if (u() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + t().hashCode();
            }
            if (w() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + v().hashCode();
            }
            if (y() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + x().hashCode();
            }
            if (z()) {
                hashCode = (((hashCode * 37) + 8) * 53) + A().hashCode();
            }
            if (B()) {
                hashCode = (((hashCode * 37) + 9) * 53) + C().hashCode();
            }
            if (D()) {
                hashCode = (((hashCode * 37) + 12) * 53) + E().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static o a(byte[] bArr) throws v {
            return f13855a.b(bArr);
        }

        public static o a(byte[] bArr, p pVar) throws v {
            return f13855a.b(bArr, pVar);
        }

        /* renamed from: G */
        public a J() {
            return M();
        }

        public static a M() {
            return f13856c.I();
        }

        /* renamed from: N */
        public a I() {
            if (this == f13856c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements p {

            /* renamed from: a  reason: collision with root package name */
            private int f13857a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13858b;

            /* renamed from: c  reason: collision with root package name */
            private Object f13859c;

            /* renamed from: d  reason: collision with root package name */
            private z f13860d;

            /* renamed from: e  reason: collision with root package name */
            private List<Integer> f13861e;

            /* renamed from: f  reason: collision with root package name */
            private List<Integer> f13862f;

            /* renamed from: g  reason: collision with root package name */
            private List<a> f13863g;
            private am<a, a.C0227a, b> h;
            private List<c> i;
            private am<c, c.a, d> j;
            private List<ac> k;
            private am<ac, ac.a, ad> l;
            private List<k> m;
            private am<k, k.a, l> n;
            private q o;
            private an<q, q.a, r> p;
            private ag q;
            private an<ag, ag.a, ah> r;
            private Object s;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.f13732d.a((Class<? extends t>) o.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13858b = "";
                this.f13859c = "";
                this.f13860d = y.f14071a;
                this.f13861e = Collections.emptyList();
                this.f13862f = Collections.emptyList();
                this.f13863g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.o = null;
                this.q = null;
                this.s = "";
                B();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13858b = "";
                this.f13859c = "";
                this.f13860d = y.f14071a;
                this.f13861e = Collections.emptyList();
                this.f13862f = Collections.emptyList();
                this.f13863g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.o = null;
                this.q = null;
                this.s = "";
                B();
            }

            private void B() {
                if (t.f14020b) {
                    G();
                    I();
                    M();
                    O();
                    P();
                    Q();
                }
            }

            public j.a g() {
                return i.f13731c;
            }

            /* renamed from: h */
            public o L() {
                return o.O();
            }

            /* renamed from: i */
            public o w() {
                o j2 = v();
                if (j2.a()) {
                    return j2;
                }
                throw b((ac) j2);
            }

            /* renamed from: j */
            public o v() {
                o oVar = new o((t.a) this);
                int i2 = this.f13857a;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = oVar.name_ = this.f13858b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = oVar.package_ = this.f13859c;
                if ((this.f13857a & 4) == 4) {
                    this.f13860d = this.f13860d.e();
                    this.f13857a &= -5;
                }
                z unused3 = oVar.dependency_ = this.f13860d;
                if ((this.f13857a & 8) == 8) {
                    this.f13861e = Collections.unmodifiableList(this.f13861e);
                    this.f13857a &= -9;
                }
                List unused4 = oVar.publicDependency_ = this.f13861e;
                if ((this.f13857a & 16) == 16) {
                    this.f13862f = Collections.unmodifiableList(this.f13862f);
                    this.f13857a &= -17;
                }
                List unused5 = oVar.weakDependency_ = this.f13862f;
                am<a, a.C0227a, b> amVar = this.h;
                if (amVar == null) {
                    if ((this.f13857a & 32) == 32) {
                        this.f13863g = Collections.unmodifiableList(this.f13863g);
                        this.f13857a &= -33;
                    }
                    List unused6 = oVar.messageType_ = this.f13863g;
                } else {
                    List unused7 = oVar.messageType_ = amVar.e();
                }
                am<c, c.a, d> amVar2 = this.j;
                if (amVar2 == null) {
                    if ((this.f13857a & 64) == 64) {
                        this.i = Collections.unmodifiableList(this.i);
                        this.f13857a &= -65;
                    }
                    List unused8 = oVar.enumType_ = this.i;
                } else {
                    List unused9 = oVar.enumType_ = amVar2.e();
                }
                am<ac, ac.a, ad> amVar3 = this.l;
                if (amVar3 == null) {
                    if ((this.f13857a & 128) == 128) {
                        this.k = Collections.unmodifiableList(this.k);
                        this.f13857a &= -129;
                    }
                    List unused10 = oVar.service_ = this.k;
                } else {
                    List unused11 = oVar.service_ = amVar3.e();
                }
                am<k, k.a, l> amVar4 = this.n;
                if (amVar4 == null) {
                    if ((this.f13857a & 256) == 256) {
                        this.m = Collections.unmodifiableList(this.m);
                        this.f13857a &= -257;
                    }
                    List unused12 = oVar.extension_ = this.m;
                } else {
                    List unused13 = oVar.extension_ = amVar4.e();
                }
                if ((i2 & 512) == 512) {
                    i3 |= 4;
                }
                an<q, q.a, r> anVar = this.p;
                if (anVar == null) {
                    q unused14 = oVar.options_ = this.o;
                } else {
                    q unused15 = oVar.options_ = anVar.c();
                }
                if ((i2 & 1024) == 1024) {
                    i3 |= 8;
                }
                an<ag, ag.a, ah> anVar2 = this.r;
                if (anVar2 == null) {
                    ag unused16 = oVar.sourceCodeInfo_ = this.q;
                } else {
                    ag unused17 = oVar.sourceCodeInfo_ = anVar2.c();
                }
                if ((i2 & 2048) == 2048) {
                    i3 |= 16;
                }
                Object unused18 = oVar.syntax_ = this.s;
                int unused19 = oVar.bitField0_ = i3;
                x();
                return oVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof o) {
                    return a((o) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(o oVar) {
                if (oVar == o.O()) {
                    return this;
                }
                if (oVar.h()) {
                    this.f13857a |= 1;
                    this.f13858b = oVar.name_;
                    A();
                }
                if (oVar.j()) {
                    this.f13857a |= 2;
                    this.f13859c = oVar.package_;
                    A();
                }
                if (!oVar.dependency_.isEmpty()) {
                    if (this.f13860d.isEmpty()) {
                        this.f13860d = oVar.dependency_;
                        this.f13857a &= -5;
                    } else {
                        C();
                        this.f13860d.addAll(oVar.dependency_);
                    }
                    A();
                }
                if (!oVar.publicDependency_.isEmpty()) {
                    if (this.f13861e.isEmpty()) {
                        this.f13861e = oVar.publicDependency_;
                        this.f13857a &= -9;
                    } else {
                        D();
                        this.f13861e.addAll(oVar.publicDependency_);
                    }
                    A();
                }
                if (!oVar.weakDependency_.isEmpty()) {
                    if (this.f13862f.isEmpty()) {
                        this.f13862f = oVar.weakDependency_;
                        this.f13857a &= -17;
                    } else {
                        E();
                        this.f13862f.addAll(oVar.weakDependency_);
                    }
                    A();
                }
                am<k, k.a, l> amVar = null;
                if (this.h == null) {
                    if (!oVar.messageType_.isEmpty()) {
                        if (this.f13863g.isEmpty()) {
                            this.f13863g = oVar.messageType_;
                            this.f13857a &= -33;
                        } else {
                            F();
                            this.f13863g.addAll(oVar.messageType_);
                        }
                        A();
                    }
                } else if (!oVar.messageType_.isEmpty()) {
                    if (this.h.d()) {
                        this.h.b();
                        this.h = null;
                        this.f13863g = oVar.messageType_;
                        this.f13857a &= -33;
                        this.h = t.f14020b ? G() : null;
                    } else {
                        this.h.a(oVar.messageType_);
                    }
                }
                if (this.j == null) {
                    if (!oVar.enumType_.isEmpty()) {
                        if (this.i.isEmpty()) {
                            this.i = oVar.enumType_;
                            this.f13857a &= -65;
                        } else {
                            H();
                            this.i.addAll(oVar.enumType_);
                        }
                        A();
                    }
                } else if (!oVar.enumType_.isEmpty()) {
                    if (this.j.d()) {
                        this.j.b();
                        this.j = null;
                        this.i = oVar.enumType_;
                        this.f13857a &= -65;
                        this.j = t.f14020b ? I() : null;
                    } else {
                        this.j.a(oVar.enumType_);
                    }
                }
                if (this.l == null) {
                    if (!oVar.service_.isEmpty()) {
                        if (this.k.isEmpty()) {
                            this.k = oVar.service_;
                            this.f13857a &= -129;
                        } else {
                            J();
                            this.k.addAll(oVar.service_);
                        }
                        A();
                    }
                } else if (!oVar.service_.isEmpty()) {
                    if (this.l.d()) {
                        this.l.b();
                        this.l = null;
                        this.k = oVar.service_;
                        this.f13857a &= -129;
                        this.l = t.f14020b ? M() : null;
                    } else {
                        this.l.a(oVar.service_);
                    }
                }
                if (this.n == null) {
                    if (!oVar.extension_.isEmpty()) {
                        if (this.m.isEmpty()) {
                            this.m = oVar.extension_;
                            this.f13857a &= -257;
                        } else {
                            N();
                            this.m.addAll(oVar.extension_);
                        }
                        A();
                    }
                } else if (!oVar.extension_.isEmpty()) {
                    if (this.n.d()) {
                        this.n.b();
                        this.n = null;
                        this.m = oVar.extension_;
                        this.f13857a &= -257;
                        if (t.f14020b) {
                            amVar = O();
                        }
                        this.n = amVar;
                    } else {
                        this.n.a(oVar.extension_);
                    }
                }
                if (oVar.z()) {
                    a(oVar.A());
                }
                if (oVar.B()) {
                    a(oVar.C());
                }
                if (oVar.D()) {
                    this.f13857a |= 2048;
                    this.s = oVar.syntax_;
                    A();
                }
                d(oVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i2 = 0; i2 < l(); i2++) {
                    if (!a(i2).a()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < m(); i3++) {
                    if (!b(i3).a()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < n(); i4++) {
                    if (!c(i4).a()) {
                        return false;
                    }
                }
                for (int i5 = 0; i5 < o(); i5++) {
                    if (!d(i5).a()) {
                        return false;
                    }
                }
                if (!p() || q().a()) {
                    return true;
                }
                return false;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.o.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$o> r1 = com.google.c.i.o.f13855a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$o r3 = (com.google.c.i.o) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.o) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$o r4 = (com.google.c.i.o) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.o) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.o.a.c(com.google.c.g, com.google.c.p):com.google.c.i$o$a");
            }

            public a a(String str) {
                if (str != null) {
                    this.f13857a |= 1;
                    this.f13858b = str;
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            public a b(String str) {
                if (str != null) {
                    this.f13857a |= 2;
                    this.f13859c = str;
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            private void C() {
                if ((this.f13857a & 4) != 4) {
                    this.f13860d = new y(this.f13860d);
                    this.f13857a |= 4;
                }
            }

            private void D() {
                if ((this.f13857a & 8) != 8) {
                    this.f13861e = new ArrayList(this.f13861e);
                    this.f13857a |= 8;
                }
            }

            private void E() {
                if ((this.f13857a & 16) != 16) {
                    this.f13862f = new ArrayList(this.f13862f);
                    this.f13857a |= 16;
                }
            }

            private void F() {
                if ((this.f13857a & 32) != 32) {
                    this.f13863g = new ArrayList(this.f13863g);
                    this.f13857a |= 32;
                }
            }

            public int l() {
                am<a, a.C0227a, b> amVar = this.h;
                if (amVar == null) {
                    return this.f13863g.size();
                }
                return amVar.c();
            }

            public a a(int i2) {
                am<a, a.C0227a, b> amVar = this.h;
                if (amVar == null) {
                    return this.f13863g.get(i2);
                }
                return amVar.a(i2);
            }

            public a a(a aVar) {
                am<a, a.C0227a, b> amVar = this.h;
                if (amVar != null) {
                    amVar.a(aVar);
                } else if (aVar != null) {
                    F();
                    this.f13863g.add(aVar);
                    A();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            private am<a, a.C0227a, b> G() {
                if (this.h == null) {
                    this.h = new am<>(this.f13863g, (this.f13857a & 32) == 32, z(), y());
                    this.f13863g = null;
                }
                return this.h;
            }

            private void H() {
                if ((this.f13857a & 64) != 64) {
                    this.i = new ArrayList(this.i);
                    this.f13857a |= 64;
                }
            }

            public int m() {
                am<c, c.a, d> amVar = this.j;
                if (amVar == null) {
                    return this.i.size();
                }
                return amVar.c();
            }

            public c b(int i2) {
                am<c, c.a, d> amVar = this.j;
                if (amVar == null) {
                    return this.i.get(i2);
                }
                return amVar.a(i2);
            }

            private am<c, c.a, d> I() {
                if (this.j == null) {
                    this.j = new am<>(this.i, (this.f13857a & 64) == 64, z(), y());
                    this.i = null;
                }
                return this.j;
            }

            private void J() {
                if ((this.f13857a & 128) != 128) {
                    this.k = new ArrayList(this.k);
                    this.f13857a |= 128;
                }
            }

            public int n() {
                am<ac, ac.a, ad> amVar = this.l;
                if (amVar == null) {
                    return this.k.size();
                }
                return amVar.c();
            }

            public ac c(int i2) {
                am<ac, ac.a, ad> amVar = this.l;
                if (amVar == null) {
                    return this.k.get(i2);
                }
                return amVar.a(i2);
            }

            private am<ac, ac.a, ad> M() {
                if (this.l == null) {
                    this.l = new am<>(this.k, (this.f13857a & 128) == 128, z(), y());
                    this.k = null;
                }
                return this.l;
            }

            private void N() {
                if ((this.f13857a & 256) != 256) {
                    this.m = new ArrayList(this.m);
                    this.f13857a |= 256;
                }
            }

            public int o() {
                am<k, k.a, l> amVar = this.n;
                if (amVar == null) {
                    return this.m.size();
                }
                return amVar.c();
            }

            public k d(int i2) {
                am<k, k.a, l> amVar = this.n;
                if (amVar == null) {
                    return this.m.get(i2);
                }
                return amVar.a(i2);
            }

            private am<k, k.a, l> O() {
                if (this.n == null) {
                    this.n = new am<>(this.m, (this.f13857a & 256) == 256, z(), y());
                    this.m = null;
                }
                return this.n;
            }

            public boolean p() {
                return (this.f13857a & 512) == 512;
            }

            public q q() {
                an<q, q.a, r> anVar = this.p;
                if (anVar != null) {
                    return anVar.b();
                }
                q qVar = this.o;
                return qVar == null ? q.V() : qVar;
            }

            public a a(q qVar) {
                an<q, q.a, r> anVar = this.p;
                if (anVar == null) {
                    if ((this.f13857a & 512) == 512) {
                        q qVar2 = this.o;
                        if (!(qVar2 == null || qVar2 == q.V())) {
                            this.o = q.a(this.o).a(qVar).v();
                            A();
                        }
                    }
                    this.o = qVar;
                    A();
                } else {
                    anVar.a(qVar);
                }
                this.f13857a |= 512;
                return this;
            }

            private an<q, q.a, r> P() {
                if (this.p == null) {
                    this.p = new an<>(q(), z(), y());
                    this.o = null;
                }
                return this.p;
            }

            public ag r() {
                an<ag, ag.a, ah> anVar = this.r;
                if (anVar != null) {
                    return anVar.b();
                }
                ag agVar = this.q;
                return agVar == null ? ag.m() : agVar;
            }

            public a a(ag agVar) {
                an<ag, ag.a, ah> anVar = this.r;
                if (anVar == null) {
                    if ((this.f13857a & 1024) == 1024) {
                        ag agVar2 = this.q;
                        if (!(agVar2 == null || agVar2 == ag.m())) {
                            this.q = ag.a(this.q).a(agVar).v();
                            A();
                        }
                    }
                    this.q = agVar;
                    A();
                } else {
                    anVar.a(agVar);
                }
                this.f13857a |= 1024;
                return this;
            }

            private an<ag, ag.a, ah> Q() {
                if (this.r == null) {
                    this.r = new an<>(r(), z(), y());
                    this.q = null;
                }
                return this.r;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static o O() {
            return f13856c;
        }

        public aj<o> F() {
            return f13855a;
        }

        /* renamed from: P */
        public o L() {
            return f13856c;
        }
    }

    public static final class a extends t implements b {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<a> f13736a = new c<a>() {
            /* renamed from: a */
            public a b(g gVar, p pVar) throws v {
                return new a(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final a f13737c = new a();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public List<c> enumType_;
        /* access modifiers changed from: private */
        public List<b> extensionRange_;
        /* access modifiers changed from: private */
        public List<k> extension_;
        /* access modifiers changed from: private */
        public List<k> field_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public List<a> nestedType_;
        /* access modifiers changed from: private */
        public List<y> oneofDecl_;
        /* access modifiers changed from: private */
        public s options_;
        /* access modifiers changed from: private */
        public z reservedName_;
        /* access modifiers changed from: private */
        public List<d> reservedRange_;

        public interface c extends ag {
        }

        public interface e extends ag {
        }

        private a(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private a() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.field_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.nestedType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.extensionRange_ = Collections.emptyList();
            this.oneofDecl_ = Collections.emptyList();
            this.reservedRange_ = Collections.emptyList();
            this.reservedName_ = y.f14071a;
        }

        public final at f() {
            return this.unknownFields;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        private a(g gVar, p pVar) throws v {
            this();
            g gVar2 = gVar;
            p pVar2 = pVar;
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    switch (a2) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            f m = gVar.m();
                            this.bitField0_ |= 1;
                            this.name_ = m;
                            break;
                        case 18:
                            if (!(z2 & true)) {
                                this.field_ = new ArrayList();
                                z2 |= true;
                            }
                            this.field_.add(gVar2.a(k.f13829a, pVar2));
                            break;
                        case 26:
                            if (!(z2 & true)) {
                                this.nestedType_ = new ArrayList();
                                z2 |= true;
                            }
                            this.nestedType_.add(gVar2.a(f13736a, pVar2));
                            break;
                        case 34:
                            if (!(z2 & true)) {
                                this.enumType_ = new ArrayList();
                                z2 |= true;
                            }
                            this.enumType_.add(gVar2.a(c.f13801a, pVar2));
                            break;
                        case 42:
                            if (!(z2 & true)) {
                                this.extensionRange_ = new ArrayList();
                                z2 |= true;
                            }
                            this.extensionRange_.add(gVar2.a(b.f13745a, pVar2));
                            break;
                        case 50:
                            if (!(z2 & true)) {
                                this.extension_ = new ArrayList();
                                z2 |= true;
                            }
                            this.extension_.add(gVar2.a(k.f13829a, pVar2));
                            break;
                        case 58:
                            s.a t = (this.bitField0_ & 2) == 2 ? this.options_.I() : null;
                            this.options_ = (s) gVar2.a(s.f13875a, pVar2);
                            if (t != null) {
                                t.a(this.options_);
                                this.options_ = t.v();
                            }
                            this.bitField0_ |= 2;
                            break;
                        case 66:
                            if (!(z2 & true)) {
                                this.oneofDecl_ = new ArrayList();
                                z2 |= true;
                            }
                            this.oneofDecl_.add(gVar2.a(y.f13899a, pVar2));
                            break;
                        case 74:
                            if (!(z2 & true)) {
                                this.reservedRange_ = new ArrayList();
                                z2 |= true;
                            }
                            this.reservedRange_.add(gVar2.a(d.f13750a, pVar2));
                            break;
                        case 82:
                            f m2 = gVar.m();
                            if (!(z2 & true)) {
                                this.reservedName_ = new y();
                                z2 |= true;
                            }
                            this.reservedName_.a(m2);
                            break;
                        default:
                            if (a(gVar2, c2, pVar2, a2)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.field_ = Collections.unmodifiableList(this.field_);
                    }
                    if (z2 & true) {
                        this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
                    }
                    if (z2 & true) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                    }
                    if (z2 & true) {
                        this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
                    }
                    if (z2 & true) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                    }
                    if (z2 & true) {
                        this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
                    }
                    if (z2 & true) {
                        this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
                    }
                    if (z2 & true) {
                        this.reservedName_ = this.reservedName_.e();
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.field_ = Collections.unmodifiableList(this.field_);
            }
            if (z2 & true) {
                this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
            }
            if (z2 & true) {
                this.enumType_ = Collections.unmodifiableList(this.enumType_);
            }
            if (z2 & true) {
                this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
            }
            if (z2 & true) {
                this.extension_ = Collections.unmodifiableList(this.extension_);
            }
            if (z2 & true) {
                this.oneofDecl_ = Collections.unmodifiableList(this.oneofDecl_);
            }
            if (z2 & true) {
                this.reservedRange_ = Collections.unmodifiableList(this.reservedRange_);
            }
            if (z2 & true) {
                this.reservedName_ = this.reservedName_.e();
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.f13734f.a((Class<? extends t>) a.class, (Class<? extends t.a>) C0227a.class);
        }

        public static final class b extends t implements c {
            @Deprecated

            /* renamed from: a  reason: collision with root package name */
            public static final aj<b> f13745a = new c<b>() {
                /* renamed from: a */
                public b b(g gVar, p pVar) throws v {
                    return new b(gVar, pVar);
                }
            };

            /* renamed from: c  reason: collision with root package name */
            private static final b f13746c = new b();
            private static final long serialVersionUID = 0;
            /* access modifiers changed from: private */
            public int bitField0_;
            /* access modifiers changed from: private */
            public int end_;
            private byte memoizedIsInitialized;
            /* access modifiers changed from: private */
            public int start_;

            private b(t.a<?> aVar) {
                super(aVar);
                this.memoizedIsInitialized = -1;
            }

            private b() {
                this.memoizedIsInitialized = -1;
                this.start_ = 0;
                this.end_ = 0;
            }

            public final at f() {
                return this.unknownFields;
            }

            private b(g gVar, p pVar) throws v {
                this();
                at.a c2 = at.c();
                boolean z = false;
                while (!z) {
                    try {
                        int a2 = gVar.a();
                        if (a2 != 0) {
                            if (a2 == 8) {
                                this.bitField0_ |= 1;
                                this.start_ = gVar.g();
                            } else if (a2 == 16) {
                                this.bitField0_ |= 2;
                                this.end_ = gVar.g();
                            } else if (!a(gVar, c2, pVar, a2)) {
                            }
                        }
                        z = true;
                    } catch (v e2) {
                        throw e2.a(this);
                    } catch (IOException e3) {
                        throw new v(e3).a(this);
                    } catch (Throwable th) {
                        this.unknownFields = c2.w();
                        Y();
                        throw th;
                    }
                }
                this.unknownFields = c2.w();
                Y();
            }

            /* access modifiers changed from: protected */
            public t.f m_() {
                return i.h.a((Class<? extends t>) b.class, (Class<? extends t.a>) C0228a.class);
            }

            public boolean h() {
                return (this.bitField0_ & 1) == 1;
            }

            public int i() {
                return this.start_;
            }

            public boolean j() {
                return (this.bitField0_ & 2) == 2;
            }

            public int k() {
                return this.end_;
            }

            public final boolean a() {
                byte b2 = this.memoizedIsInitialized;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            public void a(h hVar) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    hVar.b(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    hVar.b(2, this.end_);
                }
                this.unknownFields.a(hVar);
            }

            public int b() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i2 = 0 + h.e(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += h.e(2, this.end_);
                }
                int b2 = i2 + this.unknownFields.b();
                this.memoizedSize = b2;
                return b2;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return super.equals(obj);
                }
                b bVar = (b) obj;
                boolean z = h() == bVar.h();
                if (h()) {
                    z = z && i() == bVar.i();
                }
                boolean z2 = z && j() == bVar.j();
                if (j()) {
                    z2 = z2 && k() == bVar.k();
                }
                if (!z2 || !this.unknownFields.equals(bVar.unknownFields)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = 779 + g().hashCode();
                if (h()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + i();
                }
                if (j()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + k();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            /* renamed from: l */
            public C0228a J() {
                return m();
            }

            public static C0228a m() {
                return f13746c.I();
            }

            /* renamed from: n */
            public C0228a I() {
                if (this == f13746c) {
                    return new C0228a();
                }
                return new C0228a().a(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public C0228a b(t.b bVar) {
                return new C0228a(bVar);
            }

            /* renamed from: com.google.c.i$a$b$a  reason: collision with other inner class name */
            public static final class C0228a extends t.a<C0228a> implements c {

                /* renamed from: a  reason: collision with root package name */
                private int f13747a;

                /* renamed from: b  reason: collision with root package name */
                private int f13748b;

                /* renamed from: c  reason: collision with root package name */
                private int f13749c;

                public final boolean a() {
                    return true;
                }

                /* access modifiers changed from: protected */
                public t.f e() {
                    return i.h.a((Class<? extends t>) b.class, (Class<? extends t.a>) C0228a.class);
                }

                private C0228a() {
                    l();
                }

                private C0228a(t.b bVar) {
                    super(bVar);
                    l();
                }

                private void l() {
                    boolean z = t.f14020b;
                }

                public j.a g() {
                    return i.f13735g;
                }

                /* renamed from: h */
                public b L() {
                    return b.o();
                }

                /* renamed from: i */
                public b w() {
                    b j = v();
                    if (j.a()) {
                        return j;
                    }
                    throw b((ac) j);
                }

                /* renamed from: j */
                public b v() {
                    b bVar = new b((t.a) this);
                    int i = this.f13747a;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    int unused = bVar.start_ = this.f13748b;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    int unused2 = bVar.end_ = this.f13749c;
                    int unused3 = bVar.bitField0_ = i2;
                    x();
                    return bVar;
                }

                /* renamed from: k */
                public C0228a s() {
                    return (C0228a) super.d();
                }

                /* renamed from: a */
                public C0228a f(j.f fVar, Object obj) {
                    return (C0228a) super.f(fVar, obj);
                }

                /* renamed from: b */
                public C0228a e(j.f fVar, Object obj) {
                    return (C0228a) super.e(fVar, obj);
                }

                /* renamed from: d */
                public C0228a c(ac acVar) {
                    if (acVar instanceof b) {
                        return a((b) acVar);
                    }
                    super.c(acVar);
                    return this;
                }

                public C0228a a(b bVar) {
                    if (bVar == b.o()) {
                        return this;
                    }
                    if (bVar.h()) {
                        a(bVar.i());
                    }
                    if (bVar.j()) {
                        b(bVar.k());
                    }
                    d(bVar.unknownFields);
                    A();
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
                /* renamed from: d */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.c.i.a.b.C0228a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.c.aj<com.google.c.i$a$b> r1 = com.google.c.i.a.b.f13745a     // Catch:{ v -> 0x0011 }
                        java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                        com.google.c.i$a$b r3 = (com.google.c.i.a.b) r3     // Catch:{ v -> 0x0011 }
                        if (r3 == 0) goto L_0x000e
                        r2.a((com.google.c.i.a.b) r3)
                    L_0x000e:
                        return r2
                    L_0x000f:
                        r3 = move-exception
                        goto L_0x001f
                    L_0x0011:
                        r3 = move-exception
                        com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                        com.google.c.i$a$b r4 = (com.google.c.i.a.b) r4     // Catch:{ all -> 0x000f }
                        java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                        throw r3     // Catch:{ all -> 0x001d }
                    L_0x001d:
                        r3 = move-exception
                        r0 = r4
                    L_0x001f:
                        if (r0 == 0) goto L_0x0024
                        r2.a((com.google.c.i.a.b) r0)
                    L_0x0024:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.a.b.C0228a.c(com.google.c.g, com.google.c.p):com.google.c.i$a$b$a");
                }

                public C0228a a(int i) {
                    this.f13747a |= 1;
                    this.f13748b = i;
                    A();
                    return this;
                }

                public C0228a b(int i) {
                    this.f13747a |= 2;
                    this.f13749c = i;
                    A();
                    return this;
                }

                /* renamed from: b */
                public final C0228a f(at atVar) {
                    return (C0228a) super.f(atVar);
                }

                /* renamed from: c */
                public final C0228a d(at atVar) {
                    return (C0228a) super.a(atVar);
                }
            }

            public static b o() {
                return f13746c;
            }

            public aj<b> F() {
                return f13745a;
            }

            /* renamed from: p */
            public b L() {
                return f13746c;
            }
        }

        public static final class d extends t implements e {
            @Deprecated

            /* renamed from: a  reason: collision with root package name */
            public static final aj<d> f13750a = new c<d>() {
                /* renamed from: a */
                public d b(g gVar, p pVar) throws v {
                    return new d(gVar, pVar);
                }
            };

            /* renamed from: c  reason: collision with root package name */
            private static final d f13751c = new d();
            private static final long serialVersionUID = 0;
            /* access modifiers changed from: private */
            public int bitField0_;
            /* access modifiers changed from: private */
            public int end_;
            private byte memoizedIsInitialized;
            /* access modifiers changed from: private */
            public int start_;

            private d(t.a<?> aVar) {
                super(aVar);
                this.memoizedIsInitialized = -1;
            }

            private d() {
                this.memoizedIsInitialized = -1;
                this.start_ = 0;
                this.end_ = 0;
            }

            public final at f() {
                return this.unknownFields;
            }

            private d(g gVar, p pVar) throws v {
                this();
                at.a c2 = at.c();
                boolean z = false;
                while (!z) {
                    try {
                        int a2 = gVar.a();
                        if (a2 != 0) {
                            if (a2 == 8) {
                                this.bitField0_ |= 1;
                                this.start_ = gVar.g();
                            } else if (a2 == 16) {
                                this.bitField0_ |= 2;
                                this.end_ = gVar.g();
                            } else if (!a(gVar, c2, pVar, a2)) {
                            }
                        }
                        z = true;
                    } catch (v e2) {
                        throw e2.a(this);
                    } catch (IOException e3) {
                        throw new v(e3).a(this);
                    } catch (Throwable th) {
                        this.unknownFields = c2.w();
                        Y();
                        throw th;
                    }
                }
                this.unknownFields = c2.w();
                Y();
            }

            /* access modifiers changed from: protected */
            public t.f m_() {
                return i.j.a((Class<? extends t>) d.class, (Class<? extends t.a>) C0229a.class);
            }

            public boolean h() {
                return (this.bitField0_ & 1) == 1;
            }

            public int i() {
                return this.start_;
            }

            public boolean j() {
                return (this.bitField0_ & 2) == 2;
            }

            public int k() {
                return this.end_;
            }

            public final boolean a() {
                byte b2 = this.memoizedIsInitialized;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            public void a(h hVar) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    hVar.b(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    hVar.b(2, this.end_);
                }
                this.unknownFields.a(hVar);
            }

            public int b() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i2 = 0 + h.e(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += h.e(2, this.end_);
                }
                int b2 = i2 + this.unknownFields.b();
                this.memoizedSize = b2;
                return b2;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return super.equals(obj);
                }
                d dVar = (d) obj;
                boolean z = h() == dVar.h();
                if (h()) {
                    z = z && i() == dVar.i();
                }
                boolean z2 = z && j() == dVar.j();
                if (j()) {
                    z2 = z2 && k() == dVar.k();
                }
                if (!z2 || !this.unknownFields.equals(dVar.unknownFields)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = 779 + g().hashCode();
                if (h()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + i();
                }
                if (j()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + k();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            /* renamed from: l */
            public C0229a J() {
                return m();
            }

            public static C0229a m() {
                return f13751c.I();
            }

            /* renamed from: n */
            public C0229a I() {
                if (this == f13751c) {
                    return new C0229a();
                }
                return new C0229a().a(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public C0229a b(t.b bVar) {
                return new C0229a(bVar);
            }

            /* renamed from: com.google.c.i$a$d$a  reason: collision with other inner class name */
            public static final class C0229a extends t.a<C0229a> implements e {

                /* renamed from: a  reason: collision with root package name */
                private int f13752a;

                /* renamed from: b  reason: collision with root package name */
                private int f13753b;

                /* renamed from: c  reason: collision with root package name */
                private int f13754c;

                public final boolean a() {
                    return true;
                }

                /* access modifiers changed from: protected */
                public t.f e() {
                    return i.j.a((Class<? extends t>) d.class, (Class<? extends t.a>) C0229a.class);
                }

                private C0229a() {
                    l();
                }

                private C0229a(t.b bVar) {
                    super(bVar);
                    l();
                }

                private void l() {
                    boolean z = t.f14020b;
                }

                public j.a g() {
                    return i.i;
                }

                /* renamed from: h */
                public d L() {
                    return d.o();
                }

                /* renamed from: i */
                public d w() {
                    d j = v();
                    if (j.a()) {
                        return j;
                    }
                    throw b((ac) j);
                }

                /* renamed from: j */
                public d v() {
                    d dVar = new d((t.a) this);
                    int i = this.f13752a;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    int unused = dVar.start_ = this.f13753b;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    int unused2 = dVar.end_ = this.f13754c;
                    int unused3 = dVar.bitField0_ = i2;
                    x();
                    return dVar;
                }

                /* renamed from: k */
                public C0229a s() {
                    return (C0229a) super.d();
                }

                /* renamed from: a */
                public C0229a f(j.f fVar, Object obj) {
                    return (C0229a) super.f(fVar, obj);
                }

                /* renamed from: b */
                public C0229a e(j.f fVar, Object obj) {
                    return (C0229a) super.e(fVar, obj);
                }

                /* renamed from: d */
                public C0229a c(ac acVar) {
                    if (acVar instanceof d) {
                        return a((d) acVar);
                    }
                    super.c(acVar);
                    return this;
                }

                public C0229a a(d dVar) {
                    if (dVar == d.o()) {
                        return this;
                    }
                    if (dVar.h()) {
                        a(dVar.i());
                    }
                    if (dVar.j()) {
                        b(dVar.k());
                    }
                    d(dVar.unknownFields);
                    A();
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
                /* renamed from: d */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.c.i.a.d.C0229a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.c.aj<com.google.c.i$a$d> r1 = com.google.c.i.a.d.f13750a     // Catch:{ v -> 0x0011 }
                        java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                        com.google.c.i$a$d r3 = (com.google.c.i.a.d) r3     // Catch:{ v -> 0x0011 }
                        if (r3 == 0) goto L_0x000e
                        r2.a((com.google.c.i.a.d) r3)
                    L_0x000e:
                        return r2
                    L_0x000f:
                        r3 = move-exception
                        goto L_0x001f
                    L_0x0011:
                        r3 = move-exception
                        com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                        com.google.c.i$a$d r4 = (com.google.c.i.a.d) r4     // Catch:{ all -> 0x000f }
                        java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                        throw r3     // Catch:{ all -> 0x001d }
                    L_0x001d:
                        r3 = move-exception
                        r0 = r4
                    L_0x001f:
                        if (r0 == 0) goto L_0x0024
                        r2.a((com.google.c.i.a.d) r0)
                    L_0x0024:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.a.d.C0229a.c(com.google.c.g, com.google.c.p):com.google.c.i$a$d$a");
                }

                public C0229a a(int i) {
                    this.f13752a |= 1;
                    this.f13753b = i;
                    A();
                    return this;
                }

                public C0229a b(int i) {
                    this.f13752a |= 2;
                    this.f13754c = i;
                    A();
                    return this;
                }

                /* renamed from: b */
                public final C0229a f(at atVar) {
                    return (C0229a) super.f(atVar);
                }

                /* renamed from: c */
                public final C0229a d(at atVar) {
                    return (C0229a) super.a(atVar);
                }
            }

            public static d o() {
                return f13751c;
            }

            public aj<d> F() {
                return f13750a;
            }

            /* renamed from: p */
            public d L() {
                return f13751c;
            }
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public String n_() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public List<k> j() {
            return this.field_;
        }

        public int k() {
            return this.field_.size();
        }

        public k a(int i) {
            return this.field_.get(i);
        }

        public List<k> l() {
            return this.extension_;
        }

        public int m() {
            return this.extension_.size();
        }

        public k b(int i) {
            return this.extension_.get(i);
        }

        public List<a> n() {
            return this.nestedType_;
        }

        public int o() {
            return this.nestedType_.size();
        }

        public a c(int i) {
            return this.nestedType_.get(i);
        }

        public List<c> p() {
            return this.enumType_;
        }

        public int q() {
            return this.enumType_.size();
        }

        public c d(int i) {
            return this.enumType_.get(i);
        }

        public List<b> r() {
            return this.extensionRange_;
        }

        public int s() {
            return this.extensionRange_.size();
        }

        public List<y> t() {
            return this.oneofDecl_;
        }

        public int u() {
            return this.oneofDecl_.size();
        }

        public y e(int i) {
            return this.oneofDecl_.get(i);
        }

        public boolean v() {
            return (this.bitField0_ & 2) == 2;
        }

        public s w() {
            s sVar = this.options_;
            return sVar == null ? s.u() : sVar;
        }

        public List<d> x() {
            return this.reservedRange_;
        }

        public int y() {
            return this.reservedRange_.size();
        }

        public al z() {
            return this.reservedName_;
        }

        public int A() {
            return this.reservedName_.size();
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < k(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < m(); i2++) {
                if (!b(i2).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < o(); i3++) {
                if (!c(i3).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < q(); i4++) {
                if (!d(i4).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < u(); i5++) {
                if (!e(i5).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!v() || w().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            for (int i = 0; i < this.field_.size(); i++) {
                hVar.a(2, (ad) this.field_.get(i));
            }
            for (int i2 = 0; i2 < this.nestedType_.size(); i2++) {
                hVar.a(3, (ad) this.nestedType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                hVar.a(4, (ad) this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.extensionRange_.size(); i4++) {
                hVar.a(5, (ad) this.extensionRange_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                hVar.a(6, (ad) this.extension_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.a(7, (ad) w());
            }
            for (int i6 = 0; i6 < this.oneofDecl_.size(); i6++) {
                hVar.a(8, (ad) this.oneofDecl_.get(i6));
            }
            for (int i7 = 0; i7 < this.reservedRange_.size(); i7++) {
                hVar.a(9, (ad) this.reservedRange_.get(i7));
            }
            for (int i8 = 0; i8 < this.reservedName_.size(); i8++) {
                t.a(hVar, 10, this.reservedName_.c(i8));
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int a2 = (this.bitField0_ & 1) == 1 ? t.a(1, this.name_) + 0 : 0;
            for (int i2 = 0; i2 < this.field_.size(); i2++) {
                a2 += h.c(2, (ad) this.field_.get(i2));
            }
            for (int i3 = 0; i3 < this.nestedType_.size(); i3++) {
                a2 += h.c(3, (ad) this.nestedType_.get(i3));
            }
            for (int i4 = 0; i4 < this.enumType_.size(); i4++) {
                a2 += h.c(4, (ad) this.enumType_.get(i4));
            }
            for (int i5 = 0; i5 < this.extensionRange_.size(); i5++) {
                a2 += h.c(5, (ad) this.extensionRange_.get(i5));
            }
            for (int i6 = 0; i6 < this.extension_.size(); i6++) {
                a2 += h.c(6, (ad) this.extension_.get(i6));
            }
            if ((this.bitField0_ & 2) == 2) {
                a2 += h.c(7, (ad) w());
            }
            for (int i7 = 0; i7 < this.oneofDecl_.size(); i7++) {
                a2 += h.c(8, (ad) this.oneofDecl_.get(i7));
            }
            for (int i8 = 0; i8 < this.reservedRange_.size(); i8++) {
                a2 += h.c(9, (ad) this.reservedRange_.get(i8));
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.reservedName_.size(); i10++) {
                i9 += a(this.reservedName_.c(i10));
            }
            int size = a2 + i9 + (z().size() * 1) + this.unknownFields.b();
            this.memoizedSize = size;
            return size;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            boolean z = h() == aVar.h();
            if (h()) {
                z = z && n_().equals(aVar.n_());
            }
            boolean z2 = ((((((z && j().equals(aVar.j())) && l().equals(aVar.l())) && n().equals(aVar.n())) && p().equals(aVar.p())) && r().equals(aVar.r())) && t().equals(aVar.t())) && v() == aVar.v();
            if (v()) {
                z2 = z2 && w().equals(aVar.w());
            }
            if (!((z2 && x().equals(aVar.x())) && z().equals(aVar.z())) || !this.unknownFields.equals(aVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + n_().hashCode();
            }
            if (k() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + j().hashCode();
            }
            if (m() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + l().hashCode();
            }
            if (o() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + n().hashCode();
            }
            if (q() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + p().hashCode();
            }
            if (s() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + r().hashCode();
            }
            if (u() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + t().hashCode();
            }
            if (v()) {
                hashCode = (((hashCode * 37) + 7) * 53) + w().hashCode();
            }
            if (y() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + x().hashCode();
            }
            if (A() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + z().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: B */
        public C0227a J() {
            return C();
        }

        public static C0227a C() {
            return f13737c.I();
        }

        /* renamed from: D */
        public C0227a I() {
            if (this == f13737c) {
                return new C0227a();
            }
            return new C0227a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C0227a b(t.b bVar) {
            return new C0227a(bVar);
        }

        /* renamed from: com.google.c.i$a$a  reason: collision with other inner class name */
        public static final class C0227a extends t.a<C0227a> implements b {

            /* renamed from: a  reason: collision with root package name */
            private int f13738a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13739b;

            /* renamed from: c  reason: collision with root package name */
            private List<k> f13740c;

            /* renamed from: d  reason: collision with root package name */
            private am<k, k.a, l> f13741d;

            /* renamed from: e  reason: collision with root package name */
            private List<k> f13742e;

            /* renamed from: f  reason: collision with root package name */
            private am<k, k.a, l> f13743f;

            /* renamed from: g  reason: collision with root package name */
            private List<a> f13744g;
            private am<a, C0227a, b> h;
            private List<c> i;
            private am<c, c.a, d> j;
            private List<b> k;
            private am<b, b.C0228a, c> l;
            private List<y> m;
            private am<y, y.a, z> n;
            private s o;
            private an<s, s.a, t> p;
            private List<d> q;
            private am<d, d.C0229a, e> r;
            private z s;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.f13734f.a((Class<? extends t>) a.class, (Class<? extends t.a>) C0227a.class);
            }

            private C0227a() {
                this.f13739b = "";
                this.f13740c = Collections.emptyList();
                this.f13742e = Collections.emptyList();
                this.f13744g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.o = null;
                this.q = Collections.emptyList();
                this.s = y.f14071a;
                B();
            }

            private C0227a(t.b bVar) {
                super(bVar);
                this.f13739b = "";
                this.f13740c = Collections.emptyList();
                this.f13742e = Collections.emptyList();
                this.f13744g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.o = null;
                this.q = Collections.emptyList();
                this.s = y.f14071a;
                B();
            }

            private void B() {
                if (t.f14020b) {
                    D();
                    F();
                    H();
                    J();
                    N();
                    P();
                    Q();
                    S();
                }
            }

            public j.a g() {
                return i.f13733e;
            }

            /* renamed from: h */
            public a L() {
                return a.E();
            }

            /* renamed from: i */
            public a w() {
                a j2 = v();
                if (j2.a()) {
                    return j2;
                }
                throw b((ac) j2);
            }

            /* renamed from: j */
            public a v() {
                a aVar = new a((t.a) this);
                int i2 = this.f13738a;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = aVar.name_ = this.f13739b;
                am<k, k.a, l> amVar = this.f13741d;
                if (amVar == null) {
                    if ((this.f13738a & 2) == 2) {
                        this.f13740c = Collections.unmodifiableList(this.f13740c);
                        this.f13738a &= -3;
                    }
                    List unused2 = aVar.field_ = this.f13740c;
                } else {
                    List unused3 = aVar.field_ = amVar.e();
                }
                am<k, k.a, l> amVar2 = this.f13743f;
                if (amVar2 == null) {
                    if ((this.f13738a & 4) == 4) {
                        this.f13742e = Collections.unmodifiableList(this.f13742e);
                        this.f13738a &= -5;
                    }
                    List unused4 = aVar.extension_ = this.f13742e;
                } else {
                    List unused5 = aVar.extension_ = amVar2.e();
                }
                am<a, C0227a, b> amVar3 = this.h;
                if (amVar3 == null) {
                    if ((this.f13738a & 8) == 8) {
                        this.f13744g = Collections.unmodifiableList(this.f13744g);
                        this.f13738a &= -9;
                    }
                    List unused6 = aVar.nestedType_ = this.f13744g;
                } else {
                    List unused7 = aVar.nestedType_ = amVar3.e();
                }
                am<c, c.a, d> amVar4 = this.j;
                if (amVar4 == null) {
                    if ((this.f13738a & 16) == 16) {
                        this.i = Collections.unmodifiableList(this.i);
                        this.f13738a &= -17;
                    }
                    List unused8 = aVar.enumType_ = this.i;
                } else {
                    List unused9 = aVar.enumType_ = amVar4.e();
                }
                am<b, b.C0228a, c> amVar5 = this.l;
                if (amVar5 == null) {
                    if ((this.f13738a & 32) == 32) {
                        this.k = Collections.unmodifiableList(this.k);
                        this.f13738a &= -33;
                    }
                    List unused10 = aVar.extensionRange_ = this.k;
                } else {
                    List unused11 = aVar.extensionRange_ = amVar5.e();
                }
                am<y, y.a, z> amVar6 = this.n;
                if (amVar6 == null) {
                    if ((this.f13738a & 64) == 64) {
                        this.m = Collections.unmodifiableList(this.m);
                        this.f13738a &= -65;
                    }
                    List unused12 = aVar.oneofDecl_ = this.m;
                } else {
                    List unused13 = aVar.oneofDecl_ = amVar6.e();
                }
                if ((i2 & 128) == 128) {
                    i3 |= 2;
                }
                an<s, s.a, t> anVar = this.p;
                if (anVar == null) {
                    s unused14 = aVar.options_ = this.o;
                } else {
                    s unused15 = aVar.options_ = anVar.c();
                }
                am<d, d.C0229a, e> amVar7 = this.r;
                if (amVar7 == null) {
                    if ((this.f13738a & 256) == 256) {
                        this.q = Collections.unmodifiableList(this.q);
                        this.f13738a &= -257;
                    }
                    List unused16 = aVar.reservedRange_ = this.q;
                } else {
                    List unused17 = aVar.reservedRange_ = amVar7.e();
                }
                if ((this.f13738a & 512) == 512) {
                    this.s = this.s.e();
                    this.f13738a &= -513;
                }
                z unused18 = aVar.reservedName_ = this.s;
                int unused19 = aVar.bitField0_ = i3;
                x();
                return aVar;
            }

            /* renamed from: k */
            public C0227a s() {
                return (C0227a) super.d();
            }

            /* renamed from: a */
            public C0227a f(j.f fVar, Object obj) {
                return (C0227a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public C0227a e(j.f fVar, Object obj) {
                return (C0227a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public C0227a c(ac acVar) {
                if (acVar instanceof a) {
                    return a((a) acVar);
                }
                super.c(acVar);
                return this;
            }

            public C0227a a(a aVar) {
                if (aVar == a.E()) {
                    return this;
                }
                if (aVar.h()) {
                    this.f13738a |= 1;
                    this.f13739b = aVar.name_;
                    A();
                }
                am<d, d.C0229a, e> amVar = null;
                if (this.f13741d == null) {
                    if (!aVar.field_.isEmpty()) {
                        if (this.f13740c.isEmpty()) {
                            this.f13740c = aVar.field_;
                            this.f13738a &= -3;
                        } else {
                            C();
                            this.f13740c.addAll(aVar.field_);
                        }
                        A();
                    }
                } else if (!aVar.field_.isEmpty()) {
                    if (this.f13741d.d()) {
                        this.f13741d.b();
                        this.f13741d = null;
                        this.f13740c = aVar.field_;
                        this.f13738a &= -3;
                        this.f13741d = t.f14020b ? D() : null;
                    } else {
                        this.f13741d.a(aVar.field_);
                    }
                }
                if (this.f13743f == null) {
                    if (!aVar.extension_.isEmpty()) {
                        if (this.f13742e.isEmpty()) {
                            this.f13742e = aVar.extension_;
                            this.f13738a &= -5;
                        } else {
                            E();
                            this.f13742e.addAll(aVar.extension_);
                        }
                        A();
                    }
                } else if (!aVar.extension_.isEmpty()) {
                    if (this.f13743f.d()) {
                        this.f13743f.b();
                        this.f13743f = null;
                        this.f13742e = aVar.extension_;
                        this.f13738a &= -5;
                        this.f13743f = t.f14020b ? F() : null;
                    } else {
                        this.f13743f.a(aVar.extension_);
                    }
                }
                if (this.h == null) {
                    if (!aVar.nestedType_.isEmpty()) {
                        if (this.f13744g.isEmpty()) {
                            this.f13744g = aVar.nestedType_;
                            this.f13738a &= -9;
                        } else {
                            G();
                            this.f13744g.addAll(aVar.nestedType_);
                        }
                        A();
                    }
                } else if (!aVar.nestedType_.isEmpty()) {
                    if (this.h.d()) {
                        this.h.b();
                        this.h = null;
                        this.f13744g = aVar.nestedType_;
                        this.f13738a &= -9;
                        this.h = t.f14020b ? H() : null;
                    } else {
                        this.h.a(aVar.nestedType_);
                    }
                }
                if (this.j == null) {
                    if (!aVar.enumType_.isEmpty()) {
                        if (this.i.isEmpty()) {
                            this.i = aVar.enumType_;
                            this.f13738a &= -17;
                        } else {
                            I();
                            this.i.addAll(aVar.enumType_);
                        }
                        A();
                    }
                } else if (!aVar.enumType_.isEmpty()) {
                    if (this.j.d()) {
                        this.j.b();
                        this.j = null;
                        this.i = aVar.enumType_;
                        this.f13738a &= -17;
                        this.j = t.f14020b ? J() : null;
                    } else {
                        this.j.a(aVar.enumType_);
                    }
                }
                if (this.l == null) {
                    if (!aVar.extensionRange_.isEmpty()) {
                        if (this.k.isEmpty()) {
                            this.k = aVar.extensionRange_;
                            this.f13738a &= -33;
                        } else {
                            M();
                            this.k.addAll(aVar.extensionRange_);
                        }
                        A();
                    }
                } else if (!aVar.extensionRange_.isEmpty()) {
                    if (this.l.d()) {
                        this.l.b();
                        this.l = null;
                        this.k = aVar.extensionRange_;
                        this.f13738a &= -33;
                        this.l = t.f14020b ? N() : null;
                    } else {
                        this.l.a(aVar.extensionRange_);
                    }
                }
                if (this.n == null) {
                    if (!aVar.oneofDecl_.isEmpty()) {
                        if (this.m.isEmpty()) {
                            this.m = aVar.oneofDecl_;
                            this.f13738a &= -65;
                        } else {
                            O();
                            this.m.addAll(aVar.oneofDecl_);
                        }
                        A();
                    }
                } else if (!aVar.oneofDecl_.isEmpty()) {
                    if (this.n.d()) {
                        this.n.b();
                        this.n = null;
                        this.m = aVar.oneofDecl_;
                        this.f13738a &= -65;
                        this.n = t.f14020b ? P() : null;
                    } else {
                        this.n.a(aVar.oneofDecl_);
                    }
                }
                if (aVar.v()) {
                    a(aVar.w());
                }
                if (this.r == null) {
                    if (!aVar.reservedRange_.isEmpty()) {
                        if (this.q.isEmpty()) {
                            this.q = aVar.reservedRange_;
                            this.f13738a &= -257;
                        } else {
                            R();
                            this.q.addAll(aVar.reservedRange_);
                        }
                        A();
                    }
                } else if (!aVar.reservedRange_.isEmpty()) {
                    if (this.r.d()) {
                        this.r.b();
                        this.r = null;
                        this.q = aVar.reservedRange_;
                        this.f13738a &= -257;
                        if (t.f14020b) {
                            amVar = S();
                        }
                        this.r = amVar;
                    } else {
                        this.r.a(aVar.reservedRange_);
                    }
                }
                if (!aVar.reservedName_.isEmpty()) {
                    if (this.s.isEmpty()) {
                        this.s = aVar.reservedName_;
                        this.f13738a &= -513;
                    } else {
                        T();
                        this.s.addAll(aVar.reservedName_);
                    }
                    A();
                }
                d(aVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i2 = 0; i2 < l(); i2++) {
                    if (!a(i2).a()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < m(); i3++) {
                    if (!b(i3).a()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < n(); i4++) {
                    if (!c(i4).a()) {
                        return false;
                    }
                }
                for (int i5 = 0; i5 < o(); i5++) {
                    if (!d(i5).a()) {
                        return false;
                    }
                }
                for (int i6 = 0; i6 < p(); i6++) {
                    if (!e(i6).a()) {
                        return false;
                    }
                }
                if (!q() || r().a()) {
                    return true;
                }
                return false;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.a.C0227a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$a> r1 = com.google.c.i.a.f13736a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$a r3 = (com.google.c.i.a) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.a) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$a r4 = (com.google.c.i.a) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.a) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.a.C0227a.c(com.google.c.g, com.google.c.p):com.google.c.i$a$a");
            }

            public C0227a a(String str) {
                if (str != null) {
                    this.f13738a |= 1;
                    this.f13739b = str;
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            private void C() {
                if ((this.f13738a & 2) != 2) {
                    this.f13740c = new ArrayList(this.f13740c);
                    this.f13738a |= 2;
                }
            }

            public int l() {
                am<k, k.a, l> amVar = this.f13741d;
                if (amVar == null) {
                    return this.f13740c.size();
                }
                return amVar.c();
            }

            public k a(int i2) {
                am<k, k.a, l> amVar = this.f13741d;
                if (amVar == null) {
                    return this.f13740c.get(i2);
                }
                return amVar.a(i2);
            }

            private am<k, k.a, l> D() {
                if (this.f13741d == null) {
                    this.f13741d = new am<>(this.f13740c, (this.f13738a & 2) == 2, z(), y());
                    this.f13740c = null;
                }
                return this.f13741d;
            }

            private void E() {
                if ((this.f13738a & 4) != 4) {
                    this.f13742e = new ArrayList(this.f13742e);
                    this.f13738a |= 4;
                }
            }

            public int m() {
                am<k, k.a, l> amVar = this.f13743f;
                if (amVar == null) {
                    return this.f13742e.size();
                }
                return amVar.c();
            }

            public k b(int i2) {
                am<k, k.a, l> amVar = this.f13743f;
                if (amVar == null) {
                    return this.f13742e.get(i2);
                }
                return amVar.a(i2);
            }

            private am<k, k.a, l> F() {
                if (this.f13743f == null) {
                    this.f13743f = new am<>(this.f13742e, (this.f13738a & 4) == 4, z(), y());
                    this.f13742e = null;
                }
                return this.f13743f;
            }

            private void G() {
                if ((this.f13738a & 8) != 8) {
                    this.f13744g = new ArrayList(this.f13744g);
                    this.f13738a |= 8;
                }
            }

            public int n() {
                am<a, C0227a, b> amVar = this.h;
                if (amVar == null) {
                    return this.f13744g.size();
                }
                return amVar.c();
            }

            public a c(int i2) {
                am<a, C0227a, b> amVar = this.h;
                if (amVar == null) {
                    return this.f13744g.get(i2);
                }
                return amVar.a(i2);
            }

            private am<a, C0227a, b> H() {
                if (this.h == null) {
                    this.h = new am<>(this.f13744g, (this.f13738a & 8) == 8, z(), y());
                    this.f13744g = null;
                }
                return this.h;
            }

            private void I() {
                if ((this.f13738a & 16) != 16) {
                    this.i = new ArrayList(this.i);
                    this.f13738a |= 16;
                }
            }

            public int o() {
                am<c, c.a, d> amVar = this.j;
                if (amVar == null) {
                    return this.i.size();
                }
                return amVar.c();
            }

            public c d(int i2) {
                am<c, c.a, d> amVar = this.j;
                if (amVar == null) {
                    return this.i.get(i2);
                }
                return amVar.a(i2);
            }

            private am<c, c.a, d> J() {
                if (this.j == null) {
                    this.j = new am<>(this.i, (this.f13738a & 16) == 16, z(), y());
                    this.i = null;
                }
                return this.j;
            }

            private void M() {
                if ((this.f13738a & 32) != 32) {
                    this.k = new ArrayList(this.k);
                    this.f13738a |= 32;
                }
            }

            public C0227a a(b bVar) {
                am<b, b.C0228a, c> amVar = this.l;
                if (amVar != null) {
                    amVar.a(bVar);
                } else if (bVar != null) {
                    M();
                    this.k.add(bVar);
                    A();
                } else {
                    throw new NullPointerException();
                }
                return this;
            }

            private am<b, b.C0228a, c> N() {
                if (this.l == null) {
                    this.l = new am<>(this.k, (this.f13738a & 32) == 32, z(), y());
                    this.k = null;
                }
                return this.l;
            }

            private void O() {
                if ((this.f13738a & 64) != 64) {
                    this.m = new ArrayList(this.m);
                    this.f13738a |= 64;
                }
            }

            public int p() {
                am<y, y.a, z> amVar = this.n;
                if (amVar == null) {
                    return this.m.size();
                }
                return amVar.c();
            }

            public y e(int i2) {
                am<y, y.a, z> amVar = this.n;
                if (amVar == null) {
                    return this.m.get(i2);
                }
                return amVar.a(i2);
            }

            private am<y, y.a, z> P() {
                if (this.n == null) {
                    this.n = new am<>(this.m, (this.f13738a & 64) == 64, z(), y());
                    this.m = null;
                }
                return this.n;
            }

            public boolean q() {
                return (this.f13738a & 128) == 128;
            }

            public s r() {
                an<s, s.a, t> anVar = this.p;
                if (anVar != null) {
                    return anVar.b();
                }
                s sVar = this.o;
                return sVar == null ? s.u() : sVar;
            }

            public C0227a a(s sVar) {
                an<s, s.a, t> anVar = this.p;
                if (anVar == null) {
                    if ((this.f13738a & 128) == 128) {
                        s sVar2 = this.o;
                        if (!(sVar2 == null || sVar2 == s.u())) {
                            this.o = s.a(this.o).a(sVar).v();
                            A();
                        }
                    }
                    this.o = sVar;
                    A();
                } else {
                    anVar.a(sVar);
                }
                this.f13738a |= 128;
                return this;
            }

            private an<s, s.a, t> Q() {
                if (this.p == null) {
                    this.p = new an<>(r(), z(), y());
                    this.o = null;
                }
                return this.p;
            }

            private void R() {
                if ((this.f13738a & 256) != 256) {
                    this.q = new ArrayList(this.q);
                    this.f13738a |= 256;
                }
            }

            private am<d, d.C0229a, e> S() {
                if (this.r == null) {
                    this.r = new am<>(this.q, (this.f13738a & 256) == 256, z(), y());
                    this.q = null;
                }
                return this.r;
            }

            private void T() {
                if ((this.f13738a & 512) != 512) {
                    this.s = new y(this.s);
                    this.f13738a |= 512;
                }
            }

            /* renamed from: b */
            public final C0227a f(at atVar) {
                return (C0227a) super.f(atVar);
            }

            /* renamed from: c */
            public final C0227a d(at atVar) {
                return (C0227a) super.a(atVar);
            }
        }

        public static a E() {
            return f13737c;
        }

        public aj<a> F() {
            return f13736a;
        }

        /* renamed from: G */
        public a L() {
            return f13737c;
        }
    }

    public static final class k extends t implements l {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<k> f13829a = new c<k>() {
            /* renamed from: a */
            public k b(g gVar, p pVar) throws v {
                return new k(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final k f13830c = new k();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public volatile Object defaultValue_;
        /* access modifiers changed from: private */
        public volatile Object extendee_;
        /* access modifiers changed from: private */
        public volatile Object jsonName_;
        /* access modifiers changed from: private */
        public int label_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public int number_;
        /* access modifiers changed from: private */
        public int oneofIndex_;
        /* access modifiers changed from: private */
        public m options_;
        /* access modifiers changed from: private */
        public volatile Object typeName_;
        /* access modifiers changed from: private */
        public int type_;

        private k(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private k() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.number_ = 0;
            this.label_ = 1;
            this.type_ = 1;
            this.typeName_ = "";
            this.extendee_ = "";
            this.defaultValue_ = "";
            this.oneofIndex_ = 0;
            this.jsonName_ = "";
        }

        public final at f() {
            return this.unknownFields;
        }

        private k(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    switch (a2) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            f m = gVar.m();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.name_ = m;
                            break;
                        case 18:
                            f m2 = gVar.m();
                            this.bitField0_ |= 32;
                            this.extendee_ = m2;
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.number_ = gVar.g();
                            break;
                        case 32:
                            int o = gVar.o();
                            if (b.valueOf(o) != null) {
                                this.bitField0_ |= 4;
                                this.label_ = o;
                                break;
                            } else {
                                c2.a(4, o);
                                break;
                            }
                        case 40:
                            int o2 = gVar.o();
                            if (c.valueOf(o2) != null) {
                                this.bitField0_ |= 8;
                                this.type_ = o2;
                                break;
                            } else {
                                c2.a(5, o2);
                                break;
                            }
                        case 50:
                            f m3 = gVar.m();
                            this.bitField0_ |= 16;
                            this.typeName_ = m3;
                            break;
                        case 58:
                            f m4 = gVar.m();
                            this.bitField0_ |= 64;
                            this.defaultValue_ = m4;
                            break;
                        case 66:
                            m.a y = (this.bitField0_ & 512) == 512 ? this.options_.I() : null;
                            this.options_ = (m) gVar.a(m.f13842a, pVar);
                            if (y != null) {
                                y.a(this.options_);
                                this.options_ = y.v();
                            }
                            this.bitField0_ |= 512;
                            break;
                        case 72:
                            this.bitField0_ |= 128;
                            this.oneofIndex_ = gVar.g();
                            break;
                        case 82:
                            f m5 = gVar.m();
                            this.bitField0_ |= 256;
                            this.jsonName_ = m5;
                            break;
                        default:
                            if (a(gVar, c2, pVar, a2)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            this.unknownFields = c2.w();
            Y();
        }

        public static final j.a h() {
            return i.k;
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.l.a((Class<? extends t>) k.class, (Class<? extends t.a>) a.class);
        }

        public enum c implements ak {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);
            
            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;

            /* renamed from: a  reason: collision with root package name */
            private static final u.b<c> f13840a = null;

            /* renamed from: b  reason: collision with root package name */
            private static final c[] f13841b = null;
            private final int value;

            static {
                f13840a = new u.b<c>() {
                };
                f13841b = values();
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static c valueOf(int i) {
                return forNumber(i);
            }

            public static c forNumber(int i) {
                switch (i) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static u.b<c> internalGetValueMap() {
                return f13840a;
            }

            public final j.e getValueDescriptor() {
                return getDescriptor().e().get(ordinal());
            }

            public final j.d getDescriptorForType() {
                return getDescriptor();
            }

            public static final j.d getDescriptor() {
                return k.h().i().get(0);
            }

            public static c valueOf(j.e eVar) {
                if (eVar.f() == getDescriptor()) {
                    return f13841b[eVar.a()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private c(int i) {
                this.value = i;
            }
        }

        public enum b implements ak {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            
            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;

            /* renamed from: a  reason: collision with root package name */
            private static final u.b<b> f13838a = null;

            /* renamed from: b  reason: collision with root package name */
            private static final b[] f13839b = null;
            private final int value;

            static {
                f13838a = new u.b<b>() {
                };
                f13839b = values();
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static b valueOf(int i) {
                return forNumber(i);
            }

            public static b forNumber(int i) {
                if (i == 1) {
                    return LABEL_OPTIONAL;
                }
                if (i == 2) {
                    return LABEL_REQUIRED;
                }
                if (i != 3) {
                    return null;
                }
                return LABEL_REPEATED;
            }

            public static u.b<b> internalGetValueMap() {
                return f13838a;
            }

            public final j.e getValueDescriptor() {
                return getDescriptor().e().get(ordinal());
            }

            public final j.d getDescriptorForType() {
                return getDescriptor();
            }

            public static final j.d getDescriptor() {
                return k.h().i().get(1);
            }

            public static b valueOf(j.e eVar) {
                if (eVar.f() == getDescriptor()) {
                    return f13839b[eVar.a()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private b(int i) {
                this.value = i;
            }
        }

        public boolean i() {
            return (this.bitField0_ & 1) == 1;
        }

        public String j() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public boolean k() {
            return (this.bitField0_ & 2) == 2;
        }

        public int l() {
            return this.number_;
        }

        public boolean m() {
            return (this.bitField0_ & 4) == 4;
        }

        public b n() {
            b valueOf = b.valueOf(this.label_);
            return valueOf == null ? b.LABEL_OPTIONAL : valueOf;
        }

        public boolean o() {
            return (this.bitField0_ & 8) == 8;
        }

        public c p() {
            c valueOf = c.valueOf(this.type_);
            return valueOf == null ? c.TYPE_DOUBLE : valueOf;
        }

        public boolean q() {
            return (this.bitField0_ & 16) == 16;
        }

        public String r() {
            Object obj = this.typeName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.typeName_ = d2;
            }
            return d2;
        }

        public boolean s() {
            return (this.bitField0_ & 32) == 32;
        }

        public String t() {
            Object obj = this.extendee_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.extendee_ = d2;
            }
            return d2;
        }

        public boolean u() {
            return (this.bitField0_ & 64) == 64;
        }

        public String v() {
            Object obj = this.defaultValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.defaultValue_ = d2;
            }
            return d2;
        }

        public boolean w() {
            return (this.bitField0_ & 128) == 128;
        }

        public int x() {
            return this.oneofIndex_;
        }

        public boolean y() {
            return (this.bitField0_ & 256) == 256;
        }

        public String z() {
            Object obj = this.jsonName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.jsonName_ = d2;
            }
            return d2;
        }

        public boolean A() {
            return (this.bitField0_ & 512) == 512;
        }

        public m B() {
            m mVar = this.options_;
            return mVar == null ? m.z() : mVar;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!A() || B().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            if ((this.bitField0_ & 32) == 32) {
                t.a(hVar, 2, this.extendee_);
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.b(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                hVar.d(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                hVar.d(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                t.a(hVar, 6, this.typeName_);
            }
            if ((this.bitField0_ & 64) == 64) {
                t.a(hVar, 7, this.defaultValue_);
            }
            if ((this.bitField0_ & 512) == 512) {
                hVar.a(8, (ad) B());
            }
            if ((this.bitField0_ & 128) == 128) {
                hVar.b(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                t.a(hVar, 10, this.jsonName_);
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + t.a(1, this.name_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += t.a(2, this.extendee_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += h.e(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += h.h(4, this.label_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += h.h(5, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += t.a(6, this.typeName_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i2 += t.a(7, this.defaultValue_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i2 += h.c(8, (ad) B());
            }
            if ((this.bitField0_ & 128) == 128) {
                i2 += h.e(9, this.oneofIndex_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i2 += t.a(10, this.jsonName_);
            }
            int b2 = i2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof k)) {
                return super.equals(obj);
            }
            k kVar = (k) obj;
            boolean z = i() == kVar.i();
            if (i()) {
                z = z && j().equals(kVar.j());
            }
            boolean z2 = z && k() == kVar.k();
            if (k()) {
                z2 = z2 && l() == kVar.l();
            }
            boolean z3 = z2 && m() == kVar.m();
            if (m()) {
                z3 = z3 && this.label_ == kVar.label_;
            }
            boolean z4 = z3 && o() == kVar.o();
            if (o()) {
                z4 = z4 && this.type_ == kVar.type_;
            }
            boolean z5 = z4 && q() == kVar.q();
            if (q()) {
                z5 = z5 && r().equals(kVar.r());
            }
            boolean z6 = z5 && s() == kVar.s();
            if (s()) {
                z6 = z6 && t().equals(kVar.t());
            }
            boolean z7 = z6 && u() == kVar.u();
            if (u()) {
                z7 = z7 && v().equals(kVar.v());
            }
            boolean z8 = z7 && w() == kVar.w();
            if (w()) {
                z8 = z8 && x() == kVar.x();
            }
            boolean z9 = z8 && y() == kVar.y();
            if (y()) {
                z9 = z9 && z().equals(kVar.z());
            }
            boolean z10 = z9 && A() == kVar.A();
            if (A()) {
                z10 = z10 && B().equals(kVar.B());
            }
            if (!z10 || !this.unknownFields.equals(kVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (i()) {
                hashCode = (((hashCode * 37) + 1) * 53) + j().hashCode();
            }
            if (k()) {
                hashCode = (((hashCode * 37) + 3) * 53) + l();
            }
            if (m()) {
                hashCode = (((hashCode * 37) + 4) * 53) + this.label_;
            }
            if (o()) {
                hashCode = (((hashCode * 37) + 5) * 53) + this.type_;
            }
            if (q()) {
                hashCode = (((hashCode * 37) + 6) * 53) + r().hashCode();
            }
            if (s()) {
                hashCode = (((hashCode * 37) + 2) * 53) + t().hashCode();
            }
            if (u()) {
                hashCode = (((hashCode * 37) + 7) * 53) + v().hashCode();
            }
            if (w()) {
                hashCode = (((hashCode * 37) + 9) * 53) + x();
            }
            if (y()) {
                hashCode = (((hashCode * 37) + 10) * 53) + z().hashCode();
            }
            if (A()) {
                hashCode = (((hashCode * 37) + 8) * 53) + B().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: C */
        public a J() {
            return D();
        }

        public static a D() {
            return f13830c.I();
        }

        /* renamed from: E */
        public a I() {
            if (this == f13830c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements l {

            /* renamed from: a  reason: collision with root package name */
            private int f13831a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13832b;

            /* renamed from: c  reason: collision with root package name */
            private int f13833c;

            /* renamed from: d  reason: collision with root package name */
            private int f13834d;

            /* renamed from: e  reason: collision with root package name */
            private int f13835e;

            /* renamed from: f  reason: collision with root package name */
            private Object f13836f;

            /* renamed from: g  reason: collision with root package name */
            private Object f13837g;
            private Object h;
            private int i;
            private Object j;
            private m k;
            private an<m, m.a, n> l;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.l.a((Class<? extends t>) k.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13832b = "";
                this.f13834d = 1;
                this.f13835e = 1;
                this.f13836f = "";
                this.f13837g = "";
                this.h = "";
                this.j = "";
                this.k = null;
                n();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13832b = "";
                this.f13834d = 1;
                this.f13835e = 1;
                this.f13836f = "";
                this.f13837g = "";
                this.h = "";
                this.j = "";
                this.k = null;
                n();
            }

            private void n() {
                if (t.f14020b) {
                    o();
                }
            }

            public j.a g() {
                return i.k;
            }

            /* renamed from: h */
            public k L() {
                return k.G();
            }

            /* renamed from: i */
            public k w() {
                k j2 = v();
                if (j2.a()) {
                    return j2;
                }
                throw b((ac) j2);
            }

            /* renamed from: j */
            public k v() {
                k kVar = new k((t.a) this);
                int i2 = this.f13831a;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = kVar.name_ = this.f13832b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                int unused2 = kVar.number_ = this.f13833c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                int unused3 = kVar.label_ = this.f13834d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                int unused4 = kVar.type_ = this.f13835e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                Object unused5 = kVar.typeName_ = this.f13836f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                Object unused6 = kVar.extendee_ = this.f13837g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                Object unused7 = kVar.defaultValue_ = this.h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                int unused8 = kVar.oneofIndex_ = this.i;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                Object unused9 = kVar.jsonName_ = this.j;
                if ((i2 & 512) == 512) {
                    i3 |= 512;
                }
                an<m, m.a, n> anVar = this.l;
                if (anVar == null) {
                    m unused10 = kVar.options_ = this.k;
                } else {
                    m unused11 = kVar.options_ = anVar.c();
                }
                int unused12 = kVar.bitField0_ = i3;
                x();
                return kVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof k) {
                    return a((k) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(k kVar) {
                if (kVar == k.G()) {
                    return this;
                }
                if (kVar.i()) {
                    this.f13831a |= 1;
                    this.f13832b = kVar.name_;
                    A();
                }
                if (kVar.k()) {
                    a(kVar.l());
                }
                if (kVar.m()) {
                    a(kVar.n());
                }
                if (kVar.o()) {
                    a(kVar.p());
                }
                if (kVar.q()) {
                    this.f13831a |= 16;
                    this.f13836f = kVar.typeName_;
                    A();
                }
                if (kVar.s()) {
                    this.f13831a |= 32;
                    this.f13837g = kVar.extendee_;
                    A();
                }
                if (kVar.u()) {
                    this.f13831a |= 64;
                    this.h = kVar.defaultValue_;
                    A();
                }
                if (kVar.w()) {
                    b(kVar.x());
                }
                if (kVar.y()) {
                    this.f13831a |= 256;
                    this.j = kVar.jsonName_;
                    A();
                }
                if (kVar.A()) {
                    a(kVar.B());
                }
                d(kVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                return !l() || m().a();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.k.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$k> r1 = com.google.c.i.k.f13829a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$k r3 = (com.google.c.i.k) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.k) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$k r4 = (com.google.c.i.k) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.k) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.k.a.c(com.google.c.g, com.google.c.p):com.google.c.i$k$a");
            }

            public a a(int i2) {
                this.f13831a |= 2;
                this.f13833c = i2;
                A();
                return this;
            }

            public a a(b bVar) {
                if (bVar != null) {
                    this.f13831a |= 4;
                    this.f13834d = bVar.getNumber();
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            public a a(c cVar) {
                if (cVar != null) {
                    this.f13831a |= 8;
                    this.f13835e = cVar.getNumber();
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            public a b(int i2) {
                this.f13831a |= 128;
                this.i = i2;
                A();
                return this;
            }

            public boolean l() {
                return (this.f13831a & 512) == 512;
            }

            public m m() {
                an<m, m.a, n> anVar = this.l;
                if (anVar != null) {
                    return anVar.b();
                }
                m mVar = this.k;
                return mVar == null ? m.z() : mVar;
            }

            public a a(m mVar) {
                an<m, m.a, n> anVar = this.l;
                if (anVar == null) {
                    if ((this.f13831a & 512) == 512) {
                        m mVar2 = this.k;
                        if (!(mVar2 == null || mVar2 == m.z())) {
                            this.k = m.a(this.k).a(mVar).v();
                            A();
                        }
                    }
                    this.k = mVar;
                    A();
                } else {
                    anVar.a(mVar);
                }
                this.f13831a |= 512;
                return this;
            }

            private an<m, m.a, n> o() {
                if (this.l == null) {
                    this.l = new an<>(m(), z(), y());
                    this.k = null;
                }
                return this.l;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static k G() {
            return f13830c;
        }

        public aj<k> F() {
            return f13829a;
        }

        /* renamed from: M */
        public k L() {
            return f13830c;
        }
    }

    public static final class y extends t implements z {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<y> f13899a = new c<y>() {
            /* renamed from: a */
            public y b(g gVar, p pVar) throws v {
                return new y(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final y f13900c = new y();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public aa options_;

        private y(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private y() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
        }

        public final at f() {
            return this.unknownFields;
        }

        private y(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 10) {
                            f m = gVar.m();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.name_ = m;
                        } else if (a2 == 18) {
                            aa.a l = (this.bitField0_ & 2) == 2 ? this.options_.I() : null;
                            this.options_ = (aa) gVar.a(aa.f13755a, pVar);
                            if (l != null) {
                                l.a(this.options_);
                                this.options_ = l.v();
                            }
                            this.bitField0_ |= 2;
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.n.a((Class<? extends t>) y.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public String i() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public boolean j() {
            return (this.bitField0_ & 2) == 2;
        }

        public aa k() {
            aa aaVar = this.options_;
            return aaVar == null ? aa.m() : aaVar;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!j() || k().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.a(2, (ad) k());
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + t.a(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += h.c(2, (ad) k());
            }
            int b2 = i2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof y)) {
                return super.equals(obj);
            }
            y yVar = (y) obj;
            boolean z = h() == yVar.h();
            if (h()) {
                z = z && i().equals(yVar.i());
            }
            boolean z2 = z && j() == yVar.j();
            if (j()) {
                z2 = z2 && k().equals(yVar.k());
            }
            if (!z2 || !this.unknownFields.equals(yVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
            }
            if (j()) {
                hashCode = (((hashCode * 37) + 2) * 53) + k().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: l */
        public a J() {
            return m();
        }

        public static a m() {
            return f13900c.I();
        }

        /* renamed from: n */
        public a I() {
            if (this == f13900c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements z {

            /* renamed from: a  reason: collision with root package name */
            private int f13901a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13902b;

            /* renamed from: c  reason: collision with root package name */
            private aa f13903c;

            /* renamed from: d  reason: collision with root package name */
            private an<aa, aa.a, ab> f13904d;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.n.a((Class<? extends t>) y.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13902b = "";
                this.f13903c = null;
                n();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13902b = "";
                this.f13903c = null;
                n();
            }

            private void n() {
                if (t.f14020b) {
                    o();
                }
            }

            public j.a g() {
                return i.m;
            }

            /* renamed from: h */
            public y L() {
                return y.o();
            }

            /* renamed from: i */
            public y w() {
                y j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public y v() {
                y yVar = new y((t.a) this);
                int i = this.f13901a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = yVar.name_ = this.f13902b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                an<aa, aa.a, ab> anVar = this.f13904d;
                if (anVar == null) {
                    aa unused2 = yVar.options_ = this.f13903c;
                } else {
                    aa unused3 = yVar.options_ = anVar.c();
                }
                int unused4 = yVar.bitField0_ = i2;
                x();
                return yVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof y) {
                    return a((y) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(y yVar) {
                if (yVar == y.o()) {
                    return this;
                }
                if (yVar.h()) {
                    this.f13901a |= 1;
                    this.f13902b = yVar.name_;
                    A();
                }
                if (yVar.j()) {
                    a(yVar.k());
                }
                d(yVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                return !l() || m().a();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.y.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$y> r1 = com.google.c.i.y.f13899a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$y r3 = (com.google.c.i.y) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.y) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$y r4 = (com.google.c.i.y) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.y) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.y.a.c(com.google.c.g, com.google.c.p):com.google.c.i$y$a");
            }

            public boolean l() {
                return (this.f13901a & 2) == 2;
            }

            public aa m() {
                an<aa, aa.a, ab> anVar = this.f13904d;
                if (anVar != null) {
                    return anVar.b();
                }
                aa aaVar = this.f13903c;
                return aaVar == null ? aa.m() : aaVar;
            }

            public a a(aa aaVar) {
                an<aa, aa.a, ab> anVar = this.f13904d;
                if (anVar == null) {
                    if ((this.f13901a & 2) == 2) {
                        aa aaVar2 = this.f13903c;
                        if (!(aaVar2 == null || aaVar2 == aa.m())) {
                            this.f13903c = aa.a(this.f13903c).a(aaVar).v();
                            A();
                        }
                    }
                    this.f13903c = aaVar;
                    A();
                } else {
                    anVar.a(aaVar);
                }
                this.f13901a |= 2;
                return this;
            }

            private an<aa, aa.a, ab> o() {
                if (this.f13904d == null) {
                    this.f13904d = new an<>(m(), z(), y());
                    this.f13903c = null;
                }
                return this.f13904d;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static y o() {
            return f13900c;
        }

        public aj<y> F() {
            return f13899a;
        }

        /* renamed from: p */
        public y L() {
            return f13900c;
        }
    }

    public static final class c extends t implements d {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<c> f13801a = new c<c>() {
            /* renamed from: a */
            public c b(g gVar, p pVar) throws v {
                return new c(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final c f13802c = new c();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public e options_;
        /* access modifiers changed from: private */
        public List<g> value_;

        private c(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private c() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.value_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private c(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 10) {
                            f m = gVar.m();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.name_ = m;
                        } else if (a2 == 18) {
                            if (!(z2 & true)) {
                                this.value_ = new ArrayList();
                                z2 |= true;
                            }
                            this.value_.add(gVar.a(g.f13816a, pVar));
                        } else if (a2 == 26) {
                            e.a p = (this.bitField0_ & 2) == 2 ? this.options_.I() : null;
                            this.options_ = (e) gVar.a(e.f13809a, pVar);
                            if (p != null) {
                                p.a(this.options_);
                                this.options_ = p.v();
                            }
                            this.bitField0_ |= 2;
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.value_ = Collections.unmodifiableList(this.value_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.value_ = Collections.unmodifiableList(this.value_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.p.a((Class<? extends t>) c.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public String i() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public List<g> j() {
            return this.value_;
        }

        public int k() {
            return this.value_.size();
        }

        public g a(int i) {
            return this.value_.get(i);
        }

        public boolean l() {
            return (this.bitField0_ & 2) == 2;
        }

        public e m() {
            e eVar = this.options_;
            return eVar == null ? e.q() : eVar;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < k(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!l() || m().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            for (int i = 0; i < this.value_.size(); i++) {
                hVar.a(2, (ad) this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.a(3, (ad) m());
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int a2 = (this.bitField0_ & 1) == 1 ? t.a(1, this.name_) + 0 : 0;
            for (int i2 = 0; i2 < this.value_.size(); i2++) {
                a2 += h.c(2, (ad) this.value_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                a2 += h.c(3, (ad) m());
            }
            int b2 = a2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return super.equals(obj);
            }
            c cVar = (c) obj;
            boolean z = h() == cVar.h();
            if (h()) {
                z = z && i().equals(cVar.i());
            }
            boolean z2 = (z && j().equals(cVar.j())) && l() == cVar.l();
            if (l()) {
                z2 = z2 && m().equals(cVar.m());
            }
            if (!z2 || !this.unknownFields.equals(cVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
            }
            if (k() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + j().hashCode();
            }
            if (l()) {
                hashCode = (((hashCode * 37) + 3) * 53) + m().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: n */
        public a J() {
            return o();
        }

        public static a o() {
            return f13802c.I();
        }

        /* renamed from: p */
        public a I() {
            if (this == f13802c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements d {

            /* renamed from: a  reason: collision with root package name */
            private int f13803a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13804b;

            /* renamed from: c  reason: collision with root package name */
            private List<g> f13805c;

            /* renamed from: d  reason: collision with root package name */
            private am<g, g.a, h> f13806d;

            /* renamed from: e  reason: collision with root package name */
            private e f13807e;

            /* renamed from: f  reason: collision with root package name */
            private an<e, e.a, f> f13808f;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.p.a((Class<? extends t>) c.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13804b = "";
                this.f13805c = Collections.emptyList();
                this.f13807e = null;
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13804b = "";
                this.f13805c = Collections.emptyList();
                this.f13807e = null;
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                    r();
                }
            }

            public j.a g() {
                return i.o;
            }

            /* renamed from: h */
            public c L() {
                return c.q();
            }

            /* renamed from: i */
            public c w() {
                c j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public c v() {
                c cVar = new c((t.a) this);
                int i = this.f13803a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = cVar.name_ = this.f13804b;
                am<g, g.a, h> amVar = this.f13806d;
                if (amVar == null) {
                    if ((this.f13803a & 2) == 2) {
                        this.f13805c = Collections.unmodifiableList(this.f13805c);
                        this.f13803a &= -3;
                    }
                    List unused2 = cVar.value_ = this.f13805c;
                } else {
                    List unused3 = cVar.value_ = amVar.e();
                }
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                an<e, e.a, f> anVar = this.f13808f;
                if (anVar == null) {
                    e unused4 = cVar.options_ = this.f13807e;
                } else {
                    e unused5 = cVar.options_ = anVar.c();
                }
                int unused6 = cVar.bitField0_ = i2;
                x();
                return cVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof c) {
                    return a((c) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(c cVar) {
                if (cVar == c.q()) {
                    return this;
                }
                if (cVar.h()) {
                    this.f13803a |= 1;
                    this.f13804b = cVar.name_;
                    A();
                }
                if (this.f13806d == null) {
                    if (!cVar.value_.isEmpty()) {
                        if (this.f13805c.isEmpty()) {
                            this.f13805c = cVar.value_;
                            this.f13803a &= -3;
                        } else {
                            p();
                            this.f13805c.addAll(cVar.value_);
                        }
                        A();
                    }
                } else if (!cVar.value_.isEmpty()) {
                    if (this.f13806d.d()) {
                        this.f13806d.b();
                        am<g, g.a, h> amVar = null;
                        this.f13806d = null;
                        this.f13805c = cVar.value_;
                        this.f13803a &= -3;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13806d = amVar;
                    } else {
                        this.f13806d.a(cVar.value_);
                    }
                }
                if (cVar.l()) {
                    a(cVar.m());
                }
                d(cVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!m() || n().a()) {
                    return true;
                }
                return false;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.c.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$c> r1 = com.google.c.i.c.f13801a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$c r3 = (com.google.c.i.c) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.c) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$c r4 = (com.google.c.i.c) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.c) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.c.a.c(com.google.c.g, com.google.c.p):com.google.c.i$c$a");
            }

            private void p() {
                if ((this.f13803a & 2) != 2) {
                    this.f13805c = new ArrayList(this.f13805c);
                    this.f13803a |= 2;
                }
            }

            public int l() {
                am<g, g.a, h> amVar = this.f13806d;
                if (amVar == null) {
                    return this.f13805c.size();
                }
                return amVar.c();
            }

            public g a(int i) {
                am<g, g.a, h> amVar = this.f13806d;
                if (amVar == null) {
                    return this.f13805c.get(i);
                }
                return amVar.a(i);
            }

            private am<g, g.a, h> q() {
                if (this.f13806d == null) {
                    this.f13806d = new am<>(this.f13805c, (this.f13803a & 2) == 2, z(), y());
                    this.f13805c = null;
                }
                return this.f13806d;
            }

            public boolean m() {
                return (this.f13803a & 4) == 4;
            }

            public e n() {
                an<e, e.a, f> anVar = this.f13808f;
                if (anVar != null) {
                    return anVar.b();
                }
                e eVar = this.f13807e;
                return eVar == null ? e.q() : eVar;
            }

            public a a(e eVar) {
                an<e, e.a, f> anVar = this.f13808f;
                if (anVar == null) {
                    if ((this.f13803a & 4) == 4) {
                        e eVar2 = this.f13807e;
                        if (!(eVar2 == null || eVar2 == e.q())) {
                            this.f13807e = e.a(this.f13807e).a(eVar).v();
                            A();
                        }
                    }
                    this.f13807e = eVar;
                    A();
                } else {
                    anVar.a(eVar);
                }
                this.f13803a |= 4;
                return this;
            }

            private an<e, e.a, f> r() {
                if (this.f13808f == null) {
                    this.f13808f = new an<>(n(), z(), y());
                    this.f13807e = null;
                }
                return this.f13808f;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static c q() {
            return f13802c;
        }

        public aj<c> F() {
            return f13801a;
        }

        /* renamed from: r */
        public c L() {
            return f13802c;
        }
    }

    public static final class g extends t implements h {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<g> f13816a = new c<g>() {
            /* renamed from: a */
            public g b(g gVar, p pVar) throws v {
                return new g(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final g f13817c = new g();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public int number_;
        /* access modifiers changed from: private */
        public C0230i options_;

        private g(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private g() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.number_ = 0;
        }

        public final at f() {
            return this.unknownFields;
        }

        private g(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 10) {
                            f m = gVar.m();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.name_ = m;
                        } else if (a2 == 16) {
                            this.bitField0_ |= 2;
                            this.number_ = gVar.g();
                        } else if (a2 == 26) {
                            C0230i.a n = (this.bitField0_ & 4) == 4 ? this.options_.I() : null;
                            this.options_ = (C0230i) gVar.a(C0230i.f13823a, pVar);
                            if (n != null) {
                                n.a(this.options_);
                                this.options_ = n.v();
                            }
                            this.bitField0_ |= 4;
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.r.a((Class<? extends t>) g.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public String i() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public boolean j() {
            return (this.bitField0_ & 2) == 2;
        }

        public int k() {
            return this.number_;
        }

        public boolean l() {
            return (this.bitField0_ & 4) == 4;
        }

        public C0230i m() {
            C0230i iVar = this.options_;
            return iVar == null ? C0230i.o() : iVar;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!l() || m().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.b(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                hVar.a(3, (ad) m());
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + t.a(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += h.e(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += h.c(3, (ad) m());
            }
            int b2 = i2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return super.equals(obj);
            }
            g gVar = (g) obj;
            boolean z = h() == gVar.h();
            if (h()) {
                z = z && i().equals(gVar.i());
            }
            boolean z2 = z && j() == gVar.j();
            if (j()) {
                z2 = z2 && k() == gVar.k();
            }
            boolean z3 = z2 && l() == gVar.l();
            if (l()) {
                z3 = z3 && m().equals(gVar.m());
            }
            if (!z3 || !this.unknownFields.equals(gVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
            }
            if (j()) {
                hashCode = (((hashCode * 37) + 2) * 53) + k();
            }
            if (l()) {
                hashCode = (((hashCode * 37) + 3) * 53) + m().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: n */
        public a J() {
            return o();
        }

        public static a o() {
            return f13817c.I();
        }

        /* renamed from: p */
        public a I() {
            if (this == f13817c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements h {

            /* renamed from: a  reason: collision with root package name */
            private int f13818a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13819b;

            /* renamed from: c  reason: collision with root package name */
            private int f13820c;

            /* renamed from: d  reason: collision with root package name */
            private C0230i f13821d;

            /* renamed from: e  reason: collision with root package name */
            private an<C0230i, C0230i.a, j> f13822e;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.r.a((Class<? extends t>) g.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13819b = "";
                this.f13821d = null;
                n();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13819b = "";
                this.f13821d = null;
                n();
            }

            private void n() {
                if (t.f14020b) {
                    o();
                }
            }

            public j.a g() {
                return i.q;
            }

            /* renamed from: h */
            public g L() {
                return g.q();
            }

            /* renamed from: i */
            public g w() {
                g j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public g v() {
                g gVar = new g((t.a) this);
                int i = this.f13818a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = gVar.name_ = this.f13819b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = gVar.number_ = this.f13820c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                an<C0230i, C0230i.a, j> anVar = this.f13822e;
                if (anVar == null) {
                    C0230i unused3 = gVar.options_ = this.f13821d;
                } else {
                    C0230i unused4 = gVar.options_ = anVar.c();
                }
                int unused5 = gVar.bitField0_ = i2;
                x();
                return gVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof g) {
                    return a((g) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(g gVar) {
                if (gVar == g.q()) {
                    return this;
                }
                if (gVar.h()) {
                    this.f13818a |= 1;
                    this.f13819b = gVar.name_;
                    A();
                }
                if (gVar.j()) {
                    a(gVar.k());
                }
                if (gVar.l()) {
                    a(gVar.m());
                }
                d(gVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                return !l() || m().a();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.g.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$g> r1 = com.google.c.i.g.f13816a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$g r3 = (com.google.c.i.g) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.g) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$g r4 = (com.google.c.i.g) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.g) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.g.a.c(com.google.c.g, com.google.c.p):com.google.c.i$g$a");
            }

            public a a(String str) {
                if (str != null) {
                    this.f13818a |= 1;
                    this.f13819b = str;
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            public a a(int i) {
                this.f13818a |= 2;
                this.f13820c = i;
                A();
                return this;
            }

            public boolean l() {
                return (this.f13818a & 4) == 4;
            }

            public C0230i m() {
                an<C0230i, C0230i.a, j> anVar = this.f13822e;
                if (anVar != null) {
                    return anVar.b();
                }
                C0230i iVar = this.f13821d;
                return iVar == null ? C0230i.o() : iVar;
            }

            public a a(C0230i iVar) {
                an<C0230i, C0230i.a, j> anVar = this.f13822e;
                if (anVar == null) {
                    if ((this.f13818a & 4) == 4) {
                        C0230i iVar2 = this.f13821d;
                        if (!(iVar2 == null || iVar2 == C0230i.o())) {
                            this.f13821d = C0230i.a(this.f13821d).a(iVar).v();
                            A();
                        }
                    }
                    this.f13821d = iVar;
                    A();
                } else {
                    anVar.a(iVar);
                }
                this.f13818a |= 4;
                return this;
            }

            private an<C0230i, C0230i.a, j> o() {
                if (this.f13822e == null) {
                    this.f13822e = new an<>(m(), z(), y());
                    this.f13821d = null;
                }
                return this.f13822e;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static g q() {
            return f13817c;
        }

        public aj<g> F() {
            return f13816a;
        }

        /* renamed from: r */
        public g L() {
            return f13817c;
        }
    }

    public static final class ac extends t implements ad {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<ac> f13760a = new c<ac>() {
            /* renamed from: a */
            public ac b(g gVar, p pVar) throws v {
                return new ac(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final ac f13761c = new ac();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<u> method_;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public ae options_;

        private ac(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private ac() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.method_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private ac(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 10) {
                            f m = gVar.m();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.name_ = m;
                        } else if (a2 == 18) {
                            if (!(z2 & true)) {
                                this.method_ = new ArrayList();
                                z2 |= true;
                            }
                            this.method_.add(gVar.a(u.f13884a, pVar));
                        } else if (a2 == 26) {
                            ae.a n = (this.bitField0_ & 2) == 2 ? this.options_.I() : null;
                            this.options_ = (ae) gVar.a(ae.f13768a, pVar);
                            if (n != null) {
                                n.a(this.options_);
                                this.options_ = n.v();
                            }
                            this.bitField0_ |= 2;
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.method_ = Collections.unmodifiableList(this.method_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.method_ = Collections.unmodifiableList(this.method_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.t.a((Class<? extends t>) ac.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public String i() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public List<u> j() {
            return this.method_;
        }

        public int k() {
            return this.method_.size();
        }

        public u a(int i) {
            return this.method_.get(i);
        }

        public boolean l() {
            return (this.bitField0_ & 2) == 2;
        }

        public ae m() {
            ae aeVar = this.options_;
            return aeVar == null ? ae.o() : aeVar;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < k(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!l() || m().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            for (int i = 0; i < this.method_.size(); i++) {
                hVar.a(2, (ad) this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.a(3, (ad) m());
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int a2 = (this.bitField0_ & 1) == 1 ? t.a(1, this.name_) + 0 : 0;
            for (int i2 = 0; i2 < this.method_.size(); i2++) {
                a2 += h.c(2, (ad) this.method_.get(i2));
            }
            if ((this.bitField0_ & 2) == 2) {
                a2 += h.c(3, (ad) m());
            }
            int b2 = a2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ac)) {
                return super.equals(obj);
            }
            ac acVar = (ac) obj;
            boolean z = h() == acVar.h();
            if (h()) {
                z = z && i().equals(acVar.i());
            }
            boolean z2 = (z && j().equals(acVar.j())) && l() == acVar.l();
            if (l()) {
                z2 = z2 && m().equals(acVar.m());
            }
            if (!z2 || !this.unknownFields.equals(acVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
            }
            if (k() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + j().hashCode();
            }
            if (l()) {
                hashCode = (((hashCode * 37) + 3) * 53) + m().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: n */
        public a J() {
            return o();
        }

        public static a o() {
            return f13761c.I();
        }

        /* renamed from: p */
        public a I() {
            if (this == f13761c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements ad {

            /* renamed from: a  reason: collision with root package name */
            private int f13762a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13763b;

            /* renamed from: c  reason: collision with root package name */
            private List<u> f13764c;

            /* renamed from: d  reason: collision with root package name */
            private am<u, u.a, v> f13765d;

            /* renamed from: e  reason: collision with root package name */
            private ae f13766e;

            /* renamed from: f  reason: collision with root package name */
            private an<ae, ae.a, af> f13767f;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.t.a((Class<? extends t>) ac.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13763b = "";
                this.f13764c = Collections.emptyList();
                this.f13766e = null;
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13763b = "";
                this.f13764c = Collections.emptyList();
                this.f13766e = null;
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                    r();
                }
            }

            public j.a g() {
                return i.s;
            }

            /* renamed from: h */
            public ac L() {
                return ac.q();
            }

            /* renamed from: i */
            public ac w() {
                ac j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public ac v() {
                ac acVar = new ac((t.a) this);
                int i = this.f13762a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = acVar.name_ = this.f13763b;
                am<u, u.a, v> amVar = this.f13765d;
                if (amVar == null) {
                    if ((this.f13762a & 2) == 2) {
                        this.f13764c = Collections.unmodifiableList(this.f13764c);
                        this.f13762a &= -3;
                    }
                    List unused2 = acVar.method_ = this.f13764c;
                } else {
                    List unused3 = acVar.method_ = amVar.e();
                }
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                an<ae, ae.a, af> anVar = this.f13767f;
                if (anVar == null) {
                    ae unused4 = acVar.options_ = this.f13766e;
                } else {
                    ae unused5 = acVar.options_ = anVar.c();
                }
                int unused6 = acVar.bitField0_ = i2;
                x();
                return acVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof ac) {
                    return a((ac) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(ac acVar) {
                if (acVar == ac.q()) {
                    return this;
                }
                if (acVar.h()) {
                    this.f13762a |= 1;
                    this.f13763b = acVar.name_;
                    A();
                }
                if (this.f13765d == null) {
                    if (!acVar.method_.isEmpty()) {
                        if (this.f13764c.isEmpty()) {
                            this.f13764c = acVar.method_;
                            this.f13762a &= -3;
                        } else {
                            p();
                            this.f13764c.addAll(acVar.method_);
                        }
                        A();
                    }
                } else if (!acVar.method_.isEmpty()) {
                    if (this.f13765d.d()) {
                        this.f13765d.b();
                        am<u, u.a, v> amVar = null;
                        this.f13765d = null;
                        this.f13764c = acVar.method_;
                        this.f13762a &= -3;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13765d = amVar;
                    } else {
                        this.f13765d.a(acVar.method_);
                    }
                }
                if (acVar.l()) {
                    a(acVar.m());
                }
                d(acVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!m() || n().a()) {
                    return true;
                }
                return false;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.ac.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$ac> r1 = com.google.c.i.ac.f13760a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$ac r3 = (com.google.c.i.ac) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.ac) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$ac r4 = (com.google.c.i.ac) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.ac) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.ac.a.c(com.google.c.g, com.google.c.p):com.google.c.i$ac$a");
            }

            private void p() {
                if ((this.f13762a & 2) != 2) {
                    this.f13764c = new ArrayList(this.f13764c);
                    this.f13762a |= 2;
                }
            }

            public int l() {
                am<u, u.a, v> amVar = this.f13765d;
                if (amVar == null) {
                    return this.f13764c.size();
                }
                return amVar.c();
            }

            public u a(int i) {
                am<u, u.a, v> amVar = this.f13765d;
                if (amVar == null) {
                    return this.f13764c.get(i);
                }
                return amVar.a(i);
            }

            private am<u, u.a, v> q() {
                if (this.f13765d == null) {
                    this.f13765d = new am<>(this.f13764c, (this.f13762a & 2) == 2, z(), y());
                    this.f13764c = null;
                }
                return this.f13765d;
            }

            public boolean m() {
                return (this.f13762a & 4) == 4;
            }

            public ae n() {
                an<ae, ae.a, af> anVar = this.f13767f;
                if (anVar != null) {
                    return anVar.b();
                }
                ae aeVar = this.f13766e;
                return aeVar == null ? ae.o() : aeVar;
            }

            public a a(ae aeVar) {
                an<ae, ae.a, af> anVar = this.f13767f;
                if (anVar == null) {
                    if ((this.f13762a & 4) == 4) {
                        ae aeVar2 = this.f13766e;
                        if (!(aeVar2 == null || aeVar2 == ae.o())) {
                            this.f13766e = ae.a(this.f13766e).a(aeVar).v();
                            A();
                        }
                    }
                    this.f13766e = aeVar;
                    A();
                } else {
                    anVar.a(aeVar);
                }
                this.f13762a |= 4;
                return this;
            }

            private an<ae, ae.a, af> r() {
                if (this.f13767f == null) {
                    this.f13767f = new an<>(n(), z(), y());
                    this.f13766e = null;
                }
                return this.f13767f;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static ac q() {
            return f13761c;
        }

        public aj<ac> F() {
            return f13760a;
        }

        /* renamed from: r */
        public ac L() {
            return f13761c;
        }
    }

    public static final class u extends t implements v {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<u> f13884a = new c<u>() {
            /* renamed from: a */
            public u b(g gVar, p pVar) throws v {
                return new u(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final u f13885c = new u();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean clientStreaming_;
        /* access modifiers changed from: private */
        public volatile Object inputType_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object name_;
        /* access modifiers changed from: private */
        public w options_;
        /* access modifiers changed from: private */
        public volatile Object outputType_;
        /* access modifiers changed from: private */
        public boolean serverStreaming_;

        private u(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private u() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.inputType_ = "";
            this.outputType_ = "";
            this.clientStreaming_ = false;
            this.serverStreaming_ = false;
        }

        public final at f() {
            return this.unknownFields;
        }

        private u(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 10) {
                            f m = gVar.m();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.name_ = m;
                        } else if (a2 == 18) {
                            f m2 = gVar.m();
                            this.bitField0_ |= 2;
                            this.inputType_ = m2;
                        } else if (a2 == 26) {
                            f m3 = gVar.m();
                            this.bitField0_ |= 4;
                            this.outputType_ = m3;
                        } else if (a2 == 34) {
                            w.a n = (this.bitField0_ & 8) == 8 ? this.options_.I() : null;
                            this.options_ = (w) gVar.a(w.f13893a, pVar);
                            if (n != null) {
                                n.a(this.options_);
                                this.options_ = n.v();
                            }
                            this.bitField0_ |= 8;
                        } else if (a2 == 40) {
                            this.bitField0_ |= 16;
                            this.clientStreaming_ = gVar.j();
                        } else if (a2 == 48) {
                            this.bitField0_ |= 32;
                            this.serverStreaming_ = gVar.j();
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.v.a((Class<? extends t>) u.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public String i() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.name_ = d2;
            }
            return d2;
        }

        public boolean j() {
            return (this.bitField0_ & 2) == 2;
        }

        public String k() {
            Object obj = this.inputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.inputType_ = d2;
            }
            return d2;
        }

        public boolean l() {
            return (this.bitField0_ & 4) == 4;
        }

        public String m() {
            Object obj = this.outputType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.outputType_ = d2;
            }
            return d2;
        }

        public boolean n() {
            return (this.bitField0_ & 8) == 8;
        }

        public w o() {
            w wVar = this.options_;
            return wVar == null ? w.o() : wVar;
        }

        public boolean p() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean q() {
            return this.clientStreaming_;
        }

        public boolean r() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean s() {
            return this.serverStreaming_;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!n() || o().a()) {
                this.memoizedIsInitialized = 1;
                return true;
            }
            this.memoizedIsInitialized = 0;
            return false;
        }

        public void a(h hVar) throws IOException {
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                t.a(hVar, 2, this.inputType_);
            }
            if ((this.bitField0_ & 4) == 4) {
                t.a(hVar, 3, this.outputType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                hVar.a(4, (ad) o());
            }
            if ((this.bitField0_ & 16) == 16) {
                hVar.a(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                hVar.a(6, this.serverStreaming_);
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + t.a(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += t.a(2, this.inputType_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += t.a(3, this.outputType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += h.c(4, (ad) o());
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += h.b(5, this.clientStreaming_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += h.b(6, this.serverStreaming_);
            }
            int b2 = i2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof u)) {
                return super.equals(obj);
            }
            u uVar = (u) obj;
            boolean z = h() == uVar.h();
            if (h()) {
                z = z && i().equals(uVar.i());
            }
            boolean z2 = z && j() == uVar.j();
            if (j()) {
                z2 = z2 && k().equals(uVar.k());
            }
            boolean z3 = z2 && l() == uVar.l();
            if (l()) {
                z3 = z3 && m().equals(uVar.m());
            }
            boolean z4 = z3 && n() == uVar.n();
            if (n()) {
                z4 = z4 && o().equals(uVar.o());
            }
            boolean z5 = z4 && p() == uVar.p();
            if (p()) {
                z5 = z5 && q() == uVar.q();
            }
            boolean z6 = z5 && r() == uVar.r();
            if (r()) {
                z6 = z6 && s() == uVar.s();
            }
            if (!z6 || !this.unknownFields.equals(uVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
            }
            if (j()) {
                hashCode = (((hashCode * 37) + 2) * 53) + k().hashCode();
            }
            if (l()) {
                hashCode = (((hashCode * 37) + 3) * 53) + m().hashCode();
            }
            if (n()) {
                hashCode = (((hashCode * 37) + 4) * 53) + o().hashCode();
            }
            if (p()) {
                hashCode = (((hashCode * 37) + 5) * 53) + u.a(q());
            }
            if (r()) {
                hashCode = (((hashCode * 37) + 6) * 53) + u.a(s());
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: t */
        public a J() {
            return u();
        }

        public static a u() {
            return f13885c.I();
        }

        /* renamed from: v */
        public a I() {
            if (this == f13885c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements v {

            /* renamed from: a  reason: collision with root package name */
            private int f13886a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13887b;

            /* renamed from: c  reason: collision with root package name */
            private Object f13888c;

            /* renamed from: d  reason: collision with root package name */
            private Object f13889d;

            /* renamed from: e  reason: collision with root package name */
            private w f13890e;

            /* renamed from: f  reason: collision with root package name */
            private an<w, w.a, x> f13891f;

            /* renamed from: g  reason: collision with root package name */
            private boolean f13892g;
            private boolean h;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.v.a((Class<? extends t>) u.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13887b = "";
                this.f13888c = "";
                this.f13889d = "";
                this.f13890e = null;
                n();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13887b = "";
                this.f13888c = "";
                this.f13889d = "";
                this.f13890e = null;
                n();
            }

            private void n() {
                if (t.f14020b) {
                    o();
                }
            }

            public j.a g() {
                return i.u;
            }

            /* renamed from: h */
            public u L() {
                return u.w();
            }

            /* renamed from: i */
            public u w() {
                u j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public u v() {
                u uVar = new u((t.a) this);
                int i = this.f13886a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = uVar.name_ = this.f13887b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                Object unused2 = uVar.inputType_ = this.f13888c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = uVar.outputType_ = this.f13889d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                an<w, w.a, x> anVar = this.f13891f;
                if (anVar == null) {
                    w unused4 = uVar.options_ = this.f13890e;
                } else {
                    w unused5 = uVar.options_ = anVar.c();
                }
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                boolean unused6 = uVar.clientStreaming_ = this.f13892g;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                boolean unused7 = uVar.serverStreaming_ = this.h;
                int unused8 = uVar.bitField0_ = i2;
                x();
                return uVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof u) {
                    return a((u) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(u uVar) {
                if (uVar == u.w()) {
                    return this;
                }
                if (uVar.h()) {
                    this.f13886a |= 1;
                    this.f13887b = uVar.name_;
                    A();
                }
                if (uVar.j()) {
                    this.f13886a |= 2;
                    this.f13888c = uVar.inputType_;
                    A();
                }
                if (uVar.l()) {
                    this.f13886a |= 4;
                    this.f13889d = uVar.outputType_;
                    A();
                }
                if (uVar.n()) {
                    a(uVar.o());
                }
                if (uVar.p()) {
                    a(uVar.q());
                }
                if (uVar.r()) {
                    b(uVar.s());
                }
                d(uVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                return !l() || m().a();
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.u.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$u> r1 = com.google.c.i.u.f13884a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$u r3 = (com.google.c.i.u) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.u) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$u r4 = (com.google.c.i.u) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.u) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.u.a.c(com.google.c.g, com.google.c.p):com.google.c.i$u$a");
            }

            public boolean l() {
                return (this.f13886a & 8) == 8;
            }

            public w m() {
                an<w, w.a, x> anVar = this.f13891f;
                if (anVar != null) {
                    return anVar.b();
                }
                w wVar = this.f13890e;
                return wVar == null ? w.o() : wVar;
            }

            public a a(w wVar) {
                an<w, w.a, x> anVar = this.f13891f;
                if (anVar == null) {
                    if ((this.f13886a & 8) == 8) {
                        w wVar2 = this.f13890e;
                        if (!(wVar2 == null || wVar2 == w.o())) {
                            this.f13890e = w.a(this.f13890e).a(wVar).v();
                            A();
                        }
                    }
                    this.f13890e = wVar;
                    A();
                } else {
                    anVar.a(wVar);
                }
                this.f13886a |= 8;
                return this;
            }

            private an<w, w.a, x> o() {
                if (this.f13891f == null) {
                    this.f13891f = new an<>(m(), z(), y());
                    this.f13890e = null;
                }
                return this.f13891f;
            }

            public a a(boolean z) {
                this.f13886a |= 16;
                this.f13892g = z;
                A();
                return this;
            }

            public a b(boolean z) {
                this.f13886a |= 32;
                this.h = z;
                A();
                return this;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static u w() {
            return f13885c;
        }

        public aj<u> F() {
            return f13884a;
        }

        /* renamed from: x */
        public u L() {
            return f13885c;
        }
    }

    public static final class q extends t.d<q> implements r {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<q> f13864a = new c<q>() {
            /* renamed from: a */
            public q b(g gVar, p pVar) throws v {
                return new q(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final q f13865c = new q();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean ccEnableArenas_;
        /* access modifiers changed from: private */
        public boolean ccGenericServices_;
        /* access modifiers changed from: private */
        public volatile Object csharpNamespace_;
        /* access modifiers changed from: private */
        public boolean deprecated_;
        /* access modifiers changed from: private */
        public volatile Object goPackage_;
        /* access modifiers changed from: private */
        public boolean javaGenerateEqualsAndHash_;
        /* access modifiers changed from: private */
        public boolean javaGenericServices_;
        /* access modifiers changed from: private */
        public boolean javaMultipleFiles_;
        /* access modifiers changed from: private */
        public volatile Object javaOuterClassname_;
        /* access modifiers changed from: private */
        public volatile Object javaPackage_;
        /* access modifiers changed from: private */
        public boolean javaStringCheckUtf8_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public volatile Object objcClassPrefix_;
        /* access modifiers changed from: private */
        public int optimizeFor_;
        /* access modifiers changed from: private */
        public boolean pyGenericServices_;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;

        private q(t.c<q, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private q() {
            this.memoizedIsInitialized = -1;
            this.javaPackage_ = "";
            this.javaOuterClassname_ = "";
            this.javaMultipleFiles_ = false;
            this.javaGenerateEqualsAndHash_ = false;
            this.javaStringCheckUtf8_ = false;
            this.optimizeFor_ = 1;
            this.goPackage_ = "";
            this.ccGenericServices_ = false;
            this.javaGenericServices_ = false;
            this.pyGenericServices_ = false;
            this.deprecated_ = false;
            this.ccEnableArenas_ = false;
            this.objcClassPrefix_ = "";
            this.csharpNamespace_ = "";
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private q(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    switch (a2) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            f m = gVar.m();
                            this.bitField0_ = 1 | this.bitField0_;
                            this.javaPackage_ = m;
                            break;
                        case 66:
                            f m2 = gVar.m();
                            this.bitField0_ |= 2;
                            this.javaOuterClassname_ = m2;
                            break;
                        case 72:
                            int o = gVar.o();
                            if (b.valueOf(o) != null) {
                                this.bitField0_ |= 32;
                                this.optimizeFor_ = o;
                                break;
                            } else {
                                c2.a(9, o);
                                break;
                            }
                        case 80:
                            this.bitField0_ |= 4;
                            this.javaMultipleFiles_ = gVar.j();
                            break;
                        case 90:
                            f m3 = gVar.m();
                            this.bitField0_ |= 64;
                            this.goPackage_ = m3;
                            break;
                        case 128:
                            this.bitField0_ |= 128;
                            this.ccGenericServices_ = gVar.j();
                            break;
                        case 136:
                            this.bitField0_ |= 256;
                            this.javaGenericServices_ = gVar.j();
                            break;
                        case IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /*144*/:
                            this.bitField0_ |= 512;
                            this.pyGenericServices_ = gVar.j();
                            break;
                        case 160:
                            this.bitField0_ |= 8;
                            this.javaGenerateEqualsAndHash_ = gVar.j();
                            break;
                        case 184:
                            this.bitField0_ |= 1024;
                            this.deprecated_ = gVar.j();
                            break;
                        case 216:
                            this.bitField0_ |= 16;
                            this.javaStringCheckUtf8_ = gVar.j();
                            break;
                        case 248:
                            this.bitField0_ |= 2048;
                            this.ccEnableArenas_ = gVar.j();
                            break;
                        case 290:
                            f m4 = gVar.m();
                            this.bitField0_ |= 4096;
                            this.objcClassPrefix_ = m4;
                            break;
                        case 298:
                            f m5 = gVar.m();
                            this.bitField0_ |= 8192;
                            this.csharpNamespace_ = m5;
                            break;
                        case 7994:
                            if (!(z2 & true)) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                            break;
                        default:
                            if (a(gVar, c2, pVar, a2)) {
                                break;
                            }
                            z = true;
                            break;
                    }
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        public static final j.a h() {
            return i.w;
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.x.a((Class<? extends t>) q.class, (Class<? extends t.a>) a.class);
        }

        public enum b implements ak {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            
            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;

            /* renamed from: a  reason: collision with root package name */
            private static final u.b<b> f13873a = null;

            /* renamed from: b  reason: collision with root package name */
            private static final b[] f13874b = null;
            private final int value;

            static {
                f13873a = new u.b<b>() {
                };
                f13874b = values();
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static b valueOf(int i) {
                return forNumber(i);
            }

            public static b forNumber(int i) {
                if (i == 1) {
                    return SPEED;
                }
                if (i == 2) {
                    return CODE_SIZE;
                }
                if (i != 3) {
                    return null;
                }
                return LITE_RUNTIME;
            }

            public static u.b<b> internalGetValueMap() {
                return f13873a;
            }

            public final j.e getValueDescriptor() {
                return getDescriptor().e().get(ordinal());
            }

            public final j.d getDescriptorForType() {
                return getDescriptor();
            }

            public static final j.d getDescriptor() {
                return q.h().i().get(0);
            }

            public static b valueOf(j.e eVar) {
                if (eVar.f() == getDescriptor()) {
                    return f13874b[eVar.a()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private b(int i) {
                this.value = i;
            }
        }

        public boolean i() {
            return (this.bitField0_ & 1) == 1;
        }

        public String j() {
            Object obj = this.javaPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.javaPackage_ = d2;
            }
            return d2;
        }

        public boolean k() {
            return (this.bitField0_ & 2) == 2;
        }

        public String l() {
            Object obj = this.javaOuterClassname_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.javaOuterClassname_ = d2;
            }
            return d2;
        }

        public boolean m() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean n() {
            return this.javaMultipleFiles_;
        }

        public boolean o() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean p() {
            return this.javaGenerateEqualsAndHash_;
        }

        public boolean q() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean r() {
            return this.javaStringCheckUtf8_;
        }

        public boolean s() {
            return (this.bitField0_ & 32) == 32;
        }

        public b t() {
            b valueOf = b.valueOf(this.optimizeFor_);
            return valueOf == null ? b.SPEED : valueOf;
        }

        public boolean u() {
            return (this.bitField0_ & 64) == 64;
        }

        public String v() {
            Object obj = this.goPackage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.goPackage_ = d2;
            }
            return d2;
        }

        public boolean w() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean x() {
            return this.ccGenericServices_;
        }

        public boolean y() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean z() {
            return this.javaGenericServices_;
        }

        public boolean A() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean B() {
            return this.pyGenericServices_;
        }

        public boolean C() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean D() {
            return this.deprecated_;
        }

        public boolean E() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean G() {
            return this.ccEnableArenas_;
        }

        public boolean M() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public String N() {
            Object obj = this.objcClassPrefix_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.objcClassPrefix_ = d2;
            }
            return d2;
        }

        public boolean O() {
            return (this.bitField0_ & 8192) == 8192;
        }

        public String P() {
            Object obj = this.csharpNamespace_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.csharpNamespace_ = d2;
            }
            return d2;
        }

        public List<ai> Q() {
            return this.uninterpretedOption_;
        }

        public int R() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < R(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 1, this.javaPackage_);
            }
            if ((this.bitField0_ & 2) == 2) {
                t.a(hVar, 8, this.javaOuterClassname_);
            }
            if ((this.bitField0_ & 32) == 32) {
                hVar.d(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                hVar.a(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                t.a(hVar, 11, this.goPackage_);
            }
            if ((this.bitField0_ & 128) == 128) {
                hVar.a(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                hVar.a(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                hVar.a(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                hVar.a(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                hVar.a(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                hVar.a(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                hVar.a(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                t.a(hVar, 36, this.objcClassPrefix_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                t.a(hVar, 37, this.csharpNamespace_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int a2 = (this.bitField0_ & 1) == 1 ? t.a(1, this.javaPackage_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                a2 += t.a(8, this.javaOuterClassname_);
            }
            if ((this.bitField0_ & 32) == 32) {
                a2 += h.h(9, this.optimizeFor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                a2 += h.b(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 64) == 64) {
                a2 += t.a(11, this.goPackage_);
            }
            if ((this.bitField0_ & 128) == 128) {
                a2 += h.b(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 256) == 256) {
                a2 += h.b(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 512) == 512) {
                a2 += h.b(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                a2 += h.b(20, this.javaGenerateEqualsAndHash_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                a2 += h.b(23, this.deprecated_);
            }
            if ((this.bitField0_ & 16) == 16) {
                a2 += h.b(27, this.javaStringCheckUtf8_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                a2 += h.b(31, this.ccEnableArenas_);
            }
            if ((this.bitField0_ & 4096) == 4096) {
                a2 += t.a(36, this.objcClassPrefix_);
            }
            if ((this.bitField0_ & 8192) == 8192) {
                a2 += t.a(37, this.csharpNamespace_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                a2 += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i2));
            }
            int ab = a2 + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof q)) {
                return super.equals(obj);
            }
            q qVar = (q) obj;
            boolean z = i() == qVar.i();
            if (i()) {
                z = z && j().equals(qVar.j());
            }
            boolean z2 = z && k() == qVar.k();
            if (k()) {
                z2 = z2 && l().equals(qVar.l());
            }
            boolean z3 = z2 && m() == qVar.m();
            if (m()) {
                z3 = z3 && n() == qVar.n();
            }
            boolean z4 = z3 && o() == qVar.o();
            if (o()) {
                z4 = z4 && p() == qVar.p();
            }
            boolean z5 = z4 && q() == qVar.q();
            if (q()) {
                z5 = z5 && r() == qVar.r();
            }
            boolean z6 = z5 && s() == qVar.s();
            if (s()) {
                z6 = z6 && this.optimizeFor_ == qVar.optimizeFor_;
            }
            boolean z7 = z6 && u() == qVar.u();
            if (u()) {
                z7 = z7 && v().equals(qVar.v());
            }
            boolean z8 = z7 && w() == qVar.w();
            if (w()) {
                z8 = z8 && x() == qVar.x();
            }
            boolean z9 = z8 && y() == qVar.y();
            if (y()) {
                z9 = z9 && z() == qVar.z();
            }
            boolean z10 = z9 && A() == qVar.A();
            if (A()) {
                z10 = z10 && B() == qVar.B();
            }
            boolean z11 = z10 && C() == qVar.C();
            if (C()) {
                z11 = z11 && D() == qVar.D();
            }
            boolean z12 = z11 && E() == qVar.E();
            if (E()) {
                z12 = z12 && G() == qVar.G();
            }
            boolean z13 = z12 && M() == qVar.M();
            if (M()) {
                z13 = z13 && N().equals(qVar.N());
            }
            boolean z14 = z13 && O() == qVar.O();
            if (O()) {
                z14 = z14 && P().equals(qVar.P());
            }
            if (!((z14 && Q().equals(qVar.Q())) && this.unknownFields.equals(qVar.unknownFields)) || !ac().equals(qVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (i()) {
                hashCode = (((hashCode * 37) + 1) * 53) + j().hashCode();
            }
            if (k()) {
                hashCode = (((hashCode * 37) + 8) * 53) + l().hashCode();
            }
            if (m()) {
                hashCode = (((hashCode * 37) + 10) * 53) + u.a(n());
            }
            if (o()) {
                hashCode = (((hashCode * 37) + 20) * 53) + u.a(p());
            }
            if (q()) {
                hashCode = (((hashCode * 37) + 27) * 53) + u.a(r());
            }
            if (s()) {
                hashCode = (((hashCode * 37) + 9) * 53) + this.optimizeFor_;
            }
            if (u()) {
                hashCode = (((hashCode * 37) + 11) * 53) + v().hashCode();
            }
            if (w()) {
                hashCode = (((hashCode * 37) + 16) * 53) + u.a(x());
            }
            if (y()) {
                hashCode = (((hashCode * 37) + 17) * 53) + u.a(z());
            }
            if (A()) {
                hashCode = (((hashCode * 37) + 18) * 53) + u.a(B());
            }
            if (C()) {
                hashCode = (((hashCode * 37) + 23) * 53) + u.a(D());
            }
            if (E()) {
                hashCode = (((hashCode * 37) + 31) * 53) + u.a(G());
            }
            if (M()) {
                hashCode = (((hashCode * 37) + 36) * 53) + N().hashCode();
            }
            if (O()) {
                hashCode = (((hashCode * 37) + 37) * 53) + P().hashCode();
            }
            if (R() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + Q().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: S */
        public a J() {
            return T();
        }

        public static a T() {
            return f13865c.I();
        }

        public static a a(q qVar) {
            return f13865c.I().a(qVar);
        }

        /* renamed from: U */
        public a I() {
            if (this == f13865c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.c<q, a> implements r {

            /* renamed from: a  reason: collision with root package name */
            private int f13866a;

            /* renamed from: b  reason: collision with root package name */
            private Object f13867b;

            /* renamed from: c  reason: collision with root package name */
            private Object f13868c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f13869d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f13870e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f13871f;

            /* renamed from: g  reason: collision with root package name */
            private int f13872g;
            private Object h;
            private boolean i;
            private boolean j;
            private boolean k;
            private boolean l;
            private boolean m;
            private Object n;
            private Object o;
            private List<ai> p;
            private am<ai, ai.a, aj> q;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.x.a((Class<? extends t>) q.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13867b = "";
                this.f13868c = "";
                this.f13872g = 1;
                this.h = "";
                this.n = "";
                this.o = "";
                this.p = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13867b = "";
                this.f13868c = "";
                this.f13872g = 1;
                this.h = "";
                this.n = "";
                this.o = "";
                this.p = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.w;
            }

            /* renamed from: h */
            public q L() {
                return q.V();
            }

            /* renamed from: i */
            public q w() {
                q j2 = v();
                if (j2.a()) {
                    return j2;
                }
                throw b((ac) j2);
            }

            /* renamed from: j */
            public q v() {
                q qVar = new q((t.c) this);
                int i2 = this.f13866a;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                Object unused = qVar.javaPackage_ = this.f13867b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                Object unused2 = qVar.javaOuterClassname_ = this.f13868c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                boolean unused3 = qVar.javaMultipleFiles_ = this.f13869d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                boolean unused4 = qVar.javaGenerateEqualsAndHash_ = this.f13870e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                boolean unused5 = qVar.javaStringCheckUtf8_ = this.f13871f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                int unused6 = qVar.optimizeFor_ = this.f13872g;
                if ((i2 & 64) == 64) {
                    i3 |= 64;
                }
                Object unused7 = qVar.goPackage_ = this.h;
                if ((i2 & 128) == 128) {
                    i3 |= 128;
                }
                boolean unused8 = qVar.ccGenericServices_ = this.i;
                if ((i2 & 256) == 256) {
                    i3 |= 256;
                }
                boolean unused9 = qVar.javaGenericServices_ = this.j;
                if ((i2 & 512) == 512) {
                    i3 |= 512;
                }
                boolean unused10 = qVar.pyGenericServices_ = this.k;
                if ((i2 & 1024) == 1024) {
                    i3 |= 1024;
                }
                boolean unused11 = qVar.deprecated_ = this.l;
                if ((i2 & 2048) == 2048) {
                    i3 |= 2048;
                }
                boolean unused12 = qVar.ccEnableArenas_ = this.m;
                if ((i2 & 4096) == 4096) {
                    i3 |= 4096;
                }
                Object unused13 = qVar.objcClassPrefix_ = this.n;
                if ((i2 & 8192) == 8192) {
                    i3 |= 8192;
                }
                Object unused14 = qVar.csharpNamespace_ = this.o;
                am<ai, ai.a, aj> amVar = this.q;
                if (amVar == null) {
                    if ((this.f13866a & TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE) == 16384) {
                        this.p = Collections.unmodifiableList(this.p);
                        this.f13866a &= -16385;
                    }
                    List unused15 = qVar.uninterpretedOption_ = this.p;
                } else {
                    List unused16 = qVar.uninterpretedOption_ = amVar.e();
                }
                int unused17 = qVar.bitField0_ = i3;
                x();
                return qVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof q) {
                    return a((q) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(q qVar) {
                if (qVar == q.V()) {
                    return this;
                }
                if (qVar.i()) {
                    this.f13866a |= 1;
                    this.f13867b = qVar.javaPackage_;
                    A();
                }
                if (qVar.k()) {
                    this.f13866a |= 2;
                    this.f13868c = qVar.javaOuterClassname_;
                    A();
                }
                if (qVar.m()) {
                    a(qVar.n());
                }
                if (qVar.o()) {
                    b(qVar.p());
                }
                if (qVar.q()) {
                    c(qVar.r());
                }
                if (qVar.s()) {
                    a(qVar.t());
                }
                if (qVar.u()) {
                    this.f13866a |= 64;
                    this.h = qVar.goPackage_;
                    A();
                }
                if (qVar.w()) {
                    d(qVar.x());
                }
                if (qVar.y()) {
                    e(qVar.z());
                }
                if (qVar.A()) {
                    f(qVar.B());
                }
                if (qVar.C()) {
                    g(qVar.D());
                }
                if (qVar.E()) {
                    h(qVar.G());
                }
                if (qVar.M()) {
                    this.f13866a |= 4096;
                    this.n = qVar.objcClassPrefix_;
                    A();
                }
                if (qVar.O()) {
                    this.f13866a |= 8192;
                    this.o = qVar.csharpNamespace_;
                    A();
                }
                if (this.q == null) {
                    if (!qVar.uninterpretedOption_.isEmpty()) {
                        if (this.p.isEmpty()) {
                            this.p = qVar.uninterpretedOption_;
                            this.f13866a &= -16385;
                        } else {
                            p();
                            this.p.addAll(qVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!qVar.uninterpretedOption_.isEmpty()) {
                    if (this.q.d()) {
                        this.q.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.q = null;
                        this.p = qVar.uninterpretedOption_;
                        this.f13866a &= -16385;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.q = amVar;
                    } else {
                        this.q.a(qVar.uninterpretedOption_);
                    }
                }
                a((t.d) qVar);
                d(qVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i2 = 0; i2 < l(); i2++) {
                    if (!a(i2).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.q.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$q> r1 = com.google.c.i.q.f13864a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$q r3 = (com.google.c.i.q) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.q) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$q r4 = (com.google.c.i.q) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.q) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.q.a.c(com.google.c.g, com.google.c.p):com.google.c.i$q$a");
            }

            public a a(boolean z) {
                this.f13866a |= 4;
                this.f13869d = z;
                A();
                return this;
            }

            public a b(boolean z) {
                this.f13866a |= 8;
                this.f13870e = z;
                A();
                return this;
            }

            public a c(boolean z) {
                this.f13866a |= 16;
                this.f13871f = z;
                A();
                return this;
            }

            public a a(b bVar) {
                if (bVar != null) {
                    this.f13866a |= 32;
                    this.f13872g = bVar.getNumber();
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            public a d(boolean z) {
                this.f13866a |= 128;
                this.i = z;
                A();
                return this;
            }

            public a e(boolean z) {
                this.f13866a |= 256;
                this.j = z;
                A();
                return this;
            }

            public a f(boolean z) {
                this.f13866a |= 512;
                this.k = z;
                A();
                return this;
            }

            public a g(boolean z) {
                this.f13866a |= 1024;
                this.l = z;
                A();
                return this;
            }

            public a h(boolean z) {
                this.f13866a |= 2048;
                this.m = z;
                A();
                return this;
            }

            private void p() {
                if ((this.f13866a & TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE) != 16384) {
                    this.p = new ArrayList(this.p);
                    this.f13866a |= TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.q;
                if (amVar == null) {
                    return this.p.size();
                }
                return amVar.c();
            }

            public ai a(int i2) {
                am<ai, ai.a, aj> amVar = this.q;
                if (amVar == null) {
                    return this.p.get(i2);
                }
                return amVar.a(i2);
            }

            private am<ai, ai.a, aj> q() {
                if (this.q == null) {
                    this.q = new am<>(this.p, (this.f13866a & TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE) == 16384, z(), y());
                    this.p = null;
                }
                return this.q;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static q V() {
            return f13865c;
        }

        public aj<q> F() {
            return f13864a;
        }

        /* renamed from: W */
        public q L() {
            return f13865c;
        }
    }

    public static final class s extends t.d<s> implements t {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<s> f13875a = new c<s>() {
            /* renamed from: a */
            public s b(g gVar, p pVar) throws v {
                return new s(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final s f13876c = new s();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean deprecated_;
        /* access modifiers changed from: private */
        public boolean mapEntry_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public boolean messageSetWireFormat_;
        /* access modifiers changed from: private */
        public boolean noStandardDescriptorAccessor_;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;

        private s(t.c<s, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private s() {
            this.memoizedIsInitialized = -1;
            this.messageSetWireFormat_ = false;
            this.noStandardDescriptorAccessor_ = false;
            this.deprecated_ = false;
            this.mapEntry_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private s(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 8) {
                            this.bitField0_ |= 1;
                            this.messageSetWireFormat_ = gVar.j();
                        } else if (a2 == 16) {
                            this.bitField0_ |= 2;
                            this.noStandardDescriptorAccessor_ = gVar.j();
                        } else if (a2 == 24) {
                            this.bitField0_ |= 4;
                            this.deprecated_ = gVar.j();
                        } else if (a2 == 56) {
                            this.bitField0_ |= 8;
                            this.mapEntry_ = gVar.j();
                        } else if (a2 == 7994) {
                            if (!(z2 & true)) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.z.a((Class<? extends t>) s.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean i() {
            return this.messageSetWireFormat_;
        }

        public boolean j() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean k() {
            return this.noStandardDescriptorAccessor_;
        }

        public boolean l() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean m() {
            return this.deprecated_;
        }

        public boolean n() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean o() {
            return this.mapEntry_;
        }

        public List<ai> p() {
            return this.uninterpretedOption_;
        }

        public int q() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < q(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            if ((this.bitField0_ & 1) == 1) {
                hVar.a(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.a(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                hVar.a(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                hVar.a(7, this.mapEntry_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int b2 = (this.bitField0_ & 1) == 1 ? h.b(1, this.messageSetWireFormat_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                b2 += h.b(2, this.noStandardDescriptorAccessor_);
            }
            if ((this.bitField0_ & 4) == 4) {
                b2 += h.b(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                b2 += h.b(7, this.mapEntry_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                b2 += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i2));
            }
            int ab = b2 + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof s)) {
                return super.equals(obj);
            }
            s sVar = (s) obj;
            boolean z = h() == sVar.h();
            if (h()) {
                z = z && i() == sVar.i();
            }
            boolean z2 = z && j() == sVar.j();
            if (j()) {
                z2 = z2 && k() == sVar.k();
            }
            boolean z3 = z2 && l() == sVar.l();
            if (l()) {
                z3 = z3 && m() == sVar.m();
            }
            boolean z4 = z3 && n() == sVar.n();
            if (n()) {
                z4 = z4 && o() == sVar.o();
            }
            if (!((z4 && p().equals(sVar.p())) && this.unknownFields.equals(sVar.unknownFields)) || !ac().equals(sVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + u.a(i());
            }
            if (j()) {
                hashCode = (((hashCode * 37) + 2) * 53) + u.a(k());
            }
            if (l()) {
                hashCode = (((hashCode * 37) + 3) * 53) + u.a(m());
            }
            if (n()) {
                hashCode = (((hashCode * 37) + 7) * 53) + u.a(o());
            }
            if (q() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + p().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: r */
        public a J() {
            return s();
        }

        public static a s() {
            return f13876c.I();
        }

        public static a a(s sVar) {
            return f13876c.I().a(sVar);
        }

        /* renamed from: t */
        public a I() {
            if (this == f13876c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.c<s, a> implements t {

            /* renamed from: a  reason: collision with root package name */
            private int f13877a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f13878b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f13879c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f13880d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f13881e;

            /* renamed from: f  reason: collision with root package name */
            private List<ai> f13882f;

            /* renamed from: g  reason: collision with root package name */
            private am<ai, ai.a, aj> f13883g;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.z.a((Class<? extends t>) s.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13882f = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13882f = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.y;
            }

            /* renamed from: h */
            public s L() {
                return s.u();
            }

            /* renamed from: i */
            public s w() {
                s j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public s v() {
                s sVar = new s((t.c) this);
                int i = this.f13877a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                boolean unused = sVar.messageSetWireFormat_ = this.f13878b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                boolean unused2 = sVar.noStandardDescriptorAccessor_ = this.f13879c;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                boolean unused3 = sVar.deprecated_ = this.f13880d;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                boolean unused4 = sVar.mapEntry_ = this.f13881e;
                am<ai, ai.a, aj> amVar = this.f13883g;
                if (amVar == null) {
                    if ((this.f13877a & 16) == 16) {
                        this.f13882f = Collections.unmodifiableList(this.f13882f);
                        this.f13877a &= -17;
                    }
                    List unused5 = sVar.uninterpretedOption_ = this.f13882f;
                } else {
                    List unused6 = sVar.uninterpretedOption_ = amVar.e();
                }
                int unused7 = sVar.bitField0_ = i2;
                x();
                return sVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof s) {
                    return a((s) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(s sVar) {
                if (sVar == s.u()) {
                    return this;
                }
                if (sVar.h()) {
                    a(sVar.i());
                }
                if (sVar.j()) {
                    b(sVar.k());
                }
                if (sVar.l()) {
                    c(sVar.m());
                }
                if (sVar.n()) {
                    d(sVar.o());
                }
                if (this.f13883g == null) {
                    if (!sVar.uninterpretedOption_.isEmpty()) {
                        if (this.f13882f.isEmpty()) {
                            this.f13882f = sVar.uninterpretedOption_;
                            this.f13877a &= -17;
                        } else {
                            p();
                            this.f13882f.addAll(sVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!sVar.uninterpretedOption_.isEmpty()) {
                    if (this.f13883g.d()) {
                        this.f13883g.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.f13883g = null;
                        this.f13882f = sVar.uninterpretedOption_;
                        this.f13877a &= -17;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13883g = amVar;
                    } else {
                        this.f13883g.a(sVar.uninterpretedOption_);
                    }
                }
                a((t.d) sVar);
                d(sVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.s.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$s> r1 = com.google.c.i.s.f13875a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$s r3 = (com.google.c.i.s) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.s) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$s r4 = (com.google.c.i.s) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.s) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.s.a.c(com.google.c.g, com.google.c.p):com.google.c.i$s$a");
            }

            public a a(boolean z) {
                this.f13877a |= 1;
                this.f13878b = z;
                A();
                return this;
            }

            public a b(boolean z) {
                this.f13877a |= 2;
                this.f13879c = z;
                A();
                return this;
            }

            public a c(boolean z) {
                this.f13877a |= 4;
                this.f13880d = z;
                A();
                return this;
            }

            public a d(boolean z) {
                this.f13877a |= 8;
                this.f13881e = z;
                A();
                return this;
            }

            private void p() {
                if ((this.f13877a & 16) != 16) {
                    this.f13882f = new ArrayList(this.f13882f);
                    this.f13877a |= 16;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.f13883g;
                if (amVar == null) {
                    return this.f13882f.size();
                }
                return amVar.c();
            }

            public ai a(int i) {
                am<ai, ai.a, aj> amVar = this.f13883g;
                if (amVar == null) {
                    return this.f13882f.get(i);
                }
                return amVar.a(i);
            }

            private am<ai, ai.a, aj> q() {
                if (this.f13883g == null) {
                    this.f13883g = new am<>(this.f13882f, (this.f13877a & 16) == 16, z(), y());
                    this.f13882f = null;
                }
                return this.f13883g;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static s u() {
            return f13876c;
        }

        public aj<s> F() {
            return f13875a;
        }

        /* renamed from: v */
        public s L() {
            return f13876c;
        }
    }

    public static final class m extends t.d<m> implements n {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<m> f13842a = new c<m>() {
            /* renamed from: a */
            public m b(g gVar, p pVar) throws v {
                return new m(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final m f13843c = new m();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int ctype_;
        /* access modifiers changed from: private */
        public boolean deprecated_;
        /* access modifiers changed from: private */
        public int jstype_;
        /* access modifiers changed from: private */
        public boolean lazy_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public boolean packed_;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;
        /* access modifiers changed from: private */
        public boolean weak_;

        private m(t.c<m, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private m() {
            this.memoizedIsInitialized = -1;
            this.ctype_ = 0;
            this.packed_ = false;
            this.jstype_ = 0;
            this.lazy_ = false;
            this.deprecated_ = false;
            this.weak_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private m(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 8) {
                            int o = gVar.o();
                            if (b.valueOf(o) == null) {
                                c2.a(1, o);
                            } else {
                                this.bitField0_ = 1 | this.bitField0_;
                                this.ctype_ = o;
                            }
                        } else if (a2 == 16) {
                            this.bitField0_ |= 2;
                            this.packed_ = gVar.j();
                        } else if (a2 == 24) {
                            this.bitField0_ |= 16;
                            this.deprecated_ = gVar.j();
                        } else if (a2 == 40) {
                            this.bitField0_ |= 8;
                            this.lazy_ = gVar.j();
                        } else if (a2 == 48) {
                            int o2 = gVar.o();
                            if (c.valueOf(o2) == null) {
                                c2.a(6, o2);
                            } else {
                                this.bitField0_ |= 4;
                                this.jstype_ = o2;
                            }
                        } else if (a2 == 80) {
                            this.bitField0_ |= 32;
                            this.weak_ = gVar.j();
                        } else if (a2 == 7994) {
                            if (!(z2 & true)) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        public static final j.a h() {
            return i.A;
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.B.a((Class<? extends t>) m.class, (Class<? extends t.a>) a.class);
        }

        public enum b implements ak {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            
            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;

            /* renamed from: a  reason: collision with root package name */
            private static final u.b<b> f13851a = null;

            /* renamed from: b  reason: collision with root package name */
            private static final b[] f13852b = null;
            private final int value;

            static {
                f13851a = new u.b<b>() {
                };
                f13852b = values();
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static b valueOf(int i) {
                return forNumber(i);
            }

            public static b forNumber(int i) {
                if (i == 0) {
                    return STRING;
                }
                if (i == 1) {
                    return CORD;
                }
                if (i != 2) {
                    return null;
                }
                return STRING_PIECE;
            }

            public static u.b<b> internalGetValueMap() {
                return f13851a;
            }

            public final j.e getValueDescriptor() {
                return getDescriptor().e().get(ordinal());
            }

            public final j.d getDescriptorForType() {
                return getDescriptor();
            }

            public static final j.d getDescriptor() {
                return m.h().i().get(0);
            }

            public static b valueOf(j.e eVar) {
                if (eVar.f() == getDescriptor()) {
                    return f13852b[eVar.a()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private b(int i) {
                this.value = i;
            }
        }

        public enum c implements ak {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            
            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;

            /* renamed from: a  reason: collision with root package name */
            private static final u.b<c> f13853a = null;

            /* renamed from: b  reason: collision with root package name */
            private static final c[] f13854b = null;
            private final int value;

            static {
                f13853a = new u.b<c>() {
                };
                f13854b = values();
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static c valueOf(int i) {
                return forNumber(i);
            }

            public static c forNumber(int i) {
                if (i == 0) {
                    return JS_NORMAL;
                }
                if (i == 1) {
                    return JS_STRING;
                }
                if (i != 2) {
                    return null;
                }
                return JS_NUMBER;
            }

            public static u.b<c> internalGetValueMap() {
                return f13853a;
            }

            public final j.e getValueDescriptor() {
                return getDescriptor().e().get(ordinal());
            }

            public final j.d getDescriptorForType() {
                return getDescriptor();
            }

            public static final j.d getDescriptor() {
                return m.h().i().get(1);
            }

            public static c valueOf(j.e eVar) {
                if (eVar.f() == getDescriptor()) {
                    return f13854b[eVar.a()];
                }
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            private c(int i) {
                this.value = i;
            }
        }

        public boolean i() {
            return (this.bitField0_ & 1) == 1;
        }

        public b j() {
            b valueOf = b.valueOf(this.ctype_);
            return valueOf == null ? b.STRING : valueOf;
        }

        public boolean k() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean l() {
            return this.packed_;
        }

        public boolean m() {
            return (this.bitField0_ & 4) == 4;
        }

        public c n() {
            c valueOf = c.valueOf(this.jstype_);
            return valueOf == null ? c.JS_NORMAL : valueOf;
        }

        public boolean o() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean p() {
            return this.lazy_;
        }

        public boolean q() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean r() {
            return this.deprecated_;
        }

        public boolean s() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean t() {
            return this.weak_;
        }

        public List<ai> u() {
            return this.uninterpretedOption_;
        }

        public int v() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < v(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            if ((this.bitField0_ & 1) == 1) {
                hVar.d(1, this.ctype_);
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.a(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                hVar.a(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                hVar.a(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                hVar.d(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                hVar.a(10, this.weak_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int h = (this.bitField0_ & 1) == 1 ? h.h(1, this.ctype_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                h += h.b(2, this.packed_);
            }
            if ((this.bitField0_ & 16) == 16) {
                h += h.b(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                h += h.b(5, this.lazy_);
            }
            if ((this.bitField0_ & 4) == 4) {
                h += h.h(6, this.jstype_);
            }
            if ((this.bitField0_ & 32) == 32) {
                h += h.b(10, this.weak_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                h += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i2));
            }
            int ab = h + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof m)) {
                return super.equals(obj);
            }
            m mVar = (m) obj;
            boolean z = i() == mVar.i();
            if (i()) {
                z = z && this.ctype_ == mVar.ctype_;
            }
            boolean z2 = z && k() == mVar.k();
            if (k()) {
                z2 = z2 && l() == mVar.l();
            }
            boolean z3 = z2 && m() == mVar.m();
            if (m()) {
                z3 = z3 && this.jstype_ == mVar.jstype_;
            }
            boolean z4 = z3 && o() == mVar.o();
            if (o()) {
                z4 = z4 && p() == mVar.p();
            }
            boolean z5 = z4 && q() == mVar.q();
            if (q()) {
                z5 = z5 && r() == mVar.r();
            }
            boolean z6 = z5 && s() == mVar.s();
            if (s()) {
                z6 = z6 && t() == mVar.t();
            }
            if (!((z6 && u().equals(mVar.u())) && this.unknownFields.equals(mVar.unknownFields)) || !ac().equals(mVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (i()) {
                hashCode = (((hashCode * 37) + 1) * 53) + this.ctype_;
            }
            if (k()) {
                hashCode = (((hashCode * 37) + 2) * 53) + u.a(l());
            }
            if (m()) {
                hashCode = (((hashCode * 37) + 6) * 53) + this.jstype_;
            }
            if (o()) {
                hashCode = (((hashCode * 37) + 5) * 53) + u.a(p());
            }
            if (q()) {
                hashCode = (((hashCode * 37) + 3) * 53) + u.a(r());
            }
            if (s()) {
                hashCode = (((hashCode * 37) + 10) * 53) + u.a(t());
            }
            if (v() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + u().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: w */
        public a J() {
            return x();
        }

        public static a x() {
            return f13843c.I();
        }

        public static a a(m mVar) {
            return f13843c.I().a(mVar);
        }

        /* renamed from: y */
        public a I() {
            if (this == f13843c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.c<m, a> implements n {

            /* renamed from: a  reason: collision with root package name */
            private int f13844a;

            /* renamed from: b  reason: collision with root package name */
            private int f13845b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f13846c;

            /* renamed from: d  reason: collision with root package name */
            private int f13847d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f13848e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f13849f;

            /* renamed from: g  reason: collision with root package name */
            private boolean f13850g;
            private List<ai> h;
            private am<ai, ai.a, aj> i;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.B.a((Class<? extends t>) m.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13845b = 0;
                this.f13847d = 0;
                this.h = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13845b = 0;
                this.f13847d = 0;
                this.h = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.A;
            }

            /* renamed from: h */
            public m L() {
                return m.z();
            }

            /* renamed from: i */
            public m w() {
                m j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public m v() {
                m mVar = new m((t.c) this);
                int i2 = this.f13844a;
                int i3 = 1;
                if ((i2 & 1) != 1) {
                    i3 = 0;
                }
                int unused = mVar.ctype_ = this.f13845b;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                boolean unused2 = mVar.packed_ = this.f13846c;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                int unused3 = mVar.jstype_ = this.f13847d;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                boolean unused4 = mVar.lazy_ = this.f13848e;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                boolean unused5 = mVar.deprecated_ = this.f13849f;
                if ((i2 & 32) == 32) {
                    i3 |= 32;
                }
                boolean unused6 = mVar.weak_ = this.f13850g;
                am<ai, ai.a, aj> amVar = this.i;
                if (amVar == null) {
                    if ((this.f13844a & 64) == 64) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f13844a &= -65;
                    }
                    List unused7 = mVar.uninterpretedOption_ = this.h;
                } else {
                    List unused8 = mVar.uninterpretedOption_ = amVar.e();
                }
                int unused9 = mVar.bitField0_ = i3;
                x();
                return mVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof m) {
                    return a((m) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(m mVar) {
                if (mVar == m.z()) {
                    return this;
                }
                if (mVar.i()) {
                    a(mVar.j());
                }
                if (mVar.k()) {
                    a(mVar.l());
                }
                if (mVar.m()) {
                    a(mVar.n());
                }
                if (mVar.o()) {
                    b(mVar.p());
                }
                if (mVar.q()) {
                    c(mVar.r());
                }
                if (mVar.s()) {
                    d(mVar.t());
                }
                if (this.i == null) {
                    if (!mVar.uninterpretedOption_.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = mVar.uninterpretedOption_;
                            this.f13844a &= -65;
                        } else {
                            p();
                            this.h.addAll(mVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!mVar.uninterpretedOption_.isEmpty()) {
                    if (this.i.d()) {
                        this.i.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.i = null;
                        this.h = mVar.uninterpretedOption_;
                        this.f13844a &= -65;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.i = amVar;
                    } else {
                        this.i.a(mVar.uninterpretedOption_);
                    }
                }
                a((t.d) mVar);
                d(mVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i2 = 0; i2 < l(); i2++) {
                    if (!a(i2).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.m.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$m> r1 = com.google.c.i.m.f13842a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$m r3 = (com.google.c.i.m) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.m) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$m r4 = (com.google.c.i.m) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.m) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.m.a.c(com.google.c.g, com.google.c.p):com.google.c.i$m$a");
            }

            public a a(b bVar) {
                if (bVar != null) {
                    this.f13844a |= 1;
                    this.f13845b = bVar.getNumber();
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            public a a(boolean z) {
                this.f13844a |= 2;
                this.f13846c = z;
                A();
                return this;
            }

            public a a(c cVar) {
                if (cVar != null) {
                    this.f13844a |= 4;
                    this.f13847d = cVar.getNumber();
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            public a b(boolean z) {
                this.f13844a |= 8;
                this.f13848e = z;
                A();
                return this;
            }

            public a c(boolean z) {
                this.f13844a |= 16;
                this.f13849f = z;
                A();
                return this;
            }

            public a d(boolean z) {
                this.f13844a |= 32;
                this.f13850g = z;
                A();
                return this;
            }

            private void p() {
                if ((this.f13844a & 64) != 64) {
                    this.h = new ArrayList(this.h);
                    this.f13844a |= 64;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.i;
                if (amVar == null) {
                    return this.h.size();
                }
                return amVar.c();
            }

            public ai a(int i2) {
                am<ai, ai.a, aj> amVar = this.i;
                if (amVar == null) {
                    return this.h.get(i2);
                }
                return amVar.a(i2);
            }

            private am<ai, ai.a, aj> q() {
                if (this.i == null) {
                    this.i = new am<>(this.h, (this.f13844a & 64) == 64, z(), y());
                    this.h = null;
                }
                return this.i;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static m z() {
            return f13843c;
        }

        public aj<m> F() {
            return f13842a;
        }

        /* renamed from: A */
        public m L() {
            return f13843c;
        }
    }

    public static final class aa extends t.d<aa> implements ab {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<aa> f13755a = new c<aa>() {
            /* renamed from: a */
            public aa b(g gVar, p pVar) throws v {
                return new aa(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final aa f13756c = new aa();
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;

        private aa(t.c<aa, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private aa() {
            this.memoizedIsInitialized = -1;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private aa(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 7994) {
                            if (!z2 || !true) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 && true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.D.a((Class<? extends t>) aa.class, (Class<? extends t.a>) a.class);
        }

        public List<ai> h() {
            return this.uninterpretedOption_;
        }

        public int i() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < i(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.uninterpretedOption_.size(); i3++) {
                i2 += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i3));
            }
            int ab = i2 + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof aa)) {
                return super.equals(obj);
            }
            aa aaVar = (aa) obj;
            if (!((h().equals(aaVar.h())) && this.unknownFields.equals(aaVar.unknownFields)) || !ac().equals(aaVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (i() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + h().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: j */
        public a J() {
            return k();
        }

        public static a k() {
            return f13756c.I();
        }

        public static a a(aa aaVar) {
            return f13756c.I().a(aaVar);
        }

        /* renamed from: l */
        public a I() {
            if (this == f13756c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.c<aa, a> implements ab {

            /* renamed from: a  reason: collision with root package name */
            private int f13757a;

            /* renamed from: b  reason: collision with root package name */
            private List<ai> f13758b;

            /* renamed from: c  reason: collision with root package name */
            private am<ai, ai.a, aj> f13759c;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.D.a((Class<? extends t>) aa.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13758b = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13758b = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.C;
            }

            /* renamed from: h */
            public aa L() {
                return aa.m();
            }

            /* renamed from: i */
            public aa w() {
                aa j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public aa v() {
                aa aaVar = new aa((t.c) this);
                int i = this.f13757a;
                am<ai, ai.a, aj> amVar = this.f13759c;
                if (amVar == null) {
                    if ((i & 1) == 1) {
                        this.f13758b = Collections.unmodifiableList(this.f13758b);
                        this.f13757a &= -2;
                    }
                    List unused = aaVar.uninterpretedOption_ = this.f13758b;
                } else {
                    List unused2 = aaVar.uninterpretedOption_ = amVar.e();
                }
                x();
                return aaVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof aa) {
                    return a((aa) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(aa aaVar) {
                if (aaVar == aa.m()) {
                    return this;
                }
                if (this.f13759c == null) {
                    if (!aaVar.uninterpretedOption_.isEmpty()) {
                        if (this.f13758b.isEmpty()) {
                            this.f13758b = aaVar.uninterpretedOption_;
                            this.f13757a &= -2;
                        } else {
                            p();
                            this.f13758b.addAll(aaVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!aaVar.uninterpretedOption_.isEmpty()) {
                    if (this.f13759c.d()) {
                        this.f13759c.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.f13759c = null;
                        this.f13758b = aaVar.uninterpretedOption_;
                        this.f13757a &= -2;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13759c = amVar;
                    } else {
                        this.f13759c.a(aaVar.uninterpretedOption_);
                    }
                }
                a((t.d) aaVar);
                d(aaVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.aa.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$aa> r1 = com.google.c.i.aa.f13755a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$aa r3 = (com.google.c.i.aa) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.aa) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$aa r4 = (com.google.c.i.aa) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.aa) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.aa.a.c(com.google.c.g, com.google.c.p):com.google.c.i$aa$a");
            }

            private void p() {
                if ((this.f13757a & 1) != 1) {
                    this.f13758b = new ArrayList(this.f13758b);
                    this.f13757a |= 1;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.f13759c;
                if (amVar == null) {
                    return this.f13758b.size();
                }
                return amVar.c();
            }

            public ai a(int i) {
                am<ai, ai.a, aj> amVar = this.f13759c;
                if (amVar == null) {
                    return this.f13758b.get(i);
                }
                return amVar.a(i);
            }

            private am<ai, ai.a, aj> q() {
                if (this.f13759c == null) {
                    List<ai> list = this.f13758b;
                    boolean z = true;
                    if ((this.f13757a & 1) != 1) {
                        z = false;
                    }
                    this.f13759c = new am<>(list, z, z(), y());
                    this.f13758b = null;
                }
                return this.f13759c;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static aa m() {
            return f13756c;
        }

        public aj<aa> F() {
            return f13755a;
        }

        /* renamed from: n */
        public aa L() {
            return f13756c;
        }
    }

    public static final class e extends t.d<e> implements f {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<e> f13809a = new c<e>() {
            /* renamed from: a */
            public e b(g gVar, p pVar) throws v {
                return new e(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final e f13810c = new e();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public boolean allowAlias_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean deprecated_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;

        private e(t.c<e, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private e() {
            this.memoizedIsInitialized = -1;
            this.allowAlias_ = false;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private e(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 16) {
                            this.bitField0_ |= 1;
                            this.allowAlias_ = gVar.j();
                        } else if (a2 == 24) {
                            this.bitField0_ |= 2;
                            this.deprecated_ = gVar.j();
                        } else if (a2 == 7994) {
                            if (!(z2 & true)) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.F.a((Class<? extends t>) e.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean i() {
            return this.allowAlias_;
        }

        public boolean j() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean k() {
            return this.deprecated_;
        }

        public List<ai> l() {
            return this.uninterpretedOption_;
        }

        public int m() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < m(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            if ((this.bitField0_ & 1) == 1) {
                hVar.a(2, this.allowAlias_);
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.a(3, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int b2 = (this.bitField0_ & 1) == 1 ? h.b(2, this.allowAlias_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                b2 += h.b(3, this.deprecated_);
            }
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                b2 += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i2));
            }
            int ab = b2 + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return super.equals(obj);
            }
            e eVar = (e) obj;
            boolean z = h() == eVar.h();
            if (h()) {
                z = z && i() == eVar.i();
            }
            boolean z2 = z && j() == eVar.j();
            if (j()) {
                z2 = z2 && k() == eVar.k();
            }
            if (!((z2 && l().equals(eVar.l())) && this.unknownFields.equals(eVar.unknownFields)) || !ac().equals(eVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 2) * 53) + u.a(i());
            }
            if (j()) {
                hashCode = (((hashCode * 37) + 3) * 53) + u.a(k());
            }
            if (m() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + l().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: n */
        public a J() {
            return o();
        }

        public static a o() {
            return f13810c.I();
        }

        public static a a(e eVar) {
            return f13810c.I().a(eVar);
        }

        /* renamed from: p */
        public a I() {
            if (this == f13810c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.c<e, a> implements f {

            /* renamed from: a  reason: collision with root package name */
            private int f13811a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f13812b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f13813c;

            /* renamed from: d  reason: collision with root package name */
            private List<ai> f13814d;

            /* renamed from: e  reason: collision with root package name */
            private am<ai, ai.a, aj> f13815e;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.F.a((Class<? extends t>) e.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13814d = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13814d = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.E;
            }

            /* renamed from: h */
            public e L() {
                return e.q();
            }

            /* renamed from: i */
            public e w() {
                e j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public e v() {
                e eVar = new e((t.c) this);
                int i = this.f13811a;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                boolean unused = eVar.allowAlias_ = this.f13812b;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                boolean unused2 = eVar.deprecated_ = this.f13813c;
                am<ai, ai.a, aj> amVar = this.f13815e;
                if (amVar == null) {
                    if ((this.f13811a & 4) == 4) {
                        this.f13814d = Collections.unmodifiableList(this.f13814d);
                        this.f13811a &= -5;
                    }
                    List unused3 = eVar.uninterpretedOption_ = this.f13814d;
                } else {
                    List unused4 = eVar.uninterpretedOption_ = amVar.e();
                }
                int unused5 = eVar.bitField0_ = i2;
                x();
                return eVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof e) {
                    return a((e) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(e eVar) {
                if (eVar == e.q()) {
                    return this;
                }
                if (eVar.h()) {
                    a(eVar.i());
                }
                if (eVar.j()) {
                    b(eVar.k());
                }
                if (this.f13815e == null) {
                    if (!eVar.uninterpretedOption_.isEmpty()) {
                        if (this.f13814d.isEmpty()) {
                            this.f13814d = eVar.uninterpretedOption_;
                            this.f13811a &= -5;
                        } else {
                            p();
                            this.f13814d.addAll(eVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!eVar.uninterpretedOption_.isEmpty()) {
                    if (this.f13815e.d()) {
                        this.f13815e.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.f13815e = null;
                        this.f13814d = eVar.uninterpretedOption_;
                        this.f13811a &= -5;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13815e = amVar;
                    } else {
                        this.f13815e.a(eVar.uninterpretedOption_);
                    }
                }
                a((t.d) eVar);
                d(eVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.e.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$e> r1 = com.google.c.i.e.f13809a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$e r3 = (com.google.c.i.e) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.e) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$e r4 = (com.google.c.i.e) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.e) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.e.a.c(com.google.c.g, com.google.c.p):com.google.c.i$e$a");
            }

            public a a(boolean z) {
                this.f13811a |= 1;
                this.f13812b = z;
                A();
                return this;
            }

            public a b(boolean z) {
                this.f13811a |= 2;
                this.f13813c = z;
                A();
                return this;
            }

            private void p() {
                if ((this.f13811a & 4) != 4) {
                    this.f13814d = new ArrayList(this.f13814d);
                    this.f13811a |= 4;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.f13815e;
                if (amVar == null) {
                    return this.f13814d.size();
                }
                return amVar.c();
            }

            public ai a(int i) {
                am<ai, ai.a, aj> amVar = this.f13815e;
                if (amVar == null) {
                    return this.f13814d.get(i);
                }
                return amVar.a(i);
            }

            private am<ai, ai.a, aj> q() {
                if (this.f13815e == null) {
                    this.f13815e = new am<>(this.f13814d, (this.f13811a & 4) == 4, z(), y());
                    this.f13814d = null;
                }
                return this.f13815e;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static e q() {
            return f13810c;
        }

        public aj<e> F() {
            return f13809a;
        }

        /* renamed from: r */
        public e L() {
            return f13810c;
        }
    }

    /* renamed from: com.google.c.i$i  reason: collision with other inner class name */
    public static final class C0230i extends t.d<C0230i> implements j {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<C0230i> f13823a = new c<C0230i>() {
            /* renamed from: a */
            public C0230i b(g gVar, p pVar) throws v {
                return new C0230i(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final C0230i f13824c = new C0230i();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean deprecated_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;

        private C0230i(t.c<C0230i, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private C0230i() {
            this.memoizedIsInitialized = -1;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private C0230i(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 8) {
                            this.bitField0_ |= 1;
                            this.deprecated_ = gVar.j();
                        } else if (a2 == 7994) {
                            if (!(z2 & true)) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.H.a((Class<? extends t>) C0230i.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean i() {
            return this.deprecated_;
        }

        public List<ai> j() {
            return this.uninterpretedOption_;
        }

        public int k() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < k(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            if ((this.bitField0_ & 1) == 1) {
                hVar.a(1, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int b2 = (this.bitField0_ & 1) == 1 ? h.b(1, this.deprecated_) + 0 : 0;
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                b2 += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i2));
            }
            int ab = b2 + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0230i)) {
                return super.equals(obj);
            }
            C0230i iVar = (C0230i) obj;
            boolean z = h() == iVar.h();
            if (h()) {
                z = z && i() == iVar.i();
            }
            if (!((z && j().equals(iVar.j())) && this.unknownFields.equals(iVar.unknownFields)) || !ac().equals(iVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 1) * 53) + u.a(i());
            }
            if (k() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + j().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: l */
        public a J() {
            return m();
        }

        public static a m() {
            return f13824c.I();
        }

        public static a a(C0230i iVar) {
            return f13824c.I().a(iVar);
        }

        /* renamed from: n */
        public a I() {
            if (this == f13824c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        /* renamed from: com.google.c.i$i$a */
        public static final class a extends t.c<C0230i, a> implements j {

            /* renamed from: a  reason: collision with root package name */
            private int f13825a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f13826b;

            /* renamed from: c  reason: collision with root package name */
            private List<ai> f13827c;

            /* renamed from: d  reason: collision with root package name */
            private am<ai, ai.a, aj> f13828d;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.H.a((Class<? extends t>) C0230i.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13827c = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13827c = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.G;
            }

            /* renamed from: h */
            public C0230i L() {
                return C0230i.o();
            }

            /* renamed from: i */
            public C0230i w() {
                C0230i j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public C0230i v() {
                C0230i iVar = new C0230i((t.c) this);
                int i = 1;
                if ((this.f13825a & 1) != 1) {
                    i = 0;
                }
                boolean unused = iVar.deprecated_ = this.f13826b;
                am<ai, ai.a, aj> amVar = this.f13828d;
                if (amVar == null) {
                    if ((this.f13825a & 2) == 2) {
                        this.f13827c = Collections.unmodifiableList(this.f13827c);
                        this.f13825a &= -3;
                    }
                    List unused2 = iVar.uninterpretedOption_ = this.f13827c;
                } else {
                    List unused3 = iVar.uninterpretedOption_ = amVar.e();
                }
                int unused4 = iVar.bitField0_ = i;
                x();
                return iVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof C0230i) {
                    return a((C0230i) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(C0230i iVar) {
                if (iVar == C0230i.o()) {
                    return this;
                }
                if (iVar.h()) {
                    a(iVar.i());
                }
                if (this.f13828d == null) {
                    if (!iVar.uninterpretedOption_.isEmpty()) {
                        if (this.f13827c.isEmpty()) {
                            this.f13827c = iVar.uninterpretedOption_;
                            this.f13825a &= -3;
                        } else {
                            p();
                            this.f13827c.addAll(iVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!iVar.uninterpretedOption_.isEmpty()) {
                    if (this.f13828d.d()) {
                        this.f13828d.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.f13828d = null;
                        this.f13827c = iVar.uninterpretedOption_;
                        this.f13825a &= -3;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13828d = amVar;
                    } else {
                        this.f13828d.a(iVar.uninterpretedOption_);
                    }
                }
                a((t.d) iVar);
                d(iVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.C0230i.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$i> r1 = com.google.c.i.C0230i.f13823a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$i r3 = (com.google.c.i.C0230i) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.C0230i) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$i r4 = (com.google.c.i.C0230i) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.C0230i) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.C0230i.a.c(com.google.c.g, com.google.c.p):com.google.c.i$i$a");
            }

            public a a(boolean z) {
                this.f13825a |= 1;
                this.f13826b = z;
                A();
                return this;
            }

            private void p() {
                if ((this.f13825a & 2) != 2) {
                    this.f13827c = new ArrayList(this.f13827c);
                    this.f13825a |= 2;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.f13828d;
                if (amVar == null) {
                    return this.f13827c.size();
                }
                return amVar.c();
            }

            public ai a(int i) {
                am<ai, ai.a, aj> amVar = this.f13828d;
                if (amVar == null) {
                    return this.f13827c.get(i);
                }
                return amVar.a(i);
            }

            private am<ai, ai.a, aj> q() {
                if (this.f13828d == null) {
                    this.f13828d = new am<>(this.f13827c, (this.f13825a & 2) == 2, z(), y());
                    this.f13827c = null;
                }
                return this.f13828d;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static C0230i o() {
            return f13824c;
        }

        public aj<C0230i> F() {
            return f13823a;
        }

        /* renamed from: p */
        public C0230i L() {
            return f13824c;
        }
    }

    public static final class ae extends t.d<ae> implements af {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<ae> f13768a = new c<ae>() {
            /* renamed from: a */
            public ae b(g gVar, p pVar) throws v {
                return new ae(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final ae f13769c = new ae();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean deprecated_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;

        private ae(t.c<ae, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private ae() {
            this.memoizedIsInitialized = -1;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private ae(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 264) {
                            this.bitField0_ |= 1;
                            this.deprecated_ = gVar.j();
                        } else if (a2 == 7994) {
                            if (!(z2 & true)) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.J.a((Class<? extends t>) ae.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean i() {
            return this.deprecated_;
        }

        public List<ai> j() {
            return this.uninterpretedOption_;
        }

        public int k() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < k(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            if ((this.bitField0_ & 1) == 1) {
                hVar.a(33, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int b2 = (this.bitField0_ & 1) == 1 ? h.b(33, this.deprecated_) + 0 : 0;
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                b2 += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i2));
            }
            int ab = b2 + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ae)) {
                return super.equals(obj);
            }
            ae aeVar = (ae) obj;
            boolean z = h() == aeVar.h();
            if (h()) {
                z = z && i() == aeVar.i();
            }
            if (!((z && j().equals(aeVar.j())) && this.unknownFields.equals(aeVar.unknownFields)) || !ac().equals(aeVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 33) * 53) + u.a(i());
            }
            if (k() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + j().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: l */
        public a J() {
            return m();
        }

        public static a m() {
            return f13769c.I();
        }

        public static a a(ae aeVar) {
            return f13769c.I().a(aeVar);
        }

        /* renamed from: n */
        public a I() {
            if (this == f13769c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.c<ae, a> implements af {

            /* renamed from: a  reason: collision with root package name */
            private int f13770a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f13771b;

            /* renamed from: c  reason: collision with root package name */
            private List<ai> f13772c;

            /* renamed from: d  reason: collision with root package name */
            private am<ai, ai.a, aj> f13773d;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.J.a((Class<? extends t>) ae.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13772c = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13772c = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.I;
            }

            /* renamed from: h */
            public ae L() {
                return ae.o();
            }

            /* renamed from: i */
            public ae w() {
                ae j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public ae v() {
                ae aeVar = new ae((t.c) this);
                int i = 1;
                if ((this.f13770a & 1) != 1) {
                    i = 0;
                }
                boolean unused = aeVar.deprecated_ = this.f13771b;
                am<ai, ai.a, aj> amVar = this.f13773d;
                if (amVar == null) {
                    if ((this.f13770a & 2) == 2) {
                        this.f13772c = Collections.unmodifiableList(this.f13772c);
                        this.f13770a &= -3;
                    }
                    List unused2 = aeVar.uninterpretedOption_ = this.f13772c;
                } else {
                    List unused3 = aeVar.uninterpretedOption_ = amVar.e();
                }
                int unused4 = aeVar.bitField0_ = i;
                x();
                return aeVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof ae) {
                    return a((ae) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(ae aeVar) {
                if (aeVar == ae.o()) {
                    return this;
                }
                if (aeVar.h()) {
                    a(aeVar.i());
                }
                if (this.f13773d == null) {
                    if (!aeVar.uninterpretedOption_.isEmpty()) {
                        if (this.f13772c.isEmpty()) {
                            this.f13772c = aeVar.uninterpretedOption_;
                            this.f13770a &= -3;
                        } else {
                            p();
                            this.f13772c.addAll(aeVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!aeVar.uninterpretedOption_.isEmpty()) {
                    if (this.f13773d.d()) {
                        this.f13773d.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.f13773d = null;
                        this.f13772c = aeVar.uninterpretedOption_;
                        this.f13770a &= -3;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13773d = amVar;
                    } else {
                        this.f13773d.a(aeVar.uninterpretedOption_);
                    }
                }
                a((t.d) aeVar);
                d(aeVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.ae.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$ae> r1 = com.google.c.i.ae.f13768a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$ae r3 = (com.google.c.i.ae) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.ae) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$ae r4 = (com.google.c.i.ae) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.ae) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.ae.a.c(com.google.c.g, com.google.c.p):com.google.c.i$ae$a");
            }

            public a a(boolean z) {
                this.f13770a |= 1;
                this.f13771b = z;
                A();
                return this;
            }

            private void p() {
                if ((this.f13770a & 2) != 2) {
                    this.f13772c = new ArrayList(this.f13772c);
                    this.f13770a |= 2;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.f13773d;
                if (amVar == null) {
                    return this.f13772c.size();
                }
                return amVar.c();
            }

            public ai a(int i) {
                am<ai, ai.a, aj> amVar = this.f13773d;
                if (amVar == null) {
                    return this.f13772c.get(i);
                }
                return amVar.a(i);
            }

            private am<ai, ai.a, aj> q() {
                if (this.f13773d == null) {
                    this.f13773d = new am<>(this.f13772c, (this.f13770a & 2) == 2, z(), y());
                    this.f13772c = null;
                }
                return this.f13773d;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static ae o() {
            return f13769c;
        }

        public aj<ae> F() {
            return f13768a;
        }

        /* renamed from: p */
        public ae L() {
            return f13769c;
        }
    }

    public static final class w extends t.d<w> implements x {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<w> f13893a = new c<w>() {
            /* renamed from: a */
            public w b(g gVar, p pVar) throws v {
                return new w(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final w f13894c = new w();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean deprecated_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<ai> uninterpretedOption_;

        private w(t.c<w, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = -1;
        }

        private w() {
            this.memoizedIsInitialized = -1;
            this.deprecated_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private w(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 264) {
                            this.bitField0_ |= 1;
                            this.deprecated_ = gVar.j();
                        } else if (a2 == 7994) {
                            if (!(z2 & true)) {
                                this.uninterpretedOption_ = new ArrayList();
                                z2 |= true;
                            }
                            this.uninterpretedOption_.add(gVar.a(ai.f13787a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 & true) {
                this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.L.a((Class<? extends t>) w.class, (Class<? extends t.a>) a.class);
        }

        public boolean h() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean i() {
            return this.deprecated_;
        }

        public List<ai> j() {
            return this.uninterpretedOption_;
        }

        public int k() {
            return this.uninterpretedOption_.size();
        }

        public ai a(int i) {
            return this.uninterpretedOption_.get(i);
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < k(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!Z()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            t.d<MessageType>.a aa = aa();
            if ((this.bitField0_ & 1) == 1) {
                hVar.a(33, this.deprecated_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                hVar.a((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i));
            }
            aa.a(536870912, hVar);
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int b2 = (this.bitField0_ & 1) == 1 ? h.b(33, this.deprecated_) + 0 : 0;
            for (int i2 = 0; i2 < this.uninterpretedOption_.size(); i2++) {
                b2 += h.c((int) SQLStatement.IN_TOP_LIMIT, (ad) this.uninterpretedOption_.get(i2));
            }
            int ab = b2 + ab() + this.unknownFields.b();
            this.memoizedSize = ab;
            return ab;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof w)) {
                return super.equals(obj);
            }
            w wVar = (w) obj;
            boolean z = h() == wVar.h();
            if (h()) {
                z = z && i() == wVar.i();
            }
            if (!((z && j().equals(wVar.j())) && this.unknownFields.equals(wVar.unknownFields)) || !ac().equals(wVar.ac())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (h()) {
                hashCode = (((hashCode * 37) + 33) * 53) + u.a(i());
            }
            if (k() > 0) {
                hashCode = (((hashCode * 37) + SQLStatement.IN_TOP_LIMIT) * 53) + j().hashCode();
            }
            int a2 = (a(hashCode, ac()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = a2;
            return a2;
        }

        /* renamed from: l */
        public a J() {
            return m();
        }

        public static a m() {
            return f13894c.I();
        }

        public static a a(w wVar) {
            return f13894c.I().a(wVar);
        }

        /* renamed from: n */
        public a I() {
            if (this == f13894c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.c<w, a> implements x {

            /* renamed from: a  reason: collision with root package name */
            private int f13895a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f13896b;

            /* renamed from: c  reason: collision with root package name */
            private List<ai> f13897c;

            /* renamed from: d  reason: collision with root package name */
            private am<ai, ai.a, aj> f13898d;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.L.a((Class<? extends t>) w.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13897c = Collections.emptyList();
                o();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13897c = Collections.emptyList();
                o();
            }

            private void o() {
                if (t.f14020b) {
                    q();
                }
            }

            public j.a g() {
                return i.K;
            }

            /* renamed from: h */
            public w L() {
                return w.o();
            }

            /* renamed from: i */
            public w w() {
                w j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public w v() {
                w wVar = new w((t.c) this);
                int i = 1;
                if ((this.f13895a & 1) != 1) {
                    i = 0;
                }
                boolean unused = wVar.deprecated_ = this.f13896b;
                am<ai, ai.a, aj> amVar = this.f13898d;
                if (amVar == null) {
                    if ((this.f13895a & 2) == 2) {
                        this.f13897c = Collections.unmodifiableList(this.f13897c);
                        this.f13895a &= -3;
                    }
                    List unused2 = wVar.uninterpretedOption_ = this.f13897c;
                } else {
                    List unused3 = wVar.uninterpretedOption_ = amVar.e();
                }
                int unused4 = wVar.bitField0_ = i;
                x();
                return wVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.s();
            }

            /* renamed from: a */
            public a h(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a g(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof w) {
                    return a((w) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(w wVar) {
                if (wVar == w.o()) {
                    return this;
                }
                if (wVar.h()) {
                    a(wVar.i());
                }
                if (this.f13898d == null) {
                    if (!wVar.uninterpretedOption_.isEmpty()) {
                        if (this.f13897c.isEmpty()) {
                            this.f13897c = wVar.uninterpretedOption_;
                            this.f13895a &= -3;
                        } else {
                            p();
                            this.f13897c.addAll(wVar.uninterpretedOption_);
                        }
                        A();
                    }
                } else if (!wVar.uninterpretedOption_.isEmpty()) {
                    if (this.f13898d.d()) {
                        this.f13898d.b();
                        am<ai, ai.a, aj> amVar = null;
                        this.f13898d = null;
                        this.f13897c = wVar.uninterpretedOption_;
                        this.f13895a &= -3;
                        if (t.f14020b) {
                            amVar = q();
                        }
                        this.f13898d = amVar;
                    } else {
                        this.f13898d.a(wVar.uninterpretedOption_);
                    }
                }
                a((t.d) wVar);
                d(wVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i = 0; i < l(); i++) {
                    if (!a(i).a()) {
                        return false;
                    }
                }
                if (!n()) {
                    return false;
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.w.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$w> r1 = com.google.c.i.w.f13893a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$w r3 = (com.google.c.i.w) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.w) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$w r4 = (com.google.c.i.w) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.w) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.w.a.c(com.google.c.g, com.google.c.p):com.google.c.i$w$a");
            }

            public a a(boolean z) {
                this.f13895a |= 1;
                this.f13896b = z;
                A();
                return this;
            }

            private void p() {
                if ((this.f13895a & 2) != 2) {
                    this.f13897c = new ArrayList(this.f13897c);
                    this.f13895a |= 2;
                }
            }

            public int l() {
                am<ai, ai.a, aj> amVar = this.f13898d;
                if (amVar == null) {
                    return this.f13897c.size();
                }
                return amVar.c();
            }

            public ai a(int i) {
                am<ai, ai.a, aj> amVar = this.f13898d;
                if (amVar == null) {
                    return this.f13897c.get(i);
                }
                return amVar.a(i);
            }

            private am<ai, ai.a, aj> q() {
                if (this.f13898d == null) {
                    this.f13898d = new am<>(this.f13897c, (this.f13895a & 2) == 2, z(), y());
                    this.f13897c = null;
                }
                return this.f13898d;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static w o() {
            return f13894c;
        }

        public aj<w> F() {
            return f13893a;
        }

        /* renamed from: p */
        public w L() {
            return f13894c;
        }
    }

    public static final class ai extends t implements aj {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<ai> f13787a = new c<ai>() {
            /* renamed from: a */
            public ai b(g gVar, p pVar) throws v {
                return new ai(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final ai f13788c = new ai();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public volatile Object aggregateValue_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public double doubleValue_;
        /* access modifiers changed from: private */
        public volatile Object identifierValue_;
        private byte memoizedIsInitialized;
        /* access modifiers changed from: private */
        public List<b> name_;
        /* access modifiers changed from: private */
        public long negativeIntValue_;
        /* access modifiers changed from: private */
        public long positiveIntValue_;
        /* access modifiers changed from: private */
        public f stringValue_;

        public interface c extends ag {
        }

        private ai(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private ai() {
            this.memoizedIsInitialized = -1;
            this.name_ = Collections.emptyList();
            this.identifierValue_ = "";
            this.positiveIntValue_ = 0;
            this.negativeIntValue_ = 0;
            this.doubleValue_ = 0.0d;
            this.stringValue_ = f.f13707a;
            this.aggregateValue_ = "";
        }

        public final at f() {
            return this.unknownFields;
        }

        private ai(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 18) {
                            if (!z2 || !true) {
                                this.name_ = new ArrayList();
                                z2 |= true;
                            }
                            this.name_.add(gVar.a(b.f13796a, pVar));
                        } else if (a2 == 26) {
                            f m = gVar.m();
                            this.bitField0_ |= 1;
                            this.identifierValue_ = m;
                        } else if (a2 == 32) {
                            this.bitField0_ |= 2;
                            this.positiveIntValue_ = gVar.e();
                        } else if (a2 == 40) {
                            this.bitField0_ |= 4;
                            this.negativeIntValue_ = gVar.f();
                        } else if (a2 == 49) {
                            this.bitField0_ |= 8;
                            this.doubleValue_ = gVar.c();
                        } else if (a2 == 58) {
                            this.bitField0_ |= 16;
                            this.stringValue_ = gVar.m();
                        } else if (a2 == 66) {
                            f m2 = gVar.m();
                            this.bitField0_ = 32 | this.bitField0_;
                            this.aggregateValue_ = m2;
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.name_ = Collections.unmodifiableList(this.name_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 && true) {
                this.name_ = Collections.unmodifiableList(this.name_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.N.a((Class<? extends t>) ai.class, (Class<? extends t.a>) a.class);
        }

        public static final class b extends t implements c {
            @Deprecated

            /* renamed from: a  reason: collision with root package name */
            public static final aj<b> f13796a = new c<b>() {
                /* renamed from: a */
                public b b(g gVar, p pVar) throws v {
                    return new b(gVar, pVar);
                }
            };

            /* renamed from: c  reason: collision with root package name */
            private static final b f13797c = new b();
            private static final long serialVersionUID = 0;
            /* access modifiers changed from: private */
            public int bitField0_;
            /* access modifiers changed from: private */
            public boolean isExtension_;
            private byte memoizedIsInitialized;
            /* access modifiers changed from: private */
            public volatile Object namePart_;

            private b(t.a<?> aVar) {
                super(aVar);
                this.memoizedIsInitialized = -1;
            }

            private b() {
                this.memoizedIsInitialized = -1;
                this.namePart_ = "";
                this.isExtension_ = false;
            }

            public final at f() {
                return this.unknownFields;
            }

            private b(g gVar, p pVar) throws v {
                this();
                at.a c2 = at.c();
                boolean z = false;
                while (!z) {
                    try {
                        int a2 = gVar.a();
                        if (a2 != 0) {
                            if (a2 == 10) {
                                f m = gVar.m();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.namePart_ = m;
                            } else if (a2 == 16) {
                                this.bitField0_ |= 2;
                                this.isExtension_ = gVar.j();
                            } else if (!a(gVar, c2, pVar, a2)) {
                            }
                        }
                        z = true;
                    } catch (v e2) {
                        throw e2.a(this);
                    } catch (IOException e3) {
                        throw new v(e3).a(this);
                    } catch (Throwable th) {
                        this.unknownFields = c2.w();
                        Y();
                        throw th;
                    }
                }
                this.unknownFields = c2.w();
                Y();
            }

            /* access modifiers changed from: protected */
            public t.f m_() {
                return i.P.a((Class<? extends t>) b.class, (Class<? extends t.a>) a.class);
            }

            public boolean h() {
                return (this.bitField0_ & 1) == 1;
            }

            public String i() {
                Object obj = this.namePart_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                f fVar = (f) obj;
                String d2 = fVar.d();
                if (fVar.e()) {
                    this.namePart_ = d2;
                }
                return d2;
            }

            public boolean j() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean k() {
                return this.isExtension_;
            }

            public final boolean a() {
                byte b2 = this.memoizedIsInitialized;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!h()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else if (!j()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = 1;
                    return true;
                }
            }

            public void a(h hVar) throws IOException {
                if ((this.bitField0_ & 1) == 1) {
                    t.a(hVar, 1, this.namePart_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    hVar.a(2, this.isExtension_);
                }
                this.unknownFields.a(hVar);
            }

            public int b() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                if ((this.bitField0_ & 1) == 1) {
                    i2 = 0 + t.a(1, this.namePart_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i2 += h.b(2, this.isExtension_);
                }
                int b2 = i2 + this.unknownFields.b();
                this.memoizedSize = b2;
                return b2;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return super.equals(obj);
                }
                b bVar = (b) obj;
                boolean z = h() == bVar.h();
                if (h()) {
                    z = z && i().equals(bVar.i());
                }
                boolean z2 = z && j() == bVar.j();
                if (j()) {
                    z2 = z2 && k() == bVar.k();
                }
                if (!z2 || !this.unknownFields.equals(bVar.unknownFields)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = 779 + g().hashCode();
                if (h()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
                }
                if (j()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + u.a(k());
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            /* renamed from: l */
            public a J() {
                return m();
            }

            public static a m() {
                return f13797c.I();
            }

            /* renamed from: n */
            public a I() {
                if (this == f13797c) {
                    return new a();
                }
                return new a().a(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public a b(t.b bVar) {
                return new a(bVar);
            }

            public static final class a extends t.a<a> implements c {

                /* renamed from: a  reason: collision with root package name */
                private int f13798a;

                /* renamed from: b  reason: collision with root package name */
                private Object f13799b;

                /* renamed from: c  reason: collision with root package name */
                private boolean f13800c;

                /* access modifiers changed from: protected */
                public t.f e() {
                    return i.P.a((Class<? extends t>) b.class, (Class<? extends t.a>) a.class);
                }

                private a() {
                    this.f13799b = "";
                    n();
                }

                private a(t.b bVar) {
                    super(bVar);
                    this.f13799b = "";
                    n();
                }

                private void n() {
                    boolean z = t.f14020b;
                }

                public j.a g() {
                    return i.O;
                }

                /* renamed from: h */
                public b L() {
                    return b.o();
                }

                /* renamed from: i */
                public b w() {
                    b j = v();
                    if (j.a()) {
                        return j;
                    }
                    throw b((ac) j);
                }

                /* renamed from: j */
                public b v() {
                    b bVar = new b((t.a) this);
                    int i = this.f13798a;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    Object unused = bVar.namePart_ = this.f13799b;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    boolean unused2 = bVar.isExtension_ = this.f13800c;
                    int unused3 = bVar.bitField0_ = i2;
                    x();
                    return bVar;
                }

                /* renamed from: k */
                public a s() {
                    return (a) super.d();
                }

                /* renamed from: a */
                public a f(j.f fVar, Object obj) {
                    return (a) super.f(fVar, obj);
                }

                /* renamed from: b */
                public a e(j.f fVar, Object obj) {
                    return (a) super.e(fVar, obj);
                }

                /* renamed from: d */
                public a c(ac acVar) {
                    if (acVar instanceof b) {
                        return a((b) acVar);
                    }
                    super.c(acVar);
                    return this;
                }

                public a a(b bVar) {
                    if (bVar == b.o()) {
                        return this;
                    }
                    if (bVar.h()) {
                        this.f13798a |= 1;
                        this.f13799b = bVar.namePart_;
                        A();
                    }
                    if (bVar.j()) {
                        a(bVar.k());
                    }
                    d(bVar.unknownFields);
                    A();
                    return this;
                }

                public final boolean a() {
                    if (l() && m()) {
                        return true;
                    }
                    return false;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
                /* renamed from: d */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.c.i.ai.b.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.c.aj<com.google.c.i$ai$b> r1 = com.google.c.i.ai.b.f13796a     // Catch:{ v -> 0x0011 }
                        java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                        com.google.c.i$ai$b r3 = (com.google.c.i.ai.b) r3     // Catch:{ v -> 0x0011 }
                        if (r3 == 0) goto L_0x000e
                        r2.a((com.google.c.i.ai.b) r3)
                    L_0x000e:
                        return r2
                    L_0x000f:
                        r3 = move-exception
                        goto L_0x001f
                    L_0x0011:
                        r3 = move-exception
                        com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                        com.google.c.i$ai$b r4 = (com.google.c.i.ai.b) r4     // Catch:{ all -> 0x000f }
                        java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                        throw r3     // Catch:{ all -> 0x001d }
                    L_0x001d:
                        r3 = move-exception
                        r0 = r4
                    L_0x001f:
                        if (r0 == 0) goto L_0x0024
                        r2.a((com.google.c.i.ai.b) r0)
                    L_0x0024:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.ai.b.a.c(com.google.c.g, com.google.c.p):com.google.c.i$ai$b$a");
                }

                public boolean l() {
                    return (this.f13798a & 1) == 1;
                }

                public boolean m() {
                    return (this.f13798a & 2) == 2;
                }

                public a a(boolean z) {
                    this.f13798a |= 2;
                    this.f13800c = z;
                    A();
                    return this;
                }

                /* renamed from: b */
                public final a f(at atVar) {
                    return (a) super.f(atVar);
                }

                /* renamed from: c */
                public final a d(at atVar) {
                    return (a) super.a(atVar);
                }
            }

            public static b o() {
                return f13797c;
            }

            public aj<b> F() {
                return f13796a;
            }

            /* renamed from: p */
            public b L() {
                return f13797c;
            }
        }

        public List<b> h() {
            return this.name_;
        }

        public int i() {
            return this.name_.size();
        }

        public b a(int i) {
            return this.name_.get(i);
        }

        public boolean j() {
            return (this.bitField0_ & 1) == 1;
        }

        public String k() {
            Object obj = this.identifierValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.identifierValue_ = d2;
            }
            return d2;
        }

        public boolean l() {
            return (this.bitField0_ & 2) == 2;
        }

        public long m() {
            return this.positiveIntValue_;
        }

        public boolean n() {
            return (this.bitField0_ & 4) == 4;
        }

        public long o() {
            return this.negativeIntValue_;
        }

        public boolean p() {
            return (this.bitField0_ & 8) == 8;
        }

        public double q() {
            return this.doubleValue_;
        }

        public boolean r() {
            return (this.bitField0_ & 16) == 16;
        }

        public f s() {
            return this.stringValue_;
        }

        public boolean t() {
            return (this.bitField0_ & 32) == 32;
        }

        public String u() {
            Object obj = this.aggregateValue_;
            if (obj instanceof String) {
                return (String) obj;
            }
            f fVar = (f) obj;
            String d2 = fVar.d();
            if (fVar.e()) {
                this.aggregateValue_ = d2;
            }
            return d2;
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < i(); i++) {
                if (!a(i).a()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            for (int i = 0; i < this.name_.size(); i++) {
                hVar.a(2, (ad) this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                t.a(hVar, 3, this.identifierValue_);
            }
            if ((this.bitField0_ & 2) == 2) {
                hVar.b(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                hVar.a(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                hVar.a(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                hVar.a(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                t.a(hVar, 8, this.aggregateValue_);
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.name_.size(); i3++) {
                i2 += h.c(2, (ad) this.name_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += t.a(3, this.identifierValue_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += h.e(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += h.d(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += h.b(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += h.c(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += t.a(8, this.aggregateValue_);
            }
            int b2 = i2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ai)) {
                return super.equals(obj);
            }
            ai aiVar = (ai) obj;
            boolean z = (h().equals(aiVar.h())) && j() == aiVar.j();
            if (j()) {
                z = z && k().equals(aiVar.k());
            }
            boolean z2 = z && l() == aiVar.l();
            if (l()) {
                z2 = z2 && m() == aiVar.m();
            }
            boolean z3 = z2 && n() == aiVar.n();
            if (n()) {
                z3 = z3 && o() == aiVar.o();
            }
            boolean z4 = z3 && p() == aiVar.p();
            if (p()) {
                z4 = z4 && Double.doubleToLongBits(q()) == Double.doubleToLongBits(aiVar.q());
            }
            boolean z5 = z4 && r() == aiVar.r();
            if (r()) {
                z5 = z5 && s().equals(aiVar.s());
            }
            boolean z6 = z5 && t() == aiVar.t();
            if (t()) {
                z6 = z6 && u().equals(aiVar.u());
            }
            if (!z6 || !this.unknownFields.equals(aiVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (i() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + h().hashCode();
            }
            if (j()) {
                hashCode = (((hashCode * 37) + 3) * 53) + k().hashCode();
            }
            if (l()) {
                hashCode = (((hashCode * 37) + 4) * 53) + u.a(m());
            }
            if (n()) {
                hashCode = (((hashCode * 37) + 5) * 53) + u.a(o());
            }
            if (p()) {
                hashCode = (((hashCode * 37) + 6) * 53) + u.a(Double.doubleToLongBits(q()));
            }
            if (r()) {
                hashCode = (((hashCode * 37) + 7) * 53) + s().hashCode();
            }
            if (t()) {
                hashCode = (((hashCode * 37) + 8) * 53) + u().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: v */
        public a J() {
            return w();
        }

        public static a w() {
            return f13788c.I();
        }

        /* renamed from: x */
        public a I() {
            if (this == f13788c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements aj {

            /* renamed from: a  reason: collision with root package name */
            private int f13789a;

            /* renamed from: b  reason: collision with root package name */
            private List<b> f13790b;

            /* renamed from: c  reason: collision with root package name */
            private am<b, b.a, c> f13791c;

            /* renamed from: d  reason: collision with root package name */
            private Object f13792d;

            /* renamed from: e  reason: collision with root package name */
            private long f13793e;

            /* renamed from: f  reason: collision with root package name */
            private long f13794f;

            /* renamed from: g  reason: collision with root package name */
            private double f13795g;
            private f h;
            private Object i;

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.N.a((Class<? extends t>) ai.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13790b = Collections.emptyList();
                this.f13792d = "";
                this.h = f.f13707a;
                this.i = "";
                m();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13790b = Collections.emptyList();
                this.f13792d = "";
                this.h = f.f13707a;
                this.i = "";
                m();
            }

            private void m() {
                if (t.f14020b) {
                    o();
                }
            }

            public j.a g() {
                return i.M;
            }

            /* renamed from: h */
            public ai L() {
                return ai.y();
            }

            /* renamed from: i */
            public ai w() {
                ai j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public ai v() {
                ai aiVar = new ai((t.a) this);
                int i2 = this.f13789a;
                am<b, b.a, c> amVar = this.f13791c;
                int i3 = 1;
                if (amVar == null) {
                    if ((i2 & 1) == 1) {
                        this.f13790b = Collections.unmodifiableList(this.f13790b);
                        this.f13789a &= -2;
                    }
                    List unused = aiVar.name_ = this.f13790b;
                } else {
                    List unused2 = aiVar.name_ = amVar.e();
                }
                if ((i2 & 2) != 2) {
                    i3 = 0;
                }
                Object unused3 = aiVar.identifierValue_ = this.f13792d;
                if ((i2 & 4) == 4) {
                    i3 |= 2;
                }
                long unused4 = aiVar.positiveIntValue_ = this.f13793e;
                if ((i2 & 8) == 8) {
                    i3 |= 4;
                }
                long unused5 = aiVar.negativeIntValue_ = this.f13794f;
                if ((i2 & 16) == 16) {
                    i3 |= 8;
                }
                double unused6 = aiVar.doubleValue_ = this.f13795g;
                if ((i2 & 32) == 32) {
                    i3 |= 16;
                }
                f unused7 = aiVar.stringValue_ = this.h;
                if ((i2 & 64) == 64) {
                    i3 |= 32;
                }
                Object unused8 = aiVar.aggregateValue_ = this.i;
                int unused9 = aiVar.bitField0_ = i3;
                x();
                return aiVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof ai) {
                    return a((ai) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(ai aiVar) {
                if (aiVar == ai.y()) {
                    return this;
                }
                if (this.f13791c == null) {
                    if (!aiVar.name_.isEmpty()) {
                        if (this.f13790b.isEmpty()) {
                            this.f13790b = aiVar.name_;
                            this.f13789a &= -2;
                        } else {
                            n();
                            this.f13790b.addAll(aiVar.name_);
                        }
                        A();
                    }
                } else if (!aiVar.name_.isEmpty()) {
                    if (this.f13791c.d()) {
                        this.f13791c.b();
                        am<b, b.a, c> amVar = null;
                        this.f13791c = null;
                        this.f13790b = aiVar.name_;
                        this.f13789a &= -2;
                        if (t.f14020b) {
                            amVar = o();
                        }
                        this.f13791c = amVar;
                    } else {
                        this.f13791c.a(aiVar.name_);
                    }
                }
                if (aiVar.j()) {
                    this.f13789a |= 2;
                    this.f13792d = aiVar.identifierValue_;
                    A();
                }
                if (aiVar.l()) {
                    a(aiVar.m());
                }
                if (aiVar.n()) {
                    b(aiVar.o());
                }
                if (aiVar.p()) {
                    a(aiVar.q());
                }
                if (aiVar.r()) {
                    a(aiVar.s());
                }
                if (aiVar.t()) {
                    this.f13789a |= 64;
                    this.i = aiVar.aggregateValue_;
                    A();
                }
                d(aiVar.unknownFields);
                A();
                return this;
            }

            public final boolean a() {
                for (int i2 = 0; i2 < l(); i2++) {
                    if (!a(i2).a()) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.ai.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$ai> r1 = com.google.c.i.ai.f13787a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$ai r3 = (com.google.c.i.ai) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.ai) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$ai r4 = (com.google.c.i.ai) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.ai) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.ai.a.c(com.google.c.g, com.google.c.p):com.google.c.i$ai$a");
            }

            private void n() {
                if ((this.f13789a & 1) != 1) {
                    this.f13790b = new ArrayList(this.f13790b);
                    this.f13789a |= 1;
                }
            }

            public int l() {
                am<b, b.a, c> amVar = this.f13791c;
                if (amVar == null) {
                    return this.f13790b.size();
                }
                return amVar.c();
            }

            public b a(int i2) {
                am<b, b.a, c> amVar = this.f13791c;
                if (amVar == null) {
                    return this.f13790b.get(i2);
                }
                return amVar.a(i2);
            }

            private am<b, b.a, c> o() {
                if (this.f13791c == null) {
                    List<b> list = this.f13790b;
                    boolean z = true;
                    if ((this.f13789a & 1) != 1) {
                        z = false;
                    }
                    this.f13791c = new am<>(list, z, z(), y());
                    this.f13790b = null;
                }
                return this.f13791c;
            }

            public a a(long j) {
                this.f13789a |= 4;
                this.f13793e = j;
                A();
                return this;
            }

            public a b(long j) {
                this.f13789a |= 8;
                this.f13794f = j;
                A();
                return this;
            }

            public a a(double d2) {
                this.f13789a |= 16;
                this.f13795g = d2;
                A();
                return this;
            }

            public a a(f fVar) {
                if (fVar != null) {
                    this.f13789a |= 32;
                    this.h = fVar;
                    A();
                    return this;
                }
                throw new NullPointerException();
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static ai y() {
            return f13788c;
        }

        public aj<ai> F() {
            return f13787a;
        }

        /* renamed from: z */
        public ai L() {
            return f13788c;
        }
    }

    public static final class ag extends t implements ah {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final aj<ag> f13774a = new c<ag>() {
            /* renamed from: a */
            public ag b(g gVar, p pVar) throws v {
                return new ag(gVar, pVar);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final ag f13775c = new ag();
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public List<b> location_;
        private byte memoizedIsInitialized;

        public interface c extends ag {
        }

        private ag(t.a<?> aVar) {
            super(aVar);
            this.memoizedIsInitialized = -1;
        }

        private ag() {
            this.memoizedIsInitialized = -1;
            this.location_ = Collections.emptyList();
        }

        public final at f() {
            return this.unknownFields;
        }

        private ag(g gVar, p pVar) throws v {
            this();
            at.a c2 = at.c();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int a2 = gVar.a();
                    if (a2 != 0) {
                        if (a2 == 10) {
                            if (!z2 || !true) {
                                this.location_ = new ArrayList();
                                z2 |= true;
                            }
                            this.location_.add(gVar.a(b.f13779a, pVar));
                        } else if (!a(gVar, c2, pVar, a2)) {
                        }
                    }
                    z = true;
                } catch (v e2) {
                    throw e2.a(this);
                } catch (IOException e3) {
                    throw new v(e3).a(this);
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.location_ = Collections.unmodifiableList(this.location_);
                    }
                    this.unknownFields = c2.w();
                    Y();
                    throw th;
                }
            }
            if (z2 && true) {
                this.location_ = Collections.unmodifiableList(this.location_);
            }
            this.unknownFields = c2.w();
            Y();
        }

        /* access modifiers changed from: protected */
        public t.f m_() {
            return i.R.a((Class<? extends t>) ag.class, (Class<? extends t.a>) a.class);
        }

        public static final class b extends t implements c {
            @Deprecated

            /* renamed from: a  reason: collision with root package name */
            public static final aj<b> f13779a = new c<b>() {
                /* renamed from: a */
                public b b(g gVar, p pVar) throws v {
                    return new b(gVar, pVar);
                }
            };

            /* renamed from: c  reason: collision with root package name */
            private static final b f13780c = new b();
            private static final long serialVersionUID = 0;
            /* access modifiers changed from: private */
            public int bitField0_;
            /* access modifiers changed from: private */
            public volatile Object leadingComments_;
            /* access modifiers changed from: private */
            public z leadingDetachedComments_;
            private byte memoizedIsInitialized;
            private int pathMemoizedSerializedSize;
            /* access modifiers changed from: private */
            public List<Integer> path_;
            private int spanMemoizedSerializedSize;
            /* access modifiers changed from: private */
            public List<Integer> span_;
            /* access modifiers changed from: private */
            public volatile Object trailingComments_;

            private b(t.a<?> aVar) {
                super(aVar);
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
            }

            private b() {
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.path_ = Collections.emptyList();
                this.span_ = Collections.emptyList();
                this.leadingComments_ = "";
                this.trailingComments_ = "";
                this.leadingDetachedComments_ = y.f14071a;
            }

            public final at f() {
                return this.unknownFields;
            }

            private b(g gVar, p pVar) throws v {
                this();
                at.a c2 = at.c();
                boolean z = false;
                boolean z2 = false;
                while (!z) {
                    try {
                        int a2 = gVar.a();
                        if (a2 != 0) {
                            if (a2 == 8) {
                                if (!z2 || !true) {
                                    this.path_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.path_.add(Integer.valueOf(gVar.g()));
                            } else if (a2 == 10) {
                                int d2 = gVar.d(gVar.t());
                                if ((!z2 || !true) && gVar.y() > 0) {
                                    this.path_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (gVar.y() > 0) {
                                    this.path_.add(Integer.valueOf(gVar.g()));
                                }
                                gVar.e(d2);
                            } else if (a2 == 16) {
                                if (!(z2 & true)) {
                                    this.span_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.span_.add(Integer.valueOf(gVar.g()));
                            } else if (a2 == 18) {
                                int d3 = gVar.d(gVar.t());
                                if (!(z2 & true) && gVar.y() > 0) {
                                    this.span_ = new ArrayList();
                                    z2 |= true;
                                }
                                while (gVar.y() > 0) {
                                    this.span_.add(Integer.valueOf(gVar.g()));
                                }
                                gVar.e(d3);
                            } else if (a2 == 26) {
                                f m = gVar.m();
                                this.bitField0_ |= 1;
                                this.leadingComments_ = m;
                            } else if (a2 == 34) {
                                f m2 = gVar.m();
                                this.bitField0_ |= 2;
                                this.trailingComments_ = m2;
                            } else if (a2 == 50) {
                                f m3 = gVar.m();
                                if (!(z2 & true)) {
                                    this.leadingDetachedComments_ = new y();
                                    z2 |= true;
                                }
                                this.leadingDetachedComments_.a(m3);
                            } else if (!a(gVar, c2, pVar, a2)) {
                            }
                        }
                        z = true;
                    } catch (v e2) {
                        throw e2.a(this);
                    } catch (IOException e3) {
                        throw new v(e3).a(this);
                    } catch (Throwable th) {
                        if (z2 && true) {
                            this.path_ = Collections.unmodifiableList(this.path_);
                        }
                        if (z2 & true) {
                            this.span_ = Collections.unmodifiableList(this.span_);
                        }
                        if (z2 & true) {
                            this.leadingDetachedComments_ = this.leadingDetachedComments_.e();
                        }
                        this.unknownFields = c2.w();
                        Y();
                        throw th;
                    }
                }
                if (z2 && true) {
                    this.path_ = Collections.unmodifiableList(this.path_);
                }
                if (z2 & true) {
                    this.span_ = Collections.unmodifiableList(this.span_);
                }
                if (z2 & true) {
                    this.leadingDetachedComments_ = this.leadingDetachedComments_.e();
                }
                this.unknownFields = c2.w();
                Y();
            }

            /* access modifiers changed from: protected */
            public t.f m_() {
                return i.T.a((Class<? extends t>) b.class, (Class<? extends t.a>) a.class);
            }

            public List<Integer> h() {
                return this.path_;
            }

            public int i() {
                return this.path_.size();
            }

            public List<Integer> j() {
                return this.span_;
            }

            public int k() {
                return this.span_.size();
            }

            public boolean l() {
                return (this.bitField0_ & 1) == 1;
            }

            public String m() {
                Object obj = this.leadingComments_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                f fVar = (f) obj;
                String d2 = fVar.d();
                if (fVar.e()) {
                    this.leadingComments_ = d2;
                }
                return d2;
            }

            public boolean n() {
                return (this.bitField0_ & 2) == 2;
            }

            public String o() {
                Object obj = this.trailingComments_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                f fVar = (f) obj;
                String d2 = fVar.d();
                if (fVar.e()) {
                    this.trailingComments_ = d2;
                }
                return d2;
            }

            public al p() {
                return this.leadingDetachedComments_;
            }

            public int q() {
                return this.leadingDetachedComments_.size();
            }

            public final boolean a() {
                byte b2 = this.memoizedIsInitialized;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = 1;
                return true;
            }

            public void a(h hVar) throws IOException {
                b();
                if (h().size() > 0) {
                    hVar.b(10);
                    hVar.b(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    hVar.a(this.path_.get(i).intValue());
                }
                if (j().size() > 0) {
                    hVar.b(18);
                    hVar.b(this.spanMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.span_.size(); i2++) {
                    hVar.a(this.span_.get(i2).intValue());
                }
                if ((this.bitField0_ & 1) == 1) {
                    t.a(hVar, 3, this.leadingComments_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    t.a(hVar, 4, this.trailingComments_);
                }
                for (int i3 = 0; i3 < this.leadingDetachedComments_.size(); i3++) {
                    t.a(hVar, 6, this.leadingDetachedComments_.c(i3));
                }
                this.unknownFields.a(hVar);
            }

            public int b() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.path_.size(); i3++) {
                    i2 += h.h(this.path_.get(i3).intValue());
                }
                int i4 = 0 + i2;
                if (!h().isEmpty()) {
                    i4 = i4 + 1 + h.h(i2);
                }
                this.pathMemoizedSerializedSize = i2;
                int i5 = 0;
                for (int i6 = 0; i6 < this.span_.size(); i6++) {
                    i5 += h.h(this.span_.get(i6).intValue());
                }
                int i7 = i4 + i5;
                if (!j().isEmpty()) {
                    i7 = i7 + 1 + h.h(i5);
                }
                this.spanMemoizedSerializedSize = i5;
                if ((this.bitField0_ & 1) == 1) {
                    i7 += t.a(3, this.leadingComments_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i7 += t.a(4, this.trailingComments_);
                }
                int i8 = 0;
                for (int i9 = 0; i9 < this.leadingDetachedComments_.size(); i9++) {
                    i8 += a(this.leadingDetachedComments_.c(i9));
                }
                int size = i7 + i8 + (p().size() * 1) + this.unknownFields.b();
                this.memoizedSize = size;
                return size;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return super.equals(obj);
                }
                b bVar = (b) obj;
                boolean z = ((h().equals(bVar.h())) && j().equals(bVar.j())) && l() == bVar.l();
                if (l()) {
                    z = z && m().equals(bVar.m());
                }
                boolean z2 = z && n() == bVar.n();
                if (n()) {
                    z2 = z2 && o().equals(bVar.o());
                }
                if (!(z2 && p().equals(bVar.p())) || !this.unknownFields.equals(bVar.unknownFields)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = 779 + g().hashCode();
                if (i() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + h().hashCode();
                }
                if (k() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + j().hashCode();
                }
                if (l()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + m().hashCode();
                }
                if (n()) {
                    hashCode = (((hashCode * 37) + 4) * 53) + o().hashCode();
                }
                if (q() > 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + p().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            /* renamed from: r */
            public a J() {
                return s();
            }

            public static a s() {
                return f13780c.I();
            }

            /* renamed from: t */
            public a I() {
                if (this == f13780c) {
                    return new a();
                }
                return new a().a(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public a b(t.b bVar) {
                return new a(bVar);
            }

            public static final class a extends t.a<a> implements c {

                /* renamed from: a  reason: collision with root package name */
                private int f13781a;

                /* renamed from: b  reason: collision with root package name */
                private List<Integer> f13782b;

                /* renamed from: c  reason: collision with root package name */
                private List<Integer> f13783c;

                /* renamed from: d  reason: collision with root package name */
                private Object f13784d;

                /* renamed from: e  reason: collision with root package name */
                private Object f13785e;

                /* renamed from: f  reason: collision with root package name */
                private z f13786f;

                public final boolean a() {
                    return true;
                }

                /* access modifiers changed from: protected */
                public t.f e() {
                    return i.T.a((Class<? extends t>) b.class, (Class<? extends t.a>) a.class);
                }

                private a() {
                    this.f13782b = Collections.emptyList();
                    this.f13783c = Collections.emptyList();
                    this.f13784d = "";
                    this.f13785e = "";
                    this.f13786f = y.f14071a;
                    l();
                }

                private a(t.b bVar) {
                    super(bVar);
                    this.f13782b = Collections.emptyList();
                    this.f13783c = Collections.emptyList();
                    this.f13784d = "";
                    this.f13785e = "";
                    this.f13786f = y.f14071a;
                    l();
                }

                private void l() {
                    boolean z = t.f14020b;
                }

                public j.a g() {
                    return i.S;
                }

                /* renamed from: h */
                public b L() {
                    return b.u();
                }

                /* renamed from: i */
                public b w() {
                    b j = v();
                    if (j.a()) {
                        return j;
                    }
                    throw b((ac) j);
                }

                /* renamed from: j */
                public b v() {
                    b bVar = new b((t.a) this);
                    int i = this.f13781a;
                    int i2 = 1;
                    if ((i & 1) == 1) {
                        this.f13782b = Collections.unmodifiableList(this.f13782b);
                        this.f13781a &= -2;
                    }
                    List unused = bVar.path_ = this.f13782b;
                    if ((this.f13781a & 2) == 2) {
                        this.f13783c = Collections.unmodifiableList(this.f13783c);
                        this.f13781a &= -3;
                    }
                    List unused2 = bVar.span_ = this.f13783c;
                    if ((i & 4) != 4) {
                        i2 = 0;
                    }
                    Object unused3 = bVar.leadingComments_ = this.f13784d;
                    if ((i & 8) == 8) {
                        i2 |= 2;
                    }
                    Object unused4 = bVar.trailingComments_ = this.f13785e;
                    if ((this.f13781a & 16) == 16) {
                        this.f13786f = this.f13786f.e();
                        this.f13781a &= -17;
                    }
                    z unused5 = bVar.leadingDetachedComments_ = this.f13786f;
                    int unused6 = bVar.bitField0_ = i2;
                    x();
                    return bVar;
                }

                /* renamed from: k */
                public a s() {
                    return (a) super.d();
                }

                /* renamed from: a */
                public a f(j.f fVar, Object obj) {
                    return (a) super.f(fVar, obj);
                }

                /* renamed from: b */
                public a e(j.f fVar, Object obj) {
                    return (a) super.e(fVar, obj);
                }

                /* renamed from: d */
                public a c(ac acVar) {
                    if (acVar instanceof b) {
                        return a((b) acVar);
                    }
                    super.c(acVar);
                    return this;
                }

                public a a(b bVar) {
                    if (bVar == b.u()) {
                        return this;
                    }
                    if (!bVar.path_.isEmpty()) {
                        if (this.f13782b.isEmpty()) {
                            this.f13782b = bVar.path_;
                            this.f13781a &= -2;
                        } else {
                            m();
                            this.f13782b.addAll(bVar.path_);
                        }
                        A();
                    }
                    if (!bVar.span_.isEmpty()) {
                        if (this.f13783c.isEmpty()) {
                            this.f13783c = bVar.span_;
                            this.f13781a &= -3;
                        } else {
                            n();
                            this.f13783c.addAll(bVar.span_);
                        }
                        A();
                    }
                    if (bVar.l()) {
                        this.f13781a |= 4;
                        this.f13784d = bVar.leadingComments_;
                        A();
                    }
                    if (bVar.n()) {
                        this.f13781a |= 8;
                        this.f13785e = bVar.trailingComments_;
                        A();
                    }
                    if (!bVar.leadingDetachedComments_.isEmpty()) {
                        if (this.f13786f.isEmpty()) {
                            this.f13786f = bVar.leadingDetachedComments_;
                            this.f13781a &= -17;
                        } else {
                            o();
                            this.f13786f.addAll(bVar.leadingDetachedComments_);
                        }
                        A();
                    }
                    d(bVar.unknownFields);
                    A();
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
                /* renamed from: d */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.google.c.i.ag.b.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.c.aj<com.google.c.i$ag$b> r1 = com.google.c.i.ag.b.f13779a     // Catch:{ v -> 0x0011 }
                        java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                        com.google.c.i$ag$b r3 = (com.google.c.i.ag.b) r3     // Catch:{ v -> 0x0011 }
                        if (r3 == 0) goto L_0x000e
                        r2.a((com.google.c.i.ag.b) r3)
                    L_0x000e:
                        return r2
                    L_0x000f:
                        r3 = move-exception
                        goto L_0x001f
                    L_0x0011:
                        r3 = move-exception
                        com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                        com.google.c.i$ag$b r4 = (com.google.c.i.ag.b) r4     // Catch:{ all -> 0x000f }
                        java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                        throw r3     // Catch:{ all -> 0x001d }
                    L_0x001d:
                        r3 = move-exception
                        r0 = r4
                    L_0x001f:
                        if (r0 == 0) goto L_0x0024
                        r2.a((com.google.c.i.ag.b) r0)
                    L_0x0024:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.ag.b.a.c(com.google.c.g, com.google.c.p):com.google.c.i$ag$b$a");
                }

                private void m() {
                    if ((this.f13781a & 1) != 1) {
                        this.f13782b = new ArrayList(this.f13782b);
                        this.f13781a |= 1;
                    }
                }

                private void n() {
                    if ((this.f13781a & 2) != 2) {
                        this.f13783c = new ArrayList(this.f13783c);
                        this.f13781a |= 2;
                    }
                }

                private void o() {
                    if ((this.f13781a & 16) != 16) {
                        this.f13786f = new y(this.f13786f);
                        this.f13781a |= 16;
                    }
                }

                /* renamed from: b */
                public final a f(at atVar) {
                    return (a) super.f(atVar);
                }

                /* renamed from: c */
                public final a d(at atVar) {
                    return (a) super.a(atVar);
                }
            }

            public static b u() {
                return f13780c;
            }

            public aj<b> F() {
                return f13779a;
            }

            /* renamed from: v */
            public b L() {
                return f13780c;
            }
        }

        public List<b> h() {
            return this.location_;
        }

        public int i() {
            return this.location_.size();
        }

        public final boolean a() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void a(h hVar) throws IOException {
            for (int i = 0; i < this.location_.size(); i++) {
                hVar.a(1, (ad) this.location_.get(i));
            }
            this.unknownFields.a(hVar);
        }

        public int b() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.location_.size(); i3++) {
                i2 += h.c(1, (ad) this.location_.get(i3));
            }
            int b2 = i2 + this.unknownFields.b();
            this.memoizedSize = b2;
            return b2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ag)) {
                return super.equals(obj);
            }
            ag agVar = (ag) obj;
            if (!(h().equals(agVar.h())) || !this.unknownFields.equals(agVar.unknownFields)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + g().hashCode();
            if (i() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + h().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        /* renamed from: j */
        public a J() {
            return k();
        }

        public static a k() {
            return f13775c.I();
        }

        public static a a(ag agVar) {
            return f13775c.I().a(agVar);
        }

        /* renamed from: l */
        public a I() {
            if (this == f13775c) {
                return new a();
            }
            return new a().a(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b(t.b bVar) {
            return new a(bVar);
        }

        public static final class a extends t.a<a> implements ah {

            /* renamed from: a  reason: collision with root package name */
            private int f13776a;

            /* renamed from: b  reason: collision with root package name */
            private List<b> f13777b;

            /* renamed from: c  reason: collision with root package name */
            private am<b, b.a, c> f13778c;

            public final boolean a() {
                return true;
            }

            /* access modifiers changed from: protected */
            public t.f e() {
                return i.R.a((Class<? extends t>) ag.class, (Class<? extends t.a>) a.class);
            }

            private a() {
                this.f13777b = Collections.emptyList();
                l();
            }

            private a(t.b bVar) {
                super(bVar);
                this.f13777b = Collections.emptyList();
                l();
            }

            private void l() {
                if (t.f14020b) {
                    n();
                }
            }

            public j.a g() {
                return i.Q;
            }

            /* renamed from: h */
            public ag L() {
                return ag.m();
            }

            /* renamed from: i */
            public ag w() {
                ag j = v();
                if (j.a()) {
                    return j;
                }
                throw b((ac) j);
            }

            /* renamed from: j */
            public ag v() {
                ag agVar = new ag((t.a) this);
                int i = this.f13776a;
                am<b, b.a, c> amVar = this.f13778c;
                if (amVar == null) {
                    if ((i & 1) == 1) {
                        this.f13777b = Collections.unmodifiableList(this.f13777b);
                        this.f13776a &= -2;
                    }
                    List unused = agVar.location_ = this.f13777b;
                } else {
                    List unused2 = agVar.location_ = amVar.e();
                }
                x();
                return agVar;
            }

            /* renamed from: k */
            public a s() {
                return (a) super.d();
            }

            /* renamed from: a */
            public a f(j.f fVar, Object obj) {
                return (a) super.f(fVar, obj);
            }

            /* renamed from: b */
            public a e(j.f fVar, Object obj) {
                return (a) super.e(fVar, obj);
            }

            /* renamed from: d */
            public a c(ac acVar) {
                if (acVar instanceof ag) {
                    return a((ag) acVar);
                }
                super.c(acVar);
                return this;
            }

            public a a(ag agVar) {
                if (agVar == ag.m()) {
                    return this;
                }
                if (this.f13778c == null) {
                    if (!agVar.location_.isEmpty()) {
                        if (this.f13777b.isEmpty()) {
                            this.f13777b = agVar.location_;
                            this.f13776a &= -2;
                        } else {
                            m();
                            this.f13777b.addAll(agVar.location_);
                        }
                        A();
                    }
                } else if (!agVar.location_.isEmpty()) {
                    if (this.f13778c.d()) {
                        this.f13778c.b();
                        am<b, b.a, c> amVar = null;
                        this.f13778c = null;
                        this.f13777b = agVar.location_;
                        this.f13776a &= -2;
                        if (t.f14020b) {
                            amVar = n();
                        }
                        this.f13778c = amVar;
                    } else {
                        this.f13778c.a(agVar.location_);
                    }
                }
                d(agVar.unknownFields);
                A();
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
            /* renamed from: d */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.google.c.i.ag.a c(com.google.c.g r3, com.google.c.p r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.c.aj<com.google.c.i$ag> r1 = com.google.c.i.ag.f13774a     // Catch:{ v -> 0x0011 }
                    java.lang.Object r3 = r1.b((com.google.c.g) r3, (com.google.c.p) r4)     // Catch:{ v -> 0x0011 }
                    com.google.c.i$ag r3 = (com.google.c.i.ag) r3     // Catch:{ v -> 0x0011 }
                    if (r3 == 0) goto L_0x000e
                    r2.a((com.google.c.i.ag) r3)
                L_0x000e:
                    return r2
                L_0x000f:
                    r3 = move-exception
                    goto L_0x001f
                L_0x0011:
                    r3 = move-exception
                    com.google.c.ad r4 = r3.a()     // Catch:{ all -> 0x000f }
                    com.google.c.i$ag r4 = (com.google.c.i.ag) r4     // Catch:{ all -> 0x000f }
                    java.io.IOException r3 = r3.b()     // Catch:{ all -> 0x001d }
                    throw r3     // Catch:{ all -> 0x001d }
                L_0x001d:
                    r3 = move-exception
                    r0 = r4
                L_0x001f:
                    if (r0 == 0) goto L_0x0024
                    r2.a((com.google.c.i.ag) r0)
                L_0x0024:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.c.i.ag.a.c(com.google.c.g, com.google.c.p):com.google.c.i$ag$a");
            }

            private void m() {
                if ((this.f13776a & 1) != 1) {
                    this.f13777b = new ArrayList(this.f13777b);
                    this.f13776a |= 1;
                }
            }

            private am<b, b.a, c> n() {
                if (this.f13778c == null) {
                    List<b> list = this.f13777b;
                    boolean z = true;
                    if ((this.f13776a & 1) != 1) {
                        z = false;
                    }
                    this.f13778c = new am<>(list, z, z(), y());
                    this.f13777b = null;
                }
                return this.f13778c;
            }

            /* renamed from: b */
            public final a f(at atVar) {
                return (a) super.f(atVar);
            }

            /* renamed from: c */
            public final a d(at atVar) {
                return (a) super.a(atVar);
            }
        }

        public static ag m() {
            return f13775c;
        }

        public aj<ag> F() {
            return f13774a;
        }

        /* renamed from: n */
        public ag L() {
            return f13775c;
        }
    }

    public static j.g a() {
        return Y;
    }

    static {
        j.g.a(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Û\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.", "ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"ð\u0004\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorPr", "oto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001a,\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u001a+\n\rReservedRang", "e\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"¼\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE", "_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.pro", "tobuf.OneofOptions\"\u0001\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.proto", "buf.ServiceOptions\"Á\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"\u0005\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012,\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\b:\u0005false\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005fa", "lse\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001f\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0005false\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeM", "ode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0002J\u0004\b&\u0010'\"æ\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jstype", "\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\bè\u0007\u0010\u0002\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010", "\u0002\"\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002", "\"z\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0002\"\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_ex", "tension\u0018\u0002 \u0002(\b\"Õ\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"§\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0004 \u0001(\u0005B", "[\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001Z\ndescriptor \u0001\u0001¢\u0002\u0003GPBª\u0002\u001aGoogle.Protobuf.Reflection"}, new j.g[0], (j.g.a) new j.g.a() {
            public n a(j.g gVar) {
                j.g unused = i.Y = gVar;
                return null;
            }
        });
    }
}
