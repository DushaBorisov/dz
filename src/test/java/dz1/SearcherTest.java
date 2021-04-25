package dz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTest {


    @Test
    void search_success_with_r_attribute_and_with_dir_name() {
        assertEquals("C:\\Users\\Andrey\\Desktop\\Java\\DZ\\src\\main\\java\\dz1\\1\\2\\text2.txt",Searcher.search("C:\\Users\\Andrey\\Desktop\\Java\\DZ\\src\\main\\java\\dz1", "text2.txt",true));

    }

    @Test
    void search_unsuccessful_with_r_attribute_and_with_dir_name() {
        assertEquals(null,Searcher.search("C:\\Users\\Andrey\\Desktop\\Java\\DZ\\src\\main\\java\\dz1", "text3.txt",true));

    }


    @Test
    void search_success_without_r_attribute_and_with_dir_name() {
        assertEquals("C:\\Users\\Andrey\\Desktop\\Java\\DZ\\src\\main\\java\\dz1\\text1.txt",Searcher.search("C:\\Users\\Andrey\\Desktop\\Java\\DZ\\src\\main\\java\\dz1", "text1.txt",false));

    }

    @Test
    void search_unsuccessful_without_r_attribute_and_with_dir_name() {
        assertEquals(null,Searcher.search("C:\\Users\\Andrey\\Desktop\\Java\\DZ\\src\\main\\java\\dz1", "text2.txt",false));

    }


}