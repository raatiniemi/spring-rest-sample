package me.raatiniemi.spring.rest.sample.model;

import java.util.Objects;

@SuppressWarnings("ALL")
public class Link {
    private final long id;
    private final String url;

    public Link(long id, String url) {
        this.id = id;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Link)) {
            return false;
        }

        Link that = (Link) o;
        return getId() == that.getId()
                && Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + Objects.hashCode(getUrl());

        return result;
    }
}
