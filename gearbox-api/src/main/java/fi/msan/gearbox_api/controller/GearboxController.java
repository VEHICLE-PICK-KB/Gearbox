package fi.msan.gearbox_api.controller;

import fi.msan.gearbox_api.model.Gearbox;
import fi.msan.gearbox_api.model.GearboxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/api/gearboxes")
public class GearboxController {

    private final GearboxService service;

    public GearboxController(GearboxService service) {
        this.service = service;
    }

    @GetMapping
    public List<Gearbox> getAll() {
        return service.getAll();
    }
@GetMapping("/{id}")
    public ResponseEntity<Gearbox> getOne(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
@PostMapping
 public ResponseEntity<Gearbox> create(@RequestBody Gearbox gearbox){

    Gearbox created = service.create(gearbox);
    URI location = URI.create("/api/gearboxes/" + created.getId());
    return ResponseEntity.created(location).body(created);

 } 
 @PutMapping("path/{id}")
 public ResponseEntity<Gearbox> edit(@PathVariable Long id, @RequestBody Gearbox updated) {

     Gearbox result = service.update(id, updated);

     return ResponseEntity.ok(result);
 }
 @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
            service.delete(id);
            return ResponseEntity.noContent().build();}



}
