package com.oojunzi.test.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询结果
 *
 * @param <T> 查询结果类型
 * @author CBC
 */
@Data
public class Pager<T> {
    /**
     * 分页大小
     */
    private int pageSize = 20;

    /**
     * 页数
     */
    private int page = 1;

    /**
     * 总记录数
     */
    private int totalCount = 0;

    /**
     * 结果集
     */
    private List<T> data = new ArrayList<T>();

    /**
     * 构造函数
     *
     * @param page     页码
     * @param pageSize 每页记录数
     */
    public Pager(int page, int pageSize) {
        this.pageSize = pageSize;
        this.page = page;
    }

    /**
     * 是否是首页（第一页），第一页页码为1
     *
     * @return 首页标识
     */
    public boolean isFirstPage() {
        return page <= 1;
    }

    /**
     * 是否是最后一页
     *
     * @return 末页标识
     */
    public boolean isLastPage() {
        return page >= getTotalPages();
    }

    /**
     * 是否有上一页
     *
     * @return 上一页标识
     */
    public boolean isHasPrePage() {
        return (page - 1 >= 1);
    }

    /**
     * 是否有下一页
     *
     * @return 下一页标识
     */
    public boolean isHasNextPage() {
        return (page + 1 <= getTotalPages());
    }

    /**
     * offset，计数从0开始，可以用于mysql分页使用(0-based)
     *
     * @return 偏移量
     */
    public int getOffset() {
        return page > 0 ? (page - 1) * getPageSize() : 0;
    }


    /**
     * 得到 总页数
     *
     * @return 总页数
     */
    public int getTotalPages() {
        if (totalCount <= 0) {
            return 0;
        }
        if (pageSize <= 0) {
            return 0;
        }

        int count = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            count++;
        }
        return count;
    }
}
