package com.javase.day10;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.Data;
import org.json.JSONException;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.*;

/**
 * ClassName:DemoJson
 * Package:com.javase.day10
 * Description:
 *
 * @date:2019/7/27 13:41
 * @author: 574986060@qq.com
 */

public class DemoJson {
    static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        String json ="{\n" +
                "  \"data\": {\n" +
                "    \"city\": \"深圳\",\n" +
                "    \"temphigh\": \"25\",\n" +
                "    \"templow\": \"19\",\n" +
                "    \"updatetime\": \"2017-11-04 13:23:00\",\n" +
                "    \"tempnow\": \"24\",\n" +
                "    \"sendibletemp\": \"27\",\n" +
                "    \"winddirect\": \"东北风\",\n" +
                "    \"windpower\": \"2级\",\n" +
                "    \"humidity\": \"42\",\n" +
                "    \"sunrise\": \"06:29\",\n" +
                "    \"sunset\": \"17:45\",\n" +
                "    \"weather\": \"多云\",\n" +
                "    \"week\": \"星期六\",\n" +
                "    \"nl\": null,\n" +
                "    \"date\": \"2017-11-04\",\n" +
                "    \"index\": [\n" +
                "      {\n" +
                "        \"name\": \"化妆指数\",\n" +
                "        \"level\": \"控油\",\n" +
                "        \"msg\": \"建议用露质面霜打底，水质无油粉底霜，透明粉饼，粉质胭脂。\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"感冒指数\",\n" +
                "        \"level\": \"易发\",\n" +
                "        \"msg\": \"感冒容易发生，少去人群密集的场所有利于降低感冒的几率。\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"洗车指数\",\n" +
                "        \"level\": \"不宜\",\n" +
                "        \"msg\": \"雨(雪)水和泥水会弄脏您的爱车，不适宜清洗车辆。\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"穿衣指数\",\n" +
                "        \"level\": \"舒适\",\n" +
                "        \"msg\": \"白天温度适中，但早晚凉，易穿脱的便携外套很实用。\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"紫外线强度指数\",\n" +
                "        \"level\": \"弱\",\n" +
                "        \"msg\": \"辐射较弱，涂擦SPF12-15、PA+护肤品。\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"运动指数\",\n" +
                "        \"level\": \"不适宜\",\n" +
                "        \"msg\": \"受到阵雨天气的影响，不宜在户外运动。\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"pm25\": {\n" +
                "      \"aqi\": 0,\n" +
                "      \"co\": 8,\n" +
                "      \"o3\": 42,\n" +
                "      \"pm10\": 63,\n" +
                "      \"pm2_5\": 64,\n" +
                "      \"quality\": \"良\",\n" +
                "      \"so2\": 4,\n" +
                "      \"no2\": 11,\n" +
                "      \"updatetime\": \"2017-11-04 13:00:00\"\n" +
                "    },\n" +
                "    \"daily\": [\n" +
                "      {\n" +
                "        \"date\": \"2017-11-04\",\n" +
                "        \"week\": \"星期六\",\n" +
                "        \"sunrise\": \"06:29\",\n" +
                "        \"sunset\": \"17:45\",\n" +
                "        \"temphigh\": \"25\",\n" +
                "        \"templow\": \"19\",\n" +
                "        \"weather\": \"多云\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2017-11-05\",\n" +
                "        \"week\": \"星期日\",\n" +
                "        \"sunrise\": \"06:29\",\n" +
                "        \"sunset\": \"17:45\",\n" +
                "        \"temphigh\": \"26\",\n" +
                "        \"templow\": \"19\",\n" +
                "        \"weather\": \"多云\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2017-11-06\",\n" +
                "        \"week\": \"星期一\",\n" +
                "        \"sunrise\": \"06:29\",\n" +
                "        \"sunset\": \"17:45\",\n" +
                "        \"temphigh\": \"27\",\n" +
                "        \"templow\": \"20\",\n" +
                "        \"weather\": \"多云\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2017-11-07\",\n" +
                "        \"week\": \"星期二\",\n" +
                "        \"sunrise\": \"06:29\",\n" +
                "        \"sunset\": \"17:45\",\n" +
                "        \"temphigh\": \"28\",\n" +
                "        \"templow\": \"21\",\n" +
                "        \"weather\": \"多云\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2017-11-08\",\n" +
                "        \"week\": \"星期三\",\n" +
                "        \"sunrise\": \"06:29\",\n" +
                "        \"sunset\": \"17:45\",\n" +
                "        \"temphigh\": \"29\",\n" +
                "        \"templow\": \"22\",\n" +
                "        \"weather\": \"多云\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2017-11-09\",\n" +
                "        \"week\": \"星期四\",\n" +
                "        \"sunrise\": \"06:29\",\n" +
                "        \"sunset\": \"17:45\",\n" +
                "        \"temphigh\": \"28\",\n" +
                "        \"templow\": \"22\",\n" +
                "        \"weather\": \"多云\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2017-11-03\",\n" +
                "        \"week\": \"星期五\",\n" +
                "        \"sunrise\": \"06:29\",\n" +
                "        \"sunset\": \"17:45\",\n" +
                "        \"temphigh\": \"28\",\n" +
                "        \"templow\": \"18\",\n" +
                "        \"weather\": \"晴\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"status\": 0,\n" +
                "  \"msg\": \"ok\"\n" +
                "}";

//        JSONObject object = new JSONObject();
//         mapper.writeValueAsString(obj);
//        TypeReference<T> type
//     mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));


        Student student = new Student();
        student.setName("tom");
        student.setPassword("123456");

        student.setHobby(Arrays.asList("basketball", "football", "have sex"));

        String string = mapper.writeValueAsString(student);
        System.out.println(string);

        Student student1 = mapper.readValue(string, Student.class);


        Student student2 = nativeRead(string, new TypeReference<Student>() {});

        System.out.println("student2 = " + student2);

        System.out.println(student1);
        mapper.readValue(string, new TypeReference<Student>() {});

        Map<String, Object> map = new JacksonJsonParser().parseMap(json);
        System.out.println(map);

        Set<String> strings = map.keySet();
        strings.forEach(
                (k)->{
                    System.out.println(map.get(k));
                }
        );




        JsonNode jsonNode = mapper.readTree(json);

        System.out.println("------------------------->");
        Iterator<JsonNode> elements = jsonNode.elements();

        elements.forEachRemaining(
                (k)->{
                    k.forEach(
                            (v)->{
                               v.forEach(
                                       (t)->{
                                           t.forEach(
                                                   w->{

                                                       System.out.println(w);
                                                   }
                                           );
                                       }
                               );
                            }
                    );
                }
        );


        String mm = ""+"";

    }

    @Nullable
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {

            return null;
        }
    }


}
@Data
class Student{
    private String name;
    private String password;
    private List<String> hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }
}