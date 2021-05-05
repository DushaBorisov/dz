package dz1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        boolean flagR = false;
        String dir = null;
        String filename = null;
        System.out.println(System.getProperty("user.dir"));

        //перебираем все элементы массива args(массив входных параметров)
        for(int i =0; i < args.length; i++){
            if((args[i]).equals("-r") ) flagR = true;
            if((args[i]).equals("-d")){  dir = args[i + 1];}
            if( i == (args.length -1)) filename = args[i];

        }

        //если дирректория для поиска файла не была передана в виде параметра, установливаем значение корневой дирректории проекта
        if(dir == null) dir = System.getProperty("user.dir");


        List<String> results = new ArrayList<String>();

        //вызываем статический метод поиска указанного файла, передавая емк параметры, получен. из командной строки
       Searcher.search(dir,filename,flagR, results);
       for(String el : results) System.out.println(el);
    }
}

class Searcher {


    public static List<String> search(String directory, String fileName, boolean r, List<String> results) {

        //создаем объект клдасса File, в конструктор передаем имя дирректории, полученной из параметров командной строки
        File dir = new File(directory);

        // проверяем наличие этой дирректории
        if (!dir.exists()) {
            System.out.println("Указанная дирректория не существует!!!");
            return null;
        }

            // Получаем массив всех файлов содержащихся в созданной дирректории
            File[] fileArray = dir.listFiles();


            //проверяем, не пустая ли дирректория
            if (fileArray != null) {

                // проверяем значение параметра -r, отвечающего за поиск в поддиректриях. В данном случае в поддиректориях не ищем указанный файл
                if (r == false) {

                    // перебираем все файлы
                    for (File file : fileArray) {
                        // если перебираемый элемент является файлом(не дирректорией) приступаем к сравнению его имени с именем fileName
                        if (!file.isDirectory()){

                            if((file.getName()).equals((String)fileName)) {

                               //возвращаем абсолютный путь файла, если файл найден
                               // System.out.println(file.getAbsolutePath());
                                results.add(file.getAbsolutePath());
                            }
                        }
                    }

                }
                // если флаг -r был задан ищем во всех поддиректориях указанной дирректории

                else {
                    for (File file : fileArray) {
                        // проверяем является ли дирректорией и проверяем, не был ли найден уже интересующий нас файл. Может так получиться, что файл будет найден в самой первой дирректории
                        //но при этом будут иметься и другие дирректории, чтобы не проходить по ним и не искать в них при уэе найденном файле, проверяем, не был ли найден файл
                        if (file.isDirectory() ) {
                            //вызываем рекурсивно метод search(), в качестве первого параметра передаем абсолютный путь той дирректории на которой остановились в цикле for each
                             search(file.getPath(), fileName, true,results);
                        }else{

                            // если имя файла совпало с искомым, возвращаем его абсолютный путь
                            if((file.getName()).equals((String)fileName)){
                                //System.out.println(file.getAbsolutePath());
                                results.add(file.getAbsolutePath());
                            }
                        }
                    }


                }
            } else System.out.println("Папка пустая!!!");

            return results;
    }
}
