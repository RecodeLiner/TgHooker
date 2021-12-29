package com.RCLs.tgshooker;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class ScreenBlock implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        Class<?> androidutilities = XposedHelpers.findClassIfExists("org.telegram.messenger.AndroidUtilities", loadPackageParam.classLoader);
        if (androidutilities != null) {
            XposedBridge.hookAllMethods(androidutilities, "setFlagSecure", XC_MethodReplacement.returnConstant(null));
        }
    }
}
