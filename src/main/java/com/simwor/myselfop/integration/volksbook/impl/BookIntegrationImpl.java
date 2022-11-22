package com.simwor.myselfop.integration.volksbook.impl;

import com.simwor.myselfop.integration.volksbook.BookIntegration;
import com.simwor.volksbook.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookIntegrationImpl implements BookIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Book queryByIsbn(String isbn) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl("http://localhost:9000/book/query-by-isbn")
                .queryParam("isbn", "{isbn}")
                .encode()
                .toUriString();

        Map<String, String> params = new HashMap<>();
        params.put("isbn", isbn);

        ResponseEntity<Book> exchange = restTemplate.exchange(urlTemplate,
                HttpMethod.GET,
                entity,
                Book.class,
                params);

        return exchange.getBody();
    }

}
