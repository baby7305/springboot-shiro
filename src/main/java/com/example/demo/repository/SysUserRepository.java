package com.example.demo.repository;

import com.example.demo.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the SysUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    @Query("select distinct sys_user from SysUser sys_user left join fetch sys_user.sysRoles")
    List<SysUser> findAllWithEagerRelationships();

    @Query("select sys_user from SysUser sys_user left join fetch sys_user.sysRoles where sys_user.id =:id")
    SysUser findOneWithEagerRelationships(@Param("id") Long id);

}
