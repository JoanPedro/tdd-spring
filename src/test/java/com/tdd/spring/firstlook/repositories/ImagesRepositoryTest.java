package com.tdd.spring.firstlook.repositories;

import com.tdd.spring.firstlook.domain.files.Images;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ImagesRepositoryTest {

  @Autowired
  ImagesRepository imagesRepository;

  @Test
  void TestImageSave() throws IOException {
    File readFile = new File("C:\\Users\\joansouz\\Pictures\\wallpaper\\wallpaper_capgemini_final.jpg");

    byte[] imgData = new byte[(int) readFile.length()];

    FileInputStream inputStream = new FileInputStream(readFile);
    inputStream.read(imgData);

    Images img = new Images(null, "capgeminiLogo.jpg", imgData);

    imagesRepository.save(img);
    inputStream.close();

    Images rImg = imagesRepository.findById(1L).get();

    File downloadFile = new File("C:\\Users\\joansouz\\Pictures\\wallpaper\\downloaded\\".concat(rImg.getName()));
    FileOutputStream outputStream = new FileOutputStream(downloadFile);
    outputStream.write(rImg.getData());
    outputStream.close();

    Assertions.assertNotNull(rImg);
  }
}
