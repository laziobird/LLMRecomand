package com.laziobird.ai.recomand.dto;

import java.util.List;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:31 PM
 */
public class Content {
    private List<Parts> parts;
    private String role;
    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }
    public List<Parts> getParts() {
        return parts;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
