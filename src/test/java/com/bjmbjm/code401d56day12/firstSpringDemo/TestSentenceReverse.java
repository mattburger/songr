package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSentenceReverse {

    @Test
    public void testSentenceReverse() {
        SentenceReverse sr = new SentenceReverse(1, "Hello world");

        assertEquals("getId should return the id of the instance.", 1, sr.getId());

        assertEquals("getSentence should return the passed in string in reverse.", "world Hello", sr.getSentence());

    }


    @Test(expected = IllegalArgumentException.class)
    public void testSentenceReverse_fail() {
        SentenceReverse sr = new SentenceReverse(-1, "Hello world");
        SentenceReverse sr2 = new SentenceReverse(1, "");

        assertEquals("exception should be thrown before this method is even called.", -1, sr.getId());
        assertEquals("exception should be thrown before this method is even called.", "", sr2.getSentence());
    }
}
