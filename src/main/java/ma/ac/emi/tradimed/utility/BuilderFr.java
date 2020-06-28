package ma.ac.emi.tradimed.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BuilderFr {

    public Map<String, List<String>> buildDictionary(String path) {
        Map<String, List<String>> dictionary = new HashMap<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                List<String> term = Arrays.asList(line.split(cvsSplitBy));
                String ligne = term.toString();
                List<String> props=new ArrayList<>();
                for(int i=1;i<term.size();i++){
                    props.add(term.get(i));
                }
                dictionary.put(term.get(0), props);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dictionary;
    }


}

