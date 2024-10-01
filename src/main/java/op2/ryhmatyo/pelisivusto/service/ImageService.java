package op2.ryhmatyo.pelisivusto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import op2.ryhmatyo.pelisivusto.domain.Image;
import op2.ryhmatyo.pelisivusto.domain.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${pixabay.api.key}")
    private String pixabayApiKey;

    private final String PIXABAY_URL = "https://pixabay.com/api/";

    public Image searchAndSaveImage(String searchQuery) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = PIXABAY_URL + "?key=" + pixabayApiKey + "&q=" + searchQuery + "&image_type=photo";

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
