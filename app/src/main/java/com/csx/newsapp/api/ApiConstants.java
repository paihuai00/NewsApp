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

    //http://v.juhe.cn/toutiao/index?type=top&key=f6d595a6bfdf1d565662070090d2c7ba
    public static final String TOP_NEWS = "http://v.juhe.cn/toutiao/";

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.WE_CHAT:
                host = WE_CHAT;
                break;

            case HostType.TOP_NEWS:
                host = TOP_NEWS;

                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
