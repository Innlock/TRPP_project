package com.example.demo.repository;

import com.example.demo.model.Advert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Метод markAsSold отмечает, что объявление более недействительно (статус - sold)
 */
@Repository
@Transactional
public interface AdvertRepository extends PagingAndSortingRepository<Advert, Long> {
    @Modifying
    @Query("UPDATE Advert t SET t.state = \'sold\' WHERE t.id =:id")
    void markAsSold(@Param("id") Long id);
}
