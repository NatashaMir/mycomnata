package com.example.restservice;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QRBean {

    public BufferedImage generateQRCode(String barcodeText) throws Exception {
        QRCodeWriter qrCodeeWriter = new QRCodeWriter(); //This object renders a QR Code as a BitMatrix 2D array of greyscale values
        //Represents a 2D matrix of bits:
        BitMatrix bitMatrix = //
                qrCodeeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200); //encode in interface Writer

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

}
