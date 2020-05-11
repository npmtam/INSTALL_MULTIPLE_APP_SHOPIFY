package commons;

import java.util.ArrayList;
import java.util.List;

public class ReadDataCSV {
    public List<String> parseCsvLine (String csvLine){
        List<String> result = new ArrayList<String>();
        if(csvLine != null){
            String[] splitData = csvLine.split(Constants.COMMA_DELIMITER);
            for(int i = 0; i < splitData.length; i++){
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public void initStoreData(List<String> store){
        String url = store.get(0);
        String urlSplit1 = url.substring(8);
        Constants.STORE_URL_CSV = urlSplit1.substring(0, urlSplit1.length() - 14);
        Constants.STORE_EMAIL_CSV = store.get(1);
        Constants.STORE_NAME_CSV = store.get(2);
        Constants.STORE_TYPE_CSV = store.get(3);
        System.out.println("STORE URL: " + Constants.STORE_URL_CSV);
        System.out.println("EMAIL: " + Constants.STORE_EMAIL_CSV);
        System.out.println("STORE NAME: " + Constants.STORE_NAME_CSV);
        System.out.println("STORE TYPE: " + Constants.STORE_TYPE_CSV);

    }
}
