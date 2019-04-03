package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 * @author caoyixiong
 * @Date: 2018/11/28
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public enum FileUtils {
    INSTANCE;

    public void writeAppendToLast(File file, RandomAccessFile randomAccessFile, String value, List<String> list, String string) {
        if (file == null) {
            file = new File("/Users/caoyixiong/Desktop/offset.txt");
            System.out.println("FileUtils 新建了一个File");
        }
        list.add("dadasdadas");
        string += "1234";
        if (randomAccessFile == null) {
            try {
                randomAccessFile = new RandomAccessFile(file, "rwd");
                System.out.println("FileUtils 新建了一个randomAccessFile");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            long length = randomAccessFile.length();
            randomAccessFile.seek(length);
            randomAccessFile.writeBytes(System.lineSeparator());
            randomAccessFile.writeBytes(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
