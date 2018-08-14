package com.example.administrator.jinglinglgp.Bean;

/**
 * Created by Administrator on 2017/7/2.
 */

public class ChongZhiInfo {
    private String youhui;
    private double youhuizhi;
    private String name;
    private int image;
    private String content;
    private double price;
    private String priceStr;

    public ChongZhiInfo() {
    }

    public String getYouhui() {
        return youhui;
    }

    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }

    public double getYouhuizhi() {
        return youhuizhi;
    }

    public void setYouhuizhi(double youhuizhi) {
        this.youhuizhi = youhuizhi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    @Override
    public String toString() {
        return "ChongZhiInfo{" +
                "youhui='" + youhui + '\'' +
                ", youhuizhi=" + youhuizhi +
                ", name='" + name + '\'' +
                ", image=" + image +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", priceStr='" + priceStr + '\'' +
                '}';
    }
}
