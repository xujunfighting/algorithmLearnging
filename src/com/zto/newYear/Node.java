package com.zto.newYear;

import java.util.ArrayList;
import java.util.List;

/**
 * Author xujun
 * Create date 2019-08-20.
 * desc:
 */
public class Node {
    private String id;
    private String parentId;
    private String code;
    private String fineReport;
    private String menuName;
    private String menuUrl;
    private String menuIcon;
    List<Node> children=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFineReport() {
        return fineReport;
    }

    public void setFineReport(String fineReport) {
        this.fineReport = fineReport;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
