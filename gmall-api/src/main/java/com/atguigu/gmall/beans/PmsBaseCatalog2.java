package com.atguigu.gmall.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class PmsBaseCatalog2 implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatelog1Id() {
        return catelog1Id;
    }

    public void setCatelog1Id(String catelog1Id) {
        this.catelog1Id = catelog1Id;
    }

    public List<PmsBaseCatalog3> getPmsBaseCatalog3s() {
        return pmsBaseCatalog3s;
    }

    public void setPmsBaseCatalog3s(List<PmsBaseCatalog3> pmsBaseCatalog3s) {
        this.pmsBaseCatalog3s = pmsBaseCatalog3s;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    private String catelog1Id;
    @Transient
    private List<PmsBaseCatalog3> pmsBaseCatalog3s;

}
