package test;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author caoyixiong
 * @Date: 2018/11/28
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public enum FileTest {
    INSTANCE;

    private File offsetFile = null;
    private RandomAccessFile randomAccessFile = null;
    private String test;

    public void init() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(this::flush, 1, 3, TimeUnit.SECONDS);
    }

    public void aaa() {
        test = "This is a Test";
    }

    public String bbb() {
        return test;
    }

    public void ccc(List<String> list) {
        list.add("sadsadsad");
        list.add("1111111");
        list.add("222222");
    }

    private void flush() {
        String offsetRecord = "this is a test ";

        if (offsetFile == null) {
            System.err.println(" offsetFile 的值是空...");
        } else {
            System.out.println(" offsetFile 的值非空... ");
        }

        if (randomAccessFile == null) {
            System.err.println(" randomAccessFile 的值是空...");
        } else {
            System.out.println(" randomAccessFile 的值非空... ");
        }
        List<String> list = new ArrayList<>();

        System.out.println("List 的size是 " + list.size());

        String string = new String("");

        System.out.println("string是 " + string);

        FileUtils.INSTANCE.writeAppendToLast(offsetFile, randomAccessFile, offsetRecord, list, string);
    }
}