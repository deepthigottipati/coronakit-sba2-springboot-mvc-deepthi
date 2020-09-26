<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">CORONA KIT</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="product-list">Products List</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="product-entry">Add New Product</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/custom-login">Logout</a>
      </li>
    </ul>
  </div>
</nav>