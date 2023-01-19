package org.fstt.oracle.dao;

import org.fstt.oracle.entitie.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer>{

}
