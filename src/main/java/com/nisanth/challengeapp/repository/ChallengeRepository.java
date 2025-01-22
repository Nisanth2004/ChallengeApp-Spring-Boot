package com.nisanth.challengeapp.repository;

import com.nisanth.challengeapp.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {


    Optional<Challenge> findByMonthIgnoreCase(String month);
}
