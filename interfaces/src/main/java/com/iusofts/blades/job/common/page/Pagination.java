package com.iusofts.blades.job.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页参数
 */
@ApiModel("分页参数")
public class Pagination {

    @ApiModelProperty(value = "当前页", example = "1")
    private int currentPage = 1;

    @ApiModelProperty(value = "每页记录数", example = "10")
    private int pageSize = 10;

    /**
     * 总记录数
     */
    @ApiModelProperty(hidden = true)
    private int totalCount;

    /**
     * 总页数
     */
    @ApiModelProperty(hidden = true)
    private int totalPage;

    /**
     * 是否统计
     */
    @ApiModelProperty(hidden = true)
    private boolean calculate = true;

    /**
     * 排序字段
     */
    //private Map<String, String> sortFields;
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isCalculate() {
        return calculate;
    }

    public void setCalculate(boolean calculate) {
        this.calculate = calculate;
    }

   /* public Map<String, String> getSortFields() {
        return sortFields;
    }

    public void setSortFields(Map<String, String> sortFields) {
        this.sortFields = sortFields;
    }*/

    @Override
    public String toString() {
        return "Pagination [totalCount=" + totalCount + ", totalPage=" + totalPage + ", currentPage=" + currentPage
                + ", pageSize=" + pageSize + ", calculate=" + calculate + "]";
    }
}
