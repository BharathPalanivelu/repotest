package d.d;

import d.d.b.d;
import d.d.b.j;
import d.f.b;
import d.m;

public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        j.b(bVar, "$this$javaObjectType");
        Class a2 = ((d) bVar).a();
        if (a2.isPrimitive()) {
            String name = a2.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            a2 = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            a2 = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            a2 = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            a2 = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            a2 = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            a2 = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            a2 = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            a2 = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            a2 = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (a2 != null) {
                return a2;
            }
            throw new m("null cannot be cast to non-null type java.lang.Class<T>");
        } else if (a2 != null) {
            return a2;
        } else {
            throw new m("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }
}
