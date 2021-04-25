package dz1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTest1 {


    @Test
    void search_success_with_r_attribute_and_with_dir_name() {

        assertEquals("C:\\Users\\Andrey\\Desktop\\lll\\some\\2\\3\\text2.txt", Searcher.search("C:\\Users\\Andrey\\Desktop\\Java\\DZ\\src\\main\\java\\dz1", "text2.txt",true));
    }


}