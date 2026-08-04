package com.rocketseat.front_gestao.candidate.utils;


import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class FormatErrorMessage {

    public static String formatErrorMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(message);
            if (rootNode.isArray()){
                return formatArrayErrorMessage(rootNode);
            }
            return rootNode.asText();
        } catch (Exception ex) {
           return message;
        }
    }
    public static String formatArrayErrorMessage(JsonNode arrayNode){
        StringBuilder formattedMessage = new StringBuilder();
        for (JsonNode node : arrayNode){
            formattedMessage.append("- ").append(node.get("message").asText()).append("\n");
        }
        return formattedMessage.toString();
    }

}
