package com.flowAccount.api;

import com.flowAccount.api.entity.Object_Configuration;
import com.flowAccount.api.repository.ConfigurationRepository;
import com.flowAccount.api.repository.FlowAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DbInitializer implements CommandLineRunner {

    private FlowAccountRepository flowAccRepository;
    private ConfigurationRepository configRepository;

    public DbInitializer(FlowAccountRepository flowAccRepository) {
        this.flowAccRepository = flowAccRepository;
    }


    //@Override
    public void run(String... args) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);


       // INITIALIZE THE DATABASE AND POPULATE IT WITH SOME DUMMY FLOW-NAME,FLOW-TYPE AND IS-DELETED DATA
        //RUN THIS ONLY ONCE, AS SOON DB IS POPULATED.

/*          // for Flow  object
        Object_Master obj1 = new Object_Master("GATCPH", "FLOW", false);
        Object_Master obj2 = new Object_Master("JFKGAT", "FLOW", false);

        this.accountRepository.save(obj1);
        this.accountRepository.save(obj2);
*/

            // for flow configuratio

      try{
/*
          BufferedImage bufferedImage = ImageIO.read(new File("../arrow.png"));
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          ImageIO.write(bufferedImage, "png", baos);
          Blob blFile = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());



        Object_Configuration config1 = new Object_Configuration("001", "EASYJET AIRLINES", "consistent and faithful customer",timestamp,blFile);
        Object_Configuration config2 = new Object_Configuration("002", "BAE AIRLINES", "consistent and faithful customer",timestamp,blFile);


        this.configRepository.save(config1);
        this.configRepository.save(config2);
*/
    }catch(Exception e){
        e.printStackTrace();
    }


}


        public BufferedImage loadImage(File file)
        {
            BufferedImage img = null;
            try
            {
                img = ImageIO.read(file);
            } catch (java.io.IOException e)
            {
                e.printStackTrace();
            }
            return img;
        }


}
