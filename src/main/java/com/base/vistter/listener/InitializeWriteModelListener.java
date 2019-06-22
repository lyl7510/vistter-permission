package com.base.vistter.listener;

import com.base.vistter.domain.ModelComponent;
import com.base.vistter.domain.model.InterceptorModel;
import com.base.vistter.domain.model.VerifyModel;
import com.base.vistter.domain.model.WriteModel;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.List;

public class InitializeWriteModelListener implements CommandLineRunner {

    @Autowired
    private ModelComponent modelComponent;

    @Autowired
    private ResourceLoader resourceLoader;

    public void run(String... args){
        Element root = getDocument().getRootElement();
        this.analyzeDocument(root);
    }
    @SuppressWarnings("unchecked")
    private void analyzeDocument(Element root) {
        List<Element> list = root.elements();
        if (list != null && !list.isEmpty()) {
            for (Element element : list) {
                String name = element.attribute("name").getValue();
                String type = element.attribute("type").getValue();
                WriteModel model = new WriteModel(name , type);
                this.analyzeElement(model , element);
                modelComponent.addWriteModel(name, model);
            }
        }
    }
    @SuppressWarnings("unchecked")
    private void analyzeElement(WriteModel model , Element element){
         List<Element> interceptorElements = element.elements("interceptor");
         if(interceptorElements != null && !interceptorElements.isEmpty()){
             for(Element e : interceptorElements){
                 String name = e.attribute("name").getValue();
                 int code = Integer.parseInt(e.attribute("code").getValue());
                 model.getInterceptors().add(new InterceptorModel(name , code));
             }
         }
        List<Element> childrenElements = element.elements("element");
        if(childrenElements != null && !childrenElements.isEmpty()){
            for(Element e : childrenElements){
                String name = e.attribute("name").getValue();
                String type = e.attribute("type").getValue();
                model.getChildren().add(new WriteModel(name , type));
            }
        }
        Element verification = element.element("verification");
        if(verification != null){
            List<Element> verfiyList = verification.elements();
            for(Element e : verfiyList){
                VerifyModel verifyModel = new VerifyModel(e.getName() , e.attribute("name").getValue());
                model.getVerifications().add(verifyModel);
            }
        }
    }

    private Document getDocument(){
        Resource resource = resourceLoader.getResource("classpath:write.xml");
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
