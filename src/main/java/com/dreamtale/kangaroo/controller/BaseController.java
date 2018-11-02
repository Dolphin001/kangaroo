package com.dreamtale.kangaroo.controller;

import com.dreamtale.kangaroo.exception.ParamException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * BaseController
 * Created by zchuanzhao on 2016/11/26.
 */
public class BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;



    protected String getParam(String name){
        return request.getParameter(name);
    }

    protected String getParam(String name, String defaultValue){
        String value = getParam(name);
        if (null == value){
            value = defaultValue;
        }
        return value;
    }

    protected int getParamToInt(String name) throws ParamException {
        String value = getParam(name);
        try {
            return Integer.parseInt(value);
        }catch (Exception e){
            throw new ParamException("参数异常");
        }
    }

    protected int getParamToInt(String name, int defaultValue){
        try {
            return getParamToInt(name);
        } catch (ParamException paramException) {
            return defaultValue;
        }
    }

    protected double getParamToDouble(String name) throws ParamException {
        String value = getParam(name);
        try {
            return Double.parseDouble(value);
        }catch (Exception e){
            throw new ParamException("参数异常");
        }
    }

    protected double getParamToInt(String name, double defaultValue){
        try {
            return getParamToDouble(name);
        } catch (ParamException paramException) {
            return defaultValue;
        }
    }


    protected String getErrorMessages(BindingResult result) {
        StringBuffer errorMessages = new StringBuffer();
        List<FieldError> list = result.getFieldErrors();
        int count = 0;
        for (FieldError error : list) {
            errorMessages.append(error.getDefaultMessage());
            count ++;
            if(count < list.size()){
                errorMessages.append("<br/>");
            }
        }
        return errorMessages.toString();
    }


    /**
     * 判断是否是AJAX请求
     * @return true ajax
     */
    protected boolean isAjaxRequest(){
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equalsIgnoreCase(header) ? true : false;
    }

    /**
     * 全局捕获异常
     * @param e 捕获到的异常
     */
    @ExceptionHandler
    public void execptionHandler(Exception e){
        e.printStackTrace();
    }

}
