package com.pasha.ExampleRest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("clid")
public class Clid implements Serializable {
    @Id
    @Column("clid")
    private String clid;

    @JsonIgnore
    @Column("addr_id")
    private Long addrId;

    @Transient
    private Address address;

    public String getClid() {
        return clid;
    }
    public void setClid(String clid) {
        this.clid = clid;
    }

    public Long getAddrId() {
        return addrId;
    }
    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
