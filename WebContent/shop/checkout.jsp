<%@page import="util.StringUtil"%>
<%@page import="product.domain.ProductForm"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<ProductForm> cartList=(List)session.getAttribute("cart");
%>
<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if lt IE 7 ]> <html lang="en" class="ie6">    <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7">    <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8">    <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie9">    <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>b-Sale | Checkout</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Favicon
		============================================ -->
		<link rel="shortcut icon" type="image/x-icon" href="img/favicon.jpg">
		
		<!-- Fonts
		============================================ -->
		<link href='https://fonts.googleapis.com/css?family=Raleway:400,700,600,500,300,800,900' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,500,300,300italic,500italic,700' rel='stylesheet' type='text/css'>

 		<!-- CSS  -->
		
		<!-- Bootstrap CSS
		============================================ -->      
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
		<!-- font-awesome.min CSS
		============================================ -->      
        <link rel="stylesheet" href="css/font-awesome.min.css">
		
		<!-- Mean Menu CSS
		============================================ -->      
        <link rel="stylesheet" href="css/meanmenu.min.css">
        
		<!-- owl.carousel CSS
		============================================ -->      
        <link rel="stylesheet" href="css/owl.carousel.css">
        
		<!-- owl.theme CSS
		============================================ -->      
        <link rel="stylesheet" href="css/owl.theme.css">
  	
		<!-- owl.transitions CSS
		============================================ -->      
        <link rel="stylesheet" href="css/owl.transitions.css">
		
		<!-- Price Filter CSS
		============================================ --> 
        <link rel="stylesheet" href="css/jquery-ui.min.css">	

		<!-- nivo-slider css
		============================================ --> 
		<link rel="stylesheet" href="css/nivo-slider.css">
        
 		<!-- animate CSS
		============================================ -->         
        <link rel="stylesheet" href="css/animate.css">
		
		<!-- jquery-ui-slider CSS
		============================================ --> 
		<link rel="stylesheet" href="css/jquery-ui-slider.css">
        
 		<!-- normalize CSS
		============================================ -->        
        <link rel="stylesheet" href="css/normalize.css">
   
        <!-- main CSS
		============================================ -->          
        <link rel="stylesheet" href="css/main.css">
        
        <!-- style CSS
		============================================ -->          
        <link rel="stylesheet" href="style.css">
        
        <!-- responsive CSS
		============================================ -->          
        <link rel="stylesheet" href="css/responsive.css">
        
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
        <script>
        function requestOrder(){
        	form1.method="post";
			form1.action="order.jsp";
			form1.submit();
        }
        </script>
    </head>
    <body class="">
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
               
        <!-- HEADER AREA -->
        <div class="header-area">
			<div class="header-top-bar">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-sm-4 col-xs-12">
							<div class="header-top-left">
								<div class="header-top-menu">
									<ul class="list-inline">
										<li><img src="img/flag.png" alt="flag"></li>
										<li class="dropdown"><a href="#" data-toggle="dropdown">English</a>
											<ul class="dropdown-menu">
												<li><a href="#">Spanish</a></li>
												<li><a href="#">China</a></li>
											</ul>
										</li>
										<li class="dropdown"><a href="#" data-toggle="dropdown">USD</a>
											<ul class="dropdown-menu usd-dropdown">
												<li><a href="#">USD</a></li>
												<li><a href="#">GBP</a></li>
												<li><a href="#">EUR</a></li>
											</ul>
										</li>
									</ul>
								</div>
								<p>Welcome visitor!</p>
							</div>
						</div>
						<div class="col-md-8 col-sm-8 col-xs-12">
							<div class="header-top-right">
								<ul class="list-inline">
									<li><a href="#"><i class="fa fa-user"></i>My Account</a></li>
									<li><a href="#"><i class="fa fa-heart"></i>Wishlist</a></li>
									<li><a href="checkout.html"><i class="fa fa-check-square-o"></i>Checkout</a></li>
									<li><a href="#"><i class="fa fa-lock"></i>Login</a></li>
									<li><a href="#"><i class="fa fa-pencil-square-o"></i>Register</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="header-bottom">
				<div class="container">
					<div class="row">
						<div class="col-md-2 col-sm-2 col-xs-12">
							<div class="header-logo">
								<a href="index.html"><img src="img/logo.png" alt="logo"></a>
							</div>
						</div>
						<div class="col-md-10 col-sm-10 col-xs-12">
							<div class="search-chart-list">
								<div class="catagori-menu">
									<ul class="list-inline">
										<li><i class="fa fa-search"></i></li>
										<li>
											<select>
												<option value="All Categories">All Categories</option>
												<option value="Categorie One">Categorie One</option>
												<option value="Categorie Two">Categorie Two</option>
												<option value="Categorie Three">Categorie Three</option>
												<option value="Categorie Four">Categorie Four</option>
												<option value="Categorie Five">Categorie Five</option>
											</select>
										</li>
									</ul>
								</div>
								<div class="header-search">
									<input type="text" placeholder="My Search"/>
									<button type="button"><i class="fa fa-search"></i></button>
								</div>
								<div class="header-chart">
									<ul class="list-inline">
										<li><a href="#"><i class="fa fa-cart-arrow-down"></i></a></li>
										<li class="chart-li"><a href="#">My cart</a>
											<ul>
                                                <li>
                                                    <div class="header-chart-dropdown">
                                                        <div class="header-chart-dropdown-list">
                                                            <div class="dropdown-chart-left floatleft">
                                                                <a href="#"><img src="img/product/best-product-1.png" alt="list"></a>
                                                            </div>
                                                            <div class="dropdown-chart-right">
                                                                <h2><a href="#">Feugiat justo lacinia</a></h2>
                                                                <h3>Qty: 1</h3>
                                                                <h4>£80.00</h4>
                                                            </div>
                                                        </div>
                                                        <div class="header-chart-dropdown-list">
                                                            <div class="dropdown-chart-left floatleft">
                                                                <a href="#"><img src="img/product/best-product-2.png" alt="list"></a>
                                                            </div>
                                                            <div class="dropdown-chart-right">
                                                                <h2><a href="#">Aenean eu tristique</a></h2>
                                                                <h3>Qty: 1</h3>
                                                                <h4>£70.00</h4>
                                                            </div>
                                                        </div>
														<div class="chart-checkout">
															<p>subtotal<span>£150.00</span></p>
															<button type="button" class="btn btn-default">Chckout</button>
														</div>
                                                    </div> 
                                                </li> 
                                            </ul> 
										</li>
										<li><a href="#">2 items</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
        </div>
        <!-- MAIN MENU AREA -->
		<div class="main-menu-area">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="main-menu hidden-xs">
							<nav>
								<ul>
									<li><a href="index.html">Home</a></li>
									<li><a href="shop.html">Shop</a></li>
									<li><a href="shop.html">Men</a></li>
									<li><a href="shop.html">Women</a></li>
									<li><a href="shop.html">Kids</a></li>
									<li><a href="shop.html">gift</a></li>
									<li><a href="blog-left-sidebar.html">Blog</a>
										<ul class="sub-menu">
											<li><a href="blog-right-sidebar.html">Blog Right Sidebar</a></li>
											<li><a href="blog-single.html">Blog Details</a></li>
										</ul>
									</li>
									<li><a href="#">Pages</a>
										<ul class="sub-menu">
											<li><a href="shop.html">Shop</a></li>
											<li><a href="shop.html">Men</a></li>
											<li><a href="shop.html">Women</a></li>
											<li><a href="shop.html">Kids</a></li>
											<li><a href="shop.html">Gift</a></li>
											<li><a href="about-us.html">About Us</a></li>
											<li><a href="single-product.html">Single Product</a></li>
											<li><a href="cart.html">Cart</a></li>
											<li><a href="checkout.html">Checkout</a></li>
											<li><a href="look-book.html">Look Book</a></li>
											<li><a href="404.html">Error 404</a></li>
										</ul>
									</li>
									<li><a href="contact.html">contact</a></li>
								</ul>
							</nav>
						</div>
						<!-- Mobile MENU AREA -->
						<div class="mobile-menu hidden-sm hidden-md hidden-lg">
							<nav>
								<ul>
									<li><a href="index.html">Home</a></li>
									<li><a href="shop.html">Shop</a>
										<ul>
											<li><a href="#">Shop Layouts</a>
												<ul>
													<li><a href="#">Full Width</a></li>
													<li><a href="#">Sidebar Left</a></li>
													<li><a href="#">Sidebar Right</a></li>
													<li><a href="#">List View</a></li>
												</ul>	
											</li>
											<li><a href="#">Shop Pages</a>
												<ul>
													<li><a href="#">Category</a></li>
													<li><a href="#">My Account</a></li>
													<li><a href="#">Wishlist</a></li>
													<li><a href="#">Shopping Cart</a></li>
												</ul>	
											</li>
											<li><a href="#">Product Types</a>
												<ul>
													<li><a href="#">Simple Product</a></li>
													<li><a href="#">Variable Product</a></li>
													<li><a href="#">Grouped Product</a></li>
													<li><a href="#">Downloadable</a></li>
												</ul>	
											</li>
										</ul>
									</li>
									<li><a href="shop.html">Men</a></li>
									<li><a href="shop.html">Women</a></li>
									<li><a href="shop.html">Kids</a></li>
									<li><a href="shop.html">gift</a></li>
									<li><a href="blog-left-sidebar.html">Blog</a>
										<ul>
											<li><a href="blog-right-sidebar.html">Blog Right Sidebar</a></li>
											<li><a href="blog-single.html">Blog Details</a></li>
										</ul>
									</li>
									<li><a href="#">Pages</a>
										<ul>
											<li><a href="shop.html">Shop</a></li>
											<li><a href="shop.html">Men</a></li>
											<li><a href="shop.html">Women</a></li>
											<li><a href="shop.html">Kids</a></li>
											<li><a href="shop.html">Gift</a></li>
											<li><a href="about-us.html">About Us</a></li>
											<li><a href="single-product.html">Single Product</a></li>
											<li><a href="cart.html">Cart</a></li>
											<li><a href="checkout.html">Checkout</a></li>
											<li><a href="look-book.html">Look Book</a></li>
											<li><a href="404.html">Error 404</a></li>
										</ul>
									</li>
									<li><a href="contact.html">contact</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
        <!-- Breadcurb AREA -->
		<div class="breadcurb-area">
			<div class="container">
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Page</a></li>
					<li>Checkout</li>
				</ul>
			</div>
		</div>
		<!-- Checkout AREA -->
		<form name="form1">
		<div class="checkout-area">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-sm-7">
						<div class="billing-address">
							<div class="checkout-head">
								<h2>BILLING ADDRESS</h2>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenea ligula eget dolor. Aenean massa.</p>
							</div>
							<div class="checkout-form">
								
									<div class="form-group">
										<label class="control-label col-md-3">
											주문자명 <sup>*</sup>
										</label>
										<div class="col-md-9">
											<input type="text" name="name" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">
											연락처 <sup>*</sup>
										</label>
										<div class="col-md-9">
											<input type="text" name="phone" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">
											이메일 <sup>*</sup>
										</label>
										<div class="col-md-9">
											<input type="text" name="email" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-3">
											Address <sup>*</sup>
										</label>
										<div class="col-md-9">
											<input type="text" name="address" class="form-control">
										</div>
									</div>
								
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-5">
						<div class="review-order">
							<div class="checkout-head">
								<h2>Review your Order</h2>
							</div>
							<%
								int total_buy = 0; //총 구매금액 
								int total_pay = 0; //실제 결제금액
							%>
							<%for(ProductForm product : cartList){ %>
							<div class="single-review">
								<div class="single-review-img">
									<a href="#"><img src="/data/<%=product.getFilename() %>" alt="review" style="width:100px"></a>
								</div>
								<div class="single-review-content fix">
									<h2><a href="#"><%=product.getProduct_name() %></a></h2>
									<p><span>Color :</span> <%=product.getColor() %></p>
									<p><span>Size :</span> <%=product.getPsize() %></p>
									<h3><%=StringUtil.getCurrency(product.getPrice()) %></h3>
								</div>
							</div>
							<%
								total_buy += (product.getPrice() * product.getEa());
							%>
							<%} %>
							
							<div class="subtotal-area">
								<div class="subtotal-content fix">
									<input type="hidden" name="total_buy" value="<%=total_buy%>">
									<h2 class="floatleft">구매 총액</h2>
									<h2 class="floatright"><%=StringUtil.getCurrency(total_buy) %></h2>
								</div>
								<div class="subtotal-content fix">
									<h2 class="floatleft">이벤트 할인 적용 </h2>
									<h2 class="floatright">10,000 원</h2>
								</div>
								<div class="subtotal-content fix">
									<input type="hidden" name="total_pay" value="<%=total_buy-10000%>">
									<h2 class="floatleft">결제하실 금액</h2>
									<h2 class="floatright"><%=StringUtil.getCurrency(total_buy-10000) %></h2>
								</div>
							</div>
							<div class="payment-method">
								<h2>PAYMENT METHOD</h2>
								<div class="payment-checkbox">
									<input type="checkbox" name="paymethod" value="card" checked> 카드결제
								</div>
								<div class="payment-checkbox">
									<input type="checkbox" name="paymethod" value="account"> 무통장 입금<br>
									<input type="checkbox" name="paymethod" value="virtual"> 가상계좌
								</div>
								<button type="button" class="btn" onClick="requestOrder()">Place Order</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
		<!-- Footer AREA -->
		<div class="footer-area">
			<div class="footer-top">
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-sm-12">
							<div class="footer-info-card">
								<div class="footer-logo">
									<a href="index.html"><img src="img/footer-logo.png" alt="logo"></a>
								</div>
								<p>Lorem ipsum dolor sit amet, coetuer adipiscing elit. Aenean comodo liula eget dolor. Aenean massa. Cum sociis natoque penatibus.</p>
								<ul class="list-inline">
									<li><a href="#"><img src="img/visa-card/visa-card-1.png" alt="card" class="img-responsive"></a></li>
									<li><a href="#"><img src="img/visa-card/visa-card-2.png" alt="card" class="img-responsive"></a></li>
									<li><a href="#"><img src="img/visa-card/visa-card-3.png" alt="card" class="img-responsive"></a></li>
									<li><a href="#"><img src="img/visa-card/visa-card-4.png" alt="card" class="img-responsive"></a></li>
								</ul>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="footer-menu-area">
								<h2 class="footer-heading">MY ACCOUNT</h2>
								<div class="footer-menu">
									<ul>
										<li><a href="#"><i class="fa fa-angle-right"></i>My Account</a></li>
										<li><a href="#"><i class="fa fa-angle-right"></i>About Us</a></li>
										<li><a href="#"><i class="fa fa-angle-right"></i>Contact</a></li>
										<li><a href="#"><i class="fa fa-angle-right"></i>Affiliates</a></li>
										<li><a href="#"><i class="fa fa-angle-right"></i>Meet The Maker</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6 hidden-sm hidden-xs">
							<div class="footer-menu-area">
								<h2 class="footer-heading">Opening time</h2>
								<div class="footer-menu opening-time">
									<ul>
										<li><i class="fa fa-angle-right"></i>Satarday<span>7.00 AM - 7.00 PM</span></li>
										<li><i class="fa fa-angle-right"></i>Sunday<span>7.00 AM - 7.00 PM</span></li>
										<li><i class="fa fa-angle-right"></i>Monday<span>7.00 AM - 7.00 PM</span></li>
										<li><i class="fa fa-angle-right"></i>Tuesday<span>7.00 AM - 7.00 PM</span></li>
										<li><i class="fa fa-angle-right"></i>Thusday<span>7.00 AM - 7.00 PM</span></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="contact-info-area">
								<h2 class="footer-heading">Contact Us</h2>
								<div class="contact-info">
									<div class="contanct-details">
										<div class="info-icon">
											<i class="fa fa-phone"></i>
										</div>
										<div class="info-content">
											<p>+1 (00) 86 868 868 666</p>
											<p>+1 (00) 42 868 666 888</p>
										</div>
									</div>
									<div class="contanct-details">
										<div class="info-icon">
											<i class="fa fa-envelope-o"></i>
										</div>
										<div class="info-content">
											<p>admin@bootexperts.com</p>
											<p>info@bootexperts.com</p>
										</div>
									</div>
									<div class="contanct-details">
										<div class="info-icon">
											<i class="fa fa-map-marker"></i>
										</div>
										<div class="info-content">
											<p>68 Dohava Stress, Lorem isput Spust, New York- US</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>	
			</div>
			<div class="footer-bottom">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div class="copyright">
								Copyrignt@2018 <a href="https://freethemescloud.com/" target="_blank">Free themes Cloud </a>/ ALL RIGHTS RESERVED
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<div class="footer-social-icon">
								<ul class="list-inline">
									<li><a href="#"><i class="fa fa-facebook"></i></a></li>
									<li><a href="#"><i class="fa fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
									<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
									<li><a href="#"><i class="fa fa-pinterest-p"></i></a></li>
									<li><a href="#"><i class="fa fa-vimeo"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
        <!-- JS -->
        
 		<!-- jquery-1.11.3.min js
		============================================ -->         
        <script src="js/vendor/jquery-1.11.3.min.js"></script>
        
 		<!-- bootstrap js
		============================================ -->         
        <script src="js/bootstrap.min.js"></script>
		
		<!-- nivo slider js
		============================================ --> 
		<script src="js/jquery.nivo.slider.pack.js"></script>
        
 		<!-- Mean Menu js
		============================================ -->         
        <script src="js/jquery.meanmenu.min.js"></script>
        
   		<!-- owl.carousel.min js
		============================================ -->       
        <script src="js/owl.carousel.min.js"></script>
		
		<!-- jquery price slider js
		============================================ --> 		
		<script src="js/jquery-price-slider.js"></script>
		
		<!-- wow.js
		============================================ -->
        <script src="js/wow.js"></script>		
		<script>
			new WOW().init();
		</script>
        
   		<!-- plugins js
		============================================ -->         
        <script src="js/plugins.js"></script>
		
   		<!-- main js
		============================================ -->           
        <script src="js/main.js"></script>
    </body>
</html>
