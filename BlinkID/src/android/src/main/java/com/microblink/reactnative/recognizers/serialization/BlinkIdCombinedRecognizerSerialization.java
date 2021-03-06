package com.microblink.reactnative.recognizers.serialization;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.reactnative.recognizers.RecognizerSerialization;
import com.microblink.reactnative.SerializationUtils;

public final class BlinkIdCombinedRecognizerSerialization implements RecognizerSerialization {
    @Override
    public Recognizer<?> createRecognizer(ReadableMap jsonMap) {
        com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer recognizer = new com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer();
        if (jsonMap.hasKey("allowBlurFilter")) {
            recognizer.setAllowBlurFilter(jsonMap.getBoolean("allowBlurFilter"));
        }
        if (jsonMap.hasKey("allowUncertainFrontSideScan")) {
            recognizer.setAllowUncertainFrontSideScan(jsonMap.getBoolean("allowUncertainFrontSideScan"));
        }
        if (jsonMap.hasKey("allowUnparsedMrzResults")) {
            recognizer.setAllowUnparsedMrzResults(jsonMap.getBoolean("allowUnparsedMrzResults"));
        }
        if (jsonMap.hasKey("allowUnverifiedMrzResults")) {
            recognizer.setAllowUnverifiedMrzResults(jsonMap.getBoolean("allowUnverifiedMrzResults"));
        }
        if (jsonMap.hasKey("anonymizationMode")) {
            recognizer.setAnonymizationMode(com.microblink.entities.recognizers.blinkid.generic.AnonymizationMode.values()[jsonMap.getInt("anonymizationMode") - 1]);
        }
        if (jsonMap.hasKey("faceImageDpi")) {
            recognizer.setFaceImageDpi(jsonMap.getInt("faceImageDpi"));
        }
        if (jsonMap.hasKey("fullDocumentImageDpi")) {
            recognizer.setFullDocumentImageDpi(jsonMap.getInt("fullDocumentImageDpi"));
        }
        if (jsonMap.hasKey("fullDocumentImageExtensionFactors")) {
            recognizer.setFullDocumentImageExtensionFactors(SerializationUtils.deserializeExtensionFactors(jsonMap.getMap("fullDocumentImageExtensionFactors")));
        }
        if (jsonMap.hasKey("maxAllowedMismatchesPerField")) {
            recognizer.setMaxAllowedMismatchesPerField(jsonMap.getInt("maxAllowedMismatchesPerField"));
        }
        if (jsonMap.hasKey("paddingEdge")) {
            recognizer.setPaddingEdge((float)jsonMap.getDouble("paddingEdge"));
        }
        if (jsonMap.hasKey("recognitionModeFilter")) {
            recognizer.setRecognitionModeFilter(BlinkIDSerializationUtils.deserializeRecognitionModeFilter(jsonMap.getMap("recognitionModeFilter")));
        }
        if (jsonMap.hasKey("returnFaceImage")) {
            recognizer.setReturnFaceImage(jsonMap.getBoolean("returnFaceImage"));
        }
        if (jsonMap.hasKey("returnFullDocumentImage")) {
            recognizer.setReturnFullDocumentImage(jsonMap.getBoolean("returnFullDocumentImage"));
        }
        if (jsonMap.hasKey("returnSignatureImage")) {
            recognizer.setReturnSignatureImage(jsonMap.getBoolean("returnSignatureImage"));
        }
        if (jsonMap.hasKey("scanCroppedDocumentImage")) {
            recognizer.setScanCroppedDocumentImage(jsonMap.getBoolean("scanCroppedDocumentImage"));
        }
        if (jsonMap.hasKey("signResult")) {
            recognizer.setSignResult(jsonMap.getBoolean("signResult"));
        }
        if (jsonMap.hasKey("signatureImageDpi")) {
            recognizer.setSignatureImageDpi(jsonMap.getInt("signatureImageDpi"));
        }
        if (jsonMap.hasKey("skipUnsupportedBack")) {
            recognizer.setSkipUnsupportedBack(jsonMap.getBoolean("skipUnsupportedBack"));
        }
        if (jsonMap.hasKey("validateResultCharacters")) {
            recognizer.setValidateResultCharacters(jsonMap.getBoolean("validateResultCharacters"));
        }
        return recognizer;
    }

