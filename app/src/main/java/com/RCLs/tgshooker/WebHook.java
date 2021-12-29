package com.RCLs.tgshooker;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class WebHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        Class<?> WebHook = XposedHelpers.findClassIfExists("org.telegram.messenger.BuildVars", loadPackageParam.classLoader);
        if (WebHook != null) {
            XposedBridge.hookAllMethods(WebHook, "isStandaloneApp", XC_MethodReplacement.returnConstant(0x1));
        }
    }
}
