package com.RCLs.tgshooker;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SponsoredMessagesBlock implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        Class<?> messagesController = XposedHelpers.findClassIfExists("org.telegram.messenger.MessagesController", loadPackageParam.classLoader);
        if (messagesController != null) {
            XposedBridge.hookAllMethods(messagesController, "getSponsoredMessages", XC_MethodReplacement.returnConstant(null));
        }
    }
}
