export default function Banner(){
    return(
        <div>
			<section className="section section-search">
				<div className="container-fluid">
					<div className="banner-wrapper">
						<div className="banner-header text-center">
							<h1><b>Search Doctor, Make an Appointment</b></h1>
							<p>Discover the best doctors, clinic & hospital in the city nearest to you.</p>
						</div>
                         

						<div className="search-box">
							<form action="templateshub.net">
								<div className="form-group search-location">
									<input type="text" className="form-control" placeholder="Search Location"/>
									<span className="form-text">Based on your Location</span>
								</div>
								<div className="form-group search-info">
									<input type="text" className="form-control" placeholder="Search Doctors, Clinics, Hospitals, Etc"/>
									<span className="form-text">Ex : Family Physician, Cardiologist, Dermatologist etc</span>
								</div>
								<button type="submit" className="btn btn-primary btn-lg search-btn"><i class="fa fa-search" aria-hidden="true"></i> <span>Search</span></button>
							</form>
						</div>

						
					</div>
				</div>
			</section>
	  

			<section className="section section-specialities">
				<div className="container-fluid">
					<div className="section-header text-center">
						<h2>Clinic and Specialities</h2>
						<p className="sub-title">We provides Comprehensive medical directory with detailed, verified information about doctors and their specialities across the country.</p>
					</div>
					<div className="row justify-content-center">
						<div className="col-md-9">

							
							
							
						</div>
					</div>
				</div>   
			</section>	 
            </div>
    )
}