package web.Util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.*;
import java.util.Date;

/**
 * Created by zhengzhang on 2016/6/11.
 */
public class TextFileIndexer {
    public static void aa() {
        File fileDir = new File("D:\\source");
        File IndexDir = new File("D:\\index");
        Directory dir = null;
        IndexWriter indexWriter =null;
        Analyzer luceneAna = new StandardAnalyzer(Version.LUCENE_36);
        IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_36,luceneAna);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);


        File[] textFiles = fileDir.listFiles();
        long startTime = new Date().getTime();
        try {
            dir = FSDirectory.open(IndexDir);
            indexWriter = new IndexWriter(dir,iwc);
            for(int i=0;i<textFiles.length;i++){
                if (textFiles[i].isFile()
                        && textFiles[i].getName().endsWith(".txt")) {
                    System.out.println("File " + textFiles[i].getCanonicalPath()
                            + "正在被索引....");
                    String temp = FileReaderAll(textFiles[i].getCanonicalPath(),
                            "GBK");
                    //System.out.println(temp);
                    Document document = new Document();
                    Field FieldPath = new Field("path", textFiles[i].getPath(),
                            Field.Store.YES, Field.Index.NO);
                    Field FieldBody = new Field("body", temp, Field.Store.YES,
                            Field.Index.ANALYZED,
                            Field.TermVector.WITH_POSITIONS_OFFSETS);
                    document.add(FieldPath);
                    document.add(FieldBody);
                    indexWriter.addDocument(document);
                }
            }

            indexWriter.close();
        } catch (IOException e) {

        }finally {

        }


        //测试一下索引的时间
        long endTime = new Date().getTime();
//        System.out
//                .println("这花费了"
//                        + (endTime - startTime)
//                        + " 毫秒来把文档增加到索引里面去!"
//                        + fileDir.getPath());
    }

    public static String FileReaderAll(String FileName, String charset)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(FileName), charset));
        String line = new String();
        String temp = new String();

        while ((line = reader.readLine()) != null) {
            temp += line;
        }
        reader.close();
        return temp;
    }
}
