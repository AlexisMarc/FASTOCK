import Footer from "../layouts/footer/Footer";
import Menu from "../layouts/menu/Menu";
import Panel from "../layouts/panel/Panel";
import Nav from '../layouts/nav/Nav';
import Color from "../layouts/color/Color";
import Inventario from "../Components/inventario/Inventario";

function PageInventario() {
    return (
        <div className="container-scroller">
            <Nav />
            <div className="container-fluid page-body-wrapper">
                <Color />
                <Panel />
                <Menu />
                <div className="main-panel">
                    <div className="content-wrapper">
                        <div className="row">
                            <div className="col-12 col-xl-8 mb-4 mb-xl-0">
                                <h3 className="font-weight-bold">Welcome Aamir</h3>
                            </div>
                        </div>

                        <div className="row">
                            <div className="col-md-12 grid-margin stretch-card">
                                <div className="card position-relative">
                                    <div className="card-body">
                                        <div id="detailedReports"
                                            className="carousel slide detailed-report-carousel position-static pt-2"
                                            data-ride="carousel">
                                                <Inventario />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <Footer />
                </div>
            </div>
        </div>
    );
}

export default PageInventario;
