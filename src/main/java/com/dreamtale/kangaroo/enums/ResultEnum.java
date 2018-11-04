package com.dreamtale.kangaroo.enums;

import lombok.Getter;

/**
 * Created by Dreamtale
 * Create date 2018/10/6
 */
@Getter
public enum ResultEnum {

    SEARCH_SUCCESS(true,"Search success!"),
    INSERT_SUCCESS(true,"Add comment success!"),
    INSERT_DEFEAT(false,"Add comment failed!"),
    ANNOTATOR_RANGES_ERROR(false,"Please re-add comments!"),
    SEARCH_ANNOTATION(true,"Search annotation!");

    private boolean isOk;

    private String message;

    ResultEnum(boolean isOk, String message){
        this.isOk = isOk;
        this.message = message;
    }
}
