package com.base.vistter.listener;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;

public class FileUtils {

    @SuppressWarnings("unchecked")
    public static Document getDocument(File file) throws org.dom4j.DocumentException{
        SAXReader reader = new SAXReader();
        return reader.read(file);
    }
}
