<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Wagon</title>
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container px-lg-5">
                <a class="navbar-brand" href="/">Books Wagon</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link text-white" href="/">Home</a></li>
                        <li class="nav-item"><a class="nav-link text-white" href="/about">About</a></li>
                        <li class="nav-item"><a class="nav-link text-white" href="/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="py-5">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5 bg-light rounded-3 text-center">
                    <div class="m-4 m-lg-5">
                        <h1 class="display-5 fw-bold">Books Portal</h1>
                        <p class="fs-4">Bootstrap utility classes are used to create this jumbotron since the old component has been removed from the framework. Why create custom CSS when you can use utilities?</p>
                        <a class="btn btn-primary btn-lg" href="/">Call to action</a>
                    </div>
                </div>
            </div>
        </header>
        <!-- Page Content-->
        <section class="pt-4">
            <div class="container px-lg-5">
                <!-- Page Features-->
                <div class="row gx-lg-5">
                    <div class="col-lg-6 col-xxl-4 mb-5">
                        <div class="card bg-light border-0 h-100">
                            <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                <a class="btn btn-primary bg-gradient text-white rounded-3 mb-4 mx-3 mt-n4" href="/book/api/viewbooks">Click here</a>
                                <h2 class="fs-4 fw-bold">View Books</h2>
                                <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                            </div>
                        </div>
                    </div>
                    <c:if test = "${role.equals('USER')}">
                        <div class="col-lg-6 col-xxl-4 mb-5">
                            <div class="card bg-light border-0 h-100">
                                <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                    <a class="btn btn-primary bg-gradient text-white rounded-3 mb-4 mx-3 mt-n4" href="/book/api/issuelist">Click here</a>
                                    <h2 class="fs-4 fw-bold">Member Transactions</h2>
                                    <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test = "${role.equals('ADMIN')}">
                        <div class="col-lg-6 col-xxl-4 mb-5">
                            <div class="card bg-light border-0 h-100">
                                <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                    <a class="btn btn-primary bg-gradient text-white rounded-3 mb-4 mx-3 mt-n4" href="/book/api/newbook">Click here</a>
                                    <h2 class="fs-4 fw-bold">Add Book</h2>
                                    <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-xxl-4 mb-5">
                            <div class="card bg-light border-0 h-100">
                                <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                    <a class="btn btn-primary bg-gradient text-white rounded-3 mb-4 mx-3 mt-n4" href="/book/api/issuedbooks">Click here</a>
                                    <h2 class="fs-4 fw-bold">Issued Books</h2>
                                    <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-xxl-4 mb-5">
                            <div class="card bg-light border-0 h-100">
                                <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                    <a class="btn btn-primary bg-gradient text-white rounded-3 mb-4 mx-3 mt-n4" href="/book/api/collectbook">Click here</a>
                                    <h2 class="fs-4 fw-bold">Collect Book</h2>
                                    <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-xxl-4 mb-5">
                            <div class="card bg-light border-0 h-100">
                                <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                    <a class="btn btn-primary bg-gradient text-white rounded-3 mb-4 mx-3 mt-n4" href="/BooksWagon">Click here</a>
                                    <h2 class="fs-4 fw-bold">Remove Book</h2>
                                    <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-xxl-4 mb-5">
                            <div class="card bg-light border-0 h-100">
                                <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                    <a class="btn btn-primary bg-gradient text-white rounded-3 mb-4 mx-3 mt-n4" href="/BooksWagon">Click here</a>
                                    <h2 class="fs-4 fw-bold">Statistics</h2>
                                    <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>