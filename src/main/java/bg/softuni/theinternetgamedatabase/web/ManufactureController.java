package bg.softuni.theinternetgamedatabase.web;

import bg.softuni.theinternetgamedatabase.model.dto.AddManufactureDTO;
import bg.softuni.theinternetgamedatabase.service.ManufactureService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("manufacture")
public class ManufactureController {

    private final ManufactureService manufactureService;

    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    @ModelAttribute(name = "addManufactureDTO")
    public AddManufactureDTO addManufactureDTO() {
        return new AddManufactureDTO();
    }

    @GetMapping("/add")
    public String add() {
        return "manufacture-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddManufactureDTO addManufactureDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addManufactureDTO", addManufactureDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addManufactureDTO",
                    bindingResult);
            return "redirect:/manufacture/add";
        }

        this.manufactureService.add(addManufactureDTO);

        return "redirect:/game/add";
    }
}
