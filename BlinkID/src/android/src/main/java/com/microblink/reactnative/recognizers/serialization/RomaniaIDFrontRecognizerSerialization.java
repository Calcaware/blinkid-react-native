package com.microblink.reactnative.recognizers.serialization;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.reactnative.recognizers.RecognizerSerialization;

public final class RomaniaIDFrontRecognizerSerialization implements RecognizerSerialization {
    @Override
    public Recognizer<?, ?> createRecognizer(ReadableMap jsonRecognizer) {
        com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer recognizer = new com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer();
        if (jsonRecognizer.hasKey("detectGlare")) {
            recognizer.setDetectGlare(jsonRecognizer.getBoolean("detectGlare"));
        }
        if (jsonRecognizer.hasKey("extractAddress")) {
            recognizer.setExtractAddress(jsonRecognizer.getBoolean("extractAddress"));
        }
        if (jsonRecognizer.hasKey("extractFirstName")) {
            recognizer.setExtractFirstName(jsonRecognizer.getBoolean("extractFirstName"));
        }
        if (jsonRecognizer.hasKey("extractIssuedBy")) {
            recognizer.setExtractIssuedBy(jsonRecognizer.getBoolean("extractIssuedBy"));
        }
        if (jsonRecognizer.hasKey("extractLastName")) {
            recognizer.setExtractLastName(jsonRecognizer.getBoolean("extractLastName"));
        }
        if (jsonRecognizer.hasKey("extractNonMRZSex")) {
            recognizer.setExtractNonMRZSex(jsonRecognizer.getBoolean("extractNonMRZSex"));
        }
        if (jsonRecognizer.hasKey("extractPlaceOfBirth")) {
            recognizer.setExtractPlaceOfBirth(jsonRecognizer.getBoolean("extractPlaceOfBirth"));
        }
        if (jsonRecognizer.hasKey("extractValidFrom")) {
            recognizer.setExtractValidFrom(jsonRecognizer.getBoolean("extractValidFrom"));
        }
        if (jsonRecognizer.hasKey("extractValidUntil")) {
            recognizer.setExtractValidUntil(jsonRecognizer.getBoolean("extractValidUntil"));
        }
        if (jsonRecognizer.hasKey("returnFaceImage")) {
            recognizer.setReturnFaceImage(jsonRecognizer.getBoolean("returnFaceImage"));
        }
        if (jsonRecognizer.hasKey("returnFullDocumentImage")) {
            recognizer.setReturnFullDocumentImage(jsonRecognizer.getBoolean("returnFullDocumentImage"));
        }
        return recognizer;
    }

    @Override
    public WritableMap serializeResult(Recognizer<?, ?> recognizer) {
        com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer.Result result = ((com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer)recognizer).getResult();
        WritableMap jsonResult = new WritableNativeMap();
        SerializationUtils.addCommonResultData(jsonResult, result);
        jsonResult.putBoolean("MRZParsed", result.isMRZParsed());
        jsonResult.putString("MRZText", result.getMRZText());
        jsonResult.putBoolean("MRZVerified", result.isMRZVerified());
        jsonResult.putString("address", result.getAddress());
        jsonResult.putString("alienNumber", result.getAlienNumber());
        jsonResult.putString("applicationReceiptNumber", result.getApplicationReceiptNumber());
        jsonResult.putString("cNP", result.getCNP());
        jsonResult.putMap("dateOfBirth", SerializationUtils.serializeDate(result.getDateOfBirth()));
        jsonResult.putMap("dateOfExpiry", SerializationUtils.serializeDate(result.getDateOfExpiry()));
        jsonResult.putString("documentCode", result.getDocumentCode());
        jsonResult.putString("documentNumber", result.getDocumentNumber());
        jsonResult.putInt("documentType", SerializationUtils.serializeEnum(result.getDocumentType()));
        jsonResult.putString("faceImage", SerializationUtils.encodeImageBase64(result.getFaceImage()));
        jsonResult.putString("firstName", result.getFirstName());
        jsonResult.putString("fullDocumentImage", SerializationUtils.encodeImageBase64(result.getFullDocumentImage()));
        jsonResult.putString("identityCardNumber", result.getIdentityCardNumber());
        jsonResult.putString("identityCardSeries", result.getIdentityCardSeries());
        jsonResult.putString("immigrantCaseNumber", result.getImmigrantCaseNumber());
        jsonResult.putString("issuedBy", result.getIssuedBy());
        jsonResult.putString("issuer", result.getIssuer());
        jsonResult.putString("lastName", result.getLastName());
        jsonResult.putString("nationality", result.getNationality());
        jsonResult.putString("nonMRZNationality", result.getNonMRZNationality());
        jsonResult.putString("nonMRZSex", result.getNonMRZSex());
        jsonResult.putString("opt1", result.getOpt1());
        jsonResult.putString("opt2", result.getOpt2());
        jsonResult.putString("parentNames", result.getParentNames());
        jsonResult.putString("placeOfBirth", result.getPlaceOfBirth());
        jsonResult.putString("primaryId", result.getPrimaryId());
        jsonResult.putString("secondaryId", result.getSecondaryId());
        jsonResult.putString("sex", result.getSex());
        jsonResult.putMap("validFrom", SerializationUtils.serializeDate(result.getValidFrom()));
        jsonResult.putMap("validUntil", SerializationUtils.serializeDate(result.getValidUntil()));
        return jsonResult;
    }

    @Override
    public String getJsonName() {
        return "RomaniaIDFrontRecognizer";
    }

    @Override
    public Class<?> getRecognizerClass() {
        return com.microblink.entities.recognizers.blinkid.romania.RomaniaIDFrontRecognizer.class;
    }
}