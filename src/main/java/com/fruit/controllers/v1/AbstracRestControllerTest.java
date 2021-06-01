package com.fruit.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstracRestControllerTest {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
