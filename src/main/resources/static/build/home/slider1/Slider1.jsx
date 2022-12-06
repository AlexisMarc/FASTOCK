

function Slider() {

    return (
        <section className="banner" role="banner" id="home">
            <header id="header">
                <div className="header-content clearfix"> <a className="logo" href="index.html"><img src="images/logo.png" alt=""
                    width="250px"/></a>
                    <nav className="navigation" role="navigation">
                        <ul className="primary-nav">
                            <li><a href="#home">Inicio</a></li>
                            <li><a href="#Bride_Groom">Tipo de prendas</a></li>
                            <li><a href="#gallery">Galeria</a></li>
                            <li><a href="#services">Metodos de pago</a></li>
                            <li><a href="#testimonials">Contactanos</a></li>
                            <li><a href="login.html">Iniciar Sesión</a></li>
                        </ul>
                    </nav>
                    <a href="#" className="nav-toggle">Menú<span></span></a>
                </div>
            </header>
            <div id="first-slider">
                <div id="carousel-example-generic" className="carousel slide carousel-fade">
                    <ol className="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" className="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    </ol>
                    <div className="carousel-inner" role="listbox">
                        <div className="item active slide1">
                            <div className="row">
                                <div className="container">
                                    <div className="col-md-9 text-left">
                                        <h3 data-animation="animated bounceInDown">Yeilux Jeans S.A.S</h3>
                                        <h4 data-animation="animated bounceInUp"> MADISENASAN </h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="item slide2">
                            <div className="row">
                                <div className="container">
                                    <div className="col-md-7 text-left">
                                        <h3 data-animation="animated bounceInDown"> Nuestra nueva colección </h3>
                                        <h4 data-animation="animated bounceInUp"> De las mejores en Bogotá </h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="item slide3">
                            <div className="row">
                                <div className="container">
                                    <div className="col-md-7 text-left">
                                        <h3 data-animation="animated bounceInDown">Hecho con amor por manos Colombianas</h3>
                                        <h4 data-animation="animated bounceInUp">🌎</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a className="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <i className="fa fa-angle-left"></i><span className="sr-only">Previo</span>
                    </a>
                    <a className="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <i className="fa fa-angle-right"></i><span className="sr-only">Siguiente</span>
                    </a>
                </div>
            </div>

        </section>
    );
}

export default Slider;
