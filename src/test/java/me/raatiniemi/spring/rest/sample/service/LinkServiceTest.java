package me.raatiniemi.spring.rest.sample.service;

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
    private List<String> links;

    public LinkServiceTest(String... links) {
        this.links = Arrays.asList(links);
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(
                new Object[][]{
                        {
                                new String[]{
                                        "http://example.com/"
                                }
                        }
                }
        );
    }

    @Test
    public void test() {
        for (String link : this.links) {
            this.linkService.add(link);
        }

        assertEquals(
                this.links,
                this.linkService.get()
        );
    }
}
