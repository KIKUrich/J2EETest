package com.kagami.j2ee.type.servlet;

import com.kagami.j2ee.type.entity.TypeInfo;
import com.kagami.j2ee.type.service.TypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "typeListServlet", value = "/type/list")
public class TypeListServlet extends HttpServlet {

    private TypeService typeService = new TypeService() {
        @Override
        public PageInfo<TypeInfo> queryTypeInfoAll(String name, Integer pageNum, Integer limit) {
            return null;
        }

        @Override
        public void addTypeSubmit(TypeInfo info) {

        }

        @Override
        public TypeInfo queryTypeInfoById(Integer id) {
            return null;
        }

        @Override
        public void updateTypeSubmit(TypeInfo info) {

        }

        @Override
        public void deleteTypeByIds(List<String> id) {

        }

        @Override
        public TypeInfo addTypeInfo(TypeInfo typeInfo) {
            return null;
        }

        @Override
        public TypeInfo modifyTypeInfo(TypeInfo typeInfo) {
            return null;
        }

        @Override
        public Boolean deleteTypeInfo(int i) {
            return null;
        }

        @Override
        public TypeInfo getTypeInfo(int i) {
            return null;
        }

        @Override
        public List<TypeInfo> getTypeInfos(TypeInfo typeInfo) {
            return null;
        }
    };

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TypeInfo typeInfo = new TypeInfo() {
            @Override
            public String getTypeNamespace() {
                return null;
            }

            @Override
            public boolean isDerivedFrom(String typeNamespaceArg, String typeNameArg, int derivationMethod) {
                return false;
            }
        };
        typeInfo.setTypeName(request.getParameter("type_name") == null ? "" : request.getParameter("type_name"));
        List<TypeInfo> typeInfos = this.typeService.getTypeInfos(typeInfo);
        request.getSession().setAttribute("searchCondition", typeInfo);
        request.getSession().setAttribute("typeInfos", typeInfos);
        request.getRequestDispatcher("typelist.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
