package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.Image;
import op2.ryhmatyo.pelisivusto.domain.ImageRepository;

@RestController
public class ImageController {

    @Autowired
    private ImageRepository imagerepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public List<Image> ImageListRest() {
        return (List<Image>) imagerepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä kuvasta

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public Optional<Image> findImageRest(@PathVariable("id") Long image_id) {
        return imagerepository.findById(image_id);
    }

}
