package com.example.demo.controller;

import com.example.demo.domain.SysRole;
import com.example.demo.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing SysRole.
 */
@RestController
@RequestMapping("/api")
public class SysRoleResource {

    private final Logger log = LoggerFactory.getLogger(SysRoleResource.class);

    private static final String ENTITY_NAME = "sysRole";

    private final SysRoleService sysRoleService;

    public SysRoleResource(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    /**
     * POST /sys-roles : Create a new sysRole.
     *
     * @param sysRole the sysRole to create
     * @return the ResponseEntity with status 201 (Created) and with body the new
     *         sysRole, or with status 400 (Bad Request) if the sysRole has already
     *         an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sys-roles")
    public ResponseEntity<SysRole> createSysRole(@RequestBody SysRole sysRole) throws URISyntaxException {
        log.debug("REST request to save SysRole : {}", sysRole);
        SysRole result = sysRoleService.save(sysRole);
        return ResponseEntity.ok().body(result);
    }

    /**
     * PUT /sys-roles : Updates an existing sysRole.
     *
     * @param sysRole the sysRole to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     *         sysRole, or with status 400 (Bad Request) if the sysRole is not
     *         valid, or with status 500 (Internal Server Error) if the sysRole
     *         couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sys-roles")
    public ResponseEntity<SysRole> updateSysRole(@RequestBody SysRole sysRole) throws URISyntaxException {
        log.debug("REST request to update SysRole : {}", sysRole);
        if (sysRole.getId() == null) {
            return createSysRole(sysRole);
        }
        SysRole result = sysRoleService.save(sysRole);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET /sys-roles : get all the sysRoles.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sysRoles in
     *         body
     */
    @GetMapping("/sys-roles")
    public ResponseEntity<List<SysRole>> getAllSysRoles(Pageable pageable) {
        log.debug("REST request to get a page of SysRoles");
        Page<SysRole> page = sysRoleService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    /**
     * GET /sys-roles/:id : get the "id" sysRole.
     *
     * @param id the id of the sysRole to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sysRole, or
     *         with status 404 (Not Found)
     */
    @GetMapping("/sys-roles/{id}")
    public ResponseEntity<SysRole> getSysRole(@PathVariable Long id) {
        log.debug("REST request to get SysRole : {}", id);
        SysRole sysRole = sysRoleService.findOne(id);
        return ResponseEntity.ok().body(sysRole);
    }

    /**
     * DELETE /sys-roles/:id : delete the "id" sysRole.
     *
     * @param id the id of the sysRole to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sys-roles/{id}")
    public ResponseEntity<Void> deleteSysRole(@PathVariable Long id) {
        log.debug("REST request to delete SysRole : {}", id);
        sysRoleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
