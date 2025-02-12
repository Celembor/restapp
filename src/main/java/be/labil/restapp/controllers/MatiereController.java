package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.services.interfaces.IMatiereService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Tag(name = "Matière", description = "L'API des matières")
@RestController
@RequestMapping("/matiere")
@AllArgsConstructor
public class MatiereController {

    public final IMatiereService iMatiereService;

    @PostMapping(value = "/create", produces = "application/json")
    Matiere create(@RequestBody Matiere matiere) {
        return iMatiereService.insert(matiere);
    }

    @GetMapping(value = "/list", produces = "application/json")
    Set<MatiereDto> read() {
        return iMatiereService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    MatiereDto update(@PathVariable Long id, @RequestBody MatiereDto matiereDto) {
        return iMatiereService.update(id, matiereDto);
    }

    @DeleteMapping("/delete/{id}")
    Boolean delete(@PathVariable Long id) {
        return iMatiereService.delete(id);
    }

}
