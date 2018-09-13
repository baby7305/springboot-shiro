package com.example.demo.service.impl;


import com.example.demo.domain.SysResource;
import com.example.demo.repository.SysResourceRepository;
import com.example.demo.service.SysResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing SysResource.
 */
@Service
@Transactional
public class SysResourceServiceImpl implements SysResourceService {

    private final Logger log = LoggerFactory.getLogger(SysResourceServiceImpl.class);

    private final SysResourceRepository sysResourceRepository;

    public SysResourceServiceImpl(SysResourceRepository sysResourceRepository) {
        this.sysResourceRepository = sysResourceRepository;
    }

    /**
     * Save a sysResource.
     *
     * @param sysResource the entity to save
     * @return the persisted entity
     */
    @Override
    public SysResource save(SysResource sysResource) {
        log.debug("Request to save SysResource : {}", sysResource);
        SysResource result = sysResourceRepository.save(sysResource);
        return result;
    }

    /**
     * Get all the sysResources.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SysResource> findAll(Pageable pageable) {
        log.debug("Request to get all SysResources");
        return sysResourceRepository.findAll(pageable);
    }

    /**
     * Get one sysResource by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SysResource findOne(Long id) {
        log.debug("Request to get SysResource : {}", id);
        return sysResourceRepository.findById(id).orElse(null);
    }

    /**
     * Delete the sysResource by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SysResource : {}", id);
        sysResourceRepository.deleteById(id);
    }

}
