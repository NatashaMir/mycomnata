package com.example.restservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;


@SpringBootTest()
public class URLBeanControllerTest {

    @MockBean(name = "real")
    Storage storage;

    @MockBean
    ServerPortService serverPort;

    @MockBean
    Shortener shortener;

    @MockBean
    QRCodeBean qrCodeBean;

    @Autowired
    private URLBeanController controller;
    String url = "https://www.vogella.com/tutorials/JUnit/article.html";

    @BeforeEach
    public void setUp() {
        doReturn(8).when(serverPort).getPort();
    }


    @Test
    @DisplayName("Check shorten method")
    public void testShorten() {
        doReturn("happyEnd").when(shortener).encode(url);
        assertEquals(new URLBean("http://shorturl.com:8/lengthen/happyEnd"), controller.shorten(url));
    }

    @Test
    @DisplayName("Check lengthen method successful")
    public void testAnswerMethodTrue() {
        doReturn(url).when(storage).get("" + url.hashCode());
        //URLBeanControllerTest.shorten(url);
        String hash = "" + url.hashCode();
        assertEquals(new URLBean("Your full URL https://www.vogella.com/tutorials/JUnit/article.html"), controller.lengthen(hash));
    }

    @Test
    @DisplayName("Check lengthen method unsuccessful:")
    public void testAnswerMethodFalse() {
        assertEquals(new URLBean("Your full URL doesn't exists"), controller.lengthen("123456789"));
    }

    @Test
    @DisplayName("Check QR code")
    public void testGetQRCode() throws Exception {
        doReturn("happyEnd").when(shortener).encode(url);
        QRCodeBean actual = controller.getQRCode(url);
        actual.getQrCode();
        assertThat(actual.getQrCode(), Matchers.startsWith("data:image/png;base64,"));
        assertEquals(new URLBean("http://shorturl.com:8/lengthen/happyEnd"), actual.getUrl());
    }

}
