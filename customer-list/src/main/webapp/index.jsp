<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.codegym.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh Sách Khách Hàng</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 40px;
                background-color: #f8fafc;
            }
            .container {
                max-width: 850px;
                margin: auto;
                background: white;
                padding: 25px;
                border-radius: 8px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            }
            h2 {
                text-align: center;
                color: #1b2a7a;
                margin-bottom: 25px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #e2e8f0;
            }
            th {
                background-color: #1b2a7a;
                color: white;
            }
            tr:hover {
                background-color: #f1f5f9;
            }
            .avatar {
                width: 60px;
                height: 60px;
                border-radius: 50%;
                object-fit: cover;
                border: 1px solid #cbd5e1;
            }
        </style>
    </head>
    <body>
        <%
            // Khởi tạo danh sách khách hàng giả lập
            List<Customer> customerList = new ArrayList<>();
            customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=150"));
            customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?w=150"));
            customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://images.unsplash.com/photo-1527980965255-d3b416303d12?w=150"));
            customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://images.unsplash.com/photo-1580489944761-15a19d654956?w=150"));
            customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://images.unsplash.com/photo-1628157582853-a796fa650a6a?w=150"));

            request.setAttribute("customerList", customerList);
        %>

        <div class="container">
            <h2>DANH SÁCH KHÁCH HÀNG</h2>
            <table>
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên</th>
                        <th>Ngày sinh</th>
                        <th>Địa chỉ</th>
                        <th>Ảnh</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="customer" items="${requestScope.customerList}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td><b>${customer.name}</b></td>
                            <td>${customer.dob}</td>
                            <td>${customer.address}</td>
                            <td>
                                <img src="${customer.image}" alt="${customer.name}" class="avatar"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>