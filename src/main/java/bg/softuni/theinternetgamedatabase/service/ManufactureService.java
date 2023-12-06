package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.manufacture.AddManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.dto.manufacture.ManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;
import bg.softuni.theinternetgamedatabase.model.mapper.ManufactureMapper;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class ManufactureService {

    private final ManufactureRepository manufactureRepository;
    private final ManufactureMapper manufactureMapper;

    public ManufactureService(ManufactureRepository manufactureRepository,
                              ManufactureMapper manufactureMapper) {
        this.manufactureRepository = manufactureRepository;
        this.manufactureMapper = manufactureMapper;
    }


    public List<ManufactureDTO> getManufacturesData() {
        return this.manufactureRepository.getManufacturesData().orElse(new ArrayList<>());
    }

    public void add(AddManufactureDTO addManufactureDTO) {

        Manufacture manufacture = this.manufactureMapper.manufactureDtoToManufacture(addManufactureDTO);
        manufacture.setGames(new HashSet<>());

        this.manufactureRepository.save(manufacture);
    }
}
