package iba;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileExtensionSorter {


    public static void main(String... args){
        System.out.println("Enter path of directory:");
        Scanner in = new Scanner(System.in);
        String input_directory = in.nextLine();

        File dir = new File(input_directory);
        if ((!dir.isDirectory())  && (!dir.exists())){
            System.out.println("Not directory or not exists");
            return;
        }

        List<String> listDir = Arrays.asList(dir.list());
        String newDirName;
        for (String fileName:listDir) {
            if (fileName.lastIndexOf(".") != -1) {
                newDirName = fileName.substring(fileName.lastIndexOf(".")+1);
                new File( input_directory + "\\" + newDirName).mkdir();

                new File(input_directory+ "\\" + fileName)
                        .renameTo(new File(input_directory + "\\" + newDirName + "\\" + fileName));
            }
        }
    }
}
