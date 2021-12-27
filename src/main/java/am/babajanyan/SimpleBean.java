package am.babajanyan;

import am.babajanyan.annotations.Autoplug;

public class SimpleBean {

    @Autoplug
    private String strValue;

    private Integer intValue;

    public Integer getIntValue() {
        return intValue;
    }

    @Autoplug
    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return strValue;
    }


}
