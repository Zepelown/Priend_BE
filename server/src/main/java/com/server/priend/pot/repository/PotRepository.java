package com.server.priend.pot.repository;

import com.server.priend.pot.entity.Pot;
import com.server.priend.pot.payload.dto.PotData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PotRepository extends JpaRepository<Pot,Long> {
}
