package reservationspringboot.api.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import reservationspringboot.api.controller.ArtistApiController;
import reservationspringboot.model.Artist;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;



@Component
public class ArtistModelAssembler implements RepresentationModelAssembler<Artist, EntityModel<Artist>> {

    @Override
    public EntityModel<Artist> toModel(Artist artist) {
        return EntityModel.of(artist,
                linkTo(methodOn(ArtistApiController.class)
                        .one(artist.getId())).withSelfRel(),
                linkTo(methodOn(ArtistApiController.class).all())
                        .withRel("artists"));
    }
}

