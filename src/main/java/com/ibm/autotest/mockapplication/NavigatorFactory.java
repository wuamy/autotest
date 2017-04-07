package com.ibm.autotest.mockapplication;

/**
 * Created by wu on 4/1/2017.
 */
public class NavigatorFactory {
    private static Navigation navigator = null;

    public static synchronized Navigation getNavigator(){
       if (navigator == null){
        navigator = new Navigation();
        }
        return navigator;
    }
}
