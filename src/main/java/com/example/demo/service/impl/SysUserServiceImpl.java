package com.example.demo.service.impl;

import com.example.demo.domain.SysUser;
import com.example.demo.repository.SysUserRepository;
import com.example.demo.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing SysUser.
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    private final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    private final SysUserRepository sysUserRepository;

    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    /**
     * Save a sysUser.
     *
     * @param sysUser the entity to save
     * @return the persisted entity
     */
    @Override
    public SysUser save(SysUser sysUser) {
        log.debug("Request to save SysUser : {}", sysUser);
        SysUser result = sysUserRepository.save(sysUser);
        return result;
    }

    /**
     * Get all the sysUsers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SysUser> findAll(Pageable pageable) {
        log.debug("Request to get all SysUsers");
        return sysUserRepository.findAll(pageable);
    }

    /**
     * Get one sysUser by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SysUser findOne(Long id) {
        log.debug("Request to get SysUser : {}", id);
        return sysUserRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the sysUser by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SysUser : {}", id);
        sysUserRepository.deleteById(id);
    }
}
