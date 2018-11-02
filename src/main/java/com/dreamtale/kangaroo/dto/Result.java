package com.dreamtale.kangaroo.dto;

import com.dreamtale.kangaroo.enums.ResultEnum;
import lombok.Data;

/**
 * Created by Dreamtale
 * Create date 2018/10/6
 */
@Data
public class Result<T> {

    private boolean isOk;

    //data
    private T data;

    //message
    private String message;


    public Result(){

    }
    //success
    public Result(ResultEnum resultEnum, T data){
        this.isOk = resultEnum.isOk();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
    //defeat
    public Result(ResultEnum resultEnum){
        this.isOk = resultEnum.isOk();
        this.message = resultEnum.getMessage();
    }
}
