
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jspassigment2.jsp_assigment2.entity.Food" %><%--
  Created by IntelliJ IDEA.
  User: it
  Date: 12/7/2021
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%
  request.setCharacterEncoding("utf-8");

%>

<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="/include/head.jsp">
    <jsp:param name="title" value="Tạo Danh Mục"/>
  </jsp:include>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <jsp:include page="/include/header.jsp"/>

  <jsp:include page="/include/aside/aside.jsp"/>

  <div class="content-wrapper">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Simple Tables</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/list">Home</a></li>
              <li class="breadcrumb-item active">Thêm Danh Mục</li>
            </ol>
          </div>
        </div>
      </div>
    </section>
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-10">
            <!-- general form elements -->
            <div class="card card-primary">
              <!-- form start -->
              <form action="/admin/create-category" method="post">
                <div class="card-body">
                  <%-- <div class="form-group" hidden>
                     <label for="ID"> ID</label>
                     <input type="text" name="ID" class="form-control" id="ID">
                   </div>--%>
                  <div class="form-group">
                    <label for="ProductName">Category Name</label>
                    <input type="text" name="name" class="form-control" id="ProductName">
                  </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form>
            </div>
          </div>

        </div>
      </div>
    </section>
  </div>
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
</body>
</html>

