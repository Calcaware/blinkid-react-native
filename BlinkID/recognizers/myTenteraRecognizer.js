import { Recognizer, RecognizerResult } from '../recognizer'
import {
    Date, 
    Point, 
    Quadrilateral,
    MrtdDocumentType, 
    MrzResult, 
    EudlCountry, 
    DocumentFaceDetectorType,
    ImageExtensionFactors,
} from '../types'

/**
 * Result object for MyTenteraRecognizer.
 */
export class MyTenteraRecognizerResult extends RecognizerResult {
    constructor(nativeResult) {
        super(nativeResult.resultState);
        
        /** 
         * the Malaysian tentra number. 
         */
        this.armyNumber = nativeResult.armyNumber;
        
        /** 
         *  face image from the document 
         */
        this.faceImage = nativeResult.faceImage;
        
        /** 
         *  image of the full document 
         */
        this.fullDocumentImage = nativeResult.fullDocumentImage;
        
        /** 
         * NRIC number (National Registration Identity Card Number) 
         */
        this.nricNumber = nativeResult.nricNumber;
        
        /** 
         * full owner address. 
         */
        this.ownerAddress = nativeResult.ownerAddress;
        
        /** 
         * extracted city from the owner address. 
         */
        this.ownerAddressCity = nativeResult.ownerAddressCity;
        
        /** 
         * extracted state from the owner address. 
         */
        this.ownerAddressState = nativeResult.ownerAddressState;
        
        /** 
         * extracted street from the owner address. 
         */
        this.ownerAddressStreet = nativeResult.ownerAddressStreet;
        
        /** 
         * extracted ZIP code from the owner address. 
         */
        this.ownerAddressZipCode = nativeResult.ownerAddressZipCode;
        
        /** 
         * owner's date of birth if it is successfully converted to {Date} from date format: <code>YYMMDD</code>. 
         */
        this.ownerBirthDate = nativeResult.ownerBirthDate;
        
        /** 
         * owner full name 
         */
        this.ownerFullName = nativeResult.ownerFullName;
        
        /** 
         * owner religion if written on MyTentera 
         */
        this.ownerReligion = nativeResult.ownerReligion;
        
        /** 
         * owner sex (M for male, F for female) 
         */
        this.ownerSex = nativeResult.ownerSex;
        
    }
}

/**
 *  Recognizer for reading Malaysian MyTentera document.

 */
export class MyTenteraRecognizer extends Recognizer {
    constructor() {
        super('MyTenteraRecognizer');
        
        /** 
         * Defines whether glare detector is enabled. 
         */
        this.detectGlare = true;
        
        /** 
         * true if full address of Malaysian MyTentera owner is being extracted 
         */
        this.extractFullNameAndAddress = true;
        
        /** 
         * true if religion of Malaysian MyTentera owner is being extracted 
         */
        this.extractReligion = true;
        
        /** 
         * Defines the DPI (Dots Per Inch) for full document image that should be returned. 
         */
        this.fullDocumentImageDpi = 250;
        
        /** 
         * Defines whether face image will be available in result. 
         */
        this.returnFaceImage = false;
        
        /** 
         * Defines whether full document image will be available in result. 
         */
        this.returnFullDocumentImage = false;
        
        this.createResultFromNative = function (nativeResult) { return new MyTenteraRecognizerResult(nativeResult); }
    }
}