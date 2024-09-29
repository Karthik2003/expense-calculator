package com.striim.ec;

import java.util.*;

public class StringArrayTest {

    public static void main(String[] args) {
        String[] words = {"ace", "boom", "crew", "dog", "eon"};

        List<String> wordList = Arrays.asList(words);

        for (String e : wordList) {
            //System.out.println(e);
        }
        inputparam("nswregodvs");
    }
    private static void inputparam(String input) {
        String out = String.format("greenid_%s_number", input);
        System.out.println(out);
    }


// 1st approach
    private void setFieldsForMediCare(CandidateVerifyRequestModel req, List<NameValuePair> nameValueList,
                                      FieldV3 field) {
        String fieldName = field.getName();
        NameValuePair pair = new NameValuePair();
        pair.setName(fieldName);
        if (field.getName().equals(sourceIdmappings.getMappings().get("medicare.dvsno"))) {
            pair.setValue(req.getMediCare().getMedicareNo());
        } else if (field.getName().equals(sourceIdmappings.getMappings().get("medicare.refno"))) {
            pair.setValue(req.getMediCare().getIndividualReferenceNumber());
        } else if (field.getName().equals(sourceIdmappings.getMappings().get("medicare.expiry"))) {
            pair.setValue(req.getMediCare().getExpiry());
        }else if (field.getName().equals(sourceIdmappings.getMappings().get("medicare.name"))) {
            pair.setValue(req.getMediCare().getNameOnCard());
        }else if (field.getName().equals(sourceIdmappings.getMappings().get("medicare.colour"))) {
            pair.setValue(req.getMediCare().getCardColor());
        }else if (field.getName().equals(sourceIdmappings.getMappings().get("medicare.tandc"))) {
            pair.setValue(TANDC);
        } else {
            pair.setValue(field.getValue());
        }
        nameValueList.add(pair);
    }


// 2nd approach
private void setFieldsForMediCare(CandidateVerifyRequestModel req, List<NameValuePair> nameValueList,
                                  FieldV3 field) {
    String fieldName = field.getName();
    NameValuePair pair = new NameValuePair();
    pair.setName(fieldName);
    switch (name) {
        case "medicare.dvsno": {
            pair.setValue(req.getMediCare().getMedicareNo());
            break;
        }
        case "medicare.refno": {
            pair.setValue(req.getMediCare().getIndividualReferenceNumber());
            break;
        }
        case "medicare.expiry": {
            pair.setValue(req.getMediCare().getExpiry());
            break;
        }
        case "medicare.name": {
            pair.setValue(req.getMediCare().getNameOnCard());
            break;
        }
        case "medicare.colour": {
            pair.setValue(req.getMediCare().getCardColor());
            break;
        }
        case "medicare.tandc": {
            pair.setValue(TANDC);
            break;
        }
        default: {
            pair.setValue(field.getValue());
            break;
        }
    }
    nameValueList.add(pair);
}

// 3rd approach (https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java)
    private void setFieldsForMediCare(CandidateVerifyRequestModel req, List<NameValuePair> nameValueList,
                                      FieldV3 field) {
        String fieldName = field.getName();
        NameValuePair pair = new NameValuePair();
        pair.setName(fieldName);
        Map<String, Runnable> methodMap = new HashMap<>();
        methodMap.put("medicare.dvsno", () -> req.getMediCare().getMedicareNo());
        methodMap.put("medicare.refno", () -> req.getMediCare().getIndividualReferenceNumber());
        methodMap.put("medicare.expiry", () -> req.getMediCare().getExpiry());
        methodMap.put("medicare.name", () -> req.getMediCare().getNameOnCard());
        methodMap.put("medicare.colour", () -> req.getMediCare().getCardColor());
        //methodMap.put("medicare.tandc", TANDC);

        pair.setValue(methodMap.get(fieldName).run());
        nameValueList.add(pair);
    }


// 4th approach
    private void setFieldsForMediCare(CandidateVerifyRequestModel req, List<NameValuePair> nameValueList,
                                      FieldV3 field) {
        String fieldName = field.getName();
        NameValuePair pair = new NameValuePair();
        pair.setName(fieldName);
        pair.setValue(Optional.ofNullable(fieldName)
                .map(medNo -> req.getMediCare().getMedicareNo())
                .map(refNo -> req.getMediCare().getIndividualReferenceNumber())
                .map(exp -> req.getMediCare().getExpiry())
                .map(namCard -> req.getMediCare().getNameOnCard())
                .map(col -> req.getMediCare().getCardColor())
                .map(tan -> TANDC)
                .orElse(field.getValue());
        nameValueList.add(pair);
    }

// 5th approach
    private void setFieldsForMediCare(CandidateVerifyRequestModel req, List<NameValuePair> nameValueList,
                                      FieldV3 field) {
        String fieldName = field.getName();
        NameValuePair pair = new NameValuePair();
        pair.setName(fieldName);
        pair.setValue(Optional.ofNullable(fieldName)
                .map(Optional::of)
                .orElseGet(() -> req.getMediCare().getMedicareNo())
                .orElseGet(() -> req.getMediCare().getIndividualReferenceNumber())
                .orElseGet(() -> req.getMediCare().getExpiry())
                .orElseGet(() -> req.getMediCare().getNameOnCard())
                .orElseGet(() -> req.getMediCare().getCardColor())
                .orElseGet(() -> TANDC)
                .orElseGet(() -> field.getValue());
        nameValueList.add(pair);
    }