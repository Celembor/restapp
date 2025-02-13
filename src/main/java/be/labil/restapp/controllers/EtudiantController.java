package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.services.interfaces.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Tag(name = "Etudiant", description = "L'API des étudiants")
@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {

    public final IEtudiantService iEtudiantService;

    @PostMapping(value = "/create", produces = "application/json")
    Etudiant create(@RequestBody Etudiant etudiant) {
        return iEtudiantService.insert(etudiant);
    }

    @Operation(
            summary = "Récupération de la liste des étudiants",
            description = "Retourne la liste de tous les étudiants avec leurs matricules"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Opération réussie")
    })
    @GetMapping(value = "/list", produces = "application/json")
    Set<EtudiantDto> read() {
        return iEtudiantService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    EtudiantDto update(@PathVariable Long id, @RequestBody EtudiantDto etudiantDto) {
        return iEtudiantService.update(id, etudiantDto);
    }

    @DeleteMapping("/delete/{id}")
    Boolean delete(@PathVariable Long id) {
        return iEtudiantService.delete(id);
    }

    @GetMapping("/deliberation/{id}")
    ResponseEntity<String> deliberation(@PathVariable Long id) {
        return ResponseEntity.ok(iEtudiantService.deliberation(id));
    }


}
