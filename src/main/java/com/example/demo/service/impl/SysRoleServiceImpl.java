package com.example.demo.service.impl;

import com.example.demo.domain.SysRole;
import com.example.demo.repository.SysRoleRepository;
import com.example.demo.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing SysRole.
 */
@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    private final Logger log = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    private final SysRoleRepository sysRoleRepository;

    public SysRoleServiceImpl(SysRoleRepository sysRoleRepository) {
        this.sysRoleRepository = sysRoleRepository;
    }

    /**
     * Save a sysRole.
     *
     * @param sysRole the entity to save
     * @return the persisted entity
     */
    @Override
    public SysRole save(SysRole sysRole) {
        log.debug("Request to save SysRole : {}", sysRole);
        SysRole result = sysRoleRepository.save(sysRole);
        return result;
    }

    /**
     * Get all the sysRoles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SysRole> findAll(Pageable pageable) {
        log.debug("Request to get all SysRoles");
        return sysRoleRepository.findAll(pageable);
    }

    /**
     * Get one sysRole by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SysRole findOne(Long id) {
        log.debug("Request to get SysRole : {}", id);
        return sysRoleRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the sysRole by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SysRole : {}", id);
        sysRoleRepository.deleteById(id);
    }
}
