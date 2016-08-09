package me.raatiniemi.spring.rest.sample.service;

import me.raatiniemi.spring.rest.sample.model.Link;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LinkServiceTest {
    private LinkService linkService = new LinkService();

    private List<Link> expected;
    private String[] urls;
    private long perPage;
    private long page;

    public LinkServiceTest(
            Link[] expected,
            String[] urls,
            long perPage,
            long page
    ) {
        this.expected = Arrays.asList(expected);
        this.urls = urls;
        this.perPage = perPage;
        this.page = page;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(
                new Object[][]{
                        {
                                new Link[]{
                                        new Link(0, "http://example.com/")
                                },
                                new String[]{
                                        "http://example.com/"
                                },
                                20,
                                0
                        },
                        {
                                new Link[]{
                                        new Link(4, "http://example.com/4"),
                                        new Link(5, "http://example.com/5")
                                },
                                new String[]{
                                        "http://example.com/0",
                                        "http://example.com/1",
                                        "http://example.com/2",
                                        "http://example.com/3",
                                        "http://example.com/4",
                                        "http://example.com/5",
                                        "http://example.com/6",
                                        "http://example.com/7",
                                        "http://example.com/8",
                                        "http://example.com/9",
                                        "http://example.com/10",
                                        "http://example.com/11"
                                },
                                2,
                                2
                        }
                }
        );
    }

    @Test
    public void test() {
        for (String url : this.urls) {
            this.linkService.add(url);
        }

        assertEquals(
                this.expected,
                this.linkService.get(perPage, page)
        );
    }
}
