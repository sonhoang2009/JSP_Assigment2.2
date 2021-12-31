<%@ page import="java.util.ArrayList" %>

<%@ page import="com.jspassigment2.jsp_assigment2.entity.Food" %>
<%@ page import="com.jspassigment2.jsp_assigment2.entity.Category" %><%--
  Created by IntelliJ IDEA.
  User: it
  Date: 12/6/2021
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("UTF-8");
    ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("categories");


%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/include/head.jsp">
        <jsp:param name="title" value="Danh Sách Sản Phẩm"/>
    </jsp:include>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="/include/header.jsp"/>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="/include/aside/aside.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Simple Tables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">List Products</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <!-- /.row -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Products</h3>

                                <div class="card-tools">
                                    <button type="submit" class="btn btn-default">
                                        <a href="/admin/create-category" >Add new category</a>
                                    </button>
                                </div>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body table-responsive p-0">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên</th>
                                        <th>Tùy chọn</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (int i = 0; i < list.size(); i++){
                                        %>
                                                <tr>
                                                    <th><%= list.get(i).getId()%></th>
                                                    <th><%= list.get(i).getName()%></th>
                                                    <th>
                                                        <a href="/admin/update-category?id=<%= list.get(i).getId()%>">Update</a>|
                                                        <a onclick="deleteProduct(<%= list.get(i).getId()%>)" href="#">Delete</a>
                                                    </th>
                                                </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.1.0
        </div>
        <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../resources/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../resources/dist/js/demo.js"></script>
<script>
    function deleteProduct(id){
        if (confirm("bạn có muốn xóa danh mục")){
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function (){
                if (xhr.readyState == 4 && xhr.status == 200){
                    alert("xóa thành công !!");
                    window.location.reload();
                }
            };
            xhr.open('DELETE', '/admin/delete-category?id=' + id);
            xhr.send();
        }
    }
</script>
</body>
</html>
