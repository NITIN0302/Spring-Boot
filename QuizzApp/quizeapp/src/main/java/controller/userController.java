package controller;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import repository.userRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:5173/")
public class userController {
    @Autowired
    private userRepository userRepository;

    @PostMapping("/addQuestion")
    Question newUser(@RequestBody Question newQuestion) {
        return userRepository.save(newQuestion);
    }


}
