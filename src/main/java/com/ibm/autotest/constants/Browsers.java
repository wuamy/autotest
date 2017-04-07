package com.ibm.autotest.constants;

/**
 * Created by wu on 4/1/2017.
 */
public enum  Browsers {

    FIREFOX,
    CHROME,
    IE;

    public static Browsers browserForName(String browser) throws IllegalArgumentException{
        for (Browsers b: values()){
            if (b.toString().equalsIgnoreCase(browser)){
                return b;
            }
        }
        throw browserNotFound(browser);
    }

    private static IllegalArgumentException browserNotFound(String outcome) {
        return new IllegalArgumentException(("Invalid browser [" + outcome + "]"));
    }


}
