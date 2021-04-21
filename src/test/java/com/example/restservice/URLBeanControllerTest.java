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
    @DisplayName("Check hash")
    public void testShorten() {
        doReturn("happyEnd").when(shortener).encode(url);
        assertEquals(new URLBean("http://shorturl.com:8/lengthen/happyEnd"), controller.shorten(url));
    }

    @Test
    @DisplayName("Check QR code")
    public void testGetQRCode() throws Exception {
        doReturn("happyEnd").when(shortener).encode(url);
        //doReturn("qrcodeTest").when(qrCodeBean);
        QRCodeBean actual = controller.getQRCode(url);
        actual.getQrCode();
        assertThat(actual.getQrCode(), Matchers.startsWith("data:image/png;base64,"));
        assertEquals(new URLBean("http://shorturl.com:8/lengthen/happyEnd"), actual.getUrl());
    }

}
