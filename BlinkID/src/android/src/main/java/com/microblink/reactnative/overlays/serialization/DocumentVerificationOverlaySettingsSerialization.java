package com.microblink.reactnative.overlays.serialization;

import android.content.Context;

import com.facebook.react.bridge.ReadableMap;
import com.microblink.entities.recognizers.RecognizerBundle;
import com.microblink.fragment.overlay.blinkid.legacy.documentverification.LegacyDocumentVerificationOverlayStrings;
import com.microblink.reactnative.overlays.OverlaySettingsSerialization;
import com.microblink.uisettings.LegacyDocumentVerificationUISettings;
import com.microblink.uisettings.UISettings;

import static com.microblink.reactnative.SerializationUtils.getStringFromMap;

public final class DocumentVerificationOverlaySettingsSerialization implements OverlaySettingsSerialization {
    @Override
    public UISettings createUISettings(Context context, ReadableMap jsonUISettings, RecognizerBundle recognizerBundle) {
        LegacyDocumentVerificationUISettings settings = new LegacyDocumentVerificationUISettings(recognizerBundle);
        OverlaySerializationUtils.extractCommonUISettings(jsonUISettings, settings);
        BlinkIDOverlaySerializationUtils.extractCommonBlinkIdUiSettings(jsonUISettings, settings);

        LegacyDocumentVerificationOverlayStrings.Builder stringsBuilder = new LegacyDocumentVerificationOverlayStrings.Builder(context);

        String firstSideSplashMessage = getStringFromMap(jsonUISettings, "firstSideSplashMessage");
        if (firstSideSplashMessage != null) {
            stringsBuilder.setFrontSideSplashText(firstSideSplashMessage);
        }
        String secondSideSplashMessage = getStringFromMap(jsonUISettings, "secondSideSplashMessage");
        if (secondSideSplashMessage != null) {
            stringsBuilder.setBackSideSplashText(secondSideSplashMessage);
        }
        String firstSideInstructions = getStringFromMap(jsonUISettings, "firstSideInstructions");
        if (firstSideInstructions != null) {
            stringsBuilder.setFrontSideInstructions(firstSideInstructions);
        }
        String secondSideInstructions = getStringFromMap(jsonUISettings, "secondSideInstructions");
        if (secondSideInstructions != null) {
            stringsBuilder.setBackSideInstructions(secondSideInstructions);
        }
        String glareMessage = getStringFromMap(jsonUISettings, "glareMessage");
        if (glareMessage != null) {
            stringsBuilder.setGlareMessage(glareMessage);
        }
        settings.setStrings(stringsBuilder.build());
        return settings;
    }

    @Override
    public String getJsonName() {
        return "DocumentVerificationOverlaySettings";
    }
}