package com.example.Challange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeServices {

    @Autowired
    public UserRepository userRepository;

    public List<Challenge> getAllChallenge() {
        return userRepository.findAll();
    }

    public boolean addChallenges(Challenge challenge) {
        if (challenge != null) {
            userRepository.save(challenge);
            return true;
        }
        return false;
    }

    public boolean modifyChallenge(Long id,Challenge challenge){
        List<Challenge> Challenges = userRepository.findAll();
        for(Challenge curr:Challenges){
            if(curr.getId().equals(id)){
                curr.setDesc(challenge.getDesc());
                curr.setMonth(challenge.getMonth());
                userRepository.save(curr);
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id){
        userRepository.deleteById(id);
        return true;
    }
}
