package me.raatiniemi.spring.rest.sample.model;

import java.util.Objects;

@SuppressWarnings("ALL")
public class Link {
    private final String id;
    private final String url;

    public Link(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
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
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getUrl(), that.getUrl());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getUrl());

        return result;
    }
}
