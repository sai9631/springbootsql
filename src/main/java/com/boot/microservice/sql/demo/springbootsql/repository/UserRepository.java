package com.boot.microservice.sql.demo.springbootsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.microservice.sql.demo.springbootsql.model.User;


public interface UserRepository extends JpaRepository<User, String> {

}
