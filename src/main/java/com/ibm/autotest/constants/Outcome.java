package com.ibm.autotest.constants;

/**
 * Created by wu on 4/1/2017.
 */
public enum Outcome {

    SUCCESS(new String[]{"success", "successfully"}),
    FAILURE(new String[]{"failure", "unsuccessfully"});

    private String[] aliases;

    private Outcome(String[] aliases){
        this.aliases = aliases;
    }

    public static Outcome outcomeForName(String outcomeString) throws IllegalArgumentException{
        for(Outcome outcome: values()){
            for(String alias: outcome.aliases){
                if(alias.equalsIgnoreCase(outcomeString)){
                    return outcome;
                }
            }
        }
        throw outcomeNotFound(outcomeString);
    }

    private static IllegalArgumentException outcomeNotFound(String outcome) {
        return new IllegalArgumentException(("Invalid outcome [" + outcome + "]"));
    }

}
