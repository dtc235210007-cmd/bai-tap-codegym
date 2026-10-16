<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Discount Calculator</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f1f5f9;
                display: flex;
                justify-content: center;
                margin-top: 80px;
            }
            .calculator-card {
                background: #ffffff;
                width: 380px;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
            }
            h2 {
                color: #1e293b;
                text-align: center;
                margin-top: 0;
                margin-bottom: 25px;
            }
            .form-group {
                margin-bottom: 16px;
            }
            label {
                display: block;
                font-size: 14px;
                font-weight: 600;
                color: #475569;
                margin-bottom: 6px;
            }
            input {
                width: 100%;
                box-sizing: border-box;
                padding: 10px 12px;
                border: 1px solid #cbd5e1;
                border-radius: 6px;
                font-size: 14px;
            }
            input:focus {
                outline: none;
                border-color: #3b82f6;
            }
            button {
                width: 100%;
                background-color: #2563eb;
                color: #ffffff;
                padding: 12px;
                border: none;
                border-radius: 6px;
                font-size: 15px;
                font-weight: 600;
                cursor: pointer;
                margin-top: 10px;
                transition: background-color 0.2s;
            }
            button:hover {
                background-color: #1d4ed8;
            }
        </style>
    </head>
    <body>
        <div class="calculator-card">
            <h2>Product Discount Calculator</h2>
            <!-- Form gửi dữ liệu POST tới /display-discount -->
            <form action="display-discount" method="POST">
                <div class="form-group">
                    <label>Product Description:</label>
                    <input type="text" name="description" placeholder="Tên hoặc mô tả sản phẩm" required autofocus />
                </div>
                
                <div class="form-group">
                    <label>List Price ($):</label>
                    <input type="number" step="any" min="0" name="price" placeholder="Giá niêm yết" required />
                </div>
                
                <div class="form-group">
                    <label>Discount Percent (%):</label>
                    <input type="number" step="any" min="0" max="100" name="discount_percent" placeholder="Tỷ lệ chiết khấu (0 - 100)" required />
                </div>
                
                <button type="submit">Calculate Discount</button>
            </form>
        </div>
    </body>
</html>