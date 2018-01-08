package org.codediscover.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Set;

public class ClassMethodDeclareBean {
    private int access;
    private String name;
    private String desc;
    private String signature;
    private Set<String> exceptions;

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Set<String> getExceptions() {
        return exceptions;
    }

    public void setExceptions(Set<String> exceptions) {
        this.exceptions = exceptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ClassMethodDeclareBean that = (ClassMethodDeclareBean) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(desc, that.desc)
                .append(signature, that.signature)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(desc)
                .append(signature)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("access", access)
                .append("name", name)
                .append("desc", desc)
                .append("signature", signature)
                .append("exceptions", exceptions)
                .toString();
    }
}
