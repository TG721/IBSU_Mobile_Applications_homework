package com.tengizmkcorp.ibsu_mobile_homework3.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TopUserButton {
    private String title;
    private Boolean blueBackground;
    private Boolean bold;
    private Boolean imageButton;
    private Integer image;

    public String getTitle() {
        return title;
    }

    public Boolean getBlueBackground() {
        return blueBackground;
    }

    public Boolean getBold() {
        return bold;
    }

    public Boolean getImageButton() {
        return imageButton;
    }

    public Integer getImage() {
        return image;
    }

    public TopUserButton(String title, Boolean blueBackground, Boolean bold, Boolean imageButton, Integer image) {
        this.title = title;
        this.blueBackground = blueBackground;
        this.bold = bold;
        this.imageButton = imageButton;
        this.image = image;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopUserButton that = (TopUserButton) o;
        return title.equals(that.title) && blueBackground.equals(that.blueBackground) && bold.equals(that.bold) && imageButton.equals(that.imageButton) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, blueBackground, bold, imageButton);
    }

    @NonNull
    @Override
    public String toString() {
        return "TopUserButton{" +
                "title='" + title + '\'' +
                '}';
    }
public static List<TopUserButton> topUserButtonList = new ArrayList<TopUserButton>();
};
