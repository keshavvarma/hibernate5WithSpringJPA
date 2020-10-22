/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.ManyToManyMapping.model.Book;

/**
 * @author Keshav
 *
 */

public interface BookRepository extends JpaRepository<Book, Long>{

}
