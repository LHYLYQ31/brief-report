package com.lypz.briefreport.modules.dictionary.model;

public class Dictionary {
    private Integer id;

    private String dictionaryName;

    private Integer dictionaryType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName == null ? null : dictionaryName.trim();
    }

    public Integer getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(Integer dictionaryType) {
        this.dictionaryType = dictionaryType;
    }
}