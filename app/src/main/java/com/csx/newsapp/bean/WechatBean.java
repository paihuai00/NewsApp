package com.csx.newsapp.bean;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/1.
 */

public class WechatBean {


    /**
     * reason : 请求成功
     * result : {"list":[{"id":"wechat_20170701016744","title":"王培军：更事后读书","source":"文汇笔会","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261204.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016744"},{"id":"wechat_20170701016828","title":"看展 | 归思\u2014\u2014悠闲赏石慢生活","source":"葳蕤的石空","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261292.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016828"},{"id":"wechat_20170701017606","title":"素手画心，一个在香港飘零的传奇","source":"山河小岁月","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261790.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017606"},{"id":"wechat_20170701017964","title":"香港回归20年，你可知它名字的来历？","source":"自在文玩","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29262772.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017964"},{"id":"wechat_20170701017902","title":"细思极恐，缅甸人都是卖翡翠而不收藏？","source":"自在文玩","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29262598.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017902"},{"id":"wechat_20170701017614","title":"9张能改变你一生的漫画丨可读","source":"中国经济网","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29260360.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017614"},{"id":"wechat_20170701017935","title":"泰国4分35秒广告《努力一点点》拍的太感人了！","source":"健美健身联盟","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29262657.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017935"},{"id":"wechat_20170701017496","title":"阿Sa新恋情曝光？ 网友：女神要幸福久久！","source":"深夜八卦","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261675.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017496"},{"id":"wechat_20170701016738","title":"谁说学霸都是\u201c土肥圆\u201d，这几个高考状元的颜值，能让你怀疑人生！","source":"留宿","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261153.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016738"},{"id":"wechat_20170701016789","title":"优衣库镂空门！八字乳女主角LILY照片曝光","source":"飞鹏网","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-28246448.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016789"}],"totalPage":9694,"ps":10,"pno":1}
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
         * list : [{"id":"wechat_20170701016744","title":"王培军：更事后读书","source":"文汇笔会","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261204.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016744"},{"id":"wechat_20170701016828","title":"看展 | 归思\u2014\u2014悠闲赏石慢生活","source":"葳蕤的石空","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261292.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016828"},{"id":"wechat_20170701017606","title":"素手画心，一个在香港飘零的传奇","source":"山河小岁月","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261790.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017606"},{"id":"wechat_20170701017964","title":"香港回归20年，你可知它名字的来历？","source":"自在文玩","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29262772.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017964"},{"id":"wechat_20170701017902","title":"细思极恐，缅甸人都是卖翡翠而不收藏？","source":"自在文玩","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29262598.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017902"},{"id":"wechat_20170701017614","title":"9张能改变你一生的漫画丨可读","source":"中国经济网","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29260360.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017614"},{"id":"wechat_20170701017935","title":"泰国4分35秒广告《努力一点点》拍的太感人了！","source":"健美健身联盟","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29262657.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017935"},{"id":"wechat_20170701017496","title":"阿Sa新恋情曝光？ 网友：女神要幸福久久！","source":"深夜八卦","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261675.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701017496"},{"id":"wechat_20170701016738","title":"谁说学霸都是\u201c土肥圆\u201d，这几个高考状元的颜值，能让你怀疑人生！","source":"留宿","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261153.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016738"},{"id":"wechat_20170701016789","title":"优衣库镂空门！八字乳女主角LILY照片曝光","source":"飞鹏网","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-28246448.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016789"}]
         * totalPage : 9694
         * ps : 10
         * pno : 1
         */

        private int totalPage;
        private int ps;
        private int pno;
        private List<ListBean> list;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }

        public int getPno() {
            return pno;
        }

        public void setPno(int pno) {
            this.pno = pno;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : wechat_20170701016744
             * title : 王培军：更事后读书
             * source : 文汇笔会
             * firstImg : http://zxpic.gtimg.com/infonew/0/wechat_pics_-29261204.jpg/640
             * mark :
             * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20170701016744
             */

            private String id;
            private String title;
            private String source;
            private String firstImg;
            private String mark;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getFirstImg() {
                return firstImg;
            }

            public void setFirstImg(String firstImg) {
                this.firstImg = firstImg;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
