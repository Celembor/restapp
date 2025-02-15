package be.labil.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
