package com.yilinker.core.model.seller;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bryan on 9/17/2015.
 */
public class ResolutionCenterProducts implements Parcelable {

    private String orderProductId;
    private int productId;
    private String productName;
    private String productImage;
    private boolean isChecked;
    public ResolutionCenterProducts(com.yilinker.core.model.TransactionDetailsBuyer.Products products){
        this.productId = products.getProductId();
        this.productName = products.getProductName();
        this.productImage = products.getProductImage();
    }


    public ResolutionCenterProducts(com.yilinker.core.model.seller.CategoryProducts products) {
        this.productId = products.getProductId();
        this.productName = products.getProductName();
        this.productImage = products.getImage();
    }
    public String getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.orderProductId);
        dest.writeInt(this.productId);
        dest.writeString(this.productName);
        dest.writeString(this.productImage);
        dest.writeByte(isChecked ? (byte) 1 : (byte) 0);
    }

    protected ResolutionCenterProducts(Parcel in) {
        this.orderProductId = in.readString();
        this.productId = in.readInt();
        this.productName = in.readString();
        this.productImage = in.readString();
        this.isChecked = in.readByte() != 0;
    }

    public static final Creator<ResolutionCenterProducts> CREATOR = new Creator<ResolutionCenterProducts>() {
        public ResolutionCenterProducts createFromParcel(Parcel source) {
            return new ResolutionCenterProducts(source);
        }

        public ResolutionCenterProducts[] newArray(int size) {
            return new ResolutionCenterProducts[size];
        }
    };
}
