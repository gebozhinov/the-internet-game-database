package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.ManufactureDTO;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufactureService {

    private final ManufactureRepository manufactureRepository;

    public ManufactureService(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }


    public List<ManufactureDTO> getManufacturesData() {
        return this.manufactureRepository.getManufacturesData().orElse(new ArrayList<>());
    }
}
