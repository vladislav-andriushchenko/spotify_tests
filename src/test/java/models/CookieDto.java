package models;

import lombok.Data;

import java.util.Date;

@Data
public class CookieDto {
    private String name;
    private String value;
    private String domain;
    private String path;
    private Date expiry;
    private boolean isSecure;
    private boolean isHttpOnly;
}