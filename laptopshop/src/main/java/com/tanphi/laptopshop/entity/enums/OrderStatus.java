package com.tanphi.laptopshop.entity.enums;

public enum OrderStatus {
	WAITING_FOR_APPROVAL(1),
    APPROVED(2),
    DELIVERING(3),
    DELIVERD(4),
    CANCELED(5);
    private Integer code;
    OrderStatus(Integer code)
    {
        this.code=code;
    }
    public Integer getCode(){return this.code;}
}
