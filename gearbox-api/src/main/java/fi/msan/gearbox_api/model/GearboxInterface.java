package fi.msan.gearbox_api.model;



import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface GearboxInterface extends JpaRepository<Gearbox, Long> {

    List<Gearbox> findByGears(int gears);

    List<Gearbox> findByModel(String model);

    List<Gearbox> findByManufacturer(String manufacturer);

    List<Gearbox> findByType(String type);

    List<Gearbox> findByYear(int year);

    @Query("SELECT * FROM Gearbox WHERE type = :type AND gears = :gears" )
    List<Gearbox> searchByTypeAndGears(@Param("type") String type, @Param("gears") int gears);
    









}
