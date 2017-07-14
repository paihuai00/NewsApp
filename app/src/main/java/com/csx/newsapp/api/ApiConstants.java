/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
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
 *
 */
package com.csx.newsapp.api;

public class ApiConstants {
    public static final String WE_CHAT = "http://v.juhe.cn/";

    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/7/10
    public static final String PHOTO = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";


    //知乎api http://news-at.zhihu.com/api/4/news/latest
    public static final String ZHI_HU = "http://news-at.zhihu.com/api/4/news/";
    //知乎 inner http://news-at.zhihu.com/api/4/news/9520494
    public static final String ZHIHU_INNER = "http://news-at.zhihu.com/api/4/news/";

    public static final String HOME_CURRENT_TAB_POSITION="HOME_CURRENT_TAB_POSITION";
    public static final String MENU_SHOW_HIDE="MENU_SHOW_HIDE";

    /**
     * 获取对应的host
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.WE_CHAT:
                host = WE_CHAT;
                break;

            case HostType.PHOTO:
                host = PHOTO;
                break;
            case HostType.ZHIHU:
                host = ZHI_HU;
                break;
            case HostType.ZHIHU_INNER:
                host = ZHIHU_INNER;
                break;

            default:
                host = "";
                break;
        }
        return host;
    }
}
