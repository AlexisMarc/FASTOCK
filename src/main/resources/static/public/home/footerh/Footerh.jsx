import '../css/animate.min.css'
import '../css/flexslider.css'
import '../css/font-icon.css'
import '../css/jquery.fancybox.css'
import '../css/login.css'
import '../css/main.css'
import '../css/responsive.css'

function Footerh() {

  return (
    <footer className="footer">
    <div className="container-fluid">
      <div id="map-row" className="row">
        <div className="col-xs-12">

          <div id="map-overlay" className="col-xs-6 col-xs-offset-6">
            
            <div style="display: flex;" className="icons-footer">
              <h4 style="display: flex; flex-direction:column; padding: 20px; "> <samp className="icon icon-facebook" style="font-size: 80px;"></samp> Facebook</h4>
              <h4 style="display: flex; flex-direction:column; padding: 20px; "> <samp className="icon icon-facebook" style="font-size: 80px;"></samp> Instagram</h4>
              <h4 style="display: flex; flex-direction:column; padding: 20px; "> <samp className="icon icon-facebook" style="font-size: 80px;"></samp> WhatsApp</h4>
            </div>
            <div style="display: flex; flex-direction:column; margin-left: 10%;"className="log-footer">
              <img id="footeimg" src="images/logo.png" alt=""/> <br/>
              © 2022 Company Name. Yeilux Jeans S.A.S
            </div>

          </div>
        </div>
      </div>
    </div>
  </footer>
  );
}

export default Footerh;
