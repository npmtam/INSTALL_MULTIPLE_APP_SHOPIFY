package pageObject;

import commons.AbstractPage;
import commons.ReadDataCSV;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OriginalPO extends AbstractPage {
    WebDriver driver;
    ReadDataCSV readDataCSV = new ReadDataCSV();
    String root_Path = System.getProperty("user.dir");
    String fileCSV = root_Path + "/src/test/resources/readStoreData.csv";

    public OriginalPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void inputStoreURL(){

    }

    public void readDataCsv(){
        BufferedReader br = null;
        try{
            String line;
            br = new BufferedReader(new FileReader(fileCSV));

            //Read file in java line by line
            while ((line = br.readLine()) != null) {
                while ((line = br.readLine()) != null) {
                    while ((line = br.readLine()) != null) {
                        readDataCSV.initStoreData(readDataCSV.parseCsvLine(line));
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

}
