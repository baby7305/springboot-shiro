package com.example.demo.controller;

import com.example.demo.domain.SysResource;
import com.example.demo.service.SysResourceService;
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
 * REST controller for managing SysResource.
 */
@RestController
@RequestMapping("/api")
public class SysResourceResource {

    private final Logger log = LoggerFactory.getLogger(SysResourceResource.class);

    private static final String ENTITY_NAME = "sysResource";

    private final SysResourceService sysResourceService;

    public SysResourceResource(SysResourceService sysResourceService) {
        this.sysResourceService = sysResourceService;
    }

    /**
     * POST /sys-resources : Create a new sysResource.
     *
     * @param sysResource the sysResource to create
     * @return the ResponseEntity with status 201 (Created) and with body the new
     *         sysResource, or with status 400 (Bad Request) if the sysResource has
     *         already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sys-resources")
    public ResponseEntity<SysResource> createSysResource(@RequestBody SysResource sysResource)
            throws URISyntaxException {
        log.debug("REST request to save SysResource : {}", sysResource);
        SysResource result = sysResourceService.save(sysResource);
        return ResponseEntity.ok().body(result);
    }

    /**
     * PUT /sys-resources : Updates an existing sysResource.
     *
     * @param sysResource the sysResource to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     *         sysResource, or with status 400 (Bad Request) if the sysResource is
     *         not valid, or with status 500 (Internal Server Error) if the
     *         sysResource couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sys-resources")
    public ResponseEntity<SysResource> updateSysResource(@RequestBody SysResource sysResource)
            throws URISyntaxException {
        log.debug("REST request to update SysResource : {}", sysResource);
        if (sysResource.getId() == null) {
            return createSysResource(sysResource);
        }
        SysResource result = sysResourceService.save(sysResource);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET /sys-resources : get all the sysResources.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sysResources
     *         in body
     */
    @GetMapping("/sys-resources")
    public ResponseEntity<List<SysResource>> getAllSysResources(Pageable pageable) {
        log.debug("REST request to get a page of SysResources");
        Page<SysResource> page = sysResourceService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    /**
     * GET /sys-resources/:id : get the "id" sysResource.
     *
     * @param id the id of the sysResource to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the
     *         sysResource, or with status 404 (Not Found)
     */
    @GetMapping("/sys-resources/{id}")
    public ResponseEntity<SysResource> getSysResource(@PathVariable Long id) {
        log.debug("REST request to get SysResource : {}", id);
        SysResource sysResource = sysResourceService.findOne(id);
        return ResponseEntity.ok().body(sysResource);
    }

    /**
     * DELETE /sys-resources/:id : delete the "id" sysResource.
     *
     * @param id the id of the sysResource to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sys-resources/{id}")
    public ResponseEntity<Void> deleteSysResource(@PathVariable Long id) {
        log.debug("REST request to delete SysResource : {}", id);
        sysResourceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
