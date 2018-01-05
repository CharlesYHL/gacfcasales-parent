package com.gacfcasales.common.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.gacfcasales.common.entity.Codes;

/**
 * @author Charles
 * @Title: JsonToXML
 * @Package 
 * @Description: TODO
 * @date 2017/9/28 14:26
 */
public class JsonToXML {
    public static String json2xml(String jsonString) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.write(JSONSerializer.toJSON(jsonString));
        // return xmlSerializer.write(JSONArray.fromObject(jsonString));//这种方式只支持JSON数组
    }


    public static String json2Xml(String json, String rootName) throws DocumentException {
        String sXml = "";
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setTypeHintsEnabled(false);
        xmlSerializer.setRootName(rootName);
        String sContent = xmlSerializer.write(JSONSerializer.toJSON(json));
        try {
            Document docCon = DocumentHelper.parseText(sContent);
            sXml = docCon.getRootElement().asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return sXml;
    }

    public static void main(String[] args) throws DocumentException {
        JSONArray jsonArray = new JSONArray();
        Codes codeA = new Codes();
        codeA.setCode(200);
        codeA.setMessage("成功");
        jsonArray.add(codeA);

        Codes  codeB= new Codes();
        codeB.setCode(500);
        codeB.setMessage("失败");
        jsonArray.add(codeB);

        //JSONObject dataJson= new JSONObject();
        //dataJson.put("data",jsonArray);
        //String json = "[{ \"code\": 200, \"message\": \"成功\"},{\"code\": 500, \"message\": \"失败\"}]";
        //System.out.println(json2xml(jsonArray.toString()));

        System.out.println(json2Xml(jsonArray.toString(),"Result"));
    }
}
