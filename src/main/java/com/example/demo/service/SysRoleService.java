package com.example.demo.service;

import com.example.demo.domain.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SysRole.
 */
public interface SysRoleService {

    /**
     * Save a sysRole.
     *
     * @param sysRole the entity to save
     * @return the persisted entity
     */
    SysRole save(SysRole sysRole);

    /**
     * Get all the sysRoles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SysRole> findAll(Pageable pageable);

    /**
     * Get the "id" sysRole.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SysRole findOne(Long id);

    /**
     * Delete the "id" sysRole.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
