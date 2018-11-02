package com.dreamtale.kangaroo.enums;

import lombok.Getter;

/**
 * Created by Dreamtale
 * Create date 2018/10/6
 */
@Getter
public enum ResultEnum {

    SEARCH_SUCCESS(true,"search success");



    private boolean isOk;

    private String message;

    ResultEnum(boolean isOk, String message){

        this.isOk = isOk;
        this.message = message;
    }
}
