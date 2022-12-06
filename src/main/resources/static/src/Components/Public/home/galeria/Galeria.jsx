import '../css/animate.min.css'
import '../css/boostrap.min.css'
import '../css/flexslider.css'
import '../css/font-icon.css'
import '../css/jquery.fancybox.css'
import '../css/login.css'
import '../css/main.css'
import '../css/responsive.css'
import '../css/style.css'

function Galeria() {

  return (
    <section id="gallery" className="gallery section">
            <div className="container-fluid">
                <div className="section-header">
                    <h2 className="wow fadeInDown animated">Galería</h2>
                    <p className="wow fadeInDown animated">Conose nuestro catalogo de rapa, con una nueva colección</p>
                </div>
                <div className="row no-gutter">
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/01.jpg" className="work-box"> <img
                        src="images/portfolio/01.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/02.jpg" className="work-box"> <img
                        src="images/portfolio/02.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/03.jpg" className="work-box"> <img
                        src="images/portfolio/03.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/04.jpg" className="work-box"> <img
                        src="images/portfolio/04.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/05.jpg" className="work-box"> <img
                        src="images/portfolio/05.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/06.jpg" className="work-box"> <img
                        src="images/portfolio/06.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/07.jpeg" className="work-box"> <img
                        src="images/portfolio/07.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                    <div className="col-lg-3 col-md-6 col-sm-6 work"> <a href="images/portfolio/08.jpeg" className="work-box"> <img
                        src="images/portfolio/08.jpg" alt=""/>
                        <div className="overlay">
                            <div className="overlay-caption">
                                <p><span className="icon icon-magnifying-glass"></span></p>
                            </div>
                        </div>
                    </a> </div>
                </div>
            </div>
        </section>
  );
}

export default Galeria;
