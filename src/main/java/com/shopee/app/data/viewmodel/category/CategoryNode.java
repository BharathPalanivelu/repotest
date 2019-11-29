package com.shopee.app.data.viewmodel.category;

import java.util.List;

public class CategoryNode {
    private int categoryId;
    private List<CategoryNode> children;
    private boolean isDefault;
    private boolean isSelected;
    private String name;
    private int parentId;
    private boolean showing;
    private int status;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setIsDefault(boolean z) {
        this.isDefault = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<CategoryNode> getChildren() {
        return this.children;
    }

    public void setChildren(List<CategoryNode> list) {
        this.children = list;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setParent(int i) {
        this.parentId = i;
    }

    public boolean isRoot() {
        return this.parentId == 0;
    }

    public boolean isShowing() {
        return this.showing;
    }

    public void setShowing(boolean z) {
        this.showing = z;
    }

    public int getGrandCount() {
        List<CategoryNode> list = this.children;
        int i = 0;
        if (list == null) {
            return 0;
        }
        for (CategoryNode next : list) {
            if (next.getChildren() != null) {
                i += next.getChildren().size();
            }
        }
        return i;
    }

    public boolean isHistory() {
        return getCategoryId() < 0;
    }

    public boolean hasNonDefaultChildren() {
        List<CategoryNode> list = this.children;
        return list != null && list.size() > 1;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isInvalid() {
        return this.status == 0;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
