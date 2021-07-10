package org.book.examples;


import org.junit.jupiter.api.Test;

class EndPointTest {

    @Test
    void create() {
    }

    @Test
    void isValid() {

        boolean valid1 = EndPoint.isValid("google.com");
        boolean valid2 = EndPoint.isValid("yahoo.com");
        assert (valid1==valid2);

        boolean valid3 = EndPoint.isValid("google1.com");
        boolean valid4 = EndPoint.isValid("yahoo.com");
        assert (valid3!=valid4);

    }

    @Test
    void isStandard() {
        boolean standardPort = EndPoint.isStandardPort(8080);
        assert (true==standardPort);

        boolean nonStandardPort = EndPoint.isStandardPort(1976);
        assert (false==nonStandardPort);
    }

    @Test
    void testToString() {
    }
}