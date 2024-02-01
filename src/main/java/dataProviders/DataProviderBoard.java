package dataProviders;

import models.BoardDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderBoard {

    @DataProvider
    public Iterator<Object[]> dataProvider_createNewBoardPositiveTest_DP() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardDTO.builder().boardTitle("dataProvider1").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("dataProvider2").build()});
        list.add(new Object[]{BoardDTO.builder().boardTitle("dataProvider3").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProvider_deleteBoardPositiveTest_DP() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_delete1").build()});
        //list.add(new Object[]{BoardDTO.builder().boardTitle("DP_delete2").build()});
       // list.add(new Object[]{BoardDTO.builder().boardTitle("DP_delete3").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataProvider_createNewBoardPositiveTest_DPFile() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/data_boards.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{BoardDTO.builder().boardTitle(split[0]).build()});
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.listIterator();
    }
}
