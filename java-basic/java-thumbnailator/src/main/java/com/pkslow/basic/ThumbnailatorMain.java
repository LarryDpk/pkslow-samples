package com.pkslow.basic;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ThumbnailatorMain {
    public static void main(String[] args) throws IOException {
        String originalPic = "java-basic/java-thumbnailator/origin-pics/climb-up.4032x3024.jpeg";
        String picturePath = "java-basic/java-thumbnailator/output/";

        // 参数小且比例与原比例一样
        // 则按参数输出结果
        Thumbnails.of(originalPic)
                .size(400, 300)
                .toFile(picturePath + "climb-up.size.400X300.jpeg");

        // 参数大且比例不等
        // 则按比例放大，取最小的值
        Thumbnails.of(originalPic)
                .size(4400, 3400)
                .toFile(picturePath + "climb-up.size.4400X3300.jpeg");

        // 参数小且比例不等
        // 则按比例缩小，取最小的值
        Thumbnails.of(originalPic)
                .size(200, 300)
                .toFile(picturePath + "climb-up.size.200X150.jpeg");

        // 不保持比例
        // 则按参数输出结果
        Thumbnails.of(originalPic)
                .size(200, 300)
                .keepAspectRatio(false)
                .toFile(picturePath + "climb-up.size.notKeepRatio.200X300.jpeg");

        // 强制设置大小
        // 则按参数输出结果，与上个例子一样
        Thumbnails.of(originalPic)
                .forceSize(200, 300)
                .toFile(picturePath + "climb-up.forceSize.200X300.jpeg");

        // 比例小于1，缩小
        // 宽和高同时缩小为原来的0.1倍
        Thumbnails.of(originalPic)
                .scale(0.1f)
                .toFile(picturePath + "climb-up.scale.403X302.jpeg");

        // 比例大于1，放大
        // 宽和高同时放大为原来的1.1倍
        Thumbnails.of(originalPic)
                .scale(1.1f)
                .toFile(picturePath + "climb-up.scale.4435X3326.jpeg");

        // 按角度旋转
        Thumbnails.of(originalPic)
                .size(400,300)
                .rotate(45)
                .toFile(picturePath + "climb-up.rotate.45.jpeg");


        // 添加水印
        Thumbnails.of(originalPic)
                .size(2000,1500)
                .watermark(Positions.TOP_RIGHT, ImageIO.read(
                        new File("java-basic/java-thumbnailator/origin-pics/pkslow.size.400X300.jpeg")), 0.5f)
                .toFile(picturePath + "climb-up.watermark.jpeg");


        // 裁剪
        Thumbnails.of(originalPic)
                .sourceRegion(Positions.TOP_RIGHT, 1800, 1800)
                .size(400, 400)
                .toFile(picturePath + "climb-up.crop.jpeg");

        // 批量操作
        Thumbnails.of(Objects.requireNonNull(new File(picturePath).listFiles()))
                .size(400, 400)
                .toFiles(Rename.PREFIX_DOT_THUMBNAIL);

    }
}