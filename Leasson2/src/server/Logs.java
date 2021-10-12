package server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logs {
    private final File logs = new File("src/server/logs.txt");

    public void write(String message){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logs, true))){
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readAll(){
        try (BufferedReader br = new BufferedReader(new FileReader(logs))) {
            List<String> arrayList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null){
                arrayList.add(line);
            }
            return arrayList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readLastCounts(int count){
        List<String> arrayList = readAll();
        List<String> countArrayList = new ArrayList<>();
        if (arrayList.size() > count - 1){
            int index = arrayList.size() - 100;
            for (int i = index ; i < arrayList.size(); i++) {
                countArrayList.add(arrayList.get(i));
            }
            return countArrayList;
        }
        return arrayList;
    }
}
