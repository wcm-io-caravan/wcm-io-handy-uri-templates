package com.damnhandy.uri.template;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestUriTemplate {

    /**
     * Test against a regression with Java 21.
     * <p>
     * See <a href="https://github.com/damnhandy/Handy-URI-Templates/issues/77">#77</a> for more information.
     */
    @Test
    public void handleEmptyLists() {
        var result = UriTemplate.fromTemplate("http://api{?empty_list}")
        .set(Map.of("empty_list", List.of()))
        .expand();

        assertEquals("http://api", result);
    }

    @Test
    public void handleNonEmptyLists() {
        var result = UriTemplate.fromTemplate("http://api{?list}")
        .set(Map.of("list", List.of("value1", "value2")))
        .expand();

        assertEquals("http://api?list=value1,value2", result);
    }

}
