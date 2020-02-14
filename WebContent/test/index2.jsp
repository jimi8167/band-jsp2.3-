<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login V6</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/bootstrap/css/bootstrap.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="fonts/iconic/css/material-design-iconic-font.min.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css" />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/css-hamburgers/hamburgers.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/animsition/css/animsition.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/select2/select2.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="vendor/daterangepicker/daterangepicker.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css" />
    <link rel="stylesheet" type="text/css" href="css/main.css" />
<meta charset="UTF-8">
<link
	rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
@import
	url('https://fonts.googleapis.com/css?family=Fjalla+One|Francois+One|Play')
	;

html, body, section {
	height: 100%;
}

body {
	color: #fff;
	text-align: center;
}

div {
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.xop-container {
	display: flex;
}

div {
	flex-direction: column;
	justify-content: center;
}

.xop-left {
	background: linear-gradient(rgba(0, 0, 0, 0.85),
		rgba(255, 255, 225, 0.10));
	background-image: url("/img/Screenshot_3.png");
	background-size: cover;
	background-position: center;
	flex: 1;
	/* padding: 1rem; */
	transition: all .2s ease-in-out;
	text-transform: uppercase;
	/* filter: grayscale(80%); */
}

.xop-right {
	background: linear-gradient(rgba(0, 0, 0, 0.85),
		rgba(164, 222, 102, 0.10));
	background-image: url("/img/Screenshot_4.png");
	background-size: cover;
	background-position: center;
	flex: 1;
	padding: 1rem;
	transition: all .2s ease-in-out;
	text-transform: uppercase;
	/* filter: hue-rotate(90deg); */
}

.xop-left:hover, .xop-right:hover {
	transform: scale(0.90);
	/* filter: hue-rotate(-90deg); */
}

.xop-container h1 {
	letter-spacing: 2px;
	font-family: 'Francois One', sans-serif;
	font-size: 3rem;
}

.xop-button {
	border-radius: 2px;
	color: #fff;
	background-color: #333;
	padding: 10px 10px;
	margin: 0 1%;
	text-align: center;
	font-family: 'Play', sans-serif;
	text-decoration: none;
	letter-spacing: 1px;
	display: inline-block;
	font-size: 1rem;
	cursor: pointer;
	transition: all 0.5s;
	width: 150px;
}

.xop-button:hover {
	background: #fff;
	color: #333;
	text-decoration: none;
}

@media only screen and (max-width: 600px) {
	.xop-container {
		flex-direction: column;
	}
}
 .limiter {
        background-image: url("images/avatar-01.jpg");
      }
      .container-login100 {
        height: 300px;
        width: 200px;
        display: flex;
      }
      .hc {
        width: 350px;
        left: 0;
        right: 0;
        margin-left: auto;
        margin-right: auto;
      }
      .vc {
        height: 100px;
        top: 0;
        bottom: 0;
        margin-top: auto;
        margin-bottom: auto;
      }
</style>
</head>
<body>


	<section class="xop-container">

		<div class="limiter">
			<div class="container-login100 hc vc">
				<div class="wrap-login100 p-t-85 p-b-20">
					<form class="login100-form validate-form">
						<span class="login100-form-title p-b-70"> Welcome </span> <span class="login100-form-avatar"> <img
							src="images/avatar-01.jpg"
							alt="AVATAR" />
						</span>

						<div
							class="wrap-input100 validate-input m-t-85 m-b-35"
							data-validate="Enter username">
							<input
								class="input100"
								type="text"
								name="username" /> <span
								class="focus-input100"
								data-placeholder="Username"></span>
						</div>

						<div
							class="wrap-input100 validate-input m-b-50"
							data-validate="Enter password">
							<input
								class="input100"
								type="password"
								name="pass" /> <span
								class="focus-input100"
								data-placeholder="Password"></span>
						</div>

						<div class="container-login100-form-btn">
							<button class="login100-form-btn">Login</button>
						</div>

						<ul class="login-more p-t-190">
							<li class="m-b-8"><span class="txt1"> Forgot </span> <a
								href="#"
								class="txt2"> Username / Password? </a></li>

							<li><span class="txt1"> Don’t have an account? </span> <a
								href="#"
								class="txt2"> Sign up </a></li>
						</ul>
					</form>
				</div>
			</div>
		</div>

		<div id="dropDownSelect1"></div>

		<div class="xop-left">

			<article>

				<h1>밴드 만들기</h1>
				<a
					href="#"
					class="btn btn-info btn-lg"> <span class="glyphicon glyphicon-plus-sign"></span> 추가
				</a>
				<!-- <a class="xop-button">GO</a> -->
			</article>
		</div>
		<div class="xop-right">
			<article>
				<h1>밴드 찾기</h1>
				<a class="xop-button"> <span class="glyphicon">&#xe003; </span> Go
				</a>
			</article>
		</div>
	</section>
</body>

</html>