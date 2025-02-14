package be.labil.restapp;

import java.nio.charset.StandardCharsets;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.domain.entities.UE;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.repositories.interfaces.IEtudiantRepository;
import be.labil.restapp.repositories.interfaces.IMatiereRepository;
import be.labil.restapp.repositories.interfaces.INoteRepository;
import be.labil.restapp.repositories.interfaces.IUERepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestappApplication {

	public static void main(String[] args) {
		//System.setProperty("file.encoding", StandardCharsets.UTF_8.name());
		SpringApplication.run(RestappApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(
//			IEtudiantRepository iEtudiantRepository,
//			IUERepository iUeRepository,
//			IMatiereRepository iMatiereRepository,
//			INoteRepository iNoteRepository
//	) {
//		return args -> {
//			var etudiant = Etudiant.builder()
//					.nom("Berny")
//					.prenom("Marvin")
//					.matricule("MB261090")
//					.masterType("Informatique HD")
//					.build();
//			iEtudiantRepository.save(etudiant);
//			var etudiant2 = Etudiant.builder()
//					.nom("Berny")
//					.prenom("Jordan")
//					.matricule("JB211292")
//					.masterType("Droit")
//					.build();
//			iEtudiantRepository.save(etudiant2);
//			var ue = UE.builder()
//					.intitule("INFORMATIQUE")
//					.build();
//			iUeRepository.save(ue);
//			var matiere = Matiere.builder()
//					.intitule("Sécurité")
//					.credit(3)
//					.ue(ue)
//					.build();
//			iMatiereRepository.save(matiere);
//			var matiere2 = Matiere.builder()
//					.intitule("Mémoire")
//					.credit(24)
//					.ue(ue)
//					.build();
//			iMatiereRepository.save(matiere2);
//			var note = Note.builder()
//					.valeur(14.5)
//					.etudiant(etudiant)
//					.matiere(matiere)
//					.build();
//			iNoteRepository.save(note);
//		};
//	}

}
