package com.base.vistter.listener;

import com.base.vistter.domain.ModelComponent;
import com.base.vistter.domain.model.ReadModel;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.List;

public class InitializeReadModelListener implements CommandLineRunner {

    @Autowired
    private ModelComponent modelComponent;

    @Autowired
    private ResourceLoader resourceLoader;

    public void run(String... args){
        Element root = this.getDocument().getRootElement();
        this.analyzeDocument(root);
    }
    @SuppressWarnings("unchecked")
    private void analyzeDocument(Element root) {
        List<Element> list = root.elements();
        if (list != null && !list.isEmpty()) {
            for (Element element : list) {
                String name = element.attribute("name").getValue();
                ReadModel model = generModel(element, name);
                this.serializeModel(model, element.elements());
                modelComponent.addReadModel(name, model);
            }
        }
    }
    @SuppressWarnings("unchecked")
    private void serializeModel(ReadModel model, List<Element> elements) {
        if (elements != null && !elements.isEmpty()) {
            for (Element element : elements) {
                ReadModel m = generModel(element, null);
                List<Element> elementChildren = element.elements();
                if (elementChildren != null && !elementChildren.isEmpty()) {
                    this.serializeModel(m, elementChildren);
                }
                model.add(m);
            }
        }
    }

    private ReadModel generModel(Element element, String name) {
        ReadModel model = new ReadModel();
        /*统计*/
        Attribute countAttribute = element.attribute("count");
        if (countAttribute != null) {
            model.setCount(Boolean.valueOf(countAttribute.getValue()));
        }
        /*单条数据*/
        Attribute singleAttribute = element.attribute("single");
        if (singleAttribute != null) {
            model.setSingle(Boolean.valueOf(singleAttribute.getValue()));
        }
        /*数据列表*/
        Attribute dataAttribute = element.attribute("data");
        if (dataAttribute != null) {
            model.setData(Boolean.valueOf(dataAttribute.getValue()));
        }
        /*别名*/
        Attribute refAttribute = element.attribute("ref");
        if (refAttribute != null) {
            model.setRef(refAttribute.getValue());
        }
        if (StringUtils.isEmpty(name)) {
            model.setModelId(element.attribute("name").getValue());
        } else {
            model.setModelId(name);
        }
        return model;
    }

    private Document getDocument(){
        Resource resource = resourceLoader.getResource("classpath:read.xml");
        try {
            return FileUtils.getDocument(resource.getFile());
        }catch (java.io.IOException e){
            e.printStackTrace();
        }catch (org.dom4j.DocumentException e){
            e.printStackTrace();
        }
        return null;
    }
}
