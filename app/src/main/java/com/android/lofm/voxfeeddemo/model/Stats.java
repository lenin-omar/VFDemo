package com.android.lofm.voxfeeddemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {

    private int clicks;
    private int shares;
    private int likes;
    private int comments;
    private int audience;

    protected Stats(Parcel in) {
        clicks = in.readInt();
        shares = in.readInt();
        likes = in.readInt();
        comments = in.readInt();
        audience = in.readInt();
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {

        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(clicks);
        dest.writeInt(shares);
        dest.writeInt(likes);
        dest.writeInt(comments);
        dest.writeInt(audience);
    }
}
