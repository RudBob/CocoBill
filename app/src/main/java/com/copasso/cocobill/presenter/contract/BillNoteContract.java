package com.copasso.cocobill.presenter.contract;

import com.copasso.cocobill.base.BaseContract;
import com.copasso.cocobill.model.bean.local.BillingSort;
import com.copasso.cocobill.model.bean.local.NoteBean;

import java.util.List;

/**
 * Created by Zhouas666 on 2019-01-08
 * Github: https://github.com/zas023
 */
public interface BillNoteContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(NoteBean bean);

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 获取信息
         */
        void getBillNote();

        void updateBBsorts(List<BillingSort> items);

        void addBSort(BillingSort billingSort);
        void deleteBSortByID(Long id);
    }
}
