package com.evan.wj.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_card", schema = "account", catalog = "")
public class AccountCard {
    private int id;
    private String 名字;
    private String 出生日期;
    private String 性别;
    private Long 身份证;
    private Long 手机号;
    private String 地址;
    private String 所属户籍站;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "名字")
    public String get名字() {
        return 名字;
    }

    public void set名字(String 名字) {
        this.名字 = 名字;
    }

    @Basic
    @Column(name = "出生日期")
    public String get出生日期() {
        return 出生日期;
    }

    public void set出生日期(String 出生日期) {
        this.出生日期 = 出生日期;
    }

    @Basic
    @Column(name = "性别")
    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    @Basic
    @Column(name = "身份证")
    public Long get身份证() {
        return 身份证;
    }

    public void set身份证(Long 身份证) {
        this.身份证 = 身份证;
    }

    @Basic
    @Column(name = "手机号")
    public Long get手机号() {
        return 手机号;
    }

    public void set手机号(Long 手机号) {
        this.手机号 = 手机号;
    }

    @Basic
    @Column(name = "地址")
    public String get地址() {
        return 地址;
    }

    public void set地址(String 地址) {
        this.地址 = 地址;
    }

    @Basic
    @Column(name = "所属户籍站")
    public String get所属户籍站() {
        return 所属户籍站;
    }

    public void set所属户籍站(String 所属户籍站) {
        this.所属户籍站 = 所属户籍站;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCard that = (AccountCard) o;
        return id == that.id &&
                Objects.equals(名字, that.名字) &&
                Objects.equals(出生日期, that.出生日期) &&
                Objects.equals(性别, that.性别) &&
                Objects.equals(身份证, that.身份证) &&
                Objects.equals(手机号, that.手机号) &&
                Objects.equals(地址, that.地址) &&
                Objects.equals(所属户籍站, that.所属户籍站);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, 名字, 出生日期, 性别, 身份证, 手机号, 地址, 所属户籍站);
    }
}
