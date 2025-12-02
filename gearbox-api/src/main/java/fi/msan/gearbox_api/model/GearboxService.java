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

        if (gearbox.getModel()==null){
            throw new IllegalArgumentException("Gearbox must have a model!");
        }

        if (gearbox.getGears() <= 0){
            throw new IllegalArgumentException("No gears?");

        }

        if (gearbox.getYear() < 1886 || gearbox.getYear() > 2026) {
            throw new IllegalArgumentException("Year must be between 1900 and 2035.");
        }

        List<String> allowedTypes = List.of("Automatic", "Manual", "Sequential", "CVT");

        if (!allowedTypes.contains(gearbox.getType().toLowerCase())) {
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

    public List<Gearbox> findByYear(int year) {
        return repo.findByYear(year);
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

        
        Gearbox existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Gearbox with id " + id + " not found"));

        existing.setModel(updated.getModel());
        existing.setType(updated.getType());
        existing.setGears(updated.getGears());
        existing.setManufacturer(updated.getManufacturer());
        existing.setYear(updated.getYear());

        return repo.save(existing);
}
}



