package com.csx.newsapp.api;

import com.csx.newsapp.bean.PhotoBean;
import com.csx.newsapp.bean.TopNewsBean;
import com.csx.newsapp.bean.WechatBean;
import com.csx.newsapp.bean.ZhiHuBean;
import com.csx.newsapp.bean.ZhiHuInnerBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {

    /**
     * 微信精选 http://v.juhe.cn/weixin/query?
     * key=4b00f82ba05b842bb8796d9d6272be2c
     * &pno=1    页码
     * &ps=10    一页的数据
     */
    @GET("weixin/query")
    Observable<WechatBean> weChat(
            @Query("key") String key,
            @Query("pno") String page,
            @Query("ps") String page_size
    );

    /**
     * 今日头条 http://v.juhe.cn/toutiao/index?type=top&key=f6d595abfdf1d565662070090d2c7ba
     */
    @GET("toutiao/index")
    Observable<TopNewsBean> getTopNews(
            @Query("key") String key,
            @Query("top") String topstring
    );

    /**
     * 图片
     * http://gank.io/api/data/%E7%A6%8F%E5%88%A9/7/10
     */
    @GET
    Observable<PhotoBean> getPhotos(@Url String url);

    /**
     * 知乎
     * http://news-at.zhihu.om/api/4/news/latest
     */
    @GET("latest")
    Observable<ZhiHuBean> getKnows();

    /**
     * 知乎，点击进入的界面，后面的id 需要根据传入的id更改
     * http://news-at.zhihu.cm/api/4/news/9520494
     */
    @GET
    Observable<ZhiHuInnerBean> getKnowsInners(@Url String url);

//    //登陆 usr_name=2016010101&usr_pwd=123456&role_enname=student
//    @GET("userCenter/userLogin")
//    Observable<BaseRespose<User>> login(
//            @Query("usr_name") String usr_name,
//            @Query("usr_pwd") String usr_pwd,
//            @Query("role_enname") String role_enname);
//
//    //获取消息列表 http://10.4.67.142/cstuController/getMsg?user_id=df66b1fabe5b43939e3b8a1af71396fc
//    // &school_id=0930dee7b7bc11e6ae01bb18440e772e&current_page=1&page_size=10
//    @GET("cstuController/getMsg")
//    Observable<BaseRespose<MessageData>> getMessageList(
//            @Query("user_id") String user_id,
//            @Query("school_id") String school_id,
//            @Query("current_page") int current_page,
//            @Query("page_size") int page_size);
//
//    //获取消息列表 http://10.4.67.142/publicInterface/adviseList?user_id=df66b1fabe5b43939e3b8a1af71396fc&to_page=1&
//    // page_size=1&news_type=1
//    @GET("publicInterface/adviseList")
//    Observable<BaseRespose<NoticeData>> getNoticeList(
//            @Query("user_id") String user_id,
//            @Query("news_type") int news_type,
//            @Query("current_page") int current_page,
//            @Query("page_size") int page_size);

}
