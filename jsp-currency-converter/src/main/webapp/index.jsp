<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Chuyển đổi tiền tệ</title>
        <style>
            body { font-family: Arial, sans-serif; display: flex; justify-content: center; margin-top: 80px; background-color: #f8fafc; }
            .box { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 320px; text-align: center; }
            input { width: 90%; padding: 10px; margin: 8px 0; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
            button { width: 90%; padding: 10px; background: #1b2a7a; color: white; border: none; border-radius: 4px; cursor: pointer; font-weight: bold; margin-top: 10px; }
        </style>
    </head>
    <body>
        <div class="box">
            <h2>USD to VND</h2>
            <form action="converter.jsp" method="POST">
                <input type="number" name="rate" placeholder="Tỉ giá (VND/USD)" value="25000" step="any" required />
                <input type="number" name="usd" placeholder="Số lượng USD" step="any" required />
                <button type="submit">Tính toán</button>
            </form>
        </div>
    </body>
</html>