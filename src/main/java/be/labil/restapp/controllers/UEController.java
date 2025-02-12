package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.UEDto;
import be.labil.restapp.domain.entities.UE;
import be.labil.restapp.services.interfaces.IUEService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Tag(name = "Unité d'Enseignement", description = "API pour la gestion des Unités d'Enseignement (UE)")
@RestController
@RequestMapping("/ue")
@AllArgsConstructor
public class UEController {

    private final IUEService iUeService;

    @PostMapping(value = "/create", produces = "application/json")
    UE create(@RequestBody UE ue) {
        return iUeService.insert(ue);
    }

    @GetMapping(value = "/list", produces = "application/json")
    Set<UEDto> read() {
        return iUeService.list();
    }
    
    @PutMapping(value = "/update/{id}", produces = "application/json")
    UEDto update(@PathVariable Long id, @RequestBody UEDto ueDto) {
        return iUeService.update(id, ueDto);
    }

    @DeleteMapping("/delete/{id}")
    Boolean delete(@PathVariable Long id) {
        return iUeService.delete(id);
    }
}
