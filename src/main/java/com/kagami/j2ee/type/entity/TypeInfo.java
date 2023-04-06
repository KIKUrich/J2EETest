package com.kagami.j2ee.type.entity;

public abstract class TypeInfo {

    private Integer typeId;
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public abstract String getTypeNamespace();

    public abstract boolean isDerivedFrom(String typeNamespaceArg, String typeNameArg, int derivationMethod);

    public void add(TypeInfo type) {

    }
}
