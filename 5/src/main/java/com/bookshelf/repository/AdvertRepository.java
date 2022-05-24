package com.bookshelf.repository;

import com.bookshelf.model.Advert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * AdvertRepository provides basic operations for searching, saving and deleting data
 */
@Repository
@Transactional
public interface AdvertRepository extends PagingAndSortingRepository<Advert, Long> {
    /**
     * markAsSold makes 'state' in advert 'sold'
     * @param id id specified in the link
     */
    @Modifying
    @Query("UPDATE Advert t SET t.state = \'sold\' WHERE t.id =:id")
    void markAsSold(@Param("id") Long id);
}
