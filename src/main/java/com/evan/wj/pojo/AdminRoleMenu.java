package com.evan.wj.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admin_role_menu", schema = "wj", catalog = "")
public class AdminRoleMenu {
    private int id;
    private Integer rid;
    private Integer mid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rid")
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "mid")
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminRoleMenu that = (AdminRoleMenu) o;
        return id == that.id &&
                Objects.equals(rid, that.rid) &&
                Objects.equals(mid, that.mid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rid, mid);
    }
}
