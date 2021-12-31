<%@ page import="com.jspassigment2.jsp_assigment2.entity.Food" %>
<%@ page import="com.jspassigment2.jsp_assigment2.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%
    request.setCharacterEncoding("UTF-8");
    Food product = (Food) request.getAttribute("food");
    ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/include/head.jsp">
        <jsp:param name="title" value="Sửa Sản Phẩm"/>
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
                            <form action="/admin/update" method="post">
                                <div class="card-body">
                                    <div class="form-group" hidden>
                                        <label for="ProductName">Product Name</label>
                                        <input type="text" class="form-control" name="id" value="<%= product.getId()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label for="ProductName">Product Name</label>
                                        <input type="text" class="form-control" name="name" id="ProductName" value="<%= product.getName()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label for="Price">Price</label>
                                        <input type="text" class="form-control" name="price" id="Price" value="<%= product.getPrice()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label for="Description">Description</label>
                                        <input type="text" class="form-control" name="description" id="Description"  value="<%= product.getDescription()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label for="Thumbnail">Thumbnail</label>
                                        <input type="text" class="form-control" name="thumbnail" id="Thumbnail"  value="<%= product.getThumbnail()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label for="Category">Category</label>
                                        <select name="category" id="Category" class="form-control">
                                            <%
                                                for (int i = 0; i < categories.size(); i++) {

                                            %>
                                            <option value="<%= categories.get(i).getId()%>"><%= categories.get(i).getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="Status">Status</label>
                                        <input type="text" class="form-control" name="status" id="Status"  value="<%= product.getStatus()%>" />
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" id="Save" class="btn btn-primary">Save</button>
                                </div>
                            </form>
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