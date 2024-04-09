package com.jpa4.pj1984.dto;

import com.jpa4.pj1984.domain.Member;
import com.jpa4.pj1984.domain.StoreReview;
import com.jpa4.pj1984.domain.StoreReviewStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreReviewForm { // 뿌려주는

    private Long storeReviewId;
    private Member member;
    private String storeReviewDetail;
    private StoreReviewStatus storeReviewStatus;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;

    // DTO -> Entity
    public StoreReview toEntity() {
        StoreReview storeReview = new StoreReview();
        storeReview.setStoreReviewId(storeReviewId);
        storeReview.setMember(member);
        storeReview.setStoreReviewDetail(storeReviewDetail);
        storeReview.setStoreReviewStatus(storeReviewStatus);
        return storeReview;
    }

}

