package com.iusofts.blades.job.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 分页统一结果
 * Created by baijw on 2016/2/15.
 */
@ApiModel("分页返回结果")
public class PagingResult<T> {

    @ApiModelProperty("总数")
    private int totalCount;

    @ApiModelProperty("总页数")
    private int totalPage;

    @ApiModelProperty("列表数据")
    private List<T> dataList;

    public PagingResult(){

    };

    public PagingResult(int totalCount, int totalPage, List<T> dataList){
        this.totalCount=totalCount;
        this.totalPage=totalPage;
        this.dataList = dataList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
