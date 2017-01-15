package com.android.lofm.voxfeeddemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {

    private String text;
    private String image;
    private String link;

    protected Post(Parcel in) {
        text = in.readString();
        image = in.readString();
        link = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {

        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(image);
        dest.writeString(link);
    }
}
