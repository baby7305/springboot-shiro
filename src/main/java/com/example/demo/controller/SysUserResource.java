package com.example.demo.controller;

import com.example.demo.domain.SysUser;
import com.example.demo.service.SysUserService;
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
 * REST controller for managing SysUser.
 */
@RestController
@RequestMapping("/api")
public class SysUserResource {

    private final Logger log = LoggerFactory.getLogger(SysUserResource.class);

    private static final String ENTITY_NAME = "sysUser";

    private final SysUserService sysUserService;

    public SysUserResource(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * POST /sys-users : Create a new sysUser.
     *
     * @param sysUser the sysUser to create
     * @return the ResponseEntity with status 201 (Created) and with body the new
     *         sysUser, or with status 400 (Bad Request) if the sysUser has already
     *         an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sys-users")
    public ResponseEntity<SysUser> createSysUser(@RequestBody SysUser sysUser) throws URISyntaxException {
        log.debug("REST request to save SysUser : {}", sysUser);
        SysUser result = sysUserService.save(sysUser);
        return ResponseEntity.ok().body(result);
    }

    /**
     * PUT /sys-users : Updates an existing sysUser.
     *
     * @param sysUser the sysUser to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     *         sysUser, or with status 400 (Bad Request) if the sysUser is not
     *         valid, or with status 500 (Internal Server Error) if the sysUser
     *         couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sys-users")
    public ResponseEntity<SysUser> updateSysUser(@RequestBody SysUser sysUser) throws URISyntaxException {
        log.debug("REST request to update SysUser : {}", sysUser);
        if (sysUser.getId() == null) {
            return createSysUser(sysUser);
        }
        SysUser result = sysUserService.save(sysUser);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET /sys-users : get all the sysUsers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sysUsers in
     *         body
     */
    @GetMapping("/sys-users")
    public ResponseEntity<List<SysUser>> getAllSysUsers(Pageable pageable) {
        log.debug("REST request to get a page of SysUsers");
        Page<SysUser> page = sysUserService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    /**
     * GET /sys-users/:id : get the "id" sysUser.
     *
     * @param id the id of the sysUser to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sysUser, or
     *         with status 404 (Not Found)
     */
    @GetMapping("/sys-users/{id}")
    public ResponseEntity<SysUser> getSysUser(@PathVariable Long id) {
        log.debug("REST request to get SysUser : {}", id);
        SysUser sysUser = sysUserService.findOne(id);
        return ResponseEntity.ok().body(sysUser);
    }

    /**
     * DELETE /sys-users/:id : delete the "id" sysUser.
     *
     * @param id the id of the sysUser to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sys-users/{id}")
    public ResponseEntity<Void> deleteSysUser(@PathVariable Long id) {
        log.debug("REST request to delete SysUser : {}", id);
        sysUserService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
