package com.garena.imageeditor.b;

import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.g;
import java.util.HashMap;
import java.util.Stack;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Stack<d> f8104a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    private Stack<d> f8105b = new Stack<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<d, Stack<g>> f8106c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<d, Stack<g>> f8107d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private a f8108e;

    public interface a {
        void a(int i);

        void b(int i);

        void c(int i);
    }

    public void a(a aVar) {
        a(this.f8104a, this.f8106c, aVar);
        this.f8105b.clear();
        this.f8107d.clear();
        a aVar2 = this.f8108e;
        if (aVar2 != null) {
            aVar2.a(this.f8104a.size());
        }
    }

    private void a(Stack<d> stack, HashMap<d, Stack<g>> hashMap, a aVar) {
        if (hashMap.containsKey(aVar.f8102a)) {
            hashMap.get(aVar.f8102a).push(aVar.f8103b);
        } else {
            Stack stack2 = new Stack();
            stack2.push(aVar.f8103b);
            hashMap.put(aVar.f8102a, stack2);
        }
        stack.push(aVar.f8102a);
    }

    private g a(Stack<g> stack) {
        if (stack.size() > 0) {
            return stack.peek();
        }
        return null;
    }

    public a a() {
        d pop = this.f8104a.pop();
        a(this.f8105b, this.f8107d, new a(pop, (g) this.f8106c.get(pop).pop()));
        a aVar = this.f8108e;
        if (aVar != null) {
            aVar.b(this.f8104a.size());
        }
        return new a(pop, a(this.f8106c.get(pop)));
    }

    public a b() {
        d pop = this.f8105b.pop();
        g gVar = (g) this.f8107d.get(pop).pop();
        a(this.f8104a, this.f8106c, new a(pop, gVar));
        a aVar = this.f8108e;
        if (aVar != null) {
            aVar.c(this.f8105b.size());
        }
        return new a(pop, gVar);
    }

    public void a(a aVar) {
        this.f8108e = aVar;
    }
}
