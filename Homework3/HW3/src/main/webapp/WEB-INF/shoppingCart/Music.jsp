<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Music</title>
</head>
<body>
<p>Shop for CDs</p>
<form action="viewCart.act" method="get">
    <input type="submit" value="View Cart">
</form>
<br/>
<form action="addCart.act?type=Music" method="post">
    <input type="checkbox" name="Music" value="Im going to tell you a secret">I'm going to tell you a secret<br/>
    <input type="checkbox" name="Music" value="Baby one more time">Baby one more time<br/>
    <input type="checkbox" name="Music" value="Justified">Justified<br/>
    <input type="checkbox" name="Music" value="Loose">Loose<br/>
    <input type="checkbox" name="Music" value="Gold Digger">Gold Digger<br/>
    <input type="submit" value="Add to Cart">
</form>
</body>
</html>