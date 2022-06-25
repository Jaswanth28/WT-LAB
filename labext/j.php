<?php
if(isset($_POST["submit"]) && isset($_POST["uname"]) && isset($_POST["pass"])){
$uname=$_POST["uname"];
$pass=$_POST["pass"];
$con=mysqli_connect("localhost","root","jaswanth","wtl1");
if(!$con){
    die('Could not connect: '.mysqli_connect_error());
}
echo 'Connected successfully<br/>';
$query="select * from users where USERNAME='$uname' and PASSWORD='$pass'";
$records=mysqli_query($con,$query);
if(mysqli_num_rows($records)>=1)
{
    header("Location: success.html");
}
else{
    echo "wrong";
}
}
?>