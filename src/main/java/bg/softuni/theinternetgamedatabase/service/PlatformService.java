package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.platform.PlatformDTO;
import bg.softuni.theinternetgamedatabase.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformService {

    private final PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    public List<PlatformDTO> getPlatformData() {
        return this.platformRepository.getPlatformData().orElse(new ArrayList<>());
    }
}
