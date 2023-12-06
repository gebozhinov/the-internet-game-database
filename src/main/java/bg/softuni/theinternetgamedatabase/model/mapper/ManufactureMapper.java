package bg.softuni.theinternetgamedatabase.model.mapper;

import bg.softuni.theinternetgamedatabase.model.dto.manufacture.AddManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufactureMapper {

    Manufacture manufactureDtoToManufacture(AddManufactureDTO addManufactureDTO);
}
