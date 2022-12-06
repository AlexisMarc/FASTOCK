import { Link } from 'react-router-dom'
import React from 'react'
import './error.css';

function Error() {
    return (
        <div className='page404'>
            <section className="page_404">
                <div className="container">
                    <div className="row">
                        <div className="col-sm-12 ">
                            <div className="col-sm-10 col-sm-offset-1  text-center">
                                <div className="four_zero_four_bg">
                                    <h1 className="titulo">404</h1>


                                </div>

                                <div className="contant_box_404">
                                    <h1 className="h2">
                                        Upss, Salio algo mal
                                    </h1>

                                    <p>Sucedio un problema</p>

                                    <Link  to="/dashboard" className="link_404">Regresar al Home</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    )
}
export default Error;