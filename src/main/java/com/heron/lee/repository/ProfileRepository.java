package com.heron.lee.repository;

import org.springframework.data.repository.CrudRepository;

import com.heron.lee.model.Profile;

/**
 * Created by heron.lee 2020/10/13
 */
public interface ProfileRepository extends CrudRepository<Profile, Integer> {
}
