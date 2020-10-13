package com.heron.lee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heron.lee.model.Profile;
import com.heron.lee.repository.ProfileRepository;

/**
 * Created by heron.lee 2020/10/13
 */
@RestController
@RequestMapping("/mysql")
public class MysqlController {

    private ProfileRepository profileRepository;

    public MysqlController (ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById (@PathVariable int id) {
        Profile profile = profileRepository.findById(id).get();
        return ResponseEntity.ok(profile);
    }
}
