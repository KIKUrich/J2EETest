package com.kagami.j2ee.type.dao;

import com.kagami.j2ee.type.entity.TypeInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDao {

    private Connection conn;

    public TypeDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java_test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String user = "root";
            String passwd = "root";
            this.conn = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<TypeInfo> list(TypeInfo typeInfo) {
        List<TypeInfo> typeInfos = new ArrayList<TypeInfo>();
        try {
            String sql = "select * from type_info where type_name like ? ";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, "%" + typeInfo.getTypeName() == null ? "" : typeInfo.getTypeName() + "%");
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                TypeInfo type = new TypeInfo() {
                    @Override
                    public String getTypeName() {
                        return null;
                    }

                    @Override
                    public String getTypeNamespace() {
                        return null;
                    }

                    @Override
                    public boolean isDerivedFrom(String typeNamespaceArg, String typeNameArg, int derivationMethod) {
                        return false;
                    }
                };
                type.setTypeId(result.getInt("type_id"));
                type.setTypeName(result.getString("type_name"));
                typeInfo.add(type);
            }
            result.close();
            stat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeInfos;
    }

    public TypeInfo get(int typeId) {
        TypeInfo typeInfo = null;
        try {
            String sql = "select * from type_info where type_id=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, typeId);
            ResultSet result = stat.executeQuery();
            if (result.next()) {
                typeInfo = new TypeInfo() {
                    @Override
                    public String getTypeNamespace() {
                        return null;
                    }

                    @Override
                    public boolean isDerivedFrom(String typeNamespaceArg, String typeNameArg, int derivationMethod) {
                        return false;
                    }
                };
                typeInfo.setTypeId(result.getInt("type_id"));
                typeInfo.setTypeName(result.getString("type_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeInfo;
    }

    public TypeInfo insert(TypeInfo typeInfo) {
        int result = 0;
        try {
            String sql = "insert into type_info(type_name) value(?)";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, typeInfo.getTypeName());
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0)
            return typeInfo;
        else
            return null;
    }

    public TypeInfo update(TypeInfo typeInfo) {
        int result = 0;
        try {
            String sql = "update type_info set type_name=?,where type_id=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, typeInfo.getTypeName());
            stat.setInt(2, typeInfo.getTypeId());
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0)
            return typeInfo;
        else
            return null;
    }

    public Boolean delete(int booId) {
        Boolean success = false;
        try {
            String sql = "delete from type_info where type_id=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, booId);
            int result = stat.executeUpdate();
            if (result > 0)
                success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
