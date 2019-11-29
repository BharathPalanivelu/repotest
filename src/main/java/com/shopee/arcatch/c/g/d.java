package com.shopee.arcatch.c.g;

import com.badlogic.gdx.physics.box2d.ContactFilter;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.shopee.arcatch.page.view.b;
import java.util.List;

public class d implements ContactFilter {

    /* renamed from: a  reason: collision with root package name */
    private List<f> f26879a;

    /* renamed from: b  reason: collision with root package name */
    private b f26880b;

    public d(List<f> list, b bVar) {
        this.f26879a = list;
        this.f26880b = bVar;
    }

    public boolean shouldCollide(Fixture fixture, Fixture fixture2) {
        if (this.f26880b.d()) {
            Filter filterData = fixture.getFilterData();
            Filter filterData2 = fixture2.getFilterData();
            f fVar = (f) fixture.getBody().getUserData();
            f fVar2 = (f) fixture2.getBody().getUserData();
            if (!(fVar == null || fVar2 == null)) {
                int b2 = fVar.b();
                int b3 = fVar2.b();
                if (b2 == 0 && b3 == 12) {
                    return this.f26879a.contains(fVar);
                }
                if (b2 == 4 && b3 == 12) {
                    return false;
                }
                if (b2 == 8 && b3 == 12) {
                    return false;
                }
                if (b2 == 12) {
                    return b3 == 0 && this.f26879a.contains(fVar2);
                }
            }
            if (filterData.groupIndex != filterData2.groupIndex || filterData.groupIndex == 0) {
                if ((filterData.maskBits & filterData2.categoryBits) == 0 || (filterData.categoryBits & filterData2.maskBits) == 0) {
                    return false;
                }
                return true;
            } else if (filterData.groupIndex > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            f fVar3 = (f) fixture.getBody().getUserData();
            f fVar4 = (f) fixture2.getBody().getUserData();
            if (!(fVar3 == null || fVar4 == null)) {
                int b4 = fVar3.b();
                int b5 = fVar4.b();
                if (b4 == 8 || b4 == 12) {
                    if (b5 == 0) {
                        return this.f26879a.contains(fVar4);
                    }
                    if (b5 == 4) {
                    }
                } else if (b5 == 8 || b5 == 12) {
                    if (b4 == 0) {
                        return this.f26879a.contains(fVar3);
                    }
                    if (b4 == 4) {
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
