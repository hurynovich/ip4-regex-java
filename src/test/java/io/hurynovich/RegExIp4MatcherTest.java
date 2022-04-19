package io.hurynovich;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.TestInstanceFactory;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RegExIp4MatcherTest {

    @Nested
    class Rx1 implements Ip4MatcherTest {
        public Ip4Matcher getInstance() {
            return RegExIp4Matcher.rx1();
        }
    }

    @Nested
    class Rx2 implements Ip4MatcherTest {
        public Ip4Matcher getInstance() {
            return RegExIp4Matcher.rx2();
        }
    }

}