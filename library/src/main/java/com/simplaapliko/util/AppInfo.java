/*
 * Copyright (C) 2014-2015 Oleg Kan, @Simplaapliko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.simplaapliko.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class AppInfo {

    /**
     * Get app version name and code
     */
    public static String getAppVersion(Context context) {
        return getAppVersionName(context) + " (" + getAppVersionCode(context) + ")";
    }

    /**
     * Get app version name
     */
    public static String getAppVersionName(Context context) {
        String versionName;
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            versionName = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionName = "";
        }
        return versionName;
    }

    /**
     * Get app version code
     */
    public static int getAppVersionCode(Context context) {
        int versionCode;
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            versionCode = pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            versionCode = 0;
        }
        return versionCode;
    }

}