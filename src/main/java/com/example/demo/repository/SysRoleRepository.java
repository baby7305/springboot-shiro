package com.example.demo.repository;

import com.example.demo.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the SysRole entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
    @Query("select distinct sys_role from SysRole sys_role left join fetch sys_role.sysResources")
    List<SysRole> findAllWithEagerRelationships();

    @Query("select sys_role from SysRole sys_role left join fetch sys_role.sysResources where sys_role.id =:id")
    SysRole findOneWithEagerRelationships(@Param("id") Long id);

}
