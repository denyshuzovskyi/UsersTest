package ua.com.brdo.users.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.brdo.users.dtos.CommentsDTO;

@Component
@RequiredArgsConstructor
public class DummyJSONClient {
    private final RestTemplate restTemplate;

    @Value("${dummyjson.comments.uri}")
    private String commentsUri;

    public CommentsDTO getAllComments() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(commentsUri)
                .queryParam("skip", 0)
                .queryParam("limit", 0);

        ResponseEntity<CommentsDTO> response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), CommentsDTO.class);

        return response.getBody();
    }
}
