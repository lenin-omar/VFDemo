package com.android.lofm.voxfeeddemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Brand implements Parcelable {

    public static final Creator<Brand> CREATOR = new Creator<Brand>() {

        @Override
        public Brand createFromParcel(Parcel in) {
            return new Brand(in);
        }

        @Override
        public Brand[] newArray(int size) {
            return new Brand[size];
        }
    };
    private String name;
    private String logo;

    protected Brand(Parcel in) {
        name = in.readString();
        logo = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(logo);
    }
}
