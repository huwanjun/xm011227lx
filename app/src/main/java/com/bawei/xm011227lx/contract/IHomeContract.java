package com.bawei.xm011227lx.contract;

import com.bawei.xm011227lx.model.bean.FBean;
import com.bawei.xm011227lx.model.bean.Bean;

/**
 * author: 斛万珺
 * data: 2019/12/27 16:16:56
 * function:
 */
public interface IHomeContract {

    interface IView{

        void onHomeSuccess(Bean bean);
        void onHomeFailure(Throwable throwable);

        void onFlowSuccess(FBean fBean);
        void onFlowFailure(Throwable throwable);
    }

    interface IPresenter{
        void getHomeData(String keyword);
        void getFlowData();
    }

    interface IModel{

        void getHomeData(String keyword, IModelCallback iModelCallback );
        void getFlowData(IModelCallback iModelCallback);

        interface IModelCallback{

            void onHomeSuccess(Bean bean);
            void onHomeFailure(Throwable throwable);

            void onFlowSuccess(FBean fBean);
            void onFlowFailure(Throwable throwable);
        }

    }
}
