package com.sfhuskie.mediamanager.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sfhuskie.mediamanager.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User,Long> {

}
