package com.sec.hidinner.bills;

public class OrderBean {
    private String photo;
    private String name;
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    public String getBonus() {
        return bonus;
    }
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    private String distance;
    private String bonus;
    private String last;
    private String fromTo;
    public String getFromTo() {
        return fromTo;
    }
    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

}
