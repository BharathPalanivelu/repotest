package com.shopee.app.ui.chat2;

import android.content.Context;
import android.view.View;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.s;
import com.shopee.app.ui.chat.cell.ChatHelpItemView_;
import com.shopee.app.ui.chat.cell.ab;
import com.shopee.app.ui.chat.cell.ac;
import com.shopee.app.ui.chat.cell.ae;
import com.shopee.app.ui.chat.cell.ag;
import com.shopee.app.ui.chat.cell.ai;
import com.shopee.app.ui.chat.cell.ak;
import com.shopee.app.ui.chat.cell.f;
import com.shopee.app.ui.chat.cell.j;
import com.shopee.app.ui.chat.cell.k;
import com.shopee.app.ui.chat.cell.n;
import com.shopee.app.ui.chat.cell.q;
import com.shopee.app.ui.chat.cell.t;
import com.shopee.app.ui.chat.cell.w;
import com.shopee.app.ui.chat.cell.z;
import java.util.HashMap;

public class l implements s<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Integer, c> f20530a = new HashMap<>();

    private static int a(int i) {
        return (i * 1) + 1;
    }

    private static int b(int i) {
        return (i * -1) - 1;
    }

    private static int c(int i) {
        return (i * 2) + 1;
    }

    public int a() {
        return 0;
    }

    public int a(ChatMessage chatMessage, int i) {
        int type = chatMessage.getType();
        if (chatMessage.isSystemMessage()) {
            return c(type);
        }
        return chatMessage.isRemote() ? b(type) : a(type);
    }

    public View a(Context context, int i) {
        if (f20530a.containsKey(Integer.valueOf(i))) {
            return f20530a.get(Integer.valueOf(i)).a(context);
        }
        if (i > 0) {
            return f20530a.get(Integer.valueOf(a(0))).a(context);
        }
        return f20530a.get(Integer.valueOf(b(0))).a(context);
    }

    static {
        f20530a.put(Integer.valueOf(a(0)), new a() {
            public View a(Context context, k kVar, boolean z) {
                return ai.a(context, z);
            }
        });
        f20530a.put(Integer.valueOf(b(0)), new b() {
            public View a(Context context, ab abVar, boolean z) {
                return ai.a(context, z);
            }
        });
        f20530a.put(Integer.valueOf(a(1)), new a() {
            public View a(Context context, k kVar, boolean z) {
                return j.a(context, kVar, z);
            }
        });
        f20530a.put(Integer.valueOf(b(1)), new b() {
            public View a(Context context, ab abVar, boolean z) {
                return j.a(context, abVar, z);
            }
        });
        f20530a.put(Integer.valueOf(a(3)), new a() {
            public View a(Context context, k kVar, boolean z) {
                return n.a(context, kVar, z);
            }
        });
        f20530a.put(Integer.valueOf(b(3)), new b() {
            public View a(Context context, ab abVar, boolean z) {
                return n.a(context, abVar, z);
            }
        });
        f20530a.put(Integer.valueOf(a(2)), new a() {
            public View a(Context context, k kVar, boolean z) {
                return z.a(context, kVar, z);
            }
        });
        f20530a.put(Integer.valueOf(b(2)), new b() {
            public View a(Context context, ab abVar, boolean z) {
                return z.a(context, abVar, z);
            }
        });
        f20530a.put(Integer.valueOf(a(4)), new a() {
            public View a(Context context, k kVar, boolean z) {
                return z.a(context, kVar, z);
            }
        });
        f20530a.put(Integer.valueOf(b(4)), new b() {
            public View a(Context context, ab abVar, boolean z) {
                return z.a(context, abVar, z);
            }
        });
        f20530a.put(Integer.valueOf(a(6)), new a() {
            public View a(Context context, k kVar, boolean z) {
                return ae.a(context, kVar, z);
            }
        });
        f20530a.put(Integer.valueOf(b(6)), new b() {
            public View a(Context context, ab abVar, boolean z) {
                return ae.a(context, abVar, z);
            }
        });
        f20530a.put(Integer.valueOf(c(100)), new c() {
            public View a(Context context) {
                return ag.a(context, ChatHelpItemView_.a(context));
            }
        });
        f20530a.put(Integer.valueOf(c(104)), new c() {
            public View a(Context context) {
                return ag.a(context, f.a(context));
            }
        });
        f20530a.put(Integer.valueOf(c(101)), new c() {
            public View a(Context context) {
                return ag.a(context, com.shopee.app.ui.chat.cell.c.a(context));
            }
        });
        f20530a.put(Integer.valueOf(c(102)), new c() {
            public View a(Context context) {
                return ag.a(context, w.a(context));
            }
        });
        f20530a.put(Integer.valueOf(c(8)), new c() {
            public View a(Context context) {
                return ag.a(context, new ak(context));
            }
        });
        f20530a.put(Integer.valueOf(c(9)), new c() {
            public View a(Context context) {
                return ag.a(context, ChatHelpItemView_.a(context));
            }
        });
        f20530a.put(Integer.valueOf(a(5)), new a() {
            public View a(Context context, k kVar, boolean z) {
                return t.a(context, kVar, z);
            }
        });
        f20530a.put(Integer.valueOf(b(5)), new b() {
            public View a(Context context, ab abVar, boolean z) {
                return t.a(context, abVar, z);
            }
        });
        f20530a.put(Integer.valueOf(c(103)), new c() {
            public View a(Context context) {
                return ag.a(context, q.a(context));
            }
        });
    }

    private static abstract class c {
        public abstract View a(Context context);

        private c() {
        }
    }

    private static abstract class a extends c {
        public abstract View a(Context context, k kVar, boolean z);

        private a() {
            super();
        }

        public View a(Context context) {
            k a2 = com.shopee.app.ui.chat.cell.l.a(context);
            a2.setContent(a(context, a2, true));
            return a2;
        }
    }

    private static abstract class b extends c {
        public abstract View a(Context context, ab abVar, boolean z);

        private b() {
            super();
        }

        public View a(Context context) {
            ab a2 = ac.a(context);
            a2.setContent(a(context, a2, false));
            return a2;
        }
    }
}
