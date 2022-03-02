package com.mobiquity.neel.customerservice.util;


public final class Constants {

    private Constants(){}

    public static final String SECURITY_QUESTION_ANSWER_NOT_VALID_DESCRIPTION = "size of answer must be 3 or more";
    public static final String SECURITY_QUESTION_ANSWER_NOT_VALID_CODE = "CSQ-CREATE-FIE-002";

    public static final String CSQ_MANDATORY_FIELD_NOT_VALID_DESCRIPTION = "Mandatory field should not be null";
    public static final String CSQ_MANDATORY_FIELD_NOT_VALID_CODE = "CSQ-CREATE-FIE-001";

    public static final String SECURITY_QUESTIONS_NOT_FOUND_CODE = "CSQ-CREATE-FIE-003";
    public static final String SECURITY_QUESTIONS_NOT_FOUND_DESCRIPTION = "security question not found for given id.";

    public static final String SECURITY_QUESTIONS_LENGTH_NOT_VALID_CODE = "CSQ-CREATE-FIE-004";
    public static final String SECURITY_QUESTIONS_LENGTH_NOT_VALID_DESCRIPTION = "There should be at least 3 security questions.";

    public static final String CSQ_CUSTOMER_NOT_FOUND_CODE = "CSQ-CREATE-FIE-005";
    public static final String CSQ_CUSTOMER_NOT_FOUND_DESCRIPTION = "customer with given user name does not exists.";

    public static final String CUSTOMER_SECURITY_IMAGE_NOT_FOUND_CODE = "CSI-GET-FIE-001";
    public static final String CUSTOMER_SECURITY_IMAGE_NOT_FOUND_DESCRIPTION = "security image not found in database for given customer.";

    public static final String CSI_CUSTOMER_NOT_FOUND_CODE = "CSI-GET-FIE-002";
    public static final String CSI_CUSTOMER_NOT_FOUND_DESCRIPTION = "customer with given user name does not exists.";

    public static final String SECURITY_IMAGE_NOT_FOUND_CODE = "SIM-GET-FIE-001";
    public static final String SECURITY_IMAGE_NOT_FOUND_DESCRIPTION = "security images not found in configured table.";

    public static final String OTP_VAL_CUSTOMER_NOT_FOUND_CODE = "OTP-VAL-FIE-001";
    public static final String OTP_VAL_CUSTOMER_NOT_FOUND_DESCRIPTION = "customer with given user name does not exists.";

    public static final String OTP_VAL_PROVIDED_OTP_NULL_CODE = "OTP-VAL-FIE-002";
    public static final String OTP_VAL_PROVIDED_OTP_NULL_DESCRIPTION = "user provided otp or username cannot be null or empty.";

    public static final String OTP_VAL_INCORRECT_CODE = "OTP-VAL-FIE-003";
    public static final String OTP_VAL_INCORRECT_DESCRIPTION = "otp is value does not match with system generated value.";

    public static final String OTP_VAL_FAILED_ATTEMPT_EXCEEDED_CODE = "OTP-VAL-FIE-004";
    public static final String OTP_VAL_FAILED_ATTEMPT_EXCEEDED_DESCRIPTION = "number of failed otp is exceeded.";

    public static final String OTP_VAL_EXPIRED_CODE = "OTP-VAL-FIE-005";
    public static final String OTP_VAL_EXPIRED_DESCRIPTION = "otp is expired.";

    public static final String CUS_MANDATORY_FIELD_NOT_VALID_DESCRIPTION = "Mandatory field should not be null";
    public static final String CUS_MANDATORY_FIELD_NOT_VALID_CODE = "CUS-GET-FIE-001";

    public static final String CUS_CUSTOMER_NOT_FOUND_CODE = "CUS-GET-FIE-002";
    public static final String CUS_CUSTOMER_NOT_FOUND_DESCRIPTION = "Customer Not Found.";

    public static final String CUS_DELETE_CUSTOMER_NOT_FOUND_CODE = "CUS-DELETE-NFD-001";
    public static final String CUS_DELETE_CUSTOMER_NOT_FOUND_DESCRIPTION = "Customer Not Found.";

    public static final String CUS_CREATE_MANDATORY_FIELD_NOT_VALID_DESCRIPTION = "Mandatory field should not be null";
    public static final String CUS_CREATE_MANDATORY_FIELD_NOT_VALID_CODE = "CUS-CREATE-FIE-001";

    public static final String CUS_CREATE_PHONE_NUMBER_NOT_VALID_DESCRIPTION = "phone number is not as per the pattern.";
    public static final String CUS_CREATE_PHONE_NUMBER_NOT_VALID_CODE = "CUS-CREATE-FIE-002";

    public static final String CUS_CREATE_EMAIL_NOT_VALID_DESCRIPTION = "email is not as per the pattern.";
    public static final String CUS_CREATE_EMAIL_NOT_VALID_CODE = "CUS-CREATE-FIE-003";

    public static final String CUS_CREATE_PREFERRED_LANGUAGE_NOT_VALID_DESCRIPTION = "preferred language is not from the given list.";
    public static final String CUS_CREATE_PREFERRED_LANGUAGE_NOT_VALID_CODE = "CUS-CREATE-FIE-004";

    public static final String CUS_CREATE_USERNAME_NOT_VALID_DESCRIPTION = "username is not as per the pattern.";
    public static final String CUS_CREATE_USERNAME_NOT_VALID_CODE = "CUS-CREATE-FIE-005";

    public static final String CUS_CREATE_USERNAME_NOT_UNIQUE_DESCRIPTION = "username is not unique.";
    public static final String CUS_CREATE_USERNAME_NOT_UNIQUE_CODE = "CUS-CREATE-FIE-006";

    public static final String CUS_CREATE_UNEXPECTED_ERROR_IN_AGE_RETRIEVAL_DESCRIPTION = "unexpected error occurred: ";
    public static final String CUS_CREATE_UNEXPECTED_ERROR_IN_AGE_RETRIEVAL_CODE = "CUS-CREATE-FIE-007";

    public static final String CUS_UPDATE_MANDATORY_FIELD_NOT_VALID_DESCRIPTION = "Mandatory field should not be null";
    public static final String CUS_UPDATE_MANDATORY_FIELD_NOT_VALID_CODE = "CUS-UPDATE-FIE-001";

    public static final String CUS_UPDATE_PHONE_NUMBER_NOT_VALID_DESCRIPTION = "phone number is not as per the pattern.";
    public static final String CUS_UPDATE_PHONE_NUMBER_NOT_VALID_CODE = "CUS-UPDATE-FIE-002";

    public static final String CUS_UPDATE_EMAIL_NOT_VALID_DESCRIPTION = "email is not as per the pattern.";
    public static final String CUS_UPDATE_EMAIL_NOT_VALID_CODE = "CUS-UPDATE-FIE-003";

    public static final String CUS_UPDATE_PREFERRED_LANGUAGE_NOT_VALID_DESCRIPTION = "preferred language or status is not from the given list.";
    public static final String CUS_UPDATE_PREFERRED_LANGUAGE_NOT_VALID_CODE = "CUS-UPDATE-FIE-004";

    public static final String CUS_UPDATE_CUSTOMER_NOT_FOUND_CODE = "CUS-UPDATE-NFD-001";
    public static final String CUS_UPDATE_CUSTOMER_NOT_FOUND_DESCRIPTION = "Customer Not Found.";
}
