package me.raatiniemi.spring.rest.sample.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class LinkTestEqualsHashCode {
    private final String message;
    private final Boolean expected;
    private final Link link;
    private final Object compareTo;

    public LinkTestEqualsHashCode(
            String message,
            Boolean expected,
            Link link,
            Object compareTo
    ) {
        this.message = message;
        this.expected = expected;
        this.link = link;
        this.compareTo = compareTo;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Link link = new Link("1", "http://example.com/");

        return Arrays.asList(
                new Object[][]{
                        {
                                "With same instance",
                                Boolean.TRUE,
                                link,
                                link
                        },
                        {
                                "With null",
                                Boolean.FALSE,
                                link,
                                null
                        },
                        {
                                "With incompatible object",
                                Boolean.FALSE,
                                link,
                                ""
                        },
                        {
                                "With different id",
                                Boolean.FALSE,
                                link,
                                new Link("2", "http://example.com/")
                        },
                        {
                                "With different url",
                                Boolean.FALSE,
                                link,
                                new Link("1", "https://example.com/")
                        }
                }
        );
    }

    @Test
    public void equals() {
        if (shouldBeEqual()) {
            assertEqual();
            return;
        }

        assertNotEqual();
    }

    private Boolean shouldBeEqual() {
        return expected;
    }

    private void assertEqual() {
        assertTrue(message, link.equals(compareTo));

        validateHashCodeWhenEqual();
    }

    private void validateHashCodeWhenEqual() {
        assertTrue(message, link.hashCode() == compareTo.hashCode());
    }

    private void assertNotEqual() {
        assertFalse(message, link.equals(compareTo));

        validateHashCodeWhenNotEqual();
    }

    private void validateHashCodeWhenNotEqual() {
        if (null == compareTo) {
            return;
        }

        assertFalse(message, link.hashCode() == compareTo.hashCode());
    }
}
