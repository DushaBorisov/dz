package dz1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTest {

    static String homePath;

    @BeforeAll
    static void beforeAll() {
        homePath= System.getProperty("user.dir");
    }



    @Test
    void search_success_with_r_attribute_and_with_dir_name() {
        assertTrue( (Searcher.search(homePath,"text1.txt", true, new ArrayList<String>())).contains(homePath +"\\testData\\text1.txt" ));

    }


}