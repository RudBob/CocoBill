package com.copasso.cocobill.model.bean.local;

import com.copasso.cocobill.model.bean.BaseBean;

import java.util.List;

/**
 * @author ry
 */
public class NoteBean extends BaseBean {

    private List<BillingSort> outSortlis;
    private List<BillingSort> inSortlis;
    private List<BPay> payinfo;

    public List<BillingSort> getOutSortlis() {
        return outSortlis;
    }

    public void setOutSortlis(List<BillingSort> outSortlis) {
        this.outSortlis = outSortlis;
    }

    public List<BillingSort> getInSortlis() {
        return inSortlis;
    }

    public void setInSortlis(List<BillingSort> inSortlis) {
        this.inSortlis = inSortlis;
    }

    public List<BPay> getPayinfo() {
        return payinfo;
    }

    public void setPayinfo(List<BPay> payinfo) {
        this.payinfo = payinfo;
    }
}
