package com.bawei.xm011227lx.base;

/**
 * author: 斛万珺
 * data: 2019/12/27 16:16:42
 * function:
 */
public abstract class BasePresenter<V> {

    protected V view;

    public void attach(V view){

        this.view=view;
    }

    public void detach(){

        view=null;
    }
    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
