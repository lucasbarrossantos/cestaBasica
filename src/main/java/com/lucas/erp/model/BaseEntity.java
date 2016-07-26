package com.lucas.erp.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * CriadoEm by Marcus on 14/09/2015.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String criadoPor;
    private Calendar criadoEm;
    private Calendar modificadoEm;
    private String modificadoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String CriadoPor) {
        this.criadoPor = CriadoPor;
    }

    public Calendar getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Calendar CriadoEm) {
        this.criadoEm = CriadoEm;
    }

    public Calendar getModificadoEm() {
        return modificadoEm;
    }

    public void setModificadoEm(Calendar ModificadoEm) {
        this.modificadoEm = ModificadoEm;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String ModificadoPor) {
        this.modificadoPor = ModificadoPor;
    }

    @PrePersist
    void onPrePersist() {
        setCriadoEm(Calendar.getInstance());
        setModificadoEm(Calendar.getInstance());
    }

    @PostPersist
    void onPostPersist() {
    }

    @PostLoad
    void onPostLoad() {
    }

    @PreUpdate
    void onPreUpdate() {
        setModificadoEm(Calendar.getInstance());
    }

    @PostUpdate
    void onPostUpdate() {
    }

    @PreRemove
    void onPreRemove() {
    }

    @PostRemove
    void onPostRemove() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        //add por causa multselect
        if (o == null || id == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    public boolean isPersisted() {
        return id != null && id > 0;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}