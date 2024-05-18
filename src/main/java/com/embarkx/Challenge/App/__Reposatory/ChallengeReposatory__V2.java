package com.embarkx.Challenge.App.__Reposatory;



import com.embarkx.Challenge.App.__Entity.ChallengeEntity__V2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChallengeReposatory__V2 extends JpaRepository<ChallengeEntity__V2,Long> {

   // Optional<ChallengeEntity__V2> findByMonthIgnoreCase(String month);

    ChallengeEntity__V2 findByMonth(String month);

}

