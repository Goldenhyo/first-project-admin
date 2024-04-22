package com.jpa4.pj1984.repository;

import com.jpa4.pj1984.domain.Store;
import com.jpa4.pj1984.dto.PageRequestDTO;

import java.util.List;

public interface StoreCustomRepository {
    List<Store> findStoreListByStoreId(Long storeId, PageRequestDTO pageRequestDTO);

    Long countStoreListByStoreId(Long storeId, PageRequestDTO pageRequestDTO);

    String searchTypeMethod(PageRequestDTO pageRequestDTO);

    PageRequestDTO bindingMethod(PageRequestDTO pageRequestDTO);

}
