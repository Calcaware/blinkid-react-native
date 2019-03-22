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
 * Result object for RomaniaIdFrontRecognizer.
 */
export class RomaniaIdFrontRecognizerResult extends RecognizerResult {
    constructor(nativeResult) {
        super(nativeResult.resultState);
        
        /** 
         * The address of Romania ID owner. 
         */
        this.address = nativeResult.address;
        
        /** 
         * The date of expiry of Romania ID. 
         */
        this.dateOfExpiry = nativeResult.dateOfExpiry != null ? new Date(nativeResult.dateOfExpiry) : null;
        
        /** 
         * The date of issue of Romania ID. 
         */
        this.dateOfIssue = nativeResult.dateOfIssue != null ? new Date(nativeResult.dateOfIssue) : null;
        
        /** 
         * Face image from the document 
         */
        this.faceImage = nativeResult.faceImage;
        
        /** 
         * The first name of Romania ID owner. 
         */
        this.firstName = nativeResult.firstName;
        
        /** 
         * Image of the full document 
         */
        this.fullDocumentImage = nativeResult.fullDocumentImage;
        
        /** 
         * The issuing authority of Romania ID. 
         */
        this.issuedBy = nativeResult.issuedBy;
        
        /** 
         * The data extracted from the machine readable zone. 
         */
        this.mrzResult = nativeResult.mrzResult != null ? new MrzResult(nativeResult.mrzResult) : null;
        
        /** 
         * The nationality of Romania ID owner. 
         */
        this.nationality = nativeResult.nationality;
        
        /** 
         * The parent name of Romania ID owner. 
         */
        this.parentName = nativeResult.parentName;
        
        /** 
         * The place of birth of Romania ID owner. 
         */
        this.placeOfBirth = nativeResult.placeOfBirth;
        
        /** 
         * The sex of Romania ID owner. 
         */
        this.sex = nativeResult.sex;
        
        /** 
         * The surname of Romania ID owner. 
         */
        this.surname = nativeResult.surname;
        
    }
}

/**
 * Recognizer which can scan front side of Romania ID.
 */
export class RomaniaIdFrontRecognizer extends Recognizer {
    constructor() {
        super('RomaniaIdFrontRecognizer');
        
        /** 
         * Defines whether glare detector is enabled. 
         */
        this.detectGlare = true;
        
        /** 
         * Defines if address of Romania ID owner should be extracted. 
         */
        this.extractAddress = true;
        
        /** 
         * Defines if date of expiry of Romania ID should be extracted. 
         */
        this.extractDateOfExpiry = true;
        
        /** 
         * Defines if date of issue of Romania ID should be extracted. 
         */
        this.extractDateOfIssue = true;
        
        /** 
         * Defines if first name of Romania ID owner should be extracted. 
         */
        this.extractFirstName = true;
        
        /** 
         * Defines if issuing authority of Romania ID should be extracted. 
         */
        this.extractIssuedBy = true;
        
        /** 
         * Defines if place of birth of Romania ID owner should be extracted. 
         */
        this.extractPlaceOfBirth = true;
        
        /** 
         * Defines if sex of Romania ID owner should be extracted. 
         */
        this.extractSex = true;
        
        /** 
         * Defines if surname of Romania ID owner should be extracted. 
         */
        this.extractSurname = true;
        
        /** 
         * The DPI (Dots Per Inch) for face image that should be returned. 
         */
        this.faceImageDpi = 250;
        
        /** 
         * The DPI (Dots Per Inch) for full document image that should be returned. 
         */
        this.fullDocumentImageDpi = 250;
        
        /** 
         * The extension factors for full document image. 
         */
        this.fullDocumentImageExtensionFactors = new ImageExtensionFactors();
        
        /** 
         * Defines whether face image will be available in result. 
         */
        this.returnFaceImage = false;
        
        /** 
         * Defines whether full document image will be available in 
         */
        this.returnFullDocumentImage = false;
        
        this.createResultFromNative = function (nativeResult) { return new RomaniaIdFrontRecognizerResult(nativeResult); }
    }
}