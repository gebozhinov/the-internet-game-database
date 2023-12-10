package bg.softuni.theinternetgamedatabase.service;

import bg.softuni.theinternetgamedatabase.model.dto.platform.PlatformDTO;
import bg.softuni.theinternetgamedatabase.repository.PlatformRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlatformServiceTest {

    private PlatformService serviceToTest;
    @Mock
    private PlatformRepository platformRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new PlatformService(platformRepository);
    }

    @Test
    void getPlatformData() {
        List<PlatformDTO> platformDTO = getPlatformDTO();
        when(platformRepository.getPlatformData())
                .thenReturn(Optional.of(platformDTO));

        List<PlatformDTO> testPlatformData = serviceToTest.getPlatformData();

        assertEquals(platformDTO.size(), testPlatformData.size());
    }

    private List<PlatformDTO> getPlatformDTO() {
        PlatformDTO platformDTO = new PlatformDTO()
                .setId(1L)
                .setName("test");

        return List.of(platformDTO);
    }
}
