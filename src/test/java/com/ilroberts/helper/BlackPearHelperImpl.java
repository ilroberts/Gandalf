package com.ilroberts.helper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class BlackPearHelperImpl  {

    String json;

    @Before
    public void init() throws Exception {

        json = new String(readAllBytes(get("./src/test/resources/s1patient.json")));
    }

    @Test
    public void testJsonString() {

        assertThat(json.length() > 0);
    }

    @Test
    public void testPatient() {


    }

}
