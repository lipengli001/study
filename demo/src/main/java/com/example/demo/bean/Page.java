package com.example.demo.bean;

/**
 * page实体
 */
public class Page {

    /**
     * 页面ID
     */
    private String id;

    /**
     * 页面名称
     */
    private String name;

    /**
     * 页面简介
     */
    private String intro;

    /**
     * 页面关键字
     */
    private String keywords;

    /**
     * 页面信息
     */
    private String structure;

    /**
     * 自定义hearder
     */
    private String ectra_header;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getIntro () {
        return intro;
    }

    public void setIntro (String intro) {
        this.intro = intro;
    }

    public String getKeywords () {
        return keywords;
    }

    public void setKeywords (String keywords) {
        this.keywords = keywords;
    }

    public String getStructure () {
        return structure;
    }

    public void setStructure (String structure) {
        this.structure = structure;
    }

    public String getEctra_header () {
        return ectra_header;
    }

    public void setEctra_header (String ectra_header) {
        this.ectra_header = ectra_header;
    }

}
