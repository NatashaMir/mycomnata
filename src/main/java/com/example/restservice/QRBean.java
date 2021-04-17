package com.example.restservice;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QRBean {

    public static BufferedImage generateQRCode(String barcodeText) throws Exception {
        QRCodeWriter qrCodeeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                qrCodeeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

}
