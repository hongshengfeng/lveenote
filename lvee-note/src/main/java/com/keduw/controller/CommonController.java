package com.keduw.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author hongshengfeng
 * @date 2020.07.03
 * @version 1.0.1
 */

@Controller
@RequestMapping("comm")
public class CommonController extends BaseController{

    @Autowired(required = false)
    private DefaultKaptcha kaptcha;

    @GetMapping("/code")
    public void getKaptchaCode(HttpServletResponse response) throws Exception {
        byte[] numCodeImgByte = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            String code = kaptcha.createText();
            BufferedImage bi = kaptcha.createImage(code);
            // 将图片写入到流中
            ImageIO.write(bi, "jpg", stream);
        } catch (IOException e) {
            logger.error("图片写入异常", e);
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("系统异常", e);
            e.printStackTrace();
        }
        numCodeImgByte = stream.toByteArray();
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(numCodeImgByte);
        outputStream.close();
    }

}
