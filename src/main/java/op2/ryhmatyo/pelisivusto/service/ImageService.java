package op2.ryhmatyo.pelisivusto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.Date;
import java.util.Optional;
import op2.ryhmatyo.pelisivusto.domain.Image;
import op2.ryhmatyo.pelisivusto.domain.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    private final String PIXABAY_API_KEY = "46156034-444f3c2f3ed35bb2b993398bf"; // Lisää tähän oma API Key
    private final String PIXABAY_URL = "https://pixabay.com/api/";

    public Image searchAndSaveImage(String searchQuery) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = PIXABAY_URL + "?key=" + PIXABAY_API_KEY + "&q=" + searchQuery + "&image_type=photo";
    
        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonResponse = new JSONObject(response);
        
        if (jsonResponse.getJSONArray("hits").length() > 0) {
            String imageUrl = jsonResponse.getJSONArray("hits").getJSONObject(0).getString("webformatURL");
    
            // Tallenna kuva tietokantaan
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setSearchQuery(searchQuery);
            
            return imageRepository.save(image);
        } else {
            throw new Exception("Kuvaa ei löytynyt");
        }
    }
    
}
