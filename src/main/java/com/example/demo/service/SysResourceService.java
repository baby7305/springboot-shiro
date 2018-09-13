package com.example.demo.service;

import com.example.demo.domain.SysResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SysResource.
 */
public interface SysResourceService {

    /**
     * Save a sysResource.
     *
     * @param sysResource the entity to save
     * @return the persisted entity
     */
    SysResource save(SysResource sysResource);

    /**
     * Get all the sysResources.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SysResource> findAll(Pageable pageable);

    /**
     * Get the "id" sysResource.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SysResource findOne(Long id);

    /**
     * Delete the "id" sysResource.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
