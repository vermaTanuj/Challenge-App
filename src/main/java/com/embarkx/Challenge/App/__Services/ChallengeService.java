package com.embarkx.Challenge.App.__Services;

import com.embarkx.Challenge.App.__Entity.ChallengeEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//@Component
@Service
public class ChallengeService {
    private List<ChallengeEntity> challenges=new ArrayList<>();
private long nextId =1;
   /* public ChallengeService(){
        ChallengeEntity challengeEntity=new ChallengeEntity(1L,"January","Learn new Language");
        challenges.add(challengeEntity);
    }

    */



    public List<ChallengeEntity> getAllChallenges(){
        return challenges;
    }

    public boolean  addChallenges(ChallengeEntity entity){
       if(entity!=null){
           entity.setId(nextId);
            challenges.add(entity);
            nextId++;
            return true;
        }
       return false;
    }


    //Find on Month
    public ChallengeEntity getChallengesByMonth(String month){
       for (int i=0;i<challenges.size();i++){
           ChallengeEntity entity=challenges.get(i);
           if(entity.getMonth().equals(month)){
               return entity;
           }
       }
       return null;
    }

//Find on id
    public ChallengeEntity getChallenge(Long id){
        for(int i=0;i<challenges.size();i++){
            ChallengeEntity entity=challenges.get(i);
            if(entity.getId().equals(id)){
                return entity;
            }
        }
        return null;
    }

    //Adding a list:-
    public String addList(List<ChallengeEntity> list){
        for(int i=0;i<list.size();i++){
            ChallengeEntity entity=list.get(i);
            if(entity!=null){
                try {
                    addChallenges(entity);
                }catch (Exception e){
                    return " List not added ";
                }
            }
        }
        return " List added  Properly";
    }




    //Updating the challenge;-
    public boolean updateChallengeById(long id,ChallengeEntity entity){
        for (ChallengeEntity ff : challenges) {
            if (ff.getId().equals(id)) {
                ff.setMonth(entity.getMonth());
                ff.setDescription(entity.getDescription());
                return true;
            }
        }
        return false;
    }



    //Deleting Challenges by id:-
    public boolean deleteChallengeById(long id) {
        for(int i=0;i<challenges.size();i++){
            ChallengeEntity entity=challenges.get(i);
            if(entity.getId().equals(id)){
                challenges.remove(i);
                return true;
            }
        }
        return false;
    }




}
