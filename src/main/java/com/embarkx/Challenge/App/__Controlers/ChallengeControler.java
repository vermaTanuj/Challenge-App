package com.embarkx.Challenge.App.__Controlers;

import com.embarkx.Challenge.App.__Entity.ChallengeEntity;
import com.embarkx.Challenge.App.__Services.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/challengessss")
public class ChallengeControler {

    @Autowired
  private ChallengeService challengeService;




    @GetMapping                //localhost:8080/challenges
    public ResponseEntity<List<ChallengeEntity>> getAllChallenges(){
        System.out.println("entered into =  getAll");
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    @PostMapping              //localhost:8080/challenges
    public ResponseEntity<String> addChallenges(@RequestBody ChallengeEntity entity ){
        System.out.println("entered into =  create");
      boolean b=  challengeService.addChallenges(entity);
      if(b==true){
          return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
      }else{
          return new ResponseEntity<>(" \"Challenge  NOT   added \"",HttpStatus.NOT_FOUND);
      }
    }


    //Adding a List at end:-
    @PutMapping("/addList")                //localhost:8080/challenges/addlist
    private String addList(@RequestBody  List<ChallengeEntity> list2){
        return    challengeService.addList(list2);
    }


    //Find by id:-

    @GetMapping("/{month}")                    //localhost:8080/challenges/{month}
    public ResponseEntity<ChallengeEntity>  getChallengesByMonth(@PathVariable String month){
        System.out.println("entered into =  FindBy___Month");
        ChallengeEntity challenge=   challengeService.getChallengesByMonth(month);
        if(challenge!=null){
            return new ResponseEntity<>(challenge,HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")                    //localhost:8080/challenges/{id}
    public ResponseEntity<?> getChallenge(@PathVariable long id){
        System.out.println("entered into =  Find challenge __ by id");
        ChallengeEntity challenge=challengeService.getChallenge(id);
        if(challenge!=null){
            return new ResponseEntity<>(challenge,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    //Delete:-
    @DeleteMapping("/{id}")                              ////localhost:8080/challenges/{id}
    public ResponseEntity<String> deleteById(@PathVariable long id){
        System.out.println("entered into =  deleteById");
        boolean isChallengeDeleted=challengeService.deleteChallengeById(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenges Deleted Successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Challenges Not  Deleted ",HttpStatus.NOT_FOUND);
        }


    }

//update by id:-
    @PutMapping("/{id}")                                        //localhost:8080/challenges/{id}
    public ResponseEntity<String> updateById(@PathVariable Long id,@RequestBody ChallengeEntity entity){
        System.out.println("entered into =  updateById");
         boolean isChallengeUpdated=challengeService.updateChallengeById(id,entity);
          if(isChallengeUpdated){
              return new ResponseEntity<>("Challenges Updated Successfully",HttpStatus.OK);
          }else {
              return new ResponseEntity<>("Challenges Not  Updated ",HttpStatus.NOT_FOUND);
          }
    }


}
