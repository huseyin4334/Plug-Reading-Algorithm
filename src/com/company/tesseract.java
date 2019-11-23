package com.company;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



public class tesseract {
    Tesseract tesseract_ocr = new Tesseract();
    Tesseract instance = Tesseract.getInstance();


    String text;

    public void oku(String path){
            instance.setDatapath("/home/huseyin/Downloads/Compressed/Tess4J-3.4.8-src/Tess4J/tessdata");
            instance.setLanguage("tur");
            tesseract_ocr.setDatapath("/home/huseyin/Downloads/Compressed/Tess4J-3.4.8-src/Tess4J/tessdata");
            System.out.println("burda");
            //BufferedImage resim = treshold(path);
            // load the image stored in fn
                BufferedImage im = null;
                try {
                    im = ImageIO.read(new FileInputStream(path));
                    text = tesseract_ocr.doOCR(im);
                } catch (Exception e) {
                    System.out.println("Could not load " + path);
                    e.printStackTrace();
                    System.exit(0);
                }





            // path of your image file

    }





    public BufferedImage sharped(String path) throws IOException {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

        Mat image = Imgcodecs.imread(path,0);

        Mat dst = new Mat();


        Mat destination = new Mat(image.rows(),image.cols(),image.type());
        Imgproc.GaussianBlur(image, destination, new Size(0,0), 10);
        Core.addWeighted(image, 1.5, destination, -0.5, 0, destination);
        Imgcodecs.imwrite("sharp.jpg", destination);

        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".png", dst, matOfByte);
        Imgcodecs.imwrite("el.png",dst);
        byte[] byteArray = matOfByte.toArray();

        //Preparing the Buffered Image
        InputStream in = new ByteArrayInputStream(byteArray);

        BufferedImage read = ImageIO.read(in);

        return read;
    }


}
