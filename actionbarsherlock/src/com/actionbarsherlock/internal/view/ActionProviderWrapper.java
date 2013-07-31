package com.actionbarsherlock.internal.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

import com.actionbarsherlock.internal.view.menu.SubMenuWrapper;
import com.actionbarsherlock.view.ActionProvider;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class ActionProviderWrapper extends android.view.ActionProvider {
    private final ActionProvider mProvider;


    public ActionProviderWrapper(ActionProvider provider) {
        super(null/*TODO*/); //XXX this *should* be unused
        mProvider = provider;
    }


    public ActionProvider unwrap() {
        return mProvider;
    }

    @Override
    @SuppressWarnings("deprecation")
    public View onCreateActionView() {
        return mProvider.onCreateActionView();
    }

    @Override
    public boolean hasSubMenu() {
        return mProvider.hasSubMenu();
    }

    @Override
    public boolean onPerformDefaultAction() {
        return mProvider.onPerformDefaultAction();
    }

    @Override
    public void onPrepareSubMenu(android.view.SubMenu subMenu) {
        mProvider.onPrepareSubMenu(new SubMenuWrapper(subMenu));
    }
}
