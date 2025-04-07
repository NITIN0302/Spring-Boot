package com.example.Challange;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengesController {
    private ChallengeServices challengeServices;

    public ChallengesController(ChallengeServices challengeServices){
        this.challengeServices = challengeServices;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenge() {
        return new ResponseEntity<>(challengeServices.getAllChallenge(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> addChallenges(@RequestBody Challenge challenge) {
        return new ResponseEntity<>(challengeServices.addChallenges(challenge),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> modifyChallenge(@PathVariable Long id,@RequestBody Challenge challenge){
        return new ResponseEntity<>(challengeServices.modifyChallenge(id,challenge),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteChallenge(@PathVariable Long id){
        return new ResponseEntity<>(challengeServices.deleteChallenge(id),HttpStatus.OK);
    }

}
