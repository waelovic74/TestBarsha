package io.barsha.controllers;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import io.barsha.models.Offre;
import io.barsha.repository.OffreRepository;

@RestController
@RequestMapping({"/api/offres"})
@CrossOrigin(origins = "*")
public class OffreController {

    @Autowired
    private OffreRepository offreRepository;

    @GetMapping("/list")
    public List<Offre> getAllOffre() {
        return (List<Offre>) offreRepository.findAll();
    }

    @GetMapping("/list/{dateDebut}/{dateFin}")
    public List<Offre> getAllOffreByDate(@PathVariable("dateDebut") Instant dateDebut, @PathVariable("dateFin") Instant dateFin) {

        return (List<Offre>) offreRepository.findOffreBetweenDate(dateDebut, dateFin);
    }

    @GetMapping("/{offreId}")
    public Optional<Offre> getOffre(@PathVariable Long offreId) {
        return offreRepository.findById(offreId);
    }


    @PostMapping("/add")
    public Offre createOffre(@Valid @RequestBody Offre offre) {
        return offreRepository.save(offre);
    }

    @PutMapping("/{offreId}")
    public Offre updateOffre(@PathVariable Long offreId, @Valid @RequestBody Offre offreRequest) {


        /*return offreRepository.findById(offreId).map(offre -> {

                    offre.setTitre(offreRequest.getTitre());
                    offre.setPrix(offreRequest.getPrix());
                    offre.setDateValidite(offreRequest.getDateValidite());
                    offre.setImage(offreRequest.getImage());
*/

        return offreRepository.save(offreRequest);

    }


       /* ).orElseThrow(() -> new IllegalArgumentException("OffreId " + offreId + " not found"));


    }*/


    @DeleteMapping("/{offreId}")

    public Offre deleteOffre(@PathVariable Long offreId) {
        return offreRepository.findById(offreId).map(offre -> {
            offreRepository.delete(offre);
            return offre;
        }).orElseThrow(() -> new IllegalArgumentException("OffreId " + offreId + " not found"));
    }


}
