package com.bawei.xm011227lx.model;

import com.bawei.xm011227lx.contract.IHomeContract;
import com.bawei.xm011227lx.model.bean.Bean;
import com.bawei.xm011227lx.model.bean.FBean;
import com.bawei.xm011227lx.netutil.NetUtil;
import com.google.gson.Gson;

/**
 * author: 斛万珺
 * data: 2019/12/27 16:16:57
 * function:
 */
public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(String keyword, final IModelCallback iModelCallback) {
        NetUtil.getInstance().getJsonGet(keyword, new NetUtil.MyCallback() {
            @Override
            public void onSuccess(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                iModelCallback.onHomeSuccess(bean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onHomeFailure(throwable);

            }
        });
    }

    @Override
    public void getFlowData(final IModelCallback iModelCallback) {
        NetUtil.getInstance().getJsonGet("", new NetUtil.MyCallback() {
            @Override
            public void onSuccess(String json) {
                FBean fBean = new Gson().fromJson(json, FBean.class);
                iModelCallback.onFlowSuccess(fBean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onFlowFailure(throwable);

            }
        });
    }
}
