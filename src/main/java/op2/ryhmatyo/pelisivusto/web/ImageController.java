package op2.ryhmatyo.pelisivusto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.Image;
import op2.ryhmatyo.pelisivusto.domain.ImageRepository;
import op2.ryhmatyo.pelisivusto.service.ImageService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/searchImage") 
    public ResponseEntity<Map<String, String>> searchImage(@RequestParam("query") String searchQuery) {
        try {
            Image image = imageService.searchAndSaveImage(searchQuery);
            Map<String, String> response = new HashMap<>();
            response.put("imageUrl", image.getImageUrl());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Kuvaa ei löytynyt hakusanalla " + searchQuery);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Autowired
    private ImageRepository imagerepository;

    // Kaikki tiedot JSON-muodossa
    @GetMapping(value = "/images")
    public List<Image> ImageListRest() {
      return (List<Image>) imagerepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä kuvasta
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public Optional<Image> findImageRest(@PathVariable("id") Long image_id) {
      return imagerepository.findById(image_id);
    }

    // Reitti HTML-gallerian palauttamiseksi
    @RequestMapping(value = "/gallery", method = RequestMethod.GET)
    public String showGalleryPage(Model model) {
        model.addAttribute("images", imagerepository.findAll());
        return "gallery";
    }
}

