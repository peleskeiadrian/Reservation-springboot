package reservationspringboot.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import reservationspringboot.model.Artist;
import reservationspringboot.service.ArtistService;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    @GetMapping("/artists")
    public String index(Model model) {
        List<Artist> artists = service.getAllArtists();

        model.addAttribute("artists", artists);
        model.addAttribute("title", "Liste des artistes");

        return "artists/index";
    }

    @GetMapping("/artists/{id}")
    public String show(Model model, @PathVariable("id") long id) {
        Artist artist = service.getArtist(id);

        model.addAttribute("artist", artist);
        model.addAttribute("title", "Fiche d'un artiste");

        return "artists/show";
    }

    @GetMapping("/artists/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id, HttpServletRequest request) {
        Artist artist = service.getArtist(id);

        model.addAttribute("artist", artist);


        //Générer le lien retour pour l'annulation
        String referrer = request.getHeader("Referer");

        if(referrer!=null && !referrer.equals("")) {
            model.addAttribute("back", referrer);
        } else {
            model.addAttribute("back", "/artists/"+artist.getId());
        }

        return "artists/edit";
    }

    @PutMapping("/artists/{id}/edit")
    public String update(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult, @PathVariable("id") long id, Model model) {

        if (bindingResult.hasErrors()) {
            return "artists/edit";
        }

        Artist existing = service.getArtist(id);

        if(existing==null) {
            return "artists/index";
        }

        service.updateArtist(id, artist);

        return "redirect:/artists/"+artist.getId();
    }

    @GetMapping("/artists/create")
    public String create(Model model) {
        Artist artist = new Artist(null,null);

        model.addAttribute("artist", artist);

        return "artists/create";
    }

    @PostMapping("/artists/create")
    public String store(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "artists/create";
        }

        service.addArtist(artist);

        return "redirect:/artists/"+artist.getId();
    }


    @DeleteMapping("/artists/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Artist existing = service.getArtist(id);

        if(existing!=null) {
            service.deleteArtist(id);
        }

        return "redirect:/artists";
    }



}


