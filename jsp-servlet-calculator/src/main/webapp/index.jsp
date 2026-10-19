<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        .calculator { border: 1px solid #ccc; padding: 20px; width: 300px; border-radius: 5px; box-shadow: 2px 2px 12px #aaa; }
        input, select { width: 100%; padding: 8px; margin: 10px 0; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; font-weight: bold; cursor: pointer;}
        button:hover { background-color: #218838; }
    </style>
</head>
<body>
    <div class="calculator">
        <h2>Máy tính cơ bản</h2>
        <form action="calculate" method="post">
            <label>Toán hạng 1:</label>
            <input type="number" step="any" name="firstOperand" required>
            
            <label>Phép toán:</label>
            <select name="operator">
                <option value="+">Cộng (+)</option>
                <option value="-">Trừ (-)</option>
                <option value="*">Nhân (*)</option>
                <option value="/">Chia (/)</option>
            </select>
            
            <label>Toán hạng 2:</label>
            <input type="number" step="any" name="secondOperand" required>
            
            <button type="submit">Tính toán</button>
        </form>
    </div>
</body>
</html>