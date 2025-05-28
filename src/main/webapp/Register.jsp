<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Login - Online Exam System</title>
  <link rel="stylesheet" href="Register.css" />
   <link rel="stylesheet" href="Feedback.css">
   <link rel="stylesheet" href="Homepage.css">
</head>
<body>
  <header>
        <div class="header-container">
            <a href="/onlineExamManagement/Homepage.jsp"><h3 class="logo">MIKUSO EXAM</h3></a>
            <div class="icon">
                <img src="iconcover.png" alt="Home Icon">
            </div>
            <nav>
                <ul class="nav-links">
                    <li><a href="Homepage.jsp">Home</a></li>
                    <li><a href="/onlineExamManagement/getAllservlet">Module</a></li>
                    <li><a href="/onlineExamManagement/exams">Exams</a></li>
                    <li><a href="Feedback.jsp">Feedback</a></li>
                    <li class="login-btn"><a href="Register.jsp">Login</a></li>
                </ul>
            </nav>
        </div>
    </header>
  <!-- Header -->

  <!-- Main Login Form -->
  <main>
    <div class="login-container">
      <h2>Login</h2>
      <form class="login-form"  action="UserLoginServlet" method="POST">
        <label>userName:</label>
        <input type="text" placeholder="Enter Username" required name="userName" />

        <label>Password:</label>
        <input type="password" placeholder="Enter Password" required name="password" />

        <button type="submit">Login</button>
      </form>

      <p>Don't have an account? <a href="#" id="registerBtn">Register</a></p>
    </div>
  </main>

  <!-- Register Modal -->
  <div class="modal" id="registerModal">
    <div class="modal-content">
      <span class="close" id="closeModal">&times;</span>
      
      <h2>Register</h2>
      
      <form class="register-form" method="POST" action="UserInsertServlet">
        <label>Full Name:</label>
        <input type="text" placeholder="Enter your full name"  name="name"  required/>

        <label>Phone number:</label>
        <input type="text" placeholder="Enter your number"  name="phone" required />

        <label>Email:</label>
        <input type="gmail" placeholder="Choose a Email"  name="email" required/>

        <label>User name:</label>
        <input type="text" placeholder="Enter your Username"  name="userName" required />

        <label>Password:</label>
        <input type="password" placeholder="Create password"  name="password" required />

        <button type="submit">Register</button>
      </form>
    </div>
  </div>

  <!-- Script -->
  <script>
    const registerBtn = document.getElementById('registerBtn');
    const registerModal = document.getElementById('registerModal');
    const closeModal = document.getElementById('closeModal');

    registerBtn.onclick = (e) => {
      e.preventDefault();
      registerModal.style.display = 'flex';
    };

    closeModal.onclick = () => {
      registerModal.style.display = 'none';
    };

    window.onclick = (e) => {
      if (e.target === registerModal) {
        registerModal.style.display = 'none';
      }
    };
  </script>

</body>
</html>