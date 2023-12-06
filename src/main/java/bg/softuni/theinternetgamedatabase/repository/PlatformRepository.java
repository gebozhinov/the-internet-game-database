package bg.softuni.theinternetgamedatabase.repository;

import bg.softuni.theinternetgamedatabase.model.dto.platform.PlatformDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {

    @Query("SELECT NEW bg.softuni.theinternetgamedatabase.model.dto.platform.PlatformDTO(p.id, p.name) " +
            "FROM Platform p ")
    Optional<List<PlatformDTO>> getPlatformData();
}
