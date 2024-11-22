package io.github.juniorcorzo.parser;

import java.util.HashMap;
import java.util.Map;

public class Hl7Parser {
    public static Map<String, String> parserHl7Message(String HL7Message) {
        Map<String, String> parserData = new HashMap<>();
        String[] segments = HL7Message.split("\\\\n");
        StringBuilder obx = new StringBuilder();

        for (String segment : segments) {
            String[] fields = segment.split("\\|");
            String field = fields[0];
            if (field.equals("OBX")) {
                obx.append(segment).append("~");
                continue;
            }
            parserData.put(field, segment);
        }
        parserData.put("OBX", obx.toString());


        return parserData;
    }

}
