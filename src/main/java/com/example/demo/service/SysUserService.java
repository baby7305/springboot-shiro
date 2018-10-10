package com.example.demo.service;

import com.example.demo.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SysUser.
 */
public interface SysUserService {

    /**
     * Save a sysUser.
     *
     * @param sysUser the entity to save
     * @return the persisted entity
     */
    SysUser save(SysUser sysUser);

    /**
     * Get all the sysUsers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SysUser> findAll(Pageable pageable);

    /**
     * Get the "id" sysUser.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SysUser findOne(Long id);

    /**
     * Delete the "id" sysUser.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    SysUser findByUserName(String name);

}
