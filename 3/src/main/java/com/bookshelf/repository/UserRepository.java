package com.bookshelf.repository;

import com.bookshelf.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * UserRepository provides basic operations for searching, saving and deleting data
 */
@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
