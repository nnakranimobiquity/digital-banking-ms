package com.mobiquity.neel.otpservice.util;


public final class Constants {

    private Constants(){}

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

}
