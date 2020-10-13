package com.heron.lee.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heron.lee.model.Profile;
import com.heron.lee.repository.ProfileRepository;

/**
 * Created by heron.lee 2020/10/13
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ProfileRepository profileRepository;

    public ProfileController (ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getProfileList () {
        List<Profile> profileList = StreamSupport.stream(profileRepository.findAll()
                                                                          .spliterator(), false)
                                                 .collect(Collectors.toList());
        return ResponseEntity.ok(profileList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById (@PathVariable int id) {
        Profile profile = profileRepository.findById(id).orElse(null);
        return ResponseEntity.ok(profile);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile (@RequestBody Profile requestBody) {
        Profile profile = profileRepository.save(requestBody);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile (@PathVariable int id,
                                                  @RequestBody Profile requestBody) {
        Profile profile = profileRepository.findById(id)
                                           .orElseThrow();
        profile.setNickname(requestBody.getNickname());
        return ResponseEntity.ok(profile);
    }
}
