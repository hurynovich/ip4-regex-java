package io.hurynovich;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
interface Ip4MatcherTest {

    Ip4Matcher getInstance();

    @ParameterizedTest
    @ValueSource(strings = {
            "0.0.0.0",
            "9.9.9.9",
            "99.99.99.99",
            "255.255.255.255",
    })
    default void testToIntValidIp(String ip4) {
       assertTrue(getInstance().isValid(ip4));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0,0,0,0",
            "0.0.0.0.",
            ".0.0.0.0",
            "0..0.0",
            "256.0.0.0",
            "265.0.0.0",
            "355.0.0.0",
    })
    default void testToIntInvalidIp(String ip4) {
        assertFalse(getInstance().isValid(ip4));
    }
}