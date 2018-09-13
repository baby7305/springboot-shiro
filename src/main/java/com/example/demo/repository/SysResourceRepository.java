package com.example.demo.repository;

import com.example.demo.domain.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data JPA repository for the SysResource entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysResourceRepository extends JpaRepository<SysResource, Long> {

}
