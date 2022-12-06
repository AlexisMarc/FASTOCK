import '../css/animate.min.css'
import '../css/boostrap.min.css'
import '../css/flexslider.css'
import '../css/font-icon.css'
import '../css/jquery.fancybox.css'
import '../css/login.css'
import '../css/main.css'
import '../css/responsive.css'
import '../css/style.css'

function Conocenos() {

    return (
        <section style="margin-top:20px; " id="contact" className="section">
            <div className="containerx">
                <div className="section-header">
                    <h2 className="wow fadeInDown animated">Contáctanos</h2>
                    <p className="wow fadeInDown animated">dejanos tus datos y consulta<br/></p>
                </div>
                <div className="row">
                    <div style="background-color: #232323;" className="col-sm-offset-2 col-sm-3 col-xs-12 ">
                        <div>
                            <div style="padding: 30px;" >
                                <h4>Contáctanos</h4>
                                <p>Comunicate con nosotros:</p>
                                <div>
                                    <h4 style="margin-top:0;color:#fff;"></h4>
                                    <address style="color:#fff;">
                                        <p>C.C. El gran San Victorino</p>
                                        <p>Carrera. 10 No.9-37</p>
                                        <p>local 2054 - 2° Piso</p>
                                        <p>Bodega: 3143715225</p>
                                    </address>
                                    © 2022 Company Name. Yeilux Jeans S.A.S
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-5 col-md-offset- conForm">
                        <div id="message"></div>
                        <form method="post" action="php/contact.php" name="cform" id="cform">
                            <input name="name" id="name" type="text" className="col-xs-12 col-sm-12 col-md-12 col-lg-12"
                                placeholder="Nombre"/>
                                <input name="email" id="email" type="email" className=" col-xs-12 col-sm-12 col-md-12 col-lg-12 noMarr"
                                    placeholder="Email....."/>
                                    <textarea name="comments" id="comments" cols="" rows="" className="col-xs-12 col-sm-12 col-md-12 col-lg-12"
                                        placeholder="Descripción...."></textarea>
                                    <input type="submit" id="submit" name="send" className="submitBnt" value="Enviar"/>
                                        <div id="simple-msg"></div>
                                    </form>
                                </div>
                            </div>
                            </div>
                </section>
                );
}
                export default Conocenos;
