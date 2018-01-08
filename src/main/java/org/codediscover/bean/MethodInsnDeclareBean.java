package org.codediscover.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MethodInsnDeclareBean {

   private int opcode;
   private String owner;
   private String name;
   private String desc;
   private boolean itf;

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public boolean isItf() {
        return itf;
    }

    public void setItf(boolean itf) {
        this.itf = itf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MethodInsnDeclareBean that = (MethodInsnDeclareBean) o;

        return new EqualsBuilder()
                .append(opcode, that.opcode)
                .append(itf, that.itf)
                .append(owner, that.owner)
                .append(name, that.name)
                .append(desc, that.desc)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(opcode)
                .append(owner)
                .append(name)
                .append(desc)
                .append(itf)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("opcode", opcode)
                .append("owner", owner)
                .append("name", name)
                .append("desc", desc)
                .append("itf", itf)
                .toString();
    }
}
