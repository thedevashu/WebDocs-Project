import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import log from '../UI/assets/img/log.jpeg';
import logo from '../UI/assets/img/logo.png';
export default function Navbar() {


	return (
		<header className="header">
			<nav className="navbar navbar-expand-lg header-nav">
				<div className="navbar-header">
					<a id="mobile_btn" href="javascript:void(0);">
						<span className="bar-icon">
							<span></span>
							<span></span>
							<span></span>
						</span>
					</a>
					<a href="/" className="navbar-brand logo">
						<img src={log} className="img-fluid" alt="Logo" />
					</a>
				</div>
				<div className="main-menu-wrapper">
					<div className="menu-header">
						<a href="/" className="menu-logo">
							<img src={logo} className="img-fluid" alt="Logo" />
						</a>
						<a id="menu_close" className="menu-close" href="javascript:void(0);">
							<i className="fas fa-times"></i>
						</a>
					</div>
					<ul className="main-nav">
						<li className="active">
							<a href="/">Home</a>
						</li>
						<li className="has-submenu">
							<a href="#">Doctors <i className="fas fa-chevron-down"></i></a>
							<ul className="submenu">
								<li><a href="appointments.html">Appointments</a></li>
								<li><a href="schedule-timings.html">Schedule Timing</a></li>
								<li><a href="doctor-profile-settings.html">Profile Settings</a></li>
								<li><a href="reviews.html">Reviews</a></li>
								<li><a href="/doctor">Doctor's Registration</a></li>
							</ul>
						</li>
						<li className="has-submenu">
							<a href="#">Patients <i className="fas fa-chevron-down"></i></a>
							<ul className="submenu">
								<li><a href="search.html">Search Doctor</a></li>
								<li><a href="/patient">Patient's Registration</a></li>
							</ul>
						</li>

						<li>
							<a href="admin/index.html" target="_blank">Admin</a>
						</li>
						<li className="login-link">
							<Link to="login">Login / Signup</Link>

						</li>
					</ul>
				</div>
				<ul className="nav header-navbar-rht">
					<li className="nav-item contact-item">
						<div className="header-contact-img">
							<i className="far fa-hospital"></i>
						</div>
						<div className="header-contact-detail">
							<p className="contact-header">Contact</p>
							<p className="contact-info-header"> +91 1234567890</p>
						</div>
					</li>

					<li className="nav-item">
						<a className="nav-link header-login" href="/patientlogin">login / Signup </a>
					</li>
				</ul>
			</nav>
		</header>
	)
}