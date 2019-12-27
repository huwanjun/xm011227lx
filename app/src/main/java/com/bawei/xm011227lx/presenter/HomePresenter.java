package com.bawei.xm011227lx.presenter;

import android.view.View;

import com.bawei.xm011227lx.base.BasePresenter;
import com.bawei.xm011227lx.contract.IHomeContract;
import com.bawei.xm011227lx.model.HomeModel;
import com.bawei.xm011227lx.model.bean.Bean;
import com.bawei.xm011227lx.model.bean.FBean;

/**
 * author: 斛万珺
 * data: 2019/12/27 17:17:05
 * function:
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData(String keyword) {

        homeModel.getHomeData(keyword, new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);

            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);

            }

            @Override
            public void onFlowSuccess(FBean fBean) {
                view.onFlowSuccess(fBean);

            }

            @Override
            public void onFlowFailure(Throwable throwable) {
                view.onFlowFailure(throwable);

            }
        });
    }

    @Override
    public void getFlowData() {
        homeModel.getFlowData(new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);

            }

            @Override
            public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);

            }

            @Override
            public void onFlowSuccess(FBean fBean) {
                view.onFlowSuccess(fBean);

            }

            @Override
            public void onFlowFailure(Throwable throwable) {
                view.onFlowFailure(throwable);

            }
        });

    }
}
