package com.kagami.j2ee.type.service;

import com.kagami.j2ee.type.entity.TypeInfo;

import java.util.List;

public interface TypeService {
    /**
     * 查询所有记录
     */
    PageInfo<TypeInfo> queryTypeInfoAll(String name, Integer pageNum, Integer limit);

    /**
     * 添加图书类型
     */
    void addTypeSubmit(TypeInfo info);

    /**
     * 修改 根据id查询记录信息
     */
    TypeInfo queryTypeInfoById(Integer id);

    /**
     * 修改提交
     */
    void updateTypeSubmit(TypeInfo info);

    /**
     * 根据ids删除记录信息
     */
    void deleteTypeByIds(List<String> id);

    TypeInfo addTypeInfo(TypeInfo typeInfo);

    TypeInfo modifyTypeInfo(TypeInfo typeInfo);

    Boolean deleteTypeInfo(int i);

    TypeInfo getTypeInfo(int i);

    List<TypeInfo> getTypeInfos(TypeInfo typeInfo);

    class PageInfo<T> {
    }
}
