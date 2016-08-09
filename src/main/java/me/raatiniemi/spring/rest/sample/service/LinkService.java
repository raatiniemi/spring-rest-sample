package me.raatiniemi.spring.rest.sample.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LinkService {
    private List<String> links = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, value = "/links")
    public List<String> get() {
        return this.links;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/links")
    public String add(@RequestBody String link) {
        this.links.add(link);

        return link;
    }
}
