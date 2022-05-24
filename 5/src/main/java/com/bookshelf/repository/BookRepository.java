package com.bookshelf.repository;
import com.bookshelf.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/**
 * BookRepository provides basic operations for searching, saving and deleting data
 */
@Repository
@Transactional
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
