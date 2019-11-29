package com.otaliastudios.cameraview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ah {

    public interface b {
        boolean a(af afVar);
    }

    public static ag a(b bVar) {
        return new c(bVar);
    }

    public static ag a(final int i) {
        return a((b) new b() {
            public boolean a(af afVar) {
                return afVar.a() <= i;
            }
        });
    }

    public static ag b(final int i) {
        return a((b) new b() {
            public boolean a(af afVar) {
                return afVar.a() >= i;
            }
        });
    }

    public static ag c(final int i) {
        return a((b) new b() {
            public boolean a(af afVar) {
                return afVar.b() <= i;
            }
        });
    }

    public static ag d(final int i) {
        return a((b) new b() {
            public boolean a(af afVar) {
                return afVar.b() >= i;
            }
        });
    }

    public static ag a(a aVar, final float f2) {
        final float a2 = aVar.a();
        return a((b) new b() {
            public boolean a(af afVar) {
                float a2 = a.a(afVar.a(), afVar.b()).a();
                float f2 = a2;
                float f3 = f2;
                return a2 >= f2 - f3 && a2 <= f2 + f3;
            }
        });
    }

    public static ag a() {
        return new ag() {
            public List<af> a(List<af> list) {
                Collections.sort(list);
                Collections.reverse(list);
                return list;
            }
        };
    }

    public static ag b() {
        return new ag() {
            public List<af> a(List<af> list) {
                Collections.sort(list);
                return list;
            }
        };
    }

    public static ag e(final int i) {
        return a((b) new b() {
            public boolean a(af afVar) {
                return afVar.b() * afVar.a() <= i;
            }
        });
    }

    public static ag f(final int i) {
        return a((b) new b() {
            public boolean a(af afVar) {
                return afVar.b() * afVar.a() >= i;
            }
        });
    }

    public static ag a(ag... agVarArr) {
        return new a(agVarArr);
    }

    public static ag b(ag... agVarArr) {
        return new d(agVarArr);
    }

    private static class c implements ag {

        /* renamed from: a  reason: collision with root package name */
        private b f15539a;

        private c(b bVar) {
            this.f15539a = bVar;
        }

        public List<af> a(List<af> list) {
            ArrayList arrayList = new ArrayList();
            for (af next : list) {
                if (this.f15539a.a(next)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
    }

    private static class a implements ag {

        /* renamed from: a  reason: collision with root package name */
        private ag[] f15538a;

        private a(ag... agVarArr) {
            this.f15538a = agVarArr;
        }

        public List<af> a(List<af> list) {
            for (ag a2 : this.f15538a) {
                list = a2.a(list);
            }
            return list;
        }
    }

    private static class d implements ag {

        /* renamed from: a  reason: collision with root package name */
        private ag[] f15540a;

        private d(ag... agVarArr) {
            this.f15540a = agVarArr;
        }

        public List<af> a(List<af> list) {
            List<af> list2 = null;
            for (ag a2 : this.f15540a) {
                list2 = a2.a(list);
                if (!list2.isEmpty()) {
                    break;
                }
            }
            return list2 == null ? new ArrayList() : list2;
        }
    }
}
