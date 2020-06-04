package com.microblink.reactnative;

import android.graphics.Bitmap;
import android.util.Base64;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.microblink.entities.recognizers.Recognizer;
//import com.microblink.entities.parsers.Parser;
import com.microblink.geometry.Point;
import com.microblink.geometry.Quadrilateral;
import com.microblink.image.Image;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.ImageExtensionFactors;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class SerializationUtils {
    private static final int COMPRESSED_IMAGE_QUALITY = 90;

    public static <T extends Recognizer.Result> void addCommonRecognizerResultData(WritableMap jsonObject, T result) {
        jsonObject.putInt("resultState", serializeEnum(result.getResultState()));
    }

    /*public static <T extends Parser.Result> void addCommonParserResultData(WritableMap jsonObject, T result) {
        jsonObject.putInt("resultState", serializeEnum(result.getResultState()));
    }*/

    public static WritableMap serializeDate(Date date) {
        if (date != null ) {
            WritableMap jsonDate = new WritableNativeMap();
            jsonDate.putInt("day", date.getDay());
            jsonDate.putInt("month", date.getMonth());
            jsonDate.putInt("year", date.getYear());
            return jsonDate;
        } else {
            return null;
        }
    }

    public static WritableMap serializeDate(DateResult dateResult) {
        if (dateResult == null) {
            return null;
        } else {
            return serializeDate(dateResult.getDate());
        }
    }

    public static int serializeEnum(Enum e) {
        return e.ordinal() + 1;
    }

    public static WritableArray serializeStringArray(String[] strings) {
        WritableArray jsonStrings = new WritableNativeArray();
        for (String str : strings) {
            jsonStrings.pushString(str);
        }
        return jsonStrings;
    }

    public static String encodeImageBase64(Image image) {
        if (image == null) {
            return null;
        }
        Bitmap resultImgBmp = image.convertToBitmap();
        if (resultImgBmp == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean success = resultImgBmp.compress(Bitmap.CompressFormat.JPEG, COMPRESSED_IMAGE_QUALITY, byteArrayOutputStream);
        String resultImgBase64 = null;
        if (success) {
            resultImgBase64 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.NO_WRAP);
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException ignorable) {}
        return resultImgBase64;
    }

    public static String encodeByteArrayToBase64(byte[] arr) {
        if (arr == null) {
            return null;
        }
        return Base64.encodeToString(arr, Base64.NO_WRAP);
    }

    public static WritableMap serializePoint(Point point) {
        WritableMap jsonPoint = new WritableNativeMap();
        jsonPoint.putDouble("x", point.getX());
        jsonPoint.putDouble("y", point.getY());
        return jsonPoint;
    }

    public static WritableMap serializeQuad(Quadrilateral quad) {
        WritableMap jsonQuad = new WritableNativeMap();
        jsonQuad.putMap("upperLeft", serializePoint(quad.getUpperLeft()));
        jsonQuad.putMap("upperRight", serializePoint(quad.getUpperRight()));
        jsonQuad.putMap("lowerLeft", serializePoint(quad.getLowerLeft()));
        jsonQuad.putMap("lowerRight", serializePoint(quad.getLowerRight()));
        return jsonQuad;
    }

    public static ImageExtensionFactors deserializeExtensionFactors(ReadableMap jsonExtensionFactors) {
        if (jsonExtensionFactors == null) {
            return new ImageExtensionFactors(0.f, 0.f, 0.f, 0.f);
        } else {
            float up = (float)jsonExtensionFactors.getDouble("upFactor");
            float right = (float)jsonExtensionFactors.getDouble("rightFactor");
            float down = (float)jsonExtensionFactors.getDouble("downFactor");
            float left = (float)jsonExtensionFactors.getDouble("leftFactor");
            return new ImageExtensionFactors(up, down, left, right);
        }
    }

    public static String getStringFromMap(ReadableMap map, String key) {
        if (map.hasKey(key)) {
            return map.getString(key);
        }
        return null;
    }
}
