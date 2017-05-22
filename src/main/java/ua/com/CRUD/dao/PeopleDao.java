package ua.com.CRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.enity.People;

public interface PeopleDao extends JpaRepository<People, Integer> {

}
