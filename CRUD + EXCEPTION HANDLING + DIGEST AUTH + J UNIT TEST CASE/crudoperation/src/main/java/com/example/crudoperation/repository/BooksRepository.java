package com.example.crudoperation.repository;

import com.example.crudoperation.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

//repository that extends CrudRepository
public interface BooksRepository extends JpaRepository<Books, Integer> {


}