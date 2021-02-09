package com.copasso.cocobill.model.bean.local;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 账单分类bean
 * @author ry
 */
@Entity
public class BillingSort {

    @Id
    private Long id;
    private String sortName;
    private String sortImg;

    private int priority;

    private float cost;
    private Boolean income;

    @Generated(hash = 583176612)
    public BillingSort(Long id, String sortName, String sortImg, int priority,
            float cost, Boolean income) {
        this.id = id;
        this.sortName = sortName;
        this.sortImg = sortImg;
        this.priority = priority;
        this.cost = cost;
        this.income = income;
    }

    @Generated(hash = 420245818)
    public BillingSort() {
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortImg() {
        return sortImg;
    }

    public void setSortImg(String sortImg) {
        this.sortImg = sortImg;
    }

    public Boolean getIncome() {
        return income;
    }

    public void setIncome(Boolean income) {
        this.income = income;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int order) {
        this.priority = order;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}