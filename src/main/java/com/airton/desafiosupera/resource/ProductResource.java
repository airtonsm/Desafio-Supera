package com.airton.desafiosupera.resource;

import com.airton.desafiosupera.dto.ShopcartDTO;
import com.airton.desafiosupera.entities.Shopcart;
import com.airton.desafiosupera.service.ShopcartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/shopcarts")
public class ShopcartResource {

    @Autowired
    private ShopcartService service;

    @GetMapping
    public ResponseEntity<List<ShopcartDTO>> findAll(@RequestParam(required = false) String sortAttribute) {
        List<ShopcartDTO> list = service.findAll(StringUtils.upperCase(sortAttribute));
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ShopcartDTO> findById(@PathVariable Long id, @RequestParam(required = false) String sortAttribute) {
        ShopcartDTO obj = service.findById(id, StringUtils.upperCase(sortAttribute));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/checkout/{id}")
    public ResponseEntity<ShopcartDTO> checkout(@PathVariable Long id) {
        ShopcartDTO obj = service.checkout(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Shopcart> insert(@RequestBody Shopcart obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Shopcart> update(@PathVariable Long id, @RequestBody Shopcart obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
