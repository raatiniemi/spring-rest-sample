package me.raatiniemi.spring.rest.sample.service;

import me.raatiniemi.spring.rest.sample.model.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
class LinkService {
    private AtomicLong counter = new AtomicLong();
    private List<Link> links = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, value = "/links")
    public List<Link> get(
            @RequestParam(value = "per_page", defaultValue = "20") long perPage,
            @RequestParam(value = "page", defaultValue = "0") long page
    ) {
        long skip = perPage * page;

        return this.links.stream()
                .skip(skip)
                .limit(perPage)
                .collect(Collectors.toList());
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "/links")
    public Link add(@RequestBody String url) {
        Link link = new Link(
                String.valueOf(this.counter.getAndIncrement()),
                url
        );

        this.links.add(link);
        return link;
    }
}
