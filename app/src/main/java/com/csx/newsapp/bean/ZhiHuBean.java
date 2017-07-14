package com.csx.newsapp.bean;

import java.util.List;

/**
 * Created by cuishuxiang on 2017/7/12.
 *
 * 知乎bean
 */

public class ZhiHuBean {


    /**
     * date : 20170712
     * stories : [{"images":["https://pic1.zhimg.com/v2-9d239afffb90b791df98b9dc15c29fb4.jpg"],"type":0,"id":9517436,"ga_prefix":"071219","title":"这些最棒的中国科幻小说，没有改编成游戏真是太可惜"},{"images":["https://pic3.zhimg.com/v2-8140d71b2e23eabc1f8ed4c39a84bea6.jpg"],"type":0,"id":9520494,"ga_prefix":"071218","title":"都让开，这只动物要出门去光合作用了"},{"images":["https://pic2.zhimg.com/v2-c04b501f1585a161d78c2061a34c1405.jpg"],"type":0,"id":9520658,"ga_prefix":"071217","title":"- 林清玄先生您觉得台湾什么最好吃？\r\n- 馒头"},{"images":["https://pic3.zhimg.com/v2-bf47c2f5f7b3f05e3f878e6d7ae3aefe.jpg"],"type":0,"id":9517326,"ga_prefix":"071216","title":"去美国留学，如何注意人身安全？听听待过美国的人怎么说"},{"images":["https://pic4.zhimg.com/v2-cd90e687f05e5f8f38824d6cf14aa65f.jpg"],"type":0,"id":9520745,"ga_prefix":"071215","title":"有些建筑就像美人，时尚换了一轮又一轮它却惊艳千年"},{"images":["https://pic3.zhimg.com/v2-384902994f2c69080c66b7af892acb06.jpg"],"type":0,"id":9518440,"ga_prefix":"071214","title":"我是谁？我在哪？我要干什么\u2026\u2026没了地图的无人车，差不多就这状态"},{"images":["https://pic3.zhimg.com/v2-c2e0858a0e43c12a1eee845e4425fde2.jpg"],"type":0,"id":9519727,"ga_prefix":"071213","title":"我上大学没干别的，专门研究茶"},{"images":["https://pic3.zhimg.com/v2-3ebd02b5e04854aaa2cc5b6f4585fdce.jpg"],"type":0,"id":9520457,"ga_prefix":"071212","title":"简历中写自我评价时该怎么「吹捧自己」才最有效？"},{"images":["https://pic3.zhimg.com/v2-6d101d34e45f680a66c5392735c36f32.jpg"],"type":0,"id":9520305,"ga_prefix":"071212","title":"大误 · 当游戏角色开始有了意识\u2026\u2026"},{"images":["https://pic1.zhimg.com/v2-429db57db0996d2b53ee2a5ab027b068.jpg"],"type":0,"id":9519246,"ga_prefix":"071210","title":"净利润只有 29 亿的企业拿出 1000 亿去囤地，这是怎样的精神？"},{"images":["https://pic4.zhimg.com/v2-c9b64eb8c96fc5f2711d1046cde2d08b.jpg"],"type":0,"id":9519093,"ga_prefix":"071209","title":"都在搞算法，为什么苹果却越来越强调人工推荐音乐和 app？"},{"images":["https://pic4.zhimg.com/v2-cdf5950bc9f376d33d97d6ec1ad45fef.jpg"],"type":0,"id":9477470,"ga_prefix":"071208","title":"输血时错了血型会发生什么？"},{"title":"这些世界各地的涂鸦墙，告诉你生活的边界在何处","ga_prefix":"071207","images":["https://pic4.zhimg.com/v2-74c4e20b53bb19e0b1bf1da7ee1f2ba7.jpg"],"multipic":true,"type":0,"id":9519386},{"images":["https://pic2.zhimg.com/v2-8e65fcab1d2106a8bc25c8bda84ef681.jpg"],"type":0,"id":9518567,"ga_prefix":"071207","title":"暴走团马路晨练被撞 1 死 2 伤，肇事司机真的冤吗？"},{"images":["https://pic4.zhimg.com/v2-b225bb4212d8bd23db013798db2df70b.jpg"],"type":0,"id":9519781,"ga_prefix":"071207","title":"一颗国产卫星被遗落半路，前几天终于吭哧吭哧爬上了轨道"},{"images":["https://pic2.zhimg.com/v2-34b6b4681160bc9c125498f4a8d7a901.jpg"],"type":0,"id":9516916,"ga_prefix":"071206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-d30622e20035dc8e95c2657dbdfd31e9.jpg","type":0,"id":9520745,"ga_prefix":"071215","title":"有些建筑就像美人，时尚换了一轮又一轮它却惊艳千年"},{"image":"https://pic4.zhimg.com/v2-0aa406fedda5d6973509267f9e96aa27.jpg","type":0,"id":9520658,"ga_prefix":"071217","title":"- 林清玄先生您觉得台湾什么最好吃？\r\n- 馒头"},{"image":"https://pic4.zhimg.com/v2-b1a068e33a7f31918e37c497f3b9bc87.jpg","type":0,"id":9519781,"ga_prefix":"071207","title":"一颗国产卫星被遗落半路，前几天终于吭哧吭哧爬上了轨道"},{"image":"https://pic2.zhimg.com/v2-74ac8c059f0c6588ba0b3afcee79cef1.jpg","type":0,"id":9518567,"ga_prefix":"071207","title":"暴走团马路晨练被撞 1 死 2 伤，肇事司机真的冤吗？"},{"image":"https://pic3.zhimg.com/v2-8744a7bad1caa2815009e9a9dd45d2f2.jpg","type":0,"id":9519246,"ga_prefix":"071210","title":"净利润只有 29 亿的企业拿出 1000 亿去囤地，这是怎样的精神？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-9d239afffb90b791df98b9dc15c29fb4.jpg"]
         * type : 0
         * id : 9517436
         * ga_prefix : 071219
         * title : 这些最棒的中国科幻小说，没有改编成游戏真是太可惜
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic2.zhimg.com/v2-d30622e20035dc8e95c2657dbdfd31e9.jpg
         * type : 0
         * id : 9520745
         * ga_prefix : 071215
         * title : 有些建筑就像美人，时尚换了一轮又一轮它却惊艳千年
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
