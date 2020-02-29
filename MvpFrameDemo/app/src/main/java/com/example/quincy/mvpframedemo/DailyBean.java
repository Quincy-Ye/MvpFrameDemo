package com.example.quincy.mvpframedemo;

import java.util.List;

/**
 * @author Quincy
 * @Date 2020/2/17
 * @Description
 */

public class DailyBean {
    private String date;
    private List<StoriesBean> stories;

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

    public static class StoriesBean {
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
}
