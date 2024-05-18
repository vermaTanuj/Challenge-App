package com.embarkx.Challenge.App.__Controlers;

import com.embarkx.Challenge.App.__Entity.ChallengeEntity;
import com.embarkx.Challenge.App.__Entity.ChallengeEntity__V2;
import com.embarkx.Challenge.App.__Services.ChallengeService;
import com.embarkx.Challenge.App.__Services.ChallengeService__V2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeControler__V2 {

    @Autowired
  private ChallengeService__V2 challengeService__v2;




    @GetMapping                //localhost:8080/challenges
    public ResponseEntity<List<ChallengeEntity__V2>> getAllChallenges(){
        System.out.println("entered into =  getAll");
        return new ResponseEntity<>(challengeService__v2.getAllChallenges(),HttpStatus.OK);
    }

    @PostMapping              //localhost:8080/challenges
    public ResponseEntity<String> addChallenges(@RequestBody ChallengeEntity__V2 entity ){
        System.out.println("entered into =  create");
      boolean b=  challengeService__v2.addChallenges(entity);
      if(b==true){
          return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
      }else{
          return new ResponseEntity<>(" \"Challenge  NOT   added \"",HttpStatus.NOT_FOUND);
      }
    }


    //Adding a List at end:-
    @PostMapping("/addList")                //localhost:8080/challenges/addList
    private String addList(@RequestBody  List<ChallengeEntity__V2> list2){
        System.out.println("in addList method");
        try{
            System.out.println("inside try block controler:--  before");
            challengeService__v2.addList(list2);
            System.out.println("inside try block controler:--  after");
        }catch (Exception e){
            System.out.println("inside catch block controler");
        }

       return "Challenge Added list";
    }


    //Find by Month:-

    @GetMapping("/{month}")                  //localhost:8080/challenges/{month}
    public ResponseEntity<ChallengeEntity__V2>  getChallengesByMonth(@PathVariable("month") String month){

        System.out.println("entered into =  FindBy___Month  controller");

            ChallengeEntity__V2 challenge = challengeService__v2.getChallengesByMonth___(month);

        if(challenge!=null){
            return new ResponseEntity<>(challenge,HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    //Find by ID:-
    @GetMapping("/id/{id}")                    //localhost:8080/challenges/{id}
    public ResponseEntity<?> getChallenge(@PathVariable long id){
        System.out.println("entered into =  Find challenge __ by id");
        ChallengeEntity__V2 challenge=challengeService__v2.getChallenge(id);
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
        boolean isChallengeDeleted=challengeService__v2.deleteChallengeById(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenges Deleted Successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Challenges Not  Deleted ",HttpStatus.NOT_FOUND);
        }


    }

//update by id:-
    @PutMapping("/{id}")                                        //localhost:8080/challenges/{id}
    public ResponseEntity<String> updateById(@PathVariable Long id,@RequestBody ChallengeEntity__V2 entity){
        System.out.println("entered into =  updateById");
         boolean isChallengeUpdated=challengeService__v2.updateChallenge(id,entity);
          if(isChallengeUpdated){
              return new ResponseEntity<>("Challenges Updated Successfully",HttpStatus.OK);
          }else {
              return new ResponseEntity<>("Challenges Not  Updated ",HttpStatus.NOT_FOUND);
          }
    }


}
