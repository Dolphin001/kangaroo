package com.dreamtale.kangaroo.dto;

import com.dreamtale.kangaroo.enums.ResultEnum;
import lombok.Data;

import java.util.List;

/**
 * Created by Dreamtale
 * Create date 2018/10/6
 */
@Data
public class Result<T> {
    public static String SUCCESS = "success";
    public static String ERROR = "error";

    private boolean isOk;

    //data
    private T rows;

    //message
    private String message;

    private int total;

    private String status;

    public Result(){

    }
    public Result(String status){
        this.status = status;
    }
    //success
    public Result(ResultEnum resultEnum, T data){
        this.isOk = resultEnum.isOk();
        this.message = resultEnum.getMessage();
        this.rows = data;
        if (data instanceof List){
            this.total = ((List) data).size();
        }
    }
    //defeat
    public Result(ResultEnum resultEnum){
        this.isOk = resultEnum.isOk();
        this.message = resultEnum.getMessage();
    }
}
