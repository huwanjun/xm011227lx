package com.bawei.xm011227lx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.xm011227lx.base.BaseActivity;
import com.bawei.xm011227lx.contract.IHomeContract;
import com.bawei.xm011227lx.model.bean.Bean;
import com.bawei.xm011227lx.model.bean.FBean;
import com.bawei.xm011227lx.netutil.NetUtil;
import com.bawei.xm011227lx.presenter.HomePresenter;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {
    private XBanner xbaner;
    @Override
    protected void initData() {
        mPresenter.getHomeData("板鞋");
        mPresenter.getFlowData();

    }

    @Override
    protected void initView() {
        xbaner=findViewById(R.id.xbanner);

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onHomeSuccess(Bean bean) {
        final List<Bean.ResultBean> result1 = bean.getResult();
        xbaner.setBannerData(result1);
        xbaner.loadImage(new XBanner.XBannerAdapter() {
            @Override
           public void loadBanner(XBanner banner, Object model, View view, int position) {
                 String imageUrl=result1.get(position).getImageUrl();
                NetUtil.getInstance().getPhoto(imageUrl, (ImageView) view);
            }
        });


    }

    @Override
    public void onHomeFailure(Throwable throwable) {

    }

    @Override
    public void onFlowSuccess(FBean fBean) {

    }

    @Override
    public void onFlowFailure(Throwable throwable) {

    }
}
