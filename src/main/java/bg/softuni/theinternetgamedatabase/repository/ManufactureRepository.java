package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.dto.ManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {

    @Query(value = "SELECT new bg.softuni.theinternetgamedatabase.model.dto.ManufactureDTO(m.id, m.companyName) " +
            "FROM Manufacture m " +
            "ORDER BY m.companyName")
    Optional<List<ManufactureDTO>> getManufacturesData();
}
