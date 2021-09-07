package com.evan.wj.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin_role", schema = "wj", catalog = "")
public class AdminRole {
    private int id;
    private String name;
    private String nameZh;
    private Byte enabled;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "name_zh")
    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    @Basic
    @Column(name = "enabled")
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRole adminRole = (AdminRole) o;
        return id == adminRole.id &&
                Objects.equals(name, adminRole.name) &&
                Objects.equals(nameZh, adminRole.nameZh) &&
                Objects.equals(enabled, adminRole.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nameZh, enabled);
    }
}
