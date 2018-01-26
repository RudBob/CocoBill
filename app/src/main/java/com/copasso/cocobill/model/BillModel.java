package com.copasso.cocobill.model;

public interface BillModel {

    /**
     * 添加账单
     */
    void add(int userid, int sortid, int payid,Float cost, String content,
             String crdate, boolean income);

    /**
     * 修改账单
     */
    void update(int id, int userid, int sortid, int payid,Float cost, String content,
                String crdate, boolean income);

    /**
     * 删除账单
     */
    void delete(int id);

    void onUnsubscribe();
}