    @Override
    public WritableMap serializeResult(Recognizer<?> recognizer) {
        com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer.Result result = ((com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer)recognizer).getResult();
        WritableMap jsonResult = new WritableNativeMap();
        SerializationUtils.addCommonRecognizerResultData(jsonResult, result);
        jsonResult.putString("additionalAddressInformation", result.getAdditionalAddressInformation());
        jsonResult.putString("additionalNameInformation", result.getAdditionalNameInformation());
        jsonResult.putString("address", result.getAddress());
        jsonResult.putInt("age", result.getAge());
        jsonResult.putMap("backImageAnalysisResult", BlinkIDSerializationUtils.serializeImageAnalysisResult(result.getBackImageAnalysisResult()));
        jsonResult.putInt("backProcessingStatus", SerializationUtils.serializeEnum(result.getBackProcessingStatus()));
        jsonResult.putMap("backVizResult", BlinkIDSerializationUtils.serializeVizResult(result.getBackVizResult()));
        jsonResult.putMap("barcodeResult", BlinkIDSerializationUtils.serializeBarcodeResult(result.getBarcodeResult()));
        jsonResult.putMap("classInfo", BlinkIDSerializationUtils.serializeClassInfo(result.getClassInfo()));
        jsonResult.putMap("dateOfBirth", SerializationUtils.serializeDate(result.getDateOfBirth()));
        jsonResult.putMap("dateOfExpiry", SerializationUtils.serializeDate(result.getDateOfExpiry()));
        jsonResult.putBoolean("dateOfExpiryPermanent", result.isDateOfExpiryPermanent());
        jsonResult.putMap("dateOfIssue", SerializationUtils.serializeDate(result.getDateOfIssue()));
        jsonResult.putString("digitalSignature", SerializationUtils.encodeByteArrayToBase64(result.getDigitalSignature()));
        jsonResult.putInt("digitalSignatureVersion", (int)result.getDigitalSignatureVersion());
        jsonResult.putString("documentAdditionalNumber", result.getDocumentAdditionalNumber());
        jsonResult.putInt("documentDataMatch", SerializationUtils.serializeEnum(result.getDocumentDataMatch()));
        jsonResult.putString("documentNumber", result.getDocumentNumber());
        jsonResult.putString("documentOptionalAdditionalNumber", result.getDocumentOptionalAdditionalNumber());
        jsonResult.putMap("driverLicenseDetailedInfo", BlinkIDSerializationUtils.serializeDriverLicenseDetailedInfo(result.getDriverLicenseDetailedInfo()));
        jsonResult.putString("employer", result.getEmployer());
        jsonResult.putBoolean("expired", result.isExpired());
        jsonResult.putString("faceImage", SerializationUtils.encodeImageBase64(result.getFaceImage()));
        jsonResult.putString("fathersName", result.getFathersName());
        jsonResult.putString("firstName", result.getFirstName());
        jsonResult.putMap("frontImageAnalysisResult", BlinkIDSerializationUtils.serializeImageAnalysisResult(result.getFrontImageAnalysisResult()));
        jsonResult.putInt("frontProcessingStatus", SerializationUtils.serializeEnum(result.getFrontProcessingStatus()));
        jsonResult.putMap("frontVizResult", BlinkIDSerializationUtils.serializeVizResult(result.getFrontVizResult()));
        jsonResult.putString("fullDocumentBackImage", SerializationUtils.encodeImageBase64(result.getFullDocumentBackImage()));
        jsonResult.putString("fullDocumentFrontImage", SerializationUtils.encodeImageBase64(result.getFullDocumentFrontImage()));
        jsonResult.putString("fullName", result.getFullName());
        jsonResult.putString("issuingAuthority", result.getIssuingAuthority());
        jsonResult.putString("lastName", result.getLastName());
        jsonResult.putString("localizedName", result.getLocalizedName());
        jsonResult.putString("maritalStatus", result.getMaritalStatus());
        jsonResult.putString("mothersName", result.getMothersName());
        jsonResult.putMap("mrzResult", BlinkIDSerializationUtils.serializeMrzResult(result.getMrzResult()));
        jsonResult.putString("nationality", result.getNationality());
        jsonResult.putString("personalIdNumber", result.getPersonalIdNumber());
        jsonResult.putString("placeOfBirth", result.getPlaceOfBirth());
        jsonResult.putInt("processingStatus", SerializationUtils.serializeEnum(result.getProcessingStatus()));
        jsonResult.putString("profession", result.getProfession());
        jsonResult.putString("race", result.getRace());
        jsonResult.putInt("recognitionMode", SerializationUtils.serializeEnum(result.getRecognitionMode()));
        jsonResult.putString("religion", result.getReligion());
        jsonResult.putString("residentialStatus", result.getResidentialStatus());
        jsonResult.putBoolean("scanningFirstSideDone", result.isScanningFirstSideDone());
        jsonResult.putString("sex", result.getSex());
        jsonResult.putString("signatureImage", SerializationUtils.encodeImageBase64(result.getSignatureImage()));
        return jsonResult;
    }

    @Override
    public String getJsonName() {
        return "BlinkIdCombinedRecognizer";
    }

    @Override
    public Class<?> getRecognizerClass() {
        return com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer.class;
    }
}