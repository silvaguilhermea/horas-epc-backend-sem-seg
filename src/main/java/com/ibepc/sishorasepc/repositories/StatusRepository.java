package com.ibepc.sishorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibepc.sishorasepc.domain.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}