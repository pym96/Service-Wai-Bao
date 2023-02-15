<!DOCTYPE html>
<html>
<body>
<meta http-equiv="Content-Type" content="text/html charset=gb2312">
<form action="" enctype="multipart/form-data" method="post">
    <input type="file" name="myFile">
</form>
<div>
    <button id="btn">button</button>
</div>
<script>
    let header = new Headers();
    init = {
        method : 'GET',
        header : header,
        mode : 'cors',
        cache : 'default'
    };
    const btn = document.getElementById("btn");
    btn.onclick = () => {
        console.log("test");
        fetch('http://localhost:8080/select?username=zhangsan').
        then(res => {
            console.log(res);
            return res.json();
        }).then(res => {
            console.log(res);
        })
    };
</script>
</body>
</html>
