<%-- 
    Document   : Login
    Created on : Oct 20, 2017, 12:27:29 AM
    Author     : shimantta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project</title>
    </head>
    <body>
        <h3><a href="#" id="login">Login</a> or <a href="#" id="register">Register</a></h3>
        <div style="text-align:center;position:relative;">

            
            <form action="${pageContext.request.contextPath}/RegisterServlet" class="register" method="POST" >
                <fieldset>
                    <legend>Registration</legend>
                    Username : <input type="text" name="username" id="username">
                    </br></br>

                    Password : <input type="password" name="password" id="password">
                    </br></br>
                    Email : <input type="email" name="email" id="email">
                    </br></br>
                    Date of Birth : <input type="date" name="date" id="date">
                    </br></br>
                    <input type="submit" value="Submit">
                </fieldset>
            </form>
            
            <form action="${pageContext.request.contextPath}/LoginServlet" class="login" method="POST" >
                <fieldset>
                    <legend>Login</legend>
                    Username : <input type="text" name="username" id="username">
                    </br></br>

                    Password : <input type="password" name="password" id="password">
                    </br></br>
                    <input type="checkbox" name="remember" id="remember">Remember me

                    </br></br>
                    <input type="submit" value="Submit">
                </fieldset>
            </form>
        </div>
        <script>
            var login = document.getElementById("login");
            var register = document.getElementById("register");
            login.addEventListener('click',function(){
                visibility(this.id,'register');
            })
            register.addEventListener('click',function(){
                visibility(this.id,'login');
            })
            function visibility(id,vanishId){
                
                document.getElementsByClassName(id)[0].style.display = 'block';
                document.getElementsByClassName(vanishId)[0].style.display = 'none';
      
            }
            
            window.onload = function(){
                visibility('register','login');
            }
        </script>
    </body>
</html>
