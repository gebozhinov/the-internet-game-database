package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.manufacture.AddManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.dto.manufacture.ManufactureDTO;
import bg.softuni.theinternetgamedatabase.model.entity.Manufacture;
import bg.softuni.theinternetgamedatabase.model.mapper.ManufactureMapper;
import bg.softuni.theinternetgamedatabase.repository.ManufactureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ManufactureServiceTest {

    private ManufactureService serviceToTest;
    @Mock
    private ManufactureRepository mockManufactureRepository;
    @Mock
    private ManufactureMapper mockManufactureMapper;

    @BeforeEach
    void setUp() {
        serviceToTest = new ManufactureService(mockManufactureRepository, mockManufactureMapper);
    }

    @Test
    void testAddManufacture() {

        AddManufactureDTO manufactureDTO = new AddManufactureDTO().setCompanyName("test");
        Manufacture manufacture = new Manufacture().setCompanyName("test").setGames(new HashSet<>());
        when(mockManufactureMapper.manufactureDtoToManufacture(manufactureDTO))
                .thenReturn(manufacture);
        serviceToTest.add(manufactureDTO);


    }

    @Test
    void testGetManufacturesData() {

        List<ManufactureDTO> manufactureDTOS = testManufactures();
        when(mockManufactureRepository.getManufacturesData())
                .thenReturn(Optional.of(manufactureDTOS));
        List<ManufactureDTO> manufacturesData = serviceToTest.getManufacturesData();
        assertEquals(manufactureDTOS.size(), manufacturesData.size());
    }

    private List<ManufactureDTO> testManufactures() {
        return List.of(new ManufactureDTO().setId(1L).setCompanyName("test"),
                new ManufactureDTO().setId(2L).setCompanyName("test2"));
    }
}
