package com.jpa4.pj1984.dto;


import com.jpa4.pj1984.domain.Store;
import com.jpa4.pj1984.domain.StoreStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class StoreForm {
    private Long storeId;
    private String storeTitle;
    private String storeOwner;
    private String storeCrn;
    private String storeText;
    private Long storePhoneNum;
    private String storeImageName;
    private String storeImageId;
    private String storeInsideImageName01;
    private String storeInsideImageId01;
    private String storeInsideImageName02;
    private String storeInsideImageId02;
    private String storeInsideImageName03;
    private String storeInsideImageId03;
    private String storeAddress;
    private String storeOneReview;
    private String storeReview;
    private StoreStatus storeStatus;
    private String storeOperateTime;
    private String storeTag;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;
    private String storeBankName;
    private String storeAccount;

    // Form -> Entity
    public Store toEntity() {
        Store store = new Store();
        store.setStoreId(storeId);
        store.setStoreTitle(storeTitle);
        store.setStoreOwner(storeOwner);
        store.setStoreCrn(storeCrn);
        store.setStoreText(storeText );
        store.setStorePhoneNum(storePhoneNum);
        store.setStoreImageName(storeImageName);
        store.setStoreImageId(storeImageId);
        store.setStoreInsideImageName01(storeInsideImageName01);
        store.setStoreInsideImageId01(storeInsideImageId01);
        store.setStoreInsideImageName02(storeInsideImageName02);
        store.setStoreInsideImageId02(storeInsideImageId02);
        store.setStoreInsideImageName03(storeInsideImageName03);
        store.setStoreInsideImageId03(storeInsideImageId03);
        store.setStoreAddress(storeAddress);
        store.setStoreOneReview(storeOneReview);
        store.setStoreReview(storeReview);
        store.setStoreStatus(storeStatus);
        store.setStoreOperateTime(storeOperateTime);
        store.setStoreTag(storeTag);
        store.setStoreBankName(storeBankName);
        store.setStoreAccount(storeAccount);
        return store;
    }

}