package fi.msan.gearbox_api.model;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GearboxService {

    private final GearboxInterface repo;

    public GearboxService(GearboxInterface repo){
        this.repo = repo;
    }

    public List<Gearbox>getAll(){
    return repo.findAll();
    }

    public Optional<Gearbox>getById(Long id){
        return repo.findById(id);
    }

    public Gearbox create(Gearbox gearbox) {

        if (gearbox.getModel()==null || gearbox.getModel().trim().length() < 2){
            throw new IllegalArgumentException("Gearbox must have a model or enough characters!");
        }

        if(gearbox.getManufacturer()==null || gearbox.getManufacturer().trim().length() < 2){
            throw new IllegalArgumentException("Gearbox must have a manufacturer or enough characters!");
        }

        if (gearbox.getGears() < 1 || gearbox.getGears() > 9){
            throw new IllegalArgumentException("Gears must be between 1-9!");

        }

        if (gearbox.getManufyear() < 1886 || gearbox.getManufyear() > 2026) {
            throw new IllegalArgumentException("Year must be between 1886 and 2026.");
        }

        List<String> allowedTypes = List.of("Automatic", "Manual", "Sequential", "CVT");

        if (!allowedTypes.contains(gearbox.getType())) {
            throw new IllegalArgumentException("Type must be one of the following: " + allowedTypes);
        }

        return repo.save(gearbox);
    }

    public List<Gearbox> findByModel(String model) {
        return repo.findByModel(model);
    }

    public List<Gearbox> findByType(String type) {
        return repo.findByType(type);
    }

    public List<Gearbox> findByGears(int gears) {
        return repo.findByGears(gears);
    }

    public List<Gearbox> findByManufacturer(String manufacturer) {
        return repo.findByManufacturer(manufacturer);
    }

    public List<Gearbox> findByManufyear(int manufyear) {
        return repo.findByManufyear(manufyear);
    }

    public List<Gearbox> findByTypeAndGears(String type, int gears){
        return repo.searchByTypeAndGears(type, gears);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Gearbox with id " + id + " not found");
        }
        repo.deleteById(id);
    }

      public Gearbox update(Long id, Gearbox updated) {

        if (updated.getModel()==null || updated.getModel().trim().length() < 2){
            throw new IllegalArgumentException("Gearbox must have a model or enough characters!");
        }

        if(updated.getManufacturer()==null || updated.getManufacturer().trim().length() < 2){
            throw new IllegalArgumentException("Gearbox must have a manufacturer or enough characters!");
        }

        if (updated.getGears() < 1 || updated.getGears() > 9){
            throw new IllegalArgumentException("Gears must be between 1-9!");

        }

        if (updated.getManufyear() < 1886 || updated.getManufyear() > 2026) {
            throw new IllegalArgumentException("Year must be between 1886 and 2026.");
        }

        List<String> allowedTypes = List.of("Automatic", "Manual", "Sequential", "CVT");

        if (!allowedTypes.contains(updated.getType())) {
            throw new IllegalArgumentException("Type must be one of the following: " + allowedTypes);
        }

        
        Gearbox existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Gearbox with id " + id + " not found"));

        existing.setModel(updated.getModel());
        existing.setType(updated.getType());
        existing.setGears(updated.getGears());
        existing.setManufacturer(updated.getManufacturer());
        existing.setManufyear(updated.getManufyear());

        return repo.save(existing);
}
}



