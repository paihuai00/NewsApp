package com.csx.newsapp.bean;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/6.
 */

public class TopNewsBean {


    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"840386691c1dad60a0cba5f1e0cceb7d","title":"还在生长发育阶段的小胖子，有没有必要减肥？丨剑眉专栏","date":"2017-07-06 20:25","category":"头条","author_name":"春雨医生","url":"http://mini.eastday.com/mobile/170706202528338.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_1_mwpm_03200403.jpeg"},{"uniquekey":"9521ab8db06cb5546ebef96a2dbb5750","title":"德国一儿童误带二战炸弹进入幼儿园 上演惊魂一幕","date":"2017-07-06 15:42","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706154253884.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706154253_c9a1731a3d56dafc551b141f8416a275_1_mwpm_03200403.jpeg"},{"uniquekey":"d5cb34e7742def47840e3674a5ebf2a3","title":"雪域高原上的健康守门人","date":"2017-07-06 15:26","category":"头条","author_name":"新华社","url":"http://mini.eastday.com/mobile/170706152605559.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170706/20170706152605_8b84ff1ee74312f2a8d26147c94ac838_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170706/20170706152605_8b84ff1ee74312f2a8d26147c94ac838_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170706/20170706152605_8b84ff1ee74312f2a8d26147c94ac838_1_mwpm_03200403.jpeg"},{"uniquekey":"fc4ce343f800fbb12f9f1eaf6618fdc9","title":"退休干部驾车冲撞学生致一死多伤被判死刑","date":"2017-07-06 15:23","category":"头条","author_name":"南阳市中级人民法院","url":"http://mini.eastday.com/mobile/170706152359272.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170706/20170706152359_bdf548b77872506b75c48585bf659b7d_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170706/20170706152359_bdf548b77872506b75c48585bf659b7d_1_mwpm_03200403.jpeg"},{"uniquekey":"988aae3822a602d0b437d1c32369606f","title":"俄媒：普京或将作为无党派候选人参加2018总统大选","date":"2017-07-06 15:22","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706152233191.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170706/20170706152233_37f8ea02a68e3284324c5206e69f02fd_1_mwpm_03200403.png"},{"uniquekey":"6251af680624155e5d3d8012bf3a2ac6","title":"李显龙家族争端或迎转机，弟弟妹妹发联合声明称愿意私下解决","date":"2017-07-06 15:11","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170706151156324.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706151156_fa50ff02384dc95b70c46e503c183c9b_1_mwpm_03200403.jpeg"},{"uniquekey":"180a361ff969e1f9b466c50da0948930","title":"京广高铁浏阳河隧道因浸水临时关闭，8台抽水泵正不间断抽水","date":"2017-07-06 15:06","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170706150640370.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706150640_913a7d36468bb96b8b28965911898186_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170706/20170706150640_913a7d36468bb96b8b28965911898186_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170706/20170706150640_913a7d36468bb96b8b28965911898186_3_mwpm_03200403.jpeg"},{"uniquekey":"18e8dc78334740a5c5995884ea8c2af1","title":"7月份运气好到爆的三大生肖！","date":"2017-07-06 14:54","category":"头条","author_name":"暴走星座","url":"http://mini.eastday.com/mobile/170706145433482.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706_cbf930e3639c4abea8dcdd77960dac95_cover_mwpm_03200403.jpeg"},{"uniquekey":"bf7511feaf5c78dc3cfbd2738af98bf6","title":"一直保持天真和童心的星座，有你吗？","date":"2017-07-06 14:49","category":"头条","author_name":"暴走星座","url":"http://mini.eastday.com/mobile/170706144903042.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170706/20170706_965ddd8e78cfe9d767f2dfb15bb4b1eb_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170706/20170706_f10925e913102306e43d23daf03736ed_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170706/20170706_8cf508e79d5b296e06ace518e40cd36c_mwpm_03200403.jpg"},{"uniquekey":"c064e38230083f36d952044fd83d1a8b","title":"什么叫做实战经验？俄战机1000公里外向叙发射新导弹","date":"2017-07-06 14:48","category":"头条","author_name":"华领天下","url":"http://mini.eastday.com/mobile/170706144848071.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706_f1ed0f11e4769d318a9b892c6defa900_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706_85025aa922f9911f6dd67d3626253634_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706_0a8124a9035c39f4054e4ba27b2b30d6_cover_mwpm_03200403.jpeg"},{"uniquekey":"22bea3caba0d3950561cfdb4877ef325","title":"中国电商巨头进军印尼 必须要翻这\u201c四座大山\u201d","date":"2017-07-06 14:31","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706143140332.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170706/20170706143140_d4ad5caa7c253b14c1c5a693d003535a_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170706/20170706143140_d4ad5caa7c253b14c1c5a693d003535a_2_mwpm_03200403.jpeg"},{"uniquekey":"0d7de0304dbb7764615d304018f9f116","title":"昭君出塞前曾被宠幸三天三夜?历史真相让人面红耳赤！","date":"2017-07-06 14:27","category":"头条","author_name":"历史任意聊","url":"http://mini.eastday.com/mobile/170706142729613.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706_351e5d5f240628a7a3db3c03831ff9b8_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170706/20170706_2cf64eea38fd7dd1f8bca099cc195084_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170706/20170706_35ec3009f91ff078d891c1560fd03b04_cover_mwpm_03200403.jpeg"},{"uniquekey":"e64e612fd267a8aa3efbdf9b34571cd7","title":"F-35飞行员傲慢谈击败T-50,说到歼20却怂了？","date":"2017-07-06 14:15","category":"头条","author_name":"军事在前沿","url":"http://mini.eastday.com/mobile/170706141507564.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706_acf99c91020ad7422c63d480ca3291f9_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706_2dc89baf1c08cf65dddfe975dd6fd0c4_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706_cafa224eb07157ffc1f51d9acad1b676_cover_mwpm_03200403.jpeg"},{"uniquekey":"c29b5383092e88417d349ca1f4a73bb0","title":"章莹颖案新内情曝光！如没被抓，他还会下手！","date":"2017-07-06 14:11","category":"头条","author_name":"环球网-这里是美国","url":"http://mini.eastday.com/mobile/170706141123375.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170706/20170706141123_b4fa935495372288e1d48a6ae856ce71_6_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170706/20170706141123_b4fa935495372288e1d48a6ae856ce71_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170706/20170706141123_b4fa935495372288e1d48a6ae856ce71_1_mwpm_03200403.jpeg"},{"uniquekey":"ab83553f5e939a9c6d88c85c9af6619f","title":"韩执政党党首：充分理解中方对\u201c萨德\u201d入韩的忧虑","date":"2017-07-06 14:11","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706141123310.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706141123_af5557a7d06ba02e5f2691413ef091dc_1_mwpm_03200403.jpeg"},{"uniquekey":"7240c8f75195303a9cad6cb2a9df70f5","title":"江苏，2016年3座城市跻身\u201c新一线\u201d！","date":"2017-07-06 14:04","category":"头条","author_name":"长三角新时空","url":"http://mini.eastday.com/mobile/170706140452298.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170706/20170706_257ead67cdc8c19768e496ff4f423af7_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170706/20170706_dadedf570d5f66926851c4e84265703d_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170706/20170706_9b897b5d63d270b6d00d6ff961416f24_cover_mwpm_03200403.jpeg"},{"uniquekey":"7fb528cb0f3ab08d297c034e9eae1b43","title":"受持续降雨天气影响 首都机场取消航班249架次","date":"2017-07-06 14:01","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170706140113960.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706140113_438dd22b626230a8f528d35055ad1839_1_mwpm_03200403.jpeg"},{"uniquekey":"b49e0571763c1cbe8002e4abe3f29ca1","title":"创纪录暴雨急袭 日本多地变身一片泽国","date":"2017-07-06 14:01","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706140112339.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706140112_1221e1cc63bbaf052c1487904be59ff1_9_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706140112_1221e1cc63bbaf052c1487904be59ff1_3_mwpm_03200403.png","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706140112_1221e1cc63bbaf052c1487904be59ff1_1_mwpm_03200403.jpeg"},{"uniquekey":"5d81a019368317888674e930469905ea","title":"男子河中钓鱼突显前方异动，上前查看后吓得连忙扭头跑开","date":"2017-07-06 13:54","category":"头条","author_name":"星闻扒客","url":"http://mini.eastday.com/mobile/170706135413068.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706_28e0a31aabc80a337aa2e3e5b5190d80_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170706/20170706_ada046b6602947f571589f0822fc510d_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170706/20170706_59aa709827f67de8fd9a92d50e50d69b_cover_mwpm_03200403.jpeg"},{"uniquekey":"bc34aeab9898d6ceb3abb8a8fa7c67ca","title":"韩海军4架 \u201c野猫\u201d直升机正式投入实战部署","date":"2017-07-06 13:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706135059485.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706135059_773d36fd568738838c4adf2b0d306032_1_mwpm_03200403.jpeg"},{"uniquekey":"a07586c0c4dcc3508dd2045f7794f6d1","title":"好消息！那颗未入轨的卫星昨天成功定点了","date":"2017-07-06 13:44","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/170706134425974.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170706/20170706134425_499006e9e22769c4de79fe93560a7c87_1_mwpm_03200403.jpeg"},{"uniquekey":"988a5247737e6f5407237239c150d8ba","title":"独立日不安宁!美国庆假期枪击案频传 芝加哥15死86伤","date":"2017-07-06 13:40","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706134052807.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706134052_839f562d8ec810f0ab2b7efe190dd341_1_mwpm_03200403.jpeg"},{"uniquekey":"cd5640732868d1c1e4f0ac2ebf7c44ad","title":"安倍抵达比利时 将分别会晤北约秘书长和欧盟委员会主席","date":"2017-07-06 13:40","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706134052380.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170706/20170706134052_cf4fa6ea8c9304a0ebc5dc0fc6441dd1_1_mwpm_03200403.jpeg"},{"uniquekey":"e509f3bd5e1df312295346de38de4891","title":"制服有毒？！美国航空空姐爆料每次返工都生病","date":"2017-07-06 13:20","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706132035935.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706132035_f3302747b0ba07078bccf07e84b1eb4d_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170706/20170706132035_f3302747b0ba07078bccf07e84b1eb4d_1_mwpm_03200403.jpeg"},{"uniquekey":"6a7cd9c923d95d2a849d3b4c7a744739","title":"健身教练推荐最快瘦肚子的方法","date":"2017-07-06 13:18","category":"头条","author_name":"春阳白雪","url":"http://mini.eastday.com/mobile/170706131806884.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170706/20170706131806_cb62dd19dfbabc4fc98b3e3d0445c92e_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170706/20170706131806_cb62dd19dfbabc4fc98b3e3d0445c92e_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20170706/20170706131806_cb62dd19dfbabc4fc98b3e3d0445c92e_2_mwpm_03200403.jpeg"},{"uniquekey":"59b76d99e814ae52723c7bdee8134192","title":"茄子别再红烧了，换种新做法，简单好吃还不油腻，一盘根本不够吃","date":"2017-07-06 13:07","category":"头条","author_name":"美食谈","url":"http://mini.eastday.com/mobile/170706130701946.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170706/20170706_f43abac6357da45ace7a3163ff77bce7_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170706/20170706_907f4f33c797184fe7c223ce6ac96043_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170706/20170706_55c98051e800319db1d2724416ff7278_cover_mwpm_03200403.jpeg"},{"uniquekey":"a65148e4a6e8d1c07765952fe715491c","title":"半个月前发射异常的这颗卫星 已经成功进入预定轨道！","date":"2017-07-06 12:59","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706125942151.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170706/20170706125942_a6699ec8886647ef9016c25adf980ae6_1_mwpm_03200403.jpeg"},{"uniquekey":"5cbd4794fe22d6b76a279b4733150e08","title":"俄图95M使用新型巡航导弹打击叙境内IS目标","date":"2017-07-06 12:55","category":"头条","author_name":"环球时报-环球网(北京)","url":"http://mini.eastday.com/mobile/170706125551016.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170706/20170706125551_0f746515baf163b58ff5c0368aeb4e43_1_mwpm_03200403.jpg"},{"uniquekey":"cc10551f55edc9926663327e91c46614","title":"胡彦斌被套路节目现场宣称要结婚 马东搬出郑爽！","date":"2017-07-06 12:55","category":"头条","author_name":"新浪娱乐","url":"http://mini.eastday.com/mobile/170706125541337.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706125541_d8733237e5f24c2a50a91c6df4ecace2_6_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706125541_ee9dd7c5a156cb7d00d64ab4f5a2f54e_4_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706125541_f56c995360ed442a0bcd1bd332ee5f3d_8_mwpm_03200403.jpeg"},{"uniquekey":"03ed50e880cf980dba6ac4f6dbac722d","title":"浙江一吃货为口腹之欲深夜行窃 偷80斤小龙虾全吃完","date":"2017-07-06 12:55","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170706125534830.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706125534_934bb13c85f84b12fd2fa06cab05a31a_1_mwpm_03200403.jpeg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"840386691c1dad60a0cba5f1e0cceb7d","title":"还在生长发育阶段的小胖子，有没有必要减肥？丨剑眉专栏","date":"2017-07-06 20:25","category":"头条","author_name":"春雨医生","url":"http://mini.eastday.com/mobile/170706202528338.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_1_mwpm_03200403.jpeg"},{"uniquekey":"9521ab8db06cb5546ebef96a2dbb5750","title":"德国一儿童误带二战炸弹进入幼儿园 上演惊魂一幕","date":"2017-07-06 15:42","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706154253884.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706154253_c9a1731a3d56dafc551b141f8416a275_1_mwpm_03200403.jpeg"},{"uniquekey":"d5cb34e7742def47840e3674a5ebf2a3","title":"雪域高原上的健康守门人","date":"2017-07-06 15:26","category":"头条","author_name":"新华社","url":"http://mini.eastday.com/mobile/170706152605559.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170706/20170706152605_8b84ff1ee74312f2a8d26147c94ac838_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170706/20170706152605_8b84ff1ee74312f2a8d26147c94ac838_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170706/20170706152605_8b84ff1ee74312f2a8d26147c94ac838_1_mwpm_03200403.jpeg"},{"uniquekey":"fc4ce343f800fbb12f9f1eaf6618fdc9","title":"退休干部驾车冲撞学生致一死多伤被判死刑","date":"2017-07-06 15:23","category":"头条","author_name":"南阳市中级人民法院","url":"http://mini.eastday.com/mobile/170706152359272.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170706/20170706152359_bdf548b77872506b75c48585bf659b7d_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170706/20170706152359_bdf548b77872506b75c48585bf659b7d_1_mwpm_03200403.jpeg"},{"uniquekey":"988aae3822a602d0b437d1c32369606f","title":"俄媒：普京或将作为无党派候选人参加2018总统大选","date":"2017-07-06 15:22","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706152233191.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170706/20170706152233_37f8ea02a68e3284324c5206e69f02fd_1_mwpm_03200403.png"},{"uniquekey":"6251af680624155e5d3d8012bf3a2ac6","title":"李显龙家族争端或迎转机，弟弟妹妹发联合声明称愿意私下解决","date":"2017-07-06 15:11","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170706151156324.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706151156_fa50ff02384dc95b70c46e503c183c9b_1_mwpm_03200403.jpeg"},{"uniquekey":"180a361ff969e1f9b466c50da0948930","title":"京广高铁浏阳河隧道因浸水临时关闭，8台抽水泵正不间断抽水","date":"2017-07-06 15:06","category":"头条","author_name":"央视网","url":"http://mini.eastday.com/mobile/170706150640370.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706150640_913a7d36468bb96b8b28965911898186_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170706/20170706150640_913a7d36468bb96b8b28965911898186_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170706/20170706150640_913a7d36468bb96b8b28965911898186_3_mwpm_03200403.jpeg"},{"uniquekey":"18e8dc78334740a5c5995884ea8c2af1","title":"7月份运气好到爆的三大生肖！","date":"2017-07-06 14:54","category":"头条","author_name":"暴走星座","url":"http://mini.eastday.com/mobile/170706145433482.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706_cbf930e3639c4abea8dcdd77960dac95_cover_mwpm_03200403.jpeg"},{"uniquekey":"bf7511feaf5c78dc3cfbd2738af98bf6","title":"一直保持天真和童心的星座，有你吗？","date":"2017-07-06 14:49","category":"头条","author_name":"暴走星座","url":"http://mini.eastday.com/mobile/170706144903042.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170706/20170706_965ddd8e78cfe9d767f2dfb15bb4b1eb_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170706/20170706_f10925e913102306e43d23daf03736ed_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170706/20170706_8cf508e79d5b296e06ace518e40cd36c_mwpm_03200403.jpg"},{"uniquekey":"c064e38230083f36d952044fd83d1a8b","title":"什么叫做实战经验？俄战机1000公里外向叙发射新导弹","date":"2017-07-06 14:48","category":"头条","author_name":"华领天下","url":"http://mini.eastday.com/mobile/170706144848071.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706_f1ed0f11e4769d318a9b892c6defa900_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706_85025aa922f9911f6dd67d3626253634_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706_0a8124a9035c39f4054e4ba27b2b30d6_cover_mwpm_03200403.jpeg"},{"uniquekey":"22bea3caba0d3950561cfdb4877ef325","title":"中国电商巨头进军印尼 必须要翻这\u201c四座大山\u201d","date":"2017-07-06 14:31","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706143140332.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170706/20170706143140_d4ad5caa7c253b14c1c5a693d003535a_1_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170706/20170706143140_d4ad5caa7c253b14c1c5a693d003535a_2_mwpm_03200403.jpeg"},{"uniquekey":"0d7de0304dbb7764615d304018f9f116","title":"昭君出塞前曾被宠幸三天三夜?历史真相让人面红耳赤！","date":"2017-07-06 14:27","category":"头条","author_name":"历史任意聊","url":"http://mini.eastday.com/mobile/170706142729613.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706_351e5d5f240628a7a3db3c03831ff9b8_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170706/20170706_2cf64eea38fd7dd1f8bca099cc195084_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170706/20170706_35ec3009f91ff078d891c1560fd03b04_cover_mwpm_03200403.jpeg"},{"uniquekey":"e64e612fd267a8aa3efbdf9b34571cd7","title":"F-35飞行员傲慢谈击败T-50,说到歼20却怂了？","date":"2017-07-06 14:15","category":"头条","author_name":"军事在前沿","url":"http://mini.eastday.com/mobile/170706141507564.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706_acf99c91020ad7422c63d480ca3291f9_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706_2dc89baf1c08cf65dddfe975dd6fd0c4_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706_cafa224eb07157ffc1f51d9acad1b676_cover_mwpm_03200403.jpeg"},{"uniquekey":"c29b5383092e88417d349ca1f4a73bb0","title":"章莹颖案新内情曝光！如没被抓，他还会下手！","date":"2017-07-06 14:11","category":"头条","author_name":"环球网-这里是美国","url":"http://mini.eastday.com/mobile/170706141123375.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170706/20170706141123_b4fa935495372288e1d48a6ae856ce71_6_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170706/20170706141123_b4fa935495372288e1d48a6ae856ce71_2_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170706/20170706141123_b4fa935495372288e1d48a6ae856ce71_1_mwpm_03200403.jpeg"},{"uniquekey":"ab83553f5e939a9c6d88c85c9af6619f","title":"韩执政党党首：充分理解中方对\u201c萨德\u201d入韩的忧虑","date":"2017-07-06 14:11","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706141123310.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706141123_af5557a7d06ba02e5f2691413ef091dc_1_mwpm_03200403.jpeg"},{"uniquekey":"7240c8f75195303a9cad6cb2a9df70f5","title":"江苏，2016年3座城市跻身\u201c新一线\u201d！","date":"2017-07-06 14:04","category":"头条","author_name":"长三角新时空","url":"http://mini.eastday.com/mobile/170706140452298.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170706/20170706_257ead67cdc8c19768e496ff4f423af7_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170706/20170706_dadedf570d5f66926851c4e84265703d_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170706/20170706_9b897b5d63d270b6d00d6ff961416f24_cover_mwpm_03200403.jpeg"},{"uniquekey":"7fb528cb0f3ab08d297c034e9eae1b43","title":"受持续降雨天气影响 首都机场取消航班249架次","date":"2017-07-06 14:01","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170706140113960.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706140113_438dd22b626230a8f528d35055ad1839_1_mwpm_03200403.jpeg"},{"uniquekey":"b49e0571763c1cbe8002e4abe3f29ca1","title":"创纪录暴雨急袭 日本多地变身一片泽国","date":"2017-07-06 14:01","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706140112339.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706140112_1221e1cc63bbaf052c1487904be59ff1_9_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706140112_1221e1cc63bbaf052c1487904be59ff1_3_mwpm_03200403.png","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706140112_1221e1cc63bbaf052c1487904be59ff1_1_mwpm_03200403.jpeg"},{"uniquekey":"5d81a019368317888674e930469905ea","title":"男子河中钓鱼突显前方异动，上前查看后吓得连忙扭头跑开","date":"2017-07-06 13:54","category":"头条","author_name":"星闻扒客","url":"http://mini.eastday.com/mobile/170706135413068.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706_28e0a31aabc80a337aa2e3e5b5190d80_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170706/20170706_ada046b6602947f571589f0822fc510d_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170706/20170706_59aa709827f67de8fd9a92d50e50d69b_cover_mwpm_03200403.jpeg"},{"uniquekey":"bc34aeab9898d6ceb3abb8a8fa7c67ca","title":"韩海军4架 \u201c野猫\u201d直升机正式投入实战部署","date":"2017-07-06 13:50","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706135059485.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170706/20170706135059_773d36fd568738838c4adf2b0d306032_1_mwpm_03200403.jpeg"},{"uniquekey":"a07586c0c4dcc3508dd2045f7794f6d1","title":"好消息！那颗未入轨的卫星昨天成功定点了","date":"2017-07-06 13:44","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/170706134425974.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170706/20170706134425_499006e9e22769c4de79fe93560a7c87_1_mwpm_03200403.jpeg"},{"uniquekey":"988a5247737e6f5407237239c150d8ba","title":"独立日不安宁!美国庆假期枪击案频传 芝加哥15死86伤","date":"2017-07-06 13:40","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706134052807.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706134052_839f562d8ec810f0ab2b7efe190dd341_1_mwpm_03200403.jpeg"},{"uniquekey":"cd5640732868d1c1e4f0ac2ebf7c44ad","title":"安倍抵达比利时 将分别会晤北约秘书长和欧盟委员会主席","date":"2017-07-06 13:40","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706134052380.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170706/20170706134052_cf4fa6ea8c9304a0ebc5dc0fc6441dd1_1_mwpm_03200403.jpeg"},{"uniquekey":"e509f3bd5e1df312295346de38de4891","title":"制服有毒？！美国航空空姐爆料每次返工都生病","date":"2017-07-06 13:20","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706132035935.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170706/20170706132035_f3302747b0ba07078bccf07e84b1eb4d_2_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170706/20170706132035_f3302747b0ba07078bccf07e84b1eb4d_1_mwpm_03200403.jpeg"},{"uniquekey":"6a7cd9c923d95d2a849d3b4c7a744739","title":"健身教练推荐最快瘦肚子的方法","date":"2017-07-06 13:18","category":"头条","author_name":"春阳白雪","url":"http://mini.eastday.com/mobile/170706131806884.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170706/20170706131806_cb62dd19dfbabc4fc98b3e3d0445c92e_3_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20170706/20170706131806_cb62dd19dfbabc4fc98b3e3d0445c92e_1_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20170706/20170706131806_cb62dd19dfbabc4fc98b3e3d0445c92e_2_mwpm_03200403.jpeg"},{"uniquekey":"59b76d99e814ae52723c7bdee8134192","title":"茄子别再红烧了，换种新做法，简单好吃还不油腻，一盘根本不够吃","date":"2017-07-06 13:07","category":"头条","author_name":"美食谈","url":"http://mini.eastday.com/mobile/170706130701946.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170706/20170706_f43abac6357da45ace7a3163ff77bce7_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170706/20170706_907f4f33c797184fe7c223ce6ac96043_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170706/20170706_55c98051e800319db1d2724416ff7278_cover_mwpm_03200403.jpeg"},{"uniquekey":"a65148e4a6e8d1c07765952fe715491c","title":"半个月前发射异常的这颗卫星 已经成功进入预定轨道！","date":"2017-07-06 12:59","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170706125942151.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170706/20170706125942_a6699ec8886647ef9016c25adf980ae6_1_mwpm_03200403.jpeg"},{"uniquekey":"5cbd4794fe22d6b76a279b4733150e08","title":"俄图95M使用新型巡航导弹打击叙境内IS目标","date":"2017-07-06 12:55","category":"头条","author_name":"环球时报-环球网(北京)","url":"http://mini.eastday.com/mobile/170706125551016.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170706/20170706125551_0f746515baf163b58ff5c0368aeb4e43_1_mwpm_03200403.jpg"},{"uniquekey":"cc10551f55edc9926663327e91c46614","title":"胡彦斌被套路节目现场宣称要结婚 马东搬出郑爽！","date":"2017-07-06 12:55","category":"头条","author_name":"新浪娱乐","url":"http://mini.eastday.com/mobile/170706125541337.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706125541_d8733237e5f24c2a50a91c6df4ecace2_6_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20170706/20170706125541_ee9dd7c5a156cb7d00d64ab4f5a2f54e_4_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20170706/20170706125541_f56c995360ed442a0bcd1bd332ee5f3d_8_mwpm_03200403.jpeg"},{"uniquekey":"03ed50e880cf980dba6ac4f6dbac722d","title":"浙江一吃货为口腹之欲深夜行窃 偷80斤小龙虾全吃完","date":"2017-07-06 12:55","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170706125534830.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170706/20170706125534_934bb13c85f84b12fd2fa06cab05a31a_1_mwpm_03200403.jpeg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : 840386691c1dad60a0cba5f1e0cceb7d
             * title : 还在生长发育阶段的小胖子，有没有必要减肥？丨剑眉专栏
             * date : 2017-07-06 20:25
             * category : 头条
             * author_name : 春雨医生
             * url : http://mini.eastday.com/mobile/170706202528338.html
             * thumbnail_pic_s : http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_3_mwpm_03200403.jpeg
             * thumbnail_pic_s02 : http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_2_mwpm_03200403.jpeg
             * thumbnail_pic_s03 : http://04.imgmini.eastday.com/mobile/20170706/20170706202528_9d4fd118a0f1567314611f39c6757bb5_1_mwpm_03200403.jpeg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}
