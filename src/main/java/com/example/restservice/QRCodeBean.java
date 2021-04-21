package com.example.restservice;


public class QRCodeBean {

    private String qrCode;
    private URLBean url;


    public QRCodeBean(String qrCode, URLBean url) {
        this.qrCode = qrCode;
        this.url = url;
    }


    @Override
    public String toString() {
        return "QRCodeBean{" +
                "qrCode='" + qrCode + '\'' +
                ", url=" + url +
                '}';
    }

    public String getQrCode() {
        return qrCode;
    }

    public URLBean getUrl() {
        return url;
    }
}
