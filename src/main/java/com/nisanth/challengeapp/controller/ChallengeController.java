package com.nisanth.challengeapp.controller;

import com.nisanth.challengeapp.entity.Challenge;
import com.nisanth.challengeapp.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }



    @GetMapping
    public List<Challenge> getAllChallenges()
    {
        return challengeService.getAllChallenges();

    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month)
    {
        Challenge challenge=challengeService.getChallenge(month);
        if(challenge!=null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(challenge, HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge)
    {
       boolean isChallendgeAdded=challengeService.addChallenges(challenge);
       if(isChallendgeAdded)
       {
           return new ResponseEntity<>("Challenge added Successfully",HttpStatus.OK);
       }
       else {
           return new ResponseEntity<>("Challenge not Added Correctly",HttpStatus.NOT_FOUND);
       }


    }



    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updateChallenge)
    {
       boolean isChallengeUpdated= challengeService.updateChallenge(id,updateChallenge);
        if(isChallengeUpdated)
        {
            return new ResponseEntity<>("Challenge updated Successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Challenge not upadted Correctly",HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id)
    {
        boolean isChallengeDeleted=challengeService.deleteChallenge(id);
        if(isChallengeDeleted)
        {
            return new ResponseEntity<>("Challenge deleted Successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Challenge not delted Correctly",HttpStatus.NOT_FOUND);
        }

    }
}
