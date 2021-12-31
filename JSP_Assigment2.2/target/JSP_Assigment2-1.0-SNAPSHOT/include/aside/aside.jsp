<%@ page import="com.jspassigment2.jsp_assigment2.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jspassigment2.jsp_assigment2.repository.JpaRepository" %>
<%@ page import="java.util.ArrayList" %>
<%
    request.setCharacterEncoding("utf-8");
    JpaRepository<Category> repositoryCategory = new JpaRepository<>(Category.class);
    ArrayList<Category> ListCategories = (ArrayList<Category>) repositoryCategory.findAll();

%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/admin/list-product" class="brand-link">
        <img src="../resources/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">Food for life</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="../resources/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block">Admin</a>
            </div>
        </div>
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            Danh Mục
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <%
                            for (int i = 0; i <ListCategories.size();i++) {
                        %>
                        <li class="nav-item">
                            <a href="examples/invoice.html" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p><%= ListCategories.get(i).getName()%></p>
                            </a>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    <!-- /.sidebar -->
</aside>