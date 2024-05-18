package com.embarkx.Challenge.App.__Services;

import com.embarkx.Challenge.App.__Entity.ChallengeEntity__V2;
import com.embarkx.Challenge.App.__Reposatory.ChallengeReposatory__V2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


//@Component
@Service
public class ChallengeService__V2 {

    @Autowired
    ChallengeReposatory__V2 challengeReposatory__v2;


    private long nextId =1;





    public List<ChallengeEntity__V2> getAllChallenges(){
        return challengeReposatory__v2.findAll();
    }

    public boolean  addChallenges(ChallengeEntity__V2 entity){
       if(entity!=null){
           try {
               entity.setId(nextId++);
               challengeReposatory__v2.save(entity);
               return true;
           }catch (Exception e){
               System.out.println("\n\n\n\n\n\n"+e +"\n\n\n\n");
           }
        }
       return false;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Find on Month
    public ChallengeEntity__V2 getChallengesByMonth___(String month){

        System.out.println("\n\n\n\n Entrred into:-  getChallengesByMonth  Service");
        /*
        List<ChallengeEntity__V2> list=challengeReposatory__v2.findAll();;
        for(int i=0;i<list.size();i++){
            ChallengeEntity__V2 entity=list.get(i);
            if(entity.getMonth().equals(month)){
                return entity;
            }
        }

         */
     //   Optional<ChallengeEntity__V2> ee=challengeReposatory__v2.findByMonthIgnoreCase(month);
     //  return ee.orElse(null);

        //My Aproch:-
/*
       List<ChallengeEntity__V2> list= challengeReposatory__v2.findAll();
        System.out.println("list received in service:-       "+  list.size());
       for(int i=0;i<list.size();i++){
           ChallengeEntity__V2 entity=list.get(i);
           if(entity.getMonth().equalsIgnoreCase(month)){
               return entity;
           }
       }

 */
        ChallengeEntity__V2 entity__v2= challengeReposatory__v2.findByMonth( month);


return entity__v2;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Find on id
    public ChallengeEntity__V2 getChallenge(Long id){
     /*   for(int i=0;i<challenges.size();i++){
            ChallengeEntity__V2 entity=challenges.get(i);
            if(entity.getId().equals(id)){
                return entity;
            }
        }

      */
      Optional  <ChallengeEntity__V2> entity__v2=  challengeReposatory__v2.findById(id);
        return entity__v2.orElse(null);
    }

    //Adding a list:-
    public String addList(List<ChallengeEntity__V2> list){
        System.out.println("inside service:- ");
        System.out.println("list size:-"+list.size());
        for(int i=0;i<list.size();i++){
            ChallengeEntity__V2 entity=list.get(i);
            try {
               // challengeReposatory__v2.save(entity);
                addChallenges(entity);
            }
           catch (Exception e){
               System.out.println(e);
           }
            System.out.println("inside service:- After method envoked");
        }
        return " List added  Properly";
    }




    //Updating the challenge;-
    public boolean updateChallenge(Long id,ChallengeEntity__V2 entity){
      /*  for (ChallengeEntity__V2 ff : challenges) {
            if (ff.getId().equals(id)) {
                ff.setMonth(entity.getMonth());
                ff.setDescription(entity.getDescription());
                return true;
            }
        }


        return false;

       */

        Optional  <ChallengeEntity__V2> challenge=  challengeReposatory__v2.findById(id);
        if(challenge.isPresent()){
            ChallengeEntity__V2 challengeToBeUpdated =challenge.get();
            challengeToBeUpdated.setDescription(entity.getDescription());
            challengeToBeUpdated.setMonth(entity.getMonth());
            challengeReposatory__v2.save(challengeToBeUpdated);
            return true;
        }
        return false;
    }



    //Deleting Challenges by id:-
    public boolean deleteChallengeById(long id) {
      /*  for(int i=0;i<challenges.size();i++){
            ChallengeEntity__V2 entity=challenges.get(i);
            if(entity.getId().equals(id)){
                challenges.remove(i);
                return true;
            }
        }
        return false;

       */
        Optional  <ChallengeEntity__V2> challenge=  challengeReposatory__v2.findById(id);
        if(challenge.isPresent()){
            challengeReposatory__v2.deleteById(id);
            return true;
        }

        return false;
    }




}
