
<%@ page import="com.jspassigment2.jsp_assigment2.entity.Food" %>
<%@ page import="com.jspassigment2.jsp_assigment2.util.ConvertHelper" %><%--
  Created by IntelliJ IDEA.
  User: it
  Date: 12/7/2021
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("UTF-8");
    Food food = (Food) request.getAttribute("food");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/include/head.jsp">
        <jsp:param name="title" value="Thông tin Sản Phẩm"/>
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
                        <h1>Update Product</h1>
                        <a href="/admin/list-product">Back To List</a>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-10">
                        <!-- general form elements -->
                        <div class="card card-primary">
                            <!-- form start -->
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="ProductName">Product Name</label>
                                        <input type="text" class="form-control" value="<%= food.getName()%>" id="ProductName" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="Description">Description</label>
                                        <input type="text" class="form-control" value="<%= food.getDescription()%>" id="Description" readonly/>
                                    </div>
                                    <div class="form-group">
                                        <label for="Price">Price</label>
                                        <input type="text" class="form-control" value="<%= food.getPrice()%>" id="Price" readonly>
                                    </div>
                                    <div class="form-group">
                                        <p class="label">Thumbnail</p>
                                        <image src="<%= food.getThumbnail()%>" style="width: 300px"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="Create">Created at</label>
                                        <input type="text" class="form-control" value="<%= ConvertHelper.convertJavaDateToSqlDate(food.getCreated_at())%>" id="Create" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="Update">Updated at</label>
                                        <%
                                            if (food.getUpdated_at() == null){
                                        %>
                                        <input type="text" class="form-control" value="chưa cập nhật" id="Update" readonly>
                                        <%
                                            }
                                        %>
                                        <%
                                            if (food.getUpdated_at() != null){
                                        %>
                                        <input type="text" class="form-control" value="<%= ConvertHelper.convertJavaDateToSqlDate(food.getUpdated_at())%>" id="Update" readonly>
                                        <%
                                            }
                                        %>
                                    </div>
                                    <div class="form-group">
                                        <label for="Price">Status</label>
                                        <input type="text" class="form-control" value="<%= food.getStatus()%>" id="Status" readonly>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                        </div>
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
<script src="../resources/custom.js"></script>
</body>
</html>