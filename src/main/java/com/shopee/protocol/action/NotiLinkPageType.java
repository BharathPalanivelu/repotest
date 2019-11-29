package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum NotiLinkPageType implements ProtoEnum {
    Category_Item(1),
    Collection_Item(2),
    Shop(3),
    Category(4),
    Collection(5),
    Follow(6),
    Add_Friends(7),
    Sell_Camera(8),
    Activity(11),
    Me(12),
    Seller_Assistant(14),
    My_Products(15),
    My_Income(16),
    Shopping_Cart(17),
    My_Likes(18),
    My_Purchases(19),
    My_Sales(20),
    Action_Required(21),
    Simple_Nav(22),
    My_Account(23),
    Edit_Profile(24),
    Social_Account(25),
    Settings(26),
    RN_Page(27);
    
    private final int value;

    private NotiLinkPageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
