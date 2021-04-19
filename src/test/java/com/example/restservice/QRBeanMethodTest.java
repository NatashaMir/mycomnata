package com.example.restservice;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QRBeanMethodTest {

    private String url = "http://shorturl.com:8/lengthen/415207542";
    private QRBean qrBean = new QRBean();
    private BufferedImage bufferedImage;

    @BeforeEach
    public void setUp() throws Exception {
        bufferedImage = qrBean.generateQRCode(url);
    }

    @Test
    @DisplayName("Check QR code is created:")
    public void testQRBeanMethodCreated() throws Exception {
        assertNotNull(bufferedImage);
    }

    @Test
    @DisplayName("Check QR code decode:")
    public void testQRBeanMethodDecode() throws Exception {
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source)); //This class is the core bitmap class used by ZXing to represent 1 bit data. Reader objects accept a BinaryBitmap and attempt to decode it.
        assertEquals(url, new MultiFormatReader().decode(bitmap).getText());
    }

}
