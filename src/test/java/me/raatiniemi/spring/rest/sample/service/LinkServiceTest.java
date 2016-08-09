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

    public LinkServiceTest(Link[] expected, String[] urls) {
        this.expected = Arrays.asList(expected);
        this.urls = urls;
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
                                }
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
                this.linkService.get()
        );
    }
}
