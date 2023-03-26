package com.tengizmkcorp.ibsu_mobile_homework3.model;

import com.tengizmkcorp.ibsu_mobile_homework3.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoryItem {
    Integer image;
    Boolean alreadyViewed;
    String title;

    public StoryItem(Integer image, Boolean alreadyViewed, String title) {
        this.image = image;
        this.alreadyViewed = alreadyViewed;
        this.title = title;
    }

    public Integer getImage() {
        return image;
    }

    public Boolean getAlreadyViewed() {
        return alreadyViewed;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoryItem)) return false;
        StoryItem storyItem = (StoryItem) o;
        return image.equals(storyItem.image) && alreadyViewed.equals(storyItem.alreadyViewed) && title.equals(storyItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, alreadyViewed, title);
    }

    @Override
    public String toString() {
        return "StoryItem{" +
                "image=" + image +
                ", alreadyViewed=" + alreadyViewed +
                ", title='" + title + '\'' +
                '}';
    }
    public static List<StoryItem> storyList = new ArrayList<StoryItem>();
}

