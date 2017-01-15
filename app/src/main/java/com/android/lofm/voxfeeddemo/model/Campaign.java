package com.android.lofm.voxfeeddemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Campaign implements Parcelable {

    public static final Creator<Campaign> CREATOR = new Creator<Campaign>() {

        @Override
        public Campaign createFromParcel(Parcel in) {
            return new Campaign(in);
        }

        @Override
        public Campaign[] newArray(int size) {
            return new Campaign[size];
        }
    };
    private String name;
    private String coverImage;

    protected Campaign(Parcel in) {
        name = in.readString();
        coverImage = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(coverImage);
    }
}
