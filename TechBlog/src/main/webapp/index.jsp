
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*" %>    


<!DOCTYPE html>
<html>
<head>

   <meta charset="UTF-8">
   <title>TechBlog - welcome, from a Dreamer!</title>
   
<!--    CSS    -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   
   <style type="text/css">
      .banner-background{
          clip-path: polygon(50% 0, 100% 0, 100% 87%, 59% 100%, 25% 88%, 0 100%, 0 0);
          
      }
   </style>
   
   
   
</head>
<body>
 
 
<!-- NavBar  -->
    <%@include file="normal_navbar.jsp" %>
     
<!-- banner  -->     
     
     <div class="container-fluid p-0 m-0">
     
       <div class="jumbotron primary-background banner-background">
       
         <div class="container">
         
            <h3 class="display-3">Welcome to TechBlog</h3>
            <p>A programming language is a system of notation for writing computer programs.[1] Most programming languages are text-based formal languages, but they may also be graphical. They are a kind of computer language.</p>
            <p>The description of a programming language is usually split into the two components of syntax (form) and semantics (meaning), which are usually defined by a formal language.</p>
            
            <button class="btn btn-outline-light btn-lg"><span class="fa fa-bell"></span> Start it's Free!</button>
            <a href="login_page.jsp" class="btn btn-outline-light"><span class="fa fa-sign-in"></span> Login</a>
            
          </div>
          
       </div>

     </div>
     
     
<!-- Cards -->     
     
       <div class="container">
          <div class="row mb-3">
             <div class="col-md-4">
                <div class="card">
                     <div class="card-body">
                        <h5 class="card-title">Java Programming</h5>
                        <p class="card-text">Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.</p>
                        <a href="https://en.wikipedia.org/wiki/Java_(programming_language)" class="btn primary-background text-white">Read more</a>
                     </div>
                </div>
             </div>
              <div class="col-md-4">
                <div class="card">
                     <div class="card-body">
                        <h5 class="card-title">Python Programming</h5>
                        <p class="card-text">Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation.</p>
                        <a href="https://en.wikipedia.org/wiki/Python_(programming_language)" class="btn primary-background text-white">Read more</a>
                     </div>
                </div>
             </div>
              <div class="col-md-4">
                <div class="card">
                     <div class="card-body">
                        <h5 class="card-title">C# Programming</h5>
                        <p class="card-text">C# (pronounced See sharp) is a general-purpose high-level programming language supporting multiple paradigms. C# encompasses static typing, ...</p>
                        <a href="https://en.wikipedia.org/wiki/C_Sharp_(programming_language)" class="btn primary-background text-white">Read more</a>
                     </div>
                </div>
             </div>
          </div>
          
          
          <div class="row">
             <div class="col-md-4">
                <div class="card">
                     <div class="card-body">
                        <h5 class="card-title">Data Structures</h5>
                        <p class="card-text">In computer science, a data structure is a data organization, management, and storage format that is usually chosen for efficient access to data.</p>
                        <a href="https://en.wikipedia.org/wiki/Data_structure" class="btn primary-background text-white">Read more</a>
                     </div>
                </div>
             </div>
              <div class="col-md-4">
                <div class="card">
                     <div class="card-body">
                        <h5 class="card-title">Algorithms</h5>
                        <p class="card-text">Algorithms are used as specifications for performing calculations and data processing. More advanced algorithms can use conditionals to divert the code ...</p>
                        <a href="https://en.wikipedia.org/wiki/Algorithm" class="btn primary-background text-white">Read more</a>
                     </div>
                </div>
             </div>
              <div class="col-md-4">
                <div class="card">
                     <div class="card-body">
                        <h5 class="card-title">JavaScript</h5>
                        <p class="card-text">JavaScript is a high-level, often just-in-time compiled language that conforms to the ECMAScript standard. ... It has dynamic typing, prototype-based object- ...</p>
                        <a href="https://en.wikipedia.org/wiki/JavaScript" class="btn primary-background text-white">Read more</a>
                     </div>
                </div>
             </div>
          </div>
       </div>
</body>

<!--   JavaScript    -->
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  

</html>