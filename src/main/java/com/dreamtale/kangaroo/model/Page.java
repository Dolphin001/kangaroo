package com.dreamtale.kangaroo.model;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zchuanzhao on 16/9/28.
 */
@Data
public class Page<T> implements Serializable {

    private List<T> list;

    //当前第几页
    private int pageNo = 1;

    //每页数量
    private int pageSize = 20;

    //总页数
    private int totalPage;

    //数据总条数
    private int totalCount;

    //是否为第一页
    private boolean isFirstPage = false;

    //是否为最后一页
    private boolean isLastPage = false;

    private HttpServletRequest request;

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page(List<T> list, int pageNo, int pageSize, int totalCount) {
        this.list = list;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public Page(HttpServletRequest request){
        this.request = request;
        String no = request.getParameter("pageNo");
        try {
            this.pageNo = Integer.parseInt(no);
            if(this.pageNo < 1){
                this.pageNo = 1;
            }
        }catch (Exception e){
            this.pageNo = 1;
        }
        String size = request.getParameter("pageSize");
        try {
            this.pageSize = Integer.parseInt(size);
        }catch (Exception e){
            this.pageSize = 20;
        }
    }


}
