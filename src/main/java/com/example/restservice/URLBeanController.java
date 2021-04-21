package com.example.restservice;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;


@RestController
public class URLBeanController {

    private final Storage hmap;
    private final ServerPortService server;
    private final Shortener shortener;
    private final QRCodeService qrCodeService;

    private static final String template_answer = "Your full URL %s";

    public URLBeanController(@Qualifier("real") Storage storage, ServerPortService server, Shortener shortener, QRCodeService qrCodeService) {
        hmap = storage;
        this.server = server;
        this.shortener = shortener;
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/shorten")
    public URLBean shorten(@RequestParam(value = "url", defaultValue = "") String url) {
        String shortUrl = shortener.encode(url);
        hmap.put("" + shortUrl, url);
        return new URLBean(String.format("http://shorturl.com:" + server.getPort() + "/lengthen/%s", shortUrl));
    }

    @GetMapping("/lengthen/{shortURL}")
    public URLBean lengthen(@PathVariable(value = "shortURL") String shortURL) {
        String answer = hmap.get(shortURL);
        if (answer != null) {
            return new URLBean(String.format(template_answer, answer));
        } else {
            return new URLBean(String.format(template_answer, "doesn't exists"));
        }
    }

    @GetMapping("/qrcode")
    public QRCodeBean getQRCode(@RequestParam(value = "url", defaultValue = "") String url) throws Exception {
        URLBean urlBean = shorten(url);
        BufferedImage qrCode = qrCodeService.generateQRCode(urlBean.getUrl());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(qrCode, "PNG", byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        String base64bytes = Base64.encode(bytes);

        return new QRCodeBean("data:image/png;base64," + base64bytes, urlBean);
    }


}
