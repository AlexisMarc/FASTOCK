import { Link } from 'react-router-dom'
import React from 'react'

function Menu() {
    return (
        <nav className="sidebar sidebar-offcanvas" id="sidebar">
            <ul className="nav">
                <li className="nav-item">
                    <Link className="nav-link" to="/inicio">
                        <i className="ti-home menu-icon"></i>
                        <span className="menu-title">Inicio</span>
                    </Link>
                </li>
                <li className="nav-item">
                    <a className="nav-link" data-toggle="collapse" href="#fabricacion" aria-expanded="false"
                        aria-controls="ui-basic">
                        <i className="ti-settings menu-icon"></i>
                        <span className="menu-title">Producción</span>
                        <i className="menu-arrow"></i>
                    </a>
                    <div className="collapse" id="fabricacion">
                        <ul className="nav flex-column sub-menu">
                        <li className="nav-item"><Link to="/producto" className="nav-link">Producto</Link></li>
                        <li className="nav-item"><Link to="/insumo" className="nav-link">Insumo</Link></li>
                        <li className="nav-item"><Link to="/fabricacion" className="nav-link">Fabricación</Link></li>
                        </ul>
                    </div>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/usuario">
                        <i className="ti-user menu-icon"></i>
                        <span className="menu-title">Usuario</span>
                    </Link>
                </li>
                <li className="nav-item">
                    <a className="nav-link" data-toggle="collapse" href="#entidad" aria-expanded="false"
                        aria-controls="ui-basic">
                        <i className="ti-shopping-cart-full menu-icon"></i>
                        <span className="menu-title">Entidad</span>
                        <i className="menu-arrow"></i>
                    </a>
                    <div className="collapse" id="entidad">
                        <ul className="nav flex-column sub-menu">
                        <li className="nav-item"><Link to="/empresa" className="nav-link">Empresa</Link></li>
                        <li className="nav-item"><Link to="/proveedor" className="nav-link">Proveedor</Link></li>
                            
                        </ul>
                    </div>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/inventario">
                        <i className="ti-package menu-icon"></i>
                        <span className="menu-title">Inventario</span>
                    </Link>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="/">
                        <i className="ti-bookmark-alt menu-icon"></i>
                        <span className="menu-title">Novedades</span>
                    </a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="/">
                        <i className="icon-grid menu-icon"></i>
                        <span className="menu-title">Otros</span>
                    </a>
                </li>

            </ul>
        </nav>
    )
}
export default Menu;