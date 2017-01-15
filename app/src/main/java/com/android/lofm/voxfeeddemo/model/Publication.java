package com.android.lofm.voxfeeddemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Publication implements Parcelable {

    public static final Creator<Publication> CREATOR = new Creator<Publication>() {

        @Override
        public Publication createFromParcel(Parcel in) {
            return new Publication(in);
        }

        @Override
        public Publication[] newArray(int size) {
            return new Publication[size];
        }
    };
    private String id;
    private String date;
    private String socialNetwork;
    private User user;
    private Campaign campaign;
    private Brand brand;
    private Post post;
    private Stats stats;
    private double earnings;

    protected Publication(Parcel in) {
        id = in.readString();
        date = in.readString();
        socialNetwork = in.readString();
        user = (User) in.readValue(User.class.getClassLoader());
        campaign = (Campaign) in.readValue(Campaign.class.getClassLoader());
        brand = (Brand) in.readValue(Brand.class.getClassLoader());
        post = (Post) in.readValue(Post.class.getClassLoader());
        stats = (Stats) in.readValue(Stats.class.getClassLoader());
        campaign = (Campaign) in.readValue(Campaign.class.getClassLoader());
        earnings = in.readDouble();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(date);
        dest.writeString(socialNetwork);
    }

}
