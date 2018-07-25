package com.lc.base;

import java.io.Serializable;

/**
 * Created by liuch on 2018/7/25.
 */
public class BasePageUtil implements Serializable{
    //设置初始页为第一页
    protected int iniPage=1;
    //设置每页的数据为20条
    protected int size=2;
    //设置排序列
    protected String sort;
    //设置默认的排序方式是根据ID
    protected String sidx="id";

    public int getIniPage() {
        return iniPage;
    }

    public void setIniPage(int iniPage) {
        this.iniPage = iniPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
