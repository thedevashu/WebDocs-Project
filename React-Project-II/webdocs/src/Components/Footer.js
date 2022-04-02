/* eslint-disable import/no-anonymous-default-export */
import footerimage from '../UI/assets/img/footer-logo.jpeg';
export default function(){
    return(
        <footer className="footer">
				
			
				<div className="footer-top">
					<div className="container-fluid">
						<div className="row">
							<div className="col-lg-3 col-md-6">
							
							
								<div className="footer-widget footer-about">
									<div className="footer-logo">
										<img src={footerimage} alt="logo"/>
									</div>
									<div className="footer-about-content">
										<p>We created WebDocs to solve patient problems, beginning with online appointment-booking. With WebDocs you can see doctors’ open appointment times and book instantly online.</p>
										
									</div>
								</div>
								
								
							</div>
							
							<div className="col-lg-3 col-md-6">
							
								
								<div className="footer-widget footer-menu">
									<h2 className="footer-title">For Patients</h2>
									<ul>
										<li><a href="search.html"><i className="fas fa-angle-double-right"></i> Search for Doctors</a></li>
										<li><a href="login.html"><i className="fas fa-angle-double-right"></i> Login</a></li>
										<li><a href="register.html"><i className="fas fa-angle-double-right"></i> Register</a></li>
										<li><a href="booking.html"><i className="fas fa-angle-double-right"></i> Booking</a></li>
									</ul>
								</div>
								
								
							</div>
							
							<div className="col-lg-3 col-md-6">
							
								
								<div className="footer-widget footer-menu">
									<h2 className="footer-title">For Doctors</h2>
									<ul>
										<li><a href="appointments.html"><i className="fas fa-angle-double-right"></i> Appointments</a></li>
										<li><a href="login.html"><i className="fas fa-angle-double-right"></i> Login</a></li>
										<li><a href="doctor-register.html"><i className="fas fa-angle-double-right"></i> Register</a></li>
										<li><a href="doctor-dashboard.html"><i className="fas fa-angle-double-right"></i> Doctor Dashboard</a></li>
									</ul>
								</div>
								
								
							</div>
							
							<div className="col-lg-3 col-md-6">
							

								<div className="footer-widget footer-contact">
									<h2 className="footer-title">Contact Us</h2>
									<div className="footer-contact-info">
										<div className="footer-address">
											<span><i className="fas fa-map-marker-alt"></i></span>
											<p> 302  Florida Heights, G.B. Colony,<br/> Pune, 410401 </p>
										</div>
										<p>
											<i className="fas fa-phone-alt"></i>
											+91 1234567890
										</p>
										<p className="mb-0">
											<i className="fas fa-envelope"></i>
											help.webdocs@webdocs.in
										</p>
									</div>
								</div>

								
							</div>
							
						</div>
					</div>
				</div>
			
                <div className="footer-bottom">
					<div className="container-fluid">
					

						<div className="copyright">
							<div className="row">
								<div className="col-md-6 col-lg-6">
									<div className="copyright-text">
										<p className="mb-0"><a href="templateshub.net">WebDocs</a></p>
									</div>
								</div>
								<div className="col-md-6 col-lg-6">
								

									<div className="copyright-menu">
										<ul className="policy-menu">
											<li><a href="term-condition.html">Terms and Conditions</a></li>
										</ul>
									</div>

									
								</div>
							</div>
						</div>

						
					</div>
				</div>

				
			</footer>
    )
